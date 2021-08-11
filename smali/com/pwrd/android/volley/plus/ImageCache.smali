.class public Lcom/pwrd/android/volley/plus/ImageCache;
.super Ljava/lang/Object;
.source "ImageCache.java"

# interfaces
.implements Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;
.implements Lcom/pwrd/android/volley/plus/PersistentCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;
    }
.end annotation


# static fields
.field private static final DEFAULT_CLEAR_DISK_CACHE_ON_START:Z = false

.field private static final DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

.field private static final DEFAULT_COMPRESS_QUALITY:I = 0x46

.field private static final DEFAULT_DISK_CACHE_ENABLED:Z = true

.field private static final DEFAULT_DISK_CACHE_SIZE:I = 0x1400000

.field private static final DEFAULT_INIT_DISK_CACHE_ON_CREATE:Z = true

.field private static final DEFAULT_MEM_CACHE_ENABLED:Z = true

.field private static final DEFAULT_MEM_CACHE_SIZE:I = 0x500000

.field private static final DISK_CACHE_INDEX:I = 0x0

.field static final TAG:Ljava/lang/String; = "ImageCache"


# instance fields
.field private mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

.field private final mDiskCacheLock:Ljava/lang/Object;

.field private mDiskCacheStarting:Z

.field private mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

.field private mMemoryCache:Landroid/support/v4/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    sput-object v0, Lcom/pwrd/android/volley/plus/ImageCache;->DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

    .line 60
    return-void
.end method

.method public constructor <init>(Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;)V
    .locals 1
    .param p1, "cacheParams"    # Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheStarting:Z

    .line 72
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/ImageCache;->init(Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;)V

    .line 73
    return-void
.end method

.method static synthetic access$0()Landroid/graphics/Bitmap$CompressFormat;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/pwrd/android/volley/plus/ImageCache;->DEFAULT_COMPRESS_FORMAT:Landroid/graphics/Bitmap$CompressFormat;

    return-object v0
.end method

