.class Lcom/wanmei/sdk/core/task/a$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/pwrd/android/volley/Response$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/task/a;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/pwrd/android/volley/Response$Listener",
        "<TF;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/task/a;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/task/a;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/task/a$2;->a:Lcom/wanmei/sdk/core/task/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onResponse(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TF;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/task/a$2;, "Lcom/wanmei/sdk/core/task/a.2;"
    .local p1, "arg0":Ljava/lang/Object;, "TF;"
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a$2;->a:Lcom/wanmei/sdk/core/task/a;

    invoke-static {v0}, Lcom/wanmei/sdk/core/task/a;->a(Lcom/wanmei/sdk/core/task/a;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a$2;->a:Lcom/wanmei/sdk/core/task/a;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/task/a;->a(Ljava/lang/Object;)V

    return-void
.end method
