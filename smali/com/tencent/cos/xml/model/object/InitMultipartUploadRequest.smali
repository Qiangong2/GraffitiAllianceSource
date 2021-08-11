.class public final Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "InitMultipartUploadRequest.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
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
    .line 152
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "uploads"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->queryParameters:Ljava/util/Map;

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 2

    .prologue
    .line 158
    const/4 v0, 0x0

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public setCacheControl(Ljava/lang/String;)V
    .locals 1
    .param p1, "cacheControl"    # Ljava/lang/String;

    .prologue
    .line 33
    if-nez p1, :cond_0

    .line 35
    :goto_0
    return-void

    .line 34
    :cond_0
    const-string v0, "Cache-Control"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentDisposition(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentDisposition"    # Ljava/lang/String;

    .prologue
    .line 42
    if-nez p1, :cond_0

    .line 44
    :goto_0
    return-void

    .line 43
    :cond_0
    const-string v0, "Content-Disposition"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setContentEncoding(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentEncoding"    # Ljava/lang/String;

    .prologue
    .line 51
    if-nez p1, :cond_0

    .line 53
    :goto_0
    return-void

    .line 52
    :cond_0
    const-string v0, "Content-Encoding"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setExpires(Ljava/lang/String;)V
    .locals 1
    .param p1, "expires"    # Ljava/lang/String;

    .prologue
    .line 60
    if-nez p1, :cond_0

    .line 62
    :goto_0
    return-void

    .line 61
    :cond_0
    const-string v0, "Expires"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setXCOSACL(Lcom/tencent/cos/xml/common/COSACL;)V
    .locals 2
    .param p1, "cosacl"    # Lcom/tencent/cos/xml/common/COSACL;

    .prologue
    .line 100
    if-eqz p1, :cond_0

    .line 101
    const-string v0, "x-cos-acl"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSACL;->getAcl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    :cond_0
    return-void
.end method

.method public setXCOSACL(Ljava/lang/String;)V
    .locals 1
    .param p1, "cosacl"    # Ljava/lang/String;

    .prologue
    .line 85
    if-eqz p1, :cond_0

    .line 86
    const-string v0, "x-cos-acl"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    :cond_0
    return-void
.end method

.method public setXCOSGrantRead(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 112
    if-eqz p1, :cond_0

    .line 113
    const-string v0, "x-cos-grant-read"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    :cond_0
    return-void
.end method

.method public setXCOSGrantWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 126
    if-eqz p1, :cond_0

    .line 127
    const-string v0, "x-cos-grant-write"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    :cond_0
    return-void
.end method

.method public setXCOSMeta(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 70
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 71
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    :cond_0
    return-void
.end method

.method public setXCOSReadWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 140
    if-eqz p1, :cond_0

    .line 141
    const-string v0, "x-cos-grant-full-control"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    :cond_0
    return-void
.end method
