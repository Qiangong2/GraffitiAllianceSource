.class public final Lcom/wanmei/push/b/a;
.super Lcom/wanmei/push/b/f;


# instance fields
.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/b/f;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/b/a;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method protected final a()V
    .locals 4

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/wanmei/push/b/a$1;

    invoke-direct {v1, p0, v0}, Lcom/wanmei/push/b/a$1;-><init>(Lcom/wanmei/push/b/a;Ljava/util/Timer;)V

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    return-void
.end method

.method protected final a(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/wanmei/push/b;->a(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V

    return-void
.end method

.method protected final b(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/wanmei/push/b;->a(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V

    return-void
.end method

.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/g/h;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/b/a;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/wanmei/push/bean/StandardBaseResult;

    invoke-direct {v0}, Lcom/wanmei/push/bean/StandardBaseResult;-><init>()V

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/StandardBaseResult;->setCode(I)V

    goto :goto_0
.end method
