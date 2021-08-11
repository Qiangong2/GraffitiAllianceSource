.class Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;
.super Ljava/lang/Object;
.source "YXEntryActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->onReq(Lim/yixin/sdk/api/BaseReq;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;


# direct methods
.method constructor <init>(Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 103
    iget-object v1, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    .line 104
    invoke-virtual {v1}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 105
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 107
    iget-object v2, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-virtual {v2}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 106
    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 108
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 109
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 110
    iget-object v1, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-virtual {v1, v0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->startActivity(Landroid/content/Intent;)V

    .line 111
    iget-object v1, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-virtual {v1}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->finish()V

    .line 112
    return-void
.end method
