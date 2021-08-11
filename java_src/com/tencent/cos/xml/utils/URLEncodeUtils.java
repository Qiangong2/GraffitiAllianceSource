package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class URLEncodeUtils {
    public static String cosPathEncode(String cosPath) throws CosXmlClientException {
        if (cosPath == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        String[] division = cosPath.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        for (int i = 0; i < division.length - 1; i++) {
            try {
                result.append(URLEncoder.encode(division[i], "utf-8")).append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            } catch (UnsupportedEncodingException e) {
                throw new CosXmlClientException(e);
            }
        }
        if (!cosPath.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            result.append(URLEncoder.encode(division[division.length - 1], "utf-8"));
        } else {
            result.append(URLEncoder.encode(division[division.length - 1], "utf-8")).append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        return result.toString();
    }
}
