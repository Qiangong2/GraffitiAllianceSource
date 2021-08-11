package com.pwrd.android.volley;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request> mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request> queue, Network network, Cache cache, ResponseDelivery delivery) {
        this.mQueue = queue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = delivery;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request request = this.mQueue.take();
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.finish("network-discard-cancelled");
                    } else {
                        if (Build.VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
                        }
                        NetworkResponse networkResponse = this.mNetwork.performRequest(request);
                        request.addMarker("network-http-complete");
                        if (!networkResponse.notModified || !request.hasHadResponseDelivered()) {
                            Response<?> response = request.parseNetworkResponse(networkResponse);
                            request.addMarker("network-parse-complete");
                            if (request.shouldCache() && response.cacheEntry != null) {
                                this.mCache.put(request.getCacheKey(), response.cacheEntry);
                                request.addMarker("network-cache-written");
                            }
                            request.markDelivered();
                            this.mDelivery.postResponse(request, response);
                        } else {
                            request.finish("not-modified");
                        }
                    }
                } catch (VolleyError volleyError) {
                    parseAndDeliverNetworkError(request, volleyError);
                } catch (Exception e) {
                    VolleyLog.m4891e(e, "Unhandled exception %s", e.toString());
                    this.mDelivery.postError(request, new VolleyError(e));
                }
            } catch (InterruptedException e2) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }

    private void parseAndDeliverNetworkError(Request<?> request, VolleyError error) {
        this.mDelivery.postError(request, request.parseNetworkError(error));
    }
}
