package com.igexin.push.extension.distribution.gbd.p076i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.h */
public class C1119h implements IInterface {

    /* renamed from: a */
    private IBinder f2978a;

    public C1119h(IBinder iBinder) {
        this.f2978a = iBinder;
    }

    /* renamed from: a */
    public String mo5881a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str = null;
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f2978a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Exception e) {
            C1115d.m4558a(e);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
        return str;
    }

    public IBinder asBinder() {
        return this.f2978a;
    }
}
