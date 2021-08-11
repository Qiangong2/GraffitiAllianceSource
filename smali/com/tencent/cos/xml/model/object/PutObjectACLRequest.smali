.class public final Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "PutObjectACLRequest.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const-string v0, "PUT"

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
    .line 34
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "acl"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 2

    .prologue
    .line 40
    const/4 v0, 0x0

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public setXCOSACL(Lcom/tencent/cos/xml/common/COSACL;)V
    .locals 2
    .param p1, "cosacl"    # Lcom/tencent/cos/xml/common/COSACL;

    .prologue
    .line 60
    if-eqz p1, :cond_0

    .line 61
    const-string v0, "x-cos-acl"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSACL;->getAcl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :cond_0
    return-void
.end method

.method public setXCOSACL(Ljava/lang/String;)V
    .locals 1
    .param p1, "cosacl"    # Ljava/lang/String;

    .prologue
    .line 71
    if-eqz p1, :cond_0

    .line 72
    const-string v0, "x-cos-acl"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    :cond_0
    return-void
.end method

.method public setXCOSGrantRead(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 83
    if-eqz p1, :cond_0

    .line 84
    const-string v0, "x-cos-grant-read"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    :cond_0
    return-void
.end method

.method public setXCOSGrantWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 97
    if-eqz p1, :cond_0

    .line 98
    const-string v0, "x-cos-grant-write"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    :cond_0
    return-void
.end method

.method public setXCOSReadWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 111
    if-eqz p1, :cond_0

    .line 112
    const-string v0, "x-cos-grant-full-control"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_0
    return-void
.end method
