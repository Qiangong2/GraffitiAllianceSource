.class Lcom/tencent/cos/xml/transfer/UploadService$3;
.super Ljava/lang/Object;
.source "UploadService.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlProgressListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/transfer/UploadService;->uploadPart(IJJLcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/UploadService;

.field final synthetic val$uploadPartRequest:Lcom/tencent/cos/xml/model/object/UploadPartRequest;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/model/object/UploadPartRequest;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 342
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->val$uploadPartRequest:Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgress(JJ)V
    .locals 9
    .param p1, "complete"    # J
    .param p3, "target"    # J

    .prologue
    .line 345
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B

    move-result-object v3

    monitor-enter v3

    .line 346
    :try_start_0
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$600(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/concurrent/atomic/AtomicLong;

    move-result-object v4

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$500(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/Map;

    move-result-object v2

    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->val$uploadPartRequest:Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sub-long v6, p1, v6

    invoke-virtual {v4, v6, v7}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    move-result-wide v0

    .line 347
    .local v0, "dataLen":J
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$500(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/Map;

    move-result-object v2

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->val$uploadPartRequest:Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$700(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 349
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$700(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    move-result-object v2

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService$3;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v4}, Lcom/tencent/cos/xml/transfer/UploadService;->access$800(Lcom/tencent/cos/xml/transfer/UploadService;)J

    move-result-wide v4

    invoke-interface {v2, v0, v1, v4, v5}, Lcom/tencent/cos/xml/listener/CosXmlProgressListener;->onProgress(JJ)V

    .line 351
    :cond_0
    monitor-exit v3

    .line 352
    return-void

    .line 351
    .end local v0    # "dataLen":J
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method
