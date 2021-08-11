package com.unity3d.player;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* renamed from: com.unity3d.player.a */
public final class C1605a extends SSLSocketFactory {

    /* renamed from: c */
    private static volatile SSLSocketFactory f4111c;

    /* renamed from: d */
    private static final Object[] f4112d = new Object[0];

    /* renamed from: e */
    private static final boolean f4113e;

    /* renamed from: a */
    private final SSLSocketFactory f4114a;

    /* renamed from: b */
    private final C1606a f4115b = new C1606a();

    /* renamed from: com.unity3d.player.a$a */
    class C1606a implements HandshakeCompletedListener {
        C1606a() {
        }

        public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            SSLSession session = handshakeCompletedEvent.getSession();
            session.getCipherSuite();
            session.getProtocol();
            try {
                session.getPeerPrincipal().getName();
            } catch (SSLPeerUnverifiedException e) {
            }
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 20) {
            z = true;
        }
        f4113e = z;
    }

    private C1605a() {
        SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
        instance.init(null, null, null);
        this.f4114a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private static Socket m6097a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket) && f4113e) {
            ((SSLSocket) socket).setEnabledProtocols(((SSLSocket) socket).getSupportedProtocols());
        }
        return socket;
    }

    /* renamed from: a */
    public static SSLSocketFactory m6098a() {
        synchronized (f4112d) {
            if (f4111c != null) {
                return f4111c;
            }
            try {
                C1605a aVar = new C1605a();
                f4111c = aVar;
                return aVar;
            } catch (Exception e) {
                C1614e.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e.getMessage() + ")");
                return null;
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        return m6097a(this.f4114a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        return m6097a(this.f4114a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m6097a(this.f4114a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m6097a(this.f4114a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m6097a(this.f4114a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m6097a(this.f4114a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f4114a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f4114a.getSupportedCipherSuites();
    }
}
