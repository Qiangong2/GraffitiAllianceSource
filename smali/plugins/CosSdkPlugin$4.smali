.class Lplugins/CosSdkPlugin$4;
.super Ljava/lang/Object;
.source "CosSdkPlugin.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lplugins/CosSdkPlugin;->deleteObject(Ljava/lang/String;Ljava/lang/String;)V
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
    .line 225
    iput-object p1, p0, Lplugins/CosSdkPlugin$4;->this$0:Lplugins/CosSdkPlugin;

    iput-object p2, p0, Lplugins/CosSdkPlugin$4;->val$cosPath:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
    .locals 4
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "qcloudClientException"    # Lcom/tencent/cos/xml/exception/CosXmlClientException;
    .param p3, "qcloudServiceException"    # Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .prologue
    .line 239
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 240
    .local v0, "stringBuilder":Ljava/lang/StringBuilder;
    if-eqz p2, :cond_0

    .line 241
    invoke-virtual {p2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 246
    :goto_0
    const-string v1, "cqq_log"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "failed = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    return-void

    .line 244
    :cond_0
    invoke-virtual {p3}, Lcom/tencent/cos/xml/exception/CosXmlServiceException;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 4
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "cosXmlResult"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 228
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 229
    .local v0, "stringBuilder":Ljava/lang/StringBuilder;
    invoke-virtual {p2}, Lcom/tencent/cos/xml/model/CosXmlResult;->printResult()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 230
    const-string v1, "cqq_log"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "success = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 232
    const-string v1, "UIRoot"

    const-string v2, "DeleteResult"

    iget-object v3, p0, Lplugins/CosSdkPlugin$4;->val$cosPath:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    return-void
.end method
