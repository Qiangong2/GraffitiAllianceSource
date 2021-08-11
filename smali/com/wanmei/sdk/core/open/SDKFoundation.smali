.class public Lcom/wanmei/sdk/core/open/SDKFoundation;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;
    .param p4, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p4}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;
    .param p2, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p2}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onCreate(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onDestroy(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;Lcom/wanmei/sdk/core/open/SDKInterface$ExitCallBack;)Z
    .locals 1
    .param p1, "actionCode"    # I
    .param p2, "action"    # Landroid/view/KeyEvent;
    .param p3, "exitCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$ExitCallBack;

    .prologue
    invoke-interface {p3}, Lcom/wanmei/sdk/core/open/SDKInterface$ExitCallBack;->onGameHasExitView()V

    const/4 v0, 0x0

    return v0
.end method

.method public onNewIntent(Landroid/content/Intent;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p2}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onPause(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onRelease(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onRestart(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Bundle;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p2}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onResume(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "outState"    # Landroid/os/Bundle;
    .param p2, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p2}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onStart(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method public onStop(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method
