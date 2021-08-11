.class public interface abstract Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;
.super Ljava/lang/Object;
.source "IGCloudVoiceNotify.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/gcloud/voice/IGCloudVoiceNotify$GCloudVoiceCompleteCode;
    }
.end annotation


# virtual methods
.method public abstract OnApplyMessageKey(I)V
.end method

.method public abstract OnDownloadFile(ILjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract OnJoinRoom(ILjava/lang/String;I)V
.end method

.method public abstract OnMemberVoice([II)V
.end method

.method public abstract OnPlayRecordedFile(ILjava/lang/String;)V
.end method

.method public abstract OnQuitRoom(ILjava/lang/String;)V
.end method

.method public abstract OnRecording([CI)V
.end method

.method public abstract OnSpeechToText(ILjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract OnStatusUpdate(ILjava/lang/String;I)V
.end method

.method public abstract OnStreamSpeechToText(IILjava/lang/String;)V
.end method

.method public abstract OnUploadFile(ILjava/lang/String;Ljava/lang/String;)V
.end method
