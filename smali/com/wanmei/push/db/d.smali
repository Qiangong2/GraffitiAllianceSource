.class public final Lcom/wanmei/push/db/d;
.super Ljava/lang/Object;


# static fields
.field private static f:Lcom/wanmei/push/db/d;


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Landroid/database/sqlite/SQLiteDatabase;

.field protected c:Lcom/wanmei/push/db/b;

.field protected d:Lcom/wanmei/push/db/a;

.field protected e:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/wanmei/push/db/NoticeDBHelper;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized a(Landroid/content/Context;)Lcom/wanmei/push/db/d;
    .locals 3

    const-class v1, Lcom/wanmei/push/db/d;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/wanmei/push/db/d;->f:Lcom/wanmei/push/db/d;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/db/d;

    invoke-direct {v0}, Lcom/wanmei/push/db/d;-><init>()V

    sput-object v0, Lcom/wanmei/push/db/d;->f:Lcom/wanmei/push/db/d;

    :cond_0
    sget-object v0, Lcom/wanmei/push/db/d;->f:Lcom/wanmei/push/db/d;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    iput-object v2, v0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    sget-object v0, Lcom/wanmei/push/db/d;->f:Lcom/wanmei/push/db/d;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private declared-synchronized c()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/db/d;->e:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/db/NoticeDBHelper;

    iget-object v1, p0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/wanmei/push/db/NoticeDBHelper;-><init>(Landroid/content/Context;)V

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/wanmei/push/db/d;->e:Ljava/lang/ref/WeakReference;

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/db/d;->e:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/db/NoticeDBHelper;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/push/db/NoticeDBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    iput-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0}, Lcom/wanmei/push/db/b;->a(Lcom/wanmei/push/db/NoticeDBHelper;)Lcom/wanmei/push/db/b;

    move-result-object v1

    iput-object v1, p0, Lcom/wanmei/push/db/d;->c:Lcom/wanmei/push/db/b;

    invoke-static {v0}, Lcom/wanmei/push/db/a;->a(Lcom/wanmei/push/db/NoticeDBHelper;)Lcom/wanmei/push/db/a;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/db/d;->d:Lcom/wanmei/push/db/a;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized d()V
    .locals 0

    monitor-enter p0

    monitor-exit p0

    return-void
.end method


# virtual methods
.method public final declared-synchronized a()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/Notice;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->c()V

    iget-object v0, p0, Lcom/wanmei/push/db/d;->c:Lcom/wanmei/push/db/b;

    iget-object v1, p0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    const-string v1, ""

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/push/db/b;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :try_start_1
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :goto_0
    monitor-exit p0

    return-object v0

    :catch_0
    move-exception v0

    :try_start_2
    const-string v1, "noticeDBManager"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "error when getAccountList : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final a(Ljava/lang/Object;)Z
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)Z"
        }
    .end annotation

    const/4 v3, 0x1

    const/4 v2, 0x0

    if-nez p1, :cond_0

    move v1, v2

    :goto_0
    return v1

    :cond_0
    :try_start_0
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->c()V

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    instance-of v1, p1, Lcom/wanmei/push/bean/Notice;

    if-eqz v1, :cond_3

    move-object v0, p1

    check-cast v0, Lcom/wanmei/push/bean/Notice;

    move-object v1, v0

    iget-object v4, p0, Lcom/wanmei/push/db/d;->c:Lcom/wanmei/push/db/b;

    iget-object v5, p0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/wanmei/push/bean/Notice;->getMsgId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1}, Lcom/wanmei/push/bean/Notice;->getApiAddr()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/wanmei/push/db/b;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/wanmei/push/db/d;->c:Lcom/wanmei/push/db/b;

    invoke-virtual {v4, v1}, Lcom/wanmei/push/db/b;->a(Lcom/wanmei/push/bean/Notice;)I

    move-result v1

    if-lez v1, :cond_2

    move v1, v3

    :goto_1
    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_1
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    :goto_2
    move v1, v3

    goto :goto_0

    :cond_2
    move v1, v2

    goto :goto_1

    :catch_0
    move-exception v1

    const-string v2, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_3
    :try_start_2
    instance-of v1, p1, Lcom/wanmei/push/bean/AppState;

    if-eqz v1, :cond_6

    check-cast p1, Lcom/wanmei/push/bean/AppState;

    iget-object v1, p0, Lcom/wanmei/push/db/d;->d:Lcom/wanmei/push/db/a;

    iget-object v4, p0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    invoke-virtual {p1}, Lcom/wanmei/push/bean/AppState;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/wanmei/push/bean/AppState;->getApiAddr()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Lcom/wanmei/push/db/a;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/wanmei/push/db/d;->d:Lcom/wanmei/push/db/a;

    invoke-virtual {v1, p1}, Lcom/wanmei/push/db/a;->a(Lcom/wanmei/push/bean/AppState;)I

    move-result v1

    if-lez v1, :cond_5

    move v1, v3

    :goto_3
    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_4
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    :goto_4
    move v1, v3

    goto/16 :goto_0

    :cond_5
    move v1, v2

    goto :goto_3

    :catch_1
    move-exception v1

    const-string v2, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    :cond_6
    :try_start_4
    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_7
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    :goto_5
    move v1, v2

    goto/16 :goto_0

    :catch_2
    move-exception v1

    const-string v3, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    :catch_3
    move-exception v1

    :try_start_5
    const-string v3, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_8
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_5

    :catch_4
    move-exception v1

    const-string v3, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    :catchall_0
    move-exception v1

    :try_start_7
    iget-object v2, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/wanmei/push/db/d;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    :cond_9
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    :goto_6
    throw v1

    :catch_5
    move-exception v2

    const-string v3, "noticeDBManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "error when updateNotice : "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_6
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->c()V

    iget-object v1, p0, Lcom/wanmei/push/db/d;->c:Lcom/wanmei/push/db/b;

    invoke-virtual {v1, p1, p2}, Lcom/wanmei/push/db/b;->a(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    if-gtz v1, :cond_0

    iget-object v1, p0, Lcom/wanmei/push/db/d;->d:Lcom/wanmei/push/db/a;

    invoke-virtual {v1, p1, p2}, Lcom/wanmei/push/db/a;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-lez v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    :goto_0
    return v0

    :catch_0
    move-exception v1

    :try_start_1
    const-string v2, "noticeDBManager"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "error when deleteNotice : "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    throw v0
.end method

.method public final declared-synchronized b()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/AppState;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->c()V

    iget-object v0, p0, Lcom/wanmei/push/db/d;->d:Lcom/wanmei/push/db/a;

    iget-object v1, p0, Lcom/wanmei/push/db/d;->a:Landroid/content/Context;

    const-string v1, ""

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/wanmei/push/db/a;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :try_start_1
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :goto_0
    monitor-exit p0

    return-object v0

    :catch_0
    move-exception v0

    :try_start_2
    const-string v1, "noticeDBManager"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "error when getAccountList : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-direct {p0}, Lcom/wanmei/push/db/d;->d()V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method
