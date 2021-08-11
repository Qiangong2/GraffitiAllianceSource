.class public abstract Lcom/wanmei/sdk/core/param/BaseInitParams;
.super Lcom/wanmei/sdk/core/param/BaseParams;


# instance fields
.field protected commonAppId:I

.field protected commonAppKey:Ljava/lang/String;


# direct methods
.method protected constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/param/BaseParams;-><init>()V

    return-void
.end method


# virtual methods
.method public getCommonAppId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppId:I

    return v0
.end method

.method public getCommonAppKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppKey:Ljava/lang/String;

    return-object v0
.end method

.method public setCommonAppId(I)V
    .locals 0
    .param p1, "commonAppId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppId:I

    return-void
.end method

.method public setCommonAppKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "commonAppKey"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppKey:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "InitParams{appId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", appKey=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/param/BaseInitParams;->commonAppKey:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "} "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
