.class public Lcom/wanmei/push/bean/SyncAppInfo;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;
    }
.end annotation


# instance fields
.field private appInfoList:Ljava/util/List;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "list"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private page:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "page"
    .end annotation
.end field

.field private totalPage:Ljava/lang/String;
    .annotation runtime Lcom/pwrd/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/pwrd/google/gson/annotations/SerializedName;
        value = "totalPage"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppInfoList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/wanmei/push/bean/SyncAppInfo;->appInfoList:Ljava/util/List;

    return-object v0
.end method

.method public getPage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/SyncAppInfo;->page:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalPage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/SyncAppInfo;->totalPage:Ljava/lang/String;

    return-object v0
.end method

.method public setAppInfoList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "appInfoList":Ljava/util/List;, "Ljava/util/List<Lcom/wanmei/push/bean/SyncAppInfo$DeviceAppInfo;>;"
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo;->appInfoList:Ljava/util/List;

    return-void
.end method

.method public setPage(Ljava/lang/String;)V
    .locals 0
    .param p1, "page"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo;->page:Ljava/lang/String;

    return-void
.end method

.method public setTotalPage(Ljava/lang/String;)V
    .locals 0
    .param p1, "totalPage"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/SyncAppInfo;->totalPage:Ljava/lang/String;

    return-void
.end method
