package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.loc.C0331cr;

public class Fence implements Parcelable {
    public static final Parcelable.Creator<Fence> CREATOR = new Parcelable.Creator<Fence>() {
        /* class com.amap.api.fence.Fence.C02121 */

        /* renamed from: a */
        public Fence createFromParcel(Parcel parcel) {
            return new Fence(parcel);
        }

        /* renamed from: a */
        public Fence[] newArray(int i) {
            return new Fence[i];
        }
    };

    /* renamed from: a */
    public PendingIntent f156a;

    /* renamed from: b */
    public String f157b;

    /* renamed from: c */
    public double f158c;

    /* renamed from: d */
    public double f159d;

    /* renamed from: e */
    public float f160e;

    /* renamed from: f */
    public int f161f;

    /* renamed from: g */
    public long f162g;

    /* renamed from: h */
    private long f163h;

    /* renamed from: i */
    private long f164i;

    /* renamed from: j */
    private int f165j;

    public Fence() {
        this.f156a = null;
        this.f157b = null;
        this.f158c = 0.0d;
        this.f159d = 0.0d;
        this.f160e = 0.0f;
        this.f163h = -1;
        this.f164i = -1;
        this.f165j = 3;
        this.f161f = -1;
        this.f162g = -1;
    }

    private Fence(Parcel parcel) {
        this.f156a = null;
        this.f157b = null;
        this.f158c = 0.0d;
        this.f159d = 0.0d;
        this.f160e = 0.0f;
        this.f163h = -1;
        this.f164i = -1;
        this.f165j = 3;
        this.f161f = -1;
        this.f162g = -1;
        if (parcel != null) {
            this.f157b = parcel.readString();
            this.f158c = parcel.readDouble();
            this.f159d = parcel.readDouble();
            this.f160e = parcel.readFloat();
            this.f163h = parcel.readLong();
            this.f164i = parcel.readLong();
            this.f165j = parcel.readInt();
            this.f161f = parcel.readInt();
            this.f162g = parcel.readLong();
        }
    }

    /* renamed from: a */
    public int mo3480a() {
        return this.f165j;
    }

    /* renamed from: a */
    public void mo3481a(long j) {
        if (j < 0) {
            this.f163h = -1;
        } else {
            this.f163h = C0331cr.m1170b() + j;
        }
    }

    /* renamed from: b */
    public long mo3482b() {
        return this.f163h;
    }

    /* renamed from: c */
    public long mo3483c() {
        return this.f164i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f157b);
        parcel.writeDouble(this.f158c);
        parcel.writeDouble(this.f159d);
        parcel.writeFloat(this.f160e);
        parcel.writeLong(this.f163h);
        parcel.writeLong(this.f164i);
        parcel.writeInt(this.f165j);
        parcel.writeInt(this.f161f);
        parcel.writeLong(this.f162g);
    }
}
