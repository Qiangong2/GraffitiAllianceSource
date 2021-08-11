package com.wanmei.push.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wanmei.push.Proguard;

@DatabaseTable(tableName = "appstate")
public class AppState implements Proguard, Cloneable {
    public static final String API_ADDR = "apiADDR";
    public static final String APP_ID = "appId";
    public static final String PACKAGE_NAME = "pkName";
    public static final String STATE = "state";
    @DatabaseField(columnName = "apiADDR", index = true)
    private String apiAddr;
    @DatabaseField(columnName = APP_ID, index = true)
    private String appId;
    @DatabaseField(columnName = PACKAGE_NAME)
    private String pkName;
    @DatabaseField(columnName = STATE, index = true)
    private String state;

    public static class Builder {
        private String apiAddr;
        private String appId;
        private String pkName;
        private String state;

        public Builder(String appId2, String apiAddr2) {
            this.appId = appId2;
            this.apiAddr = apiAddr2;
        }

        public AppState build() {
            return new AppState(this);
        }

        public Builder pkname(String val) {
            this.pkName = val;
            return this;
        }

        public Builder state(String val) {
            this.state = val;
            return this;
        }
    }

    public AppState() {
    }

    private AppState(Builder builder) {
        this.appId = builder.appId;
        this.apiAddr = builder.apiAddr;
        this.pkName = builder.pkName;
        this.state = builder.state;
    }

    public static AppState newApp(Notice app) {
        AppState appState;
        if (app == null) {
            return null;
        }
        try {
            appState = (AppState) app.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            appState = null;
        }
        return appState;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Notice)) {
            return false;
        }
        AppState appState = (AppState) o;
        if (this.appId == null ? appState.appId != null : !this.appId.equals(appState.appId)) {
            return false;
        }
        if (this.pkName == null ? appState.pkName != null : !this.pkName.equals(appState.pkName)) {
            return false;
        }
        if (this.apiAddr == null ? appState.apiAddr != null : !this.apiAddr.equals(appState.apiAddr)) {
            return false;
        }
        if (this.state != null) {
            if (this.state.equals(appState.state)) {
                return true;
            }
        } else if (appState.state == null) {
            return true;
        }
        return false;
    }

    public String getApiAddr() {
        return this.apiAddr;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPkName() {
        return this.pkName;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.apiAddr != null ? this.apiAddr.hashCode() : 0) + (((this.pkName != null ? this.pkName.hashCode() : 0) + (((this.appId != null ? this.appId.hashCode() : 0) + 0) * 31)) * 31)) * 31;
        if (this.state != null) {
            i = this.state.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Application{, msgId=" + this.appId + ", isOffline=" + this.pkName + ", apiAddr=" + this.apiAddr + ", state=" + this.state + '}';
    }
}
