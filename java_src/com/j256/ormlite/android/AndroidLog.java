package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog implements Log {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$logger$Log$Level = null;
    private static final String ALL_LOGS_NAME = "ORMLite";
    private static final int MAX_TAG_LENGTH = 23;
    private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
    private String className;
    private final boolean[] levelCache;
    private volatile int levelCacheC = 0;

    static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$logger$Log$Level() {
        int[] iArr = $SWITCH_TABLE$com$j256$ormlite$logger$Log$Level;
        if (iArr == null) {
            iArr = new int[Log.Level.values().length];
            try {
                iArr[Log.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Log.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Log.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Log.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Log.Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Log.Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$j256$ormlite$logger$Log$Level = iArr;
        }
        return iArr;
    }

    public AndroidLog(String className2) {
        this.className = LoggerFactory.getSimpleClassName(className2);
        int length = this.className.length();
        if (length > 23) {
            this.className = this.className.substring(length - 23, length);
        }
        int maxLevel = 0;
        for (Log.Level level : Log.Level.values()) {
            int androidLevel = levelToAndroidLevel(level);
            if (androidLevel > maxLevel) {
                maxLevel = androidLevel;
            }
        }
        this.levelCache = new boolean[(maxLevel + 1)];
        refreshLevelCache();
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        int i = this.levelCacheC + 1;
        this.levelCacheC = i;
        if (i >= 200) {
            refreshLevelCache();
            this.levelCacheC = 0;
        }
        int androidLevel = levelToAndroidLevel(level);
        if (androidLevel < this.levelCache.length) {
            return this.levelCache[androidLevel];
        }
        return isLevelEnabledInternal(androidLevel);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String msg) {
        switch ($SWITCH_TABLE$com$j256$ormlite$logger$Log$Level()[level.ordinal()]) {
            case 1:
                android.util.Log.v(this.className, msg);
                return;
            case 2:
                android.util.Log.d(this.className, msg);
                return;
            case 3:
                android.util.Log.i(this.className, msg);
                return;
            case 4:
                android.util.Log.w(this.className, msg);
                return;
            case 5:
                android.util.Log.e(this.className, msg);
                return;
            case 6:
                android.util.Log.e(this.className, msg);
                return;
            default:
                android.util.Log.i(this.className, msg);
                return;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String msg, Throwable t) {
        switch ($SWITCH_TABLE$com$j256$ormlite$logger$Log$Level()[level.ordinal()]) {
            case 1:
                android.util.Log.v(this.className, msg, t);
                return;
            case 2:
                android.util.Log.d(this.className, msg, t);
                return;
            case 3:
                android.util.Log.i(this.className, msg, t);
                return;
            case 4:
                android.util.Log.w(this.className, msg, t);
                return;
            case 5:
                android.util.Log.e(this.className, msg, t);
                return;
            case 6:
                android.util.Log.e(this.className, msg, t);
                return;
            default:
                android.util.Log.i(this.className, msg, t);
                return;
        }
    }

    private void refreshLevelCache() {
        for (Log.Level level : Log.Level.values()) {
            int androidLevel = levelToAndroidLevel(level);
            if (androidLevel < this.levelCache.length) {
                this.levelCache[androidLevel] = isLevelEnabledInternal(androidLevel);
            }
        }
    }

    private boolean isLevelEnabledInternal(int androidLevel) {
        return android.util.Log.isLoggable(this.className, androidLevel) || android.util.Log.isLoggable(ALL_LOGS_NAME, androidLevel);
    }

    private int levelToAndroidLevel(Log.Level level) {
        switch ($SWITCH_TABLE$com$j256$ormlite$logger$Log$Level()[level.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
            default:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 6;
        }
    }
}
