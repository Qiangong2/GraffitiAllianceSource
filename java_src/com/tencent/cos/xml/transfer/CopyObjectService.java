package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CopyObjectService {
    private CosXmlService cosXmlService;
    private long maxSliceSize = 5242880;

    public CopyObjectService(CosXmlService cosXmlService2) {
        this.cosXmlService = cosXmlService2;
    }

    public CosXmlResult copyObject(String bucket, String cosPath, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException, CosXmlServiceException {
        long sourceLength = headObject(copySourceStruct.bucket, copySourceStruct.cosPath);
        if (sourceLength >= this.maxSliceSize) {
            return copyObjectForLargeFile(bucket, cosPath, copySourceStruct, sourceLength);
        }
        return copyObjectForSmallFile(bucket, cosPath, copySourceStruct);
    }

    public CosXmlResult copyObject(String bucket, String cosPath, CopyObjectRequest.CopySourceStruct copySourceStruct, long sourceObjectLength) throws CosXmlClientException, CosXmlServiceException {
        if (sourceObjectLength >= this.maxSliceSize) {
            return copyObjectForLargeFile(bucket, cosPath, copySourceStruct, sourceObjectLength);
        }
        return copyObjectForSmallFile(bucket, cosPath, copySourceStruct);
    }

    private long headObject(String bucket, String cosPath) throws CosXmlServiceException, CosXmlClientException {
        HeadObjectResult headObjectResult = this.cosXmlService.headObject(new HeadObjectRequest(bucket, cosPath));
        if (headObjectResult != null) {
            return Long.valueOf((String) ((List) headObjectResult.headers.get(HttpConstants.Header.CONTENT_LENGTH)).get(0)).longValue();
        }
        return -1;
    }

    private CopyObjectResult copyObjectForSmallFile(String bucket, String cosPath, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.copyObject(new CopyObjectRequest(bucket, cosPath, copySourceStruct));
    }

    private CompleteMultiUploadResult copyObjectForLargeFile(String bucket, String cosPath, CopyObjectRequest.CopySourceStruct copySourceStruct, long sourceLength) throws CosXmlClientException, CosXmlServiceException {
        String uploadId = initMultiUpload(bucket, cosPath);
        Map<Integer, String> partNumberAndEtag = new LinkedHashMap<>();
        int partNumber = 1;
        long end = -1;
        long sliceSize = this.maxSliceSize;
        while (end < sourceLength - 1) {
            long start = end + 1;
            end = end + sliceSize >= sourceLength - 1 ? sourceLength - 1 : end + sliceSize;
            partNumberAndEtag.put(Integer.valueOf(partNumber), copyObjectForLargeFile(bucket, cosPath, partNumber, uploadId, copySourceStruct, start, end).copyObject.eTag);
            partNumber++;
        }
        return completeMultipart(bucket, cosPath, uploadId, partNumberAndEtag);
    }

    private String initMultiUpload(String bucket, String cosPath) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.initMultipartUpload(new InitMultipartUploadRequest(bucket, cosPath)).initMultipartUpload.uploadId;
    }

    private UploadPartCopyResult copyObjectForLargeFile(String bucket, String cosPath, int partNumber, String uploadId, CopyObjectRequest.CopySourceStruct copySourceStruct, long start, long end) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.copyObject(new UploadPartCopyRequest(bucket, cosPath, partNumber, uploadId, copySourceStruct, start, end));
    }

    private CompleteMultiUploadResult completeMultipart(String bucket, String cosPath, String uploadId, Map<Integer, String> partNumberAndEtag) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.completeMultiUpload(new CompleteMultiUploadRequest(bucket, cosPath, uploadId, partNumberAndEtag));
    }
}
