.class public Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;
.super Ljava/lang/Object;
.source "SRTTAPIHTTPTask.java"


# instance fields
.field public body:[B

.field public key:Ljava/lang/String;

.field public method:I

.field public seq:I

.field public session:I

.field public timestamp:Ljava/lang/String;

.field public type:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->type:I

    .line 14
    iput v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->method:I

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->key:Ljava/lang/String;

    .line 16
    new-array v0, v1, [B

    iput-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->body:[B

    .line 17
    iput v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->session:I

    .line 18
    const-string v0, ""

    iput-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->timestamp:Ljava/lang/String;

    .line 19
    iput v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->seq:I

    .line 20
    return-void
.end method
