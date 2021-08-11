package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import java.io.IOException;

public abstract class ResponseBodyConverter<T> {
    /* access modifiers changed from: protected */
    public abstract T convert(HttpResponse<T> httpResponse) throws QCloudClientException, QCloudServiceException;

    private static final class StringConverter extends ResponseBodyConverter<String> {
        private StringConverter() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
        public String convert(HttpResponse<String> response) throws QCloudClientException, QCloudServiceException {
            try {
                return response.string();
            } catch (IOException e) {
                throw new QCloudClientException(e);
            }
        }
    }

    public static ResponseBodyConverter<Void> file(String filePath) {
        return file(filePath, -1);
    }

    public static ResponseBodyConverter<Void> file(String filePath, long offset) {
        return new ResponseFileConverter(filePath, offset);
    }

    public static ResponseBodyConverter<String> string() {
        return new StringConverter();
    }
}
