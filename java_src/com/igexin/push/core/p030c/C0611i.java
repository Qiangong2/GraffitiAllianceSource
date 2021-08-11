package com.igexin.push.core.p030c;

import android.content.ContentValues;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.push.util.C1155e;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.i */
public class C0611i extends AbstractC1139b {

    /* renamed from: a */
    public boolean f1544a;

    /* renamed from: g */
    private boolean f1545g = false;

    /* renamed from: h */
    private int f1546h;

    public C0611i(String str, byte[] bArr, int i, boolean z) {
        super(str);
        this.f1545g = z;
        this.f1546h = i;
        m2364a(bArr, i);
    }

    /* renamed from: a */
    private void m2364a(byte[] bArr, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", String.valueOf(i));
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("BIData", new String(C0459f.m1695f(bArr, 0), "UTF-8"));
            mo5893b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result"))) {
            this.f1544a = true;
            if (this.f1546h == 10) {
                C1155e.m4773g();
            }
            if (this.f1545g) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", "0");
                C0617f.m2395a().mo4632k().mo4255a("bi", contentValues, new String[]{"type"}, new String[]{"2"});
                C0568g.m2192a().mo4452c(System.currentTimeMillis());
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
