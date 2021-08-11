.class Lplugins/OneSdkPlugin$2;
.super Ljava/lang/Object;
.source "OneSdkPlugin.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;


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
    .line 60
    iput-object p1, p0, Lplugins/OneSdkPlugin$2;->this$0:Lplugins/OneSdkPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failed(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 70
    const-string v0, "CQQ_ONESDK"

    const-string v1, "onLogoutFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    iget-object v0, p0, Lplugins/OneSdkPlugin$2;->this$0:Lplugins/OneSdkPlugin;

    const-string v1, "logout fail"

    invoke-virtual {v0, v1}, Lplugins/OneSdkPlugin;->ReLogin(Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public succeed()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lplugins/OneSdkPlugin$2;->this$0:Lplugins/OneSdkPlugin;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lplugins/OneSdkPlugin;->ReLogin(Ljava/lang/String;)V

    .line 66
    return-void
.end method
