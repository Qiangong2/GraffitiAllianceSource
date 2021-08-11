.class public final enum Lcom/tencent/cos/xml/common/Permission;
.super Ljava/lang/Enum;
.source "Permission.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/common/Permission;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/common/Permission;

.field public static final enum FULL_CONTROL:Lcom/tencent/cos/xml/common/Permission;

.field public static final enum READ:Lcom/tencent/cos/xml/common/Permission;

.field public static final enum WRITE:Lcom/tencent/cos/xml/common/Permission;


# instance fields
.field private permission:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 14
    new-instance v0, Lcom/tencent/cos/xml/common/Permission;

    const-string v1, "READ"

    const-string v2, "READ"

    invoke-direct {v0, v1, v3, v2}, Lcom/tencent/cos/xml/common/Permission;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Permission;->READ:Lcom/tencent/cos/xml/common/Permission;

    .line 16
    new-instance v0, Lcom/tencent/cos/xml/common/Permission;

    const-string v1, "WRITE"

    const-string v2, "WRITE"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/common/Permission;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Permission;->WRITE:Lcom/tencent/cos/xml/common/Permission;

    .line 18
    new-instance v0, Lcom/tencent/cos/xml/common/Permission;

    const-string v1, "FULL_CONTROL"

    const-string v2, "FULL_CONTROL"

    invoke-direct {v0, v1, v5, v2}, Lcom/tencent/cos/xml/common/Permission;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Permission;->FULL_CONTROL:Lcom/tencent/cos/xml/common/Permission;

    .line 12
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/tencent/cos/xml/common/Permission;

    sget-object v1, Lcom/tencent/cos/xml/common/Permission;->READ:Lcom/tencent/cos/xml/common/Permission;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/cos/xml/common/Permission;->WRITE:Lcom/tencent/cos/xml/common/Permission;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/cos/xml/common/Permission;->FULL_CONTROL:Lcom/tencent/cos/xml/common/Permission;

    aput-object v1, v0, v5

    sput-object v0, Lcom/tencent/cos/xml/common/Permission;->$VALUES:[Lcom/tencent/cos/xml/common/Permission;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "permission"    # Ljava/lang/String;
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
    iput-object p3, p0, Lcom/tencent/cos/xml/common/Permission;->permission:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/tencent/cos/xml/common/Permission;
    .locals 5
    .param p0, "permission"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {}, Lcom/tencent/cos/xml/common/Permission;->values()[Lcom/tencent/cos/xml/common/Permission;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 28
    .local v0, "permission1":Lcom/tencent/cos/xml/common/Permission;
    iget-object v4, v0, Lcom/tencent/cos/xml/common/Permission;->permission:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 32
    .end local v0    # "permission1":Lcom/tencent/cos/xml/common/Permission;
    :goto_1
    return-object v0

    .line 27
    .restart local v0    # "permission1":Lcom/tencent/cos/xml/common/Permission;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 32
    .end local v0    # "permission1":Lcom/tencent/cos/xml/common/Permission;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/common/Permission;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 12
    const-class v0, Lcom/tencent/cos/xml/common/Permission;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/common/Permission;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/common/Permission;
    .locals 1

    .prologue
    .line 12
    sget-object v0, Lcom/tencent/cos/xml/common/Permission;->$VALUES:[Lcom/tencent/cos/xml/common/Permission;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/common/Permission;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/common/Permission;

    return-object v0
.end method


# virtual methods
.method public getPermission()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/tencent/cos/xml/common/Permission;->permission:Ljava/lang/String;

    return-object v0
.end method
