package com.wanmei.push.p100d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.wanmei.push.C1645b;
import com.wanmei.push.PushAgent;
import com.wanmei.push.ResponseCode;
import com.wanmei.push.p097a.AbstractC1639a;
import com.wanmei.push.p097a.AbstractC1642b;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.service.PushService;
import java.util.List;

/* renamed from: com.wanmei.push.d.d */
public final class C1680d {

    /* renamed from: a */
    private static C1680d f4268a;

    /* renamed from: b */
    private Context f4269b;

    /* renamed from: c */
    private PushAgent.OnPushOpenCallBack f4270c;

    /* renamed from: d */
    private AbstractC1642b f4271d;

    /* renamed from: e */
    private String f4272e;

    /* renamed from: f */
    private boolean f4273f = false;

    /* renamed from: g */
    private AbstractC1639a.AbstractBinderC1640a f4274g = new AbstractC1639a.AbstractBinderC1640a() {
        /* class com.wanmei.push.p100d.C1680d.BinderC16811 */

        @Override // com.wanmei.push.p097a.AbstractC1639a
        /* renamed from: a */
        public final void mo9170a() {
            try {
                if (C1680d.this.f4270c != null) {
                    C1680d.this.f4270c.openSuccess();
                }
            } catch (Exception e) {
                C1714f.m6380a("PERFECT_PUSH", "RegistCallBack Call openPushSuccess Error", e);
            }
        }

        @Override // com.wanmei.push.p097a.AbstractC1639a
        /* renamed from: a */
        public final void mo9171a(int i) {
            try {
                if (C1680d.this.f4270c != null) {
                    C1680d.this.f4270c.openFail(ResponseCode.PUSH_OPEN_FAIL_CODE);
                }
            } catch (Exception e) {
                C1714f.m6380a("PERFECT_PUSH", "RegistCallBack Call openPushFail Error", e);
            }
        }
    };

    /* renamed from: h */
    private ServiceConnection f4275h = new ServiceConnection() {
        /* class com.wanmei.push.p100d.C1680d.ServiceConnectionC16822 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C1680d.this.f4271d = AbstractC1642b.AbstractBinderC1643a.m6174a(iBinder);
                C1680d.this.f4273f = true;
                C1680d.m6298b(C1680d.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            C1680d.this.f4271d = null;
            C1680d.this.f4273f = false;
        }
    };

    private C1680d(Context context) {
        this.f4269b = context.getApplicationContext();
    }

    /* renamed from: a */
    private static Intent m6293a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            C1714f.m6382b("PERFECT_PUSH", "getExplicitIntent packageName :" + str);
            C1714f.m6382b("PERFECT_PUSH", "getExplicitIntent className :" + str2);
            ComponentName componentName = new ComponentName(str, str2);
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            return intent2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C1680d m6296a(Context context) {
        if (f4268a == null) {
            f4268a = new C1680d(context);
        }
        return f4268a;
    }

    /* renamed from: b */
    static /* synthetic */ void m6298b(C1680d dVar) {
        if (dVar.f4273f && dVar.f4271d != null) {
            try {
                dVar.f4271d.mo9175a(C1645b.m6176a().mo9193b(dVar.f4269b).getAppClientId(), dVar.f4269b.getPackageName(), dVar.f4274g);
                if (dVar.f4273f) {
                    dVar.f4269b.unbindService(dVar.f4275h);
                    dVar.f4271d = null;
                    dVar.f4273f = false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007a  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6299c() {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wanmei.push.p100d.C1680d.m6299c():boolean");
    }

    /* renamed from: d */
    private void m6300d() {
        try {
            C1714f.m6382b("PERFECT_PUSH", "bindPushService start");
            Intent intent = new Intent();
            intent.setAction(this.f4272e + ".intent.action.PERFECT_PUSH");
            intent.setPackage(this.f4272e);
            Intent a = m6293a(this.f4269b, intent);
            if (a != null) {
                this.f4269b.bindService(a, this.f4275h, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final PushAgent.OnPushOpenCallBack mo9322a() {
        return this.f4270c;
    }

    /* renamed from: a */
    public final void mo9323a(PushAgent.OnPushOpenCallBack onPushOpenCallBack) {
        if (onPushOpenCallBack != null) {
            this.f4270c = onPushOpenCallBack;
        }
        if (this.f4269b == null) {
            this.f4270c.openFail(ResponseCode.PUSH_OPEN_FAIL_CODE);
        }
        if (!m6299c()) {
            PushService.m6404a(this.f4269b);
        } else {
            m6300d();
        }
    }

    /* renamed from: b */
    public final void mo9324b() {
        if (!m6299c()) {
            PushService.m6404a(this.f4269b);
        } else {
            m6300d();
        }
    }
}
