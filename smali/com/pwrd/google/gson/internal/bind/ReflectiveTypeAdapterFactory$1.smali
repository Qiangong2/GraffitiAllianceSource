.class Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;
.super Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
.source "ReflectiveTypeAdapterFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->createBoundField(Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;ZZ)Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;

.field final typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<*>;"
        }
    .end annotation
.end field

.field private final synthetic val$context:Lcom/pwrd/google/gson/Gson;

.field private final synthetic val$field:Ljava/lang/reflect/Field;

.field private final synthetic val$fieldType:Lcom/pwrd/google/gson/reflect/TypeToken;

.field private final synthetic val$isPrimitive:Z


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;Ljava/lang/String;ZZLcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;Z)V
    .locals 1
    .param p2, "$anonymous0"    # Ljava/lang/String;
    .param p3, "$anonymous1"    # Z
    .param p4, "$anonymous2"    # Z

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->this$0:Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;

    iput-object p5, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$context:Lcom/pwrd/google/gson/Gson;

    iput-object p6, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$field:Ljava/lang/reflect/Field;

    iput-object p7, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$fieldType:Lcom/pwrd/google/gson/reflect/TypeToken;

    iput-boolean p8, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$isPrimitive:Z

    .line 105
    invoke-direct {p0, p2, p3, p4}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$BoundField;-><init>(Ljava/lang/String;ZZ)V

    .line 106
    invoke-static {p1, p5, p6, p7}, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;->access$0(Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory;Lcom/pwrd/google/gson/Gson;Ljava/lang/reflect/Field;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    return-void
.end method


# virtual methods
.method read(Lcom/pwrd/google/gson/stream/JsonReader;Ljava/lang/Object;)V
    .locals 2
    .param p1, "reader"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 117
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v1, p1}, Lcom/pwrd/google/gson/TypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v0

    .line 118
    .local v0, "fieldValue":Ljava/lang/Object;
    if-nez v0, :cond_0

    iget-boolean v1, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$isPrimitive:Z

    if-nez v1, :cond_1

    .line 119
    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$field:Ljava/lang/reflect/Field;

    invoke-virtual {v1, p2, v0}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 121
    :cond_1
    return-void
.end method

.method write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 5
    .param p1, "writer"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 110
    iget-object v2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$field:Ljava/lang/reflect/Field;

    invoke-virtual {v2, p2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 112
    .local v0, "fieldValue":Ljava/lang/Object;
    new-instance v1, Lcom/pwrd/google/gson/internal/bind/TypeAdapterRuntimeTypeWrapper;

    iget-object v2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$context:Lcom/pwrd/google/gson/Gson;

    iget-object v3, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->typeAdapter:Lcom/pwrd/google/gson/TypeAdapter;

    iget-object v4, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$fieldType:Lcom/pwrd/google/gson/reflect/TypeToken;

    invoke-virtual {v4}, Lcom/pwrd/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/pwrd/google/gson/internal/bind/TypeAdapterRuntimeTypeWrapper;-><init>(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/TypeAdapter;Ljava/lang/reflect/Type;)V

    .line 113
    .local v1, "t":Lcom/pwrd/google/gson/TypeAdapter;
    invoke-virtual {v1, p1, v0}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V

    .line 114
    return-void
.end method

.method public writeField(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 123
    iget-boolean v2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->serialized:Z

    if-nez v2, :cond_1

    .line 125
    :cond_0
    :goto_0
    return v1

    .line 124
    :cond_1
    iget-object v2, p0, Lcom/pwrd/google/gson/internal/bind/ReflectiveTypeAdapterFactory$1;->val$field:Ljava/lang/reflect/Field;

    invoke-virtual {v2, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 125
    .local v0, "fieldValue":Ljava/lang/Object;
    if-eq v0, p1, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method
