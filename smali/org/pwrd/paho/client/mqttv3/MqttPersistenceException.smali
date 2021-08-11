.class public Lorg/pwrd/paho/client/mqttv3/MqttPersistenceException;
.super Lorg/pwrd/paho/client/mqttv3/MqttException;
.source "MqttPersistenceException.java"


# static fields
.field public static final REASON_CODE_PERSISTENCE_IN_USE:S = 0x7dc8s

.field private static final serialVersionUID:J = 0x12cL


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    .line 33
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "reasonCode"    # I

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(I)V

    .line 42
    return-void
.end method

.method public constructor <init>(ILjava/lang/Throwable;)V
    .locals 0
    .param p1, "reason"    # I
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(ILjava/lang/Throwable;)V

    .line 59
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/MqttException;-><init>(Ljava/lang/Throwable;)V

    .line 50
    return-void
.end method
