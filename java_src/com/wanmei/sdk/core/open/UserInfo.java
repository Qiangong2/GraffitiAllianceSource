package com.wanmei.sdk.core.open;

public class UserInfo {
    private String balance;

    /* renamed from: lv */
    private String f4501lv;
    private String partyName;
    private String roleCreateTime;
    private String roleId;
    private String roleName;
    private String vip;
    private int zoneId;
    private String zoneName;

    public String getBalance() {
        return this.balance;
    }

    public String getLv() {
        return this.f4501lv;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public String getRoleCreateTime() {
        return this.roleCreateTime;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getVip() {
        return this.vip;
    }

    public int getZoneId() {
        return this.zoneId;
    }

    public String getZoneName() {
        return this.zoneName;
    }

    public void setBalance(String balance2) {
        this.balance = balance2;
    }

    public void setLv(String lv) {
        this.f4501lv = lv;
    }

    public void setPartyName(String partyName2) {
        this.partyName = partyName2;
    }

    public void setRoleCreateTime(String roleCreateTime2) {
        this.roleCreateTime = roleCreateTime2;
    }

    public void setRoleId(String roleId2) {
        this.roleId = roleId2;
    }

    public void setRoleName(String roleName2) {
        this.roleName = roleName2;
    }

    public void setVip(String vip2) {
        this.vip = vip2;
    }

    public void setZoneId(int zoneId2) {
        this.zoneId = zoneId2;
    }

    public void setZoneName(String zoneName2) {
        this.zoneName = zoneName2;
    }

    public String toString() {
        return "UserInfo [roleId=" + this.roleId + ", roleName=" + this.roleName + ", lv=" + this.f4501lv + ", zoneId=" + this.zoneId + ", zoneName=" + this.zoneName + ", balance=" + this.balance + ", partyName=" + this.partyName + ", vip=" + this.vip + ", roleCreateTime=" + this.roleCreateTime + "]";
    }
}
