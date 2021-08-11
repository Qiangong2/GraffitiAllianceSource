.class public Lcom/pwrd/android/volley/toolbox/BasicNetwork;
.super Ljava/lang/Object;
.source "BasicNetwork.java"

# interfaces
.implements Lcom/pwrd/android/volley/Network;


# static fields
.field protected static final DEBUG:Z

.field private static DEFAULT_POOL_SIZE:I = 0x0

.field private static SLOW_REQUEST_THRESHOLD_MS:I = 0x0

.field private static final TAG:Ljava/lang/String; = "BasicNetwork"


# instance fields
.field protected final mHttpStack:Lcom/pwrd/android/volley/toolbox/HttpStack;

.field protected final mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    sget-boolean v0, Lcom/pwrd/android/volley/VolleyLog;->DEBUG:Z

    sput-boolean v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->DEBUG:Z

    .line 42
    const/16 v0, 0xbb8

    sput v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->SLOW_REQUEST_THRESHOLD_MS:I

    .line 44
    const/16 v0, 0x1000

    sput v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->DEFAULT_POOL_SIZE:I

    return-void
.end method

.method public constructor <init>(Lcom/pwrd/android/volley/toolbox/HttpStack;)V
    .locals 2
    .param p1, "httpStack"    # Lcom/pwrd/android/volley/toolbox/HttpStack;

    .prologue
    .line 56
    new-instance v0, Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    sget v1, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->DEFAULT_POOL_SIZE:I

    invoke-direct {v0, v1}, Lcom/pwrd/android/volley/toolbox/ByteArrayPool;-><init>(I)V

    invoke-direct {p0, p1, v0}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;-><init>(Lcom/pwrd/android/volley/toolbox/HttpStack;Lcom/pwrd/android/volley/toolbox/ByteArrayPool;)V

    .line 57
    return-void
.end method

.method public constructor <init>(Lcom/pwrd/android/volley/toolbox/HttpStack;Lcom/pwrd/android/volley/toolbox/ByteArrayPool;)V
    .locals 0
    .param p1, "httpStack"    # Lcom/pwrd/android/volley/toolbox/HttpStack;
    .param p2, "pool"    # Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mHttpStack:Lcom/pwrd/android/volley/toolbox/HttpStack;

    .line 65
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    .line 66
    return-void
.end method

.method private addCacheHeaders(Ljava/util/Map;Lcom/pwrd/android/volley/Cache$Entry;)V
    .locals 6
    .param p2, "entry"    # Lcom/pwrd/android/volley/Cache$Entry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pwrd/android/volley/Cache$Entry;",
            ")V"
        }
    .end annotation

    .prologue
    .line 222
    .local p1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p2, :cond_1

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 226
    :cond_1
    iget-object v1, p2, Lcom/pwrd/android/volley/Cache$Entry;->etag:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 227
    const-string v1, "If-None-Match"

    iget-object v2, p2, Lcom/pwrd/android/volley/Cache$Entry;->etag:Ljava/lang/String;

    invoke-interface {p1, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    :cond_2
    iget-wide v2, p2, Lcom/pwrd/android/volley/Cache$Entry;->serverDate:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 231
    new-instance v0, Ljava/util/Date;

    iget-wide v2, p2, Lcom/pwrd/android/volley/Cache$Entry;->serverDate:J

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    .line 232
    .local v0, "refTime":Ljava/util/Date;
    const-string v1, "If-Modified-Since"

    invoke-static {v0}, Lorg/apache/http/impl/cookie/DateUtils;->formatDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private static attemptRetryOnException(Ljava/lang/String;Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/VolleyError;)V
    .locals 7
    .param p0, "logPrefix"    # Ljava/lang/String;
    .param p2, "exception"    # Lcom/pwrd/android/volley/VolleyError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/Request",
            "<*>;",
            "Lcom/pwrd/android/volley/VolleyError;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/VolleyError;
        }
    .end annotation

    .prologue
    .local p1, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 207
    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getRetryPolicy()Lcom/pwrd/android/volley/RetryPolicy;

    move-result-object v2

    .line 208
    .local v2, "retryPolicy":Lcom/pwrd/android/volley/RetryPolicy;
    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getTimeoutMs()I

    move-result v1

    .line 211
    .local v1, "oldTimeout":I
    :try_start_0
    invoke-interface {v2, p2}, Lcom/pwrd/android/volley/RetryPolicy;->retry(Lcom/pwrd/android/volley/VolleyError;)V
    :try_end_0
    .catch Lcom/pwrd/android/volley/VolleyError; {:try_start_0 .. :try_end_0} :catch_0

    .line 217
    const-string v3, "%s-retry [timeout=%s]"

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p0, v4, v5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Lcom/pwrd/android/volley/Request;->addMarker(Ljava/lang/String;)V

    .line 218
    return-void

    .line 212
    :catch_0
    move-exception v0

    .line 214
    .local v0, "e":Lcom/pwrd/android/volley/VolleyError;
    const-string v3, "%s-timeout-giveup [timeout=%s]"

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p0, v4, v5

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 213
    invoke-virtual {p1, v3}, Lcom/pwrd/android/volley/Request;->addMarker(Ljava/lang/String;)V

    .line 215
    throw v0
