package com.wanmei.sdk.core.log;

/* renamed from: com.wanmei.sdk.core.log.a */
public enum EnumC1758a {
    NORMAL,
    CRASH;

    /* renamed from: a */
    public static int m6478a(EnumC1758a aVar) {
        switch (aVar) {
            case CRASH:
                return 1;
            case NORMAL:
            default:
                return 2;
        }
    }
}
