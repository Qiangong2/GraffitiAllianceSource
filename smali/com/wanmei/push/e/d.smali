.class public final Lcom/wanmei/push/e/d;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/e/d$a;
    }
.end annotation


# static fields
.field private static a:Lcom/wanmei/push/e/d$a;


# instance fields
.field private b:Ljava/lang/String;

.field private c:I

.field private d:I

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:S

.field private j:Ljava/util/Map;
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

.field private k:Ljava/util/HashMap;
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

.field private l:Ljava/lang/String;

.field private m:Ljava/net/Proxy;

.field private n:Lcom/wanmei/push/e/d$a;

.field private o:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/wanmei/push/e/d$1;

    invoke-direct {v0}, Lcom/wanmei/push/e/d$1;-><init>()V

    sput-object v0, Lcom/wanmei/push/e/d;->a:Lcom/wanmei/push/e/d$a;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v3, 0x0

    const/16 v1, 0x61a8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "UTF-8"

    iput-object v0, p0, Lcom/wanmei/push/e/d;->b:Ljava/lang/String;

    iput v1, p0, Lcom/wanmei/push/e/d;->c:I

    iput v1, p0, Lcom/wanmei/push/e/d;->d:I

    const-string v0, "application/x-www-form-urlencoded;charset=UTF-8"

    iput-object v0, p0, Lcom/wanmei/push/e/d;->e:Ljava/lang/String;

    const-string v0, "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)"

    iput-object v0, p0, Lcom/wanmei/push/e/d;->f:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/push/e/d;->g:Ljava/lang/String;

    sget-object v0, Lcom/wanmei/push/e/d;->a:Lcom/wanmei/push/e/d$a;

    iput-object v0, p0, Lcom/wanmei/push/e/d;->n:Lcom/wanmei/push/e/d$a;

    iput-object p2, p0, Lcom/wanmei/push/e/d;->h:Ljava/lang/String;

    const/4 v0, 0x1

    iput-short v0, p0, Lcom/wanmei/push/e/d;->i:S

    iput-object p3, p0, Lcom/wanmei/push/e/d;->j:Ljava/util/Map;

    invoke-static {p1}, Lcom/wanmei/push/g/h;->a(Landroid/content/Context;)Lcom/wanmei/push/g/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/push/g/h;->a()I

    move-result v1

    if-nez v1, :cond_2

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-gt v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/push/g/h;->c()Ljava/net/InetSocketAddress;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v1, Ljava/net/Proxy;

    sget-object v2, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    invoke-direct {v1, v2, v0}, Ljava/net/Proxy;-><init>(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V

    iput-object v1, p0, Lcom/wanmei/push/e/d;->m:Ljava/net/Proxy;

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-object v3, p0, Lcom/wanmei/push/e/d;->m:Ljava/net/Proxy;

    goto :goto_0

    :cond_2
    iput-object v3, p0, Lcom/wanmei/push/e/d;->m:Ljava/net/Proxy;

    goto :goto_0
.end method


# virtual methods
.method public final a()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/e/d;->l:Ljava/lang/String;

    return-object v0
.end method

.method public final a(Lcom/wanmei/push/e/d$a;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/e/d;->n:Lcom/wanmei/push/e/d$a;

    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/e/d;->h:Ljava/lang/String;

    return-void
.end method

.method public final a(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/wanmei/push/e/d;->k:Ljava/util/HashMap;

    return-void
.end method

.method public final b()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/e/d;->k:Ljava/util/HashMap;

    return-object v0
.end method

.method public final b(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/e/d;->g:Ljava/lang/String;

    return-void
.end method

.method public final c()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/e/d;->h:Ljava/lang/String;

    return-object v0
.end method

.method public final d()S
    .locals 1

    iget-short v0, p0, Lcom/wanmei/push/e/d;->i:S

    return v0
.end method

.method public final e()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/e/d;->j:Ljava/util/Map;

    return-object v0
.end method

.method public final f()I
    .locals 1

    iget v0, p0, Lcom/wanmei/push/e/d;->c:I

    return v0
.end method

.method public final g()I
    .locals 1

    iget v0, p0, Lcom/wanmei/push/e/d;->d:I

    return v0
.end method

.method public final h()Ljava/net/Proxy;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/e/d;->m:Ljava/net/Proxy;

    return-object v0
.end method

.method public final i()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/e/d;->g:Ljava/lang/String;

    return-object v0
.end method

.method public final j()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/push/e/d;->n:Lcom/wanmei/push/e/d$a;

    iget-object v1, p0, Lcom/wanmei/push/e/d;->j:Ljava/util/Map;

    invoke-interface {v0, v1}, Lcom/wanmei/push/e/d$a;->a(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final k()Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/push/e/d;->o:Z

    return v0
.end method
