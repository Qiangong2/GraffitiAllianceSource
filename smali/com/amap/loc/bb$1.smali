.class Lcom/amap/loc/bb$1;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/loc/bb;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/amap/loc/bb;


# direct methods
.method constructor <init>(Lcom/amap/loc/bb;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Void;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v3, 0x0

    iget-object v1, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    invoke-static {v0}, Lcom/amap/loc/bb;->a(Lcom/amap/loc/bb;)Ljava/io/Writer;

    move-result-object v0

    if-nez v0, :cond_0

    monitor-exit v1

    :goto_0
    return-object v3

    :cond_0
    iget-object v0, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    invoke-static {v0}, Lcom/amap/loc/bb;->b(Lcom/amap/loc/bb;)V

    iget-object v0, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    invoke-static {v0}, Lcom/amap/loc/bb;->c(Lcom/amap/loc/bb;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    invoke-static {v0}, Lcom/amap/loc/bb;->d(Lcom/amap/loc/bb;)V

    iget-object v0, p0, Lcom/amap/loc/bb$1;->a:Lcom/amap/loc/bb;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/amap/loc/bb;->a(Lcom/amap/loc/bb;I)I

    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amap/loc/bb$1;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
