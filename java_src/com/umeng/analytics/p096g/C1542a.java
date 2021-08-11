package com.umeng.analytics.p096g;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000a.p001a.p002a.AbstractC0033d;
import p000a.p001a.p002a.AbstractC0047k;
import p000a.p001a.p002a.C0000a;
import p000a.p001a.p002a.C0039e;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p003a.C0002b;
import p000a.p001a.p002a.p003a.C0003c;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0020i;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p004b.C0024m;
import p000a.p001a.p002a.p004b.C0025n;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0030b;
import p000a.p001a.p002a.p005c.AbstractC0031c;
import p000a.p001a.p002a.p005c.AbstractC0032d;
import p000a.p001a.p002a.p006d.C0034a;

/* renamed from: com.umeng.analytics.g.a */
/* compiled from: UMEnvelope */
public class C1542a implements AbstractC0033d<C1542a, EnumC1548e>, Serializable, Cloneable {

    /* renamed from: A */
    private static final int f3871A = 2;

    /* renamed from: B */
    private static final int f3872B = 3;

    /* renamed from: k */
    public static final Map<EnumC1548e, C0002b> f3873k;

    /* renamed from: l */
    private static final long f3874l = 420342210744516016L;

    /* renamed from: m */
    private static final C0024m f3875m = new C0024m("UMEnvelope");

    /* renamed from: n */
    private static final C0014c f3876n = new C0014c("version", (byte) 11, 1);

    /* renamed from: o */
    private static final C0014c f3877o = new C0014c("address", (byte) 11, 2);

    /* renamed from: p */
    private static final C0014c f3878p = new C0014c("signature", (byte) 11, 3);

    /* renamed from: q */
    private static final C0014c f3879q = new C0014c("serial_num", (byte) 8, 4);

    /* renamed from: r */
    private static final C0014c f3880r = new C0014c("ts_secs", (byte) 8, 5);

    /* renamed from: s */
    private static final C0014c f3881s = new C0014c("length", (byte) 8, 6);

    /* renamed from: t */
    private static final C0014c f3882t = new C0014c("entity", (byte) 11, 7);

    /* renamed from: u */
    private static final C0014c f3883u = new C0014c("guid", (byte) 11, 8);

    /* renamed from: v */
    private static final C0014c f3884v = new C0014c("checksum", (byte) 11, 9);

    /* renamed from: w */
    private static final C0014c f3885w = new C0014c("codex", (byte) 8, 10);

    /* renamed from: x */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3886x = new HashMap();

    /* renamed from: y */
    private static final int f3887y = 0;

    /* renamed from: z */
    private static final int f3888z = 1;

    /* renamed from: C */
    private byte f3889C;

    /* renamed from: D */
    private EnumC1548e[] f3890D;

    /* renamed from: a */
    public String f3891a;

    /* renamed from: b */
    public String f3892b;

    /* renamed from: c */
    public String f3893c;

    /* renamed from: d */
    public int f3894d;

    /* renamed from: e */
    public int f3895e;

    /* renamed from: f */
    public int f3896f;

    /* renamed from: g */
    public ByteBuffer f3897g;

    /* renamed from: h */
    public String f3898h;

    /* renamed from: i */
    public String f3899i;

    /* renamed from: j */
    public int f3900j;

