.class public Lcom/getui/getuiunity/GTPushBridge;
.super Ljava/lang/Object;
.source "GTPushBridge.java"


# static fields
.field public static GAMA_OBJECT:Ljava/lang/String;

.field public static mContext:Landroid/content/Context;

.field private static pushBridge:Lcom/getui/getuiunity/GTPushBridge;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    new-instance v0, Lcom/getui/getuiunity/GTPushBridge;

    invoke-direct {v0}, Lcom/getui/getuiunity/GTPushBridge;-><init>()V

    sput-object v0, Lcom/getui/getuiunity/GTPushBridge;->pushBridge:Lcom/getui/getuiunity/GTPushBridge;

    .line 17
    const-string v0, "Main Camera"

    sput-object v0, Lcom/getui/getuiunity/GTPushBridge;->GAMA_OBJECT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/getui/getuiunity/GTPushBridge;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/getui/getuiunity/GTPushBridge;->pushBridge:Lcom/getui/getuiunity/GTPushBridge;

    return-object v0
.end method


# virtual methods
.method public bindAlias(Ljava/lang/String;)Z
    .locals 2
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/igexin/sdk/PushManager;->bindAlias(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getClientId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 49
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->getClientid(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 2

    .prologue
    .line 45
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->getVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public initPush(Ljava/lang/String;)V
    .locals 3
    .param p1, "gameObject"    # Ljava/lang/String;

    .prologue
    .line 26
    sput-object p1, Lcom/getui/getuiunity/GTPushBridge;->GAMA_OBJECT:Ljava/lang/String;

    .line 27
    sget-object v0, Lcom/unity3d/player/UnityPlayer;->currentActivity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    .line 28
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    const-class v2, Lcom/getui/getuiunity/GTPushService;

    invoke-virtual {v0, v1, v2}, Lcom/igexin/sdk/PushManager;->initialize(Landroid/content/Context;Ljava/lang/Class;)V

    .line 29
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    const-class v2, Lcom/getui/getuiunity/GTPushIntentService;

    invoke-virtual {v0, v1, v2}, Lcom/igexin/sdk/PushManager;->registerPushIntentService(Landroid/content/Context;Ljava/lang/Class;)V

    .line 30
    return-void
.end method

.method public isPushTurnOn()Z
    .locals 2

    .prologue
    .line 53
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->isPushTurnedOn(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public setPushMode(Z)V
    .locals 2
    .param p1, "turnOn"    # Z

    .prologue
    .line 33
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->isPushTurnedOn(Landroid/content/Context;)Z

    move-result v0

    if-ne p1, v0, :cond_0

    .line 42
    :goto_0
    return-void

    .line 36
    :cond_0
    if-eqz p1, :cond_1

    .line 37
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->turnOnPush(Landroid/content/Context;)V

    goto :goto_0

    .line 40
    :cond_1
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->turnOffPush(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public setTag(Ljava/lang/String;)I
    .locals 7
    .param p1, "tagNames"    # Ljava/lang/String;

    .prologue
    .line 69
    const-string v4, ","

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "tagNameArray":[Ljava/lang/String;
    if-eqz p1, :cond_0

    array-length v4, v2

    if-gtz v4, :cond_2

    .line 72
    :cond_0
    const/4 v3, 0x0

    .line 83
    .local v3, "tags":[Lcom/igexin/sdk/Tag;
    :cond_1
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v4

    sget-object v5, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    const-string v6, "sn-default"

    invoke-virtual {v4, v5, v3, v6}, Lcom/igexin/sdk/PushManager;->setTag(Landroid/content/Context;[Lcom/igexin/sdk/Tag;Ljava/lang/String;)I

    move-result v4

    return v4

    .line 75
    .end local v3    # "tags":[Lcom/igexin/sdk/Tag;
    :cond_2
    array-length v4, v2

    new-array v3, v4, [Lcom/igexin/sdk/Tag;

    .line 76
    .restart local v3    # "tags":[Lcom/igexin/sdk/Tag;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v4, v2

    if-ge v0, v4, :cond_1

    .line 77
    new-instance v1, Lcom/igexin/sdk/Tag;

    invoke-direct {v1}, Lcom/igexin/sdk/Tag;-><init>()V

    .line 78
    .local v1, "tag":Lcom/igexin/sdk/Tag;
    aget-object v4, v2, v0

    invoke-virtual {v1, v4}, Lcom/igexin/sdk/Tag;->setName(Ljava/lang/String;)V

    .line 79
    aput-object v1, v3, v0

    .line 76
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public turnOffPush()V
    .locals 2

    .prologue
    .line 63
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->isPushTurnedOn(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->turnOffPush(Landroid/content/Context;)V

    .line 66
    :cond_0
    return-void
.end method

.method public turnOnPush()V
    .locals 2

    .prologue
    .line 57
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->isPushTurnedOn(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 58
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/PushManager;->turnOnPush(Landroid/content/Context;)V

    .line 60
    :cond_0
    return-void
.end method

.method public unBindAlias(Ljava/lang/String;)Z
    .locals 3
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 91
    invoke-static {}, Lcom/igexin/sdk/PushManager;->getInstance()Lcom/igexin/sdk/PushManager;

    move-result-object v0

    sget-object v1, Lcom/getui/getuiunity/GTPushBridge;->mContext:Landroid/content/Context;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p1, v2}, Lcom/igexin/sdk/PushManager;->unBindAlias(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
