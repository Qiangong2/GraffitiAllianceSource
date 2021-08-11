.class public abstract Lcom/wanmei/sdk/core/ui/floatview/a/d;
.super Lcom/wanmei/sdk/core/ui/floatview/a/a;


# instance fields
.field protected a:Lcom/wanmei/sdk/core/ui/floatview/b;

.field protected b:Z


# direct methods
.method public constructor <init>(Lcom/wanmei/sdk/core/ui/floatview/b;)V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/ui/floatview/a/a;-><init>()V

    iput-object p1, p0, Lcom/wanmei/sdk/core/ui/floatview/a/d;->a:Lcom/wanmei/sdk/core/ui/floatview/b;

    return-void
.end method


# virtual methods
.method public c()V
    .locals 0

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/ui/floatview/a/d;->a()V

    return-void
.end method

.method public d()V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/d;->b:Z

    return-void
.end method

.method public e()V
    .locals 1

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/ui/floatview/a/d;->b()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wanmei/sdk/core/ui/floatview/a/d;->b:Z

    return-void
.end method
