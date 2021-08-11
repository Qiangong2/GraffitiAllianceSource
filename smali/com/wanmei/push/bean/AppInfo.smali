.class public Lcom/wanmei/push/bean/AppInfo;
.super Ljava/lang/Object;


# instance fields
.field private appClientId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "appClientId"
    .end annotation
.end field

.field private appClientSecret:Ljava/lang/String;

.field private packageName:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "packageName"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/push/bean/AppInfo;->packageName:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/push/bean/AppInfo;->appClientSecret:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAppClientId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppInfo;->appClientId:Ljava/lang/String;

    return-object v0
.end method

.method public getAppClientSecret()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppInfo;->appClientSecret:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppInfo;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public setAppClientId(Ljava/lang/String;)V
    .locals 0
    .param p1, "appId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/AppInfo;->appClientId:Ljava/lang/String;

    return-void
.end method

.method public setAppClientSecret(Ljava/lang/String;)V
    .locals 0
    .param p1, "appKey"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/AppInfo;->appClientSecret:Ljava/lang/String;

    return-void
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "pkName"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/AppInfo;->packageName:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "AppInfo{appClientId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/bean/AppInfo;->appClientId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", appClientSecret="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppInfo;->appClientSecret:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", packageName=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "} "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
