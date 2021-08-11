.class public Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
.super Ljava/lang/Object;
.source "HttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/HttpRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
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
.field calculateContentMD5:Z

.field headers:Ljava/util/Map;
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

.field httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

.field isCacheEnabled:Z

.field method:Ljava/lang/String;

.field requestBodySerializer:Lcom/tencent/qcloud/core/http/RequestBodySerializer;

.field requestBuilder:Lokhttp3/Request$Builder;

.field responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
            "<TT;>;"
        }
    .end annotation
.end field

.field tag:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 162
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->headers:Ljava/util/Map;

    .line 160
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->isCacheEnabled:Z

    .line 163
    new-instance v0, Lokhttp3/HttpUrl$Builder;

    invoke-direct {v0}, Lokhttp3/HttpUrl$Builder;-><init>()V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    .line 164
    new-instance v0, Lokhttp3/Request$Builder;

    invoke-direct {v0}, Lokhttp3/Request$Builder;-><init>()V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    .line 165
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 253
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 254
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/Request$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 255
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->headers:Ljava/util/Map;

    invoke-static {v0, p1, p2}, Lcom/tencent/qcloud/core/http/HttpRequest;->access$000(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    :cond_0
    return-object p0
.end method

.method public addHeaders(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 261
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    .local p1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    if-eqz p1, :cond_2

    .line 262
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 263
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 264
    .local v1, "name":Ljava/lang/String;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 265
    .local v2, "value":Ljava/lang/String;
    if-eqz v1, :cond_1

    if-eqz v2, :cond_1

    .line 266
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v5, v1, v2}, Lokhttp3/Request$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 267
    invoke-static {p1, v1, v2}, Lcom/tencent/qcloud/core/http/HttpRequest;->access$000(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 272
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v1    # "name":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_2
    return-object p0
.end method

.method public body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 0
    .param p1, "bodySerializer"    # Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/RequestBodySerializer;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 292
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBodySerializer:Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    .line 293
    return-object p0
.end method

.method public build()Lcom/tencent/qcloud/core/http/HttpRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 313
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->prepareBuild()V

    .line 314
    new-instance v0, Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-direct {v0, p0}, Lcom/tencent/qcloud/core/http/HttpRequest;-><init>(Lcom/tencent/qcloud/core/http/HttpRequest$Builder;)V

    return-object v0
.end method

.method public contentMD5()Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 248
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->calculateContentMD5:Z

    .line 249
    return-object p0
.end method

.method public converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
            "<TT;>;)",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 297
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    .local p1, "responseBodyConverter":Lcom/tencent/qcloud/core/http/ResponseBodyConverter;, "Lcom/tencent/qcloud/core/http/ResponseBodyConverter<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    .line 298
    return-object p0
.end method

.method public encodedQuery(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 217
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    if-eqz p1, :cond_0

    .line 218
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/HttpUrl$Builder;->addEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 220
    :cond_0
    return-object p0
.end method

.method public encodedQuery(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 236
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    .local p1, "nameValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 237
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 238
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 239
    .local v1, "name":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 240
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v1, v2}, Lokhttp3/HttpUrl$Builder;->addEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    goto :goto_0

    .line 244
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    return-object p0
.end method

.method public host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "host"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 187
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->host(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 188
    return-object p0
.end method

.method public method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 0
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 205
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->method:Ljava/lang/String;

    .line 206
    return-object p0
.end method

.method public path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 192
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    const-string v0, "/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 198
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 199
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->addPathSegments(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 201
    :cond_1
    return-object p0
.end method

.method protected prepareBuild()V
    .locals 2

    .prologue
    .line 302
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v1}, Lokhttp3/HttpUrl$Builder;->build()Lokhttp3/HttpUrl;

    move-result-object v1

    invoke-virtual {v0, v1}, Lokhttp3/Request$Builder;->url(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;

    .line 303
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->isCacheEnabled:Z

    if-nez v0, :cond_0

    .line 304
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    sget-object v1, Lokhttp3/CacheControl;->FORCE_NETWORK:Lokhttp3/CacheControl;

    invoke-virtual {v0, v1}, Lokhttp3/Request$Builder;->cacheControl(Lokhttp3/CacheControl;)Lokhttp3/Request$Builder;

    .line 306
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    if-nez v0, :cond_1

    .line 308
    invoke-static {}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter;->string()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->responseBodyConverter:Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    .line 310
    :cond_1
    return-void
.end method

.method public query(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 210
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    if-eqz p1, :cond_0

    .line 211
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0, p1, p2}, Lokhttp3/HttpUrl$Builder;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 213
    :cond_0
    return-object p0
.end method

.method public query(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 224
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    .local p1, "nameValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 225
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 226
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 227
    .local v1, "name":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 228
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v1, v2}, Lokhttp3/HttpUrl$Builder;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    goto :goto_0

    .line 232
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    return-object p0
.end method

.method public removeHeader(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 276
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/Request$Builder;->removeHeader(Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 277
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    return-object p0
.end method

.method public scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1
    .param p1, "scheme"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 177
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    invoke-virtual {v0, p1}, Lokhttp3/HttpUrl$Builder;->scheme(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;

    .line 178
    return-object p0
.end method

.method public setUseCache(Z)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 0
    .param p1, "cacheEnabled"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 287
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iput-boolean p1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->isCacheEnabled:Z

    .line 288
    return-object p0
.end method

.method public tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 0
    .param p1, "tag"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 182
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->tag:Ljava/lang/Object;

    .line 183
    return-object p0
.end method

.method public url(Ljava/net/URL;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 4
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URL;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 168
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    invoke-static {p1}, Lokhttp3/HttpUrl;->get(Ljava/net/URL;)Lokhttp3/HttpUrl;

    move-result-object v0

    .line 169
    .local v0, "httpUrl":Lokhttp3/HttpUrl;
    if-nez v0, :cond_0

    .line 170
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "url is not legal : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 172
    :cond_0
    invoke-virtual {v0}, Lokhttp3/HttpUrl;->newBuilder()Lokhttp3/HttpUrl$Builder;

    move-result-object v1

    iput-object v1, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->httpUrlBuilder:Lokhttp3/HttpUrl$Builder;

    .line 173
    return-object p0
.end method

.method public userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 2
    .param p1, "userAgent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 282
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/HttpRequest$Builder<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->requestBuilder:Lokhttp3/Request$Builder;

    const-string v1, "User-Agent"

    invoke-virtual {v0, v1, p1}, Lokhttp3/Request$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    .line 283
    return-object p0
.end method
