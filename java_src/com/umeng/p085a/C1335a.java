package com.umeng.p085a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.umeng.a.a */
/* compiled from: AdvertisingId */
public class C1335a {

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.a.a$a */
    /* compiled from: AdvertisingId */
    public static final class C1337a {

        /* renamed from: a */
        private final String f3128a;

        /* renamed from: b */
        private final boolean f3129b;

        C1337a(String str, boolean z) {
            this.f3128a = str;
            this.f3129b = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: b */
        private String m4906b() {
            return this.f3128a;
        }

        /* renamed from: a */
        public boolean mo8361a() {
            return this.f3129b;
        }
    }

    /* renamed from: a */
    public static String m4903a(Context context) {
        try {
            C1337a b = m4904b(context);
            if (b == null) {
                return null;
            }
            return b.m4906b();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private static C1337a m4904b(Context context) throws Exception {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC1338b bVar = new ServiceConnectionC1338b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    C1339c cVar = new C1339c(bVar.mo8362a());
                    C1337a aVar = new C1337a(cVar.mo8365a(), cVar.mo8366a(true));
                    context.unbindService(bVar);
                    return aVar;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(bVar);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.a.a$b */
    /* compiled from: AdvertisingId */
    public static final class ServiceConnectionC1338b implements ServiceConnection {

        /* renamed from: a */
        boolean f3130a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f3131b;

        private ServiceConnectionC1338b() {
            this.f3130a = false;
            this.f3131b = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3131b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        /* renamed from: a */
        public IBinder mo8362a() throws InterruptedException {
            if (this.f3130a) {
                throw new IllegalStateException();
            }
            this.f3130a = true;
            return this.f3131b.take();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.a.a$c */
    /* compiled from: AdvertisingId */
    public static final class C1339c implements IInterface {

        /* renamed from: a */
        private IBinder f3132a;

        public C1339c(IBinder iBinder) {
            this.f3132a = iBinder;
        }

        public IBinder asBinder() {
            return this.f3132a;
        }

        /* renamed from: a */
        public String mo8365a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3132a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        public boolean mo8366a(boolean z) throws RemoteException {
            boolean z2 = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f3132a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
