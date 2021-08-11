.class Lcom/cqq/test/MainActivity$11$1$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cqq/test/MainActivity$11$1;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/cqq/test/MainActivity$11$1;


# direct methods
.method constructor <init>(Lcom/cqq/test/MainActivity$11$1;)V
    .locals 0
    .param p1, "this$2"    # Lcom/cqq/test/MainActivity$11$1;

    .prologue
    .line 236
    iput-object p1, p0, Lcom/cqq/test/MainActivity$11$1$1;->this$2:Lcom/cqq/test/MainActivity$11$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .locals 1

    .prologue
    .line 240
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 241
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    .line 242
    return-void
.end method
