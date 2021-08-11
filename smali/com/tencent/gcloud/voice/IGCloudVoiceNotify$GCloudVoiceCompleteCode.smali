.class public final Lcom/tencent/gcloud/voice/IGCloudVoiceNotify$GCloudVoiceCompleteCode;
.super Ljava/lang/Object;
.source "IGCloudVoiceNotify.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/gcloud/voice/IGCloudVoiceNotify;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GCloudVoiceCompleteCode"
.end annotation


# static fields
.field public static final GV_ON_DOWNLOAD_RECORD_DONE:I = 0xd

.field public static final GV_ON_DOWNLOAD_RECORD_ERROR:I = 0xe

.field public static final GV_ON_JOINROOM_SUCC:I = 0x1

.field public static final GV_ON_JOINROOM_SVR_ERR:I = 0x3

.field public static final GV_ON_JOINROOM_TIMEOUT:I = 0x2

.field public static final GV_ON_JOINROOM_UNKNOWN:I = 0x4

.field public static final GV_ON_MESSAGE_KEY_APPLIED_SUCC:I = 0x7

.field public static final GV_ON_MESSAGE_KEY_APPLIED_SVR_ERR:I = 0x9

.field public static final GV_ON_MESSAGE_KEY_APPLIED_TIMEOUT:I = 0x8

.field public static final GV_ON_MESSAGE_KEY_APPLIED_UNKNOWN:I = 0xa

.field public static final GV_ON_NET_ERR:I = 0x5

.field public static final GV_ON_PLAYFILE_DONE:I = 0x15

.field public static final GV_ON_QUITROOM_SUCC:I = 0x6

.field public static final GV_ON_ROOM_OFFLINE:I = 0x16

.field public static final GV_ON_RSTT_APIERR:I = 0x14

.field public static final GV_ON_RSTT_SUCC:I = 0x12

.field public static final GV_ON_RSTT_TIMEOUT:I = 0x13

.field public static final GV_ON_STT_APIERR:I = 0x11

.field public static final GV_ON_STT_SUCC:I = 0xf

.field public static final GV_ON_STT_TIMEOUT:I = 0x10

.field public static final GV_ON_UNKNOWN:I = 0x17

.field public static final GV_ON_UPLOAD_RECORD_DONE:I = 0xb

.field public static final GV_ON_UPLOAD_RECORD_ERROR:I = 0xc


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
