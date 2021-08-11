package com.amap.api.location;

import android.location.Location;
import com.amap.loc.C0310c;
import com.amap.loc.C0331cr;
import com.umeng.analytics.p091b.C1447g;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class AMapLocation extends Location {
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;

    /* renamed from: a */
    protected String f166a = "";

    /* renamed from: b */
    private String f167b = "";

    /* renamed from: c */
    private String f168c = "";

    /* renamed from: d */
    private String f169d = "";

    /* renamed from: e */
    private String f170e = "";

    /* renamed from: f */
    private String f171f = "";

    /* renamed from: g */
    private String f172g = "";

    /* renamed from: h */
    private String f173h = "";

    /* renamed from: i */
    private String f174i = "";

    /* renamed from: j */
    private String f175j = "";

    /* renamed from: k */
    private String f176k = "";

    /* renamed from: l */
    private String f177l = "";

    /* renamed from: m */
    private boolean f178m = true;

    /* renamed from: n */
    private int f179n = 0;

    /* renamed from: o */
    private String f180o = "success";

    /* renamed from: p */
    private String f181p = "";

    /* renamed from: q */
    private int f182q = 0;

    /* renamed from: r */
    private double f183r = 0.0d;

    /* renamed from: s */
    private double f184s = 0.0d;

    /* renamed from: t */
    private int f185t = 0;

    /* renamed from: u */
    private String f186u = "";

    public AMapLocation(Location location) {
        super(location);
        this.f183r = location.getLatitude();
        this.f184s = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo3490a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1:
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", (double) getSpeed());
                    jSONObject.put("bearing", (double) getBearing());
                    jSONObject.put("citycode", this.f170e);
                    jSONObject.put("desc", this.f166a);
                    jSONObject.put("adcode", this.f171f);
                    jSONObject.put(C1447g.f3443G, this.f174i);
                    jSONObject.put("province", this.f167b);
                    jSONObject.put("city", this.f168c);
                    jSONObject.put("district", this.f169d);
                    jSONObject.put("road", this.f175j);
                    jSONObject.put("street", this.f176k);
                    jSONObject.put("number", this.f177l);
                    jSONObject.put("poiname", this.f173h);
                    jSONObject.put("errorCode", this.f179n);
                    jSONObject.put("errorInfo", this.f180o);
                    jSONObject.put("locationType", this.f182q);
                    jSONObject.put("locationDetail", this.f181p);
                    jSONObject.put("aoiname", this.f186u);
                    jSONObject.put("address", this.f172g);
                case 2:
                    jSONObject.put("time", getTime());
                    break;
                case 3:
                    break;
                default:
                    return jSONObject;
            }
            jSONObject.put(C1447g.f3499as, getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put(C1447g.f3485ae, getLatitude());
            jSONObject.put("accuracy", (double) getAccuracy());
            jSONObject.put("isOffset", this.f178m);
            return jSONObject;
        } catch (Throwable th) {
            C0310c.m956a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.f171f;
    }

    public String getAddress() {
        return this.f172g;
    }

    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.f186u;
    }

    public float getBearing() {
        return super.getBearing();
    }

    public String getCity() {
        return this.f168c;
    }

    public String getCityCode() {
        return this.f170e;
    }

    public String getCountry() {
        return this.f174i;
    }

    public String getDistrict() {
        return this.f169d;
    }

    public int getErrorCode() {
        return this.f179n;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f180o);
        if (this.f179n != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/abouterrorcode/查看错误码说明.");
        }
        this.f180o = sb.toString();
        return this.f180o;
    }

    public double getLatitude() {
        return this.f183r;
    }

    public String getLocationDetail() {
        return this.f181p;
    }

    public int getLocationType() {
        return this.f182q;
    }

    public double getLongitude() {
        return this.f184s;
    }

    public String getPoiName() {
        return this.f173h;
    }

    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.f167b;
    }

    public String getRoad() {
        return this.f175j;
    }

    public int getSatellites() {
        return this.f185t;
    }

    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.f176k;
    }

    public String getStreetNum() {
        return this.f177l;
    }

    public boolean isOffset() {
        return this.f178m;
    }

    public void setAdCode(String str) {
        this.f171f = str;
    }

    public void setAddress(String str) {
        this.f172g = str;
    }

    public void setAoiName(String str) {
        this.f186u = str;
    }

    public void setCity(String str) {
        this.f168c = str;
    }

    public void setCityCode(String str) {
        this.f170e = str;
    }

    public void setCountry(String str) {
        this.f174i = str;
    }

    public void setDistrict(String str) {
        this.f169d = str;
    }

    public void setErrorCode(int i) {
        if (this.f179n == 0) {
            this.f180o = C0331cr.m1185d(i);
            this.f179n = i;
        }
    }

    public void setErrorInfo(String str) {
        this.f180o = str;
    }

    public void setLatitude(double d) {
        this.f183r = d;
    }

    public void setLocationDetail(String str) {
        this.f181p = str;
    }

    public void setLocationType(int i) {
        this.f182q = i;
    }

    public void setLongitude(double d) {
        this.f184s = d;
    }

    public void setNumber(String str) {
        this.f177l = str;
    }

    public void setOffset(boolean z) {
        this.f178m = z;
    }

    public void setPoiName(String str) {
        this.f173h = str;
    }

    public void setProvince(String str) {
        this.f167b = str;
    }

    public void setRoad(String str) {
        this.f175j = str;
    }

    public void setSatellites(int i) {
        this.f185t = i;
    }

    public void setStreet(String str) {
        this.f176k = str;
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = mo3490a(i);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f183r);
            stringBuffer.append("longitude=" + this.f184s);
            stringBuffer.append("province=" + this.f167b + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("city=" + this.f168c + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("district=" + this.f169d + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("cityCode=" + this.f170e + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("adCode=" + this.f171f + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("address=" + this.f172g + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("country=" + this.f174i + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("road=" + this.f175j + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("poiName=" + this.f173h + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("street=" + this.f176k + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("streetNum=" + this.f177l + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("aoiName=" + this.f186u + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("errorCode=" + this.f179n + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("errorInfo=" + this.f180o + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("locationDetail=" + this.f181p + MqttTopic.MULTI_LEVEL_WILDCARD);
            stringBuffer.append("locationType=" + this.f182q);
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }
}
