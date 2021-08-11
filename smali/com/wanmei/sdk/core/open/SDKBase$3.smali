.class Lcom/wanmei/sdk/core/open/SDKBase$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->notifyInitResult()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$300(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$400(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$500(Lcom/wanmei/sdk/core/open/SDKBase;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;->initSucceed(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$300(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$400(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_0

    :cond_2
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$3;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$500(Lcom/wanmei/sdk/core/open/SDKBase;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;->initFailed(Ljava/lang/String;)V

    goto :goto_0
.end method
