.class public abstract Lcom/tencent/qcloud/core/task/CancelableTask;
.super Lcom/tencent/qcloud/core/task/Task;
.source "CancelableTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/tencent/qcloud/core/task/Task",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private canceled:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "tag"    # Ljava/lang/Object;

    .prologue
    .line 19
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/tencent/qcloud/core/task/Task;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    .line 20
    return-void
.end method


# virtual methods
.method public final declared-synchronized cancel()V
    .locals 4

    .prologue
    .line 62
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->canceled:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->completed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    .line 74
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 66
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->onCancel()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->workerExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    if-eqz v0, :cond_2

    .line 68
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->workerExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ThreadPoolExecutor;->remove(Ljava/lang/Runnable;)Z

    .line 70
    :cond_2
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->close()V

    .line 71
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->canceled:Z

    .line 72
    const-string v0, "QCloudTask"

    const-string v1, "[Call] %s cancel"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 62
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isCanceled()Z
    .locals 1

    .prologue
    .line 58
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/CancelableTask;->canceled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected abstract onCancel()Z
.end method

.method protected onFailure()V
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 53
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-super {p0}, Lcom/tencent/qcloud/core/task/Task;->onFailure()V

    goto :goto_0
.end method

.method protected onProgress(JJ)V
    .locals 1
    .param p1, "complete"    # J
    .param p3, "target"    # J

    .prologue
    .line 33
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    :goto_0
    return-void

    .line 36
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lcom/tencent/qcloud/core/task/Task;->onProgress(JJ)V

    goto :goto_0
.end method

.method protected onSuccess()V
    .locals 1

    .prologue
    .line 41
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    :goto_0
    return-void

    .line 44
    :cond_0
    invoke-super {p0}, Lcom/tencent/qcloud/core/task/Task;->onSuccess()V

    goto :goto_0
.end method

.method public run()V
    .locals 1

    .prologue
    .line 24
    .local p0, "this":Lcom/tencent/qcloud/core/task/CancelableTask;, "Lcom/tencent/qcloud/core/task/CancelableTask<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/CancelableTask;->isCanceled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 29
    :goto_0
    return-void

    .line 28
    :cond_0
    invoke-super {p0}, Lcom/tencent/qcloud/core/task/Task;->run()V

    goto :goto_0
.end method
