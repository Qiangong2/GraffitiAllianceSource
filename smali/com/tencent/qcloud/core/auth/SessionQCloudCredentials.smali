.class public Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;
.super Ljava/lang/Object;
.source "SessionQCloudCredentials.java"

# interfaces
.implements Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;


# instance fields
.field private final keyTime:Ljava/lang/String;

.field private final secretId:Ljava/lang/String;

.field private final signKey:Ljava/lang/String;

.field private final token:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 8
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "expiredTime"    # J

    .prologue
    .line 25
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long v4, v0, v2

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-wide v6, p4

    invoke-direct/range {v0 .. v7}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V

    .line 26
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V
    .locals 2
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "beginTime"    # J
    .param p6, "expiredTime"    # J

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-nez p1, :cond_0

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    if-nez p2, :cond_1

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretKey cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_1
    if-nez p3, :cond_2

    .line 45
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "token cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_2
    cmp-long v0, p4, p6

    if-ltz v0, :cond_3

    .line 48
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "beginTime must be larger than expiredTime."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_3
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->secretId:Ljava/lang/String;

    .line 52
    invoke-direct {p0, p4, p5, p6, p7}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->getKeyTime(JJ)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->keyTime:Ljava/lang/String;

    .line 53
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->keyTime:Ljava/lang/String;

    invoke-direct {p0, p2, v0}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->getSignKey(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->signKey:Ljava/lang/String;

    .line 54
    iput-object p3, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->token:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "secretId"    # Ljava/lang/String;
    .param p2, "secretKey"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "keyTime"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    if-nez p1, :cond_0

    .line 67
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_0
    if-nez p2, :cond_1

    .line 70
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "secretKey cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_1
    if-nez p3, :cond_2

    .line 73
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "token cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_2
    if-nez p4, :cond_3

    .line 76
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "keyTime cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :cond_3
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->secretId:Ljava/lang/String;

    .line 80
    iput-object p4, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->keyTime:Ljava/lang/String;

    .line 81
    invoke-direct {p0, p2, p4}, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->getSignKey(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->signKey:Ljava/lang/String;

    .line 82
    iput-object p3, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->token:Ljava/lang/String;

    .line 83
    return-void
.end method

.method private getKeyTime(JJ)Ljava/lang/String;
    .locals 5
    .param p1, "beginTime"    # J
    .param p3, "expiredTime"    # J

    .prologue
    .line 86
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1, p2}, Lcom/tencent/qcloud/core/auth/Utils;->handleTimeAccuracy(J)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p3, p4}, Lcom/tencent/qcloud/core/auth/Utils;->handleTimeAccuracy(J)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSignKey(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "secretKey"    # Ljava/lang/String;
    .param p2, "keyTime"    # Ljava/lang/String;

    .prologue
    .line 90
    invoke-static {p2, p1}, Lcom/tencent/qcloud/core/auth/Utils;->hmacSha1(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    .line 91
    .local v0, "hmacSha1":[B
    if-eqz v0, :cond_0

    .line 92
    new-instance v1, Ljava/lang/String;

    invoke-static {v0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([B)[C

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([C)V

    .line 94
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getKeyTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->keyTime:Ljava/lang/String;

    return-object v0
.end method

.method public getSecretId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->secretId:Ljava/lang/String;

    return-object v0
.end method

.method public getSignKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->signKey:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/SessionQCloudCredentials;->token:Ljava/lang/String;

    return-object v0
.end method
