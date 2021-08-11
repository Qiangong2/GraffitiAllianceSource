.class public Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;
.super Ljava/lang/Object;
.source "ListAllMyBuckets.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;,
        Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;
    }
.end annotation


# instance fields
.field public buckets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;",
            ">;"
        }
    .end annotation
.end field

.field public owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;


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
    .locals 5

    .prologue
    .line 16
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{ListAllMyBuckets:\n"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .local v1, "stringBuilder":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    invoke-virtual {v2}, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 18
    :cond_0
    const-string v2, "Buckets:\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 19
    iget-object v2, p0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->buckets:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;

    .line 20
    .local v0, "bucket":Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 22
    .end local v0    # "bucket":Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;
    :cond_2
    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 23
    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
