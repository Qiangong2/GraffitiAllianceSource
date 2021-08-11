.class public Lcom/wanmei/sdk/core/task/LoginTask;
.super Lcom/wanmei/sdk/core/task/a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;,
        Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wanmei/sdk/core/task/a",
        "<",
        "Lcom/wanmei/sdk/core/bean/LoginResp;",
        ">;"
    }
.end annotation


# instance fields
.field private c:Lcom/wanmei/sdk/core/param/BaseLoginParams;

.field private d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

.field private e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseLoginParams;Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "params"    # Lcom/wanmei/sdk/core/param/BaseLoginParams;
    .param p3, "callBack"    # Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/net/DownloadParams;->b()Ljava/lang/String;

    move-result-object v0

    const-class v1, Lcom/wanmei/sdk/core/bean/LoginResp;

    const-string v2, "\u9a8c\u8bc1\u4e2d\uff0c\u8bf7\u7a0d\u5019..."

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/wanmei/sdk/core/task/a;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    iput-object p2, p0, Lcom/wanmei/sdk/core/task/LoginTask;->c:Lcom/wanmei/sdk/core/param/BaseLoginParams;

    iput-object p3, p0, Lcom/wanmei/sdk/core/task/LoginTask;->e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    return-void
.end method


# virtual methods
.method protected a(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 3

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->a:Landroid/app/Activity;

    const-string v1, "\u767b\u5f55\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

    const/16 v2, -0x14

    invoke-static {v0, v1, v2}, Lcom/wanmei/sdk/core/util/Toast;->makeToastOneSDKError(Landroid/content/Context;Ljava/lang/String;I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    const/4 v1, 0x1

    const-string v2, "\u5f02\u5e38\u4fe1\u606f"

    invoke-interface {v0, v1, v2}, Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;->onLoginResult(ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    invoke-virtual {p1}, Lcom/pwrd/android/volley/VolleyError;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Lcom/wanmei/sdk/core/bean/LoginResp;)V
    .locals 3

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getCode()I

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getUid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/Account;->setUserId(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/Account;->setToken(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getPassord()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/Account;->setPassword(Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getCode()I

    move-result v1

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getMsg()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;->onLoginResult(ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getCode()I

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getMsg()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;->succeed(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/LoginResp;->getMsg()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/wanmei/sdk/core/bean/LoginResp;

    invoke-virtual {p0, p1}, Lcom/wanmei/sdk/core/task/LoginTask;->a(Lcom/wanmei/sdk/core/bean/LoginResp;)V

    return-void
.end method

.method protected a(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->d:Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;

    const/4 v1, 0x1

    invoke-interface {v0, v1, p1}, Lcom/wanmei/sdk/core/task/LoginTask$LoginListener;->onLoginResult(ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/LoginTask;->e:Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    invoke-interface {v0, p1}, Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public synthetic d()Lcom/wanmei/sdk/core/bean/CommReq;
    .locals 1

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/task/LoginTask;->e()Lcom/wanmei/sdk/core/bean/LoginReq;

    move-result-object v0

    return-object v0
.end method

.method public e()Lcom/wanmei/sdk/core/bean/LoginReq;
    .locals 2

    new-instance v0, Lcom/wanmei/sdk/core/bean/LoginReq;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/bean/LoginReq;-><init>()V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/LoginTask;->c:Lcom/wanmei/sdk/core/param/BaseLoginParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseLoginParams;->getChannelUid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/LoginReq;->setPlatUid(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/LoginTask;->c:Lcom/wanmei/sdk/core/param/BaseLoginParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseLoginParams;->getChannelToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/LoginReq;->setPlatToken(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/LoginTask;->c:Lcom/wanmei/sdk/core/param/BaseLoginParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseLoginParams;->getExtraParams()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/LoginReq;->setExtraMap(Ljava/util/HashMap;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getLoginSchemeVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/LoginReq;->setLoginSchemeVersion(Ljava/lang/String;)V

    return-object v0
.end method
