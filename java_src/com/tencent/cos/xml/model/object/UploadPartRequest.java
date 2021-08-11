package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class UploadPartRequest extends ObjectRequest {
    private byte[] data;
    private long fileContentLength;
    private long fileOffset;
    private InputStream inputStream;
    private int partNumber;
    private CosXmlProgressListener progressListener;
    private String srcPath;
    private String uploadId;

    private UploadPartRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String bucket, String cosPath, int partNumber2, String srcPath2, String uploadId2) {
        this(bucket, cosPath);
        this.partNumber = partNumber2;
        this.srcPath = srcPath2;
        this.uploadId = uploadId2;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String bucket, String cosPath, int partNumber2, String srcPath2, long offset, long length, String uploadId2) {
        this(bucket, cosPath);
        this.partNumber = partNumber2;
        setSrcPath(srcPath2, offset, length);
        this.uploadId = uploadId2;
    }

    public UploadPartRequest(String bucket, String cosPath, int partNumber2, byte[] data2, String uploadId2) {
        this(bucket, cosPath);
        this.partNumber = partNumber2;
        this.data = data2;
        this.uploadId = uploadId2;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public UploadPartRequest(String bucket, String cosPath, int partNumber2, InputStream inputStream2, String uploadId2) throws CosXmlClientException {
        this(bucket, cosPath);
        this.partNumber = partNumber2;
        this.inputStream = inputStream2;
        this.uploadId = uploadId2;
        this.fileOffset = -1;
        this.fileContentLength = -1;
    }

    public void setPartNumber(int partNumber2) {
        this.partNumber = partNumber2;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setUploadId(String uploadId2) {
        this.uploadId = uploadId2;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("partNumber", String.valueOf(this.partNumber));
        this.queryParameters.put("uploadID", this.uploadId);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        if (this.srcPath != null) {
            if (this.fileOffset != -1) {
                return RequestBodySerializer.file(null, new File(this.srcPath), this.fileOffset, this.fileContentLength);
            }
            return RequestBodySerializer.file(null, new File(this.srcPath));
        } else if (this.data != null) {
            return RequestBodySerializer.bytes(null, this.data);
        } else {
            if (this.inputStream != null) {
                return RequestBodySerializer.stream((String) null, new File(CosXmlSimpleService.appCachePath), this.inputStream);
            }
            return null;
        }
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.partNumber <= 0) {
            throw new CosXmlClientException("partNumber must be >= 1");
        } else if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        } else if (this.srcPath == null && this.data == null && this.inputStream == null) {
            throw new CosXmlClientException("Data Source must not be null");
        } else if (this.srcPath != null && !new File(this.srcPath).exists()) {
            throw new CosXmlClientException("upload file does not exist");
        }
    }

    public void setSrcPath(String srcPath2) {
        this.srcPath = srcPath2;
    }

    public void setSrcPath(String srcPath2, long fileOffset2, long contentLength) {
        this.srcPath = srcPath2;
        this.fileOffset = fileOffset2;
        this.fileContentLength = contentLength;
    }

    public String getSrcPath() {
        return this.srcPath;
    }

    public void setData(byte[] data2) {
        this.data = data2;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getFileLength() {
        if (this.data != null) {
            this.fileContentLength = (long) this.data.length;
        } else if (this.srcPath != null && this.fileContentLength == -1) {
            this.fileContentLength = new File(this.srcPath).length();
        }
        return this.fileContentLength;
    }

    public void setProgressListener(CosXmlProgressListener progressListener2) {
        this.progressListener = progressListener2;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }
}
