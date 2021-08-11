.class Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet$1;
.super Lcom/pwrd/google/gson/internal/LinkedTreeMap$LinkedTreeMapIterator;
.source "LinkedTreeMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet;->iterator()Ljava/util/Iterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/internal/LinkedTreeMap",
        "<TK;TV;>.",
        "LinkedTreeMapIterator",
        "<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet;Lcom/pwrd/google/gson/internal/LinkedTreeMap;)V
    .locals 1

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet$1;->this$1:Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet;

    .line 563
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap$LinkedTreeMapIterator;-><init>(Lcom/pwrd/google/gson/internal/LinkedTreeMap;Lcom/pwrd/google/gson/internal/LinkedTreeMap$LinkedTreeMapIterator;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet$1;->next()Ljava/util/Map$Entry;

    move-result-object v0

    return-object v0
.end method

.method public next()Ljava/util/Map$Entry;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 565
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap$EntrySet$1;->nextNode()Lcom/pwrd/google/gson/internal/LinkedTreeMap$Node;

    move-result-object v0

    return-object v0
.end method
