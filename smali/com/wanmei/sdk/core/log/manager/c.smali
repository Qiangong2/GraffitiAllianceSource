.class public final Lcom/wanmei/sdk/core/log/manager/c;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/wanmei/sdk/core/log/manager/c;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/wanmei/sdk/core/log/manager/c;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/log/manager/c;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/log/manager/c;->a:Lcom/wanmei/sdk/core/log/manager/c;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/wanmei/sdk/core/log/manager/c;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/log/manager/c;->a:Lcom/wanmei/sdk/core/log/manager/c;

    return-object v0
.end method

.method public static a(Landroid/content/Context;Z)V
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "log_preference_settings"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "log_preference_show_debug_log"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    return-void
.end method

.method public static a(Landroid/content/Context;)Z
    .locals 3

    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "log_preference_settings"

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "log_preference_show_debug_log"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
