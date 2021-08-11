.class public Lplugins/OneSdkPlugin;
.super Ljava/lang/Object;
.source "OneSdkPlugin.java"


# static fields
.field private static final ONESDK_APPID:I = 0x4db

.field private static final ONESDK_APPKEY:Ljava/lang/String; = "rbflsiyyy9kttglfnl5v367h7msuucxm"

.field private static final TAG:Ljava/lang/String; = "CQQ_ONESDK"


# instance fields
.field balance:Ljava/lang/String;

.field createTime:Ljava/lang/String;

.field id:Ljava/lang/String;

.field level:Ljava/lang/String;

.field private mActivity:Landroid/app/Activity;

.field private mContext:Landroid/content/Context;

.field name:Ljava/lang/String;

.field partyName:Ljava/lang/String;

.field vip:Ljava/lang/String;

.field zoneId:I

.field zoneName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lplugins/OneSdkPlugin;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lplugins/OneSdkPlugin;

    .prologue
    .line 20
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method private getUserInfo()Lcom/wanmei/sdk/core/open/UserInfo;
    .locals 2

    .prologue
    .line 117
    new-instance v0, Lcom/wanmei/sdk/core/open/UserInfo;

    invoke-direct {v0}, Lcom/wanmei/sdk/core/open/UserInfo;-><init>()V

    .line 122
    .local v0, "userInfo":Lcom/wanmei/sdk/core/open/UserInfo;
    iget-object v1, p0, Lplugins/OneSdkPlugin;->id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setRoleId(Ljava/lang/String;)V

    .line 127
    iget-object v1, p0, Lplugins/OneSdkPlugin;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setRoleName(Ljava/lang/String;)V

    .line 133
    iget-object v1, p0, Lplugins/OneSdkPlugin;->level:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setLv(Ljava/lang/String;)V

    .line 139
    iget v1, p0, Lplugins/OneSdkPlugin;->zoneId:I

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setZoneId(I)V

    .line 144
    iget-object v1, p0, Lplugins/OneSdkPlugin;->zoneName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setZoneName(Ljava/lang/String;)V

    .line 149
    const-string v1, "NULL"

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setPartyName(Ljava/lang/String;)V

    .line 154
    const-string v1, "-1"

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setBalance(Ljava/lang/String;)V

    .line 159
    iget-object v1, p0, Lplugins/OneSdkPlugin;->vip:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setVip(Ljava/lang/String;)V

    .line 164
    const-string v1, "1480747870"

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/UserInfo;->setRoleCreateTime(Ljava/lang/String;)V

    .line 165
    return-object v0
.end method


