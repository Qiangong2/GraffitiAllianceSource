.class Lcom/tencent/qcloud/core/logger/Record;
.super Ljava/lang/Object;
.source "Record.java"


# instance fields
.field private level:Lcom/tencent/qcloud/core/logger/RecordLevel;

.field private msg:Ljava/lang/String;

.field private tag:Ljava/lang/String;

.field private threadId:J

.field private threadName:Ljava/lang/String;

.field private throwable:Ljava/lang/Throwable;

.field private timestamp:J


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/tencent/qcloud/core/logger/RecordLevel;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "level"    # Lcom/tencent/qcloud/core/logger/RecordLevel;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    const/4 v0, 0x0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->tag:Ljava/lang/String;

    .line 15
    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->msg:Ljava/lang/String;

    .line 16
    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->throwable:Ljava/lang/Throwable;

    .line 17
    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->level:Lcom/tencent/qcloud/core/logger/RecordLevel;

    .line 20
    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->threadName:Ljava/lang/String;

    .line 22
    iput-object p2, p0, Lcom/tencent/qcloud/core/logger/Record;->level:Lcom/tencent/qcloud/core/logger/RecordLevel;

    .line 23
    iput-object p1, p0, Lcom/tencent/qcloud/core/logger/Record;->tag:Ljava/lang/String;

    .line 24
    iput-object p3, p0, Lcom/tencent/qcloud/core/logger/Record;->msg:Ljava/lang/String;

    .line 25
    iput-object p4, p0, Lcom/tencent/qcloud/core/logger/Record;->throwable:Ljava/lang/Throwable;

    .line 27
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/tencent/qcloud/core/logger/Record;->timestamp:J

    .line 28
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/tencent/qcloud/core/logger/Record;->threadId:J

    .line 29
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->threadName:Ljava/lang/String;

    .line 30
    return-void
.end method

.method static timeUtils(JLjava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "seconds"    # J
    .param p2, "dateFormat"    # Ljava/lang/String;

    .prologue
    .line 48
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    .line 49
    .local v0, "dat":Ljava/util/Date;
    new-instance v2, Ljava/util/GregorianCalendar;

    invoke-direct {v2}, Ljava/util/GregorianCalendar;-><init>()V

    .line 50
    .local v2, "gc":Ljava/util/GregorianCalendar;
    invoke-virtual {v2, v0}, Ljava/util/GregorianCalendar;->setTime(Ljava/util/Date;)V

    .line 51
    new-instance v1, Ljava/text/SimpleDateFormat;

    sget-object v3, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-direct {v1, p2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 52
    .local v1, "format":Ljava/text/SimpleDateFormat;
    invoke-virtual {v2}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method


# virtual methods
.method public getLength()J
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->msg:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/Record;->msg:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    :goto_0
    add-int/lit8 v0, v0, 0x28

    int-to-long v0, v0

    return-wide v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 35
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/tencent/qcloud/core/logger/Record;->level:Lcom/tencent/qcloud/core/logger/RecordLevel;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    iget-wide v2, p0, Lcom/tencent/qcloud/core/logger/Record;->timestamp:J

    const-string v1, "yyyy-MM-dd HH:mm:ss"

    invoke-static {v2, v3, v1}, Lcom/tencent/qcloud/core/logger/Record;->timeUtils(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 37
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/Record;->threadName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/tencent/qcloud/core/logger/Record;->threadId:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 38
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/Record;->tag:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/Record;->msg:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 40
    iget-object v1, p0, Lcom/tencent/qcloud/core/logger/Record;->throwable:Ljava/lang/Throwable;

    if-eqz v1, :cond_0

    .line 41
    const-string v1, " * Exception :\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/qcloud/core/logger/Record;->throwable:Ljava/lang/Throwable;

    invoke-static {v2}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 43
    :cond_0
    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 44
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
