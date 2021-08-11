.class Lcom/cqq/test/MainActivity$11;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$ExitCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cqq/test/MainActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/cqq/test/MainActivity;


# direct methods
.method constructor <init>(Lcom/cqq/test/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/cqq/test/MainActivity;

    .prologue
    .line 220
    iput-object p1, p0, Lcom/cqq/test/MainActivity$11;->this$0:Lcom/cqq/test/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChannelHasExitView()V
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/cqq/test/MainActivity$11;->this$0:Lcom/cqq/test/MainActivity;

    invoke-virtual {v0}, Lcom/cqq/test/MainActivity;->finish()V

    .line 266
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    .line 267
    return-void
.end method

.method public onGameHasExitView()V
    .locals 4

    .prologue
    .line 228
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/cqq/test/MainActivity$11;->this$0:Lcom/cqq/test/MainActivity;

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 229
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const-string v1, "\u662f\u5426\u9000\u51fa\u6e38\u620f"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 230
    const/4 v1, -0x1

    const-string v2, "\u9000\u51fa"

    new-instance v3, Lcom/cqq/test/MainActivity$11$1;

    invoke-direct {v3, p0}, Lcom/cqq/test/MainActivity$11$1;-><init>(Lcom/cqq/test/MainActivity$11;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 246
    const/4 v1, -0x2

    const-string v2, "\u53d6\u6d88"

    new-instance v3, Lcom/cqq/test/MainActivity$11$2;

    invoke-direct {v3, p0}, Lcom/cqq/test/MainActivity$11$2;-><init>(Lcom/cqq/test/MainActivity$11;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 256
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 257
    return-void
.end method
