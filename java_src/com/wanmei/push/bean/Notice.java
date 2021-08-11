package com.wanmei.push.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wanmei.push.Proguard;

@DatabaseTable(tableName = "message")
public class Notice implements Proguard, Cloneable {
    public static final String API_ADDR = "apiADDR";
    public static final String IS_OFFLINE = "isOffline";
    public static final String MSG_ID = "msgId";
    @DatabaseField(columnName = "apiADDR", index = true)
    private String apiAddr;
    @DatabaseField(columnName = IS_OFFLINE)
    private String isOffline;
    @DatabaseField(columnName = MSG_ID, index = true)
    private String msgId;

    public static class Builder {
        private String apiAddr;
        private String isOffline = "0";
        private String msgId;

        public Builder(String msgId2, String apiAddr2) {
            this.msgId = msgId2;
            this.apiAddr = apiAddr2;
        }

        public Notice build() {
            return new Notice(this);
        }

        public Builder isoffline(String val) {
            this.isOffline = val;
            return this;
        }
    }

    public Notice() {
        this.isOffline = "0";
    }

    private Notice(Builder builder) {
        this.isOffline = "0";
        this.msgId = builder.msgId;
        this.apiAddr = builder.apiAddr;
        this.isOffline = builder.isOffline;
    }

    public static Notice newMessage(Notice message) {
        Notice notice;
        if (message == null) {
            return null;
        }
        try {
            notice = (Notice) message.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            notice = null;
        }
        return notice;
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
        Notice notice = (Notice) o;
        if (this.msgId == null ? notice.msgId != null : !this.msgId.equals(notice.msgId)) {
            return false;
        }
        if (this.isOffline == null ? notice.isOffline != null : !this.isOffline.equals(notice.isOffline)) {
            return false;
        }
        if (this.apiAddr != null) {
            if (this.apiAddr.equals(notice.apiAddr)) {
                return true;
            }
        } else if (notice.apiAddr == null) {
            return true;
        }
        return false;
    }

    public String getApiAddr() {
        return this.apiAddr;
    }

    public String getIsOffline() {
        return this.isOffline;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.isOffline != null ? this.isOffline.hashCode() : 0) + (((this.msgId != null ? this.msgId.hashCode() : 0) + 0) * 31)) * 31;
        if (this.apiAddr != null) {
            i = this.apiAddr.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Notice{, msgId=" + this.msgId + ", isOffline=" + this.isOffline + ", apiAddr=" + this.apiAddr + '}';
    }
}
