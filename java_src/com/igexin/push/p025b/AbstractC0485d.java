package com.igexin.push.p025b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0617f;

/* renamed from: com.igexin.push.b.d */
public abstract class AbstractC0485d extends AbstractC0470d {

    /* renamed from: a */
    private static final String f1192a = C0513j.f1294a;

    /* renamed from: c */
    protected SQLiteDatabase f1193c;

    /* renamed from: d */
    protected Cursor f1194d;

    /* renamed from: e */
    protected ContentValues f1195e;

    /* renamed from: f */
    public C0484c f1196f;

    public AbstractC0485d() {
        super(1);
    }

    public AbstractC0485d(ContentValues contentValues) {
        super(1);
        this.f1195e = contentValues;
    }

    /* renamed from: a */
    public abstract void mo4261a();

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483640;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        this.f1193c = C0617f.m2395a().mo4632k().getWritableDatabase();
        mo4261a();
        if (this.f1196f != null) {
            C0456c.m1661b().mo4218a(this.f1196f);
            C0456c.m1661b().mo4171c();
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
        if (this.f1194d != null && !this.f1194d.isClosed()) {
            try {
                this.f1194d.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
        this.f1125n = true;
        this.f1119I = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }
}
