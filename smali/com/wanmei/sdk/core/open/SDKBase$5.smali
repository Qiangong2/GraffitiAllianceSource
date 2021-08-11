.class Lcom/wanmei/sdk/core/open/SDKBase$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/task/LoginTask$LoginCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKBase;->loginOneSDK(Ljava/lang/String;Ljava/lang/String;Lcom/wanmei/sdk/core/param/BaseLoginParams;)V
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
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKBase$5;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failed(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "login failed, msg:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$5;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->loginOneSDKFailed(Ljava/lang/String;)V

    return-void
.end method

.method public succeed(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKBase;->access$200()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "login succeed msg:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/open/SDKBase$5;->this$0:Lcom/wanmei/sdk/core/open/SDKBase;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/open/SDKBase;->loginSucceed(Ljava/lang/String;)V

    return-void
.end method
