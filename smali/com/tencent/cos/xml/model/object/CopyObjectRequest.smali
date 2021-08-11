.class public Lcom/tencent/cos/xml/model/object/CopyObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "CopyObjectRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    }
.end annotation


# instance fields
.field private copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "copySourceStruct"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    .line 32
    invoke-virtual {p0, p3}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->setCopySource(Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V

    .line 33
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
    .line 47
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 48
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    if-nez v0, :cond_0

    .line 49
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "copy source must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    invoke-virtual {v0}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;->checkParameters()V

    .line 53
    return-void
.end method

.method public getCopySource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCosPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->cosPath:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    const-string v0, "PUT"

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 42
    const/4 v0, 0x0

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-static {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public setCopyIfMatch(Ljava/lang/String;)V
    .locals 1
    .param p1, "eTag"    # Ljava/lang/String;

    .prologue
    .line 132
    if-eqz p1, :cond_0

    .line 133
    const-string v0, "x-cos-copy-source-If-Match"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    :cond_0
    return-void
.end method

.method public setCopyIfModifiedSince(Ljava/lang/String;)V
    .locals 1
    .param p1, "sourceIfModifiedSince"    # Ljava/lang/String;

    .prologue
    .line 106
    if-eqz p1, :cond_0

    .line 107
    const-string v0, "x-cos-copy-source-If-Modified-Since"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    :cond_0
    return-void
.end method

.method public setCopyIfNoneMatch(Ljava/lang/String;)V
    .locals 1
    .param p1, "eTag"    # Ljava/lang/String;

    .prologue
    .line 145
    if-eqz p1, :cond_0

    .line 146
    const-string v0, "x-cos-copy-source-If-None-Match"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    :cond_0
    return-void
.end method

.method public setCopyIfUnmodifiedSince(Ljava/lang/String;)V
    .locals 1
    .param p1, "sourceIfUnmodifiedSince"    # Ljava/lang/String;

    .prologue
    .line 119
    if-eqz p1, :cond_0

    .line 120
    const-string v0, "x-cos-copy-source-If-Unmodified-Since"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    :cond_0
    return-void
.end method

.method public setCopyMetaDataDirective(Lcom/tencent/cos/xml/common/MetaDataDirective;)V
    .locals 2
    .param p1, "metaDataDirective"    # Lcom/tencent/cos/xml/common/MetaDataDirective;

    .prologue
    .line 93
    if-eqz p1, :cond_0

    .line 94
    const-string v0, "x-cos-metadata-directive"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/MetaDataDirective;->getMetaDirective()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    :cond_0
    return-void
.end method

.method public setCopySource(Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;)V
    .locals 2
    .param p1, "copySource"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 73
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    .line 74
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    if-eqz v0, :cond_0

    .line 75
    const-string v0, "x-cos-copy-source"

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->copySourceStruct:Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;

    invoke-virtual {v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct;->getSource()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    :cond_0
    return-void
.end method

.method public setCosPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->cosPath:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setCosStorageClass(Lcom/tencent/cos/xml/common/COSStorageClass;)V
    .locals 2
    .param p1, "cosStorageClass"    # Lcom/tencent/cos/xml/common/COSStorageClass;

    .prologue
    .line 155
    if-eqz p1, :cond_0

    .line 156
    const-string v0, "x-cos-storage-class"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSStorageClass;->getStorageClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    :cond_0
    return-void
.end method

.method public setXCOSACL(Lcom/tencent/cos/xml/common/COSACL;)V
    .locals 2
    .param p1, "cosacl"    # Lcom/tencent/cos/xml/common/COSACL;

    .prologue
    .line 165
    if-eqz p1, :cond_0

    .line 166
    const-string v0, "x-cos-acl"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/common/COSACL;->getAcl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    :cond_0
    return-void
.end method

.method public setXCOSACL(Ljava/lang/String;)V
    .locals 1
    .param p1, "cosacl"    # Ljava/lang/String;

    .prologue
    .line 171
    if-eqz p1, :cond_0

    .line 172
    const-string v0, "x-cos-acl"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    :cond_0
    return-void
.end method

.method public setXCOSGrantRead(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 181
    if-eqz p1, :cond_0

    .line 182
    const-string v0, "x-cos-grant-read"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    :cond_0
    return-void
.end method

.method public setXCOSGrantWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 191
    if-eqz p1, :cond_0

    .line 192
    const-string v0, "x-cos-grant-write"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    :cond_0
    return-void
.end method

.method public setXCOSMeta(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 212
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 213
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    :cond_0
    return-void
.end method

.method public setXCOSReadWrite(Lcom/tencent/cos/xml/model/tag/ACLAccount;)V
    .locals 2
    .param p1, "aclAccount"    # Lcom/tencent/cos/xml/model/tag/ACLAccount;

    .prologue
    .line 201
    if-eqz p1, :cond_0

    .line 202
    const-string v0, "x-cos-grant-full-control"

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->getAccount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/CopyObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    :cond_0
    return-void
.end method
