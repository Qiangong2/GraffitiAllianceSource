.class public final Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;
.super Ljava/lang/Object;
.source "ReflectiveTypeAdapterFactory.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;,
        Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
    }
.end annotation


# instance fields
.field private final constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

.field private final excluder:Lcom/pwrd/google/gson/internal/Excluder;

.field private final fieldNamingPolicy:Lcom/pwrd/google/gson/FieldNamingStrategy;


# direct methods
.method public constructor <init>(Lcom/pwrd/google/gson/internal/ConstructorConstructor;Lcom/pwrd/google/gson/FieldNamingStrategy;Lcom/pwrd/google/gson/internal/Excluder;)V
    .locals 0
    .param p1, "constructorConstructor"    # Lcom/pwrd/google/gson/internal/ConstructorConstructor;
    .param p2, "fieldNamingPolicy"    # Lcom/pwrd/google/gson/FieldNamingStrategy;
    .param p3, "excluder"    # Lcom/pwrd/google/gson/internal/Excluder;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    .line 57
    iput-object p2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->fieldNamingPolicy:Lcom/pwrd/google/gson/FieldNamingStrategy;

    .line 58
    iput-object p3, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->excluder:Lcom/pwrd/google/gson/internal/Excluder;

    .line 59
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1

    .prologue
    .line 130
    invoke-direct {p0, p1, p2, p3}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->getFieldAdapter(Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    return-object v0
.end method

.method private createBoundField(Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;ZZ)Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
    .locals 9
    .param p1, "context"    # Lcom/pwrd/google/gson/Gson;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .param p3, "name"    # Ljava/lang/String;
    .param p5, "serialize"    # Z
    .param p6, "deserialize"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/Gson;",
            "Ljava/lang/reflect/Field;",
            "Ljava/lang/String;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<*>;ZZ)",
            "Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;"
        }
    .end annotation

    .prologue
    .line 103
    .local p4, "fieldType":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<*>;"
    invoke-virtual {p4}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/pwrd/google/gson/internal/Primitives;->isPrimitive(Ljava/lang/reflect/Type;)Z

    move-result v8

    .line 105
    .local v8, "isPrimitive":Z
    new-instance v0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;

    move-object v1, p0

    move-object v2, p3

    move v3, p5

    move v4, p6

    move-object v5, p1

    move-object v6, p2

    move-object v7, p4

    invoke-direct/range {v0 .. v8}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;-><init>(Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;Ljava/lang/String;ZZLcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;Z)V

    return-object v0
.end method

