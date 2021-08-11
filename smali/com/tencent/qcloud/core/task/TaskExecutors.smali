.class public Lcom/tencent/qcloud/core/task/TaskExecutors;
.super Ljava/lang/Object;
.source "TaskExecutors.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;
    }
.end annotation


# static fields
.field public static final COMMAND_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

.field public static final DOWNLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

.field public static final UI_THREAD_EXECUTOR:Lcom/tencent/qcloud/core/task/UIThreadExecutor;

.field public static final UPLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v2, 0x5

    const/4 v11, 0x3

    const/4 v10, 0x2

    const-wide/16 v4, 0x5

    const/4 v9, 0x1

    .line 28
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    const/16 v0, 0x80

    invoke-direct {v7, v0}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    new-instance v8, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;

    const-string v0, "Command-"

    invoke-direct {v8, v0}, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;-><init>(Ljava/lang/String;)V

    move v3, v2

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    sput-object v1, Lcom/tencent/qcloud/core/task/TaskExecutors;->COMMAND_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 31
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    new-instance v8, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;

    const-string v0, "Upload-"

    invoke-direct {v8, v0}, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;-><init>(Ljava/lang/String;)V

    move v2, v10

    move v3, v10

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    sput-object v1, Lcom/tencent/qcloud/core/task/TaskExecutors;->UPLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 34
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    const/16 v0, 0x80

    invoke-direct {v7, v0}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    new-instance v8, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;

    const-string v0, "Download-"

    invoke-direct {v8, v0}, Lcom/tencent/qcloud/core/task/TaskExecutors$TaskThreadFactory;-><init>(Ljava/lang/String;)V

    move v2, v11

    move v3, v11

    invoke-direct/range {v1 .. v8}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    sput-object v1, Lcom/tencent/qcloud/core/task/TaskExecutors;->DOWNLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 37
    new-instance v0, Lcom/tencent/qcloud/core/task/UIThreadExecutor;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/task/UIThreadExecutor;-><init>()V

    sput-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->UI_THREAD_EXECUTOR:Lcom/tencent/qcloud/core/task/UIThreadExecutor;

    .line 39
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->UPLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, v9}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 40
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->COMMAND_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, v9}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 41
    sget-object v0, Lcom/tencent/qcloud/core/task/TaskExecutors;->DOWNLOAD_EXECUTOR:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0, v9}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 42
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static schedule(Ljava/util/concurrent/Executor;Lcom/tencent/qcloud/core/task/Task;)V
    .locals 0
    .param p0, "executor"    # Ljava/util/concurrent/Executor;
    .param p1, "task"    # Lcom/tencent/qcloud/core/task/Task;

    .prologue
    .line 45
    invoke-interface {p0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 46
    return-void
.end method
