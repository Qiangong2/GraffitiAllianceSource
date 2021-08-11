.class public abstract Lcom/pwrd/android/volley/plus/RequestPro;
.super Lcom/pwrd/android/volley/Request;
.source "RequestPro.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/pwrd/android/volley/Request",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private params:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private successListener:Lcom/pwrd/android/volley/Response$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/util/Map;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 0
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 29
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p4, "successListener":Lcom/pwrd/android/volley/Response$Listener;, "Lcom/pwrd/android/volley/Response$Listener<TT;>;"
    .local p5, "errorListener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    invoke-direct {p0, p1, p2, p5}, Lcom/pwrd/android/volley/Request;-><init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 30
    iput-object p4, p0, Lcom/pwrd/android/volley/plus/RequestPro;->successListener:Lcom/pwrd/android/volley/Response$Listener;

    .line 31
    iput-object p3, p0, Lcom/pwrd/android/volley/plus/RequestPro;->params:Ljava/util/Map;

    .line 32
    return-void
.end method

.method protected static getEncodedParameters(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "paramsEncoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 134
    .local p0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Map;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 135
    :cond_0
    const-string v3, ""

    .line 146
    :goto_0
    return-object v3

    .line 136
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 138
    .local v0, "encodedParams":Ljava/lang/StringBuilder;
    :try_start_0
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_3

    .line 146
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 138
    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 139
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 141
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3, p1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 142
    const/16 v3, 0x3d

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 143
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3, p1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    const/16 v3, 0x26

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 147
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 148
    .local v2, "uee":Ljava/io/UnsupportedEncodingException;
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Encoding not supported: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method private mergeGetUrl()Ljava/lang/String;
    .locals 4

    .prologue
    .line 35
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    invoke-super {p0}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "url":Ljava/lang/String;
    const-string v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 37
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/RequestPro;->params:Ljava/util/Map;

    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParamsEncoding()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/pwrd/android/volley/plus/RequestPro;->getEncodedParameters(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 39
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-super {p0}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/RequestPro;->params:Ljava/util/Map;

    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParamsEncoding()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/pwrd/android/volley/plus/RequestPro;->getEncodedParameters(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method protected deliverResponse(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    .local p1, "response":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/RequestPro;->successListener:Lcom/pwrd/android/volley/Response$Listener;

    invoke-interface {v0, p1}, Lcom/pwrd/android/volley/Response$Listener;->onResponse(Ljava/lang/Object;)V

    .line 82
    return-void
.end method

.method public getBody()[B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 122
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParams()Ljava/util/Map;

    move-result-object v0

    .line 123
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParamsEncoding()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/pwrd/android/volley/plus/RequestPro;->getEncodedParameters(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    .line 126
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getCacheKey()Ljava/lang/String;
    .locals 4

    .prologue
    .line 107
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParams()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getParamsEncoding()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/pwrd/android/volley/plus/RequestPro;->getEncodedParameters(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lcom/pwrd/android/volley/AuthFailureError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 110
    :goto_0
    return-object v1

    .line 108
    :catch_0
    move-exception v0

    .line 109
    .local v0, "authFailureError":Lcom/pwrd/android/volley/AuthFailureError;
    invoke-virtual {v0}, Lcom/pwrd/android/volley/AuthFailureError;->printStackTrace()V

    .line 110
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getUrl()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
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
    .line 98
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/RequestPro;->params:Ljava/util/Map;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->getMethod()I

    move-result v0

    if-nez v0, :cond_0

    .line 50
    invoke-direct {p0}, Lcom/pwrd/android/volley/plus/RequestPro;->mergeGetUrl()Ljava/lang/String;

    move-result-object v0

    .line 52
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Lcom/pwrd/android/volley/Request;->getUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected parseNetworkResponse(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Response;
    .locals 1
    .param p1, "response"    # Lcom/pwrd/android/volley/NetworkResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/NetworkResponse;",
            ")",
            "Lcom/pwrd/android/volley/Response",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 67
    .local p0, "this":Lcom/pwrd/android/volley/plus/RequestPro;, "Lcom/pwrd/android/volley/plus/RequestPro<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method
