.class public Lcom/tencent/cos/xml/transfer/UploadService;
.super Ljava/lang/Object;
.source "UploadService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;,
        Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;,
        Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;
    }
.end annotation


# static fields
.field private static final SIZE_LIMIT:J = 0x200000L


# instance fields
.field private ALREADY_SEND_DATA_LEN:Ljava/util/concurrent/atomic/AtomicLong;

.field private volatile ERROR_EXIT_FLAG:I

.field private UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

.field private bucket:Ljava/lang/String;

.field private completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

.field private cosPath:Ljava/lang/String;

.field private cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

.field private cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

.field private endTime:J

.field private fileLength:J

.field private headers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

.field private listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

.field private mException:Ljava/lang/Exception;

.field private objectSync:[B

.field private partStructMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;",
            ">;"
        }
    .end annotation
.end field

.field private putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

.field private sliceSize:J

.field private srcPath:Ljava/lang/String;

.field private startTime:J

.field private uploadId:Ljava/lang/String;

.field private uploadPartRequestLongMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/tencent/cos/xml/model/object/UploadPartRequest;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;


# direct methods
.method public constructor <init>(Lcom/tencent/cos/xml/CosXmlSimpleService;Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;)V
    .locals 4
    .param p1, "cosXmlService"    # Lcom/tencent/cos/xml/CosXmlSimpleService;
    .param p2, "resumeData"    # Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;

    .prologue
    const-wide/16 v2, -0x1

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const-wide/32 v0, 0x200000

    iput-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    .line 53
    const/4 v0, 0x0

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->objectSync:[B

    .line 61
    iput-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->startTime:J

    .line 62
    iput-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->endTime:J

    .line 63
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    .line 66
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    .line 67
    invoke-direct {p0, p2}, Lcom/tencent/cos/xml/transfer/UploadService;->init(Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;)V

    .line 68
    return-void
.end method

.method private abortMultiUpload(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 5
    .param p1, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 376
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 401
    :goto_0
    return-void

    .line 377
    :cond_0
    new-instance v0, Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    invoke-direct {v0, v2, v3, v4}, Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    .local v0, "abortMultiUploadRequest":Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;
    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 381
    :try_start_0
    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    :try_end_0
    .catch Lcom/tencent/cos/xml/exception/CosXmlClientException; {:try_start_0 .. :try_end_0} :catch_0

    .line 386
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    new-instance v3, Lcom/tencent/cos/xml/transfer/UploadService$4;

    invoke-direct {v3, p0, p1}, Lcom/tencent/cos/xml/transfer/UploadService$4;-><init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    invoke-virtual {v2, v0, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->abortMultiUploadAsync(Lcom/tencent/cos/xml/model/object/AbortMultiUploadRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    goto :goto_0

    .line 382
    :catch_0
    move-exception v1

    .line 383
    .local v1, "e":Lcom/tencent/cos/xml/exception/CosXmlClientException;
    const/4 v2, 0x0

    invoke-interface {p1, v0, v1, v2}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/tencent/cos/xml/transfer/UploadService;)[B
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->objectSync:[B

    return-object v0
.end method

.method static synthetic access$100(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/tencent/cos/xml/transfer/UploadService;)V
    .locals 0
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->clear()V

    return-void
.end method

.method static synthetic access$102(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
    .locals 0
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;
    .param p1, "x1"    # Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    return-object p1
.end method

.method static synthetic access$200(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$302(Lcom/tencent/cos/xml/transfer/UploadService;Ljava/lang/Exception;)Ljava/lang/Exception;
    .locals 0
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    return-object p1
.end method

.method static synthetic access$402(Lcom/tencent/cos/xml/transfer/UploadService;I)I
    .locals 0
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;
    .param p1, "x1"    # I

    .prologue
    .line 38
    iput p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    return p1
.end method

.method static synthetic access$500(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$600(Lcom/tencent/cos/xml/transfer/UploadService;)Ljava/util/concurrent/atomic/AtomicLong;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ALREADY_SEND_DATA_LEN:Ljava/util/concurrent/atomic/AtomicLong;

    return-object v0
.end method

.method static synthetic access$700(Lcom/tencent/cos/xml/transfer/UploadService;)Lcom/tencent/cos/xml/listener/CosXmlProgressListener;
    .locals 1
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    return-object v0
.end method

.method static synthetic access$800(Lcom/tencent/cos/xml/transfer/UploadService;)J
    .locals 2
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    return-wide v0
.end method

.method static synthetic access$900(Lcom/tencent/cos/xml/transfer/UploadService;)V
    .locals 0
    .param p0, "x0"    # Lcom/tencent/cos/xml/transfer/UploadService;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->realCancel()V

    return-void
.end method

.method private checkParameter()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 84
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 85
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 86
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 87
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    .line 88
    return-void

    .line 91
    .end local v0    # "file":Ljava/io/File;
    :cond_0
    new-instance v1, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "srcPath :"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is invalid or is not exist"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private clear()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 155
    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    .line 156
    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    .line 157
    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    .line 158
    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    .line 159
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 160
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 161
    return-void
.end method

.method private completeMultiUpload()Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 361
    new-instance v2, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    iput-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    .line 363
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 364
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    .line 365
    .local v1, "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    iget v4, v1, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->partNumber:I

    iget-object v5, v1, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->eTag:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;->setPartNumberAndETag(ILjava/lang/String;)V

    goto :goto_0

    .line 367
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;>;"
    .end local v1    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    :cond_0
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-direct {p0, v2}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 368
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-direct {p0, v2}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 369
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->completeMultiUpload(Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;)Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v2

    return-object v2
.end method

.method private init(Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;)V
    .locals 5
    .param p1, "resumeData"    # Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;

    .prologue
    const/4 v4, 0x0

    .line 71
    iget-object v0, p1, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->bucket:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    .line 72
    iget-object v0, p1, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->cosPath:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    .line 73
    iget-object v0, p1, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->srcPath:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    .line 74
    iget-wide v0, p1, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->sliceSize:J

    iput-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    .line 75
    iget-object v0, p1, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->uploadId:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    .line 76
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v4}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 77
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v2, 0x0

    invoke-direct {v0, v2, v3}, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ALREADY_SEND_DATA_LEN:Ljava/util/concurrent/atomic/AtomicLong;

    .line 78
    iput v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    .line 79
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    .line 80
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    .line 81
    return-void
.end method

.method private initMultiUpload()Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 311
    new-instance v0, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    .line 313
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 314
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 315
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    invoke-virtual {v0, v1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->initMultipartUpload(Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;)Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    move-result-object v0

    return-object v0
.end method

.method private initSlicePart()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    const-wide/16 v6, 0x0

    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 421
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    if-eqz v4, :cond_1

    .line 422
    new-instance v1, Ljava/io/File;

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 423
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 424
    new-instance v4, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v5, "upload file does not exist"

    invoke-direct {v4, v5}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 426
    :cond_0
    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    .line 428
    .end local v1    # "file":Ljava/io/File;
    :cond_1
    iget-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    cmp-long v4, v4, v6

    if-lez v4, :cond_3

    iget-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    cmp-long v4, v4, v6

    if-lez v4, :cond_3

    .line 429
    iget-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    iget-wide v6, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    div-long/2addr v4, v6

    long-to-int v0, v4

    .line 430
    .local v0, "count":I
    const/4 v2, 0x1

    .line 431
    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_2

    .line 432
    new-instance v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    invoke-direct {v3, v9}, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;-><init>(Lcom/tencent/cos/xml/transfer/UploadService$1;)V

    .line 433
    .local v3, "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    iput-boolean v8, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->isAlreadyUpload:Z

    .line 434
    iput v2, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->partNumber:I

    .line 435
    add-int/lit8 v4, v2, -0x1

    int-to-long v4, v4

    iget-wide v6, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    mul-long/2addr v4, v6

    iput-wide v4, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->offset:J

    .line 436
    iget-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    iput-wide v4, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->sliceSize:J

    .line 437
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 431
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 439
    .end local v3    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    :cond_2
    new-instance v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    invoke-direct {v3, v9}, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;-><init>(Lcom/tencent/cos/xml/transfer/UploadService$1;)V

    .line 440
    .restart local v3    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    iput-boolean v8, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->isAlreadyUpload:Z

    .line 441
    iput v2, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->partNumber:I

    .line 442
    add-int/lit8 v4, v2, -0x1

    int-to-long v4, v4

    iget-wide v6, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    mul-long/2addr v4, v6

    iput-wide v4, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->offset:J

    .line 443
    iget-wide v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    iget-wide v6, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->offset:J

    sub-long/2addr v4, v6

    iput-wide v4, v3, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->sliceSize:J

    .line 444
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 445
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 446
    return-void

    .line 448
    .end local v0    # "count":I
    .end local v2    # "i":I
    .end local v3    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    :cond_3
    new-instance v4, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v5, "file size or slice size less than 0"

    invoke-direct {v4, v5}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private listPart()Lcom/tencent/cos/xml/model/object/ListPartsResult;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 322
    new-instance v0, Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lcom/tencent/cos/xml/model/object/ListPartsRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    .line 323
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 324
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 325
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    invoke-virtual {v0, v1}, Lcom/tencent/cos/xml/CosXmlSimpleService;->listParts(Lcom/tencent/cos/xml/model/object/ListPartsRequest;)Lcom/tencent/cos/xml/model/object/ListPartsResult;

    move-result-object v0

    return-object v0
.end method

.method private multiUploadParts()Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
    .locals 13
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 234
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->initSlicePart()V

    .line 235
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 236
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->listPart()Lcom/tencent/cos/xml/model/object/ListPartsResult;

    move-result-object v10

    .line 238
    .local v10, "listPartsResult":Lcom/tencent/cos/xml/model/object/ListPartsResult;
    invoke-direct {p0, v10}, Lcom/tencent/cos/xml/transfer/UploadService;->updateSlicePart(Lcom/tencent/cos/xml/model/object/ListPartsResult;)V

    .line 243
    .end local v10    # "listPartsResult":Lcom/tencent/cos/xml/model/object/ListPartsResult;
    :goto_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_0
    :goto_1
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 244
    .local v8, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;>;"
    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    .line 245
    .local v11, "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    iget-boolean v0, v11, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->isAlreadyUpload:Z

    if-nez v0, :cond_0

    .line 246
    iget v1, v11, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->partNumber:I

    iget-wide v2, v11, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->offset:J

    iget-wide v4, v11, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->sliceSize:J

    new-instance v6, Lcom/tencent/cos/xml/transfer/UploadService$2;

    invoke-direct {v6, p0, v11}, Lcom/tencent/cos/xml/transfer/UploadService$2;-><init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;)V

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPart(IJJLcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    goto :goto_1

    .line 240
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;>;"
    .end local v11    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    :cond_1
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->initMultiUpload()Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;

    move-result-object v9

    .line 241
    .local v9, "initMultipartUploadResult":Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;
    iget-object v0, v9, Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;->initMultipartUpload:Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;

    iget-object v0, v0, Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;->uploadId:Ljava/lang/String;

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    goto :goto_0

    .line 273
    .end local v9    # "initMultipartUploadResult":Lcom/tencent/cos/xml/model/object/InitMultipartUploadResult;
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-lez v0, :cond_3

    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    if-eqz v0, :cond_2

    .line 275
    :cond_3
    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    if-lez v0, :cond_4

    .line 276
    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    packed-switch v0, :pswitch_data_0

    .line 297
    :cond_4
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUpload()Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;

    move-result-object v7

    .line 298
    .local v7, "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    if-nez v0, :cond_5

    new-instance v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    invoke-direct {v0}, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;-><init>()V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    .line 299
    :cond_5
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget v1, v7, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->httpCode:I

    iput v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->httpCode:I

    .line 300
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget-object v1, v7, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->httpMessage:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->httpMessage:Ljava/lang/String;

    .line 301
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget-object v1, v7, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->headers:Ljava/util/Map;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->headers:Ljava/util/Map;

    .line 302
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget-object v1, v7, Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;->completeMultipartUpload:Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;

    iget-object v1, v1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;->eTag:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->eTag:Ljava/lang/String;

    .line 303
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-virtual {v1, v2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->accessUrl:Ljava/lang/String;

    .line 304
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    return-object v0

    .line 278
    .end local v7    # "completeMultiUploadResult":Lcom/tencent/cos/xml/model/object/CompleteMultiUploadResult;
    :pswitch_0
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->realCancel()V

    .line 279
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->clear()V

    .line 280
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "request is cancelled by manual pause"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 282
    :pswitch_1
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "request is cancelled by abort request"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 284
    :pswitch_2
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->realCancel()V

    .line 285
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    if-eqz v0, :cond_7

    .line 286
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    instance-of v0, v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    if-eqz v0, :cond_6

    .line 287
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    check-cast v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    throw v0

    .line 289
    :cond_6
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    instance-of v0, v0, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    if-eqz v0, :cond_4

    .line 290
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    check-cast v0, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    throw v0

    .line 293
    :cond_7
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "unknown exception"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 276
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private putObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
    .locals 3
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "srcPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 171
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 172
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    .line 173
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    invoke-virtual {v0, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V

    .line 174
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 175
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-direct {p0, v0}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 176
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    new-instance v2, Lcom/tencent/cos/xml/transfer/UploadService$1;

    invoke-direct {v2, p0}, Lcom/tencent/cos/xml/transfer/UploadService$1;-><init>(Lcom/tencent/cos/xml/transfer/UploadService;)V

    invoke-virtual {v0, v1, v2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->putObjectAsync(Lcom/tencent/cos/xml/model/object/PutObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 204
    :cond_0
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-lez v0, :cond_1

    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    if-eqz v0, :cond_0

    .line 206
    :cond_1
    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    if-lez v0, :cond_2

    .line 207
    iget v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    packed-switch v0, :pswitch_data_0

    .line 229
    :cond_2
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-virtual {v1, v2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->getAccessUrl(Lcom/tencent/cos/xml/model/CosXmlRequest;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;->accessUrl:Ljava/lang/String;

    .line 230
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadServiceResult:Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    return-object v0

    .line 209
    :pswitch_0
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->realCancel()V

    .line 210
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->clear()V

    .line 211
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "request is cancelled by manual pause"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 213
    :pswitch_1
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "request is cancelled by abort request"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 215
    :pswitch_2
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->realCancel()V

    .line 216
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    if-eqz v0, :cond_4

    .line 217
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    instance-of v0, v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    if-eqz v0, :cond_3

    .line 218
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    check-cast v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    throw v0

    .line 220
    :cond_3
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    instance-of v0, v0, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    if-eqz v0, :cond_2

    .line 221
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->mException:Ljava/lang/Exception;

    check-cast v0, Lcom/tencent/cos/xml/exception/CosXmlServiceException;

    throw v0

    .line 224
    :cond_4
    new-instance v0, Lcom/tencent/cos/xml/exception/CosXmlClientException;

    const-string v1, "unknown exception"

    invoke-direct {v0, v1}, Lcom/tencent/cos/xml/exception/CosXmlClientException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 207
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private realCancel()V
    .locals 4

    .prologue
    .line 404
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 405
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->initMultipartUploadRequest:Lcom/tencent/cos/xml/model/object/InitMultipartUploadRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 406
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->listPartsRequest:Lcom/tencent/cos/xml/model/object/ListPartsRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 407
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->completeMultiUploadRequest:Lcom/tencent/cos/xml/model/object/CompleteMultiUploadRequest;

    invoke-virtual {v2, v3}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 408
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    if-eqz v2, :cond_0

    .line 409
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 410
    .local v1, "set":Ljava/util/Set;, "Ljava/util/Set<Lcom/tencent/cos/xml/model/object/UploadPartRequest;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 411
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/tencent/cos/xml/model/object/UploadPartRequest;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 412
    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/tencent/cos/xml/model/CosXmlRequest;

    invoke-virtual {v3, v2}, Lcom/tencent/cos/xml/CosXmlSimpleService;->cancel(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    goto :goto_0

    .line 415
    .end local v0    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/tencent/cos/xml/model/object/UploadPartRequest;>;"
    .end local v1    # "set":Ljava/util/Set;, "Ljava/util/Set<Lcom/tencent/cos/xml/model/object/UploadPartRequest;>;"
    :cond_0
    return-void
.end method

.method private setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    .locals 5
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 116
    if-eqz p1, :cond_0

    .line 117
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    .line 118
    .local v1, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    add-int/lit8 v2, v1, -0x2

    if-ge v0, v2, :cond_0

    .line 119
    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    add-int/lit8 v4, v0, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Lcom/tencent/cos/xml/model/CosXmlRequest;->setRequestHeaders(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 122
    .end local v0    # "i":I
    .end local v1    # "size":I
    :cond_0
    return-void
.end method

.method private setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    .locals 4
    .param p1, "cosXmlRequest"    # Lcom/tencent/cos/xml/model/CosXmlRequest;

    .prologue
    .line 101
    if-eqz p1, :cond_0

    .line 102
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->startTime:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->endTime:J

    iget-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->startTime:J

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    .line 103
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->startTime:J

    iget-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->endTime:J

    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/tencent/cos/xml/model/CosXmlRequest;->setSign(JJ)V

    .line 106
    :cond_0
    return-void
.end method

.method private updateSlicePart(Lcom/tencent/cos/xml/model/object/ListPartsResult;)V
    .locals 8
    .param p1, "listPartsResult"    # Lcom/tencent/cos/xml/model/object/ListPartsResult;

    .prologue
    .line 452
    if-eqz p1, :cond_1

    iget-object v3, p1, Lcom/tencent/cos/xml/model/object/ListPartsResult;->listParts:Lcom/tencent/cos/xml/model/tag/ListParts;

    if-eqz v3, :cond_1

    .line 453
    iget-object v3, p1, Lcom/tencent/cos/xml/model/object/ListPartsResult;->listParts:Lcom/tencent/cos/xml/model/tag/ListParts;

    iget-object v1, v3, Lcom/tencent/cos/xml/model/tag/ListParts;->parts:Ljava/util/List;

    .line 454
    .local v1, "parts":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/cos/xml/model/tag/ListParts$Part;>;"
    if-eqz v1, :cond_1

    .line 455
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/tag/ListParts$Part;

    .line 456
    .local v0, "part":Lcom/tencent/cos/xml/model/tag/ListParts$Part;
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    iget-object v5, v0, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->partNumber:Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 457
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->partStructMap:Ljava/util/Map;

    iget-object v5, v0, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->partNumber:Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;

    .line 458
    .local v2, "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    const/4 v4, 0x1

    iput-boolean v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->isAlreadyUpload:Z

    .line 459
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->eTag:Ljava/lang/String;

    iput-object v4, v2, Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;->eTag:Ljava/lang/String;

    .line 460
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->UPLOAD_PART_COUNT:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 461
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ALREADY_SEND_DATA_LEN:Ljava/util/concurrent/atomic/AtomicLong;

    iget-object v5, v0, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->size:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    goto :goto_0

    .line 466
    .end local v0    # "part":Lcom/tencent/cos/xml/model/tag/ListParts$Part;
    .end local v1    # "parts":Ljava/util/List;, "Ljava/util/List<Lcom/tencent/cos/xml/model/tag/ListParts$Part;>;"
    .end local v2    # "slicePartStruct":Lcom/tencent/cos/xml/transfer/UploadService$SlicePartStruct;
    :cond_1
    return-void
.end method

.method private uploadPart(IJJLcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 14
    .param p1, "partNumber"    # I
    .param p2, "offset"    # J
    .param p4, "contentLength"    # J
    .param p6, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 332
    new-instance v3, Lcom/tencent/cos/xml/model/object/UploadPartRequest;

    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v5, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iget-object v7, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    iget-object v12, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    move v6, p1

    move-wide/from16 v8, p2

    move-wide/from16 v10, p4

    invoke-direct/range {v3 .. v12}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJLjava/lang/String;)V

    .line 334
    .local v3, "uploadPartRequest":Lcom/tencent/cos/xml/model/object/UploadPartRequest;
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadPartRequestLongMap:Ljava/util/Map;

    const-wide/16 v6, 0x0

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v4, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 335
    invoke-direct {p0, v3}, Lcom/tencent/cos/xml/transfer/UploadService;->setSignTime(Lcom/tencent/cos/xml/model/CosXmlRequest;)V

    .line 337
    :try_start_0
    invoke-direct {p0, v3}, Lcom/tencent/cos/xml/transfer/UploadService;->setRequestHeaders(Lcom/tencent/cos/xml/model/CosXmlRequest;)V
    :try_end_0
    .catch Lcom/tencent/cos/xml/exception/CosXmlClientException; {:try_start_0 .. :try_end_0} :catch_0

    .line 342
    new-instance v4, Lcom/tencent/cos/xml/transfer/UploadService$3;

    invoke-direct {v4, p0, v3}, Lcom/tencent/cos/xml/transfer/UploadService$3;-><init>(Lcom/tencent/cos/xml/transfer/UploadService;Lcom/tencent/cos/xml/model/object/UploadPartRequest;)V

    invoke-virtual {v3, v4}, Lcom/tencent/cos/xml/model/object/UploadPartRequest;->setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V

    .line 354
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlService:Lcom/tencent/cos/xml/CosXmlSimpleService;

    move-object/from16 v0, p6

    invoke-virtual {v4, v3, v0}, Lcom/tencent/cos/xml/CosXmlSimpleService;->uploadPartAsync(Lcom/tencent/cos/xml/model/object/UploadPartRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 355
    :goto_0
    return-void

    .line 338
    :catch_0
    move-exception v2

    .line 339
    .local v2, "e":Lcom/tencent/cos/xml/exception/CosXmlClientException;
    iget-object v4, p0, Lcom/tencent/cos/xml/transfer/UploadService;->putObjectRequest:Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    const/4 v5, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v4, v2, v5}, Lcom/tencent/cos/xml/listener/CosXmlResultListener;->onFail(Lcom/tencent/cos/xml/model/CosXmlRequest;Lcom/tencent/cos/xml/exception/CosXmlClientException;Lcom/tencent/cos/xml/exception/CosXmlServiceException;)V

    goto :goto_0
.end method


# virtual methods
.method public abort(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V
    .locals 1
    .param p1, "cosXmlResultListener"    # Lcom/tencent/cos/xml/listener/CosXmlResultListener;

    .prologue
    .line 150
    const/4 v0, 0x3

    iput v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    .line 151
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/transfer/UploadService;->abortMultiUpload(Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 152
    return-void
.end method

.method public pause()Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;
    .locals 4

    .prologue
    .line 139
    const/4 v1, 0x2

    iput v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->ERROR_EXIT_FLAG:I

    .line 140
    new-instance v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;

    invoke-direct {v0}, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;-><init>()V

    .line 141
    .local v0, "resumeData":Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->bucket:Ljava/lang/String;

    .line 142
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->cosPath:Ljava/lang/String;

    .line 143
    iget-wide v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->sliceSize:J

    iput-wide v2, v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->sliceSize:J

    .line 144
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->srcPath:Ljava/lang/String;

    .line 145
    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->uploadId:Ljava/lang/String;

    iput-object v1, v0, Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;->uploadId:Ljava/lang/String;

    .line 146
    return-object v0
.end method

.method public resume(Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;)Lcom/tencent/cos/xml/model/CosXmlResult;
    .locals 1
    .param p1, "resumeData"    # Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;,
            Lcom/tencent/cos/xml/exception/CosXmlClientException;
        }
    .end annotation

    .prologue
    .line 134
    invoke-direct {p0, p1}, Lcom/tencent/cos/xml/transfer/UploadService;->init(Lcom/tencent/cos/xml/transfer/UploadService$ResumeData;)V

    .line 135
    invoke-virtual {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->upload()Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v0

    return-object v0
.end method

.method public setProgressListener(Lcom/tencent/cos/xml/listener/CosXmlProgressListener;)V
    .locals 0
    .param p1, "cosXmlProgressListener"    # Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosXmlProgressListener:Lcom/tencent/cos/xml/listener/CosXmlProgressListener;

    .line 165
    return-void
.end method

.method public setRequestHeaders(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 109
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 110
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->headers:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 113
    :cond_0
    return-void
.end method

.method public setSign(JJ)V
    .locals 1
    .param p1, "startTime"    # J
    .param p3, "endTime"    # J

    .prologue
    .line 96
    iput-wide p1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->startTime:J

    .line 97
    iput-wide p3, p0, Lcom/tencent/cos/xml/transfer/UploadService;->endTime:J

    .line 98
    return-void
.end method

.method public upload()Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/tencent/cos/xml/exception/CosXmlClientException;,
            Lcom/tencent/cos/xml/exception/CosXmlServiceException;
        }
    .end annotation

    .prologue
    .line 125
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->checkParameter()V

    .line 126
    iget-wide v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->fileLength:J

    const-wide/32 v2, 0x200000

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/tencent/cos/xml/transfer/UploadService;->bucket:Ljava/lang/String;

    iget-object v1, p0, Lcom/tencent/cos/xml/transfer/UploadService;->cosPath:Ljava/lang/String;

    iget-object v2, p0, Lcom/tencent/cos/xml/transfer/UploadService;->srcPath:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/tencent/cos/xml/transfer/UploadService;->putObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v0

    .line 129
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/UploadService;->multiUploadParts()Lcom/tencent/cos/xml/transfer/UploadService$UploadServiceResult;

    move-result-object v0

    goto :goto_0
.end method
