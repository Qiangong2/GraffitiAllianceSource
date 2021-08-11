.class final Lcom/wanmei/push/b/d$2;
.super Ljava/util/TimerTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/b/d;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/Timer;

.field final synthetic b:Lcom/wanmei/push/b/d;


# direct methods
.method constructor <init>(Lcom/wanmei/push/b/d;Ljava/util/Timer;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/b/d$2;->b:Lcom/wanmei/push/b/d;

    iput-object p2, p0, Lcom/wanmei/push/b/d$2;->a:Ljava/util/Timer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    new-instance v0, Lcom/wanmei/push/b/d;

    iget-object v1, p0, Lcom/wanmei/push/b/d$2;->b:Lcom/wanmei/push/b/d;

    invoke-static {v1}, Lcom/wanmei/push/b/d;->a(Lcom/wanmei/push/b/d;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/b/d$2;->b:Lcom/wanmei/push/b/d;

    invoke-static {v2}, Lcom/wanmei/push/b/d;->b(Lcom/wanmei/push/b/d;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/b/d$2;->b:Lcom/wanmei/push/b/d;

    invoke-static {v3}, Lcom/wanmei/push/b/d;->c(Lcom/wanmei/push/b/d;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/wanmei/push/b/d;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/d;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    iget-object v0, p0, Lcom/wanmei/push/b/d$2;->a:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    return-void
.end method
