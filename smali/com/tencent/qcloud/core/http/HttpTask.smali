.class public final Lcom/tencent/qcloud/core/http/HttpTask;
.super Lcom/tencent/qcloud/core/task/CancelableTask;
.source "HttpTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/task/CancelableTask",
        "<",
        "Lcom/tencent/qcloud/core/http/HttpResult",
        "<TT;>;>;"
    }
.end annotation


# static fields
.field private static increments:Ljava/util/concurrent/atomic/AtomicInteger;


# instance fields
.field private final credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

.field private httpCall:Lokhttp3/Call;

.field private final httpClient:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

.field private final httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;"
        }
    .end annotation
.end field

.field private httpResponse:Lcom/tencent/qcloud/core/http/HttpResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpResponse",
            "<TT;>;"
        }
    .end annotation
.end field

.field private httpResult:Lcom/tencent/qcloud/core/http/HttpResult;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/qcloud/core/http/HttpResult",
            "<TT;>;"
        }
    .end annotation
.end field

.field private mProgressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    sput-object v0, Lcom/tencent/qcloud/core/http/HttpTask;->increments:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method constructor <init>(Lcom/tencent/qcloud/core/http/HttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;Lcom/tencent/qcloud/core/http/QCloudHttpClient;)V
    .locals 2
    .param p2, "credentialProvider"    # Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;
    .param p3, "httpClient"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;",
            "Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;",
            "Lcom/tencent/qcloud/core/http/QCloudHttpClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 48
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    .local p1, "httpRequest":Lcom/tencent/qcloud/core/http/HttpRequest;, "Lcom/tencent/qcloud/core/http/HttpRequest<TT;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "HttpTask-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpRequest;->tag()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/tencent/qcloud/core/http/HttpTask;->increments:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpRequest;->tag()Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/tencent/qcloud/core/task/CancelableTask;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 39
    new-instance v0, Lcom/tencent/qcloud/core/http/HttpTask$1;

    invoke-direct {v0, p0}, Lcom/tencent/qcloud/core/http/HttpTask$1;-><init>(Lcom/tencent/qcloud/core/http/HttpTask;)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->mProgressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .line 49
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 50
    iput-object p3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpClient:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    .line 51
    iput-object p2, p0, Lcom/tencent/qcloud/core/http/HttpTask;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/qcloud/core/http/HttpTask;JJ)V
    .locals 1
    .param p0, "x0"    # Lcom/tencent/qcloud/core/http/HttpTask;
    .param p1, "x1"    # J
    .param p3, "x2"    # J

    .prologue
    .line 29
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/tencent/qcloud/core/http/HttpTask;->onProgress(JJ)V

    return-void
.end method

