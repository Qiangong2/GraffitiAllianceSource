package com.igexin.push.core.p030c;

import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0504a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.push.util.C1155e;
import com.igexin.push.util.C1159i;
import com.igexin.push.util.C1167q;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.p091b.C1447g;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.core.c.g */
public class C0609g extends AbstractC1139b {

    /* renamed from: a */
    public static final String f1543a = C0609g.class.getName();

    public C0609g(String str) {
        super(str);
        mo4594a();
    }

    /* renamed from: c */
    private void m2356c(byte[] bArr) {
        String string;
        String string2;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            ActivityC0460a.m1698b(f1543a + "|parse sdk config from server resp = " + jSONObject);
            C0568g.m2192a().mo4458e(System.currentTimeMillis());
            if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result")) && jSONObject.has("config")) {
                if (jSONObject.has("tag")) {
                    C0514k.f1298D = jSONObject.getString("tag");
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("config"));
                if (jSONObject2.has("sdk.uploadapplist.enable")) {
                    String string3 = jSONObject2.getString("sdk.uploadapplist.enable");
                    if (string3.equals("true") || string3.equals("false")) {
                        C0514k.f1315g = Boolean.valueOf(string3).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.feature.sendmessage.enable")) {
                    String string4 = jSONObject2.getString("sdk.feature.sendmessage.enable");
                    if (string4.equals("true") || string4.equals("false")) {
                        C0514k.f1316h = Boolean.valueOf(string4).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.snl.enable")) {
                    String string5 = jSONObject2.getString("sdk.snl.enable");
                    if (string5.equals("true") || string5.equals("false")) {
                        C0514k.f1321m = Boolean.valueOf(string5).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.domainbackup.enable")) {
                    String string6 = jSONObject2.getString("sdk.domainbackup.enable");
                    if (string6.equals("true") || string6.equals("false")) {
                        C0514k.f1314f = Boolean.valueOf(string6).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.feature.setsilenttime.enable")) {
                    String string7 = jSONObject2.getString("sdk.feature.setsilenttime.enable");
                    if (string7.equals("true") || string7.equals("false")) {
                        C0514k.f1318j = Boolean.valueOf(string7).booleanValue();
                        if (!C0514k.f1318j && C0514k.f1310b != 0) {
                            C0535e.m2034a().mo4363a(12, 0, "server");
                        }
                    }
                }
                if (jSONObject2.has("sdk.snl.maxactiveflow")) {
                    try {
                        C0514k.f1322n = Long.parseLong(jSONObject2.getString("sdk.snl.maxactiveflow"));
                    } catch (Exception e) {
                    }
                }
                if (jSONObject2.has("sdk.feature.settag.enable")) {
                    String string8 = jSONObject2.getString("sdk.feature.settag.enable");
                    if (string8.equals("true") || string8.equals("false")) {
                        C0514k.f1317i = Boolean.valueOf(string8).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.feature.setheartbeatinterval.enable")) {
                    String string9 = jSONObject2.getString("sdk.feature.setheartbeatinterval.enable");
                    if (string9.equals("true") || string9.equals("false")) {
                        C0514k.f1319k = Boolean.valueOf(string9).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.feature.setsockettimeout.enable")) {
                    String string10 = jSONObject2.getString("sdk.feature.setsockettimeout.enable");
                    if (string10.equals("true") || string10.equals("false")) {
                        C0514k.f1320l = Boolean.valueOf(string10).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.guard.enable")) {
                    String string11 = jSONObject2.getString("sdk.guard.enable");
                    if (string11.equals("true") || string11.equals("false")) {
                        C0514k.f1323o = Boolean.valueOf(string11).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.needlook.enable")) {
                    String string12 = jSONObject2.getString("sdk.needlook.enable");
                    if (string12.equals("true") || string12.equals("false")) {
                        C0514k.f1329u = Boolean.valueOf(string12).booleanValue();
                        m2357d(string12.getBytes());
                    }
                }
                if (jSONObject2.has("sdk.report.initialize.enable")) {
                    String string13 = jSONObject2.getString("sdk.report.initialize.enable");
                    if (string13.equals("true") || string13.equals("false")) {
                        C0514k.f1330v = Boolean.valueOf(string13).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.wakeupsdk.enable")) {
                    String string14 = jSONObject2.getString("sdk.wakeupsdk.enable");
                    if (string14.equals("true") || string14.equals("false")) {
                        C0514k.f1324p = Boolean.valueOf(string14).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.feature.feedback.enable")) {
                    String string15 = jSONObject2.getString("sdk.feature.feedback.enable");
                    if (string15.equals("true") || string15.equals("false")) {
                        C0514k.f1325q = Boolean.valueOf(string15).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.watchout.app")) {
                    C0514k.f1326r = jSONObject2.getString("sdk.watchout.app");
                }
                if (jSONObject2.has("sdk.watchout.service")) {
                    C0514k.f1327s = jSONObject2.getString("sdk.watchout.service");
                }
                if (jSONObject2.has("sdk.daemon.enable")) {
                    String string16 = jSONObject2.getString("sdk.daemon.enable");
                    if (string16.equals("true") || string16.equals("false")) {
                        C0514k.f1328t = Boolean.valueOf(string16).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.guardactivity.first")) {
                    String string17 = jSONObject2.getString("sdk.guardactivity.first");
                    if (string17.equals("true") || string17.equals("false")) {
                        C0514k.f1299E = Boolean.valueOf(string17).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.polling.dis.cnt")) {
                    C0514k.f1300F = Integer.valueOf(jSONObject2.getString("sdk.polling.dis.cnt")).intValue();
                }
                if (jSONObject2.has("sdk.polling.login.interval")) {
                    C0514k.f1301G = (long) (Integer.valueOf(jSONObject2.getString("sdk.polling.login.interval")).intValue() * 1000);
                }
                if (jSONObject2.has("sdk.polling.exit.heartbeat.cnt")) {
                    C0514k.f1302H = Integer.valueOf(jSONObject2.getString("sdk.polling.exit.heartbeat.cnt")).intValue();
                }
                if (jSONObject2.has("sdk.reset.reconnect.delay")) {
                    try {
                        C0514k.f1331w = Long.parseLong(jSONObject2.getString("sdk.reset.reconnect.delay")) * 1000;
                    } catch (Exception e2) {
                    }
                }
                if (jSONObject2.has("sdk.guard.maxcnt")) {
                    try {
                        C0514k.f1297C = Integer.parseInt(jSONObject2.getString("sdk.guard.maxcnt"));
                    } catch (Exception e3) {
                    }
                }
                if (jSONObject2.has("sdk.httpdata.maxsize")) {
                    C0514k.f1303I = Integer.valueOf(jSONObject2.getString("sdk.httpdata.maxsize")).intValue();
                }
                if (jSONObject2.has("sdk.hide.righticon.blacklist")) {
                    C0514k.f1304J = jSONObject2.getString("sdk.hide.righticon.blacklist");
                }
                if (jSONObject2.has("sdk.miuipush.enable")) {
                    String string18 = jSONObject2.getString("sdk.miuipush.enable");
                    if (string18.equals("true") || string18.equals("false")) {
                        C0514k.f1305K = Boolean.valueOf(string18).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.flymepush.enable")) {
                    String string19 = jSONObject2.getString("sdk.flymepush.enable");
                    if (string19.equals("true") || string19.equals("false")) {
                        C0514k.f1306L = Boolean.valueOf(string19).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.hmspush.enable")) {
                    String string20 = jSONObject2.getString("sdk.hmspush.enable");
                    if (string20.equals("true") || string20.equals("false")) {
                        C0514k.f1307M = Boolean.valueOf(string20).booleanValue();
                    }
                }
                if (jSONObject2.has("sdk.dms.conf") && (string2 = jSONObject2.getString("sdk.dms.conf")) != null) {
                    C1167q.m4792a(C0618g.f1635f, "dmsconf", new String(C1159i.m4782c(C0435a.m1578d(string2.getBytes("UTF-8"), "dj1om0z0za9kwzxrphkqxsu9oc21tez1"), 0)));
                }
                if (jSONObject2.has("sdk.dms.conf.account") && (string = jSONObject2.getString("sdk.dms.conf.account")) != null) {
                    C1167q.m4792a(C0618g.f1635f, "dms_act", new String(C1159i.m4782c(C0435a.m1578d(string.getBytes("UTF-8"), "dj1om0z0za9kwzxrphkqxsu9oc21tez1"), 0)));
                }
                C0504a.m1940a().mo4348f();
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1543a + "|" + th.toString());
            C0535e.m2034a().mo4395c(th.toString());
        }
    }

    /* renamed from: d */
    private void m2357d(byte[] bArr) {
        try {
            C1155e.m4762a(bArr, C0618g.f1635f.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "conf_n.pid", false);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo4594a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "sdkconfig");
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("appid", C0618g.f1602a);
            jSONObject.put(C1447g.f3517l, PushBuildConfig.sdk_conf_version);
            jSONObject.put("tag", C0514k.f1298D);
            mo5893b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        if (bArr != null) {
            m2356c(bArr);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
