.class public interface abstract Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;
.super Ljava/lang/Object;
.source "IMqttAsyncClient.java"


# virtual methods
.method public abstract close()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract connect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation
.end method

.method public abstract connect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation
.end method

.method public abstract connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation
.end method

.method public abstract connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation
.end method

.method public abstract disconnect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnect(J)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnect(JLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnectForcibly()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnectForcibly(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract disconnectForcibly(JJ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract getClientId()Ljava/lang/String;
.end method

.method public abstract getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
.end method

.method public abstract getServerURI()Ljava/lang/String;
.end method

.method public abstract isConnected()Z
.end method

.method public abstract publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation
.end method

.method public abstract publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation
.end method

.method public abstract publish(Ljava/lang/String;[BIZ)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation
.end method

.method public abstract publish(Ljava/lang/String;[BIZLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation
.end method

.method public abstract setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V
.end method

.method public abstract subscribe(Ljava/lang/String;I)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract subscribe(Ljava/lang/String;ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract subscribe([Ljava/lang/String;[I)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract unsubscribe(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract unsubscribe(Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract unsubscribe([Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public abstract unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method
