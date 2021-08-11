.class public abstract Lcom/tencent/cos/xml/model/CosXmlRequest;
.super Ljava/lang/Object;
.source "CosXmlRequest.java"


# instance fields
.field private httpTask:Lcom/tencent/qcloud/core/http/HttpTask;

.field private isNeedMD5:Z

.field protected queryParameters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected requestHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->queryParameters:Ljava/util/Map;

    .line 33
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->requestHeaders:Ljava/util/Map;

    .line 36
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->isNeedMD5:Z

    return-void
.end method


# virtual methods
.method protected addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 77
    iget-object v1, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->requestHeaders:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 78
    iget-object v1, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->requestHeaders:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 82
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 83
    iget-object v1, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->requestHeaders:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    return-void

    .line 80
    .end local v0    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .restart local v0    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    goto :goto_0
.end method

.method public abstract checkParameters()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation
.end method

.method public getHost(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "appid"    # Ljava/lang/String;
    .param p2, "region"    # Ljava/lang/String;

    .prologue
    .line 87
    const-string v1, "myqcloud.com"

    .line 88
    .local v1, "suffix":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/tencent/cos/xml/model/CosXmlRequest;->getHostPrefix()Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "bucket":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 90
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 92
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".cos."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method protected abstract getHostPrefix()Ljava/lang/String;
.end method

.method public getHttpTask()Lcom/tencent/qcloud/core/http/HttpTask;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->httpTask:Lcom/tencent/qcloud/core/http/HttpTask;

    return-object v0
.end method

.method public abstract getMethod()Ljava/lang/String;
.end method

.method public abstract getPath()Ljava/lang/String;
.end method

.method public getQueryString()Ljava/util/Map;
    .locals 1
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
    .line 45
    iget-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->queryParameters:Ljava/util/Map;

    return-object v0
.end method

.method public abstract getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation
.end method

.method public getRequestHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->requestHeaders:Ljava/util/Map;

    return-object v0
.end method

.method public getSignSourceProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
    .locals 4

    .prologue
    .line 105
    iget-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    if-nez v0, :cond_0

    .line 106
    new-instance v0, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;-><init>()V

    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->setDuration(J)Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    return-object v0
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->isNeedMD5:Z

    return v0
.end method

.method public setNeedMD5(Z)V
    .locals 0
    .param p1, "isNeedMD5"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->isNeedMD5:Z

    .line 66
    return-void
.end method

.method public setRequestHeaders(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 69
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 70
    invoke-static {p2}, Lcom/tencent/cos/xml/utils/URLEncodeUtils;->cosPathEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 71
    invoke-virtual {p0, p1, p2}, Lcom/tencent/cos/xml/model/CosXmlRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    :cond_0
    return-void
.end method

.method public setSign(J)V
    .locals 1
    .param p1, "signDuration"    # J

    .prologue
    .line 96
    new-instance v0, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;-><init>()V

    invoke-virtual {v0, p1, p2}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->setDuration(J)Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 97
    return-void
.end method

.method public setSign(JJ)V
    .locals 1
    .param p1, "startTime"    # J
    .param p3, "endTime"    # J

    .prologue
    .line 100
    new-instance v0, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;-><init>()V

    invoke-virtual {v0, p1, p2}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->setSignBeginTime(J)Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    move-result-object v0

    .line 101
    invoke-virtual {v0, p3, p4}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->setSignExpiredTime(J)Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 102
    return-void
.end method

.method public setSign(JLjava/util/Set;Ljava/util/Set;)V
    .locals 3
    .param p1, "signDuration"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p3, "parameters":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .local p4, "headers":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v1, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    invoke-direct {v1}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;-><init>()V

    invoke-virtual {v1, p1, p2}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->setDuration(J)Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    move-result-object v0

    .line 113
    .local v0, "cosXmlSignSourceProvider":Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;
    invoke-virtual {v0, p3}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->parameters(Ljava/util/Set;)V

    .line 114
    invoke-virtual {v0, p4}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->headers(Ljava/util/Set;)V

    .line 115
    iput-object v0, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->signSourceProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 116
    return-void
.end method

.method public setTask(Lcom/tencent/qcloud/core/http/HttpTask;)V
    .locals 0
    .param p1, "httpTask"    # Lcom/tencent/qcloud/core/http/HttpTask;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/tencent/cos/xml/model/CosXmlRequest;->httpTask:Lcom/tencent/qcloud/core/http/HttpTask;

    .line 120
    return-void
.end method
