package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gcloud.voice.GCloudVoiceErrno;
import com.xiaomi.channel.commonutils.network.AbstractC1864c;
import com.xiaomi.channel.commonutils.network.C1865d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HttpUtils {

    public static class DefaultHttpGetProcessor extends HttpProcessor {
        public DefaultHttpGetProcessor() {
            super(1);
        }

        @Override // com.xiaomi.network.HttpProcessor
        /* renamed from: b */
        public String mo10288b(Context context, String str, List<AbstractC1864c> list) {
            if (list == null) {
                return C1865d.m6752a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (AbstractC1864c cVar : list) {
                buildUpon.appendQueryParameter(cVar.mo9936a(), cVar.mo9937b());
            }
            return C1865d.m6752a(context, new URL(buildUpon.toString()));
        }
    }

    /* renamed from: a */
    static int m7066a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    /* renamed from: a */
    static int m7067a(int i, int i2, int i3) {
        return (((i2 + GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    /* renamed from: a */
    private static int m7068a(HttpProcessor httpProcessor, String str, List<AbstractC1864c> list, String str2) {
        if (httpProcessor.mo10286a() == 1) {
            return m7066a(str.length(), m7069a(str2));
        }
        if (httpProcessor.mo10286a() != 2) {
            return -1;
        }
        return m7067a(str.length(), m7070a(list), m7069a(str2));
    }

    /* renamed from: a */
    static int m7069a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }

    /* renamed from: a */
    static int m7070a(List<AbstractC1864c> list) {
        int i = 0;
        Iterator<AbstractC1864c> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2 * 2;
            }
            AbstractC1864c next = it.next();
            if (!TextUtils.isEmpty(next.mo9936a())) {
                i2 += next.mo9936a().length();
            }
            i = !TextUtils.isEmpty(next.mo9937b()) ? next.mo9937b().length() + i2 : i2;
        }
    }

    /* renamed from: a */
    public static String m7071a(Context context, String str, List<AbstractC1864c> list) {
        return m7072a(context, str, list, new DefaultHttpGetProcessor(), true);
    }

    /* renamed from: a */
    public static String m7072a(Context context, String str, List<AbstractC1864c> list, HttpProcessor httpProcessor, boolean z) {
        if (C1865d.m6762d(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                Fallback fallback = null;
                if (z && (fallback = HostManager.getInstance().getFallbacksByURL(str)) != null) {
                    arrayList = fallback.mo10226a(str);
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                String str2 = null;
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!httpProcessor.mo10287a(context, next, arrayList2)) {
                            return str2;
                        }
                        str2 = httpProcessor.mo10288b(context, next, arrayList2);
                        if (TextUtils.isEmpty(str2)) {
                            if (fallback != null) {
                                fallback.mo10233a(next, System.currentTimeMillis() - currentTimeMillis, (long) m7068a(httpProcessor, next, arrayList2, str2), null);
                            }
                            str2 = str2;
                        } else if (fallback == null) {
                            return str2;
                        } else {
                            fallback.mo10232a(next, System.currentTimeMillis() - currentTimeMillis, (long) m7068a(httpProcessor, next, arrayList2, str2));
                            return str2;
                        }
                    } catch (IOException e) {
                        if (fallback != null) {
                            fallback.mo10233a(next, System.currentTimeMillis() - currentTimeMillis, (long) m7068a(httpProcessor, next, arrayList2, str2), e);
                        }
                        e.printStackTrace();
                    }
                }
                return str2;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
