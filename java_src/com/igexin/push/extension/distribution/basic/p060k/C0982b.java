package com.igexin.push.extension.distribution.basic.p060k;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p031d.AbstractC0614a;
import com.igexin.push.extension.distribution.basic.p041b.C0726n;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* renamed from: com.igexin.push.extension.distribution.basic.k.b */
public class C0982b extends AbstractC0614a {

    /* renamed from: d */
    private PushTaskBean f2513d;

    /* renamed from: e */
    private C0726n f2514e;

    /* renamed from: f */
    private Dialog f2515f;

    /* renamed from: g */
    private String f2516g;

    /* renamed from: h */
    private String f2517h;

    /* renamed from: i */
    private boolean f2518i = true;

    /* renamed from: j */
    private float f2519j;

    /* renamed from: k */
    private float f2520k;

    public C0982b(PushTaskBean pushTaskBean, C0726n nVar) {
        this.f2513d = pushTaskBean;
        this.f2514e = nVar;
        mo4599a((Long) 11111111L);
        mo4600a(pushTaskBean.getTaskId());
    }

    /* renamed from: a */
    private int m3943a(int i) {
        return (int) ((((float) i) * this.f2519j) + 0.5f);
    }

    /* renamed from: b */
    private String m3947b(String str) {
        return str.length() > 256 ? str.substring(0, 254) + "..." : str;
    }

    /* renamed from: c */
    private String m3949c(String str) {
        return str.length() > 20 ? str.substring(0, 18) + "..." : str;
    }

