package com.igexin.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.igexin.sdk.aidl.a */
public abstract class AbstractBinderC1175a extends Binder implements IGexinMsgService {
    public AbstractBinderC1175a() {
        attachInterface(this, "com.igexin.sdk.aidl.IGexinMsgService");
    }

    /* renamed from: a */
    public static IGexinMsgService m4829a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.igexin.sdk.aidl.IGexinMsgService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof IGexinMsgService)) ? new C1176b(iBinder) : (IGexinMsgService) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int startService = startService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case 2:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int stopService = stopService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(stopService);
                return true;
            case 3:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int isStarted = isStarted(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(isStarted);
                return true;
            case 4:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int silentTime = setSilentTime(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(silentTime);
                return true;
            case 5:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                byte[] extFunction = extFunction(parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeByteArray(extFunction);
                return true;
            case 6:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int onASNLConnected = onASNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(onASNLConnected);
                return true;
            case 7:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int onPSNLConnected = onPSNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(onPSNLConnected);
                return true;
            case 8:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int sendByASNL = sendByASNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(sendByASNL);
                return true;
            case 9:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int receiveToPSNL = receiveToPSNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(receiveToPSNL);
                return true;
            case 10:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int onASNLNetworkConnected = onASNLNetworkConnected();
                parcel2.writeNoException();
                parcel2.writeInt(onASNLNetworkConnected);
                return true;
            case 11:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                int onASNLNetworkDisconnected = onASNLNetworkDisconnected();
                parcel2.writeNoException();
                parcel2.writeInt(onASNLNetworkDisconnected);
                return true;
            case 1598968902:
                parcel2.writeString("com.igexin.sdk.aidl.IGexinMsgService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
