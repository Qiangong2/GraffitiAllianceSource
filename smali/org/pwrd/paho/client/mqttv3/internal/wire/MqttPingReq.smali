.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;
.super Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
.source "MqttPingReq.java"


# static fields
.field public static final KEY:Ljava/lang/String; = "Ping"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    const/16 v0, 0xc

    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 31
    return-void
.end method

.method public constructor <init>(B[B)V
    .locals 1
    .param p1, "info"    # B
    .param p2, "variableHeader"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 34
    const/16 v0, 0xc

    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;-><init>(B)V

    .line 35
    return-void
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    const-string v0, "Ping"

    return-object v0
.end method

.method protected getMessageInfo()B
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    return v0
.end method

.method protected getVariableHeader()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 46
    const/4 v0, 0x0

    new-array v0, v0, [B

    return-object v0
.end method

.method public isMessageIdRequired()Z
    .locals 1

    .prologue
    .line 42
    const/4 v0, 0x0

    return v0
.end method
