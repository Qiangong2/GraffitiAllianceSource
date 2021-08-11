.class Lcom/tencent/qcloud/core/logger/RecordLog$1;
.super Ljava/lang/Object;
.source "RecordLog.java"

# interfaces
.implements Ljava/io/FileFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/logger/RecordLog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/logger/RecordLog;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/logger/RecordLog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/logger/RecordLog;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/tencent/qcloud/core/logger/RecordLog$1;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;)Z
    .locals 5
    .param p1, "pathname"    # Ljava/io/File;

    .prologue
    const/4 v2, 0x0

    .line 43
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    .line 44
    .local v0, "filename":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/tencent/qcloud/core/logger/RecordLog$1;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-static {v4}, Lcom/tencent/qcloud/core/logger/RecordLog;->access$000(Lcom/tencent/qcloud/core/logger/RecordLog;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".log"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    .line 45
    .local v1, "result":Z
    if-nez v1, :cond_0

    .line 49
    :goto_0
    return v2

    .line 48
    :cond_0
    iget-object v3, p0, Lcom/tencent/qcloud/core/logger/RecordLog$1;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-virtual {v3, p1}, Lcom/tencent/qcloud/core/logger/RecordLog;->getIndexFromFile(Ljava/io/File;)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_1

    const/4 v1, 0x1

    :goto_1
    move v2, v1

    .line 49
    goto :goto_0

    :cond_1
    move v1, v2

    .line 48
    goto :goto_1
.end method
