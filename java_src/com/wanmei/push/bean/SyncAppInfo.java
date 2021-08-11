package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;
import java.util.List;

public class SyncAppInfo {
    @SerializedName("list")
    @Expose
    private List<DeviceAppInfo> appInfoList;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("totalPage")
    @Expose
    private String totalPage;

    public class DeviceAppInfo {
        @SerializedName(AppState.APP_ID)
        @Expose
        private String appId;
        @SerializedName("bundleId")
        @Expose
        private String bundleId;

        public DeviceAppInfo() {
        }

        public String getAppId() {
            return this.appId;
        }

        public String getBundleId() {
            return this.bundleId;
        }

        public void setAppId(String appId2) {
            this.appId = appId2;
        }

        public void setBundleId(String bundleId2) {
            this.bundleId = bundleId2;
        }
    }

    public List<DeviceAppInfo> getAppInfoList() {
        return this.appInfoList;
    }

    public String getPage() {
        return this.page;
    }

    public String getTotalPage() {
        return this.totalPage;
    }

    public void setAppInfoList(List<DeviceAppInfo> appInfoList2) {
        this.appInfoList = appInfoList2;
    }

    public void setPage(String page2) {
        this.page = page2;
    }

    public void setTotalPage(String totalPage2) {
        this.totalPage = totalPage2;
    }
}
