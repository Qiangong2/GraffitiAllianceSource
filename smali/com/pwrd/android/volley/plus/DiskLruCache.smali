.class public final Lcom/pwrd/android/volley/plus/DiskLruCache;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;
.implements Lcom/pwrd/android/volley/plus/PersistentCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;,
        Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;,
        Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    }
.end annotation


# static fields
.field static final ANY_SEQUENCE_NUMBER:J = -0x1L

.field private static final CLEAN:Ljava/lang/String; = "CLEAN"

.field private static final DIRTY:Ljava/lang/String; = "DIRTY"

.field private static final IO_BUFFER_SIZE:I = 0x2000

.field static final JOURNAL_FILE:Ljava/lang/String; = "journal"

.field static final JOURNAL_FILE_TMP:Ljava/lang/String; = "journal.tmp"

.field static final MAGIC:Ljava/lang/String; = "libcore.io.DiskLruCache"

.field private static final PERSISTENT:Ljava/lang/String; = "PERSISTENT"

.field private static final READ:Ljava/lang/String; = "READ"

.field private static final REMOVE:Ljava/lang/String; = "REMOVE"

.field private static final UTF_8:Ljava/nio/charset/Charset;

.field static final VERSION_1:Ljava/lang/String; = "1"


# instance fields
.field private final appVersion:I

.field private final cleanupCallable:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private final directory:Ljava/io/File;

.field private final executorService:Ljava/util/concurrent/ExecutorService;

.field private final journalFile:Ljava/io/File;

.field private final journalFileTmp:Ljava/io/File;

.field private journalWriter:Ljava/io/Writer;

.field private final lruEntries:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;",
            ">;"
        }
    .end annotation
.end field

.field private final maxSize:J

.field private nextSequenceNumber:J

.field private redundantOpCount:I

.field private size:J

.field private final valueCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 89
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lcom/pwrd/android/volley/plus/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    .line 90
    return-void
.end method

.method private constructor <init>(Ljava/io/File;IIJ)V
    .locals 8
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "appVersion"    # I
    .param p3, "valueCount"    # I
    .param p4, "maxSize"    # J

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 269
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 138
    iput-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    .line 141
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-direct {v0, v2, v1, v3}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    .line 149
    iput-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->nextSequenceNumber:J

    .line 250
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    .line 251
    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 252
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache$1;

    invoke-direct {v0, p0}, Lcom/pwrd/android/volley/plus/DiskLruCache$1;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    .line 270
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->directory:Ljava/io/File;

    .line 271
    iput p2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->appVersion:I

    .line 272
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    .line 273
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFileTmp:Ljava/io/File;

    .line 274
    iput p3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    .line 275
    iput-wide p4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->maxSize:J

    .line 276
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/plus/DiskLruCache;)Ljava/io/Writer;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/plus/DiskLruCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 727
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->trimToSize()V

    return-void
.end method

.method static synthetic access$10(Lcom/pwrd/android/volley/plus/DiskLruCache;)Ljava/io/File;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/plus/DiskLruCache;)Z
    .locals 1

    .prologue
    .line 648
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v0

    return v0
.end method

