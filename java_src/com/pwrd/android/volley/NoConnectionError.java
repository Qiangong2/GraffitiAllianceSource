package com.pwrd.android.volley;

public class NoConnectionError extends NetworkError {
    public NoConnectionError() {
    }

    public NoConnectionError(Throwable reason) {
        super(reason);
    }
}
