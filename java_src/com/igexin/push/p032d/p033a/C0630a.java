package com.igexin.push.p032d.p033a;

import android.support.p007v4.view.MotionEventCompat;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.C0457d;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0639b;
import com.igexin.push.p032d.p035c.C0645h;
import com.igexin.push.p032d.p035c.C0647j;
import com.igexin.push.p032d.p035c.C0650m;
import com.igexin.push.p032d.p035c.C0652o;
import com.igexin.push.p032d.p035c.C0653p;
import com.igexin.push.p032d.p035c.C0654q;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.d.a.a */
public class C0630a extends AbstractC0455b {
    public C0630a(String str, AbstractC0455b bVar) {
        super(str, true);
        mo4159a(bVar);
    }

    /* renamed from: a */
    private boolean m2450a(C0639b bVar, AbstractC0642e eVar) {
        String string;
        if (bVar.f1702b != 26) {
            return false;
        }
        C0653p pVar = (C0653p) eVar;
        if (pVar.mo4700a() && pVar.f1776e != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) pVar.f1776e);
                if (jSONObject.has(PushConsts.CMD_ACTION) && (string = jSONObject.getString(PushConsts.CMD_ACTION)) != null && string.equals("redirect_server")) {
                    return true;
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b("CommandFilter|" + e.toString());
            }
        }
        return false;
    }

    @Override // com.igexin.p012b.p013a.p015b.AbstractC0455b
    /* renamed from: a */
    public Object mo4158a(AbstractC0458e eVar, C0457d dVar, Object obj) {
        if (obj instanceof AbstractC0642e) {
            AbstractC0642e eVar2 = (AbstractC0642e) obj;
            C0639b bVar = new C0639b();
            bVar.f1702b = (byte) eVar2.f1723i;
            bVar.mo4686a(eVar2.mo4685d());
            bVar.f1703c = eVar2.f1724j;
            bVar.f1704d = eVar2.f1725k;
            return bVar;
        } else if (!(obj instanceof AbstractC0642e[])) {
            return null;
        } else {
            AbstractC0642e[] eVarArr = (AbstractC0642e[]) obj;
            C0639b[] bVarArr = new C0639b[eVarArr.length];
            for (int i = 0; i < eVarArr.length; i++) {
                bVarArr[i] = new C0639b();
                bVarArr[i].f1702b = (byte) eVarArr[i].f1723i;
                bVarArr[i].mo4686a(eVarArr[i].mo4685d());
            }
            return bVarArr;
        }
    }

    /* renamed from: b */
    public AbstractC0466e mo4161c(AbstractC0458e eVar, C0457d dVar, Object obj) {
        AbstractC0642e aVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof C0645h) {
            return (AbstractC0466e) obj;
        }
        C0639b bVar = (C0639b) obj;
        switch (bVar.f1702b) {
            case 5:
                aVar = new C0650m();
                break;
            case 9:
                aVar = new C0654q();
                break;
            case 26:
                aVar = new C0653p();
                break;
            case 28:
                aVar = new C0638a();
                break;
            case MotionEventCompat.AXIS_GENERIC_6:
                aVar = new C0652o();
                break;
            case 97:
                aVar = new C0647j();
                break;
            default:
                aVar = null;
                break;
        }
        if ((bVar.f1706f != 1 && bVar.f1706f != 7) || aVar == null) {
            return null;
        }
        aVar.mo4682a(bVar.f1705e);
        if (bVar.f1706f != 7) {
            if (!m2450a(bVar, aVar)) {
                aVar = null;
            }
            return aVar;
        } else if (bVar.f1707g != 32 || m2450a(bVar, aVar)) {
            return aVar;
        } else {
            return null;
        }
    }
}
