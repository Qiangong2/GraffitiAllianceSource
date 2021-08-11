.class public Lcom/tencent/apollo/ApolloVoiceDeviceMgr;
.super Ljava/lang/Object;
.source "ApolloVoiceDeviceMgr.java"


# static fields
.field private static audioManager:Landroid/media/AudioManager; = null

.field private static isUsedBlue:Z = false

.field private static isblueConnect:Z = false

.field private static mCurrVoipState:Z = false

.field private static mHeadSetReceiver:Landroid/content/BroadcastReceiver; = null

.field protected static mIsOpenCommuntication:Z = false

.field protected static mSpeakerphoneOn:Z = false

.field private static m_blueAdapt:Landroid/bluetooth/BluetoothAdapter; = null

.field private static mainActivity:Landroid/app/Activity; = null

.field private static maxVolCall:I = 0x0

.field private static maxVolMusic:I = 0x0

.field private static mctx:Landroid/content/Context; = null

.field private static preState:Z = false

.field private static final tag:Ljava/lang/String; = "GCloudVoiceTag"


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x0

    .line 21
    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    .line 23
    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mainActivity:Landroid/app/Activity;

    .line 24
    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    .line 25
    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->m_blueAdapt:Landroid/bluetooth/BluetoothAdapter;

    .line 26
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    .line 27
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isUsedBlue:Z

    .line 29
    sput v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolMusic:I

    .line 30
    sput v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolCall:I

    .line 34
    :try_start_0
    const-string v0, "GCloudVoice"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 262
    :goto_0
    const/4 v0, 0x1

    sput-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    .line 263
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mIsOpenCommuntication:Z

    .line 264
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mCurrVoipState:Z

    .line 265
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->preState:Z

    .line 271
    new-instance v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr$1;

    invoke-direct {v0}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr$1;-><init>()V

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mHeadSetReceiver:Landroid/content/BroadcastReceiver;

    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v1, "load library failed!!!"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ApolloVoiceDeviceEnterVoipMode(I)V
    .locals 3

    .prologue
    .line 196
    const-string v0, "GCloudVoiceTag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "apolloVoice ApolloVoiceDeviceEnterVoipMode nMode="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_0

    .line 203
    :goto_0
    return-void

    .line 200
    :cond_0
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setMode(I)V

    .line 201
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0
.end method

.method public static ApolloVoiceDeviceExitVoipMode()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 119
    const-string v0, "GCloudVoiceTag"

    const-string v1, "apolloVoice ApolloVoiceDeviceExitVoipMode"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-nez v0, :cond_1

    .line 136
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-eqz v0, :cond_0

    .line 125
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->setMode(I)V

    .line 126
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->IsHeadSet()Z

    move-result v0

    .line 127
    if-eqz v0, :cond_2

    .line 129
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0

    .line 133
    :cond_2
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0
.end method

