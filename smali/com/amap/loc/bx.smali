.class public Lcom/amap/loc/bx;
.super Ljava/lang/Object;
.source "CgiManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/loc/bx$a;
    }
.end annotation


# instance fields
.field a:Landroid/os/HandlerThread;

.field volatile b:Z

.field private c:Landroid/content/Context;

.field private d:I

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amap/loc/bw;",
            ">;"
        }
    .end annotation
.end field

.field private f:I

.field private g:Landroid/telephony/TelephonyManager;

.field private h:Ljava/lang/Object;

.field private i:J

.field private j:Lorg/json/JSONObject;

.field private k:Landroid/telephony/PhoneStateListener;

.field private volatile l:Landroid/telephony/CellLocation;

.field private m:Z

.field private n:Ljava/lang/Object;

.field private o:Landroid/telephony/PhoneStateListener;

.field private p:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0x9

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    const/16 v0, -0x71

    iput v0, p0, Lcom/amap/loc/bx;->f:I

    iput-object v2, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amap/loc/bx;->i:J

    iput-object v2, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    iput-boolean v3, p0, Lcom/amap/loc/bx;->m:Z

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/bx;->n:Ljava/lang/Object;

    iput-boolean v3, p0, Lcom/amap/loc/bx;->b:Z

    iput-object v2, p0, Lcom/amap/loc/bx;->o:Landroid/telephony/PhoneStateListener;

    iput-object v2, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    if-nez p1, :cond_0

    :cond_0
    iput-object p2, p0, Lcom/amap/loc/bx;->j:Lorg/json/JSONObject;

    iput-object p1, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    const-string v1, "phone"

    invoke-static {v0, v1}, Lcom/amap/loc/cr;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    iput-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    :cond_1
    return-void
.end method

.method static synthetic a(Lcom/amap/loc/bx;Landroid/telephony/CellLocation;)Landroid/telephony/CellLocation;
    .locals 0

    iput-object p1, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    return-object p1
.end method

