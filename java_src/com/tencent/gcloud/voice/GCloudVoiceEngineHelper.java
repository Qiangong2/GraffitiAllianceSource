package com.tencent.gcloud.voice;

public class GCloudVoiceEngineHelper {
    public static native int ApplyMessageKey(int i);

    public static native int ApplyMessageKey(String str, int i, int i2);

    public static native int CaptureMicrophoneData(boolean z);

    public static native int CloseMic();

    public static native int CloseSpeaker();

    public static native int DownloadRecordedFile(String str, String str2, int i);

    public static native int EnableLog(boolean z);

    public static native int EnableSpeakerOn(boolean z);

    public static native int EngineJniInstance();

    public static native int ForbidMemberVoice(int i, boolean z);

    public static native int GetFileParam(String str, Integer num, Float f);

    public static native int GetMicLevel();

    public static native int GetSpeakerLevel();

    public static native int Init();

    public static native int Invoke(int i, int i2, int i3, int[] iArr);

    public static native int JoinNationalRoom(String str, int i, int i2);

    public static native int JoinNationalRoom(String str, int i, String str2, int i2, int i3);

    public static native int JoinTeamRoom(String str, int i);

    public static native int JoinTeamRoom(String str, String str2, int i, int i2);

    public static native int OpenMic();

    public static native int OpenSpeaker();

    public static native int Pause();

    public static native int PlayRecordedFile(String str);

    public static native int Poll();

    public static native int QuitRoom(String str, int i);

    public static native int Resume();

    public static native int SetAppInfo(String str, String str2, String str3);

    public static native int SetMaxMessageLength(int i);

    public static native int SetMode(int i);

    public static native int SetNotify(IGCloudVoiceNotify iGCloudVoiceNotify);

    public static native int SetServerInfo(String str);

    public static native int SetSpeakerVolume(int i);

    public static native int SpeechToText(String str, int i, int i2);

    public static native int SpeechToText(String str, String str2, int i, int i2, int i3);

    public static native int StartRecording(String str);

    public static native int StopPlayFile();

    public static native int StopRecording();

    public static native int TestMic();

    public static native int UploadRecordedFile(String str, int i);
}
