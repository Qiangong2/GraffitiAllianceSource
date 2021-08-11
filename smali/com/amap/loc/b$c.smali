.class Lcom/amap/loc/b$c;
.super Landroid/os/Handler;
.source "APSServiceCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/loc/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "c"
.end annotation


# instance fields
.field a:Lcom/amap/loc/b;

.field final synthetic b:Lcom/amap/loc/b;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amap/loc/b;Lcom/amap/loc/b;)V
    .locals 1

    iput-object p1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    const-string v0, ""

    iput-object v0, p0, Lcom/amap/loc/b$c;->c:Ljava/lang/String;

    iput-object p2, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8

    :try_start_0
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    :pswitch_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    :cond_1
    :goto_1
    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    goto :goto_0

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

    const-string v2, "handleMessage STARTCOLL"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_2
    :try_start_3
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    :try_start_4
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x0

    iput-boolean v2, v0, Lcom/amap/loc/b;->p:Z

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    iget-object v2, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v4

    const-string v3, "extraJson"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/amap/loc/b$c;->c:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v3, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    const-wide/16 v6, 0x0

    iput-wide v6, v3, Lcom/amap/loc/b;->u:J

    :cond_2
    iput-object v0, p0, Lcom/amap/loc/b$c;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->t:Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->t:Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    invoke-virtual {v3}, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;->getErrorCode()I

    move-result v3

    if-nez v3, :cond_3

    iget-object v3, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-wide v6, v3, Lcom/amap/loc/b;->u:J

    sub-long/2addr v4, v6

    const-wide/16 v6, 0x258

    cmp-long v3, v4, v6

    if-gez v3, :cond_3

    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v3

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    const-string v5, "locationJson"

    iget-object v6, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v6, v6, Lcom/amap/loc/b;->t:Lcom/autonavi/aps/amapapi/model/AMapLocationServer;

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Lcom/autonavi/aps/amapapi/model/AMapLocationServer;->toStr(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    const/4 v4, 0x1

    iput v4, v3, Landroid/os/Message;->what:I

    invoke-virtual {v2, v3}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    :goto_2
    iget-object v2, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v3, v2, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v2, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v2, v2, Lcom/amap/loc/b;->x:Lorg/json/JSONObject;

    invoke-static {v0, v2}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;Lorg/json/JSONObject;)V

    monitor-exit v1

    goto/16 :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :try_start_5
    throw v0
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_1

    :catch_1
    move-exception v0

    :try_start_6
    const-string v1, "APSServiceCore"

    const-string v2, "handleMessage LOCATION"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_0

    goto/16 :goto_0

    :cond_3
    :try_start_7
    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    invoke-virtual {v3, v2}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->i:Ljava/util/Vector;

    invoke-virtual {v3, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    :cond_4
    iget-object v2, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/amap/loc/b;->r:Z

    iget-object v2, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v2, v2, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->notify()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_2

    :pswitch_3
    :try_start_8
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    invoke-virtual {v0}, Lcom/amap/loc/b;->b()V

    goto/16 :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    invoke-virtual {v0}, Lcom/amap/loc/b;->c()V

    goto/16 :goto_0

    :pswitch_5
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_0

    :try_start_9
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    invoke-static {v0}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;)I

    move-result v0

    invoke-static {}, Lcom/amap/loc/ck;->b()I

    move-result v2

    if-ge v0, v2, :cond_5

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;Z)Z

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    invoke-static {v0}, Lcom/amap/loc/b;->b(Lcom/amap/loc/b;)I

    :goto_3
    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/4 v2, 0x4

    const-wide/16 v4, 0x7d0

    invoke-virtual {v0, v2, v4, v5}, Lcom/amap/loc/b$c;->sendEmptyMessageDelayed(IJ)Z

    monitor-exit v1

    goto/16 :goto_0

    :catchall_2
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    :try_start_a
    throw v0
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_0

    :cond_5
    :try_start_b
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;Z)Z
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    goto :goto_3

    :pswitch_6
    :try_start_c
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_c
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_0

    :try_start_d
    invoke-static {}, Lcom/amap/loc/ck;->e()Z

    move-result v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/amap/loc/b;->b(Lcom/amap/loc/b;Z)Z

    :cond_6
    :goto_4
    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->g:Lcom/amap/loc/b$c;

    const/4 v2, 0x5

    invoke-static {}, Lcom/amap/loc/ck;->d()I

    move-result v3

    mul-int/lit16 v3, v3, 0x3e8

    int-to-long v4, v3

    invoke-virtual {v0, v2, v4, v5}, Lcom/amap/loc/b$c;->sendEmptyMessageDelayed(IJ)Z

    monitor-exit v1

    goto/16 :goto_0

    :catchall_3
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    :try_start_e
    throw v0
    :try_end_e
    .catch Ljava/lang/Throwable; {:try_start_e .. :try_end_e} :catch_0

    :cond_7
    :try_start_f
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/loc/cr;->d(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/amap/loc/b;->b(Lcom/amap/loc/b;Z)Z
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_3

    goto :goto_4

    :pswitch_7
    :try_start_10
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_10
    .catch Ljava/lang/Throwable; {:try_start_10 .. :try_end_10} :catch_0

    :try_start_11
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->k:Ljava/util/Vector;

    iget-object v2, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-virtual {v0, v2}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->k:Ljava/util/Vector;

    iget-object v2, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-virtual {v0, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    :cond_8
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/amap/loc/b;->c(Lcom/amap/loc/b;Z)Z

    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    goto/16 :goto_0

    :catchall_4
    move-exception v0

    monitor-exit v1
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_4

    :try_start_12
    throw v0

    :pswitch_8
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    monitor-enter v1
    :try_end_12
    .catch Ljava/lang/Throwable; {:try_start_12 .. :try_end_12} :catch_0

    :try_start_13
    iget-object v0, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    iget-object v0, v0, Lcom/amap/loc/b;->s:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    goto/16 :goto_0

    :catchall_5
    move-exception v0

    monitor-exit v1
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_5

    :try_start_14
    throw v0

    :pswitch_9
    invoke-static {}, Lcom/amap/loc/ck;->w()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->j:Ljava/util/Vector;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_9

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->j:Ljava/util/Vector;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    :cond_9
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "lat"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    const-string v4, "lon"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->o:Lcom/amap/loc/b$a;

    iput-wide v2, v1, Lcom/amap/loc/b$a;->a:D

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->o:Lcom/amap/loc/b$a;

    iput-wide v4, v1, Lcom/amap/loc/b$a;->b:D

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    if-eqz v1, :cond_a

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    invoke-interface {v1}, Ljava/util/concurrent/Future;->isDone()Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_a
    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    if-eqz v1, :cond_c

    const/4 v1, 0x4

    new-array v1, v1, [D

    const/4 v6, 0x0

    aput-wide v2, v1, v6

    const/4 v2, 0x1

    aput-wide v4, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v3}, Lcom/amap/api/location/AMapLocation;->getLatitude()D

    move-result-wide v4

    aput-wide v4, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v3, v3, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    invoke-virtual {v3}, Lcom/amap/api/location/AMapLocation;->getLongitude()D

    move-result-wide v4

    aput-wide v4, v1, v2

    invoke-static {v1}, Lcom/amap/loc/cr;->a([D)F

    move-result v1

    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v2

    mul-int/lit8 v2, v2, 0x3

    int-to-float v2, v2

    cmpg-float v2, v1, v2

    if-gez v2, :cond_b

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string v3, "locationJson"

    iget-object v4, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v4, v4, Lcom/amap/loc/b;->n:Lcom/amap/api/location/AMapLocation;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/amap/api/location/AMapLocation;->toStr(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "lMaxGeoDis"

    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v4

    mul-int/lit8 v4, v4, 0x3

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v3, "lMinGeoDis"

    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    iget-object v3, p0, Lcom/amap/loc/b$c;->a:Lcom/amap/loc/b;

    const/4 v4, 0x6

    invoke-static {v3, v0, v4, v2}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;Landroid/os/Messenger;ILandroid/os/Bundle;)V

    :cond_b
    invoke-static {}, Lcom/amap/loc/ck;->x()I

    move-result v0

    int-to-float v0, v0

    cmpl-float v0, v1, v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->l:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v2, v2, Lcom/amap/loc/b;->o:Lcom/amap/loc/b$a;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v1

    iput-object v1, v0, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;

    goto/16 :goto_0

    :cond_c
    iget-object v0, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v1, v1, Lcom/amap/loc/b;->l:Ljava/util/concurrent/ExecutorService;

    iget-object v2, p0, Lcom/amap/loc/b$c;->b:Lcom/amap/loc/b;

    iget-object v2, v2, Lcom/amap/loc/b;->o:Lcom/amap/loc/b$a;

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v1

    iput-object v1, v0, Lcom/amap/loc/b;->m:Ljava/util/concurrent/Future;
    :try_end_14
    .catch Ljava/lang/Throwable; {:try_start_14 .. :try_end_14} :catch_0

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_7
        :pswitch_0
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method
