package com.wanmei.push.bean;

public class DeviceInfo {
    private String mDeviceId;
    private String mDeviceName;
    private String mResolution;
    private String mSysVersion;

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getResolution() {
        return this.mResolution;
    }

    public String getSysVersion() {
        return this.mSysVersion;
    }

    public void setDeviceId(String DeviceId) {
        this.mDeviceId = DeviceId;
    }

    public void setDeviceName(String DeviceName) {
        this.mDeviceName = DeviceName;
    }

    public void setResolution(String Resolution) {
        this.mResolution = Resolution;
    }

    public void setSysVersion(String SysVersion) {
        this.mSysVersion = SysVersion;
    }

    public String toString() {
        return "DeviceInfo{mDeviceId='" + this.mDeviceId + '\'' + ", mDeviceName='" + this.mDeviceName + '\'' + ", mSysVersion='" + this.mSysVersion + '\'' + ", mResolution='" + this.mResolution + '\'' + '}';
    }
}
