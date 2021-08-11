.class Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;
.super Ljava/lang/Object;
.source "RetryAndTrafficControlInterceptor.java"

# interfaces
.implements Lokhttp3/Interceptor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ModerateTrafficStrategy;,
        Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$AggressiveTrafficStrategy;,
        Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;,
        Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;
    }
.end annotation


# static fields
.field private static final BACKOFF_MULTIPLIER:I = 0x2

.field private static final MAX_NORMAL_RETRY_WAIT_TIME:I = 0x7d0

.field private static final MAX_STREAMING_RETRY_WAIT_TIME:I = 0x2710

.field private static final MIN_NORMAL_ATTEMPTS:I = 0x3

.field private static final MIN_STREAMING_ATTEMPTS:I = 0x4

.field private static final MIN_STREAMING_TASK_FAIL_MILLIS_TOOK:I = 0xea60

.field private static final RETRY_DELAY_BASE:I = 0x3e8


# instance fields
.field private downloadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

.field private uploadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;


# direct methods
.method constructor <init>()V
    .locals 3

    .prologue
    .line 204
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    new-instance v0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ModerateTrafficStrategy;

    const-string v1, "UploadStrategy-"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ModerateTrafficStrategy;-><init>(Ljava/lang/String;I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->uploadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

    .line 54
    new-instance v0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$AggressiveTrafficStrategy;

    const-string v1, "DownloadStrategy-"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$AggressiveTrafficStrategy;-><init>(Ljava/lang/String;I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->downloadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

    .line 205
    return-void
.end method

.method private executeTaskOnce(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;Lcom/tencent/qcloud/core/http/HttpTask;)Lokhttp3/Response;
    .locals 3
    .param p1, "chain"    # Lokhttp3/Interceptor$Chain;
    .param p2, "request"    # Lokhttp3/Request;
    .param p3, "task"    # Lcom/tencent/qcloud/core/http/HttpTask;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 299
    :try_start_0
    invoke-virtual {p3}, Lcom/tencent/qcloud/core/http/HttpTask;->isCanceled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 300
    new-instance v1, Ljava/io/IOException;

    const-string v2, "CANCELED"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Ljava/net/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 304
    :catch_0
    move-exception v0

    .line 306
    .local v0, "exception":Ljava/net/ProtocolException;
    invoke-virtual {v0}, Ljava/net/ProtocolException;->getMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Ljava/net/ProtocolException;->getMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "HTTP 204 had non-zero Content-Length: "

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 308
    new-instance v1, Lokhttp3/Response$Builder;

    invoke-direct {v1}, Lokhttp3/Response$Builder;-><init>()V

    .line 309
    invoke-virtual {v1, p2}, Lokhttp3/Response$Builder;->request(Lokhttp3/Request;)Lokhttp3/Response$Builder;

    move-result-object v1

    .line 310
    invoke-virtual {v0}, Ljava/net/ProtocolException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lokhttp3/Response$Builder;->message(Ljava/lang/String;)Lokhttp3/Response$Builder;

    move-result-object v1

    const/16 v2, 0xcc

    .line 311
    invoke-virtual {v1, v2}, Lokhttp3/Response$Builder;->code(I)Lokhttp3/Response$Builder;

    move-result-object v1

    sget-object v2, Lokhttp3/Protocol;->HTTP_1_1:Lokhttp3/Protocol;

    .line 312
    invoke-virtual {v1, v2}, Lokhttp3/Response$Builder;->protocol(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;

    move-result-object v1

    .line 313
    invoke-virtual {v1}, Lokhttp3/Response$Builder;->build()Lokhttp3/Response;

    move-result-object v1

    .end local v0    # "exception":Ljava/net/ProtocolException;
    :goto_0
    return-object v1

    .line 302
    :cond_0
    :try_start_1
    invoke-virtual {p0, p1, p2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->processSingleRequest(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;)Lokhttp3/Response;
    :try_end_1
    .catch Ljava/net/ProtocolException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    goto :goto_0

    .line 315
    .restart local v0    # "exception":Ljava/net/ProtocolException;
    :cond_1
    invoke-virtual {v0}, Ljava/net/ProtocolException;->printStackTrace()V

    .line 316
    throw v0

    .line 319
    .end local v0    # "exception":Ljava/net/ProtocolException;
    :catch_1
    move-exception v0

    .line 320
    .local v0, "exception":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 321
    throw v0
.end method

.method private getRetryDelay(Lcom/tencent/qcloud/core/http/HttpTask;Ljava/io/IOException;I)J
    .locals 6
    .param p1, "task"    # Lcom/tencent/qcloud/core/http/HttpTask;
    .param p2, "e"    # Ljava/io/IOException;
    .param p3, "attempts"    # I

    .prologue
    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    .line 342
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpTask;->isStreamingTask()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 343
    instance-of v2, p2, Ljava/net/ConnectException;

    if-nez v2, :cond_0

    instance-of v2, p2, Ljava/net/UnknownHostException;

    if-eqz v2, :cond_2

    .line 345
    :cond_0
    const-wide/16 v0, 0x2710

    .line 356
    :cond_1
    :goto_0
    return-wide v0

    .line 347
    :cond_2
    int-to-double v2, p3

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    double-to-int v2, v2

    mul-int/lit16 v2, v2, 0x3e8

    const/16 v3, 0x2710

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    int-to-long v0, v2

    .line 349
    .local v0, "delay":J
    instance-of v2, p2, Ljava/net/SocketTimeoutException;

    if-eqz v2, :cond_1

    .line 351
    const-wide/16 v2, 0x1388

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    goto :goto_0

    .line 356
    .end local v0    # "delay":J
    :cond_3
    add-int/lit8 v2, p3, -0x1

    int-to-double v2, v2

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    double-to-int v2, v2

    mul-int/lit16 v2, v2, 0x3e8

    const/16 v3, 0x7d0

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    int-to-long v0, v2

    goto :goto_0
.end method

.method private getSuitableStrategy(Lcom/tencent/qcloud/core/http/HttpTask;)Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;
    .locals 1
    .param p1, "task"    # Lcom/tencent/qcloud/core/http/HttpTask;

    .prologue
    .line 294
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpTask;->isDownloadTask()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->downloadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpTask;->isUploadTask()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->uploadTrafficStrategy:Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isRecoverable(Ljava/io/IOException;)Z
    .locals 2
    .param p1, "e"    # Ljava/io/IOException;

    .prologue
    const/4 v0, 0x0

    .line 362
    instance-of v1, p1, Ljava/net/ProtocolException;

    if-eqz v1, :cond_1

    .line 389
    :cond_0
    :goto_0
    return v0

    .line 368
    :cond_1
    instance-of v1, p1, Ljava/io/InterruptedIOException;

    if-eqz v1, :cond_2

    .line 369
    instance-of v0, p1, Ljava/net/SocketTimeoutException;

    goto :goto_0

    .line 374
    :cond_2
    instance-of v1, p1, Ljavax/net/ssl/SSLHandshakeException;

    if-eqz v1, :cond_3

    .line 377
    invoke-virtual {p1}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Ljava/security/cert/CertificateException;

    if-nez v1, :cond_0

    .line 381
    :cond_3
    instance-of v1, p1, Ljavax/net/ssl/SSLPeerUnverifiedException;

    if-nez v1, :cond_0

    .line 389
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isUserCancelled(Ljava/io/IOException;)Z
    .locals 2
    .param p1, "exception"    # Ljava/io/IOException;

    .prologue
    .line 326
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "canceled"

    .line 327
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private shouldRetry(Lcom/tencent/qcloud/core/http/HttpTask;IJ)Z
    .locals 5
    .param p1, "task"    # Lcom/tencent/qcloud/core/http/HttpTask;
    .param p2, "attempts"    # I
    .param p3, "millsTook"    # J

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 335
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpTask;->isStreamingTask()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 336
    const/4 v2, 0x4

    if-lt p2, v2, :cond_0

    const-wide/32 v2, 0xea60

    cmp-long v2, p3, v2

    if-gez v2, :cond_1

    :cond_0
    move v0, v1

    .line 338
    :cond_1
    :goto_0
    return v0

    :cond_2
    const/4 v2, 0x3

    if-ge p2, v2, :cond_3

    :goto_1
    move v0, v1

    goto :goto_0

    :cond_3
    move v1, v0

    goto :goto_1
.end method


# virtual methods
.method public intercept(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;
    .locals 4
    .param p1, "chain"    # Lokhttp3/Interceptor$Chain;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 209
    invoke-interface {p1}, Lokhttp3/Interceptor$Chain;->request()Lokhttp3/Request;

    move-result-object v0

    .line 210
    .local v0, "request":Lokhttp3/Request;
    invoke-static {}, Lcom/tencent/qcloud/core/task/TaskManager;->getInstance()Lcom/tencent/qcloud/core/task/TaskManager;

    move-result-object v3

    invoke-virtual {v0}, Lokhttp3/Request;->tag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Lcom/tencent/qcloud/core/task/TaskManager;->get(Ljava/lang/String;)Lcom/tencent/qcloud/core/task/Task;

    move-result-object v1

    check-cast v1, Lcom/tencent/qcloud/core/http/HttpTask;

    .line 211
    .local v1, "task":Lcom/tencent/qcloud/core/http/HttpTask;
    invoke-virtual {p0, p1, v0, v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->processRequest(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;Lcom/tencent/qcloud/core/http/HttpTask;)Lokhttp3/Response;

    move-result-object v2

    return-object v2
.end method

.method processRequest(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;Lcom/tencent/qcloud/core/http/HttpTask;)Lokhttp3/Response;
    .locals 28
    .param p1, "chain"    # Lokhttp3/Interceptor$Chain;
    .param p2, "request"    # Lokhttp3/Request;
    .param p3, "task"    # Lcom/tencent/qcloud/core/http/HttpTask;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 215
    const/4 v13, 0x0

    .line 216
    .local v13, "response":Lokhttp3/Response;
    const/4 v5, 0x0

    .line 218
    .local v5, "e":Ljava/io/IOException;
    if-eqz p3, :cond_0

    invoke-virtual/range {p3 .. p3}, Lcom/tencent/qcloud/core/http/HttpTask;->isCanceled()Z

    move-result v21

    if-eqz v21, :cond_1

    .line 219
    :cond_0
    new-instance v21, Ljava/io/IOException;

    const-string v24, "CANCELED"

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v21

    .line 222
    :cond_1
    const/4 v4, 0x0

    .line 223
    .local v4, "attempts":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    .line 224
    .local v18, "startTime":J
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->getSuitableStrategy(Lcom/tencent/qcloud/core/http/HttpTask;)Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;

    move-result-object v20

    .line 226
    .local v20, "strategy":Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;
    :cond_2
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v24

    sub-long v24, v24, v18

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-wide/from16 v2, v24

    invoke-direct {v0, v1, v4, v2, v3}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->shouldRetry(Lcom/tencent/qcloud/core/http/HttpTask;IJ)Z

    move-result v21

    if-eqz v21, :cond_6

    .line 227
    const-wide/16 v22, 0x0

    .line 228
    .local v22, "waitTook":J
    if-eqz v20, :cond_3

    .line 229
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 230
    .local v6, "before":J
    invoke-virtual/range {v20 .. v20}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->waitForPermit()V

    .line 231
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v24

    sub-long v22, v24, v6

    .line 234
    .end local v6    # "before":J
    :cond_3
    if-lez v4, :cond_4

    .line 235
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1, v5, v4}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->getRetryDelay(Lcom/tencent/qcloud/core/http/HttpTask;Ljava/io/IOException;I)J

    move-result-wide v8

    .line 237
    .local v8, "delay":J
    const-wide/16 v24, 0x1f4

    add-long v24, v24, v22

    cmp-long v21, v8, v24

    if-lez v21, :cond_4

    .line 238
    :try_start_0
    sget-object v21, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    sub-long v24, v8, v22

    move-object/from16 v0, v21

    move-wide/from16 v1, v24

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_3

    .line 243
    .end local v8    # "delay":J
    :cond_4
    :goto_1
    const-string v21, "QCloudHttp"

    const-string v24, "%s start to execute, attempts is %d"

    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object p2, v25, v26

    const/16 v26, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v27

    aput-object v27, v25, v26

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 245
    add-int/lit8 v4, v4, 0x1

    .line 247
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v16

    .line 249
    .local v16, "startNs":J
    :try_start_1
    invoke-direct/range {p0 .. p3}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->executeTaskOnce(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;Lcom/tencent/qcloud/core/http/HttpTask;)Lokhttp3/Response;

    move-result-object v13

    .line 250
    invoke-virtual/range {p3 .. p3}, Lcom/tencent/qcloud/core/http/HttpTask;->isDownloadTask()Z

    move-result v21

    if-eqz v21, :cond_5

    .line 251
    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Lcom/tencent/qcloud/core/http/HttpTask;->convertResponse(Lokhttp3/Response;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_1 .. :try_end_1} :catch_2

    .line 253
    :cond_5
    const/4 v5, 0x0

    .line 261
    :goto_2
    sget-object v21, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v24

    sub-long v24, v24, v16

    move-object/from16 v0, v21

    move-wide/from16 v1, v24

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v14

    .line 263
    .local v14, "networkMillsTook":J
    if-nez v5, :cond_9

    .line 264
    if-eqz v20, :cond_6

    .line 265
    move-object/from16 v0, p3

    invoke-virtual {v0, v14, v15}, Lcom/tencent/qcloud/core/http/HttpTask;->getAverageStreamingSpeed(J)D

    move-result-wide v24

    move-object/from16 v0, v20

    move-object/from16 v1, p2

    move-wide/from16 v2, v24

    invoke-virtual {v0, v1, v2, v3}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->reportSpeed(Lokhttp3/Request;D)V

    .line 286
    .end local v14    # "networkMillsTook":J
    .end local v16    # "startNs":J
    .end local v22    # "waitTook":J
    :cond_6
    :goto_3
    if-eqz v5, :cond_c

    .line 287
    const-string v21, "QCloudHttp"

    const-string v24, "%s ends with error, %s"

    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object p2, v25, v26

    const/16 v26, 0x1

    aput-object v5, v25, v26

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 288
    throw v5

    .line 254
    .restart local v16    # "startNs":J
    .restart local v22    # "waitTook":J
    :catch_0
    move-exception v12

    .line 255
    .local v12, "exception":Ljava/io/IOException;
    move-object v5, v12

    .line 260
    goto :goto_2

    .line 256
    .end local v12    # "exception":Ljava/io/IOException;
    :catch_1
    move-exception v10

    .line 257
    .local v10, "e1":Lcom/tencent/qcloud/core/common/QCloudClientException;
    invoke-virtual {v10}, Lcom/tencent/qcloud/core/common/QCloudClientException;->getCause()Ljava/lang/Throwable;

    move-result-object v21

    move-object/from16 v0, v21

    instance-of v0, v0, Ljava/io/IOException;

    move/from16 v21, v0

    if-eqz v21, :cond_7

    invoke-virtual {v10}, Lcom/tencent/qcloud/core/common/QCloudClientException;->getCause()Ljava/lang/Throwable;

    move-result-object v21

    check-cast v21, Ljava/io/IOException;

    move-object/from16 v5, v21

    .line 260
    :goto_4
    goto :goto_2

    .line 257
    :cond_7
    new-instance v5, Ljava/io/IOException;

    .end local v5    # "e":Ljava/io/IOException;
    invoke-direct {v5, v10}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    goto :goto_4

    .line 258
    .end local v10    # "e1":Lcom/tencent/qcloud/core/common/QCloudClientException;
    .restart local v5    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v11

    .line 259
    .local v11, "e2":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    invoke-virtual {v11}, Lcom/tencent/qcloud/core/common/QCloudServiceException;->getCause()Ljava/lang/Throwable;

    move-result-object v21

    move-object/from16 v0, v21

    instance-of v0, v0, Ljava/io/IOException;

    move/from16 v21, v0

    if-eqz v21, :cond_8

    invoke-virtual {v11}, Lcom/tencent/qcloud/core/common/QCloudServiceException;->getCause()Ljava/lang/Throwable;

    move-result-object v21

    check-cast v21, Ljava/io/IOException;

    move-object/from16 v5, v21

    :goto_5
    goto :goto_2

    :cond_8
    new-instance v5, Ljava/io/IOException;

    .end local v5    # "e":Ljava/io/IOException;
    invoke-direct {v5, v11}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    goto :goto_5

    .line 268
    .end local v11    # "e2":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    .restart local v5    # "e":Ljava/io/IOException;
    .restart local v14    # "networkMillsTook":J
    :cond_9
    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->isUserCancelled(Ljava/io/IOException;)Z

    move-result v21

    if-nez v21, :cond_b

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;->isRecoverable(Ljava/io/IOException;)Z

    move-result v21

    if-eqz v21, :cond_b

    .line 269
    const-string v21, "QCloudHttp"

    const-string v24, "%s failed for %s"

    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object p2, v25, v26

    const/16 v26, 0x1

    aput-object v5, v25, v26

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 270
    if-eqz v20, :cond_2

    .line 271
    instance-of v0, v5, Ljava/net/SocketTimeoutException;

    move/from16 v21, v0

    if-eqz v21, :cond_a

    .line 272
    move-object/from16 v0, v20

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->reportTimeOut(Lokhttp3/Request;)V

    goto/16 :goto_0

    .line 274
    :cond_a
    move-object/from16 v0, v20

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v5}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->reportException(Lokhttp3/Request;Ljava/io/IOException;)V

    goto/16 :goto_0

    .line 278
    :cond_b
    const-string v21, "QCloudHttp"

    const-string v24, "%s failed for %s, and is not recoverable"

    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object p2, v25, v26

    const/16 v26, 0x1

    aput-object v5, v25, v26

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 279
    if-eqz v20, :cond_6

    .line 280
    move-object/from16 v0, v20

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v5}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;->reportException(Lokhttp3/Request;Ljava/io/IOException;)V

    goto/16 :goto_3

    .line 290
    .end local v14    # "networkMillsTook":J
    .end local v16    # "startNs":J
    .end local v22    # "waitTook":J
    :cond_c
    return-object v13

    .line 240
    .restart local v8    # "delay":J
    .restart local v22    # "waitTook":J
    :catch_3
    move-exception v21

    goto/16 :goto_1
.end method

.method processSingleRequest(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;)Lokhttp3/Response;
    .locals 1
    .param p1, "chain"    # Lokhttp3/Interceptor$Chain;
    .param p2, "request"    # Lokhttp3/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 331
    invoke-interface {p1, p2}, Lokhttp3/Interceptor$Chain;->proceed(Lokhttp3/Request;)Lokhttp3/Response;

    move-result-object v0

    return-object v0
.end method
