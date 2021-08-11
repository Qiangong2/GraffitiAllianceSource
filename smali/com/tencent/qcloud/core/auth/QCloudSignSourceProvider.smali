.class public interface abstract Lcom/tencent/qcloud/core/auth/QCloudSignSourceProvider;
.super Ljava/lang/Object;
.source "QCloudSignSourceProvider.java"


# virtual methods
.method public abstract source(Lcom/tencent/qcloud/core/http/HttpRequest;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/tencent/qcloud/core/http/HttpRequest",
            "<TT;>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/qcloud/core/common/QCloudClientException;
        }
    .end annotation
.end method
