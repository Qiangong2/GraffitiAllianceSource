.class public final Lcom/tencent/cos/xml/model/object/GetObjectRequest;
.super Lcom/tencent/cos/xml/model/object/ObjectRequest;
.source "GetObjectRequest.java"


# instance fields
.field private progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private range:Lcom/tencent/cos/xml/common/Range;

.field private rspCacheControl:Ljava/lang/String;

.field private rspContentDisposition:Ljava/lang/String;

.field private rspContentEncoding:Ljava/lang/String;

.field private rspContentLanguage:Ljava/lang/String;

.field private rspContentType:Ljava/lang/String;

.field private rspExpires:Ljava/lang/String;

.field private saveFileName:Ljava/lang/String;

.field private savePath:Ljava/lang/String;

.field private versionId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "savePath"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "savePath"    # Ljava/lang/String;
    .param p4, "saveFileName"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/tencent/cos/xml/model/object/ObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    iput-object p3, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    .line 55
    iput-object p4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->saveFileName:Ljava/lang/String;

    .line 56
    return-void
.end method


# virtual methods
.method public getDownloadPath()Ljava/lang/String;
    .locals 7

    .prologue
    .line 253
    const/4 v1, 0x0

    .line 254
    .local v1, "path":Ljava/lang/String;
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    if-eqz v4, :cond_3

    .line 255
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 256
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 260
    :goto_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 261
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 262
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 264
    :cond_0
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->saveFileName:Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 265
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->saveFileName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    move-object v2, v1

    .line 277
    .end local v0    # "file":Ljava/io/File;
    .end local v1    # "path":Ljava/lang/String;
    .local v2, "path":Ljava/lang/String;
    :goto_1
    return-object v2

    .line 258
    .end local v2    # "path":Ljava/lang/String;
    .restart local v1    # "path":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    goto :goto_0

    .line 268
    .restart local v0    # "file":Ljava/io/File;
    :cond_2
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->cosPath:Ljava/lang/String;

    if-eqz v4, :cond_3

    .line 269
    iget-object v4, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->cosPath:Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v3

    .line 270
    .local v3, "separator":I
    if-ltz v3, :cond_4

    .line 271
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->cosPath:Ljava/lang/String;

    add-int/lit8 v6, v3, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .end local v0    # "file":Ljava/io/File;
    .end local v3    # "separator":I
    :cond_3
    :goto_2
    move-object v2, v1

    .line 277
    .end local v1    # "path":Ljava/lang/String;
    .restart local v2    # "path":Ljava/lang/String;
    goto :goto_1

    .line 273
    .end local v2    # "path":Ljava/lang/String;
    .restart local v0    # "file":Ljava/io/File;
    .restart local v1    # "path":Ljava/lang/String;
    .restart local v3    # "separator":I
    :cond_4
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->cosPath:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_2
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 285
    const-string v0, "GET"

    return-object v0
.end method

.method public getProgressListener()Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

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
    .line 290
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->versionId:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 291
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "versionId"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->versionId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentType:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 294
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-content-type="

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 296
    :cond_1
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentLanguage:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 297
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-content-language"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentLanguage:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspExpires:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 300
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-expires"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspExpires:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspCacheControl:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 303
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-cache-control"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspCacheControl:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 305
    :cond_4
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentDisposition:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 306
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-content-disposition"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentDisposition:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    :cond_5
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentEncoding:Ljava/lang/String;

    if-eqz v0, :cond_6

    .line 309
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->queryParameters:Ljava/util/Map;

    const-string v1, "response-content-encoding"

    iget-object v2, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentEncoding:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 311
    :cond_6
    invoke-super {p0}, Lcom/tencent/cos/xml/model/object/ObjectRequest;->getQueryString()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRange()Lcom/tencent/cos/xml/common/Range;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->range:Lcom/tencent/cos/xml/common/Range;

    return-object v0
.end method

.method public getRequestBody()Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 1

    .prologue
    .line 319
    const/4 v0, 0x0

    return-object v0
.end method

.method public getRspCacheControl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspCacheControl:Ljava/lang/String;

    return-object v0
