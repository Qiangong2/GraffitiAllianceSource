package com.wanmei.sdk.core.open;

import com.wanmei.sdk.core.param.OrderParams;

public abstract class SDKImpl extends SDKFoundation {
    /* access modifiers changed from: protected */
    public abstract void doLoginImpl();

    /* access modifiers changed from: protected */
    public abstract void doLogoutImpl();

    /* access modifiers changed from: protected */
    public abstract void doPayImpl(OrderParams orderParams);

    /* access modifiers changed from: protected */
    public abstract void initImpl();
}
