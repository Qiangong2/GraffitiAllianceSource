.class final Lcom/wanmei/push/b/c$2;
.super Ljava/util/TimerTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/b/c;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/Timer;

.field final synthetic b:Lcom/wanmei/push/b/c;


# direct methods
.method constructor <init>(Lcom/wanmei/push/b/c;Ljava/util/Timer;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/b/c$2;->b:Lcom/wanmei/push/b/c;

    iput-object p2, p0, Lcom/wanmei/push/b/c$2;->a:Ljava/util/Timer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcom/wanmei/push/b/c;

    iget-object v1, p0, Lcom/wanmei/push/b/c$2;->b:Lcom/wanmei/push/b/c;

    invoke-static {v1}, Lcom/wanmei/push/b/c;->a(Lcom/wanmei/push/b/c;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wanmei/push/b/c;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b/c;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    iget-object v0, p0, Lcom/wanmei/push/b/c$2;->a:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    return-void
.end method
