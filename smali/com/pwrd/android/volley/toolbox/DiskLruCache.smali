.class public final Lcom/pwrd/android/volley/toolbox/DiskLruCache;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;,
        Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;,
        Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;
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
            "Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;",
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
    .line 86
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    .line 87
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

    .line 263
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    iput-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    .line 138
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-direct {v0, v2, v1, v3}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    .line 146
    iput-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->nextSequenceNumber:J

    .line 245
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    .line 246
    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 247
    new-instance v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;

    invoke-direct {v0, p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    .line 264
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->directory:Ljava/io/File;

    .line 265
    iput p2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->appVersion:I

    .line 266
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    .line 267
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFileTmp:Ljava/io/File;

    .line 268
    iput p3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    .line 269
    iput-wide p4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->maxSize:J

    .line 270
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)Ljava/io/Writer;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 673
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->trimToSize()V

    return-void
.end method

.method static synthetic access$10(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)Ljava/io/File;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)Z
    .locals 1

    .prologue
    .line 594
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalRebuildRequired()Z

    move-result v0

    return v0
.end method

.method static synthetic access$3(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 401
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->rebuildJournal()V

    return-void
.end method

.method static synthetic access$4(Lcom/pwrd/android/volley/toolbox/DiskLruCache;I)V
    .locals 0

    .prologue
    .line 139
    iput p1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    return-void
.end method

.method static synthetic access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 492
    invoke-direct {p0, p1, p2, p3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

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
    .line 698
    invoke-static {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$7()Ljava/nio/charset/Charset;
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    return-object v0
.end method

.method static synthetic access$8(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 540
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->completeEdit(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;Z)V

    return-void
.end method

.method static synthetic access$9(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)I
    .locals 1

    .prologue
    .line 134
    iget v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    return v0
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 642
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    .line 643
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 645
    :cond_0
    return-void
.end method

.method public static closeQuietly(Ljava/io/Closeable;)V
    .locals 2
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 215
    if-eqz p0, :cond_0

    .line 217
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 218
    :catch_0
    move-exception v0

    .line 219
    .local v0, "rethrown":Ljava/lang/RuntimeException;
    throw v0

    .line 220
    .end local v0    # "rethrown":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private declared-synchronized completeEdit(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;Z)V
    .locals 12
    .param p1, "editor"    # Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    .param p2, "success"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 541
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    move-result-object v2

    .line 542
    .local v2, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v8

    if-eq v8, p1, :cond_0

    .line 543
    new-instance v8, Ljava/lang/IllegalStateException;

    invoke-direct {v8}, Ljava/lang/IllegalStateException;-><init>()V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 541
    .end local v2    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 547
    .restart local v2    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    :cond_0
    if-eqz p2, :cond_1

    :try_start_1
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 548
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    if-lt v3, v8, :cond_5

    .line 556
    .end local v3    # "i":I
    :cond_1
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_1
    iget v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    if-lt v3, v8, :cond_7

    .line 572
    iget v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    .line 573
    const/4 v8, 0x0

    invoke-static {v2, v8}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    .line 574
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Z

    move-result v8

    or-int/2addr v8, p2

    if-eqz v8, :cond_a

    .line 575
    const/4 v8, 0x1

    invoke-static {v2, v8}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$4(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Z)V

    .line 576
    iget-object v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "CLEAN "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0xa

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 577
    if-eqz p2, :cond_2

    .line 578
    iget-wide v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->nextSequenceNumber:J

    const-wide/16 v10, 0x1

    add-long/2addr v10, v8

    iput-wide v10, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->nextSequenceNumber:J

    invoke-static {v2, v8, v9}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$9(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;J)V

    .line 585
    :cond_2
    :goto_2
    iget-wide v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    iget-wide v10, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->maxSize:J

    cmp-long v8, v8, v10

    if-gtz v8, :cond_3

    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalRebuildRequired()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 586
    :cond_3
    iget-object v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v9, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v8, v9}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 588
    :cond_4
    monitor-exit p0

    return-void

    .line 549
    :cond_5
    :try_start_2
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_6

    .line 550
    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;->abort()V

    .line 551
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "edit didn\'t create file "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 548
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 557
    :cond_7
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v1

    .line 558
    .local v1, "dirty":Ljava/io/File;
    if-eqz p2, :cond_9

    .line 559
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_8

    .line 560
    invoke-virtual {v2, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v0

    .line 561
    .local v0, "clean":Ljava/io/File;
    invoke-virtual {v1, v0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 562
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)[J

    move-result-object v8

    aget-wide v6, v8, v3

    .line 563
    .local v6, "oldLength":J
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 564
    .local v4, "newLength":J
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)[J

    move-result-object v8

    aput-wide v4, v8, v3

    .line 565
    iget-wide v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    sub-long/2addr v8, v6

    add-long/2addr v8, v4

    iput-wide v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    .line 556
    .end local v0    # "clean":Ljava/io/File;
    .end local v4    # "newLength":J
    .end local v6    # "oldLength":J
    :cond_8
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 568
    :cond_9
    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    goto :goto_3

    .line 581
    .end local v1    # "dirty":Ljava/io/File;
    :cond_a
    iget-object v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 582
    iget-object v8, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "REMOVE "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0xa

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_2
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
    .line 151
    array-length v1, p0

    .line 152
    .local v1, "originalLength":I
    if-le p1, p2, :cond_0

    .line 153
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 155
    :cond_0
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 156
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 158
    :cond_2
    sub-int v3, p2, p1

    .line 159
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 161
    .local v0, "copyLength":I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    .line 160
    check-cast v2, [Ljava/lang/Object;

    .line 162
    .local v2, "result":[Ljava/lang/Object;
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 163
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
    .line 230
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 231
    .local v1, "files":[Ljava/io/File;
    if-nez v1, :cond_0

    .line 232
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

    .line 234
    :cond_0
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_1

    .line 242
    return-void

    .line 234
    :cond_1
    aget-object v0, v1, v2

    .line 235
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 236
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteContents(Ljava/io/File;)V

    .line 238
    :cond_2
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_3

    .line 239
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

    .line 234
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
    .line 438
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 439
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 441
    :cond_0
    return-void
.end method

.method private declared-synchronized edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
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

    .line 493
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->checkNotClosed()V

    .line 494
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 495
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 496
    .local v1, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    const-wide/16 v2, -0x1

    cmp-long v2, p2, v2

    if-eqz v2, :cond_1

    .line 497
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    cmp-long v2, v2, p2

    if-eqz v2, :cond_1

    .line 513
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 500
    :cond_1
    if-nez v1, :cond_3

    .line 501
    :try_start_1
    new-instance v1, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .end local v1    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)V

    .line 502
    .restart local v1    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 507
    :cond_2
    new-instance v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    .line 508
    .local v0, "editor":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    invoke-static {v1, v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    .line 511
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

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

    .line 512
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 493
    .end local v0    # "editor":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    .end local v1    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 503
    .restart local v1    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    :cond_3
    :try_start_2
    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
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
    .line 699
    new-instance v0, Ljava/io/InputStreamReader;

    sget-object v1, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, p0, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readFully(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private journalRebuildRequired()Z
    .locals 3

    .prologue
    .line 595
    const/16 v0, 0x7d0

    .line 596
    .local v0, "REDUNDANT_OP_COMPACT_THRESHOLD":I
    iget v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    const/16 v2, 0x7d0

    if-lt v1, v2, :cond_0

    .line 597
    iget v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->size()I

    move-result v2

    .line 596
    if-lt v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static open(Ljava/io/File;IIJ)Lcom/pwrd/android/volley/toolbox/DiskLruCache;
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
    .line 284
    const-wide/16 v2, 0x0

    cmp-long v1, p3, v2

    if-gtz v1, :cond_0

    .line 285
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "maxSize <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 287
    :cond_0
    if-gtz p2, :cond_1

    .line 288
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "valueCount <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 292
    :cond_1
    new-instance v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 293
    .local v0, "cache":Lcom/pwrd/android/volley/toolbox/DiskLruCache;
    iget-object v1, v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 295
    :try_start_0
    invoke-direct {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readJournal()V

    .line 296
    invoke-direct {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->processJournal()V

    .line 297
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    .line 298
    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 297
    iput-object v1, v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 311
    .end local v0    # "cache":Lcom/pwrd/android/volley/toolbox/DiskLruCache;
    .local v6, "cache":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 300
    .end local v6    # "cache":Ljava/lang/Object;
    .restart local v0    # "cache":Lcom/pwrd/android/volley/toolbox/DiskLruCache;
    :catch_0
    move-exception v7

    .line 303
    .local v7, "journalIsCorrupt":Ljava/io/IOException;
    invoke-virtual {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->delete()V

    .line 308
    .end local v7    # "journalIsCorrupt":Ljava/io/IOException;
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 309
    new-instance v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    .end local v0    # "cache":Lcom/pwrd/android/volley/toolbox/DiskLruCache;
    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 310
    .restart local v0    # "cache":Lcom/pwrd/android/volley/toolbox/DiskLruCache;
    invoke-direct {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->rebuildJournal()V

    move-object v6, v0

    .line 311
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
    .line 379
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 380
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 395
    return-void

    .line 381
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 382
    .local v0, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v3

    if-nez v3, :cond_2

    .line 383
    const/4 v2, 0x0

    .local v2, "t":I
    :goto_1
    iget v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_0

    .line 384
    iget-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    .line 383
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 387
    .end local v2    # "t":I
    :cond_2
    const/4 v3, 0x0

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    .line 388
    const/4 v2, 0x0

    .restart local v2    # "t":I
    :goto_2
    iget v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 392
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 389
    :cond_3
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 390
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 388
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
    .line 193
    new-instance v2, Ljava/lang/StringBuilder;

    const/16 v3, 0x50

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 195
    .local v2, "result":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 196
    .local v0, "c":I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_0

    .line 197
    new-instance v3, Ljava/io/EOFException;

    invoke-direct {v3}, Ljava/io/EOFException;-><init>()V

    throw v3

    .line 198
    :cond_0
    const/16 v3, 0xa

    if-ne v0, v3, :cond_2

    .line 204
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    .line 205
    .local v1, "length":I
    if-lez v1, :cond_1

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    const/16 v4, 0xd

    if-ne v3, v4, :cond_1

    .line 206
    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 208
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 202
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
    .line 171
    :try_start_0
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    .line 172
    .local v2, "writer":Ljava/io/StringWriter;
    const/16 v3, 0x400

    new-array v0, v3, [C

    .line 174
    .local v0, "buffer":[C
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/Reader;->read([C)I

    move-result v1

    .local v1, "count":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    .line 177
    invoke-virtual {v2}, Ljava/io/StringWriter;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 179
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 177
    return-object v3

    .line 175
    :cond_0
    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {v2, v0, v3, v1}, Ljava/io/StringWriter;->write([CII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 178
    .end local v0    # "buffer":[C
    .end local v1    # "count":I
    .end local v2    # "writer":Ljava/io/StringWriter;
    :catchall_0
    move-exception v3

    .line 179
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 180
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
    .line 315
    new-instance v2, Ljava/io/BufferedInputStream;

    new-instance v6, Ljava/io/FileInputStream;

    iget-object v7, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const/16 v7, 0x2000

    invoke-direct {v2, v6, v7}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    .line 317
    .local v2, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v3

    .line 318
    .local v3, "magic":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v5

    .line 319
    .local v5, "version":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 320
    .local v0, "appVersionString":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v4

    .line 321
    .local v4, "valueCountString":Ljava/lang/String;
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    .line 322
    .local v1, "blank":Ljava/lang/String;
    const-string v6, "libcore.io.DiskLruCache"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 323
    const-string v6, "1"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 324
    iget v6, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->appVersion:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 325
    iget v6, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 326
    const-string v6, ""

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 327
    :cond_0
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "unexpected journal header: ["

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 328
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

    .line 327
    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 338
    .end local v0    # "appVersionString":Ljava/lang/String;
    .end local v1    # "blank":Ljava/lang/String;
    .end local v3    # "magic":Ljava/lang/String;
    .end local v4    # "valueCountString":Ljava/lang/String;
    .end local v5    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v6

    .line 339
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 340
    throw v6

    .line 333
    .restart local v0    # "appVersionString":Ljava/lang/String;
    .restart local v1    # "blank":Ljava/lang/String;
    .restart local v3    # "magic":Ljava/lang/String;
    .restart local v4    # "valueCountString":Ljava/lang/String;
    .restart local v5    # "version":Ljava/lang/String;
    :cond_1
    :goto_0
    :try_start_1
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->readJournalLine(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 334
    :catch_0
    move-exception v6

    .line 339
    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 341
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
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, 0x2

    .line 344
    const-string v3, " "

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 345
    .local v2, "parts":[Ljava/lang/String;
    array-length v3, v2

    if-ge v3, v5, :cond_0

    .line 346
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

    .line 349
    :cond_0
    aget-object v1, v2, v8

    .line 350
    .local v1, "key":Ljava/lang/String;
    aget-object v3, v2, v6

    const-string v4, "REMOVE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    array-length v3, v2

    if-ne v3, v5, :cond_2

    .line 351
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 372
    :cond_1
    :goto_0
    return-void

    .line 355
    :cond_2
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 356
    .local v0, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    if-nez v0, :cond_3

    .line 357
    new-instance v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .end local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    invoke-direct {v0, p0, v1, v7}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)V

    .line 358
    .restart local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 361
    :cond_3
    aget-object v3, v2, v6

    const-string v4, "CLEAN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    array-length v3, v2

    iget v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    add-int/lit8 v4, v4, 0x2

    if-ne v3, v4, :cond_4

    .line 362
    invoke-static {v0, v8}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$4(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Z)V

    .line 363
    invoke-static {v0, v7}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    .line 364
    array-length v3, v2

    invoke-static {v2, v5, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$6(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;[Ljava/lang/String;)V

    goto :goto_0

    .line 365
    :cond_4
    aget-object v3, v2, v6

    const-string v4, "DIRTY"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    array-length v3, v2

    if-ne v3, v5, :cond_5

    .line 366
    new-instance v3, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    invoke-direct {v3, p0, v0, v7}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    invoke-static {v0, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;)V

    goto :goto_0

    .line 367
    :cond_5
    aget-object v3, v2, v6

    const-string v4, "READ"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    array-length v3, v2

    if-eq v3, v5, :cond_1

    .line 370
    :cond_6
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
    .line 402
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-eqz v2, :cond_0

    .line 403
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 406
    :cond_0
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 407
    .local v1, "writer":Ljava/io/Writer;
    const-string v2, "libcore.io.DiskLruCache"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 408
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 409
    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 410
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 411
    iget v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->appVersion:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 412
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 413
    iget v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 414
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 415
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 417
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 425
    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 426
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFileTmp:Ljava/io/File;

    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 427
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    iget-object v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    const/16 v4, 0x2000

    invoke-direct {v2, v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    iput-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 428
    monitor-exit p0

    return-void

    .line 417
    :cond_1
    :try_start_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 418
    .local v0, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 419
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 402
    .end local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .end local v1    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 421
    .restart local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .restart local v1    # "writer":Ljava/io/Writer;
    :cond_2
    :try_start_2
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "CLEAN "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private trimToSize()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 674
    :goto_0
    iget-wide v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    iget-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->maxSize:J

    cmp-long v1, v2, v4

    if-gtz v1, :cond_0

    .line 679
    return-void

    .line 676
    :cond_0
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 677
    .local v0, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->remove(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method private validateKey(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 692
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

    .line 693
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 694
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

    .line 693
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 696
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
    .line 660
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 671
    :goto_0
    monitor-exit p0

    return-void

    .line 663
    :cond_0
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

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

    .line 668
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->trimToSize()V

    .line 669
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 670
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 660
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 663
    :cond_2
    :try_start_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 664
    .local v0, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 665
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v2

    invoke-virtual {v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;->abort()V
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
    .line 687
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->close()V

    .line 688
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->directory:Ljava/io/File;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->deleteContents(Ljava/io/File;)V

    .line 689
    return-void
.end method

.method public edit(Ljava/lang/String;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 489
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->edit(Ljava/lang/String;J)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

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
    .line 651
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->checkNotClosed()V

    .line 652
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->trimToSize()V

    .line 653
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 654
    monitor-exit p0

    return-void

    .line 651
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 449
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->checkNotClosed()V

    .line 450
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 451
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 452
    .local v8, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    if-nez v8, :cond_1

    .line 481
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 456
    :cond_1
    :try_start_1
    invoke-static {v8}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 465
    iget v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    new-array v6, v2, [Ljava/io/InputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 467
    .local v6, "ins":[Ljava/io/InputStream;
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    :try_start_2
    iget v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    if-lt v9, v2, :cond_3

    .line 475
    :try_start_3
    iget v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    .line 476
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

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

    .line 477
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalRebuildRequired()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 478
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 481
    :cond_2
    new-instance v1, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;

    invoke-static {v8}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$8(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)J

    move-result-wide v4

    const/4 v7, 0x0

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v1 .. v7}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 449
    .end local v6    # "ins":[Ljava/io/InputStream;
    .end local v8    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .end local v9    # "i":I
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 468
    .restart local v6    # "ins":[Ljava/io/InputStream;
    .restart local v8    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .restart local v9    # "i":I
    :cond_3
    :try_start_4
    new-instance v2, Ljava/io/FileInputStream;

    invoke-virtual {v8, v9}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v2, v6, v9
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 467
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 470
    :catch_0
    move-exception v0

    .line 472
    .local v0, "e":Ljava/io/FileNotFoundException;
    goto :goto_0
.end method

.method public getDirectory()Ljava/io/File;
    .locals 1

    .prologue
    .line 520
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 638
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

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
    .line 528
    iget-wide v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->maxSize:J

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
    .line 607
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->checkNotClosed()V

    .line 608
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 609
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;

    .line 610
    .local v0, "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    if-eqz v3, :cond_1

    .line 611
    :cond_0
    const/4 v3, 0x0

    .line 631
    :goto_0
    monitor-exit p0

    return v3

    .line 614
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    :try_start_1
    iget v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 623
    iget v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->redundantOpCount:I

    .line 624
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalWriter:Ljava/io/Writer;

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

    .line 625
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 627
    invoke-direct {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->journalRebuildRequired()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 628
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 631
    :cond_2
    const/4 v3, 0x1

    goto :goto_0

    .line 615
    :cond_3
    invoke-virtual {v0, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v1

    .line 616
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_4

    .line 617
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

    .line 607
    .end local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 619
    .restart local v0    # "entry":Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "i":I
    :cond_4
    :try_start_2
    iget-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    sub-long/2addr v4, v6

    iput-wide v4, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J

    .line 620
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;->access$7(Lcom/pwrd/android/volley/toolbox/DiskLruCache$Entry;)[J

    move-result-object v3

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 614
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public declared-synchronized size()J
    .locals 2

    .prologue
    .line 537
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->size:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
