package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CosError;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

public class ResponseXmlS3BodySerializer<T> extends ResponseBodyConverter<T> {
    private CosXmlResult cosXmlResult;

    public ResponseXmlS3BodySerializer(CosXmlResult cosXmlResult2) {
        this.cosXmlResult = cosXmlResult2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
    public T convert(HttpResponse response) throws QCloudClientException, QCloudServiceException {
        parseCOSXMLError(response);
        this.cosXmlResult.parseResponseBody(response);
        return (T) this.cosXmlResult;
    }

    private void parseCOSXMLError(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        int httpCode = response.code();
        if (httpCode < 200 || httpCode >= 300) {
            CosXmlServiceException cosXmlServiceException = new CosXmlServiceException(response.message());
            cosXmlServiceException.setStatusCode(httpCode);
            cosXmlServiceException.setRequestId(response.header("x-cos-request-id"));
            InputStream inputStream = response.byteStream();
            if (inputStream != null) {
                CosError cosError = new CosError();
                try {
                    XmlSlimParser.parseError(inputStream, cosError);
                    cosXmlServiceException.setErrorCode(cosError.code);
                    cosXmlServiceException.setErrorMessage(cosError.message);
                    cosXmlServiceException.setRequestId(cosError.requestId);
                    cosXmlServiceException.setServiceName(cosError.resource);
                } catch (XmlPullParserException e) {
                    throw new CosXmlClientException(e);
                } catch (IOException e2) {
                    throw new CosXmlClientException(e2);
                }
            }
            throw cosXmlServiceException;
        }
    }
}
