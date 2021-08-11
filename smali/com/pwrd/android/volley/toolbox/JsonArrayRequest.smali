.class public Lcom/pwrd/android/volley/toolbox/JsonArrayRequest;
.super Lcom/pwrd/android/volley/toolbox/JsonRequest;
.source "JsonArrayRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/android/volley/toolbox/JsonRequest",
        "<",
        "Lorg/json/JSONArray;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<",
            "Lorg/json/JSONArray;",
            ">;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "listener":Lcom/pwrd/android/volley/Response$Listener;, "Lcom/pwrd/android/volley/Response$Listener<Lorg/json/JSONArray;>;"
    .local p3, "errorListener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    const/4 v1, 0x0

    const/4 v3, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/android/volley/toolbox/JsonRequest;-><init>(ILjava/lang/String;Ljava/lang/String;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 43
    return-void
.end method


# virtual methods
.method protected parseNetworkResponse(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Response;
    .locals 5
    .param p1, "response"    # Lcom/pwrd/android/volley/NetworkResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/NetworkResponse;",
            ")",
            "Lcom/pwrd/android/volley/Response",
            "<",
            "Lorg/json/JSONArray;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    :try_start_0
    new-instance v2, Ljava/lang/String;

    iget-object v3, p1, Lcom/pwrd/android/volley/NetworkResponse;->data:[B

    iget-object v4, p1, Lcom/pwrd/android/volley/NetworkResponse;->headers:Ljava/util/Map;

    invoke-static {v4}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCharset(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 50
    .local v2, "jsonString":Ljava/lang/String;
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3, v2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 51
    invoke-static {p1}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCacheHeaders(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Cache$Entry;

    move-result-object v4

    .line 50
    invoke-static {v3, v4}, Lcom/pwrd/android/volley/Response;->success(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)Lcom/pwrd/android/volley/Response;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 55
    .end local v2    # "jsonString":Ljava/lang/String;
    :goto_0
    return-object v3

    .line 52
    :catch_0
    move-exception v0

    .line 53
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v3, Lcom/pwrd/android/volley/ParseError;

    invoke-direct {v3, v0}, Lcom/pwrd/android/volley/ParseError;-><init>(Ljava/lang/Throwable;)V

    invoke-static {v3}, Lcom/pwrd/android/volley/Response;->error(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/Response;

    move-result-object v3

    goto :goto_0

    .line 54
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_1
    move-exception v1

    .line 55
    .local v1, "je":Lorg/json/JSONException;
    new-instance v3, Lcom/pwrd/android/volley/ParseError;

    invoke-direct {v3, v1}, Lcom/pwrd/android/volley/ParseError;-><init>(Ljava/lang/Throwable;)V

    invoke-static {v3}, Lcom/pwrd/android/volley/Response;->error(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/Response;

    move-result-object v3

    goto :goto_0
.end method
