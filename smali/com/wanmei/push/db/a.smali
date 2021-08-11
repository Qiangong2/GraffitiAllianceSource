.class public final Lcom/wanmei/push/db/a;
.super Ljava/lang/Object;


# static fields
.field private static c:Lcom/wanmei/push/db/a;


# instance fields
.field protected a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/j256/ormlite/dao/RuntimeExceptionDao",
            "<",
            "Lcom/wanmei/push/bean/AppState;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field protected b:Lcom/wanmei/push/db/NoticeDBHelper;


# direct methods
.method private constructor <init>(Lcom/wanmei/push/db/NoticeDBHelper;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/push/db/a;->b:Lcom/wanmei/push/db/NoticeDBHelper;

    iget-object v0, p0, Lcom/wanmei/push/db/a;->a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/db/a;->b:Lcom/wanmei/push/db/NoticeDBHelper;

    const-class v1, Lcom/wanmei/push/bean/AppState;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/db/NoticeDBHelper;->getRuntimeExceptionDao(Ljava/lang/Class;)Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/db/a;->a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    :cond_0
    return-void
.end method

.method public static a(Lcom/wanmei/push/db/NoticeDBHelper;)Lcom/wanmei/push/db/a;
    .locals 1

    sget-object v0, Lcom/wanmei/push/db/a;->c:Lcom/wanmei/push/db/a;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/db/a;

    invoke-direct {v0, p0}, Lcom/wanmei/push/db/a;-><init>(Lcom/wanmei/push/db/NoticeDBHelper;)V

    sput-object v0, Lcom/wanmei/push/db/a;->c:Lcom/wanmei/push/db/a;

    :cond_0
    sget-object v0, Lcom/wanmei/push/db/a;->c:Lcom/wanmei/push/db/a;

    return-object v0
.end method


# virtual methods
.method public final a(Lcom/wanmei/push/bean/AppState;)I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/db/a;->a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    invoke-virtual {v0, p1}, Lcom/j256/ormlite/dao/RuntimeExceptionDao;->create(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/db/a;->a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    invoke-virtual {v0}, Lcom/j256/ormlite/dao/RuntimeExceptionDao;->deleteBuilder()Lcom/j256/ormlite/stmt/DeleteBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/j256/ormlite/stmt/DeleteBuilder;->where()Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    const-string v2, "appId"

    invoke-virtual {v1, v2, p1}, Lcom/j256/ormlite/stmt/Where;->eq(Ljava/lang/String;Ljava/lang/Object;)Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    invoke-virtual {v1}, Lcom/j256/ormlite/stmt/Where;->and()Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    const-string v2, "apiADDR"

    invoke-virtual {v1, v2, p2}, Lcom/j256/ormlite/stmt/Where;->eq(Ljava/lang/String;Ljava/lang/Object;)Lcom/j256/ormlite/stmt/Where;

    invoke-virtual {v0}, Lcom/j256/ormlite/stmt/DeleteBuilder;->delete()I

    move-result v0

    return v0
.end method

.method public final b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/AppState;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/db/a;->a:Lcom/j256/ormlite/dao/RuntimeExceptionDao;

    invoke-virtual {v0}, Lcom/j256/ormlite/dao/RuntimeExceptionDao;->queryBuilder()Lcom/j256/ormlite/stmt/QueryBuilder;

    move-result-object v0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/j256/ormlite/stmt/QueryBuilder;->where()Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    const-string v2, "appId"

    invoke-virtual {v1, v2, p1}, Lcom/j256/ormlite/stmt/Where;->eq(Ljava/lang/String;Ljava/lang/Object;)Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    invoke-virtual {v1}, Lcom/j256/ormlite/stmt/Where;->and()Lcom/j256/ormlite/stmt/Where;

    move-result-object v1

    const-string v2, "apiADDR"

    invoke-virtual {v1, v2, p2}, Lcom/j256/ormlite/stmt/Where;->eq(Ljava/lang/String;Ljava/lang/Object;)Lcom/j256/ormlite/stmt/Where;

    :cond_0
    invoke-virtual {v0}, Lcom/j256/ormlite/stmt/QueryBuilder;->query()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