.method static excludeField(Ljava/lang/reflect/Field;ZLcom/pwrd/google/gson/internal/Excluder;)Z
    .locals 1
    .param p0, "f"    # Ljava/lang/reflect/Field;
    .param p1, "serialize"    # Z
    .param p2, "excluder"    # Lcom/pwrd/google/gson/internal/Excluder;

    .prologue
    .line 66
    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p2, v0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->excludeClass(Ljava/lang/Class;Z)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p2, p0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->excludeField(Ljava/lang/reflect/Field;Z)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getBoundFields(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;Ljava/lang/Class;)Ljava/util/Map;
    .locals 20
    .param p1, "context"    # Lcom/pwrd/google/gson/Gson;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/Gson;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 140
    .local p2, "type":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<*>;"
    .local p3, "raw":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v17, Ljava/util/LinkedHashMap;

    invoke-direct/range {v17 .. v17}, Ljava/util/LinkedHashMap;-><init>()V

    .line 141
    .local v17, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;>;"
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Class;->isInterface()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 174
    :cond_0
    return-object v17

    .line 145
    :cond_1
    invoke-virtual/range {p2 .. p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v10

    .line 146
    .local v10, "declaredType":Ljava/lang/reflect/Type;
    :goto_0
    const-class v2, Ljava/lang/Object;

    move-object/from16 v0, p3

    if-eq v0, v2, :cond_0

    .line 147
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v13

    .line 148
    .local v13, "fields":[Ljava/lang/reflect/Field;
    array-length v0, v13

    move/from16 v19, v0

    const/4 v2, 0x0

    move/from16 v18, v2

    :goto_1
    move/from16 v0, v18

    move/from16 v1, v19

    if-lt v0, v1, :cond_2

    .line 171
    invoke-virtual/range {p2 .. p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-virtual/range {p3 .. p3}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-static {v2, v0, v3}, Lcom/pwrd/google/gson/internal/$Gson$Types;->resolve(Ljava/lang/reflect/Type;Ljava/lang/Class;Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-static {v2}, Lcom/pwrd/google/gson/reflect/TypeToken;->get(Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/reflect/TypeToken;

    move-result-object p2

    .line 172
    invoke-virtual/range {p2 .. p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object p3

    goto :goto_0

    .line 148
    :cond_2
    aget-object v4, v13, v18

    .line 149
    .local v4, "field":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v2}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->excludeField(Ljava/lang/reflect/Field;Z)Z

    move-result v7

    .line 150
    .local v7, "serialize":Z
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v2}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->excludeField(Ljava/lang/reflect/Field;Z)Z

    move-result v8

    .line 151
    .local v8, "deserialize":Z
    if-nez v7, :cond_4

    if-nez v8, :cond_4

    .line 148
    :cond_3
    add-int/lit8 v2, v18, 0x1

    move/from16 v18, v2

    goto :goto_1

    .line 154
    :cond_4
    const/4 v2, 0x1

    invoke-virtual {v4, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 155
    invoke-virtual/range {p2 .. p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getGenericType()Ljava/lang/reflect/Type;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-static {v2, v0, v3}, Lcom/pwrd/google/gson/internal/$Gson$Types;->resolve(Ljava/lang/reflect/Type;Ljava/lang/Class;Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;

    move-result-object v12

    .line 156
    .local v12, "fieldType":Ljava/lang/reflect/Type;
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->getFieldNames(Ljava/lang/reflect/Field;)Ljava/util/List;

    move-result-object v11

    .line 157
    .local v11, "fieldNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v15, 0x0

    .line 158
    .local v15, "previous":Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_2
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v2

    if-lt v14, v2, :cond_5

    .line 166
    if-eqz v15, :cond_3

    .line 167
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 168
    const-string v6, " declares multiple JSON fields named "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v6, v15, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;->name:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 167
    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 159
    :cond_5
    invoke-interface {v11, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 160
    .local v5, "name":Ljava/lang/String;
    if-eqz v14, :cond_6

    const/4 v7, 0x0

    .line 162
    :cond_6
    invoke-static {v12}, Lcom/pwrd/google/gson/reflect/TypeToken;->get(Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/reflect/TypeToken;

    move-result-object v6

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    .line 161
    invoke-direct/range {v2 .. v8}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->createBoundField(Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;ZZ)Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;

    move-result-object v9

    .line 163
    .local v9, "boundField":Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
    move-object/from16 v0, v17

    invoke-interface {v0, v5, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;

    .line 164
    .local v16, "replaced":Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
    if-nez v15, :cond_7

    move-object/from16 v15, v16

    .line 158
    :cond_7
    add-int/lit8 v14, v14, 0x1

    goto :goto_2
.end method

.method private getFieldAdapter(Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 3
    .param p1, "gson"    # Lcom/pwrd/google/gson/Gson;
    .param p2, "field"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/Gson;",
            "Ljava/lang/reflect/Field;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<*>;)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 131
    .local p3, "fieldType":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<*>;"
    const-class v2, Lcom/pwrd/google/gson/annotations/JsonAdapter;

    invoke-virtual {p2, v2}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v1

    check-cast v1, Lcom/pwrd/google/gson/annotations/JsonAdapter;

    .line 132
    .local v1, "annotation":Lcom/pwrd/google/gson/annotations/JsonAdapter;
    if-eqz v1, :cond_0

    .line 133
    iget-object v2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-static {v2, p1, p3, v1}, Lcom/pwrd/google/gson/internal/bind/JsonAdapterAnnotationTypeAdapterFactory;->getTypeAdapter(Lcom/pwrd/google/gson/internal/ConstructorConstructor;Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;Lcom/pwrd/google/gson/annotations/JsonAdapter;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .line 134
    .local v0, "adapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    if-eqz v0, :cond_0

    .line 136
    .end local v0    # "adapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, p3}, Lcom/pwrd/google/gson/Gson;->getAdapter(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    goto :goto_0
.end method

.method static getFieldName(Lcom/pwrd/google/gson/FieldNamingStrategy;Ljava/lang/reflect/Field;)Ljava/util/List;
    .locals 6
    .param p0, "fieldNamingPolicy"    # Lcom/pwrd/google/gson/FieldNamingStrategy;
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/FieldNamingStrategy;",
            "Ljava/lang/reflect/Field;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    const-class v3, Lcom/pwrd/google/gson/annotations/SerializedName;

    invoke-virtual {p1, v3}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v2

    check-cast v2, Lcom/pwrd/google/gson/annotations/SerializedName;

    .line 77
    .local v2, "serializedName":Lcom/pwrd/google/gson/annotations/SerializedName;
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 78
    .local v1, "fieldNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v2, :cond_1

    .line 79
    invoke-interface {p0, p1}, Lcom/pwrd/google/gson/FieldNamingStrategy;->translateName(Ljava/lang/reflect/Field;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    :cond_0
    return-object v1

    .line 81
    :cond_1
    invoke-interface {v2}, Lcom/pwrd/google/gson/annotations/SerializedName;->value()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 82
    invoke-interface {v2}, Lcom/pwrd/google/gson/annotations/SerializedName;->alternate()[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v0, v4, v3

    .line 83
    .local v0, "alternate":Ljava/lang/String;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 82
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method private getFieldNames(Ljava/lang/reflect/Field;)Ljava/util/List;
    .locals 1
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Field;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->fieldNamingPolicy:Lcom/pwrd/google/gson/FieldNamingStrategy;

    invoke-static {v0, p1}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->getFieldName(Lcom/pwrd/google/gson/FieldNamingStrategy;Ljava/lang/reflect/Field;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 5
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
    const/4 v2, 0x0

    .line 90
    invoke-virtual {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v1

    .line 92
    .local v1, "raw":Ljava/lang/Class;, "Ljava/lang/Class<-TT;>;"
    const-class v3, Ljava/lang/Object;

    invoke-virtual {v3, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 97
    :goto_0
    return-object v2

    .line 96
    :cond_0
    iget-object v3, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-virtual {v3, p2}, Lcom/pwrd/google/gson/internal/ConstructorConstructor;->get(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/internal/ObjectConstructor;

    move-result-object v0

    .line 97
    .local v0, "constructor":Lcom/pwrd/google/gson/internal/ObjectConstructor;, "Lcom/pwrd/google/gson/internal/ObjectConstructor<TT;>;"
    new-instance v3, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;

    invoke-direct {p0, p1, p2, v1}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->getBoundFields(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;Ljava/lang/Class;)Ljava/util/Map;

    move-result-object v4

    invoke-direct {v3, v0, v4, v2}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;-><init>(Lcom/pwrd/google/gson/internal/ObjectConstructor;Ljava/util/Map;Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$Adapter;)V

    move-object v2, v3

    goto :goto_0
.end method

.method public excludeField(Ljava/lang/reflect/Field;Z)Z
    .locals 1
    .param p1, "f"    # Ljava/lang/reflect/Field;
    .param p2, "serialize"    # Z

    .prologue
    .line 62
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->excluder:Lcom/pwrd/google/gson/internal/Excluder;

    invoke-static {p1, p2, v0}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->excludeField(Ljava/lang/reflect/Field;ZLcom/pwrd/google/gson/internal/Excluder;)Z

    move-result v0

    return v0
.end method
