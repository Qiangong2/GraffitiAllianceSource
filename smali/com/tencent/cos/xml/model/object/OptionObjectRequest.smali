.class public final Lcom/tencent/cos/xml/model/object/OptionObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "OptionObjectRequest.java"


# instance fields
.field private accessControlHeaders:Ljava/lang/String;

.field private accessControlMethod:Ljava/lang/String;

.field private origin:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "origin"    # Ljava/lang/String;
    .param p4, "accessControlMethod"    # Ljava/lang/String;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->origin:Ljava/lang/String;

    .line 28
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlMethod:Ljava/lang/String;

    .line 29
    invoke-virtual {p0, p3}, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->setOrigin(Ljava/lang/String;)V

    .line 30
    invoke-virtual {p0, p4}, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->setAccessControlMethod(Ljava/lang/String;)V

    .line 31
    return-void
.end method


# virtual methods
.method public checkParameters()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 45
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->checkParameters()V

    .line 46
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->origin:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 47
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "option request origin must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlMethod:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 50
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "option request accessControlMethod must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_1
    return-void
.end method

.method public getAccessControlHeaders()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlHeaders:Ljava/lang/String;

    return-object v0
.end method

.method public getAccessControlMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlMethod:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    const-string v0, "OPTIONS"

    return-object v0
.end method

.method public getOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->origin:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    return-object v0
.end method

.method public setAccessControlHeaders(Ljava/lang/String;)V
    .locals 1
    .param p1, "accessControlHeaders"    # Ljava/lang/String;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlHeaders:Ljava/lang/String;

    .line 105
    if-eqz p1, :cond_0

    .line 106
    const-string v0, "Access-Control-Request-Headers"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    :cond_0
    return-void
.end method

.method public setAccessControlMethod(Ljava/lang/String;)V
    .locals 2
    .param p1, "accessControlMethod"    # Ljava/lang/String;

    .prologue
    .line 83
    if-eqz p1, :cond_0

    .line 84
    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlMethod:Ljava/lang/String;

    .line 85
    const-string v0, "Access-Control-Request-Method"

    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->accessControlMethod:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    :cond_0
    return-void
.end method

.method public setOrigin(Ljava/lang/String;)V
    .locals 1
    .param p1, "origin"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->origin:Ljava/lang/String;

    .line 63
    if-eqz p1, :cond_0

    .line 64
    const-string v0, "Origin"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/OptionObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    :cond_0
    return-void
.end method
