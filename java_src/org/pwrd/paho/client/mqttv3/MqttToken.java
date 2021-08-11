package org.pwrd.paho.client.mqttv3;

import org.pwrd.paho.client.mqttv3.internal.Token;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class MqttToken implements IMqttToken {
    public Token internalTok = null;

    public MqttToken() {
    }

    public MqttToken(String logContext) {
        this.internalTok = new Token(logContext);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public MqttException getException() {
        return this.internalTok.getException();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public boolean isComplete() {
        return this.internalTok.isComplete();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public void setActionCallback(IMqttActionListener listener) {
        this.internalTok.setActionCallback(listener);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public IMqttActionListener getActionCallback() {
        return this.internalTok.getActionCallback();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public void waitForCompletion() throws MqttException {
        this.internalTok.waitForCompletion(-1);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public void waitForCompletion(long timeout) throws MqttException {
        this.internalTok.waitForCompletion(timeout);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public IMqttAsyncClient getClient() {
        return this.internalTok.getClient();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public String[] getTopics() {
        return this.internalTok.getTopics();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public Object getUserContext() {
        return this.internalTok.getUserContext();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public void setUserContext(Object userContext) {
        this.internalTok.setUserContext(userContext);
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public int getMessageId() {
        return this.internalTok.getMessageID();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public int[] getGrantedQos() {
        return this.internalTok.getGrantedQos();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public boolean getSessionPresent() {
        return this.internalTok.getSessionPresent();
    }

    @Override // org.pwrd.paho.client.mqttv3.IMqttToken
    public MqttWireMessage getResponse() {
        return this.internalTok.getResponse();
    }
}
