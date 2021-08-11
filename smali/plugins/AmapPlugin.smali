.class public Lplugins/AmapPlugin;
.super Ljava/lang/Object;
.source "AmapPlugin.java"

# interfaces
.implements Lcom/amap/api/location/AMapLocationListener;


# instance fields
.field mLocationClient:Lcom/amap/api/location/AMapLocationClient;

.field mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    .line 23
    iput-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    return-void
.end method


# virtual methods
.method CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "arg2"    # Ljava/lang/String;
    .param p2, "arg3"    # Ljava/lang/String;

    .prologue
    .line 64
    const-string v0, "MainRoot"

    invoke-static {v0, p1, p2}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public Destroy()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocationClient;->onDestroy()V

    .line 61
    return-void
.end method

.method public LocationInit(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 28
    new-instance v0, Lcom/amap/api/location/AMapLocationClient;

    invoke-direct {v0, p1}, Lcom/amap/api/location/AMapLocationClient;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    .line 30
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    invoke-virtual {v0, p0}, Lcom/amap/api/location/AMapLocationClient;->setLocationListener(Lcom/amap/api/location/AMapLocationListener;)V

    .line 33
    new-instance v0, Lcom/amap/api/location/AMapLocationClientOption;

    invoke-direct {v0}, Lcom/amap/api/location/AMapLocationClientOption;-><init>()V

    iput-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    .line 35
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    sget-object v1, Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;->Hight_Accuracy:Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;

    invoke-virtual {v0, v1}, Lcom/amap/api/location/AMapLocationClientOption;->setLocationMode(Lcom/amap/api/location/AMapLocationClientOption$AMapLocationMode;)Lcom/amap/api/location/AMapLocationClientOption;

    .line 37
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, v2, v3}, Lcom/amap/api/location/AMapLocationClientOption;->setInterval(J)Lcom/amap/api/location/AMapLocationClientOption;

    .line 39
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amap/api/location/AMapLocationClientOption;->setWifiActiveScan(Z)V

    .line 41
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amap/api/location/AMapLocationClientOption;->setMockEnable(Z)V

    .line 44
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    iget-object v1, p0, Lplugins/AmapPlugin;->mLocationOption:Lcom/amap/api/location/AMapLocationClientOption;

    invoke-virtual {v0, v1}, Lcom/amap/api/location/AMapLocationClient;->setLocationOption(Lcom/amap/api/location/AMapLocationClientOption;)V

    .line 45
    return-void
.end method

.method public StartLocation()V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocationClient;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 53
    :goto_0
    return-void

    .line 52
    :cond_0
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocationClient;->startLocation()V

    goto :goto_0
.end method

.method public StopLocation()V
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lplugins/AmapPlugin;->mLocationClient:Lcom/amap/api/location/AMapLocationClient;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocationClient;->stopLocation()V

    .line 57
    return-void
.end method

.method public onLocationChanged(Lcom/amap/api/location/AMapLocation;)V
    .locals 7
    .param p1, "aMapLocation"    # Lcom/amap/api/location/AMapLocation;

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 68
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I

    move-result v1

    if-nez v1, :cond_0

    .line 70
    const-string v0, "%s,%s,%s"

    .line 71
    .local v0, "str":Ljava/lang/String;
    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    .line 72
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v1, v5

    .line 73
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v1, v6

    .line 74
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getAdCode()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    .line 71
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 75
    const-string v1, "Android_OnLocationUpdate"

    invoke-virtual {p0, v1, v0}, Lplugins/AmapPlugin;->CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    .end local v0    # "str":Ljava/lang/String;
    :goto_0
    return-void

    .line 77
    :cond_0
    const-string v1, "Android_OnLocationError"

    const-string v2, "%s,%s"

    new-array v3, v4, [Ljava/lang/Object;

    .line 79
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    .line 80
    invoke-virtual {p1}, Lcom/amap/api/location/AMapLocation;->getErrorInfo()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    .line 78
    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 77
    invoke-virtual {p0, v1, v2}, Lplugins/AmapPlugin;->CallUnityMethod(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
