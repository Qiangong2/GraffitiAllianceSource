.class public Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;
.super Ljava/lang/Object;
.source "CommsCallback.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final INBOUND_QUEUE_SIZE:I = 0xa

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private callbackThread:Ljava/lang/Thread;

.field private clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

.field private completeQueue:Ljava/util/Vector;

.field private lifecycle:Ljava/lang/Object;

.field private messageQueue:Ljava/util/Vector;

.field private mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

.field private quiescing:Z

.field public running:Z

.field private spaceAvailable:Ljava/lang/Object;

.field private workAvailable:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    .line 39
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 41
    return-void
.end method

.method constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V
    .locals 2
    .param p1, "clientComms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .prologue
    const/16 v1, 0xa

    const/4 v0, 0x0

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    .line 47
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    .line 48
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->lifecycle:Ljava/lang/Object;

    .line 50
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    .line 51
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    .line 55
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 56
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0, v1}, Ljava/util/Vector;-><init>(I)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    .line 57
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0, v1}, Ljava/util/Vector;-><init>(I)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    .line 58
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method private handleActionComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 9
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 194
    const-string v1, "handleActionComplete"

    .line 195
    .local v1, "methodName":Ljava/lang/String;
    monitor-enter p1

    .line 197
    :try_start_0
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "handleActionComplete"

    const-string v5, "705"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v8}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 200
    iget-object v2, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->notifyComplete()V

    .line 202
    iget-object v2, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isNotified()Z

    move-result v2

    if-nez v2, :cond_1

    .line 205
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    if-eqz v2, :cond_0

    .line 206
    instance-of v2, p1, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    if-eqz v2, :cond_0

    .line 207
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->isComplete()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 208
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    move-object v0, p1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    move-object v2, v0

    invoke-interface {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttCallback;->deliveryComplete(Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;)V

    .line 211
    :cond_0
    invoke-virtual {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->fireActionEvent(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 215
    :cond_1
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->isComplete()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 216
    instance-of v2, p1, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    if-nez v2, :cond_2

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    move-result-object v2

    instance-of v2, v2, Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    if-eqz v2, :cond_3

    .line 217
    :cond_2
    iget-object v2, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setNotified(Z)V

    .line 222
    :cond_3
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->isComplete()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 226
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 195
    :cond_4
    monitor-exit p1

    .line 229
    return-void

    .line 195
    :catchall_0
    move-exception v2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private handleMessage(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V
    .locals 13
    .param p1, "publishMessage"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v12, 0x2

    const/4 v11, 0x1

    .line 347
    const-string v1, "handleMessage"

    .line 349
    .local v1, "methodName":Ljava/lang/String;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    if-eqz v3, :cond_0

    .line 350
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getTopicName()Ljava/lang/String;

    move-result-object v0

    .line 353
    .local v0, "destName":Ljava/lang/String;
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "handleMessage"

    const-string v6, "713"

    new-array v7, v12, [Ljava/lang/Object;

    const/4 v8, 0x0

    .line 354
    new-instance v9, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    aput-object v0, v7, v11

    .line 353
    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 355
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v4

    invoke-interface {v3, v0, v4}, Lorg/pwrd/paho/client/mqttv3/MqttCallback;->messageArrived(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 356
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v3

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v3

    if-ne v3, v11, :cond_1

    .line 357
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    new-instance v4, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;

    invoke-direct {v4, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 358
    new-instance v5, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v6

    invoke-interface {v6}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 357
    invoke-virtual {v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 365
    .end local v0    # "destName":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 359
    .restart local v0    # "destName":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v3

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v3

    if-ne v3, v12, :cond_0

    .line 360
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v3, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->deliveryComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 361
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    invoke-direct {v2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 362
    .local v2, "pubComp":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    new-instance v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v5

    invoke-interface {v5}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    goto :goto_0
.end method


# virtual methods
.method public asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 10
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .prologue
    const/4 v4, 0x0

    .line 368
    const-string v6, "asyncOperationComplete"

    .line 370
    .local v6, "methodName":Ljava/lang/String;
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-eqz v0, :cond_0

    .line 372
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 373
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    monitor-enter v1

    .line 375
    :try_start_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "asyncOperationComplete"

    const-string v4, "715"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v9}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-interface {v0, v2, v3, v4, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 376
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 373
    monitor-exit v1

    .line 393
    :goto_0
    return-void

    .line 373
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 381
    :cond_0
    :try_start_1
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->handleActionComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 382
    :catch_0
    move-exception v5

    .line 386
    .local v5, "ex":Ljava/lang/Throwable;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "asyncOperationComplete"

    const-string v3, "719"

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 389
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v1, v5}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    invoke-virtual {v0, v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    goto :goto_0
.end method

.method public connectionLost(Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 10
    .param p1, "cause"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 241
    const-string v0, "connectionLost"

    .line 245
    .local v0, "methodName":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    if-eqz v2, :cond_0

    if-eqz p1, :cond_0

    .line 247
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "connectionLost"

    const-string v5, "708"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 248
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    invoke-interface {v2, p1}, Lorg/pwrd/paho/client/mqttv3/MqttCallback;->connectionLost(Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 250
    :catch_0
    move-exception v1

    .line 254
    .local v1, "t":Ljava/lang/Throwable;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "connectionLost"

    const-string v5, "720"

    new-array v6, v9, [Ljava/lang/Object;

    aput-object v1, v6, v8

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public fireActionEvent(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 9
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x0

    .line 265
    const-string v1, "fireActionEvent"

    .line 267
    .local v1, "methodName":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 268
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getActionCallback()Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;

    move-result-object v0

    .line 269
    .local v0, "asyncCB":Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    if-eqz v0, :cond_0

    .line 270
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    if-nez v2, :cond_1

    .line 272
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "fireActionEvent"

    const-string v5, "716"

    .line 273
    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v7}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    .line 272
    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 274
    invoke-interface {v0, p1}, Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;->onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V

    .line 283
    .end local v0    # "asyncCB":Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    :cond_0
    :goto_0
    return-void

    .line 277
    .restart local v0    # "asyncCB":Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    :cond_1
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "fireActionEvent"

    const-string v5, "716"

    .line 278
    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v7}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    .line 277
    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 279
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    invoke-interface {v0, p1, v2}, Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;->onFailure(Lorg/pwrd/paho/client/mqttv3/IMqttToken;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected getThread()Ljava/lang/Thread;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    return-object v0
.end method

.method public isQuiesced()Z
    .locals 1

    .prologue
    .line 339
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 340
    const/4 v0, 0x1

    .line 342
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public messageArrived(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V
    .locals 6
    .param p1, "sendMessage"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .prologue
    .line 294
    const-string v0, "messageArrived"

    .line 295
    .local v0, "methodName":Ljava/lang/String;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    if-eqz v1, :cond_1

    .line 300
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 301
    :goto_0
    :try_start_0
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v1

    const/16 v3, 0xa

    if-ge v1, v3, :cond_2

    .line 300
    :cond_0
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 310
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    if-nez v1, :cond_1

    .line 311
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 313
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 315
    :try_start_1
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "messageArrived"

    const-string v5, "710"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 313
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 320
    :cond_1
    return-void

    .line 304
    :cond_2
    :try_start_2
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "messageArrived"

    const-string v5, "709"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 305
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    const-wide/16 v4, 0xc8

    invoke-virtual {v1, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 306
    :catch_0
    move-exception v1

    goto :goto_0

    .line 300
    :catchall_0
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v1

    .line 313
    :catchall_1
    move-exception v1

    :try_start_4
    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v1
.end method

.method public quiesce()V
    .locals 6

    .prologue
    .line 328
    const-string v0, "quiesce"

    .line 329
    .local v0, "methodName":Ljava/lang/String;
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    .line 330
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 332
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "quiesce"

    const-string v5, "711"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 330
    monitor-exit v2

    .line 336
    return-void

    .line 330
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public run()V
    .locals 11

    .prologue
    .line 120
    const-string v8, "run"

    .line 121
    .local v8, "methodName":Ljava/lang/String;
    :goto_0
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-nez v1, :cond_0

    .line 190
    return-void

    .line 125
    :cond_0
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    .line 126
    :try_start_1
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 127
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 129
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "run"

    const-string v5, "704"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V

    .line 125
    :cond_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 136
    :goto_1
    :try_start_2
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-eqz v1, :cond_5

    .line 138
    const/4 v9, 0x0

    .line 139
    .local v9, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    monitor-enter v2
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_5

    .line 140
    :try_start_3
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 142
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-object v9, v0

    .line 143
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/Vector;->removeElementAt(I)V

    .line 139
    :cond_2
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 146
    if-eqz v9, :cond_3

    .line 147
    :try_start_4
    invoke-direct {p0, v9}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->handleActionComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 151
    :cond_3
    const/4 v7, 0x0

    .line 152
    .local v7, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    monitor-enter v2
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_5

    .line 153
    :try_start_5
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    .line 157
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    move-object v7, v0

    .line 159
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/Vector;->removeElementAt(I)V

    .line 152
    :cond_4
    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_4

    .line 162
    if-eqz v7, :cond_5

    .line 163
    :try_start_6
    invoke-direct {p0, v7}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->handleMessage(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 167
    .end local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .end local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :cond_5
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    if-eqz v1, :cond_6

    .line 168
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    .line 180
    :cond_6
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 185
    :try_start_7
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "run"

    const-string v5, "706"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 180
    monitor-exit v2

    goto/16 :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    throw v1

    .line 125
    :catchall_1
    move-exception v1

    :try_start_8
    monitor-exit v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    :try_start_9
    throw v1
    :try_end_9
    .catch Ljava/lang/InterruptedException; {:try_start_9 .. :try_end_9} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_5

    .line 133
    :catch_0
    move-exception v1

    goto :goto_1

    .line 139
    .restart local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_2
    move-exception v1

    :try_start_a
    monitor-exit v2
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    :try_start_b
    throw v1
    :try_end_b
    .catch Ljava/lang/Throwable; {:try_start_b .. :try_end_b} :catch_1
    .catchall {:try_start_b .. :try_end_b} :catchall_5

    .line 171
    .end local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catch_1
    move-exception v6

    .line 175
    .local v6, "ex":Ljava/lang/Throwable;
    :try_start_c
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "run"

    const-string v4, "714"

    const/4 v5, 0x0

    invoke-interface/range {v1 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 176
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    .line 177
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    const/4 v2, 0x0

    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v3, v6}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    invoke-virtual {v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_5

    .line 180
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 185
    :try_start_d
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "run"

    const-string v5, "706"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 180
    monitor-exit v2

    goto/16 :goto_0

    :catchall_3
    move-exception v1

    monitor-exit v2
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    throw v1

    .line 152
    .end local v6    # "ex":Ljava/lang/Throwable;
    .restart local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .restart local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_4
    move-exception v1

    :try_start_e
    monitor-exit v2
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_4

    :try_start_f
    throw v1
    :try_end_f
    .catch Ljava/lang/Throwable; {:try_start_f .. :try_end_f} :catch_1
    .catchall {:try_start_f .. :try_end_f} :catchall_5

    .line 179
    .end local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .end local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_5
    move-exception v1

    .line 180
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    monitor-enter v2

    .line 185
    :try_start_10
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "run"

    const-string v10, "706"

    invoke-interface {v3, v4, v5, v10}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->spaceAvailable:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->notifyAll()V

    .line 180
    monitor-exit v2
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_6

    .line 188
    throw v1

    .line 180
    :catchall_6
    move-exception v1

    :try_start_11
    monitor-exit v2
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_6

    throw v1
.end method

.method public setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V
    .locals 0
    .param p1, "mqttCallback"    # Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    .prologue
    .line 116
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->mqttCallback:Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    .line 117
    return-void
.end method

.method public setClientState(Lorg/pwrd/paho/client/mqttv3/internal/ClientState;)V
    .locals 0
    .param p1, "clientState"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .prologue
    .line 62
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 63
    return-void
.end method

.method public start(Ljava/lang/String;)V
    .locals 2
    .param p1, "threadName"    # Ljava/lang/String;

    .prologue
    .line 69
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->lifecycle:Ljava/lang/Object;

    monitor-enter v1

    .line 70
    :try_start_0
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-nez v0, :cond_0

    .line 73
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageQueue:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 74
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->completeQueue:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 76
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    .line 77
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiescing:Z

    .line 78
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    .line 79
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 69
    :cond_0
    monitor-exit v1

    .line 82
    return-void

    .line 69
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public stop()V
    .locals 7

    .prologue
    .line 89
    const-string v0, "stop"

    .line 90
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->lifecycle:Ljava/lang/Object;

    monitor-enter v2

    .line 91
    :try_start_0
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    if-eqz v1, :cond_0

    .line 93
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "stop"

    const-string v5, "700"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->running:Z

    .line 95
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result v1

    if-nez v1, :cond_0

    .line 97
    :try_start_1
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    monitor-enter v3
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 100
    :try_start_2
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "stop"

    const-string v6, "701"

    invoke-interface {v1, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->workAvailable:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 97
    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 104
    :try_start_3
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->join()V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 109
    :cond_0
    :goto_0
    const/4 v1, 0x0

    :try_start_4
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->callbackThread:Ljava/lang/Thread;

    .line 111
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "stop"

    const-string v5, "703"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 113
    return-void

    .line 97
    :catchall_0
    move-exception v1

    :try_start_5
    monitor-exit v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v1
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 105
    :catch_0
    move-exception v1

    goto :goto_0

    .line 90
    :catchall_1
    move-exception v1

    :try_start_7
    monitor-exit v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    throw v1
.end method
