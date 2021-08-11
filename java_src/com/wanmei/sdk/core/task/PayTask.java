package com.wanmei.sdk.core.task;

import android.app.Activity;
import com.pwrd.android.volley.VolleyError;
import com.wanmei.sdk.core.LibCoreCode;
import com.wanmei.sdk.core.bean.CommReq;
import com.wanmei.sdk.core.bean.PayReq;
import com.wanmei.sdk.core.bean.PayResp;
import com.wanmei.sdk.core.net.DownloadParams;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.param.BaseOrderParams;
import com.wanmei.sdk.core.util.Toast;
import java.util.HashMap;

public class PayTask extends AbstractC1807a<PayResp> {

    /* renamed from: c */
    private BaseOrderParams f4506c;

    /* renamed from: d */
    private PayCallBack f4507d;

    /* renamed from: e */
    private PayListener f4508e;

    public interface PayCallBack {
        void failed(String str);

        void succeed(String str, String str2);
    }

    public interface PayListener {
        void onPayResult(int i, String str, String str2);
    }

    public PayTask(Activity activity, BaseOrderParams params, PayCallBack listener) {
        super(activity, DownloadParams.m6505c(), PayResp.class, "下单中，请稍候...");
        this.f4506c = params;
        this.f4507d = listener;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.sdk.core.task.AbstractC1807a
    /* renamed from: a */
    public void mo9821a(VolleyError volleyError) {
        Toast.makeToastOneSDKError(this.f4509a, "支付发生异常，请稍后重试", -30);
        SDKCoreFacade.getInstance().getCommonOrderInfo().setOrderId("");
        if (this.f4508e != null) {
            this.f4508e.onPayResult(1, LibCoreCode.MSG_ERROR, "");
        } else {
            this.f4507d.failed(volleyError.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9823a(PayResp payResp) {
        switch (payResp.getCode()) {
            case 0:
                String orderId = payResp.getOrderId();
                SDKCoreFacade.getInstance().getCommonOrderInfo().setOrderId(orderId);
                if (this.f4508e != null) {
                    this.f4508e.onPayResult(payResp.getCode(), payResp.getMsg(), orderId);
                    return;
                } else {
                    this.f4507d.succeed(orderId, payResp.getMsg());
                    return;
                }
            default:
                SDKCoreFacade.getInstance().getCommonOrderInfo().setOrderId("");
                if (this.f4508e != null) {
                    this.f4508e.onPayResult(payResp.getCode(), payResp.getMsg(), "");
                    return;
                } else {
                    this.f4507d.failed(payResp.getMsg());
                    return;
                }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.sdk.core.task.AbstractC1807a
    /* renamed from: a */
    public void mo9824a(String str) {
        SDKCoreFacade.getInstance().getCommonOrderInfo().setOrderId("");
        if (this.f4508e != null) {
            this.f4508e.onPayResult(1, LibCoreCode.MSG_ERROR, "");
        } else {
            this.f4507d.failed(str);
        }
    }

    @Override // com.wanmei.sdk.core.task.AbstractC1807a
    /* renamed from: d */
    public CommReq mo9825d() {
        PayReq payReq = new PayReq();
        payReq.setAmount(this.f4506c.getPrice());
        payReq.setAppOrder(this.f4506c.getOrderNum());
        payReq.setExt(this.f4506c.getExt());
        payReq.setUid(SDKCoreFacade.getInstance().getAccount().getUserId());
        payReq.setServerId(this.f4506c.getServerId());
        payReq.setPaySchemeVersion(SDKCoreFacade.getInstance().getPaySchemeVersion());
        HashMap<String, String> extraParams = this.f4506c.getExtraParams();
        extraParams.put(BaseOrderParams.PRODUCT_NAME, this.f4506c.getProductName());
        extraParams.put(BaseOrderParams.PRODUCT_DESC, this.f4506c.getProductDesc());
        payReq.setExtraMap(extraParams);
        return payReq;
    }
}
