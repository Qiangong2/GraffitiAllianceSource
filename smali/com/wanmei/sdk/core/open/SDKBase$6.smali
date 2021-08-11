.class Lcom/wanmei/sdk/core/open/SDKBase$6;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->loginSucceed(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;

.field final synthetic val$msg:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->val$msg:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$702(Lcom/wanmei/sdk/core/open/SDKBase;Z)Z

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mLoginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKBase;->getUserId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/open/SDKBase;->getToken()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v3}, Lcom/wanmei/sdk/core/open/SDKBase;->getPassword()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->val$msg:Ljava/lang/String;

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;->succeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase$6;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/open/SDKBase;->getFloatViewPlace()I

    move-result v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKBase;->access$800(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/content/Context;I)V

    return-void
.end method
