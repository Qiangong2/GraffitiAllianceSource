package com.xiaomi.xmpush.thrift;

/* renamed from: com.xiaomi.xmpush.thrift.a */
public enum EnumC2064a {
    Registration(1),
    UnRegistration(2),
    Subscription(3),
    UnSubscription(4),
    SendMessage(5),
    AckMessage(6),
    SetConfig(7),
    ReportFeedback(8),
    Notification(9),
    Command(10),
    MultiConnectionBroadcast(11),
    MultiConnectionResult(12),
    ConnectionKick(13);
    

    /* renamed from: n */
    private final int f5520n;

    private EnumC2064a(int i) {
        this.f5520n = i;
    }

    /* renamed from: a */
    public static EnumC2064a m7770a(int i) {
        switch (i) {
            case 1:
                return Registration;
            case 2:
                return UnRegistration;
            case 3:
                return Subscription;
            case 4:
                return UnSubscription;
            case 5:
                return SendMessage;
            case 6:
                return AckMessage;
            case 7:
                return SetConfig;
            case 8:
                return ReportFeedback;
            case 9:
                return Notification;
            case 10:
                return Command;
            case 11:
                return MultiConnectionBroadcast;
            case 12:
                return MultiConnectionResult;
            case 13:
                return ConnectionKick;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int mo10671a() {
        return this.f5520n;
    }
}
