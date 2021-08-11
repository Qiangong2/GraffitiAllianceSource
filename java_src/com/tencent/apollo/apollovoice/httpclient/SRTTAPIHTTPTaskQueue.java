package com.tencent.apollo.apollovoice.httpclient;

class SRTTAPIHTTPTaskQueue {
    private static String LOGTAG = "GCloudVoiceTag";
    private static SRTTAPIHTTPTaskQueueImp taskQueue = new SRTTAPIHTTPTaskQueueImp();

    SRTTAPIHTTPTaskQueue() {
    }

    public static void init() {
        taskQueue.init();
    }

    public static synchronized void addTask(int i, int i2, String str, byte[] bArr, int i3) {
        synchronized (SRTTAPIHTTPTaskQueue.class) {
            taskQueue.addTask(i, i2, str, bArr, i3);
        }
    }
}
