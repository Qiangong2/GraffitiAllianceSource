.class public final Lcom/wanmei/push/c/b;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/c/a;


# instance fields
.field private a:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public final a(Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;)V
    .locals 6

    const/4 v5, 0x0

    invoke-static {}, Lcom/wanmei/push/g/i;->b()Z

    move-result v1

    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v0, "\u5f53\u524dROM\u7c7b\u578b\u4e3a\uff1a"

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz v1, :cond_2

    const-string v0, "MIUI"

    :goto_0
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/a;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/xiaomi/mipush/sdk/MiPushClient;->getRegId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "PERFECT_PUSH"

    const-string v1, "MiPush \u6ca1\u6709\u6ce8\u518c\u6210\u529f,\u975eMIUI\u8bbe\u5907\u65e0\u9700\u6ce8\u518c"

    invoke-static {v1}, Lcom/wanmei/push/a;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_1
    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openSuccess()V

    :cond_1
    return-void

    :cond_2
    const-string v0, "\u4e0d\u662fMIUI"

    goto :goto_0

    :cond_3
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "MiPush \u7684RegId:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v2}, Lcom/xiaomi/mipush/sdk/MiPushClient;->getRegId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lcom/wanmei/push/b;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    const-string v0, "PERFECT_PUSH"

    const-string v1, "\u65e0\u6cd5\u83b7\u53d6push sdk\u7684deviceId"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u8bbe\u7f6eMI PUSH Alias:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v2, v0, v5}, Lcom/xiaomi/mipush/sdk/MiPushClient;->setAlias(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    const-string v0, "PERFECT_PUSH"

    const-string v1, "\u65e0\u6cd5\u83b7\u53d6push appid"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "broadcast/"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u8bbe\u7f6eMI PUSH subscribe:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v1, v0, v5}, Lcom/xiaomi/mipush/sdk/MiPushClient;->subscribe(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5

    iget-object v0, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager$RunningAppProcessInfo;

    iget v4, v0, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v4, v2, :cond_0

    iget-object v0, v0, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v0, p1, p2}, Lcom/xiaomi/mipush/sdk/MiPushClient;->registerPush(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    new-instance v0, Lcom/wanmei/push/c/b$1;

    invoke-direct {v0, p0}, Lcom/wanmei/push/c/b$1;-><init>(Lcom/wanmei/push/c/b;)V

    iget-object v1, p0, Lcom/wanmei/push/c/b;->a:Landroid/content/Context;

    invoke-static {v1, v0}, Lcom/xiaomi/mipush/sdk/Logger;->setLogger(Landroid/content/Context;Lcom/xiaomi/channel/commonutils/logger/LoggerInterface;)V

    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
