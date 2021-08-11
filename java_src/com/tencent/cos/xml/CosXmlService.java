package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketResult;
import com.tencent.cos.xml.model.bucket.GetBucketACLRequest;
import com.tencent.cos.xml.model.bucket.GetBucketACLResult;
import com.tencent.cos.xml.model.bucket.GetBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.GetBucketCORSResult;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.GetBucketLocationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLocationResult;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.GetBucketRequest;
import com.tencent.cos.xml.model.bucket.GetBucketResult;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningResult;
import com.tencent.cos.xml.model.bucket.HeadBucketRequest;
import com.tencent.cos.xml.model.bucket.HeadBucketResult;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsRequest;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsResult;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsRequest;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsResult;
import com.tencent.cos.xml.model.bucket.PutBucketACLRequest;
import com.tencent.cos.xml.model.bucket.PutBucketACLResult;
import com.tencent.cos.xml.model.bucket.PutBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.PutBucketCORSResult;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.PutBucketRequest;
import com.tencent.cos.xml.model.bucket.PutBucketResult;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.DeleteMultiObjectRequest;
import com.tencent.cos.xml.model.object.DeleteMultiObjectResult;
import com.tencent.cos.xml.model.object.GetObjectACLRequest;
import com.tencent.cos.xml.model.object.GetObjectACLResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.OptionObjectRequest;
import com.tencent.cos.xml.model.object.OptionObjectResult;
import com.tencent.cos.xml.model.object.PutObjectACLRequest;
import com.tencent.cos.xml.model.object.PutObjectACLResult;
import com.tencent.cos.xml.model.object.RestoreRequest;
import com.tencent.cos.xml.model.object.RestoreResult;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.cos.xml.model.service.GetServiceRequest;
import com.tencent.cos.xml.model.service.GetServiceResult;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;

public class CosXmlService extends CosXmlSimpleService implements CosXml {
    public CosXmlService(Context context, CosXmlServiceConfig configuration, QCloudCredentialProvider qCloudCredentialProvider) {
        super(context, configuration, qCloudCredentialProvider);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetServiceResult getService(GetServiceRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetServiceResult) execute(request, new GetServiceResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getServiceAsync(GetServiceRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetServiceResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteMultiObjectResult deleteMultiObject(DeleteMultiObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteMultiObjectResult) execute(request, new DeleteMultiObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteMultiObjectAsync(DeleteMultiObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteMultiObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetObjectACLResult getObjectACL(GetObjectACLRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectACLResult) execute(request, new GetObjectACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getObjectACLAsync(GetObjectACLRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetObjectACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public HeadObjectResult headObject(HeadObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (HeadObjectResult) execute(request, new HeadObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void headObjectAsync(HeadObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new HeadObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public OptionObjectResult optionObject(OptionObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (OptionObjectResult) execute(request, new OptionObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void optionObjectAsync(OptionObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new OptionObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutObjectACLResult putObjectACL(PutObjectACLRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutObjectACLResult) execute(request, new PutObjectACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putObjectACLAsync(PutObjectACLRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutObjectACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public CopyObjectResult copyObject(CopyObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (CopyObjectResult) execute(request, new CopyObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void copyObjectAsync(CopyObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new CopyObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public UploadPartCopyResult copyObject(UploadPartCopyRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartCopyResult) execute(request, new UploadPartCopyResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void copyObjectAsync(UploadPartCopyRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new UploadPartCopyResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public RestoreResult restoreObject(RestoreRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (RestoreResult) execute(request, new RestoreResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void restoreObjectAsync(RestoreRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new RestoreResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketCORSResult deleteBucketCORS(DeleteBucketCORSRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketCORSResult) execute(request, new DeleteBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketCORSAsync(DeleteBucketCORSRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketLifecycleResult) execute(request, new DeleteBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketLifecycleAsync(DeleteBucketLifecycleRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketResult deleteBucket(DeleteBucketRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketResult) execute(request, new DeleteBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketAsync(DeleteBucketRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketACLResult getBucketACL(GetBucketACLRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketACLResult) execute(request, new GetBucketACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketACLAsync(GetBucketACLRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketCORSResult getBucketCORS(GetBucketCORSRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketCORSResult) execute(request, new GetBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketCORSAsync(GetBucketCORSRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLifecycleResult) execute(request, new GetBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketLifecycleAsync(GetBucketLifecycleRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketLocationResult getBucketLocation(GetBucketLocationRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLocationResult) execute(request, new GetBucketLocationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketLocationAsync(GetBucketLocationRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketLocationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketResult getBucket(GetBucketRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketResult) execute(request, new GetBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketAsync(GetBucketRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public HeadBucketResult headBucket(HeadBucketRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (HeadBucketResult) execute(request, new HeadBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void headBucketAsync(HeadBucketRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new HeadBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public ListMultiUploadsResult listMultiUploads(ListMultiUploadsRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (ListMultiUploadsResult) execute(request, new ListMultiUploadsResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void listMultiUploadsAsync(ListMultiUploadsRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new ListMultiUploadsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketACLResult putBucketACL(PutBucketACLRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketACLResult) execute(request, new PutBucketACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketACLAsync(PutBucketACLRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketCORSResult putBucketCORS(PutBucketCORSRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketCORSResult) execute(request, new PutBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketCORSAsync(PutBucketCORSRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketLifecycleResult) execute(request, new PutBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketLifecycleAsync(PutBucketLifecycleRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketResult putBucket(PutBucketRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketResult) execute(request, new PutBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketAsync(PutBucketRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketVersioningResult getBucketVersioning(GetBucketVersioningRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketVersioningResult) execute(request, new GetBucketVersioningResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketVersioningAsync(GetBucketVersioningRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketVersioningResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketVersioningResult putBucketVersioning(PutBucketVersioningRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketVersioningResult) execute(request, new PutBucketVersioningResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketVersionAsync(PutBucketVersioningRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketVersioningResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketReplicationResult getBucketReplication(GetBucketReplicationRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketReplicationResult) execute(request, new GetBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketReplicationAsync(GetBucketReplicationRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketReplicationResult putBucketReplication(PutBucketReplicationRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketReplicationResult) execute(request, new PutBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketReplicationAsync(PutBucketReplicationRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new PutBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketReplicationResult deleteBucketReplication(DeleteBucketReplicationRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketReplicationResult) execute(request, new DeleteBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketReplicationAsync(DeleteBucketReplicationRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public ListBucketVersionsResult listBucketVersions(ListBucketVersionsRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (ListBucketVersionsResult) execute(request, new ListBucketVersionsResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void listBucketVersionsAsync(ListBucketVersionsRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new ListBucketVersionsResult(), cosXmlResultListener);
    }
}
