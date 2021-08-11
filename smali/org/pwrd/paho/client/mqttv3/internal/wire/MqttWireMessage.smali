.class public abstract Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
.super Ljava/lang/Object;
.source "MqttWireMessage.java"


# static fields
.field public static final MESSAGE_TYPE_CONNACK:B = 0x2t

.field public static final MESSAGE_TYPE_CONNECT:B = 0x1t

.field public static final MESSAGE_TYPE_DISCONNECT:B = 0xet

.field public static final MESSAGE_TYPE_PINGREQ:B = 0xct

.field public static final MESSAGE_TYPE_PINGRESP:B = 0xdt

.field public static final MESSAGE_TYPE_PUBACK:B = 0x4t

.field public static final MESSAGE_TYPE_PUBCOMP:B = 0x7t

.field public static final MESSAGE_TYPE_PUBLISH:B = 0x3t

.field public static final MESSAGE_TYPE_PUBREC:B = 0x5t

.field public static final MESSAGE_TYPE_PUBREL:B = 0x6t

.field public static final MESSAGE_TYPE_SUBACK:B = 0x9t

.field public static final MESSAGE_TYPE_SUBSCRIBE:B = 0x8t

.field public static final MESSAGE_TYPE_UNSUBACK:B = 0xbt

.field public static final MESSAGE_TYPE_UNSUBSCRIBE:B = 0xat

