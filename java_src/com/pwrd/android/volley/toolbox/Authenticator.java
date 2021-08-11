package com.pwrd.android.volley.toolbox;

import com.pwrd.android.volley.AuthFailureError;

public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
