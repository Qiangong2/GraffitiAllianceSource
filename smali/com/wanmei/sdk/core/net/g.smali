.class public Lcom/wanmei/sdk/core/net/g;
.super Lcom/pwrd/android/volley/plus/RequestPro;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/net/g$b;,
        Lcom/wanmei/sdk/core/net/g$a;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/pwrd/android/volley/plus/RequestPro",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private b:Lcom/wanmei/sdk/core/net/g$b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/wanmei/sdk/core/net/g$b",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILjava/lang/String;ZLjava/util/Map;Lcom/wanmei/sdk/core/bean/CommReq;Ljava/lang/Class;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;Ljava/lang/Class;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Z",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/wanmei/sdk/core/bean/CommReq;",
            "Ljava/lang/Class;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p7

    move-object v5, p8

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/plus/RequestPro;-><init>(ILjava/lang/String;Ljava/util/Map;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    const-string v0, "Request"

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/g;->a:Ljava/lang/String;

    new-instance v0, Lcom/wanmei/sdk/core/net/g$b;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/net/g$b;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p3}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Z)Z

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p9}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p4}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Ljava/util/Map;)Ljava/util/Map;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;I)I

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p2}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p7}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$Listener;)Lcom/pwrd/android/volley/Response$Listener;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p8}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$ErrorListener;)Lcom/pwrd/android/volley/Response$ErrorListener;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p6}, Lcom/wanmei/sdk/core/net/g$b;->b(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p5}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/wanmei/sdk/core/bean/CommReq;)Lcom/wanmei/sdk/core/bean/CommReq;

    return-void
.end method


# virtual methods
.method public getBody()[B
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/AuthFailureError;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->f(Lcom/wanmei/sdk/core/net/g$b;)Lcom/wanmei/sdk/core/bean/CommReq;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/net/g$b;->e(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v1

    new-instance v2, Lcom/pwrd/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/pwrd/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/pwrd/google/gson/GsonBuilder;->excludeFieldsWithoutExposeAnnotation()Lcom/pwrd/google/gson/GsonBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/pwrd/google/gson/GsonBuilder;->create()Lcom/pwrd/google/gson/Gson;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :cond_0
    const-string v1, "Request"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "request body: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/net/g$b;->h(Lcom/wanmei/sdk/core/net/g$b;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x10

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/d;->a(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    :cond_1
    const-string v1, "Request"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "request body encrypt: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_0
    const-string v1, "UTF-8"

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Request"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "UnsupportedEncodingException at getBody:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCacheKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaders()Ljava/util/Map;
    .locals 5
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

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->j(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/HashMap;

    move-result-object v0

    const-string v1, "appId"

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->j(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, "Request"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "--------> "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v4}, Lcom/wanmei/sdk/core/net/g$b;->j(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->j(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method protected parseNetworkError(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/VolleyError;
    .locals 2
    .param p1, "volleyError"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/net/g;, "Lcom/wanmei/sdk/core/net/g<TT;>;"
    invoke-virtual {p1}, Lcom/pwrd/android/volley/VolleyError;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/pwrd/android/volley/VolleyError;->getMessage()Ljava/lang/String;

    move-result-object v0

    const-string v1, "empty"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/pwrd/android/volley/VolleyError;

    invoke-direct {v0}, Lcom/pwrd/android/volley/VolleyError;-><init>()V

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1}, Lcom/pwrd/android/volley/plus/RequestPro;->parseNetworkError(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/VolleyError;

    move-result-object v0

    goto :goto_0
.end method

.method protected parseNetworkResponse(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Response;
    .locals 4
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
    .local p0, "this":Lcom/wanmei/sdk/core/net/g;, "Lcom/wanmei/sdk/core/net/g<TT;>;"
    :try_start_0
    new-instance v0, Ljava/lang/String;

    iget-object v1, p1, Lcom/pwrd/android/volley/NetworkResponse;->data:[B

    iget-object v2, p1, Lcom/pwrd/android/volley/NetworkResponse;->headers:Ljava/util/Map;

    invoke-static {v2}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCharset(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    const-string v1, "Request"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "resp String:\n"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/net/g$b;->h(Lcom/wanmei/sdk/core/net/g$b;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x10

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-static {v0, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/d;->a([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    new-instance v0, Lcom/pwrd/android/volley/VolleyError;

    const-string v1, "empty"

    invoke-direct {v0, v1}, Lcom/pwrd/android/volley/VolleyError;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/pwrd/android/volley/Response;->error(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/Response;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_1
    const-string v1, "Request"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "resp String decrypt:\n"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/pwrd/google/gson/Gson;

    invoke-direct {v1}, Lcom/pwrd/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/wanmei/sdk/core/net/g;->b:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v2}, Lcom/wanmei/sdk/core/net/g$b;->d(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/pwrd/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {p1}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCacheHeaders(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Cache$Entry;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/pwrd/android/volley/Response;->success(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)Lcom/pwrd/android/volley/Response;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/pwrd/android/volley/ParseError;

    invoke-direct {v1, v0}, Lcom/pwrd/android/volley/ParseError;-><init>(Ljava/lang/Throwable;)V

    invoke-static {v1}, Lcom/pwrd/android/volley/Response;->error(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/Response;

    move-result-object v0

    goto :goto_0
.end method
