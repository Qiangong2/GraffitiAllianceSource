.class Lcom/wanmei/sdk/core/ui/floatview/b/b$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/ui/floatview/b/b;-><init>(Landroid/content/Context;Lcom/wanmei/sdk/core/ui/floatview/a;Ljava/lang/String;[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

.field final synthetic b:Lcom/wanmei/sdk/core/ui/floatview/b/b;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b/b;Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;->b:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    iput-object p2, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;->a:Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->getRunnable()Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b/b$1;->b:Lcom/wanmei/sdk/core/ui/floatview/b/b;

    iget-object v0, v0, Lcom/wanmei/sdk/core/ui/floatview/b/b;->b:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->b()V

    invoke-static {}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a()Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/ui/floatview/a/e;

    invoke-static {}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a()Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->b()Lcom/wanmei/sdk/core/ui/floatview/b;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/wanmei/sdk/core/ui/floatview/a/e;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a(Lcom/wanmei/sdk/core/ui/floatview/a/d;)V

    return-void
.end method
