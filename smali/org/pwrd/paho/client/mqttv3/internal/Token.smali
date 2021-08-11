.class public Lorg/pwrd/paho/client/mqttv3/internal/Token;
.super Ljava/lang/Object;
.source "Token.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private callback:Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

.field private client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

.field private volatile completed:Z

.field private exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

.field private key:Ljava/lang/String;

.field protected message:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

.field private messageID:I

.field private notified:Z

.field private pendingComplete:Z

.field private response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

.field private responseLock:Ljava/lang/Object;

.field private sent:Z

.field private sentLock:Ljava/lang/Object;

.field private topics:[Ljava/lang/String;

.field private userContext:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    .line 32
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 3
    .param p1, "logContext"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    .line 35
    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    .line 36
    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    .line 38
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    .line 39
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    .line 41
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->message:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .line 42
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 43
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 44
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->topics:[Ljava/lang/String;

    .line 48
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    .line 49
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->callback:Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    .line 51
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->userContext:Ljava/lang/Object;

    .line 53
    iput v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->messageID:I

    .line 54
    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->notified:Z

    .line 57
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v0, p1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 58
    return-void
.end method


# virtual methods
.method public checkResult()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 69
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 70
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v0

    throw v0

    .line 72
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->callback:Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    return-object v0
.end method

.method public getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    return-object v0
.end method

.method public getException()Lorg/pwrd/paho/client/mqttv3/MqttException;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    return-object v0
.end method

.method public getGrantedQos()[I
    .locals 2

    .prologue
    .line 373
    const/4 v1, 0x0

    new-array v0, v1, [I

    .line 374
    .local v0, "val":[I
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    instance-of v1, v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;

    if-eqz v1, :cond_0

    .line 375
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSuback;->getGrantedQos()[I

    move-result-object v0

    .line 377
    :cond_0
    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 337
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->message:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    return-object v0
.end method

.method public getMessageID()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->messageID:I

    return v0
.end method

.method public getResponse()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    return-object v0
.end method

.method public getSessionPresent()Z
    .locals 2

    .prologue
    .line 381
    const/4 v0, 0x0

    .line 382
    .local v0, "val":Z
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    instance-of v1, v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    if-eqz v1, :cond_0

    .line 383
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;->getSessionPresent()Z

    move-result v0

    .line 385
    :cond_0
    return v0
.end method

.method public getTopics()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->topics:[Ljava/lang/String;

    return-object v0
.end method

.method public getUserContext()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->userContext:Ljava/lang/Object;

    return-object v0
.end method

.method public getWireMessage()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 1

    .prologue
    .line 308
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    return-object v0
.end method

.method public isComplete()Z
    .locals 1

    .prologue
    .line 80
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    return v0
.end method

.method protected isCompletePending()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    return v0
.end method

.method protected isInUse()Z
    .locals 1

    .prologue
    .line 88
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isComplete()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isNotified()Z
    .locals 1

    .prologue
    .line 347
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->notified:Z

    return v0
.end method

.method protected markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 9
    .param p1, "msg"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "ex"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    const/4 v8, 0x1

    .line 174
    const-string v0, "markComplete"

    .line 176
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "markComplete"

    const-string v4, "404"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    aput-object p1, v5, v8

    const/4 v6, 0x2

    aput-object p2, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v2

    .line 180
    :try_start_0
    instance-of v1, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-eqz v1, :cond_0

    .line 181
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->message:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .line 183
    :cond_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    .line 184
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 185
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 178
    monitor-exit v2

    .line 187
    return-void

    .line 178
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method protected notifyComplete()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 193
    const-string v0, "notifyComplete"

    .line 195
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifyComplete"

    const-string v4, "404"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    aput-object v6, v5, v8

    const/4 v6, 0x2

    iget-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    aput-object v7, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 197
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v2

    .line 202
    :try_start_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    if-eqz v1, :cond_0

    .line 203
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    .line 204
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    .line 209
    :goto_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 197
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 211
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    monitor-enter v2

    .line 212
    const/4 v1, 0x1

    :try_start_1
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    .line 213
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 211
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 215
    return-void

    .line 206
    :cond_0
    const/4 v1, 0x0

    :try_start_2
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->pendingComplete:Z

    goto :goto_0

    .line 197
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1

    .line 211
    :catchall_1
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v1
.end method

.method protected notifySent()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 265
    const-string v0, "notifySent"

    .line 267
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifySent"

    const-string v4, "403"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 268
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v2

    .line 269
    const/4 v1, 0x0

    :try_start_0
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 270
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    .line 268
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 272
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    monitor-enter v2

    .line 273
    const/4 v1, 0x1

    :try_start_1
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    .line 274
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 272
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 276
    return-void

    .line 268
    :catchall_0
    move-exception v1

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1

    .line 272
    :catchall_1
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v1
.end method

.method public reset()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 287
    const-string v0, "reset"

    .line 288
    .local v0, "methodName":Ljava/lang/String;
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isInUse()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 290
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7dc9

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 293
    :cond_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "reset"

    const-string v4, "410"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 295
    iput-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    .line 296
    iput-boolean v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    .line 297
    iput-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 298
    iput-boolean v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    .line 299
    iput-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 300
    iput-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->userContext:Ljava/lang/Object;

    .line 301
    return-void
.end method

.method public setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 0
    .param p1, "listener"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    .prologue
    .line 92
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->callback:Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    .line 94
    return-void
.end method

.method protected setClient(Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;)V
    .locals 0
    .param p1, "client"    # Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    .prologue
    .line 283
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    .line 284
    return-void
.end method

.method public setException(Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 2
    .param p1, "exception"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    .line 341
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v1

    .line 342
    :try_start_0
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 341
    monitor-exit v1

    .line 344
    return-void

    .line 341
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public setKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 333
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->key:Ljava/lang/String;

    .line 334
    return-void
.end method

.method public setMessage(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V
    .locals 0
    .param p1, "msg"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .prologue
    .line 313
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->message:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .line 314
    return-void
.end method

.method public setMessageID(I)V
    .locals 0
    .param p1, "messageID"    # I

    .prologue
    .line 65
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->messageID:I

    .line 66
    return-void
.end method

.method public setNotified(Z)V
    .locals 0
    .param p1, "notified"    # Z

    .prologue
    .line 351
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->notified:Z

    .line 352
    return-void
.end method

.method public setTopics([Ljava/lang/String;)V
    .locals 0
    .param p1, "topics"    # [Ljava/lang/String;

    .prologue
    .line 321
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->topics:[Ljava/lang/String;

    .line 322
    return-void
.end method

.method public setUserContext(Ljava/lang/Object;)V
    .locals 0
    .param p1, "userContext"    # Ljava/lang/Object;

    .prologue
    .line 329
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->userContext:Ljava/lang/Object;

    .line 330
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 355
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 356
    .local v1, "tok":Ljava/lang/StringBuffer;
    const-string v2, "key="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 357
    const-string v2, " ,topics="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 358
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getTopics()[Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 359
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getTopics()[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    if-lt v0, v2, :cond_1

    .line 363
    .end local v0    # "i":I
    :cond_0
    const-string v2, " ,usercontext="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getUserContext()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 364
    const-string v2, " ,isComplete="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isComplete()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Z)Ljava/lang/StringBuffer;

    .line 365
    const-string v2, " ,isNotified="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isNotified()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Z)Ljava/lang/StringBuffer;

    .line 366
    const-string v2, " ,exception="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 367
    const-string v2, " ,actioncallback="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 369
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 360
    .restart local v0    # "i":I
    :cond_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getTopics()[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 359
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public waitForCompletion()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 100
    const-wide/16 v0, -0x1

    invoke-virtual {p0, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitForCompletion(J)V

    .line 101
    return-void
.end method

.method public waitForCompletion(J)V
    .locals 11
    .param p1, "timeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 104
    const-string v0, "waitForCompletion"

    .line 106
    .local v0, "methodName":Ljava/lang/String;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "waitForCompletion"

    const-string v5, "407"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    new-instance v7, Ljava/lang/Long;

    invoke-direct {v7, p1, p2}, Ljava/lang/Long;-><init>(J)V

    aput-object v7, v6, v9

    aput-object p0, v6, v10

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 108
    invoke-virtual {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitForResponse(J)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v1

    .line 109
    .local v1, "resp":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    if-nez v1, :cond_0

    iget-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    if-nez v2, :cond_0

    .line 111
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "waitForCompletion"

    const-string v5, "406"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    aput-object p0, v6, v9

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 112
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v3, 0x7d00

    invoke-direct {v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    iput-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 113
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    throw v2

    .line 115
    :cond_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->checkResult()Z

    .line 116
    return-void
.end method

.method protected waitForResponse()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 125
    const-wide/16 v0, -0x1

    invoke-virtual {p0, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitForResponse(J)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v0

    return-object v0
.end method

.method protected waitForResponse(J)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 11
    .param p1, "timeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 129
    const-string v7, "waitForResponse"

    .line 130
    .local v7, "methodName":Ljava/lang/String;
    iget-object v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v8

    .line 132
    :try_start_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "waitForResponse"

    const-string v3, "400"

    const/4 v4, 0x7

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x1

    new-instance v9, Ljava/lang/Long;

    invoke-direct {v9, p1, p2}, Ljava/lang/Long;-><init>(J)V

    aput-object v9, v4, v5

    const/4 v5, 0x2

    new-instance v9, Ljava/lang/Boolean;

    iget-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    invoke-direct {v9, v10}, Ljava/lang/Boolean;-><init>(Z)V

    aput-object v9, v4, v5

    const/4 v5, 0x3

    new-instance v9, Ljava/lang/Boolean;

    iget-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    invoke-direct {v9, v10}, Ljava/lang/Boolean;-><init>(Z)V

    aput-object v9, v4, v5

    const/4 v9, 0x4

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v5, :cond_1

    const-string v5, "false"

    :goto_0
    aput-object v5, v4, v9

    const/4 v5, 0x5

    iget-object v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    aput-object v9, v4, v5

    const/4 v5, 0x6

    aput-object p0, v4, v5

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 134
    :cond_0
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    if-eqz v0, :cond_2

    .line 130
    :goto_1
    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 164
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "waitForResponse"

    const-string v3, "402"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    const/4 v5, 0x1

    iget-object v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    aput-object v8, v4, v5

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 165
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->response:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    return-object v0

    .line 132
    :cond_1
    :try_start_1
    const-string v5, "true"

    goto :goto_0

    .line 135
    :cond_2
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_3

    .line 138
    :try_start_2
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "waitForResponse"

    const-string v3, "408"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x1

    new-instance v9, Ljava/lang/Long;

    invoke-direct {v9, p1, p2}, Ljava/lang/Long;-><init>(J)V

    aput-object v9, v4, v5

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 140
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_4

    .line 141
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->wait()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 149
    :cond_3
    :goto_2
    :try_start_3
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->completed:Z

    if-nez v0, :cond_0

    .line 150
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-eqz v0, :cond_5

    .line 152
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "waitForResponse"

    const-string v3, "401"

    const/4 v4, 0x0

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 153
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    throw v0

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    .line 143
    :cond_4
    :try_start_4
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    invoke-virtual {v0, p1, p2}, Ljava/lang/Object;->wait(J)V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_2

    .line 145
    :catch_0
    move-exception v6

    .line 146
    .local v6, "e":Ljava/lang/InterruptedException;
    :try_start_5
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 156
    .end local v6    # "e":Ljava/lang/InterruptedException;
    :cond_5
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    goto :goto_1
.end method

.method public waitUntilSent()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 234
    const-string v0, "waitUntilSent"

    .line 235
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    monitor-enter v2

    .line 236
    :try_start_0
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->responseLock:Ljava/lang/Object;

    monitor-enter v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 237
    :try_start_1
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-eqz v1, :cond_0

    .line 238
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    throw v1

    .line 236
    :catchall_0
    move-exception v1

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v1

    .line 235
    :catchall_1
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    .line 236
    :cond_0
    :try_start_3
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 241
    :goto_0
    :try_start_4
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    if-eqz v1, :cond_1

    .line 251
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sent:Z

    if-nez v1, :cond_3

    .line 252
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v1, :cond_2

    .line 253
    const/4 v1, 0x6

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 244
    :cond_1
    :try_start_5
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/Token;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/Token;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "waitUntilSent"

    const-string v5, "409"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-interface {v1, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 246
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->sentLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_0

    .line 247
    :catch_0
    move-exception v1

    goto :goto_0

    .line 255
    :cond_2
    :try_start_6
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/Token;->exception:Lorg/pwrd/paho/client/mqttv3/MqttException;

    throw v1

    .line 235
    :cond_3
    monitor-exit v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 258
    return-void
.end method
