.class public Lcom/tencent/cos/xml/utils/DigestUtils;
.super Ljava/lang/Object;
.source "DigestUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getHmacSha1(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 108
    :try_start_0
    const-string v5, "UTF-8"

    invoke-static {v5}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    .line 109
    .local v0, "byteKey":[B
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    const-string v5, "HmacSHA1"

    invoke-direct {v2, v0, v5}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 110
    .local v2, "hmacKey":Ljavax/crypto/SecretKey;
    const-string v5, "HmacSHA1"

    invoke-static {v5}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v4

    .line 111
    .local v4, "mac":Ljavax/crypto/Mac;
    invoke-virtual {v4, v2}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 112
    const-string v5, "UTF-8"

    .line 113
    invoke-static {v5}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v5

    .line 112
    invoke-virtual {p0, v5}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v5

    invoke-virtual {v4, v5}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v5

    invoke-static {v5}, Lcom/tencent/cos/xml/utils/StringUtils;->toHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 119
    .local v3, "hmacSha1":Ljava/lang/String;
    return-object v3

    .line 114
    .end local v0    # "byteKey":[B
    .end local v2    # "hmacKey":Ljavax/crypto/SecretKey;
    .end local v3    # "hmacSha1":Ljava/lang/String;
    .end local v4    # "mac":Ljavax/crypto/Mac;
    :catch_0
    move-exception v1

    .line 115
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v5, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v5, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 116
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v1

    .line 117
    .local v1, "e":Ljava/security/InvalidKeyException;
    new-instance v5, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v5, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v5
.end method

.method public static getMD5(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "filePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 25
    if-nez p0, :cond_0

    new-instance v8, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v9, "file Path is null"

    invoke-direct {v8, v9}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 26
    :cond_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 27
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_1

    new-instance v8, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v9, "file Path is not exist"

    invoke-direct {v8, v9}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 29
    :cond_1
    const/4 v3, 0x0

    .line 31
    .local v3, "fileInputStream":Ljava/io/FileInputStream;
    :try_start_0
    const-string v8, "MD5"

    invoke-static {v8}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v7

    .line 32
    .local v7, "messageDigest":Ljava/security/MessageDigest;
    new-instance v4, Ljava/io/FileInputStream;

    invoke-direct {v4, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 33
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .local v4, "fileInputStream":Ljava/io/FileInputStream;
    const v8, 0x8000

    :try_start_1
    new-array v0, v8, [B

    .line 34
    .local v0, "buffer":[B
    const/4 v5, -0x1

    .line 35
    .local v5, "len":I
    :goto_0
    invoke-virtual {v4, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v5

    const/4 v8, -0x1

    if-eq v5, v8, :cond_2

    .line 36
    const/4 v8, 0x0

    invoke-virtual {v7, v0, v8, v5}, Ljava/security/MessageDigest;->update([BII)V
    :try_end_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 39
    .end local v0    # "buffer":[B
    .end local v5    # "len":I
    :catch_0
    move-exception v1

    move-object v3, v4

    .line 40
    .end local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .end local v7    # "messageDigest":Ljava/security/MessageDigest;
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    :goto_1
    :try_start_2
    new-instance v8, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v8, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 46
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catchall_0
    move-exception v8

    :goto_2
    invoke-static {v3}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    throw v8

    .line 38
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v0    # "buffer":[B
    .restart local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v5    # "len":I
    .restart local v7    # "messageDigest":Ljava/security/MessageDigest;
    :cond_2
    :try_start_3
    invoke-virtual {v7}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v8

    invoke-static {v8}, Lcom/tencent/cos/xml/utils/StringUtils;->toHexString([B)Ljava/lang/String;
    :try_end_3
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v6

    .line 46
    .local v6, "md5":Ljava/lang/String;
    invoke-static {v4}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    .line 48
    return-object v6

    .line 41
    .end local v0    # "buffer":[B
    .end local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .end local v5    # "len":I
    .end local v6    # "md5":Ljava/lang/String;
    .end local v7    # "messageDigest":Ljava/security/MessageDigest;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_1
    move-exception v1

    .line 42
    .local v1, "e":Ljava/io/FileNotFoundException;
    :goto_3
    :try_start_4
    new-instance v8, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v8, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v8

    .line 43
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    :catch_2
    move-exception v1

    .line 44
    .local v1, "e":Ljava/io/IOException;
    :goto_4
    new-instance v8, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v8, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 46
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v7    # "messageDigest":Ljava/security/MessageDigest;
    :catchall_1
    move-exception v8

    move-object v3, v4

    .end local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_2

    .line 43
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v4    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_3
    move-exception v1

    move-object v3, v4

    .end local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_4

    .line 41
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v4    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_4
    move-exception v1

    move-object v3, v4

    .end local v4    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_3

    .line 39
    .end local v7    # "messageDigest":Ljava/security/MessageDigest;
    :catch_5
    move-exception v1

    goto :goto_1
.end method

.method public static getSHA1FromBytes([BII)Ljava/lang/String;
    .locals 5
    .param p0, "data"    # [B
    .param p1, "offset"    # I
    .param p2, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 89
    if-eqz p0, :cond_0

    if-lez p2, :cond_0

    if-gez p1, :cond_1

    .line 90
    :cond_0
    new-instance v3, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v4, "data == null | len <= 0 |offset < 0 |offset >= len"

    invoke-direct {v3, v4}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 94
    :cond_1
    :try_start_0
    const-string v3, "SHA-1"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 95
    .local v1, "messageDigest":Ljava/security/MessageDigest;
    invoke-virtual {v1, p0, p1, p2}, Ljava/security/MessageDigest;->update([BII)V

    .line 96
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    invoke-static {v3}, Lcom/tencent/cos/xml/utils/StringUtils;->toHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 102
    .local v2, "sha1":Ljava/lang/String;
    return-object v2

    .line 97
    .end local v1    # "messageDigest":Ljava/security/MessageDigest;
    .end local v2    # "sha1":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 98
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v3, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v3, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 99
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 100
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    new-instance v3, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v3, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public static getSHA1FromPath(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "filePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 65
    const/4 v2, 0x0

    .line 67
    .local v2, "fileInputStream":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, p0}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    .end local v2    # "fileInputStream":Ljava/io/FileInputStream;
    .local v3, "fileInputStream":Ljava/io/FileInputStream;
    :try_start_1
    const-string v7, "SHA-1"

    invoke-static {v7}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v5

    .line 69
    .local v5, "messageDigest":Ljava/security/MessageDigest;
    const/high16 v7, 0x10000

    new-array v0, v7, [B

    .line 71
    .local v0, "buffer":[B
    :goto_0
    const/4 v7, 0x0

    array-length v8, v0

    invoke-virtual {v3, v0, v7, v8}, Ljava/io/FileInputStream;->read([BII)I

    move-result v4

    .local v4, "len":I
    const/4 v7, -0x1

    if-eq v4, v7, :cond_0

    .line 72
    const/4 v7, 0x0

    invoke-virtual {v5, v0, v7, v4}, Ljava/security/MessageDigest;->update([BII)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 75
    .end local v0    # "buffer":[B
    .end local v4    # "len":I
    .end local v5    # "messageDigest":Ljava/security/MessageDigest;
    :catch_0
    move-exception v1

    move-object v2, v3

    .line 76
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .local v1, "e":Ljava/io/FileNotFoundException;
    .restart local v2    # "fileInputStream":Ljava/io/FileInputStream;
    :goto_1
    :try_start_2
    new-instance v7, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v7, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 82
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    :catchall_0
    move-exception v7

    :goto_2
    invoke-static {v2}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    throw v7

    .line 74
    .end local v2    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v0    # "buffer":[B
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v4    # "len":I
    .restart local v5    # "messageDigest":Ljava/security/MessageDigest;
    :cond_0
    :try_start_3
    invoke-virtual {v5}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v7

    invoke-static {v7}, Lcom/tencent/cos/xml/utils/StringUtils;->toHexString([B)Ljava/lang/String;
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v6

    .line 82
    .local v6, "sha1":Ljava/lang/String;
    invoke-static {v3}, Lcom/tencent/cos/xml/utils/CloseUtil;->closeQuietly(Ljava/io/Closeable;)V

    .line 84
    return-object v6

    .line 77
    .end local v0    # "buffer":[B
    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .end local v4    # "len":I
    .end local v5    # "messageDigest":Ljava/security/MessageDigest;
    .end local v6    # "sha1":Ljava/lang/String;
    .restart local v2    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_1
    move-exception v1

    .line 78
    .local v1, "e":Ljava/io/IOException;
    :goto_3
    :try_start_4
    new-instance v7, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v7, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v7

    .line 79
    .end local v1    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 80
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    :goto_4
    new-instance v7, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v7, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 82
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    .end local v2    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v7

    move-object v2, v3

    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v2    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_2

    .line 79
    .end local v2    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_3
    move-exception v1

    move-object v2, v3

    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v2    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_4

    .line 77
    .end local v2    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v3    # "fileInputStream":Ljava/io/FileInputStream;
    :catch_4
    move-exception v1

    move-object v2, v3

    .end local v3    # "fileInputStream":Ljava/io/FileInputStream;
    .restart local v2    # "fileInputStream":Ljava/io/FileInputStream;
    goto :goto_3

    .line 75
    :catch_5
    move-exception v1

    goto :goto_1
.end method

.method public static getSha1(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "content"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 54
    :try_start_0
    const-string v3, "SHA-1"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 55
    .local v1, "messageDigest":Ljava/security/MessageDigest;
    const-string v3, "UTF-8"

    .line 56
    invoke-static {v3}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v3

    .line 55
    invoke-virtual {p0, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v3

    invoke-static {v3}, Lcom/tencent/cos/xml/utils/StringUtils;->toHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 60
    .local v2, "sha1":Ljava/lang/String;
    return-object v2

    .line 57
    .end local v1    # "messageDigest":Ljava/security/MessageDigest;
    .end local v2    # "sha1":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 58
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v3, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    invoke-direct {v3, v0}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method
