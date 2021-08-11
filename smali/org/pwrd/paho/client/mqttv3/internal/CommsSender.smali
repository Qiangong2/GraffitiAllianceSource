.class public Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;
.super Ljava/lang/Object;
.source "CommsSender.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

.field private lifecycle:Ljava/lang/Object;

.field private out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

.field private running:Z

.field private sendThread:Ljava/lang/Thread;

.field private tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 33
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    .line 34
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/ClientState;Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;Ljava/io/OutputStream;)V
    .locals 2
    .param p1, "clientComms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
    .param p2, "clientState"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
    .param p3, "tokenStore"    # Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;
    .param p4, "out"    # Ljava/io/OutputStream;

    .prologue
    const/4 v1, 0x0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    .line 38
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->lifecycle:Ljava/lang/Object;

    .line 39
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 41
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 42
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 43
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    .line 46
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-direct {v0, p2, p4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientState;Ljava/io/OutputStream;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    .line 47
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 48
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 49
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 50
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method private handleRunException(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Ljava/lang/Exception;)V
    .locals 8
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "ex"    # Ljava/lang/Exception;

    .prologue
    const/4 v4, 0x0

    .line 147
    const-string v6, "handleRunException"

    .line 149
    .local v6, "methodName":Ljava/lang/String;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "handleRunException"

    const-string v3, "804"

    move-object v5, p2

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 151
    instance-of v0, p2, Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v0, :cond_0

    .line 152
    new-instance v7, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v0, 0x7d6d

    invoke-direct {v7, v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    .line 157
    .local v7, "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    .line 158
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0, v4, v7}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 159
    return-void

    .end local v7    # "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :cond_0
    move-object v7, p2

    .line 154
    check-cast v7, Lorg/pwrd/paho/client/mqttv3/MqttException;

    .restart local v7    # "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    .line 95
    const-string v3, "run"

    .line 96
    .local v3, "methodName":Ljava/lang/String;
    const/4 v2, 0x0

    .line 97
    .local v2, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_0
    :goto_0
    iget-boolean v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    if-eqz v5, :cond_1

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    if-nez v5, :cond_2

    .line 142
    :cond_1
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "run"

    const-string v8, "805"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    return-void

    .line 99
    :cond_2
    :try_start_0
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->get()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v2

    .line 100
    if-eqz v2, :cond_5

    .line 102
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "run"

    const-string v8, "802"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    aput-object v2, v9, v10

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 104
    instance-of v5, v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-eqz v5, :cond_3

    .line 105
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-virtual {v5, v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->write(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 106
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->flush()V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 134
    :catch_0
    move-exception v1

    .line 135
    .local v1, "me":Lorg/pwrd/paho/client/mqttv3/MqttException;
    invoke-direct {p0, v2, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->handleRunException(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Ljava/lang/Exception;)V

    goto :goto_0

    .line 108
    .end local v1    # "me":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :cond_3
    :try_start_1
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, v2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v4

    .line 112
    .local v4, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    if-eqz v4, :cond_0

    .line 113
    monitor-enter v4
    :try_end_1
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 114
    :try_start_2
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-virtual {v5, v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->write(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 116
    :try_start_3
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->out:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->flush()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 124
    :cond_4
    :try_start_4
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v5, v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifySent(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 113
    monitor-exit v4

    goto :goto_0

    :catchall_0
    move-exception v5

    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v5
    :try_end_5
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    .line 136
    .end local v4    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catch_1
    move-exception v0

    .line 137
    .local v0, "ex":Ljava/lang/Exception;
    invoke-direct {p0, v2, v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->handleRunException(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Ljava/lang/Exception;)V

    goto :goto_0

    .line 117
    .end local v0    # "ex":Ljava/lang/Exception;
    .restart local v4    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catch_2
    move-exception v0

    .line 120
    .local v0, "ex":Ljava/io/IOException;
    :try_start_6
    instance-of v5, v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    if-nez v5, :cond_4

    .line 121
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 130
    .end local v0    # "ex":Ljava/io/IOException;
    .end local v4    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :cond_5
    :try_start_7
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "run"

    const-string v8, "803"

    invoke-interface {v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    const/4 v5, 0x0

    iput-boolean v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z
    :try_end_7
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    goto :goto_0
.end method

.method public start(Ljava/lang/String;)V
    .locals 2
    .param p1, "threadName"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->lifecycle:Ljava/lang/Object;

    monitor-enter v1

    .line 58
    :try_start_0
    iget-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    if-nez v0, :cond_0

    .line 59
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    .line 60
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    .line 61
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 57
    :cond_0
    monitor-exit v1

    .line 64
    return-void

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public stop()V
    .locals 6

    .prologue
    .line 70
    const-string v0, "stop"

    .line 72
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->lifecycle:Ljava/lang/Object;

    monitor-enter v2

    .line 74
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "stop"

    const-string v5, "800"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    if-eqz v1, :cond_0

    .line 76
    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->running:Z

    .line 77
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 80
    :try_start_1
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyQueueLock()V

    .line 82
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->join()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 88
    :cond_0
    :goto_0
    const/4 v1, 0x0

    :try_start_2
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->sendThread:Ljava/lang/Thread;

    .line 90
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsSender;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "stop"

    const-string v5, "801"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    monitor-exit v2

    .line 92
    return-void

    .line 72
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1

    .line 84
    :catch_0
    move-exception v1

    goto :goto_0
.end method
