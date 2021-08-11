.class final Lcom/wanmei/push/d/d$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/d/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/d/d;


# direct methods
.method constructor <init>(Lcom/wanmei/push/d/d;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 2
    .param p2, "iBinder"    # Landroid/os/IBinder;

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    invoke-static {p2}, Lcom/wanmei/push/a/b$a;->a(Landroid/os/IBinder;)Lcom/wanmei/push/a/b;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;Lcom/wanmei/push/a/b;)Lcom/wanmei/push/a/b;

    iget-object v0, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;Z)Z

    iget-object v0, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    invoke-static {v0}, Lcom/wanmei/push/d/d;->b(Lcom/wanmei/push/d/d;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public final onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;Lcom/wanmei/push/a/b;)Lcom/wanmei/push/a/b;

    iget-object v0, p0, Lcom/wanmei/push/d/d$2;->a:Lcom/wanmei/push/d/d;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;Z)Z

    return-void
.end method
