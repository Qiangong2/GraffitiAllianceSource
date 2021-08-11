.class Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;
.super Ljava/lang/Object;
.source "QCloudHttpClient.java"

# interfaces
.implements Ljavax/net/ssl/HostnameVerifier;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/QCloudHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/http/QCloudHttpClient;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;->this$0:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z
    .locals 3
    .param p1, "hostname"    # Ljava/lang/String;
    .param p2, "session"    # Ljavax/net/ssl/SSLSession;

    .prologue
    .line 42
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;->this$0:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-static {v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->access$000(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 43
    iget-object v1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;->this$0:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-static {v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;->access$000(Lcom/tencent/qcloud/core/http/QCloudHttpClient;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 44
    .local v0, "host":Ljava/lang/String;
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v2

    invoke-interface {v2, v0, p2}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    const/4 v1, 0x1

    .line 49
    .end local v0    # "host":Ljava/lang/String;
    :goto_0
    return v1

    :cond_1
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z

    move-result v1

    goto :goto_0
.end method
