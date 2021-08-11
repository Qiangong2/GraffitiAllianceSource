.class public final Lcom/tencent/cos/xml/model/object/PutObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "PutObjectRequest.java"


# instance fields
.field private data:[B

.field private fileLength:J

.field private inputStream:Ljava/io/InputStream;

.field private progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private srcPath:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "inputStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->inputStream:Ljava/io/InputStream;

    .line 65
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "srcPath"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "data"    # [B

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    .line 53
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
    .line 87
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 88
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->inputStream:Ljava/io/InputStream;

    if-nez v1, :cond_0

    .line 89
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "Data Source must not be null"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 91
    :cond_0
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 92
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 93
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 94
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "upload file does not exist"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 97
    .end local v0    # "file":Ljava/io/File;
    :cond_1
    return-void
.end method

.method public getData()[B
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    return-object v0
.end method

.method public getFileLength()J
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 159
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->fileLength:J

    .line 163
    :cond_0
    :goto_0
    iget-wide v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->fileLength:J

    return-wide v0

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    array-length v0, v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->fileLength:J

    goto :goto_0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    const-string v0, "PUT"

    return-object v0
.end method

.method public getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

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
    const/4 v0, 0x0

    .line 74
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 75
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->file(Ljava/lang/String;Ljava/io/File;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    .line 82
    :cond_0
    :goto_0
    return-object v0

    .line 76
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    if-eqz v1, :cond_2

    .line 77
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0

    .line 78
    :cond_2
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->inputStream:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    .line 79
    new-instance v1, Ljava/io/File;

    sget-object v2, Lcom/tencent/cos/xml/CosXmlSimpleService;->appCachePath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->inputStream:Ljava/io/InputStream;

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0
.end method

.method public getSrcPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    return-object v0
.end method

.method public setCacheControl(Ljava/lang/String;)V
    .locals 1
    .param p1, "cacheControl"    # Ljava/lang/String;

    .prologue
    .line 173
    if-nez p1, :cond_0

    .line 175
    :goto_0
    return-void

    .line 174
    :cond_0
    const-string v0, "Cache-Control"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentDisposition(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentDisposition"    # Ljava/lang/String;

    .prologue
    .line 184
    if-nez p1, :cond_0

    .line 186
    :goto_0
    return-void

    .line 185
    :cond_0
    const-string v0, "Content-Disposition"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentEncodeing(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentEncoding"    # Ljava/lang/String;

    .prologue
    .line 195
    if-nez p1, :cond_0

    .line 197
    :goto_0
    return-void

    .line 196
    :cond_0
    const-string v0, "Content-Encoding"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setData([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 141
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->data:[B

    .line 142
    return-void
.end method

.method public setExpires(Ljava/lang/String;)V
    .locals 1
    .param p1, "expires"    # Ljava/lang/String;

    .prologue
    .line 206
    if-nez p1, :cond_0

    .line 208
    :goto_0
    return-void

    .line 207
    :cond_0
    const-string v0, "Expires"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "progressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 106
    return-void
.end method

.method public setSrcPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "srcPath"    # Ljava/lang/String;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->srcPath:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public setXCOSACL(Lcom/tencent/cos/xml/common/COSACL;)V
    .locals 2
    .param p1, "cosacl"    # Lcom/tencent/cos/xml/common/COSACL;

    .prologue
    .line 237
    if-eqz p1, :cond_0

    .line 238
    const-string v0, "x-cos-acl"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSACL;->getAcl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    :cond_0
    return-void
.end method

.method public setXCOSACL(Ljava/lang/String;)V
    .locals 1
    .param p1, "cosacl"    # Ljava/lang/String;

    .prologue
    .line 257
    if-eqz p1, :cond_0

    .line 258
    const-string v0, "x-cos-acl"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    :cond_0
    return-void
.end method

.method public setXCOSGrantRead(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 269
    if-eqz p1, :cond_0

    .line 270
    const-string v0, "x-cos-grant-read"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 272
    :cond_0
    return-void
.end method

.method public setXCOSGrantWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 283
    if-eqz p1, :cond_0

    .line 284
    const-string v0, "x-cos-grant-write"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 286
    :cond_0
    return-void
.end method

.method public setXCOSMeta(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 218
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 219
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    :cond_0
    return-void
.end method

.method public setXCOSReadWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 296
    if-eqz p1, :cond_0

    .line 297
    const-string v0, "x-cos-grant-full-control"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    :cond_0
    return-void
.end method
