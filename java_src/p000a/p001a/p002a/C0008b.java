package p000a.p001a.p002a;

/* renamed from: a.a.a.b */
/* compiled from: ShortStack */
public class C0008b {

    /* renamed from: a */
    private short[] f14a;

    /* renamed from: b */
    private int f15b = -1;

    public C0008b(int i) {
        this.f14a = new short[i];
    }

    /* renamed from: a */
    public short mo6a() {
        short[] sArr = this.f14a;
        int i = this.f15b;
        this.f15b = i - 1;
        return sArr[i];
    }

    /* renamed from: a */
    public void mo7a(short s) {
        if (this.f14a.length == this.f15b + 1) {
            m23d();
        }
        short[] sArr = this.f14a;
        int i = this.f15b + 1;
        this.f15b = i;
        sArr[i] = s;
    }

    /* renamed from: d */
    private void m23d() {
        short[] sArr = new short[(this.f14a.length * 2)];
        System.arraycopy(this.f14a, 0, sArr, 0, this.f14a.length);
        this.f14a = sArr;
    }

    /* renamed from: b */
    public short mo8b() {
        return this.f14a[this.f15b];
    }

    /* renamed from: c */
    public void mo9c() {
        this.f15b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f14a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f15b) {
                sb.append(">>");
            }
            sb.append((int) this.f14a[i]);
            if (i == this.f15b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
