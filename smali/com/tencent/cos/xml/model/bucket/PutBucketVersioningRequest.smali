.class public Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "PutBucketVersioningRequest.java"


# instance fields
.field private versioningConfiguration:Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 30
    new-instance v0, Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;->versioningConfiguration:Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;

    .line 31
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
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
    .line 50
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "versioning"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    invoke-super {p0}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

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
    .line 57
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;->versioningConfiguration:Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;

    .line 58
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildVersioningConfiguration(Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;)Ljava/lang/String;

    move-result-object v2

    .line 57
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 59
    :catch_0
    move-exception v0

    .line 60
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 61
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 62
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public setEnableVersion(Z)V
    .locals 2
    .param p1, "isEnable"    # Z

    .prologue
    .line 36
    if-eqz p1, :cond_0

    .line 37
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;->versioningConfiguration:Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;

    const-string v1, "Enabled"

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;->status:Ljava/lang/String;

    .line 41
    :goto_0
    return-void

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;->versioningConfiguration:Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;

    const-string v1, "Suspended"

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;->status:Ljava/lang/String;

    goto :goto_0
.end method
