.class Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor$ResizableSemaphore;
.super Ljava/util/concurrent/Semaphore;
.source "RetryAndTrafficControlInterceptor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/RetryAndTrafficControlInterceptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ResizableSemaphore"
.end annotation


# direct methods
.method constructor <init>(IZ)V
    .locals 0
    .param p1, "permit"    # I
    .param p2, "fair"    # Z

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Ljava/util/concurrent/Semaphore;-><init>(IZ)V

    .line 60
    return-void
.end method


# virtual methods
.method protected reducePermits(I)V
    .locals 0
    .param p1, "reduction"    # I

    .prologue
    .line 64
    invoke-super {p0, p1}, Ljava/util/concurrent/Semaphore;->reducePermits(I)V

    .line 65
    return-void
.end method
