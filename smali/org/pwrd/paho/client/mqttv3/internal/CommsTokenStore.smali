.class public Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;
.super Ljava/lang/Object;
.source "CommsTokenStore.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

.field private logContext:Ljava/lang/String;

.field private tokens:Ljava/util/Hashtable;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 48
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    .line 49
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 5
    .param p1, "logContext"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 57
    const-string v0, "<Init>"

    .line 59
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v1, p1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 60
    new-instance v1, Ljava/util/Hashtable;

    invoke-direct {v1}, Ljava/util/Hashtable;-><init>()V

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    .line 61
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->logContext:Ljava/lang/String;

    .line 63
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "<Init>"

    const-string v4, "308"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 9

    .prologue
    .line 227
    const-string v0, "clear"

    .line 229
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "clear"

    const-string v4, "305"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    new-instance v7, Ljava/lang/Integer;

    iget-object v8, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v8}, Ljava/util/Hashtable;->size()I

    move-result v8

    invoke-direct {v7, v8}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 230
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v2

    .line 231
    :try_start_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v1}, Ljava/util/Hashtable;->clear()V

    .line 230
    monitor-exit v2

    .line 233
    return-void

    .line 230
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public count()I
    .locals 2

    .prologue
    .line 236
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v1

    .line 237
    :try_start_0
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->size()I

    move-result v0

    monitor-exit v1

    return v0

    .line 236
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getOutstandingDelTokens()[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .locals 10

    .prologue
    .line 179
    const-string v2, "getOutstandingDelTokens"

    .line 181
    .local v2, "methodName":Ljava/lang/String;
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v6

    .line 183
    :try_start_0
    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v7, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v8, "getOutstandingDelTokens"

    const-string v9, "311"

    invoke-interface {v5, v7, v8, v9}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    .line 186
    .local v1, "list":Ljava/util/Vector;
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v5}, Ljava/util/Hashtable;->elements()Ljava/util/Enumeration;

    move-result-object v0

    .line 188
    .local v0, "enumeration":Ljava/util/Enumeration;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v5

    if-nez v5, :cond_1

    .line 198
    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v5

    new-array v3, v5, [Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    .line 199
    .local v3, "result":[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    invoke-virtual {v1, v3}, Ljava/util/Vector;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    monitor-exit v6

    return-object v5

    .line 189
    .end local v3    # "result":[Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    :cond_1
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 190
    .local v4, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    if-eqz v4, :cond_0

    .line 191
    instance-of v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    if-eqz v5, :cond_0

    .line 192
    iget-object v5, v4, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->isNotified()Z

    move-result v5

    if-nez v5, :cond_0

    .line 194
    invoke-virtual {v1, v4}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0

    .line 181
    .end local v0    # "enumeration":Ljava/util/Enumeration;
    .end local v1    # "list":Ljava/util/Vector;
    .end local v4    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5
.end method

.method public getOutstandingTokens()Ljava/util/Vector;
    .locals 9

    .prologue
    .line 204
    const-string v2, "getOutstandingTokens"

    .line 206
    .local v2, "methodName":Ljava/lang/String;
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v5

    .line 208
    :try_start_0
    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v7, "getOutstandingTokens"

    const-string v8, "312"

    invoke-interface {v4, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    .line 211
    .local v1, "list":Ljava/util/Vector;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v4}, Ljava/util/Hashtable;->elements()Ljava/util/Enumeration;

    move-result-object v0

    .line 213
    .local v0, "enumeration":Ljava/util/Enumeration;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v4

    if-nez v4, :cond_1

    .line 219
    monitor-exit v5

    return-object v1

    .line 214
    :cond_1
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 215
    .local v3, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    if-eqz v3, :cond_0

    .line 216
    invoke-virtual {v1, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0

    .line 206
    .end local v0    # "enumeration":Ljava/util/Enumeration;
    .end local v1    # "list":Ljava/util/Vector;
    .end local v3    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4
.end method

.method public getToken(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 79
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    return-object v0
.end method

.method public getToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 2
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 74
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "key":Ljava/lang/String;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v1, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    return-object v1
.end method

.method public open()V
    .locals 6

    .prologue
    .line 168
    const-string v0, "open"

    .line 170
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v2

    .line 172
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "open"

    const-string v5, "310"

    invoke-interface {v1, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 170
    monitor-exit v2

    .line 176
    return-void

    .line 170
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method protected quiesce(Lorg/pwrd/paho/client/mqttv3/MqttException;)V
    .locals 8
    .param p1, "quiesceResponse"    # Lorg/pwrd/paho/client/mqttv3/MqttException;

    .prologue
    .line 157
    const-string v0, "quiesce"

    .line 159
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v2

    .line 161
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "quiesce"

    const-string v5, "309"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-interface {v1, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

    .line 159
    monitor-exit v2

    .line 165
    return-void

    .line 159
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public removeToken(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 7
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 91
    const-string v0, "removeToken"

    .line 93
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "removeToken"

    const-string v4, "306"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 95
    if-eqz p1, :cond_0

    .line 96
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v1, p1}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 99
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public removeToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .locals 1
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;

    .prologue
    .line 84
    if-eqz p1, :cond_0

    .line 85
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->removeToken(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v0

    .line 87
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected restoreToken(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;)Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .locals 10
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    .prologue
    .line 108
    const-string v1, "restoreToken"

    .line 110
    .local v1, "methodName":Ljava/lang/String;
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v4

    .line 111
    :try_start_0
    new-instance v3, Ljava/lang/Integer;

    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;->getMessageId()I

    move-result v5

    invoke-direct {v3, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v3}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 112
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v3, v0}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 113
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v3, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    .line 115
    .local v2, "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "restoreToken"

    const-string v7, "302"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v0, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    const/4 v9, 0x2

    aput-object v2, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 110
    :goto_0
    monitor-exit v4

    .line 124
    return-object v2

    .line 117
    .end local v2    # "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    :cond_0
    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->logContext:Ljava/lang/String;

    invoke-direct {v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;-><init>(Ljava/lang/String;)V

    .line 118
    .restart local v2    # "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    iget-object v3, v2, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v3, v0}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setKey(Ljava/lang/String;)V

    .line 119
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v3, v0, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v6, "restoreToken"

    const-string v7, "303"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v0, v8, v9

    const/4 v9, 0x1

    aput-object p1, v8, v9

    const/4 v9, 0x2

    aput-object v2, v8, v9

    invoke-interface {v3, v5, v6, v7, v8}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 110
    .end local v0    # "key":Ljava/lang/String;
    .end local v2    # "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method protected saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Ljava/lang/String;)V
    .locals 9
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 146
    const-string v0, "saveToken"

    .line 148
    .local v0, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v2

    .line 150
    :try_start_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "saveToken"

    const-string v5, "307"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p2, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-interface {v1, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 151
    iget-object v1, p1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->setKey(Ljava/lang/String;)V

    .line 152
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v1, p2, p1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    monitor-exit v2

    .line 154
    return-void

    .line 148
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method protected saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    .locals 9
    .param p1, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;
    .param p2, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    .line 130
    const-string v1, "saveToken"

    .line 132
    .local v1, "methodName":Ljava/lang/String;
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v3

    .line 133
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

    if-nez v2, :cond_0

    .line 134
    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getKey()Ljava/lang/String;

    move-result-object v0

    .line 136
    .local v0, "key":Ljava/lang/String;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->CLASS_NAME:Ljava/lang/String;

    const-string v5, "saveToken"

    const-string v6, "300"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    const/4 v8, 0x1

    aput-object p2, v7, v8

    invoke-interface {v2, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 138
    invoke-virtual {p0, p1, v0}, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->saveToken(Lorg/pwrd/paho/client/mqttv3/MqttToken;Ljava/lang/String;)V

    .line 132
    monitor-exit v3

    .line 143
    return-void

    .line 140
    .end local v0    # "key":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->closedResponse:Lorg/pwrd/paho/client/mqttv3/MqttException;

    throw v2

    .line 132
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public toString()Ljava/lang/String;
    .locals 7

    .prologue
    .line 241
    const-string v4, "line.separator"

    const-string v5, "\n"

    invoke-static {v4, v5}, Ljava/lang/System;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 242
    .local v1, "lineSep":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 243
    .local v3, "toks":Ljava/lang/StringBuffer;
    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    monitor-enter v5

    .line 244
    :try_start_0
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/internal/CommsTokenStore;->tokens:Ljava/util/Hashtable;

    invoke-virtual {v4}, Ljava/util/Hashtable;->elements()Ljava/util/Enumeration;

    move-result-object v0

    .line 246
    .local v0, "enumeration":Ljava/util/Enumeration;
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v4

    if-nez v4, :cond_0

    .line 250
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    monitor-exit v5

    return-object v4

    .line 247
    :cond_0
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 248
    .local v2, "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "{"

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "}"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 243
    .end local v0    # "enumeration":Ljava/util/Enumeration;
    .end local v2    # "token":Lorg/pwrd/paho/client/mqttv3/MqttToken;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4
.end method
