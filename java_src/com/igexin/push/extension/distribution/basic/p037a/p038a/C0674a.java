package com.igexin.push.extension.distribution.basic.p037a.p038a;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.util.C1001g;
import com.igexin.sdk.PushBuildConfig;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.a.a */
public class C0674a implements AbstractC0521a {
    /* renamed from: a */
    private int m2617a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        long j = 0;
        long j2 = 0;
        long j3 = 1;
        for (int i = 0; i < split.length; i++) {
            for (int i2 = 0; i2 < 3 - i; i2++) {
                j3 *= 100;
            }
            j += j3 * Long.parseLong(split[i]);
            j3 = 1;
        }
        for (int i3 = 0; i3 < split2.length; i3++) {
            for (int i4 = 0; i4 < 3 - i3; i4++) {
                j3 *= 100;
            }
            j2 += j3 * Long.parseLong(split2[i3]);
            j3 = 1;
        }
        if (j > j2) {
            return 1;
        }
        return j == j2 ? 0 : -1;
    }

    /* renamed from: a */
    private boolean m2618a(C0675b bVar) {
        C0676c[] c = bVar.mo4754c();
        if (c == null || c.length <= 0) {
            return false;
        }
        for (C0676c cVar : c) {
            if (cVar.mo4755a() == EnumC0677d.A) {
                int a = m2617a(Build.VERSION.RELEASE, cVar.mo4760c());
                if (cVar.mo4759b() == 0) {
                    if (a != 0) {
                        return false;
                    }
                } else if (cVar.mo4759b() == -1 && a != -1) {
                    return false;
                }
            } else if (cVar.mo4755a() == EnumC0677d.V) {
                PackageInfo packageInfo = C0618g.f1635f.getPackageManager().getPackageInfo(C0618g.f1635f.getPackageName(), 0);
                int parseInt = Integer.parseInt(cVar.mo4760c());
                int i = packageInfo.versionCode;
                if (cVar.mo4759b() == 0) {
                    if (i != parseInt) {
                        return false;
                    }
                } else if (cVar.mo4759b() == -1 && i >= parseInt) {
                    return false;
                }
            } else if (cVar.mo4755a() == EnumC0677d.S) {
                int a2 = C1001g.m4029a(PushBuildConfig.sdk_conf_version, cVar.mo4760c());
                if (cVar.mo4759b() == 0) {
                    if (a2 != 0) {
                        return false;
                    }
                } else if (cVar.mo4759b() == -1 && a2 != -1) {
                    return false;
                }
            } else {
                continue;
            }
        }
        return true;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            return C0675b.m2622c(jSONObject.toString());
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z = false;
        if (baseAction != null) {
            try {
                C0675b bVar = (C0675b) baseAction;
                String taskId = pushTaskBean.getTaskId();
                String messageId = pushTaskBean.getMessageId();
                z = m2618a(bVar);
                if (z) {
                    C0535e.m2034a().mo4379a(taskId, messageId, bVar.mo4749a());
                } else {
                    C0535e.m2034a().mo4379a(taskId, messageId, bVar.mo4752b());
                }
            } catch (Exception e) {
            }
        }
        return z;
    }
}
