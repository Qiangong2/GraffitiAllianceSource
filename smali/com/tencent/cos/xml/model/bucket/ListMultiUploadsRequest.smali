.class public final Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "ListMultiUploadsRequest.java"


# instance fields
.field private delimiter:Ljava/lang/String;

.field private encodingType:Ljava/lang/String;

.field private keyMarker:Ljava/lang/String;

.field private maxUploads:Ljava/lang/String;

.field private prefix:Ljava/lang/String;

.field private uploadIdMarker:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 46
    return-void
.end method


# virtual methods
.method public getDelimiter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->delimiter:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->encodingType:Ljava/lang/String;

    return-object v0
.end method

.method public getKeyMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->keyMarker:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxUploads()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->maxUploads:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    const-string v0, "GET"

    return-object v0
.end method

.method public getPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->prefix:Ljava/lang/String;

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
    .line 55
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploads"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->delimiter:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "delimiter"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->delimiter:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->encodingType:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 60
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "Encoding-type"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->encodingType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->prefix:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 63
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "Prefix"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->prefix:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->maxUploads:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 66
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "max-uploads"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->maxUploads:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->keyMarker:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 69
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "key-marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->keyMarker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    :cond_4
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->uploadIdMarker:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 72
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "upload-id-marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->uploadIdMarker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_5
    invoke-super {p0}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    return-object v0
.end method

.method public getUploadIdMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->uploadIdMarker:Ljava/lang/String;

    return-object v0
.end method

.method public setDelimiter(Ljava/lang/String;)V
    .locals 0
    .param p1, "delimiter"    # Ljava/lang/String;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->delimiter:Ljava/lang/String;

    .line 95
    return-void
.end method

.method public setEncodingType(Ljava/lang/String;)V
    .locals 0
    .param p1, "encodingType"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->encodingType:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setKeyMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "keyMarker"    # Ljava/lang/String;

    .prologue
    .line 140
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->keyMarker:Ljava/lang/String;

    .line 141
    return-void
.end method

.method public setMaxUploads(Ljava/lang/String;)V
    .locals 0
    .param p1, "maxUploads"    # Ljava/lang/String;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->maxUploads:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setPrefix(Ljava/lang/String;)V
    .locals 0
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->prefix:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public setUploadIdMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "uploadIdMarker"    # Ljava/lang/String;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;->uploadIdMarker:Ljava/lang/String;

    .line 197
    return-void
.end method
