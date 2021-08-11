.class public interface abstract Lcom/wanmei/sdk/core/open/SDKInterface$PayCallBack;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/open/SDKInterface;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PayCallBack"
.end annotation


# virtual methods
.method public abstract cancelled(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract failed(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract ordered(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract succeed(Ljava/lang/String;Ljava/lang/String;)V
.end method
