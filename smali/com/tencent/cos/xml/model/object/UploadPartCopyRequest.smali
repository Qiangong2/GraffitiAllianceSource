.class public Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;
.super Lcom/tencent/cos/xml/model/object/CopyObjectRequest;
.source "UploadPartCopyRequest.java"


# instance fields
.field private partNumber:I

.field private uploadId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V
    .locals 10
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "uploadId"    # Ljava/lang/String;
    .param p5, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    const-wide/16 v6, -0x1

    .line 29
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    move-wide v8, v6

    invoke-direct/range {v0 .. v9}, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;JJ)V

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;JJ)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "uploadId"    # Ljava/lang/String;
    .param p5, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .param p6, "start"    # J
    .param p8, "end"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p5}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V

    .line 24
    const/4 v0, -0x1

    iput v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->partNumber:I

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->uploadId:Ljava/lang/String;

    .line 35
    iput p3, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->partNumber:I

    .line 36
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->uploadId:Ljava/lang/String;

    .line 37
    invoke-virtual {p0, p6, p7, p8, p9}, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->setCopyRange(JJ)V

    .line 38
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
    .line 49
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->checkParameters()V

    .line 50
    iget v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->partNumber:I

    if-gtz v0, :cond_0

    .line 51
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "partNumber must be >= 1"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->uploadId:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 54
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "uploadID must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_1
    return-void
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
    .line 42
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "partNumber"

    iget v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->partNumber:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploadId"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->uploadId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public setCopyRange(JJ)V
    .locals 5
    .param p1, "start"    # J
    .param p3, "end"    # J

    .prologue
    .line 59
    const-wide/16 v2, 0x0

    cmp-long v1, p1, v2

    if-ltz v1, :cond_0

    cmp-long v1, p3, p1

    if-ltz v1, :cond_0

    .line 60
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bytes="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "bytes":Ljava/lang/String;
    const-string v1, "x-cos-copy-source-range"

    invoke-virtual {p0, v1, v0}, Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    .end local v0    # "bytes":Ljava/lang/String;
    :cond_0
    return-void
.end method
