.class public Lcom/wanmei/sdk/core/bean/PayResp;
.super Lcom/wanmei/sdk/core/bean/CommResp;


# instance fields
.field private orderId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/bean/CommResp;-><init>()V

    return-void
.end method


# virtual methods
.method public getOrderId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/bean/PayResp;->orderId:Ljava/lang/String;

    return-object v0
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "orderId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/bean/PayResp;->orderId:Ljava/lang/String;

    return-void
.end method
