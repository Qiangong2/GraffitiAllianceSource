package com.tencent.qcloud.core.task;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudResultListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class Task<T> implements Runnable {
    protected QCloudClientException clientException;
    private boolean closed;
    protected boolean completed;
    protected boolean executed;
    private final String identifier;
    protected Set<QCloudProgressListener> mProgressListeners = new HashSet(2);
    protected T mResult;
    protected Set<QCloudResultListener<T>> mResultListeners = new HashSet(2);
    private Executor observerExecutor;
    protected QCloudServiceException serviceException;
    private final Object tag;
    protected TaskManager taskManager;
    protected ThreadPoolExecutor workerExecutor;

    /* access modifiers changed from: protected */
    public abstract T onCommand() throws QCloudClientException, QCloudServiceException;

    Task(String identifier2, Object tag2) {
        this.identifier = identifier2;
        this.tag = tag2;
        this.taskManager = TaskManager.getInstance();
    }

    /* access modifiers changed from: protected */
    public void scheduleOn(ThreadPoolExecutor executor) {
        this.taskManager.add(this);
        this.workerExecutor = executor;
        TaskExecutors.schedule(executor, this);
    }

    public final Task<T> observeOn(Executor executor) {
        this.observerExecutor = executor;
        return this;
    }

    public final T executeNow() throws QCloudClientException, QCloudServiceException {
        executeNowSilently();
        if (this.clientException != null) {
            throw this.clientException;
        } else if (this.serviceException == null) {
            return this.mResult;
        } else {
            throw this.serviceException;
        }
    }

    public final void executeNowSilently() {
        this.taskManager.add(this);
        run();
    }

    public final Task<T> addResultListener(QCloudResultListener<T> resultListener) {
        if (resultListener != null) {
            this.mResultListeners.add(resultListener);
        }
        return this;
    }

    public final Task<T> addResultListeners(List<QCloudResultListener<T>> resultListeners) {
        if (resultListeners != null) {
            this.mResultListeners.addAll(resultListeners);
        }
        return this;
    }

    public final Task<T> removeResultListener(QCloudResultListener<T> resultListener) {
        if (resultListener != null) {
            this.mResultListeners.remove(resultListener);
        }
        return this;
    }

    public final void removeAllListeners() {
        this.mResultListeners.clear();
        this.mProgressListeners.clear();
    }

    public final List<QCloudResultListener<T>> getAllResultListeners() {
        return new ArrayList(this.mResultListeners);
    }

    public final List<QCloudProgressListener> getAllProgressListeners() {
        return new ArrayList(this.mProgressListeners);
    }

    public final Task<T> addProgressListener(QCloudProgressListener progressListener) {
        if (progressListener != null) {
            this.mProgressListeners.add(progressListener);
        }
        return this;
    }

    public final Task<T> addProgressListeners(List<QCloudProgressListener> progressListeners) {
        if (progressListeners != null) {
            this.mProgressListeners.addAll(progressListeners);
        }
        return this;
    }

    public final Task<T> removeProgressListener(QCloudProgressListener progressListener) {
        if (progressListener != null) {
            this.mProgressListeners.remove(progressListener);
        }
        return this;
    }

    public T getResult() {
        return this.mResult;
    }

    public Exception getException() {
        return this.clientException != null ? this.clientException : this.serviceException;
    }

    /* access modifiers changed from: protected */
    public void onSuccess() {
        if (this.mResultListeners.size() > 0) {
            executeListener(new Runnable() {
                /* class com.tencent.qcloud.core.task.Task.RunnableC13321 */

                public void run() {
                    for (QCloudResultListener<T> resultListener : new ArrayList<>(Task.this.mResultListeners)) {
                        resultListener.onSuccess(Task.this.mResult);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onFailure() {
        if (this.mResultListeners.size() > 0) {
            executeListener(new Runnable() {
                /* class com.tencent.qcloud.core.task.Task.RunnableC13332 */

                public void run() {
                    Iterator<QCloudResultListener<T>> it = new ArrayList<>(Task.this.mResultListeners).iterator();
                    while (it.hasNext()) {
                        it.next().onFailure(Task.this.clientException, Task.this.serviceException);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onProgress(final long complete, final long target) {
        if (this.mProgressListeners.size() > 0) {
            executeListener(new Runnable() {
                /* class com.tencent.qcloud.core.task.Task.RunnableC13343 */

                public void run() {
                    for (QCloudProgressListener progressListener : new ArrayList<>(Task.this.mProgressListeners)) {
                        progressListener.onProgress(complete, target);
                    }
                }
            });
        }
    }

    private void executeListener(Runnable callback) {
        if (this.observerExecutor != null) {
            this.observerExecutor.execute(callback);
        } else {
            callback.run();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            this.taskManager.remove(this);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onExecute() {
        QCloudLogger.m4893d("QCloudTask", "[Task] %s start execute", getIdentifier());
        this.executed = true;
    }

    /* access modifiers changed from: protected */
    public synchronized void onComplete() {
        QCloudLogger.m4893d("QCloudTask", "[Task] %s complete", getIdentifier());
        close();
        this.completed = true;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    public final synchronized boolean isCompleted() {
        return this.completed;
    }

    public void run() {
        onExecute();
        try {
            this.mResult = onCommand();
            onSuccess();
        } catch (QCloudClientException e) {
            e.printStackTrace();
            this.clientException = e;
            onFailure();
        } catch (QCloudServiceException e2) {
            e2.printStackTrace();
            this.serviceException = e2;
            onFailure();
        }
        onComplete();
    }
}
