.class public final Lcom/wanmei/push/b/c;
.super Lcom/wanmei/push/b/f;


# instance fields
.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/b/f;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/b/c;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Lcom/wanmei/push/bean/CertificateInfo;
    .locals 6

    new-instance v1, Lcom/wanmei/push/bean/CertificateInfo;

    invoke-direct {v1}, Lcom/wanmei/push/bean/CertificateInfo;-><init>()V

    if-nez p1, :cond_0

    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    new-instance v0, Lcom/wanmei/push/b/c$1;

    invoke-direct {v0, p0}, Lcom/wanmei/push/b/c$1;-><init>(Lcom/wanmei/push/b/c;)V

    invoke-static {p1, v0}, Lcom/wanmei/push/e/e;->a(Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/CertificateInfo;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    move-object v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v2, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    const-string v3, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendStandardPostRequest "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v3, v0}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method protected final a()V
    .locals 4

    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/wanmei/push/b/c$2;

    invoke-direct {v1, p0, v0}, Lcom/wanmei/push/b/c$2;-><init>(Lcom/wanmei/push/b/c;Ljava/util/Timer;)V

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    return-void
.end method

.method protected final a(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    :try_start_0
    invoke-virtual {p1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/CertificateInfo;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, p1, v2, v3}, Lcom/wanmei/push/b;->b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v1

    iget-object v2, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/CertificateInfo;->getXmAppId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/wanmei/push/bean/CertificateInfo;->getXmAppKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, p1, v3, v0}, Lcom/wanmei/push/b;->b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    const-string v2, "PERFECT_PUSH"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "PullCertificateTask  onSuccess"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-virtual {v0, v1, p1, v2, v2}, Lcom/wanmei/push/b;->b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected final b(Lcom/wanmei/push/bean/StandardBaseResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;)V"
        }
    .end annotation

    const/4 v2, 0x0

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-virtual {v0, v1, p1, v2, v2}, Lcom/wanmei/push/b;->b(Landroid/content/Context;Lcom/wanmei/push/bean/StandardBaseResult;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    .prologue
    new-instance v0, Lcom/wanmei/push/bean/StandardBaseResult;

    invoke-direct {v0}, Lcom/wanmei/push/bean/StandardBaseResult;-><init>()V

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-static {v1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/g/h;->b()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/StandardBaseResult;->setCode(I)V

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    iget-object v1, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-static {v1}, Lcom/wanmei/push/d/a;->c(Landroid/content/Context;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/b/c;->b:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientSecret()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/wanmei/push/bean/StandardBaseResult;->getResult()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/wanmei/push/g/b;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/push/b/c;->a(Ljava/lang/String;)Lcom/wanmei/push/bean/CertificateInfo;

    move-result-object v2

    new-instance v0, Lcom/wanmei/push/bean/StandardBaseResult;

    invoke-direct {v0}, Lcom/wanmei/push/bean/StandardBaseResult;-><init>()V

    invoke-virtual {v0, v2}, Lcom/wanmei/push/bean/StandardBaseResult;->setResult(Ljava/lang/Object;)V

    invoke-virtual {v1}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/wanmei/push/bean/StandardBaseResult;->setCode(I)V

    invoke-virtual {v1}, Lcom/wanmei/push/bean/StandardBaseResult;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/StandardBaseResult;->setMessage(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    invoke-virtual {v1}, Lcom/wanmei/push/bean/StandardBaseResult;->getCode()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/StandardBaseResult;->setCode(I)V

    goto :goto_0
.end method
