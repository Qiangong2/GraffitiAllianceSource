.class public Lcom/amap/loc/cg;
.super Ljava/lang/Object;
.source "LocNetManager.java"


# static fields
.field private static h:Lcom/amap/loc/cg;


# instance fields
.field a:Lcom/amap/loc/bf;

.field b:Lcom/amap/loc/bh;

.field c:Z

.field d:J

.field e:Z

.field public f:Ljava/lang/String;

.field g:Z

.field private i:Ljava/lang/Object;

.field private j:Ljava/lang/String;

.field private k:I

.field private l:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/amap/loc/cg;->h:Lcom/amap/loc/cg;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    const/4 v0, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amap/loc/cg;->a:Lcom/amap/loc/bf;

    iput-object v0, p0, Lcom/amap/loc/cg;->b:Lcom/amap/loc/bh;

    iput-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    const-string v0, "apilocatesrc.amap.com"

    iput-object v0, p0, Lcom/amap/loc/cg;->j:Ljava/lang/String;

    iput-boolean v2, p0, Lcom/amap/loc/cg;->c:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amap/loc/cg;->d:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/cg;->e:Z

    const-string v0, "com.autonavi.httpdns.HttpDnsManager"

    iput-object v0, p0, Lcom/amap/loc/cg;->f:Ljava/lang/String;

    iput v2, p0, Lcom/amap/loc/cg;->k:I

    sget v0, Lcom/amap/loc/c;->e:I

    iput v0, p0, Lcom/amap/loc/cg;->l:I

    iput-boolean v2, p0, Lcom/amap/loc/cg;->g:Z

    invoke-direct {p0, p1}, Lcom/amap/loc/cg;->c(Landroid/content/Context;)V

    invoke-static {}, Lcom/amap/loc/bf;->a()Lcom/amap/loc/bf;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/cg;->a:Lcom/amap/loc/bf;

    return-void
.end method

.method public static a(Landroid/net/NetworkInfo;)I
    .locals 2

    const/4 v0, -0x1

    if-nez p0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getType()I

    move-result v0

    goto :goto_0
.end method