.field private static final PACKET_NAMES:[Ljava/lang/String;

.field protected static final STRING_ENCODING:Ljava/lang/String; = "UTF-8"


# instance fields
.field protected duplicate:Z

.field protected msgId:I

.field private type:B


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 53
    const/16 v0, 0xf

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "reserved"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "CONNECT"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "CONNACK"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "PUBLISH"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    .line 54
    const-string v2, "PUBACK"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "PUBREC"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "PUBREL"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "PUBCOMP"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "SUBSCRIBE"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "SUBACK"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    .line 55
    const-string v2, "UNSUBSCRIBE"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "UNSUBACK"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "PINGREQ"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "PINGRESP"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "DISCONNECT"

    aput-object v2, v0, v1

    .line 53
    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->PACKET_NAMES:[Ljava/lang/String;

    .line 55
    return-void
.end method

.method public constructor <init>(B)V
    .locals 1
    .param p1, "type"    # B

    .prologue
    const/4 v0, 0x0

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->duplicate:Z

    .line 66
    iput-byte p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->type:B

    .line 69
    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->msgId:I

    .line 70
    return-void
.end method

.method private static createWireMessage(Ljava/io/InputStream;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 18
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 169
    :try_start_0
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;-><init>(Ljava/io/InputStream;)V

    .line 170
    .local v2, "counter":Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;
    new-instance v5, Ljava/io/DataInputStream;

    invoke-direct {v5, v2}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 171
    .local v5, "in":Ljava/io/DataInputStream;
    invoke-virtual {v5}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v4

    .line 172
    .local v4, "first":I
    shr-int/lit8 v16, v4, 0x4

    move/from16 v0, v16

    int-to-byte v13, v0

    .line 173
    .local v13, "type":B
    and-int/lit8 v4, v4, 0xf

    int-to-byte v6, v4

    .line 174
    .local v6, "info":B
    invoke-static {v5}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->readMBI(Ljava/io/DataInputStream;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;->getValue()J

    move-result-wide v8

    .line 175
    .local v8, "remLen":J
    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->getCounter()I

    move-result v16

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    add-long v14, v16, v8

    .line 178
    .local v14, "totalToRead":J
    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->getCounter()I

    move-result v16

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    sub-long v10, v14, v16

    .line 179
    .local v10, "remainder":J
    const/16 v16, 0x0

    move/from16 v0, v16

    new-array v3, v0, [B

    .line 181
    .local v3, "data":[B
    const-wide/16 v16, 0x0

    cmp-long v16, v10, v16

    if-lez v16, :cond_0

    .line 182
    long-to-int v0, v10

    move/from16 v16, v0

    move/from16 v0, v16

    new-array v3, v0, [B

    .line 183
    const/16 v16, 0x0

    array-length v0, v3

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v5, v3, v0, v1}, Ljava/io/DataInputStream;->readFully([BII)V

    .line 186
    :cond_0
    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v13, v0, :cond_1

    .line 187
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;-><init>(B[B)V

    .line 231
    .local v12, "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :goto_0
    return-object v12

    .line 189
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_1
    const/16 v16, 0x3

    move/from16 v0, v16

    if-ne v13, v0, :cond_2

    .line 190
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;-><init>(B[B)V

    .line 191
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 192
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_2
    const/16 v16, 0x4

    move/from16 v0, v16

    if-ne v13, v0, :cond_3

    .line 193
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;-><init>(B[B)V

    .line 194
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 195
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_3
    const/16 v16, 0x7

    move/from16 v0, v16

    if-ne v13, v0, :cond_4

    .line 196
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;-><init>(B[B)V

    .line 197
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 198
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_4
    const/16 v16, 0x2

    move/from16 v0, v16

    if-ne v13, v0, :cond_5

    .line 199
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;-><init>(B[B)V

    .line 200
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 201
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_5
    const/16 v16, 0xc

    move/from16 v0, v16

    if-ne v13, v0, :cond_6

    .line 202
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;-><init>(B[B)V

    .line 203
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 204
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_6
    const/16 v16, 0xd

    move/from16 v0, v16

    if-ne v13, v0, :cond_7

    .line 205
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingResp;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingResp;-><init>(B[B)V

    .line 206
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 207
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_7
    const/16 v16, 0x8

    move/from16 v0, v16

    if-ne v13, v0, :cond_8

    .line 208
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;-><init>(B[B)V

    .line 209
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 210
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_8
    const/16 v16, 0x9

    move/from16 v0, v16

    if-ne v13, v0, :cond_9

    .line 211
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;-><init>(B[B)V

    .line 212
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 213
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_9
    const/16 v16, 0xa

    move/from16 v0, v16

    if-ne v13, v0, :cond_a

    .line 214
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;-><init>(B[B)V

    .line 215
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 216
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_a
    const/16 v16, 0xb

    move/from16 v0, v16

    if-ne v13, v0, :cond_b

    .line 217
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubAck;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubAck;-><init>(B[B)V

    .line 218
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto :goto_0

    .line 219
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_b
    const/16 v16, 0x6

    move/from16 v0, v16

    if-ne v13, v0, :cond_c

    .line 220
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;-><init>(B[B)V

    .line 221
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto/16 :goto_0

    .line 222
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_c
    const/16 v16, 0x5

    move/from16 v0, v16

    if-ne v13, v0, :cond_d

    .line 223
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;-><init>(B[B)V

    .line 224
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto/16 :goto_0

    .line 225
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_d
    const/16 v16, 0xe

    move/from16 v0, v16

    if-ne v13, v0, :cond_e

    .line 226
    new-instance v12, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    invoke-direct {v12, v6, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;-><init>(B[B)V

    .line 227
    .restart local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    goto/16 :goto_0

    .line 229
    .end local v12    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_e
    const/16 v16, 0x6

    invoke-static/range {v16 .. v16}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v16

    throw v16
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 232
    .end local v2    # "counter":Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;
    .end local v3    # "data":[B
    .end local v4    # "first":I
    .end local v5    # "in":Ljava/io/DataInputStream;
    .end local v6    # "info":B
    .end local v8    # "remLen":J
    .end local v10    # "remainder":J
    .end local v13    # "type":B
    .end local v14    # "totalToRead":J
    :catch_0
    move-exception v7

    .line 233
    .local v7, "io":Ljava/io/IOException;
    new-instance v16, Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-object/from16 v0, v16

    invoke-direct {v0, v7}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v16
.end method

.method public static createWireMessage(Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 7
    .param p0, "data"    # Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 145
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getPayloadBytes()[B

    move-result-object v4

    .line 149
    .local v4, "payload":[B
    if-nez v4, :cond_0

    .line 150
    const/4 v1, 0x0

    new-array v4, v1, [B

    .line 152
    :cond_0
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteArrayInputStream;

    .line 153
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getHeaderBytes()[B

    move-result-object v1

    .line 154
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getHeaderOffset()I

    move-result v2

    .line 155
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getHeaderLength()I

    move-result v3

    .line 157
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getPayloadOffset()I

    move-result v5

    .line 158
    invoke-interface {p0}, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;->getPayloadLength()I

    move-result v6

    .line 152
    invoke-direct/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteArrayInputStream;-><init>([BII[BII)V

    .line 159
    .local v0, "mbais":Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteArrayInputStream;
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->createWireMessage(Ljava/io/InputStream;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v1

    return-object v1
.end method

.method public static createWireMessage([B)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 2
    .param p0, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 163
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 164
    .local v0, "bais":Ljava/io/ByteArrayInputStream;
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->createWireMessage(Ljava/io/InputStream;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v1

    return-object v1
.end method

.method protected static encodeMBI(J)[B
    .locals 12
    .param p0, "number"    # J

    .prologue
    const-wide/16 v10, 0x80

    const-wide/16 v8, 0x0

    .line 238
    const/4 v4, 0x0

    .line 239
    .local v4, "numBytes":I
    move-wide v2, p0

    .line 240
    .local v2, "no":J
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 243
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    :cond_0
    rem-long v6, v2, v10

    long-to-int v5, v6

    int-to-byte v1, v5

    .line 244
    .local v1, "digit":B
    div-long/2addr v2, v10

    .line 245
    cmp-long v5, v2, v8

    if-lez v5, :cond_1

    .line 246
    or-int/lit16 v5, v1, 0x80

    int-to-byte v1, v5

    .line 248
    :cond_1
    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 249
    add-int/lit8 v4, v4, 0x1

    .line 250
    cmp-long v5, v2, v8

    if-lez v5, :cond_2

    const/4 v5, 0x4

    .line 242
    if-lt v4, v5, :cond_0

    .line 252
    :cond_2
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    return-object v5
.end method

.method protected static readMBI(Ljava/io/DataInputStream;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;
    .locals 8
    .param p0, "in"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 260
    const-wide/16 v2, 0x0

    .line 261
    .local v2, "msgLength":J
    const/4 v4, 0x1

    .line 262
    .local v4, "multiplier":I
    const/4 v0, 0x0

    .line 265
    .local v0, "count":I
    :cond_0
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readByte()B

    move-result v1

    .line 266
    .local v1, "digit":B
    add-int/lit8 v0, v0, 0x1

    .line 267
    and-int/lit8 v5, v1, 0x7f

    mul-int/2addr v5, v4

    int-to-long v6, v5

    add-long/2addr v2, v6

    .line 268
    mul-int/lit16 v4, v4, 0x80

    .line 269
    and-int/lit16 v5, v1, 0x80

    if-nez v5, :cond_0

    .line 271
    new-instance v5, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;

    invoke-direct {v5, v2, v3, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;-><init>(JI)V

    return-object v5
.end method


# virtual methods
.method protected decodeUTF8(Ljava/io/DataInputStream;)Ljava/lang/String;
    .locals 5
    .param p1, "input"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 338
    :try_start_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v0

    .line 340
    .local v0, "encodedLength":I
    new-array v1, v0, [B

    .line 341
    .local v1, "encodedString":[B
    invoke-virtual {p1, v1}, Ljava/io/DataInputStream;->readFully([B)V

    .line 343
    new-instance v3, Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-direct {v3, v1, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v3

    .line 344
    .end local v0    # "encodedLength":I
    .end local v1    # "encodedString":[B
    :catch_0
    move-exception v2

    .line 345
    .local v2, "ex":Ljava/io/IOException;
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method protected encodeMessageId()[B
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 276
    :try_start_0
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 277
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 278
    .local v1, "dos":Ljava/io/DataOutputStream;
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->msgId:I

    invoke-virtual {v1, v3}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 279
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->flush()V

    .line 280
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    return-object v3

    .line 282
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "dos":Ljava/io/DataOutputStream;
    :catch_0
    move-exception v2

    .line 283
    .local v2, "ex":Ljava/io/IOException;
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method protected encodeUTF8(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    .locals 5
    .param p1, "dos"    # Ljava/io/DataOutputStream;
    .param p2, "stringToEncode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 308
    :try_start_0
    const-string v4, "UTF-8"

    invoke-virtual {p2, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    .line 309
    .local v2, "encodedString":[B
    array-length v4, v2

    ushr-int/lit8 v4, v4, 0x8

    and-int/lit16 v4, v4, 0xff

    int-to-byte v0, v4

    .line 310
    .local v0, "byte1":B
    array-length v4, v2

    ushr-int/lit8 v4, v4, 0x0

    and-int/lit16 v4, v4, 0xff

    int-to-byte v1, v4

    .line 313
    .local v1, "byte2":B
    invoke-virtual {p1, v0}, Ljava/io/DataOutputStream;->write(I)V

    .line 314
    invoke-virtual {p1, v1}, Ljava/io/DataOutputStream;->write(I)V

    .line 315
    invoke-virtual {p1, v2}, Ljava/io/DataOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 323
    return-void

    .line 317
    .end local v0    # "byte1":B
    .end local v1    # "byte2":B
    .end local v2    # "encodedString":[B
    :catch_0
    move-exception v3

    .line 319
    .local v3, "ex":Ljava/io/UnsupportedEncodingException;
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v4, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 320
    .end local v3    # "ex":Ljava/io/UnsupportedEncodingException;
    :catch_1
    move-exception v3

    .line 321
    .local v3, "ex":Ljava/io/IOException;
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v4, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method public getHeader()[B
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 118
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getType()B

    move-result v6

    and-int/lit8 v6, v6, 0xf

    shl-int/lit8 v6, v6, 0x4

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageInfo()B

    move-result v7

    and-int/lit8 v7, v7, 0xf

    xor-int v2, v6, v7

    .line 119
    .local v2, "first":I
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getVariableHeader()[B

    move-result-object v5

    .line 120
    .local v5, "varHeader":[B
    array-length v6, v5

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getPayload()[B

    move-result-object v7

    array-length v7, v7

    add-int v4, v6, v7

    .line 122
    .local v4, "remLen":I
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 123
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-direct {v1, v0}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 124
    .local v1, "dos":Ljava/io/DataOutputStream;
    invoke-virtual {v1, v2}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 125
    int-to-long v6, v4

    invoke-static {v6, v7}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->encodeMBI(J)[B

    move-result-object v6

    invoke-virtual {v1, v6}, Ljava/io/DataOutputStream;->write([B)V

    .line 126
    invoke-virtual {v1, v5}, Ljava/io/DataOutputStream;->write([B)V

    .line 127
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->flush()V

    .line 128
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    return-object v6

    .line 129
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "dos":Ljava/io/DataOutputStream;
    .end local v2    # "first":I
    .end local v4    # "remLen":I
    .end local v5    # "varHeader":[B
    :catch_0
    move-exception v3

    .line 130
    .local v3, "ioe":Ljava/io/IOException;
    new-instance v6, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v6, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    throw v6
.end method

.method public getKey()Ljava/lang/String;
    .locals 2

    .prologue
    .line 113
    new-instance v0, Ljava/lang/Integer;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMessageId()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->msgId:I

    return v0
.end method

.method protected abstract getMessageInfo()B
.end method

.method public getPayload()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 82
    const/4 v0, 0x0

    new-array v0, v0, [B

    return-object v0
.end method

.method public getType()B
    .locals 1

    .prologue
    .line 89
    iget-byte v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->type:B

    return v0
.end method

.method protected abstract getVariableHeader()[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation
.end method

.method public isMessageIdRequired()Z
    .locals 1

    .prologue
    .line 141
    const/4 v0, 0x1

    return v0
.end method

.method public isRetryable()Z
    .locals 1

    .prologue
    .line 288
    const/4 v0, 0x0

    return v0
.end method

.method public setDuplicate(Z)V
    .locals 0
    .param p1, "duplicate"    # Z

    .prologue
    .line 292
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->duplicate:Z

    .line 293
    return-void
.end method

.method public setMessageId(I)V
    .locals 0
    .param p1, "msgId"    # I

    .prologue
    .line 103
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->msgId:I

    .line 104
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 350
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->PACKET_NAMES:[Ljava/lang/String;

    iget-byte v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->type:B

    aget-object v0, v0, v1

    return-object v0
.end method
