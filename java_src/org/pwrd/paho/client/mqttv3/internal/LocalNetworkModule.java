package org.pwrd.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.pwrd.paho.client.mqttv3.MqttException;

public class LocalNetworkModule implements NetworkModule {
    private String brokerName;
    private Object localAdapter;
    private Class localListener;

    public LocalNetworkModule(String brokerName2) {
        this.brokerName = brokerName2;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.NetworkModule
    public void start() throws IOException, MqttException {
        if (!ExceptionHelper.isClassAvailable("com.ibm.mqttdirect.modules.local.bindings.localListener")) {
            throw ExceptionHelper.createMqttException(32103);
        }
        try {
            this.localListener = Class.forName("com.ibm.mqttdirect.modules.local.bindings.localListener");
            this.localAdapter = this.localListener.getMethod("connect", String.class).invoke(null, this.brokerName);
        } catch (Exception e) {
        }
        if (this.localAdapter == null) {
            throw ExceptionHelper.createMqttException(32103);
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.NetworkModule
    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) this.localListener.getMethod("getClientInputStream", new Class[0]).invoke(this.localAdapter, new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.NetworkModule
    public OutputStream getOutputStream() throws IOException {
        try {
            return (OutputStream) this.localListener.getMethod("getClientOutputStream", new Class[0]).invoke(this.localAdapter, new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.NetworkModule
    public void stop() throws IOException {
        if (this.localAdapter != null) {
            try {
                this.localListener.getMethod("close", new Class[0]).invoke(this.localAdapter, new Object[0]);
            } catch (Exception e) {
            }
        }
    }
}
