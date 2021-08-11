.class public final enum Lcom/tencent/cos/xml/common/MetaDataDirective;
.super Ljava/lang/Enum;
.source "MetaDataDirective.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/common/MetaDataDirective;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/common/MetaDataDirective;

.field public static final enum COPY:Lcom/tencent/cos/xml/common/MetaDataDirective;

.field public static final enum REPLACED:Lcom/tencent/cos/xml/common/MetaDataDirective;


# instance fields
.field directive:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 13
    new-instance v0, Lcom/tencent/cos/xml/common/MetaDataDirective;

    const-string v1, "COPY"

    const-string v2, "Copy"

    invoke-direct {v0, v1, v3, v2}, Lcom/tencent/cos/xml/common/MetaDataDirective;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/MetaDataDirective;->COPY:Lcom/tencent/cos/xml/common/MetaDataDirective;

    .line 15
    new-instance v0, Lcom/tencent/cos/xml/common/MetaDataDirective;

    const-string v1, "REPLACED"

    const-string v2, "Replaced"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/common/MetaDataDirective;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/MetaDataDirective;->REPLACED:Lcom/tencent/cos/xml/common/MetaDataDirective;

    .line 11
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/tencent/cos/xml/common/MetaDataDirective;

    sget-object v1, Lcom/tencent/cos/xml/common/MetaDataDirective;->COPY:Lcom/tencent/cos/xml/common/MetaDataDirective;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/cos/xml/common/MetaDataDirective;->REPLACED:Lcom/tencent/cos/xml/common/MetaDataDirective;

    aput-object v1, v0, v4

    sput-object v0, Lcom/tencent/cos/xml/common/MetaDataDirective;->$VALUES:[Lcom/tencent/cos/xml/common/MetaDataDirective;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "directive"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 19
    iput-object p3, p0, Lcom/tencent/cos/xml/common/MetaDataDirective;->directive:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/tencent/cos/xml/common/MetaDataDirective;
    .locals 5
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {}, Lcom/tencent/cos/xml/common/MetaDataDirective;->values()[Lcom/tencent/cos/xml/common/MetaDataDirective;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 28
    .local v0, "metaDataDirective":Lcom/tencent/cos/xml/common/MetaDataDirective;
    iget-object v4, v0, Lcom/tencent/cos/xml/common/MetaDataDirective;->directive:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 32
    .end local v0    # "metaDataDirective":Lcom/tencent/cos/xml/common/MetaDataDirective;
    :goto_1
    return-object v0

    .line 27
    .restart local v0    # "metaDataDirective":Lcom/tencent/cos/xml/common/MetaDataDirective;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 32
    .end local v0    # "metaDataDirective":Lcom/tencent/cos/xml/common/MetaDataDirective;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/common/MetaDataDirective;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/tencent/cos/xml/common/MetaDataDirective;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/common/MetaDataDirective;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/common/MetaDataDirective;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/tencent/cos/xml/common/MetaDataDirective;->$VALUES:[Lcom/tencent/cos/xml/common/MetaDataDirective;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/common/MetaDataDirective;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/common/MetaDataDirective;

    return-object v0
.end method


# virtual methods
.method public getMetaDirective()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/tencent/cos/xml/common/MetaDataDirective;->directive:Ljava/lang/String;

    return-object v0
.end method
