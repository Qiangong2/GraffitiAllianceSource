.class public abstract Lcom/pwrd/android/volley/Request;
.super Ljava/lang/Object;
.source "Request.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/Request$Method;,
        Lcom/pwrd/android/volley/Request$Priority;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/pwrd/android/volley/Request",
        "<TT;>;>;"
    }
.end annotation


# static fields
.field private static final DEFAULT_PARAMS_ENCODING:Ljava/lang/String; = "UTF-8"

.field private static final SLOW_REQUEST_THRESHOLD_MS:J = 0xbb8L


# instance fields
.field private mCacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

.field private mCanceled:Z

.field private final mDefaultTrafficStatsTag:I

.field private final mErrorListener:Lcom/pwrd/android/volley/Response$ErrorListener;

.field private final mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

.field private final mMethod:I

.field private mRequestBirthTime:J

.field private mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

.field private mResponseDelivered:Z

.field private mRetryPolicy:Lcom/pwrd/android/volley/RetryPolicy;

.field private mSequence:Ljava/lang/Integer;

.field private mShouldCache:Z

.field private mTag:Ljava/lang/Object;

.field private final mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 6
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    .local p3, "listener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 149
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    sget-boolean v1, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->ENABLED:Z

    if-eqz v1, :cond_0

    new-instance v1, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    invoke-direct {v1}, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;-><init>()V

    :goto_0
    iput-object v1, p0, Lcom/pwrd/android/volley/Request;->mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    .line 94
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/pwrd/android/volley/Request;->mShouldCache:Z

    .line 99
    iput-boolean v3, p0, Lcom/pwrd/android/volley/Request;->mCanceled:Z

    .line 104
    iput-boolean v3, p0, Lcom/pwrd/android/volley/Request;->mResponseDelivered:Z

    .line 107
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Lcom/pwrd/android/volley/Request;->mRequestBirthTime:J

    .line 124
    iput-object v2, p0, Lcom/pwrd/android/volley/Request;->mCacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

    .line 150
    iput p1, p0, Lcom/pwrd/android/volley/Request;->mMethod:I

    .line 151
    iput-object p2, p0, Lcom/pwrd/android/volley/Request;->mUrl:Ljava/lang/String;

    .line 152
    iput-object p3, p0, Lcom/pwrd/android/volley/Request;->mErrorListener:Lcom/pwrd/android/volley/Response$ErrorListener;

    .line 153
    new-instance v1, Lcom/pwrd/android/volley/DefaultRetryPolicy;

    invoke-direct {v1}, Lcom/pwrd/android/volley/DefaultRetryPolicy;-><init>()V

    invoke-virtual {p0, v1}, Lcom/pwrd/android/volley/Request;->setRetryPolicy(Lcom/pwrd/android/volley/RetryPolicy;)V

    .line 155
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 156
    iput v3, p0, Lcom/pwrd/android/volley/Request;->mDefaultTrafficStatsTag:I

    .line 165
    :goto_1
    return-void

    :cond_0
    move-object v1, v2

    .line 59
    goto :goto_0

    .line 158
    :cond_1
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 159
    .local v0, "uri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 160
    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    iput v1, p0, Lcom/pwrd/android/volley/Request;->mDefaultTrafficStatsTag:I

    goto :goto_1

    .line 162
    :cond_2
    iput v3, p0, Lcom/pwrd/android/volley/Request;->mDefaultTrafficStatsTag:I

    goto :goto_1
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 140
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    .local p2, "listener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    const/4 v0, -0x1

    invoke-direct {p0, v0, p1, p2}, Lcom/pwrd/android/volley/Request;-><init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 141
    return-void
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/VolleyLog$MarkerLog;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    return-object v0
.end method

