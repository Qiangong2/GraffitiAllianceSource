.class public final Lcom/pwrd/google/gson/JsonObject;
.super Lcom/pwrd/google/gson/JsonElement;
.source "JsonObject.java"


# instance fields
.field private final members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/internal/LinkedTreeMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/google/gson/JsonElement;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/pwrd/google/gson/JsonElement;-><init>()V

    .line 34
    new-instance v0, Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-direct {v0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;-><init>()V

    iput-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    .line 32
    return-void
.end method

.method private createJsonElement(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 122
    if-nez p1, :cond_0

    sget-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/JsonPrimitive;

    invoke-direct {v0, p1}, Lcom/pwrd/google/gson/JsonPrimitive;-><init>(Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V
    .locals 1
    .param p1, "property"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/pwrd/google/gson/JsonElement;

    .prologue
    .line 54
    if-nez p2, :cond_0

    .line 55
    sget-object p2, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    return-void
.end method

.method public addProperty(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "property"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 101
    invoke-direct {p0, p2}, Lcom/pwrd/google/gson/JsonObject;->createJsonElement(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V

    .line 102
    return-void
.end method

.method public addProperty(Ljava/lang/String;Ljava/lang/Character;)V
    .locals 1
    .param p1, "property"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Character;

    .prologue
    .line 112
    invoke-direct {p0, p2}, Lcom/pwrd/google/gson/JsonObject;->createJsonElement(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V

    .line 113
    return-void
.end method

.method public addProperty(Ljava/lang/String;Ljava/lang/Number;)V
    .locals 1
    .param p1, "property"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Number;

    .prologue
    .line 90
    invoke-direct {p0, p2}, Lcom/pwrd/google/gson/JsonObject;->createJsonElement(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V

    .line 91
    return-void
.end method

.method public addProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "property"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-direct {p0, p2}, Lcom/pwrd/google/gson/JsonObject;->createJsonElement(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V

    .line 80
    return-void
.end method

.method bridge synthetic deepCopy()Lcom/pwrd/google/gson/JsonElement;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/google/gson/JsonObject;->deepCopy()Lcom/pwrd/google/gson/JsonObject;

    move-result-object v0

    return-object v0
.end method

.method deepCopy()Lcom/pwrd/google/gson/JsonObject;
    .locals 5

    .prologue
    .line 38
    new-instance v1, Lcom/pwrd/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/pwrd/google/gson/JsonObject;-><init>()V

    .line 39
    .local v1, "result":Lcom/pwrd/google/gson/JsonObject;
    iget-object v2, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v2}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 42
    return-object v1

    .line 39
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 40
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/pwrd/google/gson/JsonElement;

    invoke-virtual {v3}, Lcom/pwrd/google/gson/JsonElement;->deepCopy()Lcom/pwrd/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/pwrd/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/pwrd/google/gson/JsonElement;)V

    goto :goto_0
.end method

.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/google/gson/JsonElement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 132
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 187
    if-eq p1, p0, :cond_1

    instance-of v0, p1, Lcom/pwrd/google/gson/JsonObject;

    if-eqz v0, :cond_0

    .line 188
    check-cast p1, Lcom/pwrd/google/gson/JsonObject;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v0, p1, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    iget-object v1, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, v1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 187
    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public get(Ljava/lang/String;)Lcom/pwrd/google/gson/JsonElement;
    .locals 1
    .param p1, "memberName"    # Ljava/lang/String;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/JsonElement;

    return-object v0
.end method

.method public getAsJsonArray(Ljava/lang/String;)Lcom/pwrd/google/gson/JsonArray;
    .locals 1
    .param p1, "memberName"    # Ljava/lang/String;

    .prologue
    .line 172
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/JsonArray;

    return-object v0
.end method

.method public getAsJsonObject(Ljava/lang/String;)Lcom/pwrd/google/gson/JsonObject;
    .locals 1
    .param p1, "memberName"    # Ljava/lang/String;

    .prologue
    .line 182
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/JsonObject;

    return-object v0
.end method

.method public getAsJsonPrimitive(Ljava/lang/String;)Lcom/pwrd/google/gson/JsonPrimitive;
    .locals 1
    .param p1, "memberName"    # Ljava/lang/String;

    .prologue
    .line 162
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/JsonPrimitive;

    return-object v0
.end method

.method public has(Ljava/lang/String;)Z
    .locals 1
    .param p1, "memberName"    # Ljava/lang/String;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->hashCode()I

    move-result v0

    return v0
.end method

.method public remove(Ljava/lang/String;)Lcom/pwrd/google/gson/JsonElement;
    .locals 1
    .param p1, "property"    # Ljava/lang/String;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/pwrd/google/gson/JsonObject;->members:Lcom/pwrd/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/internal/LinkedTreeMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/JsonElement;

    return-object v0
.end method
