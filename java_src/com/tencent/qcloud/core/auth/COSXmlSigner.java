package com.tencent.qcloud.core.auth;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.QCloudHttpRequest;

public class COSXmlSigner implements QCloudSigner {
    private static final String COS_SESSION_TOKEN = "x-cos-security-token";

    @Override // com.tencent.qcloud.core.auth.QCloudSigner
    public void sign(QCloudHttpRequest request, QCloudCredentials credentials) throws QCloudClientException {
        COSXmlSignSourceProvider sourceProvider = (COSXmlSignSourceProvider) request.getSignProvider();
        if (sourceProvider == null) {
            throw new QCloudClientException("no sign provider for cos xml signer");
        }
        StringBuilder authorization = new StringBuilder();
        QCloudLifecycleCredentials lifecycleCredentials = (QCloudLifecycleCredentials) credentials;
        authorization.append(AuthConstants.Q_SIGN_ALGORITHM).append(SimpleComparison.EQUAL_TO_OPERATION).append(AuthConstants.SHA1).append("&").append(AuthConstants.Q_AK).append(SimpleComparison.EQUAL_TO_OPERATION).append(credentials.getSecretId()).append("&").append(AuthConstants.Q_SIGN_TIME).append(SimpleComparison.EQUAL_TO_OPERATION).append(sourceProvider.getSignTime()).append("&").append(AuthConstants.Q_KEY_TIME).append(SimpleComparison.EQUAL_TO_OPERATION).append(lifecycleCredentials.getKeyTime()).append("&").append(AuthConstants.Q_HEADER_LIST).append(SimpleComparison.EQUAL_TO_OPERATION).append(sourceProvider.getRealHeaderList().toLowerCase()).append("&").append(AuthConstants.Q_URL_PARAM_LIST).append(SimpleComparison.EQUAL_TO_OPERATION).append(sourceProvider.getRealParameterList().toLowerCase()).append("&").append(AuthConstants.Q_SIGNATURE).append(SimpleComparison.EQUAL_TO_OPERATION).append(signature(sourceProvider.source(request), lifecycleCredentials.getSignKey()));
        request.addHeader(HttpConstants.Header.AUTHORIZATION, authorization.toString());
        if (credentials instanceof SessionQCloudCredentials) {
            request.addHeader(COS_SESSION_TOKEN, ((SessionQCloudCredentials) credentials).getToken());
        }
    }

    private String signature(String source, String signKey) throws QCloudClientException {
        byte[] sha1Bytes = Utils.hmacSha1(source, signKey);
        if (sha1Bytes != null) {
            return new String(Utils.encodeHex(sha1Bytes));
        }
        return "";
    }
}
