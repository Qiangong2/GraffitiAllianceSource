.class public Lcom/tencent/cos/xml/CosXmlServiceConfig;
.super Ljava/lang/Object;
.source "CosXmlServiceConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;
    }
.end annotation


# static fields
.field public static final DEFAULT_PROTOCOL:Ljava/lang/String; = "http"

.field public static final DEFAULT_USER_AGENT:Ljava/lang/String;


# instance fields
.field private appid:Ljava/lang/String;

.field private isDebuggable:Z

.field private protocol:Ljava/lang/String;

.field private region:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    invoke-static {}, Lcom/tencent/cos/xml/common/VersionInfo;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->DEFAULT_USER_AGENT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {p1}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->access$000(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->protocol:Ljava/lang/String;

    .line 30
    invoke-static {p1}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->access$100(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->userAgent:Ljava/lang/String;

    .line 31
    invoke-static {p1}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->access$200(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->appid:Ljava/lang/String;

    .line 32
    invoke-static {p1}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->access$300(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->region:Ljava/lang/String;

    .line 33
    invoke-static {p1}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->access$400(Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->isDebuggable:Z

    .line 34
    return-void
.end method


# virtual methods
.method public getAppid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->appid:Ljava/lang/String;

    return-object v0
.end method

.method public getProtocol()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->protocol:Ljava/lang/String;

    return-object v0
.end method

.method public getRegion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->region:Ljava/lang/String;

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public isDebuggable()Z
    .locals 1

    .prologue
    .line 53
    iget-boolean v0, p0, Lcom/tencent/cos/xml/CosXmlServiceConfig;->isDebuggable:Z

    return v0
.end method
