.class public Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
.super Lorg/pwrd/paho/client/mqttv3/MqttException;
.source "MqttSecurityException.java"


# static fields
.field private static final serialVersionUID:J = 0x12cL


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "reasonCode"    # I

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    .line 32
    return-void
.end method

.method public constructor <init>(ILjava/lang/Throwable;)V
    .locals 0
    .param p1, "reasonCode"    # I
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    .line 50
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    .line 41
    return-void
.end method
