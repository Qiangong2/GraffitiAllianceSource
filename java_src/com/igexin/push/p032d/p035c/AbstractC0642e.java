package com.igexin.push.p032d.p035c;

import android.support.p007v4.view.MotionEventCompat;
import com.igexin.p012b.p013a.p020d.AbstractC0461a;

/* renamed from: com.igexin.push.d.c.e */
public abstract class AbstractC0642e extends AbstractC0461a {

    /* renamed from: i */
    public int f1723i;

    /* renamed from: j */
    public byte f1724j;

    /* renamed from: k */
    public byte f1725k = 11;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo4694a(String str) {
        if (str.equals("UTF-8")) {
            return 1;
        }
        if (str.equals("UTF-16")) {
            return 2;
        }
        if (str.equals("UTF-16BE")) {
            return 16;
        }
        if (str.equals("UTF-16LE")) {
            return 17;
        }
        if (str.equals("GBK")) {
            return 25;
        }
        if (str.equals("GB2312")) {
            return 26;
        }
        if (str.equals("GB18030")) {
            return 27;
        }
        return str.equals("ISO-8859-1") ? 33 : 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo4695a(byte b) {
        switch (b & 63) {
            case 1:
                return "UTF-8";
            case 2:
                return "UTF-16";
            case 16:
                return "UTF-16BE";
            case 17:
                return "UTF-16LE";
            case MotionEventCompat.AXIS_TILT:
                return "GBK";
            case 26:
                return "GB2312";
            case 27:
                return "GB18030";
            case MotionEventCompat.AXIS_GENERIC_2:
                return "ISO-8859-1";
            default:
                return "UTF-8";
        }
    }

    /* renamed from: a */
    public abstract void mo4682a(byte[] bArr);

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return this.f1723i;
    }

    /* renamed from: d */
    public abstract byte[] mo4685d();
}
