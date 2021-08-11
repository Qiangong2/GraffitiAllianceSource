.class final Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;
.super Ljava/lang/Object;
.source "HttpLoggingInterceptor.java"

# interfaces
.implements Lokhttp3/Interceptor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;,
        Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;
    }
.end annotation


# static fields
.field private static final UTF8:Ljava/nio/charset/Charset;


# instance fields
.field private volatile level:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

.field private final logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->UTF8:Ljava/nio/charset/Charset;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 126
    sget-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->DEFAULT:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    invoke-direct {p0, v0}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;-><init>(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;)V

    .line 127
    return-void
.end method

.method public constructor <init>(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;)V
    .locals 1
    .param p1, "logger"    # Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    .prologue
    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    sget-object v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->NONE:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    iput-object v0, p0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->level:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    .line 130
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    .line 131
    return-void
.end method

.method private bodyEncoded(Lokhttp3/Headers;)Z
    .locals 2
    .param p1, "headers"    # Lokhttp3/Headers;

    .prologue
    .line 325
    const-string v1, "Content-Encoding"

    invoke-virtual {p1, v1}, Lokhttp3/Headers;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 326
    .local v0, "contentEncoding":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v1, "identity"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isContentLengthTooLarge(J)Z
    .locals 3
    .param p1, "contentLength"    # J

    .prologue
    .line 297
    const-wide/16 v0, 0x800

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static isPlaintext(Lokio/Buffer;)Z
    .locals 10
    .param p0, "buffer"    # Lokio/Buffer;

    .prologue
    const-wide/16 v4, 0x40

    const/4 v9, 0x0

    .line 306
    :try_start_0
    new-instance v1, Lokio/Buffer;

    invoke-direct {v1}, Lokio/Buffer;-><init>()V

    .line 307
    .local v1, "prefix":Lokio/Buffer;
    invoke-virtual {p0}, Lokio/Buffer;->size()J

    move-result-wide v2

    cmp-long v0, v2, v4

    if-gez v0, :cond_0

    invoke-virtual {p0}, Lokio/Buffer;->size()J

    move-result-wide v4

    .line 308
    .local v4, "byteCount":J
    :cond_0
    const-wide/16 v2, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lokio/Buffer;->copyTo(Lokio/Buffer;JJ)Lokio/Buffer;

    .line 309
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    const/16 v0, 0x10

    if-ge v8, v0, :cond_1

    .line 310
    invoke-virtual {v1}, Lokio/Buffer;->exhausted()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 318
    :cond_1
    const/4 v0, 0x1

    .line 320
    .end local v1    # "prefix":Lokio/Buffer;
    .end local v4    # "byteCount":J
    .end local v8    # "i":I
    :goto_1
    return v0

    .line 313
    .restart local v1    # "prefix":Lokio/Buffer;
    .restart local v4    # "byteCount":J
    .restart local v8    # "i":I
    :cond_2
    invoke-virtual {v1}, Lokio/Buffer;->readUtf8CodePoint()I

    move-result v6

    .line 314
    .local v6, "codePoint":I
    invoke-static {v6}, Ljava/lang/Character;->isISOControl(I)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-static {v6}, Ljava/lang/Character;->isWhitespace(I)Z
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-nez v0, :cond_3

    move v0, v9

    .line 315
    goto :goto_1

    .line 309
    :cond_3
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 319
    .end local v1    # "prefix":Lokio/Buffer;
    .end local v4    # "byteCount":J
    .end local v6    # "codePoint":I
    .end local v8    # "i":I
    :catch_0
    move-exception v7

    .local v7, "e":Ljava/io/EOFException;
    move v0, v9

    .line 320
    goto :goto_1
.end method


# virtual methods
.method public getLevel()Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->level:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    return-object v0
.end method

