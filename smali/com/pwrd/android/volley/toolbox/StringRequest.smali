.class public Lcom/pwrd/android/volley/toolbox/StringRequest;
.super Lcom/pwrd/android/volley/Request;
.source "StringRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/android/volley/Request",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private final mListener:Lcom/pwrd/android/volley/Response$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/android/volley/Response$Listener",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 0
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 43
    .local p3, "listener":Lcom/pwrd/android/volley/Response$Listener;, "Lcom/pwrd/android/volley/Response$Listener<Ljava/lang/String;>;"
    .local p4, "errorListener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    invoke-direct {p0, p1, p2, p4}, Lcom/pwrd/android/volley/Request;-><init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 44
    iput-object p3, p0, Lcom/pwrd/android/volley/toolbox/StringRequest;->mListener:Lcom/pwrd/android/volley/Response$Listener;

    .line 45
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 55
    .local p2, "listener":Lcom/pwrd/android/volley/Response$Listener;, "Lcom/pwrd/android/volley/Response$Listener<Ljava/lang/String;>;"
    .local p3, "errorListener":Lcom/pwrd/android/volley/Response$ErrorListener;, "Lcom/pwrd/android/volley/Response$ErrorListener;"
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/pwrd/android/volley/toolbox/StringRequest;-><init>(ILjava/lang/String;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;)V

    .line 56
    return-void
.end method


# virtual methods
.method protected bridge synthetic deliverResponse(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/toolbox/StringRequest;->deliverResponse(Ljava/lang/String;)V

    return-void
.end method

.method protected deliverResponse(Ljava/lang/String;)V
    .locals 1
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/StringRequest;->mListener:Lcom/pwrd/android/volley/Response$Listener;

    invoke-interface {v0, p1}, Lcom/pwrd/android/volley/Response$Listener;->onResponse(Ljava/lang/Object;)V

    .line 61
    return-void
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
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    :try_start_0
    new-instance v1, Ljava/lang/String;

    iget-object v2, p1, Lcom/pwrd/android/volley/NetworkResponse;->data:[B

    iget-object v3, p1, Lcom/pwrd/android/volley/NetworkResponse;->headers:Ljava/util/Map;

    invoke-static {v3}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCharset(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    .local v1, "parsed":Ljava/lang/String;
    :goto_0
    invoke-static {p1}, Lcom/pwrd/android/volley/toolbox/HttpHeaderParser;->parseCacheHeaders(Lcom/pwrd/android/volley/NetworkResponse;)Lcom/pwrd/android/volley/Cache$Entry;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/pwrd/android/volley/Response;->success(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)Lcom/pwrd/android/volley/Response;

    move-result-object v2

    return-object v2

    .line 68
    .end local v1    # "parsed":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 69
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/String;

    iget-object v2, p1, Lcom/pwrd/android/volley/NetworkResponse;->data:[B

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([B)V

    .restart local v1    # "parsed":Ljava/lang/String;
    goto :goto_0
.end method
