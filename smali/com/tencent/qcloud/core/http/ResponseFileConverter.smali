.class public Lcom/tencent/qcloud/core/http/ResponseFileConverter;
.super Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
.source "ResponseFileConverter.java"

# interfaces
.implements Lcom/tencent/qcloud/core/http/ProgressBody;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
        "<TT;>;",
        "Lcom/tencent/qcloud/core/http/ProgressBody;"
    }
.end annotation


# instance fields
.field private countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

.field private filePath:Ljava/lang/String;

.field private offset:J

.field private progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;


# direct methods
.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "filePath"    # Ljava/lang/String;
    .param p2, "offset"    # J

    .prologue
    .line 33
    .local p0, "this":Lcom/tencent/qcloud/core/http/ResponseFileConverter;, "Lcom/tencent/qcloud/core/http/ResponseFileConverter<TT;>;"
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->filePath:Ljava/lang/String;

    .line 35
    iput-wide p2, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->offset:J

    .line 36
    return-void
.end method

.method private writeRandomAccessFile(Ljava/io/File;Ljava/io/InputStream;J)V
    .locals 9
    .param p1, "downloadFilePath"    # Ljava/io/File;
    .param p2, "inputStream"    # Ljava/io/InputStream;
    .param p3, "contentLength"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 84
    .local p0, "this":Lcom/tencent/qcloud/core/http/ResponseFileConverter;, "Lcom/tencent/qcloud/core/http/ResponseFileConverter<TT;>;"
    if-nez p2, :cond_0

    .line 85
    new-instance v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v5, "response body stream is null"

    invoke-direct {v4, v5}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 87
    :cond_0
    const/4 v2, 0x0

    .line 89
    .local v2, "randomAccessFile":Ljava/io/RandomAccessFile;
    :try_start_0
    new-instance v3, Ljava/io/RandomAccessFile;

    const-string v4, "rws"

    invoke-direct {v3, p1, v4}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 90
    .end local v2    # "randomAccessFile":Ljava/io/RandomAccessFile;
    .local v3, "randomAccessFile":Ljava/io/RandomAccessFile;
    :try_start_1
    iget-wide v4, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->offset:J

    invoke-virtual {v3, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 91
    const/16 v4, 0x2000

    new-array v0, v4, [B

    .line 92
    .local v0, "buffer":[B
    new-instance v4, Lcom/tencent/qcloud/core/http/CountingSink;

    new-instance v5, Lokio/Buffer;

    invoke-direct {v5}, Lokio/Buffer;-><init>()V

    iget-object v6, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    invoke-direct {v4, v5, p3, p4, v6}, Lcom/tencent/qcloud/core/http/CountingSink;-><init>(Lokio/Sink;JLcom/tencent/qcloud/core/common/QCloudProgressListener;)V

    iput-object v4, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    .line 94
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "len":I
    const/4 v4, -0x1

    if-eq v1, v4, :cond_1

    .line 95
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v1}, Ljava/io/RandomAccessFile;->write([BII)V

    .line 96
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    int-to-long v6, v1

    invoke-virtual {v4, v6, v7}, Lcom/tencent/qcloud/core/http/CountingSink;->writeBytesInternal(J)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 99
    .end local v0    # "buffer":[B
    .end local v1    # "len":I
    :catchall_0
    move-exception v4

    move-object v2, v3

    .end local v3    # "randomAccessFile":Ljava/io/RandomAccessFile;
    .restart local v2    # "randomAccessFile":Ljava/io/RandomAccessFile;
    :goto_1
    invoke-static {p2}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 100
    invoke-static {v2}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    throw v4

    .line 99
    .end local v2    # "randomAccessFile":Ljava/io/RandomAccessFile;
    .restart local v0    # "buffer":[B
    .restart local v1    # "len":I
    .restart local v3    # "randomAccessFile":Ljava/io/RandomAccessFile;
    :cond_1
    invoke-static {p2}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 100
    invoke-static {v3}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 102
    return-void

    .line 99
    .end local v0    # "buffer":[B
    .end local v1    # "len":I
    .end local v3    # "randomAccessFile":Ljava/io/RandomAccessFile;
    .restart local v2    # "randomAccessFile":Ljava/io/RandomAccessFile;
    :catchall_1
    move-exception v4

    goto :goto_1
.end method


# virtual methods
.method public convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/Object;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpResponse",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/tencent/qcloud/core/http/ResponseFileConverter;, "Lcom/tencent/qcloud/core/http/ResponseFileConverter<TT;>;"
    .local p1, "response":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<TT;>;"
    invoke-static {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->checkResponseSuccessful(Lcom/tencent/qcloud/core/http/HttpResponse;)V

    .line 46
    const-string v8, "Content-Range"

    invoke-virtual {p1, v8}, Lcom/tencent/qcloud/core/http/HttpResponse;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 47
    .local v3, "contentRangeString":Ljava/lang/String;
    invoke-static {v3}, Lcom/tencent/qcloud/core/util/QCloudHttpUtils;->parseContentRange(Ljava/lang/String;)[J

    move-result-object v2

    .line 49
    .local v2, "contentRange":[J
    if-eqz v2, :cond_0

    .line 51
    const/4 v8, 0x1

    aget-wide v8, v2, v8

    const/4 v10, 0x0

    aget-wide v10, v2, v10

    sub-long/2addr v8, v10

    const-wide/16 v10, 0x1

    add-long v0, v8, v10

    .line 57
    .local v0, "contentLength":J
    :goto_0
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->filePath:Ljava/lang/String;

    invoke-direct {v4, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 58
    .local v4, "downloadFilePath":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v6

    .line 59
    .local v6, "parentDir":Ljava/io/File;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_1

    invoke-virtual {v6}, Ljava/io/File;->mkdirs()Z

    move-result v8

    if-nez v8, :cond_1

    .line 60
    new-instance v8, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v9, "local file directory can not create."

    invoke-direct {v8, v9}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 54
    .end local v0    # "contentLength":J
    .end local v4    # "downloadFilePath":Ljava/io/File;
    .end local v6    # "parentDir":Ljava/io/File;
    :cond_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->contentLength()J

    move-result-wide v0

    .restart local v0    # "contentLength":J
    goto :goto_0

    .line 63
    .restart local v4    # "downloadFilePath":Ljava/io/File;
    .restart local v6    # "parentDir":Ljava/io/File;
    :cond_1
    const/4 v7, 0x0

    .line 65
    .local v7, "sink":Lokio/BufferedSink;
    :try_start_0
    iget-wide v8, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->offset:J

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-gtz v8, :cond_2

    .line 66
    new-instance v8, Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-static {v4}, Lokio/Okio;->sink(Ljava/io/File;)Lokio/Sink;

    move-result-object v9

    iget-object v10, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    invoke-direct {v8, v9, v0, v1, v10}, Lcom/tencent/qcloud/core/http/CountingSink;-><init>(Lokio/Sink;JLcom/tencent/qcloud/core/common/QCloudProgressListener;)V

    iput-object v8, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    .line 68
    iget-object v8, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    invoke-static {v8}, Lokio/Okio;->buffer(Lokio/Sink;)Lokio/BufferedSink;

    move-result-object v7

    .line 69
    iget-object v8, p1, Lcom/tencent/qcloud/core/http/HttpResponse;->response:Lokhttp3/Response;

    invoke-virtual {v8}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v8

    invoke-virtual {v8}, Lokhttp3/ResponseBody;->source()Lokio/BufferedSource;

    move-result-object v8

    invoke-interface {v7, v8, v0, v1}, Lokio/BufferedSink;->write(Lokio/Source;J)Lokio/BufferedSink;

    .line 70
    invoke-interface {v7}, Lokio/BufferedSink;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 74
    :goto_1
    const/4 v8, 0x0

    .line 78
    invoke-static {v7}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    return-object v8

    .line 72
    :cond_2
    :try_start_1
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->byteStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {p0, v4, v8, v0, v1}, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->writeRandomAccessFile(Ljava/io/File;Ljava/io/InputStream;J)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 75
    :catch_0
    move-exception v5

    .line 76
    .local v5, "e":Ljava/io/IOException;
    :try_start_2
    new-instance v8, Lcom/tencent/qcloud/core/common/QCloudClientException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "write local file error for "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v5}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9, v5}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 78
    .end local v5    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    invoke-static {v7}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    throw v8
.end method

.method public getBytesTransferred()J
    .locals 2

    .prologue
    .line 106
    .local p0, "this":Lcom/tencent/qcloud/core/http/ResponseFileConverter;, "Lcom/tencent/qcloud/core/http/ResponseFileConverter<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->countingSink:Lcom/tencent/qcloud/core/http/CountingSink;

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
    .line 39
    .local p0, "this":Lcom/tencent/qcloud/core/http/ResponseFileConverter;, "Lcom/tencent/qcloud/core/http/ResponseFileConverter<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/ResponseFileConverter;->progressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .line 40
    return-void
.end method
