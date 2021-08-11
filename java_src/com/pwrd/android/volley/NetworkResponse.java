package com.pwrd.android.volley;

import com.tencent.gcloud.voice.GCloudVoiceErrno;
import java.util.Collections;
import java.util.Map;

public class NetworkResponse {
    public final byte[] data;
    public final Map<String, String> headers;
    public final boolean notModified;
    public final int statusCode;

    public NetworkResponse(int statusCode2, byte[] data2, Map<String, String> headers2, boolean notModified2) {
        this.statusCode = statusCode2;
        this.data = data2;
        this.headers = headers2;
        this.notModified = notModified2;
    }

    public NetworkResponse(byte[] data2) {
        this(GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC, data2, Collections.emptyMap(), false);
    }

    public NetworkResponse(byte[] data2, Map<String, String> headers2) {
        this(GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC, data2, headers2, false);
    }
}
