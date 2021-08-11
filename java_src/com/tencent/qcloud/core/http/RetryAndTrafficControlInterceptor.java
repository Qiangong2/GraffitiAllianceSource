package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.TaskManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* access modifiers changed from: package-private */
public class RetryAndTrafficControlInterceptor implements Interceptor {
    private static final int BACKOFF_MULTIPLIER = 2;
    private static final int MAX_NORMAL_RETRY_WAIT_TIME = 2000;
    private static final int MAX_STREAMING_RETRY_WAIT_TIME = 10000;
    private static final int MIN_NORMAL_ATTEMPTS = 3;
    private static final int MIN_STREAMING_ATTEMPTS = 4;
    private static final int MIN_STREAMING_TASK_FAIL_MILLIS_TOOK = 60000;
    private static final int RETRY_DELAY_BASE = 1000;
    private TrafficStrategy downloadTrafficStrategy = new AggressiveTrafficStrategy("DownloadStrategy-", 3);
    private TrafficStrategy uploadTrafficStrategy = new ModerateTrafficStrategy("UploadStrategy-", 2);

    /* access modifiers changed from: private */
    public static class ResizableSemaphore extends Semaphore {
        ResizableSemaphore(int permit, boolean fair) {
            super(permit, fair);
        }

        /* access modifiers changed from: protected */
        public void reducePermits(int reduction) {
            super.reducePermits(reduction);
        }
    }

    /* access modifiers changed from: private */
    public static abstract class TrafficStrategy {
        static final int MIN_FAST_SPEED = 300;
        static final int MIN_TIMEOUT_COUNT = 2;
        private AtomicInteger concurrent;
        private ResizableSemaphore controller;
        private int current = 0;
        private AtomicInteger historyConsecutiveTimeoutError = new AtomicInteger(0);
        private final int[] historySpeed = new int[5];
        private final int maxConcurrent;
        private final String name;

        TrafficStrategy(String name2, int concurrent2, int maxConcurrent2) {
            this.name = name2;
            this.maxConcurrent = maxConcurrent2;
            this.controller = new ResizableSemaphore(concurrent2, true);
            this.concurrent = new AtomicInteger(concurrent2);
            QCloudLogger.m4893d("QCloudHttp", name2 + " init concurrent is " + concurrent2, new Object[0]);
        }

        /* access modifiers changed from: package-private */
        public void reportException(Request request, IOException exception) {
            this.controller.release();
        }

