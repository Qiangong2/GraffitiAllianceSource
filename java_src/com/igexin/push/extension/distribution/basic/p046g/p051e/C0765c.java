package com.igexin.push.extension.distribution.basic.p046g.p051e;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;

@TargetApi(14)
/* renamed from: com.igexin.push.extension.distribution.basic.g.e.c */
public class C0765c implements AbstractC0763a {

    /* renamed from: a */
    private Notification.Builder f2125a = null;

    public C0765c(Context context) {
        this.f2125a = new Notification.Builder(context);
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public Notification mo5099a() {
        return this.f2125a.getNotification();
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5100a(int i) {
        this.f2125a.setSmallIcon(i);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5101a(int i, int i2, boolean z) {
        this.f2125a.setProgress(i, i2, z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5102a(PendingIntent pendingIntent) {
        this.f2125a.setContentIntent(pendingIntent);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5103a(Bitmap bitmap) {
        this.f2125a.setLargeIcon(bitmap);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5104a(CharSequence charSequence) {
        this.f2125a.setContentTitle(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5105a(boolean z) {
        this.f2125a.setAutoCancel(z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: b */
    public AbstractC0763a mo5106b(CharSequence charSequence) {
        this.f2125a.setContentText(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: c */
    public AbstractC0763a mo5107c(CharSequence charSequence) {
        this.f2125a.setTicker(charSequence);
        return this;
    }
}
