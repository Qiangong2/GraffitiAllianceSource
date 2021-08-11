.class public Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;
.super Ljava/lang/Object;
.source "SRTTAPIHTTPTaskQueueImp.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;
    }
.end annotation


# static fields
.field private static LOGTAG:Ljava/lang/String;

.field private static apiAddr:Ljava/lang/String;

.field private static apiKey:Ljava/lang/String;


# instance fields
.field private taskQueue:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;",
            ">;"
        }
    .end annotation
.end field

.field private timestampArg:Ljava/lang/String;

.field private workThread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-string v0, "GCloudVoiceTag"

    sput-object v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->LOGTAG:Ljava/lang/String;

    .line 34
    const-string v0, "http://api.pr.weixin.qq.com/cgi-bin/wxvoicereco"

    sput-object v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiAddr:Ljava/lang/String;

    .line 35
    const-string v0, "wxk158ztg8lli234j"

    sput-object v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiKey:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 354
    return-void
.end method

.method static synthetic access$000(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;)Ljava/util/LinkedList;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->taskQueue:Ljava/util/LinkedList;

    return-object v0
.end method

.method static synthetic access$100(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;I)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->dealStartTask(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->dealVoiceTask(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V

    return-void
.end method

.method static synthetic access$300(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->dealStopTask(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V

    return-void
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->LOGTAG:Ljava/lang/String;

    return-object v0
.end method

.method public static native callback(I[BI)V
.end method

.method private dealStartTask(I)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 62
    .line 64
    :try_start_0
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiAddr:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "?cmd=1&appid="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiKey:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 71
    :try_start_1
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 79
    :try_start_2
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/net/ProtocolException; {:try_start_2 .. :try_end_2} :catch_3

    .line 85
    :goto_0
    const-string v1, "Content-Type"

    const-string v3, "text/html"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    :try_start_3
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    move-result v1

    .line 96
    :goto_1
    :try_start_4
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_6

    .line 108
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 109
    const/16 v4, 0x400

    new-array v4, v4, [B

    .line 112
    :goto_2
    :try_start_5
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    .line 113
    const/4 v6, 0x0

    invoke-virtual {v3, v4, v6, v5}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_2

    .line 115
    :catch_0
    move-exception v0

    .line 117
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 132
    :goto_3
    return-void

    .line 65
    :catch_1
    move-exception v0

    .line 67
    invoke-virtual {v0}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_3

    .line 72
    :catch_2
    move-exception v0

    .line 74
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 80
    :catch_3
    move-exception v1

    .line 82
    invoke-virtual {v1}, Ljava/net/ProtocolException;->printStackTrace()V

    goto :goto_0

    .line 89
    :catch_4
    move-exception v1

    .line 91
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    move v1, v2

    goto :goto_1

    .line 97
    :catch_5
    move-exception v0

    .line 98
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 101
    :catch_6
    move-exception v0

    .line 103
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 122
    :cond_0
    :try_start_6
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 123
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 124
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_7

    .line 131
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    invoke-static {v1, v0, p1}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->callback(I[BI)V

    goto :goto_3

    .line 125
    :catch_7
    move-exception v0

    .line 126
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3
.end method

.method private dealStopTask(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 137
    .line 139
    :try_start_0
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiAddr:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "?platform=android&cmd=6&appid="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiKey:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "&voice_id="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->key:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 146
    :try_start_1
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 154
    :try_start_2
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/net/ProtocolException; {:try_start_2 .. :try_end_2} :catch_3

    .line 159
    :goto_0
    const-string v1, "Content-Type"

    const-string v3, "application/octet-stream"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    const-string v1, "Connection"

    const-string v3, "keep-alive"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    const-string v1, "Accept-Language"

    const-string v3, "zh-CN"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    :try_start_3
    new-instance v1, Ljava/io/BufferedOutputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    .line 186
    :try_start_4
    iget-object v3, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->body:[B

    invoke-virtual {v1, v3}, Ljava/io/OutputStream;->write([B)V

    .line 187
    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V

    .line 188
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_5

    .line 197
    :goto_1
    :try_start_5
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_6

    move-result v1

    .line 205
    :goto_2
    :try_start_6
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_6
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_7
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_8

    .line 217
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 218
    const/16 v4, 0x400

    new-array v4, v4, [B

    .line 221
    :goto_3
    :try_start_7
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    .line 222
    const/4 v6, 0x0

    invoke-virtual {v3, v4, v6, v5}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    goto :goto_3

    .line 224
    :catch_0
    move-exception v0

    .line 226
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 242
    :goto_4
    return-void

    .line 140
    :catch_1
    move-exception v0

    .line 142
    invoke-virtual {v0}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_4

    .line 147
    :catch_2
    move-exception v0

    .line 149
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 155
    :catch_3
    move-exception v1

    .line 157
    invoke-virtual {v1}, Ljava/net/ProtocolException;->printStackTrace()V

    goto :goto_0

    .line 167
    :catch_4
    move-exception v0

    .line 169
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 189
    :catch_5
    move-exception v1

    .line 191
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 198
    :catch_6
    move-exception v1

    .line 200
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    move v1, v2

    goto :goto_2

    .line 206
    :catch_7
    move-exception v0

    .line 207
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 210
    :catch_8
    move-exception v0

    .line 212
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 231
    :cond_0
    :try_start_8
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 232
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 233
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_9

    .line 240
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    iget v2, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->session:I

    invoke-static {v1, v0, v2}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->callback(I[BI)V

    goto :goto_4

    .line 234
    :catch_9
    move-exception v0

    .line 235
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4
.end method

.method private dealVoiceTask(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 247
    .line 249
    :try_start_0
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiAddr:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "?platform=android&cmd=6&appid="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->apiKey:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "&voice_id="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->key:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 256
    :try_start_1
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 264
    :try_start_2
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/net/ProtocolException; {:try_start_2 .. :try_end_2} :catch_3

    .line 269
    :goto_0
    const-string v1, "Content-Type"

    const-string v3, "application/octet-stream"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    const-string v1, "Connection"

    const-string v3, "keep-alive"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 271
    const-string v1, "Accept-Language"

    const-string v3, "zh-CN"

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    :try_start_3
    new-instance v1, Ljava/io/BufferedOutputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    .line 296
    :try_start_4
    iget-object v3, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->body:[B

    invoke-virtual {v1, v3}, Ljava/io/OutputStream;->write([B)V

    .line 297
    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V

    .line 298
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_5

    .line 307
    :goto_1
    :try_start_5
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_6

    move-result v1

    .line 315
    :goto_2
    :try_start_6
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_6
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_7
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_8

    .line 327
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 328
    const/16 v4, 0x400

    new-array v4, v4, [B

    .line 331
    :goto_3
    :try_start_7
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    .line 332
    const/4 v6, 0x0

    invoke-virtual {v3, v4, v6, v5}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    goto :goto_3

    .line 334
    :catch_0
    move-exception v0

    .line 336
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 352
    :goto_4
    return-void

    .line 250
    :catch_1
    move-exception v0

    .line 252
    invoke-virtual {v0}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_4

    .line 257
    :catch_2
    move-exception v0

    .line 259
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 265
    :catch_3
    move-exception v1

    .line 267
    invoke-virtual {v1}, Ljava/net/ProtocolException;->printStackTrace()V

    goto :goto_0

    .line 277
    :catch_4
    move-exception v0

    .line 279
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 299
    :catch_5
    move-exception v1

    .line 301
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 308
    :catch_6
    move-exception v1

    .line 310
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    move v1, v2

    goto :goto_2

    .line 316
    :catch_7
    move-exception v0

    .line 317
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 320
    :catch_8
    move-exception v0

    .line 322
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 341
    :cond_0
    :try_start_8
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 342
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 343
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_9

    .line 350
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    iget v2, p1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->session:I

    invoke-static {v1, v0, v2}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->callback(I[BI)V

    goto :goto_4

    .line 344
    :catch_9
    move-exception v0

    .line 345
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4
.end method


# virtual methods
.method public declared-synchronized addTask(IILjava/lang/String;[BI)V
    .locals 2

    .prologue
    .line 49
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;

    invoke-direct {v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;-><init>()V

    .line 50
    iput p1, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->type:I

    .line 51
    iput-object p4, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->body:[B

    .line 52
    iput-object p3, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->key:Ljava/lang/String;

    .line 53
    iput p2, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->method:I

    .line 54
    iput p5, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->session:I

    .line 55
    iget-object v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->taskQueue:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->offer(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 57
    monitor-exit p0

    return-void

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public init()V
    .locals 2

    .prologue
    .line 41
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->taskQueue:Ljava/util/LinkedList;

    .line 43
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;

    invoke-direct {v1, p0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;-><init>(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->workThread:Ljava/lang/Thread;

    .line 44
    iget-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->workThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 45
    return-void
.end method
