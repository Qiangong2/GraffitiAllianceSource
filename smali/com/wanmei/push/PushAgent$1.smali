.class final Lcom/wanmei/push/PushAgent$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent;->pullAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
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

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$1;->b:Lcom/wanmei/push/PushAgent;

    iput-object p2, p0, Lcom/wanmei/push/PushAgent$1;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$1;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-interface {v0, p1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openFail(I)V

    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "pullAppInfo:appId:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "    appKey:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$1;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0, p1, p2}, Lcom/wanmei/push/PushAgent;->access$000(Lcom/wanmei/push/PushAgent;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$1;->b:Lcom/wanmei/push/PushAgent;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$1;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-static {v0, v1}, Lcom/wanmei/push/PushAgent;->access$100(Lcom/wanmei/push/PushAgent;Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method
