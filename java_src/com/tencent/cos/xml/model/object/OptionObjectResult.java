package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Arrays;
import java.util.List;

public final class OptionObjectResult extends CosXmlResult {
    private List<String> accessControlAllowHeaders;
    private List<String> accessControlAllowMethods;
    private String accessControlAllowOrigin;
    private List<String> accessControlExposeHeaders;
    private long accessControlMaxAge;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.accessControlAllowOrigin = response.header("Access-Control-Allow-Origin");
        if (response.header("Access-Control-Max-Age") != null) {
            this.accessControlMaxAge = Long.parseLong(response.header("Access-Control-Max-Age"));
        }
        if (response.header("Access-Control-Allow-Methods") != null) {
            this.accessControlAllowMethods = Arrays.asList(response.header("Access-Control-Allow-Methods").split(MiPushClient.ACCEPT_TIME_SEPARATOR));
        }
        if (response.header("Access-Control-Allow-Headers") != null) {
            this.accessControlAllowHeaders = Arrays.asList(response.header("Access-Control-Allow-Headers").split(MiPushClient.ACCEPT_TIME_SEPARATOR));
        }
        if (response.header("Access-Control-Expose-Headers") != null) {
            this.accessControlExposeHeaders = Arrays.asList(response.header("Access-Control-Expose-Headers").split(MiPushClient.ACCEPT_TIME_SEPARATOR));
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return super.printResult() + IOUtils.LINE_SEPARATOR_UNIX + this.accessControlAllowOrigin + IOUtils.LINE_SEPARATOR_UNIX + this.accessControlMaxAge + IOUtils.LINE_SEPARATOR_UNIX;
    }
}
