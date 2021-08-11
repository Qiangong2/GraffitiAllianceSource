.class final Lcom/wanmei/push/b$1;
.super Ljava/util/TimerTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/b;->a(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Ljava/util/Timer;

.field final synthetic c:Lcom/wanmei/push/b;


# direct methods
.method constructor <init>(Lcom/wanmei/push/b;Landroid/content/Context;Ljava/util/Timer;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/b$1;->c:Lcom/wanmei/push/b;

    iput-object p2, p0, Lcom/wanmei/push/b$1;->a:Landroid/content/Context;

    iput-object p3, p0, Lcom/wanmei/push/b$1;->b:Ljava/util/Timer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v0, p0, Lcom/wanmei/push/b$1;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/a;->a(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/wanmei/push/b$1;->b:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    return-void
.end method
