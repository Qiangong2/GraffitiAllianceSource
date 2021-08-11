.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$27;
.super Ljava/lang/Object;
.source "TypeAdapters.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Lcom/pwrd/google/gson/reflect/TypeToken;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$type:Lcom/pwrd/google/gson/reflect/TypeToken;

.field private final synthetic val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/reflect/TypeToken;Lcom/pwrd/google/gson/TypeAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$27;->val$type:Lcom/pwrd/google/gson/reflect/TypeToken;

    iput-object p2, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$27;->val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    .line 770
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1
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
    .line 773
    .local p2, "typeToken":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$27;->val$type:Lcom/pwrd/google/gson/reflect/TypeToken;

    invoke-virtual {p2, v0}, Lcom/pwrd/google/gson/reflect/TypeToken;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$27;->val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
