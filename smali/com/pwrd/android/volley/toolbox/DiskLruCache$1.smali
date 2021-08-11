.class Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/DiskLruCache;
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
.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;


# direct methods
.method constructor <init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    .line 247
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 249
    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    monitor-enter v1

    .line 250
    :try_start_0
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$0(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)Ljava/io/Writer;

    move-result-object v0

    if-nez v0, :cond_0

    .line 251
    monitor-exit v1

    .line 259
    :goto_0
    return-object v3

    .line 253
    :cond_0
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$1(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V

    .line 254
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$2(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 255
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$3(Lcom/pwrd/android/volley/toolbox/DiskLruCache;)V

    .line 256
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$1;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$4(Lcom/pwrd/android/volley/toolbox/DiskLruCache;I)V

    .line 249
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