.method private a(Ljava/util/List;)Landroid/telephony/CellLocation;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;)",
            "Landroid/telephony/CellLocation;"
        }
    .end annotation

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    const/4 v0, 0x0

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    invoke-static {}, Ljava/lang/ClassLoader;->getSystemClassLoader()Ljava/lang/ClassLoader;

    move-result-object v9

    const/4 v6, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x0

    const/4 v0, 0x0

    move v8, v0

    move v0, v1

    move-object v1, v2

    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v8, v2, :cond_c

    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_3

    :goto_2
    add-int/lit8 v2, v8, 0x1

    move v8, v2

    goto :goto_1

    :cond_3
    :try_start_0
    const-string v2, "android.telephony.CellInfoGsm"

    invoke-virtual {v9, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v4

    const-string v2, "android.telephony.CellInfoWcdma"

    invoke-virtual {v9, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v5

    const-string v2, "android.telephony.CellInfoLte"

    invoke-virtual {v9, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v10

    const-string v2, "android.telephony.CellInfoCdma"

    invoke-virtual {v9, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v11

    const/4 v2, 0x0

    invoke-virtual {v4, v3}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v7

    if-eqz v7, :cond_4

    const/4 v7, 0x1

    :try_start_1
    invoke-virtual {v4, v3}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_3
    if-lez v7, :cond_b

    const-string v2, "getCellIdentity"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/amap/loc/cm;->a(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    if-nez v2, :cond_8

    move v0, v7

    goto :goto_2

    :cond_4
    :try_start_2
    invoke-virtual {v5, v3}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    move-result v4

    if-eqz v4, :cond_5

    const/4 v7, 0x2

    :try_start_3
    invoke-virtual {v5, v3}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    move-result-object v0

    goto :goto_3

    :cond_5
    :try_start_4
    invoke-virtual {v10, v3}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0

    move-result v4

    if-eqz v4, :cond_6

    const/4 v7, 0x3

    :try_start_5
    invoke-virtual {v10, v3}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_1

    move-result-object v0

    goto :goto_3

    :cond_6
    :try_start_6
    invoke-virtual {v11, v3}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_0

    move-result v0

    if-eqz v0, :cond_7

    const/4 v7, 0x4

    :try_start_7
    invoke-virtual {v11, v3}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_3

    :cond_7
    const/4 v7, 0x0

    move-object v0, v2

    goto :goto_3

    :cond_8
    const/4 v0, 0x4

    if-ne v7, v0, :cond_9

    new-instance v0, Landroid/telephony/cdma/CdmaCellLocation;

    invoke-direct {v0}, Landroid/telephony/cdma/CdmaCellLocation;-><init>()V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_1

    :try_start_8
    const-string v1, "getSystemId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v1, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v4

    const-string v1, "getNetworkId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v1, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v5

    const-string v1, "getBasestationId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v1, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v1

    const-string v3, "getLongitude"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v2, v3, v10}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v3

    const-string v10, "getLatitude"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v2, v10, v11}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    invoke-virtual/range {v0 .. v5}, Landroid/telephony/cdma/CdmaCellLocation;->setCellLocationData(IIIII)V
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_2

    move-object v1, v6

    :goto_4
    const/4 v2, 0x4

    if-eq v7, v2, :cond_1

    move-object v0, v1

    goto/16 :goto_0

    :cond_9
    const/4 v0, 0x3

    if-ne v7, v0, :cond_a

    :try_start_9
    const-string v0, "getTac"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v0, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v3

    const-string v0, "getCi"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    new-instance v0, Landroid/telephony/gsm/GsmCellLocation;

    invoke-direct {v0}, Landroid/telephony/gsm/GsmCellLocation;-><init>()V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_1

    :try_start_a
    invoke-virtual {v0, v3, v2}, Landroid/telephony/gsm/GsmCellLocation;->setLacAndCid(II)V
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_3

    move-object v12, v1

    move-object v1, v0

    move-object v0, v12

    goto :goto_4

    :cond_a
    :try_start_b
    const-string v0, "getLac"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v0, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v3

    const-string v0, "getCid"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    new-instance v0, Landroid/telephony/gsm/GsmCellLocation;

    invoke-direct {v0}, Landroid/telephony/gsm/GsmCellLocation;-><init>()V
    :try_end_b
    .catch Ljava/lang/Throwable; {:try_start_b .. :try_end_b} :catch_1

    :try_start_c
    invoke-virtual {v0, v3, v2}, Landroid/telephony/gsm/GsmCellLocation;->setLacAndCid(II)V
    :try_end_c
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_4

    move-object v12, v1

    move-object v1, v0

    move-object v0, v12

    goto :goto_4

    :cond_b
    move v0, v7

    goto/16 :goto_2

    :catch_0
    move-exception v2

    goto/16 :goto_2

    :catch_1
    move-exception v0

    move v0, v7

    goto/16 :goto_2

    :catch_2
    move-exception v1

    move-object v1, v0

    move v0, v7

    goto/16 :goto_2

    :catch_3
    move-exception v2

    move-object v6, v0

    move v0, v7

    goto/16 :goto_2

    :catch_4
    move-exception v2

    move-object v6, v0

    move v0, v7

    goto/16 :goto_2

    :cond_c
    move v7, v0

    move-object v0, v1

    move-object v1, v6

    goto :goto_4
.end method

.method private varargs a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    .locals 3

    const/4 v1, 0x0

    if-nez p2, :cond_1

    move-object v0, v1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    :try_start_0
    const-string v0, "getAllCellInfo"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "getAllCellInfo"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p2, v0, v2}, Lcom/amap/loc/cm;->a(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/amap/loc/bx;->a(Ljava/util/List;)Landroid/telephony/CellLocation;

    move-result-object v0

    :goto_1
    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_2
    move-object v0, v1

    goto :goto_0

    :cond_2
    invoke-static {p2, p3, p4}, Lcom/amap/loc/cm;->a(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_3

    check-cast v0, Landroid/telephony/CellLocation;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    goto :goto_2

    :cond_3
    move-object v0, v1

    goto :goto_1
.end method

.method static synthetic a(Lcom/amap/loc/bx;Landroid/telephony/PhoneStateListener;)Landroid/telephony/PhoneStateListener;
    .locals 0

    iput-object p1, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    return-object p1
.end method

.method private a(Landroid/telephony/NeighboringCellInfo;)Lcom/amap/loc/bw;
    .locals 4

    const/4 v0, 0x0

    invoke-static {}, Lcom/amap/loc/cr;->c()I

    move-result v1

    const/4 v2, 0x5

    if-ge v1, v2, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v1, Lcom/amap/loc/bw;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Lcom/amap/loc/bw;-><init>(I)V

    iget-object v2, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-static {v2}, Lcom/amap/loc/cr;->a(Landroid/telephony/TelephonyManager;)[Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    aget-object v3, v2, v3

    iput-object v3, v1, Lcom/amap/loc/bw;->a:Ljava/lang/String;

    const/4 v3, 0x1

    aget-object v2, v2, v3

    iput-object v2, v1, Lcom/amap/loc/bw;->b:Ljava/lang/String;

    const-string v2, "getLac"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, v2, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    iput v2, v1, Lcom/amap/loc/bw;->c:I

    invoke-virtual {p1}, Landroid/telephony/NeighboringCellInfo;->getCid()I

    move-result v2

    iput v2, v1, Lcom/amap/loc/bw;->d:I

    invoke-virtual {p1}, Landroid/telephony/NeighboringCellInfo;->getRssi()I

    move-result v2

    invoke-static {v2}, Lcom/amap/loc/cr;->a(I)I

    move-result v2

    iput v2, v1, Lcom/amap/loc/bw;->j:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    const-string v2, "CgiManager"

    const-string v3, "getGsm"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/amap/loc/bx;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->n:Ljava/lang/Object;

    return-object v0
.end method

.method private a(I)V
    .locals 3

    const/16 v0, -0x71

    if-ne p1, v0, :cond_1

    iput v0, p0, Lcom/amap/loc/bx;->f:I

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput p1, p0, Lcom/amap/loc/bx;->f:I

    iget v0, p0, Lcom/amap/loc/bx;->d:I

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/loc/bw;

    iget v1, p0, Lcom/amap/loc/bx;->f:I

    iput v1, v0, Lcom/amap/loc/bw;->j:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "hdlCgiSigStrenChange"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method private a(Landroid/telephony/CellLocation;Z)V
    .locals 4

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-nez v0, :cond_1

    :cond_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    invoke-virtual {p0, p1}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Lcom/amap/loc/bx;->b(Landroid/telephony/CellLocation;)Lcom/amap/loc/bw;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    if-nez p2, :cond_0

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNeighboringCellInfo()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/NeighboringCellInfo;

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/telephony/NeighboringCellInfo;->getLac()I

    move-result v2

    invoke-virtual {v0}, Landroid/telephony/NeighboringCellInfo;->getCid()I

    move-result v3

    invoke-direct {p0, v2, v3}, Lcom/amap/loc/bx;->a(II)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-direct {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/NeighboringCellInfo;)Lcom/amap/loc/bw;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v2, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method static synthetic a(Lcom/amap/loc/bx;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amap/loc/bx;->a(I)V

    return-void
.end method

.method private a(II)Z
    .locals 3

    const v2, 0xffff

    const/4 v1, -0x1

    const/4 v0, 0x1

    if-eq p1, v1, :cond_0

    if-eqz p1, :cond_0

    if-gt p1, v2, :cond_0

    if-eq p2, v1, :cond_0

    if-eqz p2, :cond_0

    if-eq p2, v2, :cond_0

    const v1, 0xfffffff

    if-lt p2, v1, :cond_1

    :cond_0
    const/4 v0, 0x0

    :cond_1
    return v0
.end method

.method private declared-synchronized b(ZZ)Landroid/telephony/CellLocation;
    .locals 3

    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/amap/loc/bx;->b:Z

    iget-boolean v0, p0, Lcom/amap/loc/bx;->b:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/amap/loc/bx;->m()Landroid/telephony/CellLocation;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/amap/loc/bx;->n()Landroid/telephony/CellLocation;

    move-result-object v0

    :cond_0
    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v1

    if-eqz v1, :cond_1

    iput-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x0

    :goto_0
    monitor-exit p0

    return-object v0

    :cond_2
    :try_start_1
    iget-boolean v0, p0, Lcom/amap/loc/bx;->b:Z

    iget-object v1, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    iget-object v2, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    invoke-static {v0, v1, v2}, Lcom/amap/loc/cr;->a(ZLandroid/telephony/CellLocation;Landroid/content/Context;)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_1
    iget-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    invoke-direct {p0, v0, p2}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :pswitch_1
    :try_start_2
    iget-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    invoke-direct {p0, v0, p2}, Lcom/amap/loc/bx;->b(Landroid/telephony/CellLocation;Z)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private b(Landroid/telephony/CellLocation;)Lcom/amap/loc/bw;
    .locals 4

    const/4 v3, 0x1

    check-cast p1, Landroid/telephony/gsm/GsmCellLocation;

    new-instance v0, Lcom/amap/loc/bw;

    invoke-direct {v0, v3}, Lcom/amap/loc/bw;-><init>(I)V

    iget-object v1, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-static {v1}, Lcom/amap/loc/cr;->a(Landroid/telephony/TelephonyManager;)[Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v2, v1, v2

    iput-object v2, v0, Lcom/amap/loc/bw;->a:Ljava/lang/String;

    aget-object v1, v1, v3

    iput-object v1, v0, Lcom/amap/loc/bw;->b:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/telephony/gsm/GsmCellLocation;->getLac()I

    move-result v1

    iput v1, v0, Lcom/amap/loc/bw;->c:I

    invoke-virtual {p1}, Landroid/telephony/gsm/GsmCellLocation;->getCid()I

    move-result v1

    iput v1, v0, Lcom/amap/loc/bw;->d:I

    iget v1, p0, Lcom/amap/loc/bx;->f:I

    iput v1, v0, Lcom/amap/loc/bw;->j:I

    return-object v0
.end method

.method private b(Landroid/telephony/CellLocation;Z)V
    .locals 6

    const v5, 0x7fffffff

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    invoke-static {}, Lcom/amap/loc/cr;->c()I

    move-result v0

    const/4 v3, 0x5

    if-lt v0, v3, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v0, :cond_3

    :try_start_1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v3, "mGsmCellLoc"

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/reflect/Field;->isAccessible()Z

    move-result v3

    if-nez v3, :cond_2

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    :cond_2
    invoke-virtual {v0, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/gsm/GsmCellLocation;

    if-eqz v0, :cond_7

    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-direct {p0, v0, p2}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;Z)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move v0, v1

    :goto_1
    if-nez v0, :cond_0

    :cond_3
    :try_start_2
    invoke-virtual {p0, p1}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-static {v0}, Lcom/amap/loc/cr;->a(Landroid/telephony/TelephonyManager;)[Ljava/lang/String;

    move-result-object v0

    new-instance v3, Lcom/amap/loc/bw;

    const/4 v4, 0x2

    invoke-direct {v3, v4}, Lcom/amap/loc/bw;-><init>(I)V

    const/4 v4, 0x0

    aget-object v4, v0, v4

    iput-object v4, v3, Lcom/amap/loc/bw;->a:Ljava/lang/String;

    const/4 v4, 0x1

    aget-object v0, v0, v4

    iput-object v0, v3, Lcom/amap/loc/bw;->b:Ljava/lang/String;

    const-string v0, "getSystemId"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v0

    iput v0, v3, Lcom/amap/loc/bw;->g:I

    const-string v0, "getNetworkId"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v0

    iput v0, v3, Lcom/amap/loc/bw;->h:I

    const-string v0, "getBaseStationId"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v0

    iput v0, v3, Lcom/amap/loc/bw;->i:I

    iget v0, p0, Lcom/amap/loc/bx;->f:I

    iput v0, v3, Lcom/amap/loc/bw;->j:I

    const-string v0, "getBaseStationLatitude"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v0

    iput v0, v3, Lcom/amap/loc/bw;->e:I

    const-string v0, "getBaseStationLongitude"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1, v0, v4}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v0

    iput v0, v3, Lcom/amap/loc/bw;->f:I

    iget v0, v3, Lcom/amap/loc/bw;->e:I

    if-ltz v0, :cond_4

    iget v0, v3, Lcom/amap/loc/bw;->f:I

    if-ltz v0, :cond_4

    iget v0, v3, Lcom/amap/loc/bw;->e:I

    if-eq v0, v5, :cond_4

    iget v0, v3, Lcom/amap/loc/bw;->f:I

    if-eq v0, v5, :cond_4

    iget v0, v3, Lcom/amap/loc/bw;->e:I

    iget v4, v3, Lcom/amap/loc/bw;->f:I

    if-ne v0, v4, :cond_5

    iget v0, v3, Lcom/amap/loc/bw;->e:I

    if-lez v0, :cond_5

    :cond_4
    const/4 v0, 0x0

    iput v0, v3, Lcom/amap/loc/bw;->e:I

    const/4 v0, 0x0

    iput v0, v3, Lcom/amap/loc/bw;->f:I

    move v1, v2

    :cond_5
    if-nez v1, :cond_6

    :cond_6
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "hdlCdmaLocChange"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :catch_1
    move-exception v0

    move v0, v2

    goto/16 :goto_1

    :cond_7
    move v0, v2

    goto/16 :goto_1
.end method

.method static synthetic b(Lcom/amap/loc/bx;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/amap/loc/bx;->m:Z

    return v0
.end method

.method static synthetic c(Lcom/amap/loc/bx;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/bx;->q()V

    return-void
.end method

.method static synthetic d(Lcom/amap/loc/bx;)Landroid/telephony/PhoneStateListener;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    return-object v0
.end method

.method static synthetic e(Lcom/amap/loc/bx;)Landroid/telephony/TelephonyManager;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    return-object v0
.end method

.method static synthetic f(Lcom/amap/loc/bx;)Landroid/telephony/PhoneStateListener;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->o:Landroid/telephony/PhoneStateListener;

    return-object v0
.end method

.method static synthetic g(Lcom/amap/loc/bx;)I
    .locals 1

    iget v0, p0, Lcom/amap/loc/bx;->d:I

    return v0
.end method

.method static synthetic h(Lcom/amap/loc/bx;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/bx;->r()V

    return-void
.end method

.method static synthetic i(Lcom/amap/loc/bx;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/bx;->p()V

    return-void
.end method

.method public static k()I
    .locals 2

    const/4 v0, 0x0

    :try_start_0
    const-string v1, "android.telephony.MSimTelephonyManager"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v0, 0x1

    :goto_0
    if-nez v0, :cond_0

    :try_start_1
    const-string v1, "android.telephony.TelephonyManager2"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    const/4 v0, 0x2

    :cond_0
    :goto_1
    return v0

    :catch_0
    move-exception v1

    goto :goto_1

    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private m()Landroid/telephony/CellLocation;
    .locals 6

    const/4 v5, 0x0

    const/4 v4, 0x1

    iget-object v1, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-nez v1, :cond_1

    const/4 v0, 0x0

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-virtual {p0}, Lcom/amap/loc/bx;->e()Landroid/telephony/CellLocation;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v0, "getAllCellInfo"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-direct {p0, v4, v1, v0, v2}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "getCellLocationExt"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-direct {p0, v4, v1, v0, v2}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "getCellLocationGemini"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-direct {p0, v4, v1, v0, v2}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-eqz v0, :cond_0

    goto :goto_0
.end method

.method private n()Landroid/telephony/CellLocation;
    .locals 7

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    :try_start_0
    invoke-direct {p0}, Lcom/amap/loc/bx;->o()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v2, v1}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    const-string v2, "getCellLocation"

    const/4 v3, 0x0

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v2, "getCellLocationGemini"

    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v2, "getAllCellInfo"

    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-direct {p0, v3, v1, v2, v4}, Lcom/amap/loc/bx;->a(ZLjava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Landroid/telephony/CellLocation;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    if-eqz v0, :cond_0

    goto :goto_0

    :catch_0
    move-exception v1

    const-string v2, "CgiManager"

    const-string v3, "getSim2Cgi"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private o()Ljava/lang/Class;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    const/4 v1, 0x0

    invoke-static {}, Ljava/lang/ClassLoader;->getSystemClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-static {}, Lcom/amap/loc/bx;->k()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    move-object v0, v1

    :goto_0
    :try_start_0
    invoke-virtual {v2, v0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    :goto_1
    return-object v1

    :pswitch_0
    const-string v0, "android.telephony.MSimTelephonyManager"

    goto :goto_0

    :pswitch_1
    const-string v0, "android.telephony.TelephonyManager2"

    goto :goto_0

    :pswitch_2
    const-string v0, "android.telephony.TelephonyManager"

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v2, "CgiManager"

    const-string v3, "getSim2TmClass"

    invoke-static {v0, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private p()V
    .locals 4

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/amap/loc/bx;->j:Lorg/json/JSONObject;

    if-eqz v1, :cond_0

    :try_start_0
    const-string v2, "cellupdate"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "cellupdate"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    :try_start_1
    invoke-static {}, Landroid/telephony/CellLocation;->requestLocationUpdate()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amap/loc/bx;->i:J

    :cond_1
    return-void

    :catch_0
    move-exception v1

    const-string v2, "CgiManager"

    const-string v3, "updateCgi1"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "updateCgi"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private q()V
    .locals 5

    const/16 v4, 0x10

    new-instance v0, Lcom/amap/loc/bx$1;

    invoke-direct {v0, p0}, Lcom/amap/loc/bx$1;-><init>(Lcom/amap/loc/bx;)V

    iput-object v0, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    const-string v1, "android.telephony.PhoneStateListener"

    const-string v0, ""

    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Lcom/amap/loc/cr;->c()I

    move-result v2

    const/4 v3, 0x7

    if-ge v2, v3, :cond_0

    const-string v2, "LISTEN_SIGNAL_STRENGTH"

    invoke-static {v1, v2}, Lcom/amap/loc/cm;->b(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_2

    move-result v0

    :goto_0
    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    iget-object v1, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    invoke-virtual {v0, v1, v4}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V

    :goto_1
    :try_start_1
    invoke-static {}, Lcom/amap/loc/bx;->k()I
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_2
    return-void

    :cond_0
    :try_start_2
    const-string v2, "LISTEN_SIGNAL_STRENGTHS"

    invoke-static {v1, v2}, Lcom/amap/loc/cm;->b(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2

    move-result v0

    goto :goto_0

    :cond_1
    :try_start_3
    iget-object v1, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    iget-object v2, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    or-int/2addr v0, v4

    invoke-virtual {v1, v2, v0}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "initPhoneStateListener1"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :pswitch_0
    :try_start_4
    iget-object v0, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    const-string v1, "phone_msim"

    invoke-static {v0, v1}, Lcom/amap/loc/cr;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_2

    :catch_1
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "initPhoneStateListener"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :pswitch_1
    :try_start_5
    iget-object v0, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    const-string v1, "phone2"

    invoke-static {v0, v1}, Lcom/amap/loc/cr;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;

    goto :goto_2

    :pswitch_2
    iget-object v0, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    const-string v1, "phone2"

    invoke-static {v0, v1}, Lcom/amap/loc/cr;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_2

    :catch_2
    move-exception v1

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private r()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    iput-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;

    const/16 v0, 0x9

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    return-void
.end method


# virtual methods
.method public a(ZZ)Landroid/telephony/CellLocation;
    .locals 1

    invoke-direct {p0, p1, p2}, Lcom/amap/loc/bx;->b(ZZ)Landroid/telephony/CellLocation;

    move-result-object v0

    return-object v0
.end method

.method public a()V
    .locals 4

    const/4 v3, 0x0

    invoke-direct {p0}, Lcom/amap/loc/bx;->p()V

    iget-boolean v0, p0, Lcom/amap/loc/bx;->m:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-eqz v0, :cond_0

    :try_start_0
    iget-boolean v0, p0, Lcom/amap/loc/bx;->b:Z

    iget-object v1, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getCellLocation()Landroid/telephony/CellLocation;

    move-result-object v1

    iget-object v2, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    invoke-static {v0, v1, v2}, Lcom/amap/loc/cr;->a(ZLandroid/telephony/CellLocation;Landroid/content/Context;)I

    move-result v0

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    :goto_1
    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    iput-object v3, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    :cond_2
    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/loc/bx$a;

    const-string v1, "listenerPhoneStateThread"

    invoke-direct {v0, p0, v1}, Lcom/amap/loc/bx$a;-><init>(Lcom/amap/loc/bx;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    goto :goto_1

    :catch_1
    move-exception v0

    iput-object v3, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    const-string v1, "CgiManager"

    const-string v2, "CgiManager"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    const/16 v0, 0x9

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    goto :goto_1
.end method

.method public a(Lorg/json/JSONObject;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/loc/bx;->j:Lorg/json/JSONObject;

    return-void
.end method

.method public a(Landroid/telephony/CellLocation;)Z
    .locals 4

    const/4 v1, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    const/4 v0, 0x1

    iget-boolean v2, p0, Lcom/amap/loc/bx;->b:Z

    iget-object v3, p0, Lcom/amap/loc/bx;->c:Landroid/content/Context;

    invoke-static {v2, p1, v3}, Lcom/amap/loc/cr;->a(ZLandroid/telephony/CellLocation;Landroid/content/Context;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    move v1, v0

    :goto_1
    if-nez v1, :cond_0

    const/16 v0, 0x9

    iput v0, p0, Lcom/amap/loc/bx;->d:I

    goto :goto_0

    :pswitch_0
    :try_start_0
    check-cast p1, Landroid/telephony/gsm/GsmCellLocation;

    invoke-virtual {p1}, Landroid/telephony/gsm/GsmCellLocation;->getLac()I

    move-result v1

    invoke-virtual {p1}, Landroid/telephony/gsm/GsmCellLocation;->getCid()I

    move-result v2

    invoke-direct {p0, v1, v2}, Lcom/amap/loc/bx;->a(II)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    move v1, v0

    goto :goto_1

    :catch_0
    move-exception v1

    const-string v2, "CgiManager"

    const-string v3, "cgiUseful Cgi.iGsmT"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    goto :goto_1

    :pswitch_1
    :try_start_1
    const-string v2, "getSystemId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, v2, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    if-lez v2, :cond_2

    const-string v2, "getNetworkId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, v2, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I

    move-result v2

    if-ltz v2, :cond_2

    const-string v2, "getBaseStationId"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, v2, v3}, Lcom/amap/loc/cm;->b(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-result v2

    if-gez v2, :cond_3

    :cond_2
    move v0, v1

    :cond_3
    move v1, v0

    goto :goto_1

    :catch_1
    move-exception v1

    const-string v2, "CgiManager"

    const-string v3, "cgiUseful Cgi.iCdmaT"

    invoke-static {v1, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public a(Z)Z
    .locals 6

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-nez p1, :cond_0

    iget-wide v2, p0, Lcom/amap/loc/bx;->i:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/amap/loc/bx;->i:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x7530

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public b()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amap/loc/bw;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    return-object v0
.end method

.method public c()Lcom/amap/loc/bw;
    .locals 3

    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x1

    if-lt v1, v2, :cond_0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/loc/bw;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()I
    .locals 1

    iget v0, p0, Lcom/amap/loc/bx;->d:I

    return v0
.end method

.method public e()Landroid/telephony/CellLocation;
    .locals 4

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getCellLocation()Landroid/telephony/CellLocation;

    move-result-object v0

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/amap/loc/bx;->a(Landroid/telephony/CellLocation;)Z

    move-result v2

    if-eqz v2, :cond_0

    iput-object v0, p0, Lcom/amap/loc/bx;->l:Landroid/telephony/CellLocation;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    :cond_0
    :goto_1
    move-object v0, v1

    goto :goto_0

    :catch_1
    move-exception v0

    iput-object v1, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    const-string v2, "CgiManager"

    const-string v3, "getCellLocation"

    invoke-static {v0, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public f()Landroid/telephony/TelephonyManager;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    return-object v0
.end method

.method public g()V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/bx;->r()V

    return-void
.end method

.method public h()V
    .locals 0

    invoke-direct {p0}, Lcom/amap/loc/bx;->p()V

    return-void
.end method

.method public i()V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    iget-object v1, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    iput-object v3, p0, Lcom/amap/loc/bx;->k:Landroid/telephony/PhoneStateListener;

    iget-object v1, p0, Lcom/amap/loc/bx;->n:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/amap/loc/bx;->m:Z

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    const-wide/16 v0, 0x64

    :try_start_2
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1

    :goto_1
    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    iput-object v3, p0, Lcom/amap/loc/bx;->a:Landroid/os/HandlerThread;

    :cond_1
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    const/16 v0, -0x71

    iput v0, p0, Lcom/amap/loc/bx;->f:I

    iput-object v3, p0, Lcom/amap/loc/bx;->g:Landroid/telephony/TelephonyManager;

    iput-object v3, p0, Lcom/amap/loc/bx;->h:Ljava/lang/Object;

    return-void

    :catch_0
    move-exception v0

    const-string v1, "CgiManager"

    const-string v2, "destroy"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method public j()V
    .locals 2

    const/16 v1, 0x9

    iget v0, p0, Lcom/amap/loc/bx;->d:I

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iput v1, p0, Lcom/amap/loc/bx;->d:I

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/amap/loc/bx;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iput v1, p0, Lcom/amap/loc/bx;->d:I

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public l()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/bx;->p:Ljava/lang/String;

    return-object v0
.end method
