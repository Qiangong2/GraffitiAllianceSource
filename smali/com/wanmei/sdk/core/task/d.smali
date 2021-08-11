.class public Lcom/wanmei/sdk/core/task/d;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/task/d$a;,
        Lcom/wanmei/sdk/core/task/d$b;
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/content/Context;

.field private c:Lcom/wanmei/sdk/core/task/d$a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/sdk/core/task/d;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/task/d;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/wanmei/sdk/core/task/d$a;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/task/d;->b:Landroid/content/Context;

    iput-object p2, p0, Lcom/wanmei/sdk/core/task/d;->c:Lcom/wanmei/sdk/core/task/d$a;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/task/d;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d;->b:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/task/d;)Lcom/wanmei/sdk/core/task/d$a;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d;->c:Lcom/wanmei/sdk/core/task/d$a;

    return-object v0
.end method

.method static synthetic b()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/task/d;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 3

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    new-instance v1, Lcom/wanmei/sdk/core/task/d$b;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/wanmei/sdk/core/task/d$b;-><init>(Lcom/wanmei/sdk/core/task/d;B)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :try_start_0
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->invokeAny(Ljava/util/Collection;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d;->c:Lcom/wanmei/sdk/core/task/d$a;

    invoke-interface {v0}, Lcom/wanmei/sdk/core/task/d$a;->onFail()V

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->printStackTrace()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d;->c:Lcom/wanmei/sdk/core/task/d$a;

    invoke-interface {v0}, Lcom/wanmei/sdk/core/task/d$a;->onFail()V

    goto :goto_0
.end method
