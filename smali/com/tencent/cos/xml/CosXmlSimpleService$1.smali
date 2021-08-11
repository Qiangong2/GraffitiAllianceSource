.class Lcom/tencent/cos/xml/CosXmlSimpleService$1;
.super Ljava/lang/Object;
.source "CosXmlSimpleService.java"

# interfaces
.implements Lcom/tencent/qcloud/core/common/QCloudResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/CosXmlSimpleService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/tencent/qcloud/core/common/QCloudResultListener",
        "<",
        "Lcom/tencent/qcloud/core/http/HttpResult",
        "<TT2;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/CosXmlSimpleService;

.field final synthetic val$cosXmlRequest:Lcom/tencent/cos/xml/model/CosXmlRequest;

.field final synthetic val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/CosXmlSimpleService;Lcom/tencent/cos/xml/listener/CosXmlResultListener;Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/CosXmlSimpleService;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->this$0:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iput-object p2, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    iput-object p3, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlRequest:Lcom/tencent/cos/xml/model/CosXmlRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lcom/tencent/qcloud/core/common/QCloudClientException;Lcom/tencent/qcloud/core/common/QCloudServiceException;)V
    .locals 4
    .param p1, "clientException"    # Lcom/tencent/qcloud/core/common/QCloudClientException;
    .param p2, "serviceException"    # Lcom/tencent/qcloud/core/common/QCloudServiceException;

    .prologue
    const/4 v3, 0x0

    .line 155
    if-eqz p1, :cond_0

    .line 156
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    iget-object v1, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlRequest:Lcom/tencent/cos/xml/model/CosXmlRequest;

    new-instance v2, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v2, p1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    invoke-interface {v0, v1, v2, v3}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    .line 161
    .end local p2    # "serviceException":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    :goto_0
    return-void

    .line 158
    .restart local p2    # "serviceException":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    iget-object v1, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlRequest:Lcom/tencent/cos/xml/model/CosXmlRequest;

    check-cast p2, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .end local p2    # "serviceException":Lcom/tencent/qcloud/core/common/QCloudServiceException;
    invoke-interface {v0, v1, v3, p2}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    goto :goto_0
.end method

.method public onSuccess(Lcom/tencent/qcloud/core/http/HttpResult;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpResult",
            "<TT2;>;)V"
        }
    .end annotation

    .prologue
    .line 150
    .local p1, "result":Lcom/tencent/qcloud/core/http/HttpResult;, "Lcom/tencent/qcloud/core/http/HttpResult<TT2;>;"
    iget-object v1, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    iget-object v2, p0, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->val$cosXmlRequest:Lcom/tencent/cos/xml/model/CosXmlRequest;

    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResult;->content()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/CosXmlResult;

    invoke-interface {v1, v2, v0}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V

    .line 151
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 147
    check-cast p1, Lcom/tencent/qcloud/core/http/HttpResult;

    invoke-virtual {p0, p1}, Lcom/tencent/cos/xml/CosXmlSimpleService$1;->onSuccess(Lcom/tencent/qcloud/core/http/HttpResult;)V

    return-void
.end method
