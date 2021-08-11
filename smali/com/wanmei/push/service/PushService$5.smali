.class final Lcom/wanmei/push/service/PushService$5;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/PushService;->c(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/PushService;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$5;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/push/service/PushService$b;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$5;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {v0, v1, v2}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;B)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method
