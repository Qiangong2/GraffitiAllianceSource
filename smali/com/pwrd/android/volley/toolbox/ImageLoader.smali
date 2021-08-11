.class public Lcom/pwrd/android/volley/toolbox/ImageLoader;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;,
        Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;,
        Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;,
        Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;,
        Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    }
.end annotation


# static fields
.field private static final BAD_URLS:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String; = "ImageLoader"


# instance fields
.field private mBatchResponseDelayMs:I

.field private final mBatchedResponses:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

.field private final mHandler:Landroid/os/Handler;

.field private final mInFlightLoaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;",
            ">;"
        }
    .end annotation
.end field

.field private final mInFlightRequests:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

.field private mRunnable:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->BAD_URLS:Ljava/util/HashSet;

    return-void
.end method

.method public constructor <init>(Lcom/pwrd/android/volley/RequestQueue;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;)V
    .locals 2
    .param p1, "queue"    # Lcom/pwrd/android/volley/RequestQueue;
    .param p2, "imageCache"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    const/16 v0, 0x64

    iput v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchResponseDelayMs:I

    .line 72
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightLoaders:Ljava/util/HashMap;

    .line 83
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchedResponses:Ljava/util/HashMap;

    .line 88
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mHandler:Landroid/os/Handler;

    .line 129
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

    .line 130
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    .line 131
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightLoaders:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchedResponses:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$3(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    return-object v0
.end method

.method static synthetic access$4(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 310
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->onGetImageSuccess(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method static synthetic access$5(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Lcom/pwrd/android/volley/VolleyError;)V
    .locals 0

    .prologue
    .line 331
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->onGetImageError(Ljava/lang/String;Lcom/pwrd/android/volley/VolleyError;)V

    return-void
.end method

.method static synthetic access$6()Ljava/util/HashSet;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->BAD_URLS:Ljava/util/HashSet;

    return-object v0
.end method

.method static synthetic access$7(Lcom/pwrd/android/volley/toolbox/ImageLoader;)Lcom/pwrd/android/volley/RequestQueue;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

    return-object v0
.end method

.method static synthetic access$8(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method private batchResponse(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)V
    .locals 4
    .param p1, "cacheKey"    # Ljava/lang/String;
    .param p2, "request"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .prologue
    .line 626
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchedResponses:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 629
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRunnable:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 630
    new-instance v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;

    invoke-direct {v0, p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$2;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRunnable:Ljava/lang/Runnable;

    .line 655
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mRunnable:Ljava/lang/Runnable;

    iget v2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchResponseDelayMs:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 657
    :cond_0
    return-void
.end method

.method private static bytesToHexString([B)Ljava/lang/String;
    .locals 7
    .param p0, "bytes"    # [B

    .prologue
    .line 667
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 668
    .local v2, "sb":Ljava/lang/StringBuilder;
    array-length v4, p0

    const/4 v3, 0x0

    :goto_0
    if-lt v3, v4, :cond_0

    .line 675
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 668
    :cond_0
    aget-byte v0, p0, v3

    .line 669
    .local v0, "aByte":B
    and-int/lit16 v5, v0, 0xff

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    .line 670
    .local v1, "hex":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_1

    .line 671
    const/16 v5, 0x30

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 673
    :cond_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 668
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public static getImageListener(Landroid/widget/ImageView;II)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;
    .locals 1
    .param p0, "imageView"    # Landroid/widget/ImageView;
    .param p1, "defaultImageResId"    # I
    .param p2, "errorImageResId"    # I

    .prologue
    .line 144
    new-instance v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;

    invoke-direct {v0, p2, p0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;-><init>(ILandroid/widget/ImageView;I)V

    return-object v0
.end method

.method private onGetImageError(Ljava/lang/String;Lcom/pwrd/android/volley/VolleyError;)V
    .locals 2
    .param p1, "cacheKey"    # Ljava/lang/String;
    .param p2, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 334
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 335
    .local v0, "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v0, :cond_0

    .line 337
    invoke-virtual {v0, p2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->setError(Lcom/pwrd/android/volley/VolleyError;)V

    .line 339
    invoke-direct {p0, p1, v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->batchResponse(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)V

    .line 341
    :cond_0
    return-void
.end method

.method private onGetImageSuccess(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "cacheKey"    # Ljava/lang/String;
    .param p2, "response"    # Landroid/graphics/Bitmap;

    .prologue
    .line 312
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    sget-object v2, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    invoke-interface {v1, p1, p2, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->addBitmapToCache(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;)V

    .line 315
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 317
    .local v0, "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v0, :cond_0

    .line 319
    invoke-static {v0, p2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;Landroid/graphics/Bitmap;)V

    .line 322
    invoke-direct {p0, p1, v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->batchResponse(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)V

    .line 324
    :cond_0
    return-void
.end method

.method private throwIfNotOnMainThread()V
    .locals 2

    .prologue
    .line 660
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 661
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "ImageLoader must be invoked from the main thread."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 663
    :cond_0
    return-void
.end method


# virtual methods
.method public clearBadRecords()V
    .locals 2

    .prologue
    .line 290
    const-string v0, "ImageLoader"

    const-string v1, "bad records cleared"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 291
    sget-object v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->BAD_URLS:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 292
    return-void
.end method

.method public get(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    .locals 1
    .param p1, "requestUrl"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;

    .prologue
    const/4 v0, 0x0

    .line 213
    invoke-virtual {p0, p1, p2, v0, v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->get(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;II)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;II)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    .locals 17
    .param p1, "requestUrl"    # Ljava/lang/String;
    .param p2, "imageListener"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;
    .param p3, "maxWidth"    # I
    .param p4, "maxHeight"    # I

    .prologue
    .line 231
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 232
    new-instance v2, Lcom/pwrd/android/volley/VolleyError;

    const-string v5, "empty_url"

    invoke-direct {v2, v5}, Lcom/pwrd/android/volley/VolleyError;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V

    .line 233
    const/4 v4, 0x0

    .line 286
    :goto_0
    return-object v4

    .line 236
    :cond_0
    invoke-direct/range {p0 .. p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->throwIfNotOnMainThread()V

    .line 238
    sget-object v2, Lcom/pwrd/android/volley/toolbox/ImageLoader;->BAD_URLS:Ljava/util/HashSet;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 239
    new-instance v2, Lcom/pwrd/android/volley/VolleyError;

    const-string v5, "bad url, tried, ignore this time"

    invoke-direct {v2, v5}, Lcom/pwrd/android/volley/VolleyError;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V

    .line 240
    const/4 v4, 0x0

    goto :goto_0

    .line 243
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    move-object/from16 v0, p1

    invoke-interface {v2, v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->getCacheKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 246
    .local v8, "cacheKey":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    move-object/from16 v0, p1

    invoke-interface {v2, v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 247
    .local v3, "cachedBitmap":Landroid/graphics/Bitmap;
    if-eqz v3, :cond_2

    .line 249
    new-instance v1, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v2, p0

    move-object/from16 v4, p1

    invoke-direct/range {v1 .. v6}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;)V

    .line 250
    .local v1, "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    const/4 v2, 0x1

    move-object/from16 v0, p2

    invoke-interface {v0, v1, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V

    move-object v4, v1

    .line 251
    goto :goto_0

    .line 255
    .end local v1    # "container":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    :cond_2
    new-instance v4, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    const/4 v6, 0x0

    move-object/from16 v5, p0

    move-object/from16 v7, p1

    move-object/from16 v9, p2

    invoke-direct/range {v4 .. v9}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;)V

    .line 258
    .local v4, "imageContainer":Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    const/4 v2, 0x1

    move-object/from16 v0, p2

    invoke-interface {v0, v4, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;->onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V

    .line 261
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightLoaders:Ljava/util/HashMap;

    monitor-enter v5

    .line 262
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightLoaders:Ljava/util/HashMap;

    invoke-virtual {v2, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    .line 263
    .local v14, "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    if-eqz v14, :cond_3

    invoke-virtual {v14}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_3

    .line 264
    const-string v2, "ImageLoader"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v9, "loading from disk:"

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v2, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 265
    invoke-virtual {v14, v4}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->addContainer(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V

    .line 266
    monitor-exit v5

    goto/16 :goto_0

    .line 261
    .end local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :catchall_0
    move-exception v2

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 268
    .restart local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :cond_3
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    move-object/from16 v16, v0

    monitor-enter v16
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 269
    :try_start_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightRequests:Ljava/util/HashMap;

    invoke-virtual {v2, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;

    .line 270
    .local v15, "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    if-eqz v15, :cond_4

    .line 272
    invoke-virtual {v15, v4}, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->addContainer(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-object v6, v14

    .line 268
    .end local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .local v6, "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :goto_1
    :try_start_3
    monitor-exit v16
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 261
    :try_start_4
    monitor-exit v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0

    .line 274
    .end local v6    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .restart local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :cond_4
    :try_start_5
    const-string v2, "ImageLoader"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v9, "not existed in disk, start download, url:"

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v2, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 277
    new-instance v6, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    const/4 v13, 0x0

    move-object/from16 v7, p0

    move-object/from16 v9, p1

    move/from16 v10, p3

    move/from16 v11, p4

    move-object v12, v4

    invoke-direct/range {v6 .. v13}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;-><init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Ljava/lang/String;IILcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 278
    .end local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .restart local v6    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mInFlightLoaders:Ljava/util/HashMap;

    invoke-virtual {v2, v8, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v6, v2}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 268
    .end local v15    # "request":Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
    :catchall_1
    move-exception v2

    :goto_2
    monitor-exit v16
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .end local v6    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .restart local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    :catchall_2
    move-exception v2

    move-object v6, v14

    .end local v14    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    .restart local v6    # "loadFromDiskTask":Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;
    goto :goto_2
.end method

.method public isMemCached(Ljava/lang/String;)Z
    .locals 1
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 197
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->throwIfNotOnMainThread()V

    .line 199
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mCache:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;

    invoke-interface {v0, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;->getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBatchedResponseDelay(I)V
    .locals 0
    .param p1, "newBatchedResponseDelayMs"    # I

    .prologue
    .line 301
    iput p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader;->mBatchResponseDelayMs:I

    .line 302
    return-void
.end method
