package com.wanmei.sdk.core.util;

import android.app.ActivityManager;
import android.content.Context;
import com.wanmei.sdk.core.Proguard;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class Util implements Proguard {
    public static int dip2px(Context context, float dipValue) {
        return (int) ((context.getResources().getDisplayMetrics().density * dipValue) + 0.5f);
    }

    private void fatherToChild(Object father, Object child) throws Exception {
        if (child.getClass().getSuperclass() != father.getClass()) {
            throw new Exception("child不是father的子类");
        }
        Class<?> cls = father.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            field.getType();
            field.set(child, cls.getMethod("get" + upperHeadChar(field.getName()), new Class[0]).invoke(father, new Object[0]));
        }
    }

    private static String formatDateTime(int raw) {
        return String.valueOf(raw).length() < 2 ? "0" + raw : new StringBuilder().append(raw).toString();
    }

    public static String generateOutputName(String sourcePathName, String outputDir) {
        StringBuilder sb = new StringBuilder(80);
        sb.append(outputDir);
        if (!outputDir.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        int lastIndexOf = sourcePathName.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (lastIndexOf >= 0) {
            sourcePathName = sourcePathName.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = sourcePathName.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            sb.append(sourcePathName);
        } else {
            sb.append((CharSequence) sourcePathName, 0, lastIndexOf2);
        }
        sb.append(".dex");
        return sb.toString();
    }

    public static String getCurrentDate() {
        Calendar instance = Calendar.getInstance();
        String sb = new StringBuilder().append(instance.get(1)).toString();
        String formatDateTime = formatDateTime(instance.get(2) + 1);
        return sb + "-" + formatDateTime + "-" + formatDateTime(instance.get(5));
    }

    public static String getCurrentTime() {
        Calendar instance = Calendar.getInstance();
        String formatDateTime = formatDateTime(instance.get(11));
        String formatDateTime2 = formatDateTime(instance.get(12));
        return formatDateTime + ":" + formatDateTime2 + ":" + formatDateTime(instance.get(13));
    }

    public static boolean isAppOnForeground(Context con) {
        String packageName = con.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) con.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static String md5(String string) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    public static int px2dip(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * spValue) + 0.5f);
    }

    private String upperHeadChar(String in) {
        return in.substring(0, 1).toUpperCase() + in.substring(1, in.length());
    }
}
