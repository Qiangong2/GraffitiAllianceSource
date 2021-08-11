package com.tencent.apollo.apollovoice.httpclient;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLRequest {
    private final int AV_HTTP_STATUS_FAIL = 1;
    private final int AV_HTTP_STATUS_GET_CREATEFILE = 8;
    private final int AV_HTTP_STATUS_GET_WRITEFILE = 9;
    private final int AV_HTTP_STATUS_INVALIED_HOST = 3;
    private final int AV_HTTP_STATUS_INVALIED_URL = 4;
    private final int AV_HTTP_STATUS_NOHEADERS = 5;
    private final int AV_HTTP_STATUS_POST_READFILE = 10;
    private final int AV_HTTP_STATUS_READBODY = 6;
    private final int AV_HTTP_STATUS_SEND_INCOMPLETE = 7;
    private final int AV_HTTP_STATUS_SUCC = 0;
    private final int AV_HTTP_STATUS_TIMEOUT = 2;
    private byte[] body;
    private long delegate;
    private String getFilePath;
    private String method;
    private String postFilePath;
    private URL reqConnURL;
    private URLResponse response;
    private int timeout;
    private HttpURLConnection urlConn;

    public static native void response(int i, long j, int i2, String str, String str2, String str3, byte[] bArr, String[] strArr);

    public int initWithURL(String str, int i) {
        this.response = new URLResponse();
        this.response.URL = str;
        this.method = "GET";
        this.timeout = i;
        try {
            this.reqConnURL = new URL(this.response.URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (this.reqConnURL == null) {
            Log.e("ApolloVoice", "reqConnURL");
            return -1;
        }
        try {
            this.urlConn = (HttpURLConnection) this.reqConnURL.openConnection();
            Log.i("ApolloVoice", "After open Connection With URL:" + str);
            if (this.urlConn == null) {
                Log.i("cz", "urlConn == null");
                return -1;
            }
            try {
                this.urlConn.setRequestMethod(this.method);
                this.urlConn.setReadTimeout(i);
                if (this.method == "POST") {
                    this.urlConn.setDoOutput(true);
                    this.urlConn.setUseCaches(false);
                }
                this.urlConn.setConnectTimeout(i);
                return 0;
            } catch (ProtocolException e2) {
                e2.printStackTrace();
                return -1;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public void getFile(String str) {
        setMethod("GET");
        sendRequest(str);
    }

    public void postFile(String str) {
        setMethod("POST");
        sendRequest(str);
    }

    public void sendRequest() {
        this.method = "GET";
        sendRequest("");
    }

    public void sendRequest(String str) {
        new Thread(new RequestTask(str)).start();
    }

    public void response2cpp(int i) {
        Log.i("ApolloVoice", "url[" + this.response.URL + "]response2cpp with result :" + i);
        if (i != 0) {
            response(i, this.delegate, 0, "", this.response.URL, "", null, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.response.headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!(value == null || key == null)) {
                arrayList.add(key);
                arrayList.add(value);
            }
        }
        response(i, this.delegate, this.response.status, this.response.statusMsg, this.response.URL, this.response.version, this.response.body, (String[]) arrayList.toArray(new String[0]));
    }

    public void setMethod(String str) {
        this.method = str;
        try {
            this.urlConn.setRequestMethod(str);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public void setDelegate(long j) {
        this.delegate = j;
    }

    public void addHead(String str, String str2) {
        this.urlConn.setRequestProperty(str, str2);
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    /* access modifiers changed from: package-private */
    public class RequestTask implements Runnable {
        private String filepath;

        public RequestTask(String str) {
            this.filepath = str;
        }

        public void run() {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = null;
            if (this.filepath == "" || URLRequest.this.method != "GET") {
                fileOutputStream = null;
            } else {
                File file = new File(this.filepath);
                try {
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    Log.e("ApolloVoice", "Get File With Create File Error");
                    e.printStackTrace();
                    URLRequest.this.response2cpp(8);
                    return;
                }
            }
            if (this.filepath != "" && URLRequest.this.method == "POST") {
                try {
                    fileInputStream = new FileInputStream(this.filepath);
                } catch (FileNotFoundException e2) {
                    Log.e("ApolloVoice", "Post File With Open File Error");
                    e2.printStackTrace();
                    URLRequest.this.response2cpp(10);
                    return;
                }
            }
            try {
                if (URLRequest.this.body != null) {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(URLRequest.this.urlConn.getOutputStream());
                    bufferedOutputStream.write(URLRequest.this.body);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } else if (this.filepath != "" && URLRequest.this.method == "POST" && fileInputStream != null) {
                    byte[] bArr = new byte[1024];
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(URLRequest.this.urlConn.getOutputStream());
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                        bufferedOutputStream2.flush();
                    }
                    bufferedOutputStream2.close();
                } else if (URLRequest.this.urlConn == null) {
                    Log.e("ApolloVice", "urlConn is null");
                    return;
                } else {
                    URLRequest.this.urlConn.connect();
                }
                Map<String, List<String>> headerFields = URLRequest.this.urlConn.getHeaderFields();
                if (headerFields == null || headerFields.entrySet() == null) {
                    Log.e("ApolloVoice", "headerFields == null || headerFields.entrySet() == null");
                    URLRequest.this.response2cpp(5);
                    return;
                }
                for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    String str = "";
                    if (value != null) {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            str = str + it.next();
                        }
                    }
                    if (key == null) {
                        URLRequest.this.response.version = str.split("\\ ")[0];
                    } else {
                        URLRequest.this.response.headers.put(key, str);
                    }
                }
                try {
                    URLRequest.this.response.status = URLRequest.this.urlConn.getResponseCode();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    URLRequest.this.response.status = 0;
                }
                try {
                    URLRequest.this.response.statusMsg = URLRequest.this.urlConn.getResponseMessage();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    URLRequest.this.response.statusMsg = "No Status Message!";
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(URLRequest.this.urlConn.getInputStream());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        try {
                            int read2 = bufferedInputStream.read(bArr2);
                            if (read2 == -1) {
                                try {
                                    break;
                                } catch (IOException e5) {
                                    Log.e("ApolloVoice", "ByteArrayOutputStream Exception");
                                    return;
                                }
                            } else if (fileOutputStream == null) {
                                byteArrayOutputStream.write(bArr2, 0, read2);
                            } else if (fileOutputStream != null) {
                                fileOutputStream.write(bArr2, 0, read2);
                            }
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            URLRequest.this.response2cpp(6);
                            return;
                        }
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    URLRequest.this.response.body = byteArrayOutputStream.toByteArray();
                    Log.i("ApolloVoice", "Java body size is " + URLRequest.this.response.body.length);
                    if (!(this.filepath == "" || URLRequest.this.method != "GET" || fileOutputStream == null)) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    URLRequest.this.response2cpp(0);
                } catch (FileNotFoundException e8) {
                    if (URLRequest.this.response.status == 404) {
                        URLRequest.this.response.body = "404".getBytes();
                        URLRequest.this.response2cpp(0);
                        return;
                    }
                    Log.e("ApolloVoice", "response status = " + URLRequest.this.response.status + " " + URLRequest.this.response.statusMsg);
                    Log.e("ApolloVoice", "" + URLRequest.this.urlConn.getErrorStream());
                    e8.printStackTrace();
                    URLRequest.this.response2cpp(1);
                } catch (IOException e9) {
                    e9.printStackTrace();
                    URLRequest.this.response2cpp(1);
                }
            } catch (UnknownHostException e10) {
                Log.i("ApolloVoice", "UnknownHost");
                URLRequest.this.response2cpp(3);
            } catch (SocketTimeoutException e11) {
                Log.i("ApolloVoice", "SocketTimeoutException");
                URLRequest.this.response2cpp(2);
            } catch (IOException e12) {
                e12.printStackTrace();
                URLRequest.this.response2cpp(1);
            }
        }
    }
}
