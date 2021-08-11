package com.igexin.push.core;

import com.igexin.sdk.aidl.AbstractBinderC1175a;

/* renamed from: com.igexin.push.core.p */
final class BinderC0627p extends AbstractBinderC1175a {
    BinderC0627p() {
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public byte[] extFunction(byte[] bArr) {
        return null;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int isStarted(String str) {
        return 1;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int onASNLConnected(String str, String str2, String str3, long j) {
        if (C0617f.m2395a() != null) {
            return C0617f.m2395a().mo4629h().mo4713a(str3);
        }
        return -1;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int onASNLNetworkConnected() {
        if (C0617f.m2395a().mo4628g().mo4741a()) {
            return -1;
        }
        C0617f.m2395a().mo4628g().mo4742b();
        return 0;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int onASNLNetworkDisconnected() {
        if (C0617f.m2395a().mo4628g().mo4741a()) {
            return -1;
        }
        C0617f.m2395a().mo4628g().mo4743b(false);
        return 0;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int onPSNLConnected(String str, String str2, String str3, long j) {
        if (C0617f.m2395a() == null || str.equals("") || str2.equals("")) {
            return -1;
        }
        return C0617f.m2395a().mo4629h().mo4715a(str, str2);
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int receiveToPSNL(String str, String str2, byte[] bArr) {
        if (str2 == null || bArr == null || C0617f.m2395a().mo4628g().mo4741a()) {
            return -1;
        }
        return C0617f.m2395a().mo4629h().mo4722b(str, str2, bArr);
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int sendByASNL(String str, String str2, byte[] bArr) {
        if (str2 == null || bArr == null || !C0617f.m2395a().mo4628g().mo4741a()) {
            return -1;
        }
        return C0617f.m2395a().mo4629h().mo4716a(str, str2, bArr);
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int setSilentTime(int i, int i2, String str) {
        return 1;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int startService(String str) {
        return 1;
    }

    @Override // com.igexin.sdk.aidl.IGexinMsgService
    public int stopService(String str) {
        return 1;
    }
}
