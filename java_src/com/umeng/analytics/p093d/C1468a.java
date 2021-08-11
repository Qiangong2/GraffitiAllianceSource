package com.umeng.analytics.p093d;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.umeng.analytics.d.a */
/* compiled from: NetworkHelper */
class C1468a implements X509TrustManager {

    /* renamed from: a */
    X509TrustManager f3616a;

    public C1468a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                if (trustManagers[i] instanceof X509TrustManager) {
                    this.f3616a = (X509TrustManager) trustManagers[i];
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        try {
            this.f3616a.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.f3616a.getAcceptedIssuers();
    }
}
