package com.wanmei.sdk.core.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.wanmei.sdk.core.log.EnumC1758a;
import com.wanmei.sdk.core.log.p105a.C1761b;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.util.C1843d;
import com.wanmei.sdk.core.util.C1844e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.wanmei.sdk.core.task.b */
public class AsyncTaskC1811b extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    private Context f4517a;

    /* renamed from: b */
    private boolean f4518b = false;

    public AsyncTaskC1811b(Context context, boolean z) {
        this.f4517a = context;
        this.f4518b = z;
    }

    /* renamed from: a */
    private static String m6589a(File file) {
        String str = "";
        if (file.isDirectory()) {
            Log.d("test", "The File doesn't not exist.");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine;
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                Log.d("test", "The File doesn't not exist.");
            } catch (IOException e2) {
                Log.d("test", e2.getMessage());
            }
        }
        return str;
    }

    /* renamed from: b */
    private static String m6590b(String str) {
        String str2;
        Exception e;
        try {
            String[] split = str.split("&&");
            int length = split.length;
            str2 = "";
            int i = 0;
            while (i < length) {
                try {
                    String str3 = split[i];
                    String appKey = SDKCoreFacade.getInstance().getAppKey();
                    i++;
                    str2 = str2 + C1843d.m6688a(Base64.decode(str3, 2), appKey.substring(appKey.length() - 16, appKey.length()));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str2;
                }
            }
        } catch (Exception e3) {
            str2 = "";
            e = e3;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9834a() {
        File file;
        try {
            File a = C1761b.m6489a(this.f4517a);
            if (a == null || !a.exists() || a.isFile()) {
                return "";
            }
            File[] listFiles = a.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return "";
            }
            if (listFiles.length == 1) {
                file = listFiles[0];
            } else {
                Arrays.sort(listFiles, new Comparator<File>() {
                    /* class com.wanmei.sdk.core.task.AsyncTaskC1811b.C18121 */

                    /* renamed from: a */
                    public int compare(File file, File file2) {
                        return (int) (file2.lastModified() - file.lastModified());
                    }
                });
                file = this.f4518b ? listFiles[0] : listFiles[1];
            }
            if (file == null) {
                return "";
            }
            String a2 = m6589a(file);
            if (!TextUtils.isEmpty(a2)) {
                a2 = m6590b(a2);
            }
            C1844e.m6690a(file);
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5000) {
                str = str.substring(0, 4990);
            }
            try {
                new AsyncTaskC1819f(this.f4517a, EnumC1758a.NORMAL, URLEncoder.encode(str, "UTF-8")).execute(new Void[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* synthetic */ String doInBackground(Void[] voidArr) {
        return mo9834a();
    }
}
