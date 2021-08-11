package com.wanmei.push.service;

import android.content.Context;
import android.os.Environment;
import com.pwrd.google.gson.Gson;
import com.pwrd.google.gson.reflect.TypeToken;
import com.wanmei.push.bean.AppInfo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.wanmei.push.service.d */
public final class C1746d {

    /* renamed from: a */
    private String f4424a;

    public C1746d(Context context) throws IOException {
        File file = new File("mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getAbsolutePath() : context.getApplicationContext().getDir(context.getApplicationContext().getPackageName(), 0).getAbsolutePath(), "perfectPush/push/data/");
        if (!file.exists()) {
            file.mkdirs();
        }
        new File(file, ".nomedia").createNewFile();
        File file2 = new File(file.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "push.data");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        this.f4424a = file2.getAbsolutePath();
    }

    /* renamed from: a */
    public static String m6468a(List<AppInfo> list) {
        return new Gson().toJson(list);
    }

    /* renamed from: a */
    public final String mo9443a() {
        return this.f4424a;
    }

    /* renamed from: a */
    public final synchronized void mo9444a(String str) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.f4424a), 2048);
        bufferedWriter.write("");
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* renamed from: b */
    public final String mo9445b() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f4424a);
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
                sb.append((char) read);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: b */
    public final List<AppInfo> mo9446b(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<AppInfo>>() {
            /* class com.wanmei.push.service.C1746d.C17471 */
        }.getType());
    }
}
