package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.auth.SignerFactory;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.net.URL;

public final class QCloudHttpRequest<T> extends HttpRequest<T> {
    private final QCloudSignSourceProvider signProvider;
    private final String signerType;

    public QCloudHttpRequest(Builder<T> builder) {
        super(builder);
        this.signerType = ((Builder) builder).signerType;
        this.signProvider = ((Builder) builder).signProvider;
    }

    @Override // com.tencent.qcloud.core.http.HttpRequest
    public QCloudSignSourceProvider getSignProvider() {
        if (shouldCalculateAuth()) {
            return this.signProvider;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qcloud.core.http.HttpRequest
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        QCloudSigner signer = null;
        if (this.signerType == null || !shouldCalculateAuth() || (signer = SignerFactory.getSigner(this.signerType)) != null) {
            return signer;
        }
        throw new QCloudClientException("can't get signer for type : " + this.signerType);
    }

    private boolean shouldCalculateAuth() {
        return QCloudStringUtils.isEmpty(header(HttpConstants.Header.AUTHORIZATION));
    }

    public static class Builder<T> extends HttpRequest.Builder<T> {
        private QCloudSignSourceProvider signProvider;
        private String signerType;

        public Builder<T> signer(String signerType2, QCloudSignSourceProvider signProvider2) {
            this.signerType = signerType2;
            this.signProvider = signProvider2;
            return this;
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> url(URL url) {
            return (Builder) super.url(url);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> scheme(String scheme) {
            return (Builder) super.scheme(scheme);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> path(String path) {
            return (Builder) super.path(path);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> host(String host) {
            return (Builder) super.host(host);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> method(String method) {
            return (Builder) super.method(method);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> query(String key, String value) {
            return (Builder) super.query(key, value);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> contentMD5() {
            return (Builder) super.contentMD5();
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> addHeader(String name, String value) {
            return (Builder) super.addHeader(name, value);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> removeHeader(String name) {
            return (Builder) super.removeHeader(name);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> userAgent(String userAgent) {
            return (Builder) super.userAgent(userAgent);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> setUseCache(boolean cacheEnabled) {
            return (Builder) super.setUseCache(cacheEnabled);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> body(RequestBodySerializer bodySerializer) {
            return (Builder) super.body(bodySerializer);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> tag(Object tag) {
            return (Builder) super.tag(tag);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter) {
            return (Builder) super.converter((ResponseBodyConverter) responseBodyConverter);
        }

        @Override // com.tencent.qcloud.core.http.HttpRequest.Builder
        public QCloudHttpRequest<T> build() {
            prepareBuild();
            return new QCloudHttpRequest<>(this);
        }
    }
}
