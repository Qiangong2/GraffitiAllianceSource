package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.p093d.C1485j;
import com.umeng.analytics.p093d.C1488m;
import java.io.Serializable;

/* renamed from: com.umeng.analytics.game.b */
/* compiled from: GameState */
public class C1550b {

    /* renamed from: a */
    public String f3922a;

    /* renamed from: b */
    public String f3923b;

    /* renamed from: c */
    private Context f3924c;

    /* renamed from: d */
    private final String f3925d = "um_g_cache";

    /* renamed from: e */
    private final String f3926e = "single_level";

    /* renamed from: f */
    private final String f3927f = "stat_player_level";

    /* renamed from: g */
    private final String f3928g = "stat_game_level";

    /* renamed from: h */
    private C1551a f3929h = null;

    public C1550b(Context context) {
        this.f3924c = context;
    }

    /* renamed from: a */
    public C1551a mo8911a(String str) {
        this.f3929h = new C1551a(str);
        this.f3929h.mo8915a();
        return this.f3929h;
    }

    /* renamed from: a */
    public void mo8912a() {
        if (this.f3929h != null) {
            this.f3929h.mo8917b();
            SharedPreferences.Editor edit = this.f3924c.getSharedPreferences("um_g_cache", 0).edit();
            edit.putString("single_level", C1485j.m5517a(this.f3929h));
            edit.putString("stat_player_level", this.f3923b);
            edit.putString("stat_game_level", this.f3922a);
            edit.commit();
        }
    }

    /* renamed from: b */
    public void mo8914b() {
        SharedPreferences a = C1488m.m5523a(this.f3924c, "um_g_cache");
        String string = a.getString("single_level", null);
        if (!TextUtils.isEmpty(string)) {
            this.f3929h = (C1551a) C1485j.m5516a(string);
            if (this.f3929h != null) {
                this.f3929h.mo8918c();
            }
        }
        if (TextUtils.isEmpty(this.f3923b)) {
            this.f3923b = a.getString("stat_player_level", null);
            if (this.f3923b == null) {
                SharedPreferences a2 = C1488m.m5522a(this.f3924c);
                if (a2 != null) {
                    this.f3923b = a2.getString("userlevel", null);
                } else {
                    return;
                }
            }
        }
        if (this.f3922a == null) {
            this.f3922a = a.getString("stat_game_level", null);
        }
    }

    /* renamed from: b */
    public C1551a mo8913b(String str) {
        if (this.f3929h != null) {
            this.f3929h.mo8919d();
            if (this.f3929h.mo8916a(str)) {
                C1551a aVar = this.f3929h;
                this.f3929h = null;
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: com.umeng.analytics.game.b$a */
    /* compiled from: GameState */
    static class C1551a implements Serializable {

        /* renamed from: a */
        private static final long f3930a = 20140327;

        /* renamed from: b */
        private String f3931b;

        /* renamed from: c */
        private long f3932c;

        /* renamed from: d */
        private long f3933d;

        public C1551a(String str) {
            this.f3931b = str;
        }

        /* renamed from: a */
        public boolean mo8916a(String str) {
            return this.f3931b.equals(str);
        }

        /* renamed from: a */
        public void mo8915a() {
            this.f3933d = System.currentTimeMillis();
        }

        /* renamed from: b */
        public void mo8917b() {
            this.f3932c += System.currentTimeMillis() - this.f3933d;
            this.f3933d = 0;
        }

        /* renamed from: c */
        public void mo8918c() {
            mo8915a();
        }

        /* renamed from: d */
        public void mo8919d() {
            mo8917b();
        }

        /* renamed from: e */
        public long mo8920e() {
            return this.f3932c;
        }

        /* renamed from: f */
        public String mo8921f() {
            return this.f3931b;
        }
    }
}
