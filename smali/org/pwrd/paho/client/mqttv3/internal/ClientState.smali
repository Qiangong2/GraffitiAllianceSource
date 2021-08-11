.class public Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
.super Ljava/lang/Object;
.source "ClientState.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final DEFAULT_MAX_INFLIGHT:I = 0xa

.field private static final MAX_MSG_ID:I = 0xffff

.field private static final MIN_MSG_ID:I = 0x1

.field private static final PERSISTENCE_CONFIRMED_PREFIX:Ljava/lang/String; = "sc-"

.field private static final PERSISTENCE_RECEIVED_PREFIX:Ljava/lang/String; = "r-"

.field private static final PERSISTENCE_SENT_PREFIX:Ljava/lang/String; = "s-"

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private actualInFlight:I

.field private callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

.field private cleanSession:Z

.field private clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private connected:Z

.field private inFlightPubRels:I

.field private inUseMsgIds:Ljava/util/Hashtable;

.field private inboundQoS2:Ljava/util/Hashtable;

.field private keepAlive:J

.field private lastInboundActivity:J

.field private lastOutboundActivity:J

.field private lastPing:J

.field private maxInflight:I

.field private nextMsgId:I

.field private outboundQoS1:Ljava/util/Hashtable;

.field private outboundQoS2:Ljava/util/Hashtable;

.field private volatile pendingFlows:Ljava/util/Vector;

.field private volatile pendingMessages:Ljava/util/Vector;

.field private persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

.field private pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

.field private pingOutstanding:I

.field private pingOutstandingLock:Ljava/lang/Object;

.field private pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

.field private queueLock:Ljava/lang/Object;

.field private quiesceLock:Ljava/lang/Object;

.field private quiescing:Z

.field private tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 92
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    .line 93
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 100
    return-void
.end method

