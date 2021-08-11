.class public Lcom/wanmei/sdk/core/config/ChannelsReader;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;
    }
.end annotation


# static fields
.field private static final CHANNEL_FILE_NAME:Ljava/lang/String; = "OneSDKchannels.config"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/sdk/core/config/ChannelsReader;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/config/ChannelsReader;->mContext:Landroid/content/Context;

    return-void
.end method

.method static synthetic access$000(Lcom/wanmei/sdk/core/config/ChannelsReader;I)Lcom/wanmei/sdk/core/open/Channel;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/sdk/core/config/ChannelsReader;
    .param p1, "x1"    # I

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/sdk/core/config/ChannelsReader;->getChannel(I)Lcom/wanmei/sdk/core/open/Channel;

    move-result-object v0

    return-object v0
.end method

.method private getChannel(I)Lcom/wanmei/sdk/core/open/Channel;
    .locals 5
    .param p1, "channelId"    # I

    .prologue
    const/4 v2, 0x0

    :try_start_0
    invoke-direct {p0}, Lcom/wanmei/sdk/core/config/ChannelsReader;->readChannelFile()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .local v0, "channles":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    const-string v3, "readChannelFile result is null"

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v1, v2

    .end local v0    # "channles":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v1

    :catch_0
    move-exception v1

    sget-object v3, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    const-string v4, "readChannelFile failed"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    move-object v1, v2

    goto :goto_0

    .restart local v0    # "channles":Ljava/lang/String;
    :cond_1
    :try_start_1
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    sget-object v1, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    const-string v3, "jsonObject do not have the channelId"

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v1, v2

    goto :goto_0

    :catch_1
    move-exception v1

    sget-object v3, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    const-string v4, "readChannelFile result is not json"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    move-object v1, v2

    goto :goto_0

    :cond_2
    const-class v3, Lcom/wanmei/sdk/core/open/Channel;

    invoke-static {v1, v3}, Lcom/wanmei/sdk/core/net/a;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wanmei/sdk/core/open/Channel;

    if-nez v1, :cond_0

    sget-object v1, Lcom/wanmei/sdk/core/config/ChannelsReader;->TAG:Ljava/lang/String;

    const-string v3, "JsonHelper parse error"

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v1, v2

    goto :goto_0
.end method

.method private readChannelFile()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ChannelsReader;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "OneSDKchannels.config"

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/sdk/core/util/f;->b(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getChannel(ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V
    .locals 4
    .param p1, "channelId"    # I
    .param p2, "readChannelCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    .prologue
    new-instance v0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;

    invoke-direct {v0, p0, p2}, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;-><init>(Lcom/wanmei/sdk/core/config/ChannelsReader;Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Integer;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method
