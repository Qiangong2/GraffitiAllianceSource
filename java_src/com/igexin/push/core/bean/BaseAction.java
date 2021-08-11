package com.igexin.push.core.bean;

public class BaseAction {

    /* renamed from: a */
    private String f1441a;

    /* renamed from: b */
    private String f1442b;

    /* renamed from: c */
    private String f1443c;

    /* renamed from: d */
    private boolean f1444d = true;

    public String getActionId() {
        return this.f1441a;
    }

    public String getDoActionId() {
        return this.f1443c;
    }

    public String getType() {
        return this.f1442b;
    }

    public boolean isSupportExt() {
        return this.f1444d;
    }

    public void setActionId(String str) {
        this.f1441a = str;
    }

    public void setDoActionId(String str) {
        this.f1443c = str;
    }

    public void setSupportExt(boolean z) {
        this.f1444d = z;
    }

    public void setType(String str) {
        this.f1442b = str;
    }
}
