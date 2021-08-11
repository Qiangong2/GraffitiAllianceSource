.class public Lcom/tencent/qcloud/core/auth/COSXmlSigner;
.super Ljava/lang/Object;
.source "COSXmlSigner.java"

# interfaces
.implements Lcom/tencent/qcloud/core/auth/QCloudSigner;


# static fields
.field private static final COS_SESSION_TOKEN:Ljava/lang/String; = "x-cos-security-token"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private signature(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "signKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 58
    invoke-static {p1, p2}, Lcom/tencent/qcloud/core/auth/Utils;->hmacSha1(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    .line 59
    .local v0, "sha1Bytes":[B
    const-string v1, ""

    .line 60
    .local v1, "signature":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 61
    new-instance v1, Ljava/lang/String;

    .end local v1    # "signature":Ljava/lang/String;
    invoke-static {v0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([B)[C

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([C)V

    .line 63
    .restart local v1    # "signature":Ljava/lang/String;
    :cond_0
    return-object v1
.end method


# virtual methods
.method public sign(Lcom/tencent/qcloud/core/http/QCloudHttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentials;)V
    .locals 7
    .param p1, "request"    # Lcom/tencent/qcloud/core/http/QCloudHttpRequest;
    .param p2, "credentials"    # Lcom/tencent/qcloud/core/auth/QCloudCredentials;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 24
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->getSignProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    move-result-object v4

    check-cast v4, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    .line 25
    .local v4, "sourceProvider":Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;
    if-nez v4, :cond_0

    .line 26
    new-instance v5, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v6, "no sign provider for cos xml signer"

    invoke-direct {v5, v6}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 29
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, "authorization":Ljava/lang/StringBuilder;
    move-object v1, p2

    .line 31
    check-cast v1, Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    .line 33
    .local v1, "lifecycleCredentials":Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    invoke-virtual {v4, p1}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->source(Lcom/tencent/qcloud/core/http/HttpRequest;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1}, Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;->getSignKey()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6}, Lcom/tencent/qcloud/core/auth/COSXmlSigner;->signature(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 35
    .local v3, "signature":Ljava/lang/String;
    sget-object v5, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGN_ALGORITHM:Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->SHA1:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_AK:Ljava/lang/String;

    .line 36
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 37
    invoke-interface {p2}, Lcom/tencent/qcloud/core/auth/QCloudCredentials;->getSecretId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGN_TIME:Ljava/lang/String;

    .line 38
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 39
    invoke-virtual {v4}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->getSignTime()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_KEY_TIME:Ljava/lang/String;

    .line 40
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 41
    invoke-interface {v1}, Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;->getKeyTime()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_HEADER_LIST:Ljava/lang/String;

    .line 42
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 43
    invoke-virtual {v4}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->getRealHeaderList()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_URL_PARAM_LIST:Ljava/lang/String;

    .line 44
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 45
    invoke-virtual {v4}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->getRealParameterList()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGNATURE:Ljava/lang/String;

    .line 46
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 49
    const-string v5, "Authorization"

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v5, v6}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    instance-of v5, p2, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;

    if-eqz v5, :cond_1

    move-object v2, p2

    .line 52
    check-cast v2, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;

    .line 53
    .local v2, "sessionCredentials":Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;
    const-string v5, "x-cos-security-token"

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->getToken()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v5, v6}, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    .end local v2    # "sessionCredentials":Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;
    :cond_1
    return-void
.end method
