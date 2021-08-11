.class public Lcom/tencent/qcloud/core/http/HttpRequest;
.super Ljava/lang/Object;
.source "HttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final calculateContentMD5:Z

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

.field private final method:Ljava/lang/String;

.field private final requestBody:Lokhttp3/RequestBody;

.field private final requestBuilder:Lokhttp3/Request$Builder;

.field private final responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final tag:Ljava/lang/Object;

.field private final url:Ljava/net/URL;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/http/HttpRequest$Builder;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    .local p1, "builder":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    .line 42
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    .line 43
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->headers:Ljava/util/Map;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    .line 44
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->method:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->method:Ljava/lang/String;

    .line 45
    iget-boolean v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->calculateContentMD5:Z

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->calculateContentMD5:Z

    .line 46
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->tag:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 47
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->tag:Ljava/lang/Object;

    .line 51
    :goto_0
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0}, Lokhttp3/HttpUrl$Builder;->build()Lokhttp3/HttpUrl;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/HttpUrl;->url()Ljava/net/URL;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->url:Ljava/net/URL;

    .line 53
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBodySerializer:Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    if-eqz v0, :cond_1

    .line 54
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBodySerializer:Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->body()Lokhttp3/RequestBody;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    .line 58
    :goto_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    iget-object v1, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->method:Ljava/lang/String;

    iget-object v2, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    invoke-virtual {v0, v1, v2}, Lokhttp3/Request$Builder;->method(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    .line 59
    return-void

    .line 49
    :cond_0
    iget-object v0, p1, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->tag:Ljava/lang/Object;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->tag:Ljava/lang/Object;

    goto :goto_0

    .line 56
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    goto :goto_1
.end method

.method static synthetic access$000(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ljava/util/Map;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-static {p0, p1, p2}, Lcom/tencent/qcloud/core/http/HttpRequest;->addHeaderNameValue(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static addHeaderNameValue(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 137
    .local p0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 138
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 139
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 140
    .restart local v0    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p0, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    :cond_0
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 143
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 79
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 80
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x1

    if-ge v1, v2, :cond_1

    .line 81
    :cond_0
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v1, p1, p2}, Lokhttp3/Request$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 82
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    invoke-static {v1, p1, p2}, Lcom/tencent/qcloud/core/http/HttpRequest;->addHeaderNameValue(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    :cond_1
    return-void
.end method

.method buildRealRequest()Lokhttp3/Request;
    .locals 1

    .prologue
    .line 125
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v0}, Lokhttp3/Request$Builder;->build()Lokhttp3/Request;

    move-result-object v0

    return-object v0
.end method

.method public contentLength()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    invoke-virtual {v0}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v0

    return-wide v0
.end method

.method public contentType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 104
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    invoke-virtual {v1}, Lokhttp3/RequestBody;->contentType()Lokhttp3/MediaType;

    move-result-object v0

    .line 105
    .local v0, "mediaType":Lokhttp3/MediaType;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lokhttp3/MediaType;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method getQCloudSigner()Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 133
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method getRequestBody()Lokhttp3/RequestBody;
    .locals 1

    .prologue
    .line 121
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBody:Lokhttp3/RequestBody;

    return-object v0
.end method

.method getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 117
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    return-object v0
.end method

.method getSignProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
    .locals 1

    .prologue
    .line 129
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public header(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 66
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 67
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

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
    .line 62
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    return-object v0
.end method

.method public host()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public method()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->method:Ljava/lang/String;

    return-object v0
.end method

.method public removeHeader(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 87
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->removeHeader(Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 88
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    return-void
.end method

.method setOkHttpRequestTag(Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 75
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->tag(Ljava/lang/Object;)Lokhttp3/Request$Builder;

    .line 76
    return-void
.end method

.method shouldCalculateContentMD5()Z
    .locals 1

    .prologue
    .line 92
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->calculateContentMD5:Z

    if-eqz v0, :cond_0

    const-string v0, "Content-MD5"

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/tencent/qcloud/core/util/QCloudStringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public tag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 71
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->tag:Ljava/lang/Object;

    return-object v0
.end method

.method public url()Ljava/net/URL;
    .locals 1

    .prologue
    .line 113
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest;->url:Ljava/net/URL;

    return-object v0
.end method
