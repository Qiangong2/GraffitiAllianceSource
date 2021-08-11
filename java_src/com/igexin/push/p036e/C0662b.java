package com.igexin.push.p036e;

import android.content.ServiceConnection;
import com.igexin.sdk.aidl.IGexinMsgService;

/* renamed from: com.igexin.push.e.b */
public class C0662b {

    /* renamed from: a */
    private String f1789a;

    /* renamed from: b */
    private String f1790b;

    /* renamed from: c */
    private IGexinMsgService f1791c;

    /* renamed from: d */
    private ServiceConnection f1792d;

    /* renamed from: e */
    private String f1793e;

    /* renamed from: a */
    public String mo4703a() {
        return this.f1789a;
    }

    /* renamed from: a */
    public void mo4704a(ServiceConnection serviceConnection) {
        this.f1792d = serviceConnection;
    }

    /* renamed from: a */
    public void mo4705a(IGexinMsgService iGexinMsgService) {
        this.f1791c = iGexinMsgService;
    }

    /* renamed from: a */
    public void mo4706a(String str) {
        this.f1789a = str;
    }

    /* renamed from: b */
    public String mo4707b() {
        return this.f1790b;
    }

    /* renamed from: b */
    public void mo4708b(String str) {
        this.f1790b = str;
    }

    /* renamed from: c */
    public IGexinMsgService mo4709c() {
        return this.f1791c;
    }

    /* renamed from: c */
    public void mo4710c(String str) {
        this.f1793e = str;
    }

    /* renamed from: d */
    public ServiceConnection mo4711d() {
        return this.f1792d;
    }

    /* renamed from: e */
    public String mo4712e() {
        return this.f1793e;
    }
}
