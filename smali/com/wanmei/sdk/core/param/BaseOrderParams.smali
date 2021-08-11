.class public abstract Lcom/wanmei/sdk/core/param/BaseOrderParams;
.super Lcom/wanmei/sdk/core/param/BaseParams;


# static fields
.field public static final EXT:Ljava/lang/String; = "ext"

.field public static final ORDER_NUM:Ljava/lang/String; = "orderNum"

.field public static final PRICE:Ljava/lang/String; = "price"

.field public static final PRODUCT_DESC:Ljava/lang/String; = "productDesc"

.field public static final PRODUCT_NAME:Ljava/lang/String; = "productName"

.field public static final SERVER_ID:Ljava/lang/String; = "serverId"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field protected payParamHashMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/wanmei/sdk/core/param/BaseOrderParams;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 6

    const/4 v5, 0x1

    invoke-direct {p0}, Lcom/wanmei/sdk/core/param/BaseParams;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "orderNum"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "orderNum"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "price"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "price"

    const-string v4, "-1"

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverId"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "serverId"

    const-string v4, "-1"

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "productName"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productDesc"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "productDesc"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "ext"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "ext"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private addParams(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "necessary":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/wanmei/sdk/core/param/Param;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    iget-object v2, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    return-void

    :cond_1
    iget-object v2, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method protected addNecessaryParams()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method protected addOptionalParams()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getExt()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "ext"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOrderNum()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "orderNum"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getPayParams()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wanmei/sdk/core/param/Param;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->addNecessaryParams()Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->addParams(Ljava/util/ArrayList;)V

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->addOptionalParams()Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->addParams(Ljava/util/ArrayList;)V

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    return-object v0
.end method

.method public getPrice()I
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "price"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getIntValue()I

    move-result v0

    return v0
.end method

.method public getProductDesc()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productDesc"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getProductName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getServerId()I
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getIntValue()I

    move-result v0

    return v0
.end method

.method public setExt(Ljava/lang/String;)V
    .locals 2
    .param p1, "ext"    # Ljava/lang/String;

    .prologue
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "ext"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public setOrderNum(Ljava/lang/String;)V
    .locals 2
    .param p1, "orderNum"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "orderNum"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setPrice(I)V
    .locals 2
    .param p1, "price"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "price"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setProductDesc(Ljava/lang/String;)V
    .locals 2
    .param p1, "productDesc"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productDesc"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setProductName(Ljava/lang/String;)V
    .locals 2
    .param p1, "productName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setServerId(I)V
    .locals 2
    .param p1, "serverId"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "OrderParams{payParamHashMap="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->payParamHashMap:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public validate()V
    .locals 3

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getOrderNum()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/wanmei/sdk/core/param/PayParameterLackException;

    const-string v1, "lack param: orderNum"

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/param/PayParameterLackException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getPrice()I

    move-result v0

    if-gez v0, :cond_1

    new-instance v0, Lcom/wanmei/sdk/core/param/PayParameterLackException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "price is: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getPrice()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/param/PayParameterLackException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getServerId()I

    move-result v0

    if-gez v0, :cond_2

    new-instance v0, Lcom/wanmei/sdk/core/param/PayParameterLackException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "serverId is: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getServerId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/param/PayParameterLackException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getProductName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Lcom/wanmei/sdk/core/param/PayParameterLackException;

    const-string v1, "productName is empty"

    invoke-direct {v0, v1}, Lcom/wanmei/sdk/core/param/PayParameterLackException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getProductDesc()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->TAG:Ljava/lang/String;

    const-string v1, "productDesc is empty"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_4
    invoke-virtual {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;->getExt()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/wanmei/sdk/core/param/BaseOrderParams;->TAG:Ljava/lang/String;

    const-string v1, "ext is empty"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_5
    return-void
.end method
