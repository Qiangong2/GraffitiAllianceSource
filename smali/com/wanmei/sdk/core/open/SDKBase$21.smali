.class Lcom/wanmei/sdk/core/open/SDKBase$21;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->tryFlash()V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$21;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string v1, "flash failed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$21;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$1400(Lcom/wanmei/sdk/core/open/SDKBase;)V

    return-void
.end method
