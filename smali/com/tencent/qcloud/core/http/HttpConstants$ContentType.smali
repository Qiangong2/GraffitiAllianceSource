.class public final Lcom/tencent/qcloud/core/http/HttpConstants$ContentType;
.super Ljava/lang/Object;
.source "HttpConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/HttpConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ContentType"
.end annotation


# static fields
.field public static final JSON:Ljava/lang/String; = "application/json"

.field public static final MULTIPART_FORM_DATA:Ljava/lang/String; = "multipart/form-data"

.field public static final TEXT_PLAIN:Ljava/lang/String; = "text/plain"

.field public static final XML:Ljava/lang/String; = "application/xml"

.field public static final X_WWW_FORM_URLENCODED:Ljava/lang/String; = "application/x-www-form-urlencoded"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
