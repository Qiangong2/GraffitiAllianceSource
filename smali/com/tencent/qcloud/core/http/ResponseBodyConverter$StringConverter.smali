.class final Lcom/tencent/qcloud/core/http/ResponseBodyConverter$StringConverter;
.super Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
.source "ResponseBodyConverter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/ResponseBodyConverter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "StringConverter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/tencent/qcloud/core/http/ResponseBodyConverter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/tencent/qcloud/core/http/ResponseBodyConverter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/tencent/qcloud/core/http/ResponseBodyConverter$1;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter$StringConverter;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 25
    invoke-virtual {p0, p1}, Lcom/tencent/qcloud/core/http/ResponseBodyConverter$StringConverter;->convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected convert(Lcom/tencent/qcloud/core/http/HttpResponse;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/qcloud/core/http/HttpResponse",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;,
            Lcom/tencent/qcloud/core/common/QCloudServiceException;
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "response":Lcom/tencent/qcloud/core/http/HttpResponse;, "Lcom/tencent/qcloud/core/http/HttpResponse<Ljava/lang/String;>;"
    :try_start_0
    invoke-virtual {p1}, Lcom/tencent/qcloud/core/http/HttpResponse;->string()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 30
    :catch_0
    move-exception v0

    .line 31
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/qcloud/core/common/QCloudClientException;

    invoke-direct {v1, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
