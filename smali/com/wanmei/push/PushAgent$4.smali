.class final Lcom/wanmei/push/PushAgent$4;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$f;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent;->syncDeviceAppInfo(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
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

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$4;->b:Lcom/wanmei/push/PushAgent;

    iput-object p2, p0, Lcom/wanmei/push/PushAgent$4;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Sync DeviceAppInfo Fail, Try Open Push"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$4;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$400(Lcom/wanmei/push/PushAgent;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$4;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    return-void
.end method

.method public final a(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/wanmei/push/bean/SyncAppInfo;

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/SyncAppInfo;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/SyncAppInfo;->getAppInfoList()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/push/bean/SyncAppInfo;->getAppInfoList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/push/bean/SyncAppInfo;->getAppInfoList()Ljava/util/List;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;

    new-instance v3, Lcom/wanmei/push/bean/AppInfo;

    invoke-direct {v3}, Lcom/wanmei/push/bean/AppInfo;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/wanmei/push/bean/AppInfo;->setAppClientId(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->getBundleId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/wanmei/push/bean/AppInfo;->setPackageName(Ljava/lang/String;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/PushAgent$4;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$700(Lcom/wanmei/push/PushAgent;)Lcom/wanmei/push/service/d;

    move-result-object v0

    iget-object v2, p0, Lcom/wanmei/push/PushAgent$4;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v2}, Lcom/wanmei/push/PushAgent;->access$700(Lcom/wanmei/push/PushAgent;)Lcom/wanmei/push/service/d;

    invoke-static {v1}, Lcom/wanmei/push/service/d;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_1
    const-string v0, "PERFECT_PUSH"

    const-string v1, "Sync DeviceAppInfo Success, Try Open Push"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/PushAgent$4;->b:Lcom/wanmei/push/PushAgent;

    invoke-static {v0}, Lcom/wanmei/push/PushAgent;->access$400(Lcom/wanmei/push/PushAgent;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/PushAgent$4;->a:Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V

    :cond_2
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method
