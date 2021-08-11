.class public Lcom/wanmei/sdk/core/ui/floatview/b;
.super Ljava/lang/Object;


# instance fields
.field private a:Landroid/content/Context;

.field private b:I

.field private c:I

.field private volatile d:Z

.field private e:I

.field private f:Lcom/wanmei/sdk/core/ui/floatview/a;

.field private g:Landroid/view/View$OnTouchListener;

.field private h:Lcom/wanmei/sdk/core/ui/floatview/a/b;

.field private i:Landroid/os/Handler;

.field private volatile j:I

.field private volatile k:I

.field private l:F

.field private m:F


# direct methods
.method public constructor <init>(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->d:Z

    iput v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    iput v2, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->k:I

    iput v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->l:F

    iput v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->m:F

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/b$1;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/ui/floatview/b$1;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->g:Landroid/view/View$OnTouchListener;

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/b$2;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/ui/floatview/b$2;-><init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->i:Landroid/os/Handler;

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->a:Landroid/content/Context;

    iput p2, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->e:I

    const-string v0, "window"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v1

    iput v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->b:I

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->c:I

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/a;

    iget v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->e:I

    invoke-direct {v0, p1, v1, p3}, Lcom/wanmei/sdk/core/ui/floatview/a;-><init>(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->g:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/ui/floatview/a;->a(Landroid/view/View$OnTouchListener;)V

    invoke-static {p0}, Lcom/wanmei/sdk/core/ui/floatview/a/b;->a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a/b;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->h:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/ui/floatview/b;F)F
    .locals 0

    iput p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->l:F

    return p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/ui/floatview/b;I)I
    .locals 0

    iput p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    return p1
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    return-object v0
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/ui/floatview/b;)F
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->l:F

    return v0
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/ui/floatview/b;F)F
    .locals 0

    iput p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->m:F

    return p1
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/ui/floatview/b;I)I
    .locals 0

    iput p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->k:I

    return p1
.end method

.method static synthetic c(Lcom/wanmei/sdk/core/ui/floatview/b;)F
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->m:F

    return v0
.end method

.method static synthetic d(Lcom/wanmei/sdk/core/ui/floatview/b;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->d:Z

    return v0
.end method

.method static synthetic e(Lcom/wanmei/sdk/core/ui/floatview/b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    return v0
.end method

.method static synthetic f(Lcom/wanmei/sdk/core/ui/floatview/b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->k:I

    return v0
.end method

.method static synthetic g(Lcom/wanmei/sdk/core/ui/floatview/b;)Lcom/wanmei/sdk/core/ui/floatview/a/b;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->h:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    return-object v0
.end method

.method static synthetic h(Lcom/wanmei/sdk/core/ui/floatview/b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->b:I

    return v0
.end method

.method static synthetic i(Lcom/wanmei/sdk/core/ui/floatview/b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    add-int/lit8 v0, v0, -0x14

    iput v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    return v0
.end method

.method static synthetic j(Lcom/wanmei/sdk/core/ui/floatview/b;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->i:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic k(Lcom/wanmei/sdk/core/ui/floatview/b;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    add-int/lit8 v0, v0, 0x14

    iput v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->j:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->f()V

    return-void
.end method

.method public a(I)V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0, p1}, Lcom/wanmei/sdk/core/ui/floatview/a;->a(I)V

    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 2

    const-string v0, "window"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v1

    iput v1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->b:I

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->c:I

    return-void
.end method

.method public a(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->d:Z

    return-void
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->g()V

    return-void
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->h()V

    return-void
.end method

.method public d()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->a()V

    return-void
.end method

.method public e()V
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->f:Lcom/wanmei/sdk/core/ui/floatview/a;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/a;->b()V

    return-void
.end method

.method public f()Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->a:Landroid/content/Context;

    return-object v0
.end method

.method public g()Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->i:Landroid/os/Handler;

    return-object v0
.end method

.method public h()Lcom/wanmei/sdk/core/ui/floatview/a/b;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/b;->h:Lcom/wanmei/sdk/core/ui/floatview/a/b;

    return-object v0
.end method
