package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.support.p007v4.widget.ExploreByTouchHelper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.smack.util.C2045g;

/* renamed from: com.xiaomi.smack.packet.f */
public class C2030f extends AbstractC2028d {

    /* renamed from: a */
    private EnumC2032b f5399a = EnumC2032b.available;

    /* renamed from: d */
    private String f5400d = null;

    /* renamed from: e */
    private int f5401e = ExploreByTouchHelper.INVALID_ID;

    /* renamed from: f */
    private EnumC2031a f5402f = null;

    /* renamed from: com.xiaomi.smack.packet.f$a */
    public enum EnumC2031a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.smack.packet.f$b */
    public enum EnumC2032b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        f5415g,
        probe
    }

    public C2030f(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.f5399a = EnumC2032b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f5400d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f5401e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f5402f = EnumC2031a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public C2030f(EnumC2032b bVar) {
        mo10628a(bVar);
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: a */
    public String mo10546a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (mo10625t() != null) {
            sb.append(" xmlns=\"").append(mo10625t()).append("\"");
        }
        if (mo10609k() != null) {
            sb.append(" id=\"").append(mo10609k()).append("\"");
        }
        if (mo10613m() != null) {
            sb.append(" to=\"").append(C2045g.m7700a(mo10613m())).append("\"");
        }
        if (mo10615n() != null) {
            sb.append(" from=\"").append(C2045g.m7700a(mo10615n())).append("\"");
        }
        if (mo10611l() != null) {
            sb.append(" chid=\"").append(C2045g.m7700a(mo10611l())).append("\"");
        }
        if (this.f5399a != null) {
            sb.append(" type=\"").append(this.f5399a).append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f5400d != null) {
            sb.append("<status>").append(C2045g.m7700a(this.f5400d)).append("</status>");
        }
        if (this.f5401e != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.f5401e).append("</priority>");
        }
        if (!(this.f5402f == null || this.f5402f == EnumC2031a.available)) {
            sb.append("<show>").append(this.f5402f).append("</show>");
        }
        sb.append(mo10624s());
        C2034h p = mo10620p();
        if (p != null) {
            sb.append(p.mo10634d());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo10626a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f5401e = i;
    }

    /* renamed from: a */
    public void mo10627a(EnumC2031a aVar) {
        this.f5402f = aVar;
    }

    /* renamed from: a */
    public void mo10628a(EnumC2032b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f5399a = bVar;
    }

    /* renamed from: a */
    public void mo10629a(String str) {
        this.f5400d = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: c */
    public Bundle mo10581c() {
        Bundle c = super.mo10581c();
        if (this.f5399a != null) {
            c.putString("ext_pres_type", this.f5399a.toString());
        }
        if (this.f5400d != null) {
            c.putString("ext_pres_status", this.f5400d);
        }
        if (this.f5401e != Integer.MIN_VALUE) {
            c.putInt("ext_pres_prio", this.f5401e);
        }
        if (!(this.f5402f == null || this.f5402f == EnumC2031a.available)) {
            c.putString("ext_pres_mode", this.f5402f.toString());
        }
        return c;
    }
}
