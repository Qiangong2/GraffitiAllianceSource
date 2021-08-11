.class Lcom/wanmei/sdk/core/task/d$b;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/task/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/task/d;


# direct methods
.method private constructor <init>(Lcom/wanmei/sdk/core/task/d;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/task/d$b;->a:Lcom/wanmei/sdk/core/task/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/wanmei/sdk/core/task/d;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/task/d$b;-><init>(Lcom/wanmei/sdk/core/task/d;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Void;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d$b;->a:Lcom/wanmei/sdk/core/task/d;

    invoke-static {v0}, Lcom/wanmei/sdk/core/task/d;->a(Lcom/wanmei/sdk/core/task/d;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/support/multidex/MultiDex;->install(Landroid/content/Context;)V

    invoke-static {}, Lcom/wanmei/sdk/core/task/d;->b()Ljava/lang/String;

    move-result-object v0

    const-string v1, "LoadMutiDex done"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/d$b;->a:Lcom/wanmei/sdk/core/task/d;

    invoke-static {v0}, Lcom/wanmei/sdk/core/task/d;->b(Lcom/wanmei/sdk/core/task/d;)Lcom/wanmei/sdk/core/task/d$a;

    move-result-object v0

    invoke-interface {v0}, Lcom/wanmei/sdk/core/task/d$a;->onSuccess()V

    const/4 v0, 0x0

    return-object v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/task/d$b;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
