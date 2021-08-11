.class public Lorg/pwrd/paho/client/mqttv3/logging/SimpleLogFormatter;
.super Ljava/util/logging/Formatter;
.source "SimpleLogFormatter.java"


# static fields
.field private static final LS:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-string v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/logging/SimpleLogFormatter;->LS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/util/logging/Formatter;-><init>()V

    .line 35
    return-void
.end method

.method public static left(Ljava/lang/String;IC)Ljava/lang/String;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "width"    # I
    .param p2, "fillChar"    # C

    .prologue
    .line 93
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-lt v2, p1, :cond_0

    .line 101
    .end local p0    # "s":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 96
    .restart local p0    # "s":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1, p1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 97
    .local v1, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 98
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    sub-int v0, p1, v2

    .local v0, "i":I
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-gez v0, :cond_1

    .line 101
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 99
    :cond_1
    invoke-virtual {v1, p2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1
.end method


# virtual methods
.method public format(Ljava/util/logging/LogRecord;)Ljava/lang/String;
    .locals 22
    .param p1, "r"    # Ljava/util/logging/LogRecord;

    .prologue
    .line 41
    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    .line 42
    .local v9, "sb":Ljava/lang/StringBuffer;
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getLevel()Ljava/util/logging/Level;

    move-result-object v14

    invoke-virtual {v14}, Ljava/util/logging/Level;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    const-string v15, "\t"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 43
    new-instance v14, Ljava/lang/StringBuilder;

    const-string v15, "{0, date, yy-MM-dd} {0, time, kk:mm:ss.SSSS} "

    .line 44
    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    new-instance v18, Ljava/util/Date;

    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getMillis()J

    move-result-wide v20

    move-object/from16 v0, v18

    move-wide/from16 v1, v20

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    aput-object v18, v16, v17

    .line 43
    invoke-static/range {v15 .. v16}, Ljava/text/MessageFormat;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 44
    const-string v15, "\t"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 43
    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 45
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getSourceClassName()Ljava/lang/String;

    move-result-object v6

    .line 46
    .local v6, "cnm":Ljava/lang/String;
    const-string v4, ""

    .line 47
    .local v4, "cn":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 48
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v5

    .line 49
    .local v5, "cnl":I
    const/16 v14, 0x14

    if-le v5, v14, :cond_2

    .line 50
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getSourceClassName()Ljava/lang/String;

    move-result-object v14

    add-int/lit8 v15, v5, -0x13

    invoke-virtual {v14, v15}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 57
    .end local v5    # "cnl":I
    :cond_0
    :goto_0
    invoke-virtual {v9, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    const-string v15, "\t"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 58
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getSourceMethodName()Ljava/lang/String;

    move-result-object v14

    const/16 v15, 0x17

    const/16 v16, 0x20

    invoke-static/range {v14 .. v16}, Lorg/pwrd/paho/client/mqttv3/logging/SimpleLogFormatter;->left(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    const-string v15, "\t"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 59
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getThreadID()I

    move-result v14

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v14

    const-string v15, "\t"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 60
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/logging/SimpleLogFormatter;->formatMessage(Ljava/util/logging/LogRecord;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v14

    sget-object v15, Lorg/pwrd/paho/client/mqttv3/logging/SimpleLogFormatter;->LS:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 61
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getThrown()Ljava/lang/Throwable;

    move-result-object v14

    if-eqz v14, :cond_1

    .line 62
    const-string v14, "Throwable occurred: "

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 63
    invoke-virtual/range {p1 .. p1}, Ljava/util/logging/LogRecord;->getThrown()Ljava/lang/Throwable;

    move-result-object v13

    .line 64
    .local v13, "t":Ljava/lang/Throwable;
    const/4 v7, 0x0

    .line 66
    .local v7, "pw":Ljava/io/PrintWriter;
    :try_start_0
    new-instance v12, Ljava/io/StringWriter;

    invoke-direct {v12}, Ljava/io/StringWriter;-><init>()V

    .line 67
    .local v12, "sw":Ljava/io/StringWriter;
    new-instance v8, Ljava/io/PrintWriter;

    invoke-direct {v8, v12}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    .end local v7    # "pw":Ljava/io/PrintWriter;
    .local v8, "pw":Ljava/io/PrintWriter;
    :try_start_1
    invoke-virtual {v13, v8}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 69
    invoke-virtual {v12}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v9, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 71
    if-eqz v8, :cond_1

    .line 73
    :try_start_2
    invoke-virtual {v8}, Ljava/io/PrintWriter;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 80
    .end local v8    # "pw":Ljava/io/PrintWriter;
    .end local v12    # "sw":Ljava/io/StringWriter;
    .end local v13    # "t":Ljava/lang/Throwable;
    :cond_1
    :goto_1
    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    return-object v14

    .line 52
    .restart local v5    # "cnl":I
    :cond_2
    const/4 v14, 0x1

    new-array v11, v14, [C

    const/4 v14, 0x0

    const/16 v15, 0x20

    aput-char v15, v11, v14

    .line 53
    .local v11, "sp":[C
    new-instance v14, Ljava/lang/StringBuffer;

    invoke-direct {v14}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v14, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v10

    .line 54
    .local v10, "sb1":Ljava/lang/StringBuffer;
    const/4 v14, 0x0

    const/4 v15, 0x1

    invoke-virtual {v10, v11, v14, v15}, Ljava/lang/StringBuffer;->append([CII)Ljava/lang/StringBuffer;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_0

    .line 70
    .end local v5    # "cnl":I
    .end local v10    # "sb1":Ljava/lang/StringBuffer;
    .end local v11    # "sp":[C
    .restart local v7    # "pw":Ljava/io/PrintWriter;
    .restart local v13    # "t":Ljava/lang/Throwable;
    :catchall_0
    move-exception v14

    .line 71
    :goto_2
    if-eqz v7, :cond_3

    .line 73
    :try_start_3
    invoke-virtual {v7}, Ljava/io/PrintWriter;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 78
    :cond_3
    :goto_3
    throw v14

    .line 74
    :catch_0
    move-exception v15

    goto :goto_3

    .end local v7    # "pw":Ljava/io/PrintWriter;
    .restart local v8    # "pw":Ljava/io/PrintWriter;
    .restart local v12    # "sw":Ljava/io/StringWriter;
    :catch_1
    move-exception v14

    goto :goto_1

    .line 70
    :catchall_1
    move-exception v14

    move-object v7, v8

    .end local v8    # "pw":Ljava/io/PrintWriter;
    .restart local v7    # "pw":Ljava/io/PrintWriter;
    goto :goto_2
.end method
