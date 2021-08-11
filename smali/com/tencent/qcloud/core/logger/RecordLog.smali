.class Lcom/tencent/qcloud/core/logger/RecordLog;
.super Ljava/lang/Object;
.source "RecordLog.java"


# static fields
.field private static final BUFFER_SIZE:J = 0x8000L

.field public static final LOG_DIR:Ljava/lang/String; = "QCloudLogs"

.field private static final LOG_FLUSH_DURATION:J = 0x2710L

.field private static final MAX_FILE_COUNT:I = 0x1e

.field private static final MAX_FILE_SIZE:I = 0x8000

.field private static final MSG_DELETE_FILE:I = 0x2

.field private static final MSG_FLUSH_ALL:I = 0x0

.field private static final MSG_FLUSH_CONTENT:I = 0x1

.field private static final instance:[B

.field private static final object:[B

.field private static recordLog:Lcom/tencent/qcloud/core/logger/RecordLog;


# instance fields
.field private bufferRecord:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/logger/Record;",
            ">;"
        }
    .end annotation
.end field

.field private fileFilter:Ljava/io/FileFilter;

.field private flag:Ljava/lang/String;

.field private handler:Landroid/os/Handler;

.field private logRootDir:Ljava/lang/String;

.field private volatile mBufferSize:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 61
    new-array v0, v1, [B

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->object:[B

    .line 62
    new-array v0, v1, [B

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->instance:[B

    .line 63
    const/4 v0, 0x0

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->recordLog:Lcom/tencent/qcloud/core/logger/RecordLog;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "flag"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object v3, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    .line 37
    iput-object v3, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->logRootDir:Ljava/lang/String;

    .line 40
    new-instance v2, Lcom/tencent/qcloud/core/logger/RecordLog$1;

    invoke-direct {v2, p0}, Lcom/tencent/qcloud/core/logger/RecordLog$1;-><init>(Lcom/tencent/qcloud/core/logger/RecordLog;)V

    iput-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->fileFilter:Ljava/io/FileFilter;

    .line 56
    iput-object v3, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    .line 58
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->bufferRecord:Ljava/util/List;

    .line 59
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J

    .line 66
    iput-object p2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    .line 67
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "QCloudLogs"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->logRootDir:Ljava/lang/String;

    .line 68
    new-instance v0, Landroid/os/HandlerThread;

    const-string v2, "log_handlerThread"

    const/4 v3, 0x1

    invoke-direct {v0, v2, v3}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 69
    .local v0, "handlerThread":Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 70
    new-instance v2, Lcom/tencent/qcloud/core/logger/RecordLog$2;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/tencent/qcloud/core/logger/RecordLog$2;-><init>(Lcom/tencent/qcloud/core/logger/RecordLog;Landroid/os/Looper;)V

    iput-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    .line 86
    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    invoke-virtual {v2}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .line 87
    .local v1, "message":Landroid/os/Message;
    const/4 v2, 0x0

    iput v2, v1, Landroid/os/Message;->what:I

    .line 88
    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 89
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/qcloud/core/logger/RecordLog;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/logger/RecordLog;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/qcloud/core/logger/RecordLog;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flag"    # Ljava/lang/String;

    .prologue
    .line 92
    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLog;->instance:[B

    monitor-enter v1

    .line 93
    :try_start_0
    sget-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->recordLog:Lcom/tencent/qcloud/core/logger/RecordLog;

    if-nez v0, :cond_0

    .line 94
    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-direct {v0, p0, p1}, Lcom/tencent/qcloud/core/logger/RecordLog;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->recordLog:Lcom/tencent/qcloud/core/logger/RecordLog;

    .line 96
    :cond_0
    sget-object v0, Lcom/tencent/qcloud/core/logger/RecordLog;->recordLog:Lcom/tencent/qcloud/core/logger/RecordLog;

    monitor-exit v1

    return-object v0

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public declared-synchronized appendRecord(Ljava/lang/String;Lcom/tencent/qcloud/core/logger/RecordLevel;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "level"    # Lcom/tencent/qcloud/core/logger/RecordLevel;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 203
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/tencent/qcloud/core/logger/Record;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/tencent/qcloud/core/logger/Record;-><init>(Ljava/lang/String;Lcom/tencent/qcloud/core/logger/RecordLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 204
    .local v0, "r":Lcom/tencent/qcloud/core/logger/Record;
    iget-object v1, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->bufferRecord:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    iget-wide v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/logger/Record;->getLength()J

    move-result-wide v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J

    .line 207
    iget-object v1, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 208
    iget-object v1, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->handler:Landroid/os/Handler;

    const/4 v2, 0x1

    const-wide/16 v4, 0x1f4

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 209
    monitor-exit p0

    return-void

    .line 203
    .end local v0    # "r":Lcom/tencent/qcloud/core/logger/Record;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method declared-synchronized flush()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 212
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 216
    :goto_0
    monitor-exit p0

    return-void

    .line 213
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->bufferRecord:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/logger/RecordLog;->write(Ljava/util/List;)V

    .line 214
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->bufferRecord:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 215
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 212
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method getIndexFromFile(Ljava/io/File;)I
    .locals 4
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 163
    :try_start_0
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    .line 164
    .local v1, "filename":Ljava/lang/String;
    const/16 v3, 0x2e

    invoke-virtual {v1, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 165
    .local v2, "point":I
    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 166
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 169
    .end local v1    # "filename":Ljava/lang/String;
    .end local v2    # "point":I
    :goto_0
    return v3

    .line 167
    :catch_0
    move-exception v0

    .line 168
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 169
    const/4 v3, -0x1

    goto :goto_0
.end method

.method getLogFile(J)Ljava/io/File;
    .locals 13
    .param p1, "times"    # J

    .prologue
    .line 128
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v8, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->logRootDir:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p0, p1, p2}, Lcom/tencent/qcloud/core/logger/RecordLog;->getLongDate(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 130
    .local v0, "dirName":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 131
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_1

    .line 133
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 134
    new-instance v5, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "1."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ".log"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v0, v7}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    :cond_0
    :goto_0
    return-object v5

    .line 136
    :cond_1
    iget-object v7, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->fileFilter:Ljava/io/FileFilter;

    invoke-virtual {v1, v7}, Ljava/io/File;->listFiles(Ljava/io/FileFilter;)[Ljava/io/File;

    move-result-object v3

    .line 137
    .local v3, "fileslist":[Ljava/io/File;
    if-eqz v3, :cond_2

    array-length v7, v3

    if-nez v7, :cond_3

    .line 138
    :cond_2
    new-instance v5, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "1."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ".log"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v0, v7}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 141
    :cond_3
    new-instance v7, Lcom/tencent/qcloud/core/logger/RecordLog$3;

    invoke-direct {v7, p0}, Lcom/tencent/qcloud/core/logger/RecordLog$3;-><init>(Lcom/tencent/qcloud/core/logger/RecordLog;)V

    invoke-static {v3, v7}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    .line 147
    array-length v7, v3

    add-int/lit8 v7, v7, -0x1

    aget-object v5, v3, v7

    .line 148
    .local v5, "last":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v8

    const-wide/32 v10, 0x8000

    cmp-long v7, v8, v10

    if-lez v7, :cond_4

    .line 149
    invoke-virtual {p0, v5}, Lcom/tencent/qcloud/core/logger/RecordLog;->getIndexFromFile(Ljava/io/File;)I

    move-result v7

    add-int/lit8 v6, v7, 0x1

    .line 150
    .local v6, "newIndex":I
    new-instance v5, Ljava/io/File;

    .end local v5    # "last":Ljava/io/File;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->flag:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ".log"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v0, v7}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    .end local v6    # "newIndex":I
    .restart local v5    # "last":Ljava/io/File;
    :cond_4
    array-length v7, v3

    add-int/lit8 v2, v7, 0x1

    .line 153
    .local v2, "filecounts":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    add-int/lit8 v7, v2, -0x1e

    if-ge v4, v7, :cond_0

    .line 155
    aget-object v7, v3, v4

    invoke-virtual {v7}, Ljava/io/File;->delete()Z

    .line 153
    add-int/lit8 v4, v4, 0x1

    goto :goto_1
.end method

.method getLogFileDir()Ljava/io/File;
    .locals 4

    .prologue
    .line 116
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->logRootDir:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/logger/RecordLog;->getTodayDate()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 117
    .local v0, "dir":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 118
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 120
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 122
    :cond_0
    return-object v1
.end method

.method getLongDate(J)Ljava/lang/String;
    .locals 3
    .param p1, "times"    # J

    .prologue
    .line 109
    const-string v1, "yyyy-MM-dd"

    .line 110
    .local v1, "simple_date_formate":Ljava/lang/String;
    new-instance v0, Ljava/text/SimpleDateFormat;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 111
    .local v0, "simpleDateFormat":Ljava/text/SimpleDateFormat;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method getTodayDate()Ljava/lang/String;
    .locals 4

    .prologue
    .line 102
    const-string v2, "yyyy-MM-dd"

    .line 103
    .local v2, "simple_date_formate":Ljava/lang/String;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 104
    .local v0, "date":Ljava/util/Date;
    new-instance v1, Ljava/text/SimpleDateFormat;

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 105
    .local v1, "simpleDateFormat":Ljava/text/SimpleDateFormat;
    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method declared-synchronized input()V
    .locals 4

    .prologue
    .line 219
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog;->mBufferSize:J

    const-wide/32 v2, 0x8000

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 220
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/logger/RecordLog;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 222
    :cond_0
    monitor-exit p0

    return-void

    .line 219
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method write(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/logger/Record;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 174
    .local p1, "listInfo":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/logger/Record;>;"
    sget-object v6, Lcom/tencent/qcloud/core/logger/RecordLog;->object:[B

    monitor-enter v6

    .line 175
    if-nez p1, :cond_0

    :try_start_0
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 199
    :goto_0
    return-void

    .line 176
    :cond_0
    const/4 v2, 0x0

    .line 179
    .local v2, "fos":Ljava/io/FileOutputStream;
    :try_start_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-virtual {p0, v8, v9}, Lcom/tencent/qcloud/core/logger/RecordLog;->getLogFile(J)Ljava/io/File;

    move-result-object v1

    .line 180
    .local v1, "file":Ljava/io/File;
    new-instance v3, Ljava/io/FileOutputStream;

    const/4 v5, 0x1

    invoke-direct {v3, v1, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 181
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .local v3, "fos":Ljava/io/FileOutputStream;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    :try_start_2
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_1

    .line 182
    invoke-interface {p1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/tencent/qcloud/core/logger/Record;

    invoke-virtual {v5}, Lcom/tencent/qcloud/core/logger/Record;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v7, "UTF-8"

    invoke-virtual {v5, v7}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/io/FileOutputStream;->write([B)V

    .line 181
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 184
    :cond_1
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_7
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 190
    if-eqz v3, :cond_4

    .line 192
    :try_start_3
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-object v2, v3

    .line 198
    .end local v1    # "file":Ljava/io/File;
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .end local v4    # "i":I
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    :cond_2
    :goto_2
    :try_start_4
    monitor-exit v6

    goto :goto_0

    .end local v2    # "fos":Ljava/io/FileOutputStream;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v5

    .line 193
    .restart local v1    # "file":Ljava/io/File;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v4    # "i":I
    :catch_0
    move-exception v0

    .line 194
    .local v0, "e":Ljava/io/IOException;
    :try_start_5
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-object v2, v3

    .line 195
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    goto :goto_2

    .line 185
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "file":Ljava/io/File;
    .end local v4    # "i":I
    :catch_1
    move-exception v0

    .line 186
    .local v0, "e":Ljava/io/FileNotFoundException;
    :goto_3
    :try_start_6
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 190
    if-eqz v2, :cond_2

    .line 192
    :try_start_7
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_2

    .line 193
    :catch_2
    move-exception v0

    .line 194
    .local v0, "e":Ljava/io/IOException;
    :try_start_8
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_2

    .line 187
    .end local v0    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v0

    .line 188
    .restart local v0    # "e":Ljava/io/IOException;
    :goto_4
    :try_start_9
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 190
    if-eqz v2, :cond_2

    .line 192
    :try_start_a
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_4
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto :goto_2

    .line 193
    :catch_4
    move-exception v0

    .line 194
    :try_start_b
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    goto :goto_2

    .line 190
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v5

    :goto_5
    if-eqz v2, :cond_3

    .line 192
    :try_start_c
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_5
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 195
    :cond_3
    :goto_6
    :try_start_d
    throw v5

    .line 193
    :catch_5
    move-exception v0

    .line 194
    .restart local v0    # "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    goto :goto_6

    .line 190
    .end local v0    # "e":Ljava/io/IOException;
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v4    # "i":I
    :catchall_2
    move-exception v5

    move-object v2, v3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    goto :goto_5

    .line 187
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    :catch_6
    move-exception v0

    move-object v2, v3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    goto :goto_4

    .line 185
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    :catch_7
    move-exception v0

    move-object v2, v3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    goto :goto_3

    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    :cond_4
    move-object v2, v3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    goto :goto_2
.end method
