.class Lcom/wanmei/sdk/core/open/SDKBase$20$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase$20;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wanmei/sdk/core/open/SDKBase$20;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase$20;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$20$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$20;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$20$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$20;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase$20;->val$dialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string v1, "flash finished"

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->v(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$20$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$20;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase$20;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$400(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$20$1;->this$1:Lcom/wanmei/sdk/core/open/SDKBase$20;

    iget-object v0, v0, Lcom/wanmei/sdk/core/open/SDKBase$20;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->access$1400(Lcom/wanmei/sdk/core/open/SDKBase;)V

    :cond_0
    return-void
.end method
