.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$10;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "TypeAdapters.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<",
        "Ljava/lang/Number;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 289
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Number;
    .locals 2
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 292
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_0

    .line 293
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 294
    const/4 v0, 0x0

    .line 296
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextDouble()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$10;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Number;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Number;)V
    .locals 0
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/lang/Number;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 300
    invoke-virtual {p1, p2}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(Ljava/lang/Number;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 301
    return-void
.end method

.method public bridge synthetic write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1
    check-cast p2, Ljava/lang/Number;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$10;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Number;)V

    return-void
.end method