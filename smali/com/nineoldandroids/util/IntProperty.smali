.class public abstract Lcom/nineoldandroids/util/IntProperty;
.super Lcom/nineoldandroids/util/Property;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/nineoldandroids/util/Property",
        "<TT;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/nineoldandroids/util/IntProperty;, "Lcom/nineoldandroids/util/IntProperty<TT;>;"
    const-class v0, Ljava/lang/Integer;

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/util/Property;-><init>(Ljava/lang/Class;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public final set(Ljava/lang/Object;Ljava/lang/Integer;)V
    .locals 1
    .param p2, "value"    # Ljava/lang/Integer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/lang/Integer;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/nineoldandroids/util/IntProperty;, "Lcom/nineoldandroids/util/IntProperty<TT;>;"
    .local p1, "object":Ljava/lang/Object;, "TT;"
    :goto_0
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    goto :goto_0
.end method

.method public bridge synthetic set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .local p0, "this":Lcom/nineoldandroids/util/IntProperty;, "Lcom/nineoldandroids/util/IntProperty<TT;>;"
    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2}, Lcom/nineoldandroids/util/IntProperty;->set(Ljava/lang/Object;Ljava/lang/Integer;)V

    return-void
.end method

.method public abstract setValue(Ljava/lang/Object;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)V"
        }
    .end annotation
.end method