package com.igexin.push.core.p030c;

import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.push.util.C1168r;
import com.igexin.sdk.PushConsts;
import java.util.Timer;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.c */
public class C0605c extends AbstractC1139b {

    /* renamed from: a */
    private String f1534a;

    /* renamed from: g */
    private String f1535g;

    /* renamed from: h */
    private C0638a f1536h;

    /* renamed from: i */
    private PushTaskBean f1537i;

    public C0605c(String str, C0638a aVar, PushTaskBean pushTaskBean) {
        super(str);
        this.f1535g = str;
        this.f1534a = pushTaskBean.getMessageId();
        this.f1536h = aVar;
        this.f1537i = pushTaskBean;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4589a(PushTaskBean pushTaskBean, C0638a aVar) {
        C0640c cVar = new C0640c();
        cVar.mo4688a();
        cVar.f1710c = "RTV" + pushTaskBean.getMessageId() + "@" + pushTaskBean.getTaskId();
        cVar.f1711d = C0618g.f1647r;
        cVar.f1708a = (int) System.currentTimeMillis();
        C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, cVar);
        ActivityC0460a.m1698b("cdnRetrieve|" + pushTaskBean.getMessageId() + "|" + pushTaskBean.getTaskId());
        if (aVar.mo4684c() < 2) {
            long a = C1168r.m4794a();
            Timer timer = new Timer();
            timer.schedule(new C0607e(this, pushTaskBean, aVar), a);
            C0618g.f1614aj.put(pushTaskBean.getTaskId(), timer);
        }
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4590a(Exception exc) {
        if (this.f1536h.mo4680a() < 2) {
            new Timer().schedule(new C0606d(this), C1168r.m4794a());
            return;
        }
        mo4589a(this.f1537i, this.f1536h);
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        if (bArr != null) {
            byte[] d = C0459f.m1693d(C0435a.m1577c(bArr, C0618g.f1632c));
            if (d != null) {
                JSONObject jSONObject = new JSONObject(new String(d, "utf-8"));
                jSONObject.put("id", this.f1534a);
                jSONObject.put("messageid", this.f1534a);
                jSONObject.put("cdnType", true);
                byte[] bArr2 = null;
                try {
                    if ("pushmessage".equals(jSONObject.getString(PushConsts.CMD_ACTION))) {
                        if (jSONObject.has("extraData")) {
                            bArr2 = jSONObject.getString("extraData").getBytes();
                        }
                        C0535e.m2034a().mo4381a(jSONObject, bArr2, true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new Exception("Get error CDNData, can not UnGzip it...");
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
