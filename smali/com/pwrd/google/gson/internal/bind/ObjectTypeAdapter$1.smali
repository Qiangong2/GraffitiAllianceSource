.class Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter$1;
.super Ljava/lang/Object;
.source "ObjectTypeAdapter.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 38
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
    .local p2, "type":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    const/4 v1, 0x0

    .line 41
    invoke-virtual {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v0

    const-class v2, Ljava/lang/Object;

    if-ne v0, v2, :cond_0

    .line 42
    new-instance v0, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;

    invoke-direct {v0, p1, v1}, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;-><init>(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;)V

    .line 44
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method
