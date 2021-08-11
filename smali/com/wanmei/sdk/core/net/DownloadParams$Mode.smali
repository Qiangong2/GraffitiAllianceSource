.class public final enum Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/net/DownloadParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Mode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/net/DownloadParams$Mode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

.field public static final enum online:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

.field public static final enum sample:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

.field public static final enum sampleTest:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

.field public static final enum testOnline:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    const-string v1, "online"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->online:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    new-instance v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    const-string v1, "testOnline"

    invoke-direct {v0, v1, v3}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->testOnline:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    new-instance v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    const-string v1, "sample"

    invoke-direct {v0, v1, v4}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->sample:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    new-instance v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    const-string v1, "sampleTest"

    invoke-direct {v0, v1, v5}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->sampleTest:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->online:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->testOnline:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->sample:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->sampleTest:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->$VALUES:[Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

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

.method public static valueOf(Ljava/lang/String;)Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const-class v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    return-object v0
.end method

.method public static values()[Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->$VALUES:[Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    return-object v0
.end method
