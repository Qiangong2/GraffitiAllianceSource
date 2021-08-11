.class public Lcom/wanmei/sdk/core/open/SDKCoreFacade;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/Proguard;


# static fields
.field private static volatile INSTANCE:Lcom/wanmei/sdk/core/open/SDKCoreFacade; = null

.field public static final PLATFORM:I = 0x1


# instance fields
.field private sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCore;->getInstance()Lcom/wanmei/sdk/core/open/SDKCore;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    return-void
.end method

.method public static getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKCore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public doPay(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "orderParams"    # Lcom/wanmei/sdk/core/param/BaseOrderParams;
    .param p3, "listener"    # Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0, p1, p2, p3}, Lcom/wanmei/sdk/core/open/SDKCore;->doPay(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V

    return-void
.end method

.method public getAccount()Lcom/wanmei/sdk/core/bean/Account;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    return-object v0
.end method

.method public getAppId()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getAppId()I

    move-result v0

    return v0
.end method

.method public getAppKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getAppKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getChannelConfig(Landroid/content/Context;ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "channelId"    # I
    .param p3, "readChannelCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    .prologue
    new-instance v0, Lcom/wanmei/sdk/core/config/ChannelsReader;

    invoke-direct {v0, p1}, Lcom/wanmei/sdk/core/config/ChannelsReader;-><init>(Landroid/content/Context;)V

    if-eqz p3, :cond_0

    invoke-virtual {v0, p2, p3}, Lcom/wanmei/sdk/core/config/ChannelsReader;->getChannel(ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V

    :cond_0
    return-void
.end method

.method public getChannelId()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getChannelId()I

    move-result v0

    return v0
.end method

.method public getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v0

    return-object v0
.end method

.method public getLoginSchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getLoginSchemeVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMode()Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/net/DownloadParams;->d()Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    move-result-object v0

    return-object v0
.end method

.method public getPaySchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCore;->getPaySchemeVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPushDeviceId(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    invoke-static {p1}, Lcom/wanmei/push/PushAgent;->getInstance(Landroid/content/Context;)Lcom/wanmei/push/PushAgent;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/PushAgent;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public init(Landroid/content/Context;ILjava/lang/String;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appId"    # I
    .param p3, "appKey"    # Ljava/lang/String;
    .param p4, "channelId"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/wanmei/sdk/core/open/SDKCore;->init(Landroid/content/Context;ILjava/lang/String;I)V

    return-void
.end method

.method public isDebug()Z
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/util/LogUtil;->isLOG()Z

    move-result v0

    return v0
.end method

.method public loginCommonSDK(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseLoginParams;Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "loginParams"    # Lcom/wanmei/sdk/core/param/BaseLoginParams;
    .param p3, "listener"    # Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0, p1, p2, p3}, Lcom/wanmei/sdk/core/open/SDKCore;->loginCommonSDK(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseLoginParams;Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;)V

    return-void
.end method

.method public setDebug(Z)V
    .locals 0
    .param p1, "log"    # Z

    .prologue
    invoke-static {p1}, Lcom/wanmei/sdk/core/util/LogUtil;->setLOG(Z)V

    return-void
.end method

.method public setLoginSchemeVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "loginSchemeVersion"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/open/SDKCore;->setLoginSchemeVersion(Ljava/lang/String;)V

    return-void
.end method

.method public setMode(Lcom/wanmei/sdk/core/net/DownloadParams$Mode;)V
    .locals 0
    .param p1, "mode"    # Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    .prologue
    invoke-static {p1}, Lcom/wanmei/sdk/core/net/DownloadParams;->a(Lcom/wanmei/sdk/core/net/DownloadParams$Mode;)V

    return-void
.end method

.method public setPaySchemeVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "paySchemeVersion"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->sdkCore:Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/open/SDKCore;->setPaySchemeVersion(Ljava/lang/String;)V

    return-void
.end method
