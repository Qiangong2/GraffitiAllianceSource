.class public final Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "ObjectTypeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I

.field public static final FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;


# instance fields
.field private final gson:Lcom/pwrd/google/gson/Gson;


# direct methods
.method static synthetic $SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken()[I
    .locals 3

    .prologue
    .line 37
    sget-object v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I

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
    sput-object v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken:[I

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

.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter$1;

    invoke-direct {v0}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter$1;-><init>()V

    sput-object v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    .line 46
    return-void
.end method

.method private constructor <init>(Lcom/pwrd/google/gson/Gson;)V
    .locals 0
    .param p1, "gson"    # Lcom/pwrd/google/gson/Gson;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->gson:Lcom/pwrd/google/gson/Gson;

    .line 52
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;-><init>(Lcom/pwrd/google/gson/Gson;)V

    return-void
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 6
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 55
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v2

    .line 56
    .local v2, "token":Lcom/pwrd/google/gson/stream/JsonToken;
    invoke-static {}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->$SWITCH_TABLE$com$pwrd$google$gson$stream$JsonToken()[I

    move-result-object v3

    invoke-virtual {v2}, Lcom/pwrd/google/gson/stream/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 89
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3}, Ljava/lang/IllegalStateException;-><init>()V

    throw v3

    .line 58
    :pswitch_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 59
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->beginArray()V

    .line 60
    :goto_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 63
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->endArray()V

    .line 86
    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    :goto_1
    return-object v0

    .line 61
    .restart local v0    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    :cond_0
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 67
    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    :pswitch_2
    new-instance v1, Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-direct {v1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;-><init>()V

    .line 68
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->beginObject()V

    .line 69
    :goto_2
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 72
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->endObject()V

    move-object v0, v1

    .line 73
    goto :goto_1

    .line 70
    :cond_1
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 76
    .end local v1    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :pswitch_3
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 79
    :pswitch_4
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextDouble()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_1

    .line 82
    :pswitch_5
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextBoolean()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_1

    .line 85
    :pswitch_6
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 86
    const/4 v0, 0x0

    goto :goto_1

    .line 56
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 3
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    if-nez p2, :cond_0

    .line 96
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->nullValue()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 108
    :goto_0
    return-void

    .line 100
    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->gson:Lcom/pwrd/google/gson/Gson;

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/pwrd/google/gson/Gson;->getAdapter(Ljava/lang/Class;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .line 101
    .local v0, "typeAdapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<Ljava/lang/Object;>;"
    instance-of v1, v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;

    if-eqz v1, :cond_1

    .line 102
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->beginObject()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 103
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->endObject()Lcom/pwrd/google/gson/stream/JsonWriter;

    goto :goto_0

    .line 107
    :cond_1
    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V

    goto :goto_0
.end method
