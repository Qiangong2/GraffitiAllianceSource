.class public Lcom/cqq/test/MainActivity;
.super Lcom/unity3d/player/UnityPlayerActivity;
.source "MainActivity.java"


# instance fields
.field _ap:Lplugins/AmapPlugin;

.field _clip:Lplugins/ClipboardPlugin;

.field _cos:Lplugins/CosSdkPlugin;

.field _gvp:Lplugins/GVoicePlugin;

.field _osp:Lplugins/OneSdkPlugin;

.field private isOpenKeyCode:Z

.field private onHomeIntent:Landroid/content/Intent;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/unity3d/player/UnityPlayerActivity;-><init>()V

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/cqq/test/MainActivity;->isOpenKeyCode:Z

    .line 33
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_ap:Lplugins/AmapPlugin;

    return-void
.end method


# virtual methods
.method public GetAmap()Lplugins/AmapPlugin;
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_ap:Lplugins/AmapPlugin;

    if-nez v0, :cond_0

    .line 36
    new-instance v0, Lplugins/AmapPlugin;

    invoke-direct {v0}, Lplugins/AmapPlugin;-><init>()V

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_ap:Lplugins/AmapPlugin;

    .line 37
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_ap:Lplugins/AmapPlugin;

    invoke-virtual {p0}, Lcom/cqq/test/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lplugins/AmapPlugin;->LocationInit(Landroid/content/Context;Landroid/app/Activity;)V

    .line 40
    :cond_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_ap:Lplugins/AmapPlugin;

    return-object v0
.end method

.method public GetClipboard()Lplugins/ClipboardPlugin;
    .locals 2

    .prologue
    .line 75
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_clip:Lplugins/ClipboardPlugin;

    if-nez v0, :cond_0

    .line 76
    new-instance v0, Lplugins/ClipboardPlugin;

    invoke-direct {v0}, Lplugins/ClipboardPlugin;-><init>()V

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_clip:Lplugins/ClipboardPlugin;

    .line 77
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_clip:Lplugins/ClipboardPlugin;

    invoke-virtual {p0}, Lcom/cqq/test/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lplugins/ClipboardPlugin;->Init(Landroid/content/Context;Landroid/app/Activity;)V

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_clip:Lplugins/ClipboardPlugin;

    return-object v0
.end method

.method public GetCosSdk()Lplugins/CosSdkPlugin;
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    if-nez v0, :cond_0

    .line 67
    new-instance v0, Lplugins/CosSdkPlugin;

    invoke-direct {v0}, Lplugins/CosSdkPlugin;-><init>()V

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    .line 68
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    invoke-virtual {p0}, Lcom/cqq/test/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lplugins/CosSdkPlugin;->Init(Landroid/content/Context;Landroid/app/Activity;)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    return-object v0
.end method

.method public GetGvoice()Lplugins/GVoicePlugin;
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_gvp:Lplugins/GVoicePlugin;

    if-nez v0, :cond_0

    .line 47
    new-instance v0, Lplugins/GVoicePlugin;

    invoke-direct {v0}, Lplugins/GVoicePlugin;-><init>()V

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_gvp:Lplugins/GVoicePlugin;

    .line 48
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_gvp:Lplugins/GVoicePlugin;

    invoke-virtual {p0}, Lcom/cqq/test/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lplugins/GVoicePlugin;->VoiceInit(Landroid/content/Context;Landroid/app/Activity;)V

    .line 50
    :cond_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_gvp:Lplugins/GVoicePlugin;

    return-object v0
.end method

