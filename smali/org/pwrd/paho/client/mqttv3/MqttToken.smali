.class public Lorg/pwrd/paho/client/mqttv3/MqttToken;
.super Ljava/lang/Object;
.source "MqttToken.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttToken;


# instance fields
.field public internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    .line 40
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "logContext"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    .line 43
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-direct {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    .line 44
    return-void
.end method


# virtual methods
.method public getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    move-result-object v0

    return-object v0
.end method

.method public getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v0

    return-object v0
.end method

.method public getException()Lorg/pwrd/paho/client/mqttv3/MqttException;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v0

    return-object v0
.end method

.method public getGrantedQos()[I
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getGrantedQos()[I

    move-result-object v0

    return-object v0
.end method

.method public getMessageId()I
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getMessageID()I

    move-result v0

    return v0
.end method

.method public getResponse()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getResponse()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v0

    return-object v0
.end method

.method public getSessionPresent()Z
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getSessionPresent()Z

    move-result v0

    return v0
.end method

.method public getTopics()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getTopics()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserContext()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getUserContext()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isComplete()Z
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isComplete()Z

    move-result v0

    return v0
.end method

.method public setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 1
    .param p1, "listener"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    .prologue
    .line 55
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 57
    return-void
.end method

.method public setUserContext(Ljava/lang/Object;)V
    .locals 1
    .param p1, "userContext"    # Ljava/lang/Object;

    .prologue
    .line 83
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setUserContext(Ljava/lang/Object;)V

    .line 84
    return-void
.end method

.method public waitForCompletion()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    const-wide/16 v2, -0x1

    invoke-virtual {v0, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitForCompletion(J)V

    .line 64
    return-void
.end method

.method public waitForCompletion(J)V
    .locals 1
    .param p1, "timeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitForCompletion(J)V

    .line 68
    return-void
.end method