.end method

.method private static convertHeaders([Lorg/apache/http/Header;)Ljava/util/Map;
    .locals 4
    .param p0, "headers"    # [Lorg/apache/http/Header;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lorg/apache/http/Header;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 277
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 278
    .local v1, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p0

    if-lt v0, v2, :cond_0

    .line 281
    return-object v1

    .line 279
    :cond_0
    aget-object v2, p0, v0

    invoke-interface {v2}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v2

    aget-object v3, p0, v0

    invoke-interface {v3}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private entityToBytes(Lorg/apache/http/HttpEntity;)[B
    .locals 9
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/pwrd/android/volley/ServerError;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 246
    new-instance v1, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;

    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v6

    long-to-int v6, v6

    invoke-direct {v1, v5, v6}, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;-><init>(Lcom/pwrd/android/volley/toolbox/ByteArrayPool;I)V

    .line 247
    .local v1, "bytes":Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;
    const/4 v0, 0x0

    .line 249
    .local v0, "buffer":[B
    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v4

    .line 250
    .local v4, "in":Ljava/io/InputStream;
    if-nez v4, :cond_0

    .line 251
    new-instance v5, Lcom/pwrd/android/volley/ServerError;

    invoke-direct {v5}, Lcom/pwrd/android/volley/ServerError;-><init>()V

    throw v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 259
    .end local v4    # "in":Ljava/io/InputStream;
    :catchall_0
    move-exception v5

    .line 262
    :try_start_1
    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->consumeContent()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 268
    :goto_0
    iget-object v6, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    invoke-virtual {v6, v0}, Lcom/pwrd/android/volley/toolbox/ByteArrayPool;->returnBuf([B)V

    .line 269
    invoke-virtual {v1}, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;->close()V

    .line 270
    throw v5

    .line 253
    .restart local v4    # "in":Ljava/io/InputStream;
    :cond_0
    :try_start_2
    iget-object v5, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    const/16 v6, 0x400

    invoke-virtual {v5, v6}, Lcom/pwrd/android/volley/toolbox/ByteArrayPool;->getBuf(I)[B

    move-result-object v0

    .line 255
    :goto_1
    invoke-virtual {v4, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    .local v2, "count":I
    const/4 v5, -0x1

    if-ne v2, v5, :cond_1

    .line 258
    invoke-virtual {v1}, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;->toByteArray()[B
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v5

    .line 262
    :try_start_3
    invoke-interface {p1}, Lorg/apache/http/HttpEntity;->consumeContent()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 268
    :goto_2
    iget-object v6, p0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mPool:Lcom/pwrd/android/volley/toolbox/ByteArrayPool;

    invoke-virtual {v6, v0}, Lcom/pwrd/android/volley/toolbox/ByteArrayPool;->returnBuf([B)V

    .line 269
    invoke-virtual {v1}, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;->close()V

    .line 258
    return-object v5

    .line 256
    :cond_1
    const/4 v5, 0x0

    :try_start_4
    invoke-virtual {v1, v0, v5, v2}, Lcom/pwrd/android/volley/toolbox/PoolingByteArrayOutputStream;->write([BII)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_1

    .line 263
    :catch_0
    move-exception v3

    .line 266
    .local v3, "e":Ljava/io/IOException;
    const-string v6, "Error occured when calling consumingContent"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/pwrd/android/volley/VolleyLog;->v(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 263
    .end local v2    # "count":I
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "in":Ljava/io/InputStream;
    :catch_1
    move-exception v3

    .line 266
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v6, "Error occured when calling consumingContent"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/pwrd/android/volley/VolleyLog;->v(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private isLocalFile(Ljava/lang/String;)Z
    .locals 1
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 69
    const-string v0, "file://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private logSlowRequests(JLcom/pwrd/android/volley/Request;[BLorg/apache/http/StatusLine;)V
    .locals 5
    .param p1, "requestLifetime"    # J
    .param p4, "responseContents"    # [B
    .param p5, "statusLine"    # Lorg/apache/http/StatusLine;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lcom/pwrd/android/volley/Request",
            "<*>;[B",
            "Lorg/apache/http/StatusLine;",
            ")V"
        }
    .end annotation

    .prologue
    .line 191
    .local p3, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    sget-boolean v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->DEBUG:Z

    if-nez v0, :cond_0

    sget v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->SLOW_REQUEST_THRESHOLD_MS:I

    int-to-long v0, v0

    cmp-long v0, p1, v0

    if-lez v0, :cond_1

    .line 192
    :cond_0
    const-string v1, "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"

    const/4 v0, 0x5

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    .line 193
    aput-object p3, v2, v0

    const/4 v0, 0x1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v3, 0x2

    .line 194
    if-eqz p4, :cond_2

    array-length v0, p4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    :goto_0
    aput-object v0, v2, v3

    const/4 v0, 0x3

    .line 195
    invoke-interface {p5}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x4

    invoke-virtual {p3}, Lcom/pwrd/android/volley/Request;->getRetryPolicy()Lcom/pwrd/android/volley/RetryPolicy;

    move-result-object v3

    invoke-interface {v3}, Lcom/pwrd/android/volley/RetryPolicy;->getCurrentRetryCount()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    .line 192
    invoke-static {v1, v2}, Lcom/pwrd/android/volley/VolleyLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 197
    :cond_1
    return-void

    .line 194
    :cond_2
    const-string v0, "null"

    goto :goto_0
.end method

.method private performFileRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;)",
            "Lcom/pwrd/android/volley/NetworkResponse;"
        }
    .end annotation

    .prologue
    .local p1, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    const/16 v8, 0x2000

    .line 82
    const/4 v7, 0x0

    .line 83
    .local v7, "urlConnection":Ljava/net/URLConnection;
    const/4 v3, 0x0

    .line 84
    .local v3, "in":Ljava/io/BufferedInputStream;
    new-instance v5, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v5, v8}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 86
    .local v5, "out":Ljava/io/ByteArrayOutputStream;
    :try_start_0
    new-instance v6, Ljava/net/URL;

    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v8}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 87
    .local v6, "url":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    .line 88
    new-instance v4, Ljava/io/BufferedInputStream;

    invoke-virtual {v7}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    const/16 v9, 0x2000

    invoke-direct {v4, v8, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .local v4, "in":Ljava/io/BufferedInputStream;
    :goto_0
    :try_start_1
    invoke-virtual {v4}, Ljava/io/BufferedInputStream;->read()I

    move-result v0

    .local v0, "b":I
    const/4 v8, -0x1

    if-ne v0, v8, :cond_2

    .line 94
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    .line 95
    .local v1, "data":[B
    if-eqz v1, :cond_7

    .line 96
    new-instance v9, Lcom/pwrd/android/volley/NetworkResponse;

    const/16 v8, 0xc8

    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    const/4 v11, 0x0

    invoke-direct {v9, v8, v1, v10, v11}, Lcom/pwrd/android/volley/NetworkResponse;-><init>(I[BLjava/util/Map;Z)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 101
    if-eqz v7, :cond_0

    instance-of v8, v7, Ljava/net/HttpURLConnection;

    if-eqz v8, :cond_0

    move-object v8, v7

    .line 102
    check-cast v8, Ljava/net/HttpURLConnection;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 105
    :cond_0
    :try_start_2
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 106
    if-eqz v4, :cond_1

    .line 107
    invoke-virtual {v4}, Ljava/io/BufferedInputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5

    :cond_1
    :goto_1
    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    move-object v8, v9

    .line 112
    .end local v0    # "b":I
    .end local v1    # "data":[B
    .end local v6    # "url":Ljava/net/URL;
    :goto_2
    return-object v8

    .line 92
    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .restart local v0    # "b":I
    .restart local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v6    # "url":Ljava/net/URL;
    :cond_2
    :try_start_3
    invoke-virtual {v5, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    .line 98
    .end local v0    # "b":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 99
    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .end local v6    # "url":Ljava/net/URL;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    :goto_3
    :try_start_4
    const-string v8, "BasicNetwork"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Error in read file - "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 101
    if-eqz v7, :cond_3

    instance-of v8, v7, Ljava/net/HttpURLConnection;

    if-eqz v8, :cond_3

    move-object v8, v7

    .line 102
    check-cast v8, Ljava/net/HttpURLConnection;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 105
    :cond_3
    :try_start_5
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 106
    if-eqz v3, :cond_4

    .line 107
    invoke-virtual {v3}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 112
    .end local v2    # "e":Ljava/io/IOException;
    :cond_4
    :goto_4
    const/4 v8, 0x0

    goto :goto_2

    .line 100
    :catchall_0
    move-exception v8

    .line 101
    :goto_5
    if-eqz v7, :cond_5

    instance-of v9, v7, Ljava/net/HttpURLConnection;

    if-eqz v9, :cond_5

    .line 102
    check-cast v7, Ljava/net/HttpURLConnection;

    .end local v7    # "urlConnection":Ljava/net/URLConnection;
    invoke-virtual {v7}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 105
    :cond_5
    :try_start_6
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 106
    if-eqz v3, :cond_6

    .line 107
    invoke-virtual {v3}, Ljava/io/BufferedInputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 111
    :cond_6
    :goto_6
    throw v8

    .line 101
    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .restart local v0    # "b":I
    .restart local v1    # "data":[B
    .restart local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v6    # "url":Ljava/net/URL;
    .restart local v7    # "urlConnection":Ljava/net/URLConnection;
    :cond_7
    if-eqz v7, :cond_8

    instance-of v8, v7, Ljava/net/HttpURLConnection;

    if-eqz v8, :cond_8

    move-object v8, v7

    .line 102
    check-cast v8, Ljava/net/HttpURLConnection;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 105
    :cond_8
    :try_start_7
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 106
    if-eqz v4, :cond_9

    .line 107
    invoke-virtual {v4}, Ljava/io/BufferedInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1

    move-object v3, v4

    .line 109
    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    goto :goto_4

    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .restart local v4    # "in":Ljava/io/BufferedInputStream;
    :catch_1
    move-exception v8

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    goto :goto_4

    .end local v0    # "b":I
    .end local v1    # "data":[B
    .end local v6    # "url":Ljava/net/URL;
    .end local v7    # "urlConnection":Ljava/net/URLConnection;
    :catch_2
    move-exception v9

    goto :goto_6

    .line 100
    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .restart local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v6    # "url":Ljava/net/URL;
    .restart local v7    # "urlConnection":Ljava/net/URLConnection;
    :catchall_1
    move-exception v8

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    goto :goto_5

    .line 109
    .end local v6    # "url":Ljava/net/URL;
    .restart local v2    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v8

    goto :goto_4

    .line 98
    .end local v2    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v2

    goto :goto_3

    .line 109
    .end local v3    # "in":Ljava/io/BufferedInputStream;
    .restart local v0    # "b":I
    .restart local v1    # "data":[B
    .restart local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v6    # "url":Ljava/net/URL;
    :catch_5
    move-exception v8

    goto :goto_1

    :cond_9
    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedInputStream;
    .restart local v3    # "in":Ljava/io/BufferedInputStream;
    goto :goto_4
.end method

.method private performNetRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;)",
            "Lcom/pwrd/android/volley/NetworkResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/VolleyError;
        }
    .end annotation

    .prologue
    .line 116
    .local p1, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v12

    .line 118
    .local v12, "requestStart":J
    :goto_0
    const/4 v10, 0x0

    .line 119
    .local v10, "httpResponse":Lorg/apache/http/HttpResponse;
    const/4 v7, 0x0

    .line 120
    .local v7, "responseContents":[B
    new-instance v14, Ljava/util/HashMap;

    invoke-direct {v14}, Ljava/util/HashMap;-><init>()V

    .line 123
    .local v14, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 124
    .local v9, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual/range {p1 .. p1}, Lcom/pwrd/android/volley/Request;->getCacheEntry()Lcom/pwrd/android/volley/Cache$Entry;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v3}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->addCacheHeaders(Ljava/util/Map;Lcom/pwrd/android/volley/Cache$Entry;)V

    .line 125
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->mHttpStack:Lcom/pwrd/android/volley/toolbox/HttpStack;

    move-object/from16 v0, p1

    invoke-interface {v3, v0, v9}, Lcom/pwrd/android/volley/toolbox/HttpStack;->performRequest(Lcom/pwrd/android/volley/Request;Ljava/util/Map;)Lorg/apache/http/HttpResponse;

    move-result-object v10

    .line 126
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    .line 127
    .local v8, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v15

    .line 129
    .local v15, "statusCode":I
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v3

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->convertHeaders([Lorg/apache/http/Header;)Ljava/util/Map;

    move-result-object v14

    .line 131
    const/16 v3, 0x130

    if-ne v15, v3, :cond_0

    .line 132
    new-instance v3, Lcom/pwrd/android/volley/NetworkResponse;

    const/16 v6, 0x130

    .line 133
    invoke-virtual/range {p1 .. p1}, Lcom/pwrd/android/volley/Request;->getCacheEntry()Lcom/pwrd/android/volley/Cache$Entry;

    move-result-object v16

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/pwrd/android/volley/Cache$Entry;->data:[B

    move-object/from16 v16, v0

    const/16 v17, 0x1

    .line 132
    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-direct {v3, v6, v0, v14, v1}, Lcom/pwrd/android/volley/NetworkResponse;-><init>(I[BLjava/util/Map;Z)V

    .line 152
    :goto_1
    return-object v3

    .line 137
    :cond_0
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 138
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->entityToBytes(Lorg/apache/http/HttpEntity;)[B

    move-result-object v7

    .line 146
    :goto_2
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v16

    sub-long v4, v16, v12

    .local v4, "requestLifetime":J
    move-object/from16 v3, p0

    move-object/from16 v6, p1

    .line 147
    invoke-direct/range {v3 .. v8}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->logSlowRequests(JLcom/pwrd/android/volley/Request;[BLorg/apache/http/StatusLine;)V

    .line 149
    const/16 v3, 0xc8

    if-lt v15, v3, :cond_1

    const/16 v3, 0x12b

    if-le v15, v3, :cond_3

    .line 150
    :cond_1
    new-instance v3, Ljava/io/IOException;

    invoke-direct {v3}, Ljava/io/IOException;-><init>()V

    throw v3
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    .line 153
    .end local v4    # "requestLifetime":J
    .end local v8    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v9    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v15    # "statusCode":I
    :catch_0
    move-exception v2

    .line 154
    .local v2, "e":Ljava/net/SocketTimeoutException;
    const-string v3, "socket"

    new-instance v6, Lcom/pwrd/android/volley/TimeoutError;

    invoke-direct {v6}, Lcom/pwrd/android/volley/TimeoutError;-><init>()V

    move-object/from16 v0, p1

    invoke-static {v3, v0, v6}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->attemptRetryOnException(Ljava/lang/String;Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/VolleyError;)V

    goto/16 :goto_0

    .line 142
    .end local v2    # "e":Ljava/net/SocketTimeoutException;
    .restart local v8    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v9    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v15    # "statusCode":I
    :cond_2
    const/4 v3, 0x0

    :try_start_1
    new-array v7, v3, [B

    goto :goto_2

    .line 152
    .restart local v4    # "requestLifetime":J
    :cond_3
    new-instance v3, Lcom/pwrd/android/volley/NetworkResponse;

    const/4 v6, 0x0

    invoke-direct {v3, v15, v7, v14, v6}, Lcom/pwrd/android/volley/NetworkResponse;-><init>(I[BLjava/util/Map;Z)V
    :try_end_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3

    goto :goto_1

    .line 155
    .end local v4    # "requestLifetime":J
    .end local v8    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v9    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v15    # "statusCode":I
    :catch_1
    move-exception v2

    .line 156
    .local v2, "e":Lorg/apache/http/conn/ConnectTimeoutException;
    const-string v3, "connection"

    new-instance v6, Lcom/pwrd/android/volley/TimeoutError;

    invoke-direct {v6}, Lcom/pwrd/android/volley/TimeoutError;-><init>()V

    move-object/from16 v0, p1

    invoke-static {v3, v0, v6}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->attemptRetryOnException(Ljava/lang/String;Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/VolleyError;)V

    goto/16 :goto_0

    .line 157
    .end local v2    # "e":Lorg/apache/http/conn/ConnectTimeoutException;
    :catch_2
    move-exception v2

    .line 158
    .local v2, "e":Ljava/net/MalformedURLException;
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v16, "Bad URL "

    move-object/from16 v0, v16

    invoke-direct {v6, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p1 .. p1}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v3, v6, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 159
    .end local v2    # "e":Ljava/net/MalformedURLException;
    :catch_3
    move-exception v2

    .line 160
    .local v2, "e":Ljava/io/IOException;
    const/4 v15, 0x0

    .line 161
    .restart local v15    # "statusCode":I
    const/4 v11, 0x0

    .line 162
    .local v11, "networkResponse":Lcom/pwrd/android/volley/NetworkResponse;
    if-eqz v10, :cond_5

    .line 163
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v15

    .line 167
    const-string v3, "Unexpected response code %d for %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v6, v16

    const/16 v16, 0x1

    invoke-virtual/range {p1 .. p1}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v6, v16

    invoke-static {v3, v6}, Lcom/pwrd/android/volley/VolleyLog;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 168
    if-eqz v7, :cond_7

    .line 169
    new-instance v11, Lcom/pwrd/android/volley/NetworkResponse;

    .line 170
    .end local v11    # "networkResponse":Lcom/pwrd/android/volley/NetworkResponse;
    const/4 v3, 0x0

    .line 169
    invoke-direct {v11, v15, v7, v14, v3}, Lcom/pwrd/android/volley/NetworkResponse;-><init>(I[BLjava/util/Map;Z)V

    .line 171
    .restart local v11    # "networkResponse":Lcom/pwrd/android/volley/NetworkResponse;
    const/16 v3, 0x191

    if-eq v15, v3, :cond_4

    .line 172
    const/16 v3, 0x193

    if-ne v15, v3, :cond_6

    .line 173
    :cond_4
    const-string v3, "auth"

    .line 174
    new-instance v6, Lcom/pwrd/android/volley/AuthFailureError;

    invoke-direct {v6, v11}, Lcom/pwrd/android/volley/AuthFailureError;-><init>(Lcom/pwrd/android/volley/NetworkResponse;)V

    .line 173
    move-object/from16 v0, p1

    invoke-static {v3, v0, v6}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->attemptRetryOnException(Ljava/lang/String;Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/VolleyError;)V

    goto/16 :goto_0

    .line 165
    :cond_5
    new-instance v3, Lcom/pwrd/android/volley/NoConnectionError;

    invoke-direct {v3, v2}, Lcom/pwrd/android/volley/NoConnectionError;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 177
    :cond_6
    new-instance v3, Lcom/pwrd/android/volley/ServerError;

    invoke-direct {v3, v11}, Lcom/pwrd/android/volley/ServerError;-><init>(Lcom/pwrd/android/volley/NetworkResponse;)V

    throw v3

    .line 180
    :cond_7
    new-instance v3, Lcom/pwrd/android/volley/NetworkError;

    invoke-direct {v3, v11}, Lcom/pwrd/android/volley/NetworkError;-><init>(Lcom/pwrd/android/volley/NetworkResponse;)V

    throw v3
.end method


# virtual methods
.method protected logError(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 9
    .param p1, "what"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "start"    # J

    .prologue
    .line 237
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 238
    .local v0, "now":J
    const-string v2, "HTTP ERROR(%s) %d ms to fetch %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    sub-long v6, v0, p3

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Lcom/pwrd/android/volley/VolleyLog;->v(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 239
    return-void
.end method

.method public performRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;)",
            "Lcom/pwrd/android/volley/NetworkResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/VolleyError;
        }
    .end annotation

    .prologue
    .line 74
    .local p1, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->isLocalFile(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->performFileRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;

    move-result-object v0

    .line 77
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/toolbox/BasicNetwork;->performNetRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;

    move-result-object v0

    goto :goto_0
.end method
