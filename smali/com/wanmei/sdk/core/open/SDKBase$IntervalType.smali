.class final enum Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/open/SDKBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "IntervalType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

.field public static final enum INIT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

.field public static final enum LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

.field public static final enum LOGOUT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

.field public static final enum PAY:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    const-string v1, "INIT"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->INIT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    const-string v1, "LOGIN"

    invoke-direct {v0, v1, v3}, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    const-string v1, "PAY"

    invoke-direct {v0, v1, v4}, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->PAY:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    const-string v1, "LOGOUT"

    invoke-direct {v0, v1, v5}, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->LOGOUT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->INIT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->PAY:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->LOGOUT:Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

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
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const-class v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    return-object v0
.end method

.method public static values()[Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/open/SDKBase$IntervalType;

    return-object v0
.end method
