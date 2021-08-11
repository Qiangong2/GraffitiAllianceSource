.class Lcom/wanmei/sdk/core/open/SDKBase$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->init(ILjava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;

.field final synthetic val$initCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$1;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$1;->val$initCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$1;->val$initCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "initCallBack is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$1;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->INIT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->access$000(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;)Z

    move-result v0

    if-nez v0, :cond_1

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$1;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$100(Lcom/wanmei/sdk/core/open/SDKBase;)V

    goto :goto_0
.end method