.method static synthetic access$3(Lcom/pwrd/android/volley/plus/DiskLruCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 415
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->rebuildJournal()V

    return-void
.end method

.method static synthetic access$4(Lcom/pwrd/android/volley/plus/DiskLruCache;I)V
    .locals 0

    .prologue
    .line 142
    iput p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    return-void
.end method

.method static synthetic access$5(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;J)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 541
    invoke-direct {p0, p1, p2, p3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$6(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 754
    invoke-static {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$7()Ljava/nio/charset/Charset;
    .locals 1

    .prologue
    .line 89
    sget-object v0, Lcom/pwrd/android/volley/plus/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    return-object v0
.end method

.method static synthetic access$8(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 589
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->completeEdit(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    return-void
.end method

.method static synthetic access$9(Lcom/pwrd/android/volley/plus/DiskLruCache;)I
    .locals 1

    .prologue
    .line 137
    iget v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    return v0
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 696
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    .line 697
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 699
    :cond_0
    return-void
.end method

.method public static closeQuietly(Ljava/io/Closeable;)V
    .locals 2
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 218
    if-eqz p0, :cond_0

    .line 220
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 226
    :cond_0
    :goto_0
    return-void

    .line 221
    :catch_0
    move-exception v0

    .line 222
    .local v0, "rethrown":Ljava/lang/RuntimeException;
    throw v0

    .line 223
    .end local v0    # "rethrown":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private declared-synchronized completeEdit(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V
    .locals 14
    .param p1, "editor"    # Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .param p2, "success"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 590
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    move-result-object v2

    .line 591
    .local v2, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v9

    if-eq v9, p1, :cond_0

    .line 592
    new-instance v9, Ljava/lang/IllegalStateException;

    invoke-direct {v9}, Ljava/lang/IllegalStateException;-><init>()V

    throw v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 590
    .end local v2    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    :catchall_0
    move-exception v9

    monitor-exit p0

    throw v9

    .line 596
    .restart local v2    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    :cond_0
    if-eqz p2, :cond_1

    :try_start_1
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 597
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    if-lt v3, v9, :cond_5

    .line 605
    .end local v3    # "i":I
    :cond_1
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_1
    iget v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    if-lt v3, v9, :cond_7

    .line 626
    iget v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v9, v9, 0x1

    iput v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    .line 627
    const/4 v9, 0x0

    invoke-static {v2, v9}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 628
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v9

    or-int v9, v9, p2

    if-eqz v9, :cond_c

    .line 629
    const/4 v9, 0x1

    invoke-static {v2, v9}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$4(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 630
    iget-object v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v9

    if-eqz v9, :cond_b

    const-string v9, "PERSISTENT"

    :goto_2
    invoke-virtual {v10, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 631
    if-eqz p2, :cond_2

    .line 632
    iget-wide v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->nextSequenceNumber:J

    const-wide/16 v12, 0x1

    add-long/2addr v12, v10

    iput-wide v12, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->nextSequenceNumber:J

    invoke-static {v2, v10, v11}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$11(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;J)V

    .line 639
    :cond_2
    :goto_3
    iget-wide v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    iget-wide v12, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->maxSize:J

    cmp-long v9, v10, v12

    if-gtz v9, :cond_3

    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 640
    :cond_3
    iget-object v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v9, v10}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 642
    :cond_4
    monitor-exit p0

    return-void

    .line 598
    :cond_5
    :try_start_2
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v9

    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v9

    if-nez v9, :cond_6

    .line 599
    invoke-virtual {p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->abort()V

    .line 600
    new-instance v9, Ljava/lang/IllegalStateException;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "edit didn\'t create file "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 597
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 606
    :cond_7
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v1

    .line 607
    .local v1, "dirty":Ljava/io/File;
    if-eqz p2, :cond_a

    .line 608
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_9

    .line 609
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v0

    .line 610
    .local v0, "clean":Ljava/io/File;
    invoke-virtual {v1, v0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v8

    .line 611
    .local v8, "renameResult":Z
    if-nez v8, :cond_8

    .line 612
    const-string v9, "ImageCache"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "failed to rename image file to: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 614
    :cond_8
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v9

    if-nez v9, :cond_9

    .line 615
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J

    move-result-object v9

    aget-wide v6, v9, v3

    .line 616
    .local v6, "oldLength":J
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 617
    .local v4, "newLength":J
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J

    move-result-object v9

    aput-wide v4, v9, v3

    .line 618
    iget-wide v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    sub-long/2addr v10, v6

    add-long/2addr v10, v4

    iput-wide v10, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    .line 605
    .end local v0    # "clean":Ljava/io/File;
    .end local v4    # "newLength":J
    .end local v6    # "oldLength":J
    .end local v8    # "renameResult":Z
    :cond_9
    :goto_4
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 622
    :cond_a
    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    goto :goto_4

    .line 630
    .end local v1    # "dirty":Ljava/io/File;
    :cond_b
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v11, "CLEAN "

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v11, 0xa

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_2

    .line 635
    :cond_c
    iget-object v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 636
    iget-object v9, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "REMOVE "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const/16 v11, 0xa

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_3
.end method

.method private static copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;
    .locals 5
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;II)[TT;"
        }
    .end annotation

    .prologue
    .line 154
    array-length v1, p0

    .line 155
    .local v1, "originalLength":I
    if-le p1, p2, :cond_0

    .line 156
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 158
    :cond_0
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 159
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 161
    :cond_2
    sub-int v3, p2, p1

    .line 162
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 164
    .local v0, "copyLength":I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    .line 163
    check-cast v2, [Ljava/lang/Object;

    .line 165
    .local v2, "result":[Ljava/lang/Object;
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 166
    return-object v2
.end method

.method public static deleteContents(Ljava/io/File;)V
    .locals 5
    .param p0, "dir"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 233
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 234
    .local v1, "files":[Ljava/io/File;
    if-nez v1, :cond_0

    .line 235
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "not a directory: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 237
    :cond_0
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_1

    .line 245
    return-void

    .line 237
    :cond_1
    aget-object v0, v1, v2

    .line 238
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 239
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteContents(Ljava/io/File;)V

    .line 241
    :cond_2
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_3

    .line 242
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "failed to delete file: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 237
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private static deleteIfExists(Ljava/io/File;)V
    .locals 1
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 452
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 453
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 455
    :cond_0
    return-void
.end method

.method private declared-synchronized edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .locals 6
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "expectedSequenceNumber"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 542
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 543
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 544
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 545
    .local v1, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    const-wide/16 v2, -0x1

    cmp-long v2, p2, v2

    if-eqz v2, :cond_1

    .line 546
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$10(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    cmp-long v2, v2, p2

    if-eqz v2, :cond_1

    .line 562
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 549
    :cond_1
    if-nez v1, :cond_3

    .line 550
    :try_start_1
    new-instance v1, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .end local v1    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)V

    .line 551
    .restart local v1    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 556
    :cond_2
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 557
    .local v0, "editor":Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    invoke-static {v1, v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 560
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 561
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 542
    .end local v0    # "editor":Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .end local v1    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 552
    .restart local v1    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    :cond_3
    :try_start_2
    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    if-eqz v2, :cond_2

    goto :goto_0
.end method

.method private static inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 2
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 755
    new-instance v0, Ljava/io/InputStreamReader;

    sget-object v1, Lcom/pwrd/android/volley/plus/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, p0, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readFully(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private journalRebuildRequired()Z
    .locals 3

    .prologue
    .line 649
    const/16 v0, 0x7d0

    .line 650
    .local v0, "REDUNDANT_OP_COMPACT_THRESHOLD":I
    iget v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    const/16 v2, 0x7d0

    if-lt v1, v2, :cond_0

    .line 651
    iget v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->size()I

    move-result v2

    .line 650
    if-lt v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static open(Ljava/io/File;IIJ)Lcom/pwrd/android/volley/plus/DiskLruCache;
    .locals 9
    .param p0, "directory"    # Ljava/io/File;
    .param p1, "appVersion"    # I
    .param p2, "valueCount"    # I
    .param p3, "maxSize"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 290
    const-wide/16 v2, 0x0

    cmp-long v1, p3, v2

    if-gtz v1, :cond_0

    .line 291
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "maxSize <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 293
    :cond_0
    if-gtz p2, :cond_1

    .line 294
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "valueCount <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 298
    :cond_1
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/plus/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 299
    .local v0, "cache":Lcom/pwrd/android/volley/plus/DiskLruCache;
    iget-object v1, v0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 301
    :try_start_0
    invoke-direct {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readJournal()V

    .line 302
    invoke-direct {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->processJournal()V

    .line 303
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, v0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    .line 304
    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 303
    iput-object v1, v0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 317
    .end local v0    # "cache":Lcom/pwrd/android/volley/plus/DiskLruCache;
    .local v6, "cache":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 306
    .end local v6    # "cache":Ljava/lang/Object;
    .restart local v0    # "cache":Lcom/pwrd/android/volley/plus/DiskLruCache;
    :catch_0
    move-exception v7

    .line 309
    .local v7, "journalIsCorrupt":Ljava/io/IOException;
    invoke-virtual {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->delete()V

    .line 314
    .end local v7    # "journalIsCorrupt":Ljava/io/IOException;
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 315
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache;

    .end local v0    # "cache":Lcom/pwrd/android/volley/plus/DiskLruCache;
    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/plus/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 316
    .restart local v0    # "cache":Lcom/pwrd/android/volley/plus/DiskLruCache;
    invoke-direct {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->rebuildJournal()V

    move-object v6, v0

    .line 317
    .restart local v6    # "cache":Ljava/lang/Object;
    goto :goto_0
.end method

.method private processJournal()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 391
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-static {v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 392
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 409
    return-void

    .line 393
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 394
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v3

    if-nez v3, :cond_2

    .line 395
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 396
    const/4 v2, 0x0

    .local v2, "t":I
    :goto_1
    iget v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_0

    .line 397
    iget-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    .line 396
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 401
    .end local v2    # "t":I
    :cond_2
    const/4 v3, 0x0

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 402
    const/4 v2, 0x0

    .restart local v2    # "t":I
    :goto_2
    iget v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 406
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 403
    :cond_3
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 404
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 402
    add-int/lit8 v2, v2, 0x1

    goto :goto_2
.end method

.method public static readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 196
    new-instance v2, Ljava/lang/StringBuilder;

    const/16 v3, 0x50

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 198
    .local v2, "result":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 199
    .local v0, "c":I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_0

    .line 200
    new-instance v3, Ljava/io/EOFException;

    invoke-direct {v3}, Ljava/io/EOFException;-><init>()V

    throw v3

    .line 201
    :cond_0
    const/16 v3, 0xa

    if-ne v0, v3, :cond_2

    .line 207
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    .line 208
    .local v1, "length":I
    if-lez v1, :cond_1

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    const/16 v4, 0xd

    if-ne v3, v4, :cond_1

    .line 209
    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 211
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 205
    .end local v1    # "length":I
    :cond_2
    int-to-char v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public static readFully(Ljava/io/Reader;)Ljava/lang/String;
    .locals 4
    .param p0, "reader"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 174
    :try_start_0
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    .line 175
    .local v2, "writer":Ljava/io/StringWriter;
    const/16 v3, 0x400

    new-array v0, v3, [C

    .line 177
    .local v0, "buffer":[C
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/Reader;->read([C)I

    move-result v1

    .local v1, "count":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    .line 180
    invoke-virtual {v2}, Ljava/io/StringWriter;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 182
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 180
    return-object v3

    .line 178
    :cond_0
    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {v2, v0, v3, v1}, Ljava/io/StringWriter;->write([CII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 181
    .end local v0    # "buffer":[C
    .end local v1    # "count":I
    .end local v2    # "writer":Ljava/io/StringWriter;
    :catchall_0
    move-exception v3

    .line 182
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 183
    throw v3
.end method

.method private readJournal()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 321
    new-instance v2, Ljava/io/BufferedInputStream;

    new-instance v6, Ljava/io/FileInputStream;

    iget-object v7, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const/16 v7, 0x2000

    invoke-direct {v2, v6, v7}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    .line 323
    .local v2, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v3

    .line 324
    .local v3, "magic":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v5

    .line 325
    .local v5, "version":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 326
    .local v0, "appVersionString":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v4

    .line 327
    .local v4, "valueCountString":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    .line 328
    .local v1, "blank":Ljava/lang/String;
    const-string v6, "libcore.io.DiskLruCache"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 329
    const-string v6, "1"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 330
    iget v6, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->appVersion:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 331
    iget v6, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 332
    const-string v6, ""

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 333
    :cond_0
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "unexpected journal header: ["

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 334
    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 333
    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 344
    .end local v0    # "appVersionString":Ljava/lang/String;
    .end local v1    # "blank":Ljava/lang/String;
    .end local v3    # "magic":Ljava/lang/String;
    .end local v4    # "valueCountString":Ljava/lang/String;
    .end local v5    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v6

    .line 345
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 346
    throw v6

    .line 339
    .restart local v0    # "appVersionString":Ljava/lang/String;
    .restart local v1    # "blank":Ljava/lang/String;
    .restart local v3    # "magic":Ljava/lang/String;
    .restart local v4    # "valueCountString":Ljava/lang/String;
    .restart local v5    # "version":Ljava/lang/String;
    :cond_1
    :goto_0
    :try_start_1
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/pwrd/android/volley/plus/DiskLruCache;->readJournalLine(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 340
    :catch_0
    move-exception v6

    .line 345
    invoke-static {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 347
    return-void
.end method

.method private readJournalLine(Ljava/lang/String;)V
    .locals 9
    .param p1, "line"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    const/4 v6, 0x2

    const/4 v5, 0x0

    .line 350
    const-string v3, " "

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 351
    .local v2, "parts":[Ljava/lang/String;
    array-length v3, v2

    if-ge v3, v6, :cond_0

    .line 352
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 355
    :cond_0
    aget-object v1, v2, v7

    .line 356
    .local v1, "key":Ljava/lang/String;
    aget-object v3, v2, v5

    const-string v4, "REMOVE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    array-length v3, v2

    if-ne v3, v6, :cond_2

    .line 357
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 384
    :cond_1
    :goto_0
    return-void

    .line 361
    :cond_2
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 362
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    if-nez v0, :cond_3

    .line 363
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .end local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    invoke-direct {v0, p0, v1, v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)V

    .line 364
    .restart local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 367
    :cond_3
    aget-object v3, v2, v5

    const-string v4, "CLEAN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    array-length v3, v2

    iget v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    add-int/lit8 v4, v4, 0x2

    if-ne v3, v4, :cond_4

    .line 368
    invoke-static {v0, v7}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$4(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 369
    invoke-static {v0, v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 370
    invoke-static {v0, v5}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$6(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 371
    array-length v3, v2

    invoke-static {v2, v6, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;[Ljava/lang/String;)V

    goto :goto_0

    .line 372
    :cond_4
    aget-object v3, v2, v5

    const-string v4, "DIRTY"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    array-length v3, v2

    if-ne v3, v6, :cond_5

    .line 373
    new-instance v3, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    invoke-direct {v3, p0, v0, v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    goto :goto_0

    .line 374
    :cond_5
    aget-object v3, v2, v5

    const-string v4, "READ"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    array-length v3, v2

    if-eq v3, v6, :cond_1

    .line 376
    :cond_6
    aget-object v3, v2, v5

    const-string v4, "PERSISTENT"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    array-length v3, v2

    iget v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    add-int/lit8 v4, v4, 0x2

    if-ne v3, v4, :cond_7

    .line 377
    invoke-static {v0, v7}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$4(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 378
    invoke-static {v0, v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V

    .line 379
    invoke-static {v0, v7}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$6(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 380
    array-length v3, v2

    invoke-static {v2, v6, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;[Ljava/lang/String;)V

    goto/16 :goto_0

    .line 382
    :cond_7
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private declared-synchronized rebuildJournal()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 416
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-eqz v2, :cond_0

    .line 417
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 420
    :cond_0
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 421
    .local v1, "writer":Ljava/io/Writer;
    const-string v2, "libcore.io.DiskLruCache"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 422
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 423
    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 424
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 425
    iget v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->appVersion:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 426
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 427
    iget v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 428
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 429
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 431
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 439
    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 440
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFileTmp:Ljava/io/File;

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 441
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    iget-object v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    const/16 v4, 0x2000

    invoke-direct {v2, v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    iput-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 442
    monitor-exit p0

    return-void

    .line 431
    :cond_1
    :try_start_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 432
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 433
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v4, 0xa

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 416
    .end local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .end local v1    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 435
    .restart local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .restart local v1    # "writer":Ljava/io/Writer;
    :cond_2
    :try_start_2
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "PERSISTENT"

    :goto_1
    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "CLEAN "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v4, 0xa

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    goto :goto_1
.end method

.method private trimToSize()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 728
    :goto_0
    iget-wide v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    iget-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->maxSize:J

    cmp-long v1, v2, v4

    if-gtz v1, :cond_0

    .line 735
    return-void

    .line 730
    :cond_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 732
    .local v0, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->remove(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method private validateKey(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 748
    if-eqz p1, :cond_1

    const-string v0, " "

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "\n"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "\r"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 749
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 750
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "keys must not contain spaces or newlines: \""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 749
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 752
    :cond_1
    return-void
.end method


# virtual methods
.method public declared-synchronized close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 714
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 725
    :goto_0
    monitor-exit p0

    return-void

    .line 717
    :cond_0
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 722
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->trimToSize()V

    .line 723
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 724
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 714
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 717
    :cond_2
    :try_start_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 718
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 719
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v2

    invoke-virtual {v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->abort()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public delete()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 743
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->close()V

    .line 744
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->directory:Ljava/io/File;

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->deleteContents(Ljava/io/File;)V

    .line 745
    return-void
.end method

.method public edit(Ljava/lang/String;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 538
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 705
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 706
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->trimToSize()V

    .line 707
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 708
    monitor-exit p0

    return-void

    .line 705
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;)Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 463
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 464
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 465
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 466
    .local v8, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    if-nez v8, :cond_1

    .line 495
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 470
    :cond_1
    :try_start_1
    invoke-static {v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 479
    iget v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    new-array v6, v2, [Ljava/io/InputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 481
    .local v6, "ins":[Ljava/io/InputStream;
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    :try_start_2
    iget v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    if-lt v9, v2, :cond_3

    .line 489
    :try_start_3
    iget v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    .line 490
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "READ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 491
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 492
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 495
    :cond_2
    new-instance v1, Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;

    invoke-static {v8}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$10(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)J

    move-result-wide v4

    const/4 v7, 0x0

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v1 .. v7}, Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/pwrd/android/volley/plus/DiskLruCache$Snapshot;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 463
    .end local v6    # "ins":[Ljava/io/InputStream;
    .end local v8    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .end local v9    # "i":I
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 482
    .restart local v6    # "ins":[Ljava/io/InputStream;
    .restart local v8    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .restart local v9    # "i":I
    :cond_3
    :try_start_4
    new-instance v2, Ljava/io/FileInputStream;

    invoke-virtual {v8, v9}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v2, v6, v9
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 481
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 484
    :catch_0
    move-exception v0

    .line 486
    .local v0, "e":Ljava/io/FileNotFoundException;
    goto :goto_0
.end method

.method public getDirectory()Ljava/io/File;
    .locals 1

    .prologue
    .line 569
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 692
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public maxSize()J
    .locals 2

    .prologue
    .line 577
    iget-wide v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->maxSize:J

    return-wide v0
.end method

.method public declared-synchronized remove(Ljava/lang/String;)Z
    .locals 8
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 661
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 662
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 663
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 664
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v3

    if-nez v3, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-eqz v3, :cond_1

    .line 665
    :cond_0
    const/4 v3, 0x0

    .line 685
    :goto_0
    monitor-exit p0

    return v3

    .line 668
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    :try_start_1
    iget v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 677
    iget v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    .line 678
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "REMOVE "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0xa

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 679
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 681
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 682
    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 685
    :cond_2
    const/4 v3, 0x1

    goto :goto_0

    .line 669
    :cond_3
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v1

    .line 670
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_4

    .line 671
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "failed to delete "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 661
    .end local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 673
    .restart local v0    # "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "i":I
    :cond_4
    :try_start_2
    iget-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    sub-long/2addr v4, v6

    iput-wide v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J

    .line 674
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J

    move-result-object v3

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 668
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public setBrittle(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 518
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 519
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 520
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 521
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 522
    iget v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    .line 523
    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$6(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 524
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "CLEAN "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 525
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->flush()V

    .line 526
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 527
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 531
    :cond_0
    return-void
.end method

.method public setPersistent(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 500
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->checkNotClosed()V

    .line 501
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 502
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 503
    .local v0, "entry":Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 504
    iget v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->redundantOpCount:I

    .line 505
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$6(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V

    .line 506
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "PERSISTENT "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 507
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->flush()V

    .line 508
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->journalRebuildRequired()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 509
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 514
    :cond_0
    return-void
.end method

.method public declared-synchronized size()J
    .locals 2

    .prologue
    .line 586
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache;->size:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
