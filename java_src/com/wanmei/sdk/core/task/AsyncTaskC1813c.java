package com.wanmei.sdk.core.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.wanmei.push.bean.AppState;
import com.wanmei.sdk.core.log.manager.C1765c;
import com.wanmei.sdk.core.log.p105a.C1760a;
import com.wanmei.sdk.core.net.C1768b;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.wanmei.sdk.core.task.c */
public class AsyncTaskC1813c extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private Context f4520a;

    public AsyncTaskC1813c(Context context) {
        this.f4520a = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9840a() {
        C1768b bVar = new C1768b(this.f4520a);
        HashMap<String, String> hashMap = new HashMap<>();
        String sb = new StringBuilder().append(SDKCoreFacade.getInstance().getAppId()).toString();
        if (!TextUtils.isEmpty(sb)) {
            hashMap.put(AppState.APP_ID, sb);
        }
        String userId = SDKCoreFacade.getInstance().getAccount().getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("userId", userId);
        }
        String pushDeviceId = SDKCoreFacade.getInstance().getPushDeviceId(this.f4520a);
        if (!TextUtils.isEmpty(pushDeviceId)) {
            hashMap.put("deviceId", pushDeviceId);
        }
        Context context = this.f4520a;
        String c = C1760a.m6486c();
        if (!TextUtils.isEmpty(c)) {
            hashMap.put("deviceName", c);
        }
        String sb2 = new StringBuilder().append(SDKCoreFacade.getInstance().getChannelId()).toString();
        if (!TextUtils.isEmpty(sb2)) {
            hashMap.put("channelId", sb2);
        }
        String str = C1760a.m6484b(this.f4520a);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mac", str.replace(":", ""));
        }
        String sb3 = new StringBuilder().append(C1760a.m6485c(this.f4520a)).toString();
        if (!TextUtils.isEmpty(sb3)) {
            hashMap.put("versionCode", sb3);
        }
        StringBuilder sb4 = new StringBuilder();
        Context context2 = this.f4520a;
        String sb5 = sb4.append(C1760a.m6483b()).toString();
        if (!TextUtils.isEmpty(sb5)) {
            hashMap.put("systemVersion", sb5);
        }
        String a = bVar.mo9555a(hashMap);
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("sign", a);
        }
        return bVar.mo9554a("https://apidev.laohu.com/logapi/is_debug", hashMap, 1);
    }

    /* renamed from: a */
    public void mo9841a(Context context, boolean z) {
        Log.d("test", "debug  =" + z);
        C1765c.m6499a();
        C1765c.m6500a(context, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        try {
            if (new JSONObject(str).optInt("code", -1) == 0) {
                mo9841a(this.f4520a, true);
            } else {
                mo9841a(this.f4520a, false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* synthetic */ String doInBackground(Void[] voidArr) {
        return mo9840a();
    }
}
