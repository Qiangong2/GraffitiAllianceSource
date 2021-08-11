.class public final Lcom/pwrd/google/gson/internal/Excluder;
.super Ljava/lang/Object;
.source "Excluder.java"

# interfaces
.implements Lcom/pwrd/google/gson/TypeAdapterFactory;
.implements Ljava/lang/Cloneable;


# static fields
.field public static final DEFAULT:Lcom/pwrd/google/gson/internal/Excluder;

.field private static final IGNORE_VERSIONS:D = -1.0


# instance fields
.field private deserializationStrategies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/pwrd/google/gson/ExclusionStrategy;",
            ">;"
        }
    .end annotation
.end field

.field private modifiers:I

.field private requireExpose:Z

.field private serializationStrategies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/pwrd/google/gson/ExclusionStrategy;",
            ">;"
        }
    .end annotation
.end field

.field private serializeInnerClasses:Z

.field private version:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/pwrd/google/gson/internal/Excluder;

    invoke-direct {v0}, Lcom/pwrd/google/gson/internal/Excluder;-><init>()V

    sput-object v0, Lcom/pwrd/google/gson/internal/Excluder;->DEFAULT:Lcom/pwrd/google/gson/internal/Excluder;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    .line 56
    const/16 v0, 0x88

    iput v0, p0, Lcom/pwrd/google/gson/internal/Excluder;->modifiers:I

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializeInnerClasses:Z

    .line 59
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    .line 60
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    .line 51
    return-void
.end method

