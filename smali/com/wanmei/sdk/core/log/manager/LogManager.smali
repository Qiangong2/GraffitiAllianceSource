.class public final enum Lcom/wanmei/sdk/core/log/manager/LogManager;
.super Ljava/lang/Enum;

# interfaces
.implements Lcom/wanmei/sdk/core/Proguard;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wanmei/sdk/core/log/manager/LogManager;",
        ">;",
        "Lcom/wanmei/sdk/core/Proguard;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/wanmei/sdk/core/log/manager/LogManager;

.field public static final enum INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

.field private static mContext:Landroid/content/Context;

.field private static sManager:Lcom/wanmei/sdk/core/log/manager/a;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/log/manager/LogManager;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/log/manager/LogManager;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    const/4 v0, 0x1

    new-array v0, v0, [Lcom/wanmei/sdk/core/log/manager/LogManager;

    sget-object v1, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    aput-object v1, v0, v2

    sput-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->$VALUES:[Lcom/wanmei/sdk/core/log/manager/LogManager;

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

.method public static getDebug()Z
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-static {}, Lcom/wanmei/sdk/core/log/manager/c;->a()Lcom/wanmei/sdk/core/log/manager/c;

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/sdk/core/log/manager/c;->a(Landroid/content/Context;)Z

    move-result v0

    goto :goto_0
.end method

.method private getDebugFromServer()V
    .locals 2

    new-instance v0, Lcom/wanmei/sdk/core/task/c;

    sget-object v1, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/task/c;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/task/c;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method private static declared-synchronized initManager(Landroid/content/Context;)Lcom/wanmei/sdk/core/log/manager/a;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const-class v1, Lcom/wanmei/sdk/core/log/manager/LogManager;

    monitor-enter v1

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    monitor-exit v1

    return-object v0

    :cond_0
    :try_start_0
    sput-object p0, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->sManager:Lcom/wanmei/sdk/core/log/manager/a;

    if-nez v0, :cond_1

    new-instance v0, Lcom/wanmei/sdk/core/log/manager/b;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/log/manager/b;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->sManager:Lcom/wanmei/sdk/core/log/manager/a;

    :cond_1
    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->sManager:Lcom/wanmei/sdk/core/log/manager/a;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private updateTheLastNormalLog()V
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Lcom/wanmei/sdk/core/task/b;

    sget-object v1, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/task/b;-><init>(Landroid/content/Context;Z)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/task/b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wanmei/sdk/core/log/manager/LogManager;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const-class v0, Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/log/manager/LogManager;

    return-object v0
.end method

.method public static values()[Lcom/wanmei/sdk/core/log/manager/LogManager;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->$VALUES:[Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-virtual {v0}, [Lcom/wanmei/sdk/core/log/manager/LogManager;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wanmei/sdk/core/log/manager/LogManager;

    return-object v0
.end method


# virtual methods
.method public getLogger()Lcom/wanmei/sdk/core/log/manager/a;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->sManager:Lcom/wanmei/sdk/core/log/manager/a;

    return-object v0
.end method

.method public init(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    sput-object p1, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    invoke-static {p1}, Lcom/wanmei/sdk/core/log/manager/LogManager;->initManager(Landroid/content/Context;)Lcom/wanmei/sdk/core/log/manager/a;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->sManager:Lcom/wanmei/sdk/core/log/manager/a;

    invoke-direct {p0}, Lcom/wanmei/sdk/core/log/manager/LogManager;->getDebugFromServer()V

    invoke-static {}, Lcom/wanmei/sdk/core/log/manager/LogManager;->getDebug()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    invoke-static {v0}, Lcom/wanmei/sdk/core/util/LogUtil;->setLOG(Z)V

    invoke-direct {p0}, Lcom/wanmei/sdk/core/log/manager/LogManager;->updateTheLastNormalLog()V

    goto :goto_0
.end method

.method public upLoadLog()V
    .locals 3

    new-instance v0, Lcom/wanmei/sdk/core/task/b;

    sget-object v1, Lcom/wanmei/sdk/core/log/manager/LogManager;->mContext:Landroid/content/Context;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/wanmei/sdk/core/task/b;-><init>(Landroid/content/Context;Z)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/task/b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    return-void
.end method
