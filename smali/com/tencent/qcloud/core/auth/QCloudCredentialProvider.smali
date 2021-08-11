.class public interface abstract Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;
.super Ljava/lang/Object;
.source "QCloudCredentialProvider.java"


# virtual methods
.method public abstract getCredentials()Lcom/tencent/qcloud/core/auth/QCloudCredentials;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation
.end method

.method public abstract refresh()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation
.end method
