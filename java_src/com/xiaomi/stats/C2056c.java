package com.xiaomi.stats;

import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.C2005c;
import com.xiaomi.smack.C2023p;
import java.net.UnknownHostException;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.stats.c */
public final class C2056c {

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.stats.c$a */
    public static class C2057a {

        /* renamed from: a */
        EnumC1997a f5490a;

        /* renamed from: b */
        String f5491b;

        C2057a() {
        }
    }

    /* renamed from: a */
    static C2057a m7735a(Exception exc) {
        m7739e(exc);
        boolean z = exc instanceof C2023p;
        Exception exc2 = exc;
        if (z) {
            Throwable a = ((C2023p) exc).mo10561a();
            exc2 = exc;
            if (a != null) {
                exc2 = ((C2023p) exc).mo10561a();
            }
        }
        C2057a aVar = new C2057a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = C2005c.m7526a(exc2);
        if (a2 != 0) {
            aVar.f5490a = EnumC1997a.m7437a(a2 + EnumC1997a.GSLB_REQUEST_SUCCESS.mo10447a());
        }
        if (aVar.f5490a == null) {
            aVar.f5490a = EnumC1997a.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f5490a == EnumC1997a.GSLB_TCP_ERR_OTHER) {
            aVar.f5491b = str;
        }
        return aVar;
    }

    /* renamed from: b */
    static C2057a m7736b(Exception exc) {
        Throwable cause;
        m7739e(exc);
        boolean z = exc instanceof C2023p;
        Exception exc2 = exc;
        if (z) {
            Throwable a = ((C2023p) exc).mo10561a();
            exc2 = exc;
            if (a != null) {
                exc2 = ((C2023p) exc).mo10561a();
            }
        }
        C2057a aVar = new C2057a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = C2005c.m7526a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            aVar.f5490a = EnumC1997a.m7437a(a2 + EnumC1997a.CONN_SUCCESS.mo10447a());
            if (aVar.f5490a == EnumC1997a.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f5490a = EnumC1997a.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f5490a = EnumC1997a.CONN_XMPP_ERR;
        }
        if (aVar.f5490a == EnumC1997a.CONN_TCP_ERR_OTHER || aVar.f5490a == EnumC1997a.CONN_XMPP_ERR || aVar.f5490a == EnumC1997a.CONN_BOSH_ERR) {
            aVar.f5491b = str;
        }
        return aVar;
    }

    /* renamed from: c */
    static C2057a m7737c(Exception exc) {
        m7739e(exc);
        boolean z = exc instanceof C2023p;
        Exception exc2 = exc;
        if (z) {
            Throwable a = ((C2023p) exc).mo10561a();
            exc2 = exc;
            if (a != null) {
                exc2 = ((C2023p) exc).mo10561a();
            }
        }
        C2057a aVar = new C2057a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (C2005c.m7526a(exc2)) {
            case 105:
                aVar.f5490a = EnumC1997a.BIND_TCP_READ_TIMEOUT;
                break;
            case 109:
                aVar.f5490a = EnumC1997a.BIND_TCP_CONNRESET;
                break;
            case 110:
                aVar.f5490a = EnumC1997a.BIND_TCP_BROKEN_PIPE;
                break;
            case 199:
                aVar.f5490a = EnumC1997a.BIND_TCP_ERR;
                break;
            case 499:
                aVar.f5490a = EnumC1997a.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.f5490a = EnumC1997a.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                aVar.f5490a = EnumC1997a.BIND_XMPP_ERR;
                break;
        }
        if (aVar.f5490a == EnumC1997a.BIND_TCP_ERR || aVar.f5490a == EnumC1997a.BIND_XMPP_ERR || aVar.f5490a == EnumC1997a.BIND_BOSH_ERR) {
            aVar.f5491b = str;
        }
        return aVar;
    }

    /* renamed from: d */
    static C2057a m7738d(Exception exc) {
        m7739e(exc);
        boolean z = exc instanceof C2023p;
        Exception exc2 = exc;
        if (z) {
            Throwable a = ((C2023p) exc).mo10561a();
            exc2 = exc;
            if (a != null) {
                exc2 = ((C2023p) exc).mo10561a();
            }
        }
        C2057a aVar = new C2057a();
        String message = exc2.getMessage();
        String str = exc2.getClass().getSimpleName() + ":" + message;
        switch (C2005c.m7526a(exc2)) {
            case 105:
                aVar.f5490a = EnumC1997a.CHANNEL_TCP_READTIMEOUT;
                break;
            case 109:
                aVar.f5490a = EnumC1997a.CHANNEL_TCP_CONNRESET;
                break;
            case 110:
                aVar.f5490a = EnumC1997a.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case 199:
                aVar.f5490a = EnumC1997a.CHANNEL_TCP_ERR;
                break;
            case 499:
                aVar.f5490a = EnumC1997a.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    aVar.f5490a = EnumC1997a.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                aVar.f5490a = EnumC1997a.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (aVar.f5490a == EnumC1997a.CHANNEL_TCP_ERR || aVar.f5490a == EnumC1997a.CHANNEL_XMPPEXCEPTION || aVar.f5490a == EnumC1997a.CHANNEL_BOSH_EXCEPTION) {
            aVar.f5491b = str;
        }
        return aVar;
    }

    /* renamed from: e */
    private static void m7739e(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }
}
