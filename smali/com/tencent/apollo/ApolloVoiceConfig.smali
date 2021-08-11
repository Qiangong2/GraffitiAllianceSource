.class public Lcom/tencent/apollo/ApolloVoiceConfig;
.super Ljava/lang/Object;
.source "ApolloVoiceConfig.java"


# static fields
.field private static LOGTAG:Ljava/lang/String; = null

.field private static final cfgName:Ljava/lang/String; = "GCloudVoice/config.json"

.field private static mainContext:Landroid/content/Context;

.field private static storageCfgPath:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-string v0, "GCloudVoiceTag"

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->LOGTAG:Ljava/lang/String;

    .line 14
    const/4 v0, 0x0

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->storageCfgPath:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static IsSDCardCfgExist()Z
    .locals 2

    .prologue
    .line 29
    new-instance v0, Ljava/io/File;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceConfig;->storageCfgPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 30
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    return v0
.end method

.method public static JSONCfg(Z)Ljava/lang/String;
    .locals 7

    .prologue
    .line 35
    .line 36
    if-eqz p0, :cond_1

    .line 37
    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceConfig;->storageCfgPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    .line 38
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceConfig;->LOGTAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Read config file from storage : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/tencent/apollo/ApolloVoiceConfig;->storageCfgPath:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move-object v1, v0

    .line 44
    :goto_0
    invoke-virtual {v1}, Ljava/io/InputStream;->available()I

    move-result v2

    .line 45
    new-array v3, v2, [B

    .line 46
    const-string v4, "UTF-8"

    .line 47
    const/4 v0, 0x0

    .line 50
    :goto_1
    if-ge v0, v2, :cond_0

    .line 52
    sub-int v5, v2, v0

    invoke-virtual {v1, v3, v0, v5}, Ljava/io/InputStream;->read([BII)I

    move-result v5

    .line 53
    const/4 v6, -0x1

    if-ne v5, v6, :cond_2

    .line 57
    :cond_0
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 58
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 59
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceConfig;->LOGTAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "####Get config :"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    :goto_2
    return-object v0

    .line 41
    :cond_1
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->mainContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "GCloudVoice/config.json"

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    .line 55
    :cond_2
    add-int/2addr v0, v5

    .line 56
    goto :goto_1

    .line 61
    :catch_0
    move-exception v0

    .line 62
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 64
    const/4 v0, 0x0

    goto :goto_2
.end method

.method public static SetContext(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 19
    sput-object p0, Lcom/tencent/apollo/ApolloVoiceConfig;->mainContext:Landroid/content/Context;

    .line 20
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->mainContext:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 21
    if-eqz v0, :cond_0

    .line 22
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "GCloudVoice/config.json"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->storageCfgPath:Ljava/lang/String;

    .line 26
    :goto_0
    return-void

    .line 24
    :cond_0
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceConfig;->LOGTAG:Ljava/lang/String;

    const-string v1, "getExternalFilesDir failed !!!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
