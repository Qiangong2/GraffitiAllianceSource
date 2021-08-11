.class public Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;
.super Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
.source "ResponseXmlS3BodySerializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private cosXmlResult:Lcom/tencent/cos/xml/model/CosXmlResult;


# direct methods
.method public constructor <init>(Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 0
    .param p1, "cosXmlResult"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 31
    .local p0, "this":Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;, "Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer<TT;>;"
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;->cosXmlResult:Lcom/tencent/cos/xml/model/CosXmlResult;

    .line 33
    return-void
.end method

.method private parseCOSXMLError(Lcom/tencent/qcloud/core/http/HttpResponse;)V
    .locals 7
    .param p1, "response"    # Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "this":Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;, "Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer<TT;>;"
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->code()I

    move-result v3

    .line 44
    .local v3, "httpCode":I
    const/16 v6, 0xc8

    if-lt v3, v6, :cond_0

    const/16 v6, 0x12c

    if-ge v3, v6, :cond_0

    return-void

    .line 45
    :cond_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->message()Ljava/lang/String;

    move-result-object v5

    .line 46
    .local v5, "message":Ljava/lang/String;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    invoke-direct {v1, v5}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;-><init>(Ljava/lang/String;)V

    .line 47
    .local v1, "cosXmlServiceException":Lcom/tencent/cos/xml/exception/CosXmlServiceException;
    invoke-virtual {v1, v3}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setStatusCode(I)V

    .line 48
    const-string v6, "x-cos-request-id"

    invoke-virtual {p1, v6}, Lcom/tencent/qcloud/core/http/HttpResponse;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setRequestId(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->byteStream()Ljava/io/InputStream;

    move-result-object v4

    .line 50
    .local v4, "inputStream":Ljava/io/InputStream;
    if-eqz v4, :cond_1

    .line 51
    new-instance v0, Lcom/tencent/cos/xml/model/tag/CosError;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/CosError;-><init>()V

    .line 53
    .local v0, "cosError":Lcom/tencent/cos/xml/model/tag/CosError;
    :try_start_0
    invoke-static {v4, v0}, Lcom/tencent/cos/xml/transfer/XmlSlimParser;->parseError(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CosError;)V

    .line 54
    iget-object v6, v0, Lcom/tencent/cos/xml/model/tag/CosError;->code:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setErrorCode(Ljava/lang/String;)V

    .line 55
    iget-object v6, v0, Lcom/tencent/cos/xml/model/tag/CosError;->message:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setErrorMessage(Ljava/lang/String;)V

    .line 56
    iget-object v6, v0, Lcom/tencent/cos/xml/model/tag/CosError;->requestId:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setRequestId(Ljava/lang/String;)V

    .line 57
    iget-object v6, v0, Lcom/tencent/cos/xml/model/tag/CosError;->resource:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->setServiceName(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 64
    .end local v0    # "cosError":Lcom/tencent/cos/xml/model/tag/CosError;
    :cond_1
    throw v1

    .line 58
    .restart local v0    # "cosError":Lcom/tencent/cos/xml/model/tag/CosError;
    :catch_0
    move-exception v2

    .line 59
    .local v2, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v6, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v6, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v6

    .line 60
    .end local v2    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v2

    .line 61
    .local v2, "e":Ljava/io/IOException;
    new-instance v6, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v6, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v6
.end method


# virtual methods
.method protected convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/Object;
    .locals 1
    .param p1, "response"    # Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpResponse;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 37
    .local p0, "this":Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;, "Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer<TT;>;"
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;->parseCOSXMLError(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;->cosXmlResult:Lcom/tencent/cos/xml/model/CosXmlResult;

    invoke-virtual {v0, p1}, Lcom/tencent/cos/xml/model/CosXmlResult;->parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 39
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;->cosXmlResult:Lcom/tencent/cos/xml/model/CosXmlResult;

    return-object v0
.end method
