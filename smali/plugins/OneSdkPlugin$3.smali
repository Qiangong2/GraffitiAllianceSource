.class Lplugins/OneSdkPlugin$3;
.super Ljava/lang/Object;
.source "OneSdkPlugin.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lplugins/OneSdkPlugin;->OneSdkLogin()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lplugins/OneSdkPlugin;


# direct methods
.method constructor <init>(Lplugins/OneSdkPlugin;)V
    .locals 0
    .param p1, "this$0"    # Lplugins/OneSdkPlugin;

    .prologue
    .line 79
    iput-object p1, p0, Lplugins/OneSdkPlugin$3;->this$0:Lplugins/OneSdkPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled()V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lplugins/OneSdkPlugin$3;->this$0:Lplugins/OneSdkPlugin;

    invoke-virtual {v0}, Lplugins/OneSdkPlugin;->LoginFail()V

    .line 101
    return-void
.end method

.method public failed(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 94
    iget-object v0, p0, Lplugins/OneSdkPlugin$3;->this$0:Lplugins/OneSdkPlugin;

    invoke-virtual {v0}, Lplugins/OneSdkPlugin;->LoginFail()V

    .line 95
    return-void
.end method

.method public succeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "userId"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "password"    # Ljava/lang/String;
    .param p4, "msg"    # Ljava/lang/String;

    .prologue
    .line 82
    const-string v0, "%s,%s,%s,%s"

    .line 83
    .local v0, "str":Ljava/lang/String;
    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    const/4 v2, 0x2

    aput-object p3, v1, v2

    const/4 v2, 0x3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lplugins/OneSdkPlugin$3;->this$0:Lplugins/OneSdkPlugin;

    .line 87
    invoke-static {v4}, Lplugins/OneSdkPlugin;->access$000(Lplugins/OneSdkPlugin;)Landroid/app/Activity;

    move-result-object v4

    invoke-static {v4}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/sdk/core/open/SDKBase;->getChannelId()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 83
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 88
    iget-object v1, p0, Lplugins/OneSdkPlugin$3;->this$0:Lplugins/OneSdkPlugin;

    const-string v2, "Android_DoLogin"

    invoke-virtual {v1, v2, v0}, Lplugins/OneSdkPlugin;->CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    return-void
.end method
