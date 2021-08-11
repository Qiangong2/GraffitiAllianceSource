package com.xiaomi.smack;

import com.wanmei.push.ResponseCode;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.smack.c */
public class C2005c {
    /* renamed from: a */
    public static int m7526a(Throwable th) {
        Throwable a = (!(th instanceof C2023p) || ((C2023p) th).mo10561a() == null) ? th : ((C2023p) th).mo10561a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        if (a instanceof SocketTimeoutException) {
            return 105;
        }
        if (a instanceof SocketException) {
            if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            }
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return ResponseCode.PUSH_OPEN_FAIL_CODE;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        } else if (a instanceof UnknownHostException) {
            return 107;
        } else {
            return th instanceof C2023p ? 399 : 0;
        }
    }
}
