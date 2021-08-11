.class Lcom/wanmei/sdk/core/open/SDKBase$4;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->doLogin(Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;

.field final synthetic val$loginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->val$loginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->val$loginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "loginCallBack is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->val$loginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    iput-object v1, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mLoginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$000(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$600(Lcom/wanmei/sdk/core/open/SDKBase;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$4;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->doLoginImpl()V

    :cond_1
    return-void
.end method
