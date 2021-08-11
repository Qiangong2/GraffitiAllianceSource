.class public final Lcom/wanmei/push/f/b$a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/f/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field private a:I

.field private b:J


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/push/f/b$a;)I
    .locals 1

    iget v0, p0, Lcom/wanmei/push/f/b$a;->a:I

    return v0
.end method

.method static synthetic b(Lcom/wanmei/push/f/b$a;)J
    .locals 2

    iget-wide v0, p0, Lcom/wanmei/push/f/b$a;->b:J

    return-wide v0
.end method


# virtual methods
.method public final a(I)Lcom/wanmei/push/f/b$a;
    .locals 0

    iput p1, p0, Lcom/wanmei/push/f/b$a;->a:I

    return-object p0
.end method

.method public final a(J)Lcom/wanmei/push/f/b$a;
    .locals 1

    iput-wide p1, p0, Lcom/wanmei/push/f/b$a;->b:J

    return-object p0
.end method

.method public final a()Lcom/wanmei/push/f/b;
    .locals 2

    new-instance v0, Lcom/wanmei/push/f/b;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/wanmei/push/f/b;-><init>(Lcom/wanmei/push/f/b$a;B)V

    return-object v0
.end method
