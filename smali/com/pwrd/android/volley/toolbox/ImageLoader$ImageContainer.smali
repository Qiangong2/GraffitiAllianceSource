.class public Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ImageContainer"
.end annotation


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field private final mCacheKey:Ljava/lang/String;

.field private mListener:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

.field private final mRequestUrl:Ljava/lang/String;

.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;


# direct methods
.method public constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;)V
    .locals 0
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "requestUrl"    # Ljava/lang/String;
    .param p4, "cacheKey"    # Ljava/lang/String;
    .param p5, "listener"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    .prologue
    .line 373
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    .line 372
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 374
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mBitmap:Landroid/graphics/Bitmap;

    .line 375
    iput-object p3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mRequestUrl:Ljava/lang/String;

    .line 376
    iput-object p4, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    .line 377
    iput-object p5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mListener:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    .line 378
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mListener:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 351
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mBitmap:Landroid/graphics/Bitmap;

    return-void
.end method


# virtual methods
.method public cancelRequest()V
    .locals 6

    .prologue
    .line 388
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mListener:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    if-nez v3, :cond_0

    .line 417
    :goto_0
    return-void

    .line 391
    :cond_0
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v4

    monitor-enter v4

    .line 392
    :try_start_0
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    .line 393
    .local v1, "loadTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    if-eqz v1, :cond_1

    .line 394
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cancel(Z)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 395
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 391
    :cond_1
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 399
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v4

    monitor-enter v4

    .line 400
    :try_start_1
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 401
    .local v2, "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v2, :cond_3

    .line 402
    invoke-virtual {v2, p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->removeContainerAndCancelIfNecessary(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Z

    move-result v0

    .line 403
    .local v0, "canceled":Z
    if-eqz v0, :cond_2

    .line 404
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 399
    .end local v0    # "canceled":Z
    :cond_2
    :goto_1
    monitor-exit v4

    goto :goto_0

    .end local v2    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3

    .line 391
    .end local v1    # "loadTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :catchall_1
    move-exception v3

    :try_start_2
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v3

    .line 408
    .restart local v1    # "loadTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .restart local v2    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    :cond_3
    :try_start_3
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    check-cast v2, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 409
    .restart local v2    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v2, :cond_2

    .line 410
    invoke-virtual {v2, p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->removeContainerAndCancelIfNecessary(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Z

    .line 411
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)Ljava/util/HashSet;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    if-nez v3, :cond_2

    .line 412
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v3

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mCacheKey:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method public deleteListener()V
    .locals 1

    .prologue
    .line 381
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mListener:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    .line 382
    return-void
.end method

.method public getBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getRequestUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 430
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->mRequestUrl:Ljava/lang/String;

    return-object v0
.end method
