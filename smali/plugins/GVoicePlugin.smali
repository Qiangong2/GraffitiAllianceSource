.class public Lplugins/GVoicePlugin;
.super Ljava/lang/Object;
.source "GVoicePlugin.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public VoiceInit(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 15
    invoke-static {}, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->getInstance()Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/tencent/gcloud/voice/GCloudVoiceEngine;->init(Landroid/content/Context;Landroid/app/Activity;)I

    .line 16
    return-void
.end method
