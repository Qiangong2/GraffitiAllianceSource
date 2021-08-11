.class public Lcom/wanmei/sdk/core/net/f;
.super Ljava/lang/Object;


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/pwrd/android/volley/RequestQueue;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/f;->a:Landroid/content/Context;

    :try_start_0
    const-string v0, "TLS"

    invoke-static {v0}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    const/4 v0, 0x1

    :try_start_1
    new-array v0, v0, [Ljavax/net/ssl/X509TrustManager;

    const/4 v2, 0x0

    new-instance v3, Lcom/wanmei/sdk/core/net/f$1;

    invoke-direct {v3, p0}, Lcom/wanmei/sdk/core/net/f$1;-><init>(Lcom/wanmei/sdk/core/net/f;)V

    aput-object v3, v0, v2

    const/4 v2, 0x0

    new-instance v3, Ljava/security/SecureRandom;

    invoke-direct {v3}, Ljava/security/SecureRandom;-><init>()V

    invoke-virtual {v1, v2, v0, v3}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    :try_end_1
    .catch Ljava/security/GeneralSecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_0
    if-eqz v1, :cond_0

    :try_start_2
    invoke-virtual {v1}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    invoke-static {v0}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    :cond_0
    new-instance v0, Lcom/wanmei/sdk/core/net/f$2;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/net/f$2;-><init>(Lcom/wanmei/sdk/core/net/f;)V

    invoke-static {v0}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    new-instance v0, Lcom/pwrd/android/volley/toolbox/HurlStack;

    const/4 v2, 0x0

    invoke-virtual {v1}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    invoke-direct {v0, v2, v1}, Lcom/pwrd/android/volley/toolbox/HurlStack;-><init>(Lcom/pwrd/android/volley/toolbox/HurlStack$UrlRewriter;Ljavax/net/ssl/SSLSocketFactory;)V

    invoke-static {p1, v0}, Lcom/pwrd/android/volley/toolbox/Volley;->newRequestQueue(Landroid/content/Context;Lcom/pwrd/android/volley/toolbox/HttpStack;)Lcom/pwrd/android/volley/RequestQueue;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/f;->b:Lcom/pwrd/android/volley/RequestQueue;

    :goto_1
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/security/GeneralSecurityException;->printStackTrace()V
    :try_end_2
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_1
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/f;->b:Lcom/pwrd/android/volley/RequestQueue;

    invoke-virtual {v0}, Lcom/pwrd/android/volley/RequestQueue;->stop()V

    return-void
.end method

.method public a(Ljava/lang/String;Lcom/wanmei/sdk/core/bean/CommReq;Ljava/lang/Class;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/bean/CommReq;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    const-string v0, "CsDownloader"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "POST: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppId()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/wanmei/sdk/core/bean/CommReq;->setAppId(I)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getChannelId()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/wanmei/sdk/core/bean/CommReq;->setChannelId(I)V

    new-instance v0, Lcom/wanmei/sdk/core/net/g$a;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/net/g$a;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/g$a;->b()Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/net/g$a;->a(Ljava/lang/String;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/g$a;->a()Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/wanmei/sdk/core/net/g$a;->a(Lcom/wanmei/sdk/core/bean/CommReq;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/net/g$a;->b(Ljava/lang/Class;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0, p4}, Lcom/wanmei/sdk/core/net/g$a;->a(Lcom/pwrd/android/volley/Response$Listener;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0, p5}, Lcom/wanmei/sdk/core/net/g$a;->a(Lcom/pwrd/android/volley/Response$ErrorListener;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/wanmei/sdk/core/net/g$a;->a(Ljava/lang/Class;)Lcom/wanmei/sdk/core/net/g$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/g$a;->c()Lcom/wanmei/sdk/core/net/g;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/f;->b:Lcom/pwrd/android/volley/RequestQueue;

    invoke-virtual {v1, v0}, Lcom/pwrd/android/volley/RequestQueue;->add(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/Request;

    return-void
.end method
