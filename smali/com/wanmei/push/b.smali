.class public final Lcom/wanmei/push/b;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/b$g;,
        Lcom/wanmei/push/b$f;,
        Lcom/wanmei/push/b$h;,
        Lcom/wanmei/push/b$d;,
        Lcom/wanmei/push/b$e;,
        Lcom/wanmei/push/b$a;,
        Lcom/wanmei/push/b$c;,
        Lcom/wanmei/push/b$b;
    }
.end annotation


# static fields
.field private static l:Lcom/wanmei/push/b;


# instance fields
.field protected a:Lcom/wanmei/push/bean/DeviceInfo;

.field protected b:Lcom/wanmei/push/bean/OneSDKInfo;

.field protected c:Lcom/wanmei/push/bean/AppInfo;

.field protected d:Lcom/wanmei/push/b$c;

.field protected e:Lcom/wanmei/push/b$a;

.field protected f:Lcom/wanmei/push/b$h;

.field protected g:Lcom/wanmei/push/b$f;

.field protected h:Lcom/wanmei/push/b$b;

.field protected i:Lcom/wanmei/push/b$g;

.field protected j:Lcom/wanmei/push/b$e;

.field protected k:Lcom/wanmei/push/b$d;

.field private m:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/wanmei/push/b;

    invoke-direct {v0}, Lcom/wanmei/push/b;-><init>()V

    sput-object v0, Lcom/wanmei/push/b;->l:Lcom/wanmei/push/b;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/wanmei/push/b;->m:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method public static a()Lcom/wanmei/push/b;
    .locals 1

    sget-object v0, Lcom/wanmei/push/b;->l:Lcom/wanmei/push/b;

    return-object v0
.end method


# virtual methods
.method public final a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "getDeviceInfo\'s context is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    if-nez v0, :cond_1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    :cond_1
    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    return-object v0
.end method

