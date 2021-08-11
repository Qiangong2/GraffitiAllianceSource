.class public Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "ListBucketVersionsRequest.java"


# instance fields
.field private delimiter:Ljava/lang/String;

.field private encodingType:Ljava/lang/String;

.field private keyMarker:Ljava/lang/String;

.field private maxKeys:Ljava/lang/String;

.field private prefix:Ljava/lang/String;

.field private versionIdMarker:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 21
    const-string v0, "1000"

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->maxKeys:Ljava/lang/String;

    .line 26
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    const-string v0, "GET"

    return-object v0
.end method

.method public getQueryString()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "versions"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->prefix:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "prefix"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->prefix:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->keyMarker:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 75
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "key-marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->keyMarker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->versionIdMarker:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 78
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "version-id-marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->versionIdMarker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->delimiter:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 81
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "delimiter"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->delimiter:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->encodingType:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 84
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "encoding-type"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->encodingType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    :cond_4
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->maxKeys:Ljava/lang/String;

    const-string v1, "1000"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 87
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "max-keys"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->maxKeys:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    :cond_5
    invoke-super {p0}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 35
    const/4 v0, 0x0

    return-object v0
.end method

.method public setDelimiter(Ljava/lang/String;)V
    .locals 0
    .param p1, "delimiter"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->delimiter:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setEncodingType(Ljava/lang/String;)V
    .locals 0
    .param p1, "encodingType"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->encodingType:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setKeyMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "keyMarker"    # Ljava/lang/String;

    .prologue
    .line 45
    if-eqz p1, :cond_0

    .line 46
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->keyMarker:Ljava/lang/String;

    .line 48
    :cond_0
    return-void
.end method

.method public setMaxKeys(I)V
    .locals 1
    .param p1, "maxKeys"    # I

    .prologue
    .line 65
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->maxKeys:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setPrefix(Ljava/lang/String;)V
    .locals 0
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 39
    if-eqz p1, :cond_0

    .line 40
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->prefix:Ljava/lang/String;

    .line 42
    :cond_0
    return-void
.end method

.method public setVersionIdMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "versionIdMarker"    # Ljava/lang/String;

    .prologue
    .line 51
    if-eqz p1, :cond_0

    .line 52
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;->versionIdMarker:Ljava/lang/String;

    .line 54
    :cond_0
    return-void
.end method
