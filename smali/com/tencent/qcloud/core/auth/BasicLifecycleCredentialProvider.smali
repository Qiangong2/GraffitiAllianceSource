.class public abstract Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;
.super Ljava/lang/Object;
.source "BasicLifecycleCredentialProvider.java"

# interfaces
.implements Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;


# instance fields
.field private credentials:Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

.field private lock:Ljava/util/concurrent/locks/ReentrantLock;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    return-void
.end method

.method private needUpdateSignaturePair()Z
    .locals 12

    .prologue
    const/4 v7, 0x1

    .line 53
    iget-object v8, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->credentials:Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    if-nez v8, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v7

    .line 57
    :cond_1
    iget-object v8, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->credentials:Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    invoke-interface {v8}, Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;->getKeyTime()Ljava/lang/String;

    move-result-object v3

    .line 58
    .local v3, "keyTime":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 61
    const-string v8, ";"

    invoke-virtual {v3, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 62
    .local v6, "times":[Ljava/lang/String;
    array-length v8, v6

    const/4 v9, 0x2

    if-ne v8, v9, :cond_0

    .line 65
    aget-object v2, v6, v7

    .line 66
    .local v2, "expire":Ljava/lang/String;
    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 67
    .local v4, "expireTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    const-wide/16 v10, 0x3e8

    div-long v0, v8, v10

    .line 68
    .local v0, "currentTime":J
    const-wide/16 v8, 0x3c

    sub-long v8, v4, v8

    cmp-long v8, v0, v8

    if-gtz v8, :cond_0

    .line 71
    const/4 v7, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected abstract fetchNewCredentials()Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation
.end method

.method public final getCredentials()Lcom/tencent/qcloud/core/auth/QCloudCredentials;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->needUpdateSignaturePair()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 26
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->refresh()V

    .line 28
    :cond_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->credentials:Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    return-object v0
.end method

.method public final refresh()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation

    .prologue
    .line 35
    :try_start_0
    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    const-wide/16 v4, 0x14

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2, v4, v5, v3}, Ljava/util/concurrent/locks/ReentrantLock;->tryLock(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    .line 37
    .local v1, "locked":Z
    if-nez v1, :cond_0

    .line 38
    new-instance v2, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v3, "lock timeout, no credential for sign"

    invoke-direct {v2, v3}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 43
    .end local v1    # "locked":Z
    :catch_0
    move-exception v0

    .line 44
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_1
    new-instance v2, Lcom/tencent/qcloud/core/common/QCloudClientException;

    const-string v3, "interrupt when try to get credential"

    invoke-direct {v2, v3, v0}, Lcom/tencent/qcloud/core/common/QCloudClientException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 46
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2

    .line 41
    .restart local v1    # "locked":Z
    :cond_0
    :try_start_2
    invoke-virtual {p0}, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->fetchNewCredentials()Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;

    move-result-object v2

    iput-object v2, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->credentials:Lcom/tencent/qcloud/core/auth/QCloudLifecycleCredentials;
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 46
    iget-object v2, p0, Lcom/tencent/qcloud/core/auth/BasicLifecycleCredentialProvider;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 48
    return-void
.end method
