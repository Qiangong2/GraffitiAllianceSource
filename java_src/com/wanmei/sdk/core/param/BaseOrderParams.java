package com.wanmei.sdk.core.param;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class BaseOrderParams extends BaseParams {
    public static final String EXT = "ext";
    public static final String ORDER_NUM = "orderNum";
    public static final String PRICE = "price";
    public static final String PRODUCT_DESC = "productDesc";
    public static final String PRODUCT_NAME = "productName";
    public static final String SERVER_ID = "serverId";
    private static final String TAG = BaseOrderParams.class.getName();
    protected HashMap<String, Param> payParamHashMap = new HashMap<>();

    protected BaseOrderParams() {
        this.payParamHashMap.put(ORDER_NUM, new Param(ORDER_NUM, "", true));
        this.payParamHashMap.put(PRICE, new Param(PRICE, "-1", true));
        this.payParamHashMap.put(SERVER_ID, new Param(SERVER_ID, "-1", true));
        this.payParamHashMap.put(PRODUCT_NAME, new Param(PRODUCT_NAME, "", true));
        this.payParamHashMap.put(PRODUCT_DESC, new Param(PRODUCT_DESC, "", true));
        this.payParamHashMap.put(EXT, new Param(EXT, "", true));
    }

    private void addParams(ArrayList<Param> necessary) {
        if (necessary != null) {
            Iterator<Param> it = necessary.iterator();
            while (it.hasNext()) {
                Param next = it.next();
                if (!this.payParamHashMap.containsKey(next.getName())) {
                    this.payParamHashMap.put(next.getName(), next);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<Param> addNecessaryParams() {
        return new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public ArrayList<Param> addOptionalParams() {
        return new ArrayList<>();
    }

    public String getExt() {
        return this.payParamHashMap.get(EXT).getStringValue();
    }

    public String getOrderNum() {
        return this.payParamHashMap.get(ORDER_NUM).getStringValue();
    }

    public final HashMap<String, Param> getPayParams() {
        addParams(addNecessaryParams());
        addParams(addOptionalParams());
        return this.payParamHashMap;
    }

    public int getPrice() {
        return this.payParamHashMap.get(PRICE).getIntValue();
    }

    public String getProductDesc() {
        return this.payParamHashMap.get(PRODUCT_DESC).getStringValue();
    }

    public String getProductName() {
        return this.payParamHashMap.get(PRODUCT_NAME).getStringValue();
    }

    public int getServerId() {
        return this.payParamHashMap.get(SERVER_ID).getIntValue();
    }

    public void setExt(String ext) {
        if (ext != null) {
            this.payParamHashMap.get(EXT).setValue(ext);
        }
    }

    public void setOrderNum(String orderNum) {
        this.payParamHashMap.get(ORDER_NUM).setValue(orderNum);
    }

    public void setPrice(int price) {
        this.payParamHashMap.get(PRICE).setValue(Integer.toString(price));
    }

    public void setProductDesc(String productDesc) {
        this.payParamHashMap.get(PRODUCT_DESC).setValue(productDesc);
    }

    public void setProductName(String productName) {
        this.payParamHashMap.get(PRODUCT_NAME).setValue(productName);
    }

    public void setServerId(int serverId) {
        this.payParamHashMap.get(SERVER_ID).setValue(Integer.toString(serverId));
    }

    public String toString() {
        return "OrderParams{payParamHashMap=" + this.payParamHashMap + '}';
    }

    public void validate() {
        if (TextUtils.isEmpty(getOrderNum())) {
            throw new PayParameterLackException("lack param: orderNum");
        } else if (getPrice() < 0) {
            throw new PayParameterLackException("price is: " + getPrice());
        } else if (getServerId() < 0) {
            throw new PayParameterLackException("serverId is: " + getServerId());
        } else if (TextUtils.isEmpty(getProductName())) {
            throw new PayParameterLackException("productName is empty");
        } else {
            if (TextUtils.isEmpty(getProductDesc())) {
                Log.d(TAG, "productDesc is empty");
            }
            if (TextUtils.isEmpty(getExt())) {
                Log.d(TAG, "ext is empty");
            }
        }
    }
}
