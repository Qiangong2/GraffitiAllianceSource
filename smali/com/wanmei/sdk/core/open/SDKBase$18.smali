.class Lcom/wanmei/sdk/core/open/SDKBase$18;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->logoutSucceed()V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$18;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$18;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$702(Lcom/wanmei/sdk/core/open/SDKBase;Z)Z

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$18;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mLogoutCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

    invoke-interface {v0}, Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;->succeed()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$18;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$1300(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/content/Context;)V

    return-void
.end method