.method public static declared-synchronized a(Landroid/content/Context;Z)Lcom/amap/loc/cg;
    .locals 2

    const-class v1, Lcom/amap/loc/cg;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amap/loc/cg;->h:Lcom/amap/loc/cg;

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/loc/cg;

    invoke-direct {v0, p0}, Lcom/amap/loc/cg;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amap/loc/cg;->h:Lcom/amap/loc/cg;

    :cond_0
    sget-object v0, Lcom/amap/loc/cg;->h:Lcom/amap/loc/cg;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    const/4 v4, 0x0

    invoke-direct {p0, p1}, Lcom/amap/loc/cg;->d(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    const-string v1, "getIpByHostAsync"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amap/loc/cm;->a(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, "HttpDns"

    invoke-static {p1, v0, v4}, Lcom/amap/loc/co;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)Z
    .locals 6

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, -0x1

    const/4 v1, 0x0

    :try_start_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xe

    if-lt v0, v5, :cond_0

    move v0, v2

    :goto_0
    if-eqz v0, :cond_2

    const-string v0, "http.proxyHost"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v0, "http.proxyPort"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    :goto_1
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    :goto_2
    if-eqz v1, :cond_3

    if-eq v0, v4, :cond_3

    move v0, v2

    :goto_3
    return v0

    :cond_0
    move v0, v3

    goto :goto_0

    :cond_1
    const-string v0, "-1"

    goto :goto_1

    :cond_2
    invoke-static {p0}, Landroid/net/Proxy;->getHost(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Landroid/net/Proxy;->getPort(Landroid/content/Context;)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_2

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    move v0, v4

    goto :goto_2

    :cond_3
    move v0, v3

    goto :goto_3
.end method

.method private b(Landroid/content/Context;)Z
    .locals 6

    const-wide/16 v4, 0x0

    const-string v0, "pref"

    const-string v1, "dns_faile_count"

    invoke-static {p1, v0, v1, v4, v5}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J

    move-result-wide v0

    const-string v2, "pref"

    const-string v3, "dns_faile_time"

    invoke-static {p1, v2, v3, v4, v5}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J

    move-result-wide v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v2, v3, v4, v5}, Lcom/amap/loc/cr;->b(JJ)Z

    move-result v2

    if-eqz v2, :cond_0

    const-wide/16 v2, 0x3

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private c(Landroid/content/Context;)V
    .locals 8

    const/4 v6, 0x0

    const/4 v7, 0x1

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amap/loc/cg;->g:Z

    if-nez v0, :cond_0

    const-string v0, "HttpDNS"

    const-string v1, "1.0.0"

    invoke-static {v0, v1}, Lcom/amap/loc/c;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/amap/loc/q;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/amap/loc/co;->a(Landroid/content/Context;Lcom/amap/loc/q;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/loc/cg;->g:Z

    iget-boolean v0, p0, Lcom/amap/loc/cg;->g:Z

    if-eqz v0, :cond_1

    iget-object v2, p0, Lcom/amap/loc/cg;->f:Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/Class;

    const/4 v0, 0x0

    const-class v5, Landroid/content/Context;

    aput-object v5, v4, v0

    const/4 v0, 0x1

    new-array v5, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    aput-object p1, v5, v0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lcom/amap/loc/ar;->a(Landroid/content/Context;Lcom/amap/loc/q;Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    iget-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    if-nez v0, :cond_2

    move v0, v6

    :goto_0
    const-string v1, "HttpDns"

    invoke-static {p1, v1, v0}, Lcom/amap/loc/co;->a(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_0
    :goto_1
    return-void

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/loc/cg;->g:Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    const-string v1, "APS"

    const-string v2, "initHttpDns"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move v0, v7

    goto :goto_0
.end method

.method private d(Landroid/content/Context;)Z
    .locals 1

    iget-object v0, p0, Lcom/amap/loc/cg;->i:Ljava/lang/Object;

    if-eqz v0, :cond_0

    invoke-static {p1}, Lcom/amap/loc/cg;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()I
    .locals 1

    iget v0, p0, Lcom/amap/loc/cg;->k:I

    return v0
.end method

.method public a(Landroid/content/Context;Lorg/json/JSONObject;Lcom/amap/loc/cj;Ljava/lang/String;Z)Lcom/amap/loc/bl;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    const-string v0, "httptimeout"

    invoke-static {p2, v0}, Lcom/amap/loc/cr;->a(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    const-string v0, "httptimeout"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/amap/loc/cg;->l:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    invoke-static {p1}, Lcom/amap/loc/cr;->c(Landroid/content/Context;)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-static {v0}, Lcom/amap/loc/cg;->a(Landroid/net/NetworkInfo;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    const/4 v0, 0x0

    :cond_1
    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "LocNetManager"

    const-string v2, "req"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    new-instance v2, Lcom/amap/loc/ch;

    const-string v0, "loc"

    const-string v3, "3.0.0"

    invoke-static {v0, v3}, Lcom/amap/loc/c;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/amap/loc/q;

    move-result-object v0

    invoke-direct {v2, p1, v0}, Lcom/amap/loc/ch;-><init>(Landroid/content/Context;Lcom/amap/loc/q;)V

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    const-string v0, "Content-Type"

    const-string v3, "application/octet-stream"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "Accept-Encoding"

    const-string v3, "gzip"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "gzipped"

    const-string v3, "1"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "Connection"

    const-string v3, "Keep-Alive"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "User-Agent"

    const-string v3, "AMAP_Location_SDK_Android 3.0.0"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "KEY"

    invoke-static {p1}, Lcom/amap/loc/i;->f(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "enginever"

    const-string v3, "4.2"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcom/amap/loc/k;->a()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "key="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Lcom/amap/loc/i;->f(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v0, v3}, Lcom/amap/loc/k;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ts"

    invoke-interface {v1, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "scode"

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "loc"

    if-nez p5, :cond_3

    const-string v0, "locf"

    :cond_3
    const-string v3, "encr"

    const-string v4, "1"

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v2, p5}, Lcom/amap/loc/ch;->a(Z)V

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v4, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "3.0.0"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    const/4 v0, 0x2

    const/4 v6, 0x3

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v0

    invoke-static {v3, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Lcom/amap/loc/ch;->b(Ljava/util/Map;)V

    invoke-virtual {v2, p4}, Lcom/amap/loc/ch;->b(Ljava/lang/String;)V

    invoke-virtual {p3}, Lcom/amap/loc/cj;->a()[B

    move-result-object v0

    invoke-static {v0}, Lcom/amap/loc/cr;->a([B)[B

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->c([B)V

    invoke-static {p1}, Lcom/amap/loc/o;->a(Landroid/content/Context;)Ljava/net/Proxy;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(Ljava/net/Proxy;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "output"

    const-string v3, "bin"

    invoke-interface {v0, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "policy"

    const-string v3, "2103"

    invoke-interface {v0, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(Ljava/util/Map;)V

    iget v0, p0, Lcom/amap/loc/cg;->l:I

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(I)V

    iget v0, p0, Lcom/amap/loc/cg;->l:I

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->b(I)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/loc/cg;->c:Z

    const-string v0, "locationProtocol"

    const/4 v1, 0x0

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-virtual {v2}, Lcom/amap/loc/ch;->b()Ljava/lang/String;

    move-result-object v0

    const-string v3, "http"

    const-string v4, "https"

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->b(Ljava/lang/String;)V

    :cond_4
    :goto_2
    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v4

    :try_start_1
    iget-object v0, p0, Lcom/amap/loc/cg;->a:Lcom/amap/loc/bf;

    invoke-virtual {v0, v2, v1}, Lcom/amap/loc/bf;->a(Lcom/amap/loc/bk;Z)Lcom/amap/loc/bl;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    invoke-static {}, Lcom/amap/loc/cr;->b()J

    move-result-wide v2

    sub-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->intValue()I

    move-result v1

    iput v1, p0, Lcom/amap/loc/cg;->k:I

    iget-boolean v1, p0, Lcom/amap/loc/cg;->c:Z

    if-eqz v1, :cond_1

    const-string v1, "pref"

    const-string v2, "dns_faile_time"

    const-wide/16 v4, 0x0

    invoke-static {p1, v1, v2, v4, v5}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    const-string v1, "pref"

    const-string v2, "dns_faile_count"

    const-wide/16 v4, 0x0

    invoke-static {p1, v1, v2, v4, v5}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amap/loc/cg;->e:Z

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/amap/loc/cg;->d:J

    goto/16 :goto_1

    :cond_5
    invoke-direct {p0, p1}, Lcom/amap/loc/cg;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-direct {p0, p1}, Lcom/amap/loc/cg;->d(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/amap/loc/cg;->j:Ljava/lang/String;

    invoke-direct {p0, p1, v0}, Lcom/amap/loc/cg;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez p5, :cond_6

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_6

    const-string v0, "ip"

    const-string v3, "last_ip"

    const-string v4, ""

    invoke-static {p1, v0, v3, v4}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_6
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amap/loc/cg;->c:Z

    const-string v3, "ip"

    const-string v4, "last_ip"

    invoke-static {p1, v3, v4, v0}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/amap/loc/c;->b()Ljava/lang/String;

    move-result-object v3

    const-string v4, "apilocatesrc.amap.com"

    invoke-virtual {v3, v4, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->b(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amap/loc/ch;->a()Ljava/util/Map;

    move-result-object v0

    const-string v3, "host"

    const-string v4, "apilocatesrc.amap.com"

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_2

    :catch_1
    move-exception v0

    iget-boolean v1, p0, Lcom/amap/loc/cg;->c:Z

    if-eqz v1, :cond_8

    const-string v1, "pref"

    const-string v2, "dns_faile_count"

    const-wide/16 v4, 0x0

    invoke-static {p1, v1, v2, v4, v5}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/amap/loc/cg;->d:J

    const-string v1, "pref"

    const-string v2, "dns_faile_time"

    const-wide/16 v4, 0x0

    invoke-static {p1, v1, v2, v4, v5}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J

    move-result-wide v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v1, v2, v6

    if-nez v1, :cond_7

    const-string v1, "pref"

    const-string v6, "dns_faile_time"

    invoke-static {p1, v1, v6, v4, v5}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    :cond_7
    invoke-static {v2, v3, v4, v5}, Lcom/amap/loc/cr;->b(JJ)Z

    move-result v1

    if-nez v1, :cond_a

    iget-wide v2, p0, Lcom/amap/loc/cg;->d:J

    const-wide/16 v6, 0x3

    cmp-long v1, v2, v6

    if-ltz v1, :cond_9

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amap/loc/cg;->e:Z

    :goto_3
    const-string v1, "pref"

    const-string v2, "dns_last_success"

    iget-boolean v3, p0, Lcom/amap/loc/cg;->e:Z

    invoke-static {p1, v1, v2, v3}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/amap/loc/cg;->d:J

    :goto_4
    iget-wide v2, p0, Lcom/amap/loc/cg;->d:J

    const-wide/16 v6, 0x1

    add-long/2addr v2, v6

    iput-wide v2, p0, Lcom/amap/loc/cg;->d:J

    const-string v1, "pref"

    const-string v2, "dns_faile_count"

    iget-wide v6, p0, Lcom/amap/loc/cg;->d:J

    invoke-static {p1, v1, v2, v6, v7}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    const-string v1, "pref"

    const-string v2, "dns_faile_time"

    invoke-static {p1, v1, v2, v4, v5}, Lcom/amap/loc/cq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    iget-wide v2, p0, Lcom/amap/loc/cg;->d:J

    const-wide/16 v4, 0x3

    cmp-long v1, v2, v4

    if-ltz v1, :cond_8

    iget-boolean v1, p0, Lcom/amap/loc/cg;->e:Z

    if-nez v1, :cond_8

    const-string v1, "HttpDNS"

    const-string v2, "dns faile too much"

    invoke-static {p1, v1, v2}, Lcom/amap/loc/cp;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_8
    throw v0

    :cond_9
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amap/loc/cg;->e:Z

    goto :goto_3

    :cond_a
    const-string v1, "pref"

    const-string v2, "dns_last_success"

    const/4 v3, 0x1

    invoke-static {p1, v1, v2, v3}, Lcom/amap/loc/cq;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amap/loc/cg;->e:Z

    goto :goto_4
.end method

.method public a([BLandroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 11

    const/4 v1, 0x0

    const/4 v10, 0x3

    const/4 v9, 0x1

    invoke-static {p2}, Lcom/amap/loc/cr;->c(Landroid/content/Context;)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-static {v0}, Lcom/amap/loc/cg;->a(Landroid/net/NetworkInfo;)I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_0

    :goto_0
    return-object v1

    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v2, Lcom/amap/loc/ch;

    const-string v3, "loc"

    const-string v4, "3.0.0"

    invoke-static {v3, v4}, Lcom/amap/loc/c;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/amap/loc/q;

    move-result-object v3

    invoke-direct {v2, p2, v3}, Lcom/amap/loc/ch;-><init>(Landroid/content/Context;Lcom/amap/loc/q;)V

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    const-string v3, "Content-Type"

    const-string v4, "application/x-www-form-urlencoded"

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "Connection"

    const-string v4, "Keep-Alive"

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz p4, :cond_1

    const-string v3, "User-Agent"

    const-string v4, "AMAP_Location_SDK_Android 3.0.0"

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "custom"

    const-string v5, "26260A1F00020002"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "key"

    invoke-static {p2}, Lcom/amap/loc/i;->f(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcom/amap/loc/k;->a()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3}, Lcom/amap/loc/r;->c(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v5

    invoke-static {p2, v4, v5}, Lcom/amap/loc/k;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "ts"

    invoke-interface {v3, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "scode"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v2, p1}, Lcom/amap/loc/ch;->b([B)V

    invoke-virtual {v2, v9}, Lcom/amap/loc/ch;->a(Z)V

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v5, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s"

    new-array v6, v10, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "3.0.0"

    aput-object v8, v6, v7

    const-string v7, "loc"

    aput-object v7, v6, v9

    const/4 v7, 0x2

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amap/loc/ch;->a(Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/amap/loc/ch;->a(Ljava/util/Map;)V

    :cond_1
    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->b(Ljava/util/Map;)V

    invoke-virtual {v2, p3}, Lcom/amap/loc/ch;->b(Ljava/lang/String;)V

    if-nez p4, :cond_2

    invoke-virtual {v2, p1}, Lcom/amap/loc/ch;->c([B)V

    :cond_2
    invoke-static {p2}, Lcom/amap/loc/o;->a(Landroid/content/Context;)Ljava/net/Proxy;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(Ljava/net/Proxy;)V

    sget v0, Lcom/amap/loc/c;->e:I

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->a(I)V

    sget v0, Lcom/amap/loc/c;->e:I

    invoke-virtual {v2, v0}, Lcom/amap/loc/ch;->b(I)V

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/cg;->a:Lcom/amap/loc/bf;

    invoke-virtual {v0, v2}, Lcom/amap/loc/bf;->a(Lcom/amap/loc/bk;)[B

    move-result-object v2

    new-instance v0, Ljava/lang/String;

    const-string v3, "utf-8"

    invoke-direct {v0, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    move-object v1, v0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    const-string v2, "LocNetManager"

    const-string v3, "post"

    invoke-static {v0, v2, v3}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_1
.end method
