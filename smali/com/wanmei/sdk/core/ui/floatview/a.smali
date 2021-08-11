.class public Lcom/wanmei/sdk/core/ui/floatview/a;
.super Ljava/lang/Object;


# instance fields
.field private a:Landroid/content/Context;

.field private b:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

.field private c:Landroid/view/WindowManager;

.field private d:Landroid/widget/ImageView;

.field private e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

.field private f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

.field private g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

.field private h:Landroid/view/WindowManager$LayoutParams;

.field private i:Landroid/view/WindowManager$LayoutParams;


# direct methods
.method public constructor <init>(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 9

    const/16 v8, 0x8

    const/4 v5, 0x1

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    const/4 v4, -0x2

    const/4 v3, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->a:Landroid/content/Context;

    iput-object p3, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->b:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    const-string v0, "window"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const-string v1, "comm_view_floatview_axis"

    const-string v2, "layout"

    invoke-static {p1, v1, v2}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput v5, v0, Landroid/view/WindowManager$LayoutParams;->format:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    const/16 v1, 0x7d2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->type:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput v8, v0, Landroid/view/WindowManager$LayoutParams;->flags:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    const/16 v1, 0x33

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->width:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getHeight()I

    move-result v2

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    packed-switch p2, :pswitch_data_0

    :goto_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iput v5, v0, Landroid/view/WindowManager$LayoutParams;->format:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    const/16 v1, 0x7d2

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->type:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iput v8, v0, Landroid/view/WindowManager$LayoutParams;->flags:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->width:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/b/d;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->a:Landroid/content/Context;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->b:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    invoke-direct {v0, v1, p0, v2}, Lcom/wanmei/sdk/core/ui/floatview/b/d;-><init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/b/c;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->a:Landroid/content/Context;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->b:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    invoke-direct {v0, v1, p0, v2}, Lcom/wanmei/sdk/core/ui/floatview/b/c;-><init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b/d;->e()Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b/c;->e()Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    :pswitch_0
    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto :goto_0

    :pswitch_1
    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v2}, Ljava/math/BigDecimal;-><init>(I)V

    new-instance v2, Ljava/math/BigDecimal;

    invoke-direct {v2, v6, v7}, Ljava/math/BigDecimal;-><init>(D)V

    invoke-virtual {v0, v2}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    invoke-virtual {v0}, Ljava/math/BigDecimal;->intValue()I

    move-result v0

    iput v0, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto :goto_0

    :pswitch_2
    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto :goto_0

    :pswitch_3
    iput v0, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto :goto_0

    :pswitch_4
    iput v0, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v2}, Ljava/math/BigDecimal;-><init>(I)V

    new-instance v2, Ljava/math/BigDecimal;

    invoke-direct {v2, v6, v7}, Ljava/math/BigDecimal;-><init>(D)V

    invoke-virtual {v0, v2}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    invoke-virtual {v0}, Ljava/math/BigDecimal;->intValue()I

    move-result v0

    iput v0, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto/16 :goto_0

    :pswitch_5
    iput v0, v1, Landroid/view/WindowManager$LayoutParams;->x:I

    iput v2, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method


# virtual methods
.method public a()V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    const/4 v1, 0x2

    new-array v1, v1, [I

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v2, v1}, Landroid/widget/ImageView;->getLocationOnScreen([I)V

    aget v1, v1, v3

    div-int/lit8 v0, v0, 0x2

    if-gt v1, v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    const/16 v1, 0x33

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    :goto_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    invoke-virtual {v0, v3}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iput v3, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iget v1, v1, Landroid/view/WindowManager$LayoutParams;->y:I

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->e()Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c()V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->i:Landroid/view/WindowManager$LayoutParams;

    const/16 v1, 0x35

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    goto :goto_0
.end method

.method public a(I)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    return-void
.end method

.method public declared-synchronized a(II)V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput p1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    iput p2, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->h:Landroid/view/WindowManager$LayoutParams;

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public a(Landroid/view/View$OnTouchListener;)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    return-void
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->d()V

    return-void
.end method

.method public c()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v0

    return v0
.end method

.method public d()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getMeasuredHeight()I

    move-result v0

    return v0
.end method

.method public e()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getWidth()I

    move-result v0

    return v0
.end method

.method public f()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    return-void
.end method

.method public g()V
    .locals 2

    const/4 v1, 0x4

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a(I)V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/b/d;->a(I)V

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    :cond_2
    return-void
.end method

.method public h()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->g:Lcom/wanmei/sdk/core/ui/floatview/b/c;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b/c;->e()Landroid/view/View;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeViewImmediate(Landroid/view/View;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->f:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/ui/floatview/b/d;->e()Landroid/view/View;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeViewImmediate(Landroid/view/View;)V

    iput-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->e:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->c:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeViewImmediate(Landroid/view/View;)V

    iput-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/a;->d:Landroid/widget/ImageView;

    :cond_0
    return-void
.end method
