.class public Lcom/umeng/analytics/UnityUtil;
.super Ljava/lang/Object;
.source "UnityUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkPermission(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "permission"    # Ljava/lang/String;

    .prologue
    .line 47
    const/4 v5, 0x0

    .line 48
    .local v5, "result":Z
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x17

    if-lt v6, v7, :cond_2

    .line 50
    :try_start_0
    const-string v6, "android.content.Context"

    invoke-static {v6}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 51
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v6, "checkSelfPermission"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Ljava/lang/String;

    aput-object v9, v7, v8

    invoke-virtual {v0, v6, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 52
    .local v2, "method":Ljava/lang/reflect/Method;
    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-virtual {v2, p0, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 53
    .local v4, "rest":I
    if-nez v4, :cond_1

    .line 54
    const/4 v5, 0x1

    .line 67
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "method":Ljava/lang/reflect/Method;
    .end local v4    # "rest":I
    :cond_0
    :goto_0
    return v5

    .line 56
    .restart local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v2    # "method":Ljava/lang/reflect/Method;
    .restart local v4    # "rest":I
    :cond_1
    const/4 v5, 0x0

    goto :goto_0

    .line 58
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "method":Ljava/lang/reflect/Method;
    .end local v4    # "rest":I
    :catch_0
    move-exception v1

    .line 59
    .local v1, "e":Ljava/lang/Exception;
    const/4 v5, 0x0

    .line 61
    goto :goto_0

    .line 62
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 63
    .local v3, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, p1, v6}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v6

    if-nez v6, :cond_0

    .line 64
    const/4 v5, 0x1

    goto :goto_0
.end method

.method public static getDeviceInfo(Landroid/content/Context;)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 73
    .local v5, "json":Lorg/json/JSONObject;
    const-string v8, "phone"

    invoke-virtual {p0, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    .line 72
    check-cast v7, Landroid/telephony/TelephonyManager;

    .line 74
    .local v7, "tm":Landroid/telephony/TelephonyManager;
    const/4 v0, 0x0

    .line 75
    .local v0, "device_id":Ljava/lang/String;
    const-string v8, "android.permission.READ_PHONE_STATE"

    invoke-static {p0, v8}, Lcom/umeng/analytics/UnityUtil;->checkPermission(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 76
    invoke-virtual {v7}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v0

    .line 78
    :cond_0
    const/4 v6, 0x0

    .line 79
    .local v6, "mac":Ljava/lang/String;
    const/4 v2, 0x0

    .line 81
    .local v2, "fstream":Ljava/io/FileReader;
    :try_start_1
    new-instance v2, Ljava/io/FileReader;

    .end local v2    # "fstream":Ljava/io/FileReader;
    const-string v8, "/sys/class/net/wlan0/address"

    invoke-direct {v2, v8}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    .line 85
    .restart local v2    # "fstream":Ljava/io/FileReader;
    :goto_0
    const/4 v3, 0x0

    .line 86
    .local v3, "in":Ljava/io/BufferedReader;
    if-eqz v2, :cond_2

    .line 88
    :try_start_2
    new-instance v4, Ljava/io/BufferedReader;

    const/16 v8, 0x400

    invoke-direct {v4, v2, v8}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 89
    .end local v3    # "in":Ljava/io/BufferedReader;
    .local v4, "in":Ljava/io/BufferedReader;
    :try_start_3
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_9
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v6

    .line 92
    if-eqz v2, :cond_1

    .line 94
    :try_start_4
    invoke-virtual {v2}, Ljava/io/FileReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    .line 99
    :cond_1
    :goto_1
    if-eqz v4, :cond_8

    .line 101
    :try_start_5
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_8
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    move-object v3, v4

    .line 108
    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :cond_2
    :goto_2
    :try_start_6
    const-string v8, "mac"

    invoke-virtual {v5, v8, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 109
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 110
    move-object v0, v6

    .line 112
    :cond_3
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 113
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    .line 114
    const-string v9, "android_id"

    .line 113
    invoke-static {v8, v9}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 116
    :cond_4
    const-string v8, "device_id"

    invoke-virtual {v5, v8, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 117
    invoke-virtual {v5}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v8

    .line 121
    .end local v0    # "device_id":Ljava/lang/String;
    .end local v2    # "fstream":Ljava/io/FileReader;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .end local v5    # "json":Lorg/json/JSONObject;
    .end local v6    # "mac":Ljava/lang/String;
    .end local v7    # "tm":Landroid/telephony/TelephonyManager;
    :goto_3
    return-object v8

    .line 82
    .restart local v0    # "device_id":Ljava/lang/String;
    .restart local v5    # "json":Lorg/json/JSONObject;
    .restart local v6    # "mac":Ljava/lang/String;
    .restart local v7    # "tm":Landroid/telephony/TelephonyManager;
    :catch_0
    move-exception v1

    .line 83
    .local v1, "e":Ljava/io/FileNotFoundException;
    new-instance v2, Ljava/io/FileReader;

    const-string v8, "/sys/class/net/eth0/address"

    invoke-direct {v2, v8}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    .restart local v2    # "fstream":Ljava/io/FileReader;
    goto :goto_0

    .line 90
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :catch_1
    move-exception v8

    .line 92
    :goto_4
    if-eqz v2, :cond_5

    .line 94
    :try_start_7
    invoke-virtual {v2}, Ljava/io/FileReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    .line 99
    :cond_5
    :goto_5
    if-eqz v3, :cond_2

    .line 101
    :try_start_8
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_3

    goto :goto_2

    .line 102
    :catch_2
    move-exception v1

    .line 103
    .local v1, "e":Ljava/io/IOException;
    :try_start_9
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_3

    goto :goto_2

    .line 118
    .end local v0    # "device_id":Ljava/lang/String;
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "fstream":Ljava/io/FileReader;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .end local v5    # "json":Lorg/json/JSONObject;
    .end local v6    # "mac":Ljava/lang/String;
    .end local v7    # "tm":Landroid/telephony/TelephonyManager;
    :catch_3
    move-exception v1

    .line 119
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 121
    const/4 v8, 0x0

    goto :goto_3

    .line 95
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "device_id":Ljava/lang/String;
    .restart local v2    # "fstream":Ljava/io/FileReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    .restart local v5    # "json":Lorg/json/JSONObject;
    .restart local v6    # "mac":Ljava/lang/String;
    .restart local v7    # "tm":Landroid/telephony/TelephonyManager;
    :catch_4
    move-exception v1

    .line 96
    .local v1, "e":Ljava/io/IOException;
    :try_start_a
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3

    goto :goto_5

    .line 91
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    .line 92
    :goto_6
    if-eqz v2, :cond_6

    .line 94
    :try_start_b
    invoke-virtual {v2}, Ljava/io/FileReader;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_5
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_3

    .line 99
    :cond_6
    :goto_7
    if-eqz v3, :cond_7

    .line 101
    :try_start_c
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_6
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_3

    .line 106
    :cond_7
    :goto_8
    :try_start_d
    throw v8

    .line 95
    :catch_5
    move-exception v1

    .line 96
    .restart local v1    # "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_7

    .line 102
    .end local v1    # "e":Ljava/io/IOException;
    :catch_6
    move-exception v1

    .line 103
    .restart local v1    # "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_8

    .line 95
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    :catch_7
    move-exception v1

    .line 96
    .restart local v1    # "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 102
    .end local v1    # "e":Ljava/io/IOException;
    :catch_8
    move-exception v1

    .line 103
    .restart local v1    # "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_3

    .end local v1    # "e":Ljava/io/IOException;
    :cond_8
    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    goto :goto_2

    .line 91
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v8

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    goto :goto_6

    .line 90
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    :catch_9
    move-exception v8

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    goto :goto_4
.end method

.method public static initUnity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "appkey"    # Ljava/lang/String;
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "version"    # Ljava/lang/String;

    .prologue
    .line 27
    const-string v0, "Unity"

    sput-object v0, Lcom/umeng/analytics/AnalyticsConfig;->mWrapperType:Ljava/lang/String;

    .line 28
    sput-object p3, Lcom/umeng/analytics/AnalyticsConfig;->mWrapperVersion:Ljava/lang/String;

    .line 29
    new-instance v0, Lcom/umeng/analytics/MobclickAgent$UMAnalyticsConfig;

    sget-object v1, Lcom/umeng/analytics/MobclickAgent$EScenarioType;->E_UM_GAME:Lcom/umeng/analytics/MobclickAgent$EScenarioType;

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/umeng/analytics/MobclickAgent$UMAnalyticsConfig;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/umeng/analytics/MobclickAgent$EScenarioType;)V

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->startWithConfigure(Lcom/umeng/analytics/MobclickAgent$UMAnalyticsConfig;)V

    .line 30
    invoke-static {p0}, Lcom/umeng/analytics/game/UMGameAgent;->init(Landroid/content/Context;)V

    .line 36
    return-void
.end method

.method public static onEventForUnity(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "keyPath"    # Ljava/lang/String;
    .param p2, "value"    # I
    .param p3, "label"    # Ljava/lang/String;

    .prologue
    .line 40
    const-string v1, ";=umengUnity=;"

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 41
    .local v0, "items":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0, v0, p2, p3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/util/List;ILjava/lang/String;)V

    .line 42
    return-void
.end method
