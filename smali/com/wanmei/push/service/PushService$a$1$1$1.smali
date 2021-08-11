.class final Lcom/wanmei/push/service/PushService$a$1$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/PushService$a$1$1;->onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/PushService$a$1$1;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService$a$1$1;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailure(Lorg/pwrd/paho/client/mqttv3/IMqttToken;Ljava/lang/Throwable;)V
    .locals 4
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PushService MQTTConnection subscribeToTopic onFailure. topics : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/wanmei/push/service/b;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->i(Lcom/wanmei/push/service/PushService;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->j(Lcom/wanmei/push/service/PushService;)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wanmei/push/service/PushService;->a(J)V

    :cond_0
    return-void
.end method

.method public final onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V
    .locals 4

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;J)J

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->e(Lcom/wanmei/push/service/PushService;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->f(Lcom/wanmei/push/service/PushService;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Connection established to "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on topics "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/wanmei/push/service/b;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->g(Lcom/wanmei/push/service/PushService;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->h(Lcom/wanmei/push/service/PushService;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1$1;->a:Lcom/wanmei/push/service/PushService$a$1$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "android.intent.action.PERFECT_PUSH_STATUS_START_SUCCESS"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    return-void
.end method
