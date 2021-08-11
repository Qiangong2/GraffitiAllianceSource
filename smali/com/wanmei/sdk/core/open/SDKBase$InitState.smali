.class final enum Lcom/wanmei/sdk/core/open/SDKBase$InitState;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/open/SDKBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "InitState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/open/SDKBase$InitState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$InitState;

.field public static final enum fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

.field public static final enum process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

.field public static final enum success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    const-string v1, "success"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/open/SDKBase$InitState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    const-string v1, "process"

    invoke-direct {v0, v1, v3}, Lcom/wanmei/sdk/core/open/SDKBase$InitState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    new-instance v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    const-string v1, "fail"

    invoke-direct {v0, v1, v4}, Lcom/wanmei/sdk/core/open/SDKBase$InitState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->success:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->process:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->fail:Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    aput-object v1, v0, v4

    sput-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$InitState;

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

.method public static valueOf(Ljava/lang/String;)Lcom/wanmei/sdk/core/open/SDKBase$InitState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const-class v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    return-object v0
.end method

.method public static values()[Lcom/wanmei/sdk/core/open/SDKBase$InitState;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/open/SDKBase$InitState;->$VALUES:[Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/open/SDKBase$InitState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/open/SDKBase$InitState;

    return-object v0
.end method
