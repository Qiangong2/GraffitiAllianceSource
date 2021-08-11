package com.wanmei.sdk.core.param;

import android.util.Log;

public class PayParameterDuplicateException extends RuntimeException {
    private static final long serialVersionUID = -5365630128867468164L;

    public PayParameterDuplicateException() {
    }

    public PayParameterDuplicateException(String detailMessage) {
        super(detailMessage);
        Log.d("PayParameterDuplicateException", detailMessage);
    }

    public PayParameterDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayParameterDuplicateException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}
