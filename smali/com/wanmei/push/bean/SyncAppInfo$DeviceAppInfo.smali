.class public Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/bean/SyncAppInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DeviceAppInfo"
.end annotation


# instance fields
.field private appId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "appId"
    .end annotation
.end field

.field private bundleId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "bundleId"
    .end annotation
.end field

.field final synthetic this$0:Lcom/wanmei/push/bean/SyncAppInfo;


# direct methods
.method public constructor <init>(Lcom/wanmei/push/bean/SyncAppInfo;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->this$0:Lcom/wanmei/push/bean/SyncAppInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getBundleId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->bundleId:Ljava/lang/String;

    return-object v0
.end method

.method public setAppId(Ljava/lang/String;)V
    .locals 0
    .param p1, "appId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->appId:Ljava/lang/String;

    return-void
.end method

.method public setBundleId(Ljava/lang/String;)V
    .locals 0
    .param p1, "bundleId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;->bundleId:Ljava/lang/String;

    return-void
.end method
