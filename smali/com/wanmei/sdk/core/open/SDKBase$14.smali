.class Lcom/wanmei/sdk/core/open/SDKBase$14;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->payCancelled(Ljava/lang/String;)V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$14;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$14;->val$msg:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$14;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase;->mPayCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;

    const-string v1, ""

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase$14;->val$msg:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;->cancelled(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
