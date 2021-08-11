.class public final Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "DeleteMultiObjectRequest.java"


# instance fields
.field private delete:Lcom/tencent/cos/xml/model/tag/Delete;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/List;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p2, "deleteObjectList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    new-instance v0, Lcom/tencent/cos/xml/model/tag/Delete;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/Delete;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    .line 32
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/tencent/cos/xml/model/tag/Delete;->deleteObjects:Ljava/util/List;

    .line 33
    invoke-virtual {p0, p2}, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->setObjectList(Ljava/util/List;)V

    .line 34
    return-void
.end method


# virtual methods
.method public checkParameters()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->bucket:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 61
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "bucket must not be null"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_0
    return-void
.end method

.method public getDelete()Lcom/tencent/cos/xml/model/tag/Delete;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    const-string v0, "POST"

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    const-string v0, "/"

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
    .line 43
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "delete"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->queryParameters:Ljava/util/Map;

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
    .line 50
    :try_start_0
    const-string v1, "application/xml"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    invoke-static {v2}, Lcom/tencent/cos/xml/transfer/XmlBuilder;->buildDelete(Lcom/tencent/cos/xml/model/tag/Delete;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 51
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 53
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 54
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v1, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public isNeedMD5()Z
    .locals 1

    .prologue
    .line 160
    const/4 v0, 0x1

    return v0
.end method

.method public setObjectList(Ljava/lang/String;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/String;

    .prologue
    .line 92
    if-eqz p1, :cond_1

    .line 93
    const-string v1, "/"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 94
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 96
    :cond_0
    new-instance v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;-><init>()V

    .line 97
    .local v0, "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    iput-object p1, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    .line 98
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    iget-object v1, v1, Lcom/tencent/cos/xml/model/tag/Delete;->deleteObjects:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 100
    .end local v0    # "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    :cond_1
    return-void
.end method

.method public setObjectList(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/String;
    .param p2, "versionId"    # Ljava/lang/String;

    .prologue
    .line 103
    if-eqz p1, :cond_2

    .line 104
    const-string v1, "/"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 105
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 107
    :cond_0
    new-instance v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;-><init>()V

    .line 108
    .local v0, "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    iput-object p1, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    .line 109
    if-eqz p2, :cond_1

    .line 110
    iput-object p2, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->versionId:Ljava/lang/String;

    .line 112
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    iget-object v1, v1, Lcom/tencent/cos/xml/model/tag/Delete;->deleteObjects:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 114
    .end local v0    # "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    :cond_2
    return-void
.end method

.method public setObjectList(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 122
    .local p1, "objectList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 123
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    .line 125
    .local v3, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_1

    .line 126
    new-instance v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;-><init>()V

    .line 127
    .local v0, "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 128
    .local v2, "object":Ljava/lang/String;
    const-string v4, "/"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 129
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    .line 133
    :goto_1
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    iget-object v4, v4, Lcom/tencent/cos/xml/model/tag/Delete;->deleteObjects:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 125
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 131
    :cond_0
    iput-object v2, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    goto :goto_1

    .line 136
    .end local v0    # "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    .end local v1    # "i":I
    .end local v2    # "object":Ljava/lang/String;
    .end local v3    # "size":I
    :cond_1
    return-void
.end method

.method public setObjectList(Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 139
    .local p1, "objectListWithVersionId":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_2

    .line 141
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 142
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;-><init>()V

    .line 143
    .local v0, "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 144
    .local v2, "object":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 145
    .local v3, "versionId":Ljava/lang/String;
    const-string v5, "/"

    invoke-virtual {v2, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 146
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    .line 150
    :goto_1
    if-eqz v3, :cond_0

    .line 151
    iput-object v3, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->versionId:Ljava/lang/String;

    .line 153
    :cond_0
    iget-object v5, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    iget-object v5, v5, Lcom/tencent/cos/xml/model/tag/Delete;->deleteObjects:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 148
    :cond_1
    iput-object v2, v0, Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;->key:Ljava/lang/String;

    goto :goto_1

    .line 156
    .end local v0    # "deleteObject":Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "object":Ljava/lang/String;
    .end local v3    # "versionId":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public setQuiet(Z)V
    .locals 1
    .param p1, "quiet"    # Z

    .prologue
    .line 83
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/DeleteMultiObjectRequest;->delete:Lcom/tencent/cos/xml/model/tag/Delete;

    iput-boolean p1, v0, Lcom/tencent/cos/xml/model/tag/Delete;->quiet:Z

    .line 84
    return-void
.end method
