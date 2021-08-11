.class Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;
.super Ljava/lang/Object;
.source "ClientComms.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DisconnectBG"
.end annotation


# instance fields
.field dBg:Ljava/lang/Thread;

.field disconnect:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

.field quiesceTimeout:J

.field final synthetic this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field token:Lorg/pwrd/paho/client/mqttv3/MqttToken;


# direct methods
.method constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;JLorg/pwrd/paho/client/mqttv3/MqttToken;)V
    .locals 1
    .param p2, "disconnect"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;
    .param p3, "quiesceTimeout"    # J
    .param p5, "token"    # Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .prologue
    .line 622
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 617
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->dBg:Ljava/lang/Thread;

    .line 623
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->disconnect:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    .line 624
    iput-wide p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->quiesceTimeout:J

    .line 625
    iput-object p5, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    .line 626
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 634
    const-string v0, "disconnectBG:run"

    .line 636
    .local v0, "methodName":Ljava/lang/String;
    invoke-static {}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->access$0()Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v1

    invoke-static {}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->access$1()Ljava/lang/String;

    move-result-object v2

    const-string v3, "disconnectBG:run"

    const-string v4, "221"

    invoke-interface {v1, v2, v3, v4}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-static {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->access$5(Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    move-result-object v1

    iget-wide v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->quiesceTimeout:J

    invoke-virtual {v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->quiesce(J)V

    .line 641
    :try_start_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->disconnect:Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttDisconnect;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->internalSend(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 642
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v1, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitUntilSent()V
    :try_end_0
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 647
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v1, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, v5, v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 648
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {v1, v2, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 650
    :goto_0
    return-void

    .line 644
    :catch_0
    move-exception v1

    .line 647
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v1, v1, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1, v5, v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 648
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {v1, v2, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    goto :goto_0

    .line 646
    :catchall_0
    move-exception v1

    .line 647
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    iget-object v2, v2, Lorg/pwrd/paho/client/mqttv3/MqttToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v2, v5, v5}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->markComplete(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 648
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->token:Lorg/pwrd/paho/client/mqttv3/MqttToken;

    invoke-virtual {v2, v3, v5}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->shutdownConnection(Lorg/pwrd/paho/client/mqttv3/MqttToken;Lorg/pwrd/paho/client/mqttv3/MqttException;)V

    .line 649
    throw v1
.end method

.method start()V
    .locals 3

    .prologue
    .line 629
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "MQTT Disc: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->this$0:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v2

    invoke-interface {v2}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->dBg:Ljava/lang/Thread;

    .line 630
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms$DisconnectBG;->dBg:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 631
    return-void
.end method