.method private isAnonymousOrLocal(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 217
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v0, Ljava/lang/Enum;

    invoke-virtual {v0, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 218
    invoke-virtual {p1}, Ljava/lang/Class;->isAnonymousClass()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/Class;->isLocalClass()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 217
    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isInnerClass(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 222
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->isMemberClass()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->isStatic(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isStatic(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 226
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getModifiers()I

    move-result v0

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isValidSince(Lcom/pwrd/google/gson/annotations/Since;)Z
    .locals 4
    .param p1, "annotation"    # Lcom/pwrd/google/gson/annotations/Since;

    .prologue
    .line 234
    if-eqz p1, :cond_0

    .line 235
    invoke-interface {p1}, Lcom/pwrd/google/gson/annotations/Since;->value()D

    move-result-wide v0

    .line 236
    .local v0, "annotationVersion":D
    iget-wide v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    cmpl-double v2, v0, v2

    if-lez v2, :cond_0

    .line 237
    const/4 v2, 0x0

    .line 240
    .end local v0    # "annotationVersion":D
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private isValidUntil(Lcom/pwrd/google/gson/annotations/Until;)Z
    .locals 4
    .param p1, "annotation"    # Lcom/pwrd/google/gson/annotations/Until;

    .prologue
    .line 244
    if-eqz p1, :cond_0

    .line 245
    invoke-interface {p1}, Lcom/pwrd/google/gson/annotations/Until;->value()D

    move-result-wide v0

    .line 246
    .local v0, "annotationVersion":D
    iget-wide v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    cmpg-double v2, v0, v2

    if-gtz v2, :cond_0

    .line 247
    const/4 v2, 0x0

    .line 250
    .end local v0    # "annotationVersion":D
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private isValidVersion(Lcom/pwrd/google/gson/annotations/Since;Lcom/pwrd/google/gson/annotations/Until;)Z
    .locals 1
    .param p1, "since"    # Lcom/pwrd/google/gson/annotations/Since;
    .param p2, "until"    # Lcom/pwrd/google/gson/annotations/Until;

    .prologue
    .line 230
    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->isValidSince(Lcom/pwrd/google/gson/annotations/Since;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p2}, Lcom/pwrd/google/gson/internal/Excluder;->isValidUntil(Lcom/pwrd/google/gson/annotations/Until;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected clone()Lcom/pwrd/google/gson/internal/Excluder;
    .locals 2

    .prologue
    .line 64
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/google/gson/internal/Excluder;
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 65
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1
.end method

.method protected bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v0

    return-object v0
.end method

.method public create(Lcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/pwrd/google/gson/TypeAdapter;
    .locals 7
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
    .line 113
    .local p2, "type":Lcom/pwrd/google/gson/reflect/TypeToken;, "Lcom/pwrd/google/gson/reflect/TypeToken<TT;>;"
    invoke-virtual {p2}, Lcom/pwrd/google/gson/reflect/TypeToken;->getRawType()Ljava/lang/Class;

    move-result-object v6

    .line 114
    .local v6, "rawType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x1

    invoke-virtual {p0, v6, v0}, Lcom/pwrd/google/gson/internal/Excluder;->excludeClass(Ljava/lang/Class;Z)Z

    move-result v3

    .line 115
    .local v3, "skipSerialize":Z
    const/4 v0, 0x0

    invoke-virtual {p0, v6, v0}, Lcom/pwrd/google/gson/internal/Excluder;->excludeClass(Ljava/lang/Class;Z)Z

    move-result v2

    .line 117
    .local v2, "skipDeserialize":Z
    if-nez v3, :cond_0

    if-nez v2, :cond_0

    .line 118
    const/4 v0, 0x0

    .line 121
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/pwrd/google/gson/internal/Excluder$1;

    move-object v1, p0

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/pwrd/google/gson/internal/Excluder$1;-><init>(Lcom/pwrd/google/gson/internal/Excluder;ZZLcom/pwrd/google/gson/Gson;Lcom/pwrd/google/gson/reflect/TypeToken;)V

    goto :goto_0
.end method

.method public disableInnerClassSerialization()Lcom/pwrd/google/gson/internal/Excluder;
    .locals 2

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v0

    .line 87
    .local v0, "result":Lcom/pwrd/google/gson/internal/Excluder;
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->serializeInnerClasses:Z

    .line 88
    return-object v0
.end method

.method public excludeClass(Ljava/lang/Class;Z)Z
    .locals 8
    .param p2, "serialize"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;Z)Z"
        }
    .end annotation

    .prologue
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v4, 0x1

    .line 193
    iget-wide v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    const-wide/high16 v6, -0x4010000000000000L    # -1.0

    cmpl-double v2, v2, v6

    if-eqz v2, :cond_0

    .line 194
    const-class v2, Lcom/pwrd/google/gson/annotations/Since;

    invoke-virtual {p1, v2}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v2

    check-cast v2, Lcom/pwrd/google/gson/annotations/Since;

    const-class v3, Lcom/pwrd/google/gson/annotations/Until;

    invoke-virtual {p1, v3}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v3

    check-cast v3, Lcom/pwrd/google/gson/annotations/Until;

    invoke-direct {p0, v2, v3}, Lcom/pwrd/google/gson/internal/Excluder;->isValidVersion(Lcom/pwrd/google/gson/annotations/Since;Lcom/pwrd/google/gson/annotations/Until;)Z

    move-result v2

    if-nez v2, :cond_0

    move v2, v4

    .line 213
    :goto_0
    return v2

    .line 198
    :cond_0
    iget-boolean v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializeInnerClasses:Z

    if-nez v2, :cond_1

    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->isInnerClass(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_1

    move v2, v4

    .line 199
    goto :goto_0

    .line 202
    :cond_1
    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/Excluder;->isAnonymousOrLocal(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_2

    move v2, v4

    .line 203
    goto :goto_0

    .line 206
    :cond_2
    if-eqz p2, :cond_4

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    .line 207
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_5

    .line 213
    const/4 v2, 0x0

    goto :goto_0

    .line 206
    .end local v1    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :cond_4
    iget-object v1, p0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    goto :goto_1

    .line 207
    .restart local v1    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :cond_5
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/ExclusionStrategy;

    .line 208
    .local v0, "exclusionStrategy":Lcom/pwrd/google/gson/ExclusionStrategy;
    invoke-interface {v0, p1}, Lcom/pwrd/google/gson/ExclusionStrategy;->shouldSkipClass(Ljava/lang/Class;)Z

    move-result v3

    if-eqz v3, :cond_3

    move v2, v4

    .line 209
    goto :goto_0
.end method

.method public excludeField(Ljava/lang/reflect/Field;Z)Z
    .locals 10
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "serialize"    # Z

    .prologue
    const/4 v6, 0x1

    .line 151
    iget v4, p0, Lcom/pwrd/google/gson/internal/Excluder;->modifiers:I

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v5

    and-int/2addr v4, v5

    if-eqz v4, :cond_0

    move v4, v6

    .line 189
    :goto_0
    return v4

    .line 155
    :cond_0
    iget-wide v4, p0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    const-wide/high16 v8, -0x4010000000000000L    # -1.0

    cmpl-double v4, v4, v8

    if-eqz v4, :cond_1

    .line 156
    const-class v4, Lcom/pwrd/google/gson/annotations/Since;

    invoke-virtual {p1, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v4

    check-cast v4, Lcom/pwrd/google/gson/annotations/Since;

    const-class v5, Lcom/pwrd/google/gson/annotations/Until;

    invoke-virtual {p1, v5}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v5

    check-cast v5, Lcom/pwrd/google/gson/annotations/Until;

    invoke-direct {p0, v4, v5}, Lcom/pwrd/google/gson/internal/Excluder;->isValidVersion(Lcom/pwrd/google/gson/annotations/Since;Lcom/pwrd/google/gson/annotations/Until;)Z

    move-result v4

    if-nez v4, :cond_1

    move v4, v6

    .line 157
    goto :goto_0

    .line 160
    :cond_1
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->isSynthetic()Z

    move-result v4

    if-eqz v4, :cond_2

    move v4, v6

    .line 161
    goto :goto_0

    .line 164
    :cond_2
    iget-boolean v4, p0, Lcom/pwrd/google/gson/internal/Excluder;->requireExpose:Z

    if-eqz v4, :cond_5

    .line 165
    const-class v4, Lcom/pwrd/google/gson/annotations/Expose;

    invoke-virtual {p1, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/annotations/Expose;

    .line 166
    .local v0, "annotation":Lcom/pwrd/google/gson/annotations/Expose;
    if-eqz v0, :cond_3

    if-eqz p2, :cond_4

    invoke-interface {v0}, Lcom/pwrd/google/gson/annotations/Expose;->serialize()Z

    move-result v4

    if-nez v4, :cond_5

    :cond_3
    move v4, v6

    .line 167
    goto :goto_0

    .line 166
    :cond_4
    invoke-interface {v0}, Lcom/pwrd/google/gson/annotations/Expose;->deserialize()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 171
    .end local v0    # "annotation":Lcom/pwrd/google/gson/annotations/Expose;
    :cond_5
    iget-boolean v4, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializeInnerClasses:Z

    if-nez v4, :cond_6

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/internal/Excluder;->isInnerClass(Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_6

    move v4, v6

    .line 172
    goto :goto_0

    .line 175
    :cond_6
    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/internal/Excluder;->isAnonymousOrLocal(Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_7

    move v4, v6

    .line 176
    goto :goto_0

    .line 179
    :cond_7
    if-eqz p2, :cond_a

    iget-object v3, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    .line 180
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :goto_1
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_9

    .line 181
    new-instance v2, Lcom/pwrd/google/gson/FieldAttributes;

    invoke-direct {v2, p1}, Lcom/pwrd/google/gson/FieldAttributes;-><init>(Ljava/lang/reflect/Field;)V

    .line 182
    .local v2, "fieldAttributes":Lcom/pwrd/google/gson/FieldAttributes;
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_8
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_b

    .line 189
    .end local v2    # "fieldAttributes":Lcom/pwrd/google/gson/FieldAttributes;
    :cond_9
    const/4 v4, 0x0

    goto :goto_0

    .line 179
    .end local v3    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :cond_a
    iget-object v3, p0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    goto :goto_1

    .line 182
    .restart local v2    # "fieldAttributes":Lcom/pwrd/google/gson/FieldAttributes;
    .restart local v3    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/pwrd/google/gson/ExclusionStrategy;>;"
    :cond_b
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/pwrd/google/gson/ExclusionStrategy;

    .line 183
    .local v1, "exclusionStrategy":Lcom/pwrd/google/gson/ExclusionStrategy;
    invoke-interface {v1, v2}, Lcom/pwrd/google/gson/ExclusionStrategy;->shouldSkipField(Lcom/pwrd/google/gson/FieldAttributes;)Z

    move-result v5

    if-eqz v5, :cond_8

    move v4, v6

    .line 184
    goto/16 :goto_0
.end method

.method public excludeFieldsWithoutExposeAnnotation()Lcom/pwrd/google/gson/internal/Excluder;
    .locals 2

    .prologue
    .line 92
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v0

    .line 93
    .local v0, "result":Lcom/pwrd/google/gson/internal/Excluder;
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->requireExpose:Z

    .line 94
    return-object v0
.end method

.method public withExclusionStrategy(Lcom/pwrd/google/gson/ExclusionStrategy;ZZ)Lcom/pwrd/google/gson/internal/Excluder;
    .locals 3
    .param p1, "exclusionStrategy"    # Lcom/pwrd/google/gson/ExclusionStrategy;
    .param p2, "serialization"    # Z
    .param p3, "deserialization"    # Z

    .prologue
    .line 99
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v0

    .line 100
    .local v0, "result":Lcom/pwrd/google/gson/internal/Excluder;
    if-eqz p2, :cond_0

    .line 101
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    .line 102
    iget-object v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->serializationStrategies:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 104
    :cond_0
    if-eqz p3, :cond_1

    .line 106
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 105
    iput-object v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    .line 107
    iget-object v1, v0, Lcom/pwrd/google/gson/internal/Excluder;->deserializationStrategies:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 109
    :cond_1
    return-object v0
.end method

.method public varargs withModifiers([I)Lcom/pwrd/google/gson/internal/Excluder;
    .locals 5
    .param p1, "modifiers"    # [I

    .prologue
    const/4 v2, 0x0

    .line 77
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v1

    .line 78
    .local v1, "result":Lcom/pwrd/google/gson/internal/Excluder;
    iput v2, v1, Lcom/pwrd/google/gson/internal/Excluder;->modifiers:I

    .line 79
    array-length v3, p1

    :goto_0
    if-lt v2, v3, :cond_0

    .line 82
    return-object v1

    .line 79
    :cond_0
    aget v0, p1, v2

    .line 80
    .local v0, "modifier":I
    iget v4, v1, Lcom/pwrd/google/gson/internal/Excluder;->modifiers:I

    or-int/2addr v4, v0

    iput v4, v1, Lcom/pwrd/google/gson/internal/Excluder;->modifiers:I

    .line 79
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public withVersion(D)Lcom/pwrd/google/gson/internal/Excluder;
    .locals 1
    .param p1, "ignoreVersionsAfter"    # D

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/pwrd/google/gson/internal/Excluder;->clone()Lcom/pwrd/google/gson/internal/Excluder;

    move-result-object v0

    .line 72
    .local v0, "result":Lcom/pwrd/google/gson/internal/Excluder;
    iput-wide p1, v0, Lcom/pwrd/google/gson/internal/Excluder;->version:D

    .line 73
    return-object v0
.end method
