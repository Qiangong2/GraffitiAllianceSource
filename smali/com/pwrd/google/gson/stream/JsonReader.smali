.class public Lcom/pwrd/google/gson/stream/JsonReader;
.super Ljava/lang/Object;
.source "JsonReader.java"

# interfaces
.implements Ljava/io/Closeable;


# static fields
.field private static final MIN_INCOMPLETE_INTEGER:J = -0xcccccccccccccccL

.field private static final NON_EXECUTE_PREFIX:[C

.field private static final NUMBER_CHAR_DECIMAL:I = 0x3

.field private static final NUMBER_CHAR_DIGIT:I = 0x2

.field private static final NUMBER_CHAR_EXP_DIGIT:I = 0x7

.field private static final NUMBER_CHAR_EXP_E:I = 0x5

.field private static final NUMBER_CHAR_EXP_SIGN:I = 0x6

.field private static final NUMBER_CHAR_FRACTION_DIGIT:I = 0x4

.field private static final NUMBER_CHAR_NONE:I = 0x0

.field private static final NUMBER_CHAR_SIGN:I = 0x1

.field private static final PEEKED_BEGIN_ARRAY:I = 0x3

.field private static final PEEKED_BEGIN_OBJECT:I = 0x1

.field private static final PEEKED_BUFFERED:I = 0xb

.field private static final PEEKED_DOUBLE_QUOTED:I = 0x9

.field private static final PEEKED_DOUBLE_QUOTED_NAME:I = 0xd

.field private static final PEEKED_END_ARRAY:I = 0x4

.field private static final PEEKED_END_OBJECT:I = 0x2

.field private static final PEEKED_EOF:I = 0x11

.field private static final PEEKED_FALSE:I = 0x6

.field private static final PEEKED_LONG:I = 0xf

.field private static final PEEKED_NONE:I = 0x0

.field private static final PEEKED_NULL:I = 0x7

.field private static final PEEKED_NUMBER:I = 0x10

.field private static final PEEKED_SINGLE_QUOTED:I = 0x8

.field private static final PEEKED_SINGLE_QUOTED_NAME:I = 0xc

.field private static final PEEKED_TRUE:I = 0x5

.field private static final PEEKED_UNQUOTED:I = 0xa

.field private static final PEEKED_UNQUOTED_NAME:I = 0xe


# instance fields
.field private final buffer:[C

.field private final in:Ljava/io/Reader;

.field private lenient:Z

.field private limit:I

.field private lineNumber:I

.field private lineStart:I

.field private pathIndices:[I

.field private pathNames:[Ljava/lang/String;

.field private peeked:I

.field private peekedLong:J

.field private peekedNumberLength:I

.field private peekedString:Ljava/lang/String;

.field private pos:I

.field private stack:[I

.field private stackSize:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 193
    const-string v0, ")]}\'\n"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    sput-object v0, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    .line 1601
    new-instance v0, Lcom/pwrd/google/gson/stream/JsonReader$1;

    invoke-direct {v0}, Lcom/pwrd/google/gson/stream/JsonReader$1;-><init>()V

    sput-object v0, Lcom/pwrd/google/gson/internal/JsonReaderInternalAccess;->INSTANCE:Lcom/pwrd/google/gson/internal/JsonReaderInternalAccess;

    .line 1624
    return-void
.end method

.method public constructor <init>(Ljava/io/Reader;)V
    .locals 4
    .param p1, "in"    # Ljava/io/Reader;

    .prologue
    const/16 v3, 0x20

    const/4 v1, 0x0

    .line 290
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 231
    iput-boolean v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    .line 239
    const/16 v0, 0x400

    new-array v0, v0, [C

    iput-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 240
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 241
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 243
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 244
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    .line 246
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 270
    new-array v0, v3, [I

    iput-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    .line 271
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 273
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    const/4 v2, 0x6

    aput v2, v0, v1

    .line 284
    new-array v0, v3, [Ljava/lang/String;

    iput-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    .line 285
    new-array v0, v3, [I

    iput-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    .line 291
    if-nez p1, :cond_0

    .line 292
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "in == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 294
    :cond_0
    iput-object p1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->in:Ljava/io/Reader;

    .line 295
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/google/gson/stream/JsonReader;)I
    .locals 1

    .prologue
    .line 246
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    return v0
.end method

.method static synthetic access$1(Lcom/pwrd/google/gson/stream/JsonReader;)I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 466
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    return v0
.end method

.method static synthetic access$2(Lcom/pwrd/google/gson/stream/JsonReader;I)V
    .locals 0

    .prologue
    .line 246
    iput p1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    return-void
.end method

.method static synthetic access$3(Lcom/pwrd/google/gson/stream/JsonReader;)I
    .locals 1

    .prologue
    .line 1318
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v0

    return v0
.end method

.method static synthetic access$4(Lcom/pwrd/google/gson/stream/JsonReader;)I
    .locals 1

    .prologue
    .line 1322
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v0

    return v0
.end method

.method private checkLenient()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1423
    iget-boolean v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    if-nez v0, :cond_0

    .line 1424
    const-string v0, "Use JsonReader.setLenient(true) to accept malformed JSON"

    invoke-direct {p0, v0}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    .line 1426
    :cond_0
    return-void
.end method

.method private consumeNonExecutePrefix()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1583
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    .line 1584
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1586
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    sget-object v2, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    array-length v2, v2

    add-int/2addr v1, v2

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-le v1, v2, :cond_1

    sget-object v1, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    array-length v1, v1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1598
    :cond_0
    :goto_0
    return-void

    .line 1590
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 1597
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    sget-object v2, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    array-length v2, v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_0

    .line 1591
    :cond_2
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v2, v0

    aget-char v1, v1, v2

    sget-object v2, Lcom/pwrd/google/gson/stream/JsonReader;->NON_EXECUTE_PREFIX:[C

    aget-char v2, v2, v0

    if-ne v1, v2, :cond_0

    .line 1590
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private doPeek()I
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x7

    const/4 v8, 0x5

    const/4 v2, 0x4

    const/4 v3, 0x2

    const/4 v4, 0x1

    .line 467
    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v7, v7, -0x1

    aget v1, v6, v7

    .line 468
    .local v1, "peekStack":I
    if-ne v1, v4, :cond_3

    .line 469
    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v7, v7, -0x1

    aput v3, v6, v7

    .line 554
    :cond_0
    :goto_0
    :pswitch_0
    :sswitch_0
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 555
    .local v0, "c":I
    sparse-switch v0, :sswitch_data_0

    .line 584
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 587
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    if-ne v3, v4, :cond_1

    .line 588
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 591
    :cond_1
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peekKeyword()I

    move-result v2

    .line 592
    .local v2, "result":I
    if-eqz v2, :cond_14

    .line 606
    .end local v2    # "result":I
    :cond_2
    :goto_1
    return v2

    .line 470
    .end local v0    # "c":I
    :cond_3
    if-ne v1, v3, :cond_4

    .line 472
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 473
    .restart local v0    # "c":I
    sparse-switch v0, :sswitch_data_1

    .line 481
    const-string v3, "Unterminated array"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 475
    :sswitch_1
    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_1

    .line 477
    :sswitch_2
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    goto :goto_0

    .line 483
    .end local v0    # "c":I
    :cond_4
    const/4 v6, 0x3

    if-eq v1, v6, :cond_5

    if-ne v1, v8, :cond_9

    .line 484
    :cond_5
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aput v2, v5, v6

    .line 486
    if-ne v1, v8, :cond_6

    .line 487
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 488
    .restart local v0    # "c":I
    sparse-switch v0, :sswitch_data_2

    .line 496
    const-string v3, "Unterminated object"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 490
    :sswitch_3
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    move v2, v3

    goto :goto_1

    .line 492
    :sswitch_4
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 499
    .end local v0    # "c":I
    :cond_6
    :sswitch_5
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 500
    .restart local v0    # "c":I
    sparse-switch v0, :sswitch_data_3

    .line 513
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 514
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 515
    int-to-char v3, v0

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->isLiteral(C)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 516
    const/16 v2, 0xe

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_1

    .line 502
    :sswitch_6
    const/16 v2, 0xd

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_1

    .line 504
    :sswitch_7
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 505
    const/16 v2, 0xc

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_1

    .line 507
    :sswitch_8
    if-eq v1, v8, :cond_7

    .line 508
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    move v2, v3

    goto :goto_1

    .line 510
    :cond_7
    const-string v3, "Expected name"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 518
    :cond_8
    const-string v3, "Expected name"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 521
    .end local v0    # "c":I
    :cond_9
    if-ne v1, v2, :cond_b

    .line 522
    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v7, v7, -0x1

    aput v8, v6, v7

    .line 524
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 525
    .restart local v0    # "c":I
    packed-switch v0, :pswitch_data_0

    .line 535
    :pswitch_1
    const-string v3, "Expected \':\'"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 529
    :pswitch_2
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 530
    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v6, v7, :cond_a

    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v6

    if-eqz v6, :cond_0

    :cond_a
    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v6, v6, v7

    const/16 v7, 0x3e

    if-ne v6, v7, :cond_0

    .line 531
    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto/16 :goto_0

    .line 537
    .end local v0    # "c":I
    :cond_b
    const/4 v6, 0x6

    if-ne v1, v6, :cond_d

    .line 538
    iget-boolean v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    if-eqz v6, :cond_c

    .line 539
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->consumeNonExecutePrefix()V

    .line 541
    :cond_c
    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v7, v7, -0x1

    aput v5, v6, v7

    goto/16 :goto_0

    .line 542
    :cond_d
    if-ne v1, v5, :cond_f

    .line 543
    const/4 v6, 0x0

    invoke-direct {p0, v6}, Lcom/pwrd/google/gson/stream/JsonReader;->nextNonWhitespace(Z)I

    move-result v0

    .line 544
    .restart local v0    # "c":I
    const/4 v6, -0x1

    if-ne v0, v6, :cond_e

    .line 545
    const/16 v2, 0x11

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 547
    :cond_e
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 548
    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v6, v6, -0x1

    iput v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto/16 :goto_0

    .line 550
    .end local v0    # "c":I
    :cond_f
    const/16 v6, 0x8

    if-ne v1, v6, :cond_0

    .line 551
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "JsonReader is closed"

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 557
    .restart local v0    # "c":I
    :sswitch_9
    if-ne v1, v4, :cond_10

    .line 558
    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 564
    :cond_10
    :sswitch_a
    if-eq v1, v4, :cond_11

    if-ne v1, v3, :cond_12

    .line 565
    :cond_11
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 566
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 567
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    move v2, v5

    goto/16 :goto_1

    .line 569
    :cond_12
    const-string v3, "Unexpected value"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 572
    :sswitch_b
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 573
    const/16 v2, 0x8

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 575
    :sswitch_c
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    if-ne v3, v4, :cond_13

    .line 576
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 578
    :cond_13
    const/16 v2, 0x9

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 580
    :sswitch_d
    const/4 v2, 0x3

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 582
    :sswitch_e
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    move v2, v4

    goto/16 :goto_1

    .line 596
    .restart local v2    # "result":I
    :cond_14
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peekNumber()I

    move-result v2

    .line 597
    if-nez v2, :cond_2

    .line 601
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v3, v3, v4

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->isLiteral(C)Z

    move-result v3

    if-nez v3, :cond_15

    .line 602
    const-string v3, "Expected value"

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v3

    throw v3

    .line 605
    :cond_15
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 606
    const/16 v2, 0xa

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 555
    nop

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_c
        0x27 -> :sswitch_b
        0x2c -> :sswitch_a
        0x3b -> :sswitch_a
        0x5b -> :sswitch_d
        0x5d -> :sswitch_9
        0x7b -> :sswitch_e
    .end sparse-switch

    .line 473
    :sswitch_data_1
    .sparse-switch
        0x2c -> :sswitch_0
        0x3b -> :sswitch_2
        0x5d -> :sswitch_1
    .end sparse-switch

    .line 488
    :sswitch_data_2
    .sparse-switch
        0x2c -> :sswitch_5
        0x3b -> :sswitch_4
        0x7d -> :sswitch_3
    .end sparse-switch

    .line 500
    :sswitch_data_3
    .sparse-switch
        0x22 -> :sswitch_6
        0x27 -> :sswitch_7
        0x7d -> :sswitch_8
    .end sparse-switch

    .line 525
    :pswitch_data_0
    .packed-switch 0x3a
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private fillBuffer(I)Z
    .locals 7
    .param p1, "minimum"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1290
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 1291
    .local v0, "buffer":[C
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    sub-int/2addr v3, v4

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    .line 1292
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    if-eq v3, v4, :cond_1

    .line 1293
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    sub-int/2addr v3, v4

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1294
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    invoke-static {v0, v3, v0, v2, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1299
    :goto_0
    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1301
    :cond_0
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->in:Ljava/io/Reader;

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    array-length v5, v0

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    sub-int/2addr v5, v6

    invoke-virtual {v3, v0, v4, v5}, Ljava/io/Reader;->read([CII)I

    move-result v1

    .local v1, "total":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_2

    .line 1315
    :goto_1
    return v2

    .line 1296
    .end local v1    # "total":I
    :cond_1
    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    goto :goto_0

    .line 1302
    .restart local v1    # "total":I
    :cond_2
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    add-int/2addr v3, v1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1305
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    if-nez v3, :cond_3

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    if-nez v3, :cond_3

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lez v3, :cond_3

    aget-char v3, v0, v2

    const v4, 0xfeff

    if-ne v3, v4, :cond_3

    .line 1306
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1307
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    .line 1308
    add-int/lit8 p1, p1, 0x1

    .line 1311
    :cond_3
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v3, p1, :cond_0

    .line 1312
    const/4 v2, 0x1

    goto :goto_1
.end method

.method private getColumnNumber()I
    .locals 2

    .prologue
    .line 1323
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private getLineNumber()I
    .locals 1

    .prologue
    .line 1319
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private isLiteral(C)Z
    .locals 1
    .param p1, "c"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 757
    sparse-switch p1, :sswitch_data_0

    .line 777
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 763
    :sswitch_0
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 775
    :sswitch_1
    const/4 v0, 0x0

    goto :goto_0

    .line 757
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method private nextNonWhitespace(Z)I
    .locals 10
    .param p1, "throwOnEof"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1341
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 1342
    .local v0, "buffer":[C
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1343
    .local v4, "p":I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1345
    .local v3, "l":I
    :goto_0
    if-ne v4, v3, :cond_1

    .line 1346
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1347
    const/4 v7, 0x1

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v7

    if-nez v7, :cond_0

    .line 1414
    if-eqz p1, :cond_8

    .line 1415
    new-instance v7, Ljava/io/EOFException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "End of input at line "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1416
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " column "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 1415
    invoke-direct {v7, v8}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 1350
    :cond_0
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1351
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1354
    :cond_1
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "p":I
    .local v5, "p":I
    aget-char v1, v0, v4

    .line 1355
    .local v1, "c":I
    const/16 v7, 0xa

    if-ne v1, v7, :cond_2

    .line 1356
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1357
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    move v4, v5

    .line 1358
    .end local v5    # "p":I
    .restart local v4    # "p":I
    goto :goto_0

    .line 1359
    .end local v4    # "p":I
    .restart local v5    # "p":I
    :cond_2
    const/16 v7, 0x20

    if-eq v1, v7, :cond_9

    const/16 v7, 0xd

    if-eq v1, v7, :cond_9

    const/16 v7, 0x9

    if-ne v1, v7, :cond_3

    move v4, v5

    .line 1360
    .end local v5    # "p":I
    .restart local v4    # "p":I
    goto :goto_0

    .line 1363
    .end local v4    # "p":I
    .restart local v5    # "p":I
    :cond_3
    const/16 v7, 0x2f

    if-ne v1, v7, :cond_6

    .line 1364
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1365
    if-ne v5, v3, :cond_4

    .line 1366
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v7, v7, -0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1367
    const/4 v7, 0x2

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v2

    .line 1368
    .local v2, "charsLoaded":Z
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1369
    if-nez v2, :cond_4

    move v4, v5

    .line 1418
    .end local v1    # "c":I
    .end local v2    # "charsLoaded":Z
    .end local v5    # "p":I
    .restart local v4    # "p":I
    :goto_1
    return v1

    .line 1374
    .end local v4    # "p":I
    .restart local v1    # "c":I
    .restart local v5    # "p":I
    :cond_4
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 1375
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v6, v0, v7

    .line 1376
    .local v6, "peek":C
    sparse-switch v6, :sswitch_data_0

    move v4, v5

    .line 1396
    .end local v5    # "p":I
    .restart local v4    # "p":I
    goto :goto_1

    .line 1379
    .end local v4    # "p":I
    .restart local v5    # "p":I
    :sswitch_0
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1380
    const-string v7, "*/"

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->skipTo(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_5

    .line 1381
    const-string v7, "Unterminated comment"

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v7

    throw v7

    .line 1383
    :cond_5
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v4, v7, 0x2

    .line 1384
    .end local v5    # "p":I
    .restart local v4    # "p":I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1385
    goto/16 :goto_0

    .line 1389
    .end local v4    # "p":I
    .restart local v5    # "p":I
    :sswitch_1
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1390
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->skipToEndOfLine()V

    .line 1391
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1392
    .end local v5    # "p":I
    .restart local v4    # "p":I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1393
    goto/16 :goto_0

    .line 1398
    .end local v4    # "p":I
    .end local v6    # "peek":C
    .restart local v5    # "p":I
    :cond_6
    const/16 v7, 0x23

    if-ne v1, v7, :cond_7

    .line 1399
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1405
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 1406
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->skipToEndOfLine()V

    .line 1407
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1408
    .end local v5    # "p":I
    .restart local v4    # "p":I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1409
    goto/16 :goto_0

    .line 1410
    .end local v4    # "p":I
    .restart local v5    # "p":I
    :cond_7
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    move v4, v5

    .line 1411
    .end local v5    # "p":I
    .restart local v4    # "p":I
    goto :goto_1

    .line 1418
    .end local v1    # "c":I
    :cond_8
    const/4 v1, -0x1

    goto :goto_1

    .end local v4    # "p":I
    .restart local v1    # "c":I
    .restart local v5    # "p":I
    :cond_9
    move v4, v5

    .end local v5    # "p":I
    .restart local v4    # "p":I
    goto/16 :goto_0

    .line 1376
    :sswitch_data_0
    .sparse-switch
        0x2a -> :sswitch_0
        0x2f -> :sswitch_1
    .end sparse-switch
.end method

.method private nextQuotedValue(C)Ljava/lang/String;
    .locals 8
    .param p1, "quote"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1002
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 1003
    .local v0, "buffer":[C
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1005
    .local v1, "builder":Ljava/lang/StringBuilder;
    :cond_0
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1006
    .local v4, "p":I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1008
    .local v3, "l":I
    move v6, v4

    .local v6, "start":I
    move v5, v4

    .line 1009
    .end local v4    # "p":I
    .local v5, "p":I
    :goto_0
    if-lt v5, v3, :cond_1

    .line 1029
    sub-int v7, v5, v6

    invoke-virtual {v1, v0, v6, v7}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1030
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1031
    const/4 v7, 0x1

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v7

    if-nez v7, :cond_0

    .line 1032
    const-string v7, "Unterminated string"

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v7

    throw v7

    .line 1010
    :cond_1
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "p":I
    .restart local v4    # "p":I
    aget-char v2, v0, v5

    .line 1012
    .local v2, "c":I
    if-ne v2, p1, :cond_2

    .line 1013
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1014
    sub-int v7, v4, v6

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v1, v0, v6, v7}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1015
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7

    .line 1016
    :cond_2
    const/16 v7, 0x5c

    if-ne v2, v7, :cond_3

    .line 1017
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1018
    sub-int v7, v4, v6

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v1, v0, v6, v7}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1019
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->readEscapeCharacter()C

    move-result v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1020
    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1021
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 1022
    move v6, v4

    move v5, v4

    .line 1023
    .end local v4    # "p":I
    .restart local v5    # "p":I
    goto :goto_0

    .end local v5    # "p":I
    .restart local v4    # "p":I
    :cond_3
    const/16 v7, 0xa

    if-ne v2, v7, :cond_4

    .line 1024
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1025
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    :cond_4
    move v5, v4

    .end local v4    # "p":I
    .restart local v5    # "p":I
    goto :goto_0
.end method

.method private nextUnquotedValue()Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1042
    const/4 v0, 0x0

    .line 1043
    .local v0, "builder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 1047
    .local v1, "i":I
    :cond_0
    :goto_0
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v3, v1

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v3, v4, :cond_1

    .line 1071
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    array-length v3, v3

    if-ge v1, v3, :cond_2

    .line 1072
    add-int/lit8 v3, v1, 0x1

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1092
    :goto_1
    :sswitch_0
    if-nez v0, :cond_4

    .line 1093
    new-instance v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    invoke-direct {v2, v3, v4, v1}, Ljava/lang/String;-><init>([CII)V

    .line 1098
    .local v2, "result":Ljava/lang/String;
    :goto_2
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v3, v1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1099
    return-object v2

    .line 1048
    .end local v2    # "result":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v4, v1

    aget-char v3, v3, v4

    sparse-switch v3, :sswitch_data_0

    .line 1047
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1054
    :sswitch_1
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    goto :goto_1

    .line 1080
    :cond_2
    if-nez v0, :cond_3

    .line 1081
    new-instance v0, Ljava/lang/StringBuilder;

    .end local v0    # "builder":Ljava/lang/StringBuilder;
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1083
    .restart local v0    # "builder":Ljava/lang/StringBuilder;
    :cond_3
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    invoke-virtual {v0, v3, v4, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1084
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v3, v1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1085
    const/4 v1, 0x0

    .line 1086
    const/4 v3, 0x1

    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v3

    if-nez v3, :cond_0

    goto :goto_1

    .line 1095
    :cond_4
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    invoke-virtual {v0, v3, v4, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    .line 1096
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "result":Ljava/lang/String;
    goto :goto_2

    .line 1048
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_0
        0xa -> :sswitch_0
        0xc -> :sswitch_0
        0xd -> :sswitch_0
        0x20 -> :sswitch_0
        0x23 -> :sswitch_1
        0x2c -> :sswitch_0
        0x2f -> :sswitch_1
        0x3a -> :sswitch_0
        0x3b -> :sswitch_1
        0x3d -> :sswitch_1
        0x5b -> :sswitch_0
        0x5c -> :sswitch_1
        0x5d -> :sswitch_0
        0x7b -> :sswitch_0
        0x7d -> :sswitch_0
    .end sparse-switch
.end method

.method private peekKeyword()I
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 611
    iget-object v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v0, v7, v8

    .line 615
    .local v0, "c":C
    const/16 v7, 0x74

    if-eq v0, v7, :cond_0

    const/16 v7, 0x54

    if-ne v0, v7, :cond_2

    .line 616
    :cond_0
    const-string v2, "true"

    .line 617
    .local v2, "keyword":Ljava/lang/String;
    const-string v3, "TRUE"

    .line 618
    .local v3, "keywordUpper":Ljava/lang/String;
    const/4 v5, 0x5

    .line 632
    .local v5, "peeking":I
    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    .line 633
    .local v4, "length":I
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_1
    if-lt v1, v4, :cond_7

    .line 643
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v7, v4

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v7, v8, :cond_1

    add-int/lit8 v7, v4, 0x1

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 644
    :cond_1
    iget-object v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v8, v4

    aget-char v7, v7, v8

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->isLiteral(C)Z

    move-result v7

    if-eqz v7, :cond_a

    move v5, v6

    .line 650
    .end local v1    # "i":I
    .end local v2    # "keyword":Ljava/lang/String;
    .end local v3    # "keywordUpper":Ljava/lang/String;
    .end local v4    # "length":I
    .end local v5    # "peeking":I
    :goto_2
    return v5

    .line 619
    :cond_2
    const/16 v7, 0x66

    if-eq v0, v7, :cond_3

    const/16 v7, 0x46

    if-ne v0, v7, :cond_4

    .line 620
    :cond_3
    const-string v2, "false"

    .line 621
    .restart local v2    # "keyword":Ljava/lang/String;
    const-string v3, "FALSE"

    .line 622
    .restart local v3    # "keywordUpper":Ljava/lang/String;
    const/4 v5, 0x6

    .line 623
    .restart local v5    # "peeking":I
    goto :goto_0

    .end local v2    # "keyword":Ljava/lang/String;
    .end local v3    # "keywordUpper":Ljava/lang/String;
    .end local v5    # "peeking":I
    :cond_4
    const/16 v7, 0x6e

    if-eq v0, v7, :cond_5

    const/16 v7, 0x4e

    if-ne v0, v7, :cond_6

    .line 624
    :cond_5
    const-string v2, "null"

    .line 625
    .restart local v2    # "keyword":Ljava/lang/String;
    const-string v3, "NULL"

    .line 626
    .restart local v3    # "keywordUpper":Ljava/lang/String;
    const/4 v5, 0x7

    .line 627
    .restart local v5    # "peeking":I
    goto :goto_0

    .end local v2    # "keyword":Ljava/lang/String;
    .end local v3    # "keywordUpper":Ljava/lang/String;
    .end local v5    # "peeking":I
    :cond_6
    move v5, v6

    .line 628
    goto :goto_2

    .line 634
    .restart local v1    # "i":I
    .restart local v2    # "keyword":Ljava/lang/String;
    .restart local v3    # "keywordUpper":Ljava/lang/String;
    .restart local v4    # "length":I
    .restart local v5    # "peeking":I
    :cond_7
    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v7, v1

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v7, v8, :cond_8

    add-int/lit8 v7, v1, 0x1

    invoke-direct {p0, v7}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v7

    if-nez v7, :cond_8

    move v5, v6

    .line 635
    goto :goto_2

    .line 637
    :cond_8
    iget-object v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v8, v1

    aget-char v0, v7, v8

    .line 638
    invoke-virtual {v2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-eq v0, v7, :cond_9

    invoke-virtual {v3, v1}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-eq v0, v7, :cond_9

    move v5, v6

    .line 639
    goto :goto_2

    .line 633
    :cond_9
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 649
    :cond_a
    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v6, v4

    iput v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 650
    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_2
.end method

.method private peekNumber()I
    .locals 18
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 655
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 656
    .local v2, "buffer":[C
    move-object/from16 v0, p0

    iget v9, v0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 657
    .local v9, "p":I
    move-object/from16 v0, p0

    iget v6, v0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 659
    .local v6, "l":I
    const-wide/16 v12, 0x0

    .line 660
    .local v12, "value":J
    const/4 v8, 0x0

    .line 661
    .local v8, "negative":Z
    const/4 v4, 0x1

    .line 662
    .local v4, "fitsInLong":Z
    const/4 v7, 0x0

    .line 664
    .local v7, "last":I
    const/4 v5, 0x0

    .line 668
    .local v5, "i":I
    :goto_0
    add-int v14, v9, v5

    if-ne v14, v6, :cond_4

    .line 669
    array-length v14, v2

    if-ne v5, v14, :cond_0

    .line 672
    const/4 v14, 0x0

    .line 752
    .end local v12    # "value":J
    :goto_1
    return v14

    .line 674
    .restart local v12    # "value":J
    :cond_0
    add-int/lit8 v14, v5, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v14

    if-nez v14, :cond_3

    .line 743
    :cond_1
    const/4 v14, 0x2

    if-ne v7, v14, :cond_17

    if-eqz v4, :cond_17

    const-wide/high16 v14, -0x8000000000000000L

    cmp-long v14, v12, v14

    if-nez v14, :cond_2

    if-eqz v8, :cond_17

    .line 744
    :cond_2
    if-eqz v8, :cond_16

    .end local v12    # "value":J
    :goto_2
    move-object/from16 v0, p0

    iput-wide v12, v0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    .line 745
    move-object/from16 v0, p0

    iget v14, v0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v14, v5

    move-object/from16 v0, p0

    iput v14, v0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 746
    const/16 v14, 0xf

    move-object/from16 v0, p0

    iput v14, v0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto :goto_1

    .line 677
    .restart local v12    # "value":J
    :cond_3
    move-object/from16 v0, p0

    iget v9, v0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 678
    move-object/from16 v0, p0

    iget v6, v0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .line 681
    :cond_4
    add-int v14, v9, v5

    aget-char v3, v2, v14

    .line 682
    .local v3, "c":C
    sparse-switch v3, :sswitch_data_0

    .line 717
    const/16 v14, 0x30

    if-lt v3, v14, :cond_5

    const/16 v14, 0x39

    if-le v3, v14, :cond_d

    .line 718
    :cond_5
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->isLiteral(C)Z

    move-result v14

    if-eqz v14, :cond_1

    .line 721
    const/4 v14, 0x0

    goto :goto_1

    .line 684
    :sswitch_0
    if-nez v7, :cond_7

    .line 685
    const/4 v8, 0x1

    .line 686
    const/4 v7, 0x1

    .line 667
    :cond_6
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 688
    :cond_7
    const/4 v14, 0x5

    if-ne v7, v14, :cond_8

    .line 689
    const/4 v7, 0x6

    .line 690
    goto :goto_3

    .line 692
    :cond_8
    const/4 v14, 0x0

    goto :goto_1

    .line 695
    :sswitch_1
    const/4 v14, 0x5

    if-ne v7, v14, :cond_9

    .line 696
    const/4 v7, 0x6

    .line 697
    goto :goto_3

    .line 699
    :cond_9
    const/4 v14, 0x0

    goto :goto_1

    .line 703
    :sswitch_2
    const/4 v14, 0x2

    if-eq v7, v14, :cond_a

    const/4 v14, 0x4

    if-ne v7, v14, :cond_b

    .line 704
    :cond_a
    const/4 v7, 0x5

    .line 705
    goto :goto_3

    .line 707
    :cond_b
    const/4 v14, 0x0

    goto :goto_1

    .line 710
    :sswitch_3
    const/4 v14, 0x2

    if-ne v7, v14, :cond_c

    .line 711
    const/4 v7, 0x3

    .line 712
    goto :goto_3

    .line 714
    :cond_c
    const/4 v14, 0x0

    goto :goto_1

    .line 723
    :cond_d
    const/4 v14, 0x1

    if-eq v7, v14, :cond_e

    if-nez v7, :cond_f

    .line 724
    :cond_e
    add-int/lit8 v14, v3, -0x30

    neg-int v14, v14

    int-to-long v12, v14

    .line 725
    const/4 v7, 0x2

    .line 726
    goto :goto_3

    :cond_f
    const/4 v14, 0x2

    if-ne v7, v14, :cond_13

    .line 727
    const-wide/16 v14, 0x0

    cmp-long v14, v12, v14

    if-nez v14, :cond_10

    .line 728
    const/4 v14, 0x0

    goto/16 :goto_1

    .line 730
    :cond_10
    const-wide/16 v14, 0xa

    mul-long/2addr v14, v12

    add-int/lit8 v16, v3, -0x30

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    sub-long v10, v14, v16

    .line 731
    .local v10, "newValue":J
    const-wide v14, -0xcccccccccccccccL

    cmp-long v14, v12, v14

    if-gtz v14, :cond_12

    .line 732
    const-wide v14, -0xcccccccccccccccL

    cmp-long v14, v12, v14

    if-nez v14, :cond_11

    cmp-long v14, v10, v12

    if-ltz v14, :cond_12

    :cond_11
    const/4 v14, 0x0

    :goto_4
    and-int/2addr v4, v14

    .line 733
    move-wide v12, v10

    .line 734
    goto :goto_3

    .line 732
    :cond_12
    const/4 v14, 0x1

    goto :goto_4

    .line 734
    .end local v10    # "newValue":J
    :cond_13
    const/4 v14, 0x3

    if-ne v7, v14, :cond_14

    .line 735
    const/4 v7, 0x4

    .line 736
    goto :goto_3

    :cond_14
    const/4 v14, 0x5

    if-eq v7, v14, :cond_15

    const/4 v14, 0x6

    if-ne v7, v14, :cond_6

    .line 737
    :cond_15
    const/4 v7, 0x7

    goto :goto_3

    .line 744
    .end local v3    # "c":C
    :cond_16
    neg-long v12, v12

    goto/16 :goto_2

    .line 747
    :cond_17
    const/4 v14, 0x2

    if-eq v7, v14, :cond_18

    const/4 v14, 0x4

    if-eq v7, v14, :cond_18

    .line 748
    const/4 v14, 0x7

    if-ne v7, v14, :cond_19

    .line 749
    :cond_18
    move-object/from16 v0, p0

    iput v5, v0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    .line 750
    const/16 v14, 0x10

    move-object/from16 v0, p0

    iput v14, v0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    goto/16 :goto_1

    .line 752
    :cond_19
    const/4 v14, 0x0

    goto/16 :goto_1

    .line 682
    :sswitch_data_0
    .sparse-switch
        0x2b -> :sswitch_1
        0x2d -> :sswitch_0
        0x2e -> :sswitch_3
        0x45 -> :sswitch_2
        0x65 -> :sswitch_2
    .end sparse-switch
.end method

.method private push(I)V
    .locals 6
    .param p1, "newTop"    # I

    .prologue
    const/4 v5, 0x0

    .line 1270
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    iget-object v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    array-length v4, v4

    if-ne v3, v4, :cond_0

    .line 1271
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    mul-int/lit8 v3, v3, 0x2

    new-array v2, v3, [I

    .line 1272
    .local v2, "newStack":[I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    mul-int/lit8 v3, v3, 0x2

    new-array v0, v3, [I

    .line 1273
    .local v0, "newPathIndices":[I
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    mul-int/lit8 v3, v3, 0x2

    new-array v1, v3, [Ljava/lang/String;

    .line 1274
    .local v1, "newPathNames":[Ljava/lang/String;
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    invoke-static {v3, v5, v2, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1275
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    invoke-static {v3, v5, v0, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1276
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    invoke-static {v3, v5, v1, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1277
    iput-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    .line 1278
    iput-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    .line 1279
    iput-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    .line 1281
    .end local v0    # "newPathIndices":[I
    .end local v1    # "newPathNames":[Ljava/lang/String;
    .end local v2    # "newStack":[I
    :cond_0
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    aput p1, v3, v4

    .line 1282
    return-void
.end method

.method private readEscapeCharacter()C
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x4

    .line 1513
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-ne v5, v6, :cond_0

    const/4 v5, 0x1

    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v5

    if-nez v5, :cond_0

    .line 1514
    const-string v5, "Unterminated escape sequence"

    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v5

    throw v5

    .line 1517
    :cond_0
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v7, v6, 0x1

    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v2, v5, v6

    .line 1518
    .local v2, "escaped":C
    sparse-switch v2, :sswitch_data_0

    :goto_0
    move v4, v2

    .line 1565
    :goto_1
    return v4

    .line 1520
    :sswitch_0
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v5, v5, 0x4

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-le v5, v6, :cond_1

    invoke-direct {p0, v10}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1521
    const-string v5, "Unterminated escape sequence"

    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v5

    throw v5

    .line 1524
    :cond_1
    const/4 v4, 0x0

    .line 1525
    .local v4, "result":C
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .local v3, "i":I
    add-int/lit8 v1, v3, 0x4

    .local v1, "end":I
    :goto_2
    if-lt v3, v1, :cond_2

    .line 1538
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v5, v5, 0x4

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_1

    .line 1526
    :cond_2
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    aget-char v0, v5, v3

    .line 1527
    .local v0, "c":C
    shl-int/lit8 v5, v4, 0x4

    int-to-char v4, v5

    .line 1528
    const/16 v5, 0x30

    if-lt v0, v5, :cond_3

    const/16 v5, 0x39

    if-gt v0, v5, :cond_3

    .line 1529
    add-int/lit8 v5, v0, -0x30

    add-int/2addr v5, v4

    int-to-char v4, v5

    .line 1525
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 1530
    :cond_3
    const/16 v5, 0x61

    if-lt v0, v5, :cond_4

    const/16 v5, 0x66

    if-gt v0, v5, :cond_4

    .line 1531
    add-int/lit8 v5, v0, -0x61

    add-int/lit8 v5, v5, 0xa

    add-int/2addr v5, v4

    int-to-char v4, v5

    .line 1532
    goto :goto_3

    :cond_4
    const/16 v5, 0x41

    if-lt v0, v5, :cond_5

    const/16 v5, 0x46

    if-gt v0, v5, :cond_5

    .line 1533
    add-int/lit8 v5, v0, -0x41

    add-int/lit8 v5, v5, 0xa

    add-int/2addr v5, v4

    int-to-char v4, v5

    .line 1534
    goto :goto_3

    .line 1535
    :cond_5
    new-instance v5, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "\\u"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v7, Ljava/lang/String;

    iget-object v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v9, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    invoke-direct {v7, v8, v9, v10}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 1542
    .end local v0    # "c":C
    .end local v1    # "end":I
    .end local v3    # "i":I
    .end local v4    # "result":C
    :sswitch_1
    const/16 v4, 0x9

    goto :goto_1

    .line 1545
    :sswitch_2
    const/16 v4, 0x8

    goto :goto_1

    .line 1548
    :sswitch_3
    const/16 v4, 0xa

    goto :goto_1

    .line 1551
    :sswitch_4
    const/16 v4, 0xd

    goto/16 :goto_1

    .line 1554
    :sswitch_5
    const/16 v4, 0xc

    goto/16 :goto_1

    .line 1557
    :sswitch_6
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1558
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    goto/16 :goto_0

    .line 1518
    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_6
        0x62 -> :sswitch_2
        0x66 -> :sswitch_5
        0x6e -> :sswitch_3
        0x72 -> :sswitch_4
        0x74 -> :sswitch_1
        0x75 -> :sswitch_0
    .end sparse-switch
.end method

.method private skipQuotedValue(C)V
    .locals 6
    .param p1, "quote"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1104
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    .line 1106
    .local v0, "buffer":[C
    :cond_0
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1107
    .local v3, "p":I
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    .local v2, "l":I
    move v4, v3

    .line 1109
    .end local v3    # "p":I
    .local v4, "p":I
    :goto_0
    if-lt v4, v2, :cond_1

    .line 1124
    iput v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1125
    const/4 v5, 0x1

    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v5

    if-nez v5, :cond_0

    .line 1126
    const-string v5, "Unterminated string"

    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->syntaxError(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v5

    throw v5

    .line 1110
    :cond_1
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "p":I
    .restart local v3    # "p":I
    aget-char v1, v0, v4

    .line 1111
    .local v1, "c":I
    if-ne v1, p1, :cond_2

    .line 1112
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1113
    return-void

    .line 1114
    :cond_2
    const/16 v5, 0x5c

    if-ne v1, v5, :cond_3

    .line 1115
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1116
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->readEscapeCharacter()C

    .line 1117
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1118
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    move v4, v3

    .line 1119
    .end local v3    # "p":I
    .restart local v4    # "p":I
    goto :goto_0

    .end local v4    # "p":I
    .restart local v3    # "p":I
    :cond_3
    const/16 v5, 0xa

    if-ne v1, v5, :cond_4

    .line 1120
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1121
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    :cond_4
    move v4, v3

    .end local v3    # "p":I
    .restart local v4    # "p":I
    goto :goto_0
.end method

.method private skipTo(Ljava/lang/String;)Z
    .locals 3
    .param p1, "toFind"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1451
    :goto_0
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-le v1, v2, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1464
    const/4 v1, 0x0

    :goto_1
    return v1

    .line 1452
    :cond_0
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v1, v1, v2

    const/16 v2, 0xa

    if-ne v1, v2, :cond_2

    .line 1453
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1454
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    .line 1451
    :cond_1
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_0

    .line 1457
    :cond_2
    const/4 v0, 0x0

    .local v0, "c":I
    :goto_2
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lt v0, v1, :cond_3

    .line 1462
    const/4 v1, 0x1

    goto :goto_1

    .line 1458
    :cond_3
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v2, v0

    aget-char v1, v1, v2

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-ne v1, v2, :cond_1

    .line 1457
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method private skipToEndOfLine()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1434
    :cond_0
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v1, v2, :cond_1

    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1444
    :goto_0
    return-void

    .line 1435
    :cond_1
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    aget-char v0, v1, v2

    .line 1436
    .local v0, "c":C
    const/16 v1, 0xa

    if-ne v0, v1, :cond_2

    .line 1437
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineNumber:I

    .line 1438
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lineStart:I

    goto :goto_0

    .line 1440
    :cond_2
    const/16 v1, 0xd

    if-ne v0, v1, :cond_0

    goto :goto_0
.end method

.method private skipUnquotedValue()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1131
    :cond_0
    const/4 v0, 0x0

    .line 1132
    .local v0, "i":I
    :goto_0
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->limit:I

    if-lt v1, v2, :cond_1

    .line 1155
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1156
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->fillBuffer(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1157
    :goto_1
    return-void

    .line 1133
    :cond_1
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v2, v0

    aget-char v1, v1, v2

    sparse-switch v1, :sswitch_data_0

    .line 1132
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1139
    :sswitch_0
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->checkLenient()V

    .line 1151
    :sswitch_1
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_1

    .line 1133
    nop

    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method private syntaxError(Ljava/lang/String;)Ljava/io/IOException;
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1574
    new-instance v0, Lcom/pwrd/google/gson/stream/MalformedJsonException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1575
    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " path "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1574
    invoke-direct {v0, v1}, Lcom/pwrd/google/gson/stream/MalformedJsonException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public beginArray()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 342
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 343
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 344
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 346
    :cond_0
    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 347
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->push(I)V

    .line 348
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    aput v3, v1, v2

    .line 349
    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 354
    return-void

    .line 351
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected BEGIN_ARRAY but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 352
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 351
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public beginObject()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 380
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 381
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 382
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 384
    :cond_0
    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 385
    const/4 v1, 0x3

    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->push(I)V

    .line 386
    const/4 v1, 0x0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 391
    return-void

    .line 388
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected BEGIN_OBJECT but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 389
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 388
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1222
    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1223
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    const/16 v1, 0x8

    aput v1, v0, v2

    .line 1224
    const/4 v0, 0x1

    iput v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 1225
    iget-object v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->in:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->close()V

    .line 1226
    return-void
.end method

.method public endArray()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 361
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 362
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 363
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 365
    :cond_0
    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 366
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 367
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    aget v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    aput v3, v1, v2

    .line 368
    const/4 v1, 0x0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 373
    return-void

    .line 370
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected END_ARRAY but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 371
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 370
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public endObject()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 398
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 399
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 400
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 402
    :cond_0
    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 403
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 404
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 405
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    aget v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    aput v3, v1, v2

    .line 406
    const/4 v1, 0x0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 411
    return-void

    .line 408
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected END_OBJECT but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 409
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 408
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getPath()Ljava/lang/String;
    .locals 5

    .prologue
    .line 1477
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v4, 0x24

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 1478
    .local v1, "result":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .local v2, "size":I
    :goto_0
    if-lt v0, v2, :cond_0

    .line 1500
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 1479
    :cond_0
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stack:[I

    aget v3, v3, v0

    packed-switch v3, :pswitch_data_0

    .line 1478
    :cond_1
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1482
    :pswitch_0
    const/16 v3, 0x5b

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    aget v4, v4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x5d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 1488
    :pswitch_1
    const/16 v3, 0x2e

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1489
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    aget-object v3, v3, v0

    if-eqz v3, :cond_1

    .line 1490
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 1479
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public hasNext()Z
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 417
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 418
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 419
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 421
    :cond_0
    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    const/4 v1, 0x4

    if-eq v0, v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public final isLenient()Z
    .locals 1

    .prologue
    .line 334
    iget-boolean v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    return v0
.end method

.method public nextBoolean()Z
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 854
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 855
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 856
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 858
    :cond_0
    const/4 v2, 0x5

    if-ne v0, v2, :cond_1

    .line 859
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 860
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    aget v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    aput v3, v1, v2

    .line 861
    const/4 v1, 0x1

    .line 865
    :goto_0
    return v1

    .line 862
    :cond_1
    const/4 v2, 0x6

    if-ne v0, v2, :cond_2

    .line 863
    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 864
    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v3, v3, -0x1

    aget v4, v2, v3

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v3

    goto :goto_0

    .line 867
    :cond_2
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected a boolean but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 868
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 867
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public nextDouble()D
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v8, 0xb

    const/16 v4, 0x8

    const/4 v7, 0x0

    .line 902
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 903
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 904
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 907
    :cond_0
    const/16 v1, 0xf

    if-ne v0, v1, :cond_1

    .line 908
    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 909
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v4, v4, -0x1

    aget v5, v1, v4

    add-int/lit8 v5, v5, 0x1

    aput v5, v1, v4

    .line 910
    iget-wide v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    long-to-double v2, v4

    .line 934
    :goto_0
    return-wide v2

    .line 913
    :cond_1
    const/16 v1, 0x10

    if-ne v0, v1, :cond_4

    .line 914
    new-instance v1, Ljava/lang/String;

    iget-object v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    invoke-direct {v1, v4, v5, v6}, Ljava/lang/String;-><init>([CII)V

    iput-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 915
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    add-int/2addr v1, v4

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 925
    :cond_2
    :goto_1
    iput v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 926
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    .line 927
    .local v2, "result":D
    iget-boolean v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    if-nez v1, :cond_9

    invoke-static {v2, v3}, Ljava/lang/Double;->isNaN(D)Z

    move-result v1

    if-nez v1, :cond_3

    invoke-static {v2, v3}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 928
    :cond_3
    new-instance v1, Lcom/pwrd/google/gson/stream/MalformedJsonException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "JSON forbids NaN and infinities: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 929
    const-string v5, " at line "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " column "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " path "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 928
    invoke-direct {v1, v4}, Lcom/pwrd/google/gson/stream/MalformedJsonException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 916
    .end local v2    # "result":D
    :cond_4
    if-eq v0, v4, :cond_5

    const/16 v1, 0x9

    if-ne v0, v1, :cond_7

    .line 917
    :cond_5
    if-ne v0, v4, :cond_6

    const/16 v1, 0x27

    :goto_2
    invoke-direct {p0, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    goto :goto_1

    :cond_6
    const/16 v1, 0x22

    goto :goto_2

    .line 918
    :cond_7
    const/16 v1, 0xa

    if-ne v0, v1, :cond_8

    .line 919
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->nextUnquotedValue()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    goto :goto_1

    .line 920
    :cond_8
    if-eq v0, v8, :cond_2

    .line 921
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Expected a double but was "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 922
    const-string v5, " at line "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " column "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " path "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 921
    invoke-direct {v1, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 931
    .restart local v2    # "result":D
    :cond_9
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 932
    iput v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 933
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v4, v4, -0x1

    aget v5, v1, v4

    add-int/lit8 v5, v5, 0x1

    aput v5, v1, v4

    goto/16 :goto_0
.end method

.method public nextInt()I
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x8

    const/4 v10, 0x0

    .line 1170
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1171
    .local v2, "p":I
    if-nez v2, :cond_0

    .line 1172
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v2

    .line 1176
    :cond_0
    const/16 v5, 0xf

    if-ne v2, v5, :cond_2

    .line 1177
    iget-wide v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    long-to-int v3, v6

    .line 1178
    .local v3, "result":I
    iget-wide v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    int-to-long v8, v3

    cmp-long v5, v6, v8

    if-eqz v5, :cond_1

    .line 1179
    new-instance v5, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Expected an int but was "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 1180
    const-string v7, " at line "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " column "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " path "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1179
    invoke-direct {v5, v6}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 1182
    :cond_1
    iput v10, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1183
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v5, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v5, v6

    move v4, v3

    .line 1215
    .end local v3    # "result":I
    .local v4, "result":I
    :goto_0
    return v4

    .line 1187
    .end local v4    # "result":I
    :cond_2
    const/16 v5, 0x10

    if-ne v2, v5, :cond_3

    .line 1188
    new-instance v5, Ljava/lang/String;

    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    invoke-direct {v5, v6, v7, v8}, Ljava/lang/String;-><init>([CII)V

    iput-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 1189
    iget v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    add-int/2addr v5, v6

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 1205
    :goto_1
    const/16 v5, 0xb

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1206
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 1207
    .local v0, "asDouble":D
    double-to-int v3, v0

    .line 1208
    .restart local v3    # "result":I
    int-to-double v6, v3

    cmpl-double v5, v6, v0

    if-eqz v5, :cond_7

    .line 1209
    new-instance v5, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Expected an int but was "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 1210
    const-string v7, " at line "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " column "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " path "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1209
    invoke-direct {v5, v6}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 1190
    .end local v0    # "asDouble":D
    .end local v3    # "result":I
    :cond_3
    if-eq v2, v6, :cond_4

    const/16 v5, 0x9

    if-ne v2, v5, :cond_6

    .line 1191
    :cond_4
    if-ne v2, v6, :cond_5

    const/16 v5, 0x27

    :goto_2
    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 1193
    :try_start_0
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 1194
    .restart local v3    # "result":I
    const/4 v5, 0x0

    iput v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1195
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v5, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v5, v6
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move v4, v3

    .line 1196
    .end local v3    # "result":I
    .restart local v4    # "result":I
    goto/16 :goto_0

    .line 1191
    .end local v4    # "result":I
    :cond_5
    const/16 v5, 0x22

    goto :goto_2

    .line 1201
    :cond_6
    new-instance v5, Ljava/lang/IllegalStateException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Expected an int but was "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 1202
    const-string v7, " at line "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " column "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " path "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1201
    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 1212
    .restart local v0    # "asDouble":D
    .restart local v3    # "result":I
    :cond_7
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 1213
    iput v10, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1214
    iget-object v5, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v5, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v5, v6

    move v4, v3

    .line 1215
    .end local v3    # "result":I
    .restart local v4    # "result":I
    goto/16 :goto_0

    .line 1197
    .end local v0    # "asDouble":D
    .end local v4    # "result":I
    :catch_0
    move-exception v5

    goto/16 :goto_1
.end method

.method public nextLong()J
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x8

    const/4 v9, 0x0

    .line 948
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 949
    .local v2, "p":I
    if-nez v2, :cond_0

    .line 950
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v2

    .line 953
    :cond_0
    const/16 v3, 0xf

    if-ne v2, v3, :cond_1

    .line 954
    iput v9, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 955
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v3, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v3, v6

    .line 956
    iget-wide v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    .line 987
    :goto_0
    return-wide v4

    .line 959
    :cond_1
    const/16 v3, 0x10

    if-ne v2, v3, :cond_2

    .line 960
    new-instance v3, Ljava/lang/String;

    iget-object v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v8, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    invoke-direct {v3, v6, v7, v8}, Ljava/lang/String;-><init>([CII)V

    iput-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 961
    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    add-int/2addr v3, v6

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    .line 977
    :goto_1
    const/16 v3, 0xb

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 978
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 979
    .local v0, "asDouble":D
    double-to-long v4, v0

    .line 980
    .local v4, "result":J
    long-to-double v6, v4

    cmpl-double v3, v6, v0

    if-eqz v3, :cond_6

    .line 981
    new-instance v3, Ljava/lang/NumberFormatException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Expected a long but was "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 982
    const-string v7, " at line "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " column "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " path "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 981
    invoke-direct {v3, v6}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 962
    .end local v0    # "asDouble":D
    .end local v4    # "result":J
    :cond_2
    if-eq v2, v6, :cond_3

    const/16 v3, 0x9

    if-ne v2, v3, :cond_5

    .line 963
    :cond_3
    if-ne v2, v6, :cond_4

    const/16 v3, 0x27

    :goto_2
    invoke-direct {p0, v3}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 965
    :try_start_0
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 966
    .restart local v4    # "result":J
    const/4 v3, 0x0

    iput v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 967
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v3, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v3, v6
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 969
    .end local v4    # "result":J
    :catch_0
    move-exception v3

    goto :goto_1

    .line 963
    :cond_4
    const/16 v3, 0x22

    goto :goto_2

    .line 973
    :cond_5
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Expected a long but was "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 974
    const-string v7, " at line "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " column "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " path "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 973
    invoke-direct {v3, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 984
    .restart local v0    # "asDouble":D
    .restart local v4    # "result":J
    :cond_6
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 985
    iput v9, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 986
    iget-object v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v6, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v6, v6, -0x1

    aget v7, v3, v6

    add-int/lit8 v7, v7, 0x1

    aput v7, v3, v6

    goto/16 :goto_0
.end method

.method public nextName()Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 789
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 790
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 791
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 794
    :cond_0
    const/16 v2, 0xe

    if-ne v0, v2, :cond_1

    .line 795
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->nextUnquotedValue()Ljava/lang/String;

    move-result-object v1

    .line 804
    .local v1, "result":Ljava/lang/String;
    :goto_0
    const/4 v2, 0x0

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 805
    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v3, v3, -0x1

    aput-object v1, v2, v3

    .line 806
    return-object v1

    .line 796
    .end local v1    # "result":Ljava/lang/String;
    :cond_1
    const/16 v2, 0xc

    if-ne v0, v2, :cond_2

    .line 797
    const/16 v2, 0x27

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v1

    .line 798
    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0

    .end local v1    # "result":Ljava/lang/String;
    :cond_2
    const/16 v2, 0xd

    if-ne v0, v2, :cond_3

    .line 799
    const/16 v2, 0x22

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v1

    .line 800
    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0

    .line 801
    .end local v1    # "result":Ljava/lang/String;
    :cond_3
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Expected a name but was "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 802
    const-string v4, " at line "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " column "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " path "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 801
    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public nextNull()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 879
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 880
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 881
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 883
    :cond_0
    const/4 v1, 0x7

    if-ne v0, v1, :cond_1

    .line 884
    const/4 v1, 0x0

    iput v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 885
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    aget v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    aput v3, v1, v2

    .line 890
    return-void

    .line 887
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected null but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 888
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 887
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public nextString()Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 818
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 819
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 820
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 823
    :cond_0
    const/16 v2, 0xa

    if-ne v0, v2, :cond_1

    .line 824
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->nextUnquotedValue()Ljava/lang/String;

    move-result-object v1

    .line 841
    .local v1, "result":Ljava/lang/String;
    :goto_0
    const/4 v2, 0x0

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 842
    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v3, v3, -0x1

    aget v4, v2, v3

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v3

    .line 843
    return-object v1

    .line 825
    .end local v1    # "result":Ljava/lang/String;
    :cond_1
    const/16 v2, 0x8

    if-ne v0, v2, :cond_2

    .line 826
    const/16 v2, 0x27

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v1

    .line 827
    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0

    .end local v1    # "result":Ljava/lang/String;
    :cond_2
    const/16 v2, 0x9

    if-ne v0, v2, :cond_3

    .line 828
    const/16 v2, 0x22

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->nextQuotedValue(C)Ljava/lang/String;

    move-result-object v1

    .line 829
    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0

    .end local v1    # "result":Ljava/lang/String;
    :cond_3
    const/16 v2, 0xb

    if-ne v0, v2, :cond_4

    .line 830
    iget-object v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    .line 831
    .restart local v1    # "result":Ljava/lang/String;
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedString:Ljava/lang/String;

    goto :goto_0

    .line 832
    .end local v1    # "result":Ljava/lang/String;
    :cond_4
    const/16 v2, 0xf

    if-ne v0, v2, :cond_5

    .line 833
    iget-wide v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedLong:J

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    .line 834
    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0

    .end local v1    # "result":Ljava/lang/String;
    :cond_5
    const/16 v2, 0x10

    if-ne v0, v2, :cond_6

    .line 835
    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->buffer:[C

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v4, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    invoke-direct {v1, v2, v3, v4}, Ljava/lang/String;-><init>([CII)V

    .line 836
    .restart local v1    # "result":Ljava/lang/String;
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_0

    .line 838
    .end local v1    # "result":Ljava/lang/String;
    :cond_6
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Expected a string but was "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 839
    const-string v4, " at line "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " column "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " path "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 838
    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public peek()Lcom/pwrd/google/gson/stream/JsonToken;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 428
    iget v0, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 429
    .local v0, "p":I
    if-nez v0, :cond_0

    .line 430
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v0

    .line 433
    :cond_0
    packed-switch v0, :pswitch_data_0

    .line 462
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1

    .line 435
    :pswitch_0
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BEGIN_OBJECT:Lcom/pwrd/google/gson/stream/JsonToken;

    .line 460
    :goto_0
    return-object v1

    .line 437
    :pswitch_1
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_OBJECT:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 439
    :pswitch_2
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BEGIN_ARRAY:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 441
    :pswitch_3
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_ARRAY:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 445
    :pswitch_4
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NAME:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 448
    :pswitch_5
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->BOOLEAN:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 450
    :pswitch_6
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NULL:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 455
    :pswitch_7
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->STRING:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 458
    :pswitch_8
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->NUMBER:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 460
    :pswitch_9
    sget-object v1, Lcom/pwrd/google/gson/stream/JsonToken;->END_DOCUMENT:Lcom/pwrd/google/gson/stream/JsonToken;

    goto :goto_0

    .line 433
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_5
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_7
        :pswitch_7
        :pswitch_7
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_8
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public final setLenient(Z)V
    .locals 0
    .param p1, "lenient"    # Z

    .prologue
    .line 327
    iput-boolean p1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->lenient:Z

    .line 328
    return-void
.end method

.method public skipValue()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    .line 1234
    const/4 v0, 0x0

    .line 1236
    .local v0, "count":I
    :cond_0
    iget v1, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1237
    .local v1, "p":I
    if-nez v1, :cond_1

    .line 1238
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->doPeek()I

    move-result v1

    .line 1241
    :cond_1
    if-ne v1, v5, :cond_3

    .line 1242
    invoke-direct {p0, v4}, Lcom/pwrd/google/gson/stream/JsonReader;->push(I)V

    .line 1243
    add-int/lit8 v0, v0, 0x1

    .line 1262
    :cond_2
    :goto_0
    const/4 v2, 0x0

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peeked:I

    .line 1263
    if-nez v0, :cond_0

    .line 1265
    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathIndices:[I

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v3, v3, -0x1

    aget v4, v2, v3

    add-int/lit8 v4, v4, 0x1

    aput v4, v2, v3

    .line 1266
    iget-object v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pathNames:[Ljava/lang/String;

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v3, v3, -0x1

    const-string v4, "null"

    aput-object v4, v2, v3

    .line 1267
    return-void

    .line 1244
    :cond_3
    if-ne v1, v4, :cond_4

    .line 1245
    invoke-direct {p0, v5}, Lcom/pwrd/google/gson/stream/JsonReader;->push(I)V

    .line 1246
    add-int/lit8 v0, v0, 0x1

    .line 1247
    goto :goto_0

    :cond_4
    const/4 v2, 0x4

    if-ne v1, v2, :cond_5

    .line 1248
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 1249
    add-int/lit8 v0, v0, -0x1

    .line 1250
    goto :goto_0

    :cond_5
    const/4 v2, 0x2

    if-ne v1, v2, :cond_6

    .line 1251
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->stackSize:I

    .line 1252
    add-int/lit8 v0, v0, -0x1

    .line 1253
    goto :goto_0

    :cond_6
    const/16 v2, 0xe

    if-eq v1, v2, :cond_7

    const/16 v2, 0xa

    if-ne v1, v2, :cond_8

    .line 1254
    :cond_7
    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->skipUnquotedValue()V

    goto :goto_0

    .line 1255
    :cond_8
    const/16 v2, 0x8

    if-eq v1, v2, :cond_9

    const/16 v2, 0xc

    if-ne v1, v2, :cond_a

    .line 1256
    :cond_9
    const/16 v2, 0x27

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->skipQuotedValue(C)V

    goto :goto_0

    .line 1257
    :cond_a
    const/16 v2, 0x9

    if-eq v1, v2, :cond_b

    const/16 v2, 0xd

    if-ne v1, v2, :cond_c

    .line 1258
    :cond_b
    const/16 v2, 0x22

    invoke-direct {p0, v2}, Lcom/pwrd/google/gson/stream/JsonReader;->skipQuotedValue(C)V

    goto :goto_0

    .line 1259
    :cond_c
    const/16 v2, 0x10

    if-ne v1, v2, :cond_2

    .line 1260
    iget v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    iget v3, p0, Lcom/pwrd/google/gson/stream/JsonReader;->peekedNumberLength:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/pwrd/google/gson/stream/JsonReader;->pos:I

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1468
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1469
    const-string v1, " at line "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getLineNumber()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " column "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Lcom/pwrd/google/gson/stream/JsonReader;->getColumnNumber()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1468
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
