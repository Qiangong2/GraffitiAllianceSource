package com.igexin.push.core.p027a;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0513j;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p030c.C0608f;
import com.igexin.push.p026c.C0490e;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p079f.p080a.C1142e;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.s */
public class C0549s extends AbstractC0532b {

    /* renamed from: a */
    private static final String f1382a = (C0513j.f1294a + "_RedirectServerAction");

    /* renamed from: a */
    private void m2144a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str2.equals(str)) {
            ActivityC0460a.m1698b(f1382a + "|new location = " + str + "; pre location = " + str2 + ", send snl retire broadcast");
            Intent intent = new Intent();
            intent.setAction("com.igexin.sdk.action.snlretire");
            intent.putExtra("groupid", str2);
            intent.putExtra("branch", "open");
            C0618g.f1635f.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    private void m2145a(String str, JSONArray jSONArray) {
        try {
            ActivityC0460a.m1698b(f1382a + "|start fetch idc config, url : " + str);
            C0456c.m1661b().mo4216a(new C1142e(new C0608f(str, jSONArray)), false, true);
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1382a + e.toString());
        }
    }

    /* renamed from: a */
    public static String[] m2146a(JSONArray jSONArray) {
        String[] strArr;
        Exception e;
        try {
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    strArr[i] = "http://" + jSONArray.getString(i);
                } catch (Exception e2) {
                    e = e2;
                    ActivityC0460a.m1698b(f1382a + "|parseIDCConfigURL exception" + e.toString());
                    return strArr;
                }
            }
        } catch (Exception e3) {
            strArr = null;
            e = e3;
            ActivityC0460a.m1698b(f1382a + "|parseIDCConfigURL exception" + e.toString());
            return strArr;
        }
        return strArr;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        long j;
        ActivityC0460a.m1698b(f1382a + "|redirect server resp data : " + jSONObject);
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("redirect_server")) {
                return true;
            }
            String string = jSONObject.getString("delay");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("address_list");
            ActivityC0460a.m1698b("redirect|" + string + "|" + jSONArray.toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                String string2 = jSONArray.getString(i);
                int indexOf = string2.indexOf(44);
                if (indexOf > 0) {
                    String substring = string2.substring(0, indexOf);
                    String substring2 = string2.substring(indexOf + 1);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        long parseLong = Long.parseLong(substring2);
                        C0490e eVar = new C0490e();
                        eVar.f1220a = "socket://" + substring;
                        eVar.f1221b = (parseLong * 1000) + currentTimeMillis;
                        arrayList.add(eVar);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            try {
                j = Long.parseLong(string) * 1000;
            } catch (Exception e2) {
                j = 0;
            }
            if (j >= 0) {
                C0618g.f1579D = j;
            }
            if (jSONObject.has("loc") && jSONObject.has("conf")) {
                try {
                    String string3 = jSONObject.getString("loc");
                    String str = C0618g.f1633d;
                    SDKUrlConfig.setLocation(string3);
                    if (C0514k.f1321m) {
                        m2144a(string3, str);
                    }
                    ActivityC0460a.m1698b(f1382a + " set group id : " + C0618g.f1633d);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("conf");
                    String[] a = m2146a(jSONArray2);
                    if (a != null && a.length > 0) {
                        String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                        if (idcConfigUrl != null && a[0].equals(idcConfigUrl[0])) {
                            ActivityC0460a.m1698b(f1382a + "|current idc config url == new idc config url, return");
                        } else if (C0618g.f1624at == 0) {
                            m2145a(a[0], jSONArray2);
                        } else if (System.currentTimeMillis() - C0618g.f1624at > 7200000) {
                            m2145a(a[0], jSONArray2);
                        } else {
                            ActivityC0460a.m1698b(f1382a + "|get idc cfg last time less than 2 hours return");
                        }
                    }
                } catch (Exception e3) {
                    ActivityC0460a.m1698b(f1382a + e3.toString());
                }
            }
            C0494i.m1834a().mo4281e().mo4263a(arrayList);
            C0535e.m2034a().mo4396c(true);
            if (!EncryptUtils.isLoadSuccess()) {
                return true;
            }
            ActivityC0460a.m1698b(f1382a + "|redirect reInit so ~~~~~");
            EncryptUtils.reset();
            return true;
        } catch (Exception e4) {
            ActivityC0460a.m1698b(f1382a + e4.toString());
            return true;
        }
    }
}
