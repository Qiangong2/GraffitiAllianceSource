package com.wanmei.sdk.core.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.wanmei.push.bean.AppState;
import com.wanmei.sdk.core.log.EnumC1758a;
import com.wanmei.sdk.core.log.p105a.C1760a;
import com.wanmei.sdk.core.net.C1768b;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import java.util.HashMap;

/* renamed from: com.wanmei.sdk.core.task.f */
public class AsyncTaskC1819f extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private Context f4530a;

    /* renamed from: b */
    private EnumC1758a f4531b;

    /* renamed from: c */
    private String f4532c;

    public AsyncTaskC1819f(Context context, EnumC1758a aVar, String str) {
        this.f4530a = context;
        this.f4531b = aVar;
        this.f4532c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9849a() {
        C1768b bVar = new C1768b(this.f4530a);
        HashMap<String, String> hashMap = new HashMap<>();
        String sb = new StringBuilder().append(SDKCoreFacade.getInstance().getAppId()).toString();
        if (!TextUtils.isEmpty(sb)) {
            hashMap.put(AppState.APP_ID, sb);
        }
        String userId = SDKCoreFacade.getInstance().getAccount().getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("userId", userId);
        }
        String pushDeviceId = SDKCoreFacade.getInstance().getPushDeviceId(this.f4530a);
        if (!TextUtils.isEmpty(pushDeviceId)) {
            hashMap.put("deviceId", pushDeviceId);
        }
        Context context = this.f4530a;
        String c = C1760a.m6486c();
        if (!TextUtils.isEmpty(c)) {
            hashMap.put("deviceName", c);
        }
        hashMap.put("platform", "1");
        String sb2 = new StringBuilder().append(SDKCoreFacade.getInstance().getChannelId()).toString();
        if (!TextUtils.isEmpty(sb2)) {
            hashMap.put("channelId", sb2);
        }
        hashMap.put("time", new StringBuilder().append(System.currentTimeMillis()).toString());
        String str = C1760a.m6484b(this.f4530a);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mac", str.replace(":", ""));
        }
        String sb3 = new StringBuilder().append(C1760a.m6485c(this.f4530a)).toString();
        if (!TextUtils.isEmpty(sb3)) {
            hashMap.put("versionCode", sb3);
        }
        StringBuilder sb4 = new StringBuilder();
        Context context2 = this.f4530a;
        String sb5 = sb4.append(C1760a.m6483b()).toString();
        if (!TextUtils.isEmpty(sb5)) {
            hashMap.put("systemVersion", sb5);
        }
        hashMap.put("logType", new StringBuilder().append(EnumC1758a.m6478a(this.f4531b)).toString());
        String a = bVar.mo9555a(hashMap);
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("sign", a);
        }
        hashMap.put("logs", this.f4532c);
        return bVar.mo9554a("https://apidev.laohu.com/logapi/record_log", hashMap, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        Log.d("test", str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* synthetic */ String doInBackground(Void[] voidArr) {
        return mo9849a();
    }
}
