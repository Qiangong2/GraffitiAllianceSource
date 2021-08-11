package com.wanmei.sdk.core.net;

import android.content.Context;
import com.pwrd.android.volley.RequestQueue;
import com.pwrd.android.volley.Response;
import com.pwrd.android.volley.toolbox.HurlStack;
import com.pwrd.android.volley.toolbox.Volley;
import com.wanmei.sdk.core.bean.CommReq;
import com.wanmei.sdk.core.net.C1779g;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.util.LogUtil;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* renamed from: com.wanmei.sdk.core.net.f */
public class C1776f {

    /* renamed from: a */
    private Context f4484a;

    /* renamed from: b */
    private RequestQueue f4485b;

    public C1776f(Context context) {
        this.f4484a = context.getApplicationContext();
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            try {
                instance.init(null, new X509TrustManager[]{new X509TrustManager() {
                    /* class com.wanmei.sdk.core.net.C1776f.C17771 */

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }}, new SecureRandom());
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            if (instance != null) {
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            }
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                /* class com.wanmei.sdk.core.net.C1776f.C17782 */

                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            this.f4485b = Volley.newRequestQueue(context, new HurlStack(null, instance.getSocketFactory()));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo9584a() {
        this.f4485b.stop();
    }

    /* renamed from: a */
    public <T> void mo9585a(String str, CommReq commReq, Class<T> cls, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        LogUtil.m6672d("CsDownloader", "POST: " + str);
        commReq.setAppId(SDKCoreFacade.getInstance().getAppId());
        commReq.setChannelId(SDKCoreFacade.getInstance().getChannelId());
        this.f4485b.add(new C1779g.C1780a().mo9596b().mo9595a(str).mo9590a().mo9593a(commReq).mo9597b(commReq.getClass()).mo9592a(listener).mo9591a(errorListener).mo9594a(cls).mo9598c());
    }
}