        /* access modifiers changed from: package-private */
        public void reportTimeOut(Request request) {
            if (this.historyConsecutiveTimeoutError.get() < 0) {
                this.historyConsecutiveTimeoutError.set(1);
            } else {
                this.historyConsecutiveTimeoutError.incrementAndGet();
            }
            if (this.historyConsecutiveTimeoutError.get() >= 2) {
                adjustConcurrentAndRelease(1);
            } else {
                this.controller.release();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void reportSpeed(Request request, double averageSpeed) {
            this.historyConsecutiveTimeoutError.decrementAndGet();
            if (averageSpeed > 0.0d) {
                QCloudLogger.m4893d("QCloudHttp", this.name + " %s streaming speed is %1.3f KBps", request, Double.valueOf(averageSpeed));
                int average = updateAverageSpeed(averageSpeed);
                int concurrent2 = this.concurrent.get();
                if (average > (concurrent2 + 1) * 300 && concurrent2 < this.maxConcurrent) {
                    adjustConcurrentAndRelease(concurrent2 + 1);
                } else if (average <= 0 || average >= (concurrent2 - 1) * 300 || concurrent2 <= 1) {
                    this.controller.release();
                } else {
                    adjustConcurrentAndRelease(concurrent2 - 1);
                }
            } else {
                this.controller.release();
            }
        }

        /* access modifiers changed from: package-private */
        public void waitForPermit() {
            try {
                this.controller.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private int updateAverageSpeed(double averageSpeed) {
            int i = 0;
            synchronized (this.historySpeed) {
                this.historySpeed[this.current] = (int) Math.floor(averageSpeed);
                this.current = (this.current + 1) % this.historySpeed.length;
                int sum = 0;
                boolean notEnoughData = false;
                int[] iArr = this.historySpeed;
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    int speed = iArr[i2];
                    if (speed == 0) {
                        notEnoughData = true;
                        break;
                    }
                    sum += speed;
                    i2++;
                }
                if (!notEnoughData) {
                    i = sum / this.historySpeed.length;
                }
            }
            return i;
        }

        private void clearAverageSpeed() {
            synchronized (this.historySpeed) {
                for (int i = 0; i < this.historySpeed.length; i++) {
                    this.historySpeed[i] = 0;
                }
            }
        }

        private synchronized void adjustConcurrentAndRelease(int expect) {
            int delta = expect - this.concurrent.get();
            if (delta == 0) {
                this.controller.release();
            } else {
                this.concurrent.set(expect);
                if (delta > 0) {
                    this.controller.release(delta + 1);
                    clearAverageSpeed();
                } else {
                    this.controller.reducePermits(delta * -1);
                    this.controller.release();
                    clearAverageSpeed();
                }
                QCloudLogger.m4897i("QCloudHttp", this.name + " adjust concurrent to " + expect, new Object[0]);
            }
        }
    }

    private static class AggressiveTrafficStrategy extends TrafficStrategy {
        AggressiveTrafficStrategy(String name, int maxConcurrent) {
            super(name, maxConcurrent, maxConcurrent);
        }
    }

    private static class ModerateTrafficStrategy extends TrafficStrategy {
        ModerateTrafficStrategy(String name, int maxConcurrent) {
            super(name, 1, maxConcurrent);
        }
    }

    RetryAndTrafficControlInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return processRequest(chain, request, (HttpTask) TaskManager.getInstance().get((String) request.tag()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017c, code lost:
        if (r20 == null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x017e, code lost:
        r20.reportException(r30, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response processRequest(okhttp3.Interceptor.Chain r29, okhttp3.Request r30, com.tencent.qcloud.core.http.HttpTask r31) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.RetryAndTrafficControlInterceptor.processRequest(okhttp3.Interceptor$Chain, okhttp3.Request, com.tencent.qcloud.core.http.HttpTask):okhttp3.Response");
    }

    private TrafficStrategy getSuitableStrategy(HttpTask task) {
        if (task.isDownloadTask()) {
            return this.downloadTrafficStrategy;
        }
        if (task.isUploadTask()) {
            return this.uploadTrafficStrategy;
        }
        return null;
    }

    private Response executeTaskOnce(Interceptor.Chain chain, Request request, HttpTask task) throws IOException {
        try {
            if (!task.isCanceled()) {
                return processSingleRequest(chain, request);
            }
            throw new IOException("CANCELED");
        } catch (ProtocolException exception) {
            if (exception.getMessage() != null && exception.getMessage().contains("HTTP 204 had non-zero Content-Length: ")) {
                return new Response.Builder().request(request).message(exception.toString()).code(204).protocol(Protocol.HTTP_1_1).build();
            }
            exception.printStackTrace();
            throw exception;
        } catch (IOException exception2) {
            exception2.printStackTrace();
            throw exception2;
        }
    }

    private boolean isUserCancelled(IOException exception) {
        return exception.getMessage() != null && exception.getMessage().toLowerCase().equals("canceled");
    }

    /* access modifiers changed from: package-private */
    public Response processSingleRequest(Interceptor.Chain chain, Request request) throws IOException {
        return chain.proceed(request);
    }

    private boolean shouldRetry(HttpTask task, int attempts, long millsTook) {
        boolean z = true;
        if (task.isStreamingTask()) {
            return attempts < 4 || millsTook < 60000;
        }
        if (attempts >= 3) {
            z = false;
        }
        return z;
    }

    private long getRetryDelay(HttpTask task, IOException e, int attempts) {
        if (!task.isStreamingTask()) {
            return (long) Math.min(((int) Math.pow(2.0d, (double) (attempts - 1))) * RETRY_DELAY_BASE, (int) MAX_NORMAL_RETRY_WAIT_TIME);
        }
        if ((e instanceof ConnectException) || (e instanceof UnknownHostException)) {
            return 10000;
        }
        long delay = (long) Math.min(((int) Math.pow(2.0d, (double) attempts)) * RETRY_DELAY_BASE, (int) MAX_STREAMING_RETRY_WAIT_TIME);
        if (e instanceof SocketTimeoutException) {
            return Math.max(delay, 5000L);
        }
        return delay;
    }

    private boolean isRecoverable(IOException e) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return e instanceof SocketTimeoutException;
        }
        if ((!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }
}
