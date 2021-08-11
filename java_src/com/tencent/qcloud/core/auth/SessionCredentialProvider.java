package com.tencent.qcloud.core.auth;

import android.util.Base64;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionCredentialProvider extends ShortTimeCredentialProvider {
    private String appid;
    private String region;
    private String secretId;
    private String secretKey;
    private String userAgent;

    @Deprecated
    public SessionCredentialProvider(String secretId2, String secretKey2, String appid2, String region2, String userAgent2) {
        super(secretId2, secretKey2, 0);
        this.secretId = secretId2;
        this.secretKey = secretKey2;
        this.appid = appid2;
        this.userAgent = userAgent2;
        this.region = region2;
    }

    public SessionCredentialProvider(HttpRequest<String> httpRequest) {
        super(httpRequest);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qcloud.core.auth.ShortTimeCredentialProvider
    public QCloudLifecycleCredentials onGetCredentialFromLocal(String secretId2, String secretKey2) throws QCloudClientException {
        try {
            this.httpRequest = getRequestByKey();
            return parseCAMResponse((String) ((HttpResult) QCloudHttpClient.getDefault().resolveRequest(this.httpRequest).executeNow()).content());
        } catch (QCloudServiceException e) {
            throw new QCloudClientException("get session json fails", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.auth.ShortTimeCredentialProvider
    public QCloudLifecycleCredentials onRemoteCredentialReceived(String jsonContent) throws QCloudClientException {
        return parseCAMResponse(jsonContent);
    }

    private QCloudLifecycleCredentials parseCAMResponse(String jsonContent) throws QCloudClientException {
        if (jsonContent != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonContent);
                JSONObject data = jsonObject.optJSONObject("data");
                if (data == null) {
                    data = jsonObject;
                }
                JSONObject credentials = data.optJSONObject("credentials");
                long expiredTime = data.optLong("expiredTime");
                if (credentials != null) {
                    return new SessionQCloudCredentials(credentials.optString("tmpSecretId"), credentials.optString("tmpSecretKey"), credentials.optString("sessionToken"), expiredTime);
                }
            } catch (JSONException e) {
                throw new QCloudClientException("parse session json fails", e);
            }
        }
        return null;
    }

    private HttpRequest<String> getRequestByKey() {
        Map<String, String> params = new TreeMap<>();
        params.put("policy", String.format("{\"statement\": [{\"action\": [\"name/cos:*\"],\"effect\": \"allow\",\"resource\":[\"qcs::cos:%s:uid/%s:prefix//%s/*\"]}],\"version\": \"2.0\"}", this.region, this.appid, this.appid));
        params.put("name", "Rabbitliu");
        params.put("Action", "GetFederationToken");
        params.put("SecretId", this.secretId);
        params.put("Nonce", "" + new Random().nextInt(Integer.MAX_VALUE));
        params.put("Timestamp", "" + (System.currentTimeMillis() / 1000));
        params.put("RequestClient", this.userAgent);
        byte[] hmacSha1 = Utils.hmacSha1(makeSignPlainText(params, "GET", "sts.api.qcloud.com", "/v2/index.php"), this.secretKey);
        if (hmacSha1 != null) {
            params.put("Signature", Base64.encodeToString(hmacSha1, 0));
        }
        return new HttpRequest.Builder().scheme(HttpConstants.Scheme.HTTPS).host("sts.api.qcloud.com").path("/v2/index.php").method("GET").query(params).build();
    }

    private String makeSignPlainText(Map<String, String> requestParams, String requestMethod, String requestHost, String requestPath) {
        return ((("" + requestMethod) + requestHost) + requestPath) + buildParamStr(requestParams);
    }

    private String buildParamStr(Map<String, String> requestParams) {
        StringBuilder retStr = new StringBuilder();
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            if (retStr.length() == 0) {
                retStr.append('?');
            } else {
                retStr.append('&');
            }
            retStr.append(entry.getKey().replace("_", ".")).append('=').append(entry.getValue().toString());
        }
        return retStr.toString();
    }
}
