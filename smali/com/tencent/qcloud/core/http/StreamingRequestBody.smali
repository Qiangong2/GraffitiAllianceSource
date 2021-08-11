.class Lcom/tencent/qcloud/core/http/StreamingRequestBody;
.super Lokhttp3/RequestBody;
.source "StreamingRequestBody.java"

# interfaces
.implements Lcom/tencent/qcloud/core/http/ProgressBody;


# instance fields
.field private bytes:[B

.field private contentType:Ljava/lang/String;

.field private countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

.field private file:Ljava/io/File;

.field private length:J

.field private offset:J

.field private progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

.field private stream:Ljava/io/InputStream;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 45
    invoke-direct {p0}, Lokhttp3/RequestBody;-><init>()V

    .line 32
    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    .line 33
    iput-wide v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    .line 46
    return-void
.end method

.method static bytes([BLjava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    .locals 4
    .param p0, "bytes"    # [B
    .param p1, "contentType"    # Ljava/lang/String;
    .param p2, "offset"    # J
    .param p4, "length"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 68
    new-instance v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;-><init>()V

    .line 69
    .local v0, "requestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    iput-object p0, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->bytes:[B

    .line 70
    iput-object p1, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentType:Ljava/lang/String;

    .line 71
    cmp-long v1, p2, v2

    if-gez v1, :cond_0

    move-wide p2, v2

    .end local p2    # "offset":J
    :cond_0
    iput-wide p2, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    .line 72
    const-wide/16 v2, 0x1

    cmp-long v1, p4, v2

    if-gez v1, :cond_1

    const-wide p4, 0x7fffffffffffffffL

    .end local p4    # "length":J
    :cond_1
    iput-wide p4, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    .line 74
    return-object v0
.end method

.method static file(Ljava/io/File;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    .locals 6
    .param p0, "file"    # Ljava/io/File;
    .param p1, "contentType"    # Ljava/lang/String;

    .prologue
    .line 54
    const-wide/16 v2, 0x0

    const-wide v4, 0x7fffffffffffffffL

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file(Ljava/io/File;Ljava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    move-result-object v0

    return-object v0
.end method

.method static file(Ljava/io/File;Ljava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    .locals 4
    .param p0, "file"    # Ljava/io/File;
    .param p1, "contentType"    # Ljava/lang/String;
    .param p2, "offset"    # J
    .param p4, "length"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 58
    new-instance v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;-><init>()V

    .line 59
    .local v0, "requestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    iput-object p0, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    .line 60
    iput-object p1, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentType:Ljava/lang/String;

    .line 61
    cmp-long v1, p2, v2

    if-gez v1, :cond_0

    move-wide p2, v2

    .end local p2    # "offset":J
    :cond_0
    iput-wide p2, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    .line 62
    const-wide/16 v2, 0x1

    cmp-long v1, p4, v2

    if-gez v1, :cond_1

    const-wide p4, 0x7fffffffffffffffL

    .end local p4    # "length":J
    :cond_1
    iput-wide p4, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    .line 64
    return-object v0
.end method

.method private getStream()Ljava/io/InputStream;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 110
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->bytes:[B

    if-eqz v4, :cond_0

    .line 111
    new-instance v4, Ljava/io/ByteArrayInputStream;

    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->bytes:[B

    invoke-direct {v4, v5}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 129
    :goto_0
    return-object v4

    .line 112
    :cond_0
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    if-eqz v4, :cond_2

    .line 113
    const/4 v2, 0x0

    .line 115
    .local v2, "fos":Ljava/io/FileOutputStream;
    :try_start_0
    new-instance v3, Ljava/io/FileOutputStream;

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    invoke-direct {v3, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 116
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .local v3, "fos":Ljava/io/FileOutputStream;
    const/16 v4, 0x2000

    :try_start_1
    new-array v0, v4, [B

    .line 118
    .local v0, "buffer":[B
    :goto_1
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    invoke-virtual {v4, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "bytesRead":I
    const/4 v4, -0x1

    if-eq v1, v4, :cond_1

    .line 119
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 124
    .end local v0    # "buffer":[B
    .end local v1    # "bytesRead":I
    :catchall_0
    move-exception v4

    move-object v2, v3

    .end local v3    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    :goto_2
    invoke-static {v2}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 125
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    invoke-static {v5}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 126
    iput-object v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    throw v4

    .line 121
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v0    # "buffer":[B
    .restart local v1    # "bytesRead":I
    .restart local v3    # "fos":Ljava/io/FileOutputStream;
    :cond_1
    :try_start_2
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V

    .line 122
    new-instance v4, Ljava/io/FileInputStream;

    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 124
    invoke-static {v3}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 125
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    invoke-static {v5}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 126
    iput-object v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    goto :goto_0

    .line 129
    .end local v0    # "buffer":[B
    .end local v1    # "bytesRead":I
    .end local v3    # "fos":Ljava/io/FileOutputStream;
    :cond_2
    new-instance v4, Ljava/io/FileInputStream;

    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    goto :goto_0

    .line 124
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    :catchall_1
    move-exception v4

    goto :goto_2
.end method

.method static steam(Ljava/io/InputStream;Ljava/io/File;Ljava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    .locals 5
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "tmpFile"    # Ljava/io/File;
    .param p2, "contentType"    # Ljava/lang/String;
    .param p3, "offset"    # J
    .param p5, "length"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 79
    new-instance v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;-><init>()V

    .line 80
    .local v0, "requestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    iput-object p0, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    .line 81
    iput-object p2, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentType:Ljava/lang/String;

    .line 82
    iput-object p1, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    .line 83
    cmp-long v1, p3, v2

    if-gez v1, :cond_0

    move-wide p3, v2

    .end local p3    # "offset":J
    :cond_0
    iput-wide p3, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    .line 84
    const-wide/16 v2, 0x1

    cmp-long v1, p5, v2

    if-gez v1, :cond_1

    const-wide p5, 0x7fffffffffffffffL

    .end local p5    # "length":J
    :cond_1
    iput-wide p5, v0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    .line 86
    return-object v0
.end method


# virtual methods
.method public contentLength()J
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 100
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->stream:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v0

    int-to-long v0, v0

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    sub-long/2addr v0, v2

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    .line 105
    :goto_0
    return-wide v0

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    if-eqz v0, :cond_1

    .line 103
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    sub-long/2addr v0, v2

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    goto :goto_0

    .line 105
    :cond_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->bytes:[B

    array-length v0, v0

    int-to-long v0, v0

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    sub-long/2addr v0, v2

    iget-wide v2, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->length:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    goto :goto_0
.end method

.method public contentType()Lokhttp3/MediaType;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentType:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentType:Ljava/lang/String;

    invoke-static {v0}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v0

    .line 94
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBytesTransferred()J
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/CountingSink;->getTotalTransferred()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public setProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)V
    .locals 0
    .param p1, "progressListener"    # Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .line 43
    return-void
.end method

.method public writeTo(Lokio/BufferedSink;)V
    .locals 10
    .param p1, "sink"    # Lokio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 135
    const/4 v1, 0x0

    .line 136
    .local v1, "inputStream":Ljava/io/InputStream;
    const/4 v4, 0x0

    .line 138
    .local v4, "source":Lokio/Source;
    :try_start_0
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->getStream()Ljava/io/InputStream;

    move-result-object v1

    .line 139
    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    const-wide/16 v8, 0x0

    cmp-long v5, v6, v8

    if-lez v5, :cond_0

    .line 140
    iget-wide v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->offset:J

    invoke-virtual {v1, v6, v7}, Ljava/io/InputStream;->skip(J)J

    .line 142
    :cond_0
    invoke-static {v1}, Lokio/Okio;->source(Ljava/io/InputStream;)Lokio/Source;

    move-result-object v4

    .line 144
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->contentLength()J

    move-result-wide v2

    .line 145
    .local v2, "contentLength":J
    new-instance v5, Lcom/tencent/qcloud/core/http/CountingSink;

    iget-object v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    invoke-direct {v5, p1, v2, v3, v6}, Lcom/tencent/qcloud/core/http/CountingSink;-><init>(Lokio/Sink;JLcom/tencent/qcloud/core/common/QCloudProgressListener;)V

    iput-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    .line 146
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-static {v5}, Lokio/Okio;->buffer(Lokio/Sink;)Lokio/BufferedSink;

    move-result-object v0

    .line 147
    .local v0, "bufferedSink":Lokio/BufferedSink;
    invoke-interface {v0, v4, v2, v3}, Lokio/BufferedSink;->write(Lokio/Source;J)Lokio/BufferedSink;

    .line 148
    invoke-interface {v0}, Lokio/BufferedSink;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 150
    invoke-static {v1}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 151
    invoke-static {v4}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 152
    iget-object v5, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-static {v5}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 155
    return-void

    .line 150
    .end local v0    # "bufferedSink":Lokio/BufferedSink;
    .end local v2    # "contentLength":J
    :catchall_0
    move-exception v5

    invoke-static {v1}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 151
    invoke-static {v4}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 152
    iget-object v6, p0, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-static {v6}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    throw v5
.end method
