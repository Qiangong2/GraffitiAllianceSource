.class public Lorg/pwrd/paho/client/mqttv3/MqttException;
.super Ljava/lang/Exception;
.source "MqttException.java"


# static fields
.field public static final REASON_CODE_BROKER_UNAVAILABLE:S = 0x3s

.field public static final REASON_CODE_CLIENT_ALREADY_DISCONNECTED:S = 0x7d65s

.field public static final REASON_CODE_CLIENT_CLOSED:S = 0x7d6fs

.field public static final REASON_CODE_CLIENT_CONNECTED:S = 0x7d64s

.field public static final REASON_CODE_CLIENT_DISCONNECTING:S = 0x7d66s

.field public static final REASON_CODE_CLIENT_DISCONNECT_PROHIBITED:S = 0x7d6bs

.field public static final REASON_CODE_CLIENT_EXCEPTION:S = 0x0s

.field public static final REASON_CODE_CLIENT_NOT_CONNECTED:S = 0x7d68s

.field public static final REASON_CODE_CLIENT_TIMEOUT:S = 0x7d00s

.field public static final REASON_CODE_CONNECTION_LOST:S = 0x7d6ds

.field public static final REASON_CODE_CONNECT_IN_PROGRESS:S = 0x7d6es

.field public static final REASON_CODE_FAILED_AUTHENTICATION:S = 0x4s

.field public static final REASON_CODE_INVALID_CLIENT_ID:S = 0x2s

.field public static final REASON_CODE_INVALID_MESSAGE:S = 0x7d6cs

.field public static final REASON_CODE_INVALID_PROTOCOL_VERSION:S = 0x1s

.field public static final REASON_CODE_MAX_INFLIGHT:S = 0x7dcas

.field public static final REASON_CODE_NOT_AUTHORIZED:S = 0x5s

.field public static final REASON_CODE_NO_MESSAGE_IDS_AVAILABLE:S = 0x7d01s

.field public static final REASON_CODE_SERVER_CONNECT_ERROR:S = 0x7d67s

.field public static final REASON_CODE_SOCKET_FACTORY_MISMATCH:S = 0x7d69s

.field public static final REASON_CODE_SSL_CONFIG_ERROR:S = 0x7d6as

.field public static final REASON_CODE_SUBSCRIBE_FAILED:S = 0x80s

.field public static final REASON_CODE_TOKEN_INUSE:S = 0x7dc9s

.field public static final REASON_CODE_UNEXPECTED_ERROR:S = 0x6s

.field public static final REASON_CODE_WRITE_TIMEOUT:S = 0x7d02s

.field private static final serialVersionUID:J = 0x12cL


# instance fields
.field private cause:Ljava/lang/Throwable;

.field private reasonCode:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "reasonCode"    # I

    .prologue
    .line 165
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 166
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    .line 167
    return-void
.end method

.method public constructor <init>(ILjava/lang/Throwable;)V
    .locals 0
    .param p1, "reason"    # I
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 187
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 188
    iput p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    .line 189
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->cause:Ljava/lang/Throwable;

    .line 190
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 175
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 176
    const/4 v0, 0x0

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    .line 177
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->cause:Ljava/lang/Throwable;

    .line 178
    return-void
.end method


# virtual methods
.method public getCause()Ljava/lang/Throwable;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->cause:Ljava/lang/Throwable;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/MessageCatalog;->getMessage(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReasonCode()I
    .locals 1

    .prologue
    .line 198
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 223
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->reasonCode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 224
    .local v0, "result":Ljava/lang/String;
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->cause:Ljava/lang/Throwable;

    if-eqz v1, :cond_0

    .line 225
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/MqttException;->cause:Ljava/lang/Throwable;

    invoke-virtual {v2}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 227
    :cond_0
    return-object v0
.end method
