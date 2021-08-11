.class public final enum Lcom/tencent/cos/xml/common/COSStorageClass;
.super Ljava/lang/Enum;
.source "COSStorageClass.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/common/COSStorageClass;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/common/COSStorageClass;

.field public static final enum NEARLINE:Lcom/tencent/cos/xml/common/COSStorageClass;

.field public static final enum STANDARD:Lcom/tencent/cos/xml/common/COSStorageClass;

.field public static final enum STANDARD_IA:Lcom/tencent/cos/xml/common/COSStorageClass;


# instance fields
.field private cosStorageClass:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 14
    new-instance v0, Lcom/tencent/cos/xml/common/COSStorageClass;

    const-string v1, "STANDARD"

    const-string v2, "Standard"

    invoke-direct {v0, v1, v3, v2}, Lcom/tencent/cos/xml/common/COSStorageClass;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSStorageClass;->STANDARD:Lcom/tencent/cos/xml/common/COSStorageClass;

    .line 17
    new-instance v0, Lcom/tencent/cos/xml/common/COSStorageClass;

    const-string v1, "STANDARD_IA"

    const-string v2, "Standard_IA"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/common/COSStorageClass;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSStorageClass;->STANDARD_IA:Lcom/tencent/cos/xml/common/COSStorageClass;

    .line 20
    new-instance v0, Lcom/tencent/cos/xml/common/COSStorageClass;

    const-string v1, "NEARLINE"

    const-string v2, "Nearline"

    invoke-direct {v0, v1, v5, v2}, Lcom/tencent/cos/xml/common/COSStorageClass;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSStorageClass;->NEARLINE:Lcom/tencent/cos/xml/common/COSStorageClass;

    .line 11
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/tencent/cos/xml/common/COSStorageClass;

    sget-object v1, Lcom/tencent/cos/xml/common/COSStorageClass;->STANDARD:Lcom/tencent/cos/xml/common/COSStorageClass;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/cos/xml/common/COSStorageClass;->STANDARD_IA:Lcom/tencent/cos/xml/common/COSStorageClass;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/cos/xml/common/COSStorageClass;->NEARLINE:Lcom/tencent/cos/xml/common/COSStorageClass;

    aput-object v1, v0, v5

    sput-object v0, Lcom/tencent/cos/xml/common/COSStorageClass;->$VALUES:[Lcom/tencent/cos/xml/common/COSStorageClass;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "cosStorageClass"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 26
    iput-object p3, p0, Lcom/tencent/cos/xml/common/COSStorageClass;->cosStorageClass:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/tencent/cos/xml/common/COSStorageClass;
    .locals 5
    .param p0, "cosStorageClass"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-static {}, Lcom/tencent/cos/xml/common/COSStorageClass;->values()[Lcom/tencent/cos/xml/common/COSStorageClass;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 35
    .local v0, "storageClass":Lcom/tencent/cos/xml/common/COSStorageClass;
    iget-object v4, v0, Lcom/tencent/cos/xml/common/COSStorageClass;->cosStorageClass:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 39
    .end local v0    # "storageClass":Lcom/tencent/cos/xml/common/COSStorageClass;
    :goto_1
    return-object v0

    .line 34
    .restart local v0    # "storageClass":Lcom/tencent/cos/xml/common/COSStorageClass;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 39
    .end local v0    # "storageClass":Lcom/tencent/cos/xml/common/COSStorageClass;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/common/COSStorageClass;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/tencent/cos/xml/common/COSStorageClass;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/common/COSStorageClass;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/common/COSStorageClass;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/tencent/cos/xml/common/COSStorageClass;->$VALUES:[Lcom/tencent/cos/xml/common/COSStorageClass;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/common/COSStorageClass;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/common/COSStorageClass;

    return-object v0
.end method


# virtual methods
.method public getStorageClass()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/tencent/cos/xml/common/COSStorageClass;->cosStorageClass:Ljava/lang/String;

    return-object v0
.end method
