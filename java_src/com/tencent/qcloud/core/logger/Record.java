package com.tencent.qcloud.core.logger;

import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* access modifiers changed from: package-private */
public class Record {
    private RecordLevel level = null;
    private String msg = null;
    private String tag = null;
    private long threadId;
    private String threadName = null;
    private Throwable throwable = null;
    private long timestamp;

    public Record(String tag2, RecordLevel level2, String msg2, Throwable t) {
        this.level = level2;
        this.tag = tag2;
        this.msg = msg2;
        this.throwable = t;
        this.timestamp = System.currentTimeMillis();
        this.threadId = Thread.currentThread().getId();
        this.threadName = Thread.currentThread().getName();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.level).append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        builder.append(timeUtils(this.timestamp, "yyyy-MM-dd HH:mm:ss"));
        builder.append("[").append(this.threadName).append(" ").append(this.threadId).append("]");
        builder.append("[").append(this.tag).append("]");
        builder.append("[").append(this.msg).append("]");
        if (this.throwable != null) {
            builder.append(" * Exception :\n").append(Log.getStackTraceString(this.throwable));
        }
        builder.append(IOUtils.LINE_SEPARATOR_UNIX);
        return builder.toString();
    }

    static String timeUtils(long seconds, String dateFormat) {
        Date dat = new Date(seconds);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dat);
        return new SimpleDateFormat(dateFormat, Locale.CHINA).format(gc.getTime());
    }

    public long getLength() {
        return (long) ((this.msg != null ? this.msg.length() : 0) + 40);
    }
}
