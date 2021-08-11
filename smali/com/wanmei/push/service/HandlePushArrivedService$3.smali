.class final Lcom/wanmei/push/service/HandlePushArrivedService$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$e;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/HandlePushArrivedService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/bean/PushMessage;

.field final synthetic b:Lcom/wanmei/push/service/HandlePushArrivedService;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/HandlePushArrivedService;Lcom/wanmei/push/bean/PushMessage;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    iput-object p2, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->a:Lcom/wanmei/push/bean/PushMessage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    invoke-virtual {v3}, Lcom/wanmei/push/service/HandlePushArrivedService;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "][HandlePushArrivedService sendReceiptToServer Success] PushMessage:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->a:Lcom/wanmei/push/bean/PushMessage;

    invoke-virtual {v3}, Lcom/wanmei/push/bean/PushMessage;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final b()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    invoke-virtual {v3}, Lcom/wanmei/push/service/HandlePushArrivedService;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "][HandlePushArrivedService sendReceiptToServer Fail] PushMessage:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/service/HandlePushArrivedService$3;->a:Lcom/wanmei/push/bean/PushMessage;

    invoke-virtual {v3}, Lcom/wanmei/push/bean/PushMessage;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
