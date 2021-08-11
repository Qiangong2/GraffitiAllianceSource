.class public Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
.super Ljava/lang/Object;
.source "CompleteMultipartUpload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Part"
.end annotation


# instance fields
.field public eTag:Ljava/lang/String;

.field public partNumber:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
