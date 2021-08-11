.class Lplugins/CosSdkPlugin$3;
.super Ljava/lang/Object;
.source "CosSdkPlugin.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lplugins/CosSdkPlugin;->downloadObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lplugins/CosSdkPlugin;

.field final synthetic val$cosPath:Ljava/lang/String;


# direct methods
.method constructor <init>(Lplugins/CosSdkPlugin;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lplugins/CosSdkPlugin;

    .prologue
    .line 169
    iput-object p1, p0, Lplugins/CosSdkPlugin$3;->this$0:Lplugins/CosSdkPlugin;

    iput-object p2, p0, Lplugins/CosSdkPlugin$3;->val$cosPath:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
    .locals 6
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "qcloudClientException"    # Lcom/tencent/cos/xml/exception/CosXmlClientException;
    .param p3, "qcloudServiceException"    # Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .prologue
    .line 191
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 192
    .local v2, "stringBuilder":Ljava/lang/StringBuilder;
    if-eqz p2, :cond_0

    .line 193
    invoke-virtual {p2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    :goto_0
    const-string v3, "cqq_log"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "download failed = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lplugins/CosSdkPlugin$3;->val$cosPath:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    invoke-virtual {p3}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->getStatusCode()I

    move-result v0

    .line 201
    .local v0, "code":I
    invoke-virtual {p3}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->getHttpMessage()Ljava/lang/String;

    move-result-object v1

    .line 202
    .local v1, "msg":Ljava/lang/String;
    iget-object v3, p0, Lplugins/CosSdkPlugin$3;->this$0:Lplugins/CosSdkPlugin;

    iget-object v4, p0, Lplugins/CosSdkPlugin$3;->val$cosPath:Ljava/lang/String;

    const-string v5, ""

    invoke-static {v3, v0, v1, v4, v5}, Lplugins/CosSdkPlugin;->access$100(Lplugins/CosSdkPlugin;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    return-void

    .line 196
    .end local v0    # "code":I
    .end local v1    # "msg":Ljava/lang/String;
    :cond_0
    invoke-virtual {p3}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 8
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "cosXmlResult"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 172
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 173
    .local v3, "stringBuilder":Ljava/lang/StringBuilder;
    invoke-virtual {p2}, Lcom/tencent/cos/xml/model/CosXmlResult;->printResult()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 174
    const-string v5, "cqq_log"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "download success = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lplugins/CosSdkPlugin$3;->val$cosPath:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    const-string v2, ""

    .line 177
    .local v2, "newTag":Ljava/lang/String;
    iget-object v5, p2, Lcom/tencent/cos/xml/model/CosXmlResult;->headers:Ljava/util/Map;

    const-string v6, "etag"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 178
    .local v4, "tags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 179
    const/4 v5, 0x0

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "newTag":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 182
    .restart local v2    # "newTag":Ljava/lang/String;
    :cond_0
    iget v0, p2, Lcom/tencent/cos/xml/model/CosXmlResult;->httpCode:I

    .line 183
    .local v0, "code":I
    iget-object v1, p2, Lcom/tencent/cos/xml/model/CosXmlResult;->httpMessage:Ljava/lang/String;

    .line 184
    .local v1, "msg":Ljava/lang/String;
    iget-object v5, p0, Lplugins/CosSdkPlugin$3;->this$0:Lplugins/CosSdkPlugin;

    iget-object v6, p0, Lplugins/CosSdkPlugin$3;->val$cosPath:Ljava/lang/String;

    invoke-static {v5, v0, v1, v6, v2}, Lplugins/CosSdkPlugin;->access$100(Lplugins/CosSdkPlugin;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    return-void
.end method
