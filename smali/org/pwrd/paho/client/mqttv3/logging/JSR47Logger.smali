.class public Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;
.super Ljava/lang/Object;
.source "JSR47Logger.java"

# interfaces
.implements Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# instance fields
.field private catalogID:Ljava/lang/String;

.field private julLogger:Ljava/util/logging/Logger;

.field private logMessageCatalog:Ljava/util/ResourceBundle;

.field private loggerName:Ljava/lang/String;

.field private resourceName:Ljava/lang/String;

.field private traceMessageCatalog:Ljava/util/ResourceBundle;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    .line 37
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    .line 38
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->traceMessageCatalog:Ljava/util/ResourceBundle;

    .line 39
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->catalogID:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->resourceName:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->loggerName:Ljava/lang/String;

    .line 35
    return-void
.end method

.method protected static dumpMemoryTrace47(Ljava/util/logging/Logger;)V
    .locals 6
    .param p0, "logger"    # Ljava/util/logging/Logger;

    .prologue
    .line 260
    const/4 v3, 0x0

    .line 262
    .local v3, "mHand":Ljava/util/logging/MemoryHandler;
    if-eqz p0, :cond_0

    .line 263
    invoke-virtual {p0}, Ljava/util/logging/Logger;->getHandlers()[Ljava/util/logging/Handler;

    move-result-object v1

    .line 265
    .local v1, "handlers":[Ljava/util/logging/Handler;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, v1

    if-lt v2, v4, :cond_1

    .line 274
    invoke-virtual {p0}, Ljava/util/logging/Logger;->getParent()Ljava/util/logging/Logger;

    move-result-object v4

    invoke-static {v4}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->dumpMemoryTrace47(Ljava/util/logging/Logger;)V

    .line 276
    .end local v1    # "handlers":[Ljava/util/logging/Handler;
    .end local v2    # "i":I
    :cond_0
    :goto_1
    return-void

    .line 266
    .restart local v1    # "handlers":[Ljava/util/logging/Handler;
    .restart local v2    # "i":I
    :cond_1
    aget-object v4, v1, v2

    instance-of v4, v4, Ljava/util/logging/MemoryHandler;

    if-eqz v4, :cond_2

    .line 267
    aget-object v5, v1, v2

    monitor-enter v5

    .line 268
    :try_start_0
    aget-object v4, v1, v2

    move-object v0, v4

    check-cast v0, Ljava/util/logging/MemoryHandler;

    move-object v3, v0

    .line 269
    invoke-virtual {v3}, Ljava/util/logging/MemoryHandler;->push()V

    .line 270
    monitor-exit v5

    goto :goto_1

    .line 267
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 265
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private getResourceMessage(Ljava/util/ResourceBundle;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "messageCatalog"    # Ljava/util/ResourceBundle;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 181
    :try_start_0
    invoke-virtual {p1, p2}, Ljava/util/ResourceBundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/util/MissingResourceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 186
    .local v1, "message":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 182
    .end local v1    # "message":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 184
    .local v0, "e":Ljava/util/MissingResourceException;
    move-object v1, p2

    .restart local v1    # "message":Ljava/lang/String;
    goto :goto_0
.end method

.method private logToJsr47(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ResourceBundle;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "julLevel"    # Ljava/util/logging/Level;
    .param p2, "sourceClass"    # Ljava/lang/String;
    .param p3, "sourceMethod"    # Ljava/lang/String;
    .param p4, "catalogName"    # Ljava/lang/String;
    .param p5, "messageCatalog"    # Ljava/util/ResourceBundle;
    .param p6, "msg"    # Ljava/lang/String;
    .param p7, "inserts"    # [Ljava/lang/Object;
    .param p8, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 192
    move-object v0, p6

    .line 193
    .local v0, "formattedWithArgs":Ljava/lang/String;
    const-string v2, "====="

    invoke-virtual {p6, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 194
    invoke-direct {p0, p5, p6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->getResourceMessage(Ljava/util/ResourceBundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p7}, Ljava/text/MessageFormat;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 196
    :cond_0
    new-instance v1, Ljava/util/logging/LogRecord;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->resourceName:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Ljava/util/logging/LogRecord;-><init>(Ljava/util/logging/Level;Ljava/lang/String;)V

    .line 198
    .local v1, "logRecord":Ljava/util/logging/LogRecord;
    invoke-virtual {v1, p2}, Ljava/util/logging/LogRecord;->setSourceClassName(Ljava/lang/String;)V

    .line 199
    invoke-virtual {v1, p3}, Ljava/util/logging/LogRecord;->setSourceMethodName(Ljava/lang/String;)V

    .line 200
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->loggerName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/logging/LogRecord;->setLoggerName(Ljava/lang/String;)V

    .line 206
    if-eqz p8, :cond_1

    .line 207
    invoke-virtual {v1, p8}, Ljava/util/logging/LogRecord;->setThrown(Ljava/lang/Throwable;)V

    .line 210
    :cond_1
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    invoke-virtual {v2, v1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/LogRecord;)V

    .line 211
    return-void
.end method

.method private mapJULLevel(I)Ljava/util/logging/Level;
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 214
    const/4 v0, 0x0

    .line 216
    .local v0, "julLevel":Ljava/util/logging/Level;
    packed-switch p1, :pswitch_data_0

    .line 242
    :goto_0
    return-object v0

    .line 218
    :pswitch_0
    sget-object v0, Ljava/util/logging/Level;->SEVERE:Ljava/util/logging/Level;

    .line 219
    goto :goto_0

    .line 221
    :pswitch_1
    sget-object v0, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    .line 222
    goto :goto_0

    .line 224
    :pswitch_2
    sget-object v0, Ljava/util/logging/Level;->INFO:Ljava/util/logging/Level;

    .line 225
    goto :goto_0

    .line 227
    :pswitch_3
    sget-object v0, Ljava/util/logging/Level;->CONFIG:Ljava/util/logging/Level;

    .line 228
    goto :goto_0

    .line 230
    :pswitch_4
    sget-object v0, Ljava/util/logging/Level;->FINE:Ljava/util/logging/Level;

    .line 231
    goto :goto_0

    .line 233
    :pswitch_5
    sget-object v0, Ljava/util/logging/Level;->FINER:Ljava/util/logging/Level;

    .line 234
    goto :goto_0

    .line 236
    :pswitch_6
    sget-object v0, Ljava/util/logging/Level;->FINEST:Ljava/util/logging/Level;

    goto :goto_0

    .line 216
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method


# virtual methods
.method public config(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 106
    const/4 v1, 0x4

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 107
    return-void
.end method

.method public config(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 110
    const/4 v1, 0x4

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 111
    return-void
.end method

.method public config(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 114
    const/4 v1, 0x4

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 115
    return-void
.end method

.method public dumpTrace()V
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->dumpMemoryTrace47(Ljava/util/logging/Logger;)V

    .line 257
    return-void
.end method

.method public fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 130
    const/4 v1, 0x5

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 131
    return-void
.end method

.method public fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 134
    const/4 v1, 0x5

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 135
    return-void
.end method

.method public fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 138
    const/4 v1, 0x5

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 139
    return-void
.end method

.method public finer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 142
    const/4 v1, 0x6

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 143
    return-void
.end method

.method public finer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 146
    const/4 v1, 0x6

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 147
    return-void
.end method

.method public finer(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 150
    const/4 v1, 0x6

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 151
    return-void
.end method

.method public finest(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 154
    const/4 v1, 0x7

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 155
    return-void
.end method

.method public finest(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 158
    const/4 v1, 0x7

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 159
    return-void
.end method

.method public finest(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 162
    const/4 v1, 0x7

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 163
    return-void
.end method

.method public formatMessage(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 248
    :try_start_0
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    invoke-virtual {v2, p1}, Ljava/util/ResourceBundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/util/MissingResourceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 252
    .local v1, "formatString":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 249
    .end local v1    # "formatString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 250
    .local v0, "e":Ljava/util/MissingResourceException;
    move-object v1, p1

    .restart local v1    # "formatString":Ljava/lang/String;
    goto :goto_0
.end method

.method public info(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 94
    const/4 v1, 0x3

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 95
    return-void
.end method

.method public info(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 98
    const/4 v1, 0x3

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 99
    return-void
.end method

.method public info(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 102
    const/4 v1, 0x3

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 103
    return-void
.end method

.method public initialise(Ljava/util/ResourceBundle;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "logMsgCatalog"    # Ljava/util/ResourceBundle;
    .param p2, "loggerID"    # Ljava/lang/String;
    .param p3, "resourceContext"    # Ljava/lang/String;

    .prologue
    .line 50
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->traceMessageCatalog:Ljava/util/ResourceBundle;

    .line 51
    iput-object p3, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->resourceName:Ljava/lang/String;

    .line 53
    iput-object p2, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->loggerName:Ljava/lang/String;

    .line 54
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->loggerName:Ljava/lang/String;

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    .line 55
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    .line 56
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->traceMessageCatalog:Ljava/util/ResourceBundle;

    .line 57
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/util/ResourceBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->catalogID:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public isLoggable(I)Z
    .locals 2
    .param p1, "level"    # I

    .prologue
    .line 66
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->mapJULLevel(I)Ljava/util/logging/Level;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->isLoggable(Ljava/util/logging/Level;)Z

    move-result v0

    return v0
.end method

.method public log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 9
    .param p1, "level"    # I
    .param p2, "sourceClass"    # Ljava/lang/String;
    .param p3, "sourceMethod"    # Ljava/lang/String;
    .param p4, "msg"    # Ljava/lang/String;
    .param p5, "inserts"    # [Ljava/lang/Object;
    .param p6, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 119
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->mapJULLevel(I)Ljava/util/logging/Level;

    move-result-object v1

    .line 120
    .local v1, "julLevel":Ljava/util/logging/Level;
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->isLoggable(Ljava/util/logging/Level;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 121
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->catalogID:Ljava/lang/String;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logMessageCatalog:Ljava/util/ResourceBundle;

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v6, p4

    move-object v7, p5

    move-object v8, p6

    invoke-direct/range {v0 .. v8}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logToJsr47(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ResourceBundle;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 123
    :cond_0
    return-void
.end method

.method public setResourceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "logContext"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->resourceName:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public severe(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 70
    const/4 v1, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 71
    return-void
.end method

.method public severe(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 74
    const/4 v1, 0x1

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 75
    return-void
.end method

.method public severe(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 78
    const/4 v1, 0x1

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 79
    return-void
.end method

.method public trace(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 10
    .param p1, "level"    # I
    .param p2, "sourceClass"    # Ljava/lang/String;
    .param p3, "sourceMethod"    # Ljava/lang/String;
    .param p4, "msg"    # Ljava/lang/String;
    .param p5, "inserts"    # [Ljava/lang/Object;
    .param p6, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 167
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->mapJULLevel(I)Ljava/util/logging/Level;

    move-result-object v1

    .line 168
    .local v1, "julLevel":Ljava/util/logging/Level;
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->julLogger:Ljava/util/logging/Logger;

    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->isLoggable(Ljava/util/logging/Level;)Z

    move-result v9

    .line 172
    .local v9, "isJULLoggable":Z
    if-eqz v9, :cond_0

    .line 173
    iget-object v4, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->catalogID:Ljava/lang/String;

    iget-object v5, p0, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->traceMessageCatalog:Ljava/util/ResourceBundle;

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v6, p4

    move-object v7, p5

    move-object/from16 v8, p6

    invoke-direct/range {v0 .. v8}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->logToJsr47(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ResourceBundle;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 175
    :cond_0
    return-void
.end method

.method public warning(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 82
    const/4 v1, 0x2

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 83
    return-void
.end method

.method public warning(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;

    .prologue
    .line 86
    const/4 v1, 0x2

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 87
    return-void
.end method

.method public warning(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "sourceClass"    # Ljava/lang/String;
    .param p2, "sourceMethod"    # Ljava/lang/String;
    .param p3, "msg"    # Ljava/lang/String;
    .param p4, "inserts"    # [Ljava/lang/Object;
    .param p5, "thrown"    # Ljava/lang/Throwable;

    .prologue
    .line 90
    const/4 v1, 0x2

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lorg/pwrd/paho/client/mqttv3/logging/JSR47Logger;->log(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 91
    return-void
.end method
