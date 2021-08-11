package com.igexin.push.extension.distribution.gbd.stub;

import android.content.Context;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.gbd.p068d.C1071b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.stub.IPushExtension;
import org.json.JSONObject;

public class PushExtension implements IPushExtension {
    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean executeAction(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return false;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean init(Context context) {
        try {
            C1115d.m4559b("GBD_PushExtension", "init gbd ...");
            C1071b.m4348a().mo5793a(context);
            return true;
        } catch (Exception e) {
            C1115d.m4558a(e);
            C1115d.m4559b("GBD_PushExtension", e.toString());
            return false;
        }
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean isActionSupported(String str) {
        return false;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public void onDestroy() {
        C1071b.m4348a().mo5796d();
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public BaseAction parseAction(JSONObject jSONObject) {
        return null;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public EnumC0554b prepareExecuteAction(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.stop;
    }
}
