.class final Lcom/wanmei/push/service/a;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttPingSender;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/service/a$a;
    }
.end annotation


# instance fields
.field private a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private b:Lcom/wanmei/push/service/PushService;

.field private c:Landroid/content/BroadcastReceiver;

.field private d:Lcom/wanmei/push/service/a;

.field private e:Landroid/app/PendingIntent;

.field private volatile f:Z


# direct methods
.method public constructor <init>(Lcom/wanmei/push/service/PushService;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/push/service/a;->f:Z

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Neither service nor client can be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    iput-object p0, p0, Lcom/wanmei/push/service/a;->d:Lcom/wanmei/push/service/a;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/a;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/a;->d:Lcom/wanmei/push/service/a;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/push/service/a;)Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    return-object v0
.end method

.method static synthetic c(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/PushService;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    return-object v0
.end method


# virtual methods
.method public final init(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V
    .locals 1
    .param p1, "comms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    new-instance v0, Lcom/wanmei/push/service/a$a;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/a$a;-><init>(Lcom/wanmei/push/service/a;)V

    iput-object v0, p0, Lcom/wanmei/push/service/a;->c:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method public final schedule(J)V
    .locals 7
    .param p1, "delayInMilliseconds"    # J

    .prologue
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    add-long v2, v0, p1

    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Schedule next AlarmPingSender at "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v1, v4}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "alarm"

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    const/4 v1, 0x0

    iget-object v4, p0, Lcom/wanmei/push/service/a;->e:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    return-void
.end method

.method public final start()V
    .locals 5

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "perfectPush.pingSender."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Register AlarmPingSenderReceiver to PushService "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    iget-object v2, p0, Lcom/wanmei/push/service/a;->c:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3, v0}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Lcom/wanmei/push/service/PushService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    iget-object v1, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const/4 v2, 0x0

    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/high16 v0, 0x8000000

    invoke-static {v1, v2, v3, v0}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/service/a;->e:Landroid/app/PendingIntent;

    iget-object v0, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getKeepAlive()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/wanmei/push/service/a;->schedule(J)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wanmei/push/service/a;->f:Z

    return-void
.end method

.method public final stop()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "alarm"

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/wanmei/push/service/a;->e:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unregister AlarmPingSenderReceiver to PushService "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v3

    invoke-interface {v3}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/wanmei/push/service/a;->f:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/push/service/a;->f:Z

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/a;->b:Lcom/wanmei/push/service/PushService;

    iget-object v1, p0, Lcom/wanmei/push/service/a;->c:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unregister AlarmPingSenderReceiver to PushService "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/a;->a:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v3

    invoke-interface {v3}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " IllegalArgumentException : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
