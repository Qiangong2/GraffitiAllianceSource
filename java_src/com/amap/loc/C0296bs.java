package com.amap.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.amap.loc.AbstractC0338g;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.umeng.analytics.p091b.C1447g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.loc.bs */
/* compiled from: ConnectionServiceManager */
public class C0296bs {

    /* renamed from: a */
    AbstractC0300a f553a = null;

    /* renamed from: b */
    private String f554b = null;

    /* renamed from: c */
    private Context f555c = null;

    /* renamed from: d */
    private boolean f556d = true;

    /* renamed from: e */
    private AbstractC0338g f557e = null;

    /* renamed from: f */
    private ServiceConnection f558f = null;

    /* renamed from: g */
    private ServiceConnection f559g = null;

    /* renamed from: h */
    private ServiceConnection f560h = null;

    /* renamed from: i */
    private Intent f561i = new Intent();

    /* renamed from: j */
    private String f562j = "com.autonavi.minimap";

    /* renamed from: k */
    private String f563k = "com.amap.api.service.AMapService";

    /* renamed from: l */
    private String f564l = "com.autonavi.minimap.LBSConnectionService";

    /* renamed from: m */
    private boolean f565m = false;

    /* renamed from: n */
    private boolean f566n = false;

    /* renamed from: o */
    private boolean f567o = false;

    /* renamed from: p */
    private String f568p = "invaid type";

    /* renamed from: q */
    private String f569q = "empty appkey";

    /* renamed from: r */
    private String f570r = "refused";

    /* renamed from: s */
    private String f571s = "failed";

    /* renamed from: com.amap.loc.bs$a */
    /* compiled from: ConnectionServiceManager */
    public interface AbstractC0300a {
        /* renamed from: a */
        void mo3801a(int i);
    }

    C0296bs(Context context) {
        this.f555c = context;
        try {
            this.f554b = C0355m.m1295a(C0309bz.m942a(C0342i.m1235f(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            C0310c.m956a(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m867a(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0296bs.m867a(android.os.Bundle):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    public void mo3803a() {
        mo3806c();
        this.f555c = null;
        this.f557e = null;
        this.f558f = null;
        this.f559g = null;
        this.f560h = null;
        if (this.f553a != null) {
            this.f553a.mo3801a(-1);
        }
        this.f556d = true;
        this.f565m = false;
        this.f566n = false;
        this.f567o = false;
    }

    /* renamed from: a */
    public void mo3804a(final AbstractC0300a aVar) {
        try {
            this.f553a = aVar;
            if (this.f558f == null) {
                this.f558f = new ServiceConnection() {
                    /* class com.amap.loc.C0296bs.ServiceConnectionC02971 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        C0296bs.this.f557e = AbstractC0338g.AbstractBinderC0339a.m1223a(iBinder);
                        aVar.mo3801a(0);
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        C0296bs.this.f557e = null;
                    }
                };
            }
            if (this.f559g == null) {
                this.f559g = new ServiceConnection() {
                    /* class com.amap.loc.C0296bs.ServiceConnectionC02982 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
            if (this.f560h == null) {
                this.f560h = new ServiceConnection() {
                    /* class com.amap.loc.C0296bs.ServiceConnectionC02993 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "ConnectionServiceManager", "init");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3805b() {
        ArrayList<String> n;
        ArrayList<String> m;
        try {
            if (C0322ck.m1053b(this.f555c)) {
                this.f561i.putExtra(C1447g.f3463a, this.f554b);
                this.f561i.setComponent(new ComponentName(this.f562j, this.f563k));
                try {
                    this.f565m = this.f555c.bindService(this.f561i, this.f558f, 1);
                } catch (Throwable th) {
                }
                if (!this.f565m && (m = C0322ck.m1085m()) != null) {
                    Iterator<String> it = m.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!next.equals(this.f563k)) {
                            this.f561i.setComponent(new ComponentName(this.f562j, next));
                            try {
                                this.f565m = this.f555c.bindService(this.f561i, this.f558f, 1);
                            } catch (Throwable th2) {
                            }
                            if (this.f565m) {
                                break;
                            }
                        }
                    }
                }
            }
            if (C0322ck.m1057c(this.f555c)) {
                Intent intent = new Intent();
                intent.putExtra(C1447g.f3463a, this.f554b);
                intent.setComponent(new ComponentName(this.f562j, this.f564l));
                try {
                    this.f566n = this.f555c.bindService(intent, this.f559g, 1);
                } catch (Throwable th3) {
                }
                if (!this.f566n && (n = C0322ck.m1086n()) != null) {
                    Iterator<String> it2 = n.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!next2.equals(this.f564l)) {
                            intent.setComponent(new ComponentName(this.f562j, next2));
                            try {
                                this.f566n = this.f555c.bindService(intent, this.f559g, 1);
                            } catch (Throwable th4) {
                            }
                            if (this.f565m) {
                                break;
                            }
                        }
                    }
                }
            }
            mo3807d();
            return this.f565m && this.f566n;
        } catch (Throwable th5) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3806c() {
        try {
            if (this.f565m) {
                this.f555c.unbindService(this.f558f);
            }
            if (this.f566n) {
                this.f555c.unbindService(this.f559g);
            }
            if (this.f567o) {
                this.f555c.unbindService(this.f560h);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "ConnectionServiceManager", "unbindService");
        }
        this.f557e = null;
    }

    /* renamed from: d */
    public void mo3807d() {
        List<C0324cl> v;
        try {
            if (C0322ck.m1073g(this.f555c) && (v = C0322ck.m1094v()) != null && v.size() > 0) {
                for (C0324cl clVar : v) {
                    if (clVar != null) {
                        try {
                            if (clVar.mo3896a()) {
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName(clVar.mo3897b(), clVar.mo3900c()));
                                if (!TextUtils.isEmpty(clVar.mo3903e())) {
                                    intent.setAction(clVar.mo3903e());
                                }
                                List<Map<String, String>> d = clVar.mo3902d();
                                if (d != null && d.size() > 0) {
                                    for (int i = 0; i < d.size(); i++) {
                                        Iterator<Map.Entry<String, String>> it = d.get(i).entrySet().iterator();
                                        if (it.hasNext()) {
                                            Map.Entry<String, String> next = it.next();
                                            intent.putExtra(next.getKey().toString(), next.getValue().toString());
                                        }
                                    }
                                }
                                if (clVar.mo3904f()) {
                                    this.f555c.startService(intent);
                                }
                                boolean bindService = this.f555c.bindService(intent, this.f560h, 1);
                                if (bindService) {
                                    this.f567o = bindService;
                                }
                            }
                        } catch (Throwable th) {
                            C0310c.m956a(th, "ConnectionServiceManager", "bindOtherService 1");
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            C0310c.m956a(th2, "ConnectionServiceManager", "bindOtherService");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public AMapLocationServer mo3808e() {
        try {
            if (!this.f556d || !this.f565m) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "corse");
            bundle.putString(C1447g.f3463a, this.f554b);
            if (this.f557e == null) {
                return null;
            }
            this.f557e.mo3929a(bundle);
            if (bundle.size() >= 1) {
                return m867a(bundle);
            }
            return null;
        } catch (Throwable th) {
            C0310c.m956a(th, "ConnectionServiceManager", "sendCommand");
            return null;
        }
    }
}
