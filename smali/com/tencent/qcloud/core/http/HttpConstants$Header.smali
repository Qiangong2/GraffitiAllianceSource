.class public final Lcom/tencent/qcloud/core/http/HttpConstants$Header;
.super Ljava/lang/Object;
.source "HttpConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/HttpConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Header"
.end annotation


# static fields
.field public static final AUTHORIZATION:Ljava/lang/String; = "Authorization"

.field public static final CONNECTION:Ljava/lang/String; = "Connection"

.field public static final CONTENT_LENGTH:Ljava/lang/String; = "Content-Length"

.field public static final CONTENT_RANGE:Ljava/lang/String; = "Content-Range"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "Content-Type"

.field public static final DATE:Ljava/lang/String; = "Date"

.field public static final EXPECT:Ljava/lang/String; = "Expect"

.field public static final HOST:Ljava/lang/String; = "Host"

.field public static final MD5:Ljava/lang/String; = "Content-MD5"

.field public static final RANGE:Ljava/lang/String; = "Range"

.field public static final TRANSFER_ENCODING:Ljava/lang/String; = "Transfer-Encoding"

.field public static final USER_AGENT:Ljava/lang/String; = "User-Agent"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
