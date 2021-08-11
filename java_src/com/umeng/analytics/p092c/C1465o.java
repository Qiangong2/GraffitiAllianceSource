package com.umeng.analytics.p092c;

import android.content.Context;
import android.os.Environment;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.umeng.analytics.c.o */
/* compiled from: UTDIdTracker */
public class C1465o extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3605a = "utdid";

    /* renamed from: b */
    private static final String f3606b = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: c */
    private static final Pattern f3607c = Pattern.compile("UTDID\">([^<]+)");

    /* renamed from: d */
    private Context f3608d;

    public C1465o(Context context) {
        super(f3605a);
        this.f3608d = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        try {
            return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f3608d);
        } catch (Exception e) {
            return m5426g();
        }
    }

    /* renamed from: g */
    private String m5426g() {
        File h = m5427h();
        if (h == null || !h.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(h);
            try {
                return m5425b(C1344f.m4972a(fileInputStream));
            } finally {
                C1344f.m4981c(fileInputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private String m5425b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f3607c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* renamed from: h */
    private File m5427h() {
        if (!C1343e.m4938a(this.f3608d, f3606b) || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }
}
