.class public Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;
.super Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;
.source "ShortTimeCredentialProvider.java"


# instance fields
.field private duration:J

.field protected httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private secretId:Ljava/lang/String;

.field private secretKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/tencent/qcloud/core/http/HttpRequest;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p1, "httpRequest":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 1
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .param p3, "keyDuration"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretId:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretKey:Ljava/lang/String;

    .line 25
    iput-wide p3, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->duration:J

    .line 26
    return-void
.end method

.method private secretKey2SignKey(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "secretKey"    # Ljava/lang/String;
    .param p2, "keyTime"    # Ljava/lang/String;

    .prologue
    .line 63
    invoke-static {p2, p1}, Lcom/tencent/qcloud/core/auth/Utils;->hmacSha1(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    .line 64
    .local v0, "hmacSha1":[B
    if-eqz v0, :cond_0

    .line 65
    new-instance v1, Ljava/lang/String;

    invoke-static {v0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([B)[C

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([C)V

    .line 68
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected fetchNewCredentials()Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 34
    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretId:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretKey:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 35
    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretId:Ljava/lang/String;

    iget-object v3, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretKey:Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->onGetCredentialFromLocal(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    move-result-object v2

    .line 45
    :goto_0
    return-object v2

    .line 36
    :cond_0
    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    if-eqz v2, :cond_1

    .line 38
    :try_start_0
    invoke-static {}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->getDefault()Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->resolveRequest(Lcom/tencent/qcloud/core/http/HttpRequest;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v2

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/HttpTask;->executeNow()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/tencent/qcloud/core/http/HttpResult;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/HttpResult;->content()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 39
    .local v1, "json":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->onRemoteCredentialReceived(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    :try_end_0
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 40
    .end local v1    # "json":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 41
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    new-instance v2, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v3, "get session json fails"

    invoke-direct {v2, v3, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 45
    .end local v0    # "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method onGetCredentialFromLocal(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 10
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 50
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    div-long v0, v6, v8

    .line 51
    .local v0, "current":J
    iget-wide v6, p0, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->duration:J

    add-long v2, v0, v6

    .line 52
    .local v2, "expired":J
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ";"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 53
    .local v4, "keyTime":Ljava/lang/String;
    invoke-direct {p0, p2, v4}, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;->secretKey2SignKey(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "signKey":Ljava/lang/String;
    new-instance v6, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;

    invoke-direct {v6, p1, v5, v4}, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v6
.end method

.method protected onRemoteCredentialReceived(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 1
    .param p1, "jsonContent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 59
    const/4 v0, 0x0

    return-object v0
.end method
