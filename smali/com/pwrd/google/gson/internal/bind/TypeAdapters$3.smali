.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$3;
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
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 145
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Boolean;
    .locals 2
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 148
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_0

    .line 149
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 150
    const/4 v0, 0x0

    .line 155
    :goto_0
    return-object v0

    .line 151
    :cond_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->STRING:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_1

    .line 153
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    .line 155
    :cond_1
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextBoolean()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

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
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$3;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 159
    if-nez p2, :cond_0

    .line 160
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->nullValue()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 164
    :goto_0
    return-void

    .line 163
    :cond_0
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(Z)Lcom/pwrd/google/gson/stream/JsonWriter;

    goto :goto_0
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
    check-cast p2, Ljava/lang/Boolean;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$3;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Boolean;)V

    return-void
.end method
