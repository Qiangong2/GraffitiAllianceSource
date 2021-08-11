.class Lcom/cqq/test/MainActivity$11$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cqq/test/MainActivity$11;->onGameHasExitView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/cqq/test/MainActivity$11;


# direct methods
.method constructor <init>(Lcom/cqq/test/MainActivity$11;)V
    .locals 0
    .param p1, "this$1"    # Lcom/cqq/test/MainActivity$11;

    .prologue
    .line 231
    iput-object p1, p0, Lcom/cqq/test/MainActivity$11$1;->this$1:Lcom/cqq/test/MainActivity$11;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 236
    iget-object v0, p0, Lcom/cqq/test/MainActivity$11$1;->this$1:Lcom/cqq/test/MainActivity$11;

    iget-object v0, v0, Lcom/cqq/test/MainActivity$11;->this$0:Lcom/cqq/test/MainActivity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$11$1$1;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$11$1$1;-><init>(Lcom/cqq/test/MainActivity$11$1;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onRelease(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 244
    return-void
.end method
