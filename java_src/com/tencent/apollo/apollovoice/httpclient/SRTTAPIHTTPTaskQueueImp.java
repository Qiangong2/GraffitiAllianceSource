package com.tencent.apollo.apollovoice.httpclient;

import android.util.Log;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.LinkedList;

public class SRTTAPIHTTPTaskQueueImp {
    private static String LOGTAG = "GCloudVoiceTag";
    private static String apiAddr = "http://api.pr.weixin.qq.com/cgi-bin/wxvoicereco";
    private static String apiKey = "wxk158ztg8lli234j";
    private LinkedList<SRTTAPIHTTPTask> taskQueue;
    private String timestampArg;
    private Thread workThread;

    public static native void callback(int i, byte[] bArr, int i2);

    public void init() {
        this.taskQueue = new LinkedList<>();
        this.workThread = new Thread(new RequestTask());
        this.workThread.start();
    }

    public synchronized void addTask(int i, int i2, String str, byte[] bArr, int i3) {
        SRTTAPIHTTPTask sRTTAPIHTTPTask = new SRTTAPIHTTPTask();
        sRTTAPIHTTPTask.type = i;
        sRTTAPIHTTPTask.body = bArr;
        sRTTAPIHTTPTask.key = str;
        sRTTAPIHTTPTask.method = i2;
        sRTTAPIHTTPTask.session = i3;
        this.taskQueue.offer(sRTTAPIHTTPTask);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dealStartTask(int i) {
        int i2;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(apiAddr + "?cmd=1&appid=" + apiKey).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, "text/html");
                try {
                    i2 = httpURLConnection.getResponseCode();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    i2 = 0;
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                    httpURLConnection.disconnect();
                                    callback(i2, byteArrayOutputStream.toByteArray(), i);
                                    return;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                } catch (FileNotFoundException e5) {
                    e5.printStackTrace();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        } catch (MalformedURLException e8) {
            e8.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dealStopTask(SRTTAPIHTTPTask sRTTAPIHTTPTask) {
        int i;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(apiAddr + "?platform=android&cmd=6&appid=" + apiKey + "&voice_id=" + sRTTAPIHTTPTask.key).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
                httpURLConnection.setRequestProperty(HttpConstants.Header.CONNECTION, "keep-alive");
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(sRTTAPIHTTPTask.body);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        i = httpURLConnection.getResponseCode();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        i = 0;
                    }
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        byteArrayOutputStream.flush();
                                        byteArrayOutputStream.close();
                                        httpURLConnection.disconnect();
                                        callback(i, byteArrayOutputStream.toByteArray(), sRTTAPIHTTPTask.session);
                                        return;
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        return;
                                    }
                                }
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dealVoiceTask(SRTTAPIHTTPTask sRTTAPIHTTPTask) {
        int i;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(apiAddr + "?platform=android&cmd=6&appid=" + apiKey + "&voice_id=" + sRTTAPIHTTPTask.key).openConnection();
                try {
                    httpURLConnection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
                httpURLConnection.setRequestProperty(HttpConstants.Header.CONNECTION, "keep-alive");
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(sRTTAPIHTTPTask.body);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        i = httpURLConnection.getResponseCode();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        i = 0;
                    }
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        byteArrayOutputStream.flush();
                                        byteArrayOutputStream.close();
                                        httpURLConnection.disconnect();
                                        callback(i, byteArrayOutputStream.toByteArray(), sRTTAPIHTTPTask.session);
                                        return;
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        return;
                                    }
                                }
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e6.printStackTrace();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
    }

    class RequestTask implements Runnable {
        RequestTask() {
        }

        public void run() {
            while (true) {
                if (SRTTAPIHTTPTaskQueueImp.this.taskQueue.isEmpty()) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    SRTTAPIHTTPTask sRTTAPIHTTPTask = (SRTTAPIHTTPTask) SRTTAPIHTTPTaskQueueImp.this.taskQueue.remove();
                    switch (sRTTAPIHTTPTask.type) {
                        case 1:
                            SRTTAPIHTTPTaskQueueImp.this.dealStartTask(sRTTAPIHTTPTask.session);
                            continue;
                        case 2:
                            SRTTAPIHTTPTaskQueueImp.this.dealVoiceTask(sRTTAPIHTTPTask);
                            continue;
                        case 3:
                            SRTTAPIHTTPTaskQueueImp.this.dealStopTask(sRTTAPIHTTPTask);
                            continue;
                        default:
                            Log.i(SRTTAPIHTTPTaskQueueImp.LOGTAG, "[SRTTAPIHTTPTaskQueueImp]Unknown type:" + sRTTAPIHTTPTask.type);
                            continue;
                    }
                }
            }
        }
    }
}
