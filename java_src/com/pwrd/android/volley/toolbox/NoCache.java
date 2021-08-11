package com.pwrd.android.volley.toolbox;

import com.pwrd.android.volley.Cache;

public class NoCache implements Cache {
    @Override // com.pwrd.android.volley.Cache
    public void clear() {
    }

    @Override // com.pwrd.android.volley.Cache
    public Cache.Entry get(String key) {
        return null;
    }

    @Override // com.pwrd.android.volley.Cache
    public void put(String key, Cache.Entry entry) {
    }

    @Override // com.pwrd.android.volley.Cache
    public void invalidate(String key, boolean fullExpire) {
    }

    @Override // com.pwrd.android.volley.Cache
    public void remove(String key) {
    }

    @Override // com.pwrd.android.volley.Cache
    public void initialize() {
    }
}
