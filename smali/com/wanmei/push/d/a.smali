.class public final Lcom/wanmei/push/d/a;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/wanmei/push/d/a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/wanmei/push/d/a;

    invoke-direct {v0}, Lcom/wanmei/push/d/a;-><init>()V

    sput-object v0, Lcom/wanmei/push/d/a;->a:Lcom/wanmei/push/d/a;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/push/e/b;->a(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static a()Lcom/wanmei/push/d/a;
    .locals 1

    sget-object v0, Lcom/wanmei/push/d/a;->a:Lcom/wanmei/push/d/a;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/a;

    invoke-direct {v0, p0}, Lcom/wanmei/push/b/a;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/a;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    new-instance v0, Lcom/wanmei/push/b/d;

    invoke-direct {v0, p0, p1, p2}, Lcom/wanmei/push/b/d;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/d;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static b(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/e/b;->a()Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static b(Landroid/content/Context;Ljava/util/Map;)V
    .locals 4
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

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/h;

    invoke-direct {v0, p0, p1}, Lcom/wanmei/push/b/h;-><init>(Landroid/content/Context;Ljava/util/Map;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/h;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static c(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v1

    const-string v0, ""

    invoke-static {}, Lcom/wanmei/push/g/i;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v0, "xiaomi"

    :cond_0
    invoke-virtual {v1, v0}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static c(Landroid/content/Context;Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/push/e/b;->b(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static d(Landroid/content/Context;)V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/i;

    invoke-direct {v0, p0}, Lcom/wanmei/push/b/i;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/i;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static d(Landroid/content/Context;Ljava/util/Map;)V
    .locals 4
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

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/e;

    invoke-direct {v0, p0, p1}, Lcom/wanmei/push/b/e;-><init>(Landroid/content/Context;Ljava/util/Map;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/e;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static e(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/e/b;->b()Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static e(Landroid/content/Context;Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/push/e/b;->c(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public static f(Landroid/content/Context;)V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/g;

    invoke-direct {v0, p0}, Lcom/wanmei/push/b/g;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/g;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static f(Landroid/content/Context;Ljava/util/Map;)V
    .locals 4
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

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/b;

    invoke-direct {v0, p0, p1}, Lcom/wanmei/push/b/b;-><init>(Landroid/content/Context;Ljava/util/Map;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static g(Landroid/content/Context;)V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/c;

    invoke-direct {v0, p0}, Lcom/wanmei/push/b/c;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/c;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static h(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Lcom/wanmei/push/bean/SyncAppInfo;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/wanmei/push/e/b;->a(Landroid/content/Context;)Lcom/wanmei/push/e/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/e/b;->c()Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method
