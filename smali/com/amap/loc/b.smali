.class public Lcom/amap/loc/b;
.super Ljava/lang/Object;
.source "APSServiceCore.java"

# interfaces
.implements Lcom/amap/api/location/APSServiceBase;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/loc/b$d;,
        Lcom/amap/loc/b$a;,
        Lcom/amap/loc/b$b;,
        Lcom/amap/loc/b$c;
    }
.end annotation


# instance fields
.field A:Z

.field volatile B:Ljava/net/Socket;

.field C:Z

.field D:Lcom/amap/loc/b$d;

.field private volatile E:Z

.field private F:I

.field private G:Z

.field private H:Z

.field private I:Z

.field private J:Z

.field private K:Z

.field private L:Z

.field private M:Z

.field private N:J

.field private O:J

.field private P:Lcom/amap/loc/br;

.field private Q:Z

.field private R:Ljava/lang/String;

.field a:Landroid/content/Context;

.field b:Z

.field c:Z

.field d:Landroid/os/Messenger;

.field e:Ljava/lang/String;

.field f:Landroid/os/Messenger;

.field g:Lcom/amap/loc/b$c;

.field h:Lcom/amap/loc/b$b;

.field i:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Landroid/os/Messenger;",
            ">;"
        }
    .end annotation
.end field

.field j:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Landroid/os/Messenger;",
            ">;"
        }
    .end annotation
.end field

.field k:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Landroid/os/Messenger;",
            ">;"
        }
    .end annotation
.end field

.field l:Ljava/util/concurrent/ExecutorService;

.field m:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<*>;"
        }
    .end annotation
.end field

.field n:Lcom/amap/api/location/AMapLocation;

.field o:Lcom/amap/loc/b$a;

.field p:Z

.field volatile q:Z

.field r:Z

.field s:Ljava/lang/Object;

.field t:Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

.field u:J

.field v:J

.field volatile w:I

.field x:Lorg/json/JSONObject;

.field y:Lcom/amap/api/location/AMapLocation;

.field volatile z:Ljava/net/ServerSocket;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 6

    const-wide/16 v4, 0x0

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v2, p0, Lcom/amap/loc/b;->b:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->c:Z

    iput-object v3, p0, Lcom/amap/loc/b;->d:Landroid/os/Messenger;

    iput-boolean v2, p0, Lcom/amap/loc/b;->E:Z

    iput-object v3, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    new-instance v0, Lcom/amap/loc/b$c;

    invoke-direct {v0, p0, p0}, Lcom/amap/loc/b$c;-><init>(Lcom/amap/loc/b;Lcom/amap/loc/b;)V

    iput-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    iput-object v3, p0, Lcom/amap/loc/b;->h:Lcom/amap/loc/b$b;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/b;->j:Ljava/util/Vector;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/b;->k:Ljava/util/Vector;

    iput v2, p0, Lcom/amap/loc/b;->F:I

    iput-boolean v2, p0, Lcom/amap/loc/b;->G:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->H:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->I:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->J:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->K:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->L:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->M:Z

    iput-wide v4, p0, Lcom/amap/loc/b;->N:J

    iput-wide v4, p0, Lcom/amap/loc/b;->O:J

    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->l:Ljava/util/concurrent/ExecutorService;

    iput-object v3, p0, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    iput-object v3, p0, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    new-instance v0, Lcom/amap/loc/b$a;

    invoke-direct {v0, p0}, Lcom/amap/loc/b$a;-><init>(Lcom/amap/loc/b;)V

    iput-object v0, p0, Lcom/amap/loc/b;->o:Lcom/amap/loc/b$a;

    iput-object v3, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    iput-boolean v2, p0, Lcom/amap/loc/b;->p:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->q:Z

    iput-boolean v2, p0, Lcom/amap/loc/b;->r:Z

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amap/loc/b;->u:J

    iput-wide v4, p0, Lcom/amap/loc/b;->v:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->Q:Z

    const-string v0, ""

    iput-object v0, p0, Lcom/amap/loc/b;->R:Ljava/lang/String;

    iput v2, p0, Lcom/amap/loc/b;->w:I

    iput-object v3, p0, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    iput-object v3, p0, Lcom/amap/loc/b;->z:Ljava/net/ServerSocket;

    iput-boolean v2, p0, Lcom/amap/loc/b;->A:Z

    iput-object v3, p0, Lcom/amap/loc/b;->B:Ljava/net/Socket;

    iput-boolean v2, p0, Lcom/amap/loc/b;->C:Z

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;)I
    .locals 1

    iget v0, p0, Lcom/amap/loc/b;->F:I

    return v0
