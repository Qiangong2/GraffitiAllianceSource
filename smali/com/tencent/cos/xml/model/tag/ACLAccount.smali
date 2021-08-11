.class public Lcom/tencent/cos/xml/model/tag/ACLAccount;
.super Ljava/lang/Object;
.source "ACLAccount.java"


# instance fields
.field idList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/tag/ACLAccount;->idList:Ljava/util/List;

    .line 14
    return-void
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;)V
    .locals 0
    .param p1, "owner"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-virtual {p0, p1, p1}, Lcom/tencent/cos/xml/model/tag/ACLAccount;->addAccount(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    return-void
.end method

.method public addAccount(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "ownerUin"    # Ljava/lang/String;
    .param p2, "subUin"    # Ljava/lang/String;

    .prologue
    .line 17
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 18
    iget-object v0, p0, Lcom/tencent/cos/xml/model/tag/ACLAccount;->idList:Ljava/util/List;

    const-string v1, "id=\"qcs::cam::uin/%s:uin/%s\""

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 20
    :cond_0
    return-void
.end method

.method public getAccount()Ljava/lang/String;
    .locals 7

    .prologue
    .line 27
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 28
    .local v3, "stringBuilder":Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/tencent/cos/xml/model/tag/ACLAccount;->idList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 29
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 31
    .end local v0    # "account":Ljava/lang/String;
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 32
    .local v2, "result":Ljava/lang/String;
    const-string v4, ","

    invoke-virtual {v2, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 33
    .local v1, "last":I
    if-lez v1, :cond_1

    .line 34
    const/4 v4, 0x0

    invoke-virtual {v2, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 36
    :goto_1
    return-object v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method
