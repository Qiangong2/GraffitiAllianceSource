package com.igexin.p010a;

import android.content.Context;
import android.util.Log;
import com.igexin.p010a.p011a.C0412j;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.igexin.a.h */
public class C0423h {

    /* renamed from: a */
    protected final Set<String> f1003a;

    /* renamed from: b */
    protected final AbstractC0420e f1004b;

    /* renamed from: c */
    protected final AbstractC0419d f1005c;

    /* renamed from: d */
    protected boolean f1006d;

    /* renamed from: e */
    protected boolean f1007e;

    /* renamed from: f */
    protected AbstractC0422g f1008f;

    protected C0423h() {
        this(new C0425j(), new C0402a());
    }

    protected C0423h(AbstractC0420e eVar, AbstractC0419d dVar) {
        this.f1003a = new HashSet();
        if (eVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (dVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        } else {
            this.f1004b = eVar;
            this.f1005c = dVar;
        }
    }

    /* renamed from: c */
    private void m1533c(Context context, String str, String str2) {
        if (!this.f1003a.contains(str) || this.f1006d) {
            try {
                this.f1004b.mo4075a(str);
                this.f1003a.add(str);
                mo4090a("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e) {
                mo4090a("Loading the library normally failed: %s", Log.getStackTraceString(e));
                mo4090a("%s (%s) was not loaded normally, re-linking...", str, str2);
                File a = mo4086a(context, str, str2);
                if (!a.exists() || this.f1006d) {
                    if (this.f1006d) {
                        mo4090a("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    mo4092b(context, str, str2);
                    this.f1005c.mo4062a(context, this.f1004b.mo4076a(), this.f1004b.mo4078c(str), a, this);
                }
                try {
                    if (this.f1007e) {
                        for (String str3 : new C0412j(a).mo4070b()) {
                            mo4087a(context, this.f1004b.mo4079d(str3));
                        }
                    }
                } catch (IOException e2) {
                }
                this.f1004b.mo4077b(a.getAbsolutePath());
                this.f1003a.add(str);
                mo4090a("%s (%s) was re-linked!", str, str2);
            }
        } else {
            mo4090a("%s already loaded previously!", str);
        }
    }

    /* renamed from: a */
    public C0423h mo4083a() {
        this.f1006d = true;
        return this;
    }

    /* renamed from: a */
    public C0423h mo4084a(AbstractC0422g gVar) {
        this.f1008f = gVar;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo4085a(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo4086a(Context context, String str, String str2) {
        String c = this.f1004b.mo4078c(str);
        return C0426k.m1549a(str2) ? new File(mo4085a(context), c) : new File(mo4085a(context), c + "." + str2);
    }

    /* renamed from: a */
    public void mo4087a(Context context, String str) {
        mo4088a(context, str, null, null);
    }

    /* renamed from: a */
    public void mo4088a(Context context, String str, String str2, AbstractC0421f fVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (C0426k.m1549a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            mo4090a("Beginning load of %s...", str);
            if (fVar == null) {
                m1533c(context, str, str2);
                return;
            }
            try {
                m1533c(context, str, str2);
                fVar.mo4080a();
            } catch (UnsatisfiedLinkError e) {
                fVar.mo4081a(e);
            }
        }
    }

    /* renamed from: a */
    public void mo4089a(String str) {
        if (this.f1008f != null) {
            this.f1008f.mo4082a(str);
        }
    }

    /* renamed from: a */
    public void mo4090a(String str, Object... objArr) {
        mo4089a(String.format(Locale.US, str, objArr));
    }

    /* renamed from: b */
    public C0423h mo4091b() {
        this.f1007e = true;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4092b(Context context, String str, String str2) {
        File a = mo4085a(context);
        File a2 = mo4086a(context, str, str2);
        File[] listFiles = a.listFiles(new C0424i(this, this.f1004b.mo4078c(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f1006d || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
