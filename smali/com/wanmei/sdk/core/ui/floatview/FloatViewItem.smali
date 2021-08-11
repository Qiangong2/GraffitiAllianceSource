.class public Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/Proguard;


# instance fields
.field private iconName:Ljava/lang/String;

.field private runnable:Ljava/lang/Runnable;

.field private text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getIconName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->iconName:Ljava/lang/String;

    return-object v0
.end method

.method public getRunnable()Ljava/lang/Runnable;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->runnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->text:Ljava/lang/String;

    return-object v0
.end method

.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->runnable:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->runnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    :cond_0
    return-void
.end method

.method public setIconName(Ljava/lang/String;)V
    .locals 0
    .param p1, "iconName"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->iconName:Ljava/lang/String;

    return-void
.end method

.method public setRunnable(Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->runnable:Ljava/lang/Runnable;

    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;->text:Ljava/lang/String;

    return-void
.end method
