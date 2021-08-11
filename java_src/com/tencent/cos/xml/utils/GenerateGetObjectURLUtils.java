package com.tencent.cos.xml.utils;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.auth.AuthConstants;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class GenerateGetObjectURLUtils {

    public interface QCloudAPI {
        long getKeyDuration();

        String getSecretId();

        String getSecretKey();

        String getSessionToken();
    }

    public static String getObjectUrl(boolean isHttps, String appid, String bucket, String region, String cosPath) throws CosXmlClientException {
        StringBuilder urlBuilder = new StringBuilder();
        if (StringUtils.isEmpty(appid) || StringUtils.isEmpty(bucket) || StringUtils.isEmpty(region) || StringUtils.isEmpty(cosPath)) {
            throw new CosXmlClientException("appid or bucket or or region or cosPath must not be null");
        }
        if (isHttps) {
            urlBuilder.append(HttpConstants.Scheme.HTTPS).append("://");
        } else {
            urlBuilder.append("http").append("://");
        }
        urlBuilder.append(bucket).append("-").append(appid).append(".");
        urlBuilder.append("cos").append(".").append(region).append(".").append("myqcloud.com");
        if (!cosPath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            cosPath = MqttTopic.TOPIC_LEVEL_SEPARATOR + cosPath;
        }
        urlBuilder.append(URLEncodeUtils.cosPathEncode(cosPath));
        return urlBuilder.toString();
    }

    public static String getRequestUrlWithSign(boolean isHttps, String httpMethod, Map<String, String> headers, Map<String, String> queryParameters, String appid, String bucket, String region, String cosPath, long duration, QCloudAPI qCloudAPI) throws CosXmlClientException {
        return getObjectUrl(isHttps, appid, bucket, region, cosPath) + "?" + getSign(httpMethod, headers, queryParameters, cosPath, duration, qCloudAPI);
    }

    public static String getObjectUrlWithSign(boolean isHttps, Map<String, String> headers, Map<String, String> queryParameters, String appid, String bucket, String region, String cosPath, long duration, QCloudAPI qCloudAPI) throws CosXmlClientException {
        return getObjectUrl(isHttps, appid, bucket, region, cosPath) + "?sign=" + URLEncodeUtils.cosPathEncode(getSign("get", headers, queryParameters, cosPath, duration, qCloudAPI));
    }

    private static String getSign(String httpMethod, Map<String, String> headers, Map<String, String> queryParameters, String cosPath, long signDuration, QCloudAPI qCloudAPI) throws CosXmlClientException {
        String secretId = qCloudAPI.getSecretId();
        String secretKey = qCloudAPI.getSecretKey();
        long keyDuration = qCloudAPI.getKeyDuration();
        if (keyDuration <= 0) {
            keyDuration = signDuration;
        }
        long current = System.currentTimeMillis() / 1000;
        String keyTime = current + ";" + (current + keyDuration);
        String signKey = DigestUtils.getHmacSha1(keyTime, secretKey);
        StringBuilder formatString = new StringBuilder(httpMethod.trim().toLowerCase());
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (!cosPath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            cosPath = MqttTopic.TOPIC_LEVEL_SEPARATOR + cosPath;
        }
        formatString.append(cosPath);
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        String[] sortQueryParameters = sort(queryParameters);
        if (sortQueryParameters != null) {
            formatString.append(sortQueryParameters[1]);
        }
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        String[] sortHeaders = sort(headers);
        if (headers != null) {
            formatString.append(sortHeaders[1]);
        }
        formatString.append(IOUtils.LINE_SEPARATOR_UNIX);
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append("sha1");
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        long currentTime = System.currentTimeMillis() / 1000;
        String signTime = currentTime + ";" + (currentTime + signDuration);
        stringToSign.append(signTime);
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringToSign.append(DigestUtils.getSha1(formatString.toString()));
        stringToSign.append(IOUtils.LINE_SEPARATOR_UNIX);
        String signature = DigestUtils.getHmacSha1(stringToSign.toString(), signKey);
        StringBuilder authorization = new StringBuilder();
        authorization.append(AuthConstants.Q_SIGN_ALGORITHM).append(SimpleComparison.EQUAL_TO_OPERATION).append(AuthConstants.SHA1).append("&").append(AuthConstants.Q_AK).append(SimpleComparison.EQUAL_TO_OPERATION).append(secretId).append("&").append(AuthConstants.Q_SIGN_TIME).append(SimpleComparison.EQUAL_TO_OPERATION).append(signTime).append("&").append(AuthConstants.Q_KEY_TIME).append(SimpleComparison.EQUAL_TO_OPERATION).append(keyTime).append("&").append(AuthConstants.Q_HEADER_LIST).append(SimpleComparison.EQUAL_TO_OPERATION).append("&").append(AuthConstants.Q_URL_PARAM_LIST).append(SimpleComparison.EQUAL_TO_OPERATION).append("&").append(AuthConstants.Q_SIGNATURE).append(SimpleComparison.EQUAL_TO_OPERATION).append(signature);
        return authorization.toString();
    }

    private static String[] sort(Map<String, String> maps) throws CosXmlClientException {
        if (maps == null) {
            return null;
        }
        Map<String, Object> temp = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            temp.put(entry.getKey().toLowerCase().trim(), URLEncodeUtils.cosPathEncode(entry.getValue().trim()));
        }
        List<Map.Entry<String, Object>> list = new ArrayList<>(temp.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
            /* class com.tencent.cos.xml.utils.GenerateGetObjectURLUtils.C13171 */

            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        StringBuilder keyStringBuilder = new StringBuilder();
        StringBuilder valueStringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry2 : list) {
            keyStringBuilder.append(entry2.getKey()).append(";");
            valueStringBuilder.append(entry2.getKey()).append(SimpleComparison.EQUAL_TO_OPERATION).append(entry2.getValue()).append("&");
        }
        keyStringBuilder.deleteCharAt(keyStringBuilder.length() - 1);
        valueStringBuilder.deleteCharAt(valueStringBuilder.length() - 1);
        return new String[]{keyStringBuilder.toString(), valueStringBuilder.toString()};
    }
}
