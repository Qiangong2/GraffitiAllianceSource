package com.wanmei.sdk.core.param;

import java.util.HashMap;

public abstract class BaseParams {
    protected BaseParams() {
    }

    /* access modifiers changed from: protected */
    public abstract HashMap<String, String> addExtraParams(HashMap<String, String> hashMap);

    public HashMap<String, String> getExtraParams() {
        return addExtraParams(new HashMap<>());
    }
}
