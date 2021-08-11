.class public Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;
.super Ljava/lang/Object;
.source "BasicQCloudCredentials.java"

# interfaces
.implements Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;


# instance fields
.field private final keyTime:Ljava/lang/String;

.field private final secretId:Ljava/lang/String;

.field private final signKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;JJ)V
    .locals 5
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "signKey"    # Ljava/lang/String;
    .param p3, "beginTime"    # J
    .param p5, "expiredTime"    # J

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    if-nez p1, :cond_0

    .line 27
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_0
    if-nez p2, :cond_1

    .line 30
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "signKey cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :cond_1
    cmp-long v0, p3, p5

    if-ltz v0, :cond_2

    .line 33
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "beginTime must be larger than expiredTime."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_2
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->secretId:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->signKey:Ljava/lang/String;

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p3, p4}, Lcom/tencent/qcloud/core/auth/Utils;->handleTimeAccuracy(J)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p5, p6}, Lcom/tencent/qcloud/core/auth/Utils;->handleTimeAccuracy(J)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->keyTime:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "signKey"    # Ljava/lang/String;
    .param p3, "keyTime"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    if-nez p1, :cond_0

    .line 50
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    if-nez p2, :cond_1

    .line 53
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "signKey cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_1
    if-nez p3, :cond_2

    .line 56
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "keyTime cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_2
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->secretId:Ljava/lang/String;

    .line 60
    iput-object p2, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->signKey:Ljava/lang/String;

    .line 61
    iput-object p3, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->keyTime:Ljava/lang/String;

    .line 62
    return-void
.end method


# virtual methods
.method public getKeyTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->keyTime:Ljava/lang/String;

    return-object v0
.end method

.method public getSecretId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->secretId:Ljava/lang/String;

    return-object v0
.end method

.method public getSignKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicQCloudCredentials;->signKey:Ljava/lang/String;

    return-object v0
.end method
