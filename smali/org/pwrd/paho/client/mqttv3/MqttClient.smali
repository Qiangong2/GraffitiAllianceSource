.class public Lorg/pwrd/paho/client/mqttv3/MqttClient;
.super Ljava/lang/Object;
.source "MqttClient.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttClient;


# instance fields
.field protected aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

.field protected timeToWait:J


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "serverURI"    # Ljava/lang/String;
    .param p2, "clientId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 137
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/persist/MqttDefaultFilePersistence;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/persist/MqttDefaultFilePersistence;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;-><init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;)V

    .line 138
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;)V
    .locals 2
    .param p1, "serverURI"    # Ljava/lang/String;
    .param p2, "clientId"    # Ljava/lang/String;
    .param p3, "persistence"    # Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 224
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    .line 64
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->timeToWait:J

    .line 225
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-direct {v0, p1, p2, p3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;-><init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    .line 226
    return-void
.end method

.method public static generateClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 457
    invoke-static {}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->generateClientId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 402
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->close()V

    .line 403
    return-void
.end method

.method public connect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 232
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;-><init>()V

    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)V

    .line 233
    return-void
.end method

.method public connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)V
    .locals 4
    .param p1, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 239
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, v1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->getTimeToWait()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion(J)V

    .line 240
    return-void
.end method

.method public connectWithResult(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 4
    .param p1, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 246
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v1, p1, v2, v2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    .line 247
    .local v0, "tok":Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->getTimeToWait()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion(J)V

    .line 248
    return-object v0
.end method

.method public disconnect()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 255
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    invoke-interface {v0}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion()V

    .line 256
    return-void
.end method

.method public disconnect(J)V
    .locals 3
    .param p1, "quiesceTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 262
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, p2, v1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect(JLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    invoke-interface {v0}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion()V

    .line 263
    return-void
.end method

.method public disconnectForcibly()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 271
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnectForcibly()V

    .line 272
    return-void
.end method

.method public disconnectForcibly(J)V
    .locals 1
    .param p1, "disconnectTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 280
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnectForcibly(J)V

    .line 281
    return-void
.end method

.method public disconnectForcibly(JJ)V
    .locals 1
    .param p1, "quiesceTimeout"    # J
    .param p3, "disconnectTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 289
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnectForcibly(JJ)V

    .line 290
    return-void
.end method

.method public getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 409
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDebug()Lorg/pwrd/paho/client/mqttv3/util/Debug;
    .locals 1

    .prologue
    .line 464
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getDebug()Lorg/pwrd/paho/client/mqttv3/util/Debug;

    move-result-object v0

    return-object v0
.end method

.method public getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 1

    .prologue
    .line 416
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    move-result-object v0

    return-object v0
.end method

.method public getServerURI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getServerURI()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTimeToWait()J
    .locals 2

    .prologue
    .line 395
    iget-wide v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->timeToWait:J

    return-wide v0
.end method

.method public getTopic(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    .locals 1
    .param p1, "topic"    # Ljava/lang/String;

    .prologue
    .line 430
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getTopic(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttTopic;

    move-result-object v0

    return-object v0
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 437
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->isConnected()Z

    move-result v0

    return v0
.end method

.method public publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V
    .locals 4
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "message"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 362
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, p2, v1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    move-result-object v0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->getTimeToWait()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;->waitForCompletion(J)V

    .line 363
    return-void
.end method

.method public publish(Ljava/lang/String;[BIZ)V
    .locals 1
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "payload"    # [B
    .param p3, "qos"    # I
    .param p4, "retained"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 351
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-direct {v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;-><init>([B)V

    .line 352
    .local v0, "message":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    invoke-virtual {v0, p3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setQos(I)V

    .line 353
    invoke-virtual {v0, p4}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setRetained(Z)V

    .line 354
    invoke-virtual {p0, p1, v0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 355
    return-void
.end method

.method public setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V
    .locals 1
    .param p1, "callback"    # Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    .prologue
    .line 444
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V

    .line 445
    return-void
.end method

.method public setTimeToWait(J)V
    .locals 3
    .param p1, "timeToWaitInMillis"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 384
    const-wide/16 v0, -0x1

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    .line 385
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 387
    :cond_0
    iput-wide p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->timeToWait:J

    .line 388
    return-void
.end method

.method public subscribe(Ljava/lang/String;)V
    .locals 4
    .param p1, "topicFilter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 296
    new-array v0, v2, [Ljava/lang/String;

    aput-object p1, v0, v3

    new-array v1, v2, [I

    aput v2, v1, v3

    invoke-virtual {p0, v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->subscribe([Ljava/lang/String;[I)V

    .line 297
    return-void
.end method

.method public subscribe(Ljava/lang/String;I)V
    .locals 3
    .param p1, "topicFilter"    # Ljava/lang/String;
    .param p2, "qos"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 314
    new-array v0, v1, [Ljava/lang/String;

    aput-object p1, v0, v2

    new-array v1, v1, [I

    aput p2, v1, v2

    invoke-virtual {p0, v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->subscribe([Ljava/lang/String;[I)V

    .line 315
    return-void
.end method

.method public subscribe([Ljava/lang/String;)V
    .locals 3
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 303
    array-length v2, p1

    new-array v1, v2, [I

    .line 304
    .local v1, "qos":[I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-lt v0, v2, :cond_0

    .line 307
    invoke-virtual {p0, p1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->subscribe([Ljava/lang/String;[I)V

    .line 308
    return-void

    .line 305
    :cond_0
    const/4 v2, 0x1

    aput v2, v1, v0

    .line 304
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public subscribe([Ljava/lang/String;[I)V
    .locals 7
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .param p2, "qos"    # [I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/16 v6, 0x80

    .line 321
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v3, p1, p2, v4, v4}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v2

    .line 322
    .local v2, "tok":Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->getTimeToWait()J

    move-result-wide v4

    invoke-interface {v2, v4, v5}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion(J)V

    .line 323
    invoke-interface {v2}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->getGrantedQos()[I

    move-result-object v0

    .line 324
    .local v0, "grantedQos":[I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v0

    if-lt v1, v3, :cond_0

    .line 327
    array-length v3, v0

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    const/4 v3, 0x0

    aget v3, p2, v3

    if-ne v3, v6, :cond_1

    .line 328
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v3, v6}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v3

    .line 325
    :cond_0
    aget v3, v0, v1

    aput v3, p2, v1

    .line 324
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 330
    :cond_1
    return-void
.end method

.method public unsubscribe(Ljava/lang/String;)V
    .locals 2
    .param p1, "topicFilter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 336
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->unsubscribe([Ljava/lang/String;)V

    .line 337
    return-void
.end method

.method public unsubscribe([Ljava/lang/String;)V
    .locals 4
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 343
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttClient;->aClient:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p1, v1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttClient;->getTimeToWait()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->waitForCompletion(J)V

    .line 344
    return-void
.end method
