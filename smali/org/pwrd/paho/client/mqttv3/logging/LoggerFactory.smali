.class public Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;
.super Ljava/lang/Object;
.source "LoggerFactory.java"


# static fields
.field private static final CLASS_NAME:Ljava/lang/String;

.field public static final MQTT_CLIENT_MSG_CAT:Ljava/lang/String; = "org.pwrd.paho.client.mqttv3.internal.nls.logcat"

.field private static jsr47LoggerClassName:Ljava/lang/String;

.field private static overrideloggerClassName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->CLASS_NAME:Ljava/lang/String;

    .line 48
    const/4 v0, 0x0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->overrideloggerClassName:Ljava/lang/String;

    .line 52
    const-string v0, "org.pwrd.paho.client.mqttv3.logging.JSR47Logger"

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->jsr47LoggerClassName:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLogger(Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    .locals 5
    .param p0, "messageCatalogName"    # Ljava/lang/String;
    .param p1, "loggerID"    # Ljava/lang/String;

    .prologue
    .line 66
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->overrideloggerClassName:Ljava/lang/String;

    .line 67
    .local v1, "loggerClassName":Ljava/lang/String;
    const/4 v0, 0x0

    .line 69
    .local v0, "logger":Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    if-nez v1, :cond_0

    .line 70
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->jsr47LoggerClassName:Ljava/lang/String;

    .line 73
    :cond_0
    invoke-static {p0}, Ljava/util/ResourceBundle;->getBundle(Ljava/lang/String;)Ljava/util/ResourceBundle;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v1, v2, p1, v3}, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->getLogger(Ljava/lang/String;Ljava/util/ResourceBundle;Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-result-object v0

    .line 76
    if-nez v0, :cond_1

    .line 77
    new-instance v2, Ljava/util/MissingResourceException;

    const-string v3, "Error locating the logging class"

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->CLASS_NAME:Ljava/lang/String;

    invoke-direct {v2, v3, v4, p1}, Ljava/util/MissingResourceException;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    throw v2

    .line 80
    :cond_1
    return-object v0
.end method

.method private static getLogger(Ljava/lang/String;Ljava/util/ResourceBundle;Ljava/lang/String;Ljava/lang/String;)Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    .locals 8
    .param p0, "loggerClassName"    # Ljava/lang/String;
    .param p1, "messageCatalog"    # Ljava/util/ResourceBundle;
    .param p2, "loggerID"    # Ljava/lang/String;
    .param p3, "resourceName"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 94
    const/4 v4, 0x0

    .line 95
    .local v4, "logger":Lorg/pwrd/paho/client/mqttv3/logging/Logger;
    const/4 v3, 0x0

    .line 98
    .local v3, "logClass":Ljava/lang/Class;
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 104
    if-eqz v3, :cond_0

    .line 107
    :try_start_1
    invoke-virtual {v3}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object v4, v0
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_5

    .line 117
    invoke-interface {v4, p1, p2, p3}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->initialise(Ljava/util/ResourceBundle;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    move-object v6, v4

    .line 120
    :goto_0
    return-object v6

    .line 99
    :catch_0
    move-exception v5

    .local v5, "ncdfe":Ljava/lang/NoClassDefFoundError;
    move-object v6, v7

    .line 100
    goto :goto_0

    .line 101
    .end local v5    # "ncdfe":Ljava/lang/NoClassDefFoundError;
    :catch_1
    move-exception v1

    .local v1, "cnfe":Ljava/lang/ClassNotFoundException;
    move-object v6, v7

    .line 102
    goto :goto_0

    .line 108
    .end local v1    # "cnfe":Ljava/lang/ClassNotFoundException;
    :catch_2
    move-exception v2

    .local v2, "e":Ljava/lang/IllegalAccessException;
    move-object v6, v7

    .line 109
    goto :goto_0

    .line 110
    .end local v2    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v2

    .local v2, "e":Ljava/lang/InstantiationException;
    move-object v6, v7

    .line 111
    goto :goto_0

    .line 112
    .end local v2    # "e":Ljava/lang/InstantiationException;
    :catch_4
    move-exception v2

    .local v2, "e":Ljava/lang/ExceptionInInitializerError;
    move-object v6, v7

    .line 113
    goto :goto_0

    .line 114
    .end local v2    # "e":Ljava/lang/ExceptionInInitializerError;
    :catch_5
    move-exception v2

    .local v2, "e":Ljava/lang/SecurityException;
    move-object v6, v7

    .line 115
    goto :goto_0
.end method

.method public static getLoggingProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 131
    const/4 v5, 0x0

    .line 135
    .local v5, "result":Ljava/lang/String;
    :try_start_0
    const-string v6, "java.util.logging.LogManager"

    invoke-static {v6}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 136
    .local v1, "logManagerClass":Ljava/lang/Class;
    const-string v6, "getLogManager"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Class;

    invoke-virtual {v1, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 137
    .local v3, "m1":Ljava/lang/reflect/Method;
    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 138
    .local v2, "logManagerInstance":Ljava/lang/Object;
    const-string v6, "getProperty"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    invoke-virtual {v1, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 139
    .local v4, "m2":Ljava/lang/reflect/Method;
    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    invoke-virtual {v4, v2, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "result":Ljava/lang/String;
    check-cast v5, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    .end local v1    # "logManagerClass":Ljava/lang/Class;
    .end local v2    # "logManagerInstance":Ljava/lang/Object;
    .end local v3    # "m1":Ljava/lang/reflect/Method;
    .end local v4    # "m2":Ljava/lang/reflect/Method;
    .restart local v5    # "result":Ljava/lang/String;
    :goto_0
    return-object v5

    .line 140
    .end local v5    # "result":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    const/4 v5, 0x0

    .restart local v5    # "result":Ljava/lang/String;
    goto :goto_0
.end method

.method public static setLogger(Ljava/lang/String;)V
    .locals 0
    .param p0, "loggerClassName"    # Ljava/lang/String;

    .prologue
    .line 154
    sput-object p0, Lorg/pwrd/paho/client/mqttv3/logging/LoggerFactory;->overrideloggerClassName:Ljava/lang/String;

    .line 155
    return-void
.end method
