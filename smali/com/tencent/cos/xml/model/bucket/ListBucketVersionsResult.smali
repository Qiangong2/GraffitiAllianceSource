.class public Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;
.super Lcom/tencent/cos/xml/model/CosXmlResult;
.source "ListBucketVersionsResult.java"


# instance fields
.field public listBucketVersions:Lcom/tencent/cos/xml/model/tag/ListBucketVersions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/tencent/cos/xml/model/CosXmlResult;-><init>()V

    return-void
.end method


# virtual methods
.method public parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V
    .locals 3
    .param p1, "response"    # Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/tencent/cos/xml/model/CosXmlResult;->parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 25
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;

    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;-><init>()V

    iput-object v1, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;->listBucketVersions:Lcom/tencent/cos/xml/model/tag/ListBucketVersions;

    .line 27
    :try_start_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->byteStream()Ljava/io/InputStream;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;->listBucketVersions:Lcom/tencent/cos/xml/model/tag/ListBucketVersions;

    invoke-static {v1, v2}, Lcom/tencent/cos/xml/transfer/XmlParser;->parseListBucketVersions(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListBucketVersions;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 33
    return-void

    .line 28
    :catch_0
    move-exception v0

    .line 29
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-virtual {v0}, Lorg/xmlpull/v1/XmlPullParserException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 30
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 31
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public printResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;->listBucketVersions:Lcom/tencent/cos/xml/model/tag/ListBucketVersions;

    if-eqz v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;->listBucketVersions:Lcom/tencent/cos/xml/model/tag/ListBucketVersions;

    invoke-virtual {v0}, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->toString()Ljava/lang/String;

    move-result-object v0

    .line 40
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Lcom/tencent/cos/xml/model/CosXmlResult;->printResult()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
