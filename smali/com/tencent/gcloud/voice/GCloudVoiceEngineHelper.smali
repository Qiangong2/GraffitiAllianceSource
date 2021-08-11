.class public Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;
.super Ljava/lang/Object;
.source "GCloudVoiceEngineHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static native ApplyMessageKey(I)I
.end method

.method public static native ApplyMessageKey(Ljava/lang/String;II)I
.end method

.method public static native CaptureMicrophoneData(Z)I
.end method

.method public static native CloseMic()I
.end method

.method public static native CloseSpeaker()I
.end method

.method public static native DownloadRecordedFile(Ljava/lang/String;Ljava/lang/String;I)I
.end method

.method public static native EnableLog(Z)I
.end method

.method public static native EnableSpeakerOn(Z)I
.end method

.method public static native EngineJniInstance()I
.end method

.method public static native ForbidMemberVoice(IZ)I
.end method

.method public static native GetFileParam(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;)I
.end method

.method public static native GetMicLevel()I
.end method

.method public static native GetSpeakerLevel()I
.end method

.method public static native Init()I
.end method

.method public static native Invoke(III[I)I
.end method

.method public static native JoinNationalRoom(Ljava/lang/String;II)I
.end method

.method public static native JoinNationalRoom(Ljava/lang/String;ILjava/lang/String;II)I
.end method

.method public static native JoinTeamRoom(Ljava/lang/String;I)I
.end method

.method public static native JoinTeamRoom(Ljava/lang/String;Ljava/lang/String;II)I
.end method

.method public static native OpenMic()I
.end method

.method public static native OpenSpeaker()I
.end method

.method public static native Pause()I
.end method

.method public static native PlayRecordedFile(Ljava/lang/String;)I
.end method

.method public static native Poll()I
.end method

.method public static native QuitRoom(Ljava/lang/String;I)I
.end method

.method public static native Resume()I
.end method

.method public static native SetAppInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
.end method

.method public static native SetMaxMessageLength(I)I
.end method

.method public static native SetMode(I)I
.end method

.method public static native SetNotify(Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;)I
.end method

.method public static native SetServerInfo(Ljava/lang/String;)I
.end method

.method public static native SetSpeakerVolume(I)I
.end method

.method public static native SpeechToText(Ljava/lang/String;II)I
.end method

.method public static native SpeechToText(Ljava/lang/String;Ljava/lang/String;III)I
.end method

.method public static native StartRecording(Ljava/lang/String;)I
.end method

.method public static native StopPlayFile()I
.end method

.method public static native StopRecording()I
.end method

.method public static native TestMic()I
.end method

.method public static native UploadRecordedFile(Ljava/lang/String;I)I
.end method
