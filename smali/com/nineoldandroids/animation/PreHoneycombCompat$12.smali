.class final Lcom/nineoldandroids/animation/PreHoneycombCompat$12;
.super Lcom/nineoldandroids/util/IntProperty;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/nineoldandroids/animation/PreHoneycombCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/nineoldandroids/util/IntProperty",
        "<",
        "Landroid/view/View;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    invoke-direct {p0, p1}, Lcom/nineoldandroids/util/IntProperty;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public get(Landroid/view/View;)Ljava/lang/Integer;
    .locals 1
    .param p1, "object"    # Landroid/view/View;

    .prologue
    invoke-static {p1}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nineoldandroids/view/a/a;->j()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    check-cast p1, Landroid/view/View;

    invoke-virtual {p0, p1}, Lcom/nineoldandroids/animation/PreHoneycombCompat$12;->get(Landroid/view/View;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public setValue(Landroid/view/View;I)V
    .locals 1
    .param p1, "object"    # Landroid/view/View;
    .param p2, "value"    # I

    .prologue
    invoke-static {p1}, Lcom/nineoldandroids/view/a/a;->a(Landroid/view/View;)Lcom/nineoldandroids/view/a/a;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/a/a;->b(I)V

    return-void
.end method

.method public bridge synthetic setValue(Ljava/lang/Object;I)V
    .locals 0

    .prologue
    check-cast p1, Landroid/view/View;

    invoke-virtual {p0, p1, p2}, Lcom/nineoldandroids/animation/PreHoneycombCompat$12;->setValue(Landroid/view/View;I)V

    return-void
.end method