    static {
        f3886x.put(AbstractC0031c.class, new C1545b());
        f3886x.put(AbstractC0032d.class, new C1547d());
        EnumMap enumMap = new EnumMap(EnumC1548e.class);
        enumMap.put((Object) EnumC1548e.VERSION, (Object) new C0002b("version", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1548e.ADDRESS, (Object) new C0002b("address", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1548e.SIGNATURE, (Object) new C0002b("signature", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1548e.SERIAL_NUM, (Object) new C0002b("serial_num", (byte) 1, new C0003c((byte) 8)));
        enumMap.put((Object) EnumC1548e.TS_SECS, (Object) new C0002b("ts_secs", (byte) 1, new C0003c((byte) 8)));
        enumMap.put((Object) EnumC1548e.LENGTH, (Object) new C0002b("length", (byte) 1, new C0003c((byte) 8)));
        enumMap.put((Object) EnumC1548e.ENTITY, (Object) new C0002b("entity", (byte) 1, new C0003c((byte) 11, true)));
        enumMap.put((Object) EnumC1548e.GUID, (Object) new C0002b("guid", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1548e.CHECKSUM, (Object) new C0002b("checksum", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1548e.CODEX, (Object) new C0002b("codex", (byte) 2, new C0003c((byte) 8)));
        f3873k = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1542a.class, f3873k);
    }

    /* renamed from: com.umeng.analytics.g.a$e */
    /* compiled from: UMEnvelope */
    public enum EnumC1548e implements AbstractC0047k {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k */
        private static final Map<String, EnumC1548e> f3911k = new HashMap();

        /* renamed from: l */
        private final short f3913l;

        /* renamed from: m */
        private final String f3914m;

        static {
            Iterator it = EnumSet.allOf(EnumC1548e.class).iterator();
            while (it.hasNext()) {
                EnumC1548e eVar = (EnumC1548e) it.next();
                f3911k.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1548e m5970a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1548e m5972b(int i) {
            EnumC1548e a = m5970a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1548e m5971a(String str) {
            return f3911k.get(str);
        }

        private EnumC1548e(short s, String str) {
            this.f3913l = s;
            this.f3914m = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3913l;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3914m;
        }
    }

    public C1542a() {
        this.f3889C = 0;
        this.f3890D = new EnumC1548e[]{EnumC1548e.CODEX};
    }

    public C1542a(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f3891a = str;
        this.f3892b = str2;
        this.f3893c = str3;
        this.f3894d = i;
        mo8873d(true);
        this.f3895e = i2;
        mo8876e(true);
        this.f3896f = i3;
        mo8880f(true);
        this.f3897g = byteBuffer;
        this.f3898h = str4;
        this.f3899i = str5;
    }

    public C1542a(C1542a aVar) {
        this.f3889C = 0;
        this.f3890D = new EnumC1548e[]{EnumC1548e.CODEX};
        this.f3889C = aVar.f3889C;
        if (aVar.mo8877e()) {
            this.f3891a = aVar.f3891a;
        }
        if (aVar.mo8884h()) {
            this.f3892b = aVar.f3892b;
        }
        if (aVar.mo8889k()) {
            this.f3893c = aVar.f3893c;
        }
        this.f3894d = aVar.f3894d;
        this.f3895e = aVar.f3895e;
        this.f3896f = aVar.f3896f;
        if (aVar.mo8903y()) {
            this.f3897g = C0039e.m259d(aVar.f3897g);
        }
        if (aVar.mo8850B()) {
            this.f3898h = aVar.f3898h;
        }
        if (aVar.mo8853E()) {
            this.f3899i = aVar.f3899i;
        }
        this.f3900j = aVar.f3900j;
    }

    /* renamed from: a */
    public C1542a mo77p() {
        return new C1542a(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3891a = null;
        this.f3892b = null;
        this.f3893c = null;
        mo8873d(false);
        this.f3894d = 0;
        mo8876e(false);
        this.f3895e = 0;
        mo8880f(false);
        this.f3896f = 0;
        this.f3897g = null;
        this.f3898h = null;
        this.f3899i = null;
        mo8888j(false);
        this.f3900j = 0;
    }

    /* renamed from: c */
    public String mo8868c() {
        return this.f3891a;
    }

    /* renamed from: a */
    public C1542a mo8860a(String str) {
        this.f3891a = str;
        return this;
    }

    /* renamed from: d */
    public void mo8872d() {
        this.f3891a = null;
    }

    /* renamed from: e */
    public boolean mo8877e() {
        return this.f3891a != null;
    }

    /* renamed from: a */
    public void mo8863a(boolean z) {
        if (!z) {
            this.f3891a = null;
        }
    }

    /* renamed from: f */
    public String mo8879f() {
        return this.f3892b;
    }

    /* renamed from: b */
    public C1542a mo8864b(String str) {
        this.f3892b = str;
        return this;
    }

    /* renamed from: g */
    public void mo8881g() {
        this.f3892b = null;
    }

    /* renamed from: h */
    public boolean mo8884h() {
        return this.f3892b != null;
    }

    /* renamed from: b */
    public void mo8865b(boolean z) {
        if (!z) {
            this.f3892b = null;
        }
    }

    /* renamed from: i */
    public String mo8885i() {
        return this.f3893c;
    }

    /* renamed from: c */
    public C1542a mo8867c(String str) {
        this.f3893c = str;
        return this;
    }

    /* renamed from: j */
    public void mo8887j() {
        this.f3893c = null;
    }

    /* renamed from: k */
    public boolean mo8889k() {
        return this.f3893c != null;
    }

    /* renamed from: c */
    public void mo8869c(boolean z) {
        if (!z) {
            this.f3893c = null;
        }
    }

    /* renamed from: l */
    public int mo8890l() {
        return this.f3894d;
    }

    /* renamed from: a */
    public C1542a mo8859a(int i) {
        this.f3894d = i;
        mo8873d(true);
        return this;
    }

    /* renamed from: m */
    public void mo8891m() {
        this.f3889C = C0000a.m12b(this.f3889C, 0);
    }

    /* renamed from: n */
    public boolean mo8892n() {
        return C0000a.m8a(this.f3889C, 0);
    }

    /* renamed from: d */
    public void mo8873d(boolean z) {
        this.f3889C = C0000a.m0a(this.f3889C, 0, z);
    }

    /* renamed from: o */
    public int mo8893o() {
        return this.f3895e;
    }

    /* renamed from: c */
    public C1542a mo8866c(int i) {
        this.f3895e = i;
        mo8876e(true);
        return this;
    }

    /* renamed from: q */
    public void mo8894q() {
        this.f3889C = C0000a.m12b(this.f3889C, 1);
    }

    /* renamed from: r */
    public boolean mo8895r() {
        return C0000a.m8a(this.f3889C, 1);
    }

    /* renamed from: e */
    public void mo8876e(boolean z) {
        this.f3889C = C0000a.m0a(this.f3889C, 1, z);
    }

    /* renamed from: s */
    public int mo8896s() {
        return this.f3896f;
    }

    /* renamed from: d */
    public C1542a mo8870d(int i) {
        this.f3896f = i;
        mo8880f(true);
        return this;
    }

    /* renamed from: t */
    public void mo8897t() {
        this.f3889C = C0000a.m12b(this.f3889C, 2);
    }

    /* renamed from: u */
    public boolean mo8899u() {
        return C0000a.m8a(this.f3889C, 2);
    }

    /* renamed from: f */
    public void mo8880f(boolean z) {
        this.f3889C = C0000a.m0a(this.f3889C, 2, z);
    }

    /* renamed from: v */
    public byte[] mo8900v() {
        mo8861a(C0039e.m258c(this.f3897g));
        if (this.f3897g == null) {
            return null;
        }
        return this.f3897g.array();
    }

    /* renamed from: w */
    public ByteBuffer mo8901w() {
        return this.f3897g;
    }

    /* renamed from: a */
    public C1542a mo8862a(byte[] bArr) {
        mo8861a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public C1542a mo8861a(ByteBuffer byteBuffer) {
        this.f3897g = byteBuffer;
        return this;
    }

    /* renamed from: x */
    public void mo8902x() {
        this.f3897g = null;
    }

    /* renamed from: y */
    public boolean mo8903y() {
        return this.f3897g != null;
    }

    /* renamed from: g */
    public void mo8882g(boolean z) {
        if (!z) {
            this.f3897g = null;
        }
    }

    /* renamed from: z */
    public String mo8904z() {
        return this.f3898h;
    }

    /* renamed from: d */
    public C1542a mo8871d(String str) {
        this.f3898h = str;
        return this;
    }

    /* renamed from: A */
    public void mo8849A() {
        this.f3898h = null;
    }

    /* renamed from: B */
    public boolean mo8850B() {
        return this.f3898h != null;
    }

    /* renamed from: h */
    public void mo8883h(boolean z) {
        if (!z) {
            this.f3898h = null;
        }
    }

    /* renamed from: C */
    public String mo8851C() {
        return this.f3899i;
    }

    /* renamed from: e */
    public C1542a mo8875e(String str) {
        this.f3899i = str;
        return this;
    }

    /* renamed from: D */
    public void mo8852D() {
        this.f3899i = null;
    }

    /* renamed from: E */
    public boolean mo8853E() {
        return this.f3899i != null;
    }

    /* renamed from: i */
    public void mo8886i(boolean z) {
        if (!z) {
            this.f3899i = null;
        }
    }

    /* renamed from: F */
    public int mo8854F() {
        return this.f3900j;
    }

    /* renamed from: e */
    public C1542a mo8874e(int i) {
        this.f3900j = i;
        mo8888j(true);
        return this;
    }

    /* renamed from: G */
    public void mo8855G() {
        this.f3889C = C0000a.m12b(this.f3889C, 3);
    }

    /* renamed from: H */
    public boolean mo8856H() {
        return C0000a.m8a(this.f3889C, 3);
    }

    /* renamed from: j */
    public void mo8888j(boolean z) {
        this.f3889C = C0000a.m0a(this.f3889C, 3, z);
    }

    /* renamed from: f */
    public EnumC1548e mo74b(int i) {
        return EnumC1548e.m5970a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3886x.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3886x.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        if (this.f3891a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3891a);
        }
        sb.append(", ");
        sb.append("address:");
        if (this.f3892b == null) {
            sb.append("null");
        } else {
            sb.append(this.f3892b);
        }
        sb.append(", ");
        sb.append("signature:");
        if (this.f3893c == null) {
            sb.append("null");
        } else {
            sb.append(this.f3893c);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f3894d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f3895e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f3896f);
        sb.append(", ");
        sb.append("entity:");
        if (this.f3897g == null) {
            sb.append("null");
        } else {
            C0039e.m254a(this.f3897g, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        if (this.f3898h == null) {
            sb.append("null");
        } else {
            sb.append(this.f3898h);
        }
        sb.append(", ");
        sb.append("checksum:");
        if (this.f3899i == null) {
            sb.append("null");
        } else {
            sb.append(this.f3899i);
        }
        if (mo8856H()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f3900j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: I */
    public void mo8857I() throws C0046j {
        if (this.f3891a == null) {
            throw new C0020i("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f3892b == null) {
            throw new C0020i("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f3893c == null) {
            throw new C0020i("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.f3897g == null) {
            throw new C0020i("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.f3898h == null) {
            throw new C0020i("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.f3899i == null) {
            throw new C0020i("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5897a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5896a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3889C = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.g.a$b */
    /* compiled from: UMEnvelope */
    private static class C1545b implements AbstractC0030b {
        private C1545b() {
        }

        /* renamed from: a */
        public C1544a mo72b() {
            return new C1544a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.g.a$a */
    /* compiled from: UMEnvelope */
    public static class C1544a extends AbstractC0031c<C1542a> {
        private C1544a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1542a aVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!aVar.mo8892n()) {
                        throw new C0020i("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!aVar.mo8895r()) {
                        throw new C0020i("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (!aVar.mo8899u()) {
                        throw new C0020i("Required field 'length' was not found in serialized data! Struct: " + toString());
                    } else {
                        aVar.mo8857I();
                        return;
                    }
                } else {
                    switch (l.f66c) {
                        case 1:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3891a = hVar.mo54z();
                                aVar.mo8863a(true);
                                break;
                            }
                        case 2:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3892b = hVar.mo54z();
                                aVar.mo8865b(true);
                                break;
                            }
                        case 3:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3893c = hVar.mo54z();
                                aVar.mo8869c(true);
                                break;
                            }
                        case 4:
                            if (l.f65b != 8) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3894d = hVar.mo51w();
                                aVar.mo8873d(true);
                                break;
                            }
                        case 5:
                            if (l.f65b != 8) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3895e = hVar.mo51w();
                                aVar.mo8876e(true);
                                break;
                            }
                        case 6:
                            if (l.f65b != 8) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3896f = hVar.mo51w();
                                aVar.mo8880f(true);
                                break;
                            }
                        case 7:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3897g = hVar.mo11A();
                                aVar.mo8882g(true);
                                break;
                            }
                        case 8:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3898h = hVar.mo54z();
                                aVar.mo8883h(true);
                                break;
                            }
                        case 9:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3899i = hVar.mo54z();
                                aVar.mo8886i(true);
                                break;
                            }
                        case 10:
                            if (l.f65b != 8) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                aVar.f3900j = hVar.mo51w();
                                aVar.mo8888j(true);
                                break;
                            }
                        default:
                            C0022k.m187a(hVar, l.f65b);
                            break;
                    }
                    hVar.mo41m();
                }
            }
        }

        /* renamed from: b */
        public void mo70a(AbstractC0019h hVar, C1542a aVar) throws C0046j {
            aVar.mo8857I();
            hVar.mo22a(C1542a.f3875m);
            if (aVar.f3891a != null) {
                hVar.mo17a(C1542a.f3876n);
                hVar.mo23a(aVar.f3891a);
                hVar.mo29c();
            }
            if (aVar.f3892b != null) {
                hVar.mo17a(C1542a.f3877o);
                hVar.mo23a(aVar.f3892b);
                hVar.mo29c();
            }
            if (aVar.f3893c != null) {
                hVar.mo17a(C1542a.f3878p);
                hVar.mo23a(aVar.f3893c);
                hVar.mo29c();
            }
            hVar.mo17a(C1542a.f3879q);
            hVar.mo15a(aVar.f3894d);
            hVar.mo29c();
            hVar.mo17a(C1542a.f3880r);
            hVar.mo15a(aVar.f3895e);
            hVar.mo29c();
            hVar.mo17a(C1542a.f3881s);
            hVar.mo15a(aVar.f3896f);
            hVar.mo29c();
            if (aVar.f3897g != null) {
                hVar.mo17a(C1542a.f3882t);
                hVar.mo24a(aVar.f3897g);
                hVar.mo29c();
            }
            if (aVar.f3898h != null) {
                hVar.mo17a(C1542a.f3883u);
                hVar.mo23a(aVar.f3898h);
                hVar.mo29c();
            }
            if (aVar.f3899i != null) {
                hVar.mo17a(C1542a.f3884v);
                hVar.mo23a(aVar.f3899i);
                hVar.mo29c();
            }
            if (aVar.mo8856H()) {
                hVar.mo17a(C1542a.f3885w);
                hVar.mo15a(aVar.f3900j);
                hVar.mo29c();
            }
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.g.a$d */
    /* compiled from: UMEnvelope */
    private static class C1547d implements AbstractC0030b {
        private C1547d() {
        }

        /* renamed from: a */
        public C1546c mo72b() {
            return new C1546c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.g.a$c */
    /* compiled from: UMEnvelope */
    public static class C1546c extends AbstractC0032d<C1542a> {
        private C1546c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1542a aVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo23a(aVar.f3891a);
            nVar.mo23a(aVar.f3892b);
            nVar.mo23a(aVar.f3893c);
            nVar.mo15a(aVar.f3894d);
            nVar.mo15a(aVar.f3895e);
            nVar.mo15a(aVar.f3896f);
            nVar.mo24a(aVar.f3897g);
            nVar.mo23a(aVar.f3898h);
            nVar.mo23a(aVar.f3899i);
            BitSet bitSet = new BitSet();
            if (aVar.mo8856H()) {
                bitSet.set(0);
            }
            nVar.mo66a(bitSet, 1);
            if (aVar.mo8856H()) {
                nVar.mo15a(aVar.f3900j);
            }
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1542a aVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            aVar.f3891a = nVar.mo54z();
            aVar.mo8863a(true);
            aVar.f3892b = nVar.mo54z();
            aVar.mo8865b(true);
            aVar.f3893c = nVar.mo54z();
            aVar.mo8869c(true);
            aVar.f3894d = nVar.mo51w();
            aVar.mo8873d(true);
            aVar.f3895e = nVar.mo51w();
            aVar.mo8876e(true);
            aVar.f3896f = nVar.mo51w();
            aVar.mo8880f(true);
            aVar.f3897g = nVar.mo11A();
            aVar.mo8882g(true);
            aVar.f3898h = nVar.mo54z();
            aVar.mo8883h(true);
            aVar.f3899i = nVar.mo54z();
            aVar.mo8886i(true);
            if (nVar.mo67b(1).get(0)) {
                aVar.f3900j = nVar.mo51w();
                aVar.mo8888j(true);
            }
        }
    }
}
