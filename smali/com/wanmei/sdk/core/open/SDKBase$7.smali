.class Lcom/wanmei/sdk/core/open/SDKBase$7;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->loginFailed(Ljava/lang/String;)V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$7;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$7;->val$msg:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$7;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKBase;->getChannelName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "\u767b\u5f55\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

    const/16 v3, -0x28

    invoke-static {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/util/Toast;->makeToastChannelError(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$7;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mLoginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$7;->val$msg:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;->failed(Ljava/lang/String;)V

    return-void
.end method
