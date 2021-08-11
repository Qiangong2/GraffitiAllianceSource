package com.tencent.cos.xml.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtils {
    private SharedPreferences sharedPreferences;

    public SharePreferenceUtils(Context context) {
        this.sharedPreferences = context.getSharedPreferences("downloader", 0);
    }

    public synchronized void updateValue(String localFilePath, String eTag) {
        if (localFilePath != null) {
            this.sharedPreferences.edit().putString(localFilePath, eTag).apply();
        }
    }

    public synchronized String getValue(String localFilePath) {
        String str = null;
        synchronized (this) {
            if (localFilePath != null) {
                str = this.sharedPreferences.getString(localFilePath, null);
            }
        }
        return str;
    }

    public synchronized void clear(String localFilePath) {
        if (localFilePath != null) {
            this.sharedPreferences.edit().remove(localFilePath).apply();
        }
    }
}
