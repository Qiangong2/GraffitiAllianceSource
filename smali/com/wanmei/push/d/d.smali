.class public final Lcom/wanmei/push/d/d;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/wanmei/push/d/d;


# instance fields
.field private b:Landroid/content/Context;

.field private c:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

.field private d:Lcom/wanmei/push/a/b;

.field private e:Ljava/lang/String;

.field private f:Z

.field private g:Lcom/wanmei/push/a/a$a;

.field private h:Landroid/content/ServiceConnection;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/push/d/d;->f:Z

    new-instance v0, Lcom/wanmei/push/d/d$1;

    invoke-direct {v0, p0}, Lcom/wanmei/push/d/d$1;-><init>(Lcom/wanmei/push/d/d;)V

    iput-object v0, p0, Lcom/wanmei/push/d/d;->g:Lcom/wanmei/push/a/a$a;

    new-instance v0, Lcom/wanmei/push/d/d$2;

    invoke-direct {v0, p0}, Lcom/wanmei/push/d/d$2;-><init>(Lcom/wanmei/push/d/d;)V

    iput-object v0, p0, Lcom/wanmei/push/d/d;->h:Landroid/content/ServiceConnection;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    return-void
.end method

.method private static a(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 6

    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x1

    if-eq v2, v3, :cond_1

    :cond_0
    move-object v0, v1

    :goto_0
    return-object v0

    :cond_1
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v2, v2, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v0, v0, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    const-string v3, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "getExplicitIntent packageName :"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "getExplicitIntent className :"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v3, Landroid/content/ComponentName;

    invoke-direct {v3, v2, v0}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move-object v0, v1

    goto :goto_0
.end method

.method static synthetic a(Lcom/wanmei/push/d/d;)Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/d/d;->c:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    return-object v0
.end method

.method static synthetic a(Lcom/wanmei/push/d/d;Lcom/wanmei/push/a/b;)Lcom/wanmei/push/a/b;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/d/d;->d:Lcom/wanmei/push/a/b;

    return-object p1
.end method

.method public static a(Landroid/content/Context;)Lcom/wanmei/push/d/d;
    .locals 1

    sget-object v0, Lcom/wanmei/push/d/d;->a:Lcom/wanmei/push/d/d;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/d/d;

    invoke-direct {v0, p0}, Lcom/wanmei/push/d/d;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/wanmei/push/d/d;->a:Lcom/wanmei/push/d/d;

    :cond_0
    sget-object v0, Lcom/wanmei/push/d/d;->a:Lcom/wanmei/push/d/d;

    return-object v0
.end method

.method static synthetic a(Lcom/wanmei/push/d/d;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/wanmei/push/d/d;->f:Z

    return p1
.end method

.method static synthetic b(Lcom/wanmei/push/d/d;)V
    .locals 4

    iget-boolean v0, p0, Lcom/wanmei/push/d/d;->f:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/d/d;->d:Lcom/wanmei/push/a/b;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/d/d;->d:Lcom/wanmei/push/a/b;

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lcom/wanmei/push/b;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/d/d;->g:Lcom/wanmei/push/a/a$a;

    invoke-interface {v0, v1, v2, v3}, Lcom/wanmei/push/a/b;->a(Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/push/a/a;)V

    iget-boolean v0, p0, Lcom/wanmei/push/d/d;->f:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    iget-object v1, p0, Lcom/wanmei/push/d/d;->h:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wanmei/push/d/d;->d:Lcom/wanmei/push/a/b;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/push/d/d;->f:Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    goto :goto_0
.end method

.method private c()Z
    .locals 7

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    iget-object v5, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v6, "com.perfect.push.service"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    iget-object v0, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    aget-object v0, v0, v3

    iput-object v0, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/c;->g(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    iget-object v1, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wanmei/push/d/c;->c(Landroid/content/Context;Ljava/lang/String;)V

    :cond_1
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "PushService Already Running, Host PackageName : ["

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "]"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v2

    :goto_0
    return v0

    :cond_2
    const v1, 0x7fffffff

    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getRunningServices(I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager$RunningServiceInfo;

    iget-object v4, v0, Landroid/app/ActivityManager$RunningServiceInfo;->process:Ljava/lang/String;

    const-string v5, "com.perfect.push.service"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    const-class v4, Lcom/wanmei/push/service/PushService;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, v0, Landroid/app/ActivityManager$RunningServiceInfo;->service:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    :cond_4
    iget-object v0, v0, Landroid/app/ActivityManager$RunningServiceInfo;->service:Landroid/content/ComponentName;

    invoke-virtual {v0}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/c;->g(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    iget-object v1, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/wanmei/push/d/c;->c(Landroid/content/Context;Ljava/lang/String;)V

    :cond_5
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "PushService Already Running, Host PackageName : ["

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "]"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v2

    goto :goto_0

    :cond_6
    move v0, v3

    goto :goto_0
.end method

.method private d()V
    .locals 4

    :try_start_0
    const-string v0, "PERFECT_PUSH"

    const-string v1, "bindPushService start"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".intent.action.PERFECT_PUSH"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v1, p0, Lcom/wanmei/push/d/d;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    iget-object v1, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    iget-object v2, p0, Lcom/wanmei/push/d/d;->h:Landroid/content/ServiceConnection;

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v2, v3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public final a()Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/d/d;->c:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    return-object v0
.end method

.method public final a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 2

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/d/d;->c:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/d/d;->c:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    const/16 v1, 0x65

    invoke-interface {v0, v1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openFail(I)V

    :cond_1
    invoke-direct {p0}, Lcom/wanmei/push/d/d;->c()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Landroid/content/Context;)V

    :goto_0
    return-void

    :cond_2
    invoke-direct {p0}, Lcom/wanmei/push/d/d;->d()V

    goto :goto_0
.end method

.method public final b()V
    .locals 1

    invoke-direct {p0}, Lcom/wanmei/push/d/d;->c()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/d/d;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Landroid/content/Context;)V

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0}, Lcom/wanmei/push/d/d;->d()V

    goto :goto_0
.end method