.method private encodeParameters(Ljava/util/Map;Ljava/lang/String;)[B
    .locals 6
    .param p2, "paramsEncoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")[B"
        }
    .end annotation

    .prologue
    .line 437
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 439
    .local v0, "encodedParams":Ljava/lang/StringBuilder;
    :try_start_0
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 445
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    return-object v3

    .line 439
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 440
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3, p2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 441
    const/16 v3, 0x3d

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 442
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3, p2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 443
    const/16 v3, 0x26

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 446
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 447
    .local v2, "uee":Ljava/io/UnsupportedEncodingException;
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Encoding not supported: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method


# virtual methods
.method public addMarker(Ljava/lang/String;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 209
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    sget-boolean v0, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->ENABLED:Z

    if-eqz v0, :cond_1

    .line 210
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v2

    invoke-virtual {v0, p1, v2, v3}, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->add(Ljava/lang/String;J)V

    .line 214
    :cond_0
    :goto_0
    return-void

    .line 211
    :cond_1
    iget-wide v0, p0, Lcom/pwrd/android/volley/Request;->mRequestBirthTime:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 212
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/pwrd/android/volley/Request;->mRequestBirthTime:J

    goto :goto_0
.end method

.method public cancel()V
    .locals 1

    .prologue
    .line 309
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/pwrd/android/volley/Request;->mCanceled:Z

    .line 310
    return-void
.end method

.method public compareTo(Lcom/pwrd/android/volley/Request;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<TT;>;)I"
        }
    .end annotation

    .prologue
    .line 565
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    .local p1, "other":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getPriority()Lcom/pwrd/android/volley/Request$Priority;

    move-result-object v0

    .line 566
    .local v0, "left":Lcom/pwrd/android/volley/Request$Priority;, "Lcom/pwrd/android/volley/Request$Priority;"
    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getPriority()Lcom/pwrd/android/volley/Request$Priority;

    move-result-object v1

    .line 570
    .local v1, "right":Lcom/pwrd/android/volley/Request$Priority;, "Lcom/pwrd/android/volley/Request$Priority;"
    if-ne v0, v1, :cond_0

    .line 571
    iget-object v2, p0, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iget-object v3, p1, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    sub-int/2addr v2, v3

    .line 570
    :goto_0
    return v2

    .line 572
    :cond_0
    invoke-virtual {v1}, Lcom/pwrd/android/volley/Request$Priority;->ordinal()I

    move-result v2

    invoke-virtual {v0}, Lcom/pwrd/android/volley/Request$Priority;->ordinal()I

    move-result v3

    sub-int/2addr v2, v3

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Lcom/pwrd/android/volley/Request;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/Request;->compareTo(Lcom/pwrd/android/volley/Request;)I

    move-result v0

    return v0
.end method

