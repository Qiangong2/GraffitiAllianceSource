package org.pwrd.paho.client.mqttv3.internal;

import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class SSLNetworkModule extends TCPNetworkModule {
    private static final String CLASS_NAME = SSLNetworkModule.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String[] enabledCiphers;
    private int handshakeTimeoutSecs;

    public SSLNetworkModule(SSLSocketFactory factory, String host, int port, String resourceContext) {
        super(factory, host, port, resourceContext);
        log.setResourceName(resourceContext);
    }

    public String[] getEnabledCiphers() {
        return this.enabledCiphers;
    }

    public void setEnabledCiphers(String[] enabledCiphers2) {
        this.enabledCiphers = enabledCiphers2;
        if (!(this.socket == null || enabledCiphers2 == null)) {
            if (log.isLoggable(5)) {
                String ciphers = "";
                for (int i = 0; i < enabledCiphers2.length; i++) {
                    if (i > 0) {
                        ciphers = String.valueOf(ciphers) + MiPushClient.ACCEPT_TIME_SEPARATOR;
                    }
                    ciphers = String.valueOf(ciphers) + enabledCiphers2[i];
                }
                log.fine(CLASS_NAME, "setEnabledCiphers", "260", new Object[]{ciphers});
            }
            ((SSLSocket) this.socket).setEnabledCipherSuites(enabledCiphers2);
        }
    }

    public void setSSLhandshakeTimeout(int timeout) {
        super.setConnectTimeout(timeout);
        this.handshakeTimeoutSecs = timeout;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.NetworkModule, org.pwrd.paho.client.mqttv3.internal.TCPNetworkModule
    public void start() throws IOException, MqttException {
        super.start();
        setEnabledCiphers(this.enabledCiphers);
        int soTimeout = this.socket.getSoTimeout();
        if (soTimeout == 0) {
            this.socket.setSoTimeout(this.handshakeTimeoutSecs * 1000);
        }
        ((SSLSocket) this.socket).startHandshake();
        this.socket.setSoTimeout(soTimeout);
    }
}
