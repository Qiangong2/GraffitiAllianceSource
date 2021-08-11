.class Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;
.super Ljava/lang/Object;
.source "YXEntryActivity.java"

# interfaces
.implements Lim/yixin/gamesdk/api/YXGameRequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->getToken(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lim/yixin/gamesdk/api/YXGameRequestListener",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

.field private final synthetic val$progressDialog:Landroid/app/ProgressDialog;


# direct methods
.method constructor <init>(Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;Landroid/app/ProgressDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    iput-object p2, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->val$progressDialog:Landroid/app/ProgressDialog;

    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic callback(ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p2, Ljava/lang/Void;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->callback(ILjava/lang/Void;)V

    return-void
.end method

.method public callback(ILjava/lang/Void;)V
    .locals 5
    .param p1, "status"    # I
    .param p2, "aVoid"    # Ljava/lang/Void;

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 140
    iget-object v0, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 141
    if-nez p1, :cond_0

    .line 142
    iget-object v0, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-static {}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->access$0()Ljava/lang/String;

    move-result-object v1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "\u767b\u5f55\u6210\u529f"

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 146
    :goto_0
    iget-object v0, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-virtual {v0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->finish()V

    .line 147
    return-void

    .line 144
    :cond_0
    iget-object v0, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->this$0:Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-static {}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->access$0()Ljava/lang/String;

    move-result-object v1

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "\u767b\u5f55\u5931\u8d25"

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onPreRequest()V
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 136
    return-void
.end method