.end method

.method public getRspContentDispositon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentDisposition:Ljava/lang/String;

    return-object v0
.end method

.method public getRspContentEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentEncoding:Ljava/lang/String;

    return-object v0
.end method

.method public getRspContentLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentLanguage:Ljava/lang/String;

    return-object v0
.end method

.method public getRspContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentType:Ljava/lang/String;

    return-object v0
.end method

.method public getRspExpires()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspExpires:Ljava/lang/String;

    return-object v0
.end method

.method public getSavePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    return-object v0
.end method

.method public setIfMatch(Ljava/lang/String;)V
    .locals 1
    .param p1, "ifMatch"    # Ljava/lang/String;

    .prologue
    .line 210
    if-eqz p1, :cond_0

    .line 211
    const-string v0, "If-Match"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    :cond_0
    return-void
.end method

.method public setIfModifiedSince(Ljava/lang/String;)V
    .locals 1
    .param p1, "ifModifiedSince"    # Ljava/lang/String;

    .prologue
    .line 198
    if-eqz p1, :cond_0

    .line 199
    const-string v0, "If-Modified-Since"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    :cond_0
    return-void
.end method

.method public setIfNONEMatch(Ljava/lang/String;)V
    .locals 1
    .param p1, "ifNONEMatch"    # Ljava/lang/String;

    .prologue
    .line 216
    if-eqz p1, :cond_0

    .line 217
    const-string v0, "If-None-Match"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    :cond_0
    return-void
.end method

.method public setIfUnmodifiedSince(Ljava/lang/String;)V
    .locals 1
    .param p1, "ifUnmodifiedSince"    # Ljava/lang/String;

    .prologue
    .line 204
    if-eqz p1, :cond_0

    .line 205
    const-string v0, "If-Unmodified-Since"

    invoke-virtual {p0, v0, p1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    :cond_0
    return-void
.end method

.method public setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "progressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->progressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 227
    return-void
.end method

.method public setRange(J)V
    .locals 3
    .param p1, "start"    # J

    .prologue
    .line 182
    const-wide/16 v0, -0x1

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setRange(JJ)V

    .line 183
    return-void
.end method

.method public setRange(JJ)V
    .locals 5
    .param p1, "start"    # J
    .param p3, "end"    # J

    .prologue
    .line 171
    const-wide/16 v2, 0x0

    cmp-long v1, p1, v2

    if-gez v1, :cond_0

    const-wide/16 p1, 0x0

    .line 172
    :cond_0
    new-instance v0, Lcom/tencent/cos/xml/common/Range;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/tencent/cos/xml/common/Range;-><init>(JJ)V

    .line 173
    .local v0, "range":Lcom/tencent/cos/xml/common/Range;
    const-string v1, "Range"

    invoke-virtual {v0}, Lcom/tencent/cos/xml/common/Range;->getRange()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    iput-object v0, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->range:Lcom/tencent/cos/xml/common/Range;

    .line 175
    return-void
.end method

.method public setRspCacheControl(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspCacheControl"    # Ljava/lang/String;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspCacheControl:Ljava/lang/String;

    .line 121
    return-void
.end method

.method public setRspContentDispositon(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspContentDispositon"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentDisposition:Ljava/lang/String;

    .line 138
    return-void
.end method

.method public setRspContentEncoding(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspContentEncoding"    # Ljava/lang/String;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentEncoding:Ljava/lang/String;

    .line 154
    return-void
.end method

.method public setRspContentLanguage(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspContentLanguage"    # Ljava/lang/String;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentLanguage:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setRspContentType(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspContentType"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspContentType:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setRspExpires(Ljava/lang/String;)V
    .locals 0
    .param p1, "rspExpires"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->rspExpires:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setSavePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "savePath"    # Ljava/lang/String;

    .prologue
    .line 241
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->savePath:Ljava/lang/String;

    .line 242
    return-void
.end method

.method public setVersionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "versionId"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->versionId:Ljava/lang/String;

    .line 61
    return-void
.end method
