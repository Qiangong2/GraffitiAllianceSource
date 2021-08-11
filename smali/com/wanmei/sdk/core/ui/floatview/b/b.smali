.class public abstract Lcom/wanmei/sdk/core/ui/floatview/b/b;
.super Ljava/lang/Object;


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/wanmei/sdk/core/ui/floatview/a;

.field protected c:Landroid/widget/RelativeLayout;

.field protected d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

.field protected e:I

.field protected f:[Landroid/widget/Button;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;Ljava/lang/String;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 9

    const/4 v8, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->b:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const-string v2, "layout"

    invoke-static {p1, p3, v2}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    const-string v2, "spread_content"

    const-string v3, "id"

    invoke-static {p1, v2, v3}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/ui/floatview/b/a;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->d:Lcom/wanmei/sdk/core/ui/floatview/b/a;

    array-length v0, p4

    new-array v0, v0, [Landroid/widget/Button;

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->f:[Landroid/widget/Button;

    move v0, v1

    :goto_0
    array-length v2, p4

    if-ge v0, v2, :cond_0

    aget-object v2, p4, v0

    new-instance v3, Landroid/widget/Button;

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a:Landroid/content/Context;

    invoke-direct {v3, v4}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    const/16 v4, 0x11

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setGravity(I)V

    invoke-virtual {v3, v1, v1, v1, v1}, Landroid/widget/Button;->setPadding(IIII)V

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a:Landroid/content/Context;

    const/high16 v5, 0x40e00000    # 7.0f

    invoke-static {v4, v5}, Lcom/wanmei/sdk/core/util/Util;->sp2px(Landroid/content/Context;F)I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setTextSize(F)V

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a:Landroid/content/Context;

    const-string v5, "comm_floatview_textcolor"

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const-string v7, "color"

    invoke-static {v4, v5, v7}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setTextColor(I)V

    iget-object v4, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a:Landroid/content/Context;

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->getIconName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/wanmei/sdk/core/util/j;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3, v8, v4, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v3, v1}, Landroid/widget/Button;->setBackgroundColor(I)V

    new-instance v4, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;

    invoke-direct {v4, p0, v2}, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b/b;Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->f:[Landroid/widget/Button;

    aput-object v3, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method protected abstract a()V
.end method

.method public a(I)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    return-void
.end method

.method protected abstract b()V
.end method

.method public c()V
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->e:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v0

    neg-int v0, v0

    iput v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->e:I

    :cond_0
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->a()V

    return-void
.end method

.method public d()V
    .locals 0

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/ui/floatview/b/b;->b()V

    return-void
.end method

.method public e()Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->c:Landroid/widget/RelativeLayout;

    return-object v0
.end method
