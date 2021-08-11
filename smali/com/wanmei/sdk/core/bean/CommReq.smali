.class public Lcom/wanmei/sdk/core/bean/CommReq;
.super Ljava/lang/Object;


# instance fields
.field protected appId:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field protected channelId:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field protected extraJson:Ljava/util/HashMap;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected platform:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/wanmei/sdk/core/bean/CommReq;->platform:I

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/bean/CommReq;->extraJson:Ljava/util/HashMap;

    return-void
.end method


# virtual methods
.method public getAppId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/CommReq;->appId:I

    return v0
.end method

.method public getChannelId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/CommReq;->channelId:I

    return v0
.end method

.method public getExtraJson()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/CommReq;->extraJson:Ljava/util/HashMap;

    return-object v0
.end method

.method public setAppId(I)V
    .locals 0
    .param p1, "appId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/CommReq;->appId:I

    return-void
.end method

.method public setChannelId(I)V
    .locals 0
    .param p1, "channelId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/CommReq;->channelId:I

    return-void
.end method

.method public setExtraMap(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "extraMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/CommReq;->extraJson:Ljava/util/HashMap;

    return-void
.end method
