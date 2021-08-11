.class public final Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
.super Lcom/tencent/qcloud/core/http/HttpRequest;
.source "QCloudHttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/http/HttpRequest",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

.field private final signerType:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT;>;"
    .local p1, "builder":Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder<TT;>;"
    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/http/HttpRequest;-><init>(Lcom/tencent/qcloud/core/http/HttpRequest$Builder;)V

    .line 27
    invoke-static {p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->access$000(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signerType:Ljava/lang/String;

    .line 28
    invoke-static {p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;->access$100(Lcom/tencent/qcloud/core/http/QCloudHttpRequest$Builder;)Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    .line 29
    return-void
.end method

.method private shouldCalculateAuth()Z
    .locals 1

    .prologue
    .line 48
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT;>;"
    const-string v0, "Authorization"

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/tencent/qcloud/core/util/QCloudStringUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method getQCloudSigner()Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 36
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT;>;"
    const/4 v0, 0x0

    .line 37
    .local v0, "signer":Lcom/tencent/qcloud/core/auth/QCloudSigner;
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signerType:Ljava/lang/String;

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->shouldCalculateAuth()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signerType:Ljava/lang/String;

    invoke-static {v1}, Lcom/tencent/qcloud/core/auth/SignerFactory;->getSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;

    move-result-object v0

    .line 39
    if-nez v0, :cond_0

    .line 40
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudClientException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "can\'t get signer for type : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signerType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 44
    :cond_0
    return-object v0
.end method

.method public getSignProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
    .locals 1

    .prologue
    .line 32
    .local p0, "this":Lcom/tencent/qcloud/core/http/QCloudHttpRequest;, "Lcom/tencent/qcloud/core/http/QCloudHttpRequest<TT;>;"
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->shouldCalculateAuth()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->signProvider:Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
