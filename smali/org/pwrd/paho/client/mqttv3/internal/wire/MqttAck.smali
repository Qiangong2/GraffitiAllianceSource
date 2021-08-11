.class public abstract Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
.source "MqttAck.java"


# direct methods
.method public constructor <init>(B)V
    .locals 0
    .param p1, "type"    # B

    .prologue
    .line 24
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 25
    return-void
.end method


# virtual methods
.method protected getMessageInfo()B
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-super {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " msgId "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->msgId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
