.class public Lcom/tencent/gcloud/voice/GCloudVoiceEngine;
.super Ljava/lang/Object;
.source "GCloudVoiceEngine.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/gcloud/voice/GCloudVoiceEngine$Mode;,
        Lcom/tencent/gcloud/voice/GCloudVoiceEngine$TaskID;
    }
.end annotation


# static fields
.field private static _instance:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;


# instance fields
.field private JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

.field private appContext:Landroid/content/Context;

.field private notify:Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    :try_start_0
    const-string v0, "GCloudVoice"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 19
    :goto_0
    return-void

    .line 13
    :catch_0
    move-exception v0

    .line 15
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v1, "load library GCloudVoice failed!!!"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 16
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    goto :goto_0
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->notify:Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;

    .line 38
    iput-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->appContext:Landroid/content/Context;

    .line 48
    new-instance v0, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-direct {v0}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;-><init>()V

    iput-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    .line 49
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->EngineJniInstance()I

    .line 50
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/tencent/gcloud/voice/GCloudVoiceEngine;
    .locals 2

    .prologue
    .line 42
    const-class v1, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->_instance:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    if-nez v0, :cond_0

    .line 43
    new-instance v0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    invoke-direct {v0}, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;-><init>()V

    sput-object v0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->_instance:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    .line 45
    :cond_0
    sget-object v0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->_instance:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 42
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public ApplyMessageKey(I)I
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->ApplyMessageKey(I)I

    move-result v0

    return v0
.end method

.method public ApplyMessageKey_Token(Ljava/lang/String;II)I
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->ApplyMessageKey(Ljava/lang/String;II)I

    move-result v0

    return v0
.end method

.method public CaptureMicrophoneData(Z)I
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->CaptureMicrophoneData(Z)I

    move-result v0

    return v0
.end method

.method public CloseMic()I
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->CloseMic()I

    move-result v0

    return v0
.end method

.method public CloseSpeaker()I
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->CloseSpeaker()I

    move-result v0

    return v0
.end method

.method public DownloadRecordedFile(Ljava/lang/String;Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->DownloadRecordedFile(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public EnableLog(Z)I
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->EnableLog(Z)I

    move-result v0

    return v0
.end method

.method public EnableSpeakerOn(Z)I
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->EnableSpeakerOn(Z)I

    move-result v0

    return v0
.end method

.method public ForbidMemberVoice(IZ)I
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->ForbidMemberVoice(IZ)I

    move-result v0

    return v0
.end method

.method public GetFileParam(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;)I
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->GetFileParam(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;)I

    move-result v0

    return v0
.end method

.method public GetMicLevel()I
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->GetMicLevel()I

    move-result v0

    return v0
.end method

.method public GetSpeakerLevel()I
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->GetSpeakerLevel()I

    move-result v0

    return v0
.end method

.method public Init()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->Init()I

    move-result v0

    return v0
.end method

.method public Invoke(III[I)I
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3, p4}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->Invoke(III[I)I

    move-result v0

    return v0
.end method

.method public JoinNationalRoom(Ljava/lang/String;II)I
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->JoinNationalRoom(Ljava/lang/String;II)I

    move-result v0

    return v0
.end method

.method public JoinNationalRoom_Token(Ljava/lang/String;ILjava/lang/String;II)I
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3, p4, p5}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->JoinNationalRoom(Ljava/lang/String;ILjava/lang/String;II)I

    move-result v0

    return v0
.end method

.method public JoinTeamRoom(Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->JoinTeamRoom(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public JoinTeamRoom_Token(Ljava/lang/String;Ljava/lang/String;II)I
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3, p4}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->JoinTeamRoom(Ljava/lang/String;Ljava/lang/String;II)I

    move-result v0

    return v0
.end method

.method public OpenMic()I
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->OpenMic()I

    move-result v0

    return v0
.end method

.method public OpenSpeaker()I
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->OpenSpeaker()I

    move-result v0

    return v0
.end method

.method public Pause()I
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->Pause()I

    move-result v0

    return v0
.end method

.method public PlayRecordedFile(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->PlayRecordedFile(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public Poll()I
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->Poll()I

    move-result v0

    return v0
.end method

.method public QuitRoom(Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->QuitRoom(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public Resume()I
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->Resume()I

    move-result v0

    return v0
.end method

.method public SetAppInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetAppInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public SetMaxMessageLength(I)I
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetMaxMessageLength(I)I

    move-result v0

    return v0
.end method

.method public SetMode(I)I
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetMode(I)I

    move-result v0

    return v0
.end method

.method public SetNotify(Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;)I
    .locals 1

    .prologue
    .line 76
    iput-object p1, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->notify:Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;

    .line 77
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetNotify(Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;)I

    move-result v0

    return v0
.end method

.method public SetServerInfo(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetServerInfo(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public SetSpeakerVolume(I)I
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SetSpeakerVolume(I)I

    move-result v0

    return v0
.end method

.method public SpeechToText(Ljava/lang/String;II)I
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SpeechToText(Ljava/lang/String;II)I

    move-result v0

    return v0
.end method

.method public SpeechToText_Token(Ljava/lang/String;Ljava/lang/String;III)I
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2, p3, p4, p5}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->SpeechToText(Ljava/lang/String;Ljava/lang/String;III)I

    move-result v0

    return v0
.end method

.method public StartRecording(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->StartRecording(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public StopPlayFile()I
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->StopPlayFile()I

    move-result v0

    return v0
.end method

.method public StopRecording()I
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->StopRecording()I

    move-result v0

    return v0
.end method

.method public TestMic()I
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->TestMic()I

    move-result v0

    return v0
.end method

.method public UploadRecordedFile(Ljava/lang/String;I)I
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->JNIHelper:Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;

    invoke-static {p1, p2}, Lcom/tencent/gcloud/voice/GCloudVoiceEngineHelper;->UploadRecordedFile(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public init(Landroid/content/Context;Landroid/app/Activity;)I
    .locals 1

    .prologue
    .line 54
    invoke-static {p1, p2}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->ApolloVoiceDeviceInit(Landroid/content/Context;Landroid/app/Activity;)V

    .line 55
    const/4 v0, 0x0

    return v0
.end method
