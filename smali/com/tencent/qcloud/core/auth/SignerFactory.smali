.class public final Lcom/tencent/qcloud/core/auth/SignerFactory;
.super Ljava/lang/Object;
.source "SignerFactory.java"


# static fields
.field private static final COS_XML_SIGNER:Ljava/lang/String; = "CosXmlSigner"

.field private static final SIGNERS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/tencent/qcloud/core/auth/QCloudSigner;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 11
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/tencent/qcloud/core/auth/SignerFactory;->SIGNERS:Ljava/util/Map;

    .line 15
    sget-object v0, Lcom/tencent/qcloud/core/auth/SignerFactory;->SIGNERS:Ljava/util/Map;

    const-string v1, "CosXmlSigner"

    const-class v2, Lcom/tencent/qcloud/core/auth/COSXmlSigner;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method

.method private static createSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .locals 6
    .param p0, "signerType"    # Ljava/lang/String;

    .prologue
    .line 69
    sget-object v3, Lcom/tencent/qcloud/core/auth/SignerFactory;->SIGNERS:Ljava/util/Map;

    invoke-interface {v3, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Class;

    .line 70
    .local v2, "signerClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/tencent/qcloud/core/auth/QCloudSigner;>;"
    if-nez v2, :cond_0

    .line 71
    const/4 v1, 0x0

    .line 85
    :goto_0
    return-object v1

    .line 74
    :cond_0
    :try_start_0
    invoke-virtual {v2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/tencent/qcloud/core/auth/QCloudSigner;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .local v1, "signer":Lcom/tencent/qcloud/core/auth/QCloudSigner;
    goto :goto_0

    .line 75
    .end local v1    # "signer":Lcom/tencent/qcloud/core/auth/QCloudSigner;
    :catch_0
    move-exception v0

    .line 76
    .local v0, "ex":Ljava/lang/InstantiationException;
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Cannot create an instance of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 77
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 79
    .end local v0    # "ex":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 80
    .local v0, "ex":Ljava/lang/IllegalAccessException;
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Cannot create an instance of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 81
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method public static getSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .locals 1
    .param p0, "signerType"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-static {p0}, Lcom/tencent/qcloud/core/auth/SignerFactory;->lookupAndCreateSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;

    move-result-object v0

    return-object v0
.end method

.method private static lookupAndCreateSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;
    .locals 1
    .param p0, "signerType"    # Ljava/lang/String;

    .prologue
    .line 61
    invoke-static {p0}, Lcom/tencent/qcloud/core/auth/SignerFactory;->createSigner(Ljava/lang/String;)Lcom/tencent/qcloud/core/auth/QCloudSigner;

    move-result-object v0

    return-object v0
.end method

.method public static registerSigner(Ljava/lang/String;Ljava/lang/Class;)V
    .locals 2
    .param p0, "signerType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/tencent/qcloud/core/auth/QCloudSigner;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    .local p1, "signerClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/tencent/qcloud/core/auth/QCloudSigner;>;"
    if-nez p0, :cond_0

    .line 35
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "signerType cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    if-nez p1, :cond_1

    .line 38
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "signerClass cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_1
    sget-object v0, Lcom/tencent/qcloud/core/auth/SignerFactory;->SIGNERS:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    return-void
.end method
