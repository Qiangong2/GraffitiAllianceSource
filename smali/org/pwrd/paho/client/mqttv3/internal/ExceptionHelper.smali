.class public Lorg/pwrd/paho/client/mqttv3/internal/ExceptionHelper;
.super Ljava/lang/Object;
.source "ExceptionHelper.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    return-void
.end method

.method public static createMqttException(I)Lorg/pwrd/paho/client/mqttv3/MqttException;
    .locals 1
    .param p0, "reasonCode"    # I

    .prologue
    .line 26
    const/4 v0, 0x4

    if-eq p0, v0, :cond_0

    .line 27
    const/4 v0, 0x5

    if-ne p0, v0, :cond_1

    .line 28
    :cond_0
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    invoke-direct {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(I)V

    .line 31
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    goto :goto_0
.end method

.method public static createMqttException(Ljava/lang/Throwable;)Lorg/pwrd/paho/client/mqttv3/MqttException;
    .locals 2
    .param p0, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 35
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "java.security.GeneralSecurityException"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 36
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    invoke-direct {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    .line 38
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lorg/pwrd/paho/client/mqttv3/MqttException;

    invoke-direct {v0, p0}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static isClassAvailable(Ljava/lang/String;)Z
    .locals 2
    .param p0, "className"    # Ljava/lang/String;

    .prologue
    .line 47
    const/4 v0, 0x0

    .line 49
    .local v0, "result":Z
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 50
    const/4 v0, 0x1

    .line 54
    :goto_0
    return v0

    .line 52
    :catch_0
    move-exception v1

    goto :goto_0
.end method
