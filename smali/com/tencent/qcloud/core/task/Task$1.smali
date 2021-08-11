.class Lcom/tencent/qcloud/core/task/Task$1;
.super Ljava/lang/Object;
.source "Task.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/qcloud/core/task/Task;->onSuccess()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/task/Task;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/task/Task;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/task/Task;

    .prologue
    .line 145
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task$1;, "Lcom/tencent/qcloud/core/task/Task$1;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/task/Task$1;->this$0:Lcom/tencent/qcloud/core/task/Task;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 148
    .local p0, "this":Lcom/tencent/qcloud/core/task/Task$1;, "Lcom/tencent/qcloud/core/task/Task$1;"
    new-instance v0, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/tencent/qcloud/core/task/Task$1;->this$0:Lcom/tencent/qcloud/core/task/Task;

    iget-object v2, v2, Lcom/tencent/qcloud/core/task/Task;->mResultListeners:Ljava/util/Set;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 149
    .local v0, "listeners":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/tencent/qcloud/core/common/QCloudResultListener;

    .line 150
    .local v1, "resultListener":Lcom/tencent/qcloud/core/common/QCloudResultListener;, "Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;"
    iget-object v3, p0, Lcom/tencent/qcloud/core/task/Task$1;->this$0:Lcom/tencent/qcloud/core/task/Task;

    iget-object v3, v3, Lcom/tencent/qcloud/core/task/Task;->mResult:Ljava/lang/Object;

    invoke-interface {v1, v3}, Lcom/tencent/qcloud/core/common/QCloudResultListener;->onSuccess(Ljava/lang/Object;)V

    goto :goto_0

    .line 152
    .end local v1    # "resultListener":Lcom/tencent/qcloud/core/common/QCloudResultListener;, "Lcom/tencent/qcloud/core/common/QCloudResultListener<TT;>;"
    :cond_0
    return-void
.end method
