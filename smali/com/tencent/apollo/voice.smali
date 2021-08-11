.class public Lcom/tencent/apollo/voice;
.super Ljava/lang/Object;
.source "voice.java"


# static fields
.field private static final tag:Ljava/lang/String; = "apolloVoiceAndroid"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static CloseMic()I
    .locals 2

    .prologue
    .line 42
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice CloseMic"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 43
    const/4 v0, 0x0

    return v0
.end method

.method public static ClosenSpeaker()I
    .locals 2

    .prologue
    .line 54
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice ClosenSpeaker"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    const/4 v0, 0x0

    return v0
.end method

.method public static CreateEngine()I
    .locals 2

    .prologue
    .line 12
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice CreateEngine"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 13
    const/16 v0, 0xb

    return v0
.end method

.method public static DestoryEngine()I
    .locals 2

    .prologue
    .line 18
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice DestoryEngine"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 19
    const/4 v0, 0x0

    return v0
.end method

.method public static JoinRoom(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JSLjava/lang/String;I)I
    .locals 2

    .prologue
    .line 24
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice JoinRoom"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 25
    const/4 v0, 0x0

    return v0
.end method

.method public static OpenMic()I
    .locals 2

    .prologue
    .line 36
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice OpenMic"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 37
    const/4 v0, 0x0

    return v0
.end method

.method public static OpenSpeaker()I
    .locals 2

    .prologue
    .line 48
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice OpenSpeaker"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public static Pause()I
    .locals 2

    .prologue
    .line 66
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice Pause"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 67
    const/4 v0, 0x0

    return v0
.end method

.method public static QuitRoom(JSLjava/lang/String;I)I
    .locals 2

    .prologue
    .line 30
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice QuitRoom"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 31
    const/4 v0, 0x0

    return v0
.end method

.method public static Resume()I
    .locals 2

    .prologue
    .line 60
    const-string v0, "apolloVoiceAndroid"

    const-string v1, "apolloVoice Resume"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    const/4 v0, 0x0

    return v0
.end method
