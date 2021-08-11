package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.amap.loc.bo */
/* compiled from: StatisticsEntity */
public class C0288bo {

    /* renamed from: a */
    private Context f476a;

    /* renamed from: b */
    private String f477b;

    /* renamed from: c */
    private String f478c;

    /* renamed from: d */
    private String f479d;

    /* renamed from: e */
    private String f480e;

    public C0288bo(Context context, String str, String str2, String str3) throws C0341h {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new C0341h("无效的参数 - IllegalArgumentException");
        }
        this.f476a = context.getApplicationContext();
        this.f478c = str;
        this.f479d = str2;
        this.f477b = str3;
    }

    /* renamed from: a */
    public void mo3774a(String str) throws C0341h {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new C0341h("无效的参数 - IllegalArgumentException");
        }
        this.f480e = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c A[SYNTHETIC, Splitter:B:15:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079 A[SYNTHETIC, Splitter:B:22:0x0079] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo3775a() {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0288bo.mo3775a():byte[]");
    }

    /* renamed from: a */
    public byte[] mo3776a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: b */
    public byte[] mo3777b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        int length = str.length();
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }
}
