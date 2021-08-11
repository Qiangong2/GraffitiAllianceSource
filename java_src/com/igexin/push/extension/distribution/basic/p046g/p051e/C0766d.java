package com.igexin.push.extension.distribution.basic.p046g.p051e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p007v4.app.NotificationCompat;

/* renamed from: com.igexin.push.extension.distribution.basic.g.e.d */
public class C0766d implements AbstractC0763a {

    /* renamed from: a */
    private NotificationCompat.Builder f2126a = null;

    public C0766d(Context context) {
        this.f2126a = new NotificationCompat.Builder(context);
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public Notification mo5099a() {
        return this.f2126a.getNotification();
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5100a(int i) {
        this.f2126a.setSmallIcon(i);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5101a(int i, int i2, boolean z) {
        this.f2126a.setProgress(i, i2, z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5102a(PendingIntent pendingIntent) {
        this.f2126a.setContentIntent(pendingIntent);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5103a(Bitmap bitmap) {
        this.f2126a.setLargeIcon(bitmap);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5104a(CharSequence charSequence) {
        this.f2126a.setContentTitle(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: a */
    public AbstractC0763a mo5105a(boolean z) {
        this.f2126a.setAutoCancel(z);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: b */
    public AbstractC0763a mo5106b(CharSequence charSequence) {
        this.f2126a.setContentText(charSequence);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p051e.AbstractC0763a
    /* renamed from: c */
    public AbstractC0763a mo5107c(CharSequence charSequence) {
        this.f2126a.setTicker(charSequence);
        return this;
    }
}
