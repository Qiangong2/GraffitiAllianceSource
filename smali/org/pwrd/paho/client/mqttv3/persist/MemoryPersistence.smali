.class public Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;
.super Ljava/lang/Object;
.source "MemoryPersistence.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;


# instance fields
.field private data:Ljava/util/Hashtable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 85
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 86
    return-void
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->clear()V

    .line 44
    return-void
.end method

.method public containsKey(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 92
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public get(Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/MqttPersistable;

    return-object v0
.end method

.method public keys()Ljava/util/Enumeration;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v0

    return-object v0
.end method

.method public open(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "serverURI"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 64
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    .line 65
    return-void
.end method

.method public put(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttPersistable;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "persistable"    # Lorg/pwrd/paho/client/mqttv3/MqttPersistable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0, p1, p2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    return-void
.end method

.method public remove(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/persist/MemoryPersistence;->data:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    return-void
.end method
