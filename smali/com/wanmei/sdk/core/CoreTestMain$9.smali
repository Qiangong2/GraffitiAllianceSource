.class Lcom/wanmei/sdk/core/CoreTestMain$9;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/CoreTestMain;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/CoreTestMain;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/CoreTestMain;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/CoreTestMain$9;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initFailed(Ljava/lang/String;)V
    .locals 3
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    const-string v0, "CoreTestMain"

    const-string v1, "initFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain$9;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-static {v0}, Lcom/wanmei/sdk/core/CoreTestMain;->c(Lcom/wanmei/sdk/core/CoreTestMain;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "initFailed, reason:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method public initSucceed(Ljava/lang/String;)V
    .locals 3
    .param p1, "extraJson"    # Ljava/lang/String;

    .prologue
    const-string v0, "CoreTestMain"

    const-string v1, "initSucceed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain$9;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-static {v0}, Lcom/wanmei/sdk/core/CoreTestMain;->c(Lcom/wanmei/sdk/core/CoreTestMain;)Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "initSucceed, extraJson:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    return-void
.end method
