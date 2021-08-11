.class Lcom/wanmei/sdk/core/task/a$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/task/a;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/task/a;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/task/a;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/task/a$1;->a:Lcom/wanmei/sdk/core/task/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/task/a$1;, "Lcom/wanmei/sdk/core/task/a.1;"
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a$1;->a:Lcom/wanmei/sdk/core/task/a;

    iget-object v0, v0, Lcom/wanmei/sdk/core/task/a;->b:Lcom/wanmei/sdk/core/net/f;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/f;->a()V

    return-void
.end method
