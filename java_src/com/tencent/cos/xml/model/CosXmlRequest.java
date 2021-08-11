package com.tencent.cos.xml.model;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.COSXmlSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CosXmlRequest {
    private HttpTask httpTask;
    private boolean isNeedMD5 = false;
    protected Map<String, String> queryParameters = new LinkedHashMap();
    protected Map<String, List<String>> requestHeaders = new LinkedHashMap();
    private QCloudSignSourceProvider signSourceProvider;

    public abstract void checkParameters() throws CosXmlClientException;

    /* access modifiers changed from: protected */
    public abstract String getHostPrefix();

    public abstract String getMethod();

    public abstract String getPath();

    public abstract RequestBodySerializer getRequestBody() throws CosXmlClientException;

    public Map<String, String> getQueryString() {
        return this.queryParameters;
    }

    public Map<String, List<String>> getRequestHeaders() {
        return this.requestHeaders;
    }

    public boolean isNeedMD5() {
        return this.isNeedMD5;
    }

    public void setNeedMD5(boolean isNeedMD52) {
        this.isNeedMD5 = isNeedMD52;
    }

    public void setRequestHeaders(String key, String value) throws CosXmlClientException {
        if (key != null && value != null) {
            addHeader(key, URLEncodeUtils.cosPathEncode(value));
        }
    }

    /* access modifiers changed from: protected */
    public void addHeader(String key, String value) {
        List<String> values;
        if (this.requestHeaders.containsKey(key)) {
            values = this.requestHeaders.get(key);
        } else {
            values = new ArrayList<>();
        }
        values.add(value);
        this.requestHeaders.put(key, values);
    }

    public String getHost(String appid, String region) {
        String bucket = getHostPrefix();
        if (!bucket.endsWith("-" + appid)) {
            bucket = bucket + "-" + appid;
        }
        return bucket + ".cos." + region + "." + "myqcloud.com";
    }

    public void setSign(long signDuration) {
        this.signSourceProvider = new COSXmlSignSourceProvider().setDuration(signDuration);
    }

    public void setSign(long startTime, long endTime) {
        this.signSourceProvider = new COSXmlSignSourceProvider().setSignBeginTime(startTime).setSignExpiredTime(endTime);
    }

    public QCloudSignSourceProvider getSignSourceProvider() {
        if (this.signSourceProvider == null) {
            this.signSourceProvider = new COSXmlSignSourceProvider().setDuration(600);
        }
        return this.signSourceProvider;
    }

    public void setSign(long signDuration, Set<String> parameters, Set<String> headers) {
        COSXmlSignSourceProvider cosXmlSignSourceProvider = new COSXmlSignSourceProvider().setDuration(signDuration);
        cosXmlSignSourceProvider.parameters(parameters);
        cosXmlSignSourceProvider.headers(headers);
        this.signSourceProvider = cosXmlSignSourceProvider;
    }

    public void setTask(HttpTask httpTask2) {
        this.httpTask = httpTask2;
    }

    public HttpTask getHttpTask() {
        return this.httpTask;
    }
}
