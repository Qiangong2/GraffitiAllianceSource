.class public abstract enum Lcom/pwrd/google/gson/FieldNamingPolicy;
.super Ljava/lang/Enum;
.source "FieldNamingPolicy.java"

# interfaces
.implements Lcom/pwrd/google/gson/FieldNamingStrategy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/pwrd/google/gson/FieldNamingPolicy;",
        ">;",
        "Lcom/pwrd/google/gson/FieldNamingStrategy;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/pwrd/google/gson/FieldNamingPolicy;

.field public static final enum IDENTITY:Lcom/pwrd/google/gson/FieldNamingPolicy;

.field public static final enum LOWER_CASE_WITH_DASHES:Lcom/pwrd/google/gson/FieldNamingPolicy;

.field public static final enum LOWER_CASE_WITH_UNDERSCORES:Lcom/pwrd/google/gson/FieldNamingPolicy;

.field public static final enum UPPER_CAMEL_CASE:Lcom/pwrd/google/gson/FieldNamingPolicy;

.field public static final enum UPPER_CAMEL_CASE_WITH_SPACES:Lcom/pwrd/google/gson/FieldNamingPolicy;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 33
    new-instance v0, Lcom/pwrd/google/gson/FieldNamingPolicy$1;

    const-string v1, "IDENTITY"

    invoke-direct {v0, v1, v2}, Lcom/pwrd/google/gson/FieldNamingPolicy$1;-><init>(Ljava/lang/String;I)V

    .line 37
    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 43
    new-instance v0, Lcom/pwrd/google/gson/FieldNamingPolicy$2;

    const-string v1, "UPPER_CAMEL_CASE"

    invoke-direct {v0, v1, v3}, Lcom/pwrd/google/gson/FieldNamingPolicy$2;-><init>(Ljava/lang/String;I)V

    .line 53
    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->UPPER_CAMEL_CASE:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 59
    new-instance v0, Lcom/pwrd/google/gson/FieldNamingPolicy$3;

    const-string v1, "UPPER_CAMEL_CASE_WITH_SPACES"

    invoke-direct {v0, v1, v4}, Lcom/pwrd/google/gson/FieldNamingPolicy$3;-><init>(Ljava/lang/String;I)V

    .line 72
    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->UPPER_CAMEL_CASE_WITH_SPACES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 78
    new-instance v0, Lcom/pwrd/google/gson/FieldNamingPolicy$4;

    const-string v1, "LOWER_CASE_WITH_UNDERSCORES"

    invoke-direct {v0, v1, v5}, Lcom/pwrd/google/gson/FieldNamingPolicy$4;-><init>(Ljava/lang/String;I)V

    .line 90
    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 96
    new-instance v0, Lcom/pwrd/google/gson/FieldNamingPolicy$5;

    const-string v1, "LOWER_CASE_WITH_DASHES"

    invoke-direct {v0, v1, v6}, Lcom/pwrd/google/gson/FieldNamingPolicy$5;-><init>(Ljava/lang/String;I)V

    .line 113
    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_DASHES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    .line 31
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/pwrd/google/gson/FieldNamingPolicy;

    sget-object v1, Lcom/pwrd/google/gson/FieldNamingPolicy;->IDENTITY:Lcom/pwrd/google/gson/FieldNamingPolicy;

    aput-object v1, v0, v2

    sget-object v1, Lcom/pwrd/google/gson/FieldNamingPolicy;->UPPER_CAMEL_CASE:Lcom/pwrd/google/gson/FieldNamingPolicy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/pwrd/google/gson/FieldNamingPolicy;->UPPER_CAMEL_CASE_WITH_SPACES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    aput-object v1, v0, v4

    sget-object v1, Lcom/pwrd/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_UNDERSCORES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    aput-object v1, v0, v5

    sget-object v1, Lcom/pwrd/google/gson/FieldNamingPolicy;->LOWER_CASE_WITH_DASHES:Lcom/pwrd/google/gson/FieldNamingPolicy;

    aput-object v1, v0, v6

    sput-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->ENUM$VALUES:[Lcom/pwrd/google/gson/FieldNamingPolicy;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/pwrd/google/gson/FieldNamingPolicy;)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Lcom/pwrd/google/gson/FieldNamingPolicy;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method static synthetic access$3(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    invoke-static {p0}, Lcom/pwrd/google/gson/FieldNamingPolicy;->upperCaseFirstLetter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    invoke-static {p0, p1}, Lcom/pwrd/google/gson/FieldNamingPolicy;->separateCamelCase(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static modifyString(CLjava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p0, "firstCharacter"    # C
    .param p1, "srcString"    # Ljava/lang/String;
    .param p2, "indexOfSubstring"    # I

    .prologue
    .line 165
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p2, v0, :cond_0

    .line 166
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 165
    :goto_0
    return-object v0

    .line 167
    :cond_0
    invoke-static {p0}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static separateCamelCase(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "separator"    # Ljava/lang/String;

    .prologue
    .line 124
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 125
    .local v2, "translation":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-lt v1, v3, :cond_0

    .line 132
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 126
    :cond_0
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 127
    .local v0, "character":C
    invoke-static {v0}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-eqz v3, :cond_1

    .line 128
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 130
    :cond_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 125
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private static upperCaseFirstLetter(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 139
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 140
    .local v0, "fieldNameBuilder":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 141
    .local v2, "index":I
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 143
    .local v1, "firstCharacter":C
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-lt v2, v4, :cond_2

    .line 152
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-ne v2, v4, :cond_3

    .line 153
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 160
    .end local p0    # "name":Ljava/lang/String;
    :cond_1
    :goto_1
    return-object p0

    .line 144
    .restart local p0    # "name":Ljava/lang/String;
    :cond_2
    invoke-static {v1}, Ljava/lang/Character;->isLetter(C)Z

    move-result v4

    if-nez v4, :cond_0

    .line 148
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 149
    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    goto :goto_0

    .line 156
    :cond_3
    invoke-static {v1}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v4

    if-nez v4, :cond_1

    .line 157
    invoke-static {v1}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v4

    add-int/lit8 v2, v2, 0x1

    invoke-static {v4, p0, v2}, Lcom/pwrd/google/gson/FieldNamingPolicy;->modifyString(CLjava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    .line 158
    .local v3, "modifiedTarget":Ljava/lang/String;
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/pwrd/google/gson/FieldNamingPolicy;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/pwrd/google/gson/FieldNamingPolicy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/pwrd/google/gson/FieldNamingPolicy;

    return-object v0
.end method

.method public static values()[Lcom/pwrd/google/gson/FieldNamingPolicy;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/pwrd/google/gson/FieldNamingPolicy;->ENUM$VALUES:[Lcom/pwrd/google/gson/FieldNamingPolicy;

    array-length v1, v0

    new-array v2, v1, [Lcom/pwrd/google/gson/FieldNamingPolicy;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
