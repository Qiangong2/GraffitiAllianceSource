.class Lcom/wanmei/sdk/core/CoreTestMain$6;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/CoreTestMain;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/CoreTestMain;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/CoreTestMain;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/CoreTestMain$6;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain$6;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-static {v0}, Lcom/wanmei/sdk/core/CoreTestMain;->d(Lcom/wanmei/sdk/core/CoreTestMain;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "CoreTestMain"

    invoke-static {v1, v0}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method
