package com.igexin.push.extension.distribution.basic.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.basic.util.o */
public class C1009o {

    /* renamed from: a */
    private static final String f2553a = C1009o.class.getName();

    /* renamed from: h */
    private static long f2554h;

    /* renamed from: k */
    private static C1009o f2555k;

    /* renamed from: m */
    private static int[] f2556m = {16842904};

    /* renamed from: b */
    private Integer f2557b = null;

    /* renamed from: c */
    private float f2558c = 0.0f;

    /* renamed from: d */
    private Integer f2559d = null;

    /* renamed from: e */
    private float f2560e = 0.0f;

    /* renamed from: f */
    private Integer f2561f = null;

    /* renamed from: g */
    private float f2562g = 0.0f;

    /* renamed from: i */
    private SimpleDateFormat f2563i = new SimpleDateFormat("HH:mm", Locale.getDefault());

    /* renamed from: j */
    private Context f2564j;

    /* renamed from: l */
    private DisplayMetrics f2565l;

    private C1009o(Context context) {
        this.f2564j = context;
        this.f2565l = new DisplayMetrics();
        ((WindowManager) this.f2564j.getSystemService("window")).getDefaultDisplay().getMetrics(this.f2565l);
        m4056k();
    }

    /* renamed from: a */
    public static C1009o m4050a(Context context) {
        if (f2555k == null) {
            f2555k = new C1009o(context.getApplicationContext());
        }
        return f2555k;
    }

    /* renamed from: a */
    private boolean m4051a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) instanceof TextView) {
                TextView textView = (TextView) viewGroup.getChildAt(i);
                String charSequence = textView.getText().toString();
                if ("SOME_SAMPLE_TEXT".equals(charSequence)) {
                    this.f2557b = Integer.valueOf(textView.getCurrentTextColor());
                    this.f2558c = textView.getTextSize();
                } else if ("SOME_SAMPLE_CONTENT".equals(charSequence)) {
                    this.f2559d = Integer.valueOf(textView.getCurrentTextColor());
                    this.f2560e = textView.getTextSize();
                } else if (this.f2563i.format(Long.valueOf(f2554h)).equals(charSequence)) {
                    this.f2561f = Integer.valueOf(textView.getCurrentTextColor());
                    this.f2562g = textView.getTextSize();
                }
            } else if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                m4051a((ViewGroup) viewGroup.getChildAt(i));
            }
        }
        return false;
    }

    /* renamed from: g */
    private int m4052g() {
        int rgb = Color.rgb(255, 255, 255);
        try {
            TypedArray obtainStyledAttributes = C0618g.f1635f.obtainStyledAttributes(16973928, f2556m);
            rgb = obtainStyledAttributes.getColor(0, Color.rgb(255, 255, 255));
            obtainStyledAttributes.recycle();
            return rgb;
        } catch (Exception e) {
            return rgb;
        }
    }

    /* renamed from: h */
    private int m4053h() {
        int rgb = Color.rgb(255, 255, 255);
        try {
            TypedArray obtainStyledAttributes = C0618g.f1635f.obtainStyledAttributes(16973927, f2556m);
            rgb = obtainStyledAttributes.getColor(0, Color.rgb(255, 255, 255));
            obtainStyledAttributes.recycle();
            return rgb;
        } catch (Exception e) {
            return rgb;
        }
    }

    /* renamed from: i */
    private int m4054i() {
        int g = m4052g();
        return (!C0999e.m4016a() || !C0999e.m4017b()) ? g : Color.rgb(32, 32, 32);
    }

    /* renamed from: j */
    private int m4055j() {
        int h = m4053h();
        return (!C0999e.m4016a() || !C0999e.m4017b()) ? h : Color.rgb(153, 153, 153);
    }

    /* renamed from: k */
    private void m4056k() {
        Notification notification;
        try {
            f2554h = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT < 11) {
                notification = new Notification();
                try {
                    Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class);
                    method.setAccessible(true);
                    method.invoke(notification, C0618g.f1635f, "SOME_SAMPLE_TEXT", "SOME_SAMPLE_CONTENT", null);
                } catch (Exception e) {
                    ActivityC0460a.m1698b(f2553a + "reflect invoke setLatestEventInfo failed!");
                    return;
                }
            } else {
                notification = new Notification.Builder(C0618g.f1635f).setContentTitle("SOME_SAMPLE_TEXT").setContentText("SOME_SAMPLE_CONTENT").getNotification();
            }
            notification.when = f2554h;
            LinearLayout linearLayout = new LinearLayout(this.f2564j);
            m4051a((ViewGroup) notification.contentView.apply(this.f2564j, linearLayout));
            linearLayout.removeAllViews();
        } catch (Exception e2) {
            ActivityC0460a.m1698b(f2553a + "extractNotification info exception: " + e2.toString());
        }
    }

    /* renamed from: a */
    public int mo5652a() {
        if (this.f2557b == null) {
            this.f2557b = Integer.valueOf(m4054i());
        }
        if (C0997c.m4005c() < 21 && Build.VERSION.SDK_INT >= 21) {
            this.f2557b = Integer.valueOf(m4052g());
        }
        return this.f2557b.intValue();
    }

    /* renamed from: b */
    public int mo5653b() {
        if (this.f2559d == null) {
            this.f2559d = Integer.valueOf(m4055j());
        }
        if (C0997c.m4005c() < 21 && Build.VERSION.SDK_INT >= 21) {
            this.f2559d = Integer.valueOf(m4053h());
        }
        return this.f2559d.intValue();
    }

    /* renamed from: c */
    public int mo5654c() {
        if (this.f2561f == null) {
            this.f2561f = Integer.valueOf(m4055j());
        }
        if (C0997c.m4005c() < 21 && Build.VERSION.SDK_INT >= 21) {
            this.f2561f = Integer.valueOf(m4053h());
        }
        return this.f2561f.intValue();
    }

    /* renamed from: d */
    public float mo5655d() {
        if (this.f2558c == 0.0f) {
            this.f2558c = TypedValue.applyDimension(1, 16.0f, this.f2565l);
        }
        return this.f2558c;
    }

    /* renamed from: e */
    public float mo5656e() {
        if (this.f2560e == 0.0f) {
            this.f2560e = TypedValue.applyDimension(1, 14.0f, this.f2565l);
        }
        return this.f2560e;
    }

    /* renamed from: f */
    public float mo5657f() {
        if (this.f2562g == 0.0f) {
            this.f2562g = TypedValue.applyDimension(1, 12.0f, this.f2565l);
        }
        return this.f2562g;
    }
}
