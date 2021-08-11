.class public final Lcom/pwrd/google/gson/Gson;
.super Ljava/lang/Object;
.source "Gson.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;
    }
.end annotation


# static fields
.field static final DEFAULT_JSON_NON_EXECUTABLE:Z = false

.field private static final JSON_NON_EXECUTABLE_PREFIX:Ljava/lang/String; = ")]}\'\n"


# instance fields
.field private final calls:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/util/Map",
            "<",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<*>;",
            "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter",
            "<*>;>;>;"
        }
    .end annotation
.end field

.field private final constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

.field final deserializationContext:Lcom/pwrd/google/gson/JsonDeserializationContext;

.field private final factories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/pwrd/google/gson/TypeAdapterFactory;",
            ">;"
        }
    .end annotation
.end field

.field private final generateNonExecutableJson:Z

.field private final htmlSafe:Z

.field private final prettyPrinting:Z

.field final serializationContext:Lcom/pwrd/google/gson/JsonSerializationContext;

.field private final serializeNulls:Z

.field private final typeTokenCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<*>;",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 12

    .prologue
    const/4 v4, 0x0

    .line 177
    sget-object v1, Lcom/pwrd/google/gson/internal/Excluder;->DEFAULT:Lcom/pwrd/google/gson/internal/Excluder;

    sget-object v2, Lcom/pwrd/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 178
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v3

    .line 179
    const/4 v7, 0x1

    sget-object v10, Lcom/pwrd/google/gson/LongSerializationPolicy;->DEFAULT:Lcom/pwrd/google/gson/LongSerializationPolicy;

    .line 180
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v11

    move-object v0, p0

    move v5, v4

    move v6, v4

    move v8, v4

    move v9, v4

    invoke-direct/range {v0 .. v11}, Lcom/pwrd/google/gson/Gson;-><init>(Lcom/pwrd/google/gson/internal/Excluder;Lcom/pwrd/google/gson/FieldNamingStrategy;Ljava/util/Map;ZZZZZZLcom/pwrd/google/gson/LongSerializationPolicy;Ljava/util/List;)V

    .line 181
    return-void
.end method

