package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.smack.util.C2045g;

/* renamed from: com.xiaomi.smack.packet.c */
public class C2027c extends AbstractC2028d {

    /* renamed from: a */
    private String f5372a = null;

    /* renamed from: d */
    private String f5373d = null;

    /* renamed from: e */
    private String f5374e;

    /* renamed from: f */
    private String f5375f;

    /* renamed from: g */
    private String f5376g;

    /* renamed from: h */
    private String f5377h;

    /* renamed from: i */
    private boolean f5378i = false;

    /* renamed from: j */
    private String f5379j;

    /* renamed from: k */
    private String f5380k = "";

    /* renamed from: l */
    private String f5381l = "";

    /* renamed from: m */
    private String f5382m = "";

    /* renamed from: n */
    private String f5383n = "";

    /* renamed from: o */
    private boolean f5384o = false;

    public C2027c() {
    }

    public C2027c(Bundle bundle) {
        super(bundle);
        this.f5372a = bundle.getString("ext_msg_type");
        this.f5374e = bundle.getString("ext_msg_lang");
        this.f5373d = bundle.getString("ext_msg_thread");
        this.f5375f = bundle.getString("ext_msg_sub");
        this.f5376g = bundle.getString("ext_msg_body");
        this.f5377h = bundle.getString("ext_body_encode");
        this.f5379j = bundle.getString("ext_msg_appid");
        this.f5378i = bundle.getBoolean("ext_msg_trans", false);
        this.f5384o = bundle.getBoolean("ext_msg_encrypt", false);
        this.f5380k = bundle.getString("ext_msg_seq");
        this.f5381l = bundle.getString("ext_msg_mseq");
        this.f5382m = bundle.getString("ext_msg_fseq");
        this.f5383n = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: a */
    public String mo10546a() {
        C2034h p;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (mo10625t() != null) {
            sb.append(" xmlns=\"").append(mo10625t()).append("\"");
        }
        if (this.f5374e != null) {
            sb.append(" xml:lang=\"").append(mo10603i()).append("\"");
        }
        if (mo10609k() != null) {
            sb.append(" id=\"").append(mo10609k()).append("\"");
        }
        if (mo10613m() != null) {
            sb.append(" to=\"").append(C2045g.m7700a(mo10613m())).append("\"");
        }
        if (!TextUtils.isEmpty(mo10593e())) {
            sb.append(" seq=\"").append(mo10593e()).append("\"");
        }
        if (!TextUtils.isEmpty(mo10596f())) {
            sb.append(" mseq=\"").append(mo10596f()).append("\"");
        }
        if (!TextUtils.isEmpty(mo10598g())) {
            sb.append(" fseq=\"").append(mo10598g()).append("\"");
        }
        if (!TextUtils.isEmpty(mo10600h())) {
            sb.append(" status=\"").append(mo10600h()).append("\"");
        }
        if (mo10615n() != null) {
            sb.append(" from=\"").append(C2045g.m7700a(mo10615n())).append("\"");
        }
        if (mo10611l() != null) {
            sb.append(" chid=\"").append(C2045g.m7700a(mo10611l())).append("\"");
        }
        if (this.f5378i) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f5379j)) {
            sb.append(" appid=\"").append(mo10591d()).append("\"");
        }
        if (!TextUtils.isEmpty(this.f5372a)) {
            sb.append(" type=\"").append(this.f5372a).append("\"");
        }
        if (this.f5384o) {
            sb.append(" s=\"1\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f5375f != null) {
            sb.append("<subject>").append(C2045g.m7700a(this.f5375f));
            sb.append("</subject>");
        }
        if (this.f5376g != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f5377h)) {
                sb.append(" encode=\"").append(this.f5377h).append("\"");
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION).append(C2045g.m7700a(this.f5376g)).append("</body>");
        }
        if (this.f5373d != null) {
            sb.append("<thread>").append(this.f5373d).append("</thread>");
        }
        if (C1447g.f3469aF.equalsIgnoreCase(this.f5372a) && (p = mo10620p()) != null) {
            sb.append(p.mo10634d());
        }
        sb.append(mo10624s());
        sb.append("</message>");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo10584a(String str) {
        this.f5379j = str;
    }

    /* renamed from: a */
    public void mo10585a(String str, String str2) {
        this.f5376g = str;
        this.f5377h = str2;
    }

    /* renamed from: a */
    public void mo10586a(boolean z) {
        this.f5378i = z;
    }

    /* renamed from: b */
    public String mo10587b() {
        return this.f5372a;
    }

    /* renamed from: b */
    public void mo10588b(String str) {
        this.f5380k = str;
    }

    /* renamed from: b */
    public void mo10589b(boolean z) {
        this.f5384o = z;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: c */
    public Bundle mo10581c() {
        Bundle c = super.mo10581c();
        if (!TextUtils.isEmpty(this.f5372a)) {
            c.putString("ext_msg_type", this.f5372a);
        }
        if (this.f5374e != null) {
            c.putString("ext_msg_lang", this.f5374e);
        }
        if (this.f5375f != null) {
            c.putString("ext_msg_sub", this.f5375f);
        }
        if (this.f5376g != null) {
            c.putString("ext_msg_body", this.f5376g);
        }
        if (!TextUtils.isEmpty(this.f5377h)) {
            c.putString("ext_body_encode", this.f5377h);
        }
        if (this.f5373d != null) {
            c.putString("ext_msg_thread", this.f5373d);
        }
        if (this.f5379j != null) {
            c.putString("ext_msg_appid", this.f5379j);
        }
        if (this.f5378i) {
            c.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f5380k)) {
            c.putString("ext_msg_seq", this.f5380k);
        }
        if (!TextUtils.isEmpty(this.f5381l)) {
            c.putString("ext_msg_mseq", this.f5381l);
        }
        if (!TextUtils.isEmpty(this.f5382m)) {
            c.putString("ext_msg_fseq", this.f5382m);
        }
        if (this.f5384o) {
            c.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f5383n)) {
            c.putString("ext_msg_status", this.f5383n);
        }
        return c;
    }

    /* renamed from: c */
    public void mo10590c(String str) {
        this.f5381l = str;
    }

    /* renamed from: d */
    public String mo10591d() {
        return this.f5379j;
    }

    /* renamed from: d */
    public void mo10592d(String str) {
        this.f5382m = str;
    }

    /* renamed from: e */
    public String mo10593e() {
        return this.f5380k;
    }

    /* renamed from: e */
    public void mo10594e(String str) {
        this.f5383n = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2027c cVar = (C2027c) obj;
        if (!super.equals(cVar)) {
            return false;
        }
        if (this.f5376g != null) {
            if (!this.f5376g.equals(cVar.f5376g)) {
                return false;
            }
        } else if (cVar.f5376g != null) {
            return false;
        }
        if (this.f5374e != null) {
            if (!this.f5374e.equals(cVar.f5374e)) {
                return false;
            }
        } else if (cVar.f5374e != null) {
            return false;
        }
        if (this.f5375f != null) {
            if (!this.f5375f.equals(cVar.f5375f)) {
                return false;
            }
        } else if (cVar.f5375f != null) {
            return false;
        }
        if (this.f5373d != null) {
            if (!this.f5373d.equals(cVar.f5373d)) {
                return false;
            }
        } else if (cVar.f5373d != null) {
            return false;
        }
        if (this.f5372a != cVar.f5372a) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public String mo10596f() {
        return this.f5381l;
    }

    /* renamed from: f */
    public void mo10597f(String str) {
        this.f5372a = str;
    }

    /* renamed from: g */
    public String mo10598g() {
        return this.f5382m;
    }

    /* renamed from: g */
    public void mo10599g(String str) {
        this.f5375f = str;
    }

    /* renamed from: h */
    public String mo10600h() {
        return this.f5383n;
    }

    /* renamed from: h */
    public void mo10601h(String str) {
        this.f5376g = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f5374e != null ? this.f5374e.hashCode() : 0) + (((this.f5373d != null ? this.f5373d.hashCode() : 0) + (((this.f5376g != null ? this.f5376g.hashCode() : 0) + ((this.f5372a != null ? this.f5372a.hashCode() : 0) * 31)) * 31)) * 31)) * 31;
        if (this.f5375f != null) {
            i = this.f5375f.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: i */
    public String mo10603i() {
        return this.f5374e;
    }

    /* renamed from: i */
    public void mo10604i(String str) {
        this.f5373d = str;
    }

    /* renamed from: j */
    public void mo10605j(String str) {
        this.f5374e = str;
    }
}
