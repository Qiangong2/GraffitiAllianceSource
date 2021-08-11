.class public Lcom/tencent/cos/xml/transfer/CopyObjectService;
.super Ljava/lang/Object;
.source "CopyObjectService.java"


# instance fields
.field private cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

.field private maxSliceSize:J


# direct methods
.method public constructor <init>(Lcom/tencent/cos/xml/CosXmlService;)V
    .locals 2
    .param p1, "cosXmlService"    # Lcom/tencent/cos/xml/CosXmlService;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const-wide/32 v0, 0x500000

    iput-wide v0, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->maxSliceSize:J

    .line 31
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    .line 32
    return-void
.end method

.method private completeMultipart(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    .locals 3
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
            ">;)",
            "Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 126
    .local p4, "partNumberAndEtag":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/String;>;"
    new-instance v0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 128
    .local v0, "completeMultiUploadRequest":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    invoke-virtual {v2, v0}, Lcom/tencent/cos/xml/CosXmlService;->completeMultiUpload(Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v1

    .line 129
    .local v1, "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    return-object v1
.end method

.method private copyObjectForLargeFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;J)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    .locals 22
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .param p4, "sourceLength"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 83
    invoke-direct/range {p0 .. p2}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->initMultiUpload(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 84
    .local v8, "uploadId":Ljava/lang/String;
    new-instance v16, Ljava/util/LinkedHashMap;

    invoke-direct/range {v16 .. v16}, Ljava/util/LinkedHashMap;-><init>()V

    .line 85
    .local v16, "partNumberAndEtag":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/String;>;"
    const/4 v7, 0x1

    .line 86
    .local v7, "partNumber":I
    const-wide/16 v10, 0x0

    .line 87
    .local v10, "start":J
    const-wide/16 v12, -0x1

    .line 88
    .local v12, "end":J
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->maxSliceSize:J

    move-wide/from16 v18, v0

    .line 91
    .local v18, "sliceSize":J
    :goto_0
    const-wide/16 v4, 0x1

    sub-long v4, p4, v4

    cmp-long v4, v12, v4

    if-ltz v4, :cond_0

    .line 101
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, v16

    invoke-direct {v0, v1, v2, v8, v3}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->completeMultipart(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v14

    .line 102
    .local v14, "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    return-object v14

    .line 92
    .end local v14    # "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    :cond_0
    const-wide/16 v4, 0x1

    add-long v10, v12, v4

    .line 93
    add-long v4, v12, v18

    const-wide/16 v20, 0x1

    sub-long v20, p4, v20

    cmp-long v4, v4, v20

    if-ltz v4, :cond_1

    const-wide/16 v4, 0x1

    sub-long v12, p4, v4

    :goto_1
    move-object/from16 v4, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v9, p3

    .line 95
    invoke-direct/range {v4 .. v13}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->copyObjectForLargeFile(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;JJ)Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;

    move-result-object v15

    .line 96
    .local v15, "copyObjectResult":Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iget-object v5, v15, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;->copyObject:Lcom/tencent/cos/xml/model/tag/CopyObject;

    iget-object v5, v5, Lcom/tencent/cos/xml/model/tag/CopyObject;->eTag:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-interface {v0, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 93
    .end local v15    # "copyObjectResult":Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;
    :cond_1
    add-long v12, v12, v18

    goto :goto_1
.end method

.method private copyObjectForLargeFile(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;JJ)Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;
    .locals 10
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "uploadId"    # Ljava/lang/String;
    .param p5, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .param p6, "start"    # J
    .param p8, "end"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 118
    new-instance v0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    move-wide/from16 v6, p6

    move-wide/from16 v8, p8

    invoke-direct/range {v0 .. v9}, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;JJ)V

    .line 120
    .local v0, "uploadPartCopyRequest":Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    invoke-virtual {v1, v0}, Lcom/tencent/cos/xml/CosXmlService;->copyObject(Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;)Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;

    move-result-object v1

    return-object v1
.end method

.method private copyObjectForSmallFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 75
    new-instance v0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V

    .line 76
    .local v0, "copyObjectRequest":Lcom/tencent/cos/xml/model/object/CopyObjectRequest;
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    invoke-virtual {v1, v0}, Lcom/tencent/cos/xml/CosXmlService;->copyObject(Lcom/tencent/cos/xml/model/object/CopyObjectRequest;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    move-result-object v1

    return-object v1
.end method

.method private headObject(Ljava/lang/String;Ljava/lang/String;)J
    .locals 6
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;

    invoke-direct {v0, p1, p2}, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    .local v0, "headObjectRequest":Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    invoke-virtual {v3, v0}, Lcom/tencent/cos/xml/CosXmlService;->headObject(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;)Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    move-result-object v1

    .line 65
    .local v1, "headObjectResult":Lcom/tencent/cos/xml/model/object/HeadObjectResult;
    if-eqz v1, :cond_0

    .line 66
    iget-object v3, v1, Lcom/tencent/cos/xml/model/object/HeadObjectResult;->headers:Ljava/util/Map;

    const-string v4, "Content-Length"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 67
    .local v2, "length":Ljava/lang/String;
    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 69
    .end local v2    # "length":Ljava/lang/String;
    :goto_0
    return-wide v4

    :cond_0
    const-wide/16 v4, -0x1

    goto :goto_0
.end method

.method private initMultiUpload(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 106
    new-instance v0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    invoke-direct {v0, p1, p2}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    .local v0, "initMultipartUploadRequest":Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;
    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    invoke-virtual {v3, v0}, Lcom/tencent/cos/xml/CosXmlService;->initMultipartUpload(Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;)Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    move-result-object v1

    .line 108
    .local v1, "initMultipartUploadResult":Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;
    iget-object v3, v1, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;->initMultipartUpload:Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;

    iget-object v2, v3, Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;->uploadId:Ljava/lang/String;

    .line 109
    .local v2, "uploadId":Ljava/lang/String;
    return-object v2
.end method


# virtual methods
.method public copyObject(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)Lcom/tencent/cos/xml/model/CosXmlResult;
    .locals 6
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p3, Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;->bucket:Ljava/lang/String;

    iget-object v1, p3, Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;->cosPath:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->headObject(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v4

    .line 42
    .local v4, "sourceLength":J
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->maxSliceSize:J

    cmp-long v0, v4, v0

    if-ltz v0, :cond_0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    .line 43
    invoke-direct/range {v0 .. v5}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->copyObjectForLargeFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;J)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v0

    .line 45
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->copyObjectForSmallFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    move-result-object v0

    goto :goto_0
.end method

.method public copyObject(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;J)Lcom/tencent/cos/xml/model/CosXmlResult;
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .param p4, "sourceObjectLength"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/CopyObjectService;->maxSliceSize:J

    cmp-long v0, p4, v0

    if-ltz v0, :cond_0

    .line 55
    invoke-direct/range {p0 .. p5}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->copyObjectForLargeFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;J)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v0

    .line 57
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/tencent/cos/xml/transfer/CopyObjectService;->copyObjectForSmallFile(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    move-result-object v0

    goto :goto_0
.end method
