.class final Lcom/wanmei/push/PushAgent$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent;->auth(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

.field final synthetic b:Lcom/wanmei/push/PushAgent;


# direct methods
.method constructor <init>(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    iput-object p2, p0, Lcom/wanmei/push/PushAgent$2;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Auth Success"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$200(Lcom/wanmei/push/PushAgent;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$300(Lcom/wanmei/push/PushAgent;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$400(Lcom/wanmei/push/PushAgent;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$2;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    :goto_0
    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$600(Lcom/wanmei/push/PushAgent;)V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->b:Lcom/wanmei/push/PushAgent;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$2;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-static {v0, v1}, Lcom/wanmei/push/PushAgent;->access$500(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    goto :goto_0
.end method

.method public final a(I)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$2;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-interface {v0, p1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openFail(I)V

    return-void
.end method
