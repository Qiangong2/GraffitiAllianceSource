package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.tag.ListParts;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UploadService {
    private static final long SIZE_LIMIT = 2097152;
    private AtomicLong ALREADY_SEND_DATA_LEN;
    private volatile int ERROR_EXIT_FLAG;
    private AtomicInteger UPLOAD_PART_COUNT;
    private String bucket;
    private CompleteMultiUploadRequest completeMultiUploadRequest;
    private String cosPath;
    private CosXmlProgressListener cosXmlProgressListener;
    private CosXmlSimpleService cosXmlService;
    private long endTime = -1;
    private long fileLength;
    private List<String> headers = new ArrayList();
    private InitMultipartUploadRequest initMultipartUploadRequest;
    private ListPartsRequest listPartsRequest;
    private Exception mException;
    private byte[] objectSync = new byte[0];
    private Map<Integer, SlicePartStruct> partStructMap;
    private PutObjectRequest putObjectRequest;
    private long sliceSize = SIZE_LIMIT;
    private String srcPath;
    private long startTime = -1;
    private String uploadId;
    private Map<UploadPartRequest, Long> uploadPartRequestLongMap;
    private UploadServiceResult uploadServiceResult;

    public static class ResumeData {
        public String bucket;
        public String cosPath;
        public long sliceSize;
        public String srcPath;
        public String uploadId;
    }

    public UploadService(CosXmlSimpleService cosXmlService2, ResumeData resumeData) {
        this.cosXmlService = cosXmlService2;
        init(resumeData);
    }

    private void init(ResumeData resumeData) {
        this.bucket = resumeData.bucket;
        this.cosPath = resumeData.cosPath;
        this.srcPath = resumeData.srcPath;
        this.sliceSize = resumeData.sliceSize;
        this.uploadId = resumeData.uploadId;
        this.UPLOAD_PART_COUNT = new AtomicInteger(0);
        this.ALREADY_SEND_DATA_LEN = new AtomicLong(0);
        this.ERROR_EXIT_FLAG = 0;
        this.partStructMap = new LinkedHashMap();
        this.uploadPartRequestLongMap = new LinkedHashMap();
    }

    private void checkParameter() throws CosXmlClientException {
        if (this.srcPath != null) {
            File file = new File(this.srcPath);
            if (file.exists()) {
                this.fileLength = file.length();
                return;
            }
        }
        throw new CosXmlClientException("srcPath :" + this.srcPath + " is invalid or is not exist");
    }

    public void setSign(long startTime2, long endTime2) {
        this.startTime = startTime2;
        this.endTime = endTime2;
    }

    private void setSignTime(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest != null && this.startTime > 0 && this.endTime >= this.startTime) {
            cosXmlRequest.setSign(this.startTime, this.endTime);
        }
    }

    public void setRequestHeaders(String key, String value) {
        if (key != null && value != null) {
            this.headers.add(key);
            this.headers.add(value);
        }
    }

    private void setRequestHeaders(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (cosXmlRequest != null) {
            int size = this.headers.size();
            for (int i = 0; i < size - 2; i += 2) {
                cosXmlRequest.setRequestHeaders(this.headers.get(i), this.headers.get(i + 1));
            }
        }
    }

    public UploadServiceResult upload() throws CosXmlClientException, CosXmlServiceException {
        checkParameter();
        if (this.fileLength < SIZE_LIMIT) {
            return putObject(this.bucket, this.cosPath, this.srcPath);
        }
        return multiUploadParts();
    }

    public CosXmlResult resume(ResumeData resumeData) throws CosXmlServiceException, CosXmlClientException {
        init(resumeData);
        return upload();
    }

    public ResumeData pause() {
        this.ERROR_EXIT_FLAG = 2;
        ResumeData resumeData = new ResumeData();
        resumeData.bucket = this.bucket;
        resumeData.cosPath = this.cosPath;
        resumeData.sliceSize = this.sliceSize;
        resumeData.srcPath = this.srcPath;
        resumeData.uploadId = this.uploadId;
        return resumeData;
    }

    public void abort(CosXmlResultListener cosXmlResultListener) {
        this.ERROR_EXIT_FLAG = 3;
        abortMultiUpload(cosXmlResultListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clear() {
        this.putObjectRequest = null;
        this.initMultipartUploadRequest = null;
        this.listPartsRequest = null;
        this.completeMultiUploadRequest = null;
        this.partStructMap.clear();
        this.uploadPartRequestLongMap.clear();
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener2) {
        this.cosXmlProgressListener = cosXmlProgressListener2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.cos.xml.transfer.UploadService.UploadServiceResult putObject(java.lang.String r4, java.lang.String r5, java.lang.String r6) throws com.tencent.cos.xml.exception.CosXmlClientException, com.tencent.cos.xml.exception.CosXmlServiceException {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.UploadService.putObject(java.lang.String, java.lang.String, java.lang.String):com.tencent.cos.xml.transfer.UploadService$UploadServiceResult");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.cos.xml.transfer.UploadService.UploadServiceResult multiUploadParts() throws com.tencent.cos.xml.exception.CosXmlClientException, com.tencent.cos.xml.exception.CosXmlServiceException {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.UploadService.multiUploadParts():com.tencent.cos.xml.transfer.UploadService$UploadServiceResult");
    }

    private InitMultipartUploadResult initMultiUpload() throws CosXmlServiceException, CosXmlClientException {
        this.initMultipartUploadRequest = new InitMultipartUploadRequest(this.bucket, this.cosPath);
        setSignTime(this.initMultipartUploadRequest);
        setRequestHeaders(this.initMultipartUploadRequest);
        return this.cosXmlService.initMultipartUpload(this.initMultipartUploadRequest);
    }

    private ListPartsResult listPart() throws CosXmlServiceException, CosXmlClientException {
        this.listPartsRequest = new ListPartsRequest(this.bucket, this.cosPath, this.uploadId);
        setSignTime(this.listPartsRequest);
        setRequestHeaders(this.listPartsRequest);
        return this.cosXmlService.listParts(this.listPartsRequest);
    }

    private void uploadPart(int partNumber, long offset, long contentLength, CosXmlResultListener cosXmlResultListener) {
        final UploadPartRequest uploadPartRequest = new UploadPartRequest(this.bucket, this.cosPath, partNumber, this.srcPath, offset, contentLength, this.uploadId);
        this.uploadPartRequestLongMap.put(uploadPartRequest, 0L);
        setSignTime(uploadPartRequest);
        try {
            setRequestHeaders(uploadPartRequest);
            uploadPartRequest.setProgressListener(new CosXmlProgressListener() {
                /* class com.tencent.cos.xml.transfer.UploadService.C13153 */

                @Override // com.tencent.qcloud.core.common.QCloudProgressListener
                public void onProgress(long complete, long target) {
                    synchronized (UploadService.this.objectSync) {
                        long dataLen = UploadService.this.ALREADY_SEND_DATA_LEN.addAndGet(complete - ((Long) UploadService.this.uploadPartRequestLongMap.get(uploadPartRequest)).longValue());
                        UploadService.this.uploadPartRequestLongMap.put(uploadPartRequest, Long.valueOf(complete));
                        if (UploadService.this.cosXmlProgressListener != null) {
                            UploadService.this.cosXmlProgressListener.onProgress(dataLen, UploadService.this.fileLength);
                        }
                    }
                }
            });
            this.cosXmlService.uploadPartAsync(uploadPartRequest, cosXmlResultListener);
        } catch (CosXmlClientException e) {
            cosXmlResultListener.onFail(this.putObjectRequest, e, null);
        }
    }

    private CompleteMultiUploadResult completeMultiUpload() throws CosXmlServiceException, CosXmlClientException {
        this.completeMultiUploadRequest = new CompleteMultiUploadRequest(this.bucket, this.cosPath, this.uploadId, null);
        for (Map.Entry<Integer, SlicePartStruct> entry : this.partStructMap.entrySet()) {
            SlicePartStruct slicePartStruct = entry.getValue();
            this.completeMultiUploadRequest.setPartNumberAndETag(slicePartStruct.partNumber, slicePartStruct.eTag);
        }
        setSignTime(this.completeMultiUploadRequest);
        setRequestHeaders(this.completeMultiUploadRequest);
        return this.cosXmlService.completeMultiUpload(this.completeMultiUploadRequest);
    }

    private void abortMultiUpload(final CosXmlResultListener cosXmlResultListener) {
        if (this.uploadId != null) {
            AbortMultiUploadRequest abortMultiUploadRequest = new AbortMultiUploadRequest(this.bucket, this.cosPath, this.uploadId);
            setSignTime(abortMultiUploadRequest);
            try {
                setRequestHeaders(abortMultiUploadRequest);
                this.cosXmlService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() {
                    /* class com.tencent.cos.xml.transfer.UploadService.C13164 */

                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onSuccess(CosXmlRequest request, CosXmlResult result) {
                        cosXmlResultListener.onSuccess(request, result);
                        UploadService.this.realCancel();
                        UploadService.this.clear();
                    }

                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onFail(CosXmlRequest request, CosXmlClientException exception, CosXmlServiceException serviceException) {
                        cosXmlResultListener.onFail(request, exception, serviceException);
                        UploadService.this.realCancel();
                        UploadService.this.clear();
                    }
                });
            } catch (CosXmlClientException e) {
                cosXmlResultListener.onFail(abortMultiUploadRequest, e, null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void realCancel() {
        this.cosXmlService.cancel(this.putObjectRequest);
        this.cosXmlService.cancel(this.initMultipartUploadRequest);
        this.cosXmlService.cancel(this.listPartsRequest);
        this.cosXmlService.cancel(this.completeMultiUploadRequest);
        if (this.uploadPartRequestLongMap != null) {
            for (UploadPartRequest uploadPartRequest : this.uploadPartRequestLongMap.keySet()) {
                this.cosXmlService.cancel(uploadPartRequest);
            }
        }
    }

    private void initSlicePart() throws CosXmlClientException {
        if (this.srcPath != null) {
            File file = new File(this.srcPath);
            if (!file.exists()) {
                throw new CosXmlClientException("upload file does not exist");
            }
            this.fileLength = file.length();
        }
        if (this.fileLength <= 0 || this.sliceSize <= 0) {
            throw new CosXmlClientException("file size or slice size less than 0");
        }
        int count = (int) (this.fileLength / this.sliceSize);
        int i = 1;
        while (i < count) {
            SlicePartStruct slicePartStruct = new SlicePartStruct();
            slicePartStruct.isAlreadyUpload = false;
            slicePartStruct.partNumber = i;
            slicePartStruct.offset = ((long) (i - 1)) * this.sliceSize;
            slicePartStruct.sliceSize = this.sliceSize;
            this.partStructMap.put(Integer.valueOf(i), slicePartStruct);
            i++;
        }
        SlicePartStruct slicePartStruct2 = new SlicePartStruct();
        slicePartStruct2.isAlreadyUpload = false;
        slicePartStruct2.partNumber = i;
        slicePartStruct2.offset = ((long) (i - 1)) * this.sliceSize;
        slicePartStruct2.sliceSize = this.fileLength - slicePartStruct2.offset;
        this.partStructMap.put(Integer.valueOf(i), slicePartStruct2);
        this.UPLOAD_PART_COUNT.set(i);
    }

    private void updateSlicePart(ListPartsResult listPartsResult) {
        List<ListParts.Part> parts;
        if (!(listPartsResult == null || listPartsResult.listParts == null || (parts = listPartsResult.listParts.parts) == null)) {
            for (ListParts.Part part : parts) {
                if (this.partStructMap.containsKey(part.partNumber)) {
                    SlicePartStruct slicePartStruct = this.partStructMap.get(part.partNumber);
                    slicePartStruct.isAlreadyUpload = true;
                    slicePartStruct.eTag = part.eTag;
                    this.UPLOAD_PART_COUNT.decrementAndGet();
                    this.ALREADY_SEND_DATA_LEN.addAndGet(Long.parseLong(part.size));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static class SlicePartStruct {
        public String eTag;
        public boolean isAlreadyUpload;
        public long offset;
        public int partNumber;
        public long sliceSize;

        private SlicePartStruct() {
        }
    }

    public static class UploadServiceResult extends CosXmlResult {
        public String eTag;

        @Override // com.tencent.cos.xml.model.CosXmlResult
        public String printResult() {
            return super.printResult() + IOUtils.LINE_SEPARATOR_UNIX + "eTag:" + this.eTag + IOUtils.LINE_SEPARATOR_UNIX + "accessUrl:" + this.accessUrl;
        }
    }
}
