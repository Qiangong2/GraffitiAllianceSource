.class Lplugins/OneSdkPlugin$1;
.super Ljava/lang/Object;
.source "OneSdkPlugin.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lplugins/OneSdkPlugin;->OneSdkInit(Landroid/content/Context;Landroid/app/Activity;)V
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
    .line 40
    iput-object p1, p0, Lplugins/OneSdkPlugin$1;->this$0:Lplugins/OneSdkPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 52
    const-string v0, "CQQ_ONESDK"

    const-string v1, "onInitFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    iget-object v0, p0, Lplugins/OneSdkPlugin$1;->this$0:Lplugins/OneSdkPlugin;

    invoke-virtual {v0}, Lplugins/OneSdkPlugin;->LoginFail()V

    .line 55
    return-void
.end method

.method public initSucceed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 44
    const-string v0, "CQQ_ONESDK"

    const-string v1, "onInitSucceed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    iget-object v0, p0, Lplugins/OneSdkPlugin$1;->this$0:Lplugins/OneSdkPlugin;

    invoke-virtual {v0}, Lplugins/OneSdkPlugin;->OneSdkLogin()V

    .line 48
    return-void
.end method
