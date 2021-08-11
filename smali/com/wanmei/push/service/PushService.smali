.class public Lcom/wanmei/push/service/PushService;
.super Landroid/app/Service;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/service/PushService$c;,
        Lcom/wanmei/push/service/PushService$b;,
        Lcom/wanmei/push/service/PushService$a;
    }
.end annotation


# static fields
.field private static a:[I

.field private static b:Z

.field private static c:I

.field private static d:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

.field private static e:Lcom/wanmei/push/service/PushService$a;

.field private static f:Z


# instance fields
.field private g:Landroid/net/ConnectivityManager;

.field private h:Landroid/content/SharedPreferences;

.field private i:Lcom/wanmei/push/service/c;

.field private j:Lcom/wanmei/push/service/d;

.field private k:Z

.field private l:J

.field private m:Landroid/os/Handler;

.field private n:Lcom/wanmei/push/f/a;

.field private o:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/AppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private p:Landroid/os/IBinder;

.field private q:Landroid/content/BroadcastReceiver;

.field private r:Landroid/content/BroadcastReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    new-array v0, v0, [I

    aput v1, v0, v1

    sput-object v0, Lcom/wanmei/push/service/PushService;->a:[I

    sput-boolean v1, Lcom/wanmei/push/service/PushService;->b:Z

    sput v1, Lcom/wanmei/push/service/PushService;->c:I

    const/4 v0, 0x0

    sput-object v0, Lcom/wanmei/push/service/PushService;->d:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    sput-boolean v1, Lcom/wanmei/push/service/PushService;->f:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    new-instance v0, Lcom/wanmei/push/service/PushService$1;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/PushService$1;-><init>(Lcom/wanmei/push/service/PushService;)V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->p:Landroid/os/IBinder;

    new-instance v0, Lcom/wanmei/push/service/PushService$2;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/PushService$2;-><init>(Lcom/wanmei/push/service/PushService;)V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->q:Landroid/content/BroadcastReceiver;

    new-instance v0, Lcom/wanmei/push/service/PushService$3;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/PushService$3;-><init>(Lcom/wanmei/push/service/PushService;)V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->r:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;J)J
    .locals 1

    iput-wide p1, p0, Lcom/wanmei/push/service/PushService;->l:J

    return-wide p1
.end method

.method private a(Landroid/content/Intent;Ljava/lang/String;)Lcom/wanmei/push/bean/PushMessage;
    .locals 4

    const/4 v1, 0x0

    :try_start_0
    invoke-direct {p0, p2}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;)Lcom/wanmei/push/bean/PushMessage;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :try_start_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string v2, "message"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    invoke-virtual {p1, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    move-object v3, v0

    move-object v0, v1

    move-object v1, v3

    :goto_1
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method private a(Ljava/lang/String;)Lcom/wanmei/push/bean/PushMessage;
    .locals 2

    const/4 v1, 0x0

    :try_start_0
    new-instance v0, Lcom/wanmei/push/service/PushService$6;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/PushService$6;-><init>(Lcom/wanmei/push/service/PushService;)V

    invoke-static {p1, v0}, Lcom/wanmei/push/e/e;->a(Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/PushMessage;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move-object v0, v1

    goto :goto_0
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wanmei/push/service/PushService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v1, "perfectPush.START"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    return-void
.end method

.method private a(Lcom/wanmei/push/bean/AppInfo;)V
    .locals 3

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/service/PushService$7;

    invoke-direct {v1, p0, p1}, Lcom/wanmei/push/service/PushService$7;-><init>(Lcom/wanmei/push/service/PushService;Lcom/wanmei/push/bean/AppInfo;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$g;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "appId"

    invoke-virtual {p1}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "pkName"

    invoke-virtual {p1}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "state"

    const-string v2, "3"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    invoke-static {p0, v0}, Lcom/wanmei/push/d/a;->b(Landroid/content/Context;Ljava/util/Map;)V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;Lcom/wanmei/push/bean/AppInfo;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/bean/AppInfo;)V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    .locals 3

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "android.intent.action.PERFECT_PUSH_STATUS_REFRESH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "hostPackageName"

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "successorPackageName"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->sendBroadcast(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/service/PushService;Z)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/service/PushService;->c(Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1

    if-eqz p2, :cond_1

    const-string v0, "PERFECT_PUSH"

    invoke-static {p0, v0, p1, p2}, Lcom/wanmei/push/g/f;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    invoke-virtual {v0, p1}, Lcom/wanmei/push/service/c;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_1
    return-void

    :cond_1
    const-string v0, "PERFECT_PUSH"

    invoke-static {p0, v0, p1}, Lcom/wanmei/push/g/f;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method static synthetic a(Z)Z
    .locals 0

    sput-boolean p0, Lcom/wanmei/push/service/PushService;->f:Z

    return p0
.end method

.method static synthetic b()Lcom/wanmei/push/service/PushService$a;
    .locals 1

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/push/service/PushService;)Lcom/wanmei/push/service/d;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method private b(Ljava/lang/String;)V
    .locals 5

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v1, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    const-string v0, "hostPackageName"

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v2, 0x1

    if-le v0, v2, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "successorPackageName"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    :cond_1
    invoke-virtual {p0, v1}, Lcom/wanmei/push/service/PushService;->sendBroadcast(Landroid/content/Intent;)V

    return-void
.end method

.method private b(Z)V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "preference_is_started"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    iput-boolean p1, p0, Lcom/wanmei/push/service/PushService;->k:Z

    return-void
.end method

.method static synthetic c()Lcom/wanmei/push/service/PushService$a;
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    return-object v0
.end method

.method static synthetic c(Lcom/wanmei/push/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->i()V

    return-void
.end method

.method static synthetic c(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/service/PushService;->b(Ljava/lang/String;)V

    return-void
.end method

.method private declared-synchronized c(Z)V
    .locals 4

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/wanmei/push/service/PushService;->k:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/wanmei/push/service/PushService;->f:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->n:Lcom/wanmei/push/f/a;

    invoke-virtual {v0}, Lcom/wanmei/push/f/a;->b()J

    move-result-wide v0

    const-string v2, "Connect Lost Reconnecting..."

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    if-eqz p1, :cond_1

    new-instance v0, Lcom/wanmei/push/service/PushService$b;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;B)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/wanmei/push/service/PushService;->m:Landroid/os/Handler;

    new-instance v3, Lcom/wanmei/push/service/PushService$5;

    invoke-direct {v3, p0}, Lcom/wanmei/push/service/PushService$5;-><init>(Lcom/wanmei/push/service/PushService;)V

    invoke-virtual {v2, v3, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic d(Lcom/wanmei/push/service/PushService;)Landroid/content/SharedPreferences;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic d()Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;
    .locals 1

    sget-object v0, Lcom/wanmei/push/service/PushService;->d:Lorg/pwrd/paho/client/mqttv3/MqttClientPersistence;

    return-object v0
.end method

.method static synthetic d(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V
    .locals 7

    const/4 v6, 0x0

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-direct {p0, v1, p1}, Lcom/wanmei/push/service/PushService;->a(Landroid/content/Intent;Ljava/lang/String;)Lcom/wanmei/push/bean/PushMessage;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/wanmei/push/b;->a()Lcom/wanmei/push/b;

    move-result-object v0

    new-instance v1, Lcom/wanmei/push/service/PushService$8;

    invoke-direct {v1, p0, v2}, Lcom/wanmei/push/service/PushService$8;-><init>(Lcom/wanmei/push/service/PushService;Lcom/wanmei/push/bean/PushMessage;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/push/b;->a(Lcom/wanmei/push/b$g;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "appId"

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getAppId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "pkName"

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getBundleId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "state"

    const-string v2, "3"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    invoke-static {p0, v0}, Lcom/wanmei/push/d/a;->b(Landroid/content/Context;Ljava/util/Map;)V

    :cond_0
    return-void

    :cond_1
    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getBundleId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendBroadcast appid = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getAppId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, v6}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendBroadcast package = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, v6}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ".intent.action.PERFECT_PUSH_ARRIVED"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcom/wanmei/push/service/PushService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getBundleId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendBroadcast appid = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/wanmei/push/bean/PushMessage;->getAppId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, v6}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sendBroadcast package = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, v6}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ".intent.action.PERFECT_PUSH_ARRIVED"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcom/wanmei/push/service/PushService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method static synthetic e(Lcom/wanmei/push/service/PushService;)V
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-class v1, Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v1, "perfectPush.KEEP_ALIVE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {p0, v2, v0, v2}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    return-void
.end method

.method static synthetic e()[I
    .locals 1

    sget-object v0, Lcom/wanmei/push/service/PushService;->a:[I

    return-object v0
.end method

.method private f()V
    .locals 5

    const-string v0, "PushService Creating, Check Retry Send Msg To Server"

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {p0}, Lcom/wanmei/push/db/d;->a(Landroid/content/Context;)Lcom/wanmei/push/db/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/db/d;->a()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/Notice;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getMsgId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    const-string v3, "msgId"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getMsgId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getIsOffline()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string v3, "isOffline"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getIsOffline()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getApiAddr()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    const-string v3, "apiADDR"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/Notice;->getApiAddr()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v3, Lcom/wanmei/push/e/a;->h:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    invoke-static {p0, v2}, Lcom/wanmei/push/d/a;->d(Landroid/content/Context;Ljava/util/Map;)V

    :cond_4
    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v3, Lcom/wanmei/push/e/a;->i:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    invoke-static {p0, v2}, Lcom/wanmei/push/d/a;->f(Landroid/content/Context;Ljava/util/Map;)V

    goto/16 :goto_0

    :cond_5
    invoke-static {p0}, Lcom/wanmei/push/db/d;->a(Landroid/content/Context;)Lcom/wanmei/push/db/d;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/db/d;->b()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_6
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppState;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getAppId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_7

    const-string v3, "appId"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7
    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getPkName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_8

    const-string v3, "pkName"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getPkName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8
    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getApiAddr()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_9

    const-string v3, "apiADDR"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getApiAddr()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_9
    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getState()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "state"

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppState;->getState()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_a
    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    const-string v0, "apiADDR"

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v3, Lcom/wanmei/push/e/a;->g:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-static {}, Lcom/wanmei/push/d/a;->a()Lcom/wanmei/push/d/a;

    invoke-static {p0, v2}, Lcom/wanmei/push/d/a;->b(Landroid/content/Context;Ljava/util/Map;)V

    goto :goto_1

    :cond_b
    return-void
.end method

.method static synthetic f(Lcom/wanmei/push/service/PushService;)V
    .locals 7

    const-wide/16 v4, 0x7530

    const/4 v1, 0x0

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-class v2, Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0, p0, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v2, "perfectPush.KEEP_ALIVE"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {p0, v1, v0, v1}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v6

    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    add-long/2addr v2, v4

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setRepeating(IJJLandroid/app/PendingIntent;)V

    return-void
.end method

.method private g()V
    .locals 8

    const/4 v3, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    invoke-virtual {v1}, Lcom/wanmei/push/service/d;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->b(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v2

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_8

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_8

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getAppClientId()Ljava/lang/String;

    move-result-object v5

    invoke-static {p0}, Lcom/wanmei/push/service/b;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    invoke-virtual {v0}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    move v0, v3

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_1
    if-nez v1, :cond_7

    new-instance v0, Lcom/wanmei/push/bean/AppInfo;

    invoke-direct {v0}, Lcom/wanmei/push/bean/AppInfo;-><init>()V

    invoke-static {p0}, Lcom/wanmei/push/service/b;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/AppInfo;->setAppClientId(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/bean/AppInfo;->setPackageName(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v0, v3

    :goto_2
    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v4, v0

    :goto_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lcom/wanmei/push/bean/AppInfo;

    invoke-virtual {v1}, Lcom/wanmei/push/bean/AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/PackageInfo;

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v3

    :goto_4
    if-nez v0, :cond_6

    invoke-interface {v5}, Ljava/util/Iterator;->remove()V

    invoke-direct {p0, v1}, Lcom/wanmei/push/service/PushService;->a(Lcom/wanmei/push/bean/AppInfo;)V

    move v0, v3

    :goto_5
    move v4, v0

    goto :goto_3

    :cond_3
    move v0, v2

    goto :goto_4

    :cond_4
    if-eqz v4, :cond_5

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-static {v1}, Lcom/wanmei/push/service/d;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/d;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_5
    :goto_6
    return-void

    :catch_0
    move-exception v0

    const-string v1, "PushService initAppInfo: AppInfoHasChanged, Save AppInfo Error."

    invoke-direct {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6

    :cond_6
    move v0, v4

    goto :goto_5

    :cond_7
    move v0, v2

    goto :goto_2

    :cond_8
    move v0, v1

    goto/16 :goto_1
.end method

.method static synthetic g(Lcom/wanmei/push/service/PushService;)V
    .locals 4

    const/4 v3, 0x0

    const-string v0, "regist Receiver..."

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->q:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    const-string v1, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    const-string v1, "package"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->r:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    const-string v0, "regist Receiver Done"

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method static synthetic h(Lcom/wanmei/push/service/PushService;)V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/wanmei/push/service/PushService;->b(Z)V

    return-void
.end method

.method private h()Z
    .locals 3

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    const-string v1, "preference_is_started"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private declared-synchronized i()V
    .locals 2

    monitor-enter p0

    :try_start_0
    const-string v0, "Starting Service Connect..."

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->k()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic i(Lcom/wanmei/push/service/PushService;)Z
    .locals 1

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->n()Z

    move-result v0

    return v0
.end method

.method static synthetic j(Lcom/wanmei/push/service/PushService;)J
    .locals 2

    iget-wide v0, p0, Lcom/wanmei/push/service/PushService;->l:J

    return-wide v0
.end method

.method private declared-synchronized j()V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/wanmei/push/service/PushService;->k:Z

    if-nez v0, :cond_1

    const-string v0, "Attempt to stop connection not active."

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    const/4 v0, 0x0

    :try_start_1
    invoke-direct {p0, v0}, Lcom/wanmei/push/service/PushService;->b(Z)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->q:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->r:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    const-string v0, "unregist Receiver Done"

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->a()V

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService$a;->a()V

    const/4 v0, 0x0

    sput-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized k()V
    .locals 3

    monitor-enter p0

    :try_start_0
    const-string v0, "Connecting..."

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    const-string v1, "preference_deviceID"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    const-string v0, "Device ID not found."

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :cond_1
    :try_start_1
    new-instance v0, Lcom/wanmei/push/service/PushService$a;

    const-string v1, "pushserver.laohu.com"

    invoke-direct {v0, p0, v1}, Lcom/wanmei/push/service/PushService$a;-><init>(Lcom/wanmei/push/service/PushService;Ljava/lang/String;)V

    sput-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;
    :try_end_1
    .catch Lorg/pwrd/paho/client/mqttv3/MqttException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "MqttException: "

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lorg/pwrd/paho/client/mqttv3/MqttException;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const-string v0, "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL"

    invoke-direct {p0, v0}, Lcom/wanmei/push/service/PushService;->b(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->n()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/wanmei/push/service/PushService;->l:J

    invoke-virtual {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(J)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_2
    :try_start_3
    const-string v1, "NULL"
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method static synthetic k(Lcom/wanmei/push/service/PushService;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/push/service/PushService;->k:Z

    return v0
.end method

.method private declared-synchronized l()V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/wanmei/push/service/PushService;->k:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService$a;->b()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    :catch_0
    move-exception v0

    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "PushService keepAlive Exception: "

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    invoke-virtual {v0}, Lcom/wanmei/push/service/PushService$a;->a()V

    const/4 v0, 0x0

    sput-object v0, Lcom/wanmei/push/service/PushService;->e:Lcom/wanmei/push/service/PushService$a;

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->a()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_1
    :try_start_2
    const-string v1, "NULL"
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method static synthetic l(Lcom/wanmei/push/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->j()V

    return-void
.end method

.method private declared-synchronized m()V
    .locals 2

    monitor-enter p0

    :try_start_0
    const-string v0, "Connect Retry..."

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-boolean v0, Lcom/wanmei/push/service/PushService;->f:Z

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/service/PushService$b;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;B)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private n()Z
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->g:Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 3

    const/4 v2, 0x0

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-class v1, Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v1, "perfectPush.RECONNECT"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {p0, v2, v0, v2}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    return-void
.end method

.method public final a(J)V
    .locals 9

    const-wide/32 v0, 0xea60

    const/4 v8, 0x0

    iget-object v2, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    const-string v3, "preference_retry_interval"

    invoke-interface {v2, v3, v0, v1}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v6, v4, p1

    cmp-long v2, v6, v2

    if-gez v2, :cond_0

    const-wide/16 v2, 0x2

    mul-long/2addr v2, v6

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    move-wide v2, v0

    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Rescheduling reconnection in "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "ms."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "preference_retry_interval"

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-class v1, Lcom/wanmei/push/service/PushService;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v1, "perfectPush.RECONNECT"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {p0, v8, v0, v8}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    add-long/2addr v2, v4

    invoke-virtual {v0, v8, v2, v3, v1}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    return-void

    :cond_0
    move-wide v2, v0

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 2

    .prologue
    const-string v0, "PushService onBind() IN "

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->p:Landroid/os/IBinder;

    return-object v0
.end method

.method public onCreate()V
    .locals 5

    const/4 v4, 0x0

    const/4 v3, 0x0

    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    const-string v0, "PushService onCreate() IN"

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const-string v0, "PushService Creating service"

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wanmei/push/service/PushService;->l:J

    new-instance v0, Lcom/wanmei/push/service/PushService$4;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/PushService$4;-><init>(Lcom/wanmei/push/service/PushService;)V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->m:Landroid/os/Handler;

    invoke-static {}, Lcom/wanmei/push/f/a;->a()Lcom/wanmei/push/f/a;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->n:Lcom/wanmei/push/f/a;

    :try_start_0
    invoke-static {}, Lcom/wanmei/push/service/c;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/wanmei/push/service/c;

    invoke-direct {v0}, Lcom/wanmei/push/service/c;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Opened log at "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    invoke-virtual {v1}, Lcom/wanmei/push/service/c;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    :try_start_1
    new-instance v0, Lcom/wanmei/push/service/d;

    invoke-direct {v0, p0}, Lcom/wanmei/push/service/d;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Opened Data at "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->j:Lcom/wanmei/push/service/d;

    invoke-virtual {v1}, Lcom/wanmei/push/service/d;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->f()V

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->g()V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "PushService Creating, AppInfo : "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/service/PushService;->o:Ljava/util/List;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const-string v0, "preference_push_service"

    invoke-virtual {p0, v0, v4}, Lcom/wanmei/push/service/PushService;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->h:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "preference_deviceID"

    invoke-static {p0}, Lcom/wanmei/push/g/c;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    const-string v0, "connectivity"

    invoke-virtual {p0, v0}, Lcom/wanmei/push/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/wanmei/push/service/PushService;->g:Landroid/net/ConnectivityManager;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "handleCrashedService() IN [wasStarted()]["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->h()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->h()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "Handling crashed service..."

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-boolean v0, Lcom/wanmei/push/service/PushService;->f:Z

    if-nez v0, :cond_1

    new-instance v0, Lcom/wanmei/push/service/PushService$b;

    invoke-direct {v0, p0, v4}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;B)V

    new-array v1, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    :cond_1
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to open log :"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    :catch_1
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to open Data :"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "PushService onDestroy() IN [started = ]["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v1, p0, Lcom/wanmei/push/service/PushService;->k:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    :try_start_0
    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/push/service/PushService;->i:Lcom/wanmei/push/service/c;

    invoke-virtual {v0}, Lcom/wanmei/push/service/c;->c()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public onRebind(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const-string v0, "PushService onRebind() IN "

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-super {p0, p1}, Landroid/app/Service;->onRebind(Landroid/content/Intent;)V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    const-string v0, "PushService onStartCommand() IN "

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "PushService started with intent="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v3}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "perfectPush.STOP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Lcom/wanmei/push/service/PushService$c;

    invoke-direct {v0, p0, v2}, Lcom/wanmei/push/service/PushService$c;-><init>(Lcom/wanmei/push/service/PushService;B)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$c;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    invoke-virtual {p0}, Lcom/wanmei/push/service/PushService;->stopSelf()V

    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "perfectPush.START"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-boolean v0, Lcom/wanmei/push/service/PushService;->f:Z

    if-nez v0, :cond_0

    new-instance v0, Lcom/wanmei/push/service/PushService$b;

    invoke-direct {v0, p0, v2}, Lcom/wanmei/push/service/PushService$b;-><init>(Lcom/wanmei/push/service/PushService;B)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wanmei/push/service/PushService$b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "perfectPush.KEEP_ALIVE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->l()V

    goto :goto_0

    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "perfectPush.RECONNECT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->n()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/wanmei/push/service/PushService;->m()V

    goto :goto_0
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const-string v0, "PushService onUnbind() IN "

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/wanmei/push/service/PushService;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-super {p0, p1}, Landroid/app/Service;->onUnbind(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method
