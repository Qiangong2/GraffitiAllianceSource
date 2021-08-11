package com.xiaomi.push.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1856a;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.string.C1870a;
import com.xiaomi.channel.commonutils.string.C1872c;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C1919b;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.timers.C1984a;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.AbstractC2006d;
import com.xiaomi.smack.AbstractC2009f;
import com.xiaomi.smack.C2004b;
import com.xiaomi.smack.C2019l;
import com.xiaomi.smack.C2023p;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.packet.C2025b;
import com.xiaomi.smack.packet.C2027c;
import com.xiaomi.smack.packet.C2030f;
import com.xiaomi.smack.util.C2045g;
import com.xiaomi.smack.util.C2046h;
import com.xiaomi.stats.C2062g;
import com.xiaomi.xmpush.thrift.C2069d;
import com.xiaomi.xmpush.thrift.C2077h;
import com.xiaomi.xmpush.thrift.C2079i;
import com.xiaomi.xmpush.thrift.C2081j;
import com.xiaomi.xmpush.thrift.C2103u;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2164f;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class XMPushService extends Service implements AbstractC2006d {

    /* renamed from: a */
    public static int f4992a = 1;

    /* renamed from: b */
    private C2004b f4993b;

    /* renamed from: c */
    private C1949ad f4994c;

    /* renamed from: d */
    private long f4995d = 0;

    /* renamed from: e */
    private C2019l f4996e;

    /* renamed from: f */
    private AbstractC2002a f4997f;

    /* renamed from: g */
    private C1964b f4998g;

    /* renamed from: h */
    private PacketSync f4999h = null;

    /* renamed from: i */
    private C1984a f5000i = null;

    /* renamed from: j */
    private HandlerThreadC1966d f5001j = null;

    /* renamed from: k */
    private AbstractC2009f f5002k = new C1954ah(this);

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    public class C1933a extends AbstractC1937e {

        /* renamed from: a */
        C1987w.C1989b f5003a = null;

        public C1933a(C1987w.C1989b bVar) {
            super(9);
            this.f5003a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            try {
                if (!XMPushService.this.mo10367e()) {
                    AbstractC1855b.m6723d("trying bind while the connection is not created, quit!");
                    return;
                }
                C1987w.C1989b b = C1987w.m7406a().mo10435b(this.f5003a.f5134h, this.f5003a.f5128b);
                if (b == null) {
                    AbstractC1855b.m6718a("ignore bind because the channel " + this.f5003a.f5134h + " is removed ");
                } else if (b.f5139m == C1987w.EnumC1991c.unbind) {
                    b.mo10445a(C1987w.EnumC1991c.binding, 0, 0, null, null);
                    XMPushService.this.f4997f.mo10496a(b);
                    C2062g.m7764a(XMPushService.this, b);
                } else {
                    AbstractC1855b.m6718a("trying duplicate bind, ingore! " + b.f5139m);
                }
            } catch (C2023p e) {
                AbstractC1855b.m6720a(e);
                XMPushService.this.mo10349a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "bind the client. " + this.f5003a.f5134h + ", " + this.f5003a.f5128b;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    public static class C1934b extends AbstractC1937e {

        /* renamed from: a */
        private final C1987w.C1989b f5005a;

        public C1934b(C1987w.C1989b bVar) {
            super(12);
            this.f5005a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            this.f5005a.mo10445a(C1987w.EnumC1991c.unbind, 1, 21, null, null);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "bind time out. chid=" + this.f5005a.f5134h;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1934b)) {
                return false;
            }
            return TextUtils.equals(((C1934b) obj).f5005a.f5134h, this.f5005a.f5134h);
        }

        public int hashCode() {
            return this.f5005a.f5134h.hashCode();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    public class C1935c extends AbstractC1937e {
        C1935c() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            if (XMPushService.this.mo10359a()) {
                XMPushService.this.m7192k();
            } else {
                AbstractC1855b.m6718a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "do reconnect..";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    public class C1936d extends AbstractC1937e {

        /* renamed from: a */
        public int f5007a;

        /* renamed from: b */
        public Exception f5008b;

        C1936d(int i, Exception exc) {
            super(2);
            this.f5007a = i;
            this.f5008b = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            XMPushService.this.mo10349a(this.f5007a, this.f5008b);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "disconnect the connection.";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    public static abstract class AbstractC1937e {

        /* renamed from: e */
        protected int f5010e;

        public AbstractC1937e(int i) {
            this.f5010e = i;
        }

        /* renamed from: a */
        public abstract void mo10376a();

        /* renamed from: b */
        public abstract String mo10377b();

        /* renamed from: c */
        public void mo10380c() {
            if (!(this.f5010e == 4 || this.f5010e == 8)) {
                AbstractC1855b.m6718a("JOB: " + mo10377b());
            }
            mo10376a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    class C1938f extends AbstractC1937e {
        public C1938f() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            XMPushService.this.f5001j.quit();
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "ask the job queue to quit";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    public class BinderC1939g extends Binder {
        public BinderC1939g() {
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    class C1940h extends AbstractC1937e {

        /* renamed from: b */
        private AbstractC2028d f5014b = null;

        public C1940h(AbstractC2028d dVar) {
            super(8);
            this.f5014b = dVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            XMPushService.this.f4999h.mo10342a(this.f5014b);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "receive a message.";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    public class C1941i extends AbstractC1937e {
        public C1941i() {
            super(4);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            if (XMPushService.this.mo10367e()) {
                try {
                    C2062g.m7759a();
                    XMPushService.this.f4997f.mo10519m();
                } catch (C2023p e) {
                    AbstractC1855b.m6720a(e);
                    XMPushService.this.mo10349a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "send ping..";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    public class C1942j extends AbstractC1937e {

        /* renamed from: a */
        C1987w.C1989b f5016a = null;

        public C1942j(C1987w.C1989b bVar) {
            super(4);
            this.f5016a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            try {
                this.f5016a.mo10445a(C1987w.EnumC1991c.unbind, 1, 16, null, null);
                XMPushService.this.f4997f.mo10502a(this.f5016a.f5134h, this.f5016a.f5128b);
                this.f5016a.mo10445a(C1987w.EnumC1991c.binding, 1, 16, null, null);
                XMPushService.this.f4997f.mo10496a(this.f5016a);
            } catch (C2023p e) {
                AbstractC1855b.m6720a(e);
                XMPushService.this.mo10349a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "bind the client. " + this.f5016a.f5134h + ", " + this.f5016a.f5128b;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    public class C1943k extends AbstractC1937e {
        C1943k() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            XMPushService.this.mo10349a(11, (Exception) null);
            if (XMPushService.this.mo10359a()) {
                XMPushService.this.m7192k();
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "reset the connection.";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    public class C1944l extends AbstractC1937e {

        /* renamed from: a */
        C1987w.C1989b f5019a = null;

        /* renamed from: b */
        int f5020b;

        /* renamed from: c */
        String f5021c;

        /* renamed from: d */
        String f5022d;

        public C1944l(C1987w.C1989b bVar, int i, String str, String str2) {
            super(9);
            this.f5019a = bVar;
            this.f5020b = i;
            this.f5021c = str;
            this.f5022d = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: a */
        public void mo10376a() {
            if (!(this.f5019a.f5139m == C1987w.EnumC1991c.unbind || XMPushService.this.f4997f == null)) {
                try {
                    XMPushService.this.f4997f.mo10502a(this.f5019a.f5134h, this.f5019a.f5128b);
                } catch (C2023p e) {
                    AbstractC1855b.m6720a(e);
                    XMPushService.this.mo10349a(10, e);
                }
            }
            this.f5019a.mo10445a(C1987w.EnumC1991c.unbind, this.f5020b, 0, this.f5022d, this.f5021c);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
        /* renamed from: b */
        public String mo10377b() {
            return "unbind the channel. " + this.f5019a.f5134h + ", " + this.f5019a.f5128b;
        }
    }

    static {
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        C2019l.f5288a = true;
    }

    /* renamed from: a */
    private C2027c m7177a(C2027c cVar, String str) {
        byte[] a = C1948ac.m7260a(str, cVar.mo10609k());
        C2027c cVar2 = new C2027c();
        cVar2.mo10616n(cVar.mo10615n());
        cVar2.mo10614m(cVar.mo10613m());
        cVar2.mo10610k(cVar.mo10609k());
        cVar2.mo10612l(cVar.mo10611l());
        cVar2.mo10589b(true);
        String a2 = C1948ac.m7256a(a, C2045g.m7705c(cVar.mo10546a()));
        C2024a aVar = new C2024a("s", null, null, null);
        aVar.mo10570b(a2);
        cVar2.mo10606a(aVar);
        return cVar2;
    }

    /* renamed from: a */
    private AbstractC2028d m7178a(AbstractC2028d dVar, String str, String str2, boolean z) {
        C1987w a = C1987w.m7406a();
        List<String> b = a.mo10437b(str);
        if (b.isEmpty()) {
            AbstractC1855b.m6718a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            dVar.mo10618o(str);
            String l = dVar.mo10611l();
            if (TextUtils.isEmpty(l)) {
                l = b.get(0);
                dVar.mo10612l(l);
            }
            C1987w.C1989b b2 = a.mo10435b(l, dVar.mo10615n());
            if (!mo10367e()) {
                AbstractC1855b.m6718a("drop a packet as the channel is not connected, chid=" + l);
            } else if (b2 == null || b2.f5139m != C1987w.EnumC1991c.binded) {
                AbstractC1855b.m6718a("drop a packet as the channel is not opened, chid=" + l);
            } else if (TextUtils.equals(str2, b2.f5136j)) {
                return (!(dVar instanceof C2027c) || !z) ? dVar : m7177a((C2027c) dVar, b2.f5135i);
            } else {
                AbstractC1855b.m6718a("invalid session. " + str2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m7179a(String str) {
        return "<iq to='" + str + "' id='0' chid='0' type='get'><ping xmlns='urn:xmpp:ping'>%1$s%2$s</ping></iq>";
    }

    /* renamed from: a */
    private void m7180a(String str, int i) {
        Collection<C1987w.C1989b> c = C1987w.m7406a().mo10439c(str);
        if (c != null) {
            for (C1987w.C1989b bVar : c) {
                if (bVar != null) {
                    mo10350a(new C1944l(bVar, i, null, null));
                }
            }
        }
        C1987w.m7406a().mo10433a(str);
    }

    /* renamed from: a */
    private boolean m7181a(String str, Intent intent) {
        C1987w.C1989b b = C1987w.m7406a().mo10435b(str, intent.getStringExtra(AbstractC1993y.f5167p));
        boolean z = false;
        if (b == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AbstractC1993y.f5150B);
        String stringExtra2 = intent.getStringExtra(AbstractC1993y.f5172u);
        if (!TextUtils.isEmpty(b.f5136j) && !TextUtils.equals(stringExtra, b.f5136j)) {
            AbstractC1855b.m6718a("session changed. old session=" + b.f5136j + ", new session=" + stringExtra);
            z = true;
        }
        if (stringExtra2.equals(b.f5135i)) {
            return z;
        }
        AbstractC1855b.m6718a("security changed. ");
        return true;
    }

    /* renamed from: b */
    private C1987w.C1989b m7182b(String str, Intent intent) {
        C1987w.C1989b b = C1987w.m7406a().mo10435b(str, intent.getStringExtra(AbstractC1993y.f5167p));
        if (b == null) {
            b = new C1987w.C1989b(this);
        }
        b.f5134h = intent.getStringExtra(AbstractC1993y.f5168q);
        b.f5128b = intent.getStringExtra(AbstractC1993y.f5167p);
        b.f5129c = intent.getStringExtra(AbstractC1993y.f5170s);
        b.f5127a = intent.getStringExtra(AbstractC1993y.f5176y);
        b.f5132f = intent.getStringExtra(AbstractC1993y.f5174w);
        b.f5133g = intent.getStringExtra(AbstractC1993y.f5175x);
        b.f5131e = intent.getBooleanExtra(AbstractC1993y.f5173v, false);
        b.f5135i = intent.getStringExtra(AbstractC1993y.f5172u);
        b.f5136j = intent.getStringExtra(AbstractC1993y.f5150B);
        b.f5130d = intent.getStringExtra(AbstractC1993y.f5171t);
        b.f5137k = this.f4998g;
        b.f5138l = getApplicationContext();
        C1987w.m7406a().mo10432a(b);
        return b;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private void m7190i() {
        if (C1970h.m7328a(getApplicationContext()) != null) {
            C1987w.C1989b a = C1970h.m7328a(getApplicationContext()).mo10414a(this);
            mo10352a(a);
            C1987w.m7406a().mo10432a(a);
            if (C1865d.m6762d(getApplicationContext())) {
                mo10356a(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m7191j() {
        if (!mo10359a()) {
            this.f5000i.mo10424a();
        } else if (!this.f5000i.mo10427b()) {
            this.f5000i.mo10426a(true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: k */
    private void m7192k() {
        if (this.f4997f != null && this.f4997f.mo10513g()) {
            AbstractC1855b.m6723d("try to connect while connecting.");
        } else if (this.f4997f == null || !this.f4997f.mo10514h()) {
            this.f4993b.mo10527b(C1865d.m6764f(this));
            m7193l();
            if (this.f4997f == null) {
                C1987w.m7406a().mo10429a(this);
                sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
        } else {
            AbstractC1855b.m6723d("try to connect while is connected.");
        }
    }

    /* renamed from: l */
    private void m7193l() {
        try {
            this.f4996e.mo10498a(this.f5002k, new C1963aq(this));
            this.f4996e.mo10555s();
            this.f4997f = this.f4996e;
        } catch (C2023p e) {
            AbstractC1855b.m6719a("fail to create xmpp connection", e);
            this.f4996e.mo10500a(new C2030f(C2030f.EnumC2032b.unavailable), 3, e);
        }
    }

    /* renamed from: a */
    public C2019l mo10343a(C2004b bVar) {
        return new C2019l(this, bVar);
    }

    /* renamed from: a */
    public C2027c mo10344a(C2077h hVar) {
        try {
            C2027c cVar = new C2027c();
            cVar.mo10612l("5");
            cVar.mo10614m("xiaomi.com");
            cVar.mo10616n(C1970h.m7328a(this).f5072a);
            cVar.mo10589b(true);
            cVar.mo10597f("push");
            cVar.mo10618o(hVar.f5739f);
            String str = C1970h.m7328a(this).f5072a;
            hVar.f5740g.f5603b = str.substring(0, str.indexOf("@"));
            hVar.f5740g.f5605d = str.substring(str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
            String valueOf = String.valueOf(C1870a.m6774a(C1948ac.m7261a(C1948ac.m7260a(C1970h.m7328a(this).f5074c, cVar.mo10609k()), C2103u.m8169a(hVar))));
            C2024a aVar = new C2024a("s", null, null, null);
            aVar.mo10570b(valueOf);
            cVar.mo10606a(aVar);
            AbstractC1855b.m6718a("try send mi push message. packagename:" + hVar.f5739f + " action:" + hVar.f5734a);
            return cVar;
        } catch (NullPointerException e) {
            AbstractC1855b.m6720a(e);
            return null;
        }
    }

    /* renamed from: a */
    public C2027c mo10345a(byte[] bArr) {
        C2077h hVar = new C2077h();
        try {
            C2103u.m8168a(hVar, bArr);
            return mo10344a(hVar);
        } catch (C2164f e) {
            AbstractC1855b.m6720a(e);
            return null;
        }
    }

    /* renamed from: a */
    public C2077h mo10346a(String str, String str2) {
        C2079i iVar = new C2079i();
        iVar.mo10861b(str2);
        iVar.mo10864c("package uninstalled");
        iVar.mo10855a(AbstractC2028d.m7637j());
        iVar.mo10857a(false);
        return mo10347a(str, str2, iVar, EnumC2064a.Notification);
    }

    /* renamed from: a */
    public <T extends AbstractC2158b<T, ?>> C2077h mo10347a(String str, String str2, T t, EnumC2064a aVar) {
        byte[] a = C2103u.m8169a(t);
        C2077h hVar = new C2077h();
        C2069d dVar = new C2069d();
        dVar.f5602a = 5;
        dVar.f5603b = "fakeid";
        hVar.mo10826a(dVar);
        hVar.mo10828a(ByteBuffer.wrap(a));
        hVar.mo10824a(aVar);
        hVar.mo10835c(true);
        hVar.mo10832b(str);
        hVar.mo10829a(false);
        hVar.mo10827a(str2);
        return hVar;
    }

    /* renamed from: a */
    public void mo10348a(int i) {
        this.f5001j.mo10407a(i);
    }

    /* renamed from: a */
    public void mo10349a(int i, Exception exc) {
        AbstractC1855b.m6718a("disconnect " + hashCode() + ", " + (this.f4997f == null ? null : Integer.valueOf(this.f4997f.hashCode())));
        if (this.f4997f != null) {
            this.f4997f.mo10500a(new C2030f(C2030f.EnumC2032b.unavailable), i, exc);
            this.f4997f = null;
        }
        mo10348a(7);
        mo10348a(4);
        C1987w.m7406a().mo10430a(this, i);
    }

    /* renamed from: a */
    public void mo10350a(AbstractC1937e eVar) {
        mo10351a(eVar, 0);
    }

    /* renamed from: a */
    public void mo10351a(AbstractC1937e eVar, long j) {
        this.f5001j.mo10409a(eVar, j);
    }

    /* renamed from: a */
    public void mo10352a(C1987w.C1989b bVar) {
        bVar.mo10444a(new C1961ao(this));
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10106a(AbstractC2002a aVar) {
        this.f4994c.mo10385a();
        Iterator<C1987w.C1989b> it = C1987w.m7406a().mo10436b().iterator();
        while (it.hasNext()) {
            mo10350a(new C1933a(it.next()));
        }
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10107a(AbstractC2002a aVar, int i, Exception exc) {
        mo10356a(false);
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10108a(AbstractC2002a aVar, Exception exc) {
        mo10356a(false);
    }

    /* renamed from: a */
    public void mo10353a(AbstractC2028d dVar) {
        if (this.f4997f != null) {
            this.f4997f.mo10499a(dVar);
            return;
        }
        throw new C2023p("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void mo10354a(String str, String str2, int i, String str3, String str4) {
        C1987w.C1989b b = C1987w.m7406a().mo10435b(str, str2);
        if (b != null) {
            mo10350a(new C1944l(b, i, str4, str3));
        }
        C1987w.m7406a().mo10434a(str, str2);
    }

    /* renamed from: a */
    public void mo10355a(String str, byte[] bArr) {
        if (this.f4997f != null) {
            C2027c a = mo10345a(bArr);
            if (a != null) {
                this.f4997f.mo10499a(a);
            } else {
                C1973k.m7341a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new C2023p("try send msg while connection is null.");
        }
    }

    /* renamed from: a */
    public void mo10356a(boolean z) {
        this.f4994c.mo10386a(z);
    }

    /* renamed from: a */
    public void mo10357a(byte[] bArr, String str) {
        if (bArr == null) {
            C1973k.m7341a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            AbstractC1855b.m6718a("register request without payload");
            return;
        }
        C2077h hVar = new C2077h();
        try {
            C2103u.m8168a(hVar, bArr);
            if (hVar.f5734a == EnumC2064a.Registration) {
                C2081j jVar = new C2081j();
                try {
                    C2103u.m8168a(jVar, hVar.mo10842f());
                    C1973k.m7343a(hVar.mo10847j(), bArr);
                    mo10350a(new C1972j(this, hVar.mo10847j(), jVar.mo10890d(), jVar.mo10897h(), bArr));
                } catch (C2164f e) {
                    AbstractC1855b.m6720a(e);
                    C1973k.m7341a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C1973k.m7341a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                AbstractC1855b.m6718a("register request with invalid payload");
            }
        } catch (C2164f e2) {
            AbstractC1855b.m6720a(e2);
            C1973k.m7341a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* renamed from: a */
    public void mo10358a(AbstractC2028d[] dVarArr) {
        if (this.f4997f != null) {
            this.f4997f.mo10503a(dVarArr);
            return;
        }
        throw new C2023p("try send msg while connection is null.");
    }

    /* renamed from: a */
    public boolean mo10359a() {
        return C1865d.m6762d(this) && C1987w.m7406a().mo10438c() > 0 && !mo10363b();
    }

    /* renamed from: b */
    public void mo10360b(AbstractC1937e eVar) {
        this.f5001j.mo10408a(eVar.f5010e, eVar);
    }

    /* renamed from: b */
    public void mo10361b(C1987w.C1989b bVar) {
        if (bVar != null) {
            long a = bVar.mo10442a();
            AbstractC1855b.m6718a("schedule rebind job in " + (a / 1000));
            mo10351a(new C1933a(bVar), a);
        }
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: b */
    public void mo10109b(AbstractC2002a aVar) {
        AbstractC1855b.m6722c("begin to connect...");
    }

    /* renamed from: b */
    public void mo10362b(C2077h hVar) {
        if (this.f4997f != null) {
            C2027c a = mo10344a(hVar);
            if (a != null) {
                this.f4997f.mo10499a(a);
                return;
            }
            return;
        }
        throw new C2023p("try send msg while connection is null.");
    }

    /* renamed from: b */
    public boolean mo10363b() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            return cls.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || cls.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo10364b(int i) {
        return this.f5001j.mo10411b(i);
    }

    /* renamed from: c */
    public C1964b mo10365c() {
        return new C1964b();
    }

    /* renamed from: d */
    public C1964b mo10366d() {
        return this.f4998g;
    }

    /* renamed from: e */
    public boolean mo10367e() {
        return this.f4997f != null && this.f4997f.mo10514h();
    }

    /* renamed from: f */
    public boolean mo10368f() {
        return this.f4997f != null && this.f4997f.mo10513g();
    }

    /* renamed from: g */
    public AbstractC2002a mo10369g() {
        return this.f4997f;
    }

    /* renamed from: h */
    public void mo10370h() {
        mo10351a(new C1955ai(this, 10), 120000);
    }

    public IBinder onBind(Intent intent) {
        return new BinderC1939g();
    }

    public void onCreate() {
        super.onCreate();
        C2046h.m7707a(this);
        C1969g a = C1970h.m7328a(this);
        if (a != null) {
            C1856a.m6725a(a.f5078g);
        }
        C1994z.m7432a(this);
        this.f4993b = new C1956aj(this, null, 5222, "xiaomi.com", null);
        this.f4993b.mo10526a(true);
        this.f4996e = mo10343a(this.f4993b);
        this.f4996e.mo10552b(m7179a("xiaomi.com"));
        new Fallback("mibind.chat.gslb.mi-idc.com");
        this.f4998g = mo10365c();
        try {
            if (TextUtils.equals((String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "sys.boot_completed"), "1")) {
                this.f4998g.mo10399a(this);
            }
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
        }
        this.f5000i = new C1984a(this);
        this.f4996e.mo10497a(this);
        this.f4999h = new PacketSync(this);
        this.f4994c = new C1949ad(this);
        new C1965c().mo10404a();
        this.f5001j = new HandlerThreadC1966d("Connection Controller Thread");
        this.f5001j.start();
        mo10350a(new C1957ak(this, 11));
        C1987w a2 = C1987w.m7406a();
        a2.mo10441e();
        a2.mo10431a(new C1958al(this));
    }

    public void onDestroy() {
        this.f5001j.mo10406a();
        mo10350a(new C1962ap(this, 2));
        mo10350a(new C1938f());
        C1987w.m7406a().mo10441e();
        C1987w.m7406a().mo10430a(this, 15);
        C1987w.m7406a().mo10440d();
        this.f4996e.mo10506b(this);
        C1951af.m7272a().mo10389b();
        this.f5000i.mo10424a();
        super.onDestroy();
        AbstractC1855b.m6718a("Service destroyed");
    }

    public void onStart(Intent intent, int i) {
        String b;
        int i2;
        NetworkInfo networkInfo;
        C1987w.C1989b bVar = null;
        boolean z = true;
        int i3 = 0;
        if (intent == null) {
            AbstractC1855b.m6723d("onStart() with intent NULL");
        } else {
            AbstractC1855b.m6722c(String.format("onStart() with intent.Action = %s, chid = %s", intent.getAction(), intent.getStringExtra(AbstractC1993y.f5168q)));
        }
        C1987w a = C1987w.m7406a();
        if (intent != null && intent.getAction() != null) {
            if (AbstractC1993y.f5155d.equalsIgnoreCase(intent.getAction()) || AbstractC1993y.f5161j.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(AbstractC1993y.f5168q);
                if (TextUtils.isEmpty(intent.getStringExtra(AbstractC1993y.f5172u))) {
                    AbstractC1855b.m6718a("security is empty. ignore.");
                } else if (stringExtra != null) {
                    boolean a2 = m7181a(stringExtra, intent);
                    C1987w.C1989b b2 = m7182b(stringExtra, intent);
                    if (!C1865d.m6762d(this)) {
                        this.f4998g.mo10402a(this, b2, false, 2, null);
                    } else if (!mo10367e()) {
                        mo10356a(true);
                    } else if (b2.f5139m == C1987w.EnumC1991c.unbind) {
                        mo10350a(new C1933a(b2));
                    } else if (a2) {
                        mo10350a(new C1942j(b2));
                    } else if (b2.f5139m == C1987w.EnumC1991c.binding) {
                        AbstractC1855b.m6718a(String.format("the client is binding. %1$s %2$s.", b2.f5134h, b2.f5128b));
                    } else if (b2.f5139m == C1987w.EnumC1991c.binded) {
                        this.f4998g.mo10402a(this, b2, true, 0, null);
                    }
                } else {
                    AbstractC1855b.m6723d("channel id is empty, do nothing!");
                }
            } else if (AbstractC1993y.f5160i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra2 = intent.getStringExtra(AbstractC1993y.f5176y);
                String stringExtra3 = intent.getStringExtra(AbstractC1993y.f5168q);
                String stringExtra4 = intent.getStringExtra(AbstractC1993y.f5167p);
                if (TextUtils.isEmpty(stringExtra3)) {
                    for (String str : a.mo10437b(stringExtra2)) {
                        m7180a(str, 2);
                    }
                } else if (TextUtils.isEmpty(stringExtra4)) {
                    m7180a(stringExtra3, 2);
                } else {
                    mo10354a(stringExtra3, stringExtra4, 2, null, null);
                }
            } else if (AbstractC1993y.f5156e.equalsIgnoreCase(intent.getAction())) {
                AbstractC2028d a3 = m7178a(new C2027c(intent.getBundleExtra("ext_packet")), intent.getStringExtra(AbstractC1993y.f5176y), intent.getStringExtra(AbstractC1993y.f5150B), intent.getBooleanExtra("ext_encrypt", true));
                if (a3 != null) {
                    mo10350a(new C1950ae(this, a3));
                }
            } else if (AbstractC1993y.f5158g.equalsIgnoreCase(intent.getAction())) {
                String stringExtra5 = intent.getStringExtra(AbstractC1993y.f5176y);
                String stringExtra6 = intent.getStringExtra(AbstractC1993y.f5150B);
                Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
                C2027c[] cVarArr = new C2027c[parcelableArrayExtra.length];
                boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
                while (i3 < parcelableArrayExtra.length) {
                    cVarArr[i3] = new C2027c((Bundle) parcelableArrayExtra[i3]);
                    cVarArr[i3] = (C2027c) m7178a(cVarArr[i3], stringExtra5, stringExtra6, booleanExtra);
                    if (cVarArr[i3] != null) {
                        i3++;
                    } else {
                        return;
                    }
                }
                mo10350a(new C1945a(this, cVarArr));
            } else if (AbstractC1993y.f5157f.equalsIgnoreCase(intent.getAction())) {
                String stringExtra7 = intent.getStringExtra(AbstractC1993y.f5176y);
                String stringExtra8 = intent.getStringExtra(AbstractC1993y.f5150B);
                AbstractC2028d bVar2 = new C2025b(intent.getBundleExtra("ext_packet"));
                if (m7178a(bVar2, stringExtra7, stringExtra8, false) != null) {
                    mo10350a(new C1950ae(this, bVar2));
                }
            } else if (AbstractC1993y.f5159h.equalsIgnoreCase(intent.getAction())) {
                String stringExtra9 = intent.getStringExtra(AbstractC1993y.f5176y);
                String stringExtra10 = intent.getStringExtra(AbstractC1993y.f5150B);
                AbstractC2028d fVar = new C2030f(intent.getBundleExtra("ext_packet"));
                if (m7178a(fVar, stringExtra9, stringExtra10, false) != null) {
                    mo10350a(new C1950ae(this, fVar));
                }
            } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                    AbstractC1855b.m6718a("Service called on timer");
                } else if (System.currentTimeMillis() - this.f4995d >= 30000) {
                    this.f4995d = System.currentTimeMillis();
                    AbstractC1855b.m6718a("Service called on check alive.");
                } else {
                    return;
                }
                if (this.f5001j.mo10410b()) {
                    AbstractC1855b.m6723d("ERROR, the job controller is blocked.");
                    C1987w.m7406a().mo10430a(this, 14);
                    stopSelf();
                } else if (!mo10367e()) {
                    if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                        mo10356a(false);
                    } else {
                        mo10356a(true);
                    }
                } else if (this.f4997f.mo10522p()) {
                    mo10350a(new C1941i());
                } else {
                    mo10350a(new C1936d(17, null));
                }
            } else if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                try {
                    networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e) {
                    AbstractC1855b.m6720a(e);
                    networkInfo = null;
                }
                if (networkInfo != null) {
                    AbstractC1855b.m6718a("network changed, " + networkInfo.toString());
                } else {
                    AbstractC1855b.m6718a("network changed, no active network");
                }
                this.f4996e.mo10523q();
                if (C1865d.m6762d(this)) {
                    if (!mo10367e() && !mo10368f()) {
                        this.f5001j.mo10407a(1);
                        mo10350a(new C1935c());
                    }
                    C1919b.m7106a(this).mo10307a();
                } else {
                    mo10350a(new C1936d(2, null));
                }
                m7191j();
            } else if (AbstractC1993y.f5162k.equals(intent.getAction())) {
                String stringExtra11 = intent.getStringExtra(AbstractC1993y.f5168q);
                if (stringExtra11 != null) {
                    m7182b(stringExtra11, intent);
                }
                mo10350a(new C1943k());
            } else if (AbstractC1993y.f5163l.equals(intent.getAction())) {
                String stringExtra12 = intent.getStringExtra(AbstractC1993y.f5176y);
                List<String> b3 = a.mo10437b(stringExtra12);
                if (b3.isEmpty()) {
                    AbstractC1855b.m6718a("open channel should be called first before update info, pkg=" + stringExtra12);
                    return;
                }
                String stringExtra13 = intent.getStringExtra(AbstractC1993y.f5168q);
                String stringExtra14 = intent.getStringExtra(AbstractC1993y.f5167p);
                if (TextUtils.isEmpty(stringExtra13)) {
                    stringExtra13 = b3.get(0);
                }
                if (TextUtils.isEmpty(stringExtra14)) {
                    Collection<C1987w.C1989b> c = a.mo10439c(stringExtra13);
                    if (c != null && !c.isEmpty()) {
                        bVar = c.iterator().next();
                    }
                } else {
                    bVar = a.mo10435b(stringExtra13, stringExtra14);
                }
                if (bVar != null) {
                    if (intent.hasExtra(AbstractC1993y.f5174w)) {
                        bVar.f5132f = intent.getStringExtra(AbstractC1993y.f5174w);
                    }
                    if (intent.hasExtra(AbstractC1993y.f5175x)) {
                        bVar.f5133g = intent.getStringExtra(AbstractC1993y.f5175x);
                    }
                }
            } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                if (!C1946aa.m7251a(getApplicationContext()).mo10381a() || C1946aa.m7251a(getApplicationContext()).mo10382b() != 0) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra15 = intent.getStringExtra("mipush_app_package");
                    boolean booleanExtra2 = intent.getBooleanExtra("mipush_env_chanage", false);
                    int intExtra = intent.getIntExtra("mipush_env_type", 1);
                    C1971i.m7334a(this).mo10417c(stringExtra15);
                    if (!booleanExtra2 || "com.xiaomi.xmsf".equals(getPackageName())) {
                        mo10357a(byteArrayExtra, stringExtra15);
                    } else {
                        mo10350a(new C1959am(this, 14, intExtra, byteArrayExtra, stringExtra15));
                    }
                } else {
                    AbstractC1855b.m6718a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                }
            } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                String stringExtra16 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra3 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                Collection<C1987w.C1989b> c2 = C1987w.m7406a().mo10439c("5");
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    C1971i.m7334a(this).mo10416b(stringExtra16);
                }
                if (c2.isEmpty()) {
                    if (booleanExtra3) {
                        C1973k.m7345b(stringExtra16, byteArrayExtra2);
                    }
                } else if (c2.iterator().next().f5139m == C1987w.EnumC1991c.binded) {
                    mo10350a(new C1960an(this, 4, stringExtra16, byteArrayExtra2));
                } else if (booleanExtra3) {
                    C1973k.m7345b(stringExtra16, byteArrayExtra2);
                }
            } else if (AbstractC1947ab.f5029a.equals(intent.getAction())) {
                String stringExtra17 = intent.getStringExtra("uninstall_pkg_name");
                if (stringExtra17 != null && !TextUtils.isEmpty(stringExtra17.trim())) {
                    try {
                        getPackageManager().getPackageInfo(stringExtra17, 256);
                        z = false;
                    } catch (PackageManager.NameNotFoundException e2) {
                    }
                    if (!"com.xiaomi.channel".equals(stringExtra17) || C1987w.m7406a().mo10439c("1").isEmpty() || !z) {
                        SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                        String string = sharedPreferences.getString(stringExtra17, null);
                        if (!TextUtils.isEmpty(string) && z) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.remove(stringExtra17);
                            edit.commit();
                            if (C1982s.m7394e(this, stringExtra17)) {
                                C1982s.m7393d(this, stringExtra17);
                            }
                            C1982s.m7389b(this, stringExtra17);
                            if (mo10367e() && string != null) {
                                try {
                                    mo10362b(mo10346a(stringExtra17, string));
                                    AbstractC1855b.m6718a("uninstall " + stringExtra17 + " msg sent");
                                } catch (C2023p e3) {
                                    AbstractC1855b.m6723d("Fail to send Message: " + e3.getMessage());
                                    mo10349a(10, e3);
                                }
                            }
                        }
                    } else {
                        m7180a("1", 0);
                        AbstractC1855b.m6718a("close the miliao channel as the app is uninstalled.");
                    }
                }
            } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                String stringExtra18 = intent.getStringExtra(AbstractC1993y.f5176y);
                int intExtra2 = intent.getIntExtra(AbstractC1993y.f5177z, 0);
                if (TextUtils.isEmpty(stringExtra18)) {
                    return;
                }
                if (intExtra2 >= 0) {
                    C1982s.m7384a(this, stringExtra18, intExtra2);
                } else if (intExtra2 == -1) {
                    C1982s.m7389b(this, stringExtra18);
                }
            } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                String stringExtra19 = intent.getStringExtra(AbstractC1993y.f5176y);
                String stringExtra20 = intent.getStringExtra(AbstractC1993y.f5151C);
                if (intent.hasExtra(AbstractC1993y.f5149A)) {
                    i2 = intent.getIntExtra(AbstractC1993y.f5149A, 0);
                    b = C1872c.m6780b(stringExtra19 + i2);
                } else {
                    b = C1872c.m6780b(stringExtra19);
                    i2 = 0;
                    i3 = 1;
                }
                if (TextUtils.isEmpty(stringExtra19) || !TextUtils.equals(stringExtra20, b)) {
                    AbstractC1855b.m6723d("invalid notification for " + stringExtra19);
                } else if (i3 != 0) {
                    C1982s.m7393d(this, stringExtra19);
                } else {
                    C1982s.m7390b(this, stringExtra19, i2);
                }
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return f4992a;
    }
}
