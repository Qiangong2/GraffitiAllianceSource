.class public final Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "CompleteMultiUploadRequest.java"


# instance fields
.field private completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

.field private uploadId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "uploadId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p4, "partNumberAndETag":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->uploadId:Ljava/lang/String;

    .line 46
    new-instance v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    .line 47
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;->parts:Ljava/util/List;

    .line 48
    invoke-virtual {p0, p4}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->setPartNumberAndETag(Ljava/util/Map;)V

    .line 49
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
    .line 137
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 138
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->uploadId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 139
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "uploadID must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :cond_0
    return-void
.end method

.method public getCompleteMultipartUpload()Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    const-string v0, "POST"

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
    .line 113
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploadID"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->uploadId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->queryParameters:Ljava/util/Map;

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 123
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    .line 124
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlSlimBuilder;->buildCompleteMultipartUpload(Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;)Ljava/lang/String;

    move-result-object v2

    .line 123
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 125
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 127
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 128
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getUploadId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->uploadId:Ljava/lang/String;

    return-object v0
.end method

.method public setPartNumberAndETag(ILjava/lang/String;)V
    .locals 2
    .param p1, "partNumbers"    # I
    .param p2, "eTag"    # Ljava/lang/String;

    .prologue
    .line 62
    new-instance v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;-><init>()V

    .line 63
    .local v0, "part":Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
    iput p1, v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->partNumber:I

    .line 64
    iput-object p2, v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->eTag:Ljava/lang/String;

    .line 65
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    iget-object v1, v1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;->parts:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 66
    return-void
.end method

.method public setPartNumberAndETag(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 72
    .local p1, "partNumberAndETag":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    .line 74
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 75
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/lang/String;>;"
    new-instance v1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;

    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;-><init>()V

    .line 76
    .local v1, "part":Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iput v2, v1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->partNumber:I

    .line 77
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, v1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->eTag:Ljava/lang/String;

    .line 78
    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;

    iget-object v2, v2, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;->parts:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 81
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/lang/String;>;"
    .end local v1    # "part":Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
    :cond_0
    return-void
.end method

.method public setUploadId(Ljava/lang/String;)V
    .locals 0
    .param p1, "uploadId"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->uploadId:Ljava/lang/String;

    .line 89
    return-void
.end method
