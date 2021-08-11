package com.wanmei.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.AppInfo;
import com.wanmei.push.bean.DeviceInfo;
import com.wanmei.push.bean.OneSDKInfo;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.bean.SyncAppInfo;
import com.wanmei.push.p099c.C1675b;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p100d.C1680d;
import com.wanmei.push.p104g.C1711c;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1717i;
import com.wanmei.push.service.C1746d;
import java.util.ArrayList;
import java.util.List;

public class PushAgent {
    private static PushAgent INSTANCE;
    private Context mContext;
    private C1746d mPerData;

    public interface OnPushOpenCallBack {
        void openFail(int i);

        void openSuccess();
    }

    private PushAgent(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void auth(final OnPushOpenCallBack callBack) {
        C1645b.m6176a().mo9184a(new C1645b.AbstractC1647a() {
            /* class com.wanmei.push.PushAgent.C16332 */

            @Override // com.wanmei.push.C1645b.AbstractC1647a
            /* renamed from: a */
            public final void mo9160a() {
                C1714f.m6382b("PERFECT_PUSH", "Auth Success");
                PushAgent.this.uploadDeviceInfo();
                if (PushAgent.this.isPersistentDeviceAppInfoExist()) {
                    C1680d.m6296a(PushAgent.this.mContext).mo9323a(callBack);
                } else {
                    PushAgent.this.syncDeviceAppInfo(callBack);
                }
                PushAgent.this.pullCertificate();
            }

            @Override // com.wanmei.push.C1645b.AbstractC1647a
            /* renamed from: a */
            public final void mo9161a(int i) {
                callBack.openFail(i);
            }
        });
        C1677a.m6259a();
        C1677a.m6260a(this.mContext);
    }

    public static synchronized PushAgent getInstance(Context context) {
        PushAgent pushAgent;
        synchronized (PushAgent.class) {
            if (INSTANCE == null) {
                INSTANCE = new PushAgent(context);
            }
            pushAgent = INSTANCE;
        }
        return pushAgent;
    }

    private void initDeviceInfo() {
        String a = C1711c.m6371a(this.mContext);
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        String str3 = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        C1714f.m6379a("PERFECT_PUSH", "deviceId = " + a + "    deviceName=" + str + "   sysVersion" + str2 + "   resolution=" + str3);
        C1645b.m6176a().mo9183a(this.mContext, a, str, str2, str3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isPersistentDeviceAppInfoExist() {
        try {
            this.mPerData = new C1746d(this.mContext);
            if (!this.mPerData.mo9446b(this.mPerData.mo9445b()).isEmpty()) {
                C1714f.m6382b("PERFECT_PUSH", "Has Persistent DeviceAppInfo");
                return true;
            }
        } catch (Exception e) {
            C1714f.m6382b("PERFECT_PUSH", "Check Has Persistent DeviceAppInfo Fail : " + e.getMessage());
        }
        return false;
    }

    private void pullAppInfo(final OnPushOpenCallBack callBack) {
        OneSDKInfo b = C1645b.m6176a().mo9194b();
        C1645b.m6176a().mo9186a(new C1645b.AbstractC1649c() {
            /* class com.wanmei.push.PushAgent.C16321 */

            @Override // com.wanmei.push.C1645b.AbstractC1649c
            /* renamed from: a */
            public final void mo9158a(int i) {
                callBack.openFail(i);
            }

            @Override // com.wanmei.push.C1645b.AbstractC1649c
            /* renamed from: a */
            public final void mo9159a(String str, String str2) {
                C1714f.m6382b("PERFECT_PUSH", "pullAppInfo:appId:" + str + "    appKey:" + str2);
                PushAgent.this.setPushSDKAppInfo(str, str2);
                PushAgent.this.auth(callBack);
            }
        });
        C1677a.m6259a();
        C1677a.m6261a(this.mContext, b.getOneAppId(), b.getOneAppKey());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pullCertificate() {
        if (C1717i.m6392b()) {
            C1714f.m6382b("PERFECT_PUSH", "IS XIAOMI ROOM");
            C1645b.m6176a().mo9185a(new C1645b.AbstractC1648b() {
                /* class com.wanmei.push.PushAgent.C16365 */

                @Override // com.wanmei.push.C1645b.AbstractC1648b
                /* renamed from: a */
                public final void mo9166a(int i) {
                    C1714f.m6382b("PERFECT_PUSH", "certificateFail  code is : " + i);
                }

                @Override // com.wanmei.push.C1645b.AbstractC1648b
                /* renamed from: a */
                public final void mo9167a(String str, String str2) {
                    C1714f.m6382b("PERFECT_PUSH", "certificateSuccess  appId : " + str + "   appkey:" + str2);
                    C1675b bVar = new C1675b(PushAgent.this.mContext);
                    bVar.mo9318a(str, str2);
                    bVar.mo9317a(new OnPushOpenCallBack() {
                        /* class com.wanmei.push.PushAgent.C16365.C16371 */

                        @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
                        public final void openFail(int i) {
                            C1714f.m6379a("PERFECT_PUSH", "xiaomi push openFailed");
                        }

                        @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
                        public final void openSuccess() {
                            C1714f.m6379a("PERFECT_PUSH", "xiaomi push openSuccess");
                        }
                    });
                }
            });
            C1677a.m6259a();
            C1677a.m6273g(this.mContext);
        }
    }

    private void setNotifyIcon(int ic_launcher, Context mContext2) {
        C1638a.m6168a(ic_launcher);
        C1679c.m6277a();
        C1679c.m6278a(mContext2, ic_launcher);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPushSDKAppInfo(String appId, String appKey) {
        C1714f.m6379a("PERFECT_PUSH", "setPushSDKAppInfo  appId = " + appId + "    oneAppKey=" + appKey);
        C1645b.m6176a().mo9182a(this.mContext, appId, appKey, this.mContext.getPackageName());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void syncDeviceAppInfo(final OnPushOpenCallBack callBack) {
        C1645b.m6176a().mo9189a(new C1645b.AbstractC1652f() {
            /* class com.wanmei.push.PushAgent.C16354 */

            @Override // com.wanmei.push.C1645b.AbstractC1652f
            /* renamed from: a */
            public final void mo9164a() {
                C1714f.m6382b("PERFECT_PUSH", "Sync DeviceAppInfo Fail, Try Open Push");
                C1680d.m6296a(PushAgent.this.mContext).mo9323a(callBack);
            }

            @Override // com.wanmei.push.C1645b.AbstractC1652f
            /* renamed from: a */
            public final void mo9165a(StandardBaseResult<?> standardBaseResult) {
                if (!(standardBaseResult == null || standardBaseResult.getResult() == null || !(standardBaseResult.getResult() instanceof SyncAppInfo))) {
                    SyncAppInfo syncAppInfo = (SyncAppInfo) standardBaseResult.getResult();
                    if (syncAppInfo.getAppInfoList() != null && !syncAppInfo.getAppInfoList().isEmpty()) {
                        List<SyncAppInfo.DeviceAppInfo> appInfoList = syncAppInfo.getAppInfoList();
                        ArrayList arrayList = new ArrayList();
                        for (SyncAppInfo.DeviceAppInfo deviceAppInfo : appInfoList) {
                            AppInfo appInfo = new AppInfo();
                            appInfo.setAppClientId(deviceAppInfo.getAppId());
                            appInfo.setPackageName(deviceAppInfo.getBundleId());
                            arrayList.add(appInfo);
                        }
                        try {
                            C1746d dVar = PushAgent.this.mPerData;
                            C1746d unused = PushAgent.this.mPerData;
                            dVar.mo9444a(C1746d.m6468a(arrayList));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    C1714f.m6382b("PERFECT_PUSH", "Sync DeviceAppInfo Success, Try Open Push");
                    C1680d.m6296a(PushAgent.this.mContext).mo9323a(callBack);
                }
            }
        });
        C1714f.m6382b("PERFECT_PUSH", "Persistent DeviceAppInfo is Not Exist, Sync DeviceAppInfo...");
        C1677a.m6259a();
        C1677a.m6271f(this.mContext);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void uploadDeviceInfo() {
        C1645b.m6176a().mo9191a(new C1645b.AbstractC1654h() {
            /* class com.wanmei.push.PushAgent.C16343 */

            @Override // com.wanmei.push.C1645b.AbstractC1654h
            /* renamed from: a */
            public final void mo9162a() {
                C1714f.m6382b("PERFECT_PUSH", "Upload DeviceInfo Success");
            }

            @Override // com.wanmei.push.C1645b.AbstractC1654h
            /* renamed from: b */
            public final void mo9163b() {
                C1714f.m6382b("PERFECT_PUSH", "Upload DeviceInfo Fail");
            }
        });
        C1714f.m6382b("PERFECT_PUSH", "Upload DeviceInfo");
        C1677a.m6259a();
        C1677a.m6267d(this.mContext);
    }

    public String getDeviceId() {
        DeviceInfo a = C1645b.m6176a().mo9179a(this.mContext);
        C1714f.m6379a("PERFECT_PUSH", "deviceInfo = " + (a == null ? "deviceInfo is NULL" : a.getDeviceId()));
        return a == null ? C1711c.m6371a(this.mContext) : a.getDeviceId();
    }

    public String getPushAppId(Context context) {
        AppInfo b = C1645b.m6176a().mo9193b(context);
        return b != null ? b.getAppClientId() : "";
    }

    public void initAppInfo(String appId, String appKey) {
        initDeviceInfo();
        setPushSDKAppInfo(appId, appKey);
    }

    public void oneSDKInitPush(String oneAppId, String oneAppKey) {
        C1714f.m6379a("PERFECT_PUSH", "oneSDKInitPush oneAppId = " + oneAppId + "    oneAppKey=" + oneAppKey);
        initDeviceInfo();
        C1645b.m6176a().mo9192a(oneAppId, oneAppKey);
    }

    public void openPush(OnPushOpenCallBack callBack) {
        AppInfo b = C1645b.m6176a().mo9193b(this.mContext);
        if (b != null) {
            C1714f.m6382b("PERFECT_PUSH", "appInfo:" + b.toString());
        } else {
            C1714f.m6382b("PERFECT_PUSH", "appInfo == NULL");
        }
        if (b == null || TextUtils.isEmpty(b.getAppClientId()) || TextUtils.isEmpty(b.getAppClientSecret())) {
            pullAppInfo(callBack);
        } else {
            auth(callBack);
        }
    }

    public void setDebugMode(boolean isDebugMode) {
        C1714f.m6378a(this.mContext, isDebugMode);
    }

    public void setPushNotifyIcon(int drawableId) {
        setNotifyIcon(drawableId, this.mContext);
    }
}
