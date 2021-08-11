.class abstract Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;
.super Ljava/lang/Object;
.source "RetryAndTrafficControlInterceptor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "TrafficStrategy"
.end annotation


# static fields
.field static final MIN_FAST_SPEED:I = 0x12c

.field static final MIN_TIMEOUT_COUNT:I = 0x2


# instance fields
.field private concurrent:Ljava/util/concurrent/atomic/AtomicInteger;

.field private controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

.field private current:I

.field private historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final historySpeed:[I

.field private final maxConcurrent:I

.field private final name:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;II)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "concurrent"    # I
    .param p3, "maxConcurrent"    # I

    .prologue
    const/4 v3, 0x0

    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    const/4 v0, 0x5

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    .line 74
    iput v3, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->current:I

    .line 84
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 87
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->name:Ljava/lang/String;

    .line 88
    iput p3, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->maxConcurrent:I

    .line 89
    new-instance v0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    const/4 v1, 0x1

    invoke-direct {v0, p2, v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;-><init>(IZ)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    .line 90
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->concurrent:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 91
    const-string v0, "QCloudHttp"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " init concurrent is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 92
    return-void
.end method

.method private declared-synchronized adjustConcurrentAndRelease(I)V
    .locals 5
    .param p1, "expect"    # I

    .prologue
    .line 166
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->concurrent:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    .line 167
    .local v0, "current":I
    sub-int v1, p1, v0

    .line 168
    .local v1, "delta":I
    if-nez v1, :cond_0

    .line 169
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    :goto_0
    monitor-exit p0

    return-void

    .line 171
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->concurrent:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 172
    if-lez v1, :cond_1

    .line 173
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release(I)V

    .line 174
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->clearAverageSpeed()V

    .line 181
    :goto_1
    const-string v2, "QCloudHttp"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " adjust concurrent to "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 166
    .end local v0    # "current":I
    .end local v1    # "delta":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 176
    .restart local v0    # "current":I
    .restart local v1    # "delta":I
    :cond_1
    mul-int/lit8 v1, v1, -0x1

    .line 177
    :try_start_2
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v2, v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->reducePermits(I)V

    .line 178
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V

    .line 179
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->clearAverageSpeed()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method private clearAverageSpeed()V
    .locals 4

    .prologue
    .line 158
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    monitor-enter v2

    .line 159
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    :try_start_0
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 160
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    const/4 v3, 0x0

    aput v3, v1, v0

    .line 159
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 162
    :cond_0
    monitor-exit v2

    .line 163
    return-void

    .line 162
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private updateAverageSpeed(D)I
    .locals 11
    .param p1, "averageSpeed"    # D

    .prologue
    const/4 v3, 0x0

    .line 140
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    monitor-enter v5

    .line 141
    :try_start_0
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    iget v6, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->current:I

    invoke-static {p1, p2}, Ljava/lang/Math;->floor(D)D

    move-result-wide v8

    double-to-int v7, v8

    aput v7, v4, v6

    .line 142
    iget v4, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->current:I

    add-int/lit8 v4, v4, 0x1

    iget-object v6, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    array-length v6, v6

    rem-int/2addr v4, v6

    iput v4, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->current:I

    .line 144
    const/4 v2, 0x0

    .line 145
    .local v2, "sum":I
    const/4 v0, 0x0

    .line 146
    .local v0, "notEnoughData":Z
    iget-object v6, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    array-length v7, v6

    move v4, v3

    :goto_0
    if-ge v4, v7, :cond_0

    aget v1, v6, v4

    .line 147
    .local v1, "speed":I
    if-nez v1, :cond_1

    .line 148
    const/4 v0, 0x1

    .line 153
    .end local v1    # "speed":I
    :cond_0
    if-eqz v0, :cond_2

    :goto_1
    monitor-exit v5

    return v3

    .line 151
    .restart local v1    # "speed":I
    :cond_1
    add-int/2addr v2, v1

    .line 146
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 153
    .end local v1    # "speed":I
    :cond_2
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historySpeed:[I

    array-length v3, v3

    div-int v3, v2, v3

    goto :goto_1

    .line 154
    .end local v0    # "notEnoughData":Z
    .end local v2    # "sum":I
    :catchall_0
    move-exception v3

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method


# virtual methods
.method reportException(Lokhttp3/Request;Ljava/io/IOException;)V
    .locals 1
    .param p1, "request"    # Lokhttp3/Request;
    .param p2, "exception"    # Ljava/io/IOException;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V

    .line 96
    return-void
.end method

.method declared-synchronized reportSpeed(Lokhttp3/Request;D)V
    .locals 8
    .param p1, "request"    # Lokhttp3/Request;
    .param p2, "averageSpeed"    # D

    .prologue
    const/4 v7, 0x1

    .line 112
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 113
    const-wide/16 v2, 0x0

    cmpl-double v2, p2, v2

    if-lez v2, :cond_2

    .line 114
    const-string v2, "QCloudHttp"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " %s streaming speed is %1.3f KBps"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 115
    invoke-direct {p0, p2, p3}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->updateAverageSpeed(D)I

    move-result v0

    .line 118
    .local v0, "average":I
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->concurrent:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    .line 119
    .local v1, "concurrent":I
    add-int/lit8 v2, v1, 0x1

    mul-int/lit16 v2, v2, 0x12c

    if-le v0, v2, :cond_0

    iget v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->maxConcurrent:I

    if-ge v1, v2, :cond_0

    .line 120
    add-int/lit8 v2, v1, 0x1

    invoke-direct {p0, v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->adjustConcurrentAndRelease(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    .end local v0    # "average":I
    .end local v1    # "concurrent":I
    :goto_0
    monitor-exit p0

    return-void

    .line 121
    .restart local v0    # "average":I
    .restart local v1    # "concurrent":I
    :cond_0
    if-lez v0, :cond_1

    add-int/lit8 v2, v1, -0x1

    mul-int/lit16 v2, v2, 0x12c

    if-ge v0, v2, :cond_1

    if-le v1, v7, :cond_1

    .line 122
    add-int/lit8 v2, v1, -0x1

    :try_start_1
    invoke-direct {p0, v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->adjustConcurrentAndRelease(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 112
    .end local v0    # "average":I
    .end local v1    # "concurrent":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 124
    .restart local v0    # "average":I
    .restart local v1    # "concurrent":I
    :cond_1
    :try_start_2
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V

    goto :goto_0

    .line 127
    .end local v0    # "average":I
    .end local v1    # "concurrent":I
    :cond_2
    iget-object v2, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method reportTimeOut(Lokhttp3/Request;)V
    .locals 3
    .param p1, "request"    # Lokhttp3/Request;

    .prologue
    const/4 v2, 0x1

    .line 99
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-gez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 104
    :goto_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_1

    .line 105
    invoke-direct {p0, v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->adjustConcurrentAndRelease(I)V

    .line 109
    :goto_1
    return-void

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->historyConsecutiveTimeoutError:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    goto :goto_0

    .line 107
    :cond_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->release()V

    goto :goto_1
.end method

.method waitForPermit()V
    .locals 2

    .prologue
    .line 133
    :try_start_0
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->controller:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;

    invoke-virtual {v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;->acquire()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 137
    :goto_0
    return-void

    .line 134
    :catch_0
    move-exception v0

    .line 135
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method