.method public deliverError(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 1
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 554
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mErrorListener:Lcom/pwrd/android/volley/Response$ErrorListener;

    if-eqz v0, :cond_0

    .line 555
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mErrorListener:Lcom/pwrd/android/volley/Response$ErrorListener;

    invoke-interface {v0, p1}, Lcom/pwrd/android/volley/Response$ErrorListener;->onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V

    .line 557
    :cond_0
    return-void
.end method

.method protected abstract deliverResponse(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method finish(Ljava/lang/String;)V
    .locals 10
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 222
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v1, p0, Lcom/pwrd/android/volley/Request;->mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

    if-eqz v1, :cond_0

    .line 223
    iget-object v1, p0, Lcom/pwrd/android/volley/Request;->mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

    invoke-virtual {v1, p0}, Lcom/pwrd/android/volley/RequestQueue;->finish(Lcom/pwrd/android/volley/Request;)V

    .line 225
    :cond_0
    sget-boolean v1, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->ENABLED:Z

    if-eqz v1, :cond_3

    .line 226
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v4

    .line 227
    .local v4, "threadId":J
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    if-eq v1, v6, :cond_2

    .line 230
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 231
    .local v0, "mainThread":Landroid/os/Handler;
    new-instance v1, Lcom/pwrd/android/volley/Request$1;

    invoke-direct {v1, p0, p1, v4, v5}, Lcom/pwrd/android/volley/Request$1;-><init>(Lcom/pwrd/android/volley/Request;Ljava/lang/String;J)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 249
    .end local v0    # "mainThread":Landroid/os/Handler;
    .end local v4    # "threadId":J
    :cond_1
    :goto_0
    return-void

    .line 241
    .restart local v4    # "threadId":J
    :cond_2
    iget-object v1, p0, Lcom/pwrd/android/volley/Request;->mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    invoke-virtual {v1, p1, v4, v5}, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->add(Ljava/lang/String;J)V

    .line 242
    iget-object v1, p0, Lcom/pwrd/android/volley/Request;->mEventLog:Lcom/pwrd/android/volley/VolleyLog$MarkerLog;

    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/pwrd/android/volley/VolleyLog$MarkerLog;->finish(Ljava/lang/String;)V

    goto :goto_0

    .line 244
    .end local v4    # "threadId":J
    :cond_3
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    iget-wide v8, p0, Lcom/pwrd/android/volley/Request;->mRequestBirthTime:J

    sub-long v2, v6, v8

    .line 245
    .local v2, "requestTime":J
    const-wide/16 v6, 0xbb8

    cmp-long v1, v2, v6

    if-ltz v1, :cond_1

    .line 246
    const-string v1, "%d ms: %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v1, v6}, Lcom/pwrd/android/volley/VolleyLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public getBody()[B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 426
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getParams()Ljava/util/Map;

    move-result-object v0

    .line 427
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 428
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getParamsEncoding()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/pwrd/android/volley/Request;->encodeParameters(Ljava/util/Map;Ljava/lang/String;)[B

    move-result-object v1

    .line 430
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getBodyContentType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 417
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "application/x-www-form-urlencoded; charset="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getParamsEncoding()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCacheEntry()Lcom/pwrd/android/volley/Cache$Entry;
    .locals 1

    .prologue
    .line 302
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mCacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

    return-object v0
.end method

.method public getCacheKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 287
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 327
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getMethod()I
    .locals 1

    .prologue
    .line 171
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget v0, p0, Lcom/pwrd/android/volley/Request;->mMethod:I

    return v0
.end method

.method protected getParams()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 397
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getParamsEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 413
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    const-string v0, "UTF-8"

    return-object v0
.end method

.method public getPostBody()[B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 381
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getPostParams()Ljava/util/Map;

    move-result-object v0

    .line 382
    .local v0, "postParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 383
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getPostParamsEncoding()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/pwrd/android/volley/Request;->encodeParameters(Ljava/util/Map;Ljava/lang/String;)[B

    move-result-object v1

    .line 385
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPostBodyContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 367
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getBodyContentType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getPostParams()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 342
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getParams()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method protected getPostParamsEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 360
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getParamsEncoding()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPriority()Lcom/pwrd/android/volley/Request$Priority;
    .locals 1

    .prologue
    .line 480
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    sget-object v0, Lcom/pwrd/android/volley/Request$Priority;->NORMAL:Lcom/pwrd/android/volley/Request$Priority;

    return-object v0
.end method

.method public getRetryPolicy()Lcom/pwrd/android/volley/RetryPolicy;
    .locals 1

    .prologue
    .line 496
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mRetryPolicy:Lcom/pwrd/android/volley/RetryPolicy;

    return-object v0
.end method

.method public final getSequence()I
    .locals 2

    .prologue
    .line 270
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 271
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "getSequence called before setSequence"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 273
    :cond_0
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getTag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 188
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mTag:Ljava/lang/Object;

    return-object v0
.end method

.method public final getTimeoutMs()I
    .locals 1

    .prologue
    .line 489
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mRetryPolicy:Lcom/pwrd/android/volley/RetryPolicy;

    invoke-interface {v0}, Lcom/pwrd/android/volley/RetryPolicy;->getCurrentTimeout()I

    move-result v0

    return v0
.end method

.method public getTrafficStatsTag()I
    .locals 1

    .prologue
    .line 195
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget v0, p0, Lcom/pwrd/android/volley/Request;->mDefaultTrafficStatsTag:I

    return v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Request;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public hasHadResponseDelivered()Z
    .locals 1

    .prologue
    .line 511
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-boolean v0, p0, Lcom/pwrd/android/volley/Request;->mResponseDelivered:Z

    return v0
.end method

.method public isCanceled()Z
    .locals 1

    .prologue
    .line 316
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-boolean v0, p0, Lcom/pwrd/android/volley/Request;->mCanceled:Z

    return v0
.end method

.method public markDelivered()V
    .locals 1

    .prologue
    .line 504
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/pwrd/android/volley/Request;->mResponseDelivered:Z

    .line 505
    return-void
.end method

.method protected parseNetworkError(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/VolleyError;
    .locals 0
    .param p1, "volleyError"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 534
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    return-object p1
.end method

.method protected abstract parseNetworkResponse(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Response;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/NetworkResponse;",
            ")",
            "Lcom/pwrd/android/volley/Response",
            "<TT;>;"
        }
    .end annotation
.end method

.method public setCacheEntry(Lcom/pwrd/android/volley/Cache$Entry;)V
    .locals 0
    .param p1, "entry"    # Lcom/pwrd/android/volley/Cache$Entry;

    .prologue
    .line 295
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iput-object p1, p0, Lcom/pwrd/android/volley/Request;->mCacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

    .line 296
    return-void
.end method

.method public setRequestQueue(Lcom/pwrd/android/volley/RequestQueue;)V
    .locals 0
    .param p1, "requestQueue"    # Lcom/pwrd/android/volley/RequestQueue;

    .prologue
    .line 256
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iput-object p1, p0, Lcom/pwrd/android/volley/Request;->mRequestQueue:Lcom/pwrd/android/volley/RequestQueue;

    .line 257
    return-void
.end method

.method public setRetryPolicy(Lcom/pwrd/android/volley/RetryPolicy;)V
    .locals 0
    .param p1, "retryPolicy"    # Lcom/pwrd/android/volley/RetryPolicy;

    .prologue
    .line 202
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iput-object p1, p0, Lcom/pwrd/android/volley/Request;->mRetryPolicy:Lcom/pwrd/android/volley/RetryPolicy;

    .line 203
    return-void
.end method

.method public final setSequence(I)V
    .locals 1
    .param p1, "sequence"    # I

    .prologue
    .line 263
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    .line 264
    return-void
.end method

.method public final setShouldCache(Z)V
    .locals 0
    .param p1, "shouldCache"    # Z

    .prologue
    .line 455
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iput-boolean p1, p0, Lcom/pwrd/android/volley/Request;->mShouldCache:Z

    .line 456
    return-void
.end method

.method public setTag(Ljava/lang/Object;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/Object;

    .prologue
    .line 179
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iput-object p1, p0, Lcom/pwrd/android/volley/Request;->mTag:Ljava/lang/Object;

    .line 180
    return-void
.end method

.method public final shouldCache()Z
    .locals 1

    .prologue
    .line 462
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    iget-boolean v0, p0, Lcom/pwrd/android/volley/Request;->mShouldCache:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 577
    .local p0, "this":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<TT;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "0x"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getTrafficStatsTag()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 578
    .local v0, "trafficStatsTag":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    iget-boolean v1, p0, Lcom/pwrd/android/volley/Request;->mCanceled:Z

    if-eqz v1, :cond_0

    const-string v1, "[X] "

    :goto_0
    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 579
    invoke-virtual {p0}, Lcom/pwrd/android/volley/Request;->getPriority()Lcom/pwrd/android/volley/Request$Priority;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/pwrd/android/volley/Request;->mSequence:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 578
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_0
    const-string v1, "[ ] "

    goto :goto_0
.end method