.method private calculateContentMD5()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 171
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v2

    .line 172
    .local v2, "requestBody":Lokhttp3/RequestBody;
    if-nez v2, :cond_0

    .line 173
    new-instance v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v5, "get md5 canceled, request body is null."

    invoke-direct {v4, v5}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 175
    :cond_0
    new-instance v3, Lokio/Buffer;

    invoke-direct {v3}, Lokio/Buffer;-><init>()V

    .line 177
    .local v3, "sink":Lokio/Buffer;
    :try_start_0
    invoke-virtual {v2, v3}, Lokhttp3/RequestBody;->writeTo(Lokio/BufferedSink;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 182
    invoke-virtual {v3}, Lokio/Buffer;->md5()Lokio/ByteString;

    move-result-object v4

    invoke-virtual {v4}, Lokio/ByteString;->base64()Ljava/lang/String;

    move-result-object v1

    .line 183
    .local v1, "md5":Ljava/lang/String;
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    const-string v5, "Content-MD5"

    invoke-virtual {v4, v5, v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    invoke-virtual {v3}, Lokio/Buffer;->close()V

    .line 185
    return-void

    .line 178
    .end local v1    # "md5":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v5, "calculate md5 error"

    invoke-direct {v4, v5, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
.end method

.method private signRequest(Lcom/tencent/qcloud/core/auth/QCloudSigner;Lcom/tencent/qcloud/core/http/HttpRequest;)V
    .locals 4
    .param p1, "signer"    # Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .param p2, "request"    # Lcom/tencent/qcloud/core/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 154
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    if-nez v1, :cond_0

    .line 155
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v2, "no credentials provider"

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 158
    :cond_0
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    invoke-interface {v1}, Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;->getCredentials()Lcom/tencent/qcloud/core/auth/QCloudCredentials;

    move-result-object v0

    .line 160
    .local v0, "credentials":Lcom/tencent/qcloud/core/auth/QCloudCredentials;
    if-nez v0, :cond_1

    .line 161
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudClientException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "can\'t get credentials for provider : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->credentialProvider:Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 163
    :cond_1
    invoke-virtual {p2}, Lcom/tencent/qcloud/core/http/HttpRequest;->getSignProvider()Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;

    move-result-object v1

    if-nez v1, :cond_2

    .line 164
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v2, "no source to sign"

    invoke-direct {v1, v2}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 167
    :cond_2
    check-cast p2, Lcom/tencent/qcloud/core/http/QCloudHttpRequest;

    .end local p2    # "request":Lcom/tencent/qcloud/core/http/HttpRequest;
    invoke-interface {p1, p2, v0}, Lcom/tencent/qcloud/core/auth/QCloudSigner;->sign(Lcom/tencent/qcloud/core/http/QCloudHttpRequest;Lcom/tencent/qcloud/core/auth/QCloudCredentials;)V

    .line 168
    return-void
.end method


# virtual methods
.method convertResponse(Lokhttp3/Response;)V
    .locals 5
    .param p1, "response"    # Lokhttp3/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 189
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    :try_start_0
    new-instance v3, Lcom/tencent/qcloud/core/http/HttpResponse;

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-direct {v3, v4, p1}, Lcom/tencent/qcloud/core/http/HttpResponse;-><init>(Lcom/tencent/qcloud/core/http/HttpRequest;Lokhttp3/Response;)V

    iput-object v3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResponse:Lcom/tencent/qcloud/core/http/HttpResponse;

    .line 190
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v3}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v2

    .line 191
    .local v2, "converter":Lcom/tencent/qcloud/core/http/ResponseBodyConverter;, "Lcom/tencent/qcloud/core/http/ResponseBodyConverter<TT;>;"
    instance-of v3, v2, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v3, :cond_0

    .line 192
    move-object v0, v2

    check-cast v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    move-object v3, v0

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->mProgressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    invoke-interface {v3, v4}, Lcom/tencent/qcloud/core/http/ProgressBody;->setProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)V

    .line 194
    :cond_0
    iget-object v3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResponse:Lcom/tencent/qcloud/core/http/HttpResponse;

    invoke-virtual {v2, v3}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter;->convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/Object;

    move-result-object v1

    .line 195
    .local v1, "content":Ljava/lang/Object;, "TT;"
    new-instance v3, Lcom/tencent/qcloud/core/http/HttpResult;

    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResponse:Lcom/tencent/qcloud/core/http/HttpResponse;

    invoke-direct {v3, v4, v1}, Lcom/tencent/qcloud/core/http/HttpResult;-><init>(Lcom/tencent/qcloud/core/http/HttpResponse;Ljava/lang/Object;)V

    iput-object v3, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 197
    invoke-virtual {p1}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v3

    invoke-static {v3}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 199
    return-void

    .line 197
    .end local v1    # "content":Ljava/lang/Object;, "TT;"
    .end local v2    # "converter":Lcom/tencent/qcloud/core/http/ResponseBodyConverter;, "Lcom/tencent/qcloud/core/http/ResponseBodyConverter<TT;>;"
    :catchall_0
    move-exception v3

    invoke-virtual {p1}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v4

    invoke-static {v4}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    throw v3
.end method

.method getAverageStreamingSpeed(J)D
    .locals 9
    .param p1, "networkMillsTook"    # J

    .prologue
    .line 88
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    const/4 v0, 0x0

    .line 90
    .local v0, "body":Lcom/tencent/qcloud/core/http/ProgressBody;
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v1

    instance-of v1, v1, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v1, :cond_1

    .line 91
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v0

    .end local v0    # "body":Lcom/tencent/qcloud/core/http/ProgressBody;
    check-cast v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    .line 95
    .restart local v0    # "body":Lcom/tencent/qcloud/core/http/ProgressBody;
    :cond_0
    :goto_0
    if-eqz v0, :cond_2

    .line 96
    invoke-interface {v0}, Lcom/tencent/qcloud/core/http/ProgressBody;->getBytesTransferred()J

    move-result-wide v2

    long-to-double v2, v2

    const-wide/high16 v4, 0x4090000000000000L    # 1024.0

    div-double/2addr v2, v4

    long-to-double v4, p1

    const-wide v6, 0x408f400000000000L    # 1000.0

    div-double/2addr v4, v6

    div-double/2addr v2, v4

    .line 98
    :goto_1
    return-wide v2

    .line 92
    :cond_1
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v1

    instance-of v1, v1, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v1, :cond_0

    .line 93
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v1}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v0

    .end local v0    # "body":Lcom/tencent/qcloud/core/http/ProgressBody;
    check-cast v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    .restart local v0    # "body":Lcom/tencent/qcloud/core/http/ProgressBody;
    goto :goto_0

    .line 98
    :cond_2
    const-wide/16 v2, 0x0

    goto :goto_1
