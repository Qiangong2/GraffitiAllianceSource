.class public final Lcom/tencent/cos/xml/model/object/AppendObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "AppendObjectRequest.java"


# instance fields
.field private data:[B

.field private fileLength:J

.field public inputStream:Ljava/io/InputStream;

.field private position:J

.field private progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private srcPath:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 44
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;J)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "inputStream"    # Ljava/io/InputStream;
    .param p4, "position"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->inputStream:Ljava/io/InputStream;

    .line 61
    iput-wide p4, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 62
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "srcPath"    # Ljava/lang/String;
    .param p4, "position"    # J

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    .line 48
    iput-wide p4, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[BJ)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "data"    # [B
    .param p4, "position"    # J

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    .line 54
    iput-wide p4, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 55
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
    .line 91
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 92
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->inputStream:Ljava/io/InputStream;

    if-nez v1, :cond_0

    .line 93
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "Data Source must not be null"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 95
    :cond_0
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 96
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 97
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 98
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v2, "upload file does not exist"

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 101
    .end local v0    # "file":Ljava/io/File;
    :cond_1
    return-void
.end method

.method public getData()[B
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    return-object v0
.end method

.method public getFileLength()J
    .locals 4

    .prologue
    .line 178
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 179
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 180
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->fileLength:J

    .line 184
    .end local v0    # "file":Ljava/io/File;
    :cond_0
    :goto_0
    iget-wide v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->fileLength:J

    return-wide v2

    .line 181
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    if-eqz v1, :cond_0

    .line 182
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    array-length v1, v1

    int-to-long v2, v1

    iput-wide v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->fileLength:J

    goto :goto_0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const-string v0, "POST"

    return-object v0
.end method

.method public getPosition()J
    .locals 2

    .prologue
    .line 120
    iget-wide v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    return-wide v0
.end method

.method public getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    return-object v0
.end method

.method public getQueryString()Ljava/util/Map;
    .locals 4
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
    .line 71
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "append"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "position"

    iget-wide v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->queryParameters:Ljava/util/Map;

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

    .line 78
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 79
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->file(Ljava/lang/String;Ljava/io/File;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    .line 86
    :cond_0
    :goto_0
    return-object v0

    .line 80
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    if-eqz v1, :cond_2

    .line 81
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0

    .line 82
    :cond_2
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->inputStream:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    .line 83
    new-instance v1, Ljava/io/File;

    sget-object v2, Lcom/tencent/cos/xml/CosXmlSimpleService;->appCachePath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->inputStream:Ljava/io/InputStream;

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    goto :goto_0
.end method

.method public getSrcPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    return-object v0
.end method

.method public setCacheControl(Ljava/lang/String;)V
    .locals 1
    .param p1, "cacheControl"    # Ljava/lang/String;

    .prologue
    .line 216
    if-nez p1, :cond_0

    .line 218
    :goto_0
    return-void

    .line 217
    :cond_0
    const-string v0, "Cache-Control"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentDisposition(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentDisposition"    # Ljava/lang/String;

    .prologue
    .line 231
    if-nez p1, :cond_0

    .line 233
    :goto_0
    return-void

    .line 232
    :cond_0
    const-string v0, "Content-Disposition"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentEncodeing(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentEncoding"    # Ljava/lang/String;

    .prologue
    .line 246
    if-nez p1, :cond_0

    .line 248
    :goto_0
    return-void

    .line 247
    :cond_0
    const-string v0, "Content-Encoding"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setData([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 160
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->data:[B

    .line 161
    return-void
.end method

.method public setExpires(Ljava/lang/String;)V
    .locals 1
    .param p1, "expires"    # Ljava/lang/String;

    .prologue
    .line 261
    if-nez p1, :cond_0

    .line 263
    :goto_0
    return-void

    .line 262
    :cond_0
    const-string v0, "Expires"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setPosition(J)V
    .locals 5
    .param p1, "position"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 110
    cmp-long v0, p1, v2

    if-gez v0, :cond_0

    iput-wide v2, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 111
    :cond_0
    iput-wide p1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->position:J

    .line 112
    return-void
.end method

.method public setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "progressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 194
    return-void
.end method

.method public setSrcPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "srcPath"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->srcPath:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setXCOSACL(Lcom/tencent/cos/xml/common/COSACL;)V
    .locals 2
    .param p1, "cosacl"    # Lcom/tencent/cos/xml/common/COSACL;

    .prologue
    .line 310
    if-eqz p1, :cond_0

    .line 311
    const-string v0, "x-cos-acl"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSACL;->getAcl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 313
    :cond_0
    return-void
.end method

.method public setXCOSACL(Ljava/lang/String;)V
    .locals 1
    .param p1, "cosacl"    # Ljava/lang/String;

    .prologue
    .line 299
    if-eqz p1, :cond_0

    .line 300
    const-string v0, "x-cos-acl"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    :cond_0
    return-void
.end method

.method public setXCOSGrantRead(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 323
    if-eqz p1, :cond_0

    .line 324
    const-string v0, "x-cos-grant-read"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    :cond_0
    return-void
.end method

.method public setXCOSGrantWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 338
    if-eqz p1, :cond_0

    .line 339
    const-string v0, "x-cos-grant-write"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    :cond_0
    return-void
.end method

.method public setXCOSMeta(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 277
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 278
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    :cond_0
    return-void
.end method

.method public setXCOSReadWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 352
    if-eqz p1, :cond_0

    .line 353
    const-string v0, "x-cos-grant-full-control"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    :cond_0
    return-void
.end method
