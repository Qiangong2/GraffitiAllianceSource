.class Lcom/wanmei/sdk/core/open/SDKBase$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->initPushSDK()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKBase;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKBase;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$2;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public openFail(I)V
    .locals 3
    .param p1, "code"    # I

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "openPush openFail code: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method public openSuccess()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string v1, "openPush openSuccess"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