.method constructor <init>(Lcom/pwrd/google/gson/internal/Excluder;Lcom/pwrd/google/gson/FieldNamingStrategy;Ljava/util/Map;ZZZZZZLcom/pwrd/google/gson/LongSerializationPolicy;Ljava/util/List;)V
    .locals 4
    .param p1, "excluder"    # Lcom/pwrd/google/gson/internal/Excluder;
    .param p2, "fieldNamingPolicy"    # Lcom/pwrd/google/gson/FieldNamingStrategy;
    .param p4, "serializeNulls"    # Z
    .param p5, "complexMapKeySerialization"    # Z
    .param p6, "generateNonExecutableGson"    # Z
    .param p7, "htmlSafe"    # Z
    .param p8, "prettyPrinting"    # Z
    .param p9, "serializeSpecialFloatingPointValues"    # Z
    .param p10, "longSerializationPolicy"    # Lcom/pwrd/google/gson/LongSerializationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/internal/Excluder;",
            "Lcom/pwrd/google/gson/FieldNamingStrategy;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/reflect/Type;",
            "Lcom/pwrd/google/gson/InstanceCreator",
            "<*>;>;ZZZZZZ",
            "Lcom/pwrd/google/gson/LongSerializationPolicy;",
            "Ljava/util/List",
            "<",
            "Lcom/pwrd/google/gson/TypeAdapterFactory;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 183
    .local p3, "instanceCreators":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/reflect/Type;Lcom/pwrd/google/gson/InstanceCreator<*>;>;"
    .local p11, "typeAdapterFactories":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/TypeAdapterFactory;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 113
    new-instance v1, Ljava/lang/ThreadLocal;

    invoke-direct {v1}, Ljava/lang/ThreadLocal;-><init>()V

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->calls:Ljava/lang/ThreadLocal;

    .line 116
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {v1}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->typeTokenCache:Ljava/util/Map;

    .line 126
    new-instance v1, Lcom/pwrd/google/gson/Gson$1;

    invoke-direct {v1, p0}, Lcom/pwrd/google/gson/Gson$1;-><init>(Lcom/pwrd/google/gson/Gson;)V

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->deserializationContext:Lcom/pwrd/google/gson/JsonDeserializationContext;

    .line 133
    new-instance v1, Lcom/pwrd/google/gson/Gson$2;

    invoke-direct {v1, p0}, Lcom/pwrd/google/gson/Gson$2;-><init>(Lcom/pwrd/google/gson/Gson;)V

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->serializationContext:Lcom/pwrd/google/gson/JsonSerializationContext;

    .line 189
    new-instance v1, Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-direct {v1, p3}, Lcom/pwrd/google/gson/internal/ConstructorConstructor;-><init>(Ljava/util/Map;)V

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    .line 190
    iput-boolean p4, p0, Lcom/pwrd/google/gson/Gson;->serializeNulls:Z

    .line 191
    iput-boolean p6, p0, Lcom/pwrd/google/gson/Gson;->generateNonExecutableJson:Z

    .line 192
    iput-boolean p7, p0, Lcom/pwrd/google/gson/Gson;->htmlSafe:Z

    .line 193
    iput-boolean p8, p0, Lcom/pwrd/google/gson/Gson;->prettyPrinting:Z

    .line 195
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 198
    .local v0, "factories":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/TypeAdapterFactory;>;"
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->JSON_ELEMENT_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 199
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/ObjectTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 202
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    invoke-interface {v0, p11}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 208
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->STRING_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 209
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->INTEGER_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 210
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->BOOLEAN_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 211
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->BYTE_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 212
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->SHORT_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 213
    sget-object v1, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    const-class v2, Ljava/lang/Long;

    .line 214
    invoke-direct {p0, p10}, Lcom/pwrd/google/gson/Gson;->longAdapter(Lcom/pwrd/google/gson/LongSerializationPolicy;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v3

    .line 213
    invoke-static {v1, v2, v3}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 215
    sget-object v1, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    const-class v2, Ljava/lang/Double;

    .line 216
    invoke-direct {p0, p9}, Lcom/pwrd/google/gson/Gson;->doubleAdapter(Z)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v3

    .line 215
    invoke-static {v1, v2, v3}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 217
    sget-object v1, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    const-class v2, Ljava/lang/Float;

    .line 218
    invoke-direct {p0, p9}, Lcom/pwrd/google/gson/Gson;->floatAdapter(Z)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v3

    .line 217
    invoke-static {v1, v2, v3}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 219
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->NUMBER_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 220
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->CHARACTER_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 221
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->STRING_BUILDER_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 222
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->STRING_BUFFER_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 223
    const-class v1, Ljava/math/BigDecimal;

    sget-object v2, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->BIG_DECIMAL:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-static {v1, v2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 224
    const-class v1, Ljava/math/BigInteger;

    sget-object v2, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->BIG_INTEGER:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-static {v1, v2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->newFactory(Ljava/lang/Class;Lcom/pwrd/google/gson/TypeAdapter;)Lcom/pwrd/google/gson/TypeAdapterFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->URL_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 226
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->URI_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 227
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->UUID_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 228
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->LOCALE_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 229
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->INET_ADDRESS_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->BIT_SET_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 231
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/DateTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 232
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->CALENDAR_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 233
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TimeTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 234
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/SqlDateTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 235
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->TIMESTAMP_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 236
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/ArrayTypeAdapter;->FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 237
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->CLASS_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 240
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/CollectionTypeAdapterFactory;

    iget-object v2, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-direct {v1, v2}, Lcom/pwrd/google/gson/internal/bind/CollectionTypeAdapterFactory;-><init>(Lcom/pwrd/google/gson/internal/ConstructorConstructor;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 241
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/MapTypeAdapterFactory;

    iget-object v2, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-direct {v1, v2, p5}, Lcom/pwrd/google/gson/internal/bind/MapTypeAdapterFactory;-><init>(Lcom/pwrd/google/gson/internal/ConstructorConstructor;Z)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 242
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/JsonAdapterAnnotationTypeAdapterFactory;

    iget-object v2, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-direct {v1, v2}, Lcom/pwrd/google/gson/internal/bind/JsonAdapterAnnotationTypeAdapterFactory;-><init>(Lcom/pwrd/google/gson/internal/ConstructorConstructor;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    sget-object v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->ENUM_FACTORY:Lcom/pwrd/google/gson/TypeAdapterFactory;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 244
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;

    .line 245
    iget-object v2, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-direct {v1, v2, p2, p1}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;-><init>(Lcom/pwrd/google/gson/internal/ConstructorConstructor;Lcom/pwrd/google/gson/FieldNamingStrategy;Lcom/pwrd/google/gson/internal/Excluder;)V

    .line 244
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 247
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/pwrd/google/gson/Gson;->factories:Ljava/util/List;

    .line 248
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/google/gson/Gson;D)V
    .locals 1

    .prologue
    .line 298
    invoke-direct {p0, p1, p2}, Lcom/pwrd/google/gson/Gson;->checkValidFloatingPoint(D)V

    return-void
.end method

.method private static assertFullConsumption(Ljava/lang/Object;Lcom/pwrd/google/gson/stream/JsonReader;)V
    .locals 3
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "reader"    # Lcom/pwrd/google/gson/stream/JsonReader;

    .prologue
    .line 786
    if-eqz p0, :cond_0

    :try_start_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v1

    sget-object v2, Lcom/pwrd/google/gson/stream/JsonToken;->END_DOCUMENT:Lcom/pwrd/google/gson/stream/JsonToken;

    if-eq v1, v2, :cond_0

    .line 787
    new-instance v1, Lcom/pwrd/google/gson/JsonIOException;

    const-string v2, "JSON document was not fully consumed."

    invoke-direct {v1, v2}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Lcom/pwrd/google/gson/stream/MalformedJsonException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 789
    :catch_0
    move-exception v0

    .line 790
    .local v0, "e":Lcom/pwrd/google/gson/stream/MalformedJsonException;
    new-instance v1, Lcom/pwrd/google/gson/JsonSyntaxException;

    invoke-direct {v1, v0}, Lcom/pwrd/google/gson/JsonSyntaxException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 791
    .end local v0    # "e":Lcom/pwrd/google/gson/stream/MalformedJsonException;
    :catch_1
    move-exception v0

    .line 792
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/pwrd/google/gson/JsonIOException;

    invoke-direct {v1, v0}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 794
    .end local v0    # "e":Ljava/io/IOException;
    :cond_0
    return-void
.end method

.method private checkValidFloatingPoint(D)V
    .locals 3
    .param p1, "value"    # D

    .prologue
    .line 299
    invoke-static {p1, p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1, p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 300
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 301
    const-string v2, " is not a valid double value as per JSON specification. To override this"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 302
    const-string v2, " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 300
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 304
    :cond_1
    return-void
.end method

.method private doubleAdapter(Z)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1
    .param p1, "serializeSpecialFloatingPointValues"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation

    .prologue
    .line 251
    if-eqz p1, :cond_0

    .line 252
    sget-object v0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->DOUBLE:Lcom/pwrd/google/gson/TypeAdapter;

    .line 254
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/Gson$3;

    invoke-direct {v0, p0}, Lcom/pwrd/google/gson/Gson$3;-><init>(Lcom/pwrd/google/gson/Gson;)V

    goto :goto_0
.end method

.method private floatAdapter(Z)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1
    .param p1, "serializeSpecialFloatingPointValues"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation

    .prologue
    .line 275
    if-eqz p1, :cond_0

    .line 276
    sget-object v0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->FLOAT:Lcom/pwrd/google/gson/TypeAdapter;

    .line 278
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/Gson$4;

    invoke-direct {v0, p0}, Lcom/pwrd/google/gson/Gson$4;-><init>(Lcom/pwrd/google/gson/Gson;)V

    goto :goto_0
.end method

.method private longAdapter(Lcom/pwrd/google/gson/LongSerializationPolicy;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1
    .param p1, "longSerializationPolicy"    # Lcom/pwrd/google/gson/LongSerializationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/LongSerializationPolicy;",
            ")",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation

    .prologue
    .line 307
    sget-object v0, Lcom/pwrd/google/gson/LongSerializationPolicy;->DEFAULT:Lcom/pwrd/google/gson/LongSerializationPolicy;

    if-ne p1, v0, :cond_0

    .line 308
    sget-object v0, Lcom/pwrd/google/gson/internal/bind/TypeAdapters;->LONG:Lcom/pwrd/google/gson/TypeAdapter;

    .line 310
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/Gson$5;

    invoke-direct {v0, p0}, Lcom/pwrd/google/gson/Gson$5;-><init>(Lcom/pwrd/google/gson/Gson;)V

    goto :goto_0
.end method


# virtual methods
.method public fromJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "json"    # Lcom/pwrd/google/gson/JsonElement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/JsonElement;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 852
    .local p2, "classOfT":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    .line 853
    .local v0, "object":Ljava/lang/Object;
    invoke-static {p2}, Lcom/pwrd/google/gson/internal/Primitives;->wrap(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public fromJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 1
    .param p1, "json"    # Lcom/pwrd/google/gson/JsonElement;
    .param p2, "typeOfT"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/JsonElement;",
            "Ljava/lang/reflect/Type;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 876
    if-nez p1, :cond_0

    .line 877
    const/4 v0, 0x0

    .line 879
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/internal/bind/JsonTreeReader;

    invoke-direct {v0, p1}, Lcom/pwrd/google/gson/internal/bind/JsonTreeReader;-><init>(Lcom/pwrd/google/gson/JsonElement;)V

    invoke-virtual {p0, v0, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Lcom/pwrd/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public fromJson(Lcom/pwrd/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 7
    .param p1, "reader"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .param p2, "typeOfT"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/stream/JsonReader;",
            "Ljava/lang/reflect/Type;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;,
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 806
    const/4 v1, 0x1

    .line 807
    .local v1, "isEmpty":Z
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->isLenient()Z

    move-result v3

    .line 808
    .local v3, "oldLenient":Z
    const/4 v6, 0x1

    invoke-virtual {p1, v6}, Lcom/pwrd/google/gson/stream/JsonReader;->setLenient(Z)V

    .line 810
    :try_start_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    .line 811
    const/4 v1, 0x0

    .line 812
    invoke-static {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->get(Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/reflect/TypeToken;

    move-result-object v5

    .line 813
    .local v5, "typeToken":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    invoke-virtual {p0, v5}, Lcom/pwrd/google/gson/Gson;->getAdapter(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v4

    .line 814
    .local v4, "typeAdapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    invoke-virtual {v4, p1}, Lcom/pwrd/google/gson/TypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 831
    .local v2, "object":Ljava/lang/Object;, "TT;"
    invoke-virtual {p1, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->setLenient(Z)V

    .line 822
    .end local v2    # "object":Ljava/lang/Object;, "TT;"
    .end local v4    # "typeAdapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    .end local v5    # "typeToken":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    :goto_0
    return-object v2

    .line 816
    :catch_0
    move-exception v0

    .line 821
    .local v0, "e":Ljava/io/EOFException;
    if-eqz v1, :cond_0

    .line 831
    invoke-virtual {p1, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->setLenient(Z)V

    .line 822
    const/4 v2, 0x0

    goto :goto_0

    .line 824
    :cond_0
    :try_start_1
    new-instance v6, Lcom/pwrd/google/gson/JsonSyntaxException;

    invoke-direct {v6, v0}, Lcom/pwrd/google/gson/JsonSyntaxException;-><init>(Ljava/lang/Throwable;)V

    throw v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 830
    .end local v0    # "e":Ljava/io/EOFException;
    :catchall_0
    move-exception v6

    .line 831
    invoke-virtual {p1, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->setLenient(Z)V

    .line 832
    throw v6

    .line 825
    :catch_1
    move-exception v0

    .line 826
    .local v0, "e":Ljava/lang/IllegalStateException;
    :try_start_2
    new-instance v6, Lcom/pwrd/google/gson/JsonSyntaxException;

    invoke-direct {v6, v0}, Lcom/pwrd/google/gson/JsonSyntaxException;-><init>(Ljava/lang/Throwable;)V

    throw v6

    .line 827
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_2
    move-exception v0

    .line 829
    .local v0, "e":Ljava/io/IOException;
    new-instance v6, Lcom/pwrd/google/gson/JsonSyntaxException;

    invoke-direct {v6, v0}, Lcom/pwrd/google/gson/JsonSyntaxException;-><init>(Ljava/lang/Throwable;)V

    throw v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method public fromJson(Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p1, "json"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/io/Reader;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonSyntaxException;,
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 751
    .local p2, "classOfT":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lcom/pwrd/google/gson/stream/JsonReader;

    invoke-direct {v0, p1}, Lcom/pwrd/google/gson/stream/JsonReader;-><init>(Ljava/io/Reader;)V

    .line 752
    .local v0, "jsonReader":Lcom/pwrd/google/gson/stream/JsonReader;
    invoke-virtual {p0, v0, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Lcom/pwrd/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .line 753
    .local v1, "object":Ljava/lang/Object;
    invoke-static {v1, v0}, Lcom/pwrd/google/gson/Gson;->assertFullConsumption(Ljava/lang/Object;Lcom/pwrd/google/gson/stream/JsonReader;)V

    .line 754
    invoke-static {p2}, Lcom/pwrd/google/gson/internal/Primitives;->wrap(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2
.end method

.method public fromJson(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 2
    .param p1, "json"    # Ljava/io/Reader;
    .param p2, "typeOfT"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/io/Reader;",
            "Ljava/lang/reflect/Type;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;,
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 778
    new-instance v0, Lcom/pwrd/google/gson/stream/JsonReader;

    invoke-direct {v0, p1}, Lcom/pwrd/google/gson/stream/JsonReader;-><init>(Ljava/io/Reader;)V

    .line 779
    .local v0, "jsonReader":Lcom/pwrd/google/gson/stream/JsonReader;
    invoke-virtual {p0, v0, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Lcom/pwrd/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .line 780
    .local v1, "object":Ljava/lang/Object;, "TT;"
    invoke-static {v1, v0}, Lcom/pwrd/google/gson/Gson;->assertFullConsumption(Ljava/lang/Object;Lcom/pwrd/google/gson/stream/JsonReader;)V

    .line 781
    return-object v1
.end method

.method public fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 700
    .local p2, "classOfT":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    .line 701
    .local v0, "object":Ljava/lang/Object;
    invoke-static {p2}, Lcom/pwrd/google/gson/internal/Primitives;->wrap(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 2
    .param p1, "json"    # Ljava/lang/String;
    .param p2, "typeOfT"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/reflect/Type;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonSyntaxException;
        }
    .end annotation

    .prologue
    .line 724
    if-nez p1, :cond_0

    .line 725
    const/4 v1, 0x0

    .line 729
    :goto_0
    return-object v1

    .line 727
    :cond_0
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    .line 728
    .local v0, "reader":Ljava/io/StringReader;
    invoke-virtual {p0, v0, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .line 729
    .local v1, "target":Ljava/lang/Object;, "TT;"
    goto :goto_0
.end method

.method public getAdapter(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<TT;>;)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 336
    .local p1, "type":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->typeTokenCache:Ljava/util/Map;

    invoke-interface {v7, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/TypeAdapter;

    .line 337
    .local v0, "cached":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    if-eqz v0, :cond_0

    .line 364
    .end local v0    # "cached":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    :goto_0
    return-object v0

    .line 341
    .restart local v0    # "cached":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    :cond_0
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->calls:Ljava/lang/ThreadLocal;

    invoke-virtual {v7}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    .line 342
    .local v6, "threadCalls":Ljava/util/Map;, "Ljava/util/Map<Lcom/pwrd/google/gson/reflect/TypeToken<*>;Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<*>;>;"
    const/4 v5, 0x0

    .line 343
    .local v5, "requiresThreadLocalCleanup":Z
    if-nez v6, :cond_1

    .line 344
    new-instance v6, Ljava/util/HashMap;

    .end local v6    # "threadCalls":Ljava/util/Map;, "Ljava/util/Map<Lcom/pwrd/google/gson/reflect/TypeToken<*>;Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<*>;>;"
    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 345
    .restart local v6    # "threadCalls":Ljava/util/Map;, "Ljava/util/Map<Lcom/pwrd/google/gson/reflect/TypeToken<*>;Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<*>;>;"
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->calls:Ljava/lang/ThreadLocal;

    invoke-virtual {v7, v6}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    .line 346
    const/4 v5, 0x1

    .line 350
    :cond_1
    invoke-interface {v6, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;

    .line 351
    .local v4, "ongoingCall":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    if-eqz v4, :cond_2

    move-object v0, v4

    .line 352
    goto :goto_0

    .line 356
    :cond_2
    :try_start_0
    new-instance v1, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;

    invoke-direct {v1}, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;-><init>()V

    .line 357
    .local v1, "call":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    invoke-interface {v6, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 359
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->factories:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_5

    .line 367
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "GSON cannot handle "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 368
    .end local v1    # "call":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    :catchall_0
    move-exception v7

    .line 369
    invoke-interface {v6, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 371
    if-eqz v5, :cond_4

    .line 372
    iget-object v8, p0, Lcom/pwrd/google/gson/Gson;->calls:Ljava/lang/ThreadLocal;

    invoke-virtual {v8}, Ljava/lang/ThreadLocal;->remove()V

    .line 374
    :cond_4
    throw v7

    .line 359
    .restart local v1    # "call":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    :cond_5
    :try_start_1
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/pwrd/google/gson/TypeAdapterFactory;

    .line 360
    .local v3, "factory":Lcom/pwrd/google/gson/TypeAdapterFactory;
    invoke-interface {v3, p0, p1}, Lcom/pwrd/google/gson/TypeAdapterFactory;->create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v2

    .line 361
    .local v2, "candidate":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    if-eqz v2, :cond_3

    .line 362
    invoke-virtual {v1, v2}, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->setDelegate(Lcom/pwrd/google/gson/TypeAdapter;)V

    .line 363
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->typeTokenCache:Ljava/util/Map;

    invoke-interface {v7, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 369
    invoke-interface {v6, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 371
    if-eqz v5, :cond_6

    .line 372
    iget-object v7, p0, Lcom/pwrd/google/gson/Gson;->calls:Ljava/lang/ThreadLocal;

    invoke-virtual {v7}, Ljava/lang/ThreadLocal;->remove()V

    :cond_6
    move-object v0, v2

    .line 364
    goto :goto_0
.end method

.method public getAdapter(Ljava/lang/Class;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 457
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-static {p1}, Lcom/pwrd/google/gson/reflect/TypeToken;->get(Ljava/lang/Class;)Lcom/pwrd/google/gson/reflect/TypeToken;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/pwrd/google/gson/Gson;->getAdapter(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getDelegateAdapter(Lcom/pwrd/google/gson/TypeAdapterFactory;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 6
    .param p1, "skipPast"    # Lcom/pwrd/google/gson/TypeAdapterFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/TypeAdapterFactory;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<TT;>;)",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 428
    .local p2, "type":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    const/4 v2, 0x0

    .line 432
    .local v2, "skipPastFound":Z
    iget-object v3, p0, Lcom/pwrd/google/gson/Gson;->factories:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v2, 0x1

    .line 434
    :cond_0
    iget-object v3, p0, Lcom/pwrd/google/gson/Gson;->factories:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 447
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "GSON cannot serialize "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 434
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/google/gson/TypeAdapterFactory;

    .line 435
    .local v1, "factory":Lcom/pwrd/google/gson/TypeAdapterFactory;
    if-nez v2, :cond_3

    .line 436
    if-ne v1, p1, :cond_1

    .line 437
    const/4 v2, 0x1

    .line 439
    goto :goto_0

    .line 442
    :cond_3
    invoke-interface {v1, p0, p2}, Lcom/pwrd/google/gson/TypeAdapterFactory;->create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .line 443
    .local v0, "candidate":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    if-eqz v0, :cond_1

    .line 444
    return-object v0
.end method

.method public newJsonWriter(Ljava/io/Writer;)Lcom/pwrd/google/gson/stream/JsonWriter;
    .locals 2
    .param p1, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 649
    iget-boolean v1, p0, Lcom/pwrd/google/gson/Gson;->generateNonExecutableJson:Z

    if-eqz v1, :cond_0

    .line 650
    const-string v1, ")]}\'\n"

    invoke-virtual {p1, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 652
    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/stream/JsonWriter;

    invoke-direct {v0, p1}, Lcom/pwrd/google/gson/stream/JsonWriter;-><init>(Ljava/io/Writer;)V

    .line 653
    .local v0, "jsonWriter":Lcom/pwrd/google/gson/stream/JsonWriter;
    iget-boolean v1, p0, Lcom/pwrd/google/gson/Gson;->prettyPrinting:Z

    if-eqz v1, :cond_1

    .line 654
    const-string v1, "  "

    invoke-virtual {v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->setIndent(Ljava/lang/String;)V

    .line 656
    :cond_1
    iget-boolean v1, p0, Lcom/pwrd/google/gson/Gson;->serializeNulls:Z

    invoke-virtual {v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 657
    return-object v0
.end method

.method public toJson(Lcom/pwrd/google/gson/JsonElement;)Ljava/lang/String;
    .locals 2
    .param p1, "jsonElement"    # Lcom/pwrd/google/gson/JsonElement;

    .prologue
    .line 623
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 624
    .local v0, "writer":Ljava/io/StringWriter;
    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/Gson;->toJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/Appendable;)V

    .line 625
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toJson(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "src"    # Ljava/lang/Object;

    .prologue
    .line 516
    if-nez p1, :cond_0

    .line 517
    sget-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    invoke-virtual {p0, v0}, Lcom/pwrd/google/gson/Gson;->toJson(Lcom/pwrd/google/gson/JsonElement;)Ljava/lang/String;

    move-result-object v0

    .line 519
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 2
    .param p1, "src"    # Ljava/lang/Object;
    .param p2, "typeOfSrc"    # Ljava/lang/reflect/Type;

    .prologue
    .line 538
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 539
    .local v0, "writer":Ljava/io/StringWriter;
    invoke-virtual {p0, p1, p2, v0}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/lang/Appendable;)V

    .line 540
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public toJson(Lcom/pwrd/google/gson/JsonElement;Lcom/pwrd/google/gson/stream/JsonWriter;)V
    .locals 5
    .param p1, "jsonElement"    # Lcom/pwrd/google/gson/JsonElement;
    .param p2, "writer"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 665
    invoke-virtual {p2}, Lcom/pwrd/google/gson/stream/JsonWriter;->isLenient()Z

    move-result v2

    .line 666
    .local v2, "oldLenient":Z
    const/4 v4, 0x1

    invoke-virtual {p2, v4}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 667
    invoke-virtual {p2}, Lcom/pwrd/google/gson/stream/JsonWriter;->isHtmlSafe()Z

    move-result v1

    .line 668
    .local v1, "oldHtmlSafe":Z
    iget-boolean v4, p0, Lcom/pwrd/google/gson/Gson;->htmlSafe:Z

    invoke-virtual {p2, v4}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 669
    invoke-virtual {p2}, Lcom/pwrd/google/gson/stream/JsonWriter;->getSerializeNulls()Z

    move-result v3

    .line 670
    .local v3, "oldSerializeNulls":Z
    iget-boolean v4, p0, Lcom/pwrd/google/gson/Gson;->serializeNulls:Z

    invoke-virtual {p2, v4}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 672
    :try_start_0
    invoke-static {p1, p2}, Lcom/pwrd/google/gson/internal/Streams;->write(Lcom/pwrd/google/gson/JsonElement;Lcom/pwrd/google/gson/stream/JsonWriter;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 676
    invoke-virtual {p2, v2}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 677
    invoke-virtual {p2, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 678
    invoke-virtual {p2, v3}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 680
    return-void

    .line 673
    :catch_0
    move-exception v0

    .line 674
    .local v0, "e":Ljava/io/IOException;
    :try_start_1
    new-instance v4, Lcom/pwrd/google/gson/JsonIOException;

    invoke-direct {v4, v0}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/Throwable;)V

    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 675
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 676
    invoke-virtual {p2, v2}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 677
    invoke-virtual {p2, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 678
    invoke-virtual {p2, v3}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 679
    throw v4
.end method

.method public toJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/Appendable;)V
    .locals 3
    .param p1, "jsonElement"    # Lcom/pwrd/google/gson/JsonElement;
    .param p2, "writer"    # Ljava/lang/Appendable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 638
    :try_start_0
    invoke-static {p2}, Lcom/pwrd/google/gson/internal/Streams;->writerForAppendable(Ljava/lang/Appendable;)Ljava/io/Writer;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/pwrd/google/gson/Gson;->newJsonWriter(Ljava/io/Writer;)Lcom/pwrd/google/gson/stream/JsonWriter;

    move-result-object v1

    .line 639
    .local v1, "jsonWriter":Lcom/pwrd/google/gson/stream/JsonWriter;
    invoke-virtual {p0, p1, v1}, Lcom/pwrd/google/gson/Gson;->toJson(Lcom/pwrd/google/gson/JsonElement;Lcom/pwrd/google/gson/stream/JsonWriter;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 643
    return-void

    .line 640
    .end local v1    # "jsonWriter":Lcom/pwrd/google/gson/stream/JsonWriter;
    :catch_0
    move-exception v0

    .line 641
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public toJson(Ljava/lang/Object;Ljava/lang/Appendable;)V
    .locals 1
    .param p1, "src"    # Ljava/lang/Object;
    .param p2, "writer"    # Ljava/lang/Appendable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 558
    if-eqz p1, :cond_0

    .line 559
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p2}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/lang/Appendable;)V

    .line 563
    :goto_0
    return-void

    .line 561
    :cond_0
    sget-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    invoke-virtual {p0, v0, p2}, Lcom/pwrd/google/gson/Gson;->toJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/Appendable;)V

    goto :goto_0
.end method

.method public toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/pwrd/google/gson/stream/JsonWriter;)V
    .locals 6
    .param p1, "src"    # Ljava/lang/Object;
    .param p2, "typeOfSrc"    # Ljava/lang/reflect/Type;
    .param p3, "writer"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 597
    invoke-static {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->get(Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/reflect/TypeToken;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/pwrd/google/gson/Gson;->getAdapter(Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    .line 598
    .local v0, "adapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<*>;"
    invoke-virtual {p3}, Lcom/pwrd/google/gson/stream/JsonWriter;->isLenient()Z

    move-result v3

    .line 599
    .local v3, "oldLenient":Z
    const/4 v5, 0x1

    invoke-virtual {p3, v5}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 600
    invoke-virtual {p3}, Lcom/pwrd/google/gson/stream/JsonWriter;->isHtmlSafe()Z

    move-result v2

    .line 601
    .local v2, "oldHtmlSafe":Z
    iget-boolean v5, p0, Lcom/pwrd/google/gson/Gson;->htmlSafe:Z

    invoke-virtual {p3, v5}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 602
    invoke-virtual {p3}, Lcom/pwrd/google/gson/stream/JsonWriter;->getSerializeNulls()Z

    move-result v4

    .line 603
    .local v4, "oldSerializeNulls":Z
    iget-boolean v5, p0, Lcom/pwrd/google/gson/Gson;->serializeNulls:Z

    invoke-virtual {p3, v5}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 605
    :try_start_0
    invoke-virtual {v0, p3, p1}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 609
    invoke-virtual {p3, v3}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 610
    invoke-virtual {p3, v2}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 611
    invoke-virtual {p3, v4}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 613
    return-void

    .line 606
    :catch_0
    move-exception v1

    .line 607
    .local v1, "e":Ljava/io/IOException;
    :try_start_1
    new-instance v5, Lcom/pwrd/google/gson/JsonIOException;

    invoke-direct {v5, v1}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 608
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v5

    .line 609
    invoke-virtual {p3, v3}, Lcom/pwrd/google/gson/stream/JsonWriter;->setLenient(Z)V

    .line 610
    invoke-virtual {p3, v2}, Lcom/pwrd/google/gson/stream/JsonWriter;->setHtmlSafe(Z)V

    .line 611
    invoke-virtual {p3, v4}, Lcom/pwrd/google/gson/stream/JsonWriter;->setSerializeNulls(Z)V

    .line 612
    throw v5
.end method

.method public toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/lang/Appendable;)V
    .locals 3
    .param p1, "src"    # Ljava/lang/Object;
    .param p2, "typeOfSrc"    # Ljava/lang/reflect/Type;
    .param p3, "writer"    # Ljava/lang/Appendable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonIOException;
        }
    .end annotation

    .prologue
    .line 583
    :try_start_0
    invoke-static {p3}, Lcom/pwrd/google/gson/internal/Streams;->writerForAppendable(Ljava/lang/Appendable;)Ljava/io/Writer;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/pwrd/google/gson/Gson;->newJsonWriter(Ljava/io/Writer;)Lcom/pwrd/google/gson/stream/JsonWriter;

    move-result-object v1

    .line 584
    .local v1, "jsonWriter":Lcom/pwrd/google/gson/stream/JsonWriter;
    invoke-virtual {p0, p1, p2, v1}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/pwrd/google/gson/stream/JsonWriter;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 588
    return-void

    .line 585
    .end local v1    # "jsonWriter":Lcom/pwrd/google/gson/stream/JsonWriter;
    :catch_0
    move-exception v0

    .line 586
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Lcom/pwrd/google/gson/JsonIOException;

    invoke-direct {v2, v0}, Lcom/pwrd/google/gson/JsonIOException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public toJsonTree(Ljava/lang/Object;)Lcom/pwrd/google/gson/JsonElement;
    .locals 1
    .param p1, "src"    # Ljava/lang/Object;

    .prologue
    .line 474
    if-nez p1, :cond_0

    .line 475
    sget-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    .line 477
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/pwrd/google/gson/Gson;->toJsonTree(Ljava/lang/Object;Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/JsonElement;

    move-result-object v0

    goto :goto_0
.end method

.method public toJsonTree(Ljava/lang/Object;Ljava/lang/reflect/Type;)Lcom/pwrd/google/gson/JsonElement;
    .locals 2
    .param p1, "src"    # Ljava/lang/Object;
    .param p2, "typeOfSrc"    # Ljava/lang/reflect/Type;

    .prologue
    .line 497
    new-instance v0, Lcom/pwrd/google/gson/internal/bind/JsonTreeWriter;

    invoke-direct {v0}, Lcom/pwrd/google/gson/internal/bind/JsonTreeWriter;-><init>()V

    .line 498
    .local v0, "writer":Lcom/pwrd/google/gson/internal/bind/JsonTreeWriter;
    invoke-virtual {p0, p1, p2, v0}, Lcom/pwrd/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/pwrd/google/gson/stream/JsonWriter;)V

    .line 499
    invoke-virtual {v0}, Lcom/pwrd/google/gson/internal/bind/JsonTreeWriter;->get()Lcom/pwrd/google/gson/JsonElement;

    move-result-object v1

    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 909
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "{serializeNulls:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 910
    iget-boolean v1, p0, Lcom/pwrd/google/gson/Gson;->serializeNulls:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 911
    const-string v1, "factories:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/google/gson/Gson;->factories:Ljava/util/List;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 912
    const-string v1, ",instanceCreators:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/google/gson/Gson;->constructorConstructor:Lcom/pwrd/google/gson/internal/ConstructorConstructor;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 913
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 914
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 909
    return-object v0
.end method
