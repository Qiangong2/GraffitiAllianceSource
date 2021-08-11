.class public Lcom/wanmei/sdk/core/net/b;
.super Ljava/lang/Object;


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/wanmei/sdk/core/net/c;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/b;->a:Landroid/content/Context;

    new-instance v0, Lcom/wanmei/sdk/core/net/c;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/net/c;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/net/b;->b:Lcom/wanmei/sdk/core/net/c;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/util/HashMap;S)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;S)",
            "Ljava/lang/String;"
        }
    .end annotation

    new-instance v0, Lcom/wanmei/sdk/core/net/d;

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/b;->a:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p3}, Lcom/wanmei/sdk/core/net/d;-><init>(Landroid/content/Context;Ljava/lang/String;S)V

    invoke-virtual {v0, p2}, Lcom/wanmei/sdk/core/net/d;->a(Ljava/util/Map;)V

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    const-string v2, "appId"

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v3

    invoke-virtual {v3}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/net/d;->a(Ljava/util/HashMap;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/net/b;->b:Lcom/wanmei/sdk/core/net/c;

    invoke-virtual {v1, v0}, Lcom/wanmei/sdk/core/net/c;->a(Lcom/wanmei/sdk/core/net/d;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/util/Map;)Ljava/lang/String;
    .locals 3
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

    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    new-instance v1, Lcom/wanmei/sdk/core/net/b$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/net/b$1;-><init>(Lcom/wanmei/sdk/core/net/b;)V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_0
    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getAppKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/wanmei/sdk/core/util/g;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/wanmei/sdk/core/net/b;->a(Ljava/lang/String;Ljava/util/HashMap;S)Ljava/lang/String;

    return-void
.end method
