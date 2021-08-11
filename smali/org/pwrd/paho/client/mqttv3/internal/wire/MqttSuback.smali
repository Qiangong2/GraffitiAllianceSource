.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
.source "MqttSuback.java"


# instance fields
.field private grantedQos:[I


# direct methods
.method public constructor <init>(B[B)V
    .locals 5
    .param p1, "info"    # B
    .param p2, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 34
    const/16 v4, 0x9

    invoke-direct {p0, v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;-><init>(B)V

    .line 35
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 36
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    new-instance v1, Ljava/io/DataInputStream;

    invoke-direct {v1, v0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 37
    .local v1, "dis":Ljava/io/DataInputStream;
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v4

    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->msgId:I

    .line 38
    const/4 v2, 0x0

    .line 39
    .local v2, "index":I
    array-length v4, p2

    add-int/lit8 v4, v4, -0x2

    new-array v4, v4, [I

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->grantedQos:[I

    .line 40
    invoke-virtual {v1}, Ljava/io/DataInputStream;->read()I

    move-result v3

    .line 41
    .local v3, "qos":I
    :goto_0
    const/4 v4, -0x1

    if-ne v3, v4, :cond_0

    .line 46
    invoke-virtual {v1}, Ljava/io/DataInputStream;->close()V

    .line 47
    return-void

    .line 42
    :cond_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->grantedQos:[I

    aput v3, v4, v2

    .line 43
    add-int/lit8 v2, v2, 0x1

    .line 44
    invoke-virtual {v1}, Ljava/io/DataInputStream;->read()I

    move-result v3

    goto :goto_0
.end method


# virtual methods
.method public getGrantedQos()[I
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->grantedQos:[I

    return-object v0
.end method

.method protected getVariableHeader()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 51
    const/4 v0, 0x0

    new-array v0, v0, [B

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 55
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 56
    .local v1, "sb":Ljava/lang/StringBuffer;
    invoke-super {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, " granted Qos"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 57
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->grantedQos:[I

    array-length v2, v2

    if-lt v0, v2, :cond_0

    .line 60
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 58
    :cond_0
    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->grantedQos:[I

    aget v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 57
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