.method protected constructor <init>(Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V
    .locals 5
    .param p1, "persistence"    # Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .param p2, "tokenStore"    # Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;
    .param p3, "callback"    # Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;
    .param p4, "clientComms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
    .param p5, "pingSender"    # Lorg/pwrd/paho/client/mqttv3/MqttPingSender;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 108
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 109
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    .line 114
    const/16 v0, 0xa

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    .line 115
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 116
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    .line 118
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    .line 119
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    .line 120
    iput-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    .line 122
    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    .line 123
    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    .line 124
    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastPing:J

    .line 126
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    .line 127
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    .line 129
    iput-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected:Z

    .line 131
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    .line 132
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    .line 133
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    .line 135
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    .line 140
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-virtual {p4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 141
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "<Init>"

    const-string v3, ""

    invoke-interface {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->finer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    .line 144
    new-instance v0, Ljava/util/Vector;

    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    invoke-direct {v0, v1}, Ljava/util/Vector;-><init>(I)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    .line 145
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    .line 146
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    .line 147
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    .line 148
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    .line 149
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;

    invoke-direct {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 150
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    .line 151
    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 153
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 154
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    .line 155
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 156
    iput-object p4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 157
    iput-object p5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    .line 159
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->restoreState()V

    .line 160
    return-void
.end method

.method private decrementInFlight()V
    .locals 10

    .prologue
    .line 793
    const-string v0, "decrementInFlight"

    .line 794
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v2

    .line 795
    :try_start_0
    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 797
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "decrementInFlight"

    const-string v5, "646"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v6, v7

    invoke-interface {v1, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 799
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    move-result v1

    if-nez v1, :cond_0

    .line 800
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 794
    :cond_0
    monitor-exit v2

    .line 803
    return-void

    .line 794
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private declared-synchronized getNextMessageId()I
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 1132
    monitor-enter p0

    :try_start_0
    iget v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 1135
    .local v2, "startingMessageId":I
    const/4 v1, 0x0

    .line 1137
    .local v1, "loopCount":I
    :cond_0
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 1138
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    const v4, 0xffff

    if-le v3, v4, :cond_1

    .line 1139
    const/4 v3, 0x1

    iput v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 1141
    :cond_1
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    if-ne v3, v2, :cond_2

    .line 1142
    add-int/lit8 v1, v1, 0x1

    .line 1143
    const/4 v3, 0x2

    if-ne v1, v3, :cond_2

    .line 1144
    const/16 v3, 0x7d01

    invoke-static {v3}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v3

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1132
    .end local v1    # "loopCount":I
    .end local v2    # "startingMessageId":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 1147
    .restart local v1    # "loopCount":I
    .restart local v2    # "startingMessageId":I
    :cond_2
    :try_start_1
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    new-instance v4, Ljava/lang/Integer;

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    invoke-direct {v4, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v4}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1148
    new-instance v0, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    invoke-direct {v0, v3}, Ljava/lang/Integer;-><init>(I)V

    .line 1149
    .local v0, "id":Ljava/lang/Integer;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    invoke-virtual {v3, v0, v0}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1150
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return v3
.end method

.method private getReceivedPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;
    .locals 2
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 181
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "r-"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSendConfirmPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;
    .locals 2
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 177
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "sc-"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;
    .locals 2
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 173
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "s-"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private insertInOrder(Ljava/util/Vector;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    .locals 5
    .param p1, "list"    # Ljava/util/Vector;
    .param p2, "newMsg"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 230
    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v1

    .line 231
    .local v1, "newMsgId":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/Vector;->size()I

    move-result v4

    if-lt v0, v4, :cond_0

    .line 239
    invoke-virtual {p1, p2}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 240
    :goto_1
    return-void

    .line 232
    :cond_0
    invoke-virtual {p1, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 233
    .local v2, "otherMsg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v3

    .line 234
    .local v3, "otherMsgId":I
    if-le v3, v1, :cond_1

    .line 235
    invoke-virtual {p1, p2, v0}, Ljava/util/Vector;->insertElementAt(Ljava/lang/Object;I)V

    goto :goto_1

    .line 231
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private reOrder(Ljava/util/Vector;)Ljava/util/Vector;
    .locals 9
    .param p1, "list"    # Ljava/util/Vector;

    .prologue
    .line 251
    new-instance v6, Ljava/util/Vector;

    invoke-direct {v6}, Ljava/util/Vector;-><init>()V

    .line 253
    .local v6, "newList":Ljava/util/Vector;
    invoke-virtual {p1}, Ljava/util/Vector;->size()I

    move-result v8

    if-nez v8, :cond_1

    .line 286
    :cond_0
    return-object v6

    .line 257
    :cond_1
    const/4 v7, 0x0

    .line 258
    .local v7, "previousMsgId":I
    const/4 v3, 0x0

    .line 259
    .local v3, "largestGap":I
    const/4 v4, 0x0

    .line 260
    .local v4, "largestGapMsgIdPosInList":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/Vector;->size()I

    move-result v8

    if-lt v2, v8, :cond_3

    .line 268
    const/4 v8, 0x0

    invoke-virtual {p1, v8}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    invoke-virtual {v8}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v5

    .line 269
    .local v5, "lowestMsgId":I
    move v1, v7

    .line 272
    .local v1, "highestMsgId":I
    const v8, 0xffff

    sub-int/2addr v8, v1

    add-int/2addr v8, v5

    if-le v8, v3, :cond_2

    .line 273
    const/4 v4, 0x0

    .line 277
    :cond_2
    move v2, v4

    :goto_1
    invoke-virtual {p1}, Ljava/util/Vector;->size()I

    move-result v8

    if-lt v2, v8, :cond_5

    .line 282
    const/4 v2, 0x0

    :goto_2
    if-ge v2, v4, :cond_0

    .line 283
    invoke-virtual {p1, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 282
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 261
    .end local v1    # "highestMsgId":I
    .end local v5    # "lowestMsgId":I
    :cond_3
    invoke-virtual {p1, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    invoke-virtual {v8}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v0

    .line 262
    .local v0, "currentMsgId":I
    sub-int v8, v0, v7

    if-le v8, v3, :cond_4

    .line 263
    sub-int v3, v0, v7

    .line 264
    move v4, v2

    .line 266
    :cond_4
    move v7, v0

    .line 260
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 278
    .end local v0    # "currentMsgId":I
    .restart local v1    # "highestMsgId":I
    .restart local v5    # "lowestMsgId":I
    :cond_5
    invoke-virtual {p1, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 277
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private declared-synchronized releaseMessageId(I)V
    .locals 2
    .param p1, "msgId"    # I

    .prologue
    .line 1122
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    new-instance v1, Ljava/lang/Integer;

    invoke-direct {v1, p1}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1123
    monitor-exit p0

    return-void

    .line 1122
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private restoreInflightMessages()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    .line 374
    const-string v2, "restoreInflightMessages"

    .line 375
    .local v2, "methodName":Ljava/lang/String;
    new-instance v4, Ljava/util/Vector;

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    invoke-direct {v4, v5}, Ljava/util/Vector;-><init>(I)V

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    .line 376
    new-instance v4, Ljava/util/Vector;

    invoke-direct {v4}, Ljava/util/Vector;-><init>()V

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    .line 378
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v4}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v1

    .line 379
    .local v1, "keys":Ljava/util/Enumeration;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v4

    if-nez v4, :cond_1

    .line 395
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    invoke-virtual {v4}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v1

    .line 396
    :goto_1
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v4

    if-nez v4, :cond_3

    .line 406
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-direct {p0, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->reOrder(Ljava/util/Vector;)Ljava/util/Vector;

    move-result-object v4

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    .line 407
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-direct {p0, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->reOrder(Ljava/util/Vector;)Ljava/util/Vector;

    move-result-object v4

    iput-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    .line 408
    return-void

    .line 380
    :cond_1
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    .line 381
    .local v0, "key":Ljava/lang/Object;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v4, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 382
    .local v3, "msg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    instance-of v4, v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    if-eqz v4, :cond_2

    .line 384
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "restoreInflightMessages"

    const-string v7, "610"

    new-array v8, v9, [Ljava/lang/Object;

    aput-object v0, v8, v10

    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 386
    invoke-virtual {v3, v9}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->setDuplicate(Z)V

    .line 387
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .end local v3    # "msg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-direct {p0, v4, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->insertInOrder(Ljava/util/Vector;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    goto :goto_0

    .line 388
    .restart local v3    # "msg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_2
    instance-of v4, v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    if-eqz v4, :cond_0

    .line 390
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "restoreInflightMessages"

    const-string v7, "611"

    new-array v8, v9, [Ljava/lang/Object;

    aput-object v0, v8, v10

    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 392
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    .end local v3    # "msg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-direct {p0, v4, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->insertInOrder(Ljava/util/Vector;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    goto :goto_0

    .line 397
    .end local v0    # "key":Ljava/lang/Object;
    :cond_3
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    .line 398
    .restart local v0    # "key":Ljava/lang/Object;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    invoke-virtual {v4, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .line 399
    .local v3, "msg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    invoke-virtual {v3, v9}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->setDuplicate(Z)V

    .line 401
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "restoreInflightMessages"

    const-string v7, "612"

    new-array v8, v9, [Ljava/lang/Object;

    aput-object v0, v8, v10

    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 403
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-direct {p0, v4, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->insertInOrder(Ljava/util/Vector;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    goto :goto_1
.end method

.method private restoreMessage(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "persistable"    # Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 200
    const-string v7, "restoreMessage"

    .line 201
    .local v7, "methodName":Ljava/lang/String;
    const/4 v6, 0x0

    .line 204
    .local v6, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :try_start_0
    invoke-static {p2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->createWireMessage(Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 220
    :cond_0
    :goto_0
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "restoreMessage"

    const-string v3, "601"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p1, v4, v8

    aput-object v6, v4, v9

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 221
    return-object v6

    .line 206
    :catch_0
    move-exception v5

    .line 208
    .local v5, "ex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v2, "restoreMessage"

    const-string v3, "602"

    new-array v4, v9, [Ljava/lang/Object;

    aput-object p1, v4, v8

    invoke-interface/range {v0 .. v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 209
    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    instance-of v0, v0, Ljava/io/EOFException;

    if-eqz v0, :cond_1

    .line 211
    if-eqz p1, :cond_0

    .line 212
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    goto :goto_0

    .line 216
    :cond_1
    throw v5
.end method


# virtual methods
.method public checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 20
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 531
    const-string v3, "checkForActivity"

    .line 533
    .local v3, "methodName":Ljava/lang/String;
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v11, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v12, "checkForActivity"

    const-string v13, "616"

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-interface {v10, v11, v12, v13, v14}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 535
    move-object/from16 v0, p0

    iget-object v11, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    monitor-enter v11

    .line 538
    :try_start_0
    move-object/from16 v0, p0

    iget-boolean v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    if-eqz v10, :cond_1

    .line 539
    monitor-exit v11

    const/4 v8, 0x0

    .line 615
    :cond_0
    :goto_0
    return-object v8

    .line 535
    :cond_1
    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 543
    const/4 v8, 0x0

    .line 544
    .local v8, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    invoke-virtual/range {p0 .. p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getKeepAlive()J

    move-result-wide v4

    .line 546
    .local v4, "nextPingTime":J
    move-object/from16 v0, p0

    iget-boolean v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected:Z

    if-eqz v10, :cond_0

    move-object/from16 v0, p0

    iget-wide v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    const-wide/16 v12, 0x0

    cmp-long v10, v10, v12

    if-lez v10, :cond_0

    .line 547
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 550
    .local v6, "time":J
    const/16 v2, 0x64

    .line 553
    .local v2, "delta":I
    move-object/from16 v0, p0

    iget-object v11, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    monitor-enter v11

    .line 556
    :try_start_1
    move-object/from16 v0, p0

    iget v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    if-lez v10, :cond_2

    move-object/from16 v0, p0

    iget-wide v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    sub-long v12, v6, v12

    move-object/from16 v0, p0

    iget-wide v14, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    int-to-long v0, v2

    move-wide/from16 v16, v0

    add-long v14, v14, v16

    cmp-long v10, v12, v14

    if-ltz v10, :cond_2

    .line 561
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v12, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v13, "checkForActivity"

    const-string v14, "619"

    const/4 v15, 0x5

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x1

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x2

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x3

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, v17

    invoke-direct {v0, v6, v7}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x4

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastPing:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    invoke-interface {v10, v12, v13, v14, v15}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->severe(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 565
    const/16 v10, 0x7d00

    invoke-static {v10}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v10

    throw v10

    .line 553
    :catchall_0
    move-exception v10

    :goto_1
    monitor-exit v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v10

    .line 535
    .end local v2    # "delta":I
    .end local v4    # "nextPingTime":J
    .end local v6    # "time":J
    .end local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_1
    move-exception v10

    :try_start_2
    monitor-exit v11
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v10

    .line 569
    .restart local v2    # "delta":I
    .restart local v4    # "nextPingTime":J
    .restart local v6    # "time":J
    .restart local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :cond_2
    :try_start_3
    move-object/from16 v0, p0

    iget v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    if-nez v10, :cond_3

    move-object/from16 v0, p0

    iget-wide v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    sub-long v12, v6, v12

    const-wide/16 v14, 0x2

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    move-wide/from16 v16, v0

    mul-long v14, v14, v16

    cmp-long v10, v12, v14

    if-ltz v10, :cond_3

    .line 572
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v12, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v13, "checkForActivity"

    const-string v14, "642"

    const/4 v15, 0x5

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x1

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x2

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x3

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, v17

    invoke-direct {v0, v6, v7}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x4

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastPing:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    invoke-interface {v10, v12, v13, v14, v15}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->severe(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 576
    const/16 v10, 0x7d02

    invoke-static {v10}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v10

    throw v10

    .line 588
    :cond_3
    move-object/from16 v0, p0

    iget v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    if-nez v10, :cond_4

    move-object/from16 v0, p0

    iget-wide v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    sub-long v12, v6, v12

    move-object/from16 v0, p0

    iget-wide v14, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    int-to-long v0, v2

    move-wide/from16 v16, v0

    sub-long v14, v14, v16

    cmp-long v10, v12, v14

    if-gez v10, :cond_5

    .line 589
    :cond_4
    move-object/from16 v0, p0

    iget-wide v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    sub-long v12, v6, v12

    move-object/from16 v0, p0

    iget-wide v14, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    int-to-long v0, v2

    move-wide/from16 v16, v0

    sub-long v14, v14, v16

    cmp-long v10, v12, v14

    if-ltz v10, :cond_6

    .line 592
    :cond_5
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v12, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v13, "checkForActivity"

    const-string v14, "620"

    const/4 v15, 0x3

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x1

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    const/16 v16, 0x2

    new-instance v17, Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    move-wide/from16 v18, v0

    invoke-direct/range {v17 .. v19}, Ljava/lang/Long;-><init>(J)V

    aput-object v17, v15, v16

    invoke-interface {v10, v12, v13, v14, v15}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 596
    new-instance v9, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-object/from16 v0, p0

    iget-object v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v10}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v10

    invoke-interface {v10}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Lorg/pwrd/paho/client/mqttv3/MqttToken;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 597
    .end local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .local v9, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :try_start_4
    move-object/from16 v0, p0

    iget-object v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    move-object/from16 v0, p0

    iget-object v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    invoke-virtual {v10, v9, v12}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 598
    move-object/from16 v0, p0

    iget-object v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    move-object/from16 v0, p0

    iget-object v12, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    const/4 v13, 0x0

    invoke-virtual {v10, v12, v13}, Ljava/util/Vector;->insertElementAt(Ljava/lang/Object;I)V

    .line 600
    invoke-virtual/range {p0 .. p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getKeepAlive()J

    move-result-wide v4

    .line 603
    invoke-virtual/range {p0 .. p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyQueueLock()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-object v8, v9

    .line 553
    .end local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .restart local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :goto_2
    :try_start_5
    monitor-exit v11
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 611
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v11, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v12, "checkForActivity"

    const-string v13, "624"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    new-instance v16, Ljava/lang/Long;

    move-object/from16 v0, v16

    invoke-direct {v0, v4, v5}, Ljava/lang/Long;-><init>(J)V

    aput-object v16, v14, v15

    invoke-interface {v10, v11, v12, v13, v14}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 612
    move-object/from16 v0, p0

    iget-object v10, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    invoke-interface {v10, v4, v5}, Lorg/pwrd/paho/client/mqttv3/MqttPingSender;->schedule(J)V

    goto/16 :goto_0

    .line 606
    :cond_6
    :try_start_6
    sget-object v10, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v12, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v13, "checkForActivity"

    const-string v14, "634"

    const/4 v15, 0x0

    invoke-interface {v10, v12, v13, v14, v15}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 607
    const-wide/16 v12, 0x1

    invoke-virtual/range {p0 .. p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getKeepAlive()J

    move-result-wide v14

    move-object/from16 v0, p0

    iget-wide v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    move-wide/from16 v16, v0

    sub-long v16, v6, v16

    sub-long v14, v14, v16

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->max(JJ)J
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-wide v4

    goto :goto_2

    .line 553
    .end local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .restart local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_2
    move-exception v10

    move-object v8, v9

    .end local v9    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .restart local v8    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    goto/16 :goto_1
.end method

.method protected checkQuiesceLock()Z
    .locals 11

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 806
    const-string v0, "checkQuiesceLock"

    .line 808
    .local v0, "methodName":Ljava/lang/String;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->count()I

    move-result v1

    .line 809
    .local v1, "tokC":I
    iget-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    if-eqz v4, :cond_0

    if-nez v1, :cond_0

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v4}, Ljava/util/Vector;->size()I

    move-result v4

    if-nez v4, :cond_0

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->isQuiesced()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 811
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "checkQuiesceLock"

    const-string v7, "626"

    const/4 v8, 0x6

    new-array v8, v8, [Ljava/lang/Object;

    new-instance v9, Ljava/lang/Boolean;

    iget-boolean v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    invoke-direct {v9, v10}, Ljava/lang/Boolean;-><init>(Z)V

    aput-object v9, v8, v3

    new-instance v3, Ljava/lang/Integer;

    iget v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v3, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v3, v8, v2

    const/4 v3, 0x2

    new-instance v9, Ljava/lang/Integer;

    iget-object v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v10}, Ljava/util/Vector;->size()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v8, v3

    const/4 v3, 0x3

    new-instance v9, Ljava/lang/Integer;

    iget v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v8, v3

    const/4 v3, 0x4

    iget-object v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v9}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->isQuiesced()Z

    move-result v9

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v8, v3

    const/4 v3, 0x5

    new-instance v9, Ljava/lang/Integer;

    invoke-direct {v9, v1}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v8, v3

    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 812
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    monitor-enter v3

    .line 813
    :try_start_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Object;->notifyAll()V

    .line 812
    monitor-exit v3

    .line 817
    :goto_0
    return v2

    .line 812
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    :cond_0
    move v2, v3

    .line 817
    goto :goto_0
.end method

.method protected clearState()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 185
    const-string v0, "clearState"

    .line 187
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "clearState"

    const-string v4, ">"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->clear()V

    .line 190
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    invoke-virtual {v1}, Ljava/util/Hashtable;->clear()V

    .line 191
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->clear()V

    .line 192
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->clear()V

    .line 193
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v1}, Ljava/util/Hashtable;->clear()V

    .line 194
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    invoke-virtual {v1}, Ljava/util/Hashtable;->clear()V

    .line 195
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v1}, Ljava/util/Hashtable;->clear()V

    .line 196
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->clear()V

    .line 197
    return-void
.end method

.method protected close()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1230
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 1231
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 1232
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 1233
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 1234
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 1235
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 1236
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->clear()V

    .line 1237
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    .line 1238
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    .line 1239
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    .line 1240
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    .line 1241
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    .line 1242
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    .line 1243
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    .line 1244
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    .line 1245
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 1246
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    .line 1247
    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 1248
    return-void
.end method

.method public connected()V
    .locals 5

    .prologue
    .line 1037
    const-string v0, "connected"

    .line 1039
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "connected"

    const-string v4, "631"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1040
    const/4 v1, 0x1

    iput-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected:Z

    .line 1042
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingSender:Lorg/pwrd/paho/client/mqttv3/MqttPingSender;

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/MqttPingSender;->start()V

    .line 1043
    return-void
.end method

.method protected deliveryComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V
    .locals 9
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 1215
    const-string v0, "deliveryComplete"

    .line 1218
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "deliveryComplete"

    const-string v4, "641"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    new-instance v7, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v8

    invoke-direct {v7, v8}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1220
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getReceivedPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    .line 1221
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    new-instance v2, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v3

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1222
    return-void
.end method

.method public disconnected(Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 7
    .param p1, "reason"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    const/4 v6, 0x0

    .line 1093
    const-string v0, "disconnected"

    .line 1095
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "disconnected"

    const-string v4, "633"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1097
    iput-boolean v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected:Z

    .line 1100
    :try_start_0
    iget-boolean v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->cleanSession:Z

    if-eqz v1, :cond_0

    .line 1101
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clearState()V

    .line 1104
    :cond_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->clear()V

    .line 1105
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->clear()V

    .line 1106
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1108
    const/4 v1, 0x0

    :try_start_1
    iput v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    .line 1106
    monitor-exit v2

    .line 1113
    :goto_0
    return-void

    .line 1106
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v1
    :try_end_2
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_2 .. :try_end_2} :catch_0

    .line 1110
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected get()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 629
    const-string v1, "get"

    .line 630
    .local v1, "methodName":Ljava/lang/String;
    const/4 v2, 0x0

    .line 632
    .local v2, "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v4

    .line 633
    :cond_0
    :goto_0
    if-eqz v2, :cond_1

    .line 632
    :try_start_0
    monitor-exit v4

    .line 700
    .end local v2    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :goto_1
    return-object v2

    .line 638
    .restart local v2    # "result":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_1
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 639
    :cond_2
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_4

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-lt v3, v5, :cond_4

    .line 642
    :cond_3
    :try_start_1
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "644"

    invoke-interface {v3, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 644
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->wait()V

    .line 647
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "647"

    invoke-interface {v3, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 655
    :cond_4
    :goto_2
    :try_start_2
    iget-boolean v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected:Z

    if-nez v3, :cond_6

    .line 656
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_5

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    instance-of v3, v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;

    if-nez v3, :cond_6

    .line 658
    :cond_5
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "621"

    invoke-interface {v3, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 660
    monitor-exit v4

    const/4 v2, 0x0

    goto :goto_1

    .line 670
    :cond_6
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_8

    .line 672
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Ljava/util/Vector;->remove(I)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-object v2, v0

    .line 673
    instance-of v3, v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    if-eqz v3, :cond_7

    .line 674
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    .line 677
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "617"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/Integer;

    iget v11, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 680
    :cond_7
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    goto/16 :goto_0

    .line 632
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 681
    :cond_8
    :try_start_3
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 684
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    if-ge v3, v5, :cond_9

    .line 687
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-object v2, v0

    .line 688
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Ljava/util/Vector;->removeElementAt(I)V

    .line 689
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 692
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "623"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/Integer;

    iget v11, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 695
    :cond_9
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "get"

    const-string v7, "622"

    invoke-interface {v3, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    .line 648
    :catch_0
    move-exception v3

    goto/16 :goto_2
.end method

.method public getDebug()Ljava/util/Properties;
    .locals 6

    .prologue
    .line 1251
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    .line 1252
    .local v0, "props":Ljava/util/Properties;
    const-string v1, "In use msgids"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1253
    const-string v1, "pendingMessages"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1254
    const-string v1, "pendingFlows"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1255
    const-string v1, "maxInflight"

    new-instance v2, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1256
    const-string v1, "nextMsgID"

    new-instance v2, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1257
    const-string v1, "actualInFlight"

    new-instance v2, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1258
    const-string v1, "inFlightPubRels"

    new-instance v2, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1259
    const-string v1, "quiescing"

    iget-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1260
    const-string v1, "pingoutstanding"

    new-instance v2, Ljava/lang/Integer;

    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1261
    const-string v1, "lastOutboundActivity"

    new-instance v2, Ljava/lang/Long;

    iget-wide v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    invoke-direct {v2, v4, v5}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1262
    const-string v1, "lastInboundActivity"

    new-instance v2, Ljava/lang/Long;

    iget-wide v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    invoke-direct {v2, v4, v5}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1263
    const-string v1, "outboundQoS2"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1264
    const-string v1, "outboundQoS1"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1265
    const-string v1, "inboundQoS2"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1266
    const-string v1, "tokens"

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1267
    return-object v0
.end method

.method protected getKeepAlive()J
    .locals 2

    .prologue
    .line 166
    iget-wide v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    return-wide v0
.end method

.method protected notifyComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 13
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 971
    const-string v2, "notifyComplete"

    .line 973
    .local v2, "methodName":Ljava/lang/String;
    iget-object v3, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getWireMessage()Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v1

    .line 975
    .local v1, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    if-eqz v1, :cond_1

    instance-of v3, v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-eqz v3, :cond_1

    .line 977
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "notifyComplete"

    const-string v6, "629"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    .line 978
    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v7, v10

    aput-object p1, v7, v11

    aput-object v1, v7, v12

    .line 977
    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v0, v1

    .line 980
    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    .line 982
    .local v0, "ack":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    instance-of v3, v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;

    if-eqz v3, :cond_2

    .line 984
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    .line 985
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    new-instance v4, Ljava/lang/Integer;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v5

    invoke-direct {v4, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v4}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 986
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->decrementInFlight()V

    .line 987
    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v3

    invoke-direct {p0, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->releaseMessageId(I)V

    .line 988
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v3, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 990
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "notifyComplete"

    const-string v6, "650"

    .line 991
    new-array v7, v11, [Ljava/lang/Object;

    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v7, v10

    .line 990
    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1009
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    .line 1011
    .end local v0    # "ack":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    :cond_1
    return-void

    .line 992
    .restart local v0    # "ack":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    :cond_2
    instance-of v3, v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    if-eqz v3, :cond_0

    .line 994
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    .line 995
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendConfirmPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    .line 996
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v4, Ljava/lang/Integer;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v5

    invoke-direct {v4, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v4}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 998
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    .line 999
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->decrementInFlight()V

    .line 1000
    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v3

    invoke-direct {p0, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->releaseMessageId(I)V

    .line 1001
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v3, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 1004
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "notifyComplete"

    const-string v6, "645"

    new-array v7, v12, [Ljava/lang/Object;

    .line 1005
    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v7, v10

    .line 1006
    new-instance v8, Ljava/lang/Integer;

    iget v9, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v7, v11

    .line 1004
    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public notifyQueueLock()V
    .locals 6

    .prologue
    .line 1206
    const-string v0, "notifyQueueLock"

    .line 1207
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v2

    .line 1209
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "notifyQueueLock"

    const-string v5, "638"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1210
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 1207
    monitor-exit v2

    .line 1212
    return-void

    .line 1207
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method protected notifyReceivedAck(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;)V
    .locals 14
    .param p1, "ack"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 837
    const-string v0, "notifyReceivedAck"

    .line 838
    .local v0, "methodName":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    .line 841
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "notifyReceivedAck"

    const-string v8, "627"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    .line 842
    new-instance v10, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v11

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v9, v12

    aput-object p1, v9, v13

    .line 841
    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 844
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v4

    .line 845
    .local v4, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    const/4 v1, 0x0

    .line 847
    .local v1, "mex":Lorg/pwrd/paho/client/mqttv3/MqttException;
    instance-of v5, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    if-eqz v5, :cond_0

    .line 852
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    check-cast p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    .end local p1    # "ack":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    invoke-direct {v3, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;)V

    .line 853
    .local v3, "rel":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    invoke-virtual {p0, v3, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->send(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 905
    .end local v3    # "rel":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    :goto_0
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    .line 906
    return-void

    .line 854
    .restart local p1    # "ack":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;
    :cond_0
    instance-of v5, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubAck;

    if-nez v5, :cond_1

    instance-of v5, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    if-eqz v5, :cond_2

    .line 857
    :cond_1
    invoke-virtual {p0, p1, v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyResult(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    goto :goto_0

    .line 860
    :cond_2
    instance-of v5, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingResp;

    if-eqz v5, :cond_4

    .line 861
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    monitor-enter v6

    .line 862
    const/4 v5, 0x0

    :try_start_0
    iget v7, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    add-int/lit8 v7, v7, -0x1

    invoke-static {v5, v7}, Ljava/lang/Math;->max(II)I

    move-result v5

    iput v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    .line 863
    invoke-virtual {p0, p1, v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyResult(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 864
    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    if-nez v5, :cond_3

    .line 865
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 861
    :cond_3
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 869
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "notifyReceivedAck"

    const-string v8, "636"

    new-array v9, v13, [Ljava/lang/Object;

    new-instance v10, Ljava/lang/Integer;

    iget v11, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v9, v12

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 861
    :catchall_0
    move-exception v5

    :try_start_1
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v5

    .line 870
    :cond_4
    instance-of v5, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    if-eqz v5, :cond_7

    move-object v5, p1

    .line 871
    check-cast v5, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;->getReturnCode()I

    move-result v2

    .line 872
    .local v2, "rc":I
    if-nez v2, :cond_6

    .line 873
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v6

    .line 874
    :try_start_2
    iget-boolean v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->cleanSession:Z

    if-eqz v5, :cond_5

    .line 875
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clearState()V

    .line 878
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, v4, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 880
    :cond_5
    const/4 v5, 0x0

    iput v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    .line 881
    const/4 v5, 0x0

    iput v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 882
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->restoreInflightMessages()V

    .line 883
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->connected()V

    .line 873
    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 890
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    move-object v5, p1

    check-cast v5, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;

    invoke-virtual {v6, v5, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->connectComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnack;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 891
    invoke-virtual {p0, p1, v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyResult(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 892
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 895
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v6

    .line 896
    :try_start_3
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v5}, Ljava/lang/Object;->notifyAll()V

    .line 895
    monitor-exit v6

    goto/16 :goto_0

    :catchall_1
    move-exception v5

    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v5

    .line 873
    :catchall_2
    move-exception v5

    :try_start_4
    monitor-exit v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v5

    .line 886
    :cond_6
    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;->createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v1

    .line 887
    throw v1

    .line 900
    .end local v2    # "rc":I
    :cond_7
    invoke-virtual {p0, p1, v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyResult(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 901
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;->getMessageId()I

    move-result v5

    invoke-direct {p0, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->releaseMessageId(I)V

    .line 902
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    goto/16 :goto_0
.end method

.method public notifyReceivedBytes(I)V
    .locals 8
    .param p1, "receivedBytesCount"    # I

    .prologue
    .line 821
    const-string v0, "notifyReceivedBytes"

    .line 822
    .local v0, "methodName":Ljava/lang/String;
    if-lez p1, :cond_0

    .line 823
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    .line 826
    :cond_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifyReceivedBytes"

    const-string v4, "630"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    .line 827
    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, p1}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v5, v6

    .line 826
    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 828
    return-void
.end method

.method protected notifyReceivedMsg(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    .locals 13
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v12, 0x0

    .line 916
    const-string v0, "notifyReceivedMsg"

    .line 917
    .local v0, "methodName":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastInboundActivity:J

    .line 920
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "notifyReceivedMsg"

    const-string v7, "651"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    .line 921
    new-instance v10, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v11

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    .line 920
    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 923
    iget-boolean v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    if-nez v4, :cond_0

    .line 924
    instance-of v4, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    if-eqz v4, :cond_1

    move-object v2, p1

    .line 925
    check-cast v2, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .line 926
    .local v2, "send":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v4

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 958
    .end local v2    # "send":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .end local p1    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_0
    :goto_0
    return-void

    .line 929
    .restart local v2    # "send":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .restart local p1    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :pswitch_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    if-eqz v4, :cond_0

    .line 930
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4, v2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageArrived(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    goto :goto_0

    .line 934
    :pswitch_1
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getReceivedPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v5

    .line 935
    check-cast p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .line 934
    .end local p1    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    invoke-interface {v4, v5, p1}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->put(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)V

    .line 936
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v4, v5, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 937
    new-instance v4, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    invoke-direct {v4, v2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;-><init>(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    invoke-virtual {p0, v4, v12}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->send(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    goto :goto_0

    .line 943
    .end local v2    # "send":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .restart local p1    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    :cond_1
    instance-of v4, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    if-eqz v4, :cond_0

    .line 944
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    .line 945
    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v4, v5}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .line 946
    .local v3, "sendMsg":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    if-eqz v3, :cond_2

    .line 947
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    if-eqz v4, :cond_0

    .line 948
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4, v3}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->messageArrived(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V

    goto :goto_0

    .line 952
    :cond_2
    new-instance v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    .line 953
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v4

    .line 952
    invoke-direct {v1, v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;-><init>(I)V

    .line 954
    .local v1, "pubComp":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;
    invoke-virtual {p0, v1, v12}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->send(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    goto :goto_0

    .line 926
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected notifyResult(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 10
    .param p1, "ack"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .param p3, "ex"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1014
    const-string v0, "notifyResult"

    .line 1016
    .local v0, "methodName":Ljava/lang/String;
    iget-object v1, p2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, p1, p3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 1019
    if-eqz p1, :cond_0

    instance-of v1, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-eqz v1, :cond_0

    instance-of v1, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRec;

    if-nez v1, :cond_0

    .line 1021
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifyResult"

    const-string v4, "648"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    aput-object p1, v5, v8

    aput-object p3, v5, v9

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1022
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 1026
    :cond_0
    if-nez p1, :cond_1

    .line 1028
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifyResult"

    const-string v4, "649"

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v6, p2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    aput-object p3, v5, v8

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1029
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 1031
    :cond_1
    return-void
.end method

.method protected notifySent(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    .locals 13
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    const/4 v11, 0x0

    const/4 v8, 0x1

    const/4 v10, 0x0

    .line 759
    const-string v0, "notifySent"

    .line 761
    .local v0, "methodName":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    .line 763
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "notifySent"

    const-string v7, "625"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-interface {v4, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 765
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v4, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v1

    .line 766
    .local v1, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    iget-object v4, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->notifySent()V

    .line 767
    instance-of v4, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;

    if-eqz v4, :cond_1

    .line 768
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    monitor-enter v5

    .line 769
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 770
    .local v2, "time":J
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstandingLock:Ljava/lang/Object;

    monitor-enter v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 771
    :try_start_1
    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastPing:J

    .line 772
    iget v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    .line 770
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 775
    :try_start_2
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "notifySent"

    const-string v8, "635"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    new-instance v11, Ljava/lang/Integer;

    iget v12, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingOutstanding:I

    invoke-direct {v11, v12}, Ljava/lang/Integer;-><init>(I)V

    aput-object v11, v9, v10

    invoke-interface {v4, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 768
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 790
    .end local v2    # "time":J
    :cond_0
    :goto_0
    return-void

    .line 770
    .restart local v2    # "time":J
    :catchall_0
    move-exception v4

    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v4

    .line 768
    .end local v2    # "time":J
    :catchall_1
    move-exception v4

    monitor-exit v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v4

    .line 778
    :cond_1
    instance-of v4, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    if-eqz v4, :cond_0

    move-object v4, p1

    .line 779
    check-cast v4, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v4

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v4

    if-nez v4, :cond_0

    .line 782
    iget-object v4, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v4, v11, v11}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 783
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v4, v1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->asyncOperationComplete(Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 784
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->decrementInFlight()V

    .line 785
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v4

    invoke-direct {p0, v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->releaseMessageId(I)V

    .line 786
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v4, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 787
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    goto :goto_0
.end method

.method public notifySentBytes(I)V
    .locals 8
    .param p1, "sentBytesCount"    # I

    .prologue
    .line 744
    const-string v0, "notifySentBytes"

    .line 745
    .local v0, "methodName":Ljava/lang/String;
    if-lez p1, :cond_0

    .line 746
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->lastOutboundActivity:J

    .line 749
    :cond_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "notifySentBytes"

    const-string v4, "631"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    .line 750
    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, p1}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v5, v6

    .line 749
    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 751
    return-void
.end method

.method public quiesce(J)V
    .locals 11
    .param p1, "timeout"    # J

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x0

    .line 1160
    const-string v0, "quiesce"

    .line 1162
    .local v0, "methodName":Ljava/lang/String;
    const-wide/16 v2, 0x0

    cmp-long v2, p1, v2

    if-lez v2, :cond_2

    .line 1164
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "quiesce"

    const-string v5, "637"

    new-array v6, v6, [Ljava/lang/Object;

    new-instance v7, Ljava/lang/Long;

    invoke-direct {v7, p1, p2}, Ljava/lang/Long;-><init>(J)V

    aput-object v7, v6, v8

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1165
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v3

    .line 1166
    const/4 v2, 0x1

    :try_start_0
    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    .line 1165
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1169
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->quiesce()V

    .line 1170
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifyQueueLock()V

    .line 1172
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    monitor-enter v3

    .line 1177
    :try_start_1
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->count()I

    move-result v1

    .line 1178
    .local v1, "tokc":I
    if-gtz v1, :cond_0

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-gtz v2, :cond_0

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->callback:Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/CommsCallback;->isQuiesced()Z

    move-result v2

    if-nez v2, :cond_1

    .line 1180
    :cond_0
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "quiesce"

    const-string v6, "639"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    new-instance v9, Ljava/lang/Integer;

    iget v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    const/4 v8, 0x1

    new-instance v9, Ljava/lang/Integer;

    iget-object v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v10}, Ljava/util/Vector;->size()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    const/4 v8, 0x2

    new-instance v9, Ljava/lang/Integer;

    iget v10, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inFlightPubRels:I

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    const/4 v8, 0x3

    new-instance v9, Ljava/lang/Integer;

    invoke-direct {v9, v1}, Ljava/lang/Integer;-><init>(I)V

    aput-object v9, v7, v8

    invoke-interface {v2, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1184
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesceLock:Ljava/lang/Object;

    invoke-virtual {v2, p1, p2}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1172
    .end local v1    # "tokc":I
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1194
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v3

    .line 1195
    :try_start_3
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->clear()V

    .line 1196
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->clear()V

    .line 1197
    const/4 v2, 0x0

    iput-boolean v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiescing:Z

    .line 1198
    const/4 v2, 0x0

    iput v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    .line 1194
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1201
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "quiesce"

    const-string v5, "640"

    invoke-interface {v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1203
    :cond_2
    return-void

    .line 1165
    :catchall_0
    move-exception v2

    :try_start_4
    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    .line 1172
    :catchall_1
    move-exception v2

    :try_start_5
    monitor-exit v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v2

    .line 1194
    :catchall_2
    move-exception v2

    :try_start_6
    monitor-exit v3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    throw v2

    .line 1187
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public resolveOldTokens(Lorg/pwrd/paho/client/mqttv3/MqttException;)Ljava/util/Vector;
    .locals 11
    .param p1, "reason"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    .line 1054
    const-string v0, "resolveOldTokens"

    .line 1056
    .local v0, "methodName":Ljava/lang/String;
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "resolveOldTokens"

    const-string v8, "632"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p1, v9, v10

    invoke-interface {v5, v6, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1061
    move-object v3, p1

    .line 1062
    .local v3, "shutReason":Lorg/pwrd/paho/client/mqttv3/MqttException;
    if-nez p1, :cond_0

    .line 1063
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    .end local v3    # "shutReason":Lorg/pwrd/paho/client/mqttv3/MqttException;
    const/16 v5, 0x7d66

    invoke-direct {v3, v5}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    .line 1070
    .restart local v3    # "shutReason":Lorg/pwrd/paho/client/mqttv3/MqttException;
    :cond_0
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->getOutstandingTokens()Ljava/util/Vector;

    move-result-object v1

    .line 1071
    .local v1, "outT":Ljava/util/Vector;
    invoke-virtual {v1}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v2

    .line 1072
    .local v2, "outTE":Ljava/util/Enumeration;
    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v5

    if-nez v5, :cond_2

    .line 1085
    return-object v1

    .line 1073
    :cond_2
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 1074
    .local v4, "tok":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    monitor-enter v4

    .line 1075
    :try_start_0
    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->isComplete()Z

    move-result v5

    if-nez v5, :cond_3

    iget-object v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isCompletePending()Z

    move-result v5

    if-nez v5, :cond_3

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/MqttToken;->getException()Lorg/pwrd/paho/client/mqttv3/MqttException;

    move-result-object v5

    if-nez v5, :cond_3

    .line 1076
    iget-object v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5, v3}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setException(Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 1074
    :cond_3
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1079
    instance-of v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    if-nez v5, :cond_1

    .line 1082
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    iget-object v6, v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v6}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    goto :goto_0

    .line 1074
    :catchall_0
    move-exception v5

    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v5
.end method

.method protected restoreState()V
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 293
    const-string v6, "restoreState"

    .line 294
    .local v6, "methodName":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v13}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->keys()Ljava/util/Enumeration;

    move-result-object v5

    .line 297
    .local v5, "messageKeys":Ljava/util/Enumeration;
    move-object/from16 v0, p0

    iget v2, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 298
    .local v2, "highestMsgId":I
    new-instance v7, Ljava/util/Vector;

    invoke-direct {v7}, Ljava/util/Vector;-><init>()V

    .line 300
    .local v7, "orphanedPubRels":Ljava/util/Vector;
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "600"

    invoke-interface/range {v13 .. v16}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v13

    if-nez v13, :cond_1

    .line 361
    invoke-virtual {v7}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v5

    .line 362
    :goto_1
    invoke-interface {v5}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v13

    if-nez v13, :cond_7

    .line 370
    move-object/from16 v0, p0

    iput v2, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->nextMsgId:I

    .line 371
    return-void

    .line 303
    :cond_1
    invoke-interface {v5}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 304
    .local v3, "key":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v13, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->get(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttPersistable;

    move-result-object v8

    .line 305
    .local v8, "persistable":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v8}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->restoreMessage(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v4

    .line 306
    .local v4, "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    if-eqz v4, :cond_0

    .line 307
    const-string v13, "r-"

    invoke-virtual {v3, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 309
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "604"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    const/16 v18, 0x1

    aput-object v4, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 312
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inboundQoS2:Ljava/util/Hashtable;

    new-instance v14, Ljava/lang/Integer;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v15

    invoke-direct {v14, v15}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v13, v14, v4}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 313
    :cond_2
    const-string v13, "s-"

    invoke-virtual {v3, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_6

    move-object v11, v4

    .line 314
    check-cast v11, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .line 315
    .local v11, "sendMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v13

    invoke-static {v13, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 316
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendConfirmPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v14

    invoke-interface {v13, v14}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->containsKey(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_4

    .line 317
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendConfirmPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v14

    invoke-interface {v13, v14}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->get(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttPersistable;

    move-result-object v9

    .line 321
    .local v9, "persistedConfirm":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v9}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->restoreMessage(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    move-result-object v1

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    .line 322
    .local v1, "confirmMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    if-eqz v1, :cond_3

    .line 325
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "605"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    const/16 v18, 0x1

    aput-object v4, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 327
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v14, Ljava/lang/Integer;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;->getMessageId()I

    move-result v15

    invoke-direct {v14, v15}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v13, v14, v1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    .end local v1    # "confirmMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    .end local v9    # "persistedConfirm":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    :goto_2
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v13, v11}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->restoreToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    move-result-object v12

    .line 349
    .local v12, "tok":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    iget-object v13, v12, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    move-object/from16 v0, p0

    iget-object v14, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->clientComms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v14}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v14

    invoke-virtual {v13, v14}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setClient(Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;)V

    .line 350
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->inUseMsgIds:Ljava/util/Hashtable;

    new-instance v14, Ljava/lang/Integer;

    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v15

    invoke-direct {v14, v15}, Ljava/lang/Integer;-><init>(I)V

    new-instance v15, Ljava/lang/Integer;

    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v16

    invoke-direct/range {v15 .. v16}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v13, v14, v15}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 330
    .end local v12    # "tok":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .restart local v1    # "confirmMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    .restart local v9    # "persistedConfirm":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    :cond_3
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "606"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    const/16 v18, 0x1

    aput-object v4, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 335
    .end local v1    # "confirmMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    .end local v9    # "persistedConfirm":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    :cond_4
    const/4 v13, 0x1

    invoke-virtual {v11, v13}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->setDuplicate(Z)V

    .line 336
    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v13

    invoke-virtual {v13}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v13

    const/4 v14, 0x2

    if-ne v13, v14, :cond_5

    .line 338
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "607"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    const/16 v18, 0x1

    aput-object v4, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 340
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v14, Ljava/lang/Integer;

    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v15

    invoke-direct {v14, v15}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v13, v14, v11}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_2

    .line 343
    :cond_5
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "608"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    const/16 v18, 0x1

    aput-object v4, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 345
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    new-instance v14, Ljava/lang/Integer;

    invoke-virtual {v11}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v15

    invoke-direct {v14, v15}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v13, v14, v11}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_2

    .line 352
    .end local v11    # "sendMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    :cond_6
    const-string v13, "sc-"

    invoke-virtual {v3, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_0

    move-object v10, v4

    .line 353
    check-cast v10, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    .line 354
    .local v10, "pubRelMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v14

    invoke-interface {v13, v14}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->containsKey(Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_0

    .line 355
    invoke-virtual {v7, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 363
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "message":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .end local v8    # "persistable":Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    .end local v10    # "pubRelMessage":Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;
    :cond_7
    invoke-interface {v5}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 365
    .restart local v3    # "key":Ljava/lang/String;
    sget-object v13, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v14, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v15, "restoreState"

    const-string v16, "609"

    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    aput-object v3, v17, v18

    invoke-interface/range {v13 .. v17}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 367
    move-object/from16 v0, p0

    iget-object v13, v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-interface {v13, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public send(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 12
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .param p2, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 420
    const-string v2, "send"

    .line 421
    .local v2, "methodName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->isMessageIdRequired()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v3

    if-nez v3, :cond_0

    .line 422
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getNextMessageId()I

    move-result v3

    invoke-virtual {p1, v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->setMessageId(I)V

    .line 424
    :cond_0
    if-eqz p2, :cond_1

    .line 426
    :try_start_0
    iget-object v3, p2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v4

    invoke-virtual {v3, v4}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setMessageID(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 431
    :cond_1
    :goto_0
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    if-eqz v3, :cond_3

    .line 432
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v4

    .line 433
    :try_start_1
    iget v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    iget v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->maxInflight:I

    if-lt v3, v5, :cond_2

    .line 435
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "send"

    const-string v7, "613"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/Integer;

    iget v11, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->actualInFlight:I

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 437
    new-instance v3, Lorg/pwrd/paho/client/mqttv3/MqttException;

    const/16 v5, 0x7dca

    invoke-direct {v3, v5}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    throw v3

    .line 432
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3

    .line 440
    :cond_2
    :try_start_2
    move-object v0, p1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    move-object v3, v0

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v1

    .line 442
    .local v1, "innerMessage":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "send"

    const-string v7, "628"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v11

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    const/4 v9, 0x1

    new-instance v10, Ljava/lang/Integer;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v11

    invoke-direct {v10, v11}, Ljava/lang/Integer;-><init>(I)V

    aput-object v10, v8, v9

    const/4 v9, 0x2

    aput-object p1, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 444
    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 454
    :goto_1
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v3, p2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 455
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v3, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 456
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->notifyAll()V

    .line 432
    monitor-exit v4

    .line 491
    .end local v1    # "innerMessage":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    :goto_2
    return-void

    .line 446
    .restart local v1    # "innerMessage":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    :pswitch_0
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v5, p1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 447
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v6

    move-object v0, p1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    move-object v3, v0

    invoke-interface {v5, v6, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->put(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)V

    goto :goto_1

    .line 450
    :pswitch_1
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v5, p1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 451
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v6

    move-object v0, p1

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    move-object v3, v0

    invoke-interface {v5, v6, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->put(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 460
    .end local v1    # "innerMessage":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    :cond_3
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "send"

    const-string v6, "615"

    new-array v7, v7, [Ljava/lang/Object;

    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v7, v10

    aput-object p1, v7, v11

    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 462
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttConnect;

    if-eqz v3, :cond_4

    .line 463
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v4

    .line 466
    :try_start_3
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v3, p2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 467
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    const/4 v5, 0x0

    invoke-virtual {v3, p1, v5}, Ljava/util/Vector;->insertElementAt(Ljava/lang/Object;I)V

    .line 468
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->notifyAll()V

    .line 463
    monitor-exit v4

    goto :goto_2

    :catchall_1
    move-exception v3

    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v3

    .line 471
    :cond_4
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPingReq;

    if-eqz v3, :cond_7

    .line 472
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pingCommand:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .line 482
    :cond_5
    :goto_3
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v4

    .line 483
    :try_start_4
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttAck;

    if-nez v3, :cond_6

    .line 484
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v3, p2, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V

    .line 486
    :cond_6
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingFlows:Ljava/util/Vector;

    invoke-virtual {v3, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 487
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->notifyAll()V

    .line 482
    monitor-exit v4

    goto/16 :goto_2

    :catchall_2
    move-exception v3

    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v3

    .line 474
    :cond_7
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    if-eqz v3, :cond_8

    .line 475
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v4, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getMessageId()I

    move-result v5

    invoke-direct {v4, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3, v4, p1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 476
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendConfirmPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v5

    move-object v3, p1

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubRel;

    invoke-interface {v4, v5, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->put(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)V

    goto :goto_3

    .line 478
    :cond_8
    instance-of v3, p1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPubComp;

    if-eqz v3, :cond_5

    .line 479
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getReceivedPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    goto :goto_3

    .line 427
    :catch_0
    move-exception v3

    goto/16 :goto_0

    .line 444
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected setCleanSession(Z)V
    .locals 0
    .param p1, "cleanSession"    # Z

    .prologue
    .line 169
    iput-boolean p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->cleanSession:Z

    .line 170
    return-void
.end method

.method public setKeepAliveInterval(J)V
    .locals 1
    .param p1, "interval"    # J

    .prologue
    .line 704
    iput-wide p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    .line 705
    return-void
.end method

.method protected setKeepAliveSecs(J)V
    .locals 3
    .param p1, "keepAliveSecs"    # J

    .prologue
    .line 163
    const-wide/16 v0, 0x3e8

    mul-long/2addr v0, p1

    iput-wide v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->keepAlive:J

    .line 164
    return-void
.end method

.method protected undo(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)V
    .locals 11
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    .line 499
    const-string v0, "undo"

    .line 500
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->queueLock:Ljava/lang/Object;

    monitor-enter v2

    .line 502
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "undo"

    const-string v5, "618"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v6, v7

    const/4 v7, 0x1

    new-instance v8, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v9

    invoke-virtual {v9}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v9

    invoke-direct {v8, v9}, Ljava/lang/Integer;-><init>(I)V

    aput-object v8, v6, v7

    invoke-interface {v1, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 504
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v1

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->getQos()I

    move-result v1

    if-ne v1, v10, :cond_0

    .line 505
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS1:Ljava/util/Hashtable;

    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v3}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 509
    :goto_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->pendingMessages:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->removeElement(Ljava/lang/Object;)Z

    .line 510
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->persistence:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getSendPersistenceKey(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;->remove(Ljava/lang/String;)V

    .line 511
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->tokenStore:Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v1, p1}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 512
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->checkQuiesceLock()Z

    .line 500
    monitor-exit v2

    .line 514
    return-void

    .line 507
    :cond_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->outboundQoS2:Ljava/util/Hashtable;

    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v3}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 500
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
