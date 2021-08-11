.class public Lcom/wanmei/sdk/core/open/SDKMutidexApplication;
.super Landroid/app/Application;


# static fields
.field private static final TAG:Ljava/lang/String;

.field protected static volatile mHasLoadMutiDex:Z

.field protected static volatile mUseMutiDex:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x0

    const-class v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->TAG:Ljava/lang/String;

    sput-boolean v1, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mUseMutiDex:Z

    sput-boolean v1, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mHasLoadMutiDex:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static hasLoadMutiDex()Z
    .locals 1

    sget-boolean v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mHasLoadMutiDex:Z

    return v0
.end method

.method public static useMutiDex()Z
    .locals 1

    sget-boolean v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mUseMutiDex:Z

    return v0
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .locals 2
    .param p1, "base"    # Landroid/content/Context;

    .prologue
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->TAG:Ljava/lang/String;

    const-string v1, "attachBaseContext"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x1

    sput-boolean v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mUseMutiDex:Z

    new-instance v0, Lcom/wanmei/sdk/core/task/d;

    new-instance v1, Lcom/wanmei/sdk/core/open/SDKMutidexApplication$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/open/SDKMutidexApplication$1;-><init>(Lcom/wanmei/sdk/core/open/SDKMutidexApplication;)V

    invoke-direct {v0, p0, v1}, Lcom/wanmei/sdk/core/task/d;-><init>(Landroid/content/Context;Lcom/wanmei/sdk/core/task/d$a;)V

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/task/d;->a()V

    return-void
.end method
