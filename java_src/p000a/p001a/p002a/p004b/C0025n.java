package p000a.p001a.p002a.p004b;

import java.util.BitSet;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0032d;
import p000a.p001a.p002a.p006d.AbstractC0036c;

/* renamed from: a.a.a.b.n */
/* compiled from: TTupleProtocol */
public final class C0025n extends C0011b {

    /* renamed from: a.a.a.b.n$a */
    /* compiled from: TTupleProtocol */
    public static class C0026a implements AbstractC0021j {
        @Override // p000a.p001a.p002a.p004b.AbstractC0021j
        /* renamed from: a */
        public AbstractC0019h mo55a(AbstractC0036c cVar) {
            return new C0025n(cVar);
        }
    }

    public C0025n(AbstractC0036c cVar) {
        super(cVar);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: D */
    public Class<? extends AbstractC0029a> mo64D() {
        return AbstractC0032d.class;
    }

    /* renamed from: a */
    public void mo66a(BitSet bitSet, int i) throws C0046j {
        for (byte b : m190b(bitSet, i)) {
            mo13a(b);
        }
    }

    /* renamed from: b */
    public BitSet mo67b(int i) throws C0046j {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo49u();
        }
        return m189a(bArr);
    }

    /* renamed from: a */
    public static BitSet m189a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m190b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) (bArr[length] | (1 << (i2 % 8)));
            }
        }
        return bArr;
    }
}
