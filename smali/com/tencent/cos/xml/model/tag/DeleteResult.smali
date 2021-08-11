.class public Lcom/tencent/cos/xml/model/tag/DeleteResult;
.super Ljava/lang/Object;
.source "DeleteResult.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;,
        Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    }
.end annotation


# instance fields
.field public deletedList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;",
            ">;"
        }
    .end annotation
.end field

.field public errorList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 15
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "{DeleteResult:\n"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 16
    .local v2, "stringBuilder":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/tencent/cos/xml/model/tag/DeleteResult;->deletedList:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 17
    iget-object v3, p0, Lcom/tencent/cos/xml/model/tag/DeleteResult;->deletedList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;

    .line 18
    .local v0, "deleted":Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 21
    .end local v0    # "deleted":Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    :cond_1
    iget-object v3, p0, Lcom/tencent/cos/xml/model/tag/DeleteResult;->errorList:Ljava/util/List;

    if-eqz v3, :cond_3

    .line 22
    iget-object v3, p0, Lcom/tencent/cos/xml/model/tag/DeleteResult;->errorList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;

    .line 23
    .local v1, "error":Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 26
    .end local v1    # "error":Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;
    :cond_3
    const-string v3, "}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 27
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
