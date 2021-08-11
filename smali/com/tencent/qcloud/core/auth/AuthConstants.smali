.class public Lcom/tencent/qcloud/core/auth/AuthConstants;
.super Ljava/lang/Object;
.source "AuthConstants.java"


# static fields
.field public static Q_AK:Ljava/lang/String;

.field public static Q_HEADER_LIST:Ljava/lang/String;

.field public static Q_KEY_TIME:Ljava/lang/String;

.field public static Q_SIGNATURE:Ljava/lang/String;

.field public static Q_SIGN_ALGORITHM:Ljava/lang/String;

.field public static Q_SIGN_TIME:Ljava/lang/String;

.field public static Q_URL_PARAM_LIST:Ljava/lang/String;

.field public static SHA1:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-string v0, "q-sign-algorithm"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGN_ALGORITHM:Ljava/lang/String;

    .line 11
    const-string v0, "q-ak"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_AK:Ljava/lang/String;

    .line 13
    const-string v0, "q-sign-time"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGN_TIME:Ljava/lang/String;

    .line 15
    const-string v0, "q-key-time"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_KEY_TIME:Ljava/lang/String;

    .line 17
    const-string v0, "q-header-list"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_HEADER_LIST:Ljava/lang/String;

    .line 19
    const-string v0, "q-url-param-list"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_URL_PARAM_LIST:Ljava/lang/String;

    .line 21
    const-string v0, "q-signature"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->Q_SIGNATURE:Ljava/lang/String;

    .line 23
    const-string v0, "sha1"

    sput-object v0, Lcom/tencent/qcloud/core/auth/AuthConstants;->SHA1:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "AuthConstants is static class"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0
.end method
