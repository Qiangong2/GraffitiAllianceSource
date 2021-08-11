.class Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet$1;
.super Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;
.source "LinkedHashTreeMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet;->iterator()Ljava/util/Iterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap",
        "<TK;TV;>.",
        "LinkedTreeMapIterator",
        "<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet;Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;)V
    .locals 1

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet$1;->this$1:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet;

    .line 797
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;-><init>(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet$1;->next()Ljava/util/Map$Entry;

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
    .line 799
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$EntrySet$1;->nextNode()Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    move-result-object v0

    return-object v0
.end method
