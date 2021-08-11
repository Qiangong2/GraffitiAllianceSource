.class public Lcom/wanmei/sdk/core/bean/CommResp;
.super Ljava/lang/Object;


# instance fields
.field protected code:I
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field

.field protected msg:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/wanmei/sdk/core/bean/CommResp;->code:I

    const-string v0, "\u5f02\u5e38\u4fe1\u606f"

    iput-object v0, p0, Lcom/wanmei/sdk/core/bean/CommResp;->msg:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getCode()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/bean/CommResp;->code:I

    return v0
.end method

.method public getMsg()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/CommResp;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public setCode(I)V
    .locals 0
    .param p1, "code"    # I

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/bean/CommResp;->code:I

    return-void
.end method

.method public setMsg(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/CommResp;->msg:Ljava/lang/String;

    return-void
.end method
