package com.wanmei.push.p097a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.wanmei.push.p097a.AbstractC1639a;

/* renamed from: com.wanmei.push.a.b */
public interface AbstractC1642b extends IInterface {

    /* renamed from: com.wanmei.push.a.b$a */
    public static abstract class AbstractBinderC1643a extends Binder implements AbstractC1642b {

        /* renamed from: com.wanmei.push.a.b$a$a */
        private static class C1644a implements AbstractC1642b {

            /* renamed from: a */
            private IBinder f4216a;

            C1644a(IBinder iBinder) {
                this.f4216a = iBinder;
            }

            @Override // com.wanmei.push.p097a.AbstractC1642b
            /* renamed from: a */
            public final void mo9175a(String str, String str2, AbstractC1639a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.wanmei.push.aidl.IPushService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f4216a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4216a;
            }
        }

        public AbstractBinderC1643a() {
            attachInterface(this, "com.wanmei.push.aidl.IPushService");
        }

        /* renamed from: a */
        public static AbstractC1642b m6174a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.wanmei.push.aidl.IPushService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1642b)) ? new C1644a(iBinder) : (AbstractC1642b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AbstractC1639a aVar;
            switch (code) {
                case 1:
                    data.enforceInterface("com.wanmei.push.aidl.IPushService");
                    String readString = data.readString();
                    String readString2 = data.readString();
                    IBinder readStrongBinder = data.readStrongBinder();
                    if (readStrongBinder == null) {
                        aVar = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.wanmei.push.aidl.IPushManagerCallBack");
                        aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1639a)) ? new AbstractC1639a.AbstractBinderC1640a.C1641a(readStrongBinder) : (AbstractC1639a) queryLocalInterface;
                    }
                    mo9175a(readString, readString2, aVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.wanmei.push.aidl.IPushService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9175a(String str, String str2, AbstractC1639a aVar) throws RemoteException;
}
