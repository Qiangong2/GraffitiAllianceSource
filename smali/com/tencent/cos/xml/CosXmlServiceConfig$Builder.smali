.class public final Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;
.super Ljava/lang/Object;
.source "CosXmlServiceConfig.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/CosXmlServiceConfig;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private appid:Ljava/lang/String;

.field private isDebuggable:Z

.field private protocol:Ljava/lang/String;

.field private region:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    const-string v0, "http"

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->protocol:Ljava/lang/String;

    .line 68
    sget-object v0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->DEFAULT_USER_AGENT:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->userAgent:Ljava/lang/String;

    .line 69
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->isDebuggable:Z

    .line 70
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->protocol:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->appid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->region:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 56
    iget-boolean v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->isDebuggable:Z

    return v0
.end method


# virtual methods
.method public builder()Lcom/tencent/cos/xml/CosXmlServiceConfig;
    .locals 1

    .prologue
    .line 93
    new-instance v0, Lcom/tencent/cos/xml/CosXmlServiceConfig;

    invoke-direct {v0, p0}, Lcom/tencent/cos/xml/CosXmlServiceConfig;-><init>(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)V

    return-object v0
.end method

.method public isHttps(Z)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;
    .locals 1
    .param p1, "isHttps"    # Z

    .prologue
    .line 73
    if-eqz p1, :cond_0

    .line 74
    const-string v0, "https"

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->protocol:Ljava/lang/String;

    .line 78
    :goto_0
    return-object p0

    .line 76
    :cond_0
    const-string v0, "http"

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->protocol:Ljava/lang/String;

    goto :goto_0
.end method

.method public setAppidAndRegion(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;
    .locals 0
    .param p1, "appid"    # Ljava/lang/String;
    .param p2, "region"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->appid:Ljava/lang/String;

    .line 83
    iput-object p2, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->region:Ljava/lang/String;

    .line 84
    return-object p0
.end method

.method public setDebuggable(Z)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;
    .locals 0
    .param p1, "isDebuggable"    # Z

    .prologue
    .line 88
    iput-boolean p1, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->isDebuggable:Z

    .line 89
    return-object p0
.end method
