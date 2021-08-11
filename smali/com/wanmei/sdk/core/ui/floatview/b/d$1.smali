.class Lcom/wanmei/sdk/core/ui/floatview/b/d$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/nineoldandroids/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/ui/floatview/b/d;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/ui/floatview/b/d;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b/d;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b/d$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    return-void
.end method

.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/d$1;->a:Lcom/wanmei/sdk/core/ui/floatview/b/d;

    iget-object v0, v0, Lcom/wanmei/sdk/core/ui/floatview/b/d;->c:Landroid/widget/RelativeLayout;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    return-void
.end method

.method public onAnimationRepeat(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    return-void
.end method

.method public onAnimationStart(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    return-void
.end method