.method public GetOneSdk()Lplugins/OneSdkPlugin;
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_osp:Lplugins/OneSdkPlugin;

    if-nez v0, :cond_0

    .line 57
    new-instance v0, Lplugins/OneSdkPlugin;

    invoke-direct {v0}, Lplugins/OneSdkPlugin;-><init>()V

    iput-object v0, p0, Lcom/cqq/test/MainActivity;->_osp:Lplugins/OneSdkPlugin;

    .line 58
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_osp:Lplugins/OneSdkPlugin;

    invoke-virtual {p0}, Lcom/cqq/test/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lplugins/OneSdkPlugin;->OneSdkInit(Landroid/content/Context;Landroid/app/Activity;)V

    .line 59
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/cqq/test/MainActivity;->isOpenKeyCode:Z

    .line 61
    :cond_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_osp:Lplugins/OneSdkPlugin;

    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 275
    invoke-super {p0, p1, p2, p3}, Lcom/unity3d/player/UnityPlayerActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 277
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$12;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$12;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onActivityResult(IILandroid/content/Intent;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 285
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 286
    packed-switch p1, :pswitch_data_0

    .line 300
    const-string v0, "cqq_log"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "result:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " request: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 304
    :cond_0
    :goto_0
    return-void

    .line 288
    :pswitch_0
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lplugins/CosSdkPlugin;->selectImageResult(Landroid/net/Uri;I)V

    goto :goto_0

    .line 291
    :pswitch_1
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lplugins/CosSdkPlugin;->selectImageResult(Landroid/net/Uri;I)V

    goto :goto_0

    .line 294
    :pswitch_2
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lplugins/CosSdkPlugin;->cropImageResult(Landroid/os/Bundle;I)V

    goto :goto_0

    .line 297
    :pswitch_3
    iget-object v0, p0, Lcom/cqq/test/MainActivity;->_cos:Lplugins/CosSdkPlugin;

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lplugins/CosSdkPlugin;->cropImageResult(Landroid/os/Bundle;I)V

    goto :goto_0

    .line 286
    :pswitch_data_0
    .packed-switch 0xfaa
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 163
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 165
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$7;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$7;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onConfigurationChanged(Landroid/content/res/Configuration;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 171
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 86
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onCreate(Landroid/os/Bundle;)V

    .line 88
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$1;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$1;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onCreate(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 95
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 201
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onDestroy()V

    .line 203
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$10;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$10;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onDestroy(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 210
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x0

    .line 214
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 215
    iget-boolean v1, p0, Lcom/cqq/test/MainActivity;->isOpenKeyCode:Z

    if-nez v1, :cond_1

    .line 270
    :cond_0
    :goto_0
    return v0

    .line 220
    :cond_1
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$11;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$11;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, p2, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onKeyDown(ILandroid/view/KeyEvent;Lcom/wanmei/sdk/core/open/SDKInterface$ExitCallBack;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 310
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 312
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$13;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$13;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onNewIntent(Landroid/content/Intent;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 320
    iput-object p1, p0, Lcom/cqq/test/MainActivity;->onHomeIntent:Landroid/content/Intent;

    .line 321
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onPause()V

    .line 114
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$3;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$3;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onPause(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 120
    return-void
.end method

.method protected onRestart()V
    .locals 2

    .prologue
    .line 176
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onRestart()V

    .line 178
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$8;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$8;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onRestart(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 185
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 151
    invoke-super {p0, p1}, Lcom/unity3d/player/UnityPlayerActivity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 153
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$6;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$6;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onRestoreInstanceState(Landroid/os/Bundle;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 159
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 124
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onResume()V

    .line 126
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$4;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$4;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onResume(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 132
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 141
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$5;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$5;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, p1, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onSaveInstanceState(Landroid/os/Bundle;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 147
    return-void
.end method

.method protected onStart()V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onStart()V

    .line 101
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$2;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$2;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onStart(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 108
    return-void
.end method

.method protected onStop()V
    .locals 2

    .prologue
    .line 189
    invoke-super {p0}, Lcom/unity3d/player/UnityPlayerActivity;->onStop()V

    .line 191
    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/cqq/test/MainActivity$9;

    invoke-direct {v1, p0}, Lcom/cqq/test/MainActivity$9;-><init>(Lcom/cqq/test/MainActivity;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->onStop(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 197
    return-void
.end method
