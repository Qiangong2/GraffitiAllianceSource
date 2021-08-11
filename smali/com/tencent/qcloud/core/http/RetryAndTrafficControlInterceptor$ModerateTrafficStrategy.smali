.class Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ModerateTrafficStrategy;
.super Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;
.source "RetryAndTrafficControlInterceptor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ModerateTrafficStrategy"
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "maxConcurrent"    # I

    .prologue
    .line 200
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, p2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;-><init>(Ljava/lang/String;II)V

    .line 201
    return-void
.end method
