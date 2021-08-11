package com.tencent.qcloud.core.auth;

import android.text.TextUtils;
import com.tencent.qcloud.core.common.QCloudClientException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BasicLifecycleCredentialProvider implements QCloudCredentialProvider {
    private QCloudLifecycleCredentials credentials;
    private ReentrantLock lock = new ReentrantLock();

    /* access modifiers changed from: protected */
    public abstract QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException;

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public final QCloudCredentials getCredentials() throws QCloudClientException {
        if (needUpdateSignaturePair()) {
            refresh();
        }
        return this.credentials;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public final void refresh() throws QCloudClientException {
        try {
            if (!this.lock.tryLock(20, TimeUnit.SECONDS)) {
                throw new QCloudClientException("lock timeout, no credential for sign");
            }
            this.credentials = fetchNewCredentials();
            this.lock.unlock();
        } catch (InterruptedException e) {
            throw new QCloudClientException("interrupt when try to get credential", e);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    private boolean needUpdateSignaturePair() {
        if (this.credentials == null) {
            return true;
        }
        String keyTime = this.credentials.getKeyTime();
        if (TextUtils.isEmpty(keyTime)) {
            return true;
        }
        String[] times = keyTime.split(";");
        if (times.length != 2) {
            return true;
        }
        if (System.currentTimeMillis() / 1000 <= Long.valueOf(times[1]).longValue() - 60) {
            return false;
        }
        return true;
    }
}
