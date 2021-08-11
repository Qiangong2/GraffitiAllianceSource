.class Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Lcom/pwrd/android/volley/Response$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->tryAddRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/pwrd/android/volley/Response$Listener",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;


# direct methods
.method constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    .line 505
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onResponse(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "response"    # Landroid/graphics/Bitmap;

    .prologue
    .line 508
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->access$5(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Lcom/pwrd/android/volley/toolbox/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$4(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 509
    return-void
.end method

.method public bridge synthetic onResponse(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Landroid/graphics/Bitmap;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;->onResponse(Landroid/graphics/Bitmap;)V

    return-void
.end method
