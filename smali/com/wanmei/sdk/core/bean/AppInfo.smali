.class public Lcom/wanmei/sdk/core/bean/AppInfo;
.super Ljava/lang/Object;


# instance fields
.field private appId:I

.field private appKey:Ljava/lang/String;

.field private channelId:I

.field private loginSchemeVersion:Ljava/lang/String;

.field private paySchemeVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->appId:I

    return v0
.end method

.method public getAppKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->appKey:Ljava/lang/String;

    return-object v0
.end method

.method public getChannelId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->channelId:I

    return v0
.end method

.method public getLoginSchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->loginSchemeVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPaySchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->paySchemeVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setAppId(I)V
    .locals 0
    .param p1, "appId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->appId:I

    return-void
.end method

.method public setAppKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "appKey"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->appKey:Ljava/lang/String;

    return-void
.end method

.method public setChannelId(I)V
    .locals 0
    .param p1, "channelId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->channelId:I

    return-void
.end method

.method public setLoginSchemeVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "loginSchemeVersion"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->loginSchemeVersion:Ljava/lang/String;

    return-void
.end method

.method public setPaySchemeVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "paySchemeVersion"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/AppInfo;->paySchemeVersion:Ljava/lang/String;

    return-void
.end method
