.class final Lcom/wanmei/push/service/a$a;
.super Landroid/content/BroadcastReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/a;

.field private b:Landroid/os/PowerManager$WakeLock;

.field private c:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/a;)V
    .locals 2

    iput-object p1, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "perfectPush.client."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-static {v1}, Lcom/wanmei/push/service/a;->a(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/a;

    move-result-object v1

    invoke-static {v1}, Lcom/wanmei/push/service/a;->b(Lcom/wanmei/push/service/a;)Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    move-result-object v1

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/service/a$a;->c:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/a$a;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->c:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->b:Landroid/os/PowerManager$WakeLock;

    return-object v0
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const-string v0, "android.intent.extra.ALARM_COUNT"

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iget-object v1, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-static {v1}, Lcom/wanmei/push/service/a;->c(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/PushService;

    move-result-object v1

    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "AlarmPingSender AlarmReceiver Ping "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " times."

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-static {v0}, Lcom/wanmei/push/service/a;->c(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/PushService;

    move-result-object v0

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "AlarmPingSender AlarmReceiver Check time : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-static {v0}, Lcom/wanmei/push/service/a;->b(Lcom/wanmei/push/service/a;)Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    move-result-object v0

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->checkForActivity()Lorg/pwrd/paho/client/mqttv3/MqttToken;

    move-result-object v1

    if-nez v1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->b:Landroid/os/PowerManager$WakeLock;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->a:Lcom/wanmei/push/service/a;

    invoke-static {v0}, Lcom/wanmei/push/service/a;->c(Lcom/wanmei/push/service/a;)Lcom/wanmei/push/service/PushService;

    move-result-object v0

    const-string v2, "power"

    invoke-virtual {v0, v2}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/wanmei/push/service/a$a;->c:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/service/a$a;->b:Landroid/os/PowerManager$WakeLock;

    :cond_1
    iget-object v0, p0, Lcom/wanmei/push/service/a$a;->b:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    new-instance v0, Lcom/wanmei/push/service/a$a$1;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/a$a$1;-><init>(Lcom/wanmei/push/service/a$a;)V

    invoke-interface {v1, v0}, Lorg/pwrd/paho/client/mqttv3/IMqttToken;->setActionCallback(Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    goto :goto_0
.end method
