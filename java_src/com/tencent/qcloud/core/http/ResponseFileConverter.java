package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;

public class ResponseFileConverter<T> extends ResponseBodyConverter<T> implements ProgressBody {
    private CountingSink countingSink;
    private String filePath;
    private long offset;
    private QCloudProgressListener progressListener;

    public ResponseFileConverter(String filePath2, long offset2) {
        this.filePath = filePath2;
        this.offset = offset2;
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public void setProgressListener(QCloudProgressListener progressListener2) {
        this.progressListener = progressListener2;
    }

    @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
    public T convert(HttpResponse<T> response) throws QCloudClientException, QCloudServiceException {
        long contentLength;
        HttpResponse.checkResponseSuccessful(response);
        long[] contentRange = QCloudHttpUtils.parseContentRange(response.header(HttpConstants.Header.CONTENT_RANGE));
        if (contentRange != null) {
            contentLength = (contentRange[1] - contentRange[0]) + 1;
        } else {
            contentLength = response.contentLength();
        }
        File downloadFilePath = new File(this.filePath);
        File parentDir = downloadFilePath.getParentFile();
        if (parentDir == null || parentDir.exists() || parentDir.mkdirs()) {
            BufferedSink sink = null;
            try {
                if (this.offset <= 0) {
                    this.countingSink = new CountingSink(Okio.sink(downloadFilePath), contentLength, this.progressListener);
                    sink = Okio.buffer(this.countingSink);
                    sink.write(response.response.body().source(), contentLength);
                    sink.flush();
                } else {
                    writeRandomAccessFile(downloadFilePath, response.byteStream(), contentLength);
                }
                Util.closeQuietly(sink);
                return null;
            } catch (IOException e) {
                throw new QCloudClientException("write local file error for " + e.toString(), e);
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) null);
                throw th;
            }
        } else {
            throw new QCloudClientException("local file directory can not create.");
        }
    }

    private void writeRandomAccessFile(File downloadFilePath, InputStream inputStream, long contentLength) throws IOException, QCloudClientException {
        if (inputStream == null) {
            throw new QCloudClientException("response body stream is null");
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(downloadFilePath, "rws");
            try {
                randomAccessFile2.seek(this.offset);
                byte[] buffer = new byte[8192];
                this.countingSink = new CountingSink(new Buffer(), contentLength, this.progressListener);
                while (true) {
                    int len = inputStream.read(buffer);
                    if (len != -1) {
                        randomAccessFile2.write(buffer, 0, len);
                        this.countingSink.writeBytesInternal((long) len);
                    } else {
                        Util.closeQuietly(inputStream);
                        Util.closeQuietly(randomAccessFile2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                Util.closeQuietly(inputStream);
                Util.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            Util.closeQuietly(inputStream);
            Util.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public long getBytesTransferred() {
        if (this.countingSink != null) {
            return this.countingSink.getTotalTransferred();
        }
        return 0;
    }
}
