.class Lcom/wanmei/sdk/core/ui/floatview/b$2;
.super Landroid/os/Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/ui/floatview/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/ui/floatview/b;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const-wide/16 v2, 0x5

    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    :cond_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->e(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->h(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    if-gt v0, v1, :cond_1

    :goto_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->e(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->i(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->j(Lcom/wanmei/sdk/core/ui/floatview/b;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/b$2$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/ui/floatview/b$2$1;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b$2;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->e(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->h(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v1

    if-ge v0, v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->k(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b$2;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
