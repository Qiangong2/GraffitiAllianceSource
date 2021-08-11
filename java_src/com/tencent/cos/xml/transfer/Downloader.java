package com.tencent.cos.xml.transfer;

import android.content.Context;
import com.tencent.cos.xml.CosXml;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.utils.SharePreferenceUtils;
import java.io.File;
import java.util.List;

public class Downloader {
    private String bucket;
    private String cosPath;
    private CosXml cosXmlServer;
    private GetObjectRequest getObjectRequest;
    private ListenerHandler listenerHandler = new ListenerHandler();
    private String localFileName;
    private String localPath;
    private long rangeStart = 0;
    private SharePreferenceUtils sharePreferedUtils;

    public Downloader(Context appContext, CosXml cosXmlServer2) {
        this.sharePreferedUtils = new SharePreferenceUtils(appContext);
        this.cosXmlServer = cosXmlServer2;
    }

    public void setProgress(CosXmlProgressListener cosXmlProgressListener) {
        this.listenerHandler.setCosXmlProgressListener(cosXmlProgressListener);
    }

    public GetObjectResult download(String bucket2, String cosPath2, String localPath2, String localFileName2) throws CosXmlClientException, CosXmlServiceException {
        this.bucket = bucket2;
        this.cosPath = cosPath2;
        this.localPath = localPath2;
        this.localFileName = localFileName2;
        checkParameters();
        List<String> realEtags = (List) this.cosXmlServer.headObject(new HeadObjectRequest(bucket2, cosPath2)).headers.get("ETag");
        String realEtag = null;
        if (realEtags != null && realEtags.size() > 0) {
            realEtag = realEtags.get(0);
        }
        this.getObjectRequest = new GetObjectRequest(bucket2, cosPath2, localPath2, localFileName2);
        this.rangeStart = 0;
        String realLocalPath = this.getObjectRequest.getDownloadPath();
        if (realEtag != null) {
            String sourceEtag = this.sharePreferedUtils.getValue(realLocalPath);
            if (sourceEtag == null || !realEtag.equals(sourceEtag)) {
                this.sharePreferedUtils.updateValue(realLocalPath, realEtag);
            } else {
                this.rangeStart = getRange(realLocalPath);
            }
        }
        this.getObjectRequest.setRange(this.rangeStart);
        this.getObjectRequest.setProgressListener(this.listenerHandler);
        GetObjectResult getObjectResult = this.cosXmlServer.getObject(this.getObjectRequest);
        this.sharePreferedUtils.clear(realLocalPath);
        return getObjectResult;
    }

    public void download(String bucket2, String cosPath2, String localPath2, String localFileName2, CosXmlResultListener cosXmlResultListener) {
        this.bucket = bucket2;
        this.cosPath = cosPath2;
        this.localPath = localPath2;
        this.localFileName = localFileName2;
        this.listenerHandler.setCosXmlResultListener(cosXmlResultListener);
        try {
            checkParameters();
            this.getObjectRequest = new GetObjectRequest(bucket2, cosPath2, localPath2, localFileName2);
            this.cosXmlServer.headObjectAsync(new HeadObjectRequest(bucket2, cosPath2), new CosXmlResultListener() {
                /* class com.tencent.cos.xml.transfer.Downloader.C13121 */

                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onSuccess(CosXmlRequest request, CosXmlResult result) {
                    List<String> realEtags = (List) ((HeadObjectResult) result).headers.get("ETag");
                    String realEtag = null;
                    if (realEtags != null && realEtags.size() > 0) {
                        realEtag = realEtags.get(0);
                    }
                    Downloader.this.rangeStart = 0;
                    String realLocalPath = Downloader.this.getObjectRequest.getDownloadPath();
                    if (realEtag != null) {
                        String sourceEtag = Downloader.this.sharePreferedUtils.getValue(realLocalPath);
                        if (sourceEtag == null || !realEtag.equals(sourceEtag)) {
                            Downloader.this.sharePreferedUtils.updateValue(realLocalPath, realEtag);
                        } else {
                            Downloader.this.rangeStart = Downloader.this.getRange(realLocalPath);
                        }
                    }
                    Downloader.this.getObjectRequest.setRange(Downloader.this.rangeStart);
                    Downloader.this.getObjectRequest.setProgressListener(Downloader.this.listenerHandler);
                    Downloader.this.cosXmlServer.getObjectAsync(Downloader.this.getObjectRequest, Downloader.this.listenerHandler);
                }

                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onFail(CosXmlRequest request, CosXmlClientException exception, CosXmlServiceException serviceException) {
                    Downloader.this.listenerHandler.onFail(Downloader.this.getObjectRequest, exception, serviceException);
                }
            });
        } catch (CosXmlClientException e) {
            this.listenerHandler.onFail(this.getObjectRequest, e, null);
        }
    }

    public void cancel() {
        if (this.getObjectRequest != null && this.cosXmlServer != null) {
            this.cosXmlServer.cancel(this.getObjectRequest);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long getRange(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    private void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null ");
        } else if (this.cosPath == null) {
            throw new CosXmlClientException("cosPath must not be null ");
        } else if (this.localPath == null) {
            throw new CosXmlClientException("localPath must not be null ");
        }
    }

    /* access modifiers changed from: private */
    public class ListenerHandler implements CosXmlProgressListener, CosXmlResultListener {
        private CosXmlProgressListener cosXmlProgressListener;
        private CosXmlResultListener cosXmlResultListener;

        public ListenerHandler() {
        }

        public void setCosXmlProgressListener(CosXmlProgressListener cosXmlProgressListener2) {
            this.cosXmlProgressListener = cosXmlProgressListener2;
        }

        public void setCosXmlResultListener(CosXmlResultListener cosXmlResultListener2) {
            this.cosXmlResultListener = cosXmlResultListener2;
        }

        @Override // com.tencent.qcloud.core.common.QCloudProgressListener
        public void onProgress(long complete, long target) {
            if (this.cosXmlProgressListener != null) {
                this.cosXmlProgressListener.onProgress(Downloader.this.rangeStart + complete, Downloader.this.rangeStart + target);
            }
        }

        @Override // com.tencent.cos.xml.listener.CosXmlResultListener
        public void onSuccess(CosXmlRequest request, CosXmlResult result) {
            Downloader.this.sharePreferedUtils.clear(Downloader.this.getObjectRequest.getDownloadPath());
            if (this.cosXmlResultListener != null) {
                this.cosXmlResultListener.onSuccess(request, result);
            }
        }

        @Override // com.tencent.cos.xml.listener.CosXmlResultListener
        public void onFail(CosXmlRequest request, CosXmlClientException exception, CosXmlServiceException serviceException) {
            if (this.cosXmlResultListener != null) {
                this.cosXmlResultListener.onFail(request, exception, serviceException);
            }
        }
    }
}
