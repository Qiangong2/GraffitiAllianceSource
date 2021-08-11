.class final Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;
.super Ljava/lang/Object;
.source "QCloudHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/QCloudHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Builder"
.end annotation


# instance fields
.field connectionTimeout:I

.field socketTimeout:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 134
    const/16 v0, 0x3a98

    iput v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->connectionTimeout:I

    .line 135
    const/16 v0, 0x7530

    iput v0, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->socketTimeout:I

    .line 138
    return-void
.end method


# virtual methods
.method public build()Lcom/tencent/qcloud/core/http/QCloudHttpClient;
    .locals 2

    .prologue
    .line 157
    new-instance v0, Lcom/tencent/qcloud/core/http/QCloudHttpClient;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/tencent/qcloud/core/http/QCloudHttpClient;-><init>(Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;Lcom/tencent/qcloud/core/http/QCloudHttpClient$1;)V

    return-object v0
.end method

.method public setConnectionTimeout(I)Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;
    .locals 2
    .param p1, "connectionTimeout"    # I

    .prologue
    .line 141
    const/16 v0, 0x2710

    if-ge p1, v0, :cond_0

    .line 142
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "connection timeout must be larger than 10 seconds."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 144
    :cond_0
    iput p1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->connectionTimeout:I

    .line 145
    return-object p0
.end method

.method public setSocketTimeout(I)Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;
    .locals 2
    .param p1, "socketTimeout"    # I

    .prologue
    .line 149
    const/16 v0, 0x2710

    if-ge p1, v0, :cond_0

    .line 150
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "socket timeout must be larger than 10 seconds."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 152
    :cond_0
    iput p1, p0, Lcom/tencent/qcloud/core/http/QCloudHttpClient$Builder;->socketTimeout:I

    .line 153
    return-object p0
.end method
