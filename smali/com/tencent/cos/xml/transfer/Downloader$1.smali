.class Lcom/tencent/cos/xml/transfer/Downloader$1;
.super Ljava/lang/Object;
.source "Downloader.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/cos/xml/transfer/Downloader;->download(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/Downloader;


# direct methods
.method constructor <init>(Lcom/tencent/cos/xml/transfer/Downloader;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "exception"    # Lcom/tencent/cos/xml/exception/CosXmlClientException;
    .param p3, "serviceException"    # Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    .prologue
    .line 122
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/Downloader;->access$400(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    move-result-object v0

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v1}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v1

    invoke-virtual {v0, v1, p2, p3}, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    .line 123
    return-void
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 8
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "result"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 99
    move-object v0, p2

    check-cast v0, Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    .line 100
    .local v0, "headObjectResult":Lcom/tencent/cos/xml/model/object/HeadObjectResult;
    iget-object v5, v0, Lcom/tencent/cos/xml/model/object/HeadObjectResult;->headers:Ljava/util/Map;

    const-string v6, "ETag"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 101
    .local v2, "realEtags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 102
    .local v1, "realEtag":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 103
    const/4 v5, 0x0

    invoke-interface {v2, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "realEtag":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 105
    .restart local v1    # "realEtag":Ljava/lang/String;
    :cond_0
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    const-wide/16 v6, 0x0

    invoke-static {v5, v6, v7}, Lcom/tencent/cos/xml/transfer/Downloader;->access$002(Lcom/tencent/cos/xml/transfer/Downloader;J)J

    .line 106
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v5

    invoke-virtual {v5}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getDownloadPath()Ljava/lang/String;

    move-result-object v3

    .line 107
    .local v3, "realLocalPath":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 108
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$200(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 109
    .local v4, "sourceEtag":Ljava/lang/String;
    if-eqz v4, :cond_1

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 110
    :cond_1
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$200(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    move-result-object v5

    invoke-virtual {v5, v3, v1}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->updateValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    .end local v4    # "sourceEtag":Ljava/lang/String;
    :cond_2
    :goto_0
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v5

    iget-object v6, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v6}, Lcom/tencent/cos/xml/transfer/Downloader;->access$000(Lcom/tencent/cos/xml/transfer/Downloader;)J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setRange(J)V

    .line 116
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v5

    iget-object v6, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v6}, Lcom/tencent/cos/xml/transfer/Downloader;->access$400(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V

    .line 117
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v5}, Lcom/tencent/cos/xml/transfer/Downloader;->access$500(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/CosXml;

    move-result-object v5

    iget-object v6, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v6}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v6

    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v7}, Lcom/tencent/cos/xml/transfer/Downloader;->access$400(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Lcom/tencent/cos/xml/CosXml;->getObjectAsync(Lcom/tencent/cos/xml/model/object/GetObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 118
    return-void

    .line 112
    .restart local v4    # "sourceEtag":Ljava/lang/String;
    :cond_3
    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    iget-object v6, p0, Lcom/tencent/cos/xml/transfer/Downloader$1;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v6, v3}, Lcom/tencent/cos/xml/transfer/Downloader;->access$300(Lcom/tencent/cos/xml/transfer/Downloader;Ljava/lang/String;)J

    move-result-wide v6

    invoke-static {v5, v6, v7}, Lcom/tencent/cos/xml/transfer/Downloader;->access$002(Lcom/tencent/cos/xml/transfer/Downloader;J)J

    goto :goto_0
.end method