.method private static bytesToHexString([B)Ljava/lang/String;
    .locals 7
    .param p0, "bytes"    # [B

    .prologue
    .line 489
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 490
    .local v2, "sb":Ljava/lang/StringBuilder;
    array-length v4, p0

    const/4 v3, 0x0

    :goto_0
    if-lt v3, v4, :cond_0

    .line 497
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 490
    :cond_0
    aget-byte v0, p0, v3

    .line 491
    .local v0, "aByte":B
    and-int/lit16 v5, v0, 0xff

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    .line 492
    .local v1, "hex":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_1

    .line 493
    const/16 v5, 0x30

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 495
    :cond_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 490
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public static getBitmapSize(Landroid/graphics/Bitmap;)I
    .locals 2
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 508
    invoke-static {}, Lcom/pwrd/android/volley/plus/OsVersionUtils;->hasHoneycombMR1()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 509
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getByteCount()I

    move-result v0

    .line 512
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v0

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    mul-int/2addr v0, v1

    goto :goto_0
.end method

.method public static getDiskCacheDir(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uniqueName"    # Ljava/lang/String;

    .prologue
    .line 472
    invoke-static {}, Lcom/pwrd/android/volley/plus/ImageCache;->isSdCardOK()Z

    move-result v1

    if-nez v1, :cond_0

    .line 473
    const/4 v1, 0x0

    .line 479
    :goto_0
    return-object v1

    .line 476
    :cond_0
    const-string v1, "mounted"

    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 477
    invoke-static {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 479
    .local v0, "cachePath":Ljava/lang/String;
    :goto_1
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 477
    .end local v0    # "cachePath":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public static getExternalCacheDir(Landroid/content/Context;)Ljava/io/File;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 534
    invoke-static {}, Lcom/pwrd/android/volley/plus/OsVersionUtils;->hasFroyo()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 535
    invoke-virtual {p0}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v1

    .line 536
    .local v1, "file":Ljava/io/File;
    if-eqz v1, :cond_0

    .line 542
    .end local v1    # "file":Ljava/io/File;
    :goto_0
    return-object v1

    .line 541
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/Android/data/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/cache/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 542
    .local v0, "cacheDir":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getUsableSpace(Ljava/io/File;)J
    .locals 6
    .param p0, "path"    # Ljava/io/File;

    .prologue
    .line 553
    invoke-static {}, Lcom/pwrd/android/volley/plus/OsVersionUtils;->hasGingerbread()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 554
    invoke-virtual {p0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v2

    .line 557
    :goto_0
    return-wide v2

    .line 556
    :cond_0
    new-instance v0, Landroid/os/StatFs;

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 557
    .local v0, "stats":Landroid/os/StatFs;
    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockSize()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {v0}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v1

    int-to-long v4, v1

    mul-long/2addr v2, v4

    goto :goto_0
.end method

.method public static hashKeyForDisk(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 382
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 383
    const/4 v0, 0x0

    .line 392
    :goto_0
    return-object v0

    .line 386
    :cond_0
    :try_start_0
    const-string v3, "MD5"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 387
    .local v2, "mDigest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/security/MessageDigest;->update([B)V

    .line 388
    invoke-virtual {v2}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/plus/ImageCache;->bytesToHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .local v0, "cacheKey":Ljava/lang/String;
    goto :goto_0

    .line 389
    .end local v0    # "cacheKey":Ljava/lang/String;
    .end local v2    # "mDigest":Ljava/security/MessageDigest;
    :catch_0
    move-exception v1

    .line 390
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "cacheKey":Ljava/lang/String;
    goto :goto_0
.end method

.method private init(Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;)V
    .locals 2
    .param p1, "cacheParams"    # Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    .line 84
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget-boolean v0, v0, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memoryCacheEnabled:Z

    if-eqz v0, :cond_0

    .line 88
    new-instance v0, Lcom/pwrd/android/volley/plus/ImageCache$1;

    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget v1, v1, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->memCacheSize:I

    invoke-direct {v0, p0, v1}, Lcom/pwrd/android/volley/plus/ImageCache$1;-><init>(Lcom/pwrd/android/volley/plus/ImageCache;I)V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    .line 102
    :cond_0
    iget-boolean v0, p1, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->initDiskCacheOnCreate:Z

    if-eqz v0, :cond_1

    .line 104
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->initDiskCache()V

    .line 106
    :cond_1
    return-void
.end method

.method private initDiskCache()V
    .locals 8

    .prologue
    .line 116
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v3

    .line 117
    :try_start_0
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 118
    :cond_0
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget-object v0, v2, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 119
    .local v0, "diskCacheDir":Ljava/io/File;
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget-boolean v2, v2, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheEnabled:Z

    if-eqz v2, :cond_2

    if-eqz v0, :cond_2

    .line 120
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1

    .line 121
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 123
    :cond_1
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/ImageCache;->getUsableSpace(Ljava/io/File;)J

    move-result-wide v4

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget v2, v2, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    int-to-long v6, v2

    cmp-long v2, v4, v6

    if-lez v2, :cond_2

    .line 126
    const/4 v2, 0x1

    const/4 v4, 0x1

    :try_start_1
    iget-object v5, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget v5, v5, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheSize:I

    int-to-long v6, v5

    .line 125
    invoke-static {v0, v2, v4, v6, v7}, Lcom/pwrd/android/volley/plus/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/pwrd/android/volley/plus/DiskLruCache;

    move-result-object v2

    iput-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 137
    .end local v0    # "diskCacheDir":Ljava/io/File;
    :cond_2
    :goto_0
    const/4 v2, 0x0

    :try_start_2
    iput-boolean v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheStarting:Z

    .line 138
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->notifyAll()V

    .line 116
    monitor-exit v3

    .line 140
    return-void

    .line 130
    .restart local v0    # "diskCacheDir":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 131
    .local v1, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    const/4 v4, 0x0

    iput-object v4, v2, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->diskCacheDir:Ljava/io/File;

    .line 132
    const-string v2, "ImageCache"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "initDiskCache - "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 116
    .end local v0    # "diskCacheDir":Ljava/io/File;
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method public static isExternalStorageRemovable()Z
    .locals 1

    .prologue
    .line 523
    invoke-static {}, Lcom/pwrd/android/volley/plus/OsVersionUtils;->hasGingerbread()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Landroid/os/Environment;->isExternalStorageRemovable()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static isSdCardOK()Z
    .locals 2

    .prologue
    .line 483
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 484
    const-string v1, "mounted"

    .line 483
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isStorageWritable()Z
    .locals 2

    .prologue
    .line 374
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    const-string v1, "mounted"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public addBitmapToCache(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;)V
    .locals 8
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "format"    # Landroid/graphics/Bitmap$CompressFormat;

    .prologue
    .line 149
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 193
    :cond_0
    :goto_0
    return-void

    .line 154
    :cond_1
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v4, p1}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-nez v4, :cond_2

    .line 155
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v4, p1, p2}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    :cond_2
    iget-object v5, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v5

    .line 160
    :try_start_0
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v4, :cond_4

    .line 162
    const/4 v2, 0x0

    .line 164
    .local v2, "out":Ljava/io/OutputStream;
    :try_start_1
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v4, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->get(Ljava/lang/String;)Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;

    move-result-object v3

    .line 165
    .local v3, "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    if-nez v3, :cond_5

    .line 166
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v4, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->edit(Ljava/lang/String;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v1

    .line 167
    .local v1, "editor":Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    if-eqz v1, :cond_3

    .line 168
    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v2

    .line 170
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mCacheParams:Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;

    iget v4, v4, Lcom/pwrd/android/volley/plus/ImageCache$ImageCacheParams;->compressQuality:I

    .line 169
    invoke-virtual {p2, p3, v4, v2}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 171
    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->commit()V

    .line 173
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 184
    .end local v1    # "editor":Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    :cond_3
    :goto_1
    :try_start_2
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->flush()V

    .line 185
    if-eqz v2, :cond_4

    .line 186
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 158
    .end local v2    # "out":Ljava/io/OutputStream;
    .end local v3    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :cond_4
    :goto_2
    :try_start_3
    monitor-exit v5

    goto :goto_0

    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v4

    .line 176
    .restart local v2    # "out":Ljava/io/OutputStream;
    .restart local v3    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :cond_5
    const/4 v4, 0x0

    :try_start_4
    invoke-virtual {v3, v4}, Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_1

    .line 178
    .end local v3    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/io/IOException;
    :try_start_5
    const-string v4, "ImageCache"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "addBitmapToCache - "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 184
    :try_start_6
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->flush()V

    .line 185
    if-eqz v2, :cond_4

    .line 186
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2

    .line 188
    :catch_1
    move-exception v4

    goto :goto_2

    .line 180
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 181
    .local v0, "e":Ljava/lang/Exception;
    :try_start_7
    const-string v4, "ImageCache"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "addBitmapToCache - "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 184
    :try_start_8
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->flush()V

    .line 185
    if-eqz v2, :cond_4

    .line 186
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_2

    .line 188
    :catch_3
    move-exception v4

    goto :goto_2

    .line 182
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v4

    .line 184
    :try_start_9
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->flush()V

    .line 185
    if-eqz v2, :cond_6

    .line 186
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_5
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 190
    :cond_6
    :goto_3
    :try_start_a
    throw v4
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 188
    .restart local v3    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :catch_4
    move-exception v4

    goto :goto_2

    .end local v3    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :catch_5
    move-exception v6

    goto :goto_3
.end method

.method public addBitmapToMemCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 197
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p1}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    :cond_0
    return-void
.end method

.method public clearCache()V
    .locals 5

    .prologue
    .line 269
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    if-eqz v1, :cond_0

    .line 270
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v1}, Landroid/support/v4/util/LruCache;->evictAll()V

    .line 276
    :cond_0
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 277
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheStarting:Z

    .line 278
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->isClosed()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_1

    .line 280
    :try_start_1
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->delete()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 287
    :goto_0
    const/4 v1, 0x0

    :try_start_2
    iput-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    .line 288
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/ImageCache;->initDiskCache()V

    .line 276
    :cond_1
    monitor-exit v2

    .line 291
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "clearCache - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 276
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public close()V
    .locals 5

    .prologue
    .line 317
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 318
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 320
    :try_start_1
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    .line 321
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->close()V

    .line 322
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 317
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 332
    return-void

    .line 327
    :catch_0
    move-exception v0

    .line 328
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "close - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 317
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public flush()V
    .locals 5

    .prologue
    .line 298
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 299
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 301
    :try_start_1
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->flush()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 298
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 310
    return-void

    .line 305
    :catch_0
    move-exception v0

    .line 306
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "ImageCache"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "flush - "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 298
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public getBitmapFromDiskCache(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .locals 7
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 229
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v4

    .line 230
    :goto_0
    :try_start_0
    iget-boolean v3, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheStarting:Z

    if-nez v3, :cond_1

    .line 236
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v3, :cond_2

    .line 237
    const/4 v1, 0x0

    .line 239
    .local v1, "inputStream":Ljava/io/InputStream;
    :try_start_1
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {v3, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->get(Ljava/lang/String;)Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;

    move-result-object v2

    .line 240
    .local v2, "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    if-eqz v2, :cond_4

    .line 244
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v1

    .line 245
    if-eqz v1, :cond_4

    .line 246
    invoke-static {v1, p2, p3}, Lcom/pwrd/android/volley/plus/ImageReSizer;->decodeSampledBitmapFromStream(Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 253
    if-eqz v1, :cond_0

    .line 254
    :try_start_2
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 246
    :cond_0
    :goto_1
    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 260
    .end local v1    # "inputStream":Ljava/io/InputStream;
    .end local v2    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :goto_2
    return-object v3

    .line 232
    :cond_1
    :try_start_4
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->wait()V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0

    .line 233
    :catch_0
    move-exception v3

    goto :goto_0

    .line 249
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    :catch_1
    move-exception v0

    .line 250
    .local v0, "e":Ljava/io/IOException;
    :try_start_5
    const-string v3, "ImageCache"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "getBitmapFromDiskCache - "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 253
    if-eqz v1, :cond_2

    .line 254
    :try_start_6
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 258
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "inputStream":Ljava/io/InputStream;
    :cond_2
    :goto_3
    :try_start_7
    monitor-exit v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 260
    const/4 v3, 0x0

    goto :goto_2

    .line 251
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    :catchall_0
    move-exception v3

    .line 253
    if-eqz v1, :cond_3

    .line 254
    :try_start_8
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 258
    :cond_3
    :goto_4
    :try_start_9
    throw v3

    .line 229
    .end local v1    # "inputStream":Ljava/io/InputStream;
    :catchall_1
    move-exception v3

    monitor-exit v4
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    throw v3

    .line 253
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    .restart local v2    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    :cond_4
    if-eqz v1, :cond_2

    .line 254
    :try_start_a
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    goto :goto_3

    .line 256
    :catch_2
    move-exception v3

    goto :goto_3

    :catch_3
    move-exception v5

    goto :goto_1

    .end local v2    # "snapshot":Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    .restart local v0    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v3

    goto :goto_3

    .end local v0    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v5

    goto :goto_4
.end method

.method public getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 209
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    const-string v1, ""

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 210
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mMemoryCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/plus/ImageCache;->getCacheKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 211
    .local v0, "memBitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 218
    .end local v0    # "memBitmap":Landroid/graphics/Bitmap;
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCacheKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 401
    invoke-static {p1}, Lcom/pwrd/android/volley/plus/ImageCache;->hashKeyForDisk(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setBrittle(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 362
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 363
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 365
    :try_start_1
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/plus/ImageCache;->getCacheKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->setBrittle(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 362
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 371
    return-void

    .line 366
    :catch_0
    move-exception v0

    .line 367
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 362
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public setPersistent(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 343
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskCacheLock:Ljava/lang/Object;

    monitor-enter v2

    .line 344
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 346
    :try_start_1
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/ImageCache;->mDiskLruCache:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/plus/ImageCache;->getCacheKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->setPersistent(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 343
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v2

    .line 352
    return-void

    .line 347
    :catch_0
    move-exception v0

    .line 348
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 343
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method
