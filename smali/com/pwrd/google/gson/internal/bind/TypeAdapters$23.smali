.class Lcom/pwrd/google/gson/internal/bind/TypeAdapters$23;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "TypeAdapters.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/bind/TypeAdapters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<",
        "Ljava/util/Calendar;",
        ">;"
    }
.end annotation


# static fields
.field private static final DAY_OF_MONTH:Ljava/lang/String; = "dayOfMonth"

.field private static final HOUR_OF_DAY:Ljava/lang/String; = "hourOfDay"

.field private static final MINUTE:Ljava/lang/String; = "minute"

.field private static final MONTH:Ljava/lang/String; = "month"

.field private static final SECOND:Ljava/lang/String; = "second"

.field private static final YEAR:Ljava/lang/String; = "year"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 539
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public bridge synthetic read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$23;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/util/Calendar;

    move-result-object v0

    return-object v0
.end method

.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/util/Calendar;
    .locals 10
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 549
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v9, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v0, v9, :cond_0

    .line 550
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNull()V

    .line 551
    const/4 v0, 0x0

    .line 578
    :goto_0
    return-object v0

    .line 553
    :cond_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->beginObject()V

    .line 554
    const/4 v1, 0x0

    .line 555
    .local v1, "year":I
    const/4 v2, 0x0

    .line 556
    .local v2, "month":I
    const/4 v3, 0x0

    .line 557
    .local v3, "dayOfMonth":I
    const/4 v4, 0x0

    .line 558
    .local v4, "hourOfDay":I
    const/4 v5, 0x0

    .line 559
    .local v5, "minute":I
    const/4 v6, 0x0

    .line 560
    .local v6, "second":I
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v9, Lcom/pwrd/google/gson/stream/JsonToken;->END_OBJECT:Lcom/pwrd/google/gson/stream/JsonToken;

    if-ne v0, v9, :cond_2

    .line 577
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->endObject()V

    .line 578
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-direct/range {v0 .. v6}, Ljava/util/GregorianCalendar;-><init>(IIIIII)V

    goto :goto_0

    .line 561
    :cond_2
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextName()Ljava/lang/String;

    move-result-object v7

    .line 562
    .local v7, "name":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextInt()I

    move-result v8

    .line 563
    .local v8, "value":I
    const-string v0, "year"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 564
    move v1, v8

    .line 565
    goto :goto_1

    :cond_3
    const-string v0, "month"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 566
    move v2, v8

    .line 567
    goto :goto_1

    :cond_4
    const-string v0, "dayOfMonth"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 568
    move v3, v8

    .line 569
    goto :goto_1

    :cond_5
    const-string v0, "hourOfDay"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 570
    move v4, v8

    .line 571
    goto :goto_1

    :cond_6
    const-string v0, "minute"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 572
    move v5, v8

    .line 573
    goto :goto_1

    :cond_7
    const-string v0, "second"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 574
    move v6, v8

    goto :goto_1
.end method

.method public bridge synthetic write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1
    check-cast p2, Ljava/util/Calendar;

    invoke-virtual {p0, p1, p2}, Lcom/pwrd/google/gson/internal/bind/TypeAdapters$23;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/util/Calendar;)V

    return-void
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/util/Calendar;)V
    .locals 2
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .param p2, "value"    # Ljava/util/Calendar;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 583
    if-nez p2, :cond_0

    .line 584
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->nullValue()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 601
    :goto_0
    return-void

    .line 587
    :cond_0
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->beginObject()Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 588
    const-string v0, "year"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 589
    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 590
    const-string v0, "month"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 591
    const/4 v0, 0x2

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 592
    const-string v0, "dayOfMonth"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 593
    const/4 v0, 0x5

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 594
    const-string v0, "hourOfDay"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 595
    const/16 v0, 0xb

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 596
    const-string v0, "minute"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 597
    const/16 v0, 0xc

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 598
    const-string v0, "second"

    invoke-virtual {p1, v0}, Lcom/pwrd/google/gson/stream/JsonWriter;->name(Ljava/lang/String;)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 599
    const/16 v0, 0xd

    invoke-virtual {p2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/pwrd/google/gson/stream/JsonWriter;->value(J)Lcom/pwrd/google/gson/stream/JsonWriter;

    .line 600
    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonWriter;->endObject()Lcom/pwrd/google/gson/stream/JsonWriter;

    goto :goto_0
.end method