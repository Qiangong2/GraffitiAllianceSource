package com.igexin.assist.action;

import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;

/* renamed from: com.igexin.assist.action.b */
class C0428b extends Thread {

    /* renamed from: a */
    MessageBean f1012a;

    /* renamed from: b */
    final /* synthetic */ MessageManger f1013b;

    C0428b(MessageManger messageManger, MessageBean messageBean) {
        this.f1013b = messageManger;
        this.f1012a = messageBean;
    }

    public void run() {
        try {
            if (this.f1012a == null) {
                return;
            }
            if (this.f1012a.getMessageType().equals(AssistPushConsts.MSG_TYPE_TOKEN)) {
                MessageManger.m1552a(this.f1013b, this.f1012a.getStringMessage());
            } else if (this.f1012a.getMessageType().equals(AssistPushConsts.MSG_TYPE_PAYLOAD) && !TextUtils.isEmpty(this.f1012a.getStringMessage())) {
                C0430d dVar = new C0430d();
                dVar.mo4103a(this.f1012a);
                if (dVar.mo4104a() && dVar.mo4109f().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                    MessageManger.m1551a(this.f1013b, dVar, this.f1012a.getContext());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
