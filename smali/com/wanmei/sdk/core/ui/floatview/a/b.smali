.class public Lcom/wanmei/sdk/core/ui/floatview/a/b;
.super Ljava/lang/Object;


# static fields
.field private static volatile a:Lcom/wanmei/sdk/core/ui/floatview/a/b;


# instance fields
.field private b:Lcom/wanmei/sdk/core/ui/floatview/b;

.field private c:Lcom/wanmei/sdk/core/ui/floatview/a/d;


# direct methods
.method private constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/a/e;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/a/e;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c:Lcom/wanmei/sdk/core/ui/floatview/a/d;

    return-void
.end method

.method public static a()Lcom/wanmei/sdk/core/ui/floatview/a/b;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    return-object v0
.end method

.method public static a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a/b;
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    if-nez v0, :cond_1

    const-class v1, Lcom/wanmei/sdk/core/ui/floatview/a/b;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/ui/floatview/a/b;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    sput-object v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public a(Lcom/wanmei/sdk/core/ui/floatview/a/d;)V
    .locals 1

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c:Lcom/wanmei/sdk/core/ui/floatview/a/d;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c:Lcom/wanmei/sdk/core/ui/floatview/a/d;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a/d;->c()V

    return-void
.end method

.method public b()Lcom/wanmei/sdk/core/ui/floatview/b;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    return-object v0
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c:Lcom/wanmei/sdk/core/ui/floatview/a/d;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a/d;->d()V

    return-void
.end method

.method public d()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c:Lcom/wanmei/sdk/core/ui/floatview/a/d;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a/d;->e()V

    return-void
.end method
