package com.tencent.qcloud.core.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public final class QCloudLogger {
    private static final int DEBUG = 3;
    private static final int ERROR = 6;
    private static final int INFO = 4;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    private static RecordLog recordLog;

    public static void setUp(Context context) {
        if (context != null) {
            recordLog = RecordLog.getInstance(context, "cloud");
        }
    }

    private QCloudLogger() {
    }

    /* renamed from: v */
    public static int m4899v(String tag, String format, Object... args) {
        if (!isLoggable(tag, 2)) {
            return 0;
        }
        try {
            return Log.v(tag, args.length > 0 ? String.format(format, args) : format);
        } catch (Exception e) {
            return Log.v(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: v */
    public static int m4900v(String tag, Throwable tr, String format, Object... args) {
        if (!isLoggable(tag, 2)) {
            return 0;
        }
        try {
            return Log.v(tag, args.length > 0 ? String.format(format, args) : format, tr);
        } catch (Exception e) {
            return Log.v(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: d */
    public static int m4893d(String tag, String format, Object... args) {
        if (!isLoggable(tag, 3)) {
            return 0;
        }
        try {
            return Log.d(tag, args.length > 0 ? String.format(format, args) : format);
        } catch (Exception e) {
            return Log.d(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: d */
    public static int m4894d(String tag, Throwable tr, String format, Object... args) {
        if (!isLoggable(tag, 3)) {
            return 0;
        }
        try {
            return Log.d(tag, args.length > 0 ? String.format(format, args) : format, tr);
        } catch (Exception e) {
            return Log.d(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: i */
    public static int m4897i(String tag, String format, Object... args) {
        if (!isLoggable(tag, 4)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.i(tag, message);
            flush(tag, RecordLevel.INFO, message, null);
            return r;
        } catch (Exception e) {
            return Log.i(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: i */
    public static int m4898i(String tag, Throwable tr, String format, Object... args) {
        if (!isLoggable(tag, 4)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.i(tag, message, tr);
            flush(tag, RecordLevel.INFO, message, tr);
            return r;
        } catch (Exception e) {
            return Log.i(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: w */
    public static int m4901w(String tag, String format, Object... args) {
        if (!isLoggable(tag, 5)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.w(tag, message);
            flush(tag, RecordLevel.INFO, message, null);
            return r;
        } catch (Exception e) {
            return Log.w(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: w */
    public static int m4902w(String tag, Throwable tr, String format, Object... args) {
        if (!isLoggable(tag, 5)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.w(tag, message, tr);
            flush(tag, RecordLevel.INFO, message, tr);
            return r;
        } catch (Exception e) {
            return Log.w(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: e */
    public static int m4895e(String tag, String format, Object... args) {
        if (!isLoggable(tag, 6)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.e(tag, message);
            flush(tag, RecordLevel.INFO, message, null);
            return r;
        } catch (Exception e) {
            return Log.e(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    /* renamed from: e */
    public static int m4896e(String tag, Throwable tr, String format, Object... args) {
        if (!isLoggable(tag, 6)) {
            return 0;
        }
        try {
            String message = args.length > 0 ? String.format(format, args) : format;
            int r = Log.e(tag, message, tr);
            flush(tag, RecordLevel.INFO, message, tr);
            return r;
        } catch (Exception e) {
            return Log.e(tag, format + ": !!!! Log format exception: ", e);
        }
    }

    public static boolean isTagLoggable(String tag) {
        return isLoggable(tag, 3);
    }

    private static boolean isLoggable(String tag, int level) {
        if (TextUtils.isEmpty(tag) || tag.length() >= 23) {
            return false;
        }
        return Log.isLoggable(tag, level);
    }

    private static void flush(String tag, RecordLevel level, String msg, Throwable t) {
        if (level.ordinal() >= RecordLevel.INFO.ordinal() && recordLog != null) {
            recordLog.appendRecord(tag, level, msg, t);
        }
    }
}