.method public intercept(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;
    .locals 36
    .param p1, "chain"    # Lokhttp3/Interceptor$Chain;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 152
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->level:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    move-object/from16 v17, v0

    .line 154
    .local v17, "level":Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;
    invoke-interface/range {p1 .. p1}, Lokhttp3/Interceptor$Chain;->request()Lokhttp3/Request;

    move-result-object v22

    .line 155
    .local v22, "request":Lokhttp3/Request;
    sget-object v32, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->NONE:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    move-object/from16 v0, v17

    move-object/from16 v1, v32

    if-ne v0, v1, :cond_1

    .line 156
    move-object/from16 v0, p1

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lokhttp3/Interceptor$Chain;->proceed(Lokhttp3/Request;)Lokhttp3/Response;

    move-result-object v25

    .line 293
    :cond_0
    :goto_0
    return-object v25

    .line 159
    :cond_1
    sget-object v32, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->BODY:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    move-object/from16 v0, v17

    move-object/from16 v1, v32

    if-ne v0, v1, :cond_7

    const/16 v18, 0x1

    .line 160
    .local v18, "logBody":Z
    :goto_1
    if-nez v18, :cond_2

    sget-object v32, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;->HEADERS:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    move-object/from16 v0, v17

    move-object/from16 v1, v32

    if-ne v0, v1, :cond_8

    :cond_2
    const/16 v19, 0x1

    .line 162
    .local v19, "logHeaders":Z
    :goto_2
    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->body()Lokhttp3/RequestBody;

    move-result-object v23

    .line 163
    .local v23, "requestBody":Lokhttp3/RequestBody;
    if-eqz v23, :cond_9

    const/4 v13, 0x1

    .line 165
    .local v13, "hasRequestBody":Z
    :goto_3
    invoke-interface/range {p1 .. p1}, Lokhttp3/Interceptor$Chain;->connection()Lokhttp3/Connection;

    move-result-object v7

    .line 166
    .local v7, "connection":Lokhttp3/Connection;
    if-eqz v7, :cond_a

    invoke-interface {v7}, Lokhttp3/Connection;->protocol()Lokhttp3/Protocol;

    move-result-object v21

    .line 167
    .local v21, "protocol":Lokhttp3/Protocol;
    :goto_4
    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "--> "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const/16 v33, 0x20

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->url()Lokhttp3/HttpUrl;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v32

    const/16 v33, 0x20

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 168
    .local v24, "requestStartMessage":Ljava/lang/String;
    if-nez v19, :cond_3

    if-eqz v13, :cond_3

    .line 169
    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v32

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " ("

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v34

    move-object/from16 v0, v32

    move-wide/from16 v1, v34

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, "-byte body)"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 171
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    move-object/from16 v0, v32

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 173
    if-eqz v19, :cond_d

    .line 174
    if-eqz v13, :cond_5

    .line 177
    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentType()Lokhttp3/MediaType;

    move-result-object v32

    if-eqz v32, :cond_4

    .line 178
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "Content-Type: "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentType()Lokhttp3/MediaType;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 180
    :cond_4
    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v32

    const-wide/16 v34, -0x1

    cmp-long v32, v32, v34

    if-eqz v32, :cond_5

    .line 181
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "Content-Length: "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v34

    invoke-virtual/range {v33 .. v35}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 185
    :cond_5
    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->headers()Lokhttp3/Headers;

    move-result-object v15

    .line 186
    .local v15, "headers":Lokhttp3/Headers;
    const/16 v16, 0x0

    .local v16, "i":I
    invoke-virtual {v15}, Lokhttp3/Headers;->size()I

    move-result v11

    .local v11, "count":I
    :goto_5
    move/from16 v0, v16

    if-ge v0, v11, :cond_b

    .line 187
    invoke-virtual/range {v15 .. v16}, Lokhttp3/Headers;->name(I)Ljava/lang/String;

    move-result-object v20

    .line 189
    .local v20, "name":Ljava/lang/String;
    const-string v32, "Content-Type"

    move-object/from16 v0, v32

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v32

    if-nez v32, :cond_6

    const-string v32, "Content-Length"

    move-object/from16 v0, v32

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v32

    if-nez v32, :cond_6

    .line 190
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v33

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, ": "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v15 .. v16}, Lokhttp3/Headers;->value(I)Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 186
    :cond_6
    add-int/lit8 v16, v16, 0x1

    goto :goto_5

    .line 159
    .end local v7    # "connection":Lokhttp3/Connection;
    .end local v11    # "count":I
    .end local v13    # "hasRequestBody":Z
    .end local v15    # "headers":Lokhttp3/Headers;
    .end local v16    # "i":I
    .end local v18    # "logBody":Z
    .end local v19    # "logHeaders":Z
    .end local v20    # "name":Ljava/lang/String;
    .end local v21    # "protocol":Lokhttp3/Protocol;
    .end local v23    # "requestBody":Lokhttp3/RequestBody;
    .end local v24    # "requestStartMessage":Ljava/lang/String;
    :cond_7
    const/16 v18, 0x0

    goto/16 :goto_1

    .line 160
    .restart local v18    # "logBody":Z
    :cond_8
    const/16 v19, 0x0

    goto/16 :goto_2

    .line 163
    .restart local v19    # "logHeaders":Z
    .restart local v23    # "requestBody":Lokhttp3/RequestBody;
    :cond_9
    const/4 v13, 0x0

    goto/16 :goto_3

    .line 166
    .restart local v7    # "connection":Lokhttp3/Connection;
    .restart local v13    # "hasRequestBody":Z
    :cond_a
    sget-object v21, Lokhttp3/Protocol;->HTTP_1_1:Lokhttp3/Protocol;

    goto/16 :goto_4

    .line 194
    .restart local v11    # "count":I
    .restart local v15    # "headers":Lokhttp3/Headers;
    .restart local v16    # "i":I
    .restart local v21    # "protocol":Lokhttp3/Protocol;
    .restart local v24    # "requestStartMessage":Ljava/lang/String;
    :cond_b
    if-eqz v18, :cond_c

    if-eqz v13, :cond_c

    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v32

    move-object/from16 v0, p0

    move-wide/from16 v1, v32

    invoke-direct {v0, v1, v2}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->isContentLengthTooLarge(J)Z

    move-result v32

    if-eqz v32, :cond_e

    .line 195
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "--> END "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 225
    .end local v11    # "count":I
    .end local v15    # "headers":Lokhttp3/Headers;
    .end local v16    # "i":I
    :cond_d
    :goto_6
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v28

    .line 228
    .local v28, "startNs":J
    :try_start_0
    move-object/from16 v0, p1

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Lokhttp3/Interceptor$Chain;->proceed(Lokhttp3/Request;)Lokhttp3/Response;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v25

    .line 233
    .local v25, "response":Lokhttp3/Response;
    sget-object v32, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v34

    sub-long v34, v34, v28

    move-object/from16 v0, v32

    move-wide/from16 v1, v34

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v30

    .line 235
    .local v30, "tookMs":J
    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v26

    .line 236
    .local v26, "responseBody":Lokhttp3/ResponseBody;
    if-eqz v26, :cond_12

    const/4 v14, 0x1

    .line 238
    .local v14, "hasResponseBody":Z
    :goto_7
    if-eqz v14, :cond_13

    invoke-virtual/range {v26 .. v26}, Lokhttp3/ResponseBody;->contentLength()J

    move-result-wide v8

    .line 239
    .local v8, "contentLength":J
    :goto_8
    const-wide/16 v32, -0x1

    cmp-long v32, v8, v32

    if-eqz v32, :cond_14

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v32

    invoke-virtual {v0, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, "-byte"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 240
    .local v4, "bodySize":Ljava/lang/String;
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v33, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "<-- "

    move-object/from16 v0, v32

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->code()I

    move-result v34

    move-object/from16 v0, v32

    move/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const/16 v34, 0x20

    move-object/from16 v0, v32

    move/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->message()Ljava/lang/String;

    move-result-object v34

    move-object/from16 v0, v32

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const/16 v34, 0x20

    move-object/from16 v0, v32

    move/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v32

    .line 241
    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->request()Lokhttp3/Request;

    move-result-object v34

    invoke-virtual/range {v34 .. v34}, Lokhttp3/Request;->url()Lokhttp3/HttpUrl;

    move-result-object v34

    move-object/from16 v0, v32

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v34, " ("

    move-object/from16 v0, v32

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-wide/from16 v1, v30

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v34, "ms"

    move-object/from16 v0, v32

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    if-nez v19, :cond_15

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v35, ", "

    move-object/from16 v0, v32

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v35, " body"

    move-object/from16 v0, v32

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    :goto_a
    move-object/from16 v0, v34

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const/16 v34, 0x29

    move-object/from16 v0, v32

    move/from16 v1, v34

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    .line 240
    move-object/from16 v0, v33

    move-object/from16 v1, v32

    invoke-interface {v0, v1}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 244
    if-eqz v19, :cond_0

    .line 245
    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->headers()Lokhttp3/Headers;

    move-result-object v15

    .line 246
    .restart local v15    # "headers":Lokhttp3/Headers;
    const/16 v16, 0x0

    .restart local v16    # "i":I
    invoke-virtual {v15}, Lokhttp3/Headers;->size()I

    move-result v11

    .restart local v11    # "count":I
    :goto_b
    move/from16 v0, v16

    if-ge v0, v11, :cond_16

    .line 247
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {v15 .. v16}, Lokhttp3/Headers;->name(I)Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, ": "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v15 .. v16}, Lokhttp3/Headers;->value(I)Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 246
    add-int/lit8 v16, v16, 0x1

    goto :goto_b

    .line 196
    .end local v4    # "bodySize":Ljava/lang/String;
    .end local v8    # "contentLength":J
    .end local v14    # "hasResponseBody":Z
    .end local v25    # "response":Lokhttp3/Response;
    .end local v26    # "responseBody":Lokhttp3/ResponseBody;
    .end local v28    # "startNs":J
    .end local v30    # "tookMs":J
    :cond_e
    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->headers()Lokhttp3/Headers;

    move-result-object v32

    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->bodyEncoded(Lokhttp3/Headers;)Z

    move-result v32

    if-eqz v32, :cond_f

    .line 197
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "--> END "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, " (encoded body omitted)"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_6

    .line 200
    :cond_f
    :try_start_1
    new-instance v5, Lokio/Buffer;

    invoke-direct {v5}, Lokio/Buffer;-><init>()V

    .line 201
    .local v5, "buffer":Lokio/Buffer;
    move-object/from16 v0, v23

    invoke-virtual {v0, v5}, Lokhttp3/RequestBody;->writeTo(Lokio/BufferedSink;)V

    .line 203
    sget-object v6, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->UTF8:Ljava/nio/charset/Charset;

    .line 204
    .local v6, "charset":Ljava/nio/charset/Charset;
    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentType()Lokhttp3/MediaType;

    move-result-object v10

    .line 205
    .local v10, "contentType":Lokhttp3/MediaType;
    if-eqz v10, :cond_10

    .line 206
    sget-object v32, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->UTF8:Ljava/nio/charset/Charset;

    move-object/from16 v0, v32

    invoke-virtual {v10, v0}, Lokhttp3/MediaType;->charset(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;

    move-result-object v6

    .line 209
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, ""

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 210
    invoke-static {v5}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->isPlaintext(Lokio/Buffer;)Z

    move-result v32

    if-eqz v32, :cond_11

    .line 211
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    invoke-virtual {v5, v6}, Lokio/Buffer;->readString(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 212
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "--> END "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, " ("

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    .line 213
    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v34

    invoke-virtual/range {v33 .. v35}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, "-byte body)"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    .line 212
    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_6

    .line 218
    .end local v5    # "buffer":Lokio/Buffer;
    .end local v6    # "charset":Ljava/nio/charset/Charset;
    .end local v10    # "contentType":Lokhttp3/MediaType;
    :catch_0
    move-exception v12

    .line 220
    .local v12, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "--> END "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_6

    .line 215
    .end local v12    # "e":Ljava/lang/Exception;
    .restart local v5    # "buffer":Lokio/Buffer;
    .restart local v6    # "charset":Ljava/nio/charset/Charset;
    .restart local v10    # "contentType":Lokhttp3/MediaType;
    :cond_11
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "--> END "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v22 .. v22}, Lokhttp3/Request;->method()Ljava/lang/String;

    move-result-object v34

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, " (binary "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    .line 216
    invoke-virtual/range {v23 .. v23}, Lokhttp3/RequestBody;->contentLength()J

    move-result-wide v34

    invoke-virtual/range {v33 .. v35}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, "-byte body omitted)"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    .line 215
    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_6

    .line 229
    .end local v5    # "buffer":Lokio/Buffer;
    .end local v6    # "charset":Ljava/nio/charset/Charset;
    .end local v10    # "contentType":Lokhttp3/MediaType;
    .end local v11    # "count":I
    .end local v15    # "headers":Lokhttp3/Headers;
    .end local v16    # "i":I
    .restart local v28    # "startNs":J
    :catch_1
    move-exception v12

    .line 230
    .restart local v12    # "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "<-- HTTP FAILED: "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    move-object/from16 v0, v33

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 231
    throw v12

    .line 236
    .end local v12    # "e":Ljava/lang/Exception;
    .restart local v25    # "response":Lokhttp3/Response;
    .restart local v26    # "responseBody":Lokhttp3/ResponseBody;
    .restart local v30    # "tookMs":J
    :cond_12
    const/4 v14, 0x0

    goto/16 :goto_7

    .line 238
    .restart local v14    # "hasResponseBody":Z
    :cond_13
    const-wide/16 v8, 0x0

    goto/16 :goto_8

    .line 239
    .restart local v8    # "contentLength":J
    :cond_14
    const-string v4, "unknown-length"

    goto/16 :goto_9

    .line 241
    .restart local v4    # "bodySize":Ljava/lang/String;
    :cond_15
    const-string v32, ""

    goto/16 :goto_a

    .line 250
    .restart local v11    # "count":I
    .restart local v15    # "headers":Lokhttp3/Headers;
    .restart local v16    # "i":I
    :cond_16
    if-eqz v18, :cond_17

    invoke-static/range {v25 .. v25}, Lokhttp3/internal/http/HttpHeaders;->hasBody(Lokhttp3/Response;)Z

    move-result v32

    if-eqz v32, :cond_17

    if-eqz v14, :cond_17

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v9}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->isContentLengthTooLarge(J)Z

    move-result v32

    if-eqz v32, :cond_18

    .line 251
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, "<-- END HTTP"

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 252
    :cond_18
    invoke-virtual/range {v25 .. v25}, Lokhttp3/Response;->headers()Lokhttp3/Headers;

    move-result-object v32

    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-direct {v0, v1}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->bodyEncoded(Lokhttp3/Headers;)Z

    move-result v32

    if-eqz v32, :cond_19

    .line 253
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, "<-- END HTTP (encoded body omitted)"

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 256
    :cond_19
    :try_start_3
    invoke-virtual/range {v26 .. v26}, Lokhttp3/ResponseBody;->source()Lokio/BufferedSource;

    move-result-object v27

    .line 257
    .local v27, "source":Lokio/BufferedSource;
    const-wide v32, 0x7fffffffffffffffL

    move-object/from16 v0, v27

    move-wide/from16 v1, v32

    invoke-interface {v0, v1, v2}, Lokio/BufferedSource;->request(J)Z

    .line 258
    invoke-interface/range {v27 .. v27}, Lokio/BufferedSource;->buffer()Lokio/Buffer;

    move-result-object v5

    .line 260
    .restart local v5    # "buffer":Lokio/Buffer;
    sget-object v6, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->UTF8:Ljava/nio/charset/Charset;

    .line 261
    .restart local v6    # "charset":Ljava/nio/charset/Charset;
    invoke-virtual/range {v26 .. v26}, Lokhttp3/ResponseBody;->contentType()Lokhttp3/MediaType;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v10

    .line 262
    .restart local v10    # "contentType":Lokhttp3/MediaType;
    if-eqz v10, :cond_1a

    .line 264
    :try_start_4
    sget-object v32, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->UTF8:Ljava/nio/charset/Charset;

    move-object/from16 v0, v32

    invoke-virtual {v10, v0}, Lokhttp3/MediaType;->charset(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    :try_end_4
    .catch Ljava/nio/charset/UnsupportedCharsetException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    move-result-object v6

    .line 274
    :cond_1a
    :try_start_5
    invoke-static {v5}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->isPlaintext(Lokio/Buffer;)Z

    move-result v32

    if-nez v32, :cond_1b

    .line 275
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, ""

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 276
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "<-- END HTTP (binary "

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual {v5}, Lokio/Buffer;->size()J

    move-result-wide v34

    invoke-virtual/range {v33 .. v35}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, "-byte body omitted)"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    goto/16 :goto_0

    .line 286
    .end local v5    # "buffer":Lokio/Buffer;
    .end local v6    # "charset":Ljava/nio/charset/Charset;
    .end local v10    # "contentType":Lokhttp3/MediaType;
    .end local v27    # "source":Lokio/BufferedSource;
    :catch_2
    move-exception v12

    .line 288
    .restart local v12    # "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, "<-- END HTTP"

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 265
    .end local v12    # "e":Ljava/lang/Exception;
    .restart local v5    # "buffer":Lokio/Buffer;
    .restart local v6    # "charset":Ljava/nio/charset/Charset;
    .restart local v10    # "contentType":Lokhttp3/MediaType;
    .restart local v27    # "source":Lokio/BufferedSource;
    :catch_3
    move-exception v12

    .line 266
    .local v12, "e":Ljava/nio/charset/UnsupportedCharsetException;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, ""

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 267
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, "Couldn\'t decode the response body; charset is likely malformed."

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 268
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, "<-- END HTTP"

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 280
    .end local v12    # "e":Ljava/nio/charset/UnsupportedCharsetException;
    :cond_1b
    const-wide/16 v32, 0x0

    cmp-long v32, v8, v32

    if-eqz v32, :cond_1c

    .line 281
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    const-string v33, ""

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 282
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    invoke-virtual {v5}, Lokio/Buffer;->clone()Lokio/Buffer;

    move-result-object v33

    move-object/from16 v0, v33

    invoke-virtual {v0, v6}, Lokio/Buffer;->readString(Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V

    .line 285
    :cond_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->logger:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;

    move-object/from16 v32, v0

    new-instance v33, Ljava/lang/StringBuilder;

    invoke-direct/range {v33 .. v33}, Ljava/lang/StringBuilder;-><init>()V

    const-string v34, "<-- END HTTP ("

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual {v5}, Lokio/Buffer;->size()J

    move-result-wide v34

    invoke-virtual/range {v33 .. v35}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v33

    const-string v34, "-byte body)"

    invoke-virtual/range {v33 .. v34}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-interface/range {v32 .. v33}, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger;->log(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    goto/16 :goto_0
.end method

.method public setLevel(Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;)Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;
    .locals 2
    .param p1, "level"    # Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    .prologue
    .line 141
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "level == null. Use Level.NONE instead."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 142
    :cond_0
    iput-object p1, p0, Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor;->level:Lcom/tencent/qcloud/core/http/HttpLoggingInterceptor$Level;

    .line 143
    return-object p0
.end method
