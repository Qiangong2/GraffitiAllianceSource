.class public Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;
.super Ljava/lang/Object;
.source "PutBucketReplicationRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RuleStruct"
.end annotation


# instance fields
.field public appid:Ljava/lang/String;

.field public bucket:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public isEnable:Z

.field public prefix:Ljava/lang/String;

.field public region:Ljava/lang/String;

.field public storageClass:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
