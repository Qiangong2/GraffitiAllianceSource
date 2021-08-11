package org.pwrd.paho.client.mqttv3.internal;

import org.pwrd.paho.client.mqttv3.IMqttActionListener;
import org.pwrd.paho.client.mqttv3.IMqttToken;
import org.pwrd.paho.client.mqttv3.MqttAsyncClient;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttConnectOptions;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;
import org.pwrd.paho.client.mqttv3.MqttToken;

public class ConnectActionListener implements IMqttActionListener {
    private MqttAsyncClient client;
    private ClientComms comms;
    private MqttConnectOptions options;
    private int originalMqttVersion;
    private MqttClientPersistence persistence;
    private IMqttActionListener userCallback;
    private Object userContext;
    private MqttToken userToken;

    public ConnectActionListener(MqttAsyncClient client2, MqttClientPersistence persistence2, ClientComms comms2, MqttConnectOptions options2, MqttToken userToken2, Object userContext2, IMqttActionListener userCallback2) {
        this.persistence = persistence2;
        this.client = client2;
        this.comms = comms2;
        this.options = options2;
        this.userToken = userToken2;
        this.userContext = userContext2;
        this.userCallback = userCallback2;
        this.originalMqttVersion = options2.getMqttVersion();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
    public void onSuccess(IMqttToken token) {
        if (this.originalMqttVersion == 0) {
            this.options.setMqttVersion(0);
        }
        this.userToken.internalTok.markComplete(token.getResponse(), null);
        this.userToken.internalTok.notifyComplete();
        if (this.userCallback != null) {
            this.userToken.setUserContext(this.userContext);
            this.userCallback.onSuccess(this.userToken);
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
    public void onFailure(IMqttToken token, Throwable exception) {
        MqttException ex;
        int numberOfURIs = this.comms.getNetworkModules().length;
        int index = this.comms.getNetworkModuleIndex();
        if (index + 1 < numberOfURIs || (this.originalMqttVersion == 0 && this.options.getMqttVersion() == 4)) {
            if (this.originalMqttVersion != 0) {
                this.comms.setNetworkModuleIndex(index + 1);
            } else if (this.options.getMqttVersion() == 4) {
                this.options.setMqttVersion(3);
            } else {
                this.options.setMqttVersion(4);
                this.comms.setNetworkModuleIndex(index + 1);
            }
            try {
                connect();
            } catch (MqttPersistenceException e) {
                onFailure(token, e);
            }
        } else {
            if (this.originalMqttVersion == 0) {
                this.options.setMqttVersion(0);
            }
            if (exception instanceof MqttException) {
                ex = (MqttException) exception;
            } else {
                ex = new MqttException(exception);
            }
            this.userToken.internalTok.markComplete(null, ex);
            this.userToken.internalTok.notifyComplete();
            if (this.userCallback != null) {
                this.userToken.setUserContext(this.userContext);
                this.userCallback.onFailure(this.userToken, exception);
            }
        }
    }

    public void connect() throws MqttPersistenceException {
        MqttToken token = new MqttToken(this.client.getClientId());
        token.setActionCallback(this);
        token.setUserContext(this);
        this.persistence.open(this.client.getClientId(), this.client.getServerURI());
        if (this.options.isCleanSession()) {
            this.persistence.clear();
        }
        if (this.options.getMqttVersion() == 0) {
            this.options.setMqttVersion(4);
        }
        try {
            this.comms.connect(this.options, token);
        } catch (MqttException e) {
            onFailure(token, e);
        }
    }
}
