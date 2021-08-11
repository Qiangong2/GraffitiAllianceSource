.class public Lcom/tencent/cos/xml/CosXmlService;
.super Lcom/tencent/cos/xml/CosXmlSimpleService;
.source "CosXmlService.java"

# interfaces
.implements Lcom/tencent/cos/xml/CosXml;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/tencent/cos/xml/CosXmlServiceConfig;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/tencent/cos/xml/CosXmlServiceConfig;
    .param p3, "qCloudCredentialProvider"    # Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;

    .prologue
    .line 87
    invoke-direct {p0, p1, p2, p3}, Lcom/tencent/cos/xml/CosXmlSimpleService;-><init>(Landroid/content/Context;Lcom/tencent/cos/xml/CosXmlServiceConfig;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)V

    .line 88
    return-void
.end method


# virtual methods
.method public copyObject(Lcom/tencent/cos/xml/model/object/CopyObjectRequest;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 277
    new-instance v0, Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/CopyObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    return-object v0
.end method

.method public copyObject(Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;)Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 301
    new-instance v0, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;

    return-object v0
.end method

.method public copyObjectAsync(Lcom/tencent/cos/xml/model/object/CopyObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/CopyObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 289
    new-instance v0, Lcom/tencent/cos/xml/model/object/CopyObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/CopyObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 290
    return-void
.end method

.method public copyObjectAsync(Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 313
    new-instance v0, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 314
    return-void
.end method

.method public deleteBucket(Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 383
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;

    return-object v0
.end method

.method public deleteBucketAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 395
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 396
    return-void
.end method

.method public deleteBucketCORS(Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 335
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;

    return-object v0
.end method

.method public deleteBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 347
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 348
    return-void
.end method

.method public deleteBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 359
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;

    return-object v0
.end method

.method public deleteBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 371
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 372
    return-void
.end method

.method public deleteBucketReplication(Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 825
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;

    return-object v0
.end method

.method public deleteBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 837
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 838
    return-void
.end method

.method public deleteMultiObject(Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;)Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 157
    new-instance v0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;

    return-object v0
.end method

.method public deleteMultiObjectAsync(Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 169
    new-instance v0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 170
    return-void
.end method

.method public getBucket(Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 527
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketResult;

    return-object v0
.end method

.method public getBucketACL(Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 431
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;

    return-object v0
.end method

.method public getBucketACLAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 443
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 444
    return-void
.end method

.method public getBucketAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 539
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 540
    return-void
.end method

.method public getBucketCORS(Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 455
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;

    return-object v0
.end method

.method public getBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 467
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 468
    return-void
.end method

.method public getBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 479
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;

    return-object v0
.end method

.method public getBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 491
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 492
    return-void
.end method

.method public getBucketLocation(Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 503
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;

    return-object v0
.end method

.method public getBucketLocationAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 515
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 516
    return-void
.end method

.method public getBucketReplication(Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 777
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;

    return-object v0
.end method

.method public getBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 789
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 790
    return-void
.end method

.method public getBucketVersioning(Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 729
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;

    return-object v0
.end method

.method public getBucketVersioningAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 741
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 742
    return-void
.end method

.method public getObjectACL(Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;)Lcom/tencent/cos/xml/model/object/GetObjectACLResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 181
    new-instance v0, Lcom/tencent/cos/xml/model/object/GetObjectACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/GetObjectACLResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/GetObjectACLResult;

    return-object v0
.end method

.method public getObjectACLAsync(Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 193
    new-instance v0, Lcom/tencent/cos/xml/model/object/GetObjectACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/GetObjectACLResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 194
    return-void
.end method

.method public getService(Lcom/tencent/cos/xml/model/service/GetServiceRequest;)Lcom/tencent/cos/xml/model/service/GetServiceResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/service/GetServiceRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 99
    new-instance v0, Lcom/tencent/cos/xml/model/service/GetServiceResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/service/GetServiceResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/service/GetServiceResult;

    return-object v0
.end method

.method public getServiceAsync(Lcom/tencent/cos/xml/model/service/GetServiceRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/service/GetServiceRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 111
    new-instance v0, Lcom/tencent/cos/xml/model/service/GetServiceResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/service/GetServiceResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 112
    return-void
.end method

.method public headBucket(Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;)Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 575
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;

    return-object v0
.end method

.method public headBucketAsync(Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 587
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 588
    return-void
.end method

.method public headObject(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;)Lcom/tencent/cos/xml/model/object/HeadObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 205
    new-instance v0, Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/HeadObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    return-object v0
.end method

.method public headObjectAsync(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/HeadObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 217
    new-instance v0, Lcom/tencent/cos/xml/model/object/HeadObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/HeadObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 218
    return-void
.end method

.method public listBucketVersions(Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;)Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 849
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;

    return-object v0
.end method

.method public listBucketVersionsAsync(Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 861
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 862
    return-void
.end method

.method public listMultiUploads(Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;)Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 599
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;

    return-object v0
.end method

.method public listMultiUploadsAsync(Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 611
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 612
    return-void
.end method

.method public optionObject(Lcom/tencent/cos/xml/model/object/OptionObjectRequest;)Lcom/tencent/cos/xml/model/object/OptionObjectResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/OptionObjectRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 229
    new-instance v0, Lcom/tencent/cos/xml/model/object/OptionObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/OptionObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/OptionObjectResult;

    return-object v0
.end method

.method public optionObjectAsync(Lcom/tencent/cos/xml/model/object/OptionObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/OptionObjectRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 241
    new-instance v0, Lcom/tencent/cos/xml/model/object/OptionObjectResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/OptionObjectResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 242
    return-void
.end method

.method public putBucket(Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 695
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketResult;

    return-object v0
.end method

.method public putBucketACL(Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 623
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;

    return-object v0
.end method

.method public putBucketACLAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 635
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 636
    return-void
.end method

.method public putBucketAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 707
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 708
    return-void
.end method

.method public putBucketCORS(Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 647
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;

    return-object v0
.end method

.method public putBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 659
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 660
    return-void
.end method

.method public putBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 671
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;

    return-object v0
.end method

.method public putBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 683
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 684
    return-void
.end method

.method public putBucketReplication(Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 801
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;

    return-object v0
.end method

.method public putBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 813
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 814
    return-void
.end method

.method public putBucketVersionAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 765
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 766
    return-void
.end method

.method public putBucketVersioning(Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 753
    new-instance v0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;

    return-object v0
.end method

.method public putObjectACL(Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;)Lcom/tencent/cos/xml/model/object/PutObjectACLResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 253
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/PutObjectACLResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/PutObjectACLResult;

    return-object v0
.end method

.method public putObjectACLAsync(Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 265
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectACLResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/PutObjectACLResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 266
    return-void
.end method

.method public restoreObject(Lcom/tencent/cos/xml/model/object/RestoreRequest;)Lcom/tencent/cos/xml/model/object/RestoreResult;
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/RestoreRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 318
    new-instance v0, Lcom/tencent/cos/xml/model/object/RestoreResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/RestoreResult;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/tencent/cos/xml/CosXmlService;->execute(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;)Lcom/tencent/cos/xml/model/CosXmlResult;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/object/RestoreResult;

    return-object v0
.end method

.method public restoreObjectAsync(Lcom/tencent/cos/xml/model/object/RestoreRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "request"    # Lcom/tencent/cos/xml/model/object/RestoreRequest;
    .param p2, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 323
    new-instance v0, Lcom/tencent/cos/xml/model/object/RestoreResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/object/RestoreResult;-><init>()V

    invoke-virtual {p0, p1, v0, p2}, Lcom/tencent/cos/xml/CosXmlService;->schedule(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/model/CosXmlResult;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 324
    return-void
.end method
