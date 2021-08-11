.class public Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;
.super Ljava/lang/Object;
.source "TCPNetworkModule.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/internal/NetworkModule;


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private conTimeout:I

.field private factory:Ljavax/net/SocketFactory;

.field private host:Ljava/lang/String;

.field private port:I

.field protected socket:Ljava/net/Socket;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->CLASS_NAME:Ljava/lang/String;

    .line 38
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljavax/net/SocketFactory;Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p1, "factory"    # Ljavax/net/SocketFactory;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "resourceContext"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v0, p4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 53
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->factory:Ljavax/net/SocketFactory;

    .line 54
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->host:Ljava/lang/String;

    .line 55
    iput p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->port:I

    .line 57
    return-void
.end method


# virtual methods
.method public getInputStream()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 85
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public setConnectTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 106
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->conTimeout:I

    .line 107
    return-void
.end method

.method public start()V
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 63
    const-string v6, "start"

    .line 68
    .local v6, "methodName":Ljava/lang/String;
    :try_start_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "start"

    const-string v3, "252"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->host:Ljava/lang/String;

    aput-object v9, v4, v8

    const/4 v8, 0x1

    new-instance v9, Ljava/lang/Integer;

    iget v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->port:I

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v4, v8

    const/4 v8, 0x2

    new-instance v9, Ljava/lang/Long;

    iget v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->conTimeout:I

    mul-int/lit16 v10, v10, 0x3e8

    int-to-long v10, v10

    invoke-direct {v9, v10, v11}, Ljava/lang/Long;-><init>(J)V

    aput-object v9, v4, v8

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 69
    new-instance v7, Ljava/net/InetSocketAddress;

    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->host:Ljava/lang/String;

    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->port:I

    invoke-direct {v7, v0, v1}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    .line 70
    .local v7, "sockaddr":Ljava/net/SocketAddress;
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->factory:Ljavax/net/SocketFactory;

    invoke-virtual {v0}, Ljavax/net/SocketFactory;->createSocket()Ljava/net/Socket;

    move-result-object v0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    .line 71
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->conTimeout:I

    mul-int/lit16 v1, v1, 0x3e8

    invoke-virtual {v0, v7, v1}, Ljava/net/Socket;->connect(Ljava/net/SocketAddress;I)V
    :try_end_0
    .catch Ljava/net/ConnectException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    return-void

    .line 77
    .end local v7    # "sockaddr":Ljava/net/SocketAddress;
    :catch_0
    move-exception v5

    .line 79
    .local v5, "ex":Ljava/net/ConnectException;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "start"

    const-string v3, "250"

    const/4 v4, 0x0

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 80
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v1, 0x7d67

    invoke-direct {v0, v1, v5}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    throw v0
.end method

.method public stop()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/TCPNetworkModule;->socket:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 99
    :cond_0
    return-void
.end method
