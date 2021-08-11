.class Lcom/cqq/test/MainActivity$7;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cqq/test/MainActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/cqq/test/MainActivity;


# direct methods
.method constructor <init>(Lcom/cqq/test/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/cqq/test/MainActivity;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/cqq/test/MainActivity$7;->this$0:Lcom/cqq/test/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .locals 0

    .prologue
    .line 169
    return-void
.end method
