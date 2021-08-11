package android.support.p007v4.p009os;

import android.os.Parcel;

/* renamed from: android.support.v4.os.ParcelableCompatCreatorCallbacks */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
