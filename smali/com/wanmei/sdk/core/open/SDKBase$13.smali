.class Lcom/wanmei/sdk/core/open/SDKBase$13;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->payOneSDKFailed(Ljava/lang/String;)V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$13;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$13;->val$msg:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "\u672c\u6b21\u652f\u4ed8\u6ca1\u6709\u6210\u529f\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

    const/16 v2, -0x1e

    invoke-static {v0, v1, v2}, Lcom/wanmei/sdk/core/util/Toast;->makeToastOneSDKError(Landroid/content/Context;Ljava/lang/String;I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$13;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mPayCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;

    const-string v1, ""

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase$13;->val$msg:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;->failed(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
