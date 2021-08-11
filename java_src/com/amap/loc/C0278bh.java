package com.amap.loc;

/* renamed from: com.amap.loc.bh */
/* compiled from: DownloadManager */
public class C0278bh {

    /* renamed from: a */
    private C0280bi f450a;

    /* renamed from: b */
    private AbstractC0283bk f451b;

    /* renamed from: com.amap.loc.bh$a */
    /* compiled from: DownloadManager */
    public interface AbstractC0279a {
        /* renamed from: a */
        void mo3683a(Throwable th);

        /* renamed from: a */
        void mo3684a(byte[] bArr, long j);

        /* renamed from: b */
        void mo3685b();

        /* renamed from: c */
        void mo3686c();
    }

    public C0278bh(AbstractC0283bk bkVar) {
        this(bkVar, 0, -1);
    }

    public C0278bh(AbstractC0283bk bkVar, long j, long j2) {
        this.f451b = bkVar;
        this.f450a = new C0280bi(this.f451b.f465c, this.f451b.f466d, bkVar.f467e == null ? null : bkVar.f467e);
        this.f450a.mo3764b(j2);
        this.f450a.mo3762a(j);
    }

    /* renamed from: a */
    public void mo3759a(AbstractC0279a aVar) {
        this.f450a.mo3763a(this.f451b.mo3697b(), this.f451b.mo3696a(), this.f451b.mo3698c(), aVar);
    }
}
