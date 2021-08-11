.class public abstract Lcom/tencent/qcloud/core/http/RequestBodySerializer;
.super Ljava/lang/Object;
.source "RequestBodySerializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static bytes(Ljava/lang/String;[B)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 6
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "content"    # [B

    .prologue
    .line 59
    const-wide/16 v2, 0x0

    const-wide/16 v4, -0x1

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->bytes(Ljava/lang/String;[BJJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public static bytes(Ljava/lang/String;[BJJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 8
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "content"    # [B
    .param p2, "offset"    # J
    .param p4, "byteCount"    # J

    .prologue
    .line 65
    move-object v0, p1

    move-object v1, p0

    move-wide v2, p2

    move-wide v4, p4

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->bytes([BLjava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    move-result-object v6

    .line 66
    .local v6, "requestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    new-instance v0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-direct {v0, v6}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v0
.end method

.method public static file(Ljava/lang/String;Ljava/io/File;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 6
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 70
    const-wide/16 v2, 0x0

    const-wide/16 v4, -0x1

    move-object v0, p0

    move-object v1, p1

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->file(Ljava/lang/String;Ljava/io/File;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public static file(Ljava/lang/String;Ljava/io/File;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 8
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "file"    # Ljava/io/File;
    .param p2, "offset"    # J
    .param p4, "length"    # J

    .prologue
    .line 78
    move-object v0, p1

    move-object v1, p0

    move-wide v2, p2

    move-wide v4, p4

    invoke-static/range {v0 .. v5}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file(Ljava/io/File;Ljava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    move-result-object v6

    .line 80
    .local v6, "fileRequestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    new-instance v0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-direct {v0, v6}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v0
.end method

.method public static multipart(Ljava/util/Map;Ljava/util/Map;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/tencent/qcloud/core/http/RequestBodySerializer;"
        }
    .end annotation

    .prologue
    .line 106
    .local p0, "keyValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p1, "uploadFiles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lokhttp3/MultipartBody$Builder;

    invoke-direct {v0}, Lokhttp3/MultipartBody$Builder;-><init>()V

    .line 107
    .local v0, "bodyBuilder":Lokhttp3/MultipartBody$Builder;
    const-string v6, "multipart/form-data"

    invoke-static {v6}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v6

    invoke-virtual {v0, v6}, Lokhttp3/MultipartBody$Builder;->setType(Lokhttp3/MediaType;)Lokhttp3/MultipartBody$Builder;

    .line 109
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 110
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v0, v6, v7}, Lokhttp3/MultipartBody$Builder;->addFormDataPart(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/MultipartBody$Builder;

    goto :goto_0

    .line 113
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 114
    .restart local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 115
    .local v4, "path":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 116
    .local v5, "type":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 118
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/tencent/qcloud/core/http/MimeType;->getTypeByFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 117
    invoke-static {v2, v7}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->file(Ljava/io/File;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    move-result-object v3

    .line 119
    .local v3, "fileRequestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v5, v7, v3}, Lokhttp3/MultipartBody$Builder;->addFormDataPart(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;

    goto :goto_1

    .line 122
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fileRequestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    .end local v4    # "path":Ljava/lang/String;
    .end local v5    # "type":Ljava/lang/String;
    :cond_1
    new-instance v6, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-virtual {v0}, Lokhttp3/MultipartBody$Builder;->build()Lokhttp3/MultipartBody;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v6
.end method

.method public static stream(Ljava/lang/String;Landroid/content/Context;Ljava/io/InputStream;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 8
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 84
    const-wide/16 v4, 0x0

    const-wide/16 v6, -0x1

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-static/range {v1 .. v7}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Landroid/content/Context;Ljava/io/InputStream;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public static stream(Ljava/lang/String;Landroid/content/Context;Ljava/io/InputStream;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 9
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inputStream"    # Ljava/io/InputStream;
    .param p3, "offset"    # J
    .param p5, "length"    # J

    .prologue
    .line 89
    new-instance v2, Ljava/io/File;

    invoke-virtual {p1}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    move-result-object v0

    const-string v1, "inputStream_tmp"

    invoke-direct {v2, v0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v2, "tmpFile":Ljava/io/File;
    move-object v1, p0

    move-object v3, p2

    move-wide v4, p3

    move-wide v6, p5

    .line 90
    invoke-static/range {v1 .. v7}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public static stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 8
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "tmpFile"    # Ljava/io/File;
    .param p2, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 94
    const-wide/16 v4, 0x0

    const-wide/16 v6, -0x1

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-static/range {v1 .. v7}, Lcom/tencent/qcloud/core/http/RequestBodySerializer;->stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;

    move-result-object v0

    return-object v0
.end method

.method public static stream(Ljava/lang/String;Ljava/io/File;Ljava/io/InputStream;JJ)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 9
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "tmpFile"    # Ljava/io/File;
    .param p2, "inputStream"    # Ljava/io/InputStream;
    .param p3, "offset"    # J
    .param p5, "length"    # J

    .prologue
    .line 99
    move-object v1, p2

    move-object v2, p1

    move-object v3, p0

    move-wide v4, p3

    move-wide v6, p5

    invoke-static/range {v1 .. v7}, Lcom/tencent/qcloud/core/http/StreamingRequestBody;->steam(Ljava/io/InputStream;Ljava/io/File;Ljava/lang/String;JJ)Lcom/tencent/qcloud/core/http/StreamingRequestBody;

    move-result-object v0

    .line 102
    .local v0, "requestBody":Lcom/tencent/qcloud/core/http/StreamingRequestBody;
    new-instance v1, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-direct {v1, v0}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v1
.end method

.method public static string(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 2
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 49
    new-instance v0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-static {p0}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v1

    invoke-static {v1, p1}, Lokhttp3/RequestBody;->create(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v0
.end method

.method public static string(Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/qcloud/core/http/RequestBodySerializer;
    .locals 2
    .param p0, "contentType"    # Ljava/lang/String;
    .param p1, "content"    # Lokio/ByteString;

    .prologue
    .line 54
    new-instance v0, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;

    invoke-static {p0}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v1

    invoke-static {v1, p1}, Lokhttp3/RequestBody;->create(Lokhttp3/MediaType;Lokio/ByteString;)Lokhttp3/RequestBody;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/http/RequestBodySerializer$BaseRequestBodyWrapper;-><init>(Lokhttp3/RequestBody;)V

    return-object v0
.end method


# virtual methods
.method abstract body()Lokhttp3/RequestBody;
.end method
