.class public Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
.super Ljava/lang/Object;
.source "ClientComms.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;,
        Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;
    }
.end annotation


# static fields
.field public static BUILD_LEVEL:Ljava/lang/String; = null

.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final CLOSED:B = 0x4t

.field private static final CONNECTED:B = 0x0t

.field private static final CONNECTING:B = 0x1t

.field private static final DISCONNECTED:B = 0x3t

.field private static final DISCONNECTING:B = 0x2t

.field public static VERSION:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

.field private client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

.field private clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

.field private closePending:Z

.field private conLock:Ljava/lang/Object;

.field private conOptions:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

.field private conState:B

.field private networkModuleIndex:I

.field private networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

.field private persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

.field private pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

.field private receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

.field private sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

.field private stoppingComms:Z

.field private tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 46
    const-string v0, "${project.version}"

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->VERSION:Ljava/lang/String;

    .line 47
    const-string v0, "L${build.level}"

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->BUILD_LEVEL:Ljava/lang/String;

    .line 48
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    .line 49
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 55
    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V
    .locals 6
    .param p1, "client"    # Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;
    .param p2, "persistence"    # Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .param p3, "pingSender"    # Lorg/pwrd/paho/client/mqttv3/MqttPingSender;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x3

    const/4 v1, 0x0

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->stoppingComms:Z

    .line 70
    iput-byte v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 71
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    .line 72
    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z

    .line 79
    iput-byte v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 80
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    .line 81
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 82
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    .line 83
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    invoke-interface {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttPingSender;->init(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V

    .line 85
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 86
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-direct {v0, p0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    .line 87
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    move-object v1, p2

    move-object v4, p0

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;-><init>(Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 89
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->setClientState(Lorg/pwrd/paho/client/mqttv3/internal/ClientState;)V

    .line 90
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 91
    return-void
.end method

.method static synthetic access$0()Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-object v0
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$10(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    return-object v0
.end method

.method static synthetic access$2(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    return-object v0
.end method

.method static synthetic access$3(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    return-object v0
.end method

.method static synthetic access$4(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModuleIndex:I

    return v0
.end method

.method static synthetic access$5(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    return-object v0
.end method

.method static synthetic access$6(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    return-void
.end method

.method static synthetic access$7(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    return-object v0
.end method

.method static synthetic access$8(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    return-void
.end method

.method static synthetic access$9(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    return-object v0
.end method

.method private handleOldTokens(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 9
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .param p2, "reason"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    .line 377
    const-string v0, "handleOldTokens"

    .line 379
    .local v0, "methodName":Ljava/lang/String;
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "handleOldTokens"

    const-string v8, "222"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    const/4 v2, 0x0

    .line 385
    .local v2, "tokToNotifyLater":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    if-eqz p1, :cond_0

    .line 386
    :try_start_0
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    iget-object v6, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getToken(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v5

    if-nez v5, :cond_0

    .line 387
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    iget-object v6, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, p1, v6}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Ljava/lang/String;)V

    .line 391
    :cond_0
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v5, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->resolveOldTokens(Lorg/pwrd/paho/client/mqttv3/MqttException;)Ljava/util/Vector;

    move-result-object v3

    .line 392
    .local v3, "toksToNot":Ljava/util/Vector;
    invoke-virtual {v3}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v4

    .line 393
    .local v4, "toksToNotE":Ljava/util/Enumeration;
    :goto_0
    invoke-interface {v4}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v5

    if-nez v5, :cond_1

    .line 410
    .end local v3    # "toksToNot":Ljava/util/Vector;
    .end local v4    # "toksToNotE":Ljava/util/Enumeration;
    :goto_1
    return-object v2

    .line 394
    .restart local v3    # "toksToNot":Ljava/util/Vector;
    .restart local v4    # "toksToNotE":Ljava/util/Enumeration;
    :cond_1
    invoke-interface {v4}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 396
    .local v1, "tok":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    iget-object v5, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Disc"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 397
    iget-object v5, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Con"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 399
    :cond_2
    move-object v2, v1

    .line 400
    goto :goto_0

    .line 404
    :cond_3
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v5, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 407
    .end local v1    # "tok":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .end local v3    # "toksToNot":Ljava/util/Vector;
    .end local v4    # "toksToNotE":Ljava/util/Enumeration;
    :catch_0
    move-exception v5

    goto :goto_1
.end method

.method private handleRunException(Ljava/lang/Exception;)V
    .locals 8
    .param p1, "ex"    # Ljava/lang/Exception;

    .prologue
    const/4 v4, 0x0

    .line 671
    const-string v6, "handleRunException"

    .line 673
    .local v6, "methodName":Ljava/lang/String;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "handleRunException"

    const-string v3, "804"

    move-object v5, p1

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 675
    instance-of v0, p1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v0, :cond_0

    .line 676
    new-instance v7, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v0, 0x7d6d

    invoke-direct {v7, v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    .line 681
    .local v7, "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :goto_0
    invoke-virtual {p0, v4, v7}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 682
    return-void

    .end local v7    # "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :cond_0
    move-object v7, p1

    .line 678
    check-cast v7, Lorg/pwrd/paho/client/mqttv3/MqttException;

    .restart local v7    # "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    goto :goto_0
.end method


# virtual methods
.method public checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 3

    .prologue
    .line 659
    const/4 v1, 0x0

    .line 661
    .local v1, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 667
    :goto_0
    return-object v1

    .line 662
    :catch_0
    move-exception v0

    .line 663
    .local v0, "e":Lorg/pwrd/paho/client/mqttv3/MqttException;
    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->handleRunException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 664
    .end local v0    # "e":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :catch_1
    move-exception v0

    .line 665
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->handleRunException(Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public close()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 156
    const-string v0, "close"

    .line 157
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v2

    .line 158
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isClosed()Z

    move-result v1

    if-nez v1, :cond_3

    .line 160
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnected()Z

    move-result v1

    if-nez v1, :cond_2

    .line 162
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "close"

    const-string v5, "224"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnecting()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 165
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v3, 0x7d6e

    invoke-direct {v1, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 157
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 166
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 167
    const/16 v1, 0x7d64

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    throw v1

    .line 168
    :cond_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 169
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z

    .line 170
    monitor-exit v2

    .line 189
    :goto_0
    return-void

    .line 174
    :cond_2
    const/4 v1, 0x4

    iput-byte v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 177
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->close()V

    .line 178
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 179
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    .line 180
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 181
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    .line 182
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    .line 183
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    .line 184
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    .line 185
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conOptions:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    .line 186
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 157
    :cond_3
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 12
    .param p1, "options"    # Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .param p2, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 197
    const-string v10, "connect"

    .line 198
    .local v10, "methodName":Ljava/lang/String;
    iget-object v11, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v11

    .line 199
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnected()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z

    if-nez v1, :cond_0

    .line 201
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "connect"

    const-string v4, "214"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    const/4 v1, 0x1

    iput-byte v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 205
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conOptions:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    .line 207
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    .line 208
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getMqttVersion()I

    move-result v2

    .line 209
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->isCleanSession()Z

    move-result v3

    .line 210
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getKeepAliveInterval()I

    move-result v4

    .line 211
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getUserName()Ljava/lang/String;

    move-result-object v5

    .line 212
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getPassword()[C

    move-result-object v6

    .line 213
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getWillMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v7

    .line 214
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getWillDestination()Ljava/lang/String;

    move-result-object v8

    .line 207
    invoke-direct/range {v0 .. v8}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;-><init>(Ljava/lang/String;IZILjava/lang/String;[CLorg/pwrd/paho/client/mqttv3/MqttMessage;Ljava/lang/String;)V

    .line 216
    .local v0, "connect":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getKeepAliveInterval()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->setKeepAliveSecs(J)V

    .line 217
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->isCleanSession()Z

    move-result v2

    invoke-virtual {v1, v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->setCleanSession(Z)V

    .line 219
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->open()V

    .line 220
    new-instance v9, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;

    invoke-direct {v9, p0, p0, p2, v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;)V

    .line 221
    .local v9, "conbg":Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;
    invoke-virtual {v9}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;->start()V

    .line 198
    monitor-exit v11

    .line 237
    return-void

    .line 225
    .end local v0    # "connect":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;
    .end local v9    # "conbg":Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$ConnectBG;
    :cond_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "connect"

    const-string v4, "207"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    new-instance v7, Ljava/lang/Byte;

    iget-byte v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    invoke-direct {v7, v8}, Ljava/lang/Byte;-><init>(B)V

    aput-object v7, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 226
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isClosed()Z

    move-result v1

    if-nez v1, :cond_1

    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z

    if-eqz v1, :cond_2

    .line 227
    :cond_1
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d6f

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 198
    :catchall_0
    move-exception v1

    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 228
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnecting()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 229
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d6e

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 230
    :cond_3
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 231
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d66

    invoke-direct {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v1

    .line 233
    :cond_4
    const/16 v1, 0x7d64

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0
.end method

.method public connectComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 9
    .param p1, "cack"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;
    .param p2, "mex"    # Lorg/pwrd/paho/client/mqttv3/MqttException;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 240
    const-string v0, "connectComplete"

    .line 241
    .local v0, "methodName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;->getReturnCode()I

    move-result v1

    .line 242
    .local v1, "rc":I
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v3

    .line 243
    if-nez v1, :cond_0

    .line 246
    :try_start_0
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "connectComplete"

    const-string v6, "215"

    invoke-interface {v2, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const/4 v2, 0x0

    iput-byte v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 249
    monitor-exit v3

    return-void

    .line 242
    :cond_0
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 254
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "connectComplete"

    const-string v5, "204"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, v1}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v6, v8

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 255
    throw p2

    .line 242
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method protected deliveryComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V
    .locals 1
    .param p1, "msg"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 520
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->deliveryComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 521
    return-void
.end method

.method public disconnect(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;JLorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 8
    .param p1, "disconnect"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;
    .param p2, "quiesceTimeout"    # J
    .param p4, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 414
    const-string v0, "disconnect"

    .line 415
    .local v0, "methodName":Ljava/lang/String;
    iget-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v7

    .line 416
    :try_start_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 418
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "disconnect"

    const-string v5, "223"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 419
    const/16 v2, 0x7d6f

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    throw v2

    .line 415
    :catchall_0
    move-exception v2

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 420
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnected()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 422
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "disconnect"

    const-string v5, "211"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 423
    const/16 v2, 0x7d65

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    throw v2

    .line 424
    :cond_1
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 426
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "disconnect"

    const-string v5, "219"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    const/16 v2, 0x7d66

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    throw v2

    .line 428
    :cond_2
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->getThread()Ljava/lang/Thread;

    move-result-object v3

    if-ne v2, v3, :cond_3

    .line 430
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "disconnect"

    const-string v5, "210"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    const/16 v2, 0x7d6b

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v2

    throw v2

    .line 436
    :cond_3
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "disconnect"

    const-string v5, "218"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 437
    const/4 v2, 0x2

    iput-byte v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 438
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;

    move-object v2, p0

    move-object v3, p1

    move-wide v4, p2

    move-object v6, p4

    invoke-direct/range {v1 .. v6}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;JLorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 439
    .local v1, "discbg":Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;
    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->start()V

    .line 415
    monitor-exit v7
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 441
    return-void
.end method

.method public disconnectForcibly(JJ)V
    .locals 5
    .param p1, "quiesceTimeout"    # J
    .param p3, "disconnectTimeout"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 448
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v1, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesce(J)V

    .line 449
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V

    .line 452
    .local v0, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :try_start_0
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    invoke-direct {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;-><init>()V

    invoke-virtual {p0, v1, v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 455
    invoke-virtual {v0, p3, p4}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->waitForCompletion(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 461
    iget-object v1, v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, v3, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 462
    invoke-virtual {p0, v0, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 464
    :goto_0
    return-void

    .line 457
    :catch_0
    move-exception v1

    .line 461
    iget-object v1, v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, v3, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 462
    invoke-virtual {p0, v0, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    goto :goto_0

    .line 460
    :catchall_0
    move-exception v1

    .line 461
    iget-object v2, v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v2, v3, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 462
    invoke-virtual {p0, v0, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 463
    throw v1
.end method

.method public getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;
    .locals 1

    .prologue
    .line 524
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->client:Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    return-object v0
.end method

.method public getClientState()Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
    .locals 1

    .prologue
    .line 532
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    return-object v0
.end method

.method public getConOptions()Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;
    .locals 1

    .prologue
    .line 536
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conOptions:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    return-object v0
.end method

.method public getDebug()Ljava/util/Properties;
    .locals 4

    .prologue
    .line 540
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    .line 541
    .local v0, "props":Ljava/util/Properties;
    const-string v1, "conState"

    new-instance v2, Ljava/lang/Integer;

    iget-byte v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 542
    const-string v1, "serverURI"

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v2

    invoke-interface {v2}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getServerURI()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 543
    const-string v1, "callback"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 544
    const-string v1, "stoppingComms"

    new-instance v2, Ljava/lang/Boolean;

    iget-boolean v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->stoppingComms:Z

    invoke-direct {v2, v3}, Ljava/lang/Boolean;-><init>(Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 545
    return-object v0
.end method

.method public getKeepAlive()J
    .locals 2

    .prologue
    .line 528
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getKeepAlive()J

    move-result-wide v0

    return-wide v0
.end method

.method public getNetworkModuleIndex()I
    .locals 1

    .prologue
    .line 508
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModuleIndex:I

    return v0
.end method

.method public getNetworkModules()[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    .locals 1

    .prologue
    .line 511
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    return-object v0
.end method

.method public getPendingDeliveryTokens()[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .locals 1

    .prologue
    .line 517
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getOutstandingDelTokens()[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    move-result-object v0

    return-object v0
.end method

.method getReceiver()Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    return-object v0
.end method

.method protected getTopic(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttTopic;
    .locals 1
    .param p1, "topic"    # Ljava/lang/String;

    .prologue
    .line 502
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;

    invoke-direct {v0, p1, p0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;-><init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V

    return-object v0
.end method

.method internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 12
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 105
    const-string v1, "internalSend"

    .line 107
    .local v1, "methodName":Ljava/lang/String;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "internalSend"

    const-string v5, "200"

    new-array v6, v11, [Ljava/lang/Object;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    aput-object p1, v6, v9

    aput-object p2, v6, v10

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 109
    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v2

    if-nez v2, :cond_0

    .line 111
    iget-object v2, p2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setClient(Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;)V

    .line 122
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v2, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->send(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    .line 129
    return-void

    .line 115
    :cond_0
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "internalSend"

    const-string v5, "213"

    new-array v6, v11, [Ljava/lang/Object;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    aput-object p1, v6, v9

    aput-object p2, v6, v10

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 117
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v3, 0x7dc9

    invoke-direct {v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v2

    .line 123
    :catch_0
    move-exception v0

    .line 124
    .local v0, "e":Lorg/pwrd/paho/client/mqttv3/MqttException;
    instance-of v2, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    if-eqz v2, :cond_1

    .line 125
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    check-cast p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .end local p1    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-virtual {v2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->undo(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    .line 127
    :cond_1
    throw v0
.end method

.method public isClosed()Z
    .locals 3

    .prologue
    .line 491
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v1

    .line 492
    :try_start_0
    iget-byte v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    const/4 v2, 0x4

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 491
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isConnected()Z
    .locals 2

    .prologue
    .line 467
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v1

    .line 468
    :try_start_0
    iget-byte v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 467
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isConnecting()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 473
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v1

    .line 474
    :try_start_0
    iget-byte v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    if-ne v2, v0, :cond_0

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 473
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isDisconnected()Z
    .locals 3

    .prologue
    .line 479
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v1

    .line 480
    :try_start_0
    iget-byte v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    const/4 v2, 0x3

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 479
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isDisconnecting()Z
    .locals 3

    .prologue
    .line 485
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v1

    .line 486
    :try_start_0
    iget-byte v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    const/4 v2, 0x2

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 485
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public sendNoWait(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 5
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 136
    const-string v0, "sendNoWait"

    .line 137
    .local v0, "methodName":Ljava/lang/String;
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v1

    if-nez v1, :cond_1

    .line 138
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v1

    if-nez v1, :cond_0

    instance-of v1, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;

    if-nez v1, :cond_1

    .line 139
    :cond_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v1

    if-eqz v1, :cond_2

    instance-of v1, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    if-eqz v1, :cond_2

    .line 140
    :cond_1
    invoke-virtual {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 146
    return-void

    .line 143
    :cond_2
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "sendNoWait"

    const-string v4, "208"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    const/16 v1, 0x7d68

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    throw v1
.end method

.method public setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V
    .locals 1
    .param p1, "mqttCallback"    # Lorg/pwrd/paho/client/mqttv3/MqttCallback;

    .prologue
    .line 498
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V

    .line 499
    return-void
.end method

.method public setNetworkModuleIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 505
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModuleIndex:I

    .line 506
    return-void
.end method

.method public setNetworkModules([Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;)V
    .locals 0
    .param p1, "networkModules"    # [Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    .prologue
    .line 514
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    .line 515
    return-void
.end method

.method public shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 11
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .param p2, "reason"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 266
    const-string v1, "shutdownConnection"

    .line 268
    .local v1, "methodName":Ljava/lang/String;
    const/4 v0, 0x0

    .line 272
    .local v0, "endToken":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    iget-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v7

    .line 273
    :try_start_0
    iget-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->stoppingComms:Z

    if-nez v4, :cond_0

    iget-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z

    if-eqz v4, :cond_1

    .line 274
    :cond_0
    monitor-exit v7

    .line 369
    :goto_0
    return-void

    .line 276
    :cond_1
    const/4 v4, 0x1

    iput-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->stoppingComms:Z

    .line 279
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v8, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v9, "shutdownConnection"

    const-string v10, "216"

    invoke-interface {v4, v8, v9, v10}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isConnected()Z

    move-result v4

    if-nez v4, :cond_c

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v4

    if-nez v4, :cond_c

    move v3, v6

    .line 282
    .local v3, "wasConnected":Z
    :goto_1
    const/4 v4, 0x2

    iput-byte v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 272
    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 287
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->isComplete()Z

    move-result v4

    if-nez v4, :cond_2

    .line 288
    iget-object v4, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v4, p2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setException(Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 293
    :cond_2
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->stop()V

    .line 297
    :cond_3
    :try_start_1
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    if-eqz v4, :cond_4

    .line 298
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModules:[Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;

    iget v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->networkModuleIndex:I

    aget-object v2, v4, v7

    .line 299
    .local v2, "networkModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    if-eqz v2, :cond_4

    .line 300
    invoke-interface {v2}, Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;->stop()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    .line 308
    .end local v2    # "networkModule":Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;
    :cond_4
    :goto_2
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    if-eqz v4, :cond_5

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->receiver:Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->stop()V

    .line 311
    :cond_5
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    new-instance v7, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v8, 0x7d66

    invoke-direct {v7, v8}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    invoke-virtual {v4, v7}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->quiesce(Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 316
    invoke-direct {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->handleOldTokens(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v0

    .line 320
    :try_start_2
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v4, p2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->disconnected(Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 325
    :goto_3
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    if-eqz v4, :cond_6

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sender:Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->stop()V

    .line 327
    :cond_6
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    if-eqz v4, :cond_7

    .line 328
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    invoke-interface {v4}, Lorg/pwrd/paho/client/mqttv3/MqttPingSender;->stop()V

    .line 332
    :cond_7
    :try_start_3
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    if-eqz v4, :cond_8

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v4}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 338
    :cond_8
    :goto_4
    iget-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v7

    .line 340
    :try_start_4
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v8, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->CLASS_NAME:Ljava/lang/String;

    const-string v9, "shutdownConnection"

    const-string v10, "217"

    invoke-interface {v4, v8, v9, v10}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    const/4 v4, 0x3

    iput-byte v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conState:B

    .line 343
    const/4 v4, 0x0

    iput-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->stoppingComms:Z

    .line 338
    monitor-exit v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 351
    if-eqz v0, :cond_d

    move v4, v5

    :goto_5
    iget-object v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    if-eqz v7, :cond_e

    :goto_6
    and-int/2addr v4, v5

    if-eqz v4, :cond_9

    .line 352
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4, v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 355
    :cond_9
    if-eqz v3, :cond_a

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    if-eqz v4, :cond_a

    .line 357
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4, p2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->connectionLost(Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 361
    :cond_a
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->conLock:Ljava/lang/Object;

    monitor-enter v5

    .line 362
    :try_start_5
    iget-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->closePending:Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    if-eqz v4, :cond_b

    .line 364
    :try_start_6
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 361
    :cond_b
    :goto_7
    :try_start_7
    monitor-exit v5

    goto/16 :goto_0

    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    throw v4

    .end local v3    # "wasConnected":Z
    :cond_c
    move v3, v5

    .line 281
    goto/16 :goto_1

    .line 272
    :catchall_1
    move-exception v4

    :try_start_8
    monitor-exit v7
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    throw v4

    .line 338
    .restart local v3    # "wasConnected":Z
    :catchall_2
    move-exception v4

    :try_start_9
    monitor-exit v7
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    throw v4

    :cond_d
    move v4, v6

    .line 351
    goto :goto_5

    :cond_e
    move v5, v6

    goto :goto_6

    .line 365
    :catch_0
    move-exception v4

    goto :goto_7

    .line 333
    :catch_1
    move-exception v4

    goto :goto_4

    .line 321
    :catch_2
    move-exception v4

    goto :goto_3

    .line 303
    :catch_3
    move-exception v4

    goto/16 :goto_2
.end method
