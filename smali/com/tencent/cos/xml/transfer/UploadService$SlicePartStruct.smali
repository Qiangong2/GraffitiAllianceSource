.class Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
.super Ljava/lang/Object;
.source "UploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/transfer/UploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SlicePartStruct"
.end annotation


# instance fields
.field public eTag:Ljava/lang/String;

.field public isAlreadyUpload:Z

.field public offset:J

.field public partNumber:I

.field public sliceSize:J


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 476
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/tencent/cos/xml/transfer/UploadService$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService$1;

    .prologue
    .line 476
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;-><init>()V

    return-void
.end method
