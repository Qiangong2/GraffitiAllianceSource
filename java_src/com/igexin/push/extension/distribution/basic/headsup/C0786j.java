package com.igexin.push.extension.distribution.basic.headsup;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p007v4.app.NotificationCompat;
import android.view.View;
import com.igexin.push.extension.distribution.basic.p042c.EnumC0736b;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.headsup.j */
public class C0786j {

    /* renamed from: a */
    private Context f2209a;

    /* renamed from: b */
    private long f2210b;

    /* renamed from: c */
    private Notification f2211c;

    /* renamed from: d */
    private C0788l f2212d;

    /* renamed from: e */
    private boolean f2213e;

    /* renamed from: f */
    private boolean f2214f;

    /* renamed from: g */
    private long f2215g;

    /* renamed from: h */
    private int f2216h;

    /* renamed from: i */
    private List<NotificationCompat.Action> f2217i;

    /* renamed from: j */
    private CharSequence f2218j;

    /* renamed from: k */
    private CharSequence f2219k;

    /* renamed from: l */
    private int f2220l;

    /* renamed from: m */
    private Bitmap f2221m;

    /* renamed from: n */
    private View f2222n;

    /* renamed from: o */
    private boolean f2223o;

    /* renamed from: p */
    private boolean f2224p;

    /* renamed from: q */
    private EnumC0736b f2225q;

    /* renamed from: r */
    private Bitmap f2226r;

    /* renamed from: s */
    private String f2227s;

    /* renamed from: t */
    private Bitmap f2228t;

    private C0786j(Context context) {
        this.f2210b = 5;
        this.f2213e = false;
        this.f2214f = true;
        this.f2215g = 600;
        this.f2209a = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3250a(C0788l lVar) {
        this.f2212d = lVar;
    }

    /* renamed from: a */
    public Bitmap mo5164a() {
        return this.f2221m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5165a(int i) {
        this.f2220l = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5166a(Notification notification) {
        this.f2211c = notification;
    }

    /* renamed from: a */
    public void mo5167a(Bitmap bitmap) {
        this.f2221m = bitmap;
    }

    /* renamed from: a */
    public void mo5168a(EnumC0736b bVar) {
        this.f2225q = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5169a(CharSequence charSequence) {
        this.f2218j = charSequence;
    }

    /* renamed from: a */
    public void mo5170a(String str) {
        this.f2227s = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5171a(List<NotificationCompat.Action> list) {
        this.f2217i = list;
    }

    /* renamed from: a */
    public void mo5172a(boolean z) {
        this.f2224p = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5173b(int i) {
        this.f2216h = i;
    }

    /* renamed from: b */
    public void mo5174b(Bitmap bitmap) {
        this.f2226r = bitmap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5175b(CharSequence charSequence) {
        this.f2219k = charSequence;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5176b(boolean z) {
        this.f2223o = z;
    }

    /* renamed from: b */
    public boolean mo5177b() {
        return this.f2224p;
    }

    /* renamed from: c */
    public EnumC0736b mo5178c() {
        return this.f2225q;
    }

    /* renamed from: c */
    public void mo5179c(Bitmap bitmap) {
        this.f2228t = bitmap;
    }

    /* renamed from: c */
    public void mo5180c(boolean z) {
        this.f2213e = z;
    }

    /* renamed from: d */
    public Bitmap mo5181d() {
        return this.f2226r;
    }

    /* renamed from: e */
    public String mo5182e() {
        return this.f2227s;
    }

    /* renamed from: f */
    public Bitmap mo5183f() {
        return this.f2228t;
    }

    /* renamed from: g */
    public long mo5184g() {
        return this.f2210b;
    }

    /* renamed from: h */
    public CharSequence mo5185h() {
        return this.f2218j;
    }

    /* renamed from: i */
    public CharSequence mo5186i() {
        return this.f2219k;
    }

    /* renamed from: j */
    public int mo5187j() {
        return this.f2220l;
    }

    /* renamed from: k */
    public Notification mo5188k() {
        return this.f2211c;
    }

    /* renamed from: l */
    public View mo5189l() {
        return this.f2222n;
    }

    /* renamed from: m */
    public int mo5190m() {
        return this.f2216h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public Notification mo5191n() {
        return C0788l.m3282a(mo5192o());
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C0788l mo5192o() {
        return this.f2212d;
    }

    /* renamed from: p */
    public boolean mo5193p() {
        return this.f2213e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo5194q() {
        return this.f2214f;
    }
}
