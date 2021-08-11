.class public Lcom/wanmei/sdk/core/util/LogUtil;
.super Ljava/lang/Object;


# static fields
.field private static LOG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {p0, p1}, Lcom/wanmei/sdk/core/util/LogUtil;->log(Ljava/lang/String;Ljava/lang/String;)V

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {p0, p1}, Lcom/wanmei/sdk/core/util/LogUtil;->log(Ljava/lang/String;Ljava/lang/String;)V

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    invoke-static {p0, p1}, Lcom/wanmei/sdk/core/util/LogUtil;->log(Ljava/lang/String;Ljava/lang/String;)V

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    return-void
.end method

.method public static isLOG()Z
    .locals 1

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    return v0
.end method

.method public static log(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {}, Lcom/wanmei/sdk/core/log/manager/LogManager;->getDebug()Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    sget-object v0, Lcom/wanmei/sdk/core/log/manager/LogManager;->INSTANCE:Lcom/wanmei/sdk/core/log/manager/LogManager;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/log/manager/LogManager;->getLogger()Lcom/wanmei/sdk/core/log/manager/a;

    move-result-object v0

    invoke-interface {v0, p0, p1}, Lcom/wanmei/sdk/core/log/manager/a;->a(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static logcat(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public static setLOG(Z)V
    .locals 0
    .param p0, "lOG"    # Z

    .prologue
    sput-boolean p0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    return-void
.end method

.method public static v(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {p0, p1}, Lcom/wanmei/sdk/core/util/LogUtil;->log(Ljava/lang/String;Ljava/lang/String;)V

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    invoke-static {p0, p1}, Lcom/wanmei/sdk/core/util/LogUtil;->log(Ljava/lang/String;Ljava/lang/String;)V

    sget-boolean v0, Lcom/wanmei/sdk/core/util/LogUtil;->LOG:Z

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method
