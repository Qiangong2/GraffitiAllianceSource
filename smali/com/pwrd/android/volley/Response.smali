.class public Lcom/pwrd/android/volley/Response;
.super Ljava/lang/Object;
.source "Response.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/Response$ErrorListener;,
        Lcom/pwrd/android/volley/Response$Listener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field public final cacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

.field public final error:Lcom/pwrd/android/volley/VolleyError;

.field public intermediate:Z

.field public final result:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 2
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .local p0, "this":Lcom/pwrd/android/volley/Response;, "Lcom/pwrd/android/volley/Response<TT;>;"
    const/4 v1, 0x0

    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/pwrd/android/volley/Response;->intermediate:Z

    .line 81
    iput-object v1, p0, Lcom/pwrd/android/volley/Response;->result:Ljava/lang/Object;

    .line 82
    iput-object v1, p0, Lcom/pwrd/android/volley/Response;->cacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

    .line 83
    iput-object p1, p0, Lcom/pwrd/android/volley/Response;->error:Lcom/pwrd/android/volley/VolleyError;

    .line 84
    return-void
.end method

.method private constructor <init>(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)V
    .locals 1
    .param p2, "cacheEntry"    # Lcom/pwrd/android/volley/Cache$Entry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/pwrd/android/volley/Cache$Entry;",
            ")V"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "this":Lcom/pwrd/android/volley/Response;, "Lcom/pwrd/android/volley/Response<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/pwrd/android/volley/Response;->intermediate:Z

    .line 75
    iput-object p1, p0, Lcom/pwrd/android/volley/Response;->result:Ljava/lang/Object;

    .line 76
    iput-object p2, p0, Lcom/pwrd/android/volley/Response;->cacheEntry:Lcom/pwrd/android/volley/Cache$Entry;

    .line 77
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pwrd/android/volley/Response;->error:Lcom/pwrd/android/volley/VolleyError;

    .line 78
    return-void
.end method

.method public static error(Lcom/pwrd/android/volley/VolleyError;)Lcom/pwrd/android/volley/Response;
    .locals 1
    .param p0, "error"    # Lcom/pwrd/android/volley/VolleyError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/android/volley/VolleyError;",
            ")",
            "Lcom/pwrd/android/volley/Response",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 51
    new-instance v0, Lcom/pwrd/android/volley/Response;

    invoke-direct {v0, p0}, Lcom/pwrd/android/volley/Response;-><init>(Lcom/pwrd/android/volley/VolleyError;)V

    return-object v0
.end method

.method public static success(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)Lcom/pwrd/android/volley/Response;
    .locals 1
    .param p1, "cacheEntry"    # Lcom/pwrd/android/volley/Cache$Entry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Lcom/pwrd/android/volley/Cache$Entry;",
            ")",
            "Lcom/pwrd/android/volley/Response",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "result":Ljava/lang/Object;, "TT;"
    new-instance v0, Lcom/pwrd/android/volley/Response;

    invoke-direct {v0, p0, p1}, Lcom/pwrd/android/volley/Response;-><init>(Ljava/lang/Object;Lcom/pwrd/android/volley/Cache$Entry;)V

    return-object v0
.end method


# virtual methods
.method public isSuccess()Z
    .locals 1

    .prologue
    .line 70
    .local p0, "this":Lcom/pwrd/android/volley/Response;, "Lcom/pwrd/android/volley/Response<TT;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/Response;->error:Lcom/pwrd/android/volley/VolleyError;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
