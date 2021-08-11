package com.amap.api.location;

import android.content.Context;
import com.amap.loc.C0310c;

public class CoordinateConverter {

    /* renamed from: a */
    DPoint f207a = null;

    /* renamed from: b */
    private Context f208b;

    /* renamed from: c */
    private CoordType f209c = null;

    /* renamed from: d */
    private DPoint f210d = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.f208b = context;
    }

    public synchronized DPoint convert() throws Exception {
        if (this.f209c == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        } else if (this.f210d == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        } else if (this.f210d.getLongitude() > 180.0d || this.f210d.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        } else if (this.f210d.getLatitude() > 90.0d || this.f210d.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        } else {
            switch (this.f209c) {
                case BAIDU:
                    this.f207a = C0214a.m355a(this.f210d);
                    break;
                case MAPBAR:
                    this.f207a = C0214a.m360b(this.f208b, this.f210d);
                    break;
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    this.f207a = this.f210d;
                    break;
                case GPS:
                    this.f207a = C0214a.m354a(this.f208b, this.f210d);
                    break;
            }
        }
        return this.f207a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            throw new IllegalArgumentException("传入经纬度对象为空");
        } else if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        } else if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        } else {
            this.f210d = dPoint;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f209c = coordType;
        return this;
    }

    public boolean isAMapDataAvailable(double d, double d2) {
        return C0310c.m957a(d, d2);
    }
}
