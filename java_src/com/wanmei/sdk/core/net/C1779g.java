package com.wanmei.sdk.core.net;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.pwrd.android.volley.AuthFailureError;
import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.ParseError;
import com.pwrd.android.volley.Response;
import com.pwrd.android.volley.VolleyError;
import com.pwrd.android.volley.plus.RequestPro;
import com.pwrd.android.volley.toolbox.HttpHeaderParser;
import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.GsonBuilder;
import com.wanmei.push.bean.AppState;
import com.wanmei.sdk.core.bean.CommReq;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.util.C1843d;
import com.wanmei.sdk.core.util.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wanmei.sdk.core.net.g */
public class C1779g<T> extends RequestPro<T> {

    /* renamed from: a */
    private final String f4488a = "Request";

    /* renamed from: b */
    private C1781b<T> f4489b = new C1781b<>();

    /* renamed from: com.wanmei.sdk.core.net.g$a */
    public static class C1780a<T> {

        /* renamed from: a */
        private C1781b<T> f4490a = new C1781b<>();

        /* renamed from: a */
        public C1780a<T> mo9590a() {
            ((C1781b) this.f4490a).f4495e = true;
            return this;
        }

        /* renamed from: a */
        public C1780a<T> mo9591a(Response.ErrorListener errorListener) {
            ((C1781b) this.f4490a).f4498h = errorListener;
            return this;
        }

        /* renamed from: a */
        public C1780a<T> mo9592a(Response.Listener<T> listener) {
            ((C1781b) this.f4490a).f4497g = listener;
            return this;
        }

        /* renamed from: a */
        public C1780a<T> mo9593a(CommReq commReq) {
            ((C1781b) this.f4490a).f4499i = commReq;
            return this;
        }

        /* renamed from: a */
        public C1780a<T> mo9594a(Class<T> cls) {
            ((C1781b) this.f4490a).f4492b = cls;
            return this;
        }

        /* renamed from: a */
        public C1780a<T> mo9595a(String str) {
            ((C1781b) this.f4490a).f4493c = str;
            return this;
        }

        /* renamed from: b */
        public C1780a<T> mo9596b() {
            ((C1781b) this.f4490a).f4496f = 1;
            return this;
        }

        /* renamed from: b */
        public C1780a<T> mo9597b(Class cls) {
            ((C1781b) this.f4490a).f4500j = cls;
            return this;
        }

        /* renamed from: c */
        public C1779g<T> mo9598c() {
            if (TextUtils.isEmpty(((C1781b) this.f4490a).f4493c)) {
                throw new IllegalArgumentException("url not set");
            } else if (((C1781b) this.f4490a).f4497g == null) {
                throw new IllegalArgumentException("successListener not set");
            } else if (((C1781b) this.f4490a).f4498h == null) {
                throw new IllegalArgumentException("errorListener not set");
            } else if (((C1781b) this.f4490a).f4492b == null) {
                throw new IllegalArgumentException("responseClass not set");
            } else if (((C1781b) this.f4490a).f4500j == null) {
                throw new IllegalArgumentException("requestBodyType not set");
            } else if (((C1781b) this.f4490a).f4499i != null) {
                return new C1779g<>(((C1781b) this.f4490a).f4496f, ((C1781b) this.f4490a).f4493c, ((C1781b) this.f4490a).f4495e, ((C1781b) this.f4490a).f4491a, ((C1781b) this.f4490a).f4499i, ((C1781b) this.f4490a).f4500j, ((C1781b) this.f4490a).f4497g, ((C1781b) this.f4490a).f4498h, ((C1781b) this.f4490a).f4492b);
            } else {
                throw new IllegalArgumentException("requestBody not set");
            }
        }
    }

    /* renamed from: com.wanmei.sdk.core.net.g$b */
    public static class C1781b<T> {

        /* renamed from: a */
        private Map<String, String> f4491a;

        /* renamed from: b */
        private Class<T> f4492b;

        /* renamed from: c */
        private String f4493c;

        /* renamed from: d */
        private HashMap<String, String> f4494d = new HashMap<>();

        /* renamed from: e */
        private boolean f4495e;

        /* renamed from: f */
        private int f4496f = 0;

        /* renamed from: g */
        private Response.Listener<T> f4497g;

        /* renamed from: h */
        private Response.ErrorListener f4498h;

        /* renamed from: i */
        private CommReq f4499i;

        /* renamed from: j */
        private Class f4500j;
    }

    public C1779g(int i, String str, boolean z, Map<String, String> map, CommReq commReq, Class cls, Response.Listener<T> listener, Response.ErrorListener errorListener, Class<T> cls2) {
        super(i, str, map, listener, errorListener);
        ((C1781b) this.f4489b).f4495e = z;
        ((C1781b) this.f4489b).f4492b = cls2;
        ((C1781b) this.f4489b).f4491a = map;
        ((C1781b) this.f4489b).f4496f = i;
        ((C1781b) this.f4489b).f4493c = str;
        ((C1781b) this.f4489b).f4497g = listener;
        ((C1781b) this.f4489b).f4498h = errorListener;
        ((C1781b) this.f4489b).f4500j = cls;
        ((C1781b) this.f4489b).f4499i = commReq;
    }

    @Override // com.pwrd.android.volley.Request, com.pwrd.android.volley.plus.RequestPro
    public byte[] getBody() throws AuthFailureError {
        String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(((C1781b) this.f4489b).f4499i, ((C1781b) this.f4489b).f4500j);
        if (json == null) {
            json = "";
        }
        LogUtil.m6672d("Request", "request body: " + json);
        if (((C1781b) this.f4489b).f4495e) {
            String appKey = SDKCoreFacade.getInstance().getAppKey();
            json = Base64.encodeToString(C1843d.m6689a(json, appKey.substring(appKey.length() - 16, appKey.length())), 2);
        }
        LogUtil.m6672d("Request", "request body encrypt: " + json);
        try {
            return json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("Request", "UnsupportedEncodingException at getBody:" + e.getMessage());
            return null;
        }
    }

    @Override // com.pwrd.android.volley.Request, com.pwrd.android.volley.plus.RequestPro
    public String getCacheKey() {
        return ((C1781b) this.f4489b).f4493c;
    }

    @Override // com.pwrd.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        ((C1781b) this.f4489b).f4494d.put(AppState.APP_ID, String.valueOf(SDKCoreFacade.getInstance().getAppId()));
        for (String str : ((C1781b) this.f4489b).f4494d.keySet()) {
            LogUtil.m6672d("Request", "--------> " + str + " : " + ((String) ((C1781b) this.f4489b).f4494d.get(str)));
        }
        return ((C1781b) this.f4489b).f4494d;
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public VolleyError parseNetworkError(VolleyError volleyError) {
        return (volleyError.getMessage() == null || !volleyError.getMessage().equals("empty")) ? super.parseNetworkError(volleyError) : new VolleyError();
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request, com.pwrd.android.volley.plus.RequestPro
    public Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String str = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            LogUtil.m6672d("Request", "resp String:\n" + str);
            if (((C1781b) this.f4489b).f4495e) {
                String appKey = SDKCoreFacade.getInstance().getAppKey();
                str = C1843d.m6688a(Base64.decode(str, 2), appKey.substring(appKey.length() - 16, appKey.length()));
            }
            if (TextUtils.isEmpty(str)) {
                return Response.error(new VolleyError("empty"));
            }
            LogUtil.m6672d("Request", "resp String decrypt:\n" + str);
            return Response.success(new Gson().fromJson(str, (Class) ((C1781b) this.f4489b).f4492b), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }
}
