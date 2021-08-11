.class public final Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "GetBucketRequest.java"


# instance fields
.field private delimiter:Ljava/lang/String;

.field private encodingType:Ljava/lang/String;

.field private marker:Ljava/lang/String;

.field private maxKeys:Ljava/lang/String;

.field private prefix:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 16
    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    .line 23
    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->delimiter:Ljava/lang/String;

    .line 29
    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->marker:Ljava/lang/String;

    .line 32
    const-string v0, "1000"

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->maxKeys:Ljava/lang/String;

    .line 36
    return-void
.end method


# virtual methods
.method public getDelimiter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->delimiter:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodingType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->encodingType:Ljava/lang/String;

    return-object v0
.end method

.method public getMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->marker:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxKeys()J
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->maxKeys:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    const-string v0, "GET"

    return-object v0
.end method

.method public getPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

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
    .line 46
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "prefix"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->delimiter:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "delimiter"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->delimiter:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->encodingType:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 53
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "encoding-type"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->encodingType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->marker:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "marker"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->marker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->maxKeys:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 59
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "max-keys"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->maxKeys:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    :cond_4
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 62
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "prefix"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    :cond_5
    invoke-super {p0}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1

    .prologue
    .line 70
    const/4 v0, 0x0

    return-object v0
.end method

.method public setDelimiter(C)V
    .locals 1
    .param p1, "delimiter"    # C

    .prologue
    .line 102
    invoke-static {p1}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->delimiter:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setEncodingType(Ljava/lang/String;)V
    .locals 0
    .param p1, "encodingType"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->encodingType:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public setMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "marker"    # Ljava/lang/String;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->marker:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setMaxKeys(J)V
    .locals 1
    .param p1, "maxKeys"    # J

    .prologue
    .line 155
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->maxKeys:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setPrefix(Ljava/lang/String;)V
    .locals 0
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;->prefix:Ljava/lang/String;

    .line 80
    return-void
.end method
