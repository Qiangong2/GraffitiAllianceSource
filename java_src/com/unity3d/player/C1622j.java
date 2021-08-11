package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.p007v4.view.ViewCompat;
import android.view.View;

/* renamed from: com.unity3d.player.j */
public final class C1622j extends View {

    /* renamed from: a */
    final int f4153a;

    /* renamed from: b */
    final int f4154b = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());

    /* renamed from: c */
    Bitmap f4155c;

    /* renamed from: d */
    Bitmap f4156d;

    /* renamed from: com.unity3d.player.j$1 */
    static /* synthetic */ class C16231 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4157a = new int[EnumC1624a.m6133a().length];

        static {
            try {
                f4157a[EnumC1624a.f4158a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4157a[EnumC1624a.f4159b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4157a[EnumC1624a.f4160c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    /* renamed from: com.unity3d.player.j$a */
    public static final class EnumC1624a extends Enum {

        /* renamed from: a */
        public static final int f4158a = 1;

        /* renamed from: b */
        public static final int f4159b = 2;

        /* renamed from: c */
        public static final int f4160c = 3;

        /* renamed from: d */
        private static final /* synthetic */ int[] f4161d = {f4158a, f4159b, f4160c};

        /* renamed from: a */
        public static int[] m6133a() {
            return (int[]) f4161d.clone();
        }
    }

    public C1622j(Context context, int i) {
        super(context);
        this.f4153a = i;
        if (this.f4154b != 0) {
            forceLayout();
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4155c != null) {
            this.f4155c.recycle();
            this.f4155c = null;
        }
        if (this.f4156d != null) {
            this.f4156d.recycle();
            this.f4156d = null;
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (this.f4154b != 0) {
            if (this.f4155c == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                this.f4155c = BitmapFactory.decodeResource(getResources(), this.f4154b, options);
            }
            int width = this.f4155c.getWidth();
            int height = this.f4155c.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            if (width2 != 0 && height2 != 0) {
                float f = ((float) width) / ((float) height);
                boolean z2 = ((float) width2) / ((float) height2) <= f;
                switch (C16231.f4157a[this.f4153a - 1]) {
                    case 1:
                        if (width2 < width) {
                            i5 = (int) (((float) width2) / f);
                            i7 = width2;
                        } else {
                            i5 = height;
                            i7 = width;
                        }
                        if (height2 >= i5) {
                            i6 = i7;
                            break;
                        } else {
                            i5 = height2;
                            i6 = (int) (((float) i5) * f);
                            break;
                        }
                    case 2:
                    case 3:
                        if (!(z2 ^ (this.f4153a == EnumC1624a.f4160c))) {
                            i5 = height2;
                            i6 = (int) (((float) i5) * f);
                            break;
                        } else {
                            i5 = (int) (((float) width2) / f);
                            i6 = width2;
                            break;
                        }
                    default:
                        i5 = height;
                        i6 = width;
                        break;
                }
                if (this.f4156d != null) {
                    if (this.f4156d.getWidth() != i6 || this.f4156d.getHeight() != i5) {
                        if (this.f4156d != this.f4155c) {
                            this.f4156d.recycle();
                            this.f4156d = null;
                        }
                    } else {
                        return;
                    }
                }
                this.f4156d = Bitmap.createScaledBitmap(this.f4155c, i6, i5, true);
                this.f4156d.setDensity(getResources().getDisplayMetrics().densityDpi);
                ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.f4156d);
                bitmapDrawable.setGravity(17);
                setBackground(new LayerDrawable(new Drawable[]{colorDrawable, bitmapDrawable}));
            }
        }
    }
}
