package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.p027a.C0535e;

public class GActivity extends Activity {
    public static final String TAG = GActivity.class.getName();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            Intent intent2 = new Intent(this, C0535e.m2034a().mo4360a((Context) this));
            if (intent != null) {
                try {
                    if (intent.hasExtra(PushConsts.CMD_ACTION) && intent.hasExtra("isSlave")) {
                        intent2.putExtra(PushConsts.CMD_ACTION, intent.getStringExtra(PushConsts.CMD_ACTION));
                        intent2.putExtra("isSlave", intent.getBooleanExtra("isSlave", false));
                        if (intent.hasExtra("op_app")) {
                            intent2.putExtra("op_app", intent.getStringExtra("op_app"));
                        }
                        ActivityC0460a.m1698b("GActivity action = " + intent.getStringExtra(PushConsts.CMD_ACTION) + ", isSlave = " + intent.getBooleanExtra("isSlave", false));
                    }
                } catch (Exception e) {
                    ActivityC0460a.m1698b(TAG + "|put extra exception" + e.toString());
                }
            }
            startService(intent2);
        } catch (Throwable th) {
            ActivityC0460a.m1698b(TAG + th.toString());
        }
        ActivityC0460a.m1698b(TAG + "|start PushService from GActivity");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
