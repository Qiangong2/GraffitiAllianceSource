.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
.source "MqttSubscribe.java"


# instance fields
.field private count:I

.field private names:[Ljava/lang/String;

.field private qos:[I


# direct methods
.method public constructor <init>(B[B)V
    .locals 7
    .param p1, "info"    # B
    .param p2, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0xa

    .line 44
    const/16 v4, 0x8

    invoke-direct {p0, v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 45
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 46
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    new-instance v1, Ljava/io/DataInputStream;

    invoke-direct {v1, v0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 47
    .local v1, "dis":Ljava/io/DataInputStream;
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v4

    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->msgId:I

    .line 49
    const/4 v4, 0x0

    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    .line 50
    new-array v4, v5, [Ljava/lang/String;

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    .line 51
    new-array v4, v5, [I

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->qos:[I

    .line 52
    const/4 v3, 0x0

    .line 53
    .local v3, "end":Z
    :goto_0
    if-eqz v3, :cond_0

    .line 61
    invoke-virtual {v1}, Ljava/io/DataInputStream;->close()V

    .line 62
    return-void

    .line 55
    :cond_0
    :try_start_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    invoke-virtual {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->decodeUTF8(Ljava/io/DataInputStream;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 56
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->qos:[I

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    invoke-virtual {v1}, Ljava/io/DataInputStream;->readByte()B

    move-result v6

    aput v6, v4, v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 57
    :catch_0
    move-exception v2

    .line 58
    .local v2, "e":Ljava/lang/Exception;
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public constructor <init>([Ljava/lang/String;[I)V
    .locals 3
    .param p1, "names"    # [Ljava/lang/String;
    .param p2, "qos"    # [I

    .prologue
    .line 70
    const/16 v1, 0x8

    invoke-direct {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 71
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    .line 72
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->qos:[I

    .line 74
    array-length v1, p1

    array-length v2, p2

    if-eq v1, v2, :cond_0

    .line 75
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 78
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p2

    if-lt v0, v1, :cond_1

    .line 81
    return-void

    .line 79
    :cond_1
    aget v1, p2, v0

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->validateQos(I)V

    .line 78
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method protected getMessageInfo()B
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->duplicate:Z

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

.method public getPayload()[B
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 126
    :try_start_0
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 127
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 128
    .local v1, "dos":Ljava/io/DataOutputStream;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    array-length v4, v4

    if-lt v3, v4, :cond_0

    .line 132
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    return-object v4

    .line 129
    :cond_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    aget-object v4, v4, v3

    invoke-virtual {p0, v1, v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->encodeUTF8(Ljava/io/DataOutputStream;Ljava/lang/String;)V

    .line 130
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->qos:[I

    aget v4, v4, v3

    invoke-virtual {v1, v4}, Ljava/io/DataOutputStream;->writeByte(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 133
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "dos":Ljava/io/DataOutputStream;
    .end local v3    # "i":I
    :catch_0
    move-exception v2

    .line 134
    .local v2, "ex":Ljava/io/IOException;
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v4, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method protected getVariableHeader()[B
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 114
    :try_start_0
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 115
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 116
    .local v1, "dos":Ljava/io/DataOutputStream;
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->msgId:I

    invoke-virtual {v1, v3}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 117
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->flush()V

    .line 118
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    return-object v3

    .line 119
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "dos":Ljava/io/DataOutputStream;
    :catch_0
    move-exception v2

    .line 120
    .local v2, "ex":Ljava/io/IOException;
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public isRetryable()Z
    .locals 1

    .prologue
    .line 139
    const/4 v0, 0x1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 87
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 88
    .local v1, "sb":Ljava/lang/StringBuffer;
    invoke-super {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 89
    const-string v2, " names:["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 90
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    if-lt v0, v2, :cond_0

    .line 96
    const-string v2, "] qos:["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 97
    const/4 v0, 0x0

    :goto_1
    iget v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->count:I

    if-lt v0, v2, :cond_2

    .line 103
    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 105
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 91
    :cond_0
    if-lez v0, :cond_1

    .line 92
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 94
    :cond_1
    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->names:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 90
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 98
    :cond_2
    if-lez v0, :cond_3

    .line 99
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 101
    :cond_3
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;->qos:[I

    aget v2, v2, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 97
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method
