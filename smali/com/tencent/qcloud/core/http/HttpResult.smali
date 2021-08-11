.class public final Lcom/tencent/qcloud/core/http/HttpResult;
.super Ljava/lang/Object;
.source "HttpResult.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final code:I

.field private final content:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final message:Ljava/lang/String;

.field private final request:Lcom/tencent/qcloud/core/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/http/HttpResponse;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpResponse",
            "<TT;>;TT;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    .local p1, "response":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    .local p2, "content":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->code()I

    move-result v0

    iput v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->code:I

    .line 23
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->message()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->message:Ljava/lang/String;

    .line 24
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->headers()Lokhttp3/Headers;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Headers;->toMultimap()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->headers:Ljava/util/Map;

    .line 25
    iput-object p2, p0, Lcom/tencent/qcloud/core/http/HttpResult;->content:Ljava/lang/Object;

    .line 26
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpResponse;->request:Lcom/tencent/qcloud/core/http/HttpRequest;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->request:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 27
    return-void
.end method


# virtual methods
.method public asException()Lcom/tencent/qcloud/core/common/QCloudServiceException;
    .locals 2

    .prologue
    .line 54
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    new-instance v0, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpResult;->message:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/common/QCloudServiceException;-><init>(Ljava/lang/String;)V

    .line 55
    .local v0, "exception":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    iget v1, p0, Lcom/tencent/qcloud/core/http/HttpResult;->code:I

    invoke-virtual {v0, v1}, Lcom/tencent/qcloud/core/common/QCloudServiceException;->setStatusCode(I)V

    .line 56
    return-object v0
.end method

.method public code()I
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->code:I

    return v0
.end method

.method public content()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->content:Ljava/lang/Object;

    return-object v0
.end method

.method public header(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 60
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpResult;->headers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 61
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 62
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 65
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public headers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->headers:Ljava/util/Map;

    return-object v0
.end method

.method public final isSuccessful()Z
    .locals 2

    .prologue
    .line 50
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->code:I

    const/16 v1, 0xc8

    if-lt v0, v1, :cond_0

    iget v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->code:I

    const/16 v1, 0x12c

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public message()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->message:Ljava/lang/String;

    return-object v0
.end method

.method public request()Lcom/tencent/qcloud/core/http/HttpRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResult;->request:Lcom/tencent/qcloud/core/http/HttpRequest;

    return-object v0
.end method
