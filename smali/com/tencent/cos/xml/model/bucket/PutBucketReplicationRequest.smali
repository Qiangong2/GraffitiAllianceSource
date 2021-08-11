.class public Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;
.super Lcom/tencent/cos/xml/model/bucket/BucketRequest;
.source "PutBucketReplicationRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;
    }
.end annotation


# instance fields
.field private replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;-><init>(Ljava/lang/String;)V

    .line 34
    new-instance v0, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    .line 35
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->rules:Ljava/util/List;

    .line 36
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const-string v0, "PUT"

    return-object v0
.end method

.method public getQueryString()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "replication"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    invoke-super {p0}, Lcom/tencent/cos/xml/model/bucket/BucketRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 78
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    .line 79
    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildReplicationConfiguration(Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;)Ljava/lang/String;

    move-result-object v2

    .line 78
    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 80
    :catch_0
    move-exception v0

    .line 81
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 82
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 83
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 90
    const/4 v0, 0x1

    return v0
.end method

.method public setReplicationConfigurationWithRole(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "ownerUin"    # Ljava/lang/String;
    .param p2, "subUin"    # Ljava/lang/String;

    .prologue
    .line 40
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 41
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "qcs::cam::uin/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":uin/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, "role":Ljava/lang/String;
    iget-object v1, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    iput-object v0, v1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->role:Ljava/lang/String;

    .line 44
    .end local v0    # "role":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setReplicationConfigurationWithRule(Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;)V
    .locals 5
    .param p1, "ruleStruct"    # Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;

    .prologue
    .line 48
    if-eqz p1, :cond_0

    .line 49
    new-instance v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;

    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;-><init>()V

    .line 50
    .local v2, "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    iget-object v3, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->id:Ljava/lang/String;

    iput-object v3, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->id:Ljava/lang/String;

    .line 51
    iget-boolean v3, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->isEnable:Z

    if-eqz v3, :cond_1

    const-string v3, "Enabled"

    :goto_0
    iput-object v3, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->status:Ljava/lang/String;

    .line 52
    iget-object v3, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->prefix:Ljava/lang/String;

    iput-object v3, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->prefix:Ljava/lang/String;

    .line 53
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;

    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;-><init>()V

    .line 54
    .local v1, "destination":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;
    iget-object v3, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->storageClass:Ljava/lang/String;

    iput-object v3, v1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;->storageClass:Ljava/lang/String;

    .line 55
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 56
    .local v0, "bucket":Ljava/lang/StringBuilder;
    const-string v3, "qcs:id/0:cos:"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->region:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":appid/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->appid:Ljava/lang/String;

    .line 57
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest$RuleStruct;->bucket:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 58
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;->bucket:Ljava/lang/String;

    .line 59
    iput-object v1, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->destination:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;

    .line 60
    iget-object v3, p0, Lcom/tencent/cos/xml/model/bucket/PutBucketReplicationRequest;->replicationConfiguration:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;

    iget-object v3, v3, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->rules:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 62
    .end local v0    # "bucket":Ljava/lang/StringBuilder;
    .end local v1    # "destination":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;
    .end local v2    # "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    :cond_0
    return-void

    .line 51
    .restart local v2    # "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    :cond_1
    const-string v3, "Disabled"

    goto :goto_0
.end method
