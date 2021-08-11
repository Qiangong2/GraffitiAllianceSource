.class public abstract Lcom/wanmei/push/b/f;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Object;",
        "Lcom/wanmei/push/bean/StandardBaseResult",
        "<*>;>;"
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/content/Context;

.field private c:Landroid/app/Dialog;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/push/b/f;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/push/b/f;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wanmei/push/b/f;-><init>(Landroid/content/Context;B)V

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 0

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    iput-object p1, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 0

    return-void
.end method

.method protected a(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    return-void
.end method

.method protected b(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    return-void
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    check-cast p1, Lcom/wanmei/push/bean/StandardBaseResult;

    iget-object v0, p0, Lcom/wanmei/push/b/f;->c:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b/f;->c:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/b/f;->c:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    if-eqz v0, :cond_1

    if-nez p1, :cond_2

    invoke-virtual {p0}, Lcom/wanmei/push/b/f;->a()V

    :cond_1
    :goto_0
    return-void

    :cond_2
    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    iget-object v0, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    const-string v1, "PERFECT_PUSH"

    const-string v2, "HttpResponseCode.default"

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    :cond_3
    invoke-virtual {p0, p1}, Lcom/wanmei/push/b/f;->b(Lcom/wanmei/push/bean/StandardBaseResult;)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    const-string v1, "PERFECT_PUSH"

    const-string v2, "HttpResponseCode.SUCCEED"

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcom/wanmei/push/b/f;->a(Lcom/wanmei/push/bean/StandardBaseResult;)V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    const-string v1, "PERFECT_PUSH"

    const-string v2, "HttpResponseCode.NETWORK_ERROR"

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/wanmei/push/b/f;->a()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected onPreExecute()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b/f;->b:Landroid/content/Context;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wanmei/push/b/f;->cancel(Z)Z

    :cond_0
    return-void
.end method