# virtual methods
.method CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "arg2"    # Ljava/lang/String;
    .param p2, "arg3"    # Ljava/lang/String;

    .prologue
    .line 258
    const-string v0, "MainRoot"

    invoke-static {v0, p1, p2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    return-void
.end method

.method public CreateRoleSubmitUserInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "roleId"    # Ljava/lang/String;
    .param p2, "roleName"    # Ljava/lang/String;
    .param p3, "roleLevel"    # Ljava/lang/String;
    .param p4, "roleZoneId"    # I
    .param p5, "roleZoneName"    # Ljava/lang/String;
    .param p6, "rolePartyName"    # Ljava/lang/String;
    .param p7, "roleBalance"    # Ljava/lang/String;
    .param p8, "roldVip"    # Ljava/lang/String;
    .param p9, "roleCreateTime"    # Ljava/lang/String;

    .prologue
    .line 218
    iput-object p1, p0, Lplugins/OneSdkPlugin;->id:Ljava/lang/String;

    .line 219
    iput-object p2, p0, Lplugins/OneSdkPlugin;->name:Ljava/lang/String;

    .line 220
    iput-object p3, p0, Lplugins/OneSdkPlugin;->level:Ljava/lang/String;

    .line 221
    iput p4, p0, Lplugins/OneSdkPlugin;->zoneId:I

    .line 222
    iput-object p5, p0, Lplugins/OneSdkPlugin;->zoneName:Ljava/lang/String;

    .line 223
    iput-object p6, p0, Lplugins/OneSdkPlugin;->partyName:Ljava/lang/String;

    .line 224
    iput-object p7, p0, Lplugins/OneSdkPlugin;->balance:Ljava/lang/String;

    .line 225
    iput-object p8, p0, Lplugins/OneSdkPlugin;->vip:Ljava/lang/String;

    .line 226
    iput-object p9, p0, Lplugins/OneSdkPlugin;->createTime:Ljava/lang/String;

    .line 230
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->CREATE_ROLE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    invoke-direct {p0}, Lplugins/OneSdkPlugin;->getUserInfo()Lcom/wanmei/sdk/core/open/UserInfo;

    move-result-object v2

    new-instance v3, Lplugins/OneSdkPlugin$5;

    invoke-direct {v3, p0}, Lplugins/OneSdkPlugin$5;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/open/SDKBase;->submitUserInfo(Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;Lcom/wanmei/sdk/core/open/UserInfo;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 238
    return-void
.end method

.method public EnterServerSubmitUserInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "roleId"    # Ljava/lang/String;
    .param p2, "roleName"    # Ljava/lang/String;
    .param p3, "roleLevel"    # Ljava/lang/String;
    .param p4, "roleZoneId"    # I
    .param p5, "roleZoneName"    # Ljava/lang/String;
    .param p6, "rolePartyName"    # Ljava/lang/String;
    .param p7, "roleBalance"    # Ljava/lang/String;
    .param p8, "roldVip"    # Ljava/lang/String;
    .param p9, "roleCreateTime"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lplugins/OneSdkPlugin;->id:Ljava/lang/String;

    .line 180
    iput-object p2, p0, Lplugins/OneSdkPlugin;->name:Ljava/lang/String;

    .line 181
    iput-object p3, p0, Lplugins/OneSdkPlugin;->level:Ljava/lang/String;

    .line 182
    iput p4, p0, Lplugins/OneSdkPlugin;->zoneId:I

    .line 183
    iput-object p5, p0, Lplugins/OneSdkPlugin;->zoneName:Ljava/lang/String;

    .line 184
    iput-object p6, p0, Lplugins/OneSdkPlugin;->partyName:Ljava/lang/String;

    .line 185
    iput-object p7, p0, Lplugins/OneSdkPlugin;->balance:Ljava/lang/String;

    .line 186
    iput-object p8, p0, Lplugins/OneSdkPlugin;->vip:Ljava/lang/String;

    .line 187
    iput-object p9, p0, Lplugins/OneSdkPlugin;->createTime:Ljava/lang/String;

    .line 197
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->LOGIN:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    invoke-direct {p0}, Lplugins/OneSdkPlugin;->getUserInfo()Lcom/wanmei/sdk/core/open/UserInfo;

    move-result-object v2

    new-instance v3, Lplugins/OneSdkPlugin$4;

    invoke-direct {v3, p0}, Lplugins/OneSdkPlugin$4;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/open/SDKBase;->submitUserInfo(Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;Lcom/wanmei/sdk/core/open/UserInfo;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 205
    return-void
.end method

.method LoginFail()V
    .locals 4

    .prologue
    .line 263
    const-string v0, "%s,%s,%s,%s"

    .line 264
    .local v0, "str":Ljava/lang/String;
    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "null"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "null"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "null"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "0"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 269
    const-string v1, "Android_DoLogin"

    invoke-virtual {p0, v1, v0}, Lplugins/OneSdkPlugin;->CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    return-void
.end method

.method public OneSdkInit(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 37
    iput-object p1, p0, Lplugins/OneSdkPlugin;->mContext:Landroid/content/Context;

    .line 38
    iput-object p2, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    .line 40
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    const/16 v1, 0x4db

    const-string v2, "rbflsiyyy9kttglfnl5v367h7msuucxm"

    new-instance v3, Lplugins/OneSdkPlugin$1;

    invoke-direct {v3, p0}, Lplugins/OneSdkPlugin$1;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/open/SDKBase;->init(ILjava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V

    .line 60
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lplugins/OneSdkPlugin$2;

    invoke-direct {v1, p0}, Lplugins/OneSdkPlugin$2;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->setLogoutCallBack(Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V

    .line 75
    return-void
.end method

.method public OneSdkLogin()V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lplugins/OneSdkPlugin$3;

    invoke-direct {v1, p0}, Lplugins/OneSdkPlugin$3;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->doLogin(Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V

    .line 103
    return-void
.end method

.method ReLogin(Ljava/lang/String;)V
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 274
    const-string v0, "Android_ReLogin"

    invoke-virtual {p0, v0, p1}, Lplugins/OneSdkPlugin;->CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    return-void
.end method

.method public RoleLevelUpSubmitUserInfo(Ljava/lang/String;)V
    .locals 4
    .param p1, "roleLevel"    # Ljava/lang/String;

    .prologue
    .line 242
    iput-object p1, p0, Lplugins/OneSdkPlugin;->level:Ljava/lang/String;

    .line 247
    iget-object v0, p0, Lplugins/OneSdkPlugin;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    sget-object v1, Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;->ROLE_LEVEL_CHANGE:Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;

    invoke-direct {p0}, Lplugins/OneSdkPlugin;->getUserInfo()Lcom/wanmei/sdk/core/open/UserInfo;

    move-result-object v2

    new-instance v3, Lplugins/OneSdkPlugin$6;

    invoke-direct {v3, p0}, Lplugins/OneSdkPlugin$6;-><init>(Lplugins/OneSdkPlugin;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/open/SDKBase;->submitUserInfo(Lcom/wanmei/sdk/core/open/SDKBase$UserInfoType;Lcom/wanmei/sdk/core/open/UserInfo;Lcom/wanmei/sdk/core/open/SDKInterface$CompleteCallBack;)V

    .line 255
    return-void
.end method
