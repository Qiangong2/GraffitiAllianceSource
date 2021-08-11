.class public Lcom/wanmei/sdk/core/net/g$a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/net/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
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
.field private a:Lcom/wanmei/sdk/core/net/g$b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/wanmei/sdk/core/net/g$b",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/wanmei/sdk/core/net/g$b;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/net/g$b;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    return-void
.end method


# virtual methods
.method public a()Lcom/wanmei/sdk/core/net/g$a;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Z)Z

    return-object p0
.end method

.method public a(Lcom/pwrd/android/volley/Response$ErrorListener;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Response$ErrorListener;",
            ")",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$ErrorListener;)Lcom/pwrd/android/volley/Response$ErrorListener;

    return-object p0
.end method

.method public a(Lcom/pwrd/android/volley/Response$Listener;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;)",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$Listener;)Lcom/pwrd/android/volley/Response$Listener;

    return-object p0
.end method

.method public a(Lcom/wanmei/sdk/core/bean/CommReq;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wanmei/sdk/core/bean/CommReq;",
            ")",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Lcom/wanmei/sdk/core/bean/CommReq;)Lcom/wanmei/sdk/core/bean/CommReq;

    return-object p0
.end method

.method public a(Ljava/lang/Class;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;

    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/String;)Ljava/lang/String;

    return-object p0
.end method

.method public b()Lcom/wanmei/sdk/core/net/g$a;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;I)I

    return-object p0
.end method

.method public b(Ljava/lang/Class;)Lcom/wanmei/sdk/core/net/g$a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class;",
            ")",
            "Lcom/wanmei/sdk/core/net/g$a",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0, p1}, Lcom/wanmei/sdk/core/net/g$b;->b(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;

    return-object p0
.end method

.method public c()Lcom/wanmei/sdk/core/net/g;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/sdk/core/net/g",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "url not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->b(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$Listener;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "successListener not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->c(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$ErrorListener;

    move-result-object v0

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "errorListener not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->d(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v0

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "responseClass not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->e(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v0

    if-nez v0, :cond_4

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "requestBodyType not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v0}, Lcom/wanmei/sdk/core/net/g$b;->f(Lcom/wanmei/sdk/core/net/g$b;)Lcom/wanmei/sdk/core/bean/CommReq;

    move-result-object v0

    if-nez v0, :cond_5

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "requestBody not set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    new-instance v0, Lcom/wanmei/sdk/core/net/g;

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v1}, Lcom/wanmei/sdk/core/net/g$b;->g(Lcom/wanmei/sdk/core/net/g$b;)I

    move-result v1

    iget-object v2, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v2}, Lcom/wanmei/sdk/core/net/g$b;->a(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v3}, Lcom/wanmei/sdk/core/net/g$b;->h(Lcom/wanmei/sdk/core/net/g$b;)Z

    move-result v3

    iget-object v4, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v4}, Lcom/wanmei/sdk/core/net/g$b;->i(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/Map;

    move-result-object v4

    iget-object v5, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v5}, Lcom/wanmei/sdk/core/net/g$b;->f(Lcom/wanmei/sdk/core/net/g$b;)Lcom/wanmei/sdk/core/bean/CommReq;

    move-result-object v5

    iget-object v6, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v6}, Lcom/wanmei/sdk/core/net/g$b;->e(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v6

    iget-object v7, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v7}, Lcom/wanmei/sdk/core/net/g$b;->b(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$Listener;

    move-result-object v7

    iget-object v8, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v8}, Lcom/wanmei/sdk/core/net/g$b;->c(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$ErrorListener;

    move-result-object v8

    iget-object v9, p0, Lcom/wanmei/sdk/core/net/g$a;->a:Lcom/wanmei/sdk/core/net/g$b;

    invoke-static {v9}, Lcom/wanmei/sdk/core/net/g$b;->d(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lcom/wanmei/sdk/core/net/g;-><init>(ILjava/lang/String;ZLjava/util/Map;Lcom/wanmei/sdk/core/bean/CommReq;Ljava/lang/Class;Lcom/pwrd/android/volley/Response$Listener;Lcom/pwrd/android/volley/Response$ErrorListener;Ljava/lang/Class;)V

    return-object v0
.end method
