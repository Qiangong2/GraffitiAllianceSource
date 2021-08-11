.class public Lcom/tencent/qcloud/core/auth/OAuth2Credentials;
.super Ljava/lang/Object;
.source "OAuth2Credentials.java"

# interfaces
.implements Lcom/tencent/qcloud/core/auth/QCloudCredentials;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    }
.end annotation


# instance fields
.field private accessToken:Ljava/lang/String;

.field private authorizationCode:Ljava/lang/String;

.field private openId:Ljava/lang/String;

.field private platform:Ljava/lang/String;

.field private refreshToken:Ljava/lang/String;

.field private scope:Ljava/lang/String;

.field private tokenStartTime:Ljava/util/Date;

.field private validFromDate:Ljava/util/Date;


# direct methods
.method private constructor <init>(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)V
    .locals 8
    .param p1, "builder"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$000(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->platform:Ljava/lang/String;

    .line 32
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$100(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->accessToken:Ljava/lang/String;

    .line 33
    new-instance v0, Ljava/util/Date;

    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$200(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->tokenStartTime:Ljava/util/Date;

    .line 34
    new-instance v0, Ljava/util/Date;

    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$200(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)J

    move-result-wide v2

    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$300(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    add-long/2addr v2, v4

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->validFromDate:Ljava/util/Date;

    .line 35
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$400(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->refreshToken:Ljava/lang/String;

    .line 36
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$500(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->openId:Ljava/lang/String;

    .line 37
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$600(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->scope:Ljava/lang/String;

    .line 38
    invoke-static {p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->access$700(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->authorizationCode:Ljava/lang/String;

    .line 39
    return-void
.end method

.method synthetic constructor <init>(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;Lcom/tencent/qcloud/core/auth/OAuth2Credentials$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .param p2, "x1"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$1;

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;-><init>(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)V

    return-void
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->accessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorizationCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->authorizationCode:Ljava/lang/String;

    return-object v0
.end method

.method public getExpiresInSeconds()J
    .locals 4

    .prologue
    .line 63
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->validFromDate:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->tokenStartTime:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    return-wide v0
.end method

.method public getOpenId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->openId:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatform()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->platform:Ljava/lang/String;

    return-object v0
.end method

.method public getRefreshToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->refreshToken:Ljava/lang/String;

    return-object v0
.end method

.method public getScope()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->scope:Ljava/lang/String;

    return-object v0
.end method

.method public getSecretId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->openId:Ljava/lang/String;

    return-object v0
.end method

.method public getTokenStartTime()Ljava/util/Date;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->tokenStartTime:Ljava/util/Date;

    return-object v0
.end method

.method public getValidFromDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->validFromDate:Ljava/util/Date;

    return-object v0
.end method

.method public isExpired()Z
    .locals 4

    .prologue
    .line 59
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;->validFromDate:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
