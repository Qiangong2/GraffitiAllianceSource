package com.igexin.push.core;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.j */
public /* synthetic */ class C0621j {

    /* renamed from: a */
    static final /* synthetic */ int[] f1661a = new int[EnumC0623l.m2441a().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f1662b = new int[EnumC0622k.m2440a().length];

    static {
        try {
            f1662b[EnumC0622k.HEARTBEAT_OK.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1662b[EnumC0622k.HEARTBEAT_TIMEOUT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1662b[EnumC0622k.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1662b[EnumC0622k.NETWORK_SWITCH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1661a[EnumC0623l.DETECT.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1661a[EnumC0623l.STABLE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1661a[EnumC0623l.PENDING.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
