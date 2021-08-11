.class public Lcom/wanmei/push/receiver/PushStatusReceiver;
.super Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private updateHostAndSuccessorInfo(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->g(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->h(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "hostPackageName"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "hostPackageName"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    const-string v0, "hostPackageName"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/wanmei/push/d/c;->c(Landroid/content/Context;Ljava/lang/String;)V

    :cond_0
    const-string v0, "successorPackageName"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "successorPackageName"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    const-string v0, "successorPackageName"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/wanmei/push/d/c;->d(Landroid/content/Context;Ljava/lang/String;)V

    :cond_1
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const-string v0, "android.intent.action.PERFECT_PUSH_STATUS_START_SUCCESS"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-direct {p0, p1, p2}, Lcom/wanmei/push/receiver/PushStatusReceiver;->updateHostAndSuccessorInfo(Landroid/content/Context;Landroid/content/Intent;)V

    invoke-static {p1}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/d/d;->a()Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {p1}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/d/d;->a()Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    invoke-interface {v0}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openSuccess()V

    :cond_0
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] PushStatusReceiver onReceive() Push Start Success PushHostPackageName : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->g(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " PushSuccessorPackageName : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->h(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    const-string v0, "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] PushStatusReceiver onReceive() Push Start Fail"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/d/d;->a()Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {p1}, Lcom/wanmei/push/d/d;->a(Landroid/content/Context;)Lcom/wanmei/push/d/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/d/d;->a()Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    const/16 v1, 0x65

    invoke-interface {v0, v1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openFail(I)V

    goto :goto_0

    :cond_3
    const-string v0, "android.intent.action.PERFECT_PUSH_STATUS_REFRESH"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0, p1, p2}, Lcom/wanmei/push/receiver/PushStatusReceiver;->updateHostAndSuccessorInfo(Landroid/content/Context;Landroid/content/Intent;)V

    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] PushStatusReceiver onReceive() Push Refresh PushHostPackageName : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->g(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " PushSuccessorPackageName : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    invoke-static {p1}, Lcom/wanmei/push/d/c;->h(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/wanmei/push/g/f;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method
