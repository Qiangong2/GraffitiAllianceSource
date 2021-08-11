.class Lcom/wanmei/sdk/core/open/SDKBase$16$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase$16;->succeed(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wanmei/sdk/core/open/SDKBase$16;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase$16;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$16$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$16;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$16$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$16;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase$16;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase$16$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$16;

    iget-object v1, v1, Lcom/wanmei/sdk/core/open/SDKBase$16;->val$orderParams:Lcom/wanmei/sdk/core/param/OrderParams;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->doPayImpl(Lcom/wanmei/sdk/core/param/OrderParams;)V

    return-void
.end method
