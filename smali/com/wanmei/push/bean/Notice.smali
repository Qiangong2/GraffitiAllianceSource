.class public Lcom/wanmei/push/bean/Notice;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/Proguard;
.implements Ljava/lang/Cloneable;


# annotations
.annotation runtime Lcom/j256/ormlite/table/DatabaseTable;
    tableName = "message"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/push/bean/Notice$1;,
        Lcom/wanmei/push/bean/Notice$Builder;
    }
.end annotation


# static fields
.field public static final API_ADDR:Ljava/lang/String; = "apiADDR"

.field public static final IS_OFFLINE:Ljava/lang/String; = "isOffline"

.field public static final MSG_ID:Ljava/lang/String; = "msgId"


# instance fields
.field private apiAddr:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "apiADDR"
        index = true
    .end annotation
.end field

.field private isOffline:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "isOffline"
    .end annotation
.end field

.field private msgId:Ljava/lang/String;
    .annotation runtime Lcom/j256/ormlite/field/DatabaseField;
        columnName = "msgId"
        index = true
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "0"

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Lcom/wanmei/push/bean/Notice$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/wanmei/push/bean/Notice$Builder;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "0"

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/Notice$Builder;->access$000(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/Notice$Builder;->access$100(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    invoke-static {p1}, Lcom/wanmei/push/bean/Notice$Builder;->access$200(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    return-void
.end method

.method synthetic constructor <init>(Lcom/wanmei/push/bean/Notice$Builder;Lcom/wanmei/push/bean/Notice$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/wanmei/push/bean/Notice$Builder;

    .prologue
    invoke-direct {p0, p1}, Lcom/wanmei/push/bean/Notice;-><init>(Lcom/wanmei/push/bean/Notice$Builder;)V

    return-void
.end method

.method public static newMessage(Lcom/wanmei/push/bean/Notice;)Lcom/wanmei/push/bean/Notice;
    .locals 2
    .param p0, "message"    # Lcom/wanmei/push/bean/Notice;

    .prologue
    const/4 v1, 0x0

    if-nez p0, :cond_0

    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/wanmei/push/bean/Notice;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wanmei/push/bean/Notice;
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
    check-cast p1, Lcom/wanmei/push/bean/Notice;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    :cond_4
    move v0, v1

    goto :goto_0

    :cond_5
    iget-object v2, p1, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    if-nez v2, :cond_4

    :cond_6
    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_9

    :cond_7
    move v0, v1

    goto :goto_0

    :cond_8
    iget-object v2, p1, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    if-nez v2, :cond_7

    :cond_9
    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    iget-object v3, p1, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_1
    move v0, v1

    goto :goto_0

    :cond_a
    iget-object v2, p1, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    if-eqz v2, :cond_0

    goto :goto_1
.end method

.method public getApiAddr()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    return-object v0
.end method

.method public getIsOffline()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    return-object v0
.end method

.method public getMsgId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_0
    add-int/lit8 v0, v0, 0x0

    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

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
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Notice{, msgId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/push/bean/Notice;->msgId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", isOffline="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/Notice;->isOffline:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", apiAddr="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wanmei/push/bean/Notice;->apiAddr:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
