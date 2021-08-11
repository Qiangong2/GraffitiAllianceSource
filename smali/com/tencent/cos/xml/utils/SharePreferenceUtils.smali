.class public Lcom/tencent/cos/xml/utils/SharePreferenceUtils;
.super Ljava/lang/Object;
.source "SharePreferenceUtils.java"


# instance fields
.field private sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-string v0, "downloader"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 15
    return-void
.end method


# virtual methods
.method public declared-synchronized clear(Ljava/lang/String;)V
    .locals 1
    .param p1, "localFilePath"    # Ljava/lang/String;

    .prologue
    .line 33
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 34
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_0
    monitor-exit p0

    return-void

    .line 33
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "localFilePath"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 25
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 26
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->sharedPreferences:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 28
    :cond_0
    monitor-exit p0

    return-object v0

    .line 25
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized updateValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "localFilePath"    # Ljava/lang/String;
    .param p2, "eTag"    # Ljava/lang/String;

    .prologue
    .line 19
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 20
    :try_start_0
    iget-object v0, p0, Lcom/tencent/cos/xml/utils/SharePreferenceUtils;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 22
    :cond_0
    monitor-exit p0

    return-void

    .line 19
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
