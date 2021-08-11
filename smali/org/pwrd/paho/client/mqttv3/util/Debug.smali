.class public Lorg/pwrd/paho/client/mqttv3/util/Debug;
.super Ljava/lang/Object;
.source "Debug.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final lineSep:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

.field private static final separator:Ljava/lang/String; = "=============="


# instance fields
.field private clientID:Ljava/lang/String;

.field private comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    .line 38
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 40
    const-string v0, "line.separator"

    const-string v1, "\n"

    invoke-static {v0, v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V
    .locals 1
    .param p1, "clientID"    # Ljava/lang/String;
    .param p2, "comms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->clientID:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 53
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v0, p1}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->setResourceName(Ljava/lang/String;)V

    .line 54
    return-void
.end method

.method public static dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "props"    # Ljava/util/Properties;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 148
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 149
    .local v1, "propStr":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v2

    .line 150
    .local v2, "propsE":Ljava/util/Enumeration;
    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "=============="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "=============="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 151
    :goto_0
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v3

    if-nez v3, :cond_0

    .line 155
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "=========================================="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 157
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 152
    :cond_0
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 153
    .local v0, "key":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const/16 v4, 0x1c

    const/16 v5, 0x20

    invoke-static {v0, v4, v5}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->left(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ":  "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v0}, Ljava/util/Properties;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public static left(Ljava/lang/String;IC)Ljava/lang/String;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "width"    # I
    .param p2, "fillChar"    # C

    .prologue
    .line 170
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-lt v2, p1, :cond_0

    .line 178
    .end local p0    # "s":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 173
    .restart local p0    # "s":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1, p1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 174
    .local v1, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 175
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    sub-int v0, p1, v2

    .local v0, "i":I
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-gez v0, :cond_1

    .line 178
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 176
    :cond_1
    invoke-virtual {v1, p2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1
.end method


# virtual methods
.method public dumpBaseDebug()V
    .locals 0

    .prologue
    .line 75
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpVersion()V

    .line 76
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpSystemProperties()V

    .line 77
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpMemoryTrace()V

    .line 78
    return-void
.end method

.method public dumpClientComms()V
    .locals 6

    .prologue
    .line 124
    const/4 v0, 0x0

    .line 125
    .local v0, "props":Ljava/util/Properties;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    if-eqz v1, :cond_0

    .line 126
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getDebug()Ljava/util/Properties;

    move-result-object v0

    .line 127
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "dumpClientComms"

    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->clientID:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " : ClientComms"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    :cond_0
    return-void
.end method

.method public dumpClientDebug()V
    .locals 0

    .prologue
    .line 63
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpClientComms()V

    .line 64
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpConOptions()V

    .line 65
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpClientState()V

    .line 66
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpBaseDebug()V

    .line 67
    return-void
.end method

.method public dumpClientState()V
    .locals 6

    .prologue
    .line 113
    const/4 v0, 0x0

    .line 114
    .local v0, "props":Ljava/util/Properties;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClientState()Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 115
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClientState()Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    move-result-object v1

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->getDebug()Ljava/util/Properties;

    move-result-object v0

    .line 116
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "dumpClientState"

    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->clientID:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " : ClientState"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    :cond_0
    return-void
.end method

.method public dumpConOptions()V
    .locals 6

    .prologue
    .line 135
    const/4 v0, 0x0

    .line 136
    .local v0, "props":Ljava/util/Properties;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    if-eqz v1, :cond_0

    .line 137
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getConOptions()Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    move-result-object v1

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->getDebug()Ljava/util/Properties;

    move-result-object v0

    .line 138
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "dumpConOptions"

    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->clientID:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " : Connect Options"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    :cond_0
    return-void
.end method

.method protected dumpMemoryTrace()V
    .locals 1

    .prologue
    .line 85
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    invoke-interface {v0}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->dumpTrace()V

    .line 86
    return-void
.end method

.method public dumpSystemProperties()V
    .locals 5

    .prologue
    .line 105
    invoke-static {}, Ljava/lang/System;->getProperties()Ljava/util/Properties;

    move-result-object v0

    .line 106
    .local v0, "sysProps":Ljava/util/Properties;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "dumpSystemProperties"

    const-string v4, "SystemProperties"

    invoke-static {v0, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->dumpProperties(Ljava/util/Properties;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    return-void
.end method

.method protected dumpVersion()V
    .locals 5

    .prologue
    const/16 v4, 0x20

    const/16 v3, 0x14

    .line 92
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 93
    .local v0, "vInfo":Ljava/lang/StringBuffer;
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "=============="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Version Info "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "=============="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 94
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Version"

    invoke-static {v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->left(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->VERSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 95
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Build Level"

    invoke-static {v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/util/Debug;->left(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->BUILD_LEVEL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 96
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "=========================================="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->lineSep:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 97
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/util/Debug;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/util/Debug;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "dumpVersion"

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    return-void
.end method
