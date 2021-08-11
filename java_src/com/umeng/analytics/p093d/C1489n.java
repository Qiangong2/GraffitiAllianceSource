package com.umeng.analytics.p093d;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.d.n */
/* compiled from: NetworkHelper */
public class C1489n extends SSLSocketFactory {

    /* renamed from: a */
    SSLContext f3677a = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);

    public C1489n(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        try {
            C14901 r0 = new C1468a() {
                /* class com.umeng.analytics.p093d.C1489n.C14901 */
            };
            this.f3677a.init(null, new TrustManager[]{r0}, null);
        } catch (Throwable th) {
        }
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory, org.apache.http.conn.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.f3677a.getSocketFactory().createSocket(socket, str, i, z);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory, org.apache.http.conn.ssl.SSLSocketFactory
    public Socket createSocket() throws IOException {
        return this.f3677a.getSocketFactory().createSocket();
    }
}
