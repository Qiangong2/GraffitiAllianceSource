package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService extends IntentService {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C1897a> f4847a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    public static class C1897a {

        /* renamed from: a */
        private PushMessageReceiver f4848a;

        /* renamed from: b */
        private Intent f4849b;

        public C1897a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f4848a = pushMessageReceiver;
            this.f4849b = intent;
        }

        /* renamed from: a */
        public PushMessageReceiver mo10111a() {
            return this.f4848a;
        }

        /* renamed from: b */
        public Intent mo10112b() {
            return this.f4849b;
        }
    }

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void addJob(C1897a aVar) {
        if (aVar != null) {
            f4847a.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        C1897a poll;
        if (intent != null && (poll = f4847a.poll()) != null) {
            try {
                PushMessageReceiver a = poll.mo10111a();
                Intent b = poll.mo10112b();
                switch (b.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                    case 1:
                        PushMessageHandler.AbstractC1899a a2 = C1908f.m6991a(this).mo10199a(b);
                        if (a2 == null) {
                            return;
                        }
                        if (a2 instanceof MiPushMessage) {
                            MiPushMessage miPushMessage = (MiPushMessage) a2;
                            if (!miPushMessage.isArrivedMessage()) {
                                a.onReceiveMessage(this, miPushMessage);
                            }
                            if (miPushMessage.getPassThrough() == 1) {
                                a.onReceivePassThroughMessage(this, miPushMessage);
                                return;
                            } else if (miPushMessage.isNotified()) {
                                a.onNotificationMessageClicked(this, miPushMessage);
                                return;
                            } else {
                                a.onNotificationMessageArrived(this, miPushMessage);
                                return;
                            }
                        } else if (a2 instanceof MiPushCommandMessage) {
                            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a2;
                            a.onCommandResult(this, miPushCommandMessage);
                            if (TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                                a.onReceiveRegisterResult(this, miPushCommandMessage);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 2:
                    default:
                        return;
                    case 3:
                        MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) b.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                        a.onCommandResult(this, miPushCommandMessage2);
                        if (TextUtils.equals(miPushCommandMessage2.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                            a.onReceiveRegisterResult(this, miPushCommandMessage2);
                            return;
                        }
                        return;
                    case 4:
                        return;
                }
            } catch (RuntimeException e) {
                AbstractC1855b.m6720a(e);
            }
        }
    }
}
