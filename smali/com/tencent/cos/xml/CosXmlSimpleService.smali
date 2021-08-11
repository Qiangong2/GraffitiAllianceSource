.class public Lcom/tencent/cos/xml/CosXmlSimpleService;
.super Ljava/lang/Object;
.source "CosXmlSimpleService.java"

# interfaces
.implements Lcom/tencent/cos/xml/SimpleCosXml;


# static fields
.field public static appCachePath:Ljava/lang/String;


# instance fields
.field protected appid:Ljava/lang/String;

.field protected client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

.field protected credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

.field protected region:Ljava/lang/String;

.field protected scheme:Ljava/lang/String;

.field protected tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/tencent/cos/xml/CosXmlServiceConfig;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/tencent/cos/xml/CosXmlServiceConfig;
    .param p3, "qCloudCredentialProvider"    # Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    const-string v0, "CosXml"

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->tag:Ljava/lang/String;

    .line 64
    invoke-static {p1}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->setUp(Landroid/content/Context;)V

    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/tencent/cos/xml/CosXmlSimpleService;->appCachePath:Ljava/lang/String;

    .line 66
    invoke-static {}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->getDefault()Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    .line 67
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    const-string v1, "*.myqcloud.com"

    invoke-virtual {v0, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->addVerifiedHost(Ljava/lang/String;)V

    .line 68
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-virtual {p2}, Lcom/tencent/cos/xml/CosXmlServiceConfig;->isDebuggable()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->setDebuggable(Z)V

    .line 69
    invoke-virtual {p2}, Lcom/tencent/cos/xml/CosXmlServiceConfig;->getProtocol()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->scheme:Ljava/lang/String;

    .line 70
    invoke-virtual {p2}, Lcom/tencent/cos/xml/CosXmlServiceConfig;->getRegion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->region:Ljava/lang/String;

    .line 71
    invoke-virtual {p2}, Lcom/tencent/cos/xml/CosXmlServiceConfig;->getAppid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->appid:Ljava/lang/String;

    .line 72
    iput-object p3, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    .line 73
    return-void
.end method


# virtual methods
.method public abortMultiUpload(Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;)Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 279
    new-instance v0, Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;

    return-object v0
.end method

.method public abortMultiUploadAsync(Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 291
    new-instance v0, Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/AbortMultiUploadResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 292
    return-void
.end method

.method protected buildHttpRequest(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T1:",
            "Lcom/tencent/cos/xml/model/CosXmlRequest;",
            "T2:",
            "Lcom/tencent/cos/xml/model/CosXmlResult;",
            ">(TT1;TT2;)",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 77
    .local p1, "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    .local p2, "cosXmlResult":Lcom/tencent/cos/xml/model/CosXmlResult;, "TT2;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->checkParameters()V

    .line 78
    iget-object v5, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->appid:Ljava/lang/String;

    iget-object v8, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->region:Ljava/lang/String;

    invoke-virtual {p1, v5, v8}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getHost(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 79
    .local v1, "host":Ljava/lang/String;
    new-instance v5, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    invoke-direct {v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;-><init>()V

    .line 80
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getMethod()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    iget-object v8, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->scheme:Ljava/lang/String;

    .line 81
    invoke-virtual {v5, v8}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    .line 82
    invoke-virtual {v5, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    .line 83
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getPath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    const-string v8, "Host"

    .line 84
    invoke-virtual {v5, v8, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    sget-object v8, Lcom/tencent/cos/xml/CosXmlServiceConfig;->DEFAULT_USER_AGENT:Ljava/lang/String;

    .line 85
    invoke-virtual {v5, v8}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    iget-object v8, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->tag:Ljava/lang/String;

    .line 87
    invoke-virtual {v5, v8}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v5

    const-string v8, "CosXmlSigner"

    .line 88
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getSignSourceProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->signer(Ljava/lang/String;Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v3

    .line 90
    .local v3, "httpRequestBuilder":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT2;>;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getQueryString()Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->query(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    .line 91
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getRequestHeaders()Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->addHeaders(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    .line 93
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->isNeedMD5()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 94
    invoke-virtual {v3}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->contentMD5()Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    .line 97
    :cond_0
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 98
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    .line 101
    :cond_1
    instance-of v5, p1, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    if-eqz v5, :cond_3

    move-object v5, p1

    .line 102
    check-cast v5, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getDownloadPath()Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "absolutePath":Ljava/lang/String;
    check-cast p1, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    .end local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getRange()Lcom/tencent/cos/xml/common/Range;

    move-result-object v4

    .line 104
    .local v4, "range":Lcom/tencent/cos/xml/common/Range;
    const-wide/16 v6, 0x0

    .line 105
    .local v6, "start":J
    if-eqz v4, :cond_2

    .line 106
    invoke-virtual {v4}, Lcom/tencent/cos/xml/common/Range;->getStart()J

    move-result-wide v6

    .line 108
    :cond_2
    new-instance v5, Lcom/tencent/cos/xml/transfer/ResponseFileBodySerializer;

    check-cast p2, Lcom/tencent/cos/xml/model/object/GetObjectResult;

    .end local p2    # "cosXmlResult":Lcom/tencent/cos/xml/model/CosXmlResult;, "TT2;"
    invoke-direct {v5, p2, v0, v6, v7}, Lcom/tencent/cos/xml/transfer/ResponseFileBodySerializer;-><init>(Lcom/tencent/cos/xml/model/object/GetObjectResult;Ljava/lang/String;J)V

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    .line 113
    .end local v0    # "absolutePath":Ljava/lang/String;
    .end local v4    # "range":Lcom/tencent/cos/xml/common/Range;
    .end local v6    # "start":J
    :goto_0
    invoke-virtual {v3}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->build()Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    move-result-object v2

    .line 114
    .local v2, "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
    return-object v2

    .line 110
    .end local v2    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
    .restart local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    .restart local p2    # "cosXmlResult":Lcom/tencent/cos/xml/model/CosXmlResult;, "TT2;"
    :cond_3
    new-instance v5, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;

    invoke-direct {v5, p2}, Lcom/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer;-><init>(Lcom/tencent/cos/xml/model/CosXmlResult;)V

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    goto :goto_0
.end method

.method public cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    .locals 1
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;

    .prologue
    .line 404
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getHttpTask()Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 405
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getHttpTask()Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v0

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpTask;->cancel()V

    .line 407
    :cond_0
    return-void
.end method

.method public cancelAll()V
    .locals 4

    .prologue
    .line 415
    iget-object v2, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    iget-object v3, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->tag:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->getTasksByTag(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 416
    .local v1, "tasks":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/http/HttpTask;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/HttpTask;

    .line 417
    .local v0, "task":Lcom/tencent/qcloud/core/http/HttpTask;
    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpTask;->cancel()V

    goto :goto_0

    .line 419
    .end local v0    # "task":Lcom/tencent/qcloud/core/http/HttpTask;
    :cond_0
    return-void
.end method

.method public completeMultiUpload(Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 303
    new-instance v0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;-><init>()V

    .line 304
    .local v0, "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    invoke-virtual {p0, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->accessUrl:Ljava/lang/String;

    .line 305
    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v1

    check-cast v1, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    return-object v1
.end method

.method public completeMultiUploadAsync(Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 317
    new-instance v0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;-><init>()V

    .line 318
    .local v0, "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    invoke-virtual {p0, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->accessUrl:Ljava/lang/String;

    .line 319
    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 320
    return-void
.end method

.method public deleteObject(Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;)Lcom/tencent/cos/xml/model/object/DeleteObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 331
    new-instance v0, Lcom/tencent/cos/xml/model/object/DeleteObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/DeleteObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/DeleteObjectResult;

    return-object v0
.end method

.method public deleteObjectAsync(Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 343
    new-instance v0, Lcom/tencent/cos/xml/model/object/DeleteObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/DeleteObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 344
    return-void
.end method

.method protected execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T1:",
            "Lcom/tencent/cos/xml/model/CosXmlRequest;",
            "T2:",
            "Lcom/tencent/cos/xml/model/CosXmlResult;",
            ">(TT1;TT2;)TT2;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 121
    .local p1, "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    .local p2, "cosXmlResult":Lcom/tencent/cos/xml/model/CosXmlResult;, "TT2;"
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->buildHttpRequest(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    move-result-object v1

    .line 122
    .local v1, "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    iget-object v3, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    iget-object v4, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    invoke-virtual {v3, v1, v4}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->resolveRequest(Lcom/tencent/qcloud/core/http/QCloudHttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v2

    .line 124
    .local v2, "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    invoke-virtual {p1, v2}, Lcom/tencent/cos/xml/model/CosXmlRequest;->setTask(Lcom/tencent/qcloud/core/http/HttpTask;)V

    .line 126
    instance-of v3, p1, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;

    if-eqz v3, :cond_1

    .line 127
    check-cast p1, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;

    .end local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;

    .line 135
    :cond_0
    :goto_0
    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/HttpTask;->executeNow()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/tencent/qcloud/core/http/HttpResult;

    invoke-virtual {v3}, Lcom/tencent/qcloud/core/http/HttpResult;->content()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/tencent/cos/xml/model/CosXmlResult;

    return-object v3

    .line 128
    .restart local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    :cond_1
    instance-of v3, p1, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    if-eqz v3, :cond_2

    .line 129
    check-cast p1, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    .end local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    :try_end_0
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 136
    .end local v1    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .end local v2    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :catch_0
    move-exception v0

    .line 137
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    check-cast v0, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .end local v0    # "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    throw v0

    .line 130
    .restart local v1    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .restart local v2    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    .restart local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    :cond_2
    :try_start_1
    instance-of v3, p1, Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    if-eqz v3, :cond_3

    .line 131
    check-cast p1, Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    .end local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    :try_end_1
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 138
    .end local v1    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .end local v2    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :catch_1
    move-exception v0

    .line 139
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    new-instance v3, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v3, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 132
    .end local v0    # "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    .restart local v1    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .restart local v2    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    .restart local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    :cond_3
    :try_start_2
    instance-of v3, p1, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    if-eqz v3, :cond_0

    .line 133
    check-cast p1, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    .end local p1    # "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    :try_end_2
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0
.end method

.method public getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;
    .locals 4
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;

    .prologue
    .line 193
    iget-object v2, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->appid:Ljava/lang/String;

    iget-object v3, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->region:Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getHost(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 194
    .local v0, "host":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 195
    .local v1, "path":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public getObject(Lcom/tencent/cos/xml/model/object/GetObjectRequest;)Lcom/tencent/cos/xml/model/object/GetObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/GetObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 355
    new-instance v0, Lcom/tencent/cos/xml/model/object/GetObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/GetObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/GetObjectResult;

    return-object v0
.end method

.method public getObjectAsync(Lcom/tencent/cos/xml/model/object/GetObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/GetObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 367
    new-instance v0, Lcom/tencent/cos/xml/model/object/GetObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/GetObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 368
    return-void
.end method

.method public initMultipartUpload(Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;)Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 207
    new-instance v0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    return-object v0
.end method

.method public initMultipartUploadAsync(Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 219
    new-instance v0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 220
    return-void
.end method

.method public listParts(Lcom/tencent/cos/xml/model/object/ListPartsRequest;)Lcom/tencent/cos/xml/model/object/ListPartsResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/ListPartsRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 231
    new-instance v0, Lcom/tencent/cos/xml/model/object/ListPartsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/ListPartsResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/ListPartsResult;

    return-object v0
.end method

.method public listPartsAsync(Lcom/tencent/cos/xml/model/object/ListPartsRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/ListPartsRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 243
    new-instance v0, Lcom/tencent/cos/xml/model/object/ListPartsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/ListPartsResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 244
    return-void
.end method

.method public putObject(Lcom/tencent/cos/xml/model/object/PutObjectRequest;)Lcom/tencent/cos/xml/model/object/PutObjectResult;
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/PutObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 379
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/PutObjectResult;-><init>()V

    .line 380
    .local v0, "putObjectResult":Lcom/tencent/cos/xml/model/object/PutObjectResult;
    invoke-virtual {p0, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/model/object/PutObjectResult;->accessUrl:Ljava/lang/String;

    .line 381
    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v1

    check-cast v1, Lcom/tencent/cos/xml/model/object/PutObjectResult;

    return-object v1
.end method

.method public putObjectAsync(Lcom/tencent/cos/xml/model/object/PutObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/PutObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 393
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/PutObjectResult;-><init>()V

    .line 394
    .local v0, "putObjectResult":Lcom/tencent/cos/xml/model/object/PutObjectResult;
    invoke-virtual {p0, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/model/object/PutObjectResult;->accessUrl:Ljava/lang/String;

    .line 395
    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 396
    return-void
.end method

.method public release()V
    .locals 0

    .prologue
    .line 427
    invoke-virtual {p0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancelAll()V

    .line 428
    return-void
.end method

.method protected schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 7
    .param p3, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T1:",
            "Lcom/tencent/cos/xml/model/CosXmlRequest;",
            "T2:",
            "Lcom/tencent/cos/xml/model/CosXmlResult;",
            ">(TT1;TT2;",
            "Lcom/tencent/cos/xml/listener/CosXmlResultListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 147
    .local p1, "cosXmlRequest":Lcom/tencent/cos/xml/model/CosXmlRequest;, "TT1;"
    .local p2, "cosXmlResult":Lcom/tencent/cos/xml/model/CosXmlResult;, "TT2;"
    new-instance v4, Lcom/tencent/cos/xml/CosXmlSimpleService$1;

    invoke-direct {v4, p0, p3, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService$1;-><init>(Lcom/tencent/cos/xml/CosXmlSimpleService;Lcom/tencent/cos/xml/listener/CosXmlResultListener;Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 165
    .local v4, "qCloudResultListener":Lcom/tencent/qcloud/core/common/QCloudResultListener;, "Lcom/tencent/qcloud/core/common/QCloudResultListener<Lcom/tencent/qcloud/core/http/HttpResult<TT2;>;>;"
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->buildHttpRequest(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    move-result-object v2

    .line 166
    .local v2, "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    iget-object v5, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->client:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    iget-object v6, p0, Lcom/tencent/cos/xml/CosXmlSimpleService;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    invoke-virtual {v5, v2, v6}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->resolveRequest(Lcom/tencent/qcloud/core/http/QCloudHttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v3

    .line 168
    .local v3, "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    invoke-virtual {p1, v3}, Lcom/tencent/cos/xml/model/CosXmlRequest;->setTask(Lcom/tencent/qcloud/core/http/HttpTask;)V

    .line 170
    instance-of v5, p1, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;

    if-eqz v5, :cond_1

    .line 171
    move-object v0, p1

    check-cast v0, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/AppendObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;

    .line 180
    :cond_0
    :goto_0
    invoke-virtual {v3}, Lcom/tencent/qcloud/core/http/HttpTask;->schedule()Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/tencent/qcloud/core/http/HttpTask;->addResultListener(Lcom/tencent/qcloud/core/common/QCloudResultListener;)Lcom/tencent/qcloud/core/task/Task;

    .line 185
    .end local v2    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .end local v3    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :goto_1
    return-void

    .line 172
    .restart local v2    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .restart local v3    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :cond_1
    instance-of v5, p1, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    if-eqz v5, :cond_2

    .line 173
    move-object v0, p1

    check-cast v0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    :try_end_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 181
    .end local v2    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .end local v3    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :catch_0
    move-exception v1

    .line 182
    .local v1, "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    new-instance v5, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v5, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    const/4 v6, 0x0

    invoke-interface {p3, p1, v5, v6}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    goto :goto_1

    .line 174
    .end local v1    # "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    .restart local v2    # "httpRequest":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT2;>;"
    .restart local v3    # "httpTask":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT2;>;"
    :cond_2
    :try_start_1
    instance-of v5, p1, Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    if-eqz v5, :cond_3

    .line 175
    move-object v0, p1

    check-cast v0, Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;

    goto :goto_0

    .line 176
    :cond_3
    instance-of v5, p1, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    if-eqz v5, :cond_0

    .line 177
    move-object v0, p1

    check-cast v0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/tencent/qcloud/core/http/HttpTask;->addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    :try_end_1
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public uploadPart(Lcom/tencent/cos/xml/model/object/UploadPartRequest;)Lcom/tencent/cos/xml/model/object/UploadPartResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/UploadPartRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 255
    new-instance v0, Lcom/tencent/cos/xml/model/object/UploadPartResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/UploadPartResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/UploadPartResult;

    return-object v0
.end method

.method public uploadPartAsync(Lcom/tencent/cos/xml/model/object/UploadPartRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/UploadPartRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 267
    new-instance v0, Lcom/tencent/cos/xml/model/object/UploadPartResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/UploadPartResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 268
    return-void
.end method
