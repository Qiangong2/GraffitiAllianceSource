.class public final Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;
.super Lcom/tencent/cos/xml/model/CosXmlResult;
.source "DeleteMultiObjectResult.java"


# instance fields
.field public deleteResult:Lcom/tencent/cos/xml/model/tag/DeleteResult;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
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
    .line 22
    invoke-super {p0, p1}, Lcom/tencent/cos/xml/model/CosXmlResult;->parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 23
    new-instance v1, Lcom/tencent/cos/xml/model/tag/DeleteResult;

    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/DeleteResult;-><init>()V

    iput-object v1, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;->deleteResult:Lcom/tencent/cos/xml/model/tag/DeleteResult;

    .line 25
    :try_start_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->byteStream()Ljava/io/InputStream;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;->deleteResult:Lcom/tencent/cos/xml/model/tag/DeleteResult;

    invoke-static {v1, v2}, Lcom/tencent/cos/xml/transfer/XmlParser;->parseDeleteResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/DeleteResult;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 31
    return-void

    .line 26
    :catch_0
    move-exception v0

    .line 27
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 28
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 29
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public printResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;->deleteResult:Lcom/tencent/cos/xml/model/tag/DeleteResult;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;->deleteResult:Lcom/tencent/cos/xml/model/tag/DeleteResult;

    invoke-virtual {v0}, Lcom/tencent/cos/xml/model/tag/DeleteResult;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Lcom/tencent/cos/xml/model/CosXmlResult;->printResult()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
