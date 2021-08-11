.class public Lcom/amap/loc/bf;
.super Ljava/lang/Object;
.source "BaseNetManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/loc/bf$a;
    }
.end annotation


# static fields
.field private static a:Lcom/amap/loc/bf;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/amap/loc/bf;
    .locals 1

    sget-object v0, Lcom/amap/loc/bf;->a:Lcom/amap/loc/bf;

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/loc/bf;

    invoke-direct {v0}, Lcom/amap/loc/bf;-><init>()V

    sput-object v0, Lcom/amap/loc/bf;->a:Lcom/amap/loc/bf;

    :cond_0
    sget-object v0, Lcom/amap/loc/bf;->a:Lcom/amap/loc/bf;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/amap/loc/bk;Z)Lcom/amap/loc/bl;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amap/loc/h;
        }
    .end annotation

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amap/loc/bf;->b(Lcom/amap/loc/bk;)V

    iget-object v0, p1, Lcom/amap/loc/bk;->e:Ljava/net/Proxy;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    new-instance v1, Lcom/amap/loc/bi;

    iget v2, p1, Lcom/amap/loc/bk;->c:I

    iget v3, p1, Lcom/amap/loc/bk;->d:I

    invoke-direct {v1, v2, v3, v0, p2}, Lcom/amap/loc/bi;-><init>(IILjava/net/Proxy;Z)V

    invoke-virtual {p1}, Lcom/amap/loc/bk;->i()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amap/loc/bk;->a()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amap/loc/bk;->j()[B

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/amap/loc/bi;->a(Ljava/lang/String;Ljava/util/Map;[B)Lcom/amap/loc/bl;

    move-result-object v0

    return-object v0

    :cond_0
    iget-object v0, p1, Lcom/amap/loc/bk;->e:Ljava/net/Proxy;
    :try_end_0
    .catch Lcom/amap/loc/h; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    :catch_0
    move-exception v0

    throw v0

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    new-instance v0, Lcom/amap/loc/h;

    const-string v1, "\u672a\u77e5\u7684\u9519\u8bef"

    invoke-direct {v0, v1}, Lcom/amap/loc/h;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Lcom/amap/loc/bk;)[B
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amap/loc/h;
        }
    .end annotation

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, p1, v0}, Lcom/amap/loc/bf;->a(Lcom/amap/loc/bk;Z)Lcom/amap/loc/bl;
    :try_end_0
    .catch Lcom/amap/loc/h; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, v0, Lcom/amap/loc/bl;->a:[B

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    throw v0

    :catch_1
    move-exception v0

    const-string v1, "BaseNetManager"

    const-string v2, "makeSyncPostRequest"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/t;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/amap/loc/h;

    const-string v1, "\u672a\u77e5\u7684\u9519\u8bef"

    invoke-direct {v0, v1}, Lcom/amap/loc/h;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected b(Lcom/amap/loc/bk;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amap/loc/h;
        }
    .end annotation

    if-nez p1, :cond_0

    new-instance v0, Lcom/amap/loc/h;

    const-string v1, "requeust is null"

    invoke-direct {v0, v1}, Lcom/amap/loc/h;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/amap/loc/bk;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    const-string v0, ""

    invoke-virtual {p1}, Lcom/amap/loc/bk;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    new-instance v0, Lcom/amap/loc/h;

    const-string v1, "request url is empty"

    invoke-direct {v0, v1}, Lcom/amap/loc/h;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    return-void
.end method
