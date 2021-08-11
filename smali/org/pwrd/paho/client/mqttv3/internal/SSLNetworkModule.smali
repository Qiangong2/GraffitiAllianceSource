.class public Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;
.super Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;
.source "SSLNetworkModule.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private enabledCiphers:[Ljava/lang/String;

.field private handshakeTimeoutSecs:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->CLASS_NAME:Ljava/lang/String;

    .line 33
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljavax/net/ssl/SSLSocketFactory;Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p1, "factory"    # Ljavax/net/ssl/SSLSocketFactory;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "resourceContext"    # Ljava/lang/String;

    .prologue
    .line 44
    invoke-direct {p0, p1, p2, p3, p4}, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;-><init>(Ljavax/net/SocketFactory;Ljava/lang/String;ILjava/lang/String;)V

    .line 45
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v0, p4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 46
    return-void
.end method


# virtual methods
.method public getEnabledCiphers()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->enabledCiphers:[Ljava/lang/String;

    return-object v0
.end method

.method public setEnabledCiphers([Ljava/lang/String;)V
    .locals 9
    .param p1, "enabledCiphers"    # [Ljava/lang/String;

    .prologue
    .line 59
    const-string v2, "setEnabledCiphers"

    .line 60
    .local v2, "methodName":Ljava/lang/String;
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->enabledCiphers:[Ljava/lang/String;

    .line 61
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    if-eqz v3, :cond_1

    if-eqz p1, :cond_1

    .line 62
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    const/4 v4, 0x5

    invoke-interface {v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->isLoggable(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 63
    const-string v0, ""

    .line 64
    .local v0, "ciphers":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, p1

    if-lt v1, v3, :cond_2

    .line 71
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "setEnabledCiphers"

    const-string v6, "260"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 73
    .end local v0    # "ciphers":Ljava/lang/String;
    .end local v1    # "i":I
    :cond_0
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    check-cast v3, Ljavax/net/ssl/SSLSocket;

    invoke-virtual {v3, p1}, Ljavax/net/ssl/SSLSocket;->setEnabledCipherSuites([Ljava/lang/String;)V

    .line 75
    :cond_1
    return-void

    .line 65
    .restart local v0    # "ciphers":Ljava/lang/String;
    .restart local v1    # "i":I
    :cond_2
    if-lez v1, :cond_3

    .line 66
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 68
    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v4, p1, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public setSSLhandshakeTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 78
    invoke-super {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->setConnectTimeout(I)V

    .line 79
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->handshakeTimeoutSecs:I

    .line 80
    return-void
.end method

.method public start()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 83
    invoke-super {p0}, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->start()V

    .line 84
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->enabledCiphers:[Ljava/lang/String;

    invoke-virtual {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->setEnabledCiphers([Ljava/lang/String;)V

    .line 85
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    invoke-virtual {v1}, Ljava/net/Socket;->getSoTimeout()I

    move-result v0

    .line 86
    .local v0, "soTimeout":I
    if-nez v0, :cond_0

    .line 88
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    iget v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->handshakeTimeoutSecs:I

    mul-int/lit16 v2, v2, 0x3e8

    invoke-virtual {v1, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 90
    :cond_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    check-cast v1, Ljavax/net/ssl/SSLSocket;

    invoke-virtual {v1}, Ljavax/net/ssl/SSLSocket;->startHandshake()V

    .line 92
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/SSLNetworkModule;->socket:Ljava/net/Socket;

    invoke-virtual {v1, v0}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 93
    return-void
.end method
