.class public Lcom/wanmei/sdk/core/net/d;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/net/d$a;
    }
.end annotation


# static fields
.field private static o:Lcom/wanmei/sdk/core/net/d$a;


# instance fields
.field private a:Ljava/lang/String;

.field private b:I

.field private c:I

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:S

.field private i:Ljava/lang/String;

.field private j:Ljava/util/HashMap;
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

.field private k:Ljava/lang/String;

.field private l:Ljava/net/Proxy;

.field private m:Ljava/util/Map;
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

.field private n:Lcom/wanmei/sdk/core/net/d$a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/wanmei/sdk/core/net/d$1;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/net/d$1;-><init>()V

    sput-object v0, Lcom/wanmei/sdk/core/net/d;->o:Lcom/wanmei/sdk/core/net/d$a;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;S)V
    .locals 4

    const/16 v1, 0x2710

    const/4 v3, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "UTF-8"

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/d;->a:Ljava/lang/String;

    iput v1, p0, Lcom/wanmei/sdk/core/net/d;->b:I

    iput v1, p0, Lcom/wanmei/sdk/core/net/d;->c:I

    const-string v0, "application/x-www-form-urlencoded;charset=UTF-8"

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/d;->d:Ljava/lang/String;

    const-string v0, "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)"

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/d;->e:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/d;->f:Ljava/lang/String;

    sget-object v0, Lcom/wanmei/sdk/core/net/d;->o:Lcom/wanmei/sdk/core/net/d$a;

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/d;->n:Lcom/wanmei/sdk/core/net/d$a;

    iput-object p2, p0, Lcom/wanmei/sdk/core/net/d;->g:Ljava/lang/String;

    iput-short p3, p0, Lcom/wanmei/sdk/core/net/d;->h:S

    iput-object v3, p0, Lcom/wanmei/sdk/core/net/d;->i:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/sdk/core/net/e;->a(Landroid/content/Context;)Lcom/wanmei/sdk/core/net/e;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/e;->a()I

    move-result v1

    if-nez v1, :cond_2

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-gt v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/net/e;->b()Ljava/net/InetSocketAddress;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v1, Ljava/net/Proxy;

    sget-object v2, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    invoke-direct {v1, v2, v0}, Ljava/net/Proxy;-><init>(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V

    iput-object v1, p0, Lcom/wanmei/sdk/core/net/d;->l:Ljava/net/Proxy;

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-object v3, p0, Lcom/wanmei/sdk/core/net/d;->l:Ljava/net/Proxy;

    goto :goto_0

    :cond_2
    iput-object v3, p0, Lcom/wanmei/sdk/core/net/d;->l:Ljava/net/Proxy;

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->k:Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/d;->g:Ljava/lang/String;

    return-void
.end method

.method public a(Ljava/util/HashMap;)V
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

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/d;->j:Ljava/util/HashMap;

    return-void
.end method

.method public a(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/d;->m:Ljava/util/Map;

    return-void
.end method

.method public b()Ljava/util/HashMap;
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

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->j:Ljava/util/HashMap;

    return-object v0
.end method

.method public b(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/d;->f:Ljava/lang/String;

    return-void
.end method

.method public c()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->g:Ljava/lang/String;

    return-object v0
.end method

.method public d()S
    .locals 1

    iget-short v0, p0, Lcom/wanmei/sdk/core/net/d;->h:S

    return v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->i:Ljava/lang/String;

    return-object v0
.end method

.method public f()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/net/d;->b:I

    return v0
.end method

.method public g()I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/net/d;->c:I

    return v0
.end method

.method public h()Ljava/net/Proxy;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->l:Ljava/net/Proxy;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->f:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/util/Map;
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

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->m:Ljava/util/Map;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/net/d;->n:Lcom/wanmei/sdk/core/net/d$a;

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/d;->m:Ljava/util/Map;

    invoke-interface {v0, v1}, Lcom/wanmei/sdk/core/net/d$a;->a(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
