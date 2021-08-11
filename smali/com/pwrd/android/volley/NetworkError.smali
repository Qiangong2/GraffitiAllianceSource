.class public Lcom/pwrd/android/volley/NetworkError;
.super Lcom/pwrd/android/volley/VolleyError;
.source "NetworkError.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/pwrd/android/volley/VolleyError;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(Lcom/pwrd/android/volley/NetworkResponse;)V
    .locals 0
    .param p1, "networkResponse"    # Lcom/pwrd/android/volley/NetworkResponse;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/VolleyError;-><init>(Lcom/pwrd/android/volley/NetworkResponse;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/VolleyError;-><init>(Ljava/lang/Throwable;)V

    .line 33
    return-void
.end method
