.class public final Lcom/nineoldandroids/view/ViewHelper;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/nineoldandroids/view/ViewHelper$Honeycomb;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAlpha(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->a()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getAlpha(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getPivotX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->b()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getPivotX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getPivotY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->c()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getPivotY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getRotation(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->d()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getRotation(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getRotationX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->e()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getRotationX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getRotationY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->f()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getRotationY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getScaleX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->g()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getScaleX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getScaleY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->h()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getScaleY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getScrollX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->i()I

    move-result v0

    int-to-float v0, v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getScrollX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getScrollY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->j()I

    move-result v0

    int-to-float v0, v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getScrollY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getTranslationX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->k()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getTranslationX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getTranslationY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->l()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getTranslationY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getX(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->m()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getX(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static getY(Landroid/view/View;)F
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->n()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->getY(Landroid/view/View;)F

    move-result v0

    goto :goto_0
.end method

.method public static setAlpha(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "alpha"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->a(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setAlpha(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setPivotX(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "pivotX"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->b(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setPivotX(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setPivotY(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "pivotY"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->c(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setPivotY(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setRotation(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "rotation"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->d(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setRotation(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setRotationX(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "rotationX"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->e(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setRotationX(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setRotationY(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "rotationY"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->f(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setRotationY(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setScaleX(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "scaleX"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->g(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setScaleX(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setScaleY(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "scaleY"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->h(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setScaleY(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setScrollX(Landroid/view/View;I)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "scrollX"    # I

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->a(I)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setScrollX(Landroid/view/View;I)V

    goto :goto_0
.end method

.method public static setScrollY(Landroid/view/View;I)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "scrollY"    # I

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->b(I)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setScrollY(Landroid/view/View;I)V

    goto :goto_0
.end method

.method public static setTranslationX(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "translationX"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->i(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setTranslationX(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setTranslationY(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "translationY"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->j(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setTranslationY(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setX(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "x"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->k(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setX(Landroid/view/View;F)V

    goto :goto_0
.end method

.method public static setY(Landroid/view/View;F)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "y"    # F

    .prologue
    sget-boolean v0, Lcom/nineoldandroids/view/a/a;->a:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/nineoldandroids/view/a/a;->l(F)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1}, Lcom/nineoldandroids/view/ViewHelper$Honeycomb;->setY(Landroid/view/View;F)V

    goto :goto_0
.end method
