.class final Lcom/wanmei/push/PushAgent$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent;->pullCertificate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/PushAgent;


# direct methods
.method constructor <init>(Lcom/wanmei/push/PushAgent;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$5;->a:Lcom/wanmei/push/PushAgent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 3

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "certificateFail  code is : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "certificateSuccess  appId : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   appkey:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/wanmei/push/c/b;

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$5;->a:Lcom/wanmei/push/PushAgent;

    invoke-static {v1}, Lcom/wanmei/push/PushAgent;->access$400(Lcom/wanmei/push/PushAgent;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wanmei/push/c/b;-><init>(Landroid/content/Context;)V

    invoke-interface {v0, p1, p2}, Lcom/wanmei/push/c/a;->a(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/wanmei/push/PushAgent$5$1;

    invoke-direct {v1, p0}, Lcom/wanmei/push/PushAgent$5$1;-><init>(Lcom/wanmei/push/PushAgent$5;)V

    invoke-interface {v0, v1}, Lcom/wanmei/push/c/a;->a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method
