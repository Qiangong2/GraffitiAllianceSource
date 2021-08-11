.class public Lcom/getui/getuiunity/GTPushIntentService;
.super Lcom/igexin/sdk/GTIntentService;
.source "GTPushIntentService.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/igexin/sdk/GTIntentService;-><init>()V

    .line 27
    return-void
.end method


# virtual methods
.method public onReceiveClientId(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "clientId"    # Ljava/lang/String;

    .prologue
    .line 49
    sget-object v0, Lcom/getui/getuiunity/GTPushBridge;->GAMA_OBJECT:Ljava/lang/String;

    const-string v1, "onReceiveClientId"

    invoke-static {v0, v1, p2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    return-void
.end method

.method public onReceiveCommandResult(Landroid/content/Context;Lcom/igexin/sdk/message/GTCmdMessage;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cmdMessage"    # Lcom/igexin/sdk/message/GTCmdMessage;

    .prologue
    .line 59
    return-void
.end method

.method public onReceiveMessageData(Landroid/content/Context;Lcom/igexin/sdk/message/GTTransmitMessage;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "msg"    # Lcom/igexin/sdk/message/GTTransmitMessage;

    .prologue
    .line 36
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 37
    .local v1, "jsonObject":Lorg/json/JSONObject;
    const-string v2, "type"

    const-string v3, "payload"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 38
    const-string v2, "taskId"

    invoke-virtual {p2}, Lcom/igexin/sdk/message/GTTransmitMessage;->getTaskId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 39
    const-string v2, "msgId"

    invoke-virtual {p2}, Lcom/igexin/sdk/message/GTTransmitMessage;->getMessageId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 40
    const-string v2, "payload"

    new-instance v3, Ljava/lang/String;

    invoke-virtual {p2}, Lcom/igexin/sdk/message/GTTransmitMessage;->getPayload()[B

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 41
    sget-object v2, Lcom/getui/getuiunity/GTPushBridge;->GAMA_OBJECT:Ljava/lang/String;

    const-string v3, "onReceiveMessage"

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    .end local v1    # "jsonObject":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 42
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public onReceiveOnlineState(Landroid/content/Context;Z)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "online"    # Z

    .prologue
    .line 55
    return-void
.end method

.method public onReceiveServicePid(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "pid"    # I

    .prologue
    .line 31
    return-void
.end method
