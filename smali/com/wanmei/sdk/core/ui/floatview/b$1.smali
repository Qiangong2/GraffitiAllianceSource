.class Lcom/wanmei/sdk/core/ui/floatview/b$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnTouchListener;


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

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x0

    const/high16 v5, 0x42c80000    # 100.0f

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v2

    float-to-int v2, v2

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v4}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/sdk/core/ui/floatview/a;->c()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    sub-int v4, v0, v4

    invoke-static {v3, v4}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;I)I

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v4}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/sdk/core/ui/floatview/a;->d()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    sub-int v4, v2, v4

    invoke-static {v3, v4}, Lcom/wanmei/sdk/core/ui/floatview/b;->b(Lcom/wanmei/sdk/core/ui/floatview/b;I)I

    int-to-float v0, v0

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v3}, Lcom/wanmei/sdk/core/ui/floatview/b;->b(Lcom/wanmei/sdk/core/ui/floatview/b;)F

    move-result v3

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    cmpl-float v0, v0, v5

    if-gez v0, :cond_0

    int-to-float v0, v2

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v2}, Lcom/wanmei/sdk/core/ui/floatview/b;->c(Lcom/wanmei/sdk/core/ui/floatview/b;)F

    move-result v2

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    cmpl-float v0, v0, v5

    if-ltz v0, :cond_2

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    and-int/lit16 v2, v2, 0xff

    packed-switch v2, :pswitch_data_0

    :cond_1
    :goto_1
    return v1

    :cond_2
    move v0, v1

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v2

    float-to-int v2, v2

    int-to-float v2, v2

    invoke-static {v0, v2}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;F)F

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v2

    float-to-int v2, v2

    int-to-float v2, v2

    invoke-static {v0, v2}, Lcom/wanmei/sdk/core/ui/floatview/b;->b(Lcom/wanmei/sdk/core/ui/floatview/b;F)F

    goto :goto_1

    :pswitch_1
    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->d(Lcom/wanmei/sdk/core/ui/floatview/b;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a;

    move-result-object v0

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v2}, Lcom/wanmei/sdk/core/ui/floatview/b;->e(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v2

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v3}, Lcom/wanmei/sdk/core/ui/floatview/b;->f(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Lcom/wanmei/sdk/core/ui/floatview/a;->a(II)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->g(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->c()V

    goto :goto_1

    :pswitch_2
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->g(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->d()V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
