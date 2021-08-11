.class Lcom/wanmei/sdk/core/open/SDKBase$20;
.super Ljava/util/TimerTask;


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

.field final synthetic val$dialog:Landroid/app/Dialog;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/app/Dialog;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$20;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase$20;->val$dialog:Landroid/app/Dialog;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$20$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$20$1;-><init>(Lcom/wanmei/sdk/core/open/SDKBase$20;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method
