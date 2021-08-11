.class public Lcom/wanmei/sdk/core/config/InitConfig;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/config/NeedValidate;


# instance fields
.field private enableCustomService:Z
    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "custom_service"
    .end annotation
.end field

.field private shareWeixinId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "share_weixin_id"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getShareWeixinId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/InitConfig;->shareWeixinId:Ljava/lang/String;

    return-object v0
.end method

.method public isEnableCustomService()Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/config/InitConfig;->enableCustomService:Z

    return v0
.end method

.method public setEnableCustomService(Z)V
    .locals 0
    .param p1, "enableCustomService"    # Z

    .prologue
    iput-boolean p1, p0, Lcom/wanmei/sdk/core/config/InitConfig;->enableCustomService:Z

    return-void
.end method

.method public setShareWeixinId(Ljava/lang/String;)V
    .locals 0
    .param p1, "shareWeixinId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/config/InitConfig;->shareWeixinId:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Common{shareWeixinId=\'"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/config/InitConfig;->shareWeixinId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", enableCustomService="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/wanmei/sdk/core/config/InitConfig;->enableCustomService:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public validate()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/wanmei/sdk/core/config/ConfigFileException;
        }
    .end annotation

    return-void
.end method
