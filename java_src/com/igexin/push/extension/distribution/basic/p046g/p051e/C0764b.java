package com.igexin.push.extension.distribution.basic.p046g.p051e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import java.lang.reflect.Constructor;

/* renamed from: com.igexin.push.extension.distribution.basic.g.e.b */
public class C0764b implements AbstractC0763a {

    /* renamed from: a */
    private AbstractC0763a f2124a = null;

    public C0764b(Context context) {
        if (m3122a(context)) {
            this.f2124a = new C0766d(context);
        } else if (Build.VERSION.SDK_INT >= 14) {
            this.f2124a = new C0765c(context);
        }
    }

    /* renamed from: a */
    public static boolean m3122a(Context context) {
        try {
            Class<?> cls = Class.forName("android.support.v4.app.NotificationCompat$Builder");
            Constructor<?> constructor = cls.getConstructor(Context.class);
            cls.getMethod("setProgress", Integer.TYPE, Integer.TYPE, Boolean.TYPE).invoke(constructor.newInstance(context), 100, 0, false);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public Notification mo5099a() {
        return this.f2124a.mo5099a();
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5100a(int i) {
        this.f2124a.mo5100a(i);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5101a(int i, int i2, boolean z) {
        this.f2124a.mo5101a(i, i2, z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5102a(PendingIntent pendingIntent) {
        this.f2124a.mo5102a(pendingIntent);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5103a(Bitmap bitmap) {
        this.f2124a.mo5103a(bitmap);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5104a(CharSequence charSequence) {
        this.f2124a.mo5104a(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5105a(boolean z) {
        this.f2124a.mo5105a(z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: b */
    public AbstractC0763a mo5106b(CharSequence charSequence) {
        this.f2124a.mo5106b(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: c */
    public AbstractC0763a mo5107c(CharSequence charSequence) {
        this.f2124a.mo5107c(charSequence);
        return this;
    }
}
