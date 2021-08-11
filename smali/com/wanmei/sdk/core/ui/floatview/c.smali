.class public Lcom/wanmei/sdk/core/ui/floatview/c;
.super Ljava/lang/Object;


# static fields
.field private static volatile a:Lcom/wanmei/sdk/core/ui/floatview/c;


# instance fields
.field private b:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/wanmei/sdk/core/ui/floatview/c;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/c;->a:Lcom/wanmei/sdk/core/ui/floatview/c;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/ui/floatview/c;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/c;->a:Lcom/wanmei/sdk/core/ui/floatview/c;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/c;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/ui/floatview/c;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/ui/floatview/c;->a:Lcom/wanmei/sdk/core/ui/floatview/c;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/c;->a:Lcom/wanmei/sdk/core/ui/floatview/c;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public a(Landroid/content/Context;)V
    .locals 3

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/c;->b:Z

    if-eqz v0, :cond_0

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "floatViewAction"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    :cond_0
    return-void
.end method

.method public a(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/c;->b:Z

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/c;->b:Z

    if-eqz v0, :cond_0

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "floatViewPlace"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const-string v1, "floatViewAction"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    invoke-static {p3}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->a([Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    :cond_0
    return-void
.end method

.method public b(Landroid/content/Context;)V
    .locals 2

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/c;->b:Z

    if-eqz v0, :cond_0

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p1, v0}, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/c;->b:Z

    :cond_0
    return-void
.end method
