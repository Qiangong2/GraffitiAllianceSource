.class public abstract Lcom/wanmei/sdk/core/open/SDKBase;
.super Lcom/wanmei/sdk/core/open/SDKImpl;

# interfaces
.implements Lcom/wanmei/sdk/core/Proguard;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/open/SDKBase$InitState;,
        Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;,
        Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;
    }
.end annotation


# static fields
.field private static final CHANNEL_LOGIN_ERROR_MSG:Ljava/lang/String; = "\u767b\u5f55\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

.field private static final CHANNEL_PAY_ERROR_MSG:Ljava/lang/String; = "\u672c\u6b21\u652f\u4ed8\u6ca1\u6709\u6210\u529f\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5"

.field private static final DEFAULT_CONFIG_FILE_NAME:Ljava/lang/String; = "OneSDK.config"

.field private static final FLASH_PIC_LANDSCAPE:Ljava/lang/String; = "common_flash_landscape.png"

.field private static final FLASH_PIC_PORTRAIT:Ljava/lang/String; = "common_flash_portrait.png"

.field private static final FLASH_TIMER_TIME_MILLISECEND:I = 0xbb8

.field private static volatile INSTANCE:Lcom/wanmei/sdk/core/open/SDKBase; = null

.field private static final INTERVAL:J = 0x7d0L

.field private static final TAG:Ljava/lang/String;

.field private static mActivity:Landroid/app/Activity;


# instance fields
.field private commonOrderMsg:Ljava/lang/String;

.field private lastTimeHashMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mAppId:I

.field private mAppKey:Ljava/lang/String;

.field private mChannelId:I

.field private volatile mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

.field private mChannelName:Ljava/lang/String;

.field private mConfigFileName:Ljava/lang/String;

.field private mConfigFilePath:Ljava/lang/String;

.field private mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

.field private volatile mHasLogin:Z

.field protected mInitCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

.field private volatile mInitMsg:Ljava/lang/String;

.field protected mLoginCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

.field protected mLogoutCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

.field private volatile mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

.field protected mPayCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKImpl;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->lastTimeHashMap:Ljava/util/HashMap;

    return-void
.end method

