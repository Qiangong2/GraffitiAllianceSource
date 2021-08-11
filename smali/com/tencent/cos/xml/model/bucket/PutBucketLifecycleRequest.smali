.class public final Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "PutBucketLifecycleRequest.java"


# instance fields
.field private lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 49
    new-instance v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    .line 50
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;->rules:Ljava/util/List;

    .line 51
    return-void
.end method


# virtual methods
.method public getLifecycleConfiguration()Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
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
    .line 60
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "lifecycle"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
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
    .line 67
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    .line 68
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildLifecycleConfigurationXML(Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;)Ljava/lang/String;

    move-result-object v2

    .line 67
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 69
    :catch_0
    move-exception v0

    .line 70
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 71
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 72
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 107
    const/4 v0, 0x1

    return v0
.end method

.method public setRuleList(Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;)V
    .locals 1
    .param p1, "rule"    # Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;

    .prologue
    .line 93
    if-eqz p1, :cond_0

    .line 94
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;->rules:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 96
    :cond_0
    return-void
.end method

.method public setRuleList(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 82
    .local p1, "ruleList":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;>;"
    if-eqz p1, :cond_0

    .line 83
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;->lifecycleConfiguration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;->rules:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 85
    :cond_0
    return-void
.end method
