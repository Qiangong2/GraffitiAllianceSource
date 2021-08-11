.class Lcom/wanmei/sdk/core/ui/floatview/FloatViewService$1;
.super Landroid/content/BroadcastReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService$1;->a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "myIntent"    # Landroid/content/Intent;

    .prologue
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService$1;->a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->a(Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;)Lcom/wanmei/sdk/core/ui/floatview/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Landroid/content/Context;)V

    :cond_0
    return-void
.end method
