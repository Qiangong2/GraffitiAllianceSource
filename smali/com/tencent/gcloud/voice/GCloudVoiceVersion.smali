.class public Lcom/tencent/gcloud/voice/GCloudVoiceVersion;
.super Ljava/lang/Object;
.source "GCloudVoiceVersion.java"


# static fields
.field public static final Fix:I = 0x1

.field public static final Major:I = 0x1

.field public static final Minor:I = 0x1

.field public static final SVN:I = 0x1


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method version()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    const-string v0, "1.1.1.SVN"

    return-object v0
.end method
