package com.tencent.qcloud.core.auth;

public class AuthConstants {
    public static String Q_AK = "q-ak";
    public static String Q_HEADER_LIST = "q-header-list";
    public static String Q_KEY_TIME = "q-key-time";
    public static String Q_SIGNATURE = "q-signature";
    public static String Q_SIGN_ALGORITHM = "q-sign-algorithm";
    public static String Q_SIGN_TIME = "q-sign-time";
    public static String Q_URL_PARAM_LIST = "q-url-param-list";
    public static String SHA1 = "sha1";

    private AuthConstants() {
        throw new AssertionError("AuthConstants is static class");
    }
}
