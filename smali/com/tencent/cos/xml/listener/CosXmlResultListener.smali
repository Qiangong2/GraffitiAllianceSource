.class public interface abstract Lcom/tencent/cos/xml/listener/CosXmlResultListener;
.super Ljava/lang/Object;
.source "CosXmlResultListener.java"


# virtual methods
.method public abstract onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
.end method

.method public abstract onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
.end method
