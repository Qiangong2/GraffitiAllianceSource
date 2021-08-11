.class public Lcom/wanmei/sdk/core/ui/floatview/a/e;
.super Lcom/wanmei/sdk/core/ui/floatview/a/d;


# direct methods
.method public constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/ui/floatview/a/d;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->f()Landroid/content/Context;

    move-result-object v1

    const-string v2, "comm_floatview_logo_normal"

    const-string v3, "drawable"

    invoke-static {v1, v2, v3}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Z)V

    return-void
.end method

.method public b()V
    .locals 4

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->b:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->f()Landroid/content/Context;

    move-result-object v1

    const-string v2, "comm_floatview_logo_normal"

    const-string v3, "drawable"

    invoke-static {v1, v2, v3}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->g()Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->h()Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/a/e;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-direct {v1, v2}, Lcom/wanmei/sdk/core/ui/floatview/a/e;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a(Lcom/wanmei/sdk/core/ui/floatview/a/d;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->h()Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/a/c;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a/e;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-direct {v1, v2}, Lcom/wanmei/sdk/core/ui/floatview/a/c;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a(Lcom/wanmei/sdk/core/ui/floatview/a/d;)V

    goto :goto_0
.end method
