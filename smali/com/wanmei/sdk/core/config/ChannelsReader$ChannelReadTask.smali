.class Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/config/ChannelsReader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChannelReadTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "Lcom/wanmei/sdk/core/open/Channel;",
        ">;"
    }
.end annotation


# instance fields
.field private mReadChannelCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

.field final synthetic this$0:Lcom/wanmei/sdk/core/config/ChannelsReader;


# direct methods
.method public constructor <init>(Lcom/wanmei/sdk/core/config/ChannelsReader;Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V
    .locals 0
    .param p2, "readChannelCallBack"    # Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->this$0:Lcom/wanmei/sdk/core/config/ChannelsReader;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    iput-object p2, p0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->mReadChannelCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Integer;)Lcom/wanmei/sdk/core/open/Channel;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Integer;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->this$0:Lcom/wanmei/sdk/core/config/ChannelsReader;

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v0, v1}, Lcom/wanmei/sdk/core/config/ChannelsReader;->access$000(Lcom/wanmei/sdk/core/config/ChannelsReader;I)Lcom/wanmei/sdk/core/open/Channel;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    check-cast p1, [Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->doInBackground([Ljava/lang/Integer;)Lcom/wanmei/sdk/core/open/Channel;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Lcom/wanmei/sdk/core/open/Channel;)V
    .locals 2
    .param p1, "channel"    # Lcom/wanmei/sdk/core/open/Channel;

    .prologue
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->mReadChannelCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    const-string v1, "channel is empty,maybe channel id is error,OneSDKchannels.config is error"

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;->failed(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->mReadChannelCallBack:Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;

    invoke-interface {v0, p1}, Lcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;->succeed(Lcom/wanmei/sdk/core/open/Channel;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    check-cast p1, Lcom/wanmei/sdk/core/open/Channel;

    invoke-virtual {p0, p1}, Lcom/wanmei/sdk/core/config/ChannelsReader$ChannelReadTask;->onPostExecute(Lcom/wanmei/sdk/core/open/Channel;)V

    return-void
.end method