    /* renamed from: j */
    private void m3956j() {
        FileInputStream fileInputStream;
        boolean z;
        try {
            if (this.f2515f == null) {
                String a = this.f2514e.mo4949a();
                String b = this.f2514e.mo4954b();
                String f = this.f2514e.mo4964f();
                String g = this.f2514e.mo4966g();
                this.f2516g = this.f2513d.getTaskId();
                this.f2517h = this.f2513d.getMessageId();
                C0992l a2 = C0992l.m3982a(C0744j.f2042a);
                Drawable a3 = a2.mo5639a("getui_popup_bg.9.png");
                Drawable b2 = a2.mo5640b("getui_popup_close.png");
                if (a3 == null || b2 == null) {
                    AlertDialog.Builder message = new AlertDialog.Builder(this.f1556b).setTitle(a).setMessage(m3947b(b));
                    if (f != null) {
                        ImageView imageView = new ImageView(this.f1556b);
                        Bitmap bitmap = null;
                        try {
                            fileInputStream = new FileInputStream(f);
                        } catch (FileNotFoundException e) {
                            fileInputStream = null;
                        }
                        if (fileInputStream != null) {
                            bitmap = BitmapFactory.decodeStream(fileInputStream);
                        }
                        if (bitmap != null) {
                            int width = bitmap.getWidth();
                            float f2 = 0.0f;
                            double height = ((((double) C0744j.f2043b) / 800.0d) * 350.0d) / ((double) bitmap.getHeight());
                            double d = ((((double) C0744j.f2044c) / 480.0d) * 350.0d) / ((double) width);
                            if (height >= 1.0d && d >= 1.0d) {
                                f2 = 1.0f;
                            } else if (height >= 1.0d && d < 1.0d) {
                                f2 = (float) d;
                            } else if (height < 1.0d && d >= 1.0d) {
                                f2 = (float) height;
                            } else if (height < 1.0d && d < 1.0d) {
                                f2 = height > d ? (float) d : (float) height;
                            }
                            Matrix matrix = new Matrix();
                            matrix.postScale(f2, f2);
                            imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
                            imageView.setMaxHeight(0);
                            imageView.setMinimumHeight(0);
                            message.setView(imageView);
                        }
                    }
                    if (this.f2514e.mo4958c() != null) {
                        if (this.f2514e.mo4958c().size() >= 1) {
                            message.setPositiveButton(m3949c(this.f2514e.mo4958c().get(0).mo4831a()), new DialogInterface$OnClickListenerC0983c(this));
                        }
                        if (this.f2514e.mo4958c().size() >= 2) {
                            message.setNeutralButton(m3949c(this.f2514e.mo4958c().get(1).mo4831a()), new DialogInterface$OnClickListenerC0984d(this));
                        }
                        if (this.f2514e.mo4958c().size() >= 3) {
                            message.setNegativeButton(m3949c(this.f2514e.mo4958c().get(2).mo4831a()), new DialogInterface$OnClickListenerC0985e(this));
                        }
                    }
                    this.f2515f = message.create();
                    this.f2515f.show();
                    this.f2515f.setCanceledOnTouchOutside(true);
                    this.f2515f.setOnDismissListener(new DialogInterface$OnDismissListenerC0986f(this));
                    return;
                }
                LinearLayout linearLayout = new LinearLayout(this.f1556b);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setGravity(17);
                linearLayout.setBackgroundColor(0);
                linearLayout.setOrientation(1);
                LinearLayout linearLayout2 = new LinearLayout(this.f1556b);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(m3943a(320), -2));
                linearLayout2.setOrientation(1);
                linearLayout2.setBackgroundDrawable(a3);
                LinearLayout linearLayout3 = new LinearLayout(this.f1556b);
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout3.setOrientation(1);
                LinearLayout linearLayout4 = new LinearLayout(this.f1556b);
                linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, m3943a(100)));
                LinearLayout linearLayout5 = new LinearLayout(this.f1556b);
                linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout5.setOrientation(0);
                linearLayout5.setPadding(m3943a(10), m3943a(10), 0, m3943a(10));
                linearLayout5.setGravity(16);
                TextView textView = new TextView(this.f1556b);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.weight = 9.0f;
                textView.setLayoutParams(layoutParams);
                textView.setSingleLine();
                textView.setTextColor(Color.parseColor("#4D4D4D"));
                textView.setTextSize((float) mo5629a((float) m3943a(18)));
                textView.setText(a);
                ImageView imageView2 = new ImageView(this.f1556b);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m3943a(12), m3943a(12));
                layoutParams2.gravity = 21;
                layoutParams2.weight = 1.0f;
                imageView2.setLayoutParams(layoutParams2);
                imageView2.setImageDrawable(b2);
                imageView2.setOnClickListener(new View$OnClickListenerC0987g(this));
                linearLayout5.addView(textView);
                linearLayout5.addView(imageView2);
                LinearLayout linearLayout6 = new LinearLayout(this.f1556b);
                linearLayout6.setOrientation(0);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, m3943a(1));
                layoutParams3.setMargins(0, 0, 0, m3943a(5));
                linearLayout6.setLayoutParams(layoutParams3);
                linearLayout6.setBackgroundColor(Color.parseColor("#2498F3"));
                linearLayout3.addView(linearLayout5);
                linearLayout3.addView(linearLayout6);
                boolean z2 = false;
                if (g == null || this.f1556b.getResources().getConfiguration().orientation != 1) {
                    z = false;
                } else {
                    Bitmap bitmap2 = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(g);
                        if (fileInputStream2 != null) {
                            bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                        }
                        if (bitmap2 != null) {
                            ImageView imageView3 = new ImageView(this.f1556b);
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, m3943a(100));
                            layoutParams4.setMargins(m3943a(10), 0, m3943a(10), 0);
                            imageView3.setLayoutParams(layoutParams4);
                            imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageView3.setImageBitmap(bitmap2);
                            linearLayout4.addView(imageView3);
                            z2 = true;
                        }
                        z = z2;
                    } catch (FileNotFoundException e2) {
                        z = false;
                    }
                }
                LinearLayout linearLayout7 = new LinearLayout(this.f1556b);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams5.setMargins(m3943a(10), m3943a(5), m3943a(10), m3943a(10));
                layoutParams5.weight = 6.0f;
                linearLayout7.setLayoutParams(layoutParams5);
                linearLayout7.setOrientation(0);
                linearLayout7.setGravity(16);
                if (f != null) {
                    Bitmap bitmap3 = null;
                    try {
                        FileInputStream fileInputStream3 = new FileInputStream(f);
                        if (fileInputStream3 != null) {
                            bitmap3 = BitmapFactory.decodeStream(fileInputStream3);
                        }
                        if (bitmap3 != null) {
                            ImageView imageView4 = new ImageView(this.f1556b);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(m3943a(72), m3943a(72));
                            layoutParams6.gravity = 48;
                            imageView4.setLayoutParams(layoutParams6);
                            imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageView4.setImageBitmap(bitmap3);
                            linearLayout7.addView(imageView4);
                        }
                    } catch (FileNotFoundException e3) {
                    }
                }
                ScrollView scrollView = new ScrollView(this.f1556b);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams7.setMargins(m3943a(10), 0, 0, 0);
                scrollView.setLayoutParams(layoutParams7);
                LinearLayout linearLayout8 = new LinearLayout(this.f1556b);
                linearLayout8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout8.setOrientation(1);
                TextView textView2 = new TextView(this.f1556b);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView2.setTextColor(Color.parseColor("#666666"));
                textView2.setText(b);
                textView2.setTextSize((float) mo5629a((float) m3943a(14)));
                linearLayout8.addView(textView2);
                scrollView.addView(linearLayout8);
                linearLayout7.addView(scrollView);
                linearLayout2.addView(linearLayout3);
                if (z) {
                    linearLayout2.addView(linearLayout4);
                }
                linearLayout2.addView(linearLayout7);
                if (this.f2514e.mo4958c() != null && this.f2514e.mo4958c().size() >= 1) {
                    TextView textView3 = new TextView(this.f1556b);
                    LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, m3943a(40));
                    layoutParams8.gravity = 1;
                    layoutParams8.weight = 1.0f;
                    textView3.setLayoutParams(layoutParams8);
                    textView3.setTextColor(Color.parseColor("#2196F3"));
                    textView3.setTextSize((float) mo5629a((float) m3943a(17)));
                    textView3.setText(this.f2514e.mo4958c().get(0).mo4831a());
                    textView3.setOnClickListener(new View$OnClickListenerC0988h(this));
                    linearLayout2.addView(textView3);
                }
                linearLayout.addView(linearLayout2);
                this.f1556b.setContentView(linearLayout);
            } else if (!this.f2515f.isShowing()) {
                this.f2515f.show();
            }
        } catch (Exception e4) {
        }
    }

    /* renamed from: a */
    public int mo5629a(float f) {
        return (int) ((f / this.f2520k) + 0.5f);
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public void mo4597a(Intent intent) {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public void mo4598a(Configuration configuration) {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public boolean mo4601a(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (!this.f2514e.getDoActionId().equals("")) {
            C0535e.m2034a().mo4379a(this.f2516g, this.f2517h, this.f2514e.getDoActionId());
        }
        this.f1556b.finish();
        return true;
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public boolean mo4602a(Menu menu) {
        return false;
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: c */
    public void mo4604c() {
        this.f2519j = this.f1556b.getResources().getDisplayMetrics().density;
        this.f2520k = this.f1556b.getResources().getDisplayMetrics().scaledDensity;
        m3956j();
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: d */
    public void mo4605d() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: e */
    public void mo4606e() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: f */
    public void mo4607f() {
        if (this.f2518i) {
            C0535e.m2034a().mo4379a(this.f2516g, this.f2517h, this.f2514e.getDoActionId());
        }
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: g */
    public void mo4608g() {
        if (this.f1556b != null && !this.f1556b.isFinishing() && !C0997c.m4003b()) {
            this.f1556b.finish();
        }
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: h */
    public void mo4609h() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: i */
    public void mo4610i() {
        if (this.f1556b != null && !this.f1556b.isFinishing()) {
            this.f1556b.finish();
        }
    }
}
