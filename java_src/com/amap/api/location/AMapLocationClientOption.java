package com.amap.api.location;

import com.amap.loc.C0310c;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class AMapLocationClientOption implements Cloneable {

    /* renamed from: a */
    static String f189a = "";

    /* renamed from: i */
    private static AMapLocationProtocol f190i = AMapLocationProtocol.HTTP;

    /* renamed from: b */
    private long f191b = 2000;

    /* renamed from: c */
    private long f192c = ((long) C0310c.f629e);

    /* renamed from: d */
    private boolean f193d = false;

    /* renamed from: e */
    private boolean f194e = false;

    /* renamed from: f */
    private boolean f195f = true;

    /* renamed from: g */
    private boolean f196g = true;

    /* renamed from: h */
    private AMapLocationMode f197h = AMapLocationMode.Hight_Accuracy;

    /* renamed from: j */
    private boolean f198j = false;

    /* renamed from: k */
    private boolean f199k = false;

    /* renamed from: l */
    private boolean f200l = true;

    /* renamed from: m */
    private boolean f201m = true;

    /* renamed from: n */
    private boolean f202n = false;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: a */
        private int f205a;

        private AMapLocationProtocol(int i) {
            this.f205a = i;
        }

        public int getValue() {
            return this.f205a;
        }
    }

    /* renamed from: a */
    private AMapLocationClientOption m348a(AMapLocationClientOption aMapLocationClientOption) {
        this.f191b = aMapLocationClientOption.f191b;
        this.f193d = aMapLocationClientOption.f193d;
        this.f197h = aMapLocationClientOption.f197h;
        this.f194e = aMapLocationClientOption.f194e;
        this.f198j = aMapLocationClientOption.f198j;
        this.f199k = aMapLocationClientOption.f199k;
        this.f195f = aMapLocationClientOption.f195f;
        this.f196g = aMapLocationClientOption.f196g;
        this.f192c = aMapLocationClientOption.f192c;
        this.f200l = aMapLocationClientOption.f200l;
        this.f201m = aMapLocationClientOption.f201m;
        this.f202n = aMapLocationClientOption.f202n;
        return this;
    }

    public static String getAPIKEY() {
        return f189a;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f190i = aMapLocationProtocol;
    }

    @Override // java.lang.Object
    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().m348a(this);
    }

    public long getHttpTimeOut() {
        return this.f192c;
    }

    public long getInterval() {
        return this.f191b;
    }

    public AMapLocationMode getLocationMode() {
        return this.f197h;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f190i;
    }

    public boolean isGpsFirst() {
        return this.f199k;
    }

    public boolean isKillProcess() {
        return this.f198j;
    }

    public boolean isLocationCacheEnable() {
        return this.f201m;
    }

    public boolean isMockEnable() {
        return this.f194e;
    }

    public boolean isNeedAddress() {
        return this.f195f;
    }

    public boolean isOffset() {
        return this.f200l;
    }

    public boolean isOnceLocation() {
        if (this.f202n) {
            return true;
        }
        return this.f193d;
    }

    public boolean isOnceLocationLatest() {
        return this.f202n;
    }

    public boolean isWifiActiveScan() {
        return this.f196g;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.f199k = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.f192c = j;
    }

    public AMapLocationClientOption setInterval(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.f191b = j;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.f198j = z;
        return this;
    }

    public void setLocationCacheEnable(boolean z) {
        this.f201m = z;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f197h = aMapLocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.f194e = z;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f195f = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.f200l = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.f193d = z;
        return this;
    }

    public void setOnceLocationLatest(boolean z) {
        this.f202n = z;
    }

    public void setWifiActiveScan(boolean z) {
        this.f196g = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("interval:").append(String.valueOf(this.f191b)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isOnceLocation:").append(String.valueOf(this.f193d)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("locationMode:").append(String.valueOf(this.f197h)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isMockEnable:").append(String.valueOf(this.f194e)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isKillProcess:").append(String.valueOf(this.f198j)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isGpsFirst:").append(String.valueOf(this.f199k)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isNeedAddress:").append(String.valueOf(this.f195f)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isWifiActiveScan:").append(String.valueOf(this.f196g)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("httpTimeOut:").append(String.valueOf(this.f192c)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isOffset:").append(String.valueOf(this.f200l)).append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("isLocationCacheEnable:").append(String.valueOf(this.f201m));
        return sb.toString();
    }
}
