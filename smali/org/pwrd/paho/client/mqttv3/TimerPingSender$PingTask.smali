.class Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;
.super Ljava/util/TimerTask;
.source "TimerPingSender.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pwrd/paho/client/mqttv3/TimerPingSender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PingTask"
.end annotation


# static fields
.field private static final methodName:Ljava/lang/String; = "PingTask.run"


# instance fields
.field final synthetic this$0:Lorg/pwrd/paho/client/mqttv3/TimerPingSender;


# direct methods
.method private constructor <init>(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;->this$0:Lorg/pwrd/paho/client/mqttv3/TimerPingSender;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;)V
    .locals 0

    .prologue
    .line 72
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;-><init>(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 77
    invoke-static {}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->access$0()Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    invoke-static {}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->access$1()Ljava/lang/String;

    move-result-object v1

    const-string v2, "PingTask.run"

    const-string v3, "660"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/Long;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-direct {v6, v8, v9}, Ljava/lang/Long;-><init>(J)V

    aput-object v6, v4, v5

    invoke-interface {v0, v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 78
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/TimerPingSender$PingTask;->this$0:Lorg/pwrd/paho/client/mqttv3/TimerPingSender;

    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/TimerPingSender;->access$2(Lorg/pwrd/paho/client/mqttv3/TimerPingSender;)Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    move-result-object v0

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 79
    return-void
.end method
