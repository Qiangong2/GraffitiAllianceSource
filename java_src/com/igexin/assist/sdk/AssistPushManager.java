package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.push.core.C0618g;

public class AssistPushManager {

    /* renamed from: a */
    private AbstractPushManager f1021a;

    private AssistPushManager() {
    }

    public static AssistPushManager getInstance() {
        return C0433c.m1569a();
    }

    public static String getToken() {
        return C0618g.f1654y;
    }

    public void initialize(Context context) {
        this.f1021a = C0431a.m1564a(context);
    }

    public void register(Context context) {
        if (this.f1021a != null) {
            this.f1021a.register(context);
        }
    }

    public void setSilentTime(Context context, int i, int i2) {
        if (this.f1021a != null) {
            this.f1021a.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(Context context) {
        if (this.f1021a != null) {
            this.f1021a.turnOffPush(context);
        }
    }

    public void turnOnPush(Context context) {
        if (this.f1021a != null) {
            this.f1021a.turnOnPush(context);
        }
    }

    public void unregister(Context context) {
        if (this.f1021a != null) {
            this.f1021a.unregister(context);
        }
    }
}
