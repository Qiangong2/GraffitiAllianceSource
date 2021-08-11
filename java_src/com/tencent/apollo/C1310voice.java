package com.tencent.apollo;

import android.util.Log;

/* renamed from: com.tencent.apollo.voice */
public class C1310voice {
    private static final String tag = "apolloVoiceAndroid";

    public static int CreateEngine() {
        Log.i(tag, "apolloVoice CreateEngine");
        return 11;
    }

    public static int DestoryEngine() {
        Log.i(tag, "apolloVoice DestoryEngine");
        return 0;
    }

    public static int JoinRoom(String str, String str2, String str3, long j, short s, String str4, int i) {
        Log.i(tag, "apolloVoice JoinRoom");
        return 0;
    }

    public static int QuitRoom(long j, short s, String str, int i) {
        Log.i(tag, "apolloVoice QuitRoom");
        return 0;
    }

    public static int OpenMic() {
        Log.i(tag, "apolloVoice OpenMic");
        return 0;
    }

    public static int CloseMic() {
        Log.i(tag, "apolloVoice CloseMic");
        return 0;
    }

    public static int OpenSpeaker() {
        Log.i(tag, "apolloVoice OpenSpeaker");
        return 0;
    }

    public static int ClosenSpeaker() {
        Log.i(tag, "apolloVoice ClosenSpeaker");
        return 0;
    }

    public static int Resume() {
        Log.i(tag, "apolloVoice Resume");
        return 0;
    }

    public static int Pause() {
        Log.i(tag, "apolloVoice Pause");
        return 0;
    }
}
