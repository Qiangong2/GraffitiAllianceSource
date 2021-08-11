.class final enum Lcom/tencent/qcloud/core/logger/RecordLevel;
.super Ljava/lang/Enum;
.source "RecordLevel.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/tencent/qcloud/core/logger/RecordLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/tencent/qcloud/core/logger/RecordLevel;

.field public static final enum DEBUG:Lcom/tencent/qcloud/core/logger/RecordLevel;

.field public static final enum ERROR:Lcom/tencent/qcloud/core/logger/RecordLevel;

.field public static final enum INFO:Lcom/tencent/qcloud/core/logger/RecordLevel;

.field public static final enum VERBOSE:Lcom/tencent/qcloud/core/logger/RecordLevel;

.field public static final enum WARN:Lcom/tencent/qcloud/core/logger/RecordLevel;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    const-string v1, "VERBOSE"

    invoke-direct {v0, v1, v2}, Lcom/tencent/qcloud/core/logger/RecordLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->VERBOSE:Lcom/tencent/qcloud/core/logger/RecordLevel;

    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    const-string v1, "DEBUG"

    invoke-direct {v0, v1, v3}, Lcom/tencent/qcloud/core/logger/RecordLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->DEBUG:Lcom/tencent/qcloud/core/logger/RecordLevel;

    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    const-string v1, "INFO"

    invoke-direct {v0, v1, v4}, Lcom/tencent/qcloud/core/logger/RecordLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->INFO:Lcom/tencent/qcloud/core/logger/RecordLevel;

    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    const-string v1, "WARN"

    invoke-direct {v0, v1, v5}, Lcom/tencent/qcloud/core/logger/RecordLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->WARN:Lcom/tencent/qcloud/core/logger/RecordLevel;

    new-instance v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v6}, Lcom/tencent/qcloud/core/logger/RecordLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->ERROR:Lcom/tencent/qcloud/core/logger/RecordLevel;

    .line 8
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/tencent/qcloud/core/logger/RecordLevel;

    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLevel;->VERBOSE:Lcom/tencent/qcloud/core/logger/RecordLevel;

    aput-object v1, v0, v2

    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLevel;->DEBUG:Lcom/tencent/qcloud/core/logger/RecordLevel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLevel;->INFO:Lcom/tencent/qcloud/core/logger/RecordLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLevel;->WARN:Lcom/tencent/qcloud/core/logger/RecordLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/tencent/qcloud/core/logger/RecordLevel;->ERROR:Lcom/tencent/qcloud/core/logger/RecordLevel;

    aput-object v1, v0, v6

    sput-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->$VALUES:[Lcom/tencent/qcloud/core/logger/RecordLevel;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 8
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/qcloud/core/logger/RecordLevel;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/qcloud/core/logger/RecordLevel;

    return-object v0
.end method

.method public static values()[Lcom/tencent/qcloud/core/logger/RecordLevel;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/tencent/qcloud/core/logger/RecordLevel;->$VALUES:[Lcom/tencent/qcloud/core/logger/RecordLevel;

    invoke-virtual {v0}, [Lcom/tencent/qcloud/core/logger/RecordLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/qcloud/core/logger/RecordLevel;

    return-object v0
.end method
