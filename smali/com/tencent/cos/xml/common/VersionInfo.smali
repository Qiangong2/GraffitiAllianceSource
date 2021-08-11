.class public Lcom/tencent/cos/xml/common/VersionInfo;
.super Ljava/lang/Object;
.source "VersionInfo.java"


# static fields
.field public static final platform:Ljava/lang/String; = "cos-android-sdk-5.4.5"

.field public static final version:I = 0xc4e5


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    const-string v0, "cos-android-sdk-5.4.5"

    return-object v0
.end method
