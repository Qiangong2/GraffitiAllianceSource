.class Lcom/tencent/cos/xml/transfer/UploadService$2;
.super Ljava/lang/Object;
.source "UploadService.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/transfer/UploadService;->multiUploadParts()Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/UploadService;

.field final synthetic val$slicePartStruct:Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->val$slicePartStruct:Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

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
    .line 259
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B

    move-result-object v1

    monitor-enter v1

    .line 260
    if-eqz p2, :cond_0

    .line 261
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0, p2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$302(Lcom/tencent/cos/xml/transfer/UploadService;Ljava/lang/Exception;)Ljava/lang/Exception;

    .line 265
    :goto_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/tencent/cos/xml/transfer/UploadService;->access$402(Lcom/tencent/cos/xml/transfer/UploadService;I)I

    .line 266
    monitor-exit v1

    .line 267
    return-void

    .line 263
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0, p3}, Lcom/tencent/cos/xml/transfer/UploadService;->access$302(Lcom/tencent/cos/xml/transfer/UploadService;Ljava/lang/Exception;)Ljava/lang/Exception;

    goto :goto_0

    .line 266
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 3
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "result"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B

    move-result-object v1

    monitor-enter v1

    .line 251
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->val$slicePartStruct:Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    check-cast p2, Lcom/tencent/cos/xml/model/object/UploadPartResult;

    .end local p2    # "result":Lcom/tencent/cos/xml/model/CosXmlResult;
    iget-object v2, p2, Lcom/tencent/cos/xml/model/object/UploadPartResult;->eTag:Ljava/lang/String;

    iput-object v2, v0, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->eTag:Ljava/lang/String;

    .line 252
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->val$slicePartStruct:Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    const/4 v2, 0x1

    iput-boolean v2, v0, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->isAlreadyUpload:Z

    .line 253
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 254
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$2;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$200(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 255
    return-void

    .line 253
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
