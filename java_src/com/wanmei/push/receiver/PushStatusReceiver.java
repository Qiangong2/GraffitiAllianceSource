package com.wanmei.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.wanmei.push.ResponseCode;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p100d.C1680d;
import com.wanmei.push.p104g.C1714f;

public class PushStatusReceiver extends BroadcastReceiver {
    private void updateHostAndSuccessorInfo(Context context, Intent intent) {
        C1679c.m6277a();
        String g = C1679c.m6291g(context);
        C1679c.m6277a();
        String h = C1679c.m6292h(context);
        if (!TextUtils.isEmpty(intent.getStringExtra("hostPackageName")) && !g.equals(intent.getStringExtra("hostPackageName"))) {
            C1679c.m6277a();
            C1679c.m6286c(context, intent.getStringExtra("hostPackageName"));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("successorPackageName")) && !h.equals(intent.getStringExtra("successorPackageName"))) {
            C1679c.m6277a();
            C1679c.m6288d(context, intent.getStringExtra("successorPackageName"));
        }
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.PERFECT_PUSH_STATUS_START_SUCCESS".equals(intent.getAction())) {
            updateHostAndSuccessorInfo(context, intent);
            if (C1680d.m6296a(context).mo9322a() != null) {
                C1680d.m6296a(context).mo9322a().openSuccess();
            }
            StringBuilder append = new StringBuilder("[").append(context.getPackageName()).append("] PushStatusReceiver onReceive() Push Start Success PushHostPackageName : ");
            C1679c.m6277a();
            StringBuilder append2 = append.append(C1679c.m6291g(context)).append(" PushSuccessorPackageName : ");
            C1679c.m6277a();
            C1714f.m6383c(context, "PERFECT_PUSH", append2.append(C1679c.m6292h(context)).toString());
        } else if ("android.intent.action.PERFECT_PUSH_STATUS_START_FAIL".equals(intent.getAction())) {
            C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushStatusReceiver onReceive() Push Start Fail");
            if (C1680d.m6296a(context).mo9322a() != null) {
                C1680d.m6296a(context).mo9322a().openFail(ResponseCode.PUSH_OPEN_FAIL_CODE);
            }
        } else if ("android.intent.action.PERFECT_PUSH_STATUS_REFRESH".equals(intent.getAction())) {
            updateHostAndSuccessorInfo(context, intent);
            StringBuilder append3 = new StringBuilder("[").append(context.getPackageName()).append("] PushStatusReceiver onReceive() Push Refresh PushHostPackageName : ");
            C1679c.m6277a();
            StringBuilder append4 = append3.append(C1679c.m6291g(context)).append(" PushSuccessorPackageName : ");
            C1679c.m6277a();
            C1714f.m6383c(context, "PERFECT_PUSH", append4.append(C1679c.m6292h(context)).toString());
        }
    }
}
