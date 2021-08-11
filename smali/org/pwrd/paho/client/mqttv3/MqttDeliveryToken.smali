.class public Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
.super Lorg/pwrd/paho/client/mqttv3/MqttToken;
.source "MqttDeliveryToken.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>()V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "logContext"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 36
    return-void
.end method


# virtual methods
.method public getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v0

    return-object v0
.end method

.method protected setMessage(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V
    .locals 1
    .param p1, "msg"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .prologue
    .line 51
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setMessage(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 52
    return-void
.end method
