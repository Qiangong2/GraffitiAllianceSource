.class public Lcom/wanmei/sdk/core/bean/PayReq;
.super Lcom/wanmei/sdk/core/bean/CommReq;


# instance fields
.field private amount:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private appOrder:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private ext:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private serverId:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private uid:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field private version:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/wanmei/sdk/core/bean/CommReq;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->ext:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAmount()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->amount:I

    return v0
.end method

.method public getAppOrder()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->appOrder:Ljava/lang/String;

    return-object v0
.end method

.method public getExt()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->ext:Ljava/lang/String;

    return-object v0
.end method

.method public getPaySchemeVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->version:Ljava/lang/String;

    return-object v0
.end method

.method public getServerId()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->serverId:I

    return v0
.end method

.method public getUid()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->uid:Ljava/lang/String;

    return-object v0
.end method

.method public setAmount(I)V
    .locals 0
    .param p1, "amount"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/PayReq;->amount:I

    return-void
.end method

.method public setAppOrder(Ljava/lang/String;)V
    .locals 0
    .param p1, "appOrder"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/PayReq;->appOrder:Ljava/lang/String;

    return-void
.end method

.method public setExt(Ljava/lang/String;)V
    .locals 1
    .param p1, "ext"    # Ljava/lang/String;

    .prologue
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/bean/PayReq;->ext:Ljava/lang/String;

    :cond_0
    return-void
.end method

.method public setPaySchemeVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "paySchemeVersion"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/PayReq;->version:Ljava/lang/String;

    return-void
.end method

.method public setServerId(I)V
    .locals 0
    .param p1, "serverId"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/PayReq;->serverId:I

    return-void
.end method

.method public setUid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uid"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/PayReq;->uid:Ljava/lang/String;

    return-void
.end method
