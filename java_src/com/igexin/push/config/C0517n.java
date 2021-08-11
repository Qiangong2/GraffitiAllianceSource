package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.config.n */
public class C0517n {
    /* renamed from: a */
    public static void m1970a() {
        try {
            Bundle bundle = C0618g.f1635f.getPackageManager().getApplicationInfo(C0618g.f1635f.getPackageName(), 128).metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (str.equals("PUSH_DOMAIN")) {
                        ActivityC0460a.m1698b("PUSH_DOMAIN:" + bundle.getString(str));
                        m1971a(bundle.getString(str));
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(e.toString());
        }
    }

    /* renamed from: a */
    private static void m1971a(String str) {
        SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + str + ":5224"});
        ActivityC0460a.m1698b("XFR_ADDRESS_IPS:" + SDKUrlConfig.getXfrAddress()[0]);
        SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + str + ":5224"};
        ActivityC0460a.m1698b("XFR_ADDRESS_IPS_BAK:" + SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"http://bi." + str + "/api.php"};
        ActivityC0460a.m1698b("BI_ADDRESS_IPS:" + SDKUrlConfig.BI_ADDRESS_IPS[0]);
        SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"http://config." + str + "/api.php"};
        ActivityC0460a.m1698b("CONFIG_ADDRESS_IPS:" + SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        SDKUrlConfig.STATE_ADDRESS_IPS = new String[]{"http://stat." + str + "/api.php"};
        ActivityC0460a.m1698b("STATE_ADDRESS_IPS:" + SDKUrlConfig.STATE_ADDRESS_IPS[0]);
        SDKUrlConfig.LOG_ADDRESS_IPS = new String[]{"http://log." + str + "/api.php"};
        ActivityC0460a.m1698b("LOG_ADDRESS_IPS:" + SDKUrlConfig.LOG_ADDRESS_IPS[0]);
        SDKUrlConfig.AMP_ADDRESS_IPS = new String[]{"http://amp." + str + "/api.htm"};
        ActivityC0460a.m1698b("AMP_ADDRESS_IPS:" + SDKUrlConfig.AMP_ADDRESS_IPS[0]);
        SDKUrlConfig.LBS_ADDRESS_IPS = new String[]{"http://lbs." + str + "/api.htm"};
        ActivityC0460a.m1698b("LBS_ADDRESS_IPS:" + SDKUrlConfig.LBS_ADDRESS_IPS[0]);
        SDKUrlConfig.INC_ADDRESS_IPS = new String[]{"http://inc." + str + "/api.php"};
        ActivityC0460a.m1698b("INC_ADDRESS_IPS:" + SDKUrlConfig.INC_ADDRESS_IPS[0]);
    }
}
