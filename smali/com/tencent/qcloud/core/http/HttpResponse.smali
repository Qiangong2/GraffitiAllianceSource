.class public final Lcom/tencent/qcloud/core/http/HttpResponse;
.super Ljava/lang/Object;
.source "HttpResponse.java"


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
.field final request:Lcom/tencent/qcloud/core/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;"
        }
    .end annotation
.end field

.field final response:Lokhttp3/Response;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/http/HttpRequest;Lokhttp3/Response;)V
    .locals 0
    .param p2, "response"    # Lokhttp3/Response;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;",
            "Lokhttp3/Response;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    .local p1, "request":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->request:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 27
    iput-object p2, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    .line 28
    return-void
.end method

.method public static checkResponseSuccessful(Lcom/tencent/qcloud/core/http/HttpResponse;)V
    .locals 3
    .param p0, "response"    # Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 71
    if-nez p0, :cond_0

    .line 72
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    const-string v2, "response is null"

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/common/QCloudServiceException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 74
    :cond_0
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpResponse;->isSuccessful()Z

    move-result v1

    if-nez v1, :cond_1

    .line 75
    new-instance v0, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpResponse;->message()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/common/QCloudServiceException;-><init>(Ljava/lang/String;)V

    .line 76
    .local v0, "exception":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpResponse;->code()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/tencent/qcloud/core/common/QCloudServiceException;->setStatusCode(I)V

    .line 77
    throw v0

    .line 79
    .end local v0    # "exception":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    :cond_1
    return-void
.end method


# virtual methods
.method public final byteStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 55
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->byteStream()Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0
.end method

.method public final bytes()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->bytes()[B

    move-result-object v0

    goto :goto_0
.end method

.method public code()I
    .locals 1

    .prologue
    .line 35
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->code()I

    move-result v0

    return v0
.end method

.method public final contentLength()J
    .locals 2

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->contentLength()J

    move-result-wide v0

    goto :goto_0
.end method

.method public header(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 43
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0, p1}, Lokhttp3/Response;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
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
    .line 47
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->headers()Lokhttp3/Headers;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/Headers;->toMultimap()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final isSuccessful()Z
    .locals 1

    .prologue
    .line 67
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->isSuccessful()Z

    move-result v0

    if-eqz v0, :cond_0

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
    .line 39
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->message()Ljava/lang/String;

    move-result-object v0

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
    .line 31
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->request:Lcom/tencent/qcloud/core/http/HttpRequest;

    return-object v0
.end method

.method public final string()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v0}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 83
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    const-string v1, "http code = %d, http message = %s %nheader is %s"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 84
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpResponse;->code()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpResponse;->message()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v4}, Lokhttp3/Response;->headers()Lokhttp3/Headers;

    move-result-object v4

    invoke-virtual {v4}, Lokhttp3/Headers;->toMultimap()Ljava/util/Map;

    move-result-object v4

    aput-object v4, v2, v3

    .line 83
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
