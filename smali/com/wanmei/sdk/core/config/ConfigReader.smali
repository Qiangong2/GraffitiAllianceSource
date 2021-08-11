.class public abstract Lcom/wanmei/sdk/core/config/ConfigReader;
.super Ljava/lang/Object;


# static fields
.field private static final CHANNEL:Ljava/lang/String; = "channel"

.field private static final CHANNEL_ID:Ljava/lang/String; = "channelId"

.field private static final COMMON:Ljava/lang/String; = "common"

.field private static final CUSTOM_SERVICE:Ljava/lang/String; = "customService"

.field private static final INIT:Ljava/lang/String; = "init"

.field private static final LOGIN:Ljava/lang/String; = "login"

.field private static final META:Ljava/lang/String; = "meta"

.field private static final PACKAGE_NAME:Ljava/lang/String; = "packageName"

.field private static final PAY:Ljava/lang/String; = "pay"

.field private static final PLATFORM:Ljava/lang/String; = "platform"

.field private static final SHARE_WEIXIN_ID:Ljava/lang/String; = "shareWeixinId"

.field private static final TAG:Ljava/lang/String; = "ConfigReader"

.field private static final VERSION:Ljava/lang/String; = "version"


# instance fields
.field private mAppId:I

.field private mAppKey:Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private mInitConfig:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation
.end field

.field private mLoginConfig:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation
.end field

.field private mMeta:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation
.end field

.field private mPayConfig:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation
.end field

.field private mVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mContext:Landroid/content/Context;

    return-void
.end method

.method private decodeFromString(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "body"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mAppKey:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x10

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/String;

    const/4 v2, 0x2

    invoke-static {p1, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    invoke-static {v2, v0}, Lcom/wanmei/sdk/core/util/d;->a([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    return-object v1
.end method

.method private getMeta(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 7
    .param p1, "meta"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "version"

    new-instance v3, Lcom/wanmei/sdk/core/param/Param;

    const-string v4, "version"

    const-string v5, "version"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5, v6}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "platform"

    new-instance v3, Lcom/wanmei/sdk/core/param/Param;

    const-string v4, "platform"

    const-string v5, "platform"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5, v6}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "channelId"

    new-instance v3, Lcom/wanmei/sdk/core/param/Param;

    const-string v4, "channelId"

    const-string v5, "channelId"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5, v6}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "packageName"

    new-instance v3, Lcom/wanmei/sdk/core/param/Param;

    const-string v4, "packageName"

    const-string v5, "packageName"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v4, v1, v6}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0
.end method

.method private getMetaString(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 4
    .param p1, "raw"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "meta"

    const-string v3, "meta"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "init"

    const-string v3, "init"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "login"

    const-string v3, "login"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "pay"

    const-string v3, "pay"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0
.end method

.method private readConfig(Ljava/lang/String;)V
    .locals 4
    .param p1, "preDecode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "ConfigReader"

    const-string v1, "ConfigFile\'s content is null or \"\""

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/util/LogUtil;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/config/ConfigReader;->decodeFromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "ConfigReader"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "File raw: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wanmei/sdk/core/util/LogUtil;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->getMetaString(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    const-string v0, "meta"

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->getMeta(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    const-string v0, "init"

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readInitParams(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mInitConfig:Ljava/util/HashMap;

    const-string v0, "login"

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readLoginParams(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mLoginConfig:Ljava/util/HashMap;

    const-string v0, "pay"

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readPayParams(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mPayConfig:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validatePackageName()V

    invoke-direct {p0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validateVersion()V

    invoke-direct {p0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validateParams()V

    goto :goto_0
.end method

.method private readFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "configFileName"    # Ljava/lang/String;

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/sdk/core/util/f;->b(Ljava/io/InputStream;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private readFilePath(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "filePath"    # Ljava/lang/String;

    .prologue
    :try_start_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v0, Ljava/io/FileNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file not fond: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    :goto_0
    const/4 v0, 0x0

    :goto_1
    return-object v0

    :cond_0
    :try_start_1
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-static {v1}, Lcom/wanmei/sdk/core/util/f;->b(Ljava/io/InputStream;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    goto :goto_1

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method private readInitParams(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 3
    .param p1, "initStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v1, "channel"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/wanmei/sdk/core/config/ConfigReader;->readChannelInitParams(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v1

    const-string v2, "common"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    return-object v1
.end method

.method private readLoginParams(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 2
    .param p1, "loginStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v1, "channel"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readChannelLoginParams(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method private readPayParams(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 2
    .param p1, "payStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v1, "channel"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readChannelPayParams(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method private validate(Ljava/util/HashMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "paramMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/wanmei/sdk/core/param/Param;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->isNotNull()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getValue()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    new-instance v1, Lcom/wanmei/sdk/core/config/ConfigFileException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "param: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " is empty"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    return-void
.end method

.method private validatePackageName()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    const-string v2, "packageName"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v1, Lcom/wanmei/sdk/core/config/ConfigFileException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "package error, packageName in config is: "

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    const-string v3, "packageName"

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " while packageName in game is: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    return-void
.end method

.method private validateParams()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validate(Ljava/util/HashMap;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mInitConfig:Ljava/util/HashMap;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validate(Ljava/util/HashMap;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mLoginConfig:Ljava/util/HashMap;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validate(Ljava/util/HashMap;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mPayConfig:Ljava/util/HashMap;

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->validate(Ljava/util/HashMap;)V

    return-void
.end method

.method private validateVersion()V
    .locals 4

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    const-string v1, "version"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getValue()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mVersion:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v1, Lcom/wanmei/sdk/core/config/ConfigFileException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "version error, config version is: "

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mMeta:Ljava/util/HashMap;

    const-string v3, "version"

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " while the sdk\'s version is"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mVersion:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/wanmei/sdk/core/config/ConfigFileException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    return-void
.end method


# virtual methods
.method public getInitConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mInitConfig:Ljava/util/HashMap;

    return-object v0
.end method

.method public getLoginConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mLoginConfig:Ljava/util/HashMap;

    return-object v0
.end method

.method public getPayConfig()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mPayConfig:Ljava/util/HashMap;

    return-object v0
.end method

.method protected readChannelInitParams(Lorg/json/JSONObject;)Ljava/util/HashMap;
    .locals 1
    .param p1, "initJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    return-object v0
.end method

.method protected readChannelLoginParams(Lorg/json/JSONObject;)Ljava/util/HashMap;
    .locals 1
    .param p1, "loginJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    return-object v0
.end method

.method protected readChannelPayParams(Lorg/json/JSONObject;)Ljava/util/HashMap;
    .locals 1
    .param p1, "payJson"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    return-object v0
.end method

.method public readConfigFileName(Ljava/lang/String;)V
    .locals 1
    .param p1, "configFileName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/config/ConfigReader;->readFile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readConfig(Ljava/lang/String;)V

    return-void
.end method

.method public readConfigFilePath(Ljava/lang/String;)V
    .locals 1
    .param p1, "configFilePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/config/ConfigReader;->readFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/config/ConfigReader;->readConfig(Ljava/lang/String;)V

    return-void
.end method

.method public setBasic(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "appId"    # I
    .param p2, "appKey"    # Ljava/lang/String;
    .param p3, "version"    # Ljava/lang/String;

    .prologue
    iput p1, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mAppId:I

    iput-object p2, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mAppKey:Ljava/lang/String;

    iput-object p3, p0, Lcom/wanmei/sdk/core/config/ConfigReader;->mVersion:Ljava/lang/String;

    return-void
.end method