.end method

.method static synthetic a(Lcom/amap/loc/b;Ljava/util/Vector;Landroid/os/Bundle;I)Landroid/os/Messenger;
    .locals 1

    invoke-direct {p0, p1, p2, p3}, Lcom/amap/loc/b;->a(Ljava/util/Vector;Landroid/os/Bundle;I)Landroid/os/Messenger;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/util/Vector;Landroid/os/Bundle;I)Landroid/os/Messenger;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Vector",
            "<",
            "Landroid/os/Messenger;",
            ">;",
            "Landroid/os/Bundle;",
            "I)",
            "Landroid/os/Messenger;"
        }
    .end annotation

    const/4 v3, 0x0

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/util/Vector;->size()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {p1}, Ljava/util/Vector;->size()I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    move v2, v1

    move-object v1, v0

    :goto_0
    if-ge v3, v2, :cond_1

    const/4 v0, 0x0

    :try_start_1
    invoke-virtual {p1, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Messenger;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    :try_start_2
    invoke-direct {p0, v0, p3, p2}, Lcom/amap/loc/b;->a(Landroid/os/Messenger;ILandroid/os/Bundle;)V

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/Vector;->remove(I)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    add-int/lit8 v1, v2, -0x1

    move v2, v1

    move-object v1, v0

    goto :goto_0

    :catch_0
    move-exception v1

    :goto_1
    const-string v2, "APSServiceCore"

    const-string v3, "reciveLoc"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_2
    return-object v0

    :catch_1
    move-exception v0

    move-object v4, v0

    move-object v0, v1

    move-object v1, v4

    goto :goto_1

    :cond_1
    move-object v0, v1

    goto :goto_2
.end method

.method private a(ILjava/lang/String;)Lcom/autonavi/aps/amapapi/model/AMapLocationServer;
    .locals 3

    :try_start_0
    new-instance v0, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    const-string v1, ""

    invoke-direct {v0, v1}, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;->setErrorCode(I)V

    invoke-virtual {v0, p2}, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;->setLocationDetail(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "newInstanceAMapLoc"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic a(Lcom/amap/loc/b;ILjava/lang/String;)Lcom/autonavi/aps/amapapi/model/AMapLocationServer;
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/amap/loc/b;->a(ILjava/lang/String;)Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    move-result-object v0

    return-object v0
.end method

.method private a(DD)V
    .locals 5

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amap/loc/br;->a(DD)Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "locationJson"

    iget-object v2, p0, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/amap/api/location/AMapLocation;->toStr(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "lMaxGeoDis"

    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v2

    mul-int/lit8 v2, v2, 0x3

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "lMinGeoDis"

    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    iget-object v1, p0, Lcom/amap/loc/b;->j:Ljava/util/Vector;

    const/4 v2, 0x6

    invoke-direct {p0, v1, v0, v2}, Lcom/amap/loc/b;->a(Ljava/util/Vector;Landroid/os/Bundle;I)Landroid/os/Messenger;

    :cond_0
    return-void
.end method

.method private a(Landroid/os/Messenger;)V
    .locals 4

    const/4 v3, 0x4

    const/4 v2, 0x2

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/loc/ck;->d(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Messenger;

    move-object p1, v0

    :cond_0
    if-eqz p1, :cond_1

    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    const/16 v1, 0x64

    iput v1, v0, Landroid/os/Message;->what:I

    invoke-virtual {p1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    :cond_1
    iget-wide v0, p0, Lcom/amap/loc/b;->O:J

    invoke-static {v0, v1}, Lcom/amap/loc/ck;->a(J)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/amap/loc/b;->I:Z

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/amap/loc/b;->t:Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    if-eqz v0, :cond_3

    iget v0, p0, Lcom/amap/loc/b;->w:I

    if-eq v0, v2, :cond_2

    iget v0, p0, Lcom/amap/loc/b;->w:I

    if-ne v0, v3, :cond_3

    :cond_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->J:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->I:Z

    :cond_3
    invoke-static {}, Lcom/amap/loc/ck;->a()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-boolean v0, p0, Lcom/amap/loc/b;->G:Z

    if-nez v0, :cond_4

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->G:Z

    iget-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/amap/loc/b$c;->sendEmptyMessage(I)Z

    :cond_4
    invoke-static {}, Lcom/amap/loc/ck;->c()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-static {}, Lcom/amap/loc/ck;->d()I

    move-result v0

    if-le v0, v2, :cond_5

    iget-boolean v0, p0, Lcom/amap/loc/b;->H:Z

    if-nez v0, :cond_5

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->H:Z

    iget-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/amap/loc/b$c;->sendEmptyMessage(I)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_5
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "checkConfig"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Landroid/os/Messenger;ILandroid/os/Bundle;)V
    .locals 3

    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    iput p2, v0, Landroid/os/Message;->what:I

    :try_start_0
    invoke-virtual {p1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "sendMessage"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/amap/loc/b;DD)V
    .locals 1

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amap/loc/b;->a(DD)V

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;Landroid/os/Messenger;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amap/loc/b;->a(Landroid/os/Messenger;)V

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;Landroid/os/Messenger;ILandroid/os/Bundle;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/amap/loc/b;->a(Landroid/os/Messenger;ILandroid/os/Bundle;)V

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;Ljava/net/Socket;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amap/loc/b;->a(Ljava/net/Socket;)V

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;Lorg/json/JSONObject;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amap/loc/b;->a(Lorg/json/JSONObject;)V

    return-void
.end method

.method static synthetic a(Lcom/amap/loc/b;ZLandroid/content/Context;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/amap/loc/b;->a(ZLandroid/content/Context;)V

    return-void
.end method

.method private a(Ljava/net/Socket;)V
    .locals 11

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v9, 0x1

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    const/16 v0, 0x7530

    :try_start_0
    const-string v1, "jsonp1"
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    :try_start_1
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    invoke-virtual {p1}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    const-string v7, "UTF-8"

    invoke-direct {v5, v6, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v2, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_f
    .catchall {:try_start_1 .. :try_end_1} :catchall_5

    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_4

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_4

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_4

    array-length v6, v5

    if-le v6, v9, :cond_4

    const/4 v6, 0x1

    aget-object v5, v5, v6

    const-string v6, "\\?"

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_4

    array-length v6, v5

    if-le v6, v9, :cond_4

    const/4 v6, 0x1

    aget-object v5, v5, v6

    const-string v6, "&"

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_4

    array-length v6, v5
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-lez v6, :cond_4

    move-object v10, v1

    move v1, v0

    move-object v0, v10

    :goto_1
    :try_start_3
    array-length v6, v5

    if-ge v4, v6, :cond_3

    aget-object v6, v5, v4

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_2

    array-length v7, v6

    if-le v7, v9, :cond_2

    const-string v7, "to"

    const/4 v8, 0x0

    aget-object v8, v6, v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    const/4 v1, 0x1

    aget-object v1, v6, v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    :cond_1
    const-string v7, "callback"

    const/4 v8, 0x0

    aget-object v8, v6, v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    const/4 v7, 0x1

    aget-object v0, v6, v7
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_10
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    :cond_3
    move-object v10, v0

    move v0, v1

    move-object v1, v10

    :cond_4
    :try_start_4
    sget v4, Lcom/amap/loc/c;->e:I

    sput v0, Lcom/amap/loc/c;->e:I

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iget-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getTime()J

    move-result-wide v8

    sub-long/2addr v6, v8

    const-wide/16 v8, 0x1388

    cmp-long v0, v6, v8

    if-lez v0, :cond_7

    :cond_5
    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/loc/cr;->d(Landroid/content/Context;)Z
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_3
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result v0

    if-nez v0, :cond_7

    :try_start_5
    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->a()Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    iget-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I

    move-result v0

    if-eqz v0, :cond_6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "&&"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "({\'package\':\'"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v5, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "\',\'error_code\':"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v5, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v5}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I

    move-result v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ",\'error\':\'"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v5, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v5}, Lcom/amap/api/location/AMapLocation;->getErrorInfo()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "\'})"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_2
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v3

    :cond_6
    :try_start_6
    sput v4, Lcom/amap/loc/c;->e:I

    :cond_7
    :goto_2
    if-nez v3, :cond_8

    iget-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    if-nez v0, :cond_9

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "&&"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "({\'package\':\'"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\',\'error_code\':8,\'error\':\'unknown error\'})"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_3
    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/loc/cr;->d(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_8

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "&&"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "({\'package\':\'"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\',\'error_code\':36,\'error\':\'app is background\'})"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result-object v3

    :cond_8
    :try_start_7
    new-instance v0, Ljava/io/PrintStream;

    invoke-virtual {p1}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v1

    const/4 v4, 0x1

    const-string v5, "UTF-8"

    invoke-direct {v0, v1, v4, v5}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;ZLjava/lang/String;)V

    const-string v1, "HTTP/1.0 200 OK"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Content-Length:"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "UTF-8"

    invoke-virtual {v3, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    array-length v4, v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/PrintStream;->println()V

    invoke-virtual {v0, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/PrintStream;->close()V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_c
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    :try_start_8
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    :try_start_9
    const-string v1, "APSServiceCore"

    const-string v2, "invoke part4"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_1

    goto/16 :goto_0

    :catch_1
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "invoke part5"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :catch_2
    move-exception v0

    :try_start_a
    const-string v5, "APSServiceCore"

    const-string v6, "invoke part1"

    invoke-static {v0, v5, v6}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    :try_start_b
    sput v4, Lcom/amap/loc/c;->e:I
    :try_end_b
    .catch Ljava/lang/Throwable; {:try_start_b .. :try_end_b} :catch_3
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    goto/16 :goto_2

    :catch_3
    move-exception v0

    :goto_4
    :try_start_c
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "&&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "({\'package\':\'"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v4, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "\',\'error_code\':1,\'error\':\'params error\'})"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v1, "APSServiceCore"

    const-string v4, "invoke part2"

    invoke-static {v0, v1, v4}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    :try_start_d
    new-instance v0, Ljava/io/PrintStream;

    invoke-virtual {p1}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v1

    const/4 v4, 0x1

    const-string v5, "UTF-8"

    invoke-direct {v0, v1, v4, v5}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;ZLjava/lang/String;)V

    const-string v1, "HTTP/1.0 200 OK"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Content-Length:"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "UTF-8"

    invoke-virtual {v3, v4}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    array-length v4, v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/PrintStream;->println()V

    invoke-virtual {v0, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/PrintStream;->close()V
    :try_end_d
    .catch Ljava/lang/Throwable; {:try_start_d .. :try_end_d} :catch_9
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    :try_start_e
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_e
    .catch Ljava/lang/Throwable; {:try_start_e .. :try_end_e} :catch_4

    goto/16 :goto_0

    :catch_4
    move-exception v0

    :try_start_f
    const-string v1, "APSServiceCore"

    const-string v2, "invoke part4"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_f
    .catch Ljava/lang/Throwable; {:try_start_f .. :try_end_f} :catch_1

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    :try_start_10
    sput v4, Lcom/amap/loc/c;->e:I

    throw v0
    :try_end_10
    .catch Ljava/lang/Throwable; {:try_start_10 .. :try_end_10} :catch_3
    .catchall {:try_start_10 .. :try_end_10} :catchall_1

    :catchall_1
    move-exception v0

    :goto_5
    :try_start_11
    new-instance v1, Ljava/io/PrintStream;

    invoke-virtual {p1}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    const/4 v5, 0x1

    const-string v6, "UTF-8"

    invoke-direct {v1, v4, v5, v6}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;ZLjava/lang/String;)V

    const-string v4, "HTTP/1.0 200 OK"

    invoke-virtual {v1, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Content-Length:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "UTF-8"

    invoke-virtual {v3, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    array-length v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/PrintStream;->println()V

    invoke-virtual {v1, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/PrintStream;->close()V
    :try_end_11
    .catch Ljava/lang/Throwable; {:try_start_11 .. :try_end_11} :catch_5
    .catchall {:try_start_11 .. :try_end_11} :catchall_2

    :try_start_12
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_12
    .catch Ljava/lang/Throwable; {:try_start_12 .. :try_end_12} :catch_8

    :goto_6
    :try_start_13
    throw v0
    :try_end_13
    .catch Ljava/lang/Throwable; {:try_start_13 .. :try_end_13} :catch_1

    :cond_9
    :try_start_14
    iget-object v0, p0, Lcom/amap/loc/b;->y:Lcom/amap/api/location/AMapLocation;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "&&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "({\'package\':\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\',\'error_code\':0,\'error\':\'\',\'location\':{\'y\':"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getLatitude()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ",\'precision\':"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getAccuracy()F

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ",\'x\':"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getLongitude()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "},\'version_code\':\'"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "3.0.0"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\',\'version\':\'"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "3.0.0"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'})"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_14
    .catch Ljava/lang/Throwable; {:try_start_14 .. :try_end_14} :catch_3
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    move-result-object v3

    goto/16 :goto_3

    :catch_5
    move-exception v1

    :try_start_15
    const-string v3, "APSServiceCore"

    const-string v4, "invoke part3"

    invoke-static {v1, v3, v4}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_15
    .catchall {:try_start_15 .. :try_end_15} :catchall_2

    :try_start_16
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_16
    .catch Ljava/lang/Throwable; {:try_start_16 .. :try_end_16} :catch_6

    goto :goto_6

    :catch_6
    move-exception v1

    :try_start_17
    const-string v2, "APSServiceCore"

    const-string v3, "invoke part4"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_17
    .catch Ljava/lang/Throwable; {:try_start_17 .. :try_end_17} :catch_1

    goto/16 :goto_6

    :catchall_2
    move-exception v0

    :try_start_18
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_18
    .catch Ljava/lang/Throwable; {:try_start_18 .. :try_end_18} :catch_7

    :goto_7
    :try_start_19
    throw v0

    :catch_7
    move-exception v1

    const-string v2, "APSServiceCore"

    const-string v3, "invoke part4"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_7

    :catch_8
    move-exception v1

    const-string v2, "APSServiceCore"

    const-string v3, "invoke part4"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_19
    .catch Ljava/lang/Throwable; {:try_start_19 .. :try_end_19} :catch_1

    goto/16 :goto_6

    :catch_9
    move-exception v0

    :try_start_1a
    const-string v1, "APSServiceCore"

    const-string v3, "invoke part3"

    invoke-static {v0, v1, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_3

    :try_start_1b
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_1b
    .catch Ljava/lang/Throwable; {:try_start_1b .. :try_end_1b} :catch_a

    goto/16 :goto_0

    :catch_a
    move-exception v0

    :try_start_1c
    const-string v1, "APSServiceCore"

    const-string v2, "invoke part4"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1c
    .catch Ljava/lang/Throwable; {:try_start_1c .. :try_end_1c} :catch_1

    goto/16 :goto_0

    :catchall_3
    move-exception v0

    :try_start_1d
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_1d
    .catch Ljava/lang/Throwable; {:try_start_1d .. :try_end_1d} :catch_b

    :goto_8
    :try_start_1e
    throw v0

    :catch_b
    move-exception v1

    const-string v2, "APSServiceCore"

    const-string v3, "invoke part4"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1e
    .catch Ljava/lang/Throwable; {:try_start_1e .. :try_end_1e} :catch_1

    goto :goto_8

    :catch_c
    move-exception v0

    :try_start_1f
    const-string v1, "APSServiceCore"

    const-string v3, "invoke part3"

    invoke-static {v0, v1, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1f
    .catchall {:try_start_1f .. :try_end_1f} :catchall_4

    :try_start_20
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_20
    .catch Ljava/lang/Throwable; {:try_start_20 .. :try_end_20} :catch_d

    goto/16 :goto_0

    :catch_d
    move-exception v0

    :try_start_21
    const-string v1, "APSServiceCore"

    const-string v2, "invoke part4"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_21
    .catch Ljava/lang/Throwable; {:try_start_21 .. :try_end_21} :catch_1

    goto/16 :goto_0

    :catchall_4
    move-exception v0

    :try_start_22
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    invoke-virtual {p1}, Ljava/net/Socket;->close()V
    :try_end_22
    .catch Ljava/lang/Throwable; {:try_start_22 .. :try_end_22} :catch_e

    :goto_9
    :try_start_23
    throw v0

    :catch_e
    move-exception v1

    const-string v2, "APSServiceCore"

    const-string v3, "invoke part4"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_23
    .catch Ljava/lang/Throwable; {:try_start_23 .. :try_end_23} :catch_1

    goto :goto_9

    :catchall_5
    move-exception v0

    move-object v2, v3

    goto/16 :goto_5

    :catch_f
    move-exception v0

    move-object v2, v3

    goto/16 :goto_4

    :catch_10
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto/16 :goto_4
.end method

.method private a(Lorg/json/JSONObject;)V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0, p1}, Lcom/amap/loc/br;->a(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "setExtra"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(ZLandroid/content/Context;)V
    .locals 1

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0, p1, p2}, Lcom/amap/loc/br;->a(ZLandroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic a(Lcom/amap/loc/b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/amap/loc/b;->K:Z

    return p1
.end method

.method static synthetic b(Lcom/amap/loc/b;)I
    .locals 2

    iget v0, p0, Lcom/amap/loc/b;->F:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/amap/loc/b;->F:I

    return v0
.end method

.method static synthetic b(Lcom/amap/loc/b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/amap/loc/b;->L:Z

    return p1
.end method

.method static synthetic c(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->h()V

    return-void
.end method

.method static synthetic c(Lcom/amap/loc/b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/amap/loc/b;->M:Z

    return p1
.end method

.method private d()V
    .locals 5

    const/4 v4, 0x0

    iget-boolean v0, p0, Lcom/amap/loc/b;->J:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amap/loc/b;->O:J

    iput-boolean v4, p0, Lcom/amap/loc/b;->J:Z

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->b()V

    :cond_0
    iget-boolean v0, p0, Lcom/amap/loc/b;->K:Z

    if-eqz v0, :cond_1

    iput-boolean v4, p0, Lcom/amap/loc/b;->K:Z

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->b()V

    :cond_1
    iget-boolean v0, p0, Lcom/amap/loc/b;->L:Z

    if-eqz v0, :cond_2

    iput-boolean v4, p0, Lcom/amap/loc/b;->L:Z

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->b()V

    :cond_2
    iget-boolean v0, p0, Lcom/amap/loc/b;->M:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    iget-wide v2, p0, Lcom/amap/loc/b;->N:J

    invoke-static {v0, v2, v3}, Lcom/amap/loc/ck;->a(Landroid/content/Context;J)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-static {}, Lcom/amap/loc/cr;->a()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amap/loc/b;->N:J

    iput-boolean v4, p0, Lcom/amap/loc/b;->M:Z

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->b()V

    :cond_3
    return-void
.end method

.method static synthetic d(Lcom/amap/loc/b;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/amap/loc/b;->Q:Z

    return v0
.end method

.method static synthetic d(Lcom/amap/loc/b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/amap/loc/b;->I:Z

    return p1
.end method

.method static synthetic e(Lcom/amap/loc/b;)Lcom/autonavi/aps/amapapi/model/AMapLocationServer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    invoke-direct {p0}, Lcom/amap/loc/b;->f()Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    move-result-object v0

    return-object v0
.end method

.method private e()Z
    .locals 2

    iget-object v1, p0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Lcom/amap/loc/b;->q:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method static synthetic f(Lcom/amap/loc/b;)Lcom/amap/loc/br;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    return-object v0
.end method

.method private f()Lcom/autonavi/aps/amapapi/model/AMapLocationServer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->a()Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    move-result-object v0

    return-object v0
.end method

.method static synthetic g(Lcom/amap/loc/b;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/b;->R:Ljava/lang/String;

    return-object v0
.end method

.method private g()V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    iget-object v1, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/amap/loc/br;->c(Landroid/content/Context;)V

    invoke-static {}, Lcom/amap/loc/ck;->p()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "ngpsAble"

    invoke-static {}, Lcom/amap/loc/ck;->q()Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-object v1, p0, Lcom/amap/loc/b;->k:Ljava/util/Vector;

    const/4 v2, 0x7

    invoke-direct {p0, v1, v0, v2}, Lcom/amap/loc/b;->a(Ljava/util/Vector;Landroid/os/Bundle;I)Landroid/os/Messenger;

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amap/loc/ck;->a(Z)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "initAuth"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private h()V
    .locals 3

    :try_start_0
    iget-boolean v0, p0, Lcom/amap/loc/b;->E:Z

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0}, Lcom/amap/loc/b;->i()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amap/loc/b;->Q:Z

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amap/loc/b;->R:Ljava/lang/String;

    const-string v1, "APSServiceCore"

    const-string v2, "init"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic h(Lcom/amap/loc/b;)Z
    .locals 1

    invoke-direct {p0}, Lcom/amap/loc/b;->e()Z

    move-result v0

    return v0
.end method

.method private i()V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/loc/c;->a(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/amap/loc/c;->a(Lcom/amap/api/location/AMapLocationClientOption;Landroid/content/Context;)Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->E:Z

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    iget-object v1, p0, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    invoke-virtual {v0, v1}, Lcom/amap/loc/br;->a(Lorg/json/JSONObject;)V

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    iget-object v1, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/amap/loc/br;->b(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amap/loc/b;->R:Ljava/lang/String;

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amap/loc/b;->Q:Z

    const-string v1, "APSServiceCore"

    const-string v2, "doInit"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic i(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->g()V

    return-void
.end method

.method private j()V
    .locals 3

    :try_start_0
    invoke-virtual {p0}, Lcom/amap/loc/b;->c()V

    iget-object v0, p0, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/b;->E:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/b;->G:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/b;->H:Z

    const/4 v0, 0x0

    iput v0, p0, Lcom/amap/loc/b;->F:I

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->c()V

    iget-object v0, p0, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    iget-object v0, p0, Lcom/amap/loc/b;->j:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    iget-object v0, p0, Lcom/amap/loc/b;->k:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    invoke-static {}, Lcom/amap/loc/w;->a()V

    iget-boolean v0, p0, Lcom/amap/loc/b;->b:Z

    if-eqz v0, :cond_1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amap/loc/b$c;->removeCallbacksAndMessages(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "threadDestroy"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic j(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->d()V

    return-void
.end method

.method private k()V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    invoke-virtual {v0}, Lcom/amap/loc/br;->i()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "startColl"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic k(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->k()V

    return-void
.end method

.method static synthetic l(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->j()V

    return-void
.end method

.method static synthetic m(Lcom/amap/loc/b;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/amap/loc/b;->E:Z

    return v0
.end method

.method static synthetic n(Lcom/amap/loc/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/b;->i()V

    return-void
.end method


# virtual methods
.method public a()Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    return-object v0
.end method

.method public declared-synchronized b()V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amap/loc/b;->C:Z

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/loc/b$d;

    invoke-direct {v0, p0}, Lcom/amap/loc/b$d;-><init>(Lcom/amap/loc/b;)V

    iput-object v0, p0, Lcom/amap/loc/b;->D:Lcom/amap/loc/b$d;

    iget-object v0, p0, Lcom/amap/loc/b;->D:Lcom/amap/loc/b$d;

    invoke-virtual {v0}, Lcom/amap/loc/b$d;->start()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->C:Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :catch_0
    move-exception v0

    :try_start_1
    const-string v1, "APSServiceCore"

    const-string v2, "startSocket"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized c()V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b;->z:Ljava/net/ServerSocket;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b;->z:Ljava/net/ServerSocket;

    invoke-virtual {v0}, Ljava/net/ServerSocket;->close()V

    :cond_0
    iget-object v0, p0, Lcom/amap/loc/b;->B:Ljava/net/Socket;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/b;->B:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->close()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    :goto_0
    const/4 v0, 0x0

    :try_start_1
    iput-object v0, p0, Lcom/amap/loc/b;->z:Ljava/net/ServerSocket;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/loc/b;->D:Lcom/amap/loc/b$d;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/b;->C:Z

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/b;->A:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void

    :catch_0
    move-exception v0

    :try_start_2
    const-string v1, "APSServiceCore"

    const-string v2, "stopScocket"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 6

    const-string v0, "a"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amap/loc/j;->a(Ljava/lang/String;)V

    :cond_0
    const-string v0, "b"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "true"

    const-string v2, "as"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amap/loc/b;->p:Z

    iget-boolean v1, p0, Lcom/amap/loc/b;->p:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/16 v2, 0x9

    const-wide/16 v4, 0x64

    invoke-virtual {v1, v2, v4, v5}, Lcom/amap/loc/b$c;->sendEmptyMessageDelayed(IJ)Z

    :cond_1
    invoke-static {v0}, Lcom/amap/loc/i;->a(Ljava/lang/String;)V

    new-instance v0, Landroid/os/Messenger;

    invoke-virtual {p0}, Lcom/amap/loc/b;->a()Landroid/os/Handler;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/amap/loc/b;->f:Landroid/os/Messenger;

    iget-object v0, p0, Lcom/amap/loc/b;->f:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 3

    :try_start_0
    new-instance v0, Lcom/amap/loc/br;

    invoke-direct {v0}, Lcom/amap/loc/br;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/b;->P:Lcom/amap/loc/br;

    iget-object v0, p0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/b;->e:Ljava/lang/String;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/b;->q:Z

    new-instance v0, Lcom/amap/loc/b$b;

    invoke-direct {v0, p0}, Lcom/amap/loc/b$b;-><init>(Lcom/amap/loc/b;)V

    iput-object v0, p0, Lcom/amap/loc/b;->h:Lcom/amap/loc/b$b;

    iget-object v0, p0, Lcom/amap/loc/b;->h:Lcom/amap/loc/b$b;

    const-string v1, "serviceThread"

    invoke-virtual {v0, v1}, Lcom/amap/loc/b$b;->setName(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amap/loc/b;->h:Lcom/amap/loc/b$b;

    invoke-virtual {v0}, Lcom/amap/loc/b$b;->start()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "onCreate"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    :try_start_0
    iget-object v1, p0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x0

    :try_start_1
    iput-boolean v0, p0, Lcom/amap/loc/b;->q:Z

    iget-object v0, p0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    :goto_0
    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "onDestroy"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method
