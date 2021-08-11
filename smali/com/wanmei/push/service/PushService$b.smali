.class final Lcom/wanmei/push/service/PushService$b;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/PushService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/service/PushService;


# direct methods
.method private constructor <init>(Lcom/wanmei/push/service/PushService;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$b;->a:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/wanmei/push/service/PushService;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;)V

    return-void
.end method


# virtual methods
.method protected final synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/service/PushService;->b()Lcom/wanmei/push/service/PushService$a;

    move-result-object v0

    iget-object v0, v0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$b;->a:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->c(Lcom/wanmei/push/service/PushService;)V

    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    .prologue
    check-cast p1, Ljava/lang/Void;

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Z)Z

    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    return-void
.end method

.method protected final onPreExecute()V
    .locals 1

    const/4 v0, 0x1

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Z)Z

    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    return-void
.end method
