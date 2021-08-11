.class public Lcom/tencent/qcloud/core/auth/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# static fields
.field private static final DIGITS_LOWER:[C

.field private static final DIGITS_UPPER:[C

.field private static calendar:Ljava/util/Calendar;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/16 v4, 0x10

    .line 26
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    sput-object v0, Lcom/tencent/qcloud/core/auth/Utils;->calendar:Ljava/util/Calendar;

    .line 28
    sget-object v0, Lcom/tencent/qcloud/core/auth/Utils;->calendar:Ljava/util/Calendar;

    const/16 v1, 0x7da

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Calendar;->set(III)V

    .line 37
    new-array v0, v4, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/tencent/qcloud/core/auth/Utils;->DIGITS_LOWER:[C

    .line 38
    new-array v0, v4, [C

    fill-array-data v0, :array_1

    sput-object v0, Lcom/tencent/qcloud/core/auth/Utils;->DIGITS_UPPER:[C

    .line 39
    return-void

    .line 37
    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data

    .line 38
    :array_1
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x41s
        0x42s
        0x43s
        0x44s
        0x45s
        0x46s
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decodeHex(Ljava/lang/String;)[B
    .locals 1
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    invoke-static {v0}, Lcom/tencent/qcloud/core/auth/Utils;->decodeHex([C)[B

    move-result-object v0

    return-object v0
.end method

.method public static decodeHex([C)[B
    .locals 7
    .param p0, "data"    # [C

    .prologue
    .line 46
    array-length v3, p0

    .line 47
    .local v3, "len":I
    and-int/lit8 v5, v3, 0x1

    if-eqz v5, :cond_0

    .line 48
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "Odd number of characters."

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 50
    :cond_0
    shr-int/lit8 v5, v3, 0x1

    new-array v4, v5, [B

    .line 51
    .local v4, "out":[B
    const/4 v1, 0x0

    .line 53
    .local v1, "i":I
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_0
    if-ge v2, v3, :cond_1

    .line 54
    aget-char v5, p0, v2

    invoke-static {v5, v2}, Lcom/tencent/qcloud/core/auth/Utils;->toDigit(CI)I

    move-result v5

    shl-int/lit8 v0, v5, 0x4

    .line 55
    .local v0, "f":I
    add-int/lit8 v2, v2, 0x1

    .line 56
    aget-char v5, p0, v2

    invoke-static {v5, v2}, Lcom/tencent/qcloud/core/auth/Utils;->toDigit(CI)I

    move-result v5

    or-int/2addr v0, v5

    .line 57
    add-int/lit8 v2, v2, 0x1

    .line 58
    and-int/lit16 v5, v0, 0xff

    int-to-byte v5, v5

    aput-byte v5, v4, v1

    .line 53
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 61
    .end local v0    # "f":I
    :cond_1
    return-object v4
.end method

.method public static encodeHex([B)[C
    .locals 1
    .param p0, "data"    # [B

    .prologue
    .line 66
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([BZ)[C

    move-result-object v0

    return-object v0
.end method

.method public static encodeHex([BZ)[C
    .locals 1
    .param p0, "data"    # [B
    .param p1, "toLowerCase"    # Z

    .prologue
    .line 70
    if-eqz p1, :cond_0

    sget-object v0, Lcom/tencent/qcloud/core/auth/Utils;->DIGITS_LOWER:[C

    :goto_0
    invoke-static {p0, v0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([B[C)[C

    move-result-object v0

    return-object v0

    :cond_0
    sget-object v0, Lcom/tencent/qcloud/core/auth/Utils;->DIGITS_UPPER:[C

    goto :goto_0
.end method

.method static encodeHex([B[C)[C
    .locals 6
    .param p0, "data"    # [B
    .param p1, "toDigits"    # [C

    .prologue
    .line 110
    array-length v3, p0

    .line 111
    .local v3, "l":I
    shl-int/lit8 v5, v3, 0x1

    new-array v4, v5, [C

    .line 112
    .local v4, "out":[C
    const/4 v0, 0x0

    .line 114
    .local v0, "i":I
    const/4 v1, 0x0

    .local v1, "j":I
    move v2, v1

    .end local v1    # "j":I
    .local v2, "j":I
    :goto_0
    if-ge v0, v3, :cond_0

    .line 115
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "j":I
    .restart local v1    # "j":I
    aget-byte v5, p0, v0

    and-int/lit16 v5, v5, 0xf0

    ushr-int/lit8 v5, v5, 0x4

    aget-char v5, p1, v5

    aput-char v5, v4, v2

    .line 116
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "j":I
    .restart local v2    # "j":I
    aget-byte v5, p0, v0

    and-int/lit8 v5, v5, 0xf

    aget-char v5, p1, v5

    aput-char v5, v4, v1

    .line 114
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 119
    :cond_0
    return-object v4
.end method

.method public static encodeHexString([B)Ljava/lang/String;
    .locals 2
    .param p0, "data"    # [B

    .prologue
    .line 74
    new-instance v0, Ljava/lang/String;

    invoke-static {p0}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    return-object v0
.end method

.method public static encodeHexString([BZ)Ljava/lang/String;
    .locals 2
    .param p0, "data"    # [B
    .param p1, "toLowerCase"    # Z

    .prologue
    .line 78
    new-instance v0, Ljava/lang/String;

    invoke-static {p0, p1}, Lcom/tencent/qcloud/core/auth/Utils;->encodeHex([BZ)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    return-object v0
.end method

.method static handleTimeAccuracy(J)J
    .locals 2
    .param p0, "time"    # J

    .prologue
    .line 33
    sget-object v0, Lcom/tencent/qcloud/core/auth/Utils;->calendar:Ljava/util/Calendar;

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    cmp-long v0, p0, v0

    if-lez v0, :cond_0

    const-wide/16 v0, 0x3e8

    div-long/2addr p0, v0

    .end local p0    # "time":J
    :cond_0
    return-wide p0
.end method

.method public static hmacSha1(Ljava/lang/String;Ljava/lang/String;)[B
    .locals 7
    .param p0, "source"    # Ljava/lang/String;
    .param p1, "secretKey"    # Ljava/lang/String;

    .prologue
    .line 91
    const-string v0, "HmacSHA1"

    .line 93
    .local v0, "HMAC_ALGORITHM":Ljava/lang/String;
    const/4 v4, 0x0

    .line 95
    .local v4, "hmacSha1":[B
    :try_start_0
    invoke-static {p1}, Lcom/tencent/qcloud/core/util/QCloudStringUtils;->getBytesUTF8(Ljava/lang/String;)[B

    move-result-object v1

    .line 96
    .local v1, "byteKey":[B
    new-instance v3, Ljavax/crypto/spec/SecretKeySpec;

    invoke-direct {v3, v1, v0}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 97
    .local v3, "hmacKey":Ljavax/crypto/SecretKey;
    invoke-static {v0}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v5

    .line 98
    .local v5, "mac":Ljavax/crypto/Mac;
    invoke-virtual {v5, v3}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 99
    invoke-static {p0}, Lcom/tencent/qcloud/core/util/QCloudStringUtils;->getBytesUTF8(Ljava/lang/String;)[B

    move-result-object v6

    invoke-virtual {v5, v6}, Ljavax/crypto/Mac;->doFinal([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v4

    .line 106
    .end local v1    # "byteKey":[B
    .end local v3    # "hmacKey":Ljavax/crypto/SecretKey;
    .end local v5    # "mac":Ljavax/crypto/Mac;
    :goto_0
    return-object v4

    .line 101
    :catch_0
    move-exception v2

    .line 102
    .local v2, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v2}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_0

    .line 103
    .end local v2    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v2

    .line 104
    .local v2, "e":Ljava/security/InvalidKeyException;
    invoke-virtual {v2}, Ljava/security/InvalidKeyException;->printStackTrace()V

    goto :goto_0
.end method

.method public static sha1(Ljava/lang/String;)[B
    .locals 3
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 83
    :try_start_0
    const-string v2, "SHA-1"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 84
    .local v0, "messageDigest":Ljava/security/MessageDigest;
    invoke-static {p0}, Lcom/tencent/qcloud/core/util/QCloudStringUtils;->getBytesUTF8(Ljava/lang/String;)[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/security/MessageDigest;->digest([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 85
    .end local v0    # "messageDigest":Ljava/security/MessageDigest;
    :catch_0
    move-exception v1

    .line 86
    .local v1, "var2":Ljava/security/NoSuchAlgorithmException;
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method static toDigit(CI)I
    .locals 4
    .param p0, "ch"    # C
    .param p1, "index"    # I

    .prologue
    .line 123
    const/16 v1, 0x10

    invoke-static {p0, v1}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 124
    .local v0, "digit":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 125
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Illegal hexadecimal character "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " at index "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 127
    :cond_0
    return v0
.end method
