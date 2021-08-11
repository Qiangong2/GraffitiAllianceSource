.class public Lcom/j256/ormlite/field/DataPersisterManager;
.super Ljava/lang/Object;
.source "DataPersisterManager.java"


# static fields
.field private static final DEFAULT_ENUM_PERSISTER:Lcom/j256/ormlite/field/DataPersister;

.field private static final builtInMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/j256/ormlite/field/DataPersister;",
            ">;"
        }
    .end annotation
.end field

.field private static registeredPersisters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/j256/ormlite/field/DataPersister;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 14

    .prologue
    const/4 v6, 0x0

    .line 20
    invoke-static {}, Lcom/j256/ormlite/field/types/EnumStringType;->getSingleton()Lcom/j256/ormlite/field/types/EnumStringType;

    move-result-object v5

    sput-object v5, Lcom/j256/ormlite/field/DataPersisterManager;->DEFAULT_ENUM_PERSISTER:Lcom/j256/ormlite/field/DataPersister;

    .line 23
    const/4 v5, 0x0

    sput-object v5, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    .line 27
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    sput-object v5, Lcom/j256/ormlite/field/DataPersisterManager;->builtInMap:Ljava/util/Map;

    .line 28
    invoke-static {}, Lcom/j256/ormlite/field/DataType;->values()[Lcom/j256/ormlite/field/DataType;

    move-result-object v8

    array-length v9, v8

    move v7, v6

    .local v3, "dataType":Lcom/j256/ormlite/field/DataType;
    .local v4, "persister":Lcom/j256/ormlite/field/DataPersister;
    :goto_0
    if-lt v7, v9, :cond_0

    .line 42
    return-void

    .line 28
    :cond_0
    aget-object v3, v8, v7

    .line 29
    invoke-virtual {v3}, Lcom/j256/ormlite/field/DataType;->getDataPersister()Lcom/j256/ormlite/field/DataPersister;

    .end local v4    # "persister":Lcom/j256/ormlite/field/DataPersister;
    move-result-object v4

    .line 30
    .restart local v4    # "persister":Lcom/j256/ormlite/field/DataPersister;
    if-eqz v4, :cond_1

    .line 31
    invoke-interface {v4}, Lcom/j256/ormlite/field/DataPersister;->getAssociatedClasses()[Ljava/lang/Class;

    move-result-object v10

    array-length v11, v10

    move v5, v6

    :goto_1
    if-lt v5, v11, :cond_2

    .line 34
    invoke-interface {v4}, Lcom/j256/ormlite/field/DataPersister;->getAssociatedClassNames()[Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, "associatedClassNames":[Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 36
    invoke-interface {v4}, Lcom/j256/ormlite/field/DataPersister;->getAssociatedClassNames()[Ljava/lang/String;

    move-result-object v10

    array-length v11, v10

    move v5, v6

    :goto_2
    if-lt v5, v11, :cond_3

    .line 28
    .end local v0    # "associatedClassNames":[Ljava/lang/String;
    :cond_1
    add-int/lit8 v5, v7, 0x1

    move v7, v5

    goto :goto_0

    .line 31
    :cond_2
    aget-object v2, v10, v5

    .line 32
    .local v2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v12, Lcom/j256/ormlite/field/DataPersisterManager;->builtInMap:Ljava/util/Map;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v12, v13, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 36
    .end local v2    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v0    # "associatedClassNames":[Ljava/lang/String;
    :cond_3
    aget-object v1, v10, v5

    .line 37
    .local v1, "className":Ljava/lang/String;
    sget-object v12, Lcom/j256/ormlite/field/DataPersisterManager;->builtInMap:Ljava/util/Map;

    invoke-interface {v12, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    add-int/lit8 v5, v5, 0x1

    goto :goto_2
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    return-void
.end method

.method public static clear()V
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    sput-object v0, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    .line 68
    return-void
.end method

.method public static lookupForField(Ljava/lang/reflect/Field;)Lcom/j256/ormlite/field/DataPersister;
    .locals 8
    .param p0, "field"    # Ljava/lang/reflect/Field;

    .prologue
    .line 78
    sget-object v3, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 79
    sget-object v3, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_3

    .line 93
    :cond_1
    sget-object v3, Lcom/j256/ormlite/field/DataPersisterManager;->builtInMap:Ljava/util/Map;

    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/j256/ormlite/field/DataPersister;

    .line 94
    .local v1, "dataPersister":Lcom/j256/ormlite/field/DataPersister;
    if-eqz v1, :cond_4

    move-object v2, v1

    .line 109
    .end local v1    # "dataPersister":Lcom/j256/ormlite/field/DataPersister;
    :cond_2
    :goto_0
    return-object v2

    .line 79
    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/j256/ormlite/field/DataPersister;

    .line 80
    .local v2, "persister":Lcom/j256/ormlite/field/DataPersister;
    invoke-interface {v2, p0}, Lcom/j256/ormlite/field/DataPersister;->isValidForField(Ljava/lang/reflect/Field;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 84
    invoke-interface {v2}, Lcom/j256/ormlite/field/DataPersister;->getAssociatedClasses()[Ljava/lang/Class;

    move-result-object v5

    array-length v6, v5

    const/4 v3, 0x0

    :goto_1
    if-ge v3, v6, :cond_0

    aget-object v0, v5, v3

    .line 85
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v7

    if-eq v7, v0, :cond_2

    .line 84
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 102
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "persister":Lcom/j256/ormlite/field/DataPersister;
    .restart local v1    # "dataPersister":Lcom/j256/ormlite/field/DataPersister;
    :cond_4
    invoke-virtual {p0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->isEnum()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 103
    sget-object v2, Lcom/j256/ormlite/field/DataPersisterManager;->DEFAULT_ENUM_PERSISTER:Lcom/j256/ormlite/field/DataPersister;

    goto :goto_0

    .line 109
    :cond_5
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static varargs registerDataPersisters([Lcom/j256/ormlite/field/DataPersister;)V
    .locals 4
    .param p0, "dataPersisters"    # [Lcom/j256/ormlite/field/DataPersister;

    .prologue
    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 54
    .local v0, "newList":Ljava/util/List;, "Ljava/util/List<Lcom/j256/ormlite/field/DataPersister;>;"
    sget-object v2, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    if-eqz v2, :cond_0

    .line 55
    sget-object v2, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 57
    :cond_0
    array-length v3, p0

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_1

    .line 60
    sput-object v0, Lcom/j256/ormlite/field/DataPersisterManager;->registeredPersisters:Ljava/util/List;

    .line 61
    return-void

    .line 57
    :cond_1
    aget-object v1, p0, v2

    .line 58
    .local v1, "persister":Lcom/j256/ormlite/field/DataPersister;
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 57
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method
