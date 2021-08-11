.class public final Lcom/wanmei/push/e/b;
.super Ljava/lang/Object;


# static fields
.field private static c:Lcom/wanmei/push/e/b;


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/wanmei/push/e/c;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    new-instance v0, Lcom/wanmei/push/e/c;

    invoke-direct {v0}, Lcom/wanmei/push/e/c;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/e/b;->b:Lcom/wanmei/push/e/c;

    goto :goto_0
.end method

.method private a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<TT;>;>;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    const-string v1, "PERFECT_PUSH"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Http Request : url -  ["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] requestParams - ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] isUseHttps - [false]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/wanmei/push/bean/StandardBaseResult;

    invoke-direct {v1}, Lcom/wanmei/push/bean/StandardBaseResult;-><init>()V

    const-string v0, "UTF-8"

    new-instance v2, Lcom/wanmei/push/e/d;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-direct {v2, v3, p1, p3}, Lcom/wanmei/push/e/d;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v2, p2}, Lcom/wanmei/push/e/d;->a(Ljava/util/HashMap;)V

    :cond_0
    new-instance v3, Lcom/wanmei/push/e/b$9;

    invoke-direct {v3, p0, v0}, Lcom/wanmei/push/e/b$9;-><init>(Lcom/wanmei/push/e/b;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/wanmei/push/e/d;->a(Lcom/wanmei/push/e/d$a;)V

    iget-object v0, p0, Lcom/wanmei/push/e/b;->b:Lcom/wanmei/push/e/c;

    invoke-virtual {v0, v2}, Lcom/wanmei/push/e/c;->a(Lcom/wanmei/push/e/d;)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    const-string v3, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Http Response Json : Json - ["

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] url -  ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] requestParams - ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] isUseHttps - [false]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    :goto_0
    return-object v1

    :cond_1
    :try_start_0
    invoke-static {v0, p4}, Lcom/wanmei/push/e/e;->a(Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/StandardBaseResult;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    move-object v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    const-string v3, "PERFECT_PUSH"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendStandardPostRequest "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v3, v0}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_1
.end method

.method public static a(Landroid/content/Context;)Lcom/wanmei/push/e/b;
    .locals 1

    sget-object v0, Lcom/wanmei/push/e/b;->c:Lcom/wanmei/push/e/b;

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/e/b;

    invoke-direct {v0, p0}, Lcom/wanmei/push/e/b;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/wanmei/push/e/b;->c:Lcom/wanmei/push/e/b;

    :cond_0
    sget-object v0, Lcom/wanmei/push/e/b;->c:Lcom/wanmei/push/e/b;

    return-object v0
.end method

.method private final a(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    new-instance v1, Ljava/util/TreeSet;

    invoke-direct {v1, v0}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientSecret()Ljava/lang/String;

    move-result-object p2

    :cond_0
    const-string v0, "PERFECT_PUSH"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "key  ="

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x2

    const/4 v4, 0x5

    invoke-virtual {p2, v1, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v4, 0xa

    const/16 v5, 0x10

    invoke-virtual {p2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v4, 0x12

    const/16 v5, 0x14

    invoke-virtual {p2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v4, 0xe

    const/16 v5, 0x13

    invoke-virtual {p2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "="

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v0, ""

    :goto_1
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_1
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_1

    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/push/g/g;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private final d(Ljava/util/Map;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wanmei/push/e/b;->a(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final a()Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v0, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v3}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v4, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v4}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "appId"

    invoke-virtual {v2, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "deviceId"

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "platform"

    const-string v3, "1"

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "bundleId"

    invoke-virtual {v2, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "v"

    const-string v3, "1.0"

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "systemType"

    const/4 v0, 0x0

    invoke-static {}, Lcom/wanmei/push/g/i;->b()Z

    move-result v4

    if-eqz v4, :cond_0

    const/4 v0, 0x1

    :cond_0
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "sign"

    invoke-direct {p0, v2}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/wanmei/push/e/a;->c:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$2;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$2;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/String;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v2}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v3}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v4, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v4}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "appId"

    invoke-virtual {v1, v5, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "deviceId"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "bundleId"

    invoke-virtual {v1, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "certType"

    invoke-virtual {v1, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "v"

    const-string v3, "1.0"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sign"

    invoke-direct {p0, v1}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v2, Lcom/wanmei/push/e/a;->d:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$4;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$4;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v2}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "sdkType"

    sget v4, Lcom/wanmei/push/a;->b:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "sdkAppId"

    invoke-virtual {v1, v3, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "platform"

    sget v4, Lcom/wanmei/push/a;->c:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "deviceId"

    invoke-virtual {v1, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "bundleId"

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "v"

    const-string v3, "1.0"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sign"

    invoke-direct {p0, v1, p2}, Lcom/wanmei/push/e/b;->a(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v2, Lcom/wanmei/push/e/a;->b:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$1;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$1;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    const-string v0, ""

    const-string v2, ""

    const-string v3, ""

    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v1, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v1}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v1, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v1}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v7

    const-string v1, "state"

    invoke-interface {p1, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v0, "state"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    move-object v1, v0

    :goto_0
    const-string v0, "appId"

    invoke-interface {p1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "appId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    move-object v2, v0

    :cond_0
    const-string v0, "pkName"

    invoke-interface {p1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "pkName"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :goto_1
    const-string v3, "appId"

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "uAppId"

    invoke-virtual {v5, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "deviceId"

    invoke-virtual {v5, v2, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "platform"

    const-string v3, "1"

    invoke-virtual {v5, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "uBundleId"

    invoke-virtual {v5, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "state"

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "v"

    const-string v1, "1.0"

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "sign"

    invoke-direct {p0, v5}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/wanmei/push/e/a;->g:Ljava/lang/String;

    new-instance v1, Lcom/wanmei/push/e/b$6;

    invoke-direct {v1, p0}, Lcom/wanmei/push/e/b$6;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v0, v4, v5, v1}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0

    :cond_1
    move-object v0, v3

    goto :goto_1

    :cond_2
    move-object v1, v0

    goto :goto_0
.end method

.method public final b()Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v2}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v3}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v4, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v4}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceName()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v5, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v5}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/wanmei/push/bean/DeviceInfo;->getSysVersion()Ljava/lang/String;

    move-result-object v5

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v6, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v6}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v6

    invoke-virtual {v6}, Lcom/wanmei/push/bean/DeviceInfo;->getResolution()Ljava/lang/String;

    move-result-object v6

    const-string v7, "appId"

    invoke-virtual {v1, v7, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "deviceId"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "platform"

    const-string v3, "1"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "deviceName"

    invoke-virtual {v1, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sysVersion"

    invoke-virtual {v1, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "resolution"

    invoke-virtual {v1, v2, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "isBreak"

    const-string v3, "0"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "v"

    const-string v3, "1.0"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sign"

    invoke-direct {p0, v1}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v2, Lcom/wanmei/push/e/a;->e:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$3;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$3;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final b(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    const-string v0, ""

    const-string v1, ""

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v4, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v4}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v5, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v5}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v5

    const-string v6, "msgId"

    invoke-interface {p1, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const-string v6, "isOffline"

    invoke-interface {p1, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const-string v0, "msgId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v1, "isOffline"

    invoke-interface {p1, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    :cond_0
    const-string v6, "appId"

    invoke-virtual {v3, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "deviceId"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "platform"

    const-string v5, "1"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "msgId"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "isOffline"

    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "v"

    const-string v1, "1.0"

    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "sign"

    invoke-direct {p0, v3}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/wanmei/push/e/a;->h:Ljava/lang/String;

    new-instance v1, Lcom/wanmei/push/e/b$7;

    invoke-direct {v1, p0}, Lcom/wanmei/push/e/b$7;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v0, v2, v3, v1}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final c()Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<",
            "Lcom/wanmei/push/bean/SyncAppInfo;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v2, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v2}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v3}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    const-string v4, "appId"

    invoke-virtual {v1, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "deviceId"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "v"

    const-string v3, "1.0"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "sign"

    invoke-direct {p0, v1}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v2, Lcom/wanmei/push/e/a;->f:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$5;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$5;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v2, v0, v1, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method

.method public final c(Ljava/util/Map;)Lcom/wanmei/push/bean/StandardBaseResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/wanmei/push/bean/StandardBaseResult",
            "<*>;"
        }
    .end annotation

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    const-string v0, ""

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v3, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v3}, Lcom/wanmei/push/d/c;->b(Landroid/content/Context;)Lcom/wanmei/push/bean/AppInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/wanmei/push/d/c;->a()Lcom/wanmei/push/d/c;

    iget-object v4, p0, Lcom/wanmei/push/e/b;->a:Landroid/content/Context;

    invoke-static {v4}, Lcom/wanmei/push/d/c;->a(Landroid/content/Context;)Lcom/wanmei/push/bean/DeviceInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wanmei/push/bean/DeviceInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v4

    const-string v5, "msgId"

    invoke-interface {p1, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v0, "msgId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :cond_0
    const-string v5, "appId"

    invoke-virtual {v2, v5, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "deviceId"

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "platform"

    const-string v4, "1"

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "msgId"

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "v"

    const-string v3, "1.0"

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "t"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "sign"

    invoke-direct {p0, v2}, Lcom/wanmei/push/e/b;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/wanmei/push/e/a;->i:Ljava/lang/String;

    new-instance v3, Lcom/wanmei/push/e/b$8;

    invoke-direct {v3, p0}, Lcom/wanmei/push/e/b$8;-><init>(Lcom/wanmei/push/e/b;)V

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/wanmei/push/e/b;->a(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Lcom/pwrd/google/gson/reflect/TypeToken;)Lcom/wanmei/push/bean/StandardBaseResult;

    move-result-object v0

    return-object v0
.end method
