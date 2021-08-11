.class public Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;
.super Ljava/lang/Object;
.source "UploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/transfer/UploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResumeData"
.end annotation


# instance fields
.field public bucket:Ljava/lang/String;

.field public cosPath:Ljava/lang/String;

.field public sliceSize:J

.field public srcPath:Ljava/lang/String;

.field public uploadId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 468
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
