.class final Lcom/wanmei/push/service/a$a$1;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/a$a;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/a$a;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/a$a;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailure(Lorg/pwrd/paho/client/mqttv3/IMqttToken;Ljava/lang/Throwable;)V
    .locals 4

    .prologue
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "AlarmPingSender AlarmReceiver Failure. Release lock("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v2}, Lcom/wanmei/push/service/a$a;->a(Lcom/wanmei/push/service/a$a;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "):"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    :cond_0
    return-void
.end method

.method public final onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V
    .locals 4

    .prologue
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "AlarmPingSender AlarmReceiver Success. Release lock("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v2}, Lcom/wanmei/push/service/a$a;->a(Lcom/wanmei/push/service/a$a;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "):"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/a$a$1;->a:Lcom/wanmei/push/service/a$a;

    invoke-static {v0}, Lcom/wanmei/push/service/a$a;->b(Lcom/wanmei/push/service/a$a;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    :cond_0
    return-void
.end method
