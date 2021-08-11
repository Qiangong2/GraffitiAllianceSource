package com.igexin.push.extension.distribution.basic.p041b;

import com.igexin.push.core.bean.BaseAction;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.b.q */
public class C0729q extends BaseAction {

    /* renamed from: a */
    private String f1995a;

    /* renamed from: b */
    private boolean f1996b;

    /* renamed from: c */
    private boolean f1997c = false;

    /* renamed from: d */
    private List<String> f1998d = new ArrayList();

    /* renamed from: e */
    private List<String> f1999e = new ArrayList();

    /* renamed from: a */
    public void mo4979a(String str) {
        this.f1995a = str;
    }

    /* renamed from: a */
    public void mo4980a(boolean z) {
        this.f1997c = z;
    }

    /* renamed from: a */
    public boolean mo4981a() {
        return this.f1997c;
    }

    /* renamed from: b */
    public String mo4982b() {
        return this.f1995a;
    }

    /* renamed from: b */
    public void mo4983b(String str) {
        this.f1998d = Arrays.asList(str.split(MiPushClient.ACCEPT_TIME_SEPARATOR));
    }

    /* renamed from: b */
    public void mo4984b(boolean z) {
        this.f1996b = z;
    }

    /* renamed from: c */
    public List<String> mo4985c() {
        return this.f1998d;
    }

    /* renamed from: c */
    public void mo4986c(String str) {
        this.f1999e = Arrays.asList(str.split(MiPushClient.ACCEPT_TIME_SEPARATOR));
    }

    /* renamed from: d */
    public List<String> mo4987d() {
        return this.f1999e;
    }

    /* renamed from: e */
    public boolean mo4988e() {
        return this.f1996b;
    }
}
