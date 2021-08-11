.class public Lorg/pwrd/paho/client/mqttv3/MqttMessage;
.super Ljava/lang/Object;
.source "MqttMessage.java"


# instance fields
.field private dup:Z

.field private mutable:Z

.field private payload:[B

.field private qos:I

.field private retained:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->mutable:Z

    .line 28
    iput v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->qos:I

    .line 29
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->retained:Z

    .line 30
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->dup:Z

    .line 53
    new-array v0, v0, [B

    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setPayload([B)V

    .line 54
    return-void
.end method

.method public constructor <init>([B)V
    .locals 2
    .param p1, "payload"    # [B

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->mutable:Z

    .line 28
    iput v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->qos:I

    .line 29
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->retained:Z

    .line 30
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->dup:Z

    .line 61
    invoke-virtual {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setPayload([B)V

    .line 62
    return-void
.end method

.method public static validateQos(I)V
    .locals 1
    .param p0, "qos"    # I

    .prologue
    .line 37
    if-ltz p0, :cond_0

    const/4 v0, 0x2

    if-le p0, v0, :cond_1

    .line 38
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 40
    :cond_1
    return-void
.end method


# virtual methods
.method protected checkMutable()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 201
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->mutable:Z

    if-nez v0, :cond_0

    .line 202
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 204
    :cond_0
    return-void
.end method

.method public clearPayload()V
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->checkMutable()V

    .line 79
    const/4 v0, 0x0

    new-array v0, v0, [B

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->payload:[B

    .line 80
    return-void
.end method

.method public getPayload()[B
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->payload:[B

    return-object v0
.end method

.method public getQos()I
    .locals 1

    .prologue
    .line 130
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->qos:I

    return v0
.end method

.method public isDuplicate()Z
    .locals 1

    .prologue
    .line 217
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->dup:Z

    return v0
.end method

.method public isRetained()Z
    .locals 1

    .prologue
    .line 108
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->retained:Z

    return v0
.end method

.method protected setDuplicate(Z)V
    .locals 0
    .param p1, "dup"    # Z

    .prologue
    .line 207
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->dup:Z

    .line 208
    return-void
.end method

.method protected setMutable(Z)V
    .locals 0
    .param p1, "mutable"    # Z

    .prologue
    .line 197
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->mutable:Z

    .line 198
    return-void
.end method

.method public setPayload([B)V
    .locals 1
    .param p1, "payload"    # [B

    .prologue
    .line 90
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->checkMutable()V

    .line 91
    if-nez p1, :cond_0

    .line 92
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 94
    :cond_0
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->payload:[B

    .line 95
    return-void
.end method

.method public setQos(I)V
    .locals 0
    .param p1, "qos"    # I

    .prologue
    .line 174
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->checkMutable()V

    .line 175
    invoke-static {p1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->validateQos(I)V

    .line 176
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->qos:I

    .line 177
    return-void
.end method

.method public setRetained(Z)V
    .locals 0
    .param p1, "retained"    # Z

    .prologue
    .line 120
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->checkMutable()V

    .line 121
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->retained:Z

    .line 122
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 187
    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->payload:[B

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([B)V

    return-object v0
.end method
