.class public Lcom/tencent/cos/xml/model/object/RestoreResult;
.super Lcom/tencent/cos/xml/model/CosXmlResult;
.source "RestoreResult.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/tencent/cos/xml/model/CosXmlResult;-><init>()V

    return-void
.end method


# virtual methods
.method public parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V
    .locals 0
    .param p1, "response"    # Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 16
    invoke-super {p0, p1}, Lcom/tencent/cos/xml/model/CosXmlResult;->parseResponseBody(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 17
    return-void
.end method

.method public printResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    invoke-super {p0}, Lcom/tencent/cos/xml/model/CosXmlResult;->printResult()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
