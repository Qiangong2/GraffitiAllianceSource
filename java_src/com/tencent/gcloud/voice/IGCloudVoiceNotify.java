package com.tencent.gcloud.voice;

public interface IGCloudVoiceNotify {

    public static final class GCloudVoiceCompleteCode {
        public static final int GV_ON_DOWNLOAD_RECORD_DONE = 13;
        public static final int GV_ON_DOWNLOAD_RECORD_ERROR = 14;
        public static final int GV_ON_JOINROOM_SUCC = 1;
        public static final int GV_ON_JOINROOM_SVR_ERR = 3;
        public static final int GV_ON_JOINROOM_TIMEOUT = 2;
        public static final int GV_ON_JOINROOM_UNKNOWN = 4;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_SUCC = 7;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_SVR_ERR = 9;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_TIMEOUT = 8;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_UNKNOWN = 10;
        public static final int GV_ON_NET_ERR = 5;
        public static final int GV_ON_PLAYFILE_DONE = 21;
        public static final int GV_ON_QUITROOM_SUCC = 6;
        public static final int GV_ON_ROOM_OFFLINE = 22;
        public static final int GV_ON_RSTT_APIERR = 20;
        public static final int GV_ON_RSTT_SUCC = 18;
        public static final int GV_ON_RSTT_TIMEOUT = 19;
        public static final int GV_ON_STT_APIERR = 17;
        public static final int GV_ON_STT_SUCC = 15;
        public static final int GV_ON_STT_TIMEOUT = 16;
        public static final int GV_ON_UNKNOWN = 23;
        public static final int GV_ON_UPLOAD_RECORD_DONE = 11;
        public static final int GV_ON_UPLOAD_RECORD_ERROR = 12;
    }

    void OnApplyMessageKey(int i);

    void OnDownloadFile(int i, String str, String str2);

    void OnJoinRoom(int i, String str, int i2);

    void OnMemberVoice(int[] iArr, int i);

    void OnPlayRecordedFile(int i, String str);

    void OnQuitRoom(int i, String str);

    void OnRecording(char[] cArr, int i);

    void OnSpeechToText(int i, String str, String str2);

    void OnStatusUpdate(int i, String str, int i2);

    void OnStreamSpeechToText(int i, int i2, String str);

    void OnUploadFile(int i, String str, String str2);
}
