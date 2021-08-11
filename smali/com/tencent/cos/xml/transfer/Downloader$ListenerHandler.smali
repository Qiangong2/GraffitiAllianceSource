.class Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;
.super Ljava/lang/Object;
.source "Downloader.java"

# interfaces
.implements Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
.implements Lcom/tencent/cos/xml/listener/CosXmlResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/transfer/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ListenerHandler"
.end annotation


# instance fields
.field private cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

.field final synthetic this$0:Lcom/tencent/cos/xml/transfer/Downloader;


# direct methods
.method public constructor <init>(Lcom/tencent/cos/xml/transfer/Downloader;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

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
    .line 179
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    .line 182
    :cond_0
    return-void
.end method

.method public onProgress(JJ)V
    .locals 7
    .param p1, "complete"    # J
    .param p3, "target"    # J

    .prologue
    .line 164
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v1}, Lcom/tencent/cos/xml/transfer/Downloader;->access$000(Lcom/tencent/cos/xml/transfer/Downloader;)J

    move-result-wide v2

    add-long/2addr v2, p1

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v1}, Lcom/tencent/cos/xml/transfer/Downloader;->access$000(Lcom/tencent/cos/xml/transfer/Downloader;)J

    move-result-wide v4

    add-long/2addr v4, p3

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/tencent/cos/xml/listener/CosXmlProgressListener;->onProgress(JJ)V

    .line 167
    :cond_0
    return-void
.end method

.method public onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V
    .locals 2
    .param p1, "request"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .param p2, "result"    # Lcom/tencent/cos/xml/model/CosXmlResult;

    .prologue
    .line 171
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v0}, Lcom/tencent/cos/xml/transfer/Downloader;->access$200(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->this$0:Lcom/tencent/cos/xml/transfer/Downloader;

    invoke-static {v1}, Lcom/tencent/cos/xml/transfer/Downloader;->access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getDownloadPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->clear(Ljava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    if-eqz v0, :cond_0

    .line 173
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    invoke-interface {v0, p1, p2}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onSuccess(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)V

    .line 175
    :cond_0
    return-void
.end method

.method public setCosXmlProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "cosXmlProgressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 156
    return-void
.end method

.method public setCosXmlResultListener(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 0
    .param p1, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->cosXmlResultListener:Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .line 160
    return-void
.end method
