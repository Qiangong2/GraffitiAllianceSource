.class public Lcom/wanmei/sdk/core/net/g$b;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/net/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private c:Ljava/lang/String;

.field private d:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private e:Z

.field private f:I

.field private g:Lcom/pwrd/android/volley/Response$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/android/volley/Response$Listener",
            "<TT;>;"
        }
    .end annotation
.end field

.field private h:Lcom/pwrd/android/volley/Response$ErrorListener;

.field private i:Lcom/wanmei/sdk/core/bean/CommReq;

.field private j:Ljava/lang/Class;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->d:Ljava/util/HashMap;

    const/4 v0, 0x0

    iput v0, p0, Lcom/wanmei/sdk/core/net/g$b;->f:I

    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;I)I
    .locals 0

    iput p1, p0, Lcom/wanmei/sdk/core/net/g$b;->f:I

    return p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$ErrorListener;)Lcom/pwrd/android/volley/Response$ErrorListener;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->h:Lcom/pwrd/android/volley/Response$ErrorListener;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Lcom/pwrd/android/volley/Response$Listener;)Lcom/pwrd/android/volley/Response$Listener;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->g:Lcom/pwrd/android/volley/Response$Listener;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Lcom/wanmei/sdk/core/bean/CommReq;)Lcom/wanmei/sdk/core/bean/CommReq;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->i:Lcom/wanmei/sdk/core/bean/CommReq;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->b:Ljava/lang/Class;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->c:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->c:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Ljava/util/Map;)Ljava/util/Map;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->a:Ljava/util/Map;

    return-object p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/net/g$b;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/wanmei/sdk/core/net/g$b;->e:Z

    return p1
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$Listener;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->g:Lcom/pwrd/android/volley/Response$Listener;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/net/g$b;Ljava/lang/Class;)Ljava/lang/Class;
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/g$b;->j:Ljava/lang/Class;

    return-object p1
.end method

.method static synthetic c(Lcom/wanmei/sdk/core/net/g$b;)Lcom/pwrd/android/volley/Response$ErrorListener;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->h:Lcom/pwrd/android/volley/Response$ErrorListener;

    return-object v0
.end method

.method static synthetic d(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->b:Ljava/lang/Class;

    return-object v0
.end method

.method static synthetic e(Lcom/wanmei/sdk/core/net/g$b;)Ljava/lang/Class;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->j:Ljava/lang/Class;

    return-object v0
.end method

.method static synthetic f(Lcom/wanmei/sdk/core/net/g$b;)Lcom/wanmei/sdk/core/bean/CommReq;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->i:Lcom/wanmei/sdk/core/bean/CommReq;

    return-object v0
.end method

.method static synthetic g(Lcom/wanmei/sdk/core/net/g$b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/net/g$b;->f:I

    return v0
.end method

.method static synthetic h(Lcom/wanmei/sdk/core/net/g$b;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/net/g$b;->e:Z

    return v0
.end method

.method static synthetic i(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/Map;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->a:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic j(Lcom/wanmei/sdk/core/net/g$b;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/g$b;->d:Ljava/util/HashMap;

    return-object v0
.end method
