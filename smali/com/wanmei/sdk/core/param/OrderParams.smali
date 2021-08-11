.class public Lcom/wanmei/sdk/core/param/OrderParams;
.super Lcom/wanmei/sdk/core/param/BaseOrderParams;


# static fields
.field public static final APP_NAME:Ljava/lang/String; = "appName"

.field public static final BALANCE:Ljava/lang/String; = "balance"

.field public static final COMPANY:Ljava/lang/String; = "company"

.field public static final CURRENCY_NAME:Ljava/lang/String; = "currencyName"

.field public static final EXCHANGE_RATE:Ljava/lang/String; = "exchangeRate"

.field public static final LV:Ljava/lang/String; = "lv"

.field public static final PARTY_NAME:Ljava/lang/String; = "partyName"

.field public static final PRODUCT_COUNT:Ljava/lang/String; = "productCount"

.field public static final PRODUCT_ID:Ljava/lang/String; = "productId"

.field public static final ROLE_ID:Ljava/lang/String; = "roleId"

.field public static final ROLE_NAME:Ljava/lang/String; = "roleName"

.field public static final SERVER_NAME:Ljava/lang/String; = "serverName"

.field public static final VIP:Ljava/lang/String; = "vip"


# direct methods
.method public constructor <init>()V
    .locals 6

    const/4 v5, 0x1

    invoke-direct {p0}, Lcom/wanmei/sdk/core/param/BaseOrderParams;-><init>()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "exchangeRate"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "exchangeRate"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productId"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "productId"

    const-string v4, "-1"

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "appName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "appName"

    const-string v4, "-1"

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "roleName"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleId"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "roleId"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "lv"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "lv"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "serverName"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "balance"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "balance"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "vip"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "vip"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "partyName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "partyName"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "company"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "company"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "currencyName"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "currencyName"

    const-string v4, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productCount"

    new-instance v2, Lcom/wanmei/sdk/core/param/Param;

    const-string v3, "productCount"

    const-string v4, ""

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v5}, Lcom/wanmei/sdk/core/param/Param;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public addExtraParams(Ljava/util/HashMap;)Ljava/util/HashMap;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    return-object p1
.end method

.method public getAppName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "appName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBalance()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "balance"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCompany()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "company"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCurrencyName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "currencyName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExchangeRate()I
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "exchangeRate"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getIntValue()I

    move-result v0

    return v0
.end method

.method public getLv()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "lv"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPartyName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "partyName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getProductCount()I
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productCount"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getIntValue()I

    move-result v0

    return v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRoleId()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRoleName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getServerName()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVip()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "vip"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/param/Param;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setAppName(Ljava/lang/String;)V
    .locals 2
    .param p1, "appName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "appName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setBalance(Ljava/lang/String;)V
    .locals 2
    .param p1, "balance"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "balance"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setCompany(Ljava/lang/String;)V
    .locals 2
    .param p1, "company"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "company"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setCurrencyName(Ljava/lang/String;)V
    .locals 2
    .param p1, "currencyName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "currencyName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setExchangeRate(I)V
    .locals 2
    .param p1, "exchangeRate"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "exchangeRate"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setLv(Ljava/lang/String;)V
    .locals 2
    .param p1, "lv"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "lv"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setPartyName(Ljava/lang/String;)V
    .locals 2
    .param p1, "partyName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "partyName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setProductCount(I)V
    .locals 2
    .param p1, "productCount"    # I

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productCount"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 2
    .param p1, "productId"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "productId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setRoleId(Ljava/lang/String;)V
    .locals 2
    .param p1, "roleId"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleId"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setRoleName(Ljava/lang/String;)V
    .locals 2
    .param p1, "roleName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "roleName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setServerName(Ljava/lang/String;)V
    .locals 2
    .param p1, "serverName"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "serverName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method

.method public setVip(Ljava/lang/String;)V
    .locals 2
    .param p1, "vip"    # Ljava/lang/String;

    .prologue
    iget-object v0, p0, Lcom/wanmei/sdk/core/param/OrderParams;->payParamHashMap:Ljava/util/HashMap;

    const-string v1, "vip"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/sdk/core/param/Param;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/param/Param;->setValue(Ljava/lang/String;)V

    return-void
.end method
