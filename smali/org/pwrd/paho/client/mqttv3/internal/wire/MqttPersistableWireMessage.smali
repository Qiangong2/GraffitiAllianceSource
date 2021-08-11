.class public abstract Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
.source "MqttPersistableWireMessage.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttPersistable;


# direct methods
.method public constructor <init>(B)V
    .locals 0
    .param p1, "type"    # B

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 27
    return-void
.end method


# virtual methods
.method public getHeaderBytes()[B
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 31
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;->getHeader()[B
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 33
    :catch_0
    move-exception v0

    .line 34
    .local v0, "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getHeaderLength()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 39
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;->getHeaderBytes()[B

    move-result-object v0

    array-length v0, v0

    return v0
.end method

.method public getHeaderOffset()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 43
    const/4 v0, 0x0

    return v0
.end method

.method public getPayloadBytes()[B
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 52
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;->getPayload()[B
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 54
    :catch_0
    move-exception v0

    .line 55
    .local v0, "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getPayloadLength()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 60
    const/4 v0, 0x0

    return v0
.end method

.method public getPayloadOffset()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 64
    const/4 v0, 0x0

    return v0
.end method
