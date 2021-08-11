.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;
.super Ljava/lang/Object;
.source "MultiByteInteger.java"


# instance fields
.field private length:I

.field private value:J


# direct methods
.method public constructor <init>(J)V
    .locals 1
    .param p1, "value"    # J

    .prologue
    .line 27
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0}, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;-><init>(JI)V

    .line 28
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 1
    .param p1, "value"    # J
    .param p3, "length"    # I

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-wide p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;->value:J

    .line 32
    iput p3, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;->length:I

    .line 33
    return-void
.end method


# virtual methods
.method public getEncodedLength()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;->length:I

    return v0
.end method

.method public getValue()J
    .locals 2

    .prologue
    .line 46
    iget-wide v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/MultiByteInteger;->value:J

    return-wide v0
.end method
