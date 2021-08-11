.class public final Lcom/wanmei/push/f/a;
.super Ljava/lang/Object;


# instance fields
.field private a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wanmei/push/f/b;",
            ">;"
        }
    .end annotation
.end field

.field private b:I

.field private c:I

.field private d:J


# direct methods
.method private constructor <init>()V
    .locals 8

    const-wide/32 v6, 0x927c0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wanmei/push/f/a;->a:Ljava/util/Map;

    iput v2, p0, Lcom/wanmei/push/f/a;->b:I

    iput v2, p0, Lcom/wanmei/push/f/a;->c:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/wanmei/push/f/a;->d:J

    iget-object v0, p0, Lcom/wanmei/push/f/a;->a:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/f/b$a;

    invoke-direct {v2}, Lcom/wanmei/push/f/b$a;-><init>()V

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Lcom/wanmei/push/f/b$a;->a(I)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    const-wide/32 v4, 0xea60

    invoke-virtual {v2, v4, v5}, Lcom/wanmei/push/f/b$a;->a(J)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/f/b$a;->a()Lcom/wanmei/push/f/b;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/push/f/a;->a:Ljava/util/Map;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/f/b$a;

    invoke-direct {v2}, Lcom/wanmei/push/f/b$a;-><init>()V

    const/16 v3, 0x3c

    invoke-virtual {v2, v3}, Lcom/wanmei/push/f/b$a;->a(I)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    invoke-virtual {v2, v6, v7}, Lcom/wanmei/push/f/b$a;->a(J)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/f/b$a;->a()Lcom/wanmei/push/f/b;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/wanmei/push/f/a;->a:Ljava/util/Map;

    const/4 v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/wanmei/push/f/b$a;

    invoke-direct {v2}, Lcom/wanmei/push/f/b$a;-><init>()V

    const/16 v3, 0x1e

    invoke-virtual {v2, v3}, Lcom/wanmei/push/f/b$a;->a(I)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    invoke-virtual {v2, v6, v7}, Lcom/wanmei/push/f/b$a;->a(J)Lcom/wanmei/push/f/b$a;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wanmei/push/f/b$a;->a()Lcom/wanmei/push/f/b;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public static a()Lcom/wanmei/push/f/a;
    .locals 1

    new-instance v0, Lcom/wanmei/push/f/a;

    invoke-direct {v0}, Lcom/wanmei/push/f/a;-><init>()V

    return-object v0
.end method


# virtual methods
.method public final b()J
    .locals 6

    iget-object v0, p0, Lcom/wanmei/push/f/a;->a:Ljava/util/Map;

    iget v1, p0, Lcom/wanmei/push/f/a;->c:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/f/b;

    if-eqz v0, :cond_0

    iget v1, p0, Lcom/wanmei/push/f/a;->b:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/wanmei/push/f/a;->b:I

    invoke-virtual {v0}, Lcom/wanmei/push/f/b;->a()I

    move-result v2

    if-ge v1, v2, :cond_1

    invoke-virtual {v0}, Lcom/wanmei/push/f/b;->b()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wanmei/push/f/a;->d:J

    :cond_0
    :goto_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u91cd\u8bd5\u5f00\u59cb, \u5ef6\u8fdf\u65f6\u95f4"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Lcom/wanmei/push/f/a;->d:J

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\u79d2"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    iget-wide v0, p0, Lcom/wanmei/push/f/a;->d:J

    return-wide v0

    :cond_1
    iget v0, p0, Lcom/wanmei/push/f/a;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/wanmei/push/f/a;->c:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/wanmei/push/f/a;->b:I

    invoke-virtual {p0}, Lcom/wanmei/push/f/a;->b()J

    goto :goto_0
.end method
