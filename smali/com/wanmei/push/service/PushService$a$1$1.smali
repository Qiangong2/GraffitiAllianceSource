.class final Lcom/wanmei/push/service/PushService$a$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/PushService$a$1;->onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/PushService$a$1;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService$a$1;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailure(Lorg/pwrd/paho/client/mqttv3/IMqttToken;Ljava/lang/Throwable;)V
    .locals 4
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PushService MQTTConnection subscribeToTopic onFailure. topic : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/b;->a(Landroid/content/Context;)Ljava/lang/String;

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

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->i(Lcom/wanmei/push/service/PushService;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

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
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Connection established to "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " on topic "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/b;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a$1;->b:Ljava/lang/String;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/service/PushService$a$1$1$1;

    invoke-direct {v2, p0}, Lcom/wanmei/push/service/PushService$a$1$1$1;-><init>(Lcom/wanmei/push/service/PushService$a$1$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/push/service/PushService$a;->a(Ljava/util/List;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    move-object v1, v0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v2, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v0, "MqttException: "

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->i(Lcom/wanmei/push/service/PushService;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a$1$1;->a:Lcom/wanmei/push/service/PushService$a$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a$1;->c:Lcom/wanmei/push/service/PushService$a;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->j(Lcom/wanmei/push/service/PushService;)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/wanmei/push/service/PushService;->a(J)V

    goto :goto_0

    :cond_1
    const-string v0, "NULL"

    goto :goto_1
.end method