.method static synthetic access$000(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;)Z
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->checkInterval(Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/wanmei/sdk/core/open/SDKBase;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->doNext()V

    return-void
.end method

.method static synthetic access$1000(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/param/OrderParams;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Lcom/wanmei/sdk/core/param/OrderParams;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->commonOrder(Lcom/wanmei/sdk/core/param/OrderParams;)V

    return-void
.end method

.method static synthetic access$1102(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->commonOrderMsg:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1200()Landroid/app/Activity;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->dismissFloatView(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$1400(Lcom/wanmei/sdk/core/open/SDKBase;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->onOnesdkInitSuccess()V

    return-void
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    return-object v0
.end method

.method static synthetic access$400(Lcom/wanmei/sdk/core/open/SDKBase;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    return-object v0
.end method

.method static synthetic access$500(Lcom/wanmei/sdk/core/open/SDKBase;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitMsg:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/wanmei/sdk/core/open/SDKBase;)Z
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->checkInit()Z

    move-result v0

    return v0
.end method

.method static synthetic access$702(Lcom/wanmei/sdk/core/open/SDKBase;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Z

    .prologue
    iput-boolean p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    return p1
.end method

.method static synthetic access$800(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/content/Context;I)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;
    .param p1, "x1"    # Landroid/content/Context;
    .param p2, "x2"    # I

    .prologue
    invoke-direct {p0, p1, p2}, Lcom/wanmei/sdk/core/open/SDKBase;->showFloatView(Landroid/content/Context;I)V

    return-void
.end method

.method static synthetic access$900(Lcom/wanmei/sdk/core/open/SDKBase;)Z
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/open/SDKBase;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->checkLogin()Z

    move-result v0

    return v0
.end method

.method private checkInit()Z
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-eq v0, v1, :cond_1

    :cond_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "\u8bf7\u7b49\u5f85\u521d\u59cb\u5316\u6210\u529f"

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/Toast;->makeToast(Landroid/content/Context;Ljava/lang/String;)V

    :cond_1
    const/4 v0, 0x1

    return v0
.end method

.method private checkInterval(Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;)Z
    .locals 8
    .param p1, "intervalType"    # Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    .prologue
    const/4 v1, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->lastTimeHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    const-wide/16 v2, 0x0

    :goto_0
    sub-long v2, v4, v2

    const-wide/16 v6, 0x7d0

    cmp-long v0, v2, v6

    if-lez v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->lastTimeHashMap:Ljava/util/HashMap;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x1

    :goto_1
    return v0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->lastTimeHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->lastTimeHashMap:Ljava/util/HashMap;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v2, "\u8bf7\u7a0d\u7b49\u51e0\u79d2\u540e\u518d\u8bd5"

    invoke-static {v0, v2, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "less than 2000 milliseconds between two requests,"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_1
.end method

.method private checkLogin()Z
    .locals 2

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    if-nez v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "\u672a\u767b\u5f55"

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/Toast;->makeToast(Landroid/content/Context;Ljava/lang/String;)V

    :cond_0
    iget-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    return v0
.end method

.method private commonOrder(Lcom/wanmei/sdk/core/param/OrderParams;)V
    .locals 3
    .param p1, "orderParams"    # Lcom/wanmei/sdk/core/param/OrderParams;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    new-instance v2, Lcom/wanmei/sdk/core/open/SDKBase$16;

    invoke-direct {v2, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$16;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/param/OrderParams;)V

    invoke-virtual {v0, v1, p1, v2}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->doPay(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseOrderParams;Lcom/wanmei/sdk/core/task/PayTask$PayCallBack;)V

    return-void
.end method

.method private destroyFloatView(Landroid/content/Context;)V
    .locals 1
    .param p1, "con"    # Landroid/content/Context;

    .prologue
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getFloatViewItemImpl()[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/ui/floatview/c;->a()Lcom/wanmei/sdk/core/ui/floatview/c;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/ui/floatview/c;->b(Landroid/content/Context;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->destroyFloatViewImpl()V

    goto :goto_0
.end method

.method private dismissFloatView(Landroid/content/Context;)V
    .locals 1
    .param p1, "con"    # Landroid/content/Context;

    .prologue
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getFloatViewItemImpl()[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/ui/floatview/c;->a()Lcom/wanmei/sdk/core/ui/floatview/c;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/ui/floatview/c;->a(Landroid/content/Context;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->dismissFloatViewImpl()V

    goto :goto_0
.end method

.method private doInitImpl()V
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->initImpl()V

    return-void
.end method

.method private doLogout(Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V
    .locals 2
    .param p1, "logoutCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$17;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$17;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method private doNext()V
    .locals 6

    :try_start_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase;->mActivity:Landroid/app/Activity;

    iget v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppId:I

    iget-object v3, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppKey:Ljava/lang/String;

    iget v4, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelId:I

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->init(Landroid/content/Context;ILjava/lang/String;I)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getLoginSchemeVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->setLoginSchemeVersion(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getPaySchemeVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->setPaySchemeVersion(Ljava/lang/String;)V

    iget v1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppId:I

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppKey:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getVersion()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigFileName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getConfigReader()Lcom/wanmei/sdk/core/config/ConfigReader;

    move-result-object v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/wanmei/sdk/core/open/SDKBase;->readConfig(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/config/ConfigReader;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :try_start_1
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getMode()Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->sample:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->initPushSDK()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    :cond_0
    :goto_0
    :try_start_2
    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->tryFlash()V

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->doInitImpl()V

    :goto_1
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    const-string v2, "Exception initPushSDK()"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/open/SDKBase;->initFailed(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static getActivity()Landroid/app/Activity;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method public static getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    sput-object p0, Lcom/wanmei/sdk/core/open/SDKBase;->mActivity:Landroid/app/Activity;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKBase;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/open/SDKBase;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKBase;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstanceImpl()Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKBase;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->INSTANCE:Lcom/wanmei/sdk/core/open/SDKBase;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static getInstanceImpl()Lcom/wanmei/sdk/core/open/SDKBase;
    .locals 3

    const-class v1, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    const-string v2, "getInstanceImpl"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->useMutiDex()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->hasLoadMutiDex()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    const-string v2, "before wait"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const-class v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    invoke-virtual {v0}, Ljava/lang/Object;->wait()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    :try_start_1
    invoke-static {}, Lcom/wanmei/sdk/core/util/a;->a()Lcom/wanmei/sdk/core/util/a;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/wanmei/sdk/core/util/a;->a(Landroid/app/Activity;)V

    invoke-static {}, Lcom/wanmei/sdk/core/util/a;->a()Lcom/wanmei/sdk/core/util/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/util/a;->b()V

    invoke-static {}, Lcom/wanmei/sdk/core/util/a;->a()Lcom/wanmei/sdk/core/util/a;

    move-result-object v0

    const-class v2, Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0, v2}, Lcom/wanmei/sdk/core/util/a;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/open/SDKBase;

    monitor-exit v1

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private initPushSDK()V
    .locals 3

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->getInstance(Landroid/content/Context;)Lcom/wanmei/push/PushAgent;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v1, v1, Landroid/content/pm/ApplicationInfo;->icon:I

    invoke-virtual {v0, v1}, Lcom/wanmei/push/PushAgent;->setPushNotifyIcon(I)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppId:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppKey:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/push/PushAgent;->oneSDKInitPush(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->isDebug()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/PushAgent;->setDebugMode(Z)V

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$2;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$2;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/PushAgent;->openPush(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method

.method private declared-synchronized notifyInitResult()V
    .locals 2

    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$3;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$3;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private onOnesdkInitSuccess()V
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->notifyInitResult()V

    return-void
.end method

.method private showFloatView(Landroid/content/Context;I)V
    .locals 2
    .param p1, "con"    # Landroid/content/Context;
    .param p2, "floatViewPlace"    # I

    .prologue
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getFloatViewItemImpl()[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/ui/floatview/c;->a()Lcom/wanmei/sdk/core/ui/floatview/c;

    move-result-object v1

    invoke-virtual {v1, p1, p2, v0}, Lcom/wanmei/sdk/core/ui/floatview/c;->a(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->showFloatViewImpl()V

    goto :goto_0
.end method

.method private tryFlash()V
    .locals 6

    const/4 v3, 0x1

    :try_start_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    const-string v0, "common_flash_portrait.png"

    iget v2, v1, Landroid/content/res/Configuration;->orientation:I

    if-ne v2, v3, :cond_1

    const-string v0, "common_flash_portrait.png"

    :cond_0
    :goto_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    new-instance v0, Landroid/app/Dialog;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/app/Dialog;->requestWindowFeature(I)Z

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x400

    const/16 v4, 0x400

    invoke-virtual {v2, v3, v4}, Landroid/view/Window;->setFlags(II)V

    new-instance v2, Landroid/widget/LinearLayout;

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, -0x1

    invoke-direct {v1, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2, v1}, Landroid/app/Dialog;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setCancelable(Z)V

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const v2, 0x106000d

    invoke-virtual {v1, v2}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, -0x1

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/view/Window;->setLayout(II)V

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    new-instance v2, Lcom/wanmei/sdk/core/open/SDKBase$20;

    invoke-direct {v2, p0, v0}, Lcom/wanmei/sdk/core/open/SDKBase$20;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Landroid/app/Dialog;)V

    const-wide/16 v4, 0xbb8

    invoke-virtual {v1, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    :goto_1
    return-void

    :cond_1
    iget v1, v1, Landroid/content/res/Configuration;->orientation:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    const-string v0, "common_flash_landscape.png"
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$21;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$21;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_1
.end method


# virtual methods
.method protected destroyFloatViewImpl()V
    .locals 0

    return-void
.end method

.method protected dismissFloatViewImpl()V
    .locals 0

    return-void
.end method

.method public doLogin(Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V
    .locals 2
    .param p1, "loginCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$4;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$4;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public doLogout()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mLogoutCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/open/SDKBase;->doLogout(Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V

    return-void
.end method

.method public doPay(Lcom/wanmei/sdk/core/param/OrderParams;Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;)V
    .locals 2
    .param p1, "orderParams"    # Lcom/wanmei/sdk/core/param/OrderParams;
    .param p2, "payCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$10;

    invoke-direct {v1, p0, p2, p1}, Lcom/wanmei/sdk/core/open/SDKBase$10;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;Lcom/wanmei/sdk/core/param/OrderParams;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public getAppId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppId:I

    return v0
.end method

.method public getChannelConfig(ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V
    .locals 2
    .param p1, "channelId"    # I
    .param p2, "readChannelCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase;->mActivity:Landroid/app/Activity;

    invoke-virtual {v0, v1, p1, p2}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getChannelConfig(Landroid/content/Context;ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V

    return-void
.end method

.method public abstract getChannelId()I
.end method

.method public abstract getChannelName()Ljava/lang/String;
.end method

.method public getCommonOrderId()Ljava/lang/String;
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getCommonOrderInfo()Lcom/wanmei/sdk/core/bean/OrderInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/OrderInfo;->getOrderId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCommonOrderMsg()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->commonOrderMsg:Ljava/lang/String;

    return-object v0
.end method

.method protected abstract getConfigReader()Lcom/wanmei/sdk/core/config/ConfigReader;
.end method

.method protected getFloatViewItemImpl()[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected getFloatViewPlace()I
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method protected getInitConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->getInitConfig()Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method protected getLoginConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->getLoginConfig()Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method protected getLoginSchemeVersion()Ljava/lang/String;
    .locals 1

    const-string v0, ""

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/Account;->getPassword()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getPayConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->getPayConfig()Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method protected getPaySchemeVersion()Ljava/lang/String;
    .locals 1

    const-string v0, ""

    return-object v0
.end method

.method public getPushDeviceId()Ljava/lang/String;
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getPushDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/Account;->getToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAccount()Lcom/wanmei/sdk/core/bean/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/bean/Account;->getUserId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getVersion()Ljava/lang/String;
.end method

.method public init(ILjava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V
    .locals 1
    .param p1, "appId"    # I
    .param p2, "appKey"    # Ljava/lang/String;
    .param p3, "initCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    .prologue
    const-string v0, "OneSDK.config"

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/wanmei/sdk/core/open/SDKBase;->init(ILjava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V

    return-void
.end method

.method public init(ILjava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V
    .locals 3
    .param p1, "appId"    # I
    .param p2, "appKey"    # Ljava/lang/String;
    .param p3, "configFileName"    # Ljava/lang/String;
    .param p4, "initCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object p4, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;

    iput p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppId:I

    iput-object p2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mAppKey:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getChannelId()I

    move-result v0

    iput v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelId:I

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getChannelName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelName:Ljava/lang/String;

    iput-object p3, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigFileName:Ljava/lang/String;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "channelId : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelId:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "channelName : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$1;

    invoke-direct {v1, p0, p4}, Lcom/wanmei/sdk/core/open/SDKBase$1;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected initFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitMsg:Ljava/lang/String;

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->notifyInitResult()V

    return-void
.end method

.method protected initSucceed(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mInitMsg:Ljava/lang/String;

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->notifyInitResult()V

    return-void
.end method

.method public isHasInit()Z
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isHasLogin()Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    return v0
.end method

.method protected loginCancelled()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$9;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$9;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected loginFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$7;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$7;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected loginOneSDK(Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/param/BaseLoginParams;)V
    .locals 3
    .param p1, "uid"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "baseLoginParams"    # Lcom/wanmei/sdk/core/param/BaseLoginParams;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "loginOneSDK:  uid: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " token: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p3, p1, p2}, Lcom/wanmei/sdk/core/param/BaseLoginParams;->setBasicParams(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v1

    new-instance v2, Lcom/wanmei/sdk/core/open/SDKBase$5;

    invoke-direct {v2, p0}, Lcom/wanmei/sdk/core/open/SDKBase$5;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1, p3, v2}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->loginCommonSDK(Landroid/app/Activity;Lcom/wanmei/sdk/core/param/BaseLoginParams;Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;)V

    return-void
.end method

.method protected loginOneSDKFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$8;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$8;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected loginSucceed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$6;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$6;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected logoutFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$19;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$19;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected logoutSucceed()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$18;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKBase$18;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public onDestroy(Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 1
    .param p1, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/open/SDKBase;->destroyFloatView(Landroid/content/Context;)V

    invoke-interface {p1}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method

.method protected payCancelled(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$14;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$14;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected payFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$12;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$12;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected payOneSDKFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$13;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$13;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected payOrdered(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$15;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$15;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected paySucceed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKBase$11;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/sdk/core/open/SDKBase$11;-><init>(Lcom/wanmei/sdk/core/open/SDKBase;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected readConfig(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/config/ConfigReader;)V
    .locals 2
    .param p1, "appId"    # I
    .param p2, "appKey"    # Ljava/lang/String;
    .param p3, "version"    # Ljava/lang/String;
    .param p4, "configFileName"    # Ljava/lang/String;
    .param p5, "configReader"    # Lcom/wanmei/sdk/core/config/ConfigReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    iput-object p5, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    invoke-virtual {v0, p1, p2, p3}, Lcom/wanmei/sdk/core/config/ConfigReader;->setBasic(ILjava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigFilePath:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    iget-object v1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigFilePath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/config/ConfigReader;->readConfigFilePath(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigReader:Lcom/wanmei/sdk/core/config/ConfigReader;

    invoke-virtual {v0, p4}, Lcom/wanmei/sdk/core/config/ConfigReader;->readConfigFileName(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setConfigFilePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "configFilePath"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mConfigFilePath:Ljava/lang/String;

    return-void
.end method

.method protected setHasInit(Z)V
    .locals 1
    .param p1, "hasInit"    # Z

    .prologue
    if-eqz p1, :cond_0

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mOnesdkInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    iput-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mChannelInitState:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    goto :goto_0
.end method

.method protected setHasLogin(Z)V
    .locals 0
    .param p1, "hasLogin"    # Z

    .prologue
    iput-boolean p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mHasLogin:Z

    return-void
.end method

.method public setLogoutCallBack(Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V
    .locals 0
    .param p1, "logoutCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase;->mLogoutCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;

    return-void
.end method

.method protected showFloatViewImpl()V
    .locals 0

    return-void
.end method

.method public submitUserInfo(Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;Lcom/wanmei/sdk/core/open/UserInfo;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V
    .locals 0
    .param p1, "userInfoType"    # Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;
    .param p2, "userInfo"    # Lcom/wanmei/sdk/core/open/UserInfo;
    .param p3, "completeCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;

    .prologue
    invoke-interface {p3}, Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;->onComplete()V

    return-void
.end method
