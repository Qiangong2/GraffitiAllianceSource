.class Lcom/tencent/cos/xml/transfer/UploadService$4;
.super Ljava/lang/Object;
.source "UploadService.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/transfer/UploadService;->abortMultiUpload(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/UploadService;

.field final synthetic val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 386
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "exception"    # Lcom/tencent/cos/xml/exception/CosXmlClientException;
    .param p3, "serviceException"    # Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .prologue
    .line 396
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    .line 397
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$900(Lcom/tencent/cos/xml/transfer/UploadService;)V

    .line 398
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$1000(Lcom/tencent/cos/xml/transfer/UploadService;)V

    .line 399
    return-void
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "result"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 389
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    invoke-interface {v0, p1, p2}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V

    .line 390
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$900(Lcom/tencent/cos/xml/transfer/UploadService;)V

    .line 391
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService$4;->this$0:Lcom/tencent/cos/xml/transfer/UploadService;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/UploadService;->access$1000(Lcom/tencent/cos/xml/transfer/UploadService;)V

    .line 392
    return-void
.end method
