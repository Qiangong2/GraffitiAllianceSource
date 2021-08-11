package com.tencent.qcloud.core.util;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class QCloudHttpUtils {
    public static String urlEncodeWithSlash(String fileId) {
        if (fileId == null || fileId.length() <= 0 || fileId.equals(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return fileId;
        }
        String[] paras = fileId.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        for (int i = 0; i < paras.length; i++) {
            paras[i] = urlEncodeString(paras[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : paras) {
            stringBuilder.append(str);
            stringBuilder.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        if (!fileId.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static Map<String, List<String>> getDecodedQueryPair(URL url) {
        String key;
        Map<String, List<String>> query_pairs = new LinkedHashMap<>();
        if (url.getQuery() != null) {
            String[] pairs = url.getQuery().split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf(SimpleComparison.EQUAL_TO_OPERATION);
                if (idx > 0) {
                    key = urlDecodeString(pair.substring(0, idx));
                } else {
                    key = pair;
                }
                if (!query_pairs.containsKey(key)) {
                    query_pairs.put(key, new LinkedList<>());
                }
                query_pairs.get(key).add((idx <= 0 || pair.length() <= idx + 1) ? null : urlDecodeString(pair.substring(idx + 1)));
            }
        }
        return query_pairs;
    }

    public static long[] parseContentRange(String contentRange) {
        if (QCloudStringUtils.isEmpty(contentRange)) {
            return null;
        }
        int lastBlankIndex = contentRange.lastIndexOf(" ");
        int acrossIndex = contentRange.indexOf("-");
        int slashIndex = contentRange.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (lastBlankIndex == -1 || acrossIndex == -1 || slashIndex == -1) {
            return null;
        }
        return new long[]{Long.parseLong(contentRange.substring(lastBlankIndex + 1, acrossIndex)), Long.parseLong(contentRange.substring(acrossIndex + 1, slashIndex)), Long.parseLong(contentRange.substring(slashIndex + 1))};
    }

    public static String urlEncodeString(String source) {
        try {
            return URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String urlDecodeString(String source) {
        try {
            return URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String queryParametersString(Map<String, String> keyValues) {
        if (keyValues == null) {
            return null;
        }
        StringBuilder source = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : keyValues.entrySet()) {
            if (!first) {
                source.append("&");
            }
            source.append(entry.getKey() + SimpleComparison.EQUAL_TO_OPERATION + entry.getValue());
            first = false;
        }
        return source.toString();
    }
}
