.class public Lcom/wanmei/sdk/core/param/Param;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private name:Ljava/lang/String;

.field private notNull:Z

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "notNull"    # Z

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/param/Param;, "Lcom/wanmei/sdk/core/param/Param<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/param/Param;->name:Ljava/lang/String;

    iput-object p2, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/wanmei/sdk/core/param/Param;->notNull:Z

    return-void
.end method


# virtual methods
.method public getBooleanValue()Z
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public getDoubleValue()D
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public getFloatValue()F
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    return v0
.end method

.method public getIntValue()I
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getLongValue()J
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getShortValue()S
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Short;->valueOf(Ljava/lang/String;)Ljava/lang/Short;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Short;->shortValue()S

    move-result v0

    return v0
.end method

.method public getStringValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    return-object v0
.end method

.method public isNotNull()Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/param/Param;->notNull:Z

    return v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/param/Param;, "Lcom/wanmei/sdk/core/param/Param<TT;>;"
    iput-object p1, p0, Lcom/wanmei/sdk/core/param/Param;->name:Ljava/lang/String;

    return-void
.end method

.method public setNotNull(Z)V
    .locals 0
    .param p1, "notNull"    # Z

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/param/Param;, "Lcom/wanmei/sdk/core/param/Param<TT;>;"
    iput-boolean p1, p0, Lcom/wanmei/sdk/core/param/Param;->notNull:Z

    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/wanmei/sdk/core/param/Param;, "Lcom/wanmei/sdk/core/param/Param<TT;>;"
    iput-object p1, p0, Lcom/wanmei/sdk/core/param/Param;->value:Ljava/lang/String;

    return-void
.end method
