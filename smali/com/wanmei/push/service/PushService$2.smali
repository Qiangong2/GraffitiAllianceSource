.class final Lcom/wanmei/push/service/PushService$2;
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

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$2;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x1

    const-string v0, "networkInfo"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkInfo;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_0
    iget-object v2, p0, Lcom/wanmei/push/service/PushService$2;->a:Lcom/wanmei/push/service/PushService;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Connectivity changed: connected="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$2;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Z)V

    :cond_0
    :goto_1
    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService$a;->a()V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$2;->a:Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService;->a()V

    invoke-static {}, Lcom/wanmei/push/service/PushService;->c()Lcom/wanmei/push/service/PushService$a;

    goto :goto_1
.end method
