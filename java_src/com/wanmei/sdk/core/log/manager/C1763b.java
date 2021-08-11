package com.wanmei.sdk.core.log.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import com.wanmei.sdk.core.log.EnumC1758a;
import com.wanmei.sdk.core.log.p105a.C1760a;
import com.wanmei.sdk.core.log.p105a.C1761b;
import com.wanmei.sdk.core.task.RunnableC1817e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.wanmei.sdk.core.log.manager.b */
public class C1763b implements AbstractC1762a, Thread.UncaughtExceptionHandler {

    /* renamed from: d */
    private static Thread.UncaughtExceptionHandler f4449d = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: a */
    private Context f4450a;

    /* renamed from: b */
    private ExecutorService f4451b = null;

    /* renamed from: c */
    private int f4452c = 1;

    /* renamed from: e */
    private ArrayList<WeakReference<Activity>> f4453e = new ArrayList<>();

    C1763b(Context context) {
        this.f4450a = context;
        this.f4452c = Runtime.getRuntime().availableProcessors();
    }

    /* renamed from: a */
    private String m6494a(String str) {
        if (C1760a.m6482a()) {
            try {
                String c = C1761b.m6491c(this.f4450a);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(c), true);
                System.getProperty("line.separator");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                fileOutputStream.flush();
                fileOutputStream.close();
                return c;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m6495a(Runnable runnable) {
        if (this.f4451b == null || this.f4451b.isShutdown()) {
            if (this.f4452c < 0) {
                this.f4452c = 1;
            }
            this.f4451b = Executors.newFixedThreadPool(this.f4452c, new ThreadFactory() {
                /* class com.wanmei.sdk.core.log.manager.C1763b.ThreadFactoryC17641 */

                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setPriority(4);
                    thread.setName("LogManagerImpl");
                    return thread;
                }
            });
        }
        this.f4451b.submit(runnable);
    }

    /* renamed from: b */
    private String m6496b() {
        StringBuilder sb = new StringBuilder();
        int size = this.f4453e.size();
        for (int i = 0; i < size; i++) {
            sb.append(i + ":");
            WeakReference<Activity> weakReference = this.f4453e.get(i);
            if (!(weakReference == null || weakReference.get() == null)) {
                sb.append(weakReference.get().toString());
            }
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    @Override // com.wanmei.sdk.core.log.manager.AbstractC1762a
    /* renamed from: a */
    public boolean mo9550a() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        return true;
    }

    @Override // com.wanmei.sdk.core.log.manager.AbstractC1762a
    /* renamed from: a */
    public boolean mo9551a(String str, String str2) {
        if (!LogManager.getDebug()) {
            return false;
        }
        m6495a(new RunnableC1817e(this.f4450a, str, str2, EnumC1758a.NORMAL));
        return true;
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.append((CharSequence) ex.getMessage());
            ex.printStackTrace(printWriter);
            Log.getStackTraceString(ex);
            for (Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String str = MqttTopic.MULTI_LEVEL_WILDCARD + new Date().toString() + IOUtils.LINE_SEPARATOR_UNIX + C1760a.m6481a(this.f4450a) + IOUtils.LINE_SEPARATOR_UNIX + "#-------AndroidRuntime-------" + stringWriter.toString() + IOUtils.LINE_SEPARATOR_UNIX + "#-------activity_stack-------" + IOUtils.LINE_SEPARATOR_UNIX + m6496b() + "#end";
            printWriter.close();
            m6494a(str);
            if (LogManager.getDebug()) {
                m6495a(new RunnableC1817e(this.f4450a, "LogManagerImpl", str, EnumC1758a.CRASH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f4449d.uncaughtException(thread, ex);
    }
}
