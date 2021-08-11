.class Lcom/cqq/test/MainActivity$11$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/cqq/test/MainActivity$11;->onGameHasExitView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/cqq/test/MainActivity$11;


# direct methods
.method constructor <init>(Lcom/cqq/test/MainActivity$11;)V
    .locals 0
    .param p1, "this$1"    # Lcom/cqq/test/MainActivity$11;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/cqq/test/MainActivity$11$2;->this$1:Lcom/cqq/test/MainActivity$11;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 252
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 253
    return-void
.end method
