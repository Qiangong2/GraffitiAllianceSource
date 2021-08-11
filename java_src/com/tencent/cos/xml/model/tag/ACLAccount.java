package com.tencent.cos.xml.model.tag;

import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;

public class ACLAccount {
    List<String> idList = new ArrayList();

    public void addAccount(String ownerUin, String subUin) {
        if (ownerUin != null && subUin != null) {
            this.idList.add(String.format("id=\"qcs::cam::uin/%s:uin/%s\"", ownerUin, subUin));
        }
    }

    public void addAccount(String owner) {
        addAccount(owner, owner);
    }

    public String getAccount() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String account : this.idList) {
            stringBuilder.append(account).append(MiPushClient.ACCEPT_TIME_SEPARATOR);
        }
        String result = stringBuilder.toString();
        int last = result.lastIndexOf(MiPushClient.ACCEPT_TIME_SEPARATOR);
        if (last > 0) {
            return result.substring(0, last);
        }
        return null;
    }
}
