.class public Lcom/wanmei/sdk/core/task/PayTask;
.super Lcom/wanmei/sdk/core/task/a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;,
        Lcom/wanmei/sdk/core/task/PayTask$PayListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wanmei/sdk/core/task/a",
        "<",
        "Lcom/wanmei/sdk/core/bean/PayResp;",
        ">;"
    }
.end annotation


# instance fields
.field private c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

.field private d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

.field private e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "params"    # Lcom/wanmei/sdk/core/param/BaseOrderParams;
    .param p3, "listener"    # Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/net/DownloadParams;->c()Ljava/lang/String;

    move-result-object v0

    const-class v1, Lcom/wanmei/sdk/core/bean/PayResp;

    const-string v2, "\u4e0b\u5355\u4e2d\uff0c\u8bf7\u7a0d\u5019..."

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/wanmei/sdk/core/task/a;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    iput-object p2, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    iput-object p3, p0, Lcom/wanmei/sdk/core/task/PayTask;->d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    return-void
.end method


# virtual methods
.method protected a(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->a:Landroid/app/Activity;

    const-string v1, "\u652f\u4ed8\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

    const/16 v2, -0x1e

    invoke-static {v0, v1, v2}, Lcom/wanmei/sdk/core/util/Toast;->makeToastOneSDKError(Landroid/content/Context;Ljava/lang/String;I)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/OrderInfo;->setOrderId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    const/4 v1, 0x1

    const-string v2, "\u5f02\u5e38\u4fe1\u606f"

    const-string v3, ""

    invoke-interface {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/task/PayTask$PayListener;->onPayResult(ILjava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    invoke-virtual {p1}, Lcom/pwrd/android/volley/VolleyError;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Lcom/wanmei/sdk/core/bean/PayResp;)V
    .locals 4

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/OrderInfo;->setOrderId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getCode()I

    move-result v1

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getMsg()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-interface {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/task/PayTask$PayListener;->onPayResult(ILjava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :pswitch_0
    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getOrderId()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/wanmei/sdk/core/bean/OrderInfo;->setOrderId(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getCode()I

    move-result v2

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getMsg()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3, v0}, Lcom/wanmei/sdk/core/task/PayTask$PayListener;->onPayResult(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getMsg()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;->succeed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    invoke-virtual {p1}, Lcom/wanmei/sdk/core/bean/PayResp;->getMsg()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method protected bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/wanmei/sdk/core/bean/PayResp;

    invoke-virtual {p0, p1}, Lcom/wanmei/sdk/core/task/PayTask;->a(Lcom/wanmei/sdk/core/bean/PayResp;)V

    return-void
.end method

.method protected a(Ljava/lang/String;)V
    .locals 4

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/OrderInfo;->setOrderId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->e:Lcom/wanmei/sdk/core/task/PayTask$PayListener;

    const/4 v1, 0x1

    const-string v2, "\u5f02\u5e38\u4fe1\u606f"

    const-string v3, ""

    invoke-interface {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/task/PayTask$PayListener;->onPayResult(ILjava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/PayTask;->d:Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    invoke-interface {v0, p1}, Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;->failed(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public d()Lcom/wanmei/sdk/core/bean/CommReq;
    .locals 4

    new-instance v0, Lcom/wanmei/sdk/core/bean/PayReq;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/bean/PayReq;-><init>()V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getPrice()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setAmount(I)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getOrderNum()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setAppOrder(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getExt()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setExt(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/bean/Account;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setUid(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getServerId()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setServerId(I)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getPaySchemeVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setPaySchemeVersion(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getExtraParams()Ljava/util/HashMap;

    move-result-object v1

    const-string v2, "productName"

    iget-object v3, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v3}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getProductName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "productDesc"

    iget-object v3, p0, Lcom/wanmei/sdk/core/task/PayTask;->c:Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v3}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getProductDesc()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/bean/PayReq;->setExtraMap(Ljava/util/HashMap;)V

    return-object v0
.end method
