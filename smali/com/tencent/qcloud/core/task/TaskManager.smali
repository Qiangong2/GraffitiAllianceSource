.class public final Lcom/tencent/qcloud/core/task/TaskManager;
.super Ljava/lang/Object;
.source "TaskManager.java"


# static fields
.field static final TASK_LOG_TAG:Ljava/lang/String; = "QCloudTask"

.field private static volatile instance:Lcom/tencent/qcloud/core/task/TaskManager;


# instance fields
.field private taskPool:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/tencent/qcloud/core/task/Task;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    const/16 v1, 0x1e

    invoke-direct {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    .line 39
    return-void
.end method

.method public static getInstance()Lcom/tencent/qcloud/core/task/TaskManager;
    .locals 2

    .prologue
    .line 26
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskManager;->instance:Lcom/tencent/qcloud/core/task/TaskManager;

    if-nez v0, :cond_1

    .line 27
    const-class v1, Lcom/tencent/qcloud/core/task/TaskManager;

    monitor-enter v1

    .line 28
    :try_start_0
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskManager;->instance:Lcom/tencent/qcloud/core/task/TaskManager;

    if-nez v0, :cond_0

    .line 29
    new-instance v0, Lcom/tencent/qcloud/core/task/TaskManager;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/task/TaskManager;-><init>()V

    sput-object v0, Lcom/tencent/qcloud/core/task/TaskManager;->instance:Lcom/tencent/qcloud/core/task/TaskManager;

    .line 31
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 34
    :cond_1
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskManager;->instance:Lcom/tencent/qcloud/core/task/TaskManager;

    return-object v0

    .line 31
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method


# virtual methods
.method add(Lcom/tencent/qcloud/core/task/Task;)V
    .locals 5
    .param p1, "task"    # Lcom/tencent/qcloud/core/task/Task;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    const-string v0, "QCloudTask"

    const-string v1, "[Pool] ADD %s, %d cached"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 44
    return-void
.end method

.method evict()V
    .locals 5

    .prologue
    .line 62
    const-string v0, "QCloudTask"

    const-string v1, "[Pool] CLEAR %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 63
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 64
    return-void
.end method

.method public get(Ljava/lang/String;)Lcom/tencent/qcloud/core/task/Task;
    .locals 1
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/task/Task;

    return-object v0
.end method

.method remove(Lcom/tencent/qcloud/core/task/Task;)V
    .locals 5
    .param p1, "task"    # Lcom/tencent/qcloud/core/task/Task;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 48
    const-string v0, "QCloudTask"

    const-string v1, "[Pool] REMOVE %s, %d cached"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 49
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/task/Task;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 48
    invoke-static {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 51
    :cond_0
    return-void
.end method

.method public snapshot()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/tencent/qcloud/core/task/Task;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/tencent/qcloud/core/task/TaskManager;->taskPool:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method
