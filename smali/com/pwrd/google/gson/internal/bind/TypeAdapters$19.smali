.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$19;
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
        "Ljava/net/URI;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 460
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public bridge synthetic read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$19;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/net/URI;
    .locals 5
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 463
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    sget-object v4, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v3, v4, :cond_1

    .line 464
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 469
    :cond_0
    :goto_0
    return-object v2

    .line 468
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextString()Ljava/lang/String;

    move-result-object v1

    .line 469
    .local v1, "nextString":Ljava/lang/String;
    const-string v3, "null"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v2, Ljava/net/URI;

    invoke-direct {v2, v1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 470
    .end local v1    # "nextString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 471
    .local v0, "e":Ljava/net/URISyntaxException;
    new-instance v2, Lcom/pwrd/google/gson/JsonIOException;

    invoke-direct {v2, v0}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/Throwable;)V

    throw v2
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
    check-cast p2, Ljava/net/URI;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$19;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/net/URI;)V

    return-void
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/net/URI;)V
    .locals 1
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 476
    if-nez p2, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 477
    return-void

    .line 476
    :cond_0
    invoke-virtual {p2}, Ljava/net/URI;->toASCIIString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
