package com.wanmei.sdk.core.config;

public class ConfigFileException extends RuntimeException {
    private static final long serialVersionUID = -5365630128856068164L;

    public ConfigFileException() {
    }

    public ConfigFileException(String detailMessage) {
        super(detailMessage);
    }

    public ConfigFileException(String message, Throwable cause) {
        super(message, cause);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfigFileException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}
