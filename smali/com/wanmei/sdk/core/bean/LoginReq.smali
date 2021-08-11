.class public Lcom/wanmei/sdk/core/bean/LoginReq;
.super Lcom/wanmei/sdk/core/bean/CommReq;


# instance fields
.field private platToken:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private platUid:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private version:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/bean/CommReq;-><init>()V

    return-void
.end method


# virtual methods
.method public getLoginSchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->version:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->platToken:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatUid()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->platUid:Ljava/lang/String;

    return-object v0
.end method

.method public setLoginSchemeVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "loginSchemeVersion"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->version:Ljava/lang/String;

    return-void
.end method

.method public setPlatToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "platToken"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->platToken:Ljava/lang/String;

    return-void
.end method

.method public setPlatUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "platUid"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/LoginReq;->platUid:Ljava/lang/String;

    return-void
.end method
