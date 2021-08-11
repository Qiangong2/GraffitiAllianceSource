.class public Lcom/tencent/cos/xml/utils/FileUtils;
.super Ljava/lang/Object;
.source "FileUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static tempCache(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 9
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 24
    if-nez p0, :cond_0

    const/4 v6, 0x0

    .line 44
    :goto_0
    return-object v6

    .line 25
    :cond_0
    const/4 v2, 0x0

    .line 28
    .local v2, "fileOutputStream":Ljava/io/FileOutputStream;
    :try_start_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/tencent/cos/xml/CosXmlSimpleService;->appCachePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "temp.tmp"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 29
    .local v6, "tempPath":Ljava/lang/String;
    const-string v7, "UnitTest"

    invoke-static {v7, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 30
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 31
    .local v5, "tempFile":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    .line 32
    :cond_1
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 33
    .end local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    .local v3, "fileOutputStream":Ljava/io/FileOutputStream;
    const/high16 v7, 0x10000

    :try_start_1
    new-array v0, v7, [B

    .line 34
    .local v0, "buffer":[B
    const/4 v4, -0x1

    .line 35
    .local v4, "receiveLen":I
    :goto_1
    const/4 v7, 0x0

    array-length v8, v0

    invoke-virtual {p0, v0, v7, v8}, Ljava/io/InputStream;->read([BII)I

    move-result v4

    if-lez v4, :cond_2

    .line 36
    const/4 v7, 0x0

    invoke-virtual {v3, v0, v7, v4}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 40
    .end local v0    # "buffer":[B
    .end local v4    # "receiveLen":I
    :catch_0
    move-exception v1

    move-object v2, v3

    .line 41
    .end local v3    # "fileOutputStream":Ljava/io/FileOutputStream;
    .end local v5    # "tempFile":Ljava/io/File;
    .end local v6    # "tempPath":Ljava/lang/String;
    .local v1, "e":Ljava/io/IOException;
    .restart local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    :goto_2
    :try_start_2
    new-instance v7, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v7, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 43
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    :goto_3
    invoke-static {v2}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    .line 44
    invoke-static {p0}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    throw v7

    .line 38
    .end local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    .restart local v0    # "buffer":[B
    .restart local v3    # "fileOutputStream":Ljava/io/FileOutputStream;
    .restart local v4    # "receiveLen":I
    .restart local v5    # "tempFile":Ljava/io/File;
    .restart local v6    # "tempPath":Ljava/lang/String;
    :cond_2
    :try_start_3
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 43
    invoke-static {v3}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    .line 44
    invoke-static {p0}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    goto :goto_0

    .line 43
    .end local v0    # "buffer":[B
    .end local v4    # "receiveLen":I
    :catchall_1
    move-exception v7

    move-object v2, v3

    .end local v3    # "fileOutputStream":Ljava/io/FileOutputStream;
    .restart local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    goto :goto_3

    .line 40
    .end local v5    # "tempFile":Ljava/io/File;
    .end local v6    # "tempPath":Ljava/lang/String;
    :catch_1
    move-exception v1

    goto :goto_2
.end method
