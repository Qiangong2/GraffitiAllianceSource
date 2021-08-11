package com.igexin.push.extension.distribution.gbd.p068d;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.p007v4.view.MotionEventCompat;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1022a;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1024c;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1025d;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1027f;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1028g;
import com.igexin.push.extension.distribution.gbd.p061a.p063b.C1032d;
import com.igexin.push.extension.distribution.gbd.p061a.p063b.C1036h;
import com.igexin.push.extension.distribution.gbd.p061a.p064c.C1045f;
import com.igexin.push.extension.distribution.gbd.p061a.p064c.C1048i;
import com.igexin.push.extension.distribution.gbd.p061a.p065d.C1057a;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.tencent.gcloud.voice.GCloudVoiceErrno;

/* renamed from: com.igexin.push.extension.distribution.gbd.d.a */
public class HandlerC1070a extends Handler {
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    switch (message.arg1) {
                        case 11:
                            C1045f.m4230a().mo5703a(11);
                            return;
                        case 12:
                            C1045f.m4230a().mo5703a(12);
                            return;
                        default:
                            return;
                    }
                case 2:
                    switch (message.arg1) {
                        case 21:
                            C1080b.m4391a().mo5814c();
                            return;
                        case 22:
                            if (C1067a.f2805p) {
                                C1080b.m4391a().mo5811a(0);
                            }
                            if (C1067a.f2806q) {
                                C1080b.m4391a().mo5811a(1);
                                C1080b.m4391a().mo5811a(2);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 3:
                    if (message.obj != null) {
                        C1025d.m4127a().mo5677a((Intent) message.obj);
                        return;
                    }
                    return;
                case 4:
                    switch (message.arg1) {
                        case MotionEventCompat.AXIS_GENERIC_10:
                            C1024c.m4113a().mo5675d();
                            return;
                        case MotionEventCompat.AXIS_GENERIC_11:
                            C1027f.m4131a().mo5680b();
                            return;
                        default:
                            return;
                    }
                case 5:
                    switch (message.arg1) {
                        case GCloudVoiceErrno.GCLOUD_VOICE_JOIN_SUCC /*{ENCODED_INT: 51}*/:
                            C1032d.m4159a().mo5690e();
                            if (C1067a.f2755F) {
                                C1024c.m4113a().mo5673b();
                                return;
                            }
                            return;
                        case GCloudVoiceErrno.GCLOUD_VOICE_JOIN_NOTIN /*{ENCODED_INT: 52}*/:
                            C1036h.m4187a().mo5692c();
                            if (C1067a.f2755F) {
                                C1024c.m4113a().mo5674c();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 6:
                    C1032d.m4159a().mo5689d();
                    return;
                case 7:
                    C1048i.m4250a().mo5711b();
                    return;
                case 8:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                default:
                    return;
                case 10:
                    C1022a.m4100a().mo5670b();
                    return;
                case 13:
                    C1057a.m4275a().mo5725b();
                    return;
                case 16:
                    C1028g.m4140a().mo5683b();
                    return;
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            C1115d.m4559b("GBD_Handler", e.toString());
        }
    }
}
