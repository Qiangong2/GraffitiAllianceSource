.class Lcom/wanmei/sdk/core/ui/floatview/b$2$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/ui/floatview/b$2;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/ui/floatview/b$2;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b$2;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b$2;

    iget-object v0, v0, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b$2;

    iget-object v1, v1, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/ui/floatview/b;->e(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b$2$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b$2;

    iget-object v2, v2, Lcom/wanmei/sdk/core/ui/floatview/b$2;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-static {v2}, Lcom/wanmei/sdk/core/ui/floatview/b;->f(Lcom/wanmei/sdk/core/ui/floatview/b;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/sdk/core/ui/floatview/a;->a(II)V

    return-void
.end method
