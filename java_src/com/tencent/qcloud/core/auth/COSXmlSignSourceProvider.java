package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.IOUtils;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

public class COSXmlSignSourceProvider implements QCloudSignSourceProvider {
    private long beginTime;
    private long duration;
    private long expiredTime;
    private Set<String> headers = new HashSet();
    private Set<String> paras = new HashSet();
    private Set<String> realSignHeader = new HashSet();
    private Set<String> realSignParas = new HashSet();
    private String signTime;

    public COSXmlSignSourceProvider setSignBeginTime(long beginTime2) {
        this.beginTime = Utils.handleTimeAccuracy(beginTime2);
        return this;
    }

    public COSXmlSignSourceProvider setSignExpiredTime(long expiredTime2) {
        this.expiredTime = Utils.handleTimeAccuracy(expiredTime2);
        return this;
    }

    public COSXmlSignSourceProvider setDuration(long duration2) {
        this.duration = duration2;
        return this;
    }

    public void parameter(String key) {
        this.paras.add(key);
    }

    public void parameters(Set<String> keys) {
        if (keys != null) {
            this.paras.addAll(keys);
        }
    }

    public void header(String key) {
        this.headers.add(key);
    }

    public void headers(Set<String> keys) {
        if (keys != null) {
            this.headers.addAll(keys);
        }
    }

    @Override // com.tencent.qcloud.core.auth.QCloudSignSourceProvider
    public <T> String source(HttpRequest<T> request) throws QCloudClientException {
        String contentType;
        if (request == null) {
            return null;
        }
        if (this.headers.size() > 0) {
            Set<String> lowerCaseHeaders = toLowerCase(this.headers);
            if (!(lowerCaseHeaders == null || !lowerCaseHeaders.contains(HttpConstants.Header.CONTENT_TYPE.toLowerCase()) || (contentType = request.contentType()) == null)) {
                request.addHeader(HttpConstants.Header.CONTENT_TYPE, contentType);
            }
            if (lowerCaseHeaders != null && lowerCaseHeaders.contains(HttpConstants.Header.CONTENT_LENGTH.toLowerCase())) {
                try {
                    long contentLength = request.contentLength();
                    if (contentLength != -1) {
                        request.addHeader(HttpConstants.Header.CONTENT_LENGTH, Long.toString(contentLength));
                        request.removeHeader(HttpConstants.Header.TRANSFER_ENCODING);
                    } else {
                        request.addHeader(HttpConstants.Header.TRANSFER_ENCODING, "chunked");
                        request.removeHeader(HttpConstants.Header.CONTENT_LENGTH);
                    }
                } catch (IOException e) {
                    throw new QCloudClientException("read content length fails", e);
                }
            }
            if (lowerCaseHeaders != null && lowerCaseHeaders.contains(HttpConstants.Header.DATE.toLowerCase())) {
                Date d = new Date();
                DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
                format.setTimeZone(TimeZone.getTimeZone("GMT"));
                request.addHeader(HttpConstants.Header.DATE, format.format(d));
            }
        }
        StringBuilder formatString = new StringBuilder(request.method().toLowerCase());
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        formatString.append(QCloudHttpUtils.urlDecodeString(request.url().getPath()));
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        String paraString = queryStringForKeys(request.url(), this.paras, this.realSignParas);
        if (paraString == null) {
            paraString = "";
        }
        formatString.append(paraString);
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        String headerString = "";
        if (request.headers() != null) {
            headerString = headersStringForKeys(request.headers(), this.headers, this.realSignHeader);
        }
        formatString.append(headerString);
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(AuthConstants.SHA1);
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.beginTime == 0) {
            this.beginTime = System.currentTimeMillis() / 1000;
        }
        if (this.expiredTime == 0) {
            this.expiredTime = this.beginTime + this.duration;
        }
        this.signTime = this.beginTime + ";" + this.expiredTime;
        stringToSign.append(this.signTime);
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringToSign.append(Utils.encodeHexString(Utils.sha1(formatString.toString())));
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        return stringToSign.toString();
    }

    /* access modifiers changed from: package-private */
    public String getRealHeaderList() {
        return sortAndJoinSemicolon(this.realSignHeader);
    }

    /* access modifiers changed from: package-private */
    public String getRealParameterList() {
        return sortAndJoinSemicolon(this.realSignParas);
    }

    /* access modifiers changed from: package-private */
    public String getSignTime() {
        return this.signTime;
    }

    private String sortAndJoinSemicolon(Set<String> values) {
        if (values == null) {
            return "";
        }
        Set<String> set = new TreeSet<>(values);
        StringBuilder str = new StringBuilder();
        for (String value : set) {
            if (!QCloudStringUtils.isEmpty(str.toString())) {
                str.append(";");
            }
            str.append(value);
        }
        return str.toString();
    }

    private Set<String> toLowerCase(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return null;
        }
        Set<String> lowerSet = new HashSet<>();
        for (String key : set) {
            if (key != null) {
                lowerSet.add(key.toLowerCase());
            }
        }
        return lowerSet;
    }

    private String queryStringForKeys(URL httpUrl, Set<String> keys, Set<String> realKeys) {
        StringBuilder out = new StringBuilder();
        boolean isFirst = true;
        List<String> orderKeys = new LinkedList<>();
        for (String key : keys) {
            orderKeys.add(key.toLowerCase());
        }
        Collections.sort(orderKeys, new Comparator<String>() {
            /* class com.tencent.qcloud.core.auth.COSXmlSignSourceProvider.C13211 */

            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Map<String, List<String>> queryNameValues = QCloudHttpUtils.getDecodedQueryPair(httpUrl);
        Set<String> queryNames = queryNameValues.keySet();
        if (queryNames == null) {
            return "";
        }
        Map<String, String> maps = new HashMap<>();
        for (String name : queryNames) {
            maps.put(name.toLowerCase(), name);
        }
        for (String key2 : orderKeys) {
            List<String> values = queryNameValues.get(maps.get(key2));
            if (values != null) {
                for (String value : values) {
                    if (!isFirst) {
                        out.append('&');
                    }
                    isFirst = false;
                    realKeys.add(key2.toLowerCase());
                    out.append(key2.toLowerCase());
                    if (value != null) {
                        out.append('=');
                        out.append(value.toLowerCase());
                    }
                }
            }
        }
        return out.toString();
    }

    private String headersStringForKeys(Map<String, List<String>> headers2, Set<String> keys, Set<String> realKeys) {
        StringBuilder out = new StringBuilder();
        boolean isFirst = true;
        List<String> orderKeys = new LinkedList<>();
        for (String key : keys) {
            orderKeys.add(key.toLowerCase());
        }
        Collections.sort(orderKeys, new Comparator<String>() {
            /* class com.tencent.qcloud.core.auth.COSXmlSignSourceProvider.C13222 */

            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Set<String> headerNames = headers2.keySet();
        if (headerNames == null) {
            return "";
        }
        Map<String, String> maps = new HashMap<>();
        for (String name : headerNames) {
            maps.put(name.toLowerCase(), name);
        }
        for (String key2 : orderKeys) {
            List<String> values = headers2.get(key2);
            if (values != null) {
                for (String value : values) {
                    if (!isFirst) {
                        out.append('&');
                    }
                    isFirst = false;
                    out.append(key2.toLowerCase());
                    realKeys.add(key2);
                    if (value != null) {
                        out.append('=');
                        out.append(QCloudHttpUtils.urlEncodeString(value));
                    }
                }
            }
        }
        return out.toString();
    }
}
