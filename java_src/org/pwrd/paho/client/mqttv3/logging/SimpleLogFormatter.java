package org.pwrd.paho.client.mqttv3.logging;

import java.util.logging.Formatter;

public class SimpleLogFormatter extends Formatter {

    /* renamed from: LS */
    private static final String f6259LS = System.getProperty("line.separator");

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f1 A[SYNTHETIC, Splitter:B:20:0x00f1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String format(java.util.logging.LogRecord r23) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: org.pwrd.paho.client.mqttv3.logging.SimpleLogFormatter.format(java.util.logging.LogRecord):java.lang.String");
    }

    public static String left(String s, int width, char fillChar) {
        if (s.length() >= width) {
            return s;
        }
        StringBuffer sb = new StringBuffer(width);
        sb.append(s);
        int i = width - s.length();
        while (true) {
            i--;
            if (i < 0) {
                return sb.toString();
            }
            sb.append(fillChar);
        }
    }
}
