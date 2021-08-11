package com.igexin.push.util;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.util.p */
public final class C1166p implements IInterface {

    /* renamed from: a */
    private IBinder f3044a;

    public C1166p(IBinder iBinder) {
        this.f3044a = iBinder;
    }

    /* renamed from: a */
    public String mo5912a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str = null;
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f3044a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Exception e) {
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
        return str;
    }

    public IBinder asBinder() {
        return this.f3044a;
    }
}
