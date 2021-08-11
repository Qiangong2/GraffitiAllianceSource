.class Lcom/tencent/qcloud/core/http/CountingSink;
.super Lokio/ForwardingSink;
.source "CountingSink.java"


# instance fields
.field private bytesTotal:J

.field private bytesWritten:J

.field private progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

.field private recentReportBytes:J


# direct methods
.method public constructor <init>(Lokio/Sink;JLcom/tencent/qcloud/core/common/QCloudProgressListener;)V
    .locals 2
    .param p1, "delegate"    # Lokio/Sink;
    .param p2, "bytesTotal"    # J
    .param p4, "progressListener"    # Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .prologue
    const-wide/16 v0, 0x0

    .line 27
    invoke-direct {p0, p1}, Lokio/ForwardingSink;-><init>(Lokio/Sink;)V

    .line 20
    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    .line 21
    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesTotal:J

    .line 22
    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->recentReportBytes:J

    .line 28
    iput-wide p2, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesTotal:J

    .line 29
    iput-object p4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .line 30
    return-void
.end method

.method private reportProgress()V
    .locals 8

    .prologue
    .line 33
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/CountingSink;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    if-nez v3, :cond_1

    .line 43
    :cond_0
    :goto_0
    return-void

    .line 36
    :cond_1
    iget-wide v4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/CountingSink;->recentReportBytes:J

    sub-long v0, v4, v6

    .line 37
    .local v0, "delta":J
    const-wide/32 v4, 0xc800

    cmp-long v3, v0, v4

    if-gtz v3, :cond_2

    const-wide/16 v4, 0xa

    mul-long/2addr v4, v0

    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesTotal:J

    cmp-long v3, v4, v6

    if-gtz v3, :cond_2

    iget-wide v4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesTotal:J

    cmp-long v3, v4, v6

    if-nez v3, :cond_3

    :cond_2
    const/4 v2, 0x1

    .line 39
    .local v2, "enoughDelta":Z
    :goto_1
    if-eqz v2, :cond_0

    .line 40
    iget-wide v4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    iput-wide v4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->recentReportBytes:J

    .line 41
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/CountingSink;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    iget-wide v4, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesTotal:J

    invoke-interface {v3, v4, v5, v6, v7}, Lcom/tencent/qcloud/core/common/QCloudProgressListener;->onProgress(JJ)V

    goto :goto_0

    .line 37
    .end local v2    # "enoughDelta":Z
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method


# virtual methods
.method getTotalTransferred()J
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    return-wide v0
.end method

.method public write(Lokio/Buffer;J)V
    .locals 0
    .param p1, "source"    # Lokio/Buffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 56
    invoke-super {p0, p1, p2, p3}, Lokio/ForwardingSink;->write(Lokio/Buffer;J)V

    .line 58
    invoke-virtual {p0, p2, p3}, Lcom/tencent/qcloud/core/http/CountingSink;->writeBytesInternal(J)V

    .line 59
    return-void
.end method

.method writeBytesInternal(J)V
    .locals 3
    .param p1, "byteCount"    # J

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/CountingSink;->bytesWritten:J

    .line 47
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/CountingSink;->reportProgress()V

    .line 48
    return-void
.end method