.method public static ApolloVoiceDeviceInit(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 52
    const-string v0, "GCloudVoiceTag"

    const-string v1, "GCloudVoice ApolloVoiceDeviceInit"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 53
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-eqz v0, :cond_1

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 55
    :cond_1
    sput-object p0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    .line 57
    sput-object p1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mainActivity:Landroid/app/Activity;

    .line 59
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_2

    .line 61
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    .line 65
    :cond_2
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-eqz v0, :cond_3

    .line 67
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    .line 68
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    .line 70
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v0

    sput v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolMusic:I

    .line 71
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v0

    sput v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolCall:I

    .line 73
    const-string v0, "GCloudVoiceTag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "GCloudVoice::max music "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolMusic:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "max call =  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolCall:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    :cond_3
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->registerHeadsetPlugReceiver()V

    .line 76
    invoke-static {p0}, Lcom/tencent/apollo/ApolloVoiceConfig;->SetContext(Landroid/content/Context;)V

    .line 77
    invoke-static {p0}, Lcom/tencent/apollo/ApolloVoiceUDID;->SetContext(Landroid/content/Context;)V

    .line 78
    invoke-static {p0}, Lcom/tencent/apollo/ApolloVoiceNetStatus;->SetContext(Landroid/content/Context;)V

    .line 80
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isBluetoothScoAvailableOffCall()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->m_blueAdapt:Landroid/bluetooth/BluetoothAdapter;

    .line 83
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isBluetoothA2dpOn()Z

    move-result v0

    sput-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    .line 85
    const-string v0, "GCloudVoiceTag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "apollovoicemanager:: cur bluetooth state is: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public static ApolloVoiceDeviceRefresh()V
    .locals 2

    .prologue
    .line 100
    const-string v0, "GCloudVoiceTag"

    const-string v1, "apolloVoice ApolloVoiceDeviceRefresh"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 101
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-nez v0, :cond_1

    .line 116
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-eqz v0, :cond_0

    .line 106
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isWiredHeadsetOn()Z

    move-result v0

    .line 107
    if-eqz v0, :cond_2

    .line 109
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0

    .line 113
    :cond_2
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0
.end method

.method public static ApolloVoiceDeviceSetMode(I)Z
    .locals 9

    .prologue
    const/4 v1, 0x3

    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 408
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_1

    .line 410
    const-string v0, "GCloudVoiceTag"

    const-string v3, "apolloVoiceDevice::audioManager is null ..\n"

    invoke-static {v0, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 411
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-eqz v0, :cond_0

    .line 413
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    const-string v3, "audio"

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    sput-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    .line 414
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_1

    .line 416
    const-string v0, "GCloudVoiceTag"

    const-string v1, "apolloVoiceDevice::get audioManager null....\n"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 457
    :goto_0
    return v2

    .line 422
    :cond_0
    const-string v0, "GCloudVoiceTag"

    const-string v1, "apolloVoiceDevice::context is null....\n"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 426
    :cond_1
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->getMode()I

    move-result v3

    .line 429
    if-eq v3, p0, :cond_2

    .line 435
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez p0, :cond_3

    .line 437
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-object v3, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 438
    sget v3, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolMusic:I

    mul-int/2addr v3, v0

    sget v5, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolCall:I

    div-int/2addr v3, v5

    .line 439
    sput-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->preState:Z

    .line 440
    sget-object v5, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    move v8, v1

    move v1, v0

    move v0, v8

    .line 451
    :goto_1
    const-string v5, "GCloudVoiceTag"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "apolloVoiceDevice::set phone mode "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "set vol =  "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "pre vol =  "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v5, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 452
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v1, p0}, Landroid/media/AudioManager;->setMode(I)V

    .line 453
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v1, v0, v3, v2}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 455
    :cond_2
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-static {v0}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->ApolloVoiceSetSpeakerOn(Z)V

    .line 456
    const-string v0, "GCloudVoiceTag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "apolloVoiceDevice::set phone mode "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v4

    .line 457
    goto :goto_0

    .line 445
    :cond_3
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    sget-object v5, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 446
    sget v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolCall:I

    mul-int/2addr v1, v0

    sget v5, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->maxVolMusic:I

    div-int/2addr v1, v5

    .line 447
    sput-boolean v4, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->preState:Z

    .line 448
    sget-object v5, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    .line 449
    const-string v5, "GCloudVoiceTag"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "apolloVoiceDevice::cur phone mode "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "cur vol =  "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move v3, v1

    move v1, v0

    move v0, v2

    goto/16 :goto_1
.end method

.method private static ApolloVoiceDeviceStartBlue()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    .line 145
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_1

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    const-string v0, "GCloudVoiceTag"

    const-string v1, "ApolloVoiceDeviceManager::set blue  ...\n"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    if-eqz v0, :cond_0

    .line 150
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isSpeakerphoneOn()Z

    move-result v0

    sput-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    .line 151
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    if-eqz v0, :cond_2

    .line 153
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    .line 155
    :cond_2
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isBluetoothScoOn()Z

    move-result v0

    .line 156
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v1}, Landroid/media/AudioManager;->getMode()I

    move-result v1

    .line 157
    const-string v2, "GCloudVoiceTag"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "set bluetoothSco ..."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 158
    const-string v2, "GCloudVoiceTag"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "blue cur mode ..."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    if-nez v0, :cond_0

    .line 161
    if-eq v1, v5, :cond_3

    .line 163
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v5}, Landroid/media/AudioManager;->setMode(I)V

    .line 165
    :cond_3
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->startBluetoothSco()V

    goto :goto_0
.end method

.method public static ApolloVoiceDeviceUninit()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 90
    sput-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mainActivity:Landroid/app/Activity;

    .line 91
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-eqz v0, :cond_0

    .line 92
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->unregisterHeadsetPlugReceiver()V

    .line 93
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setMode(I)V

    .line 94
    sput-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    .line 95
    sput-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    .line 97
    :cond_0
    return-void
.end method

.method public static ApolloVoiceGetCurrMode()I
    .locals 1

    .prologue
    .line 188
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-eqz v0, :cond_0

    .line 190
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->getMode()I

    move-result v0

    .line 192
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x2

    goto :goto_0
