.class public Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;
.super Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;
.source "CosSdkPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lplugins/CosSdkPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LocalSessionCredentialProvider"
.end annotation


# instance fields
.field private expiredTime:J

.field private sessionToken:Ljava/lang/String;

.field private tempSecretId:Ljava/lang/String;

.field private tempSecretKey:Ljava/lang/String;

.field final synthetic this$0:Lplugins/CosSdkPlugin;


# direct methods
.method public constructor <init>(Lplugins/CosSdkPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 1
    .param p1, "this$0"    # Lplugins/CosSdkPlugin;
    .param p2, "tempSecretId"    # Ljava/lang/String;
    .param p3, "tempSecretKey"    # Ljava/lang/String;
    .param p4, "sessionToken"    # Ljava/lang/String;
    .param p5, "expiredTime"    # J

    .prologue
    .line 417
    iput-object p1, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->this$0:Lplugins/CosSdkPlugin;

    invoke-direct {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;-><init>()V

    .line 418
    iput-object p2, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->tempSecretId:Ljava/lang/String;

    .line 419
    iput-object p3, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->tempSecretKey:Ljava/lang/String;

    .line 420
    iput-object p4, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->sessionToken:Ljava/lang/String;

    .line 421
    iput-wide p5, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->expiredTime:J

    .line 422
    return-void
.end method


# virtual methods
.method public fetchNewCredentials()Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 426
    new-instance v0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;

    iget-object v1, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->tempSecretId:Ljava/lang/String;

    iget-object v2, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->tempSecretKey:Ljava/lang/String;

    iget-object v3, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->sessionToken:Ljava/lang/String;

    iget-wide v4, p0, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;->expiredTime:J

    invoke-direct/range {v0 .. v5}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    return-object v0
.end method
