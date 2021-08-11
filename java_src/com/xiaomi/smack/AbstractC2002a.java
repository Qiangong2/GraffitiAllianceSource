package com.xiaomi.smack;

import android.support.p007v4.p009os.EnvironmentCompat;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.string.C1872c;
import com.xiaomi.measite.smack.C1892a;
import com.xiaomi.push.service.AbstractC1993y;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.debugger.AbstractC2007a;
import com.xiaomi.smack.filter.AbstractC2010a;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2030f;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.smack.a */
public abstract class AbstractC2002a {

    /* renamed from: a */
    public static boolean f5288a;

    /* renamed from: n */
    private static final AtomicInteger f5289n = new AtomicInteger(0);

    /* renamed from: b */
    protected int f5290b = 0;

    /* renamed from: c */
    protected long f5291c = -1;

    /* renamed from: d */
    protected int f5292d;

    /* renamed from: e */
    protected final Map<AbstractC2009f, C2003a> f5293e = new ConcurrentHashMap();

    /* renamed from: f */
    protected final Map<AbstractC2009f, C2003a> f5294f = new ConcurrentHashMap();

    /* renamed from: g */
    protected AbstractC2007a f5295g = null;

    /* renamed from: h */
    protected Reader f5296h;

    /* renamed from: i */
    protected Writer f5297i;

    /* renamed from: j */
    protected String f5298j = "";

    /* renamed from: k */
    protected final int f5299k = f5289n.getAndIncrement();

    /* renamed from: l */
    protected C2004b f5300l;

    /* renamed from: m */
    protected XMPushService f5301m;

    /* renamed from: o */
    private LinkedList<Pair<Integer, Long>> f5302o = new LinkedList<>();

    /* renamed from: p */
    private final Collection<AbstractC2006d> f5303p = new CopyOnWriteArrayList();

    /* renamed from: q */
    private int f5304q = 2;

    /* renamed from: r */
    private long f5305r = 0;

    /* renamed from: com.xiaomi.smack.a$a */
    protected static class C2003a {

        /* renamed from: a */
        private AbstractC2009f f5306a;

        /* renamed from: b */
        private AbstractC2010a f5307b;

        public C2003a(AbstractC2009f fVar, AbstractC2010a aVar) {
            this.f5306a = fVar;
            this.f5307b = aVar;
        }

        /* renamed from: a */
        public void mo10524a(AbstractC2028d dVar) {
            if (this.f5307b == null || this.f5307b.mo10397a(dVar)) {
                this.f5306a.mo10105a(dVar);
            }
        }
    }

    static {
        f5288a = false;
        try {
            f5288a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        C2014j.m7555a();
    }

    protected AbstractC2002a(XMPushService xMPushService, C2004b bVar) {
        this.f5300l = bVar;
        this.f5301m = xMPushService;
    }

    /* renamed from: a */
    private String m7481a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* renamed from: b */
    private void m7482b(int i) {
        synchronized (this.f5302o) {
            if (i == 1) {
                this.f5302o.clear();
            } else {
                this.f5302o.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f5302o.size() > 6) {
                    this.f5302o.remove(0);
                }
            }
        }
    }

    /* renamed from: a */
    public C2004b mo10494a() {
        return this.f5300l;
    }

