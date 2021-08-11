.class Lplugins/OneSdkPlugin$5;
.super Ljava/lang/Object;
.source "OneSdkPlugin.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lplugins/OneSdkPlugin;->CreateRoleSubmitUserInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    .line 230
    iput-object p1, p0, Lplugins/OneSdkPlugin$5;->this$0:Lplugins/OneSdkPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .locals 0

    .prologue
    .line 236
    return-void
.end method
