.class public final enum Lcom/tencent/cos/xml/common/COSACL;
.super Ljava/lang/Enum;
.source "COSACL.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/common/COSACL;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/common/COSACL;

.field public static final enum PRIVATE:Lcom/tencent/cos/xml/common/COSACL;

.field public static final enum PUBLIC_READ:Lcom/tencent/cos/xml/common/COSACL;

.field public static final enum PUBLIC_READ_WRITE:Lcom/tencent/cos/xml/common/COSACL;


# instance fields
.field private acl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 16
    new-instance v0, Lcom/tencent/cos/xml/common/COSACL;

    const-string v1, "PRIVATE"

    const-string v2, "private"

    invoke-direct {v0, v1, v3, v2}, Lcom/tencent/cos/xml/common/COSACL;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSACL;->PRIVATE:Lcom/tencent/cos/xml/common/COSACL;

    .line 17
    new-instance v0, Lcom/tencent/cos/xml/common/COSACL;

    const-string v1, "PUBLIC_READ"

    const-string v2, "public-read"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/common/COSACL;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSACL;->PUBLIC_READ:Lcom/tencent/cos/xml/common/COSACL;

    .line 18
    new-instance v0, Lcom/tencent/cos/xml/common/COSACL;

    const-string v1, "PUBLIC_READ_WRITE"

    const-string v2, "public-read-write"

    invoke-direct {v0, v1, v5, v2}, Lcom/tencent/cos/xml/common/COSACL;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/COSACL;->PUBLIC_READ_WRITE:Lcom/tencent/cos/xml/common/COSACL;

    .line 15
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/tencent/cos/xml/common/COSACL;

    sget-object v1, Lcom/tencent/cos/xml/common/COSACL;->PRIVATE:Lcom/tencent/cos/xml/common/COSACL;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/cos/xml/common/COSACL;->PUBLIC_READ:Lcom/tencent/cos/xml/common/COSACL;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/cos/xml/common/COSACL;->PUBLIC_READ_WRITE:Lcom/tencent/cos/xml/common/COSACL;

    aput-object v1, v0, v5

    sput-object v0, Lcom/tencent/cos/xml/common/COSACL;->$VALUES:[Lcom/tencent/cos/xml/common/COSACL;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "acl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 21
    iput-object p3, p0, Lcom/tencent/cos/xml/common/COSACL;->acl:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/tencent/cos/xml/common/COSACL;
    .locals 5
    .param p0, "acl"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {}, Lcom/tencent/cos/xml/common/COSACL;->values()[Lcom/tencent/cos/xml/common/COSACL;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 28
    .local v0, "cosacl":Lcom/tencent/cos/xml/common/COSACL;
    iget-object v4, v0, Lcom/tencent/cos/xml/common/COSACL;->acl:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 32
    .end local v0    # "cosacl":Lcom/tencent/cos/xml/common/COSACL;
    :goto_1
    return-object v0

    .line 27
    .restart local v0    # "cosacl":Lcom/tencent/cos/xml/common/COSACL;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 32
    .end local v0    # "cosacl":Lcom/tencent/cos/xml/common/COSACL;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/common/COSACL;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    const-class v0, Lcom/tencent/cos/xml/common/COSACL;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/common/COSACL;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/common/COSACL;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/tencent/cos/xml/common/COSACL;->$VALUES:[Lcom/tencent/cos/xml/common/COSACL;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/common/COSACL;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/common/COSACL;

    return-object v0
.end method


# virtual methods
.method public getAcl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/tencent/cos/xml/common/COSACL;->acl:Ljava/lang/String;

    return-object v0
.end method
