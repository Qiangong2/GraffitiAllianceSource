package com.wanmei.sdk.core.param;

import java.util.HashMap;

public class OrderParams extends BaseOrderParams {
    public static final String APP_NAME = "appName";
    public static final String BALANCE = "balance";
    public static final String COMPANY = "company";
    public static final String CURRENCY_NAME = "currencyName";
    public static final String EXCHANGE_RATE = "exchangeRate";

    /* renamed from: LV */
    public static final String f4502LV = "lv";
    public static final String PARTY_NAME = "partyName";
    public static final String PRODUCT_COUNT = "productCount";
    public static final String PRODUCT_ID = "productId";
    public static final String ROLE_ID = "roleId";
    public static final String ROLE_NAME = "roleName";
    public static final String SERVER_NAME = "serverName";
    public static final String VIP = "vip";

    public OrderParams() {
        this.payParamHashMap.put(EXCHANGE_RATE, new Param(EXCHANGE_RATE, "", true));
        this.payParamHashMap.put(PRODUCT_ID, new Param(PRODUCT_ID, "-1", true));
        this.payParamHashMap.put(APP_NAME, new Param(APP_NAME, "-1", true));
        this.payParamHashMap.put(ROLE_NAME, new Param(ROLE_NAME, "", true));
        this.payParamHashMap.put(ROLE_ID, new Param(ROLE_ID, "", true));
        this.payParamHashMap.put(f4502LV, new Param(f4502LV, "", true));
        this.payParamHashMap.put(SERVER_NAME, new Param(SERVER_NAME, "", true));
        this.payParamHashMap.put(BALANCE, new Param(BALANCE, "", true));
        this.payParamHashMap.put(VIP, new Param(VIP, "", true));
        this.payParamHashMap.put(PARTY_NAME, new Param(PARTY_NAME, "", true));
        this.payParamHashMap.put(COMPANY, new Param(COMPANY, "", true));
        this.payParamHashMap.put(CURRENCY_NAME, new Param(CURRENCY_NAME, "", true));
        this.payParamHashMap.put(PRODUCT_COUNT, new Param(PRODUCT_COUNT, "", false));
    }

    @Override // com.wanmei.sdk.core.param.BaseParams
    public HashMap<String, String> addExtraParams(HashMap<String, String> params) {
        return params;
    }

    public String getAppName() {
        return ((Param) this.payParamHashMap.get(APP_NAME)).getStringValue();
    }

    public String getBalance() {
        return ((Param) this.payParamHashMap.get(BALANCE)).getStringValue();
    }

    public String getCompany() {
        return ((Param) this.payParamHashMap.get(COMPANY)).getStringValue();
    }

    public String getCurrencyName() {
        return ((Param) this.payParamHashMap.get(CURRENCY_NAME)).getStringValue();
    }

    public int getExchangeRate() {
        return ((Param) this.payParamHashMap.get(EXCHANGE_RATE)).getIntValue();
    }

    public String getLv() {
        return ((Param) this.payParamHashMap.get(f4502LV)).getStringValue();
    }

    public String getPartyName() {
        return ((Param) this.payParamHashMap.get(PARTY_NAME)).getStringValue();
    }

    public int getProductCount() {
        return ((Param) this.payParamHashMap.get(PRODUCT_COUNT)).getIntValue();
    }

    public String getProductId() {
        return ((Param) this.payParamHashMap.get(PRODUCT_ID)).getStringValue();
    }

    public String getRoleId() {
        return ((Param) this.payParamHashMap.get(ROLE_ID)).getStringValue();
    }

    public String getRoleName() {
        return ((Param) this.payParamHashMap.get(ROLE_NAME)).getStringValue();
    }

    public String getServerName() {
        return ((Param) this.payParamHashMap.get(SERVER_NAME)).getStringValue();
    }

    public String getVip() {
        return ((Param) this.payParamHashMap.get(VIP)).getStringValue();
    }

    public void setAppName(String appName) {
        ((Param) this.payParamHashMap.get(APP_NAME)).setValue(appName);
    }

    public void setBalance(String balance) {
        ((Param) this.payParamHashMap.get(BALANCE)).setValue(balance);
    }

    public void setCompany(String company) {
        ((Param) this.payParamHashMap.get(COMPANY)).setValue(company);
    }

    public void setCurrencyName(String currencyName) {
        ((Param) this.payParamHashMap.get(CURRENCY_NAME)).setValue(currencyName);
    }

    public void setExchangeRate(int exchangeRate) {
        ((Param) this.payParamHashMap.get(EXCHANGE_RATE)).setValue(Integer.toString(exchangeRate));
    }

    public void setLv(String lv) {
        ((Param) this.payParamHashMap.get(f4502LV)).setValue(lv);
    }

    public void setPartyName(String partyName) {
        ((Param) this.payParamHashMap.get(PARTY_NAME)).setValue(partyName);
    }

    public void setProductCount(int productCount) {
        ((Param) this.payParamHashMap.get(PRODUCT_COUNT)).setValue(Integer.toString(productCount));
    }

    public void setProductId(String productId) {
        ((Param) this.payParamHashMap.get(PRODUCT_ID)).setValue(productId);
    }

    public void setRoleId(String roleId) {
        ((Param) this.payParamHashMap.get(ROLE_ID)).setValue(roleId);
    }

    public void setRoleName(String roleName) {
        ((Param) this.payParamHashMap.get(ROLE_NAME)).setValue(roleName);
    }

    public void setServerName(String serverName) {
        ((Param) this.payParamHashMap.get(SERVER_NAME)).setValue(serverName);
    }

    public void setVip(String vip) {
        ((Param) this.payParamHashMap.get(VIP)).setValue(vip);
    }
}