.method public final a(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->e:Lcom/wanmei/push/b$a;

    if-eqz v1, :cond_2

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->e:Lcom/wanmei/push/b$a;

    invoke-interface {v0}, Lcom/wanmei/push/b$a;->a()V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_AUTH_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/wanmei/push/b;->m:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v1

    if-lez v1, :cond_1

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/wanmei/push/b$1;

    invoke-direct {v1, p0, p1, v0}, Lcom/wanmei/push/b$1;-><init>(Lcom/wanmei/push/b;Landroid/content/Context;Ljava/util/Timer;)V

    const-wide/16 v2, 0x7530

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcom/wanmei/push/b;->e:Lcom/wanmei/push/b$a;

    invoke-interface {v1, v0}, Lcom/wanmei/push/b$a;->a(I)V

    goto :goto_1

    :cond_2
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnAUTHListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final a(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->d:Lcom/wanmei/push/b$c;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->d:Lcom/wanmei/push/b$c;

    invoke-interface {v0, p3, p4}, Lcom/wanmei/push/b$c;->a(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_PULL_APPINFO_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/wanmei/push/b;->d:Lcom/wanmei/push/b$c;

    invoke-interface {v1, v0}, Lcom/wanmei/push/b$c;->a(I)V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnAUTHListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-direct {v0}, Lcom/wanmei/push/bean/AppInfo;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0, p2}, Lcom/wanmei/push/bean/AppInfo;->setAppClientId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0, p3}, Lcom/wanmei/push/bean/AppInfo;->setAppClientSecret(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0, p4}, Lcom/wanmei/push/bean/AppInfo;->setPackageName(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    invoke-static {p1, v0}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;Lcom/wanmei/push/bean/AppInfo;)V

    return-void
.end method

.method public final a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/bean/DeviceInfo;

    invoke-direct {v0}, Lcom/wanmei/push/bean/DeviceInfo;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    invoke-virtual {v0, p2}, Lcom/wanmei/push/bean/DeviceInfo;->setDeviceId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    invoke-virtual {v0, p3}, Lcom/wanmei/push/bean/DeviceInfo;->setDeviceName(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    invoke-virtual {v0, p4}, Lcom/wanmei/push/bean/DeviceInfo;->setSysVersion(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    invoke-virtual {v0, p5}, Lcom/wanmei/push/bean/DeviceInfo;->setResolution(Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/b;->a:Lcom/wanmei/push/bean/DeviceInfo;

    invoke-static {p1, v0}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;Lcom/wanmei/push/bean/DeviceInfo;)V

    return-void
.end method

.method public final a(Lcom/wanmei/push/b$a;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->e:Lcom/wanmei/push/b$a;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$b;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->h:Lcom/wanmei/push/b$b;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$c;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->d:Lcom/wanmei/push/b$c;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$d;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->k:Lcom/wanmei/push/b$d;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$e;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->j:Lcom/wanmei/push/b$e;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$f;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->g:Lcom/wanmei/push/b$f;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$g;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->i:Lcom/wanmei/push/b$g;

    :cond_0
    return-void
.end method

.method public final a(Lcom/wanmei/push/b$h;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/wanmei/push/b;->f:Lcom/wanmei/push/b$h;

    :cond_0
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b;->b:Lcom/wanmei/push/bean/OneSDKInfo;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/bean/OneSDKInfo;

    invoke-direct {v0}, Lcom/wanmei/push/bean/OneSDKInfo;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/b;->b:Lcom/wanmei/push/bean/OneSDKInfo;

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->b:Lcom/wanmei/push/bean/OneSDKInfo;

    invoke-virtual {v0, p1}, Lcom/wanmei/push/bean/OneSDKInfo;->setOneAppId(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b;->b:Lcom/wanmei/push/bean/OneSDKInfo;

    invoke-virtual {v0, p2}, Lcom/wanmei/push/bean/OneSDKInfo;->setOneAppKey(Ljava/lang/String;)V

    return-void
.end method

.method public final b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/wanmei/push/b;->c(Landroid/content/Context;)Z

    iget-object v0, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    return-object v0
.end method

.method public final b()Lcom/wanmei/push/bean/OneSDKInfo;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b;->b:Lcom/wanmei/push/bean/OneSDKInfo;

    return-object v0
.end method

.method public final b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->f:Lcom/wanmei/push/b$h;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->f:Lcom/wanmei/push/b$h;

    invoke-interface {v0}, Lcom/wanmei/push/b$h;->a()V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->d()V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->f:Lcom/wanmei/push/b$h;

    invoke-interface {v0}, Lcom/wanmei/push/b$h;->b()V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->h:Lcom/wanmei/push/b$b;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->h:Lcom/wanmei/push/b$b;

    invoke-interface {v0, p3, p4}, Lcom/wanmei/push/b$b;->a(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_PULL_CERTIFICATE_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/wanmei/push/b;->h:Lcom/wanmei/push/b$b;

    invoke-interface {v1, v0}, Lcom/wanmei/push/b$b;->a(I)V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnAUTHListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final c(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->i:Lcom/wanmei/push/b$g;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->i:Lcom/wanmei/push/b$g;

    invoke-interface {v0}, Lcom/wanmei/push/b$g;->a()V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->d()V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->i:Lcom/wanmei/push/b$g;

    invoke-interface {v0}, Lcom/wanmei/push/b$g;->b()V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final c(Landroid/content/Context;)Z
    .locals 3

    const/4 v0, 0x0

    if-nez p1, :cond_1

    const-string v1, "PERFECT_PUSH"

    const-string v2, "context is null"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return v0

    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    if-nez v1, :cond_2

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    iget-object v1, p0, Lcom/wanmei/push/b;->c:Lcom/wanmei/push/bean/AppInfo;

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/ClassCastException;->printStackTrace()V

    goto :goto_0
.end method

.method public final d(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->j:Lcom/wanmei/push/b$e;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->j:Lcom/wanmei/push/b$e;

    invoke-interface {v0}, Lcom/wanmei/push/b$e;->a()V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->d()V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->j:Lcom/wanmei/push/b$e;

    invoke-interface {v0}, Lcom/wanmei/push/b$e;->b()V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final e(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->k:Lcom/wanmei/push/b$d;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->k:Lcom/wanmei/push/b$d;

    invoke-interface {v0}, Lcom/wanmei/push/b$d;->a()V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->d()V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->k:Lcom/wanmei/push/b$d;

    invoke-interface {v0}, Lcom/wanmei/push/b$d;->b()V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final f(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-virtual {p2}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "Default"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/wanmei/push/b;->g:Lcom/wanmei/push/b$f;

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b;->g:Lcom/wanmei/push/b$f;

    invoke-interface {v0, p2}, Lcom/wanmei/push/b$f;->a(Lcom/wanmei/push/bean/StandardBaseResult;)V

    :goto_1
    return-void

    :pswitch_0
    const-string v1, "PERFECT_PUSH"

    const-string v2, "ResponseCode.PLATFORM_SUCCESS"

    invoke-static {p1, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->d()V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b;->g:Lcom/wanmei/push/b$f;

    invoke-interface {v0}, Lcom/wanmei/push/b$f;->a()V

    goto :goto_1

    :cond_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "OnListener is null"

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
