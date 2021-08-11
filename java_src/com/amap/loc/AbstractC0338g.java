package com.amap.loc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.amap.loc.g */
/* compiled from: ILocationProviderService */
public interface AbstractC0338g extends IInterface {

    /* renamed from: com.amap.loc.g$a */
    /* compiled from: ILocationProviderService */
    public static abstract class AbstractBinderC0339a extends Binder implements AbstractC0338g {

        /* renamed from: com.amap.loc.g$a$a */
        /* compiled from: ILocationProviderService */
        private static class C0340a implements AbstractC0338g {

            /* renamed from: a */
            private IBinder f817a;

            C0340a(IBinder iBinder) {
                this.f817a = iBinder;
            }

            @Override // com.amap.loc.AbstractC0338g
            /* renamed from: a */
            public int mo3929a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.service.locationprovider.ILocationProviderService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f817a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f817a;
            }
        }

        /* renamed from: a */
        public static AbstractC0338g m1223a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0338g)) ? new C0340a(iBinder) : (AbstractC0338g) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    int a = mo3929a(bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    int mo3929a(Bundle bundle) throws RemoteException;
}
