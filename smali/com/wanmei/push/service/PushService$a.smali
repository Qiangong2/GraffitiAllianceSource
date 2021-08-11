.class final Lcom/wanmei/push/service/PushService$a;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/MqttCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/PushService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

.field b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

.field final synthetic c:Lcom/wanmei/push/service/PushService;


# direct methods
.method public constructor <init>(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    const/4 v0, 0x0

    iput-object p1, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    iput-object v0, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "MQTTConnection() IN [brokerHostName]["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "tcp://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":6993"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Lcom/wanmei/push/service/PushService;->d(Lcom/wanmei/push/service/PushService;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "preference_deviceID"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    invoke-direct {v2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;-><init>()V

    iput-object v2, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->setCleanSession(Z)V

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "mobile"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/wanmei/push/g/c;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    invoke-virtual {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->setUserName(Ljava/lang/String;)V

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "0859fc7b49769ddd89a8cac544fbfd9b"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v6, 0x2

    const/4 v7, 0x5

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0xa

    const/16 v7, 0x10

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0x12

    const/16 v7, 0x14

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0xe

    const/16 v7, 0x13

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/wanmei/push/g/g;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    invoke-virtual {v2}, Ljava/lang/String;->toCharArray()[C

    move-result-object v2

    invoke-virtual {v3, v2}, Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;->setPassword([C)V

    new-instance v2, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-static {}, Lcom/wanmei/push/service/PushService;->d()Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    move-result-object v3

    new-instance v4, Lcom/wanmei/push/service/a;

    invoke-direct {v4, p1}, Lcom/wanmei/push/service/a;-><init>(Lcom/wanmei/push/service/PushService;)V

    invoke-direct {v2, v0, v1, v3, v4}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;-><init>(Ljava/lang/String;Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;Lorg/pwrd/paho/client/mqttv3/MqttPingSender;)V

    iput-object v2, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->setCallback(Lorg/pwrd/paho/client/mqttv3/MqttCallback;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a;->b:Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;

    new-instance v2, Lcom/wanmei/push/service/PushService$a$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/wanmei/push/service/PushService$a$1;-><init>(Lcom/wanmei/push/service/PushService$a;Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    invoke-virtual {v0, v1, p1, v2}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->connect(Lorg/pwrd/paho/client/mqttv3/MqttConnectOptions;Ljava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    return-void
.end method

.method private a([Ljava/lang/String;[ILorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "subscribeToTopic() IN [topicName]["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "Connection error : No connection"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0, p1, p2, v1, p3}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->subscribe([Ljava/lang/String;[ILjava/lang/Object;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)Lorg/pwrd/paho/client/mqttv3/IMqttToken;

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->e(Lcom/wanmei/push/service/PushService;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->a:Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttAsyncClient;->disconnect()Lorg/pwrd/paho/client/mqttv3/IMqttToken;
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    move-object v1, v0

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v0, "MqttException"

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :cond_0
    const-string v0, " NULL"

    goto :goto_1
.end method

.method public final a(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-static {}, Lcom/wanmei/push/service/PushService;->e()[I

    move-result-object v1

    invoke-direct {p0, v0, v1, p2}, Lcom/wanmei/push/service/PushService$a;->a([Ljava/lang/String;[ILorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    return-void
.end method

.method public final a(Ljava/util/List;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/AppInfo;",
            ">;",
            "Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    const/4 v1, 0x0

    invoke-static {p1}, Lcom/wanmei/push/service/b;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    new-array v4, v0, [I

    move v0, v1

    :goto_0
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    if-ge v0, v5, :cond_0

    aput v1, v4, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    invoke-direct {p0, v2, v4, p2}, Lcom/wanmei/push/service/PushService$a;->a([Ljava/lang/String;[ILorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    return-void
.end method

.method public final b()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "[ -- keep Service alive -- ] Current App Info : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v2}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    return-void
.end method

.method public final b(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-static {}, Lcom/wanmei/push/service/PushService;->e()[I

    move-result-object v1

    invoke-direct {p0, v0, v1, p2}, Lcom/wanmei/push/service/PushService$a;->a([Ljava/lang/String;[ILorg/pwrd/paho/client/mqttv3/IMqttActionListener;)V

    return-void
.end method

.method public final connectionLost(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "arg0"    # Ljava/lang/Throwable;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "Loss of connectionconnection downed"

    invoke-static {v0, v1, p1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->e(Lcom/wanmei/push/service/PushService;)V

    invoke-static {}, Lcom/wanmei/push/service/PushService;->c()Lcom/wanmei/push/service/PushService$a;

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->i(Lcom/wanmei/push/service/PushService;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-static {v0}, Lcom/wanmei/push/service/PushService;->k(Lcom/wanmei/push/service/PushService;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/service/PushService;Z)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService;->stopSelf()V

    goto :goto_0
.end method

.method public final deliveryComplete(Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;)V
    .locals 3
    .param p1, "iMqttDeliveryToken"    # Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "[ -- DeliveryComplete -- ]["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lorg/pwrd/paho/client/mqttv3/IMqttDeliveryToken;->getMessage()Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    move-result-object v2

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->printStackTrace()V

    goto :goto_0
.end method

.method public final messageArrived(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V
    .locals 3
    .param p2, "mqttMessage"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "[ -- PUSH Message Arrived -- ]["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    invoke-static {}, Lcom/wanmei/push/g/i;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    invoke-virtual {p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->d(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService$a;->c:Lcom/wanmei/push/service/PushService;

    const-string v1, "Is not primary system"

    invoke-static {v0, v1}, Lcom/wanmei/push/service/PushService;->b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    goto :goto_0
.end method
