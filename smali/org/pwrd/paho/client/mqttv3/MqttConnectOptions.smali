.class public Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
.super Ljava/lang/Object;
.source "MqttConnectOptions.java"


# static fields
.field public static final CLEAN_SESSION_DEFAULT:Z = true

.field public static final CONNECTION_TIMEOUT_DEFAULT:I = 0x1e

.field public static final KEEP_ALIVE_INTERVAL_DEFAULT:I = 0x3c

.field public static final MQTT_VERSION_3_1:I = 0x3

.field public static final MQTT_VERSION_3_1_1:I = 0x4

.field public static final MQTT_VERSION_DEFAULT:I = 0x0

.field protected static final URI_TYPE_LOCAL:I = 0x2

.field protected static final URI_TYPE_SSL:I = 0x1

.field protected static final URI_TYPE_TCP:I


# instance fields
.field private MqttVersion:I

.field private cleanSession:Z

.field private connectionTimeout:I

.field private keepAliveInterval:I

.field private password:[C

.field private serverURIs:[Ljava/lang/String;

.field private socketFactory:Ljavax/net/SocketFactory;

.field private sslClientProps:Ljava/util/Properties;

.field private userName:Ljava/lang/String;

.field private willDestination:Ljava/lang/String;

.field private willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const/16 v0, 0x3c

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->keepAliveInterval:I

    .line 57
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willDestination:Ljava/lang/String;

    .line 58
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .line 62
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->sslClientProps:Ljava/util/Properties;

    .line 63
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->cleanSession:Z

    .line 64
    const/16 v0, 0x1e

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->connectionTimeout:I

    .line 65
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->serverURIs:[Ljava/lang/String;

    .line 66
    const/4 v0, 0x0

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->MqttVersion:I

    .line 84
    return-void
.end method

.method protected static validateURI(Ljava/lang/String;)I
    .locals 4
    .param p0, "srvURI"    # Ljava/lang/String;

    .prologue
    .line 457
    :try_start_0
    new-instance v1, Ljava/net/URI;

    invoke-direct {v1, p0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 458
    .local v1, "vURI":Ljava/net/URI;
    invoke-virtual {v1}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 459
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 473
    .end local v1    # "vURI":Ljava/net/URI;
    :catch_0
    move-exception v0

    .line 474
    .local v0, "ex":Ljava/net/URISyntaxException;
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 461
    .end local v0    # "ex":Ljava/net/URISyntaxException;
    .restart local v1    # "vURI":Ljava/net/URI;
    :cond_0
    :try_start_1
    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v2

    const-string v3, "tcp"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 462
    const/4 v2, 0x0

    .line 468
    :goto_0
    return v2

    .line 464
    :cond_1
    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v2

    const-string v3, "ssl"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 465
    const/4 v2, 0x1

    goto :goto_0

    .line 467
    :cond_2
    invoke-virtual {v1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v2

    const-string v3, "local"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 468
    const/4 v2, 0x2

    goto :goto_0

    .line 471
    :cond_3
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method private validateWill(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "dest"    # Ljava/lang/String;
    .param p2, "payload"    # Ljava/lang/Object;

    .prologue
    .line 159
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 160
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 163
    :cond_1
    const/4 v0, 0x0

    invoke-static {p1, v0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validate(Ljava/lang/String;Z)V

    .line 164
    return-void
.end method


# virtual methods
.method public getConnectionTimeout()I
    .locals 1

    .prologue
    .line 224
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->connectionTimeout:I

    return v0
.end method

.method public getDebug()Ljava/util/Properties;
    .locals 5

    .prologue
    .line 497
    const-string v1, "null"

    .line 498
    .local v1, "strNull":Ljava/lang/String;
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    .line 499
    .local v0, "p":Ljava/util/Properties;
    const-string v2, "MqttVersion"

    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getMqttVersion()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 500
    const-string v2, "CleanSession"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->isCleanSession()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 501
    const-string v2, "ConTimeout"

    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getConnectionTimeout()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 502
    const-string v2, "KeepAliveInterval"

    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getKeepAliveInterval()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 503
    const-string v3, "UserName"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getUserName()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    const-string v2, "null"

    :goto_0
    invoke-virtual {v0, v3, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 504
    const-string v3, "WillDestination"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getWillDestination()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    const-string v2, "null"

    :goto_1
    invoke-virtual {v0, v3, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 505
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSocketFactory()Ljavax/net/SocketFactory;

    move-result-object v2

    if-nez v2, :cond_2

    .line 506
    const-string v2, "SocketFactory"

    const-string v3, "null"

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 510
    :goto_2
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSSLProperties()Ljava/util/Properties;

    move-result-object v2

    if-nez v2, :cond_3

    .line 511
    const-string v2, "SSLProperties"

    const-string v3, "null"

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 515
    :goto_3
    return-object v0

    .line 503
    :cond_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getUserName()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 504
    :cond_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getWillDestination()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 508
    :cond_2
    const-string v2, "SocketFactory"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSocketFactory()Ljavax/net/SocketFactory;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 513
    :cond_3
    const-string v2, "SSLProperties"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSSLProperties()Ljava/util/Properties;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3
.end method

.method public getKeepAliveInterval()I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->keepAliveInterval:I

    return v0
.end method

.method public getMqttVersion()I
    .locals 1

    .prologue
    .line 193
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->MqttVersion:I

    return v0
.end method

.method public getPassword()[C
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->password:[C

    return-object v0
.end method

.method public getSSLProperties()Ljava/util/Properties;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->sslClientProps:Ljava/util/Properties;

    return-object v0
.end method

.method public getServerURIs()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 398
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->serverURIs:[Ljava/lang/String;

    return-object v0
.end method

.method public getSocketFactory()Ljavax/net/SocketFactory;
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->socketFactory:Ljavax/net/SocketFactory;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->userName:Ljava/lang/String;

    return-object v0
.end method

.method public getWillDestination()Ljava/lang/String;
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willDestination:Ljava/lang/String;

    return-object v0
.end method

.method public getWillMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    return-object v0
.end method

.method public isCleanSession()Z
    .locals 1

    .prologue
    .line 368
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->cleanSession:Z

    return v0
.end method

.method public setCleanSession(Z)V
    .locals 0
    .param p1, "cleanSession"    # Z

    .prologue
    .line 390
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->cleanSession:Z

    .line 391
    return-void
.end method

.method public setConnectionTimeout(I)V
    .locals 1
    .param p1, "connectionTimeout"    # I

    .prologue
    .line 237
    if-gez p1, :cond_0

    .line 238
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 240
    :cond_0
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->connectionTimeout:I

    .line 241
    return-void
.end method

.method public setKeepAliveInterval(I)V
    .locals 1
    .param p1, "keepAliveInterval"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 212
    if-gez p1, :cond_0

    .line 213
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 215
    :cond_0
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->keepAliveInterval:I

    .line 216
    return-void
.end method

.method public setMqttVersion(I)V
    .locals 1
    .param p1, "MqttVersion"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 488
    if-eqz p1, :cond_0

    .line 489
    const/4 v0, 0x3

    if-eq p1, v0, :cond_0

    .line 490
    const/4 v0, 0x4

    if-eq p1, v0, :cond_0

    .line 491
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 493
    :cond_0
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->MqttVersion:I

    .line 494
    return-void
.end method

.method public setPassword([C)V
    .locals 0
    .param p1, "password"    # [C

    .prologue
    .line 98
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->password:[C

    .line 99
    return-void
.end method

.method public setSSLProperties(Ljava/util/Properties;)V
    .locals 0
    .param p1, "props"    # Ljava/util/Properties;

    .prologue
    .line 360
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->sslClientProps:Ljava/util/Properties;

    .line 361
    return-void
.end method

.method public setServerURIs([Ljava/lang/String;)V
    .locals 2
    .param p1, "array"    # [Ljava/lang/String;

    .prologue
    .line 443
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-lt v0, v1, :cond_0

    .line 446
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->serverURIs:[Ljava/lang/String;

    .line 447
    return-void

    .line 444
    :cond_0
    aget-object v1, p1, v0

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->validateURI(Ljava/lang/String;)I

    .line 443
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public setSocketFactory(Ljavax/net/SocketFactory;)V
    .locals 0
    .param p1, "socketFactory"    # Ljavax/net/SocketFactory;

    .prologue
    .line 259
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->socketFactory:Ljavax/net/SocketFactory;

    .line 260
    return-void
.end method

.method public setUserName(Ljava/lang/String;)V
    .locals 2
    .param p1, "userName"    # Ljava/lang/String;

    .prologue
    .line 115
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 118
    :cond_0
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->userName:Ljava/lang/String;

    .line 119
    return-void
.end method

.method protected setWill(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;IZ)V
    .locals 2
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "msg"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .param p3, "qos"    # I
    .param p4, "retained"    # Z

    .prologue
    .line 170
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willDestination:Ljava/lang/String;

    .line 171
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .line 172
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-virtual {v0, p3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setQos(I)V

    .line 173
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-virtual {v0, p4}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setRetained(Z)V

    .line 175
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->willMessage:Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setMutable(Z)V

    .line 176
    return-void
.end method

.method public setWill(Ljava/lang/String;[BIZ)V
    .locals 1
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "payload"    # [B
    .param p3, "qos"    # I
    .param p4, "retained"    # Z

    .prologue
    .line 150
    invoke-direct {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->validateWill(Ljava/lang/String;Ljava/lang/Object;)V

    .line 151
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-direct {v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;-><init>([B)V

    invoke-virtual {p0, p1, v0, p3, p4}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->setWill(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;IZ)V

    .line 152
    return-void
.end method

.method public setWill(Lorg/pwrd/paho/client/mqttv3/MqttTopic;[BIZ)V
    .locals 2
    .param p1, "topic"    # Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    .param p2, "payload"    # [B
    .param p3, "qos"    # I
    .param p4, "retained"    # Z

    .prologue
    .line 133
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->getName()Ljava/lang/String;

    move-result-object v0

    .line 134
    .local v0, "topicS":Ljava/lang/String;
    invoke-direct {p0, v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->validateWill(Ljava/lang/String;Ljava/lang/Object;)V

    .line 135
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-direct {v1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;-><init>([B)V

    invoke-virtual {p0, v0, v1, p3, p4}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->setWill(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;IZ)V

    .line 136
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 519
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getDebug()Ljava/util/Properties;

    move-result-object v0

    const-string v1, "Connection options"

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
