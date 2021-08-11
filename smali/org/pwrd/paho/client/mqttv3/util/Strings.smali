.class public final Lorg/pwrd/paho/client/mqttv3/util/Strings;
.super Ljava/lang/Object;
.source "Strings.java"


# static fields
.field private static final INDEX_NOT_FOUND:I = -0x1


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 169
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 171
    return-void
.end method

.method public static containsAny(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .locals 1
    .param p0, "cs"    # Ljava/lang/CharSequence;
    .param p1, "searchChars"    # Ljava/lang/CharSequence;

    .prologue
    .line 56
    if-nez p1, :cond_0

    .line 57
    const/4 v0, 0x0

    .line 59
    :goto_0
    return v0

    :cond_0
    invoke-static {p1}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->toCharArray(Ljava/lang/CharSequence;)[C

    move-result-object v0

    invoke-static {p0, v0}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->containsAny(Ljava/lang/CharSequence;[C)Z

    move-result v0

    goto :goto_0
.end method

.method public static containsAny(Ljava/lang/CharSequence;[C)Z
    .locals 11
    .param p0, "cs"    # Ljava/lang/CharSequence;
    .param p1, "searchChars"    # [C

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 70
    invoke-static {p0}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    invoke-static {p1}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->isEmpty([C)Z

    move-result v9

    if-eqz v9, :cond_2

    :cond_0
    move v7, v8

    .line 97
    :cond_1
    :goto_0
    return v7

    .line 73
    :cond_2
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 74
    .local v2, "csLength":I
    array-length v6, p1

    .line 75
    .local v6, "searchLength":I
    add-int/lit8 v1, v2, -0x1

    .line 76
    .local v1, "csLast":I
    add-int/lit8 v5, v6, -0x1

    .line 77
    .local v5, "searchLast":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-lt v3, v2, :cond_3

    move v7, v8

    .line 97
    goto :goto_0

    .line 78
    :cond_3
    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 79
    .local v0, "ch":C
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_2
    if-lt v4, v6, :cond_4

    .line 77
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 80
    :cond_4
    aget-char v9, p1, v4

    if-ne v9, v0, :cond_5

    .line 81
    invoke-static {v0}, Ljava/lang/Character;->isHighSurrogate(C)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 82
    if-eq v4, v5, :cond_1

    .line 86
    if-ge v3, v1, :cond_5

    add-int/lit8 v9, v4, 0x1

    aget-char v9, p1, v9

    add-int/lit8 v10, v3, 0x1

    invoke-interface {p0, v10}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v10

    if-eq v9, v10, :cond_1

    .line 79
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_2
.end method

.method public static countMatches(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I
    .locals 3
    .param p0, "str"    # Ljava/lang/CharSequence;
    .param p1, "sub"    # Ljava/lang/CharSequence;

    .prologue
    .line 145
    invoke-static {p0}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {p1}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 146
    :cond_0
    const/4 v0, 0x0

    .line 154
    :cond_1
    return v0

    .line 148
    :cond_2
    const/4 v0, 0x0

    .line 149
    .local v0, "count":I
    const/4 v1, 0x0

    .line 150
    .local v1, "idx":I
    :goto_0
    invoke-static {p0, p1, v1}, Lorg/pwrd/paho/client/mqttv3/util/Strings;->indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_1

    .line 151
    add-int/lit8 v0, v0, 0x1

    .line 152
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    add-int/2addr v1, v2

    goto :goto_0
.end method

.method public static equalsAny(Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
    .locals 5
    .param p0, "cs"    # Ljava/lang/CharSequence;
    .param p1, "strs"    # [Ljava/lang/CharSequence;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 34
    const/4 v0, 0x0

    .line 35
    .local v0, "eq":Z
    if-nez p0, :cond_0

    .line 36
    if-nez p1, :cond_2

    move v0, v2

    .line 39
    :cond_0
    :goto_0
    if-eqz p1, :cond_1

    .line 40
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v4, p1

    if-lt v1, v4, :cond_3

    .line 45
    .end local v1    # "i":I
    :cond_1
    return v0

    :cond_2
    move v0, v3

    .line 36
    goto :goto_0

    .line 41
    .restart local v1    # "i":I
    :cond_3
    if-nez v0, :cond_4

    aget-object v4, p1, v1

    invoke-virtual {v4, p0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    move v0, v3

    .line 40
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_4
    move v0, v2

    .line 41
    goto :goto_2
.end method

.method private static indexOf(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)I
    .locals 2
    .param p0, "cs"    # Ljava/lang/CharSequence;
    .param p1, "searchChar"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I

    .prologue
    .line 166
    invoke-interface {p0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static isEmpty(Ljava/lang/CharSequence;)Z
    .locals 1
    .param p0, "cs"    # Ljava/lang/CharSequence;

    .prologue
    .line 107
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static isEmpty([C)Z
    .locals 1
    .param p0, "array"    # [C

    .prologue
    .line 114
    if-eqz p0, :cond_0

    array-length v0, p0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static toCharArray(Ljava/lang/CharSequence;)[C
    .locals 4
    .param p0, "cs"    # Ljava/lang/CharSequence;

    .prologue
    .line 124
    instance-of v3, p0, Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 125
    check-cast p0, Ljava/lang/String;

    .end local p0    # "cs":Ljava/lang/CharSequence;
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 133
    .local v0, "array":[C
    .local v1, "i":I
    .local v2, "sz":I
    .restart local p0    # "cs":Ljava/lang/CharSequence;
    :cond_0
    return-object v0

    .line 128
    .end local v0    # "array":[C
    .end local v1    # "i":I
    .end local v2    # "sz":I
    :cond_1
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 129
    .restart local v2    # "sz":I
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v3

    new-array v0, v3, [C

    .line 130
    .restart local v0    # "array":[C
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 131
    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    aput-char v3, v0, v1

    .line 130
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
