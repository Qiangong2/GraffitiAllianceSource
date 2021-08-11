.class public Lcom/wanmei/sdk/core/config/MetaConfig;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/config/NeedValidate;


# instance fields
.field private channelId:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private packageName:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private platform:I
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

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getChannelId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->channelId:I

    return v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public getPlatform()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->platform:I

    return v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setChannelId(I)V
    .locals 0
    .param p1, "channelId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->channelId:I

    return-void
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->packageName:Ljava/lang/String;

    return-void
.end method

.method public setPlatform(I)V
    .locals 0
    .param p1, "platform"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->platform:I

    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->version:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "MetaConfig [version="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->version:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", platform="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->platform:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", channelId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->channelId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", packageName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public validate()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/wanmei/sdk/core/config/ConfigFileException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->version:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/config/ConfigFileException;

    const-string v1, "meta error: version is empty"

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->platform:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    new-instance v0, Lcom/wanmei/sdk/core/config/ConfigFileException;

    const-string v1, "meta error: platform is not android"

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->channelId:I

    if-gtz v0, :cond_2

    new-instance v0, Lcom/wanmei/sdk/core/config/ConfigFileException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "meta error: channelId is:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->channelId:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/wanmei/sdk/core/config/MetaConfig;->packageName:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Lcom/wanmei/sdk/core/config/ConfigFileException;

    const-string v1, "meta error: package is empty"

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    return-void
.end method
