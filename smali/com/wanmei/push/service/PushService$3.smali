.class final Lcom/wanmei/push/service/PushService$3;
.super Landroid/content/BroadcastReceiver;


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

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const-string v0, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

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

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-static {p2}, Lcom/wanmei/push/g/e;->a(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1, v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Lcom/wanmei/push/bean/AppInfo;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "PushService PackageRemovedReceiver : ["

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p2}, Lcom/wanmei/push/g/e;->a(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "] Has Removed"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    const/4 v0, 0x1

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_0
    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/wanmei/push/service/d;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_2
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$3;->a:Lcom/wanmei/push/service/PushService;

    const-string v2, "PushService PackageRemovedReceiver Error."

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    :cond_2
    move v0, v1

    goto :goto_1
.end method
