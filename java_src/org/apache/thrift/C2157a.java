package org.apache.thrift;

/* renamed from: org.apache.thrift.a */
public class C2157a {

    /* renamed from: a */
    private short[] f6161a;

    /* renamed from: b */
    private int f6162b = -1;

    public C2157a(int i) {
        this.f6161a = new short[i];
    }

    /* renamed from: c */
    private void m8177c() {
        short[] sArr = new short[(this.f6161a.length * 2)];
        System.arraycopy(this.f6161a, 0, sArr, 0, this.f6161a.length);
        this.f6161a = sArr;
    }

    /* renamed from: a */
    public short mo12115a() {
        short[] sArr = this.f6161a;
        int i = this.f6162b;
        this.f6162b = i - 1;
        return sArr[i];
    }

    /* renamed from: a */
    public void mo12116a(short s) {
        if (this.f6161a.length == this.f6162b + 1) {
            m8177c();
        }
        short[] sArr = this.f6161a;
        int i = this.f6162b + 1;
        this.f6162b = i;
        sArr[i] = s;
    }

    /* renamed from: b */
    public void mo12117b() {
        this.f6162b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f6161a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f6162b) {
                sb.append(">>");
            }
            sb.append((int) this.f6161a[i]);
            if (i == this.f6162b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
