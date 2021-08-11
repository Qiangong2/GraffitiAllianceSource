.class Lcom/wanmei/sdk/core/CoreTestMain$8;
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

    iput-object p1, p0, Lcom/wanmei/sdk/core/CoreTestMain$8;->a:Lcom/wanmei/sdk/core/CoreTestMain;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/log/manager/LogManager;->upLoadLog()V

    return-void
.end method
