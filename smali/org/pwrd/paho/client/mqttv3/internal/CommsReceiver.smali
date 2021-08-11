.class public Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;
.super Ljava/lang/Object;
.source "CommsReceiver.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

.field private in:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

.field private lifecycle:Ljava/lang/Object;

.field private recThread:Ljava/lang/Thread;

.field private volatile receiving:Z

.field private running:Z

.field private tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    .line 35
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/ClientState;Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;Ljava/io/InputStream;)V
    .locals 2
    .param p1, "clientComms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
    .param p2, "clientState"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
    .param p3, "tokenStore"    # Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;
    .param p4, "in"    # Ljava/io/InputStream;

    .prologue
    const/4 v1, 0x0

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    .line 38
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->lifecycle:Ljava/lang/Object;

    .line 39
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 40
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 42
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 43
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    .line 47
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

    invoke-direct {v0, p2, p4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientState;Ljava/io/InputStream;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->in:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

    .line 48
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 49
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 50
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 51
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 52
    return-void
.end method


# virtual methods
.method public isReceiving()Z
    .locals 1

    .prologue
    .line 169
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    return v0
.end method

.method public isRunning()Z
    .locals 1

    .prologue
    .line 160
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    return v0
.end method

.method public run()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 100
    const-string v8, "run"

    .line 101
    .local v8, "methodName":Ljava/lang/String;
    const/4 v9, 0x0

    .line 103
    .local v9, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :goto_0
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->in:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

    if-nez v0, :cond_1

    .line 156
    :cond_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "run"

    const-string v3, "854"

    invoke-interface {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    return-void

    .line 106
    :cond_1
    :try_start_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "run"

    const-string v3, "852"

    invoke-interface {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->in:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;->available()I

    move-result v0

    if-lez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    .line 108
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->in:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttInputStream;->readMqttWireMessage()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v7

    .line 109
    .local v7, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    .line 111
    instance-of v0, v7, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-eqz v0, :cond_5

    .line 112
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v0, v7}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v9

    .line 113
    if-eqz v9, :cond_3

    .line 114
    monitor-enter v9
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 119
    :try_start_1
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    check-cast v7, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    .end local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-virtual {v0, v7}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyReceivedAck(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;)V

    .line 114
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 151
    :goto_2
    iput-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    goto :goto_0

    :cond_2
    move v0, v10

    .line 107
    goto :goto_1

    .line 114
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v9
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 131
    :catch_0
    move-exception v5

    .line 133
    .local v5, "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :try_start_4
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "run"

    const-string v3, "856"

    const/4 v4, 0x0

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 134
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    .line 136
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0, v9, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 151
    iput-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    goto :goto_0

    .line 124
    .end local v5    # "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    .restart local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_3
    :try_start_5
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v0
    :try_end_5
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 138
    .end local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :catch_1
    move-exception v6

    .line 140
    .local v6, "ioe":Ljava/io/IOException;
    :try_start_6
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "run"

    const-string v3, "853"

    invoke-interface {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    .line 146
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->isDisconnecting()Z

    move-result v0

    if-nez v0, :cond_4

    .line 147
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    new-instance v1, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v2, 0x7d6d

    invoke-direct {v1, v2, v6}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    invoke-virtual {v0, v9, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 151
    :cond_4
    iput-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    goto/16 :goto_0

    .line 128
    .end local v6    # "ioe":Ljava/io/IOException;
    .restart local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_5
    :try_start_7
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0, v7}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyReceivedMsg(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    :try_end_7
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_2

    .line 150
    .end local v7    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :catchall_1
    move-exception v0

    .line 151
    iput-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    .line 152
    throw v0
.end method

.method public start(Ljava/lang/String;)V
    .locals 5
    .param p1, "threadName"    # Ljava/lang/String;

    .prologue
    .line 58
    const-string v0, "start"

    .line 60
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "start"

    const-string v4, "855"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->lifecycle:Ljava/lang/Object;

    monitor-enter v2

    .line 62
    :try_start_0
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    if-nez v1, :cond_0

    .line 63
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    .line 64
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    .line 65
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 61
    :cond_0
    monitor-exit v2

    .line 68
    return-void

    .line 61
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public stop()V
    .locals 6

    .prologue
    .line 74
    const-string v0, "stop"

    .line 75
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->lifecycle:Ljava/lang/Object;

    monitor-enter v2

    .line 77
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "stop"

    const-string v5, "850"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    if-eqz v1, :cond_0

    .line 79
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->running:Z

    .line 80
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->receiving:Z

    .line 81
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 84
    :try_start_1
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->join()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 75
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 91
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->recThread:Ljava/lang/Thread;

    .line 93
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsReceiver;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "stop"

    const-string v4, "851"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    return-void

    .line 75
    :catchall_0
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v1

    .line 86
    :catch_0
    move-exception v1

    goto :goto_0
.end method
