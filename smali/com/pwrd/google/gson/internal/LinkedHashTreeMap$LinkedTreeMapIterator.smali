.class abstract Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;
.super Ljava/lang/Object;
.source "LinkedHashTreeMap.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "LinkedTreeMapIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Iterator",
        "<TT;>;"
    }
.end annotation


# instance fields
.field expectedModCount:I

.field lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node",
            "<TK;TV;>;"
        }
    .end annotation
.end field

.field next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node",
            "<TK;TV;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;


# direct methods
.method private constructor <init>(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;)V
    .locals 1

    .prologue
    .line 760
    .local p0, "this":Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;, "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap<TK;TV;>.LinkedTreeMapIterator<TT;>;"
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 761
    iget-object v0, p1, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->header:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    iget-object v0, v0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    .line 762
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    .line 763
    iget v0, p1, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->modCount:I

    iput v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->expectedModCount:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;)V
    .locals 0

    .prologue
    .line 760
    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;-><init>(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;)V

    return-void
.end method


# virtual methods
.method public final hasNext()Z
    .locals 2

    .prologue
    .line 766
    .local p0, "this":Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;, "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap<TK;TV;>.LinkedTreeMapIterator<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    iget-object v1, v1, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->header:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final nextNode()Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 770
    .local p0, "this":Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;, "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap<TK;TV;>.LinkedTreeMapIterator<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    .line 771
    .local v0, "e":Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;, "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node<TK;TV;>;"
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    iget-object v1, v1, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->header:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    if-ne v0, v1, :cond_0

    .line 772
    new-instance v1, Ljava/util/NoSuchElementException;

    invoke-direct {v1}, Ljava/util/NoSuchElementException;-><init>()V

    throw v1

    .line 774
    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    iget v1, v1, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->modCount:I

    iget v2, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->expectedModCount:I

    if-eq v1, v2, :cond_1

    .line 775
    new-instance v1, Ljava/util/ConcurrentModificationException;

    invoke-direct {v1}, Ljava/util/ConcurrentModificationException;-><init>()V

    throw v1

    .line 777
    :cond_1
    iget-object v1, v0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    iput-object v1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->next:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    .line 778
    iput-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    return-object v0
.end method

.method public final remove()V
    .locals 3

    .prologue
    .line 782
    .local p0, "this":Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;, "Lcom/pwrd/google/gson/internal/LinkedHashTreeMap<TK;TV;>.LinkedTreeMapIterator<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    if-nez v0, :cond_0

    .line 783
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 785
    :cond_0
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->removeInternal(Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;Z)V

    .line 786
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->lastReturned:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$Node;

    .line 787
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->this$0:Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;

    iget v0, v0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap;->modCount:I

    iput v0, p0, Lcom/pwrd/google/gson/internal/LinkedHashTreeMap$LinkedTreeMapIterator;->expectedModCount:I

    .line 788
    return-void
.end method