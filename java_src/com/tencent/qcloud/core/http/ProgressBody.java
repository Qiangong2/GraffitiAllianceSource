package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;

/* access modifiers changed from: package-private */
public interface ProgressBody {
    long getBytesTransferred();

    void setProgressListener(QCloudProgressListener qCloudProgressListener);
}
