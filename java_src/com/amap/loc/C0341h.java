package com.amap.loc;

import com.wanmei.push.ResponseCode;

/* renamed from: com.amap.loc.h */
/* compiled from: AMapCoreException */
public class C0341h extends Exception {

    /* renamed from: a */
    private String f818a = "未知的错误";

    /* renamed from: b */
    private int f819b = -1;

    public C0341h(String str) {
        super(str);
        this.f818a = str;
        m1225a(str);
    }

    /* renamed from: a */
    private void m1225a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f819b = 21;
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f819b = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f819b = 23;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f819b = 24;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f819b = 25;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f819b = 26;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f819b = 27;
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f819b = 28;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f819b = 29;
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f819b = 30;
        } else if ("未知的错误".equals(str)) {
            this.f819b = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f819b = 32;
        } else if ("requeust is null".equals(str)) {
            this.f819b = 1;
        } else if ("request url is empty".equals(str)) {
            this.f819b = 2;
        } else if ("response is null".equals(str)) {
            this.f819b = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f819b = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f819b = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f819b = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f819b = 7;
        } else if ("线程池为空".equals(str)) {
            this.f819b = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f819b = ResponseCode.PUSH_OPEN_FAIL_CODE;
        } else {
            this.f819b = -1;
        }
    }

    /* renamed from: a */
    public String mo3932a() {
        return this.f818a;
    }

    /* renamed from: b */
    public int mo3933b() {
        return this.f819b;
    }
}
