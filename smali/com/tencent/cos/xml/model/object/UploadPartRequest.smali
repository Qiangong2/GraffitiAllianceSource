.class public final Lcom/tencent/cos/xml/model/object/UploadPartRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "UploadPartRequest.java"


# instance fields
.field private data:[B

.field private fileContentLength:J

.field private fileOffset:J

.field private inputStream:Ljava/io/InputStream;

.field private partNumber:I

.field private progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private srcPath:Ljava/lang/String;

.field private uploadId:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    const-wide/16 v0, -0x1

    .line 36
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    .line 31
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/io/InputStream;Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "inputStream"    # Ljava/io/InputStream;
    .param p5, "uploadId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    const-wide/16 v0, -0x1

    .line 66
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    iput p3, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    .line 68
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->inputStream:Ljava/io/InputStream;

    .line 70
    iput-object p5, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    .line 71
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    .line 72
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 73
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJLjava/lang/String;)V
    .locals 9
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "srcPath"    # Ljava/lang/String;
    .param p5, "offset"    # J
    .param p7, "length"    # J
    .param p9, "uploadId"    # Ljava/lang/String;

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    iput p3, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    move-object v2, p0

    move-object v3, p4

    move-wide v4, p5

    move-wide/from16 v6, p7

    .line 52
    invoke-virtual/range {v2 .. v7}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->setSrcPath(Ljava/lang/String;JJ)V

    .line 53
    move-object/from16 v0, p9

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "srcPath"    # Ljava/lang/String;
    .param p5, "uploadId"    # Ljava/lang/String;

    .prologue
    const-wide/16 v0, -0x1

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    iput p3, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    .line 42
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    .line 43
    iput-object p5, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    .line 44
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    .line 45
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 46
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I[BLjava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "partNumber"    # I
    .param p4, "data"    # [B
    .param p5, "uploadId"    # Ljava/lang/String;

    .prologue
    const-wide/16 v0, -0x1

    .line 57
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    iput p3, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    .line 59
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    .line 60
    iput-object p5, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    .line 61
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    .line 62
    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 63
    return-void
.end method


# virtual methods
.method public checkParameters()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 138
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 139
    iget v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    if-gtz v1, :cond_0

    .line 140
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "partNumber must be >= 1"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 142
    :cond_0
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 143
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "uploadID must not be null"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 145
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->inputStream:Ljava/io/InputStream;

    if-nez v1, :cond_2

    .line 146
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "Data Source must not be null"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 148
    :cond_2
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_3

    .line 149
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 150
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_3

    .line 151
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "upload file does not exist"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 154
    .end local v0    # "file":Ljava/io/File;
    :cond_3
    return-void
.end method

.method public getData()[B
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    return-object v0
.end method

.method public getFileLength()J
    .locals 4

    .prologue
    .line 211
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    if-eqz v0, :cond_1

    .line 212
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    array-length v0, v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 216
    :cond_0
    :goto_0
    iget-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    return-wide v0

    .line 213
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 214
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    goto :goto_0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    const-string v0, "PUT"

    return-object v0
.end method

.method public getPartNumber()I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    return v0
.end method

.method public getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

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
    .line 114
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "partNumber"

    iget v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploadID"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 121
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 122
    iget-wide v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    const-wide/16 v4, -0x1

    cmp-long v1, v2, v4

    if-eqz v1, :cond_1

    .line 123
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    iget-wide v4, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->file(Ljava/lang/String;Ljava/io/File;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    .line 133
    :cond_0
    :goto_0
    return-object v0

    .line 125
    :cond_1
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->file(Ljava/lang/String;Ljava/io/File;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0

    .line 127
    :cond_2
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    if-eqz v1, :cond_3

    .line 128
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0

    .line 129
    :cond_3
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->inputStream:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    .line 130
    new-instance v1, Ljava/io/File;

    sget-object v2, Lcom/tencent/cos/xml/CosXmlSimpleService;->appCachePath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->inputStream:Ljava/io/InputStream;

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0
.end method

.method public getSrcPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    return-object v0
.end method

.method public getUploadId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    return-object v0
.end method

.method public setData([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 195
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->data:[B

    .line 196
    return-void
.end method

.method public setPartNumber(I)V
    .locals 0
    .param p1, "partNumber"    # I

    .prologue
    .line 80
    iput p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->partNumber:I

    .line 81
    return-void
.end method

.method public setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "progressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 224
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 225
    return-void
.end method

.method public setSrcPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "srcPath"    # Ljava/lang/String;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    .line 166
    return-void
.end method

.method public setSrcPath(Ljava/lang/String;JJ)V
    .locals 0
    .param p1, "srcPath"    # Ljava/lang/String;
    .param p2, "fileOffset"    # J
    .param p4, "contentLength"    # J

    .prologue
    .line 173
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->srcPath:Ljava/lang/String;

    .line 174
    iput-wide p2, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileOffset:J

    .line 175
    iput-wide p4, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->fileContentLength:J

    .line 176
    return-void
.end method

.method public setUploadId(Ljava/lang/String;)V
    .locals 0
    .param p1, "uploadId"    # Ljava/lang/String;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->uploadId:Ljava/lang/String;

    .line 97
    return-void
.end method
