.class final Lcom/wanmei/push/service/PushService$7;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$g;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/bean/AppInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/bean/AppInfo;

.field final synthetic b:Lcom/wanmei/push/service/PushService;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/PushService;Lcom/wanmei/push/bean/AppInfo;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$7;->b:Lcom/wanmei/push/service/PushService;

    iput-object p2, p0, Lcom/wanmei/push/service/PushService$7;->a:Lcom/wanmei/push/bean/AppInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$7;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "[PushService sendAppStateUpdateToServer Success] ["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/PushService$7;->a:Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v3}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] Has Removed"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final b()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$7;->b:Lcom/wanmei/push/service/PushService;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "[PushService sendAppStateUpdateToServer Fail] ["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wanmei/push/service/PushService$7;->a:Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v3}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] Has Removed"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
