package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.google.protobuf.micro.C0399c;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C1919b;
import com.xiaomi.push.protobuf.C1930b;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.C2004b;
import com.xiaomi.smack.C2015k;
import com.xiaomi.smack.C2019l;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.packet.C2025b;
import com.xiaomi.smack.packet.C2027c;
import com.xiaomi.smack.packet.C2034h;
import com.xiaomi.smack.util.C2049k;
import com.xiaomi.stats.C2062g;
import java.util.Date;

public class PacketSync {

    /* renamed from: a */
    private XMPushService f4991a;

    public interface PacketReceiveHandler extends Parcelable {
    }

    PacketSync(XMPushService xMPushService) {
        this.f4991a = xMPushService;
    }

    /* renamed from: a */
    private void m7172a(C2024a aVar) {
        String c = aVar.mo10571c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C2004b.m7515b(), false);
            if (fallbacksByHost != null && split.length > 0) {
                fallbacksByHost.mo10235a(split);
                this.f4991a.mo10349a(20, (Exception) null);
                this.f4991a.mo10356a(true);
            }
        }
    }

    /* renamed from: b */
    private void m7173b(AbstractC2028d dVar) {
        C1987w.C1989b b;
        String m = dVar.mo10613m();
        String l = dVar.mo10611l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l) && (b = C1987w.m7406a().mo10435b(l, m)) != null) {
            C2049k.m7718a(this.f4991a, b.f5127a, (long) C2049k.m7714a(dVar.mo10546a()), true, System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    public void mo10342a(AbstractC2028d dVar) {
        C2024a p;
        C1987w.C1989b b;
        if (!"5".equals(dVar.mo10611l())) {
            m7173b(dVar);
        }
        if (dVar instanceof C2015k.C2017b) {
            C2015k.C2017b bVar = (C2015k.C2017b) dVar;
            C2015k.C2017b.C2018a b2 = bVar.mo10548b();
            String l = bVar.mo10611l();
            String m = bVar.mo10613m();
            if (TextUtils.isEmpty(l) || (b = C1987w.m7406a().mo10435b(l, m)) == null) {
                return;
            }
            if (b2 == C2015k.C2017b.C2018a.f5331a) {
                b.mo10445a(C1987w.EnumC1991c.binded, 1, 0, null, null);
                AbstractC1855b.m6718a("SMACK: channel bind succeeded, chid=" + l);
                return;
            }
            C2034h p2 = bVar.mo10620p();
            AbstractC1855b.m6718a("SMACK: channel bind failed, error=" + p2.mo10634d());
            if (p2 != null) {
                if ("auth".equals(p2.mo10632b())) {
                    if ("invalid-sig".equals(p2.mo10631a())) {
                        AbstractC1855b.m6718a("SMACK: bind error invalid-sig token = " + b.f5129c + " sec = " + b.f5135i);
                        C2062g.m7762a(0, EnumC1997a.BIND_INVALID_SIG.mo10447a(), 1, null, 0);
                    }
                    b.mo10445a(C1987w.EnumC1991c.unbind, 1, 5, p2.mo10631a(), p2.mo10632b());
                    C1987w.m7406a().mo10434a(l, m);
                } else if ("cancel".equals(p2.mo10632b())) {
                    b.mo10445a(C1987w.EnumC1991c.unbind, 1, 7, p2.mo10631a(), p2.mo10632b());
                    C1987w.m7406a().mo10434a(l, m);
                } else if ("wait".equals(p2.mo10632b())) {
                    this.f4991a.mo10361b(b);
                    b.mo10445a(C1987w.EnumC1991c.unbind, 1, 7, p2.mo10631a(), p2.mo10632b());
                }
                AbstractC1855b.m6718a("SMACK: channel bind failed, chid=" + l + " reason=" + p2.mo10631a());
                return;
            }
            return;
        }
        String l2 = dVar.mo10611l();
        if (TextUtils.isEmpty(l2)) {
            l2 = "1";
            dVar.mo10612l(l2);
        }
        if (!l2.equals("0")) {
            if (dVar instanceof C2025b) {
                C2024a p3 = dVar.mo10619p("kick");
                if (p3 != null) {
                    String m2 = dVar.mo10613m();
                    String a = p3.mo10568a("type");
                    String a2 = p3.mo10568a("reason");
                    AbstractC1855b.m6718a("kicked by server, chid=" + l2 + " userid=" + m2 + " type=" + a + " reason=" + a2);
                    if ("wait".equals(a)) {
                        C1987w.C1989b b3 = C1987w.m7406a().mo10435b(l2, m2);
                        if (b3 != null) {
                            this.f4991a.mo10361b(b3);
                            b3.mo10445a(C1987w.EnumC1991c.unbind, 3, 0, a2, a);
                            return;
                        }
                        return;
                    }
                    this.f4991a.mo10354a(l2, m2, 3, a2, a);
                    C1987w.m7406a().mo10434a(l2, m2);
                    return;
                }
            } else if (dVar instanceof C2027c) {
                C2027c cVar = (C2027c) dVar;
                if ("redir".equals(cVar.mo10587b())) {
                    C2024a p4 = cVar.mo10619p("hosts");
                    if (p4 != null) {
                        m7172a(p4);
                        return;
                    }
                    return;
                }
            }
            this.f4991a.mo10366d().mo10403a(this.f4991a, l2, dVar);
        } else if (dVar instanceof C2025b) {
            C2025b bVar2 = (C2025b) dVar;
            if ("0".equals(dVar.mo10609k()) && "result".equals(bVar2.mo10580b().toString())) {
                AbstractC2002a g = this.f4991a.mo10369g();
                if (g instanceof C2019l) {
                    ((C2019l) g).mo10559w();
                }
                C2062g.m7767b();
            } else if ("command".equals(bVar2.mo10580b().toString()) && (p = dVar.mo10619p("u")) != null) {
                String a3 = p.mo10568a("url");
                String a4 = p.mo10568a("startts");
                String a5 = p.mo10568a("endts");
                try {
                    Date date = new Date(Long.parseLong(a4));
                    Date date2 = new Date(Long.parseLong(a5));
                    String a6 = p.mo10568a(AssistPushConsts.MSG_TYPE_TOKEN);
                    boolean equals = "true".equals(p.mo10568a("force"));
                    String a7 = p.mo10568a("maxlen");
                    C1919b.m7106a(this.f4991a).mo10308a(a3, a6, date2, date, !TextUtils.isEmpty(a7) ? Integer.parseInt(a7) * 1024 : 0, equals);
                } catch (NumberFormatException e) {
                    AbstractC1855b.m6718a("parseLong fail " + e.getMessage());
                }
            }
            if (bVar2.mo10576a("ps") != null) {
                try {
                    C1951af.m7272a().mo10387a(C1930b.C1931a.m7154b(Base64.decode(bVar2.mo10576a("ps"), 8)));
                } catch (IllegalArgumentException e2) {
                    AbstractC1855b.m6718a("invalid Base64 exception + " + e2.getMessage());
                } catch (C0399c e3) {
                    AbstractC1855b.m6718a("invalid pb exception + " + e3.getMessage());
                }
            }
        }
    }
}