.end method

.method public static ApolloVoiceSetSpeakerOn(Z)V
    .locals 3

    .prologue
    .line 393
    const-string v0, "GCloudVoiceTag"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "apolloVoiceDevice::SetSpeakerOn is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 394
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-nez v0, :cond_0

    .line 404
    :goto_0
    return-void

    .line 396
    :cond_0
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->IsHeadSet()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->IsBlueSet()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 398
    :cond_1
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_0

    .line 402
    :cond_2
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, p0}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    .line 403
    sput-boolean p0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    goto :goto_0
.end method

.method public static HaveMicrophonePermission()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 463
    sget-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-nez v2, :cond_0

    .line 491
    :goto_0
    return v0

    .line 476
    :cond_0
    const-string v2, "GCloudVoiceTag"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "buildVersion = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 477
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v2, v3, :cond_2

    .line 478
    sget-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    const-string v3, "android.permission.RECORD_AUDIO"

    invoke-static {v2, v3}, Landroid/support/v4/content/ContextCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    if-eqz v2, :cond_1

    .line 481
    const-string v2, "GCloudVoiceTag"

    const-string v3, "No microphone permission"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 482
    sget-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mainActivity:Landroid/app/Activity;

    new-array v1, v1, [Ljava/lang/String;

    const-string v3, "android.permission.RECORD_AUDIO"

    aput-object v3, v1, v0

    const/16 v3, 0x64

    invoke-static {v2, v1, v3}, Landroid/support/v4/app/ActivityCompat;->requestPermissions(Landroid/app/Activity;[Ljava/lang/String;I)V

    goto :goto_0

    .line 486
    :cond_1
    const-string v0, "GCloudVoiceTag"

    const-string v2, "Hava microphone permission"

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    .line 487
    goto :goto_0

    :cond_2
    move v0, v1

    .line 491
    goto :goto_0
.end method

.method private static IsBlueSet()Z
    .locals 1

    .prologue
    .line 140
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    return v0
.end method

.method private static IsHeadSet()Z
    .locals 1

    .prologue
    .line 175
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    if-eqz v0, :cond_0

    .line 177
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0}, Landroid/media/AudioManager;->isWiredHeadsetOn()Z

    move-result v0

    .line 178
    if-eqz v0, :cond_0

    .line 179
    const/4 v0, 0x1

    .line 183
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static SetpreVoipMode(I)V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 268
    if-ne p0, v0, :cond_0

    :goto_0
    sput-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mCurrVoipState:Z

    .line 269
    return-void

    .line 268
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic access$002(Z)Z
    .locals 0

    .prologue
    .line 19
    sput-boolean p0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isblueConnect:Z

    return p0
.end method

.method static synthetic access$100()Z
    .locals 1

    .prologue
    .line 19
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isUsedBlue:Z

    return v0
.end method

.method static synthetic access$102(Z)Z
    .locals 0

    .prologue
    .line 19
    sput-boolean p0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->isUsedBlue:Z

    return p0
.end method

.method static synthetic access$200()Landroid/media/AudioManager;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->audioManager:Landroid/media/AudioManager;

    return-object v0
.end method

.method static synthetic access$300()Z
    .locals 1

    .prologue
    .line 19
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->preState:Z

    return v0
.end method

.method static synthetic access$400()Z
    .locals 1

    .prologue
    .line 19
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->IsHeadSet()Z

    move-result v0

    return v0
.end method

.method private static registerHeadsetPlugReceiver()V
    .locals 4

    .prologue
    .line 243
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 260
    :goto_0
    return-void

    .line 246
    :cond_0
    :try_start_0
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 247
    const-string v1, "android.intent.action.HEADSET_PLUG"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 248
    const-string v1, "android.media.ACTION_SCO_AUDIO_STATE_UPDATED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 249
    const-string v1, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 251
    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    sget-object v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mHeadSetReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 257
    :catch_0
    move-exception v0

    .line 258
    const-string v1, "GCloudVoiceTag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Registe headset failed!!! The exception is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static unregisterHeadsetPlugReceiver()V
    .locals 4

    .prologue
    .line 232
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 240
    :goto_0
    return-void

    .line 235
    :cond_0
    :try_start_0
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mHeadSetReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 236
    sget-object v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mctx:Landroid/content/Context;

    sget-object v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mHeadSetReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 237
    :catch_0
    move-exception v0

    .line 238
    const-string v1, "GCloudVoiceTag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Registe headset failed!!! The exception is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
