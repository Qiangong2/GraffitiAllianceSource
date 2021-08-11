.class public Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;
.super Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;
.source "SessionCredentialProvider.java"


# instance fields
.field private appid:Ljava/lang/String;

.field private region:Ljava/lang/String;

.field private secretId:Ljava/lang/String;

.field private secretKey:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;


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
    .line 43
    .local p1, "httpRequest":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;-><init>(Lcom/tencent/qcloud/core/http/HttpRequest;)V

    .line 44
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .param p3, "appid"    # Ljava/lang/String;
    .param p4, "region"    # Ljava/lang/String;
    .param p5, "userAgent"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 34
    const-wide/16 v0, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/tencent/qcloud/core/auth/ShortTimeCredentialProvider;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    .line 35
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->secretId:Ljava/lang/String;

    .line 36
    iput-object p2, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->secretKey:Ljava/lang/String;

    .line 37
    iput-object p3, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->appid:Ljava/lang/String;

    .line 38
    iput-object p5, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->userAgent:Ljava/lang/String;

    .line 39
    iput-object p4, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->region:Ljava/lang/String;

    .line 40
    return-void
.end method

.method private buildParamStr(Ljava/util/Map;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 141
    .local p1, "requestParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 142
    .local v1, "retStr":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 143
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    if-nez v2, :cond_0

    .line 144
    const/16 v2, 0x3f

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 148
    :goto_1
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v4, "_"

    const-string v5, "."

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v4, 0x3d

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 146
    :cond_0
    const/16 v2, 0x26

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 151
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private getRequestByKey()Lcom/tencent/qcloud/core/http/HttpRequest;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v14, 0x0

    .line 95
    const-string v4, "sts.api.qcloud.com"

    .line 96
    .local v4, "requestHost":Ljava/lang/String;
    const-string v6, "/v2/index.php"

    .line 97
    .local v6, "requestPath":Ljava/lang/String;
    const-string v5, "GET"

    .line 99
    .local v5, "requestMethod":Ljava/lang/String;
    new-instance v1, Ljava/util/TreeMap;

    invoke-direct {v1}, Ljava/util/TreeMap;-><init>()V

    .line 101
    .local v1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v7, "{\"statement\": [{\"action\": [\"name/cos:*\"],\"effect\": \"allow\",\"resource\":[\"qcs::cos:%s:uid/%s:prefix//%s/*\"]}],\"version\": \"2.0\"}"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->region:Ljava/lang/String;

    aput-object v9, v8, v14

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->appid:Ljava/lang/String;

    aput-object v10, v8, v9

    const/4 v9, 0x2

    iget-object v10, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->appid:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 104
    .local v3, "policy":Ljava/lang/String;
    const-string v7, "policy"

    invoke-interface {v1, v7, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    const-string v7, "name"

    const-string v8, "Rabbitliu"

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    const-string v7, "Action"

    const-string v8, "GetFederationToken"

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 107
    const-string v7, "SecretId"

    iget-object v8, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->secretId:Ljava/lang/String;

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    const-string v7, "Nonce"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    new-instance v9, Ljava/util/Random;

    invoke-direct {v9}, Ljava/util/Random;-><init>()V

    const v10, 0x7fffffff

    invoke-virtual {v9, v10}, Ljava/util/Random;->nextInt(I)I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    const-string v7, "Timestamp"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, ""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    const-wide/16 v12, 0x3e8

    div-long/2addr v10, v12

    invoke-virtual {v8, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    const-string v7, "RequestClient"

    iget-object v8, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->userAgent:Ljava/lang/String;

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    invoke-direct {p0, v1, v5, v4, v6}, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->makeSignPlainText(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 115
    .local v2, "plainText":Ljava/lang/String;
    iget-object v7, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->secretKey:Ljava/lang/String;

    invoke-static {v2, v7}, Lcom/tencent/qcloud/core/auth/Utils;->hmacSha1(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    .line 116
    .local v0, "hmacSha1":[B
    if-eqz v0, :cond_0

    .line 117
    const-string v7, "Signature"

    invoke-static {v0, v14}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 120
    :cond_0
    new-instance v7, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    invoke-direct {v7}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;-><init>()V

    const-string v8, "https"

    .line 121
    invoke-virtual {v7, v8}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->scheme(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v7

    .line 122
    invoke-virtual {v7, v4}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->host(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v7

    .line 123
    invoke-virtual {v7, v6}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->path(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v7

    .line 124
    invoke-virtual {v7, v5}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->method(Ljava/lang/String;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v7

    .line 125
    invoke-virtual {v7, v1}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->query(Ljava/util/Map;)Lcom/tencent/qcloud/core/http/HttpRequest$Builder;

    move-result-object v7

    .line 126
    invoke-virtual {v7}, Lcom/tencent/qcloud/core/http/HttpRequest$Builder;->build()Lcom/tencent/qcloud/core/http/HttpRequest;

    move-result-object v7

    return-object v7
.end method

.method private makeSignPlainText(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p2, "requestMethod"    # Ljava/lang/String;
    .param p3, "requestHost"    # Ljava/lang/String;
    .param p4, "requestPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 131
    .local p1, "requestParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, ""

    .line 132
    .local v0, "retStr":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 133
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 134
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 135
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->buildParamStr(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 137
    return-object v0
.end method

.method private parseCAMResponse(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 11
    .param p1, "jsonContent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 71
    if-eqz p1, :cond_1

    .line 73
    :try_start_0
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 74
    .local v9, "jsonObject":Lorg/json/JSONObject;
    const-string v0, "data"

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 75
    .local v7, "data":Lorg/json/JSONObject;
    if-nez v7, :cond_0

    .line 76
    move-object v7, v9

    .line 78
    :cond_0
    const-string v0, "credentials"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 79
    .local v6, "credentials":Lorg/json/JSONObject;
    const-string v0, "expiredTime"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 80
    .local v4, "expiredTime":J
    if-eqz v6, :cond_1

    .line 81
    const-string v0, "sessionToken"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 82
    .local v3, "sessionToken":Ljava/lang/String;
    const-string v0, "tmpSecretId"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 83
    .local v1, "tmpSecretId":Ljava/lang/String;
    const-string v0, "tmpSecretKey"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 84
    .local v2, "tmpSecretKey":Ljava/lang/String;
    new-instance v0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;

    invoke-direct/range {v0 .. v5}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    .end local v1    # "tmpSecretId":Ljava/lang/String;
    .end local v2    # "tmpSecretKey":Ljava/lang/String;
    .end local v3    # "sessionToken":Ljava/lang/String;
    .end local v4    # "expiredTime":J
    .end local v6    # "credentials":Lorg/json/JSONObject;
    .end local v7    # "data":Lorg/json/JSONObject;
    .end local v9    # "jsonObject":Lorg/json/JSONObject;
    :goto_0
    return-object v0

    .line 86
    :catch_0
    move-exception v8

    .line 87
    .local v8, "e":Lorg/json/JSONException;
    new-instance v0, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v10, "parse session json fails"

    invoke-direct {v0, v10, v8}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0

    .line 91
    .end local v8    # "e":Lorg/json/JSONException;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method onGetCredentialFromLocal(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 4
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 50
    :try_start_0
    invoke-direct {p0}, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->getRequestByKey()Lcom/tencent/qcloud/core/http/HttpRequest;

    move-result-object v2

    iput-object v2, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 51
    invoke-static {}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->getDefault()Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->resolveRequest(Lcom/tencent/qcloud/core/http/HttpRequest;)Lcom/tencent/qcloud/core/http/HttpTask;

    move-result-object v2

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/HttpTask;->executeNow()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/tencent/qcloud/core/http/HttpResult;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/HttpResult;->content()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 52
    .local v1, "json":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->parseCAMResponse(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    :try_end_0
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 53
    .end local v1    # "json":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 54
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    new-instance v2, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v3, "get session json fails"

    invoke-direct {v2, v3, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
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
    .line 67
    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/auth/SessionCredentialProvider;->parseCAMResponse(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    move-result-object v0

    return-object v0
.end method
