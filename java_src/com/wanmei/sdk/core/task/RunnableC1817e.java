package com.wanmei.sdk.core.task;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import com.wanmei.sdk.core.log.EnumC1758a;
import com.wanmei.sdk.core.log.p105a.C1760a;
import com.wanmei.sdk.core.log.p105a.C1761b;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.util.C1843d;
import com.wanmei.sdk.core.util.C1844e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/* renamed from: com.wanmei.sdk.core.task.e */
public class RunnableC1817e implements Runnable {

    /* renamed from: a */
    private Context f4525a;

    /* renamed from: b */
    private String f4526b;

    /* renamed from: c */
    private String f4527c;

    /* renamed from: d */
    private EnumC1758a f4528d;

    public RunnableC1817e(Context context, String str, String str2, EnumC1758a aVar) {
        this.f4525a = context;
        this.f4527c = str2;
        this.f4526b = str;
        this.f4528d = aVar;
    }

    public void run() {
        if (this.f4525a != null && !TextUtils.isEmpty(this.f4527c) && !TextUtils.isEmpty(this.f4526b)) {
            switch (this.f4528d) {
                case NORMAL:
                    Log.d(this.f4526b, this.f4527c);
                    String str = " [" + this.f4526b + "]" + this.f4527c;
                    if (C1760a.m6482a()) {
                        String str2 = IOUtils.LINE_SEPARATOR_UNIX;
                        try {
                            File file = new File(C1761b.m6490b(this.f4525a));
                            if (!file.exists() || file.isDirectory()) {
                                C1844e.m6690a(file);
                                file.createNewFile();
                                str2 = C1760a.m6481a(this.f4525a);
                            }
                            System.getProperty("line.separator");
                            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
                            String appKey = SDKCoreFacade.getInstance().getAppKey();
                            String substring = appKey.substring(appKey.length() - 16, appKey.length());
                            outputStreamWriter.write(new StringBuilder().append(Base64.encodeToString(C1843d.m6689a(str2 + IOUtils.LINE_SEPARATOR_UNIX + str + IOUtils.LINE_SEPARATOR_UNIX, substring), 2)).append("&&").toString());
                            outputStreamWriter.flush();
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case CRASH:
                    String str3 = this.f4526b;
                    String str4 = this.f4527c;
                    new AsyncTaskC1819f(this.f4525a, this.f4528d, this.f4527c).execute(new Void[0]);
                    return;
                default:
                    return;
            }
        }
    }
}
