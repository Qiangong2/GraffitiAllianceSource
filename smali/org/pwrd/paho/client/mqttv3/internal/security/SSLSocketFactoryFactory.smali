.class public Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;
.super Ljava/lang/Object;
.source "SSLSocketFactoryFactory.java"


# static fields
.field public static final CIPHERSUITES:Ljava/lang/String; = "com.ibm.ssl.enabledCipherSuites"

.field private static final CLASS_NAME:Ljava/lang/String; = "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

.field public static final CLIENTAUTH:Ljava/lang/String; = "com.ibm.ssl.clientAuthentication"

.field public static final DEFAULT_PROTOCOL:Ljava/lang/String; = "TLS"

.field public static final JSSEPROVIDER:Ljava/lang/String; = "com.ibm.ssl.contextProvider"

.field public static final KEYSTORE:Ljava/lang/String; = "com.ibm.ssl.keyStore"

.field public static final KEYSTOREMGR:Ljava/lang/String; = "com.ibm.ssl.keyManager"

.field public static final KEYSTOREPROVIDER:Ljava/lang/String; = "com.ibm.ssl.keyStoreProvider"

.field public static final KEYSTOREPWD:Ljava/lang/String; = "com.ibm.ssl.keyStorePassword"

.field public static final KEYSTORETYPE:Ljava/lang/String; = "com.ibm.ssl.keyStoreType"

.field public static final SSLPROTOCOL:Ljava/lang/String; = "com.ibm.ssl.protocol"

.field public static final SYSKEYMGRALGO:Ljava/lang/String; = "ssl.KeyManagerFactory.algorithm"

.field public static final SYSKEYSTORE:Ljava/lang/String; = "javax.net.ssl.keyStore"

.field public static final SYSKEYSTOREPWD:Ljava/lang/String; = "javax.net.ssl.keyStorePassword"

.field public static final SYSKEYSTORETYPE:Ljava/lang/String; = "javax.net.ssl.keyStoreType"

.field public static final SYSTRUSTMGRALGO:Ljava/lang/String; = "ssl.TrustManagerFactory.algorithm"

.field public static final SYSTRUSTSTORE:Ljava/lang/String; = "javax.net.ssl.trustStore"

.field public static final SYSTRUSTSTOREPWD:Ljava/lang/String; = "javax.net.ssl.trustStorePassword"

.field public static final SYSTRUSTSTORETYPE:Ljava/lang/String; = "javax.net.ssl.trustStoreType"

.field public static final TRUSTSTORE:Ljava/lang/String; = "com.ibm.ssl.trustStore"

.field public static final TRUSTSTOREMGR:Ljava/lang/String; = "com.ibm.ssl.trustManager"

.field public static final TRUSTSTOREPROVIDER:Ljava/lang/String; = "com.ibm.ssl.trustStoreProvider"

.field public static final TRUSTSTOREPWD:Ljava/lang/String; = "com.ibm.ssl.trustStorePassword"

.field public static final TRUSTSTORETYPE:Ljava/lang/String; = "com.ibm.ssl.trustStoreType"

