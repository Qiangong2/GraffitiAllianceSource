.class public Lcom/tencent/cos/xml/common/Range;
.super Ljava/lang/Object;
.source "Range.java"


# instance fields
.field private end:J

.field private start:J


# direct methods
.method public constructor <init>(J)V
    .locals 3
    .param p1, "start"    # J

    .prologue
    .line 24
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/tencent/cos/xml/common/Range;-><init>(JJ)V

    .line 25
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 1
    .param p1, "start"    # J
    .param p3, "end"    # J

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-wide p1, p0, Lcom/tencent/cos/xml/common/Range;->start:J

    .line 20
    iput-wide p3, p0, Lcom/tencent/cos/xml/common/Range;->end:J

    .line 21
    return-void
.end method


# virtual methods
.method public getEnd()J
    .locals 2

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/tencent/cos/xml/common/Range;->end:J

    return-wide v0
.end method

.method public getRange()Ljava/lang/String;
    .locals 8

    .prologue
    .line 36
    const-string v1, "bytes=%s-%s"

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    iget-wide v4, p0, Lcom/tencent/cos/xml/common/Range;->start:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v3, 0x1

    iget-wide v4, p0, Lcom/tencent/cos/xml/common/Range;->end:J

    const-wide/16 v6, -0x1

    cmp-long v0, v4, v6

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    iget-wide v4, p0, Lcom/tencent/cos/xml/common/Range;->end:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getStart()J
    .locals 2

    .prologue
    .line 32
    iget-wide v0, p0, Lcom/tencent/cos/xml/common/Range;->start:J

    return-wide v0
.end method
