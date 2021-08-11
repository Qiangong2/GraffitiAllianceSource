.class public Lorg/pwrd/paho/client/mqttv3/TimerPingSender;
.super Ljava/lang/Object;
.source "TimerPingSender.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttPingSender;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;
    }
.end annotation


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private timer:Ljava/util/Timer;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    const-class v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->CLASS_NAME:Ljava/lang/String;

    .line 35
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0()Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-object v0
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->CLASS_NAME:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;)Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    return-object v0
.end method


# virtual methods
.method public init(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V
    .locals 2
    .param p1, "comms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .prologue
    .line 41
    if-nez p1, :cond_0

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ClientComms cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_0
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 45
    return-void
.end method

.method public schedule(J)V
    .locals 3
    .param p1, "delayInMilliseconds"    # J

    .prologue
    .line 69
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->timer:Ljava/util/Timer;

    new-instance v1, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;-><init>(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;)V

    invoke-virtual {v0, v1, p1, p2}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 70
    return-void
.end method

.method public start()V
    .locals 8

    .prologue
    .line 48
    const-string v1, "start"

    .line 49
    .local v1, "methodName":Ljava/lang/String;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v2

    invoke-interface {v2}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "clientid":Ljava/lang/String;
    sget-object v2, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v3, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->CLASS_NAME:Ljava/lang/String;

    const-string v4, "start"

    const-string v5, "659"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v0, v6, v7

    invoke-interface {v2, v3, v4, v5, v6}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 54
    new-instance v2, Ljava/util/Timer;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "MQTT Ping: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/Timer;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->timer:Ljava/util/Timer;

    .line 56
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->timer:Ljava/util/Timer;

    new-instance v3, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;-><init>(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;)V

    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v4}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getKeepAlive()J

    move-result-wide v4

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 57
    return-void
.end method

.method public stop()V
    .locals 6

    .prologue
    .line 60
    const-string v0, "stop"

    .line 62
    .local v0, "methodName":Ljava/lang/String;
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v2, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->CLASS_NAME:Ljava/lang/String;

    const-string v3, "stop"

    const-string v4, "661"

    const/4 v5, 0x0

    invoke-interface {v1, v2, v3, v4, v5}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 63
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->timer:Ljava/util/Timer;

    if-eqz v1, :cond_0

    .line 64
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->timer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 66
    :cond_0
    return-void
.end method
