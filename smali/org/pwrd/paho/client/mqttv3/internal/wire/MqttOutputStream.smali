.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;
.super Ljava/io/OutputStream;
.source "MqttOutputStream.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field private static final log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

.field private out:Ljava/io/BufferedOutputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    const-class v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->CLASS_NAME:Ljava/lang/String;

    .line 35
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->CLASS_NAME:Ljava/lang/String;

    invoke-static {v0, v1}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/internal/ClientState;Ljava/io/OutputStream;)V
    .locals 1
    .param p1, "clientState"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientState;
    .param p2, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 41
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    .line 42
    new-instance v0, Ljava/io/BufferedOutputStream;

    invoke-direct {v0, p2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    .line 43
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->close()V

    .line 47
    return-void
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v0}, Ljava/io/BufferedOutputStream;->flush()V

    .line 51
    return-void
.end method

.method public write(I)V
    .locals 1
    .param p1, "b"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/BufferedOutputStream;->write(I)V

    .line 65
    return-void
.end method

.method public write(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    .locals 12
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/pwrd/paho/client/mqttv3/MqttException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    .line 71
    const-string v3, "write"

    .line 72
    .local v3, "methodName":Ljava/lang/String;
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getHeader()[B

    move-result-object v0

    .line 73
    .local v0, "bytes":[B
    invoke-virtual {p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;->getPayload()[B

    move-result-object v5

    .line 76
    .local v5, "pl":[B
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    array-length v7, v0

    invoke-virtual {v6, v0, v11, v7}, Ljava/io/BufferedOutputStream;->write([BII)V

    .line 77
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    array-length v7, v0

    invoke-virtual {v6, v7}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifySentBytes(I)V

    .line 79
    const/4 v4, 0x0

    .line 80
    .local v4, "offset":I
    const/16 v1, 0x400

    .line 81
    .local v1, "chunckSize":I
    :goto_0
    array-length v6, v5

    if-lt v4, v6, :cond_0

    .line 89
    sget-object v6, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->log:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    sget-object v7, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->CLASS_NAME:Ljava/lang/String;

    const-string v8, "write"

    const-string v9, "500"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    aput-object p1, v10, v11

    invoke-interface {v6, v7, v8, v9, v10}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 90
    return-void

    .line 82
    :cond_0
    array-length v6, v5

    sub-int/2addr v6, v4

    invoke-static {v1, v6}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 83
    .local v2, "length":I
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v6, v5, v4, v2}, Ljava/io/BufferedOutputStream;->write([BII)V

    .line 84
    add-int/2addr v4, v1

    .line 85
    iget-object v6, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v6, v2}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifySentBytes(I)V

    goto :goto_0
.end method

.method public write([B)V
    .locals 2
    .param p1, "b"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 55
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    array-length v1, p1

    invoke-virtual {v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifySentBytes(I)V

    .line 56
    return-void
.end method

.method public write([BII)V
    .locals 1
    .param p1, "b"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->out:Ljava/io/BufferedOutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/BufferedOutputStream;->write([BII)V

    .line 60
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttOutputStream;->clientState:Lorg/pwrd/paho/client/mqttv3/internal/ClientState;

    invoke-virtual {v0, p3}, Lorg/pwrd/paho/client/mqttv3/internal/ClientState;->notifySentBytes(I)V

    .line 61
    return-void
.end method
