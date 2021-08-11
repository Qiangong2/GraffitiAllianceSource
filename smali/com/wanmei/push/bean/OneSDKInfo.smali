.class public Lcom/wanmei/push/bean/OneSDKInfo;
.super Ljava/lang/Object;


# instance fields
.field private oneAppId:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "oneAppId"
    .end annotation
.end field

.field private oneAppKey:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "oneAppKey"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, ""

    iput-object v0, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppKey:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getOneAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppId:Ljava/lang/String;

    return-object v0
.end method

.method public getOneAppKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppKey:Ljava/lang/String;

    return-object v0
.end method

.method public setOneAppId(Ljava/lang/String;)V
    .locals 0
    .param p1, "oneAppId"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppId:Ljava/lang/String;

    return-void
.end method

.method public setOneAppKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "oneAppKey"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppKey:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    const/16 v2, 0x27

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "OneSDKInfo{oneAppId=\'"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", oneAppKey=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/OneSDKInfo;->oneAppKey:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
