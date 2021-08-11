package com.igexin.sdk.message;

import com.igexin.push.core.C0618g;
import java.io.Serializable;

public class BaseMessage implements Serializable {

    /* renamed from: a */
    private String f3069a = C0618g.f1602a;

    /* renamed from: b */
    private String f3070b = C0618g.f1634e;

    /* renamed from: c */
    private String f3071c = C0618g.f1647r;

    public String getAppid() {
        return this.f3069a;
    }

    public String getClientId() {
        return this.f3071c;
    }

    public String getPkgName() {
        return this.f3070b;
    }

    public void setAppid(String str) {
        this.f3069a = str;
    }

    public void setClientId(String str) {
        this.f3071c = str;
    }

    public void setPkgName(String str) {
        this.f3070b = str;
    }
}
