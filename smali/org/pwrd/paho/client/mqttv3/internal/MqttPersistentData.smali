.class public Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;
.super Ljava/lang/Object;
.source "MqttPersistentData.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttPersistable;


# instance fields
.field private hLength:I

.field private hOffset:I

.field private header:[B

.field private key:Ljava/lang/String;

.field private pLength:I

.field private pOffset:I

.field private payload:[B


# direct methods
.method public constructor <init>(Ljava/lang/String;[BII[BII)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "header"    # [B
    .param p3, "hOffset"    # I
    .param p4, "hLength"    # I
    .param p5, "payload"    # [B
    .param p6, "pOffset"    # I
    .param p7, "pLength"    # I

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->key:Ljava/lang/String;

    .line 25
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->header:[B

    .line 26
    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hOffset:I

    .line 27
    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hLength:I

    .line 30
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->payload:[B

    .line 31
    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pOffset:I

    .line 32
    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pLength:I

    .line 59
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->key:Ljava/lang/String;

    .line 60
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->header:[B

    .line 61
    iput p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hOffset:I

    .line 62
    iput p4, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hLength:I

    .line 63
    iput-object p5, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->payload:[B

    .line 64
    iput p6, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pOffset:I

    .line 65
    iput p7, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pLength:I

    .line 66
    return-void
.end method


# virtual methods
.method public getHeaderBytes()[B
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->header:[B

    return-object v0
.end method

.method public getHeaderLength()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hLength:I

    return v0
.end method

.method public getHeaderOffset()I
    .locals 1

    .prologue
    .line 81
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->hOffset:I

    return v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getPayloadBytes()[B
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->payload:[B

    return-object v0
.end method

.method public getPayloadLength()I
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->payload:[B

    if-nez v0, :cond_0

    .line 90
    const/4 v0, 0x0

    .line 92
    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pLength:I

    goto :goto_0
.end method

.method public getPayloadOffset()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/MqttPersistentData;->pOffset:I

    return v0
.end method
