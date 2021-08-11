.class public Lcom/pwrd/onesdk/demo/yixin/yxapi/AppRegister;
.super Lim/yixin/sdk/api/YXAPIBaseBroadcastReceiver;
.source "AppRegister.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lim/yixin/sdk/api/YXAPIBaseBroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method protected getAppId(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    const-string v2, ""

    .line 30
    .local v2, "msg":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x80

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 31
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v4, "YX_GAME_ID"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 35
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :goto_0
    const-string v3, "AppRegister"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, " msg == "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    return-object v2

    .line 32
    :catch_0
    move-exception v1

    .line 33
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method protected onAfterYixinStart(Lim/yixin/sdk/channel/YXMessageProtocol;)V
    .locals 0
    .param p1, "protocol"    # Lim/yixin/sdk/channel/YXMessageProtocol;

    .prologue
    .line 46
    return-void
.end method
