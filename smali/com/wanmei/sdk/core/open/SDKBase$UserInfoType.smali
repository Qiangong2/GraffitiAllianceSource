.class public final enum Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/open/SDKBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "UserInfoType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

.field public static final enum CREATE_ROLE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

.field public static final enum LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

.field public static final enum ROLE_LEVEL_CHANGE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    const-string v1, "CREATE_ROLE"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->CREATE_ROLE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    const-string v1, "LOGIN"

    invoke-direct {v0, v1, v3}, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    const-string v1, "ROLE_LEVEL_CHANGE"

    invoke-direct {v0, v1, v4}, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->ROLE_LEVEL_CHANGE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->CREATE_ROLE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->ROLE_LEVEL_CHANGE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const-class v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    return-object v0
.end method

.method public static values()[Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    return-object v0
.end method
