.class final Lcom/wanmei/push/d/d$1;
.super Lcom/wanmei/push/a/a$a;


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

    iput-object p1, p0, Lcom/wanmei/push/d/d$1;->a:Lcom/wanmei/push/d/d;

    invoke-direct {p0}, Lcom/wanmei/push/a/a$a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/d/d$1;->a:Lcom/wanmei/push/d/d;

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;)Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/d/d$1;->a:Lcom/wanmei/push/d/d;

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;)Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    invoke-interface {v0}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openSuccess()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "RegistCallBack Call openPushSuccess Error"

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public final a(I)V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/d/d$1;->a:Lcom/wanmei/push/d/d;

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;)Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/d/d$1;->a:Lcom/wanmei/push/d/d;

    invoke-static {v0}, Lcom/wanmei/push/d/d;->a(Lcom/wanmei/push/d/d;)Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;

    move-result-object v0

    const/16 v1, 0x65

    invoke-interface {v0, v1}, Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;->openFail(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "PERFECT_PUSH"

    const-string v2, "RegistCallBack Call openPushFail Error"

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
