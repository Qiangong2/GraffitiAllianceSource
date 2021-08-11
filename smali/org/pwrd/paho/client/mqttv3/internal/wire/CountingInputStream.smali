.class public Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;
.super Ljava/io/InputStream;
.source "CountingInputStream.java"


# instance fields
.field private counter:I

.field private in:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 1
    .param p1, "in"    # Ljava/io/InputStream;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 33
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->in:Ljava/io/InputStream;

    .line 34
    const/4 v0, 0x0

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->counter:I

    .line 35
    return-void
.end method


# virtual methods
.method public getCounter()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->counter:I

    return v0
.end method

.method public read()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 38
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->in:Ljava/io/InputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 39
    .local v0, "i":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 40
    iget v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->counter:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->counter:I

    .line 42
    :cond_0
    return v0
.end method

.method public resetCounter()V
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    iput v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/wire/CountingInputStream;->counter:I

    .line 57
    return-void
.end method
