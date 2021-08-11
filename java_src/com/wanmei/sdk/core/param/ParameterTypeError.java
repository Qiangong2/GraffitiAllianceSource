package com.wanmei.sdk.core.param;

import android.util.Log;

public class ParameterTypeError extends RuntimeException {
    private static final long serialVersionUID = -5365630128867468164L;

    public ParameterTypeError() {
    }

    public ParameterTypeError(String detailMessage) {
        super(detailMessage);
        Log.d("ParameterTypeError", detailMessage);
    }

    public ParameterTypeError(String message, Throwable cause) {
        super(message, cause);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParameterTypeError(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}
