.class Lcom/pwrd/android/volley/toolbox/ImageLoader$2;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;->batchResponse(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;


# direct methods
.method constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    .line 630
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 633
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 649
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 650
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$8(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/Runnable;)V

    .line 651
    return-void

    .line 633
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 634
    .local v0, "bir":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)Ljava/util/HashSet;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .line 638
    .local v1, "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 641
    invoke-virtual {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->getError()Lcom/pwrd/android/volley/VolleyError;

    move-result-object v4

    if-nez v4, :cond_3

    .line 642
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Landroid/graphics/Bitmap;)V

    .line 643
    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v4, v1, v5}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V

    goto :goto_0

    .line 645
    :cond_3
    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    move-result-object v4

    invoke-virtual {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->getError()Lcom/pwrd/android/volley/VolleyError;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V

    goto :goto_0
.end method
