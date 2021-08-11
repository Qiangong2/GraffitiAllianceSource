.class public Lcom/tencent/cos/xml/model/object/RestoreRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "RestoreRequest.java"


# instance fields
.field private restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    new-instance v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    .line 26
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    new-instance v1, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters;

    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure;->casJobParameters:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters;

    .line 27
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
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
    .line 31
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "restore"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->queryParameters:Ljava/util/Map;

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
    .line 43
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    .line 44
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildRestore(Lcom/tencent/cos/xml/model/tag/RestoreConfigure;)Ljava/lang/String;

    move-result-object v2

    .line 43
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 45
    :catch_0
    move-exception v0

    .line 46
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 47
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 48
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 54
    const/4 v0, 0x1

    return v0
.end method

.method public setExpireDays(I)V
    .locals 1
    .param p1, "days"    # I

    .prologue
    .line 58
    if-gez p1, :cond_0

    const/4 p1, 0x0

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    iput p1, v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure;->days:I

    .line 60
    return-void
.end method

.method public setTier(Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;)V
    .locals 2
    .param p1, "tier"    # Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    .prologue
    .line 63
    if-eqz p1, :cond_0

    .line 64
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/RestoreRequest;->restoreConfigure:Lcom/tencent/cos/xml/model/tag/RestoreConfigure;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure;->casJobParameters:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters;

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->getTier()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$CASJobParameters;->tier:Ljava/lang/String;

    .line 66
    :cond_0
    return-void
.end method
