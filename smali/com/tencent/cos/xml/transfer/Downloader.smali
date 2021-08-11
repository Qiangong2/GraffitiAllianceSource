.class public Lcom/tencent/cos/xml/transfer/Downloader;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;
    }
.end annotation


# instance fields
.field private bucket:Ljava/lang/String;

.field private cosPath:Ljava/lang/String;

.field private cosXmlServer:Lcom/tencent/cos/xml/CosXml;

.field private getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

.field private listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

.field private localFileName:Ljava/lang/String;

.field private localPath:Ljava/lang/String;

.field private rangeStart:J

.field private sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/tencent/cos/xml/CosXml;)V
    .locals 2
    .param p1, "appContext"    # Landroid/content/Context;
    .param p2, "cosXmlServer"    # Lcom/tencent/cos/xml/CosXml;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    .line 36
    new-instance v0, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    invoke-direct {v0, p0}, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;-><init>(Lcom/tencent/cos/xml/transfer/Downloader;)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    .line 41
    new-instance v0, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    invoke-direct {v0, p1}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    .line 42
    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    .line 43
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/cos/xml/transfer/Downloader;)J
    .locals 2
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    return-wide v0
.end method

.method static synthetic access$002(Lcom/tencent/cos/xml/transfer/Downloader;J)J
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;
    .param p1, "x1"    # J

    .prologue
    .line 28
    iput-wide p1, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    return-wide p1
.end method

