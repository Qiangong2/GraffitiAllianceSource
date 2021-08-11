.class Lcom/tencent/qcloud/core/task/Task$3;
.super Ljava/lang/Object;
.source "Task.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/qcloud/core/task/Task;->onProgress(JJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/task/Task;

.field final synthetic val$complete:J

.field final synthetic val$target:J


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/task/Task;JJ)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/task/Task;

    .prologue
    .line 173
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task$3;, "Lcom/tencent/qcloud/core/task/Task$3;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/task/Task$3;->this$0:Lcom/tencent/qcloud/core/task/Task;

    iput-wide p2, p0, Lcom/tencent/qcloud/core/task/Task$3;->val$complete:J

    iput-wide p4, p0, Lcom/tencent/qcloud/core/task/Task$3;->val$target:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 176
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task$3;, "Lcom/tencent/qcloud/core/task/Task$3;"
    new-instance v0, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/tencent/qcloud/core/task/Task$3;->this$0:Lcom/tencent/qcloud/core/task/Task;

    iget-object v2, v2, Lcom/tencent/qcloud/core/task/Task;->mProgressListeners:Ljava/util/Set;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 177
    .local v0, "listeners":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/common/QCloudProgressListener;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/tencent/qcloud/core/common/QCloudProgressListener;

    .line 178
    .local v1, "progressListener":Lcom/tencent/qcloud/core/common/QCloudProgressListener;
    iget-wide v4, p0, Lcom/tencent/qcloud/core/task/Task$3;->val$complete:J

    iget-wide v6, p0, Lcom/tencent/qcloud/core/task/Task$3;->val$target:J

    invoke-interface {v1, v4, v5, v6, v7}, Lcom/tencent/qcloud/core/common/QCloudProgressListener;->onProgress(JJ)V

    goto :goto_0

    .line 180
    .end local v1    # "progressListener":Lcom/tencent/qcloud/core/common/QCloudProgressListener;
    :cond_0
    return-void
.end method
