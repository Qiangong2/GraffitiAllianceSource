package com.igexin.push.extension.distribution.basic.headsup;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.p007v4.app.NotificationCompat;
import android.widget.RemoteViews;
import com.igexin.push.extension.distribution.basic.p042c.EnumC0736b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.headsup.l */
public class C0788l extends NotificationCompat.Builder {

    /* renamed from: a */
    private List<NotificationCompat.Action> f2229a = new ArrayList();

    /* renamed from: b */
    private C0786j f2230b;

    public C0788l(Context context) {
        super(context);
        this.f2230b = new C0786j(context);
    }

    /* access modifiers changed from: public */
    /* renamed from: b */
    private Notification m3283b() {
        super.setSmallIcon(this.f2230b.mo5187j());
        setDefaults(0);
        return build();
    }

    /* renamed from: a */
    public C0786j mo5195a() {
        this.f2230b.mo5166a(build());
        this.f2230b.mo5171a(this.f2229a);
        this.f2230b.m3250a((C0786j) this);
        return this.f2230b;
    }

    /* renamed from: a */
    public C0788l setSmallIcon(int i) {
        this.f2230b.mo5165a(i);
        return this;
    }

    /* renamed from: a */
    public C0788l setLights(int i, int i2, int i3) {
        super.setLights(i, i2, i3);
        return this;
    }

    /* renamed from: a */
    public C0788l setProgress(int i, int i2, boolean z) {
        super.setProgress(i, i2, z);
        return this;
    }

    /* renamed from: a */
    public C0788l addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.f2229a.add(new NotificationCompat.Action(i, charSequence, pendingIntent));
        super.addAction(i, charSequence, pendingIntent);
        return this;
    }

    /* renamed from: a */
    public C0788l setWhen(long j) {
        super.setWhen(j);
        return this;
    }

    /* renamed from: a */
    public C0788l setContentIntent(PendingIntent pendingIntent) {
        super.setContentIntent(pendingIntent);
        return this;
    }

    /* renamed from: a */
    public C0788l setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
        super.setFullScreenIntent(pendingIntent, z);
        return this;
    }

    /* renamed from: a */
    public C0788l setSound(Uri uri) {
        super.setSound(uri);
        return this;
    }

    /* renamed from: a */
    public C0788l setSound(Uri uri, int i) {
        super.setSound(uri, i);
        return this;
    }

    /* renamed from: a */
    public C0788l setStyle(NotificationCompat.Style style) {
        super.setStyle(style);
        return this;
    }

    /* renamed from: a */
    public C0788l setContent(RemoteViews remoteViews) {
        super.setContent(remoteViews);
        return this;
    }

    /* renamed from: a */
    public C0788l setContentTitle(CharSequence charSequence) {
        this.f2230b.mo5169a(charSequence);
        super.setContentTitle(charSequence);
        return this;
    }

    /* renamed from: a */
    public C0788l setTicker(CharSequence charSequence, RemoteViews remoteViews) {
        super.setTicker(charSequence, remoteViews);
        return this;
    }

    /* renamed from: a */
    public C0788l setUsesChronometer(boolean z) {
        this.f2230b.mo5176b(z);
        return this;
    }

    /* renamed from: a */
    public C0788l setVibrate(long[] jArr) {
        super.setVibrate(jArr);
        return this;
    }

    /* renamed from: a */
    public void mo5211a(Bitmap bitmap) {
        this.f2230b.mo5179c(bitmap);
    }

    /* renamed from: a */
    public void mo5212a(EnumC0736b bVar) {
        this.f2230b.mo5168a(bVar);
    }

    /* renamed from: a */
    public void mo5213a(String str) {
        this.f2230b.mo5170a(str);
    }

    /* renamed from: b */
    public C0788l setDefaults(int i) {
        super.setDefaults(i);
        return this;
    }

    /* renamed from: b */
    public C0788l setDeleteIntent(PendingIntent pendingIntent) {
        super.setDeleteIntent(pendingIntent);
        return this;
    }

    /* renamed from: b */
    public C0788l setContentText(CharSequence charSequence) {
        this.f2230b.mo5175b(charSequence);
        super.setContentText(charSequence);
        return this;
    }

    /* renamed from: b */
    public void mo5217b(Bitmap bitmap) {
        this.f2230b.mo5174b(bitmap);
    }

    /* renamed from: b */
    public void mo5218b(boolean z) {
        this.f2230b.mo5172a(z);
    }

    /* renamed from: c */
    public C0788l setNumber(int i) {
        super.setNumber(i);
        return this;
    }

    /* renamed from: c */
    public C0788l setSubText(CharSequence charSequence) {
        super.setSubText(charSequence);
        return this;
    }

    /* renamed from: c */
    public C0788l setAutoCancel(boolean z) {
        super.setAutoCancel(z);
        return this;
    }

    /* renamed from: c */
    public void mo5222c(Bitmap bitmap) {
        this.f2230b.mo5167a(bitmap);
    }

    /* renamed from: d */
    public C0788l setPriority(int i) {
        super.setPriority(i);
        return this;
    }

    /* renamed from: d */
    public C0788l setLargeIcon(Bitmap bitmap) {
        super.setLargeIcon(bitmap);
        return this;
    }

    /* renamed from: d */
    public C0788l setContentInfo(CharSequence charSequence) {
        super.setContentInfo(charSequence);
        return this;
    }

    /* renamed from: d */
    public C0788l setOngoing(boolean z) {
        super.setOngoing(z);
        return this;
    }

    /* renamed from: e */
    public C0788l setTicker(CharSequence charSequence) {
        super.setTicker(charSequence);
        return this;
    }

    /* renamed from: e */
    public C0788l setOnlyAlertOnce(boolean z) {
        super.setOnlyAlertOnce(z);
        return this;
    }
}
