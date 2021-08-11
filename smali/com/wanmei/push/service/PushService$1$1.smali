.class final Lcom/wanmei/push/service/PushService$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/PushService$1;->a(Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/push/a/a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/wanmei/push/a/a;

.field final synthetic c:Lcom/wanmei/push/service/PushService$1;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService$1;Ljava/lang/String;Lcom/wanmei/push/a/a;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iput-object p2, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/wanmei/push/service/PushService$1$1;->b:Lcom/wanmei/push/a/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailure(Lorg/pwrd/paho/client/mqttv3/IMqttToken;Ljava/lang/Throwable;)V
    .locals 3
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "[ -- App Regist Error -- ]["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p2}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public final onSuccess(Lorg/pwrd/paho/client/mqttv3/IMqttToken;)V
    .locals 4

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-virtual {v1}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1$1;->b:Lcom/wanmei/push/a/a;

    invoke-interface {v0}, Lcom/wanmei/push/a/a;->a()V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "[ -- App Regist Success -- ]["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "], [ AppInfo : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v2, v2, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Lcom/wanmei/push/service/d;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1$1;->c:Lcom/wanmei/push/service/PushService$1;

    iget-object v1, v1, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "[ -- App Regist Error -- ]["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/PushService$1$1;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
