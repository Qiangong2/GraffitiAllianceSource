.class final Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;
.super Lcom/tencent/qcloud/core/http/RequestBodySerializer;
.source "RequestBodySerializer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/qcloud/core/http/RequestBodySerializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "BaseRequestBodyWrapper"
.end annotation


# instance fields
.field private final body:Lokhttp3/RequestBody;


# direct methods
.method public constructor <init>(Lokhttp3/RequestBody;)V
    .locals 0
    .param p1, "body"    # Lokhttp3/RequestBody;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;->body:Lokhttp3/RequestBody;

    .line 36
    return-void
.end method


# virtual methods
.method body()Lokhttp3/RequestBody;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;->body:Lokhttp3/RequestBody;

    return-object v0
.end method
