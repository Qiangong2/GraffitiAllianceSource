.class public final enum Lcom/tencent/cos/xml/common/Region;
.super Ljava/lang/Enum;
.source "Region.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/cos/xml/common/Region;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Beijing:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Beijing_1:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Chengdu:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Guangzhou:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Guangzhou_2:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Hongkong:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Shanghai:Lcom/tencent/cos/xml/common/Region;

.field public static final enum AP_Singapore:Lcom/tencent/cos/xml/common/Region;

.field public static final enum CN_EAST:Lcom/tencent/cos/xml/common/Region;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum CN_NORTH:Lcom/tencent/cos/xml/common/Region;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum CN_SOUTH:Lcom/tencent/cos/xml/common/Region;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum CN_SOUTHWEST:Lcom/tencent/cos/xml/common/Region;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final enum EU_Frankfurt:Lcom/tencent/cos/xml/common/Region;

.field public static final enum NA_Toronto:Lcom/tencent/cos/xml/common/Region;

.field public static final enum SG:Lcom/tencent/cos/xml/common/Region;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# instance fields
.field private region:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 16
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Beijing_1"

    const-string v2, "ap-beijing-1"

    invoke-direct {v0, v1, v4, v2}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Beijing_1:Lcom/tencent/cos/xml/common/Region;

    .line 18
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Beijing"

    const-string v2, "ap-beijing"

    invoke-direct {v0, v1, v5, v2}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Beijing:Lcom/tencent/cos/xml/common/Region;

    .line 20
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Shanghai"

    const-string v2, "ap-shanghai"

    invoke-direct {v0, v1, v6, v2}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Shanghai:Lcom/tencent/cos/xml/common/Region;

    .line 22
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Guangzhou"

    const-string v2, "ap-guangzhou"

    invoke-direct {v0, v1, v7, v2}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Guangzhou:Lcom/tencent/cos/xml/common/Region;

    .line 24
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Guangzhou_2"

    const-string v2, "ap-guangzhou-2"

    invoke-direct {v0, v1, v8, v2}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Guangzhou_2:Lcom/tencent/cos/xml/common/Region;

    .line 26
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Chengdu"

    const/4 v2, 0x5

    const-string v3, "ap-chengdu"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Chengdu:Lcom/tencent/cos/xml/common/Region;

    .line 28
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Singapore"

    const/4 v2, 0x6

    const-string v3, "ap-singapore"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Singapore:Lcom/tencent/cos/xml/common/Region;

    .line 30
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "AP_Hongkong"

    const/4 v2, 0x7

    const-string v3, "ap-hongkong"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Hongkong:Lcom/tencent/cos/xml/common/Region;

    .line 32
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "NA_Toronto"

    const/16 v2, 0x8

    const-string v3, "na-toronto"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->NA_Toronto:Lcom/tencent/cos/xml/common/Region;

    .line 34
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "EU_Frankfurt"

    const/16 v2, 0x9

    const-string v3, "eu-frankfurt"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->EU_Frankfurt:Lcom/tencent/cos/xml/common/Region;

    .line 37
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "CN_NORTH"

    const/16 v2, 0xa

    const-string v3, "cn-north"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->CN_NORTH:Lcom/tencent/cos/xml/common/Region;

    .line 41
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "CN_SOUTH"

    const/16 v2, 0xb

    const-string v3, "cn-south"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->CN_SOUTH:Lcom/tencent/cos/xml/common/Region;

    .line 45
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "CN_EAST"

    const/16 v2, 0xc

    const-string v3, "cn-east"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->CN_EAST:Lcom/tencent/cos/xml/common/Region;

    .line 49
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "CN_SOUTHWEST"

    const/16 v2, 0xd

    const-string v3, "cn-southwest"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->CN_SOUTHWEST:Lcom/tencent/cos/xml/common/Region;

    .line 53
    new-instance v0, Lcom/tencent/cos/xml/common/Region;

    const-string v1, "SG"

    const/16 v2, 0xe

    const-string v3, "sg"

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/common/Region;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->SG:Lcom/tencent/cos/xml/common/Region;

    .line 7
    const/16 v0, 0xf

    new-array v0, v0, [Lcom/tencent/cos/xml/common/Region;

    sget-object v1, Lcom/tencent/cos/xml/common/Region;->AP_Beijing_1:Lcom/tencent/cos/xml/common/Region;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/cos/xml/common/Region;->AP_Beijing:Lcom/tencent/cos/xml/common/Region;

    aput-object v1, v0, v5

    sget-object v1, Lcom/tencent/cos/xml/common/Region;->AP_Shanghai:Lcom/tencent/cos/xml/common/Region;

    aput-object v1, v0, v6

    sget-object v1, Lcom/tencent/cos/xml/common/Region;->AP_Guangzhou:Lcom/tencent/cos/xml/common/Region;

    aput-object v1, v0, v7

    sget-object v1, Lcom/tencent/cos/xml/common/Region;->AP_Guangzhou_2:Lcom/tencent/cos/xml/common/Region;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->AP_Chengdu:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->AP_Singapore:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->AP_Hongkong:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->NA_Toronto:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->EU_Frankfurt:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->CN_NORTH:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->CN_SOUTH:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->CN_EAST:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->CN_SOUTHWEST:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/tencent/cos/xml/common/Region;->SG:Lcom/tencent/cos/xml/common/Region;

    aput-object v2, v0, v1

    sput-object v0, Lcom/tencent/cos/xml/common/Region;->$VALUES:[Lcom/tencent/cos/xml/common/Region;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "region"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 57
    iput-object p3, p0, Lcom/tencent/cos/xml/common/Region;->region:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/tencent/cos/xml/common/Region;
    .locals 5
    .param p0, "region"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {}, Lcom/tencent/cos/xml/common/Region;->values()[Lcom/tencent/cos/xml/common/Region;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 65
    .local v0, "region1":Lcom/tencent/cos/xml/common/Region;
    iget-object v4, v0, Lcom/tencent/cos/xml/common/Region;->region:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 69
    .end local v0    # "region1":Lcom/tencent/cos/xml/common/Region;
    :goto_1
    return-object v0

    .line 64
    .restart local v0    # "region1":Lcom/tencent/cos/xml/common/Region;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 69
    .end local v0    # "region1":Lcom/tencent/cos/xml/common/Region;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/cos/xml/common/Region;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/tencent/cos/xml/common/Region;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/common/Region;

    return-object v0
.end method

.method public static values()[Lcom/tencent/cos/xml/common/Region;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/tencent/cos/xml/common/Region;->$VALUES:[Lcom/tencent/cos/xml/common/Region;

    invoke-virtual {v0}, [Lcom/tencent/cos/xml/common/Region;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/cos/xml/common/Region;

    return-object v0
.end method


# virtual methods
.method public getRegion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/tencent/cos/xml/common/Region;->region:Ljava/lang/String;

    return-object v0
.end method
