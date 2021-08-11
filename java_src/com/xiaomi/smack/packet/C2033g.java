package com.xiaomi.smack.packet;

/* renamed from: com.xiaomi.smack.packet.g */
public class C2033g {

    /* renamed from: a */
    private String f5418a;

    public C2033g(String str) {
        this.f5418a = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stream:error (").append(this.f5418a).append(")");
        return sb.toString();
    }
}
