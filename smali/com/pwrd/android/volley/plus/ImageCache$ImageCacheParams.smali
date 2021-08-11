.class public Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;
.super Ljava/lang/Object;
.source "ImageCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/plus/ImageCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImageCacheParams"
.end annotation


# instance fields
.field public clearDiskCacheOnStart:Z

.field public compressFormat:Landroid/graphics/Bitmap$CompressFormat;

.field public compressQuality:I

.field public diskCacheDir:Ljava/io/File;

.field public diskCacheEnabled:Z

.field public diskCacheSize:I

.field public initDiskCacheOnCreate:Z

.field public memCacheSize:I

.field public memoryCacheEnabled:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uniqueName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 420
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 410
    const/high16 v0, 0x500000

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memCacheSize:I

    .line 411
    const/high16 v0, 0x1400000

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheSize:I

    .line 413
    invoke-static {}, Lcom/pwrd/android/volley/plus/ImageCache;->access$0()Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->compressFormat:Landroid/graphics/Bitmap$CompressFormat;

    .line 414
    const/16 v0, 0x46

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->compressQuality:I

    .line 415
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memoryCacheEnabled:Z

    .line 416
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheEnabled:Z

    .line 417
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->clearDiskCacheOnStart:Z

    .line 418
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->initDiskCacheOnCreate:Z

    .line 421
    invoke-static {p1, p2}, Lcom/pwrd/android/volley/plus/ImageCache;->getDiskCacheDir(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 422
    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 2
    .param p1, "diskCacheDir"    # Ljava/io/File;

    .prologue
    const/4 v1, 0x1

    .line 424
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 410
    const/high16 v0, 0x500000

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memCacheSize:I

    .line 411
    const/high16 v0, 0x1400000

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheSize:I

    .line 413
    invoke-static {}, Lcom/pwrd/android/volley/plus/ImageCache;->access$0()Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->compressFormat:Landroid/graphics/Bitmap$CompressFormat;

    .line 414
    const/16 v0, 0x46

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->compressQuality:I

    .line 415
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memoryCacheEnabled:Z

    .line 416
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheEnabled:Z

    .line 417
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->clearDiskCacheOnStart:Z

    .line 418
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->initDiskCacheOnCreate:Z

    .line 425
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 426
    return-void
.end method

.method private static getMemoryClass(Landroid/content/Context;)I
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 457
    .line 458
    const-string v0, "activity"

    .line 457
    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 458
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v0

    .line 457
    return v0
.end method


# virtual methods
.method public setDiskCacheSize(I)V
    .locals 2
    .param p1, "diskCacheSize"    # I

    .prologue
    .line 429
    const/high16 v0, 0x100000

    if-ge p1, v0, :cond_0

    .line 430
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "setDiskCacheSize - disk cache size must be bigger than 1MB"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 433
    :cond_0
    iput p1, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheSize:I

    .line 434
    return-void
.end method

.method public setMemCacheSizePercent(Landroid/content/Context;F)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "percent"    # F

    .prologue
    const/high16 v1, 0x44800000    # 1024.0f

    .line 449
    const v0, 0x3d4ccccd    # 0.05f

    cmpg-float v0, p2, v0

    if-ltz v0, :cond_0

    const v0, 0x3f4ccccd    # 0.8f

    cmpl-float v0, p2, v0

    if-lez v0, :cond_1

    .line 450
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 453
    :cond_1
    invoke-static {p1}, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->getMemoryClass(Landroid/content/Context;)I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, p2

    mul-float/2addr v0, v1

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memCacheSize:I

    .line 454
    return-void
.end method
