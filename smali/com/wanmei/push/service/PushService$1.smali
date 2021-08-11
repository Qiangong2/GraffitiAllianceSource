.class final Lcom/wanmei/push/service/PushService$1;
.super Lcom/wanmei/push/a/b$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/PushService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/PushService;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Lcom/wanmei/push/a/b$a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/push/a/a;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_0
    if-nez v1, :cond_1

    new-instance v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-direct {v0}, Lcom/wanmei/push/bean/AppInfo;-><init>()V

    invoke-virtual {v0, p1}, Lcom/wanmei/push/bean/AppInfo;->setAppClientId(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Lcom/wanmei/push/bean/AppInfo;->setPackageName(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/wanmei/push/service/d;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->a(Ljava/lang/String;)V

    :cond_1
    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;)V

    :cond_2
    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    invoke-static {p1, p2}, Lcom/wanmei/push/service/b;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/service/PushService$1$1;

    invoke-direct {v2, p0, p2, p3}, Lcom/wanmei/push/service/PushService$1$1;-><init>(Lcom/wanmei/push/service/PushService$1;Ljava/lang/String;Lcom/wanmei/push/a/a;)V

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/push/service/PushService$a;->b(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_2
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$1;->a:Lcom/wanmei/push/service/PushService;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "[ -- App Regist Error -- ]["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    const/16 v0, 0x65

    invoke-interface {p3, v0}, Lcom/wanmei/push/a/a;->a(I)V

    goto :goto_2

    :cond_3
    move v0, v1

    goto :goto_1
.end method
