.class Lcom/tencent/cos/xml/transfer/UploadService$1;
.super Ljava/lang/Object;
.source "UploadService.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/transfer/UploadService;->putObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/UploadService;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/transfer/UploadService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
    .locals 3
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "exception"    # Lcom/tencent/cos/xml/exception/CosXmlClientException;
    .param p3, "serviceException"    # Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .prologue
    .line 192
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B

    move-result-object v1

    monitor-enter v1

    .line 193
    if-eqz p2, :cond_0

    .line 194
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0, p2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$302(Lcom/tencent/cos/xml/transfer/UploadService;Ljava/lang/Exception;)Ljava/lang/Exception;

    .line 198
    :goto_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$402(Lcom/tencent/cos/xml/transfer/UploadService;I)I

    .line 199
    monitor-exit v1

    .line 200
    return-void

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0, p3}, Lcom/tencent/cos/xml/transfer/UploadService;->access$302(Lcom/tencent/cos/xml/transfer/UploadService;Ljava/lang/Exception;)Ljava/lang/Exception;

    goto :goto_0

    .line 199
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 5
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "result"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 179
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B

    move-result-object v3

    monitor-enter v3

    .line 180
    :try_start_0
    move-object v0, p2

    check-cast v0, Lcom/tencent/cos/xml/model/object/PutObjectResult;

    move-object v1, v0

    .line 181
    .local v1, "putObjectResult":Lcom/tencent/cos/xml/model/object/PutObjectResult;
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    new-instance v4, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    invoke-direct {v4}, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;-><init>()V

    invoke-static {v2, v4}, Lcom/tencent/cos/xml/transfer/UploadService;->access$102(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    .line 182
    :cond_0
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v2

    iget v4, v1, Lcom/tencent/cos/xml/model/object/PutObjectResult;->httpCode:I

    iput v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->httpCode:I

    .line 183
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v2

    iget-object v4, v1, Lcom/tencent/cos/xml/model/object/PutObjectResult;->httpMessage:Ljava/lang/String;

    iput-object v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->httpMessage:Ljava/lang/String;

    .line 184
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v2

    iget-object v4, v1, Lcom/tencent/cos/xml/model/object/PutObjectResult;->headers:Ljava/util/Map;

    iput-object v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->headers:Ljava/util/Map;

    .line 185
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v2

    iget-object v4, v1, Lcom/tencent/cos/xml/model/object/PutObjectResult;->eTag:Ljava/lang/String;

    iput-object v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->eTag:Ljava/lang/String;

    .line 186
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 187
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService$1;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$200(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 188
    return-void

    .line 186
    .end local v1    # "putObjectResult":Lcom/tencent/cos/xml/model/object/PutObjectResult;
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method
