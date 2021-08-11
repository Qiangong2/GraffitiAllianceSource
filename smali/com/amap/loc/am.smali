.class public Lcom/amap/loc/am;
.super Ljava/lang/Object;
.source "SDKDBOperation.java"


# instance fields
.field private a:Lcom/amap/loc/ac;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Z)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amap/loc/am;->b:Landroid/content/Context;

    iget-object v0, p0, Lcom/amap/loc/am;->b:Landroid/content/Context;

    invoke-direct {p0, v0, p2}, Lcom/amap/loc/am;->a(Landroid/content/Context;Z)Lcom/amap/loc/ac;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    return-void
.end method

.method private a(Landroid/content/Context;Z)Lcom/amap/loc/ac;
    .locals 4

    const/4 v1, 0x0

    :try_start_0
    new-instance v0, Lcom/amap/loc/ac;

    const-class v2, Lcom/amap/loc/aj;

    invoke-static {v2}, Lcom/amap/loc/ac;->a(Ljava/lang/Class;)Lcom/amap/loc/ab;

    move-result-object v2

    invoke-direct {v0, p1, v2}, Lcom/amap/loc/ac;-><init>(Landroid/content/Context;Lcom/amap/loc/ab;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    if-nez p2, :cond_0

    const-string v2, "SDKDB"

    const-string v3, "getDB"

    invoke-static {v0, v2, v3}, Lcom/amap/loc/t;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amap/loc/q;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Lcom/amap/loc/q;->f()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    const-class v3, Lcom/amap/loc/q;

    const/4 v4, 0x1

    invoke-virtual {v2, v1, v3, v4}, Lcom/amap/loc/ac;->a(Ljava/lang/String;Ljava/lang/Class;Z)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0
.end method

.method public a(Lcom/amap/loc/q;)V
    .locals 3

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/am;->b:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amap/loc/am;->a(Landroid/content/Context;Z)Lcom/amap/loc/ac;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    :cond_1
    invoke-virtual {p1}, Lcom/amap/loc/q;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amap/loc/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    const-class v2, Lcom/amap/loc/q;

    invoke-virtual {v1, v0, v2}, Lcom/amap/loc/ac;->b(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    iget-object v0, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    invoke-virtual {v0, p1}, Lcom/amap/loc/ac;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "SDKDB"

    const-string v2, "insert"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/t;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0

    :cond_3
    :try_start_1
    iget-object v1, p0, Lcom/amap/loc/am;->a:Lcom/amap/loc/ac;

    invoke-virtual {v1, v0, p1}, Lcom/amap/loc/ac;->a(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