.field private static final key:[B

.field private static final propertyKeys:[Ljava/lang/String;

.field private static final xorTag:Ljava/lang/String; = "{xor}"


# instance fields
.field private configs:Ljava/util/Hashtable;

.field private defaultProperties:Ljava/util/Properties;

.field private logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    .line 135
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "com.ibm.ssl.protocol"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "com.ibm.ssl.contextProvider"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    .line 136
    const-string v2, "com.ibm.ssl.keyStore"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "com.ibm.ssl.keyStorePassword"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "com.ibm.ssl.keyStoreType"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "com.ibm.ssl.keyStoreProvider"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "com.ibm.ssl.keyManager"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 137
    const-string v2, "com.ibm.ssl.trustStore"

    aput-object v2, v0, v1

    const-string v1, "com.ibm.ssl.trustStorePassword"

    aput-object v1, v0, v3

    const/16 v1, 0x9

    const-string v2, "com.ibm.ssl.trustStoreType"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "com.ibm.ssl.trustStoreProvider"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    .line 138
    const-string v2, "com.ibm.ssl.trustManager"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "com.ibm.ssl.enabledCipherSuites"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "com.ibm.ssl.clientAuthentication"

    aput-object v2, v0, v1

    .line 135
    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->propertyKeys:[Ljava/lang/String;

    .line 144
    new-array v0, v3, [B

    fill-array-data v0, :array_0

    sput-object v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->key:[B

    .line 147
    return-void

    .line 144
    :array_0
    .array-data 1
        -0x63t
        -0x59t
        -0x27t
        -0x80t
        0x5t
        -0x48t
        -0x77t
        -0x64t
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 149
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 180
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    .line 181
    return-void
.end method

.method public constructor <init>(Lorg/pwrd/paho/client/mqttv3/logging/Logger;)V
    .locals 0
    .param p1, "logger"    # Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .prologue
    .line 188
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;-><init>()V

    .line 189
    iput-object p1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    .line 190
    return-void
.end method

.method private checkPropertyKeys(Ljava/util/Properties;)V
    .locals 6
    .param p1, "properties"    # Ljava/util/Properties;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 219
    invoke-virtual {p1}, Ljava/util/Properties;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 220
    .local v2, "keys":Ljava/util/Set;
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 221
    .local v0, "i":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 227
    return-void

    .line 222
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 223
    .local v1, "k":Ljava/lang/String;
    invoke-direct {p0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->keyValid(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 224
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " is not a valid IBM SSL property key."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private convertPassword(Ljava/util/Properties;)V
    .locals 3
    .param p1, "p"    # Ljava/util/Properties;

    .prologue
    .line 375
    const-string v2, "com.ibm.ssl.keyStorePassword"

    invoke-virtual {p1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 376
    .local v1, "pw":Ljava/lang/String;
    if-eqz v1, :cond_0

    const-string v2, "{xor}"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 377
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v2

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->obfuscate([C)Ljava/lang/String;

    move-result-object v0

    .line 378
    .local v0, "epw":Ljava/lang/String;
    const-string v2, "com.ibm.ssl.keyStorePassword"

    invoke-virtual {p1, v2, v0}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 380
    .end local v0    # "epw":Ljava/lang/String;
    :cond_0
    const-string v2, "com.ibm.ssl.trustStorePassword"

    invoke-virtual {p1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 381
    if-eqz v1, :cond_1

    const-string v2, "{xor}"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 382
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v2

    invoke-static {v2}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->obfuscate([C)Ljava/lang/String;

    move-result-object v0

    .line 383
    .restart local v0    # "epw":Ljava/lang/String;
    const-string v2, "com.ibm.ssl.trustStorePassword"

    invoke-virtual {p1, v2, v0}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 385
    .end local v0    # "epw":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public static deObfuscate(Ljava/lang/String;)[C
    .locals 6
    .param p0, "ePassword"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 300
    if-nez p0, :cond_0

    .line 313
    :goto_0
    return-object v3

    .line 302
    :cond_0
    const/4 v0, 0x0

    .line 304
    .local v0, "bytes":[B
    :try_start_0
    const-string v4, "{xor}"

    .line 305
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    .line 304
    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/pwrd/paho/client/mqttv3/internal/security/SimpleBase64Encoder;->decode(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 310
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v3, v0

    if-lt v2, v3, :cond_1

    .line 313
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->toChar([B)[C

    move-result-object v3

    goto :goto_0

    .line 306
    .end local v2    # "i":I
    :catch_0
    move-exception v1

    .line 307
    .local v1, "e":Ljava/lang/Exception;
    goto :goto_0

    .line 311
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "i":I
    :cond_1
    aget-byte v3, v0, v2

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->key:[B

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->key:[B

    array-length v5, v5

    rem-int v5, v2, v5

    aget-byte v4, v4, v5

    xor-int/2addr v3, v4

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v0, v2

    .line 310
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;
    .param p2, "ibmKey"    # Ljava/lang/String;
    .param p3, "sysProperty"    # Ljava/lang/String;

    .prologue
    .line 792
    const/4 v0, 0x0

    .line 793
    .local v0, "res":Ljava/lang/String;
    invoke-direct {p0, p1, p2}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getPropertyFromConfig(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 794
    if-eqz v0, :cond_0

    move-object v1, v0

    .line 801
    .end local v0    # "res":Ljava/lang/String;
    .local v1, "res":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 798
    .end local v1    # "res":Ljava/lang/String;
    .restart local v0    # "res":Ljava/lang/String;
    :cond_0
    if-eqz p3, :cond_1

    .line 799
    invoke-static {p3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    move-object v1, v0

    .line 801
    .end local v0    # "res":Ljava/lang/String;
    .restart local v1    # "res":Ljava/lang/String;
    goto :goto_0
.end method

.method private getPropertyFromConfig(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;
    .param p2, "ibmKey"    # Ljava/lang/String;

    .prologue
    .line 816
    const/4 v1, 0x0

    .line 817
    .local v1, "res":Ljava/lang/String;
    const/4 v0, 0x0

    .line 818
    .local v0, "p":Ljava/util/Properties;
    if-eqz p1, :cond_0

    .line 819
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v3, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "p":Ljava/util/Properties;
    check-cast v0, Ljava/util/Properties;

    .line 821
    .restart local v0    # "p":Ljava/util/Properties;
    :cond_0
    if-eqz v0, :cond_1

    .line 822
    invoke-virtual {v0, p2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 823
    if-eqz v1, :cond_1

    move-object v2, v1

    .line 833
    .end local v1    # "res":Ljava/lang/String;
    .local v2, "res":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 827
    .end local v2    # "res":Ljava/lang/String;
    .restart local v1    # "res":Ljava/lang/String;
    :cond_1
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    .line 828
    if-eqz v0, :cond_2

    .line 829
    invoke-virtual {v0, p2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 830
    if-eqz v1, :cond_2

    move-object v2, v1

    .line 831
    .end local v1    # "res":Ljava/lang/String;
    .restart local v2    # "res":Ljava/lang/String;
    goto :goto_0

    .end local v2    # "res":Ljava/lang/String;
    .restart local v1    # "res":Ljava/lang/String;
    :cond_2
    move-object v2, v1

    .line 833
    .end local v1    # "res":Ljava/lang/String;
    .restart local v2    # "res":Ljava/lang/String;
    goto :goto_0
.end method

.method private getSSLContext(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    .locals 34
    .param p1, "configID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    .line 1109
    const-string v4, "getSSLContext"

    .line 1110
    .local v4, "METHOD_NAME":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1112
    .local v5, "ctx":Ljavax/net/ssl/SSLContext;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getSSLProtocol(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 1113
    .local v16, "protocol":Ljava/lang/String;
    if-nez v16, :cond_0

    .line 1114
    const-string v16, "TLS"

    .line 1116
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_1

    .line 1118
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12000"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_12

    move-object/from16 v27, p1

    :goto_0
    aput-object v27, v32, v33

    const/16 v27, 0x1

    .line 1119
    aput-object v16, v32, v27

    .line 1118
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1122
    :cond_1
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getJSSEProvider(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 1124
    .local v17, "provider":Ljava/lang/String;
    if-nez v17, :cond_13

    .line 1125
    :try_start_0
    invoke-static/range {v16 .. v16}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v5

    .line 1129
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_2

    .line 1131
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12001"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_14

    move-object/from16 v27, p1

    :goto_2
    aput-object v27, v32, v33

    const/16 v27, 0x1

    .line 1132
    invoke-virtual {v5}, Ljavax/net/ssl/SSLContext;->getProvider()Ljava/security/Provider;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/security/Provider;->getName()Ljava/lang/String;

    move-result-object v33

    aput-object v33, v32, v27

    .line 1131
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1135
    :cond_2
    const-string v27, "com.ibm.ssl.keyStore"

    const/16 v28, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v27

    move-object/from16 v3, v28

    invoke-direct {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 1136
    .local v13, "keyStoreName":Ljava/lang/String;
    const/4 v12, 0x0

    .line 1137
    .local v12, "keyStore":Ljava/security/KeyStore;
    const/4 v10, 0x0

    .line 1138
    .local v10, "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    const/4 v8, 0x0

    .line 1153
    .local v8, "keyMgr":[Ljavax/net/ssl/KeyManager;
    if-nez v12, :cond_a

    .line 1154
    if-nez v13, :cond_3

    .line 1159
    const-string v27, "com.ibm.ssl.keyStore"

    const-string v28, "javax.net.ssl.keyStore"

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v27

    move-object/from16 v3, v28

    invoke-direct {v0, v1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 1161
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_4

    .line 1163
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12004"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_15

    move-object/from16 v27, p1

    :goto_3
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1164
    if-eqz v13, :cond_16

    move-object/from16 v27, v13

    :goto_4
    aput-object v27, v32, v33

    .line 1163
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1167
    :cond_4
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getKeyStorePassword(Ljava/lang/String;)[C

    move-result-object v14

    .line 1168
    .local v14, "keyStorePwd":[C
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_5

    .line 1170
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12005"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_17

    move-object/from16 v27, p1

    :goto_5
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1171
    if-eqz v14, :cond_18

    invoke-static {v14}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->obfuscate([C)Ljava/lang/String;

    move-result-object v27

    :goto_6
    aput-object v27, v32, v33

    .line 1170
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1174
    :cond_5
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getKeyStoreType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 1175
    .local v15, "keyStoreType":Ljava/lang/String;
    if-nez v15, :cond_6

    .line 1176
    invoke-static {}, Ljava/security/KeyStore;->getDefaultType()Ljava/lang/String;

    move-result-object v15

    .line 1178
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_7

    .line 1180
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12006"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_19

    move-object/from16 v27, p1

    :goto_7
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1181
    if-eqz v15, :cond_1a

    move-object/from16 v27, v15

    :goto_8
    aput-object v27, v32, v33

    .line 1180
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1184
    :cond_7
    invoke-static {}, Ljavax/net/ssl/KeyManagerFactory;->getDefaultAlgorithm()Ljava/lang/String;

    move-result-object v9

    .line 1185
    .local v9, "keyMgrAlgo":Ljava/lang/String;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getKeyStoreProvider(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 1186
    .local v11, "keyMgrProvider":Ljava/lang/String;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getKeyManager(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_0 .. :try_end_0} :catch_5

    move-result-object v7

    .line 1187
    .local v7, "keyManager":Ljava/lang/String;
    if-eqz v7, :cond_8

    .line 1188
    move-object v9, v7

    .line 1191
    :cond_8
    if-eqz v13, :cond_a

    if-eqz v15, :cond_a

    if-eqz v9, :cond_a

    .line 1193
    :try_start_1
    invoke-static {v15}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v12

    .line 1194
    new-instance v27, Ljava/io/FileInputStream;

    move-object/from16 v0, v27

    invoke-direct {v0, v13}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v27

    invoke-virtual {v12, v0, v14}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 1195
    if-eqz v11, :cond_1b

    .line 1196
    invoke-static {v9, v11}, Ljavax/net/ssl/KeyManagerFactory;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;

    move-result-object v10

    .line 1200
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_9

    .line 1202
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12010"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_1c

    move-object/from16 v27, p1

    :goto_a
    aput-object v27, v32, v33

    const/16 v27, 0x1

    .line 1203
    if-eqz v9, :cond_1d

    .end local v9    # "keyMgrAlgo":Ljava/lang/String;
    :goto_b
    aput-object v9, v32, v27

    .line 1202
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1205
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12009"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_1e

    move-object/from16 v27, p1

    :goto_c
    aput-object v27, v32, v33

    const/16 v27, 0x1

    .line 1206
    invoke-virtual {v10}, Ljavax/net/ssl/KeyManagerFactory;->getProvider()Ljava/security/Provider;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/security/Provider;->getName()Ljava/lang/String;

    move-result-object v33

    aput-object v33, v32, v27

    .line 1205
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1208
    :cond_9
    invoke-virtual {v10, v12, v14}, Ljavax/net/ssl/KeyManagerFactory;->init(Ljava/security/KeyStore;[C)V

    .line 1209
    invoke-virtual {v10}, Ljavax/net/ssl/KeyManagerFactory;->getKeyManagers()[Ljavax/net/ssl/KeyManager;
    :try_end_1
    .catch Ljava/security/KeyStoreException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/security/cert/CertificateException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catch Ljava/security/UnrecoverableKeyException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_1 .. :try_end_1} :catch_5

    move-result-object v8

    .line 1225
    .end local v7    # "keyManager":Ljava/lang/String;
    .end local v11    # "keyMgrProvider":Ljava/lang/String;
    .end local v14    # "keyStorePwd":[C
    .end local v15    # "keyStoreType":Ljava/lang/String;
    :cond_a
    :try_start_2
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getTrustStore(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 1226
    .local v24, "trustStoreName":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_b

    .line 1228
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12011"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_1f

    move-object/from16 v27, p1

    :goto_d
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1229
    if-eqz v24, :cond_20

    move-object/from16 v27, v24

    :goto_e
    aput-object v27, v32, v33

    .line 1228
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1231
    :cond_b
    const/16 v23, 0x0

    .line 1232
    .local v23, "trustStore":Ljava/security/KeyStore;
    const/16 v21, 0x0

    .line 1233
    .local v21, "trustMgrFact":Ljavax/net/ssl/TrustManagerFactory;
    const/16 v19, 0x0

    .line 1234
    .local v19, "trustMgr":[Ljavax/net/ssl/TrustManager;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getTrustStorePassword(Ljava/lang/String;)[C

    move-result-object v25

    .line 1235
    .local v25, "trustStorePwd":[C
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_c

    .line 1237
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12012"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_21

    move-object/from16 v27, p1

    :goto_f
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1238
    if-eqz v25, :cond_22

    invoke-static/range {v25 .. v25}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->obfuscate([C)Ljava/lang/String;

    move-result-object v27

    :goto_10
    aput-object v27, v32, v33

    .line 1237
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1240
    :cond_c
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getTrustStoreType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 1241
    .local v26, "trustStoreType":Ljava/lang/String;
    if-nez v26, :cond_d

    .line 1242
    invoke-static {}, Ljava/security/KeyStore;->getDefaultType()Ljava/lang/String;

    move-result-object v26

    .line 1244
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_e

    .line 1246
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12013"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_23

    move-object/from16 v27, p1

    :goto_11
    aput-object v27, v32, v33

    const/16 v33, 0x1

    .line 1247
    if-eqz v26, :cond_24

    move-object/from16 v27, v26

    :goto_12
    aput-object v27, v32, v33

    .line 1246
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1250
    :cond_e
    invoke-static {}, Ljavax/net/ssl/TrustManagerFactory;->getDefaultAlgorithm()Ljava/lang/String;

    move-result-object v20

    .line 1251
    .local v20, "trustMgrAlgo":Ljava/lang/String;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getTrustStoreProvider(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 1252
    .local v22, "trustMgrProvider":Ljava/lang/String;
    invoke-virtual/range {p0 .. p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getTrustManager(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_2 .. :try_end_2} :catch_5

    move-result-object v18

    .line 1253
    .local v18, "trustManager":Ljava/lang/String;
    if-eqz v18, :cond_f

    .line 1254
    move-object/from16 v20, v18

    .line 1257
    :cond_f
    if-eqz v24, :cond_11

    if-eqz v26, :cond_11

    if-eqz v20, :cond_11

    .line 1259
    :try_start_3
    invoke-static/range {v26 .. v26}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v23

    .line 1260
    new-instance v27, Ljava/io/FileInputStream;

    move-object/from16 v0, v27

    move-object/from16 v1, v24

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v23

    move-object/from16 v1, v27

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V

    .line 1261
    if-eqz v22, :cond_25

    .line 1262
    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-static {v0, v1}, Ljavax/net/ssl/TrustManagerFactory;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;

    move-result-object v21

    .line 1266
    :goto_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    if-eqz v27, :cond_10

    .line 1269
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v28, v0

    const-string v29, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v30, "getSSLContext"

    const-string v31, "12017"

    const/16 v27, 0x2

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v32, v0

    const/16 v33, 0x0

    if-eqz p1, :cond_26

    move-object/from16 v27, p1

    :goto_14
    aput-object v27, v32, v33

    const/16 v27, 0x1

    .line 1270
    if-eqz v20, :cond_27

    .end local v20    # "trustMgrAlgo":Ljava/lang/String;
    :goto_15
    aput-object v20, v32, v27

    .line 1269
    invoke-interface/range {v28 .. v32}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1273
    move-object/from16 v0, p0

    iget-object v0, v0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    move-object/from16 v27, v0

    const-string v28, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v29, "getSSLContext"

    const-string v30, "12016"

    const/16 v31, 0x2

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    if-eqz p1, :cond_28

    .end local p1    # "configID":Ljava/lang/String;
    :goto_16
    aput-object p1, v31, v32

    const/16 v32, 0x1

    .line 1274
    invoke-virtual/range {v21 .. v21}, Ljavax/net/ssl/TrustManagerFactory;->getProvider()Ljava/security/Provider;

    move-result-object v33

    invoke-virtual/range {v33 .. v33}, Ljava/security/Provider;->getName()Ljava/lang/String;

    move-result-object v33

    aput-object v33, v31, v32

    .line 1273
    invoke-interface/range {v27 .. v31}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1276
    :cond_10
    move-object/from16 v0, v21

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljavax/net/ssl/TrustManagerFactory;->init(Ljava/security/KeyStore;)V

    .line 1277
    invoke-virtual/range {v21 .. v21}, Ljavax/net/ssl/TrustManagerFactory;->getTrustManagers()[Ljavax/net/ssl/TrustManager;
    :try_end_3
    .catch Ljava/security/KeyStoreException; {:try_start_3 .. :try_end_3} :catch_8
    .catch Ljava/security/cert/CertificateException; {:try_start_3 .. :try_end_3} :catch_9
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_a
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_b
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_3 .. :try_end_3} :catch_5

    move-result-object v19

    .line 1289
    :cond_11
    const/16 v27, 0x0

    :try_start_4
    move-object/from16 v0, v19

    move-object/from16 v1, v27

    invoke-virtual {v5, v8, v0, v1}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    :try_end_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_4 .. :try_end_4} :catch_5

    .line 1297
    return-object v5

    .line 1118
    .end local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .end local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .end local v12    # "keyStore":Ljava/security/KeyStore;
    .end local v13    # "keyStoreName":Ljava/lang/String;
    .end local v17    # "provider":Ljava/lang/String;
    .end local v18    # "trustManager":Ljava/lang/String;
    .end local v19    # "trustMgr":[Ljavax/net/ssl/TrustManager;
    .end local v21    # "trustMgrFact":Ljavax/net/ssl/TrustManagerFactory;
    .end local v22    # "trustMgrProvider":Ljava/lang/String;
    .end local v23    # "trustStore":Ljava/security/KeyStore;
    .end local v24    # "trustStoreName":Ljava/lang/String;
    .end local v25    # "trustStorePwd":[C
    .end local v26    # "trustStoreType":Ljava/lang/String;
    .restart local p1    # "configID":Ljava/lang/String;
    :cond_12
    const-string v27, "null (broker defaults)"

    goto/16 :goto_0

    .line 1127
    .restart local v17    # "provider":Ljava/lang/String;
    :cond_13
    :try_start_5
    invoke-static/range {v16 .. v17}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v5

    goto/16 :goto_1

    .line 1131
    :cond_14
    const-string v27, "null (broker defaults)"

    goto/16 :goto_2

    .line 1163
    .restart local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .restart local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .restart local v12    # "keyStore":Ljava/security/KeyStore;
    .restart local v13    # "keyStoreName":Ljava/lang/String;
    :cond_15
    const-string v27, "null (broker defaults)"

    goto/16 :goto_3

    .line 1164
    :cond_16
    const-string v27, "null"

    goto/16 :goto_4

    .line 1170
    .restart local v14    # "keyStorePwd":[C
    :cond_17
    const-string v27, "null (broker defaults)"

    goto/16 :goto_5

    .line 1171
    :cond_18
    const-string v27, "null"

    goto/16 :goto_6

    .line 1180
    .restart local v15    # "keyStoreType":Ljava/lang/String;
    :cond_19
    const-string v27, "null (broker defaults)"

    goto/16 :goto_7

    .line 1181
    :cond_1a
    const-string v27, "null"
    :try_end_5
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_5 .. :try_end_5} :catch_5

    goto/16 :goto_8

    .line 1198
    .restart local v7    # "keyManager":Ljava/lang/String;
    .restart local v9    # "keyMgrAlgo":Ljava/lang/String;
    .restart local v11    # "keyMgrProvider":Ljava/lang/String;
    :cond_1b
    :try_start_6
    invoke-static {v9}, Ljavax/net/ssl/KeyManagerFactory;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;

    move-result-object v10

    goto/16 :goto_9

    .line 1202
    :cond_1c
    const-string v27, "null (broker defaults)"

    goto/16 :goto_a

    .line 1203
    :cond_1d
    const-string v9, "null"

    goto/16 :goto_b

    .line 1205
    .end local v9    # "keyMgrAlgo":Ljava/lang/String;
    :cond_1e
    const-string v27, "null (broker defaults)"
    :try_end_6
    .catch Ljava/security/KeyStoreException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/security/cert/CertificateException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/security/UnrecoverableKeyException; {:try_start_6 .. :try_end_6} :catch_7
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_6 .. :try_end_6} :catch_5

    goto/16 :goto_c

    .line 1210
    :catch_0
    move-exception v6

    .line 1211
    .local v6, "e":Ljava/security/KeyStoreException;
    :try_start_7
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27
    :try_end_7
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_7 .. :try_end_7} :catch_5

    .line 1290
    .end local v6    # "e":Ljava/security/KeyStoreException;
    .end local v7    # "keyManager":Ljava/lang/String;
    .end local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .end local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .end local v11    # "keyMgrProvider":Ljava/lang/String;
    .end local v12    # "keyStore":Ljava/security/KeyStore;
    .end local v13    # "keyStoreName":Ljava/lang/String;
    .end local v14    # "keyStorePwd":[C
    .end local v15    # "keyStoreType":Ljava/lang/String;
    .end local p1    # "configID":Ljava/lang/String;
    :catch_1
    move-exception v6

    .line 1291
    .local v6, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1212
    .end local v6    # "e":Ljava/security/NoSuchAlgorithmException;
    .restart local v7    # "keyManager":Ljava/lang/String;
    .restart local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .restart local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .restart local v11    # "keyMgrProvider":Ljava/lang/String;
    .restart local v12    # "keyStore":Ljava/security/KeyStore;
    .restart local v13    # "keyStoreName":Ljava/lang/String;
    .restart local v14    # "keyStorePwd":[C
    .restart local v15    # "keyStoreType":Ljava/lang/String;
    .restart local p1    # "configID":Ljava/lang/String;
    :catch_2
    move-exception v6

    .line 1213
    .local v6, "e":Ljava/security/cert/CertificateException;
    :try_start_8
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27
    :try_end_8
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_8 .. :try_end_8} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_8 .. :try_end_8} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_8 .. :try_end_8} :catch_5

    .line 1292
    .end local v6    # "e":Ljava/security/cert/CertificateException;
    .end local v7    # "keyManager":Ljava/lang/String;
    .end local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .end local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .end local v11    # "keyMgrProvider":Ljava/lang/String;
    .end local v12    # "keyStore":Ljava/security/KeyStore;
    .end local v13    # "keyStoreName":Ljava/lang/String;
    .end local v14    # "keyStorePwd":[C
    .end local v15    # "keyStoreType":Ljava/lang/String;
    .end local p1    # "configID":Ljava/lang/String;
    :catch_3
    move-exception v6

    .line 1293
    .local v6, "e":Ljava/security/NoSuchProviderException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1214
    .end local v6    # "e":Ljava/security/NoSuchProviderException;
    .restart local v7    # "keyManager":Ljava/lang/String;
    .restart local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .restart local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .restart local v11    # "keyMgrProvider":Ljava/lang/String;
    .restart local v12    # "keyStore":Ljava/security/KeyStore;
    .restart local v13    # "keyStoreName":Ljava/lang/String;
    .restart local v14    # "keyStorePwd":[C
    .restart local v15    # "keyStoreType":Ljava/lang/String;
    .restart local p1    # "configID":Ljava/lang/String;
    :catch_4
    move-exception v6

    .line 1215
    .local v6, "e":Ljava/io/FileNotFoundException;
    :try_start_9
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27
    :try_end_9
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_9 .. :try_end_9} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_9 .. :try_end_9} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_9 .. :try_end_9} :catch_5

    .line 1294
    .end local v6    # "e":Ljava/io/FileNotFoundException;
    .end local v7    # "keyManager":Ljava/lang/String;
    .end local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .end local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .end local v11    # "keyMgrProvider":Ljava/lang/String;
    .end local v12    # "keyStore":Ljava/security/KeyStore;
    .end local v13    # "keyStoreName":Ljava/lang/String;
    .end local v14    # "keyStorePwd":[C
    .end local v15    # "keyStoreType":Ljava/lang/String;
    .end local p1    # "configID":Ljava/lang/String;
    :catch_5
    move-exception v6

    .line 1295
    .local v6, "e":Ljava/security/KeyManagementException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1216
    .end local v6    # "e":Ljava/security/KeyManagementException;
    .restart local v7    # "keyManager":Ljava/lang/String;
    .restart local v8    # "keyMgr":[Ljavax/net/ssl/KeyManager;
    .restart local v10    # "keyMgrFact":Ljavax/net/ssl/KeyManagerFactory;
    .restart local v11    # "keyMgrProvider":Ljava/lang/String;
    .restart local v12    # "keyStore":Ljava/security/KeyStore;
    .restart local v13    # "keyStoreName":Ljava/lang/String;
    .restart local v14    # "keyStorePwd":[C
    .restart local v15    # "keyStoreType":Ljava/lang/String;
    .restart local p1    # "configID":Ljava/lang/String;
    :catch_6
    move-exception v6

    .line 1217
    .local v6, "e":Ljava/io/IOException;
    :try_start_a
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1218
    .end local v6    # "e":Ljava/io/IOException;
    :catch_7
    move-exception v6

    .line 1219
    .local v6, "e":Ljava/security/UnrecoverableKeyException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1228
    .end local v6    # "e":Ljava/security/UnrecoverableKeyException;
    .end local v7    # "keyManager":Ljava/lang/String;
    .end local v11    # "keyMgrProvider":Ljava/lang/String;
    .end local v14    # "keyStorePwd":[C
    .end local v15    # "keyStoreType":Ljava/lang/String;
    .restart local v24    # "trustStoreName":Ljava/lang/String;
    :cond_1f
    const-string v27, "null (broker defaults)"

    goto/16 :goto_d

    .line 1229
    :cond_20
    const-string v27, "null"

    goto/16 :goto_e

    .line 1237
    .restart local v19    # "trustMgr":[Ljavax/net/ssl/TrustManager;
    .restart local v21    # "trustMgrFact":Ljavax/net/ssl/TrustManagerFactory;
    .restart local v23    # "trustStore":Ljava/security/KeyStore;
    .restart local v25    # "trustStorePwd":[C
    :cond_21
    const-string v27, "null (broker defaults)"

    goto/16 :goto_f

    .line 1238
    :cond_22
    const-string v27, "null"

    goto/16 :goto_10

    .line 1246
    .restart local v26    # "trustStoreType":Ljava/lang/String;
    :cond_23
    const-string v27, "null (broker defaults)"

    goto/16 :goto_11

    .line 1247
    :cond_24
    const-string v27, "null"
    :try_end_a
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_a .. :try_end_a} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_a .. :try_end_a} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_a .. :try_end_a} :catch_5

    goto/16 :goto_12

    .line 1264
    .restart local v18    # "trustManager":Ljava/lang/String;
    .restart local v20    # "trustMgrAlgo":Ljava/lang/String;
    .restart local v22    # "trustMgrProvider":Ljava/lang/String;
    :cond_25
    :try_start_b
    invoke-static/range {v20 .. v20}, Ljavax/net/ssl/TrustManagerFactory;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;

    move-result-object v21

    goto/16 :goto_13

    .line 1269
    :cond_26
    const-string v27, "null (broker defaults)"

    goto/16 :goto_14

    .line 1270
    :cond_27
    const-string v20, "null"

    goto/16 :goto_15

    .line 1273
    .end local v20    # "trustMgrAlgo":Ljava/lang/String;
    :cond_28
    const-string p1, "null (broker defaults)"
    :try_end_b
    .catch Ljava/security/KeyStoreException; {:try_start_b .. :try_end_b} :catch_8
    .catch Ljava/security/cert/CertificateException; {:try_start_b .. :try_end_b} :catch_9
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_b} :catch_a
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_b
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_b .. :try_end_b} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_b .. :try_end_b} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_b .. :try_end_b} :catch_5

    goto/16 :goto_16

    .line 1278
    .end local p1    # "configID":Ljava/lang/String;
    :catch_8
    move-exception v6

    .line 1279
    .local v6, "e":Ljava/security/KeyStoreException;
    :try_start_c
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1280
    .end local v6    # "e":Ljava/security/KeyStoreException;
    :catch_9
    move-exception v6

    .line 1281
    .local v6, "e":Ljava/security/cert/CertificateException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1282
    .end local v6    # "e":Ljava/security/cert/CertificateException;
    :catch_a
    move-exception v6

    .line 1283
    .local v6, "e":Ljava/io/FileNotFoundException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27

    .line 1284
    .end local v6    # "e":Ljava/io/FileNotFoundException;
    :catch_b
    move-exception v6

    .line 1285
    .local v6, "e":Ljava/io/IOException;
    new-instance v27, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;

    move-object/from16 v0, v27

    invoke-direct {v0, v6}, Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;-><init>(Ljava/lang/Throwable;)V

    throw v27
    :try_end_c
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_c .. :try_end_c} :catch_1
    .catch Ljava/security/NoSuchProviderException; {:try_start_c .. :try_end_c} :catch_3
    .catch Ljava/security/KeyManagementException; {:try_start_c .. :try_end_c} :catch_5
.end method

.method public static isSupportedOnJVM()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/LinkageError;,
            Ljava/lang/ExceptionInInitializerError;
        }
    .end annotation

    .prologue
    .line 165
    const-string v1, "javax.net.ssl.SSLServerSocketFactory"

    .line 167
    .local v1, "requiredClassname":Ljava/lang/String;
    :try_start_0
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 171
    const/4 v2, 0x1

    :goto_0
    return v2

    .line 168
    :catch_0
    move-exception v0

    .line 169
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private keyValid(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 199
    const/4 v0, 0x0

    .line 200
    .local v0, "i":I
    :goto_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->propertyKeys:[Ljava/lang/String;

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 206
    :cond_0
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->propertyKeys:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_2

    const/4 v1, 0x1

    :goto_1
    return v1

    .line 201
    :cond_1
    sget-object v1, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->propertyKeys:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 204
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 206
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static obfuscate([C)Ljava/lang/String;
    .locals 6
    .param p0, "password"    # [C

    .prologue
    .line 278
    if-nez p0, :cond_0

    .line 279
    const/4 v1, 0x0

    .line 286
    :goto_0
    return-object v1

    .line 280
    :cond_0
    invoke-static {p0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->toByte([C)[B

    move-result-object v0

    .line 281
    .local v0, "bytes":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v3, v0

    if-lt v2, v3, :cond_1

    .line 284
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "{xor}"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 285
    new-instance v4, Ljava/lang/String;

    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SimpleBase64Encoder;->encode([B)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 284
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 286
    .local v1, "encryptedValue":Ljava/lang/String;
    goto :goto_0

    .line 282
    .end local v1    # "encryptedValue":Ljava/lang/String;
    :cond_1
    aget-byte v3, v0, v2

    sget-object v4, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->key:[B

    sget-object v5, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->key:[B

    array-length v5, v5

    rem-int v5, v2, v5

    aget-byte v4, v4, v5

    xor-int/2addr v3, v4

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v0, v2

    .line 281
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public static packCipherSuites([Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "ciphers"    # [Ljava/lang/String;

    .prologue
    .line 324
    const/4 v1, 0x0

    .line 325
    .local v1, "cipherSet":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 326
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 327
    .local v0, "buf":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, p0

    if-lt v2, v3, :cond_1

    .line 333
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    .line 335
    .end local v0    # "buf":Ljava/lang/StringBuffer;
    .end local v2    # "i":I
    :cond_0
    return-object v1

    .line 328
    .restart local v0    # "buf":Ljava/lang/StringBuffer;
    .restart local v2    # "i":I
    :cond_1
    aget-object v3, p0, v2

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 329
    array-length v3, p0

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_2

    .line 330
    const/16 v3, 0x2c

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 327
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static toByte([C)[B
    .locals 6
    .param p0, "c"    # [C

    .prologue
    .line 256
    if-nez p0, :cond_1

    const/4 v0, 0x0

    .line 263
    :cond_0
    return-object v0

    .line 257
    :cond_1
    array-length v5, p0

    mul-int/lit8 v5, v5, 0x2

    new-array v0, v5, [B

    .line 258
    .local v0, "b":[B
    const/4 v1, 0x0

    .local v1, "i":I
    const/4 v3, 0x0

    .line 259
    .local v3, "j":I
    :goto_0
    array-length v5, p0

    if-ge v3, v5, :cond_0

    .line 260
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    aget-char v5, p0, v3

    and-int/lit16 v5, v5, 0xff

    int-to-byte v5, v5

    aput-byte v5, v0, v1

    .line 261
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "j":I
    .local v4, "j":I
    aget-char v5, p0, v3

    shr-int/lit8 v5, v5, 0x8

    and-int/lit16 v5, v5, 0xff

    int-to-byte v5, v5

    aput-byte v5, v0, v2

    move v3, v4

    .end local v4    # "j":I
    .restart local v3    # "j":I
    goto :goto_0
.end method

.method public static toChar([B)[C
    .locals 7
    .param p0, "b"    # [B

    .prologue
    .line 238
    if-nez p0, :cond_1

    const/4 v0, 0x0

    .line 244
    :cond_0
    return-object v0

    .line 239
    :cond_1
    array-length v5, p0

    div-int/lit8 v5, v5, 0x2

    new-array v0, v5, [C

    .line 240
    .local v0, "c":[C
    const/4 v1, 0x0

    .local v1, "i":I
    const/4 v3, 0x0

    .line 241
    .local v3, "j":I
    :goto_0
    array-length v5, p0

    if-ge v1, v5, :cond_0

    .line 242
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "j":I
    .local v4, "j":I
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    aget-byte v5, p0, v1

    and-int/lit16 v5, v5, 0xff

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aget-byte v6, p0, v2

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x8

    add-int/2addr v5, v6

    int-to-char v5, v5

    aput-char v5, v0, v3

    move v3, v4

    .end local v4    # "j":I
    .restart local v3    # "j":I
    goto :goto_0
.end method

.method public static unpackCipherSuites(Ljava/lang/String;)[Ljava/lang/String;
    .locals 6
    .param p0, "ciphers"    # Ljava/lang/String;

    .prologue
    const/16 v5, 0x2c

    .line 348
    if-nez p0, :cond_0

    const/4 v3, 0x0

    .line 363
    :goto_0
    return-object v3

    .line 349
    :cond_0
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    .line 350
    .local v0, "c":Ljava/util/Vector;
    invoke-virtual {p0, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 351
    .local v1, "i":I
    const/4 v2, 0x0

    .line 353
    .local v2, "j":I
    :goto_1
    const/4 v4, -0x1

    if-gt v1, v4, :cond_1

    .line 360
    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 361
    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v4

    new-array v3, v4, [Ljava/lang/String;

    .line 362
    .local v3, "s":[Ljava/lang/String;
    invoke-virtual {v0, v3}, Ljava/util/Vector;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    goto :goto_0

    .line 355
    .end local v3    # "s":[Ljava/lang/String;
    :cond_1
    invoke-virtual {p0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 356
    add-int/lit8 v2, v1, 0x1

    .line 357
    invoke-virtual {p0, v5, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    goto :goto_1
.end method


# virtual methods
.method public createSocketFactory(Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;
    .locals 10
    .param p1, "configID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/pwrd/paho/client/mqttv3/MqttSecurityException;
        }
    .end annotation

    .prologue
    .line 1344
    const-string v0, "createSocketFactory"

    .line 1345
    .local v0, "METHOD_NAME":Ljava/lang/String;
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getSSLContext(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v1

    .line 1346
    .local v1, "ctx":Ljavax/net/ssl/SSLContext;
    iget-object v2, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    if-eqz v2, :cond_0

    .line 1348
    iget-object v3, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->logger:Lorg/pwrd/paho/client/mqttv3/logging/Logger;

    const-string v4, "org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory"

    const-string v5, "createSocketFactory"

    const-string v6, "12020"

    const/4 v2, 0x2

    new-array v7, v2, [Ljava/lang/Object;

    const/4 v8, 0x0

    if-eqz p1, :cond_1

    move-object v2, p1

    :goto_0
    aput-object v2, v7, v8

    const/4 v8, 0x1

    .line 1349
    invoke-virtual {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getEnabledCipherSuites(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    const-string v2, "com.ibm.ssl.enabledCipherSuites"

    const/4 v9, 0x0

    invoke-direct {p0, p1, v2, v9}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    :goto_1
    aput-object v2, v7, v8

    .line 1348
    invoke-interface {v3, v4, v5, v6, v7}, Lorg/pwrd/paho/client/mqttv3/logging/Logger;->fine(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1352
    :cond_0
    invoke-virtual {v1}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v2

    return-object v2

    .line 1348
    :cond_1
    const-string v2, "null (broker defaults)"

    goto :goto_0

    .line 1349
    :cond_2
    const-string v2, "null (using platform-enabled cipher suites)"

    goto :goto_1
.end method

.method public getClientAuthentication(Ljava/lang/String;)Z
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1088
    const-string v2, "com.ibm.ssl.clientAuthentication"

    const/4 v3, 0x0

    invoke-direct {p0, p1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1089
    .local v0, "auth":Ljava/lang/String;
    const/4 v1, 0x0

    .line 1090
    .local v1, "res":Z
    if-eqz v0, :cond_0

    .line 1091
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 1093
    :cond_0
    return v1
.end method

.method public getConfiguration(Ljava/lang/String;)Ljava/util/Properties;
    .locals 1
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 508
    if-nez p1, :cond_0

    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    :goto_0
    check-cast v0, Ljava/util/Properties;

    return-object v0

    .line 509
    :cond_0
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getEnabledCipherSuites(Ljava/lang/String;)[Ljava/lang/String;
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1074
    const-string v2, "com.ibm.ssl.enabledCipherSuites"

    const/4 v3, 0x0

    invoke-direct {p0, p1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1075
    .local v0, "ciphers":Ljava/lang/String;
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->unpackCipherSuites(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 1076
    .local v1, "res":[Ljava/lang/String;
    return-object v1
.end method

.method public getJSSEProvider(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 858
    const-string v0, "com.ibm.ssl.contextProvider"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getKeyManager(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 993
    const-string v0, "com.ibm.ssl.keyManager"

    const-string v1, "ssl.KeyManagerFactory.algorithm"

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getKeyStore(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 915
    const-string v0, "com.ibm.ssl.keyStore"

    .line 916
    .local v0, "ibmKey":Ljava/lang/String;
    const-string v3, "javax.net.ssl.keyStore"

    .line 918
    .local v3, "sysProperty":Ljava/lang/String;
    const/4 v1, 0x0

    .line 919
    .local v1, "res":Ljava/lang/String;
    invoke-direct {p0, p1, v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getPropertyFromConfig(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 920
    if-eqz v1, :cond_0

    move-object v2, v1

    .line 936
    .end local v1    # "res":Ljava/lang/String;
    .local v2, "res":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 932
    .end local v2    # "res":Ljava/lang/String;
    .restart local v1    # "res":Ljava/lang/String;
    :cond_0
    if-eqz v3, :cond_1

    .line 933
    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    :cond_1
    move-object v2, v1

    .line 936
    .end local v1    # "res":Ljava/lang/String;
    .restart local v2    # "res":Ljava/lang/String;
    goto :goto_0
.end method

.method public getKeyStorePassword(Ljava/lang/String;)[C
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 948
    const-string v2, "com.ibm.ssl.keyStorePassword"

    const-string v3, "javax.net.ssl.keyStorePassword"

    invoke-direct {p0, p1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 949
    .local v0, "pw":Ljava/lang/String;
    const/4 v1, 0x0

    .line 950
    .local v1, "r":[C
    if-eqz v0, :cond_0

    .line 951
    const-string v2, "{xor}"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 952
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->deObfuscate(Ljava/lang/String;)[C

    move-result-object v1

    .line 957
    :cond_0
    :goto_0
    return-object v1

    .line 954
    :cond_1
    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    goto :goto_0
.end method

.method public getKeyStoreProvider(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 981
    const-string v0, "com.ibm.ssl.keyStoreProvider"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getKeyStoreType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 969
    const-string v0, "com.ibm.ssl.keyStoreType"

    const-string v1, "javax.net.ssl.keyStoreType"

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSSLProtocol(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 846
    const-string v0, "com.ibm.ssl.protocol"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTrustManager(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1062
    const-string v0, "com.ibm.ssl.trustManager"

    const-string v1, "ssl.TrustManagerFactory.algorithm"

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTrustStore(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1005
    const-string v0, "com.ibm.ssl.trustStore"

    const-string v1, "javax.net.ssl.trustStore"

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTrustStorePassword(Ljava/lang/String;)[C
    .locals 4
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1017
    const-string v2, "com.ibm.ssl.trustStorePassword"

    const-string v3, "javax.net.ssl.trustStorePassword"

    invoke-direct {p0, p1, v2, v3}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1018
    .local v0, "pw":Ljava/lang/String;
    const/4 v1, 0x0

    .line 1019
    .local v1, "r":[C
    if-eqz v0, :cond_0

    .line 1020
    const-string v2, "{xor}"

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1021
    invoke-static {v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->deObfuscate(Ljava/lang/String;)[C

    move-result-object v1

    .line 1026
    :cond_0
    :goto_0
    return-object v1

    .line 1023
    :cond_1
    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    goto :goto_0
.end method

.method public getTrustStoreProvider(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1050
    const-string v0, "com.ibm.ssl.trustStoreProvider"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTrustStoreType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 1038
    const-string v0, "com.ibm.ssl.trustStoreType"

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->getProperty(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public initialize(Ljava/util/Properties;Ljava/lang/String;)V
    .locals 2
    .param p1, "props"    # Ljava/util/Properties;
    .param p2, "configID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 428
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->checkPropertyKeys(Ljava/util/Properties;)V

    .line 430
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    .line 431
    .local v0, "p":Ljava/util/Properties;
    invoke-virtual {v0, p1}, Ljava/util/Properties;->putAll(Ljava/util/Map;)V

    .line 432
    invoke-direct {p0, v0}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->convertPassword(Ljava/util/Properties;)V

    .line 433
    if-eqz p2, :cond_0

    .line 434
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v1, p2, v0}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 438
    :goto_0
    return-void

    .line 436
    :cond_0
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    goto :goto_0
.end method

.method public merge(Ljava/util/Properties;Ljava/lang/String;)V
    .locals 2
    .param p1, "props"    # Ljava/util/Properties;
    .param p2, "configID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 457
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->checkPropertyKeys(Ljava/util/Properties;)V

    .line 458
    iget-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    .line 459
    .local v0, "p":Ljava/util/Properties;
    if-eqz p2, :cond_0

    .line 460
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v1, p2}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "p":Ljava/util/Properties;
    check-cast v0, Ljava/util/Properties;

    .line 462
    .restart local v0    # "p":Ljava/util/Properties;
    :cond_0
    if-nez v0, :cond_1

    .line 463
    new-instance v0, Ljava/util/Properties;

    .end local v0    # "p":Ljava/util/Properties;
    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    .line 465
    .restart local v0    # "p":Ljava/util/Properties;
    :cond_1
    invoke-direct {p0, p1}, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->convertPassword(Ljava/util/Properties;)V

    .line 466
    invoke-virtual {v0, p1}, Ljava/util/Properties;->putAll(Ljava/util/Map;)V

    .line 467
    if-eqz p2, :cond_2

    .line 468
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v1, p2, v0}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 473
    :goto_0
    return-void

    .line 470
    :cond_2
    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    goto :goto_0
.end method

.method public remove(Ljava/lang/String;)Z
    .locals 2
    .param p1, "configID"    # Ljava/lang/String;

    .prologue
    .line 484
    const/4 v0, 0x0

    .line 485
    .local v0, "res":Z
    if-eqz p1, :cond_2

    .line 486
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->configs:Ljava/util/Hashtable;

    invoke-virtual {v1, p1}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 493
    :cond_0
    :goto_0
    return v0

    .line 486
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 488
    :cond_2
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    if-eqz v1, :cond_0

    .line 489
    const/4 v0, 0x1

    .line 490
    const/4 v1, 0x0

    iput-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/security/SSLSocketFactoryFactory;->defaultProperties:Ljava/util/Properties;

    goto :goto_0
.end method
