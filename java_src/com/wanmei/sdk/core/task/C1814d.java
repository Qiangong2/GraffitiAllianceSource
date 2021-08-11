package com.wanmei.sdk.core.task;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/* renamed from: com.wanmei.sdk.core.task.d */
public class C1814d {

    /* renamed from: a */
    private static final String f4521a = C1814d.class.getName();

    /* renamed from: b */
    private Context f4522b;

    /* renamed from: c */
    private AbstractC1815a f4523c;

    /* renamed from: com.wanmei.sdk.core.task.d$a */
    public interface AbstractC1815a {
        void onFail();

        void onSuccess();
    }

    /* access modifiers changed from: private */
    /* renamed from: com.wanmei.sdk.core.task.d$b */
    public class CallableC1816b implements Callable<Void> {
        private CallableC1816b() {
        }

        /* synthetic */ CallableC1816b(C1814d dVar, byte b) {
            this();
        }

        /* renamed from: a */
        public Void call() throws Exception {
            MultiDex.install(C1814d.this.f4522b);
            Log.d(C1814d.f4521a, "LoadMutiDex done");
            C1814d.this.f4523c.onSuccess();
            return null;
        }
    }

    public C1814d(Context context, AbstractC1815a aVar) {
        this.f4522b = context;
        this.f4523c = aVar;
    }

    /* renamed from: a */
    public void mo9845a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CallableC1816b(this, (byte) 0));
        try {
            Executors.newSingleThreadExecutor().invokeAny(arrayList);
        } catch (InterruptedException e) {
            e.printStackTrace();
            this.f4523c.onFail();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            this.f4523c.onFail();
        }
    }
}
