.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;
.super Ljava/lang/Object;
.source "TypeAdapters.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$boxed:Ljava/lang/Class;

.field private final synthetic val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

.field private final synthetic val$unboxed:Ljava/lang/Class;


# direct methods
.method constructor <init>(Ljava/lang/Class;Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$unboxed:Ljava/lang/Class;

    iput-object p2, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$boxed:Ljava/lang/Class;

    iput-object p3, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    .line 793
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 2
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
    .line 796
    .local p2, "typeToken":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    invoke-virtual {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v0

    .line 797
    .local v0, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<-TT;>;"
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$unboxed:Ljava/lang/Class;

    if-eq v0, v1, :cond_0

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$boxed:Ljava/lang/Class;

    if-ne v0, v1, :cond_1

    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 800
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Factory[type="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$boxed:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 801
    const-string v1, "+"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$unboxed:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",adapter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$29;->val$typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 800
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method