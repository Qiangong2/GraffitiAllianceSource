.class public abstract Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.super Lcom/tencent/cos/xml/model/CosXmlRequest;
.source "BucketRequest.java"


# instance fields
.field protected bucket:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/tencent/cos/xml/model/CosXmlRequest;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->bucket:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method public checkParameters()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->bucket:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "bucket must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_0
    return-void
.end method

.method public getHostPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->bucket:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    const-string v0, "/"

    return-object v0
.end method
