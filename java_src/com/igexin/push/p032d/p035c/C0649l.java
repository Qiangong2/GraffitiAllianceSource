package com.igexin.push.p032d.p035c;

/* renamed from: com.igexin.push.d.c.l */
public class C0649l extends AbstractC0642e {

    /* renamed from: a */
    public byte f1758a;

    /* renamed from: b */
    public Object f1759b;

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bytes = this.f1758a == 1 ? ((String) this.f1759b).getBytes() : this.f1758a == 2 ? ((String) this.f1759b).getBytes() : this.f1758a == 3 ? null : this.f1758a == 4 ? ((String) this.f1759b).getBytes() : null;
        if (bytes == null) {
            return null;
        }
        byte[] bArr = new byte[(bytes.length + 2)];
        bArr[0] = this.f1758a;
        bArr[1] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 2, bytes.length);
        return bArr;
    }
}
