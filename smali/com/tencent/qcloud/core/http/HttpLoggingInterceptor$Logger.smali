.class public interface abstract Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;
.super Ljava/lang/Object;
.source "HttpLoggingInterceptor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Logger"
.end annotation


# static fields
.field public static final DEFAULT:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 117
    new-instance v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger$1;

    invoke-direct {v0}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger$1;-><init>()V

    sput-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->DEFAULT:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    return-void
.end method


# virtual methods
.method public abstract log(Ljava/lang/String;)V
.end method
