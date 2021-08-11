.class public Lorg/pwrd/paho/client/mqttv3/MqttTopic;
.super Ljava/lang/Object;
.source "MqttTopic.java"


# static fields
.field private static final MAX_TOPIC_LEN:I = 0xffff

.field private static final MIN_TOPIC_LEN:I = 0x1

.field public static final MULTI_LEVEL_WILDCARD:Ljava/lang/String; = "#"

.field public static final MULTI_LEVEL_WILDCARD_PATTERN:Ljava/lang/String; = "/#"

.field private static final NUL:C = '\u0000'

.field public static final SINGLE_LEVEL_WILDCARD:Ljava/lang/String; = "+"

.field public static final TOPIC_LEVEL_SEPARATOR:Ljava/lang/String; = "/"

.field public static final TOPIC_WILDCARDS:Ljava/lang/String; = "#+"


# instance fields
.field private comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "comms"    # Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    .line 70
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->name:Ljava/lang/String;

    .line 71
    return-void
.end method

.method private createPublish(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;
    .locals 2
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    .prologue
    .line 126
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;-><init>(Ljava/lang/String;Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    return-object v0
.end method

.method public static validate(Ljava/lang/String;Z)V
    .locals 9
    .param p0, "topicString"    # Ljava/lang/String;
    .param p1, "wildcardAllowed"    # Z

    .prologue
    const v8, 0xffff

    const/4 v4, 0x2

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 145
    const/4 v1, 0x0

    .line 147
    .local v1, "topicLen":I
    :try_start_0
    const-string v2, "UTF-8"

    invoke-virtual {p0, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    array-length v1, v2
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    if-lt v1, v6, :cond_0

    if-le v1, v8, :cond_1

    .line 158
    :cond_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Invalid topic length, should be in range[%d, %d]!"

    .line 159
    new-array v4, v4, [Ljava/lang/Object;

    new-instance v5, Ljava/lang/Integer;

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    aput-object v5, v4, v7

    new-instance v5, Ljava/lang/Integer;

    invoke-direct {v5, v8}, Ljava/lang/Integer;-><init>(I)V

    aput-object v5, v4, v6

    .line 158
    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 148
    :catch_0
    move-exception v0

    .line 149
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 165
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    if-eqz p1, :cond_6

    .line 167
    new-array v2, v4, [Ljava/lang/String;

    const-string v3, "#"

    aput-object v3, v2, v7

    const-string v3, "+"

    aput-object v3, v2, v6

    invoke-static {p0, v2}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->equalsAny(Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 206
    :cond_2
    :goto_0
    return-void

    .line 179
    :cond_3
    const-string v2, "#"

    invoke-static {p0, v2}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->countMatches(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I

    move-result v2

    if-gt v2, v6, :cond_4

    .line 180
    const-string v2, "#"

    invoke-virtual {p0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 181
    const-string v2, "/#"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 182
    :cond_4
    new-instance v2, Ljava/lang/IllegalArgumentException;

    .line 183
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Invalid usage of multi-level wildcard in topic string: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 184
    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 183
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 182
    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 194
    :cond_5
    invoke-static {p0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->validateSingleLevelWildcard(Ljava/lang/String;)V

    goto :goto_0

    .line 202
    :cond_6
    const-string v2, "#+"

    invoke-static {p0, v2}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->containsAny(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 203
    new-instance v2, Ljava/lang/IllegalArgumentException;

    .line 204
    const-string v3, "The topic name MUST NOT contain any wildcard characters (#+)"

    .line 203
    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private static validateSingleLevelWildcard(Ljava/lang/String;)V
    .locals 11
    .param p0, "topicString"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 209
    const-string v8, "+"

    invoke-virtual {v8, v7}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 210
    .local v5, "singleLevelWildcardChar":C
    const-string v8, "/"

    invoke-virtual {v8, v7}, Ljava/lang/String;->charAt(I)C

    move-result v6

    .line 212
    .local v6, "topicLevelSeparatorChar":C
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 213
    .local v0, "chars":[C
    array-length v2, v0

    .line 214
    .local v2, "length":I
    const/4 v4, 0x0

    .local v4, "prev":C
    const/4 v3, 0x0

    .line 215
    .local v3, "next":C
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v2, :cond_0

    .line 228
    return-void

    .line 216
    :cond_0
    add-int/lit8 v8, v1, -0x1

    if-ltz v8, :cond_3

    add-int/lit8 v8, v1, -0x1

    aget-char v4, v0, v8

    .line 217
    :goto_1
    add-int/lit8 v8, v1, 0x1

    if-ge v8, v2, :cond_4

    add-int/lit8 v8, v1, 0x1

    aget-char v3, v0, v8

    .line 219
    :goto_2
    aget-char v8, v0, v1

    if-ne v8, v5, :cond_5

    .line 221
    if-eq v4, v6, :cond_1

    if-nez v4, :cond_2

    :cond_1
    if-eq v3, v6, :cond_5

    if-eqz v3, :cond_5

    .line 222
    :cond_2
    new-instance v8, Ljava/lang/IllegalArgumentException;

    .line 223
    const-string v9, "Invalid usage of single-level wildcard in topic string \'%s\'!"

    .line 224
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    aput-object p0, v10, v7

    .line 222
    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v8, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    :cond_3
    move v4, v7

    .line 216
    goto :goto_1

    :cond_4
    move v3, v7

    .line 217
    goto :goto_2

    .line 215
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->name:Ljava/lang/String;

    return-object v0
.end method

.method public publish(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .locals 3
    .param p1, "message"    # Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 106
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->getClient()Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;

    move-result-object v1

    invoke-interface {v1}, Lorg/pwrd/paho/client/mqttv3/IMqttAsyncClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;-><init>(Ljava/lang/String;)V

    .line 107
    .local v0, "token":Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    invoke-virtual {v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->setMessage(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)V

    .line 108
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->comms:Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->createPublish(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttPublish;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lorg/pwrd/paho/client/mqttv3/internal/ClientComms;->sendNoWait(Lorg/pwrd/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/pwrd/paho/client/mqttv3/MqttToken;)V

    .line 109
    iget-object v1, v0, Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;->internalTok:Lorg/pwrd/paho/client/mqttv3/internal/Token;

    invoke-virtual {v1}, Lorg/pwrd/paho/client/mqttv3/internal/Token;->waitUntilSent()V

    .line 110
    return-object v0
.end method

.method public publish([BIZ)Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;
    .locals 2
    .param p1, "payload"    # [B
    .param p2, "qos"    # I
    .param p3, "retained"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttException;,
            Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
        }
    .end annotation

    .prologue
    .line 88
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttMessage;

    invoke-direct {v0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;-><init>([B)V

    .line 89
    .local v0, "message":Lorg/pwrd/paho/client/mqttv3/MqttMessage;
    invoke-virtual {v0, p2}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setQos(I)V

    .line 90
    invoke-virtual {v0, p3}, Lorg/pwrd/paho/client/mqttv3/MqttMessage;->setRetained(Z)V

    .line 91
    invoke-virtual {p0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->publish(Lorg/pwrd/paho/client/mqttv3/MqttMessage;)Lorg/pwrd/paho/client/mqttv3/MqttDeliveryToken;

    move-result-object v1

    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    invoke-virtual {p0}, Lorg/pwrd/paho/client/mqttv3/MqttTopic;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
