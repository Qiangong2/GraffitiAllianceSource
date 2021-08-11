.class public final Lcom/wanmei/push/b/e;
.super Lcom/wanmei/push/b/f;


# instance fields
.field private b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/wanmei/push/b/f;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    iput-object p1, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/b/e;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/push/b/e;)Ljava/util/Map;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    return-object v0
.end method


# virtual methods
.method protected final a()V
    .locals 4

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/wanmei/push/b/e$1;

    invoke-direct {v1, p0, v0}, Lcom/wanmei/push/b/e$1;-><init>(Lcom/wanmei/push/b/e;Ljava/util/Timer;)V

    const-wide/32 v2, 0x493e0

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    return-void
.end method

.method protected final a(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v1, "msgId"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/db/d;->a(Landroid/content/Context;)Lcom/wanmei/push/db/d;

    move-result-object v1

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v2, "msgId"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v2, Lcom/wanmei/push/e/a;->h:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lcom/wanmei/push/db/d;->a(Ljava/lang/String;Ljava/lang/String;)Z

    :cond_0
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/wanmei/push/b;->d(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V

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

    iget-object v1, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/wanmei/push/b;->d(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V

    return-void
.end method

.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v1, "msgId"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v1, "isOffline"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v1, Lcom/wanmei/push/bean/Notice$Builder;

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v2, "msgId"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v2, Lcom/wanmei/push/e/a;->h:Ljava/lang/String;

    invoke-direct {v1, v0, v2}, Lcom/wanmei/push/bean/Notice$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    const-string v2, "isOffline"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Lcom/wanmei/push/bean/Notice$Builder;->isoffline(Ljava/lang/String;)Lcom/wanmei/push/bean/Notice$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice$Builder;->build()Lcom/wanmei/push/bean/Notice;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    invoke-static {v1}, Lcom/wanmei/push/db/d;->a(Landroid/content/Context;)Lcom/wanmei/push/db/d;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/wanmei/push/db/d;->a(Ljava/lang/Object;)Z

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/g/h;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/b/e;->c:Landroid/content/Context;

    iget-object v1, p0, Lcom/wanmei/push/b/e;->b:Ljava/util/Map;

    invoke-static {v0, v1}, Lcom/wanmei/push/d/a;->c(Landroid/content/Context;Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lcom/wanmei/push/bean/StandardBaseResult;

    invoke-direct {v0}, Lcom/wanmei/push/bean/StandardBaseResult;-><init>()V

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/StandardBaseResult;->setCode(I)V

    goto :goto_0
.end method
