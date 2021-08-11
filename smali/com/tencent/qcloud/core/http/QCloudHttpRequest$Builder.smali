.class public Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
.super Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
.source "QCloudHttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/http/HttpRequest$Builder",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

.field private signerType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->signerType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 99
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1, p2}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "bodySerializer"    # Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/RequestBodySerializer;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 119
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->body(Lcom/tencent/qcloud/core/http/RequestBodySerializer;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic build()Lcom/tencent/qcloud/core/http/HttpRequest;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->build()Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    move-result-object v0

    return-object v0
.end method

.method public build()Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 133
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->prepareBuild()V

    .line 134
    new-instance v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    invoke-direct {v0, p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)V

    return-object v0
.end method

.method public bridge synthetic contentMD5()Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->contentMD5()Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public contentMD5()Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 94
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->contentMD5()Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
            "<TT;>;)",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    .local p1, "responseBodyConverter":Lcom/tencent/qcloud/core/http/ResponseBodyConverter;, "Lcom/tencent/qcloud/core/http/ResponseBodyConverter<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->converter(Lcom/tencent/qcloud/core/http/ResponseBodyConverter;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "host"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 84
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic query(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->query(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public query(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1, p2}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->query(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic removeHeader(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->removeHeader(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public removeHeader(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 104
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->removeHeader(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "scheme"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 69
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic setUseCache(Z)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->setUseCache(Z)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setUseCache(Z)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "cacheEnabled"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 114
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->setUseCache(Z)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public signer(Ljava/lang/String;Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 0
    .param p1, "signerType"    # Ljava/lang/String;
    .param p2, "signProvider"    # Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 57
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->signerType:Ljava/lang/String;

    .line 58
    iput-object p2, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 59
    return-object p0
.end method

.method public bridge synthetic tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "tag"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 124
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->tag(Ljava/lang/Object;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic url(Ljava/net/URL;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->url(Ljava/net/URL;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public url(Ljava/net/URL;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URL;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->url(Ljava/net/URL;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method

.method public bridge synthetic userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    move-result-object v0

    return-object v0
.end method

.method public userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    .locals 1
    .param p1, "userAgent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 109
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-super {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->userAgent(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;

    return-object v0
.end method
