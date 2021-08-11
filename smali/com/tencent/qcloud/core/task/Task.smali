.class public abstract Lcom/tencent/qcloud/core/task/Task;
.super Ljava/lang/Object;
.source "Task.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field protected clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

.field private closed:Z

.field protected completed:Z

.field protected executed:Z

.field private final identifier:Ljava/lang/String;

.field protected mProgressListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudProgressListener;",
            ">;"
        }
    .end annotation
.end field

.field protected mResult:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field protected mResultListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudResultListener",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private observerExecutor:Ljava/util/concurrent/Executor;

.field protected serviceException:Lcom/tencent/qcloud/core/common/QCloudServiceException;

.field private final tag:Ljava/lang/Object;

.field protected taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

.field protected workerExecutor:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;
    .param p2, "tag"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    const/4 v1, 0x2

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    .line 43
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    .line 46
    iput-object p1, p0, Lcom/tencent/qcloud/core/task/Task;->identifier:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/tencent/qcloud/core/task/Task;->tag:Ljava/lang/Object;

    .line 48
    invoke-static {}, Lcom/tencent/qcloud/core/task/TaskManager;->getInstance()Lcom/tencent/qcloud/core/task/TaskManager;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    .line 49
    return-void
.end method

.method private executeListener(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 186
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->observerExecutor:Ljava/util/concurrent/Executor;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->observerExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 191
    :goto_0
    return-void

    .line 189
    :cond_0
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method


# virtual methods
.method public final addProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .param p1, "progressListener"    # Lcom/tencent/qcloud/core/common/QCloudProgressListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/common/QCloudProgressListener;",
            ")",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 115
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    if-eqz p1, :cond_0

    .line 116
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 118
    :cond_0
    return-object p0
.end method

.method public final addProgressListeners(Ljava/util/List;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudProgressListener;",
            ">;)",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 122
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    .local p1, "progressListeners":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/common/QCloudProgressListener;>;"
    if-eqz p1, :cond_0

    .line 123
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 125
    :cond_0
    return-object p0
.end method

.method public final addResultListener(Lcom/tencent/qcloud/core/common/QCloudResultListener;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/common/QCloudResultListener",
            "<TT;>;)",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 81
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    .local p1, "resultListener":Lcom/tencent/qcloud/core/common/QCloudResultListener;, "Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;"
    if-eqz p1, :cond_0

    .line 82
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 84
    :cond_0
    return-object p0
.end method

.method public final addResultListeners(Ljava/util/List;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudResultListener",
            "<TT;>;>;)",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    .local p1, "resultListeners":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;>;"
    if-eqz p1, :cond_0

    .line 89
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 91
    :cond_0
    return-object p0
.end method

.method protected declared-synchronized close()V
    .locals 1

    .prologue
    .line 194
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->closed:Z

    if-nez v0, :cond_0

    .line 195
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->closed:Z

    .line 196
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    invoke-virtual {v0, p0}, Lcom/tencent/qcloud/core/task/TaskManager;->remove(Lcom/tencent/qcloud/core/task/Task;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 198
    :cond_0
    monitor-exit p0

    return-void

    .line 194
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final executeNow()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 63
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->executeNowSilently()V

    .line 65
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

    throw v0

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->serviceException:Lcom/tencent/qcloud/core/common/QCloudServiceException;

    if-eqz v0, :cond_1

    .line 69
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->serviceException:Lcom/tencent/qcloud/core/common/QCloudServiceException;

    throw v0

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResult:Ljava/lang/Object;

    return-object v0
.end method

.method public final executeNowSilently()V
    .locals 1

    .prologue
    .line 76
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    invoke-virtual {v0, p0}, Lcom/tencent/qcloud/core/task/TaskManager;->add(Lcom/tencent/qcloud/core/task/Task;)V

    .line 77
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->run()V

    .line 78
    return-void
.end method

.method public final getAllProgressListeners()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudProgressListener;",
            ">;"
        }
    .end annotation

    .prologue
    .line 111
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public final getAllResultListeners()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/common/QCloudResultListener",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 107
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public getException()Ljava/lang/Exception;
    .locals 1

    .prologue
    .line 140
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->serviceException:Lcom/tencent/qcloud/core/common/QCloudServiceException;

    goto :goto_0
.end method

.method public final getIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 212
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->identifier:Ljava/lang/String;

    return-object v0
.end method

.method public getResult()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 136
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResult:Ljava/lang/Object;

    return-object v0
.end method

.method public final getTag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 216
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->tag:Ljava/lang/Object;

    return-object v0
.end method

.method public final declared-synchronized isCompleted()Z
    .locals 1

    .prologue
    .line 224
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->completed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized isExecuted()Z
    .locals 1

    .prologue
    .line 220
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->executed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final observeOn(Ljava/util/concurrent/Executor;)Lcom/tencent/qcloud/core/task/Task;
    .locals 0
    .param p1, "executor"    # Ljava/util/concurrent/Executor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Executor;",
            ")",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 58
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/task/Task;->observerExecutor:Ljava/util/concurrent/Executor;

    .line 59
    return-object p0
.end method

.method protected abstract onCommand()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation
.end method

.method protected declared-synchronized onComplete()V
    .locals 5

    .prologue
    .line 206
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    monitor-enter p0

    :try_start_0
    const-string v0, "QCloudTask"

    const-string v1, "[Task] %s complete"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 207
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->close()V

    .line 208
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->completed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 209
    monitor-exit p0

    return-void

    .line 206
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected declared-synchronized onExecute()V
    .locals 5

    .prologue
    .line 201
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    monitor-enter p0

    :try_start_0
    const-string v0, "QCloudTask"

    const-string v1, "[Task] %s start execute"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 202
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/tencent/qcloud/core/task/Task;->executed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 203
    monitor-exit p0

    return-void

    .line 201
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected onFailure()V
    .locals 1

    .prologue
    .line 158
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 159
    new-instance v0, Lcom/tencent/qcloud/core/task/Task$2;

    invoke-direct {v0, p0}, Lcom/tencent/qcloud/core/task/Task$2;-><init>(Lcom/tencent/qcloud/core/task/Task;)V

    invoke-direct {p0, v0}, Lcom/tencent/qcloud/core/task/Task;->executeListener(Ljava/lang/Runnable;)V

    .line 169
    :cond_0
    return-void
.end method

.method protected onProgress(JJ)V
    .locals 7
    .param p1, "complete"    # J
    .param p3, "target"    # J

    .prologue
    .line 172
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 173
    new-instance v0, Lcom/tencent/qcloud/core/task/Task$3;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/tencent/qcloud/core/task/Task$3;-><init>(Lcom/tencent/qcloud/core/task/Task;JJ)V

    invoke-direct {p0, v0}, Lcom/tencent/qcloud/core/task/Task;->executeListener(Ljava/lang/Runnable;)V

    .line 183
    :cond_0
    return-void
.end method

.method protected onSuccess()V
    .locals 1

    .prologue
    .line 144
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 145
    new-instance v0, Lcom/tencent/qcloud/core/task/Task$1;

    invoke-direct {v0, p0}, Lcom/tencent/qcloud/core/task/Task$1;-><init>(Lcom/tencent/qcloud/core/task/Task;)V

    invoke-direct {p0, v0}, Lcom/tencent/qcloud/core/task/Task;->executeListener(Ljava/lang/Runnable;)V

    .line 155
    :cond_0
    return-void
.end method

.method public final removeAllListeners()V
    .locals 1

    .prologue
    .line 102
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 103
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 104
    return-void
.end method

.method public final removeProgressListener(Lcom/tencent/qcloud/core/common/QCloudProgressListener;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .param p1, "progressListener"    # Lcom/tencent/qcloud/core/common/QCloudProgressListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/common/QCloudProgressListener;",
            ")",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    if-eqz p1, :cond_0

    .line 130
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 132
    :cond_0
    return-object p0
.end method

.method public final removeResultListener(Lcom/tencent/qcloud/core/common/QCloudResultListener;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/common/QCloudResultListener",
            "<TT;>;)",
            "Lcom/tencent/qcloud/core/task/Task",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 95
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    .local p1, "resultListener":Lcom/tencent/qcloud/core/common/QCloudResultListener;, "Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;"
    if-eqz p1, :cond_0

    .line 96
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 98
    :cond_0
    return-object p0
.end method

.method public run()V
    .locals 2

    .prologue
    .line 231
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onExecute()V

    .line 234
    :try_start_0
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onCommand()Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p0, Lcom/tencent/qcloud/core/task/Task;->mResult:Ljava/lang/Object;

    .line 235
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onSuccess()V
    :try_end_0
    .catch Lcom/tencent/qcloud/core/common/QCloudClientException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/tencent/qcloud/core/common/QCloudServiceException; {:try_start_0 .. :try_end_0} :catch_1

    .line 246
    :goto_0
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onComplete()V

    .line 247
    return-void

    .line 236
    :catch_0
    move-exception v0

    .line 237
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    invoke-virtual {v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;->printStackTrace()V

    .line 238
    iput-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->clientException:Lcom/tencent/qcloud/core/common/QCloudClientException;

    .line 239
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onFailure()V

    goto :goto_0

    .line 240
    .end local v0    # "e":Lcom/tencent/qcloud/core/common/QCloudClientException;
    :catch_1
    move-exception v0

    .line 241
    .local v0, "e":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    invoke-virtual {v0}, Lcom/tencent/qcloud/core/common/QCloudServiceException;->printStackTrace()V

    .line 242
    iput-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->serviceException:Lcom/tencent/qcloud/core/common/QCloudServiceException;

    .line 243
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/task/Task;->onFailure()V

    goto :goto_0
.end method

.method protected scheduleOn(Ljava/util/concurrent/ThreadPoolExecutor;)V
    .locals 1
    .param p1, "executor"    # Ljava/util/concurrent/ThreadPoolExecutor;

    .prologue
    .line 52
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task;, "Lcom/tencent/qcloud/core/task/Task<TT;>;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/Task;->taskManager:Lcom/tencent/qcloud/core/task/TaskManager;

    invoke-virtual {v0, p0}, Lcom/tencent/qcloud/core/task/TaskManager;->add(Lcom/tencent/qcloud/core/task/Task;)V

    .line 53
    iput-object p1, p0, Lcom/tencent/qcloud/core/task/Task;->workerExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 54
    invoke-static {p1, p0}, Lcom/tencent/qcloud/core/task/TaskExecutors;->schedule(Ljava/util/concurrent/Executor;Lcom/tencent/qcloud/core/task/Task;)V

    .line 55
    return-void
.end method
