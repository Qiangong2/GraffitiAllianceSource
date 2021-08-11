package com.pwrd.android.volley;

public interface Network {
    NetworkResponse performRequest(Request<?> request) throws VolleyError;
}