    /* renamed from: a */
    public void mo10495a(int i, int i2, Exception exc) {
        if (i != this.f5304q) {
            AbstractC1855b.m6718a(String.format("update the connection status. %1$s -> %2$s : %3$s ", m7481a(this.f5304q), m7481a(i), AbstractC1993y.m7431a(i2)));
        }
        if (C1865d.m6762d(this.f5301m)) {
            m7482b(i);
        }
        if (i == 1) {
            this.f5301m.mo10348a(10);
            if (this.f5304q != 0) {
                AbstractC1855b.m6718a("try set connected while not connecting.");
            }
            this.f5304q = i;
            for (AbstractC2006d dVar : this.f5303p) {
                dVar.mo10106a(this);
            }
        } else if (i == 0) {
            this.f5301m.mo10370h();
            if (this.f5304q != 2) {
                AbstractC1855b.m6718a("try set connecting while not disconnected.");
            }
            this.f5304q = i;
            for (AbstractC2006d dVar2 : this.f5303p) {
                dVar2.mo10109b(this);
            }
        } else if (i == 2) {
            this.f5301m.mo10348a(10);
            if (this.f5304q == 0) {
                for (AbstractC2006d dVar3 : this.f5303p) {
                    dVar3.mo10108a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (this.f5304q == 1) {
                for (AbstractC2006d dVar4 : this.f5303p) {
                    dVar4.mo10107a(this, i2, exc);
                }
            }
            this.f5304q = i;
        }
    }

    /* renamed from: a */
    public abstract void mo10496a(C1987w.C1989b bVar);

    /* renamed from: a */
    public void mo10497a(AbstractC2006d dVar) {
        if (dVar != null && !this.f5303p.contains(dVar)) {
            this.f5303p.add(dVar);
        }
    }

    /* renamed from: a */
    public void mo10498a(AbstractC2009f fVar, AbstractC2010a aVar) {
        if (fVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f5293e.put(fVar, new C2003a(fVar, aVar));
    }

    /* renamed from: a */
    public abstract void mo10499a(AbstractC2028d dVar);

    /* renamed from: a */
    public abstract void mo10500a(C2030f fVar, int i, Exception exc);

    /* renamed from: a */
    public void mo10501a(String str) {
        AbstractC1855b.m6718a("setChallenge hash = " + C1872c.m6779a(str).substring(0, 8));
        this.f5298j = str;
        mo10495a(1, 0, (Exception) null);
    }

    /* renamed from: a */
    public abstract void mo10502a(String str, String str2);

    /* renamed from: a */
    public abstract void mo10503a(AbstractC2028d[] dVarArr);

    /* renamed from: a */
    public boolean mo10504a(long j) {
        return this.f5305r >= j;
    }

    /* renamed from: b */
    public String mo10505b() {
        return this.f5300l.mo10528c();
    }

    /* renamed from: b */
    public void mo10506b(AbstractC2006d dVar) {
        this.f5303p.remove(dVar);
    }

    /* renamed from: b */
    public void mo10507b(AbstractC2009f fVar, AbstractC2010a aVar) {
        if (fVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f5294f.put(fVar, new C2003a(fVar, aVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10508b(AbstractC2028d dVar) {
        for (C2003a aVar : this.f5294f.values()) {
            aVar.mo10524a(dVar);
        }
    }

    /* renamed from: c */
    public String mo10509c() {
        return this.f5300l.mo10532f();
    }

    /* renamed from: d */
    public String mo10510d() {
        return this.f5300l.mo10530d();
    }

    /* renamed from: e */
    public int mo10511e() {
        return this.f5292d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo10512f() {
        String str;
        Class<?> cls = null;
        if (this.f5296h != null && this.f5297i != null && this.f5300l.mo10533g()) {
            if (this.f5295g == null) {
                try {
                    str = System.getProperty("smack.debuggerClass");
                } catch (Throwable th) {
                    str = null;
                }
                if (str != null) {
                    try {
                        cls = Class.forName(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (cls == null) {
                    this.f5295g = new C1892a(this, this.f5297i, this.f5296h);
                    this.f5296h = this.f5295g.mo10097a();
                    this.f5297i = this.f5295g.mo10100b();
                    return;
                }
                try {
                    this.f5295g = (AbstractC2007a) cls.getConstructor(AbstractC2002a.class, Writer.class, Reader.class).newInstance(this, this.f5297i, this.f5296h);
                    this.f5296h = this.f5295g.mo10097a();
                    this.f5297i = this.f5295g.mo10100b();
                } catch (Exception e2) {
                    throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
                }
            } else {
                this.f5296h = this.f5295g.mo10098a(this.f5296h);
                this.f5297i = this.f5295g.mo10099a(this.f5297i);
            }
        }
    }

    /* renamed from: g */
    public boolean mo10513g() {
        return this.f5304q == 0;
    }

    /* renamed from: h */
    public boolean mo10514h() {
        return this.f5304q == 1;
    }

    /* renamed from: i */
    public int mo10515i() {
        return this.f5290b;
    }

    /* renamed from: j */
    public void mo10516j() {
        this.f5290b = 0;
    }

    /* renamed from: k */
    public long mo10517k() {
        return this.f5291c;
    }

    /* renamed from: l */
    public void mo10518l() {
        this.f5291c = -1;
    }

    /* renamed from: m */
    public abstract void mo10519m();

    /* renamed from: n */
    public int mo10520n() {
        return this.f5304q;
    }

    /* renamed from: o */
    public void mo10521o() {
        this.f5305r = System.currentTimeMillis();
    }

    /* renamed from: p */
    public boolean mo10522p() {
        return System.currentTimeMillis() - this.f5305r < ((long) C2014j.m7557b());
    }

    /* renamed from: q */
    public void mo10523q() {
        synchronized (this.f5302o) {
            this.f5302o.clear();
        }
    }
}
