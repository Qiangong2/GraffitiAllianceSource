.class Lcom/wanmei/sdk/core/open/SDKBase$16;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->commonOrder(Lcom/wanmei/sdk/core/param/OrderParams;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;

.field final synthetic val$orderParams:Lcom/wanmei/sdk/core/param/OrderParams;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/param/OrderParams;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$16;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$16;->val$orderParams:Lcom/wanmei/sdk/core/param/OrderParams;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failed(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "SDKCoreFacade.getInstance().doPay failed: msg: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$16;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->payOneSDKFailed(Ljava/lang/String;)V

    return-void
.end method

.method public succeed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "commonOrderId"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "SDKCoreFacade.getInstance().doPay succeed: commonOrderId: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " msg: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$16;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0, p2}, Lcom/wanmei/sdk/core/open/SDKBase;->access$1102(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)Ljava/lang/String;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$1200()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$16$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$16$1;-><init>(Lcom/wanmei/sdk/core/open/SDKBase$16;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method
