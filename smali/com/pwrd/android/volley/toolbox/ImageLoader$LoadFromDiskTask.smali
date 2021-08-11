.class Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
.super Landroid/os/AsyncTask;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LoadFromDiskTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private cacheKey:Ljava/lang/String;

.field private final mContainers:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;",
            ">;"
        }
    .end annotation
.end field

.field private maxHeight:I

.field private maxWidth:I

.field private requestUrl:Ljava/lang/String;

.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Ljava/lang/String;IILcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V
    .locals 1
    .param p2, "cacheKey"    # Ljava/lang/String;
    .param p3, "requestUrl"    # Ljava/lang/String;
    .param p4, "maxWidth"    # I
    .param p5, "maxHeight"    # I
    .param p6, "container"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .prologue
    .line 441
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 439
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    .line 442
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    .line 443
    iput-object p3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    .line 444
    iput p4, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxWidth:I

    .line 445
    iput p5, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxHeight:I

    .line 446
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p6}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 447
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Ljava/lang/String;IILcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V
    .locals 0

    .prologue
    .line 441
    invoke-direct/range {p0 .. p6}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Ljava/lang/String;IILcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V

    return-void
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Lcom/pwrd/android/volley/toolbox/ImageLoader;
    .locals 1

    .prologue
    .line 434
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    return-object v0
.end method

.method private loadedFromDisk(Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 473
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v1}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 482
    return-void

    .line 473
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .line 474
    .local v0, "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 477
    invoke-static {v0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Landroid/graphics/Bitmap;)V

    .line 479
    const-string v2, "ImageLoader"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "get bitmap from disk, url:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 480
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v0, v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V

    goto :goto_0
.end method

.method private onLoadImageFinish(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "cacheKey"    # Ljava/lang/String;
    .param p2, "response"    # Landroid/graphics/Bitmap;

    .prologue
    .line 533
    if-eqz p2, :cond_0

    .line 534
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$3(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->addBitmapToMemCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 536
    :cond_0
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 537
    return-void
.end method

.method private tryAddRequest()V
    .locals 10

    .prologue
    .line 486
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v9

    monitor-enter v9

    .line 487
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 488
    .local v8, "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v8, :cond_1

    .line 490
    const-string v1, "ImageLoader"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "not existed in disk, downloading, url:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 491
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v8, v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->addContainers(Ljava/util/HashSet;)V

    .line 486
    :cond_0
    :goto_0
    monitor-exit v9

    .line 529
    return-void

    .line 493
    :cond_1
    const-string v1, "ImageLoader"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "not existed in disk, start download, url:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 495
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .end local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    check-cast v8, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 496
    .restart local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v8, :cond_2

    .line 498
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v1}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .line 499
    .local v7, "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    invoke-virtual {v8, v7}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->addContainer(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V

    goto :goto_1

    .line 486
    .end local v7    # "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    .end local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    :catchall_0
    move-exception v1

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 505
    .restart local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    :cond_2
    :try_start_1
    new-instance v0, Lcom/pwrd/android/volley/toolbox/ImageRequest;

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->requestUrl:Ljava/lang/String;

    new-instance v2, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;

    invoke-direct {v2, p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$1;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V

    .line 510
    iget v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxWidth:I

    iget v4, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxHeight:I

    .line 511
    sget-object v5, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    new-instance v6, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;

    invoke-direct {v6, p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V

    .line 505
    invoke-direct/range {v0 .. v6}, Lcom/pwrd/android/volley/toolbox/ImageRequest;-><init>(Ljava/lang/String;Lcom/pwrd/android/volley/Response$Listener;IILandroid/graphics/Bitmap$Config;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 519
    .local v0, "newRequest":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/pwrd/android/volley/Request;->setShouldCache(Z)V

    .line 521
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$7(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Lcom/pwrd/android/volley/RequestQueue;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/pwrd/android/volley/RequestQueue;->add(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/Request;

    .line 523
    new-instance v8, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .end local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-direct {v8, v1, v0, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Lcom/pwrd/android/volley/Request;Ljava/util/HashSet;)V

    .line 525
    .restart local v8    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v1

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    invoke-virtual {v1, v2, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method


# virtual methods
.method public addContainer(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V
    .locals 1
    .param p1, "imageContainer"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .prologue
    .line 455
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 456
    return-void
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 451
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$3(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    iget v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxWidth:I

    iget v3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->maxHeight:I

    invoke-interface {v0, v1, v2, v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->getBitmapFromDiskCache(Ljava/lang/String;II)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->doInBackground([Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 460
    if-eqz p1, :cond_0

    .line 461
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->loadedFromDisk(Landroid/graphics/Bitmap;)V

    .line 466
    :goto_0
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;

    move-result-object v1

    monitor-enter v1

    .line 467
    :try_start_0
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->cacheKey:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->onLoadImageFinish(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 466
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 469
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 470
    return-void

    .line 463
    :cond_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->tryAddRequest()V

    goto :goto_0

    .line 466
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Landroid/graphics/Bitmap;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->onPostExecute(Landroid/graphics/Bitmap;)V

    return-void
.end method
