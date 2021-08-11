.class public Lcom/wanmei/push/PushAgent;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;
    }
.end annotation


# static fields
.field private static INSTANCE:Lcom/wanmei/push/PushAgent;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mPerData:Lcom/wanmei/push/service/d;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    return-void
.end method

.method static synthetic access$000(Lcom/wanmei/push/PushAgent;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    invoke-direct {p0, p1, p2}, Lcom/wanmei/push/PushAgent;->setPushSDKAppInfo(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;
    .param p1, "x1"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/push/PushAgent;->auth(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method

.method static synthetic access$200(Lcom/wanmei/push/PushAgent;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/push/PushAgent;->uploadDeviceInfo()V

    return-void
.end method

.method static synthetic access$300(Lcom/wanmei/push/PushAgent;)Z
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/push/PushAgent;->isPersistentDeviceAppInfoExist()Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/wanmei/push/PushAgent;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$500(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;
    .param p1, "x1"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/push/PushAgent;->syncDeviceAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method

.method static synthetic access$600(Lcom/wanmei/push/PushAgent;)V
    .locals 0
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/push/PushAgent;->pullCertificate()V

    return-void
.end method

.method static synthetic access$700(Lcom/wanmei/push/PushAgent;)Lcom/wanmei/push/service/d;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/PushAgent;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mPerData:Lcom/wanmei/push/service/d;

    return-object v0
.end method

.method private auth(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 2
    .param p1, "callBack"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/PushAgent$2;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/push/PushAgent$2;-><init>(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$a;)V

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->a(Landroid/content/Context;)V

    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/wanmei/push/PushAgent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const-class v1, Lcom/wanmei/push/PushAgent;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/push/PushAgent;->INSTANCE:Lcom/wanmei/push/PushAgent;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/PushAgent;

    invoke-direct {v0, p0}, Lcom/wanmei/push/PushAgent;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/wanmei/push/PushAgent;->INSTANCE:Lcom/wanmei/push/PushAgent;

    :cond_0
    sget-object v0, Lcom/wanmei/push/PushAgent;->INSTANCE:Lcom/wanmei/push/PushAgent;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private initDeviceInfo()V
    .locals 7

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/g/c;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v4, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v5, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, "x"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v6, "deviceId = "

    invoke-direct {v1, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "    deviceName="

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "   sysVersion"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "   resolution="

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual/range {v0 .. v5}, Lcom/wanmei/push/b;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private isPersistentDeviceAppInfoExist()Z
    .locals 4

    :try_start_0
    new-instance v0, Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/wanmei/push/service/d;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wanmei/push/PushAgent;->mPerData:Lcom/wanmei/push/service/d;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mPerData:Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mPerData:Lcom/wanmei/push/service/d;

    invoke-virtual {v1}, Lcom/wanmei/push/service/d;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->b(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Has Persistent DeviceAppInfo"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Check Has Persistent DeviceAppInfo Fail : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private pullAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 3
    .param p1, "callBack"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/b;->b()Lcom/wanmei/push/bean/OneSDKInfo;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/PushAgent$1;

    invoke-direct {v2, p0, p1}, Lcom/wanmei/push/PushAgent$1;-><init>(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    invoke-virtual {v1, v2}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$c;)V

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/OneSDKInfo;->getOneAppId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/wanmei/push/bean/OneSDKInfo;->getOneAppKey()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/d/a;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private pullCertificate()V
    .locals 2

    invoke-static {}, Lcom/wanmei/push/g/i;->b()Z

    move-result v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    const-string v0, "PERFECT_PUSH"

    const-string v1, "IS XIAOMI ROOM"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/PushAgent$5;

    invoke-direct {v1, p0}, Lcom/wanmei/push/PushAgent$5;-><init>(Lcom/wanmei/push/PushAgent;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$b;)V

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->g(Landroid/content/Context;)V

    goto :goto_0
.end method

.method private setNotifyIcon(ILandroid/content/Context;)V
    .locals 0
    .param p1, "ic_launcher"    # I
    .param p2, "mContext"    # Landroid/content/Context;

    .prologue
    invoke-static {p1}, Lcom/wanmei/push/a;->a(I)V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p2, p1}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;I)V

    return-void
.end method

.method private setPushSDKAppInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "appId"    # Ljava/lang/String;
    .param p2, "appKey"    # Ljava/lang/String;

    .prologue
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setPushSDKAppInfo  appId = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "    oneAppKey="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, p1, p2, v2}, Lcom/wanmei/push/b;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private syncDeviceAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 2
    .param p1, "callBack"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/PushAgent$4;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/push/PushAgent$4;-><init>(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$f;)V

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Persistent DeviceAppInfo is Not Exist, Sync DeviceAppInfo..."

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->f(Landroid/content/Context;)V

    return-void
.end method

.method private uploadDeviceInfo()V
    .locals 2

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/PushAgent$3;

    invoke-direct {v1, p0}, Lcom/wanmei/push/PushAgent$3;-><init>(Lcom/wanmei/push/PushAgent;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$h;)V

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Upload DeviceInfo"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->d(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 4

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v1

    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v0, "deviceInfo = "

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-nez v1, :cond_0

    const-string v0, "deviceInfo is NULL"

    :goto_0
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    if-nez v1, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/g/c;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    :cond_0
    invoke-virtual {v1}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v1}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public getPushAppId(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/push/b;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public initAppInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "appId"    # Ljava/lang/String;
    .param p2, "appKey"    # Ljava/lang/String;

    .prologue
    invoke-direct {p0}, Lcom/wanmei/push/PushAgent;->initDeviceInfo()V

    invoke-direct {p0, p1, p2}, Lcom/wanmei/push/PushAgent;->setPushSDKAppInfo(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public oneSDKInitPush(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "oneAppId"    # Ljava/lang/String;
    .param p2, "oneAppKey"    # Ljava/lang/String;

    .prologue
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "oneSDKInitPush oneAppId = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "    oneAppKey="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/wanmei/push/PushAgent;->initDeviceInfo()V

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/wanmei/push/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public openPush(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 4
    .param p1, "callBack"    # Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    .prologue
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v0

    if-eqz v0, :cond_1

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "appInfo:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientSecret()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    invoke-direct {p0, p1}, Lcom/wanmei/push/PushAgent;->pullAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    :goto_1
    return-void

    :cond_1
    const-string v1, "PERFECT_PUSH"

    const-string v2, "appInfo == NULL"

    invoke-static {v1, v2}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    invoke-direct {p0, p1}, Lcom/wanmei/push/PushAgent;->auth(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    goto :goto_1
.end method

.method public setDebugMode(Z)V
    .locals 1
    .param p1, "isDebugMode"    # Z

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Z)V

    return-void
.end method

.method public setPushNotifyIcon(I)V
    .locals 1
    .param p1, "drawableId"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/PushAgent;->mContext:Landroid/content/Context;

    invoke-direct {p0, p1, v0}, Lcom/wanmei/push/PushAgent;->setNotifyIcon(ILandroid/content/Context;)V

    return-void
.end method
