.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;
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


# static fields
.field private static synthetic $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I


# direct methods
.method static synthetic $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken()[I
    .locals 3

    .prologue
    .line 304
    sget-object v0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/pwrd/google/gson/stream/JsonToken;->values()[Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BEGIN_ARRAY:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_9

    :goto_1
    :try_start_1
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BEGIN_OBJECT:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_8

    :goto_2
    :try_start_2
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BOOLEAN:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_7

    :goto_3
    :try_start_3
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_ARRAY:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_6

    :goto_4
    :try_start_4
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_DOCUMENT:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_5

    :goto_5
    :try_start_5
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_OBJECT:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_4

    :goto_6
    :try_start_6
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NAME:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_3

    :goto_7
    :try_start_7
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_2

    :goto_8
    :try_start_8
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NUMBER:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_1

    :goto_9
    :try_start_9
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->STRING:Lcom/pwrd/google/gson/stream/JsonToken;

    invoke-virtual {v1}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_0

    :goto_a
    sput-object v0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_a

    :catch_1
    move-exception v1

    goto :goto_9

    :catch_2
    move-exception v1

    goto :goto_8

    :catch_3
    move-exception v1

    goto :goto_7

    :catch_4
    move-exception v1

    goto :goto_6

    :catch_5
    move-exception v1

    goto :goto_5

    :catch_6
    move-exception v1

    goto :goto_4

    :catch_7
    move-exception v1

    goto :goto_3

    :catch_8
    move-exception v1

    goto :goto_2

    :catch_9
    move-exception v1

    goto :goto_1
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 304
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Number;
    .locals 4
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 307
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    .line 308
    .local v0, "jsonToken":Lcom/pwrd/google/gson/stream/JsonToken;
    invoke-static {}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken()[I

    move-result-object v1

    invoke-virtual {v0}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 315
    :pswitch_0
    new-instance v1, Lcom/pwrd/google/gson/JsonSyntaxException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expecting number, got: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/pwrd/google/gson/JsonSyntaxException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 310
    :pswitch_1
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 311
    const/4 v1, 0x0

    .line 313
    :goto_0
    return-object v1

    :pswitch_2
    new-instance v1, Lcom/pwrd/google/gson/internal/LazilyParsedNumber;

    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/pwrd/google/gson/internal/LazilyParsedNumber;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 308
    nop

    :pswitch_data_0
    .packed-switch 0x7
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
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
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Number;

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
    .line 320
    invoke-virtual {p1, p2}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(Ljava/lang/Number;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 321
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

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$11;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Number;)V

    return-void
.end method
