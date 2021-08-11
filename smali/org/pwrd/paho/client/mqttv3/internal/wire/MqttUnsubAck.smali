.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubAck;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
.source "MqttUnsubAck.java"


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
    .line 32
    const/16 v2, 0xb

    invoke-direct {p0, v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;-><init>(B)V

    .line 33
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 34
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    new-instance v1, Ljava/io/DataInputStream;

    invoke-direct {v1, v0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 35
    .local v1, "dis":Ljava/io/DataInputStream;
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v2

    iput v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubAck;->msgId:I

    .line 36
    invoke-virtual {v1}, Ljava/io/DataInputStream;->close()V

    .line 37
    return-void
.end method


# virtual methods
.method protected getVariableHeader()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 41
    const/4 v0, 0x0

    new-array v0, v0, [B

    return-object v0
.end method
