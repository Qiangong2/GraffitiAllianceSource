.class Lcom/tencent/qcloud/core/http/QCloudHttpClient$2;
.super Ljava/lang/Object;
.source "QCloudHttpClient.java"

# interfaces
.implements Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/qcloud/core/http/QCloudHttpClient;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;)V
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
    .line 82
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$2;->this$0:Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public log(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 85
    const-string v0, "QCloudHttp"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, p1, v1}, Lcom/tencent/qcloud/core/logger/QCloudLogger;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 86
    return-void
.end method
