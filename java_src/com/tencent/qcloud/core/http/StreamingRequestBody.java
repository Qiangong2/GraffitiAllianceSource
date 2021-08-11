package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* access modifiers changed from: package-private */
public class StreamingRequestBody extends RequestBody implements ProgressBody {
    private byte[] bytes;
    private String contentType;
    private CountingSink countingSink;
    private File file;
    private long length = 0;
    private long offset = 0;
    private QCloudProgressListener progressListener;
    private InputStream stream;

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public void setProgressListener(QCloudProgressListener progressListener2) {
        this.progressListener = progressListener2;
    }

    private StreamingRequestBody() {
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public long getBytesTransferred() {
        if (this.countingSink != null) {
            return this.countingSink.getTotalTransferred();
        }
        return 0;
    }

    static StreamingRequestBody file(File file2, String contentType2) {
        return file(file2, contentType2, 0, Long.MAX_VALUE);
    }

    static StreamingRequestBody file(File file2, String contentType2, long offset2, long length2) {
        StreamingRequestBody requestBody = new StreamingRequestBody();
        requestBody.file = file2;
        requestBody.contentType = contentType2;
        if (offset2 < 0) {
            offset2 = 0;
        }
        requestBody.offset = offset2;
        if (length2 < 1) {
            length2 = Long.MAX_VALUE;
        }
        requestBody.length = length2;
        return requestBody;
    }

    static StreamingRequestBody bytes(byte[] bytes2, String contentType2, long offset2, long length2) {
        StreamingRequestBody requestBody = new StreamingRequestBody();
        requestBody.bytes = bytes2;
        requestBody.contentType = contentType2;
        if (offset2 < 0) {
            offset2 = 0;
        }
        requestBody.offset = offset2;
        if (length2 < 1) {
            length2 = Long.MAX_VALUE;
        }
        requestBody.length = length2;
        return requestBody;
    }

    static StreamingRequestBody steam(InputStream inputStream, File tmpFile, String contentType2, long offset2, long length2) {
        StreamingRequestBody requestBody = new StreamingRequestBody();
        requestBody.stream = inputStream;
        requestBody.contentType = contentType2;
        requestBody.file = tmpFile;
        if (offset2 < 0) {
            offset2 = 0;
        }
        requestBody.offset = offset2;
        if (length2 < 1) {
            length2 = Long.MAX_VALUE;
        }
        requestBody.length = length2;
        return requestBody;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        if (this.contentType != null) {
            return MediaType.parse(this.contentType);
        }
        return null;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        if (this.stream != null) {
            return Math.min(((long) this.stream.available()) - this.offset, this.length);
        }
        if (this.file != null) {
            return Math.min(this.file.length() - this.offset, this.length);
        }
        return Math.min(((long) this.bytes.length) - this.offset, this.length);
    }

    private InputStream getStream() throws IOException {
        if (this.bytes != null) {
            return new ByteArrayInputStream(this.bytes);
        }
        if (this.stream == null) {
            return new FileInputStream(this.file);
        }
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(this.file);
            try {
                byte[] buffer = new byte[8192];
                while (true) {
                    int bytesRead = this.stream.read(buffer);
                    if (bytesRead != -1) {
                        fos2.write(buffer, 0, bytesRead);
                    } else {
                        fos2.flush();
                        FileInputStream fileInputStream = new FileInputStream(this.file);
                        Util.closeQuietly(fos2);
                        Util.closeQuietly(this.stream);
                        this.stream = null;
                        return fileInputStream;
                    }
                }
            } catch (Throwable th) {
                th = th;
                fos = fos2;
                Util.closeQuietly(fos);
                Util.closeQuietly(this.stream);
                this.stream = null;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            Util.closeQuietly(fos);
            Util.closeQuietly(this.stream);
            this.stream = null;
            throw th;
        }
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        InputStream inputStream = null;
        Source source = null;
        try {
            inputStream = getStream();
            if (this.offset > 0) {
                inputStream.skip(this.offset);
            }
            source = Okio.source(inputStream);
            long contentLength = contentLength();
            this.countingSink = new CountingSink(sink, contentLength, this.progressListener);
            BufferedSink bufferedSink = Okio.buffer(this.countingSink);
            bufferedSink.write(source, contentLength);
            bufferedSink.flush();
        } finally {
            Util.closeQuietly(inputStream);
            Util.closeQuietly(source);
            Util.closeQuietly(this.countingSink);
        }
    }
}
