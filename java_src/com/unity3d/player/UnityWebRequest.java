package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;

/* access modifiers changed from: package-private */
public class UnityWebRequest implements Runnable {

    /* renamed from: a */
    private long f4100a;

    /* renamed from: b */
    private String f4101b;

    /* renamed from: c */
    private String f4102c;

    /* renamed from: d */
    private Map f4103d;

    /* renamed from: e */
    private int f4104e;

    /* renamed from: f */
    private long f4105f;

    UnityWebRequest(long j, String str, Map map, String str2, int i) {
        this.f4100a = j;
        this.f4101b = str2;
        this.f4102c = str;
        this.f4103d = map;
        this.f4104e = i;
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private boolean hasTimedOut() {
        return this.f4104e > 0 && System.currentTimeMillis() - this.f4105f >= ((long) this.f4104e);
    }

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public void badProtocolCallback(String str) {
        errorCallback(this.f4100a, 4, str);
    }

    /* access modifiers changed from: protected */
    public void contentLengthCallback(int i) {
        contentLengthCallback(this.f4100a, i);
    }

    /* access modifiers changed from: protected */
    public boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f4100a, byteBuffer, i);
    }

    /* access modifiers changed from: protected */
    public void errorCallback(String str) {
        errorCallback(this.f4100a, 2, str);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(String str, String str2) {
        headerCallback(this.f4100a, str, str2);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(Map map) {
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    str = "Status";
                }
                for (String str2 : (List) entry.getValue()) {
                    headerCallback(str, str2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void malformattedUrlCallback(String str) {
        errorCallback(this.f4100a, 5, str);
    }

    /* access modifiers changed from: protected */
    public void responseCodeCallback(int i) {
        responseCodeCallback(this.f4100a, i);
    }

    public void run() {
        InputStream inputStream;
        SSLSocketFactory a;
        this.f4105f = System.currentTimeMillis();
        try {
            URL url = new URL(this.f4101b);
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(this.f4104e);
            openConnection.setReadTimeout(this.f4104e);
            if ((openConnection instanceof HttpsURLConnection) && (a = C1605a.m6098a()) != null) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(a);
            }
            if (url.getProtocol().equalsIgnoreCase("file") && !url.getHost().isEmpty()) {
                malformattedUrlCallback("file:// must use an absolute path");
            } else if (openConnection instanceof JarURLConnection) {
                badProtocolCallback("A URL Connection to a Java ARchive (JAR) file or an entry in a JAR file is not supported");
            } else {
                if (openConnection instanceof HttpURLConnection) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod(this.f4102c);
                        httpURLConnection.setInstanceFollowRedirects(false);
                    } catch (ProtocolException e) {
                        badProtocolCallback(e.toString());
                        return;
                    }
                }
                if (this.f4103d != null) {
                    for (Map.Entry entry : this.f4103d.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(131072);
                if (uploadCallback(null) > 0) {
                    openConnection.setDoOutput(true);
                    try {
                        OutputStream outputStream = openConnection.getOutputStream();
                        int uploadCallback = uploadCallback(allocateDirect);
                        while (uploadCallback > 0) {
                            if (hasTimedOut()) {
                                outputStream.close();
                                errorCallback(this.f4100a, 14, "WebRequest timed out.");
                                return;
                            }
                            outputStream.write(allocateDirect.array(), allocateDirect.arrayOffset(), uploadCallback);
                            uploadCallback = uploadCallback(allocateDirect);
                        }
                    } catch (Exception e2) {
                        errorCallback(e2.toString());
                        return;
                    }
                }
                if (openConnection instanceof HttpURLConnection) {
                    try {
                        responseCodeCallback(((HttpURLConnection) openConnection).getResponseCode());
                    } catch (UnknownHostException e3) {
                        unknownHostCallback(e3.toString());
                    } catch (SocketTimeoutException e4) {
                        errorCallback(this.f4100a, 14, e4.toString());
                        return;
                    } catch (IOException e5) {
                        errorCallback(e5.toString());
                        return;
                    }
                }
                Map<String, List<String>> headerFields = openConnection.getHeaderFields();
                headerCallback(headerFields);
                if ((headerFields == null || !headerFields.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                    headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
                }
                if ((headerFields == null || !headerFields.containsKey("content-type")) && openConnection.getContentType() != null) {
                    headerCallback("content-type", openConnection.getContentType());
                }
                contentLengthCallback(openConnection.getContentLength());
                try {
                    if (openConnection instanceof HttpURLConnection) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                        responseCodeCallback(httpURLConnection2.getResponseCode());
                        inputStream = httpURLConnection2.getErrorStream();
                    } else {
                        inputStream = null;
                    }
                    if (inputStream == null) {
                        inputStream = openConnection.getInputStream();
                    }
                    ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                    for (int read = newChannel.read(allocateDirect); read != -1; read = newChannel.read(allocateDirect)) {
                        if (!hasTimedOut()) {
                            if (!downloadCallback(allocateDirect, read)) {
                                break;
                            }
                            allocateDirect.clear();
                        } else {
                            newChannel.close();
                            errorCallback(this.f4100a, 14, "WebRequest timed out.");
                            return;
                        }
                    }
                    newChannel.close();
                } catch (UnknownHostException e6) {
                    unknownHostCallback(e6.toString());
                } catch (SSLHandshakeException e7) {
                    sslCannotConnectCallback(e7.toString());
                } catch (SocketTimeoutException e8) {
                    errorCallback(this.f4100a, 14, e8.toString());
                } catch (IOException e9) {
                    errorCallback(this.f4100a, 14, e9.toString());
                } catch (Exception e10) {
                    errorCallback(e10.toString());
                }
            }
        } catch (MalformedURLException e11) {
            malformattedUrlCallback(e11.toString());
        } catch (IOException e12) {
            errorCallback(e12.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void sslCannotConnectCallback(String str) {
        errorCallback(this.f4100a, 16, str);
    }

    /* access modifiers changed from: protected */
    public void unknownHostCallback(String str) {
        errorCallback(this.f4100a, 7, str);
    }

    /* access modifiers changed from: protected */
    public int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.f4100a, byteBuffer);
    }
}
