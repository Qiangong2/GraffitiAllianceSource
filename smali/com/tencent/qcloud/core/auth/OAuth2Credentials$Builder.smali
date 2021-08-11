.class public final Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
.super Ljava/lang/Object;
.source "OAuth2Credentials.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/auth/OAuth2Credentials;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private accessToken:Ljava/lang/String;

.field private authorizationCode:Ljava/lang/String;

.field private expiresIn:J

.field private openId:Ljava/lang/String;

.field private platform:Ljava/lang/String;

.field private refreshToken:Ljava/lang/String;

.field private scope:Ljava/lang/String;

.field private tokenStartTime:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 97
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->platform:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->accessToken:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)J
    .locals 2
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-wide v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->tokenStartTime:J

    return-wide v0
.end method

.method static synthetic access$300(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)J
    .locals 2
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-wide v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->expiresIn:J

    return-wide v0
.end method

.method static synthetic access$400(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->refreshToken:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->openId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->scope:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->authorizationCode:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public accessToken(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->accessToken:Ljava/lang/String;

    .line 106
    return-object p0
.end method

.method public authorizationCode(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "authorizationCode"    # Ljava/lang/String;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->authorizationCode:Ljava/lang/String;

    .line 131
    return-object p0
.end method

.method public build()Lcom/tencent/qcloud/core/auth/OAuth2Credentials;
    .locals 2

    .prologue
    .line 140
    new-instance v0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/tencent/qcloud/core/auth/OAuth2Credentials;-><init>(Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;Lcom/tencent/qcloud/core/auth/OAuth2Credentials$1;)V

    return-object v0
.end method

.method public expiresInSeconds(J)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 1
    .param p1, "val"    # J

    .prologue
    .line 110
    iput-wide p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->expiresIn:J

    .line 111
    return-object p0
.end method

.method public openId(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->openId:Ljava/lang/String;

    .line 126
    return-object p0
.end method

.method public platform(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->platform:Ljava/lang/String;

    .line 101
    return-object p0
.end method

.method public refreshToken(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 120
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->refreshToken:Ljava/lang/String;

    .line 121
    return-object p0
.end method

.method public scope(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 135
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->scope:Ljava/lang/String;

    .line 136
    return-object p0
.end method

.method public tokenStartTime(J)Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;
    .locals 1
    .param p1, "val"    # J

    .prologue
    .line 115
    iput-wide p1, p0, Lcom/tencent/qcloud/core/auth/OAuth2Credentials$Builder;->tokenStartTime:J

    .line 116
    return-object p0
.end method
