package com.wanmei.push.p097a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.wanmei.push.a.a */
public interface AbstractC1639a extends IInterface {

    /* renamed from: com.wanmei.push.a.a$a */
    public static abstract class AbstractBinderC1640a extends Binder implements AbstractC1639a {

        /* access modifiers changed from: private */
        /* renamed from: com.wanmei.push.a.a$a$a */
        public static class C1641a implements AbstractC1639a {

            /* renamed from: a */
            private IBinder f4215a;

            C1641a(IBinder iBinder) {
                this.f4215a = iBinder;
            }

            @Override // com.wanmei.push.p097a.AbstractC1639a
            /* renamed from: a */
            public final void mo9170a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wanmei.push.aidl.IPushManagerCallBack");
                    this.f4215a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.wanmei.push.p097a.AbstractC1639a
            /* renamed from: a */
            public final void mo9171a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wanmei.push.aidl.IPushManagerCallBack");
                    obtain.writeInt(i);
                    this.f4215a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4215a;
            }
        }

        public AbstractBinderC1640a() {
            attachInterface(this, "com.wanmei.push.aidl.IPushManagerCallBack");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.wanmei.push.aidl.IPushManagerCallBack");
                    mo9170a();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.wanmei.push.aidl.IPushManagerCallBack");
                    mo9171a(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.wanmei.push.aidl.IPushManagerCallBack");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9170a() throws RemoteException;

    /* renamed from: a */
    void mo9171a(int i) throws RemoteException;
}
