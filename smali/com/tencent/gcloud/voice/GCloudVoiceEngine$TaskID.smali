.class public Lcom/tencent/gcloud/voice/GCloudVoiceEngine$TaskID;
.super Ljava/lang/Object;
.source "GCloudVoiceEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/gcloud/voice/GCloudVoiceEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TaskID"
.end annotation


# instance fields
.field public ID:I

.field final synthetic this$0:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;


# direct methods
.method public constructor <init>(Lcom/tencent/gcloud/voice/GCloudVoiceEngine;)V
    .locals 1

    .prologue
    .line 23
    iput-object p1, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine$TaskID;->this$0:Lcom/tencent/gcloud/voice/GCloudVoiceEngine;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, -0x1

    iput v0, p0, Lcom/tencent/gcloud/voice/GCloudVoiceEngine$TaskID;->ID:I

    .line 25
    return-void
.end method
