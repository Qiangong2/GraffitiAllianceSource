.class Lcom/pwrd/google/gson/internal/Excluder$1;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "Excluder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/Excluder;->create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private delegate:Lcom/pwrd/google/gson/TypeAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/pwrd/google/gson/internal/Excluder;

.field private final synthetic val$gson:Lcom/pwrd/google/gson/Gson;

.field private final synthetic val$skipDeserialize:Z

.field private final synthetic val$skipSerialize:Z

.field private final synthetic val$type:Lcom/pwrd/google/gson/reflect/TypeToken;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/internal/Excluder;ZZLcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->this$0:Lcom/pwrd/google/gson/internal/Excluder;

    iput-boolean p2, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$skipDeserialize:Z

    iput-boolean p3, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$skipSerialize:Z

    iput-object p4, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$gson:Lcom/pwrd/google/gson/Gson;

    iput-object p5, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$type:Lcom/pwrd/google/gson/reflect/TypeToken;

    .line 121
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    return-void
.end method

.method private delegate()Lcom/pwrd/google/gson/TypeAdapter;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    .line 143
    .local v0, "d":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    if-eqz v0, :cond_0

    .end local v0    # "d":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    :goto_0
    return-object v0

    .line 145
    .restart local v0    # "d":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$gson:Lcom/pwrd/google/gson/Gson;

    iget-object v2, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->this$0:Lcom/pwrd/google/gson/internal/Excluder;

    iget-object v3, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$type:Lcom/pwrd/google/gson/reflect/TypeToken;

    invoke-virtual {v1, v2, v3}, Lcom/pwrd/google/gson/Gson;->getDelegateAdapter(Lcom/pwrd/google/gson/TypeAdapterFactory;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .end local v0    # "d":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    iput-object v0, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    goto :goto_0
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/stream/JsonReader;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$skipDeserialize:Z

    if-eqz v0, :cond_0

    .line 127
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->skipValue()V

    .line 128
    const/4 v0, 0x0

    .line 130
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/pwrd/google/gson/internal/Excluder$1;->delegate()Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/TypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 1
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/stream/JsonWriter;",
            "TT;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 134
    .local p2, "value":Ljava/lang/Object;, "TT;"
    iget-boolean v0, p0, Lcom/pwrd/google/gson/internal/Excluder$1;->val$skipSerialize:Z

    if-eqz v0, :cond_0

    .line 135
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->nullValue()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 139
    :goto_0
    return-void

    .line 138
    :cond_0
    invoke-direct {p0}, Lcom/pwrd/google/gson/internal/Excluder$1;->delegate()Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V

    goto :goto_0
.end method
