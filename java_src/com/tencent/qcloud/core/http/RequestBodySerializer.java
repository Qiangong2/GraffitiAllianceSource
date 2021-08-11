package com.tencent.qcloud.core.http;

import android.content.Context;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.ByteString;

public abstract class RequestBodySerializer {
    /* access modifiers changed from: package-private */
    public abstract RequestBody body();

    /* access modifiers changed from: private */
    public static final class BaseRequestBodyWrapper extends RequestBodySerializer {
        private final RequestBody body;

        public BaseRequestBodyWrapper(RequestBody body2) {
            this.body = body2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qcloud.core.http.RequestBodySerializer
        public RequestBody body() {
            return this.body;
        }
    }

    public static RequestBodySerializer string(String contentType, String content) {
        return new BaseRequestBodyWrapper(RequestBody.create(MediaType.parse(contentType), content));
    }

    public static RequestBodySerializer string(String contentType, ByteString content) {
        return new BaseRequestBodyWrapper(RequestBody.create(MediaType.parse(contentType), content));
    }

    public static RequestBodySerializer bytes(String contentType, byte[] content) {
        return bytes(contentType, content, 0, -1);
    }

    public static RequestBodySerializer bytes(String contentType, byte[] content, long offset, long byteCount) {
        return new BaseRequestBodyWrapper(StreamingRequestBody.bytes(content, contentType, offset, byteCount));
    }

    public static RequestBodySerializer file(String contentType, File file) {
        return file(contentType, file, 0, -1);
    }

    public static RequestBodySerializer file(String contentType, File file, long offset, long length) {
        return new BaseRequestBodyWrapper(StreamingRequestBody.file(file, contentType, offset, length));
    }

    public static RequestBodySerializer stream(String contentType, Context context, InputStream inputStream) {
        return stream(contentType, context, inputStream, 0, -1);
    }

    public static RequestBodySerializer stream(String contentType, Context context, InputStream inputStream, long offset, long length) {
        return stream(contentType, new File(context.getExternalCacheDir(), "inputStream_tmp"), inputStream, offset, length);
    }

    public static RequestBodySerializer stream(String contentType, File tmpFile, InputStream inputStream) {
        return stream(contentType, tmpFile, inputStream, 0, -1);
    }

    public static RequestBodySerializer stream(String contentType, File tmpFile, InputStream inputStream, long offset, long length) {
        return new BaseRequestBodyWrapper(StreamingRequestBody.steam(inputStream, tmpFile, contentType, offset, length));
    }

    public static RequestBodySerializer multipart(Map<String, String> keyValues, Map<String, String> uploadFiles) {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();
        bodyBuilder.setType(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA));
        for (Map.Entry<String, String> entry : keyValues.entrySet()) {
            bodyBuilder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : uploadFiles.entrySet()) {
            File file = new File(entry2.getKey());
            bodyBuilder.addFormDataPart(entry2.getValue(), file.getName(), StreamingRequestBody.file(file, MimeType.getTypeByFileName(file.getName())));
        }
        return new BaseRequestBodyWrapper(bodyBuilder.build());
    }
}
