package com.wanmei.sdk.core.net;

import android.content.Context;
import com.wanmei.push.bean.AppState;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.util.C1846g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wanmei.sdk.core.net.b */
public class C1768b {

    /* renamed from: a */
    private Context f4462a;

    /* renamed from: b */
    private C1770c f4463b = new C1770c();

    public C1768b(Context context) {
        this.f4462a = context.getApplicationContext();
    }

    /* renamed from: a */
    public String mo9554a(String str, HashMap<String, String> hashMap, short s) {
        C1772d dVar = new C1772d(this.f4462a, str, s);
        dVar.mo9569a((Map<String, String>) hashMap);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(AppState.APP_ID, String.valueOf(SDKCoreFacade.getInstance().getAppId()));
        dVar.mo9568a(hashMap2);
        return this.f4463b.mo9559a(dVar);
    }

    /* renamed from: a */
    public String mo9555a(Map<String, String> map) {
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() {
            /* class com.wanmei.sdk.core.net.C1768b.C17691 */

            /* renamed from: a */
            public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                return entry.getKey().toString().compareTo(entry2.getKey().toString());
            }
        });
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry entry : arrayList) {
            sb.append((String) entry.getValue());
        }
        sb.append(SDKCoreFacade.getInstance().getAppKey());
        return C1846g.m6694a(sb.toString());
    }

    /* renamed from: a */
    public void mo9556a(String str, HashMap<String, String> hashMap) {
        mo9554a(str, hashMap, 0);
    }
}
