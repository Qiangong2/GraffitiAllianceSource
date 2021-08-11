package com.tencent.apollo;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class ApolloVoiceConfig {
    private static String LOGTAG = "GCloudVoiceTag";
    private static final String cfgName = "GCloudVoice/config.json";
    private static Context mainContext;
    private static String storageCfgPath = null;

    public static void SetContext(Context context) {
        mainContext = context;
        File externalFilesDir = mainContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            storageCfgPath = externalFilesDir.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + cfgName;
        } else {
            Log.w(LOGTAG, "getExternalFilesDir failed !!!");
        }
    }

    public static boolean IsSDCardCfgExist() {
        return new File(storageCfgPath).exists();
    }

    public static String JSONCfg(boolean z) {
        FileInputStream open;
        if (z) {
            try {
                FileInputStream fileInputStream = new FileInputStream(storageCfgPath);
                Log.i(LOGTAG, "Read config file from storage : " + storageCfgPath);
                open = fileInputStream;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            open = mainContext.getResources().getAssets().open(cfgName);
        }
        int available = open.available();
        byte[] bArr = new byte[available];
        int i = 0;
        while (i < available) {
            int read = open.read(bArr, i, available - i);
            if (read == -1) {
                break;
            }
            i += read;
        }
        open.close();
        String str = new String(bArr, "UTF-8");
        Log.i(LOGTAG, "####Get config :" + str);
        return str;
    }
}