.method static synthetic access$100(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/model/object/GetObjectRequest;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    return-object v0
.end method

.method static synthetic access$200(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/utils/SharePreferenceUtils;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    return-object v0
.end method

.method static synthetic access$300(Lcom/tencent/cos/xml/transfer/Downloader;Ljava/lang/String;)J
    .locals 2
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/transfer/Downloader;->getRange(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$400(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    return-object v0
.end method

.method static synthetic access$500(Lcom/tencent/cos/xml/transfer/Downloader;)Lcom/tencent/cos/xml/CosXml;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/Downloader;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    return-object v0
.end method

.method private checkParameters()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->bucket:Ljava/lang/String;

    if-nez v0, :cond_0

    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "bucket must not be null "

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosPath:Ljava/lang/String;

    if-nez v0, :cond_1

    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "cosPath must not be null "

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 144
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->localPath:Ljava/lang/String;

    if-nez v0, :cond_2

    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "localPath must not be null "

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 145
    :cond_2
    return-void
.end method

.method private getRange(Ljava/lang/String;)J
    .locals 4
    .param p1, "filePath"    # Ljava/lang/String;

    .prologue
    .line 134
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 135
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 136
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    .line 138
    :goto_0
    return-wide v2

    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public cancel()V
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-interface {v0, v1}, Lcom/tencent/cos/xml/CosXml;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 131
    :cond_0
    return-void
.end method

.method public download(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/model/object/GetObjectResult;
    .locals 10
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "localPath"    # Ljava/lang/String;
    .param p4, "localFileName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 51
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader;->bucket:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosPath:Ljava/lang/String;

    .line 53
    iput-object p3, p0, Lcom/tencent/cos/xml/transfer/Downloader;->localPath:Ljava/lang/String;

    .line 54
    iput-object p4, p0, Lcom/tencent/cos/xml/transfer/Downloader;->localFileName:Ljava/lang/String;

    .line 55
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/Downloader;->checkParameters()V

    .line 56
    new-instance v1, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;

    invoke-direct {v1, p1, p2}, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .local v1, "headObjectRequest":Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    invoke-interface {v7, v1}, Lcom/tencent/cos/xml/CosXml;->headObject(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;)Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    move-result-object v2

    .line 58
    .local v2, "headObjectResult":Lcom/tencent/cos/xml/model/object/HeadObjectResult;
    iget-object v7, v2, Lcom/tencent/cos/xml/model/object/HeadObjectResult;->headers:Ljava/util/Map;

    const-string v8, "ETag"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 59
    .local v4, "realEtags":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    .line 60
    .local v3, "realEtag":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_0

    .line 61
    const/4 v7, 0x0

    invoke-interface {v4, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "realEtag":Ljava/lang/String;
    check-cast v3, Ljava/lang/String;

    .line 63
    .restart local v3    # "realEtag":Ljava/lang/String;
    :cond_0
    new-instance v7, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-direct {v7, p1, p2, p3, p4}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    .line 64
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    .line 65
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-virtual {v7}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->getDownloadPath()Ljava/lang/String;

    move-result-object v5

    .line 66
    .local v5, "realLocalPath":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 67
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    invoke-virtual {v7, v5}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 68
    .local v6, "sourceEtag":Ljava/lang/String;
    if-eqz v6, :cond_1

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 69
    :cond_1
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    invoke-virtual {v7, v5, v3}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->updateValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    .end local v6    # "sourceEtag":Ljava/lang/String;
    :cond_2
    :goto_0
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    iget-wide v8, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    invoke-virtual {v7, v8, v9}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setRange(J)V

    .line 75
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    iget-object v8, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    invoke-virtual {v7, v8}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V

    .line 76
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    iget-object v8, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-interface {v7, v8}, Lcom/tencent/cos/xml/CosXml;->getObject(Lcom/tencent/cos/xml/model/object/GetObjectRequest;)Lcom/tencent/cos/xml/model/object/GetObjectResult;

    move-result-object v0

    .line 77
    .local v0, "getObjectResult":Lcom/tencent/cos/xml/model/object/GetObjectResult;
    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/Downloader;->sharePreferedUtils:Lcom/tencent/cos/xml/utils/SharePreferenceUtils;

    invoke-virtual {v7, v5}, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->clear(Ljava/lang/String;)V

    .line 78
    return-object v0

    .line 71
    .end local v0    # "getObjectResult":Lcom/tencent/cos/xml/model/object/GetObjectResult;
    .restart local v6    # "sourceEtag":Ljava/lang/String;
    :cond_3
    invoke-direct {p0, v5}, Lcom/tencent/cos/xml/transfer/Downloader;->getRange(Ljava/lang/String;)J

    move-result-wide v8

    iput-wide v8, p0, Lcom/tencent/cos/xml/transfer/Downloader;->rangeStart:J

    goto :goto_0
.end method

.method public download(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 5
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "localPath"    # Ljava/lang/String;
    .param p4, "localFileName"    # Ljava/lang/String;
    .param p5, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/Downloader;->bucket:Ljava/lang/String;

    .line 84
    iput-object p2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosPath:Ljava/lang/String;

    .line 85
    iput-object p3, p0, Lcom/tencent/cos/xml/transfer/Downloader;->localPath:Ljava/lang/String;

    .line 86
    iput-object p4, p0, Lcom/tencent/cos/xml/transfer/Downloader;->localFileName:Ljava/lang/String;

    .line 87
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    invoke-virtual {v2, p5}, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->setCosXmlResultListener(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 89
    :try_start_0
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/Downloader;->checkParameters()V
    :try_end_0
    .catch Lcom/tencent/cos/xml/exception/CosXmlClientException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    new-instance v2, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-direct {v2, p1, p2, p3, p4}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    .line 95
    new-instance v1, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;

    invoke-direct {v1, p1, p2}, Lcom/tencent/cos/xml/model/object/HeadObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    .local v1, "headObjectRequest":Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->cosXmlServer:Lcom/tencent/cos/xml/CosXml;

    new-instance v3, Lcom/tencent/cos/xml/transfer/Downloader$1;

    invoke-direct {v3, p0}, Lcom/tencent/cos/xml/transfer/Downloader$1;-><init>(Lcom/tencent/cos/xml/transfer/Downloader;)V

    invoke-interface {v2, v1, v3}, Lcom/tencent/cos/xml/CosXml;->headObjectAsync(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 125
    .end local v1    # "headObjectRequest":Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    :goto_0
    return-void

    .line 90
    :catch_0
    move-exception v0

    .line 91
    .local v0, "e":Lcom/tencent/cos/xml/exception/CosXmlClientException;
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/Downloader;->getObjectRequest:Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v0, v4}, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    goto :goto_0
.end method

.method public setProgress(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 1
    .param p1, "cosXmlProgressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/Downloader;->listenerHandler:Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;

    invoke-virtual {v0, p1}, Lcom/tencent/cos/xml/transfer/Downloader$ListenerHandler;->setCosXmlProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V

    .line 47
    return-void
.end method
