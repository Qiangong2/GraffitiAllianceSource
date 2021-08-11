.class public abstract Lcom/wanmei/sdk/core/task/a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<F:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected a:Landroid/app/Activity;

.field protected b:Lcom/wanmei/sdk/core/net/f;

.field private c:Landroid/app/ProgressDialog;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TF;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TF;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    iput-object p2, p0, Lcom/wanmei/sdk/core/task/a;->d:Ljava/lang/String;

    iput-object p3, p0, Lcom/wanmei/sdk/core/task/a;->e:Ljava/lang/Class;

    new-instance v0, Lcom/wanmei/sdk/core/net/f;

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/net/f;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/task/a;->b:Lcom/wanmei/sdk/core/net/f;

    if-eqz p4, :cond_0

    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0, p4}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setCanceledOnTouchOutside(Z)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    new-instance v1, Lcom/wanmei/sdk/core/task/a$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/task/a$1;-><init>(Lcom/wanmei/sdk/core/task/a;)V

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/task/a;)V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/task/a;->e()V

    return-void
.end method

.method private e()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    :cond_0
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->c:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/e;->a(Landroid/content/Context;)Lcom/wanmei/sdk/core/net/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/e;->a()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    invoke-direct {p0}, Lcom/wanmei/sdk/core/task/a;->e()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->a:Landroid/app/Activity;

    const-string v1, "\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u60a8\u5f53\u524d\u7684\u7f51\u7edc\u8fde\u63a5\u662f\u5426\u6b63\u5e38"

    const/16 v2, -0xa

    invoke-static {v0, v1, v2}, Lcom/wanmei/sdk/core/util/Toast;->makeToastOneSDKError(Landroid/content/Context;Ljava/lang/String;I)V

    const-string v0, "\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u60a8\u5f53\u524d\u7684\u7f51\u7edc\u8fde\u63a5\u662f\u5426\u6b63\u5e38"

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/task/a;->a(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/task/a;->b()V

    goto :goto_0
.end method

.method protected abstract a(Lcom/pwrd/android/volley/VolleyError;)V
.end method

.method protected abstract a(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TF;)V"
        }
    .end annotation
.end method

.method protected abstract a(Ljava/lang/String;)V
.end method

.method protected b()V
    .locals 6

    iget-object v0, p0, Lcom/wanmei/sdk/core/task/a;->b:Lcom/wanmei/sdk/core/net/f;

    iget-object v1, p0, Lcom/wanmei/sdk/core/task/a;->d:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/task/a;->d()Lcom/wanmei/sdk/core/bean/CommReq;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/sdk/core/task/a;->e:Ljava/lang/Class;

    new-instance v4, Lcom/wanmei/sdk/core/task/a$2;

    invoke-direct {v4, p0}, Lcom/wanmei/sdk/core/task/a$2;-><init>(Lcom/wanmei/sdk/core/task/a;)V

    new-instance v5, Lcom/wanmei/sdk/core/task/a$3;

    invoke-direct {v5, p0}, Lcom/wanmei/sdk/core/task/a$3;-><init>(Lcom/wanmei/sdk/core/task/a;)V

    invoke-virtual/range {v0 .. v5}, Lcom/wanmei/sdk/core/net/f;->a(Ljava/lang/String;Lcom/wanmei/sdk/core/bean/CommReq;Ljava/lang/Class;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    return-void
.end method

.method public c()V
    .locals 0

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/task/a;->a()V

    return-void
.end method

.method public abstract d()Lcom/wanmei/sdk/core/bean/CommReq;
.end method
