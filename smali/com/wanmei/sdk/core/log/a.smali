.class public final enum Lcom/wanmei/sdk/core/log/a;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/log/a$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/log/a;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wanmei/sdk/core/log/a;

.field public static final enum b:Lcom/wanmei/sdk/core/log/a;

.field private static final synthetic c:[Lcom/wanmei/sdk/core/log/a;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/log/a;

    const-string v1, "NORMAL"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/log/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/log/a;->a:Lcom/wanmei/sdk/core/log/a;

    new-instance v0, Lcom/wanmei/sdk/core/log/a;

    const-string v1, "CRASH"

    invoke-direct {v0, v1, v3}, Lcom/wanmei/sdk/core/log/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/log/a;->b:Lcom/wanmei/sdk/core/log/a;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/wanmei/sdk/core/log/a;

    sget-object v1, Lcom/wanmei/sdk/core/log/a;->a:Lcom/wanmei/sdk/core/log/a;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wanmei/sdk/core/log/a;->b:Lcom/wanmei/sdk/core/log/a;

    aput-object v1, v0, v3

    sput-object v0, Lcom/wanmei/sdk/core/log/a;->c:[Lcom/wanmei/sdk/core/log/a;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static a(Lcom/wanmei/sdk/core/log/a;)I
    .locals 3

    const/4 v0, 0x2

    sget-object v1, Lcom/wanmei/sdk/core/log/a$1;->a:[I

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/log/a;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_0
    :pswitch_0
    return v0

    :pswitch_1
    const/4 v0, 0x1

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static a()[Lcom/wanmei/sdk/core/log/a;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/log/a;->c:[Lcom/wanmei/sdk/core/log/a;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/log/a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/log/a;

    return-object v0
.end method
