package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1873d;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.service.AbstractC1993y;
import com.xiaomi.push.service.C1982s;
import com.xiaomi.xmpush.thrift.C2065b;
import com.xiaomi.xmpush.thrift.C2067c;
import com.xiaomi.xmpush.thrift.C2071e;
import com.xiaomi.xmpush.thrift.C2075g;
import com.xiaomi.xmpush.thrift.C2077h;
import com.xiaomi.xmpush.thrift.C2079i;
import com.xiaomi.xmpush.thrift.C2083k;
import com.xiaomi.xmpush.thrift.C2089n;
import com.xiaomi.xmpush.thrift.C2093p;
import com.xiaomi.xmpush.thrift.C2097r;
import com.xiaomi.xmpush.thrift.C2101t;
import com.xiaomi.xmpush.thrift.C2103u;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2164f;

/* renamed from: com.xiaomi.mipush.sdk.f */
public class C1908f {

    /* renamed from: a */
    private static C1908f f4872a = null;

    /* renamed from: c */
    private static Queue<String> f4873c;

    /* renamed from: d */
    private static Object f4874d = new Object();

    /* renamed from: b */
    private Context f4875b;

    private C1908f(Context context) {
        this.f4875b = context.getApplicationContext();
        if (this.f4875b == null) {
            this.f4875b = context;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent m6988a(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.C1908f.m6988a(android.content.Context, java.lang.String, java.util.Map):android.content.Intent");
    }

    /* renamed from: a */
    private PushMessageHandler.AbstractC1899a m6989a(C2077h hVar, boolean z, byte[] bArr) {
        List<String> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MiPushMessage miPushMessage = null;
        try {
            AbstractC2158b a = C1906e.m6984a(this.f4875b, hVar);
            if (a == null) {
                AbstractC1855b.m6723d("receiving an un-recognized message. " + hVar.f5734a);
                return null;
            }
            AbstractC1855b.m6722c("receive a message." + a);
            EnumC2064a a2 = hVar.mo10823a();
            AbstractC1855b.m6718a("processing a message, action=" + a2);
            switch (a2) {
                case SendMessage:
                    if (!C1900a.m6949a(this.f4875b).mo10185l() || z) {
                        C2089n nVar = (C2089n) a;
                        C2065b l = nVar.mo10973l();
                        if (l == null) {
                            AbstractC1855b.m6723d("receive an empty message without push content, drop it");
                            return null;
                        }
                        if (z) {
                            if (C1982s.m7391b(hVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f4875b, l.mo10676b(), hVar.mo10850m(), hVar.f5739f, l.mo10680d());
                            } else {
                                MiPushClient.reportMessageClicked(this.f4875b, l.mo10676b(), hVar.mo10850m(), l.mo10680d());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(nVar.mo10971j()) && MiPushClient.aliasSetTime(this.f4875b, nVar.mo10971j()) < 0) {
                                MiPushClient.addAlias(this.f4875b, nVar.mo10971j());
                            } else if (!TextUtils.isEmpty(nVar.mo10968h()) && MiPushClient.topicSubscribedTime(this.f4875b, nVar.mo10968h()) < 0) {
                                MiPushClient.addTopic(this.f4875b, nVar.mo10968h());
                            }
                        }
                        String str = (hVar.f5741h == null || hVar.f5741h.mo10731s() == null) ? null : hVar.f5741h.f5576j.get("jobkey");
                        String b = TextUtils.isEmpty(str) ? l.mo10676b() : str;
                        if (z || !m6994a(this.f4875b, b)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(nVar, hVar.mo10850m(), z);
                            if (generateMessage.getPassThrough() != 0 || z || !C1982s.m7386a(generateMessage.getExtra())) {
                                AbstractC1855b.m6718a("receive a message, msgid=" + l.mo10676b() + ", jobkey=" + b);
                                if (!z || generateMessage.getExtra() == null || !generateMessage.getExtra().containsKey("notify_effect")) {
                                    miPushMessage = generateMessage;
                                } else {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    String str2 = extra.get("notify_effect");
                                    if (C1982s.m7391b(hVar)) {
                                        Intent a3 = m6988a(this.f4875b, hVar.f5739f, extra);
                                        if (a3 == null) {
                                            AbstractC1855b.m6718a("Getting Intent fail from ignore reg message. ");
                                            return null;
                                        }
                                        String f = l.mo10683f();
                                        if (!TextUtils.isEmpty(f)) {
                                            a3.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, f);
                                        }
                                        this.f4875b.startActivity(a3);
                                        return null;
                                    }
                                    Intent a4 = m6988a(this.f4875b, this.f4875b.getPackageName(), extra);
                                    if (a4 == null) {
                                        return null;
                                    }
                                    if (!str2.equals(AbstractC1993y.f5154c)) {
                                        a4.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                    }
                                    this.f4875b.startActivity(a4);
                                    return null;
                                }
                            } else {
                                C1982s.m7383a(this.f4875b, hVar, bArr);
                                return null;
                            }
                        } else {
                            AbstractC1855b.m6718a("drop a duplicate message, key=" + b);
                        }
                        if (hVar.mo10850m() != null || z) {
                            return miPushMessage;
                        }
                        m6993a(nVar, hVar.mo10850m());
                        return miPushMessage;
                    }
                    AbstractC1855b.m6718a("receive a message in pause state. drop it");
                    return null;
                case Registration:
                    C2083k kVar = (C2083k) a;
                    if (kVar.f5845f == 0) {
                        C1900a.m6949a(this.f4875b).mo10174b(kVar.f5847h, kVar.f5848i);
                    }
                    if (!TextUtils.isEmpty(kVar.f5847h)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(kVar.f5847h);
                    } else {
                        arrayList3 = null;
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_REGISTER, arrayList3, kVar.f5845f, kVar.f5846g, null);
                    C1910g.m6998a(this.f4875b).mo10214d();
                    return generateCommandMessage;
                case UnRegistration:
                    if (((C2097r) a).f6078f == 0) {
                        C1900a.m6949a(this.f4875b).mo10181h();
                        MiPushClient.clearExtras(this.f4875b);
                    }
                    PushMessageHandler.m6938a();
                    return null;
                case Subscription:
                    C2093p pVar = (C2093p) a;
                    if (pVar.f6007f == 0) {
                        MiPushClient.addTopic(this.f4875b, pVar.mo11016h());
                    }
                    if (!TextUtils.isEmpty(pVar.mo11016h())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(pVar.mo11016h());
                    } else {
                        arrayList2 = null;
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_SUBSCRIBE_TOPIC, arrayList2, pVar.f6007f, pVar.f6008g, pVar.mo11020k());
                case UnSubscription:
                    C2101t tVar = (C2101t) a;
                    if (tVar.f6138f == 0) {
                        MiPushClient.removeTopic(this.f4875b, tVar.mo11097h());
                    }
                    if (!TextUtils.isEmpty(tVar.mo11097h())) {
                        arrayList = new ArrayList();
                        arrayList.add(tVar.mo11097h());
                    } else {
                        arrayList = null;
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC, arrayList, tVar.f6138f, tVar.f6139g, tVar.mo11101k());
                case Command:
                    C2075g gVar = (C2075g) a;
                    String e = gVar.mo10808e();
                    List<String> k = gVar.mo10816k();
                    if (gVar.f5703g == 0) {
                        if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCEPT_TIME) && k != null && k.size() > 1) {
                            MiPushClient.addAcceptTime(this.f4875b, k.get(0), k.get(1));
                            if (!"00:00".equals(k.get(0)) || !"00:00".equals(k.get(1))) {
                                C1900a.m6949a(this.f4875b).mo10171a(false);
                            } else {
                                C1900a.m6949a(this.f4875b).mo10171a(true);
                            }
                            list = mo10200a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), k);
                            return PushMessageHelper.generateCommandMessage(e, list, gVar.f5703g, gVar.f5704h, gVar.mo10818m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.addAlias(this.f4875b, k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, gVar.f5703g, gVar.f5704h, gVar.mo10818m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.removeAlias(this.f4875b, k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, gVar.f5703g, gVar.f5704h, gVar.mo10818m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.addAccount(this.f4875b, k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, gVar.f5703g, gVar.f5704h, gVar.mo10818m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.removeAccount(this.f4875b, k.get(0));
                        }
                    }
                    list = k;
                    return PushMessageHelper.generateCommandMessage(e, list, gVar.f5703g, gVar.f5704h, gVar.mo10818m());
                case Notification:
                    C2079i iVar = (C2079i) a;
                    if ("registration id expired".equalsIgnoreCase(iVar.f5771e)) {
                        MiPushClient.reInitialize(this.f4875b);
                        return null;
                    } else if (!"client_info_update_ok".equalsIgnoreCase(iVar.f5771e) || iVar.mo10872h() == null || !iVar.mo10872h().containsKey(C1447g.f3509d)) {
                        return null;
                    } else {
                        C1900a.m6949a(this.f4875b).mo10169a(iVar.mo10872h().get(C1447g.f3509d));
                        return null;
                    }
                default:
                    return null;
            }
        } catch (C2164f e2) {
            AbstractC1855b.m6720a(e2);
            AbstractC1855b.m6723d("receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* renamed from: a */
    private PushMessageHandler.AbstractC1899a m6990a(C2077h hVar, byte[] bArr) {
        String str = null;
        try {
            AbstractC2158b a = C1906e.m6984a(this.f4875b, hVar);
            if (a == null) {
                AbstractC1855b.m6723d("message arrived: receiving an un-recognized message. " + hVar.f5734a);
                return null;
            }
            AbstractC1855b.m6722c("message arrived: receive a message." + a);
            EnumC2064a a2 = hVar.mo10823a();
            AbstractC1855b.m6718a("message arrived: processing an arrived message, action=" + a2);
            switch (a2) {
                case SendMessage:
                    C2089n nVar = (C2089n) a;
                    C2065b l = nVar.mo10973l();
                    if (l == null) {
                        AbstractC1855b.m6723d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (!(hVar.f5741h == null || hVar.f5741h.mo10731s() == null)) {
                        str = hVar.f5741h.f5576j.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(nVar, hVar.mo10850m(), false);
                    generateMessage.setArrivedMessage(true);
                    AbstractC1855b.m6718a("message arrived: receive a message, msgid=" + l.mo10676b() + ", jobkey=" + str);
                    return generateMessage;
                default:
                    return null;
            }
        } catch (C2164f e) {
            AbstractC1855b.m6720a(e);
            AbstractC1855b.m6723d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* renamed from: a */
    public static C1908f m6991a(Context context) {
        if (f4872a == null) {
            f4872a = new C1908f(context);
        }
        return f4872a;
    }

    /* renamed from: a */
    private void m6992a(C2077h hVar) {
        C2067c m = hVar.mo10850m();
        C2071e eVar = new C2071e();
        eVar.mo10760b(hVar.mo10844h());
        eVar.mo10755a(m.mo10704b());
        eVar.mo10754a(m.mo10711d());
        if (!TextUtils.isEmpty(m.mo10717f())) {
            eVar.mo10762c(m.mo10717f());
        }
        C1910g.m6998a(this.f4875b).mo10207a(eVar, EnumC2064a.AckMessage, false, hVar.mo10850m());
    }

    /* renamed from: a */
    private void m6993a(C2089n nVar, C2067c cVar) {
        C2071e eVar = new C2071e();
        eVar.mo10760b(nVar.mo10964e());
        eVar.mo10755a(nVar.mo10961c());
        eVar.mo10754a(nVar.mo10973l().mo10685h());
        if (!TextUtils.isEmpty(nVar.mo10968h())) {
            eVar.mo10762c(nVar.mo10968h());
        }
        if (!TextUtils.isEmpty(nVar.mo10971j())) {
            eVar.mo10765d(nVar.mo10971j());
        }
        C1910g.m6998a(this.f4875b).mo10205a(eVar, EnumC2064a.AckMessage, cVar);
    }

    /* renamed from: a */
    private static boolean m6994a(Context context, String str) {
        boolean z = false;
        synchronized (f4874d) {
            SharedPreferences j = C1900a.m6949a(context).mo10183j();
            if (f4873c == null) {
                String[] split = j.getString("pref_msg_ids", "").split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                f4873c = new LinkedList();
                for (String str2 : split) {
                    f4873c.add(str2);
                }
            }
            if (f4873c.contains(str)) {
                z = true;
            } else {
                f4873c.add(str);
                if (f4873c.size() > 10) {
                    f4873c.poll();
                }
                String a = C1873d.m6783a(f4873c, MiPushClient.ACCEPT_TIME_SEPARATOR);
                SharedPreferences.Editor edit = j.edit();
                edit.putString("pref_msg_ids", a);
                edit.commit();
            }
        }
        return z;
    }

    /* renamed from: a */
    public PushMessageHandler.AbstractC1899a mo10199a(Intent intent) {
        String action = intent.getAction();
        AbstractC1855b.m6718a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                AbstractC1855b.m6723d("receiving an empty message, drop");
                return null;
            }
            C2077h hVar = new C2077h();
            try {
                C2103u.m8168a(hVar, byteArrayExtra);
                C1900a a = C1900a.m6949a(this.f4875b);
                C2067c m = hVar.mo10850m();
                if (hVar.mo10823a() == EnumC2064a.SendMessage && m != null && !a.mo10185l() && !booleanExtra) {
                    if (m != null) {
                        hVar.mo10850m().mo10698a("mrt", stringExtra);
                        hVar.mo10850m().mo10698a("mat", Long.toString(System.currentTimeMillis()));
                    }
                    m6992a(hVar);
                }
                if (hVar.mo10823a() == EnumC2064a.SendMessage && !hVar.mo10836c()) {
                    if (!C1982s.m7391b(hVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hVar.mo10847j();
                        objArr[1] = m != null ? m.mo10704b() : "";
                        AbstractC1855b.m6718a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        return null;
                    } else if (!booleanExtra || m.mo10731s() == null || !m.mo10731s().containsKey("notify_effect")) {
                        AbstractC1855b.m6718a(String.format("drop an un-encrypted messages. %1$s, %2$s", hVar.mo10847j(), m.mo10704b()));
                        return null;
                    }
                }
                if (a.mo10182i() || hVar.f5734a == EnumC2064a.Registration) {
                    if (!a.mo10182i() || !a.mo10187n()) {
                        return m6989a(hVar, booleanExtra, byteArrayExtra);
                    }
                    if (hVar.f5734a == EnumC2064a.UnRegistration) {
                        a.mo10181h();
                        MiPushClient.clearExtras(this.f4875b);
                        PushMessageHandler.m6938a();
                    } else {
                        MiPushClient.unregisterPush(this.f4875b);
                    }
                } else if (C1982s.m7391b(hVar)) {
                    return m6989a(hVar, booleanExtra, byteArrayExtra);
                } else {
                    AbstractC1855b.m6723d("receive message without registration. need unregister or re-register!");
                }
            } catch (C2164f e) {
                AbstractC1855b.m6720a(e);
            } catch (Exception e2) {
                AbstractC1855b.m6720a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            C2077h hVar2 = new C2077h();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    C2103u.m8168a(hVar2, byteArrayExtra2);
                }
            } catch (C2164f e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(hVar2.mo10823a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            AbstractC1855b.m6723d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                AbstractC1855b.m6723d("message arrived: receiving an empty message, drop");
                return null;
            }
            C2077h hVar3 = new C2077h();
            try {
                C2103u.m8168a(hVar3, byteArrayExtra3);
                C1900a a2 = C1900a.m6949a(this.f4875b);
                if (C1982s.m7391b(hVar3)) {
                    AbstractC1855b.m6723d("message arrived: receive ignore reg message, ignore!");
                } else if (!a2.mo10182i()) {
                    AbstractC1855b.m6723d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!a2.mo10182i() || !a2.mo10187n()) {
                    return m6990a(hVar3, byteArrayExtra3);
                } else {
                    AbstractC1855b.m6723d("message arrived: app info is invalidated");
                }
            } catch (C2164f e4) {
                AbstractC1855b.m6720a(e4);
            } catch (Exception e5) {
                AbstractC1855b.m6720a(e5);
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<String> mo10200a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list.get(0).split(":")[0]);
        long parseLong2 = Long.parseLong(list.get(0).split(":")[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = (((Long.parseLong(list.get(1).split(":")[1]) + (60 * Long.parseLong(list.get(1).split(":")[0]))) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)));
        return arrayList;
    }
}
