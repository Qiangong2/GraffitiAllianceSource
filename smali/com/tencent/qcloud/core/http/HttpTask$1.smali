.class Lcom/tencent/qcloud/core/http/HttpTask$1;
.super Ljava/lang/Object;
.source "HttpTask.java"

# interfaces
.implements Lcom/tencent/qcloud/core/common/QCloudProgressListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/HttpTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/http/HttpTask;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/http/HttpTask;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/http/HttpTask;

    .prologue
    .line 39
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask$1;, "Lcom/tencent/qcloud/core/http/HttpTask$1;"
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpTask$1;->this$0:Lcom/tencent/qcloud/core/http/HttpTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgress(JJ)V
    .locals 1
    .param p1, "complete"    # J
    .param p3, "target"    # J

    .prologue
    .line 42
    .local p0, "this":Lcom/tencent/qcloud/core/http/HttpTask$1;, "Lcom/tencent/qcloud/core/http/HttpTask$1;"
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpTask$1;->this$0:Lcom/tencent/qcloud/core/http/HttpTask;

    invoke-static {v0, p1, p2, p3, p4}, Lcom/tencent/qcloud/core/http/HttpTask;->access$000(Lcom/tencent/qcloud/core/http/HttpTask;JJ)V

    .line 43
    return-void
.end method
