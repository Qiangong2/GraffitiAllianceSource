package com.tencent.apollo;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.p007v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.security.MessageDigest;
import java.util.Locale;

public class ApolloVoiceUDID {
    private static final String DefaultUUID = "UUID";
    private static String LOGTAG = "GCloudVoice";
    private static Context mainContext;

    public static void SetContext(Context context) {
        mainContext = context;
    }

    public static String BundleID() {
        String str;
        try {
            str = mainContext.getPackageName();
        } catch (Exception e) {
            Log.e(LOGTAG, "GetBundleId Exception:" + e);
            str = null;
        }
        if (str == null) {
            return "Unknown";
        }
        return str;
    }

    public static String GetDeviceID(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            Log.e(LOGTAG, "getDeviceID, Permission Denied. ");
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getDeviceId();
        } catch (Exception e) {
            Log.e(LOGTAG, "get DeviceID failed: " + e.toString());
            return "";
        }
    }

    public static String UDID() {
        String GetDeviceID = GetDeviceID(mainContext);
        String str = Build.SERIAL;
        String string = Settings.Secure.getString(mainContext.getContentResolver(), "android_id");
        StringBuilder sb = new StringBuilder();
        if (GetDeviceID != null) {
            sb.append("%");
            sb.append(GetDeviceID);
        }
        if (str != null) {
            sb.append("%");
            sb.append(str);
        }
        if (string != null) {
            sb.append("%");
            sb.append(string);
        }
        String sb2 = sb.toString();
        if (sb2.length() == 0) {
            return DefaultUUID;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance == null) {
                return DefaultUUID;
            }
            instance.update(sb2.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb3 = new StringBuilder();
            for (byte b : digest) {
                sb3.append(Integer.toHexString(b & 255));
            }
            return sb3.toString().toUpperCase(Locale.ENGLISH);
        } catch (Exception e) {
            Log.e(LOGTAG, "GetUUID Exception:" + e);
            return DefaultUUID;
        }
    }
}
