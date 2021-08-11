.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;
.source "MqttPubRel.java"


# direct methods
.method public constructor <init>(B[B)V
    .locals 3
    .param p1, "info"    # B
    .param p2, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    const/4 v2, 0x6

    invoke-direct {p0, v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;-><init>(B)V

    .line 47
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 48
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    new-instance v1, Ljava/io/DataInputStream;

    invoke-direct {v1, v0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 49
    .local v1, "dis":Ljava/io/DataInputStream;
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v2

    iput v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->msgId:I

    .line 50
    invoke-virtual {v1}, Ljava/io/DataInputStream;->close()V

    .line 51
    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;)V
    .locals 1
    .param p1, "pubRec"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    .prologue
    .line 35
    const/4 v0, 0x6

    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;-><init>(B)V

    .line 36
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;->getMessageId()I

    move-result v0

    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->setMessageId(I)V

    .line 37
    return-void
.end method


# virtual methods
.method protected getMessageInfo()B
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->duplicate:Z

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    :goto_0
    or-int/lit8 v0, v0, 0x2

    int-to-byte v0, v0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected getVariableHeader()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 54
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->encodeMessageId()[B

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 62
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-super {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPersistableWireMessage;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " msgId "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->msgId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
