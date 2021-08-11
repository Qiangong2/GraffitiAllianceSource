.class public final Lcom/tencent/qcloud/core/http/QCloudHttpClient;
.super Ljava/lang/Object;
.source "QCloudHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;
    }
.end annotation


# static fields
.field private static final DEFAULT:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

.field static final HTTP_LOG_TAG:Ljava/lang/String; = "QCloudHttp"


# instance fields
.field private final logInterceptor:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

.field private mHostnameVerifier:Ljavax/net/ssl/HostnameVerifier;

.field private final okHttpClient:Lokhttp3/OkHttpClient;

.field private final taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

.field private final verifiedHost:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->build()Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    move-result-object v0

    sput-object v0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->DEFAULT:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    return-void
.end method

.method private constructor <init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;)V
    .locals 5
    .param p1, "b"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;

    .prologue
    const/4 v3, 0x1

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v1, Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;

    invoke-direct {v1, p0}, Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)V

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->mHostnameVerifier:Ljavax/net/ssl/HostnameVerifier;

    .line 70
    new-instance v1, Ljava/util/HashSet;

    const/4 v2, 0x5

    invoke-direct {v1, v2}, Ljava/util/HashSet;-><init>(I)V

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->verifiedHost:Ljava/util/Set;

    .line 71
    invoke-static {}, Lcom/tencent/qcloud/core/task/TaskManager;->getInstance()Lcom/tencent/qcloud/core/task/TaskManager;

    move-result-object v1

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    .line 73
    new-instance v1, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v1}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    .line 74
    invoke-virtual {v1, v3}, Lokhttp3/OkHttpClient$Builder;->followRedirects(Z)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    .line 75
    invoke-virtual {v1, v3}, Lokhttp3/OkHttpClient$Builder;->followSslRedirects(Z)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->mHostnameVerifier:Ljavax/net/ssl/HostnameVerifier;

    .line 76
    invoke-virtual {v1, v2}, Lokhttp3/OkHttpClient$Builder;->hostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    .line 78
    .local v0, "builder":Lokhttp3/OkHttpClient$Builder;
    iget v1, p1, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->connectionTimeout:I

    int-to-long v2, v1

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Lokhttp3/OkHttpClient$Builder;->connectTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    iget v2, p1, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->socketTimeout:I

    int-to-long v2, v2

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 79
    invoke-virtual {v1, v2, v3, v4}, Lokhttp3/OkHttpClient$Builder;->readTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    iget v2, p1, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->socketTimeout:I

    int-to-long v2, v2

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 80
    invoke-virtual {v1, v2, v3, v4}, Lokhttp3/OkHttpClient$Builder;->writeTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 82
    new-instance v1, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    new-instance v2, Lcom/tencent/qcloud/core/http/QCloudHttpClient$2;

    invoke-direct {v2, p0}, Lcom/tencent/qcloud/core/http/QCloudHttpClient$2;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)V

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;-><init>(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;)V

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->logInterceptor:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    .line 88
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->logInterceptor:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    sget-object v2, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->NONE:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    invoke-virtual {v1, v2}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->setLevel(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;)Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    .line 89
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->logInterceptor:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->addInterceptor(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 90
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->setDebuggable(Z)V

    .line 92
    new-instance v1, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;

    invoke-direct {v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;-><init>()V

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient$Builder;->addInterceptor(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 94
    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->build()Lokhttp3/OkHttpClient;

    move-result-object v1

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->okHttpClient:Lokhttp3/OkHttpClient;

    .line 95
    return-void
.end method

.method synthetic constructor <init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;
    .param p2, "x1"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;)V

    return-void
.end method

.method static synthetic access$000(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->verifiedHost:Ljava/util/Set;

    return-object v0
.end method

.method public static getDefault()Lcom/tencent/qcloud/core/http/QCloudHttpClient;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->DEFAULT:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    return-object v0
.end method

.method private handleRequest(Lcom/tencent/qcloud/core/http/HttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;
    .locals 2
    .param p2, "credentialProvider"    # Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;",
            "Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpTask",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 128
    .local p1, "request":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    const-string v0, "Host"

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpRequest;->host()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    new-instance v0, Lcom/tencent/qcloud/core/http/HttpTask;

    invoke-direct {v0, p1, p2, p0}, Lcom/tencent/qcloud/core/http/HttpTask;-><init>(Lcom/tencent/qcloud/core/http/HttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;Lcom/tencent/qcloud/core/http/QCloudHttpClient;)V

    return-object v0
.end method


# virtual methods
.method public addVerifiedHost(Ljava/lang/String;)V
    .locals 1
    .param p1, "hostname"    # Ljava/lang/String;

    .prologue
    .line 58
    if-eqz p1, :cond_0

    .line 59
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->verifiedHost:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 61
    :cond_0
    return-void
.end method

.method getOkHttpCall(Lokhttp3/Request;)Lokhttp3/Call;
    .locals 1
    .param p1, "okHttpRequest"    # Lokhttp3/Request;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->okHttpClient:Lokhttp3/OkHttpClient;

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient;->newCall(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    return-object v0
.end method

.method public getTasksByTag(Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .param p1, "tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/http/HttpTask;",
            ">;"
        }
    .end annotation

    .prologue
    .line 98
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 99
    .local v2, "tasks":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/http/HttpTask;>;"
    if-nez p1, :cond_1

    .line 110
    :cond_0
    return-object v2

    .line 103
    :cond_1
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    invoke-virtual {v3}, Lcom/tencent/qcloud/core/task/TaskManager;->snapshot()Ljava/util/List;

    move-result-object v1

    .line 104
    .local v1, "taskManagerSnapshot":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/task/Task;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/task/Task;

    .line 105
    .local v0, "task":Lcom/tencent/qcloud/core/task/Task;
    instance-of v4, v0, Lcom/tencent/qcloud/core/http/HttpTask;

    if-eqz v4, :cond_2

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/task/Task;->getTag()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 106
    check-cast v0, Lcom/tencent/qcloud/core/http/HttpTask;

    .end local v0    # "task":Lcom/tencent/qcloud/core/task/Task;
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public resolveRequest(Lcom/tencent/qcloud/core/http/HttpRequest;)Lcom/tencent/qcloud/core/http/HttpTask;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;)",
            "Lcom/tencent/qcloud/core/http/HttpTask",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, "request":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->handleRequest(Lcom/tencent/qcloud/core/http/HttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v0

    return-object v0
.end method

.method public resolveRequest(Lcom/tencent/qcloud/core/http/QCloudHttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;
    .locals 1
    .param p2, "credentialProvider"    # Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest",
            "<TT;>;",
            "Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpTask",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "request":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->handleRequest(Lcom/tencent/qcloud/core/http/HttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v0

    return-object v0
.end method

.method public setDebuggable(Z)V
    .locals 2
    .param p1, "debuggable"    # Z

    .prologue
    .line 64
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->logInterceptor:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    if-nez p1, :cond_0

    const-string v0, "QCloudHttp"

    invoke-static {v0}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->isTagLoggable(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    sget-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->BODY:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    :goto_0
    invoke-virtual {v1, v0}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->setLevel(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;)Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;

    .line 67
    return-void

    .line 64
    :cond_1
    sget-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->NONE:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    goto :goto_0
.end method
