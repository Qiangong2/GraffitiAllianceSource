.class public interface abstract Lcom/tencent/cos/xml/CosXml;
.super Ljava/lang/Object;
.source "CosXml.java"

# interfaces
.implements Lcom/tencent/cos/xml/SimpleCosXml;


# virtual methods
.method public abstract copyObject(Lcom/tencent/cos/xml/model/object/CopyObjectRequest;)Lcom/tencent/cos/xml/model/object/CopyObjectResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract copyObject(Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;)Lcom/tencent/cos/xml/model/object/UploadPartCopyResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract copyObjectAsync(Lcom/tencent/cos/xml/model/object/CopyObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract copyObjectAsync(Lcom/tencent/cos/xml/model/object/UploadPartCopyRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract deleteBucket(Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract deleteBucketAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract deleteBucketCORS(Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract deleteBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract deleteBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract deleteBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract deleteBucketReplication(Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract deleteBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/DeleteBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract deleteMultiObject(Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;)Lcom/tencent/cos/xml/model/object/DeleteMultiObjectResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract deleteMultiObjectAsync(Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucket(Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketACL(Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketACLResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketACLAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketCORS(Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketCORSResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketLocation(Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketLocationResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketLocationAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketLocationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketReplication(Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getBucketVersioning(Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;)Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getBucketVersioningAsync(Lcom/tencent/cos/xml/model/bucket/GetBucketVersioningRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getObjectACL(Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;)Lcom/tencent/cos/xml/model/object/GetObjectACLResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getObjectACLAsync(Lcom/tencent/cos/xml/model/object/GetObjectACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract getService(Lcom/tencent/cos/xml/model/service/GetServiceRequest;)Lcom/tencent/cos/xml/model/service/GetServiceResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract getServiceAsync(Lcom/tencent/cos/xml/model/service/GetServiceRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract headBucket(Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;)Lcom/tencent/cos/xml/model/bucket/HeadBucketResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract headBucketAsync(Lcom/tencent/cos/xml/model/bucket/HeadBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract headObject(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;)Lcom/tencent/cos/xml/model/object/HeadObjectResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract headObjectAsync(Lcom/tencent/cos/xml/model/object/HeadObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract listBucketVersions(Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;)Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract listBucketVersionsAsync(Lcom/tencent/cos/xml/model/bucket/ListBucketVersionsRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract listMultiUploads(Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;)Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract listMultiUploadsAsync(Lcom/tencent/cos/xml/model/bucket/ListMultiUploadsRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract optionObject(Lcom/tencent/cos/xml/model/object/OptionObjectRequest;)Lcom/tencent/cos/xml/model/object/OptionObjectResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract optionObjectAsync(Lcom/tencent/cos/xml/model/object/OptionObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucket(Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putBucketACL(Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketACLResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putBucketACLAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketCORS(Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketCORSResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putBucketCORSAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketCORSRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketLifecycle(Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putBucketLifecycleAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketReplication(Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putBucketReplicationAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketVersionAsync(Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract putBucketVersioning(Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningRequest;)Lcom/tencent/cos/xml/model/bucket/PutBucketVersioningResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putObjectACL(Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;)Lcom/tencent/cos/xml/model/object/PutObjectACLResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract putObjectACLAsync(Lcom/tencent/cos/xml/model/object/PutObjectACLRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method

.method public abstract restoreObject(Lcom/tencent/cos/xml/model/object/RestoreRequest;)Lcom/tencent/cos/xml/model/object/RestoreResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation
.end method

.method public abstract restoreObjectAsync(Lcom/tencent/cos/xml/model/object/RestoreRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
.end method
