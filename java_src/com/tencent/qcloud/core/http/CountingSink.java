package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* access modifiers changed from: package-private */
public class CountingSink extends ForwardingSink {
    private long bytesTotal = 0;
    private long bytesWritten = 0;
    private QCloudProgressListener progressListener;
    private long recentReportBytes = 0;

    public CountingSink(Sink delegate, long bytesTotal2, QCloudProgressListener progressListener2) {
        super(delegate);
        this.bytesTotal = bytesTotal2;
        this.progressListener = progressListener2;
    }

    private void reportProgress() {
        if (this.progressListener != null) {
            long delta = this.bytesWritten - this.recentReportBytes;
            if (delta > 51200 || 10 * delta > this.bytesTotal || this.bytesWritten == this.bytesTotal) {
                this.recentReportBytes = this.bytesWritten;
                this.progressListener.onProgress(this.bytesWritten, this.bytesTotal);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeBytesInternal(long byteCount) {
        this.bytesWritten += byteCount;
        reportProgress();
    }

    /* access modifiers changed from: package-private */
    public long getTotalTransferred() {
        return this.bytesWritten;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long byteCount) throws IOException {
        super.write(source, byteCount);
        writeBytesInternal(byteCount);
    }
}
