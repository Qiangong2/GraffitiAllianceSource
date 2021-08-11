.class public Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;
.super Ljava/lang/Object;
.source "MqttAsyncClient.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final CLIENT_ID_PREFIX:Ljava/lang/String; = "paho"

.field private static final DISCONNECT_TIMEOUT:J = 0x2710L

.field private static final MAX_HIGH_SURROGATE:C = '\udbff'

.field private static final MIN_HIGH_SURROGATE:C = '\ud800'

.field private static final QUIESCE_TIMEOUT:J = 0x7530L

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private clientId:Ljava/lang/String;

.field protected comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

.field private serverURI:Ljava/lang/String;

.field private topics:Ljava/util/Hashtable;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 79
    const-class v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    .line 80
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 86
    return-void
.end method

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
    .line 164
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/persist/MqttDefaultFilePersistence;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/persist/MqttDefaultFilePersistence;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;-><init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;)V

    .line 165
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;)V
    .locals 1
    .param p1, "serverURI"    # Ljava/lang/String;
    .param p2, "clientId"    # Ljava/lang/String;
    .param p3, "persistence"    # Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 168
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;-><init>()V

    invoke-direct {p0, p1, p2, p3, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;-><init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V

    .line 169
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V
    .locals 9
    .param p1, "serverURI"    # Ljava/lang/String;
    .param p2, "clientId"    # Ljava/lang/String;
    .param p3, "persistence"    # Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .param p4, "pingSender"    # Lorg/pwrd/paho/client/mqttv3/MqttPingSender;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 255
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 256
    const-string v2, "MqttAsyncClient"

    .line 258
    .local v2, "methodName":Ljava/lang/String;
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v3, p2}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 260
    if-nez p2, :cond_0

    .line 261
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Null clientId"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 264
    :cond_0
    const/4 v0, 0x0

    .line 265
    .local v0, "clientIdLength":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-lt v1, v3, :cond_1

    .line 270
    const v3, 0xffff

    if-le v0, v3, :cond_3

    .line 271
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "ClientId longer than 65535 characters"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 266
    :cond_1
    invoke-virtual {p2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->Character_isHighSurrogate(C)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 267
    add-int/lit8 v1, v1, 0x1

    .line 268
    :cond_2
    add-int/lit8 v0, v0, 0x1

    .line 265
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 274
    :cond_3
    invoke-static {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->validateURI(Ljava/lang/String;)I

    .line 276
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->serverURI:Ljava/lang/String;

    .line 277
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->clientId:Ljava/lang/String;

    .line 279
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 280
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    if-nez v3, :cond_4

    .line 281
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;

    invoke-direct {v3}, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;-><init>()V

    iput-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 285
    :cond_4
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "MqttAsyncClient"

    const-string v6, "101"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p2, v7, v8

    const/4 v8, 0x1

    aput-object p1, v7, v8

    const/4 v8, 0x2

    aput-object p3, v7, v8

    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 287
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v3, p2, p1}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->open(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {v3, p0, v4, p4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;-><init>(Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V

    iput-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 289
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->close()V

    .line 290
    new-instance v3, Ljava/util/Hashtable;

    invoke-direct {v3}, Ljava/util/Hashtable;-><init>()V

    iput-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->topics:Ljava/util/Hashtable;

    .line 292
    return-void
.end method

.method protected static Character_isHighSurrogate(C)Z
    .locals 1
    .param p0, "ch"    # C

    .prologue
    .line 301
    const v0, 0xd800

    if-lt p0, v0, :cond_0

    const v0, 0xdbff

    if-gt p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private createNetworkModule(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    .locals 17
    .param p1, "address"    # Ljava/lang/String;
    .param p2, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    .line 348
    const-string v5, "createNetworkModule"

    .line 350
    .local v5, "methodName":Ljava/lang/String;
    sget-object v11, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v12, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v13, "createNetworkModule"

    const-string v14, "115"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p1, v15, v16

    invoke-interface {v11, v12, v13, v14, v15}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 356
    invoke-virtual/range {p2 .. p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSocketFactory()Ljavax/net/SocketFactory;

    move-result-object v2

    .line 358
    .local v2, "factory":Ljavax/net/SocketFactory;
    invoke-static/range {p1 .. p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->validateURI(Ljava/lang/String;)I

    move-result v8

    .line 360
    .local v8, "serverURIType":I
    packed-switch v8, :pswitch_data_0

    .line 411
    const/4 v6, 0x0

    .line 413
    .local v6, "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    :cond_0
    :goto_0
    return-object v6

    .line 362
    .end local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    :pswitch_0
    const/4 v11, 0x6

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    .line 363
    .local v9, "shortAddress":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getHostName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 364
    .local v4, "host":Ljava/lang/String;
    const/16 v11, 0x75b

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v11}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getPort(Ljava/lang/String;I)I

    move-result v7

    .line 365
    .local v7, "port":I
    if-nez v2, :cond_2

    .line 366
    invoke-static {}, Ljavax/net/SocketFactory;->getDefault()Ljavax/net/SocketFactory;

    move-result-object v2

    .line 371
    :cond_1
    new-instance v6, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;

    move-object/from16 v0, p0

    iget-object v11, v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->clientId:Ljava/lang/String;

    invoke-direct {v6, v2, v4, v7, v11}, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;-><init>(Ljavax/net/SocketFactory;Ljava/lang/String;ILjava/lang/String;)V

    .restart local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    move-object v11, v6

    .line 372
    check-cast v11, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;

    invoke-virtual/range {p2 .. p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getConnectionTimeout()I

    move-result v12

    invoke-virtual {v11, v12}, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->setConnectTimeout(I)V

    goto :goto_0

    .line 368
    .end local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    :cond_2
    instance-of v11, v2, Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v11, :cond_1

    .line 369
    const/16 v11, 0x7d69

    invoke-static {v11}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v11

    throw v11

    .line 375
    .end local v4    # "host":Ljava/lang/String;
    .end local v7    # "port":I
    .end local v9    # "shortAddress":Ljava/lang/String;
    :pswitch_1
    const/4 v11, 0x6

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v9

    .line 376
    .restart local v9    # "shortAddress":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getHostName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 377
    .restart local v4    # "host":Ljava/lang/String;
    const/16 v11, 0x22b3

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v11}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getPort(Ljava/lang/String;I)I

    move-result v7

    .line 378
    .restart local v7    # "port":I
    const/4 v3, 0x0

    .line 379
    .local v3, "factoryFactory":Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;
    if-nez v2, :cond_5

    .line 381
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;

    .end local v3    # "factoryFactory":Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;
    invoke-direct {v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;-><init>()V

    .line 382
    .restart local v3    # "factoryFactory":Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;
    invoke-virtual/range {p2 .. p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getSSLProperties()Ljava/util/Properties;

    move-result-object v10

    .line 383
    .local v10, "sslClientProps":Ljava/util/Properties;
    if-eqz v10, :cond_3

    .line 384
    const/4 v11, 0x0

    invoke-virtual {v3, v10, v11}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->initialize(Ljava/util/Properties;Ljava/lang/String;)V

    .line 385
    :cond_3
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->createSocketFactory(Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v2

    .line 396
    .end local v10    # "sslClientProps":Ljava/util/Properties;
    :cond_4
    new-instance v6, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;

    move-object v11, v2

    check-cast v11, Ljavax/net/ssl/SSLSocketFactory;

    move-object/from16 v0, p0

    iget-object v12, v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->clientId:Ljava/lang/String;

    invoke-direct {v6, v11, v4, v7, v12}, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;-><init>(Ljavax/net/ssl/SSLSocketFactory;Ljava/lang/String;ILjava/lang/String;)V

    .restart local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    move-object v11, v6

    .line 397
    check-cast v11, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;

    invoke-virtual/range {p2 .. p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getConnectionTimeout()I

    move-result v12

    invoke-virtual {v11, v12}, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->setSSLhandshakeTimeout(I)V

    .line 399
    if-eqz v3, :cond_0

    .line 400
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getEnabledCipherSuites(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 401
    .local v1, "enabledCiphers":[Ljava/lang/String;
    if-eqz v1, :cond_0

    move-object v11, v6

    .line 402
    check-cast v11, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;

    invoke-virtual {v11, v1}, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->setEnabledCiphers([Ljava/lang/String;)V

    goto/16 :goto_0

    .line 391
    .end local v1    # "enabledCiphers":[Ljava/lang/String;
    .end local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    :cond_5
    instance-of v11, v2, Ljavax/net/ssl/SSLSocketFactory;

    if-nez v11, :cond_4

    .line 392
    const/16 v11, 0x7d69

    invoke-static {v11}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v11

    throw v11

    .line 407
    .end local v3    # "factoryFactory":Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;
    .end local v4    # "host":Ljava/lang/String;
    .end local v7    # "port":I
    .end local v9    # "shortAddress":Ljava/lang/String;
    :pswitch_2
    new-instance v6, Lorg/pwrd/paho/client/mqttv3/internal/LocalNetworkModule;

    const/16 v11, 0x8

    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v6, v11}, Lorg/pwrd/paho/client/mqttv3/internal/LocalNetworkModule;-><init>(Ljava/lang/String;)V

    .line 408
    .restart local v6    # "netModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    goto/16 :goto_0

    .line 360
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static generateClientId()Ljava/lang/String;
    .locals 4

    .prologue
    .line 804
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "paho"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getHostName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 429
    const/16 v2, 0x2f

    invoke-virtual {p1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 430
    .local v1, "schemeIndex":I
    const/16 v2, 0x3a

    invoke-virtual {p1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    .line 431
    .local v0, "portIndex":I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_0

    .line 432
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 434
    :cond_0
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {p1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private getPort(Ljava/lang/String;I)I
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "defaultPort"    # I

    .prologue
    .line 418
    const/16 v2, 0x3a

    invoke-virtual {p1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 419
    .local v1, "portIndex":I
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 420
    move v0, p2

    .line 425
    .local v0, "port":I
    :goto_0
    return v0

    .line 423
    .end local v0    # "port":I
    :cond_0
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .restart local v0    # "port":I
    goto :goto_0
.end method


# virtual methods
.method public checkPing(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 6
    .param p1, "userContext"    # Ljava/lang/Object;
    .param p2, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 658
    const-string v0, "ping"

    .line 661
    .local v0, "methodName":Ljava/lang/String;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "ping"

    const-string v5, "117"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 663
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v1

    .line 665
    .local v1, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "ping"

    const-string v5, "118"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 667
    return-object v1
.end method

.method public close()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 871
    const-string v0, "close"

    .line 873
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "close"

    const-string v4, "113"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 874
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->close()V

    .line 876
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "close"

    const-string v4, "114"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 878
    return-void
.end method

.method public connect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 449
    invoke-virtual {p0, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public connect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .param p1, "userContext"    # Ljava/lang/Object;
    .param p2, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    .line 442
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;-><init>()V

    invoke-virtual {p0, v0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .param p1, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 456
    invoke-virtual {p0, p1, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 12
    .param p1, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .param p2, "userContext"    # Ljava/lang/Object;
    .param p3, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    .line 464
    const-string v8, "connect"

    .line 465
    .local v8, "methodName":Ljava/lang/String;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 466
    const/16 v1, 0x7d64

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    throw v1

    .line 468
    :cond_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnecting()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 469
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d6e

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 471
    :cond_1
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 472
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d66

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 474
    :cond_2
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isClosed()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 475
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d6f

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 479
    :cond_3
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "connect"

    const-string v6, "103"

    .line 480
    const/16 v1, 0x8

    new-array v7, v1, [Ljava/lang/Object;

    .line 481
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->isCleanSession()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    aput-object v1, v7, v11

    const/4 v1, 0x1

    .line 482
    new-instance v9, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getConnectionTimeout()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v1

    const/4 v1, 0x2

    .line 483
    new-instance v9, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getKeepAliveInterval()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v1

    const/4 v1, 0x3

    .line 484
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getUserName()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v1

    const/4 v9, 0x4

    .line 485
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getPassword()[C

    move-result-object v1

    if-nez v1, :cond_4

    const-string v1, "[null]"

    :goto_0
    aput-object v1, v7, v9

    const/4 v9, 0x5

    .line 486
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getWillMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v1

    if-nez v1, :cond_5

    const-string v1, "[null]"

    :goto_1
    aput-object v1, v7, v9

    const/4 v1, 0x6

    .line 487
    aput-object p2, v7, v1

    const/4 v1, 0x7

    .line 488
    aput-object p3, v7, v1

    .line 479
    invoke-interface {v2, v3, v4, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 489
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->serverURI:Ljava/lang/String;

    invoke-virtual {p0, v2, p1}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->createNetworkModules(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->setNetworkModules([Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;)V

    .line 492
    new-instance v5, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v5, v1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 493
    .local v5, "userToken":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/ConnectActionListener;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    move-object v1, p0

    move-object v4, p1

    move-object v6, p2

    move-object v7, p3

    invoke-direct/range {v0 .. v7}, Lorg/pwrd/paho/client/mqttv3/internal/ConnectActionListener;-><init>(Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Lorg/pwrd/paho/client/mqttv3/MqttToken;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 494
    .local v0, "connectActionListener":Lorg/pwrd/paho/client/mqttv3/internal/ConnectActionListener;
    invoke-virtual {v5, v0}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 495
    invoke-virtual {v5, p0}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setUserContext(Ljava/lang/Object;)V

    .line 497
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1, v11}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->setNetworkModuleIndex(I)V

    .line 498
    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ConnectActionListener;->connect()V

    .line 500
    return-object v5

    .line 485
    .end local v0    # "connectActionListener":Lorg/pwrd/paho/client/mqttv3/internal/ConnectActionListener;
    .end local v5    # "userToken":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :cond_4
    const-string v1, "[notnull]"

    goto :goto_0

    .line 486
    :cond_5
    const-string v1, "[notnull]"

    goto :goto_1
.end method

.method protected createNetworkModules(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    .locals 12
    .param p1, "address"    # Ljava/lang/String;
    .param p2, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 315
    const-string v2, "createNetworkModules"

    .line 317
    .local v2, "methodName":Ljava/lang/String;
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "createNetworkModules"

    const-string v8, "116"

    new-array v9, v11, [Ljava/lang/Object;

    aput-object p1, v9, v10

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 319
    const/4 v3, 0x0

    .line 320
    .local v3, "networkModules":[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getServerURIs()[Ljava/lang/String;

    move-result-object v4

    .line 321
    .local v4, "serverURIs":[Ljava/lang/String;
    const/4 v0, 0x0

    .line 322
    .local v0, "array":[Ljava/lang/String;
    if-nez v4, :cond_0

    .line 323
    new-array v0, v11, [Ljava/lang/String;

    .end local v0    # "array":[Ljava/lang/String;
    aput-object p1, v0, v10

    .line 330
    .restart local v0    # "array":[Ljava/lang/String;
    :goto_0
    array-length v5, v0

    new-array v3, v5, [Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    .line 331
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v5, v0

    if-lt v1, v5, :cond_2

    .line 335
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "createNetworkModules"

    const-string v8, "108"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    return-object v3

    .line 324
    .end local v1    # "i":I
    :cond_0
    array-length v5, v4

    if-nez v5, :cond_1

    .line 325
    new-array v0, v11, [Ljava/lang/String;

    .end local v0    # "array":[Ljava/lang/String;
    aput-object p1, v0, v10

    .line 326
    .restart local v0    # "array":[Ljava/lang/String;
    goto :goto_0

    .line 327
    :cond_1
    move-object v0, v4

    goto :goto_0

    .line 332
    .restart local v1    # "i":I
    :cond_2
    aget-object v5, v0, v1

    invoke-direct {p0, v5, p2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->createNetworkModule(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;)Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    move-result-object v5

    aput-object v5, v3, v1

    .line 331
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method public disconnect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 514
    invoke-virtual {p0, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public disconnect(J)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .param p1, "quiesceTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 521
    invoke-virtual {p0, p1, p2, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect(JLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public disconnect(JLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 11
    .param p1, "quiesceTimeout"    # J
    .param p3, "userContext"    # Ljava/lang/Object;
    .param p4, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 528
    const-string v7, "disconnect"

    .line 530
    .local v7, "methodName":Ljava/lang/String;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "disconnect"

    const-string v3, "104"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/Long;

    invoke-direct {v10, p1, p2}, Ljava/lang/Long;-><init>(J)V

    aput-object v10, v4, v9

    const/4 v9, 0x1

    aput-object p3, v4, v9

    const/4 v9, 0x2

    aput-object p4, v4, v9

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 532
    new-instance v8, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v8, v0}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 533
    .local v8, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    invoke-virtual {v8, p4}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 534
    invoke-virtual {v8, p3}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setUserContext(Ljava/lang/Object;)V

    .line 536
    new-instance v6, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    invoke-direct {v6}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;-><init>()V

    .line 538
    .local v6, "disconnect":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;
    :try_start_0
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0, v6, p1, p2, v8}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->disconnect(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;JLorg/pwrd/paho/client/mqttv3/MqttToken;)V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    .line 545
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "disconnect"

    const-string v3, "108"

    invoke-interface {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 547
    return-object v8

    .line 539
    :catch_0
    move-exception v5

    .line 541
    .local v5, "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "disconnect"

    const-string v3, "105"

    const/4 v4, 0x0

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 542
    throw v5
.end method

.method public disconnect(Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 2
    .param p1, "userContext"    # Ljava/lang/Object;
    .param p2, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 507
    const-wide/16 v0, 0x7530

    invoke-virtual {p0, v0, v1, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect(JLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public disconnectForcibly()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 555
    const-wide/16 v0, 0x7530

    const-wide/16 v2, 0x2710

    invoke-virtual {p0, v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnectForcibly(JJ)V

    .line 556
    return-void
.end method

.method public disconnectForcibly(J)V
    .locals 3
    .param p1, "disconnectTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 563
    const-wide/16 v0, 0x7530

    invoke-virtual {p0, v0, v1, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnectForcibly(JJ)V

    .line 564
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
    .line 571
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->disconnectForcibly(JJ)V

    .line 572
    return-void
.end method

.method public getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 585
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method public getDebug()Lorg/pwrd/paho/client/mqttv3/util/Debug;
    .locals 3

    .prologue
    .line 884
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->clientId:Ljava/lang/String;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-direct {v0, v1, v2}, Lorg/pwrd/paho/client/mqttv3/util/Debug;-><init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V

    return-object v0
.end method

.method public getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 1

    .prologue
    .line 811
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    move-result-object v0

    return-object v0
.end method

.method public getServerURI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 592
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->serverURI:Ljava/lang/String;

    return-object v0
.end method

.method protected getTopic(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    .locals 2
    .param p1, "topic"    # Ljava/lang/String;

    .prologue
    .line 638
    const/4 v1, 0x0

    invoke-static {p1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validate(Ljava/lang/String;Z)V

    .line 640
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->topics:Ljava/util/Hashtable;

    invoke-virtual {v1, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;

    .line 641
    .local v0, "result":Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    if-nez v0, :cond_0

    .line 642
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;

    .end local v0    # "result":Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-direct {v0, p1, v1}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;-><init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V

    .line 643
    .restart local v0    # "result":Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->topics:Ljava/util/Hashtable;

    invoke-virtual {v1, p1, v0}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 645
    :cond_0
    return-object v0
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 578
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v0

    return v0
.end method

.method public publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 1
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "message"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 837
    invoke-virtual {p0, p1, p2, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    move-result-object v0

    return-object v0
.end method

.method public publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 11
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "message"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .param p3, "userContext"    # Ljava/lang/Object;
    .param p4, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 845
    const-string v0, "publish"

    .line 847
    .local v0, "methodName":Ljava/lang/String;
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "publish"

    const-string v6, "111"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    aput-object p1, v7, v9

    aput-object p3, v7, v10

    const/4 v8, 0x2

    aput-object p4, v7, v8

    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 850
    invoke-static {p1, v9}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validate(Ljava/lang/String;Z)V

    .line 852
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;-><init>(Ljava/lang/String;)V

    .line 853
    .local v2, "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    invoke-virtual {v2, p4}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 854
    invoke-virtual {v2, p3}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->setUserContext(Ljava/lang/Object;)V

    .line 855
    invoke-virtual {v2, p2}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->setMessage(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 856
    iget-object v3, v2, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    new-array v4, v10, [Ljava/lang/String;

    aput-object p1, v4, v9

    invoke-virtual {v3, v4}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setTopics([Ljava/lang/String;)V

    .line 858
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    invoke-direct {v1, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;-><init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 859
    .local v1, "pubMsg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v3, v1, v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sendNoWait(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 862
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "publish"

    const-string v6, "112"

    invoke-interface {v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 864
    return-object v2
.end method

.method public publish(Ljava/lang/String;[BIZ)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 7
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
    const/4 v5, 0x0

    .line 830
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->publish(Ljava/lang/String;[BIZLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    move-result-object v0

    return-object v0
.end method

.method public publish(Ljava/lang/String;[BIZLjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;
    .locals 2
    .param p1, "topic"    # Ljava/lang/String;
    .param p2, "payload"    # [B
    .param p3, "qos"    # I
    .param p4, "retained"    # Z
    .param p5, "userContext"    # Ljava/lang/Object;
    .param p6, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 820
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-direct {v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;-><init>([B)V

    .line 821
    .local v0, "message":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    invoke-virtual {v0, p3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setQos(I)V

    .line 822
    invoke-virtual {v0, p4}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setRetained(Z)V

    .line 823
    invoke-virtual {p0, p1, v0, p5, p6}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->publish(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    move-result-object v1

    return-object v1
.end method

.method public setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V
    .locals 1
    .param p1, "callback"    # Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    .prologue
    .line 790
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V

    .line 791
    return-void
.end method

.method public subscribe(Ljava/lang/String;I)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 4
    .param p1, "topicFilter"    # Ljava/lang/String;
    .param p2, "qos"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 682
    new-array v0, v1, [Ljava/lang/String;

    aput-object p1, v0, v2

    new-array v1, v1, [I

    aput p2, v1, v2

    invoke-virtual {p0, v0, v1, v3, v3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public subscribe(Ljava/lang/String;ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 3
    .param p1, "topicFilter"    # Ljava/lang/String;
    .param p2, "qos"    # I
    .param p3, "userContext"    # Ljava/lang/Object;
    .param p4, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 675
    new-array v0, v1, [Ljava/lang/String;

    aput-object p1, v0, v2

    new-array v1, v1, [I

    aput p2, v1, v2

    invoke-virtual {p0, v0, v1, p3, p4}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public subscribe([Ljava/lang/String;[I)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .param p2, "qos"    # [I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 689
    invoke-virtual {p0, p1, p2, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 11
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .param p2, "qos"    # [I
    .param p3, "userContext"    # Ljava/lang/Object;
    .param p4, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 696
    const-string v1, "subscribe"

    .line 698
    .local v1, "methodName":Ljava/lang/String;
    array-length v5, p1

    array-length v6, p2

    if-eq v5, v6, :cond_0

    .line 699
    new-instance v5, Ljava/lang/IllegalArgumentException;

    invoke-direct {v5}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v5

    .line 702
    :cond_0
    const-string v3, ""

    .line 703
    .local v3, "subs":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v5, p1

    if-lt v0, v5, :cond_1

    .line 713
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "subscribe"

    const-string v8, "106"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v3, v9, v10

    const/4 v10, 0x1

    aput-object p3, v9, v10

    const/4 v10, 0x2

    aput-object p4, v9, v10

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 715
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 716
    .local v4, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    invoke-virtual {v4, p4}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 717
    invoke-virtual {v4, p3}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setUserContext(Ljava/lang/Object;)V

    .line 718
    iget-object v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setTopics([Ljava/lang/String;)V

    .line 720
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;

    invoke-direct {v2, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;-><init>([Ljava/lang/String;[I)V

    .line 722
    .local v2, "register":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v5, v2, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sendNoWait(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 724
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "subscribe"

    const-string v8, "109"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 726
    return-object v4

    .line 704
    .end local v2    # "register":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttSubscribe;
    .end local v4    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :cond_1
    if-lez v0, :cond_2

    .line 705
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 707
    :cond_2
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "topic="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-object v6, p1, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " qos="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget v6, p2, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 710
    aget-object v5, p1, v0

    const/4 v6, 0x1

    invoke-static {v5, v6}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validate(Ljava/lang/String;Z)V

    .line 703
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0
.end method

.method public unsubscribe(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 3
    .param p1, "topicFilter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 740
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0, v2, v2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public unsubscribe(Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 2
    .param p1, "topicFilter"    # Ljava/lang/String;
    .param p2, "userContext"    # Ljava/lang/Object;
    .param p3, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 733
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0, p2, p3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public unsubscribe([Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 1
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 747
    invoke-virtual {p0, p1, v0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    move-result-object v0

    return-object v0
.end method

.method public unsubscribe([Ljava/lang/String;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    .locals 12
    .param p1, "topicFilters"    # [Ljava/lang/String;
    .param p2, "userContext"    # Ljava/lang/Object;
    .param p3, "callback"    # Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x1

    .line 754
    const-string v1, "unsubscribe"

    .line 755
    .local v1, "methodName":Ljava/lang/String;
    const-string v2, ""

    .line 756
    .local v2, "subs":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v5, p1

    if-lt v0, v5, :cond_0

    .line 770
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "unsubscribe"

    const-string v8, "107"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v2, v9, v10

    aput-object p2, v9, v11

    const/4 v10, 0x2

    aput-object p3, v9, v10

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 772
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 773
    .local v3, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    invoke-virtual {v3, p3}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    .line 774
    invoke-virtual {v3, p2}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->setUserContext(Ljava/lang/Object;)V

    .line 775
    iget-object v5, v3, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setTopics([Ljava/lang/String;)V

    .line 777
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;

    invoke-direct {v4, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;-><init>([Ljava/lang/String;)V

    .line 779
    .local v4, "unregister":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v5, v4, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sendNoWait(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 781
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "unsubscribe"

    const-string v8, "110"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 783
    return-object v3

    .line 757
    .end local v3    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .end local v4    # "unregister":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttUnsubscribe;
    :cond_0
    if-lez v0, :cond_1

    .line 758
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 760
    :cond_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v6, p1, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 766
    aget-object v5, p1, v0

    invoke-static {v5, v11}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validate(Ljava/lang/String;Z)V

    .line 756
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
