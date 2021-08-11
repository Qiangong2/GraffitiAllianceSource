.class public abstract Lcom/wanmei/sdk/core/open/SDKImpl;
.super Lcom/wanmei/sdk/core/open/SDKFoundation;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/open/SDKFoundation;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract doLoginImpl()V
.end method

.method protected abstract doLogoutImpl()V
.end method

.method protected abstract doPayImpl(Lcom/wanmei/sdk/core/param/OrderParams;)V
.end method

.method protected abstract initImpl()V
.end method
