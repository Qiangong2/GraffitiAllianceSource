package com.tencent.gcloud.voice;

import android.app.Activity;
import android.content.Context;
import com.tencent.apollo.ApolloVoiceDeviceMgr;

public class GCloudVoiceEngine {
    private static GCloudVoiceEngine _instance;
    private GCloudVoiceEngineHelper JNIHelper = new GCloudVoiceEngineHelper();
    private Context appContext = null;
    private IGCloudVoiceNotify notify = null;

    public static final class Mode {
        public static final int HighQuality = 4;
        public static final int Messages = 1;
        public static final int RealTime = 0;
        public static final int Translation = 2;
    }

    static {
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("load library GCloudVoice failed!!!");
            System.exit(1);
        }
    }

    public class TaskID {

        /* renamed from: ID */
        public int f3127ID = -1;

        public TaskID() {
        }
    }

    public static synchronized GCloudVoiceEngine getInstance() {
        GCloudVoiceEngine gCloudVoiceEngine;
        synchronized (GCloudVoiceEngine.class) {
            if (_instance == null) {
                _instance = new GCloudVoiceEngine();
            }
            gCloudVoiceEngine = _instance;
        }
        return gCloudVoiceEngine;
    }

    private GCloudVoiceEngine() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        GCloudVoiceEngineHelper.EngineJniInstance();
    }

    public int init(Context context, Activity activity) {
        ApolloVoiceDeviceMgr.ApolloVoiceDeviceInit(context, activity);
        return 0;
    }

    public int SetServerInfo(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetServerInfo(str);
    }

    public int SetAppInfo(String str, String str2, String str3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetAppInfo(str, str2, str3);
    }

    public int Init() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.Init();
    }

    public int SetNotify(IGCloudVoiceNotify iGCloudVoiceNotify) {
        this.notify = iGCloudVoiceNotify;
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetNotify(iGCloudVoiceNotify);
    }

    public int SetMode(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetMode(i);
    }

    public int Poll() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.Poll();
    }

    public int Pause() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.Pause();
    }

    public int Resume() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.Resume();
    }

    public int JoinTeamRoom(String str, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.JoinTeamRoom(str, i);
    }

    public int JoinNationalRoom(String str, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.JoinNationalRoom(str, i, i2);
    }

    public int QuitRoom(String str, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.QuitRoom(str, i);
    }

    public int OpenMic() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.OpenMic();
    }

    public int CloseMic() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.CloseMic();
    }

    public int OpenSpeaker() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.OpenSpeaker();
    }

    public int CloseSpeaker() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.CloseSpeaker();
    }

    public int ApplyMessageKey(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.ApplyMessageKey(i);
    }

    public int SetMaxMessageLength(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetMaxMessageLength(i);
    }

    public int StartRecording(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.StartRecording(str);
    }

    public int StopRecording() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.StopRecording();
    }

    public int UploadRecordedFile(String str, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.UploadRecordedFile(str, i);
    }

    public int DownloadRecordedFile(String str, String str2, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.DownloadRecordedFile(str, str2, i);
    }

    public int PlayRecordedFile(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.PlayRecordedFile(str);
    }

    public int StopPlayFile() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.StopPlayFile();
    }

    public int SpeechToText(String str, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SpeechToText(str, i, i2);
    }

    public int JoinTeamRoom_Token(String str, String str2, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.JoinTeamRoom(str, str2, i, i2);
    }

    public int JoinNationalRoom_Token(String str, int i, String str2, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.JoinNationalRoom(str, i, str2, i2, i3);
    }

    public int ApplyMessageKey_Token(String str, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.ApplyMessageKey(str, i, i2);
    }

    public int SpeechToText_Token(String str, String str2, int i, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SpeechToText(str, str2, i, i2, i3);
    }

    public int ForbidMemberVoice(int i, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.ForbidMemberVoice(i, z);
    }

    public int EnableLog(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.EnableLog(z);
    }

    public int GetMicLevel() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.GetMicLevel();
    }

    public int GetSpeakerLevel() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.GetSpeakerLevel();
    }

    public int SetSpeakerVolume(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.SetSpeakerVolume(i);
    }

    public int TestMic() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.TestMic();
    }

    public int GetFileParam(String str, Integer num, Float f) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.GetFileParam(str, num, f);
    }

    public int CaptureMicrophoneData(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.CaptureMicrophoneData(z);
    }

    public int Invoke(int i, int i2, int i3, int[] iArr) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.Invoke(i, i2, i3, iArr);
    }

    public int EnableSpeakerOn(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = this.JNIHelper;
        return GCloudVoiceEngineHelper.EnableSpeakerOn(z);
    }
}
