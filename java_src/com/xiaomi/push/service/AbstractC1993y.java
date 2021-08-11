package com.xiaomi.push.service;

/* renamed from: com.xiaomi.push.service.y */
public abstract class AbstractC1993y {

    /* renamed from: A */
    public static String f5149A = "ext_notify_type";

    /* renamed from: B */
    public static String f5150B = "ext_session";

    /* renamed from: C */
    public static String f5151C = "sig";

    /* renamed from: a */
    public static String f5152a = "1";

    /* renamed from: b */
    public static String f5153b = "2";

    /* renamed from: c */
    public static String f5154c = "3";

    /* renamed from: d */
    public static String f5155d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e */
    public static String f5156e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f */
    public static String f5157f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g */
    public static String f5158g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h */
    public static String f5159h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i */
    public static String f5160i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j */
    public static String f5161j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k */
    public static String f5162k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l */
    public static String f5163l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m */
    public static String f5164m = "com.xiaomi.push.SEND_STATS";

    /* renamed from: n */
    public static String f5165n = "com.xiaomi.push.CHANGE_HOST";

    /* renamed from: o */
    public static String f5166o = "com.xiaomi.push.PING_TIMER";

    /* renamed from: p */
    public static String f5167p = "ext_user_id";

    /* renamed from: q */
    public static String f5168q = "ext_chid";

    /* renamed from: r */
    public static String f5169r = "ext_sid";

    /* renamed from: s */
    public static String f5170s = "ext_token";

    /* renamed from: t */
    public static String f5171t = "ext_auth_method";

    /* renamed from: u */
    public static String f5172u = "ext_security";

    /* renamed from: v */
    public static String f5173v = "ext_kick";

    /* renamed from: w */
    public static String f5174w = "ext_client_attr";

    /* renamed from: x */
    public static String f5175x = "ext_cloud_attr";

    /* renamed from: y */
    public static String f5176y = "ext_pkg_name";

    /* renamed from: z */
    public static String f5177z = "ext_notify_id";

    /* renamed from: a */
    public static String m7431a(int i) {
        switch (i) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i);
        }
    }
}
