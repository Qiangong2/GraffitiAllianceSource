package com.igexin.push.extension.distribution.basic.p060k;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import java.io.IOException;

/* renamed from: com.igexin.push.extension.distribution.basic.k.l */
public class C0992l {

    /* renamed from: b */
    private static C0992l f2532b;

    /* renamed from: a */
    private Context f2533a;

    /* renamed from: c */
    private AssetManager f2534c;

    /* renamed from: d */
    private int f2535d;

    /* renamed from: e */
    private int f2536e;

    private C0992l(Context context) {
        this.f2533a = context;
        m3983a();
    }

    /* renamed from: a */
    public static C0992l m3982a(Context context) {
        if (f2532b == null) {
            f2532b = new C0992l(context);
        }
        return f2532b;
    }

    /* renamed from: a */
    private void m3983a() {
        this.f2534c = this.f2533a.getAssets();
        new DisplayMetrics();
        DisplayMetrics displayMetrics = this.f2533a.getResources().getDisplayMetrics();
        this.f2535d = displayMetrics.widthPixels;
        this.f2536e = displayMetrics.heightPixels;
    }

    /* renamed from: a */
    public int mo5638a(String str, String str2) {
        return this.f2533a.getResources().getIdentifier(str, str2, this.f2533a.getApplicationInfo().packageName);
    }

    /* renamed from: a */
    public NinePatchDrawable mo5639a(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(this.f2534c.open(str));
            byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(this.f2533a.getResources(), decodeStream, ninePatchChunk, C0981a.m3940a(ninePatchChunk).f2509a, null);
            }
        } catch (IOException e) {
        }
        return null;
    }

    /* renamed from: b */
    public Drawable mo5640b(String str) {
        try {
            return Drawable.createFromStream(this.f2534c.open(str), null);
        } catch (IOException e) {
            return null;
        }
    }
}