.end method

.method public getResult()Lcom/tencent/qcloud/core/http/HttpResult;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpResult",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 71
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;

    return-object v0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 29
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpTask;->getResult()Lcom/tencent/qcloud/core/http/HttpResult;

    move-result-object v0

    return-object v0
.end method

.method isDownloadTask()Z
    .locals 1

    .prologue
    .line 84
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    return v0
.end method

.method isStreamingTask()Z
    .locals 1

    .prologue
    .line 75
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    .line 76
    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSuccessful()Z
    .locals 1

    .prologue
    .line 66
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpResult;->isSuccessful()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isUploadTask()Z
    .locals 1

    .prologue
    .line 80
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    return v0
.end method

.method protected onCancel()Z
    .locals 1

    .prologue
    .line 147
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpCall:Lokhttp3/Call;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpCall:Lokhttp3/Call;

    invoke-interface {v0}, Lokhttp3/Call;->cancel()V

    .line 150
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method protected onCommand()Lcom/tencent/qcloud/core/http/HttpResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpResult",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 103
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->shouldCalculateContentMD5()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 104
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/HttpTask;->calculateContentMD5()V

    .line 107
    :cond_0
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->getQCloudSigner()Lcom/tencent/qcloud/core/auth/QCloudSigner;

    move-result-object v3

    .line 108
    .local v3, "signer":Lcom/tencent/qcloud/core/auth/QCloudSigner;
    if-eqz v3, :cond_1

    .line 109
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-direct {p0, v3, v4}, Lcom/tencent/qcloud/core/http/HttpTask;->signRequest(Lcom/tencent/qcloud/core/auth/QCloudSigner;Lcom/tencent/qcloud/core/http/HttpRequest;)V

    .line 111
    :cond_1
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v4

    instance-of v4, v4, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v4, :cond_2

    .line 112
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v4

    check-cast v4, Lcom/tencent/qcloud/core/http/ProgressBody;

    iget-object v5, p0, Lcom/tencent/qcloud/core/http/HttpTask;->mProgressListener:Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    invoke-interface {v4, v5}, Lcom/tencent/qcloud/core/http/ProgressBody;->setProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)V

    .line 116
    :cond_2
    :try_start_0
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpTask;->getIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/tencent/qcloud/core/http/HttpRequest;->setOkHttpRequestTag(Ljava/lang/String;)V

    .line 117
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v4}, Lcom/tencent/qcloud/core/http/HttpRequest;->buildRealRequest()Lokhttp3/Request;

    move-result-object v1

    .line 118
    .local v1, "okHttpRequest":Lokhttp3/Request;
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpClient:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-virtual {v4, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->getOkHttpCall(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v4

    iput-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpCall:Lokhttp3/Call;

    .line 120
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpCall:Lokhttp3/Call;

    invoke-interface {v4}, Lokhttp3/Call;->execute()Lokhttp3/Response;

    move-result-object v2

    .line 122
    .local v2, "response":Lokhttp3/Response;
    if-eqz v2, :cond_4

    .line 123
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;

    if-nez v4, :cond_3

    .line 124
    invoke-virtual {p0, v2}, Lcom/tencent/qcloud/core/http/HttpTask;->convertResponse(Lokhttp3/Response;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 142
    :goto_0
    iget-object v4, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpResult:Lcom/tencent/qcloud/core/http/HttpResult;

    return-object v4

    .line 126
    :cond_3
    :try_start_1
    invoke-virtual {v2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v4

    invoke-static {v4}, Lokhttp3/internal/Util;->closeQuietly(Ljava/io/Closeable;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 132
    .end local v1    # "okHttpRequest":Lokhttp3/Request;
    .end local v2    # "response":Lokhttp3/Response;
    :catch_0
    move-exception v0

    .line 133
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    instance-of v4, v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    if-eqz v4, :cond_5

    .line 134
    invoke-virtual {v0}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    check-cast v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    throw v4

    .line 129
    .end local v0    # "e":Ljava/io/IOException;
    .restart local v1    # "okHttpRequest":Lokhttp3/Request;
    .restart local v2    # "response":Lokhttp3/Response;
    :cond_4
    :try_start_2
    new-instance v4, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    const-string v5, "http response is null"

    invoke-direct {v4, v5}, Lcom/tencent/qcloud/core/common/QCloudServiceException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 135
    .end local v1    # "okHttpRequest":Lokhttp3/Request;
    .end local v2    # "response":Lokhttp3/Response;
    .restart local v0    # "e":Ljava/io/IOException;
    :cond_5
    invoke-virtual {v0}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    instance-of v4, v4, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    if-eqz v4, :cond_6

    .line 136
    invoke-virtual {v0}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v4

    check-cast v4, Lcom/tencent/qcloud/core/common/QCloudServiceException;

    throw v4

    .line 138
    :cond_6
    new-instance v4, Lcom/tencent/qcloud/core/common/QCloudClientException;

    invoke-direct {v4, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method protected bridge synthetic onCommand()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 29
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/http/HttpTask;->onCommand()Lcom/tencent/qcloud/core/http/HttpResult;

    move-result-object v0

    return-object v0
.end method

.method public schedule()Lcom/tencent/qcloud/core/http/HttpTask;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/tencent/qcloud/core/http/HttpTask",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 55
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask;, "Lcom/tencent/qcloud/core/http/HttpTask<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getRequestBody()Lokhttp3/RequestBody;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v0, :cond_0

    .line 56
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->UPLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/http/HttpTask;->scheduleOn(Ljava/util/concurrent/ThreadPoolExecutor;)V

    .line 62
    :goto_0
    return-object p0

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask;->httpRequest:Lcom/tencent/qcloud/core/http/HttpRequest;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/http/HttpRequest;->getResponseBodyConverter()Lcom/tencent/qcloud/core/http/ResponseBodyConverter;

    move-result-object v0

    instance-of v0, v0, Lcom/tencent/qcloud/core/http/ProgressBody;

    if-eqz v0, :cond_1

    .line 58
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->DOWNLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/http/HttpTask;->scheduleOn(Ljava/util/concurrent/ThreadPoolExecutor;)V

    goto :goto_0

    .line 60
    :cond_1
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->COMMAND_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {p0, v0}, Lcom/tencent/qcloud/core/http/HttpTask;->scheduleOn(Ljava/util/concurrent/ThreadPoolExecutor;)V

    goto :goto_0
.end method
