.class public final Lcom/tencent/cos/xml/model/object/ListPartsRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "ListPartsRequest.java"


# instance fields
.field private encodingType:Ljava/lang/String;

.field private maxParts:Ljava/lang/String;

.field private partNumberMarker:Ljava/lang/String;

.field private uploadId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "uploadId"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method public checkParameters()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 63
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 64
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 65
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "uploadID must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    return-void
.end method

.method public getEncodingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->encodingType:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxParts()I
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->maxParts:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    const-string v0, "GET"

    return-object v0
.end method

.method public getPartNumberMarker()I
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->partNumberMarker:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
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
    .line 41
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploadID"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->maxParts:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 45
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "max-parts"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->maxParts:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->partNumberMarker:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 48
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "part-number-marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->maxParts:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->encodingType:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 51
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "Encoding-type"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->encodingType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->queryParameters:Ljava/util/Map;

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    return-object v0
.end method

.method public getUploadId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    return-object v0
.end method

.method public setEncodingType(Ljava/lang/String;)V
    .locals 0
    .param p1, "encodingType"    # Ljava/lang/String;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->encodingType:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setMaxParts(I)V
    .locals 1
    .param p1, "maxParts"    # I

    .prologue
    .line 90
    if-gtz p1, :cond_0

    const/4 p1, 0x1

    .line 91
    :cond_0
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->maxParts:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setPartNumberMarker(I)V
    .locals 1
    .param p1, "partNumberMarker"    # I

    .prologue
    .line 107
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->partNumberMarker:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setUploadId(Ljava/lang/String;)V
    .locals 0
    .param p1, "uploadId"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;->uploadId:Ljava/lang/String;

    .line 75
    return-void
.end method
