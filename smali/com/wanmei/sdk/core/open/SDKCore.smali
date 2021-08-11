.class public Lcom/wanmei/sdk/core/open/SDKCore;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/Proguard;


# static fields
.field private static volatile INSTANCE:Lcom/wanmei/sdk/core/open/SDKCore;

.field private static final TAG:Ljava/lang/String;

.field private static volatile mAccount:Lcom/wanmei/sdk/core/bean/Account;

.field private static volatile mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

.field private static volatile mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/wanmei/sdk/core/open/SDKCore;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCore;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKCore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCore;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKCore;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/open/SDKCore;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCore;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKCore;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private setAndPersistAppInfo(Landroid/content/Context;ILjava/lang/String;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appId"    # I
    .param p3, "appKey"    # Ljava/lang/String;
    .param p4, "channelId"    # I

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKCore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0, p2}, Lcom/wanmei/sdk/core/bean/AppInfo;->setAppId(I)V

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0, p3}, Lcom/wanmei/sdk/core/bean/AppInfo;->setAppKey(Ljava/lang/String;)V

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0, p4}, Lcom/wanmei/sdk/core/bean/AppInfo;->setChannelId(I)V

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public doPay(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "paramMap"    # Lcom/wanmei/sdk/core/param/BaseOrderParams;
    .param p3, "listener"    # Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "no appInfo"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAccount:Lcom/wanmei/sdk/core/bean/Account;

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "no login"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    if-nez p2, :cond_2

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "no orderParams"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    invoke-virtual {p2}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->validate()V

    new-instance v0, Lcom/wanmei/sdk/core/task/PayTask;

    invoke-direct {v0, p1, p2, p3}, Lcom/wanmei/sdk/core/task/PayTask;-><init>(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/task/PayTask;->c()V

    return-void
.end method

.method public getAccount()Lcom/wanmei/sdk/core/bean/Account;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAccount:Lcom/wanmei/sdk/core/bean/Account;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKCore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAccount:Lcom/wanmei/sdk/core/bean/Account;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/bean/Account;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/bean/Account;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAccount:Lcom/wanmei/sdk/core/bean/Account;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAccount:Lcom/wanmei/sdk/core/bean/Account;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getAppId()I
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;->getAppId()I

    move-result v0

    goto :goto_0
.end method

.method public getAppKey()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;->getAppKey()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getChannelId()I
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;->getChannelId()I

    move-result v0

    goto :goto_0
.end method

.method public getCommonOrderId()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/OrderInfo;->getOrderId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/OrderInfo;->getOrderId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKCore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/bean/OrderInfo;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/bean/OrderInfo;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mOrderInfo:Lcom/wanmei/sdk/core/bean/OrderInfo;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getLoginSchemeVersion()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;->getLoginSchemeVersion()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getPaySchemeVersion()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/AppInfo;->getPaySchemeVersion()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public init(Landroid/content/Context;ILjava/lang/String;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appId"    # I
    .param p3, "appKey"    # Ljava/lang/String;
    .param p4, "channelId"    # I

    .prologue
    if-eqz p1, :cond_0

    if-lez p2, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-gtz p4, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "params are wrong"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/wanmei/sdk/core/open/SDKCore;->setAndPersistAppInfo(Landroid/content/Context;ILjava/lang/String;I)V

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/log/manager/LogManager;->init(Landroid/content/Context;)V

    invoke-static {}, Lcom/wanmei/sdk/core/net/DownloadParams;->a()V

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/log/manager/LogManager;->getLogger()Lcom/wanmei/sdk/core/log/manager/a;

    move-result-object v0

    invoke-interface {v0}, Lcom/wanmei/sdk/core/log/manager/a;->a()Z

    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKCore$1;

    invoke-direct {v1, p0, p1, p2, p4}, Lcom/wanmei/sdk/core/open/SDKCore$1;-><init>(Lcom/wanmei/sdk/core/open/SDKCore;Landroid/content/Context;II)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

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
    new-instance v0, Lcom/wanmei/sdk/core/task/LoginTask;

    invoke-direct {v0, p1, p2, p3}, Lcom/wanmei/sdk/core/task/LoginTask;-><init>(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseLoginParams;Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;)V

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/task/LoginTask;->c()V

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
    .locals 2
    .param p1, "loginSchemeVersion"    # Ljava/lang/String;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "mAppInfo is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/bean/AppInfo;->setLoginSchemeVersion(Ljava/lang/String;)V

    return-void
.end method

.method public setPaySchemeVersion(Ljava/lang/String;)V
    .locals 2
    .param p1, "paySchemeVersion"    # Ljava/lang/String;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "mAppInfo is null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKCore;->mAppInfo:Lcom/wanmei/sdk/core/bean/AppInfo;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/bean/AppInfo;->setPaySchemeVersion(Ljava/lang/String;)V

    return-void
.end method
