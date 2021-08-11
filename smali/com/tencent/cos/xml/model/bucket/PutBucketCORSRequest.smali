.class public final Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "PutBucketCORSRequest.java"


# instance fields
.field private corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 33
    new-instance v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    .line 34
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;->corsRules:Ljava/util/List;

    .line 35
    return-void
.end method


# virtual methods
.method public addCORSRule(Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;)V
    .locals 1
    .param p1, "corsRule"    # Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;

    .prologue
    .line 77
    if-eqz p1, :cond_0

    .line 78
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;->corsRules:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 80
    :cond_0
    return-void
.end method

.method public addCORSRules(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 66
    .local p1, "corsRules":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;>;"
    if-eqz p1, :cond_0

    .line 67
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;->corsRules:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 69
    :cond_0
    return-void
.end method

.method public getCorsConfiguration()Lcom/tencent/cos/xml/model/tag/CORSConfiguration;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
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
    .line 44
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "cors"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
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
    .line 51
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;->corsConfiguration:Lcom/tencent/cos/xml/model/tag/CORSConfiguration;

    .line 52
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildCORSConfigurationXML(Lcom/tencent/cos/xml/model/tag/CORSConfiguration;)Ljava/lang/String;

    move-result-object v2

    .line 51
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 53
    :catch_0
    move-exception v0

    .line 54
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 55
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 56
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x1

    return v0
.end method
