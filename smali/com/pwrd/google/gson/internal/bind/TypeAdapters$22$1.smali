.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "TypeAdapters.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;->create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<",
        "Ljava/sql/Timestamp;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;

.field private final synthetic val$dateTypeAdapter:Lcom/pwrd/google/gson/TypeAdapter;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;Lcom/pwrd/google/gson/TypeAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->this$1:Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;

    iput-object p2, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->val$dateTypeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    .line 526
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

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
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/sql/Timestamp;

    move-result-object v0

    return-object v0
.end method

.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/sql/Timestamp;
    .locals 4
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 528
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->val$dateTypeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v1, p1}, Lcom/pwrd/google/gson/TypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Date;

    .line 529
    .local v0, "date":Ljava/util/Date;
    if-eqz v0, :cond_0

    new-instance v1, Ljava/sql/Timestamp;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/sql/Timestamp;-><init>(J)V

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

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
    check-cast p2, Ljava/sql/Timestamp;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/sql/Timestamp;)V

    return-void
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/sql/Timestamp;)V
    .locals 1
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/sql/Timestamp;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 533
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;->val$dateTypeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V

    .line 534
    return-void
.end method