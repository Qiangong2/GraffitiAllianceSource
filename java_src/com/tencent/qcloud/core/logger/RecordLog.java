package com.tencent.qcloud.core.logger;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* access modifiers changed from: package-private */
public class RecordLog {
    private static final long BUFFER_SIZE = 32768;
    public static final String LOG_DIR = "QCloudLogs";
    private static final long LOG_FLUSH_DURATION = 10000;
    private static final int MAX_FILE_COUNT = 30;
    private static final int MAX_FILE_SIZE = 32768;
    private static final int MSG_DELETE_FILE = 2;
    private static final int MSG_FLUSH_ALL = 0;
    private static final int MSG_FLUSH_CONTENT = 1;
    private static final byte[] instance = new byte[0];
    private static final byte[] object = new byte[0];
    private static RecordLog recordLog = null;
    private List<Record> bufferRecord = Collections.synchronizedList(new ArrayList());
    private FileFilter fileFilter = new FileFilter() {
        /* class com.tencent.qcloud.core.logger.RecordLog.C13291 */

        public boolean accept(File pathname) {
            boolean result;
            if (!pathname.getName().endsWith("." + RecordLog.this.flag + ".log")) {
                return false;
            }
            if (RecordLog.this.getIndexFromFile(pathname) != -1) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }
    };
    private String flag = null;
    private Handler handler = null;
    private String logRootDir = null;
    private volatile long mBufferSize = 0;

    private RecordLog(Context context, String flag2) {
        this.flag = flag2;
        this.logRootDir = context.getExternalCacheDir() + File.separator + LOG_DIR;
        HandlerThread handlerThread = new HandlerThread("log_handlerThread", 1);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper()) {
            /* class com.tencent.qcloud.core.logger.RecordLog.HandlerC13302 */

            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        RecordLog.this.flush();
                        sendEmptyMessageDelayed(0, RecordLog.LOG_FLUSH_DURATION);
                        return;
                    case 1:
                        RecordLog.this.input();
                        return;
                    default:
                        return;
                }
            }
        };
        Message message = this.handler.obtainMessage();
        message.what = 0;
        this.handler.sendMessage(message);
    }

    public static RecordLog getInstance(Context context, String flag2) {
        RecordLog recordLog2;
        synchronized (instance) {
            if (recordLog == null) {
                recordLog = new RecordLog(context, flag2);
            }
            recordLog2 = recordLog;
        }
        return recordLog2;
    }

    /* access modifiers changed from: package-private */
    public String getTodayDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    /* access modifiers changed from: package-private */
    public String getLongDate(long times) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(times));
    }

    /* access modifiers changed from: package-private */
    public File getLogFileDir() {
        File file = new File(this.logRootDir + File.separator + getTodayDate());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    public File getLogFile(long times) {
        String dirName = this.logRootDir + File.separator + getLongDate(times);
        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdirs();
            return new File(dirName, "1." + this.flag + ".log");
        }
        File[] fileslist = file.listFiles(this.fileFilter);
        if (fileslist == null || fileslist.length == 0) {
            return new File(dirName, "1." + this.flag + ".log");
        }
        Arrays.sort(fileslist, new Comparator<File>() {
            /* class com.tencent.qcloud.core.logger.RecordLog.C13313 */

            public int compare(File lhs, File rhs) {
                return RecordLog.this.getIndexFromFile(lhs) - RecordLog.this.getIndexFromFile(rhs);
            }
        });
        File last = fileslist[fileslist.length - 1];
        if (last.length() > BUFFER_SIZE) {
            last = new File(dirName, "" + (getIndexFromFile(last) + 1) + "." + this.flag + ".log");
        }
        int filecounts = fileslist.length + 1;
        for (int i = 0; i < filecounts - 30; i++) {
            fileslist[i].delete();
        }
        return last;
    }

    /* access modifiers changed from: package-private */
    public int getIndexFromFile(File file) {
        try {
            String filename = file.getName();
            return Integer.valueOf(filename.substring(0, filename.indexOf(46))).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[SYNTHETIC, Splitter:B:28:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0068 A[SYNTHETIC, Splitter:B:41:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(java.util.List<com.tencent.qcloud.core.logger.Record> r11) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.logger.RecordLog.write(java.util.List):void");
    }

    public synchronized void appendRecord(String tag, RecordLevel level, String msg, Throwable t) {
        Record r = new Record(tag, level, msg, t);
        this.bufferRecord.add(r);
        this.mBufferSize += r.getLength();
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 500);
    }

    /* access modifiers changed from: package-private */
    public synchronized void flush() {
        if (this.mBufferSize > 0) {
            write(this.bufferRecord);
            this.bufferRecord.clear();
            this.mBufferSize = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void input() {
        if (this.mBufferSize > BUFFER_SIZE) {
            flush();
        }
    }
}
