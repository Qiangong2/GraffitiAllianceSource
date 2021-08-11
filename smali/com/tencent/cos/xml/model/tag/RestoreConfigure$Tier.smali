.class public final enum Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;
.super Ljava/lang/Enum;
.source "RestoreConfigure.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/cos/xml/model/tag/RestoreConfigure;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Tier"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

.field public static final enum Bulk:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

.field public static final enum Expedited:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

.field public static final enum Standard:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;


# instance fields
.field private tier:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 34
    new-instance v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    const-string v1, "Expedited"

    const-string v2, "Expedited"

    invoke-direct {v0, v1, v3, v2}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Expedited:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    .line 35
    new-instance v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    const-string v1, "Standard"

    const-string v2, "Standard"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Standard:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    .line 36
    new-instance v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    const-string v1, "Bulk"

    const-string v2, "Bulk"

    invoke-direct {v0, v1, v5, v2}, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Bulk:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    .line 33
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    sget-object v1, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Expedited:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Standard:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->Bulk:Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    aput-object v1, v0, v5

    sput-object v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->$VALUES:[Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "tier"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 39
    iput-object p3, p0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->tier:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 33
    const-class v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->$VALUES:[Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;

    return-object v0
.end method


# virtual methods
.method public getTier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/tencent/cos/xml/model/tag/RestoreConfigure$Tier;->tier:Ljava/lang/String;

    return-object v0
.end method
