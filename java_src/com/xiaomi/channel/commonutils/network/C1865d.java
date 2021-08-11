package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.http.HttpConstants;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.string.C1872c;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.channel.commonutils.network.d */
public class C1865d {

    /* renamed from: a */
    public static final Pattern f4631a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b */
    public static final Pattern f4632b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c */
    public static final Pattern f4633c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: com.xiaomi.channel.commonutils.network.d$a */
    public static final class C1866a extends FilterInputStream {

        /* renamed from: a */
        private boolean f4634a;

        public C1866a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.f4634a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.f4634a = true;
            return -1;
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.network.d$b */
    public static class C1867b {

        /* renamed from: a */
        public int f4635a;

        /* renamed from: b */
        public Map<String, String> f4636b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f4635a), this.f4636b.toString());
        }
    }

    /* renamed from: a */
    public static int m6747a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00eb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ec, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0122, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0123, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[SYNTHETIC, Splitter:B:18:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[Catch:{ IOException -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0122 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0007] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.channel.commonutils.network.C1863b m6748a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.C1865d.m6748a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.channel.commonutils.network.b");
    }

    /* renamed from: a */
    public static C1863b m6749a(Context context, String str, Map<String, String> map) {
        return m6748a(context, str, "POST", (Map<String, String>) null, m6757a(map));
    }

    /* renamed from: a */
    public static InputStream m6750a(Context context, URL url, boolean z, String str, String str2) {
        return m6751a(context, url, z, str, str2, null, null);
    }

    /* renamed from: a */
    public static InputStream m6751a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, C1867b bVar) {
        if (context == null) {
            throw new IllegalArgumentException(C1447g.f3472aI);
        } else if (url == null) {
            throw new IllegalArgumentException("url");
        } else {
            URL url2 = !z ? new URL(m6754a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection b = m6758b(context, url2);
                b.setConnectTimeout(10000);
                b.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    b.setRequestProperty(HttpConstants.Header.USER_AGENT, str);
                }
                if (str2 != null) {
                    b.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        b.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals(HttpConstants.Scheme.HTTPS))) {
                    bVar.f4635a = b.getResponseCode();
                    if (bVar.f4636b == null) {
                        bVar.f4636b = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = b.getHeaderFieldKey(i);
                        String headerField = b.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            bVar.f4636b.put(headerFieldKey, headerField);
                        }
                        i++;
                    }
                }
                return new C1866a(b.getInputStream());
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static String m6752a(Context context, URL url) {
        return m6753a(context, url, false, null, "UTF-8", null);
    }

    /* renamed from: a */
    public static String m6753a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream = null;
        try {
            inputStream = m6750a(context, url, z, str, str3);
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            if (inputStream != null) {
                try {
                } catch (IOException e) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e.toString());
                }
            }
            return sb.toString();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e2.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static String m6754a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, C1872c.m6779a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076 A[SYNTHETIC, Splitter:B:18:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[Catch:{ IOException -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[Catch:{ IOException -> 0x016b }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m6755a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.io.File r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.C1865d.m6755a(java.lang.String, java.util.Map, java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m6756a(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            sb.append("?").append(url.getQuery());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m6757a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(SimpleComparison.EQUAL_TO_OPERATION);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    /* renamed from: b */
    public static HttpURLConnection m6758b(Context context, URL url) {
        if (!"http".equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (m6761c(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!m6760b(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        String host = url.getHost();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(m6756a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", host);
        return httpURLConnection;
    }

    /* renamed from: b */
    private static URL m6759b(String str) {
        return new URL(str);
    }

    /* renamed from: b */
    public static boolean m6760b(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap")) {
                    return false;
                }
                return extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m6761c(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) {
                    return false;
                }
                return extraInfo.contains("ctwap");
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m6762d(Context context) {
        return m6747a(context) >= 0;
    }

    /* renamed from: e */
    public static boolean m6763e(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return 1 == activeNetworkInfo.getType();
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: f */
    public static String m6764f(Context context) {
        if (m6763e(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? "" : (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }
}
