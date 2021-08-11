.class public final Lcom/wanmei/push/f/b;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/f/b$a;
    }
.end annotation


# instance fields
.field private a:I

.field private b:J


# direct methods
.method private constructor <init>(Lcom/wanmei/push/f/b$a;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/wanmei/push/f/b$a;->a(Lcom/wanmei/push/f/b$a;)I

    move-result v0

    iput v0, p0, Lcom/wanmei/push/f/b;->a:I

    invoke-static {p1}, Lcom/wanmei/push/f/b$a;->b(Lcom/wanmei/push/f/b$a;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wanmei/push/f/b;->b:J

    return-void
.end method

.method synthetic constructor <init>(Lcom/wanmei/push/f/b$a;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/wanmei/push/f/b;-><init>(Lcom/wanmei/push/f/b$a;)V

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    iget v0, p0, Lcom/wanmei/push/f/b;->a:I

    return v0
.end method

.method public final b()J
    .locals 2

    iget-wide v0, p0, Lcom/wanmei/push/f/b;->b:J

    return-wide v0
.end method
