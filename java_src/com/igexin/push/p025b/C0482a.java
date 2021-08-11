package com.igexin.push.p025b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.p029b.AbstractC0555a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.igexin.push.b.a */
public class C0482a extends AbstractC0470d {

    /* renamed from: e */
    private static final String f1185e = C0482a.class.getName();

    /* renamed from: a */
    protected SQLiteDatabase f1186a;

    /* renamed from: b */
    protected Cursor f1187b;

    /* renamed from: c */
    List<AbstractC0555a> f1188c = new LinkedList();

    /* renamed from: d */
    boolean f1189d;

    public C0482a() {
        super(1);
    }

    /* renamed from: a */
    public void mo4252a(AbstractC0555a aVar) {
        this.f1188c.add(aVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483639;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        this.f1186a = C0617f.m2395a().mo4632k().getWritableDatabase();
        this.f1186a.setVersion(3);
        for (AbstractC0555a aVar : this.f1188c) {
            aVar.mo4339a(this.f1186a);
        }
        for (AbstractC0555a aVar2 : this.f1188c) {
            if (this.f1189d) {
                aVar2.mo4345c(this.f1186a);
            } else {
                aVar2.mo4342b(this.f1186a);
            }
        }
        C0456c.m1661b().mo4218a(new C0484c(-980948));
        C0456c.m1661b().mo4171c();
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
        if (this.f1187b != null) {
            try {
                this.f1187b.close();
            } catch (Exception e) {
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
        super.mo4126d();
        this.f1125n = true;
        this.f1119I = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }
}
