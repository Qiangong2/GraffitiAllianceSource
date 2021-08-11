package com.tencent.apollo;

public class ApolloVoiceEngine {
    public static final native boolean GetHeadsetVoipState();

    public static final native int Pause();

    public static final native int Resume();

    public static final native int StartBlueTooth();

    public static final native int StopBlueTooth();

    static {
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("load library failed!!!");
        }
    }
}
