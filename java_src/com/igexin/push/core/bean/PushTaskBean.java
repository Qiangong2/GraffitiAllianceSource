package com.igexin.push.core.bean;

import java.util.List;
import java.util.Map;

public class PushTaskBean {

    /* renamed from: a */
    private String f1445a;

    /* renamed from: b */
    private String f1446b;

    /* renamed from: c */
    private String f1447c;

    /* renamed from: d */
    private String f1448d;

    /* renamed from: e */
    private String f1449e;

    /* renamed from: f */
    private List<BaseAction> f1450f;

    /* renamed from: g */
    private byte[] f1451g;

    /* renamed from: h */
    private String f1452h;

    /* renamed from: i */
    private String f1453i;

    /* renamed from: j */
    private int f1454j;

    /* renamed from: k */
    private int f1455k;

    /* renamed from: l */
    private boolean f1456l = false;

    /* renamed from: m */
    private boolean f1457m = false;

    /* renamed from: n */
    private boolean f1458n = false;

    /* renamed from: o */
    private Map<String, String> f1459o;

    /* renamed from: p */
    private int f1460p;

    /* renamed from: q */
    private int f1461q;

    public String getAction() {
        return this.f1445a;
    }

    public List<BaseAction> getActionChains() {
        return this.f1450f;
    }

    public String getAppKey() {
        return this.f1453i;
    }

    public String getAppid() {
        return this.f1446b;
    }

    public BaseAction getBaseAction(String str) {
        for (BaseAction baseAction : getActionChains()) {
            if (baseAction.getActionId().equals(str)) {
                return baseAction;
            }
        }
        return null;
    }

    public Map<String, String> getConditionMap() {
        return this.f1459o;
    }

    public int getCurrentActionid() {
        return this.f1454j;
    }

    public int getExecuteTimes() {
        return this.f1461q;
    }

    public String getId() {
        return this.f1447c;
    }

    public String getMessageId() {
        return this.f1448d;
    }

    public String getMsgAddress() {
        return this.f1452h;
    }

    public byte[] getMsgExtra() {
        return this.f1451g;
    }

    public int getPerActionid() {
        return this.f1455k;
    }

    public int getStatus() {
        return this.f1460p;
    }

    public String getTaskId() {
        return this.f1449e;
    }

    public boolean isCDNType() {
        return this.f1458n;
    }

    public boolean isHttpImg() {
        return this.f1456l;
    }

    public boolean isStop() {
        return this.f1457m;
    }

    public void setAction(String str) {
        this.f1445a = str;
    }

    public void setActionChains(List<BaseAction> list) {
        this.f1450f = list;
    }

    public void setAppKey(String str) {
        this.f1453i = str;
    }

    public void setAppid(String str) {
        this.f1446b = str;
    }

    public void setCDNType(boolean z) {
        this.f1458n = z;
    }

    public void setConditionMap(Map<String, String> map) {
        this.f1459o = map;
    }

    public void setCurrentActionid(int i) {
        this.f1454j = i;
    }

    public void setExecuteTimes(int i) {
        this.f1461q = i;
    }

    public void setHttpImg(boolean z) {
        this.f1456l = z;
    }

    public void setId(String str) {
        this.f1447c = str;
    }

    public void setMessageId(String str) {
        this.f1448d = str;
    }

    public void setMsgAddress(String str) {
        this.f1452h = str;
    }

    public void setMsgExtra(byte[] bArr) {
        this.f1451g = bArr;
    }

    public void setPerActionid(int i) {
        this.f1455k = i;
    }

    public void setStatus(int i) {
        this.f1460p = i;
    }

    public void setStop(boolean z) {
        this.f1457m = z;
    }

    public void setTaskId(String str) {
        this.f1449e = str;
    }
}
