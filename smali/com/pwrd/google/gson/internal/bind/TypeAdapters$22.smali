.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;
.super Ljava/lang/Object;
.source "TypeAdapters.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 518
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 3
    .param p1, "gson"    # Lcom/pwrd/google/gson/Gson;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/Gson;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<TT;>;)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 521
    .local p2, "typeToken":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    invoke-virtual {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Ljava/sql/Timestamp;

    if-eq v1, v2, :cond_0

    .line 522
    const/4 v1, 0x0

    .line 526
    :goto_0
    return-object v1

    .line 525
    :cond_0
    const-class v1, Ljava/util/Date;

    invoke-virtual {p1, v1}, Lcom/pwrd/google/gson/Gson;->getAdapter(Ljava/lang/Class;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .line 526
    .local v0, "dateTypeAdapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<Ljava/util/Date;>;"
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;

    invoke-direct {v1, p0, v0}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22$1;-><init>(Lcom/pwrd/google/gson/internal/bind/TypeAdapters$22;Lcom/pwrd/google/gson/TypeAdapter;)V

    goto :goto_0
.end method
