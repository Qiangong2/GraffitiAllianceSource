.class public Lcom/wanmei/sdk/core/ui/floatview/b/c;
.super Lcom/wanmei/sdk/core/ui/floatview/b/b;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 8

    const/4 v7, -0x2

    const/4 v6, 0x0

    const-string v0, "comm_view_floatview_spreadtoleft"

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/wanmei/sdk/core/ui/floatview/b/b;-><init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;Ljava/lang/String;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->f:[Landroid/widget/Button;

    array-length v0, v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_1

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->f:[Landroid/widget/Button;

    aget-object v2, v2, v0

    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v7, v7}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2, v3}, Lcom/wanmei/sdk/core/ui/floatview/b/a;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    if-eqz v0, :cond_0

    new-instance v1, Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a:Landroid/content/Context;

    invoke-direct {v1, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a:Landroid/content/Context;

    const-string v3, "comm_floatview_seperater"

    invoke-static {v2, v3}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a:Landroid/content/Context;

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-static {v3, v4}, Lcom/wanmei/sdk/core/util/Util;->dip2px(Landroid/content/Context;F)I

    move-result v3

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a:Landroid/content/Context;

    const/high16 v5, 0x41f00000    # 30.0f

    invoke-static {v4, v5}, Lcom/wanmei/sdk/core/util/Util;->dip2px(Landroid/content/Context;F)I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->a:Landroid/content/Context;

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Lcom/wanmei/sdk/core/util/Util;->dip2px(Landroid/content/Context;F)I

    move-result v3

    invoke-virtual {v2, v6, v6, v6, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    iget-object v3, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

    invoke-virtual {v3, v1, v2}, Lcom/wanmei/sdk/core/ui/floatview/b/a;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_1
    return-void
.end method


# virtual methods
.method public a()V
    .locals 5

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

    const-string v1, "paddingRight"

    const/4 v2, 0x2

    new-array v2, v2, [I

    const/4 v3, 0x0

    iget v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->e:I

    aput v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->b:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v4}, Lcom/wanmei/sdk/core/ui/floatview/a;->e()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    add-int/lit8 v4, v4, 0x0

    aput v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Lcom/nineoldandroids/animation/ObjectAnimator;->setDuration(J)Lcom/nineoldandroids/animation/ObjectAnimator;

    invoke-virtual {v0}, Lcom/nineoldandroids/animation/ObjectAnimator;->start()V

    return-void
.end method

.method public b()V
    .locals 5

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

    const-string v1, "paddingRight"

    const/4 v2, 0x2

    new-array v2, v2, [I

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->b:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v4}, Lcom/wanmei/sdk/core/ui/floatview/a;->e()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    add-int/lit8 v4, v4, 0x0

    aput v4, v2, v3

    const/4 v3, 0x1

    iget v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/c;->e:I

    aput v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Lcom/nineoldandroids/animation/ObjectAnimator;->setDuration(J)Lcom/nineoldandroids/animation/ObjectAnimator;

    invoke-virtual {v0}, Lcom/nineoldandroids/animation/ObjectAnimator;->start()V

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/b/c$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/ui/floatview/b/c$1;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b/c;)V

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/animation/ObjectAnimator;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    return-void
.end method
