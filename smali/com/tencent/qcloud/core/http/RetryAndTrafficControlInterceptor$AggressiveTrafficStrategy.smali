.class Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$AggressiveTrafficStrategy;
.super Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;
.source "RetryAndTrafficControlInterceptor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AggressiveTrafficStrategy"
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "maxConcurrent"    # I

    .prologue
    .line 191
    invoke-direct {p0, p1, p2, p2}, Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$TrafficStrategy;-><init>(Ljava/lang/String;II)V

    .line 192
    return-void
.end method
