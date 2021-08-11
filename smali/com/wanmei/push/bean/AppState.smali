.class public Lcom/wanmei/push/bean/AppState;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/Proguard;
.implements Ljava/lang/Cloneable;


# annotations
.annotation runtime Lcom/j256/ormlite/table/DatabaseTable;
    tableName = "appstate"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/bean/AppState$1;,
        Lcom/wanmei/push/bean/AppState$Builder;
    }
.end annotation


# static fields
.field public static final API_ADDR:Ljava/lang/String; = "apiADDR"

.field public static final APP_ID:Ljava/lang/String; = "appId"

.field public static final PACKAGE_NAME:Ljava/lang/String; = "pkName"

.field public static final STATE:Ljava/lang/String; = "state"


# instance fields
.field private apiAddr:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "apiADDR"
        index = true
    .end annotation
.end field

.field private appId:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "appId"
        index = true
    .end annotation
.end field

.field private pkName:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "pkName"
    .end annotation
.end field

.field private state:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "state"
        index = true
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private constructor <init>(Lcom/wanmei/push/bean/AppState$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/wanmei/push/bean/AppState$Builder;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/wanmei/push/bean/AppState$Builder;->access$000(Lcom/wanmei/push/bean/AppState$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/AppState$Builder;->access$100(Lcom/wanmei/push/bean/AppState$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/AppState$Builder;->access$200(Lcom/wanmei/push/bean/AppState$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/AppState$Builder;->access$300(Lcom/wanmei/push/bean/AppState$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    return-void
.end method

.method synthetic constructor <init>(Lcom/wanmei/push/bean/AppState$Builder;Lcom/wanmei/push/bean/AppState$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/wanmei/push/bean/AppState$Builder;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/push/bean/AppState;-><init>(Lcom/wanmei/push/bean/AppState$Builder;)V

    return-void
.end method

.method public static newApp(Lcom/wanmei/push/bean/Notice;)Lcom/wanmei/push/bean/AppState;
    .locals 2
    .param p0, "app"    # Lcom/wanmei/push/bean/Notice;

    .prologue
    const/4 v1, 0x0

    if-nez p0, :cond_0

    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/wanmei/push/bean/Notice;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/AppState;
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    move-object v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/CloneNotSupportedException;->printStackTrace()V

    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method protected clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    .end local p1    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .restart local p1    # "o":Ljava/lang/Object;
    :cond_1
    if-eqz p1, :cond_2

    instance-of v2, p1, Lcom/wanmei/push/bean/Notice;

    if-nez v2, :cond_3

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    check-cast p1, Lcom/wanmei/push/bean/AppState;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    :cond_4
    move v0, v1

    goto :goto_0

    :cond_5
    iget-object v2, p1, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    if-nez v2, :cond_4

    :cond_6
    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_9

    :cond_7
    move v0, v1

    goto :goto_0

    :cond_8
    iget-object v2, p1, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    if-nez v2, :cond_7

    :cond_9
    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_c

    :cond_a
    move v0, v1

    goto :goto_0

    :cond_b
    iget-object v2, p1, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    if-nez v2, :cond_a

    :cond_c
    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    if-eqz v2, :cond_d

    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_1
    move v0, v1

    goto :goto_0

    :cond_d
    iget-object v2, p1, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    if-eqz v2, :cond_0

    goto :goto_1
.end method

.method public getApiAddr()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    return-object v0
.end method

.method public getAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getPkName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_0
    add-int/lit8 v0, v0, 0x0

    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Application{, msgId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/bean/AppState;->appId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", isOffline="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppState;->pkName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", apiAddr="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppState;->apiAddr:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", state="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/AppState;->state:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
